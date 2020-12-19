package week04;

import java.util.List;
import week04.dashboard01.GitIssueBoard;
import week04.dashboard01.Participant;

public class MainWeek04 {



    static final String GIT_OAUTH_TOKEN = "c23476df999cbd5e14f0fa17035147ba73f89b38";

    public static void main(String[] args) throws Exception {
        runAssignment01();
        runAssignment02();

    }

    /**
     * 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.
     */
    private static void runAssignment01() throws Exception {
        GitIssueBoard board = GitIssueBoard.create(GIT_OAUTH_TOKEN, "whiteship/live-study");
        List<Participant> participants = board.getParticipants();

        participants.forEach(participant -> System.out.println(participant.getProgressString()));
    }


    private static void runAssignment02() throws Exception {
    }

}
