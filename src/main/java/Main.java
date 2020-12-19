import java.util.List;
import week04.dashboard01.GitIssueBoard;
import week04.dashboard01.Participant;

public class Main {

    static final String GIT_OAUTH_TOKEN = "c23476df999cbd5e14f0fa17035147ba73f89b38";

    public static void main(String[] args) throws Exception {



    }

    private static void runAssignment01() throws Exception {
        GitIssueBoard board = GitIssueBoard.create(GIT_OAUTH_TOKEN, "whiteship/live-study");
        List<Participant> participants = board.getParticipants();

        participants.forEach(participant -> System.out.println(participant.getProgressString()));
    }

}
