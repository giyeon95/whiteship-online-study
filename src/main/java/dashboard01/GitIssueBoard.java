package dashboard01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHubBuilder;

public class GitIssueBoard {

    private GHRepository repo;
    private List<Participant> participants;


    private GitIssueBoard() {
    }


    public static GitIssueBoard create(String token, String repoContext) throws IOException {
        return new GitIssueBoard(token, repoContext);
    }

    private GitIssueBoard(String token, String repoContext) throws IOException {
        repo = GitHubBuilder
            .fromEnvironment().withOAuthToken(token)
            .build().getRepository(repoContext);

        List<GHIssue> assignments = initAssignments();
        this.participants = getParticipants(assignments);
    }


    public List<Participant> getParticipants() {
        return participants;
    }


    private List<GHIssue> initAssignments() throws IOException {
        return repo.getIssues(GHIssueState.ALL).stream()
            .filter(issue -> issue.getAssignees() != null)
            .filter(issue -> issue.getAssignees().stream()
                .anyMatch(assignee -> assignee.getLogin().equals("whiteship")))
            .sorted(Comparator.comparing(GHIssue::getNumber))
            .collect(Collectors.toList());
    }

    private List<Participant> getParticipants(List<GHIssue> assignments) throws IOException {

        List<Participant> participants = new ArrayList<>();

        int size = assignments.size();
        for (int week = 0; week < size; week++) {
            GHIssue assignment = assignments.get(week);

            Set<String> ids = getPerformComments(assignment);

            for (String id : ids) {
                int pos = findListIndex(participants, id);

                Participant participant = performAssignment(participants, id, week, size);

                if (pos == -1) {
                    participants.add(participant);
                } else {
                    participants.set(pos, participant);
                }
            }
        }
        return participants;
    }

    private Set<String> getPerformComments(GHIssue assignment) throws IOException {
        return assignment.getComments().stream()
            .filter(comment -> comment.getBody().contains("https://"))
            .map(comment -> {
                try {
                    return comment.getUser().getLogin();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return StringUtils.EMPTY;
            }).filter(StringUtils::isNotEmpty)
            .filter(t -> !t.equals("whiteship"))
            .collect(Collectors.toSet());
    }

    private int findListIndex(List<Participant> participants, String id) {
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).equals(id)) {
                return i;
            }
        }

        return -1;
    }

    private Participant performAssignment(List<Participant> participants, String id, int week, int size) {
        return participants.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .map(p -> p.submitAssignment(week))
            .orElseGet(() -> Participant.create(id, size));
    }
}
