package week04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import week04.dashboard01.GitIssueBoard;
import week04.dashboard01.Participant;

public class MainWeek04 {

    public static void main(String[] args) throws Exception {
        runAssignment01();
        runAssignment02();

    }

    /**
     * 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.
     */
    private static void runAssignment01() throws Exception {


        GitIssueBoard board = GitIssueBoard.create(getGitToken(), "whiteship/live-study");
        List<Participant> participants = board.getParticipants();

        participants.forEach(participant -> System.out.println(participant.getProgressString()));
    }


    private static void runAssignment02() throws Exception {
    }



    private static String getGitToken() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("application.properties"));


        return   properties.getProperty("github.token");
    }
}
