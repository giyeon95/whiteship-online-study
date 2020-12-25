package dashboard;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"id"})
public class Participant {

    private String id;
    private Progress progress;


    private Participant(String id, Progress progress) {
        this.id = id;
        this.progress = progress;
    }

    public static Participant create(String id, int size) {
        return new Participant(id, Progress.create(1, size));
    }

    public Participant submitAssignment(int week) {
        this.progress.submit(week);
        return this;
    }

    public String getProgressString() {
        StringBuilder sb = new StringBuilder(id);
        sb.append("(");
        sb.append(progress.getPercent());
        sb.append(")");
        sb.append(" ");
        sb.append(progress.draw());

        return sb.toString();
    }
}
