package week04.dashboard01;

class Progress {

    private long submitCount;
    private long term;
    private boolean[] isSubmitEachWeeks;


    private Progress() {

    }

    private Progress(long submitCount, int size) {
        this.submitCount = submitCount;
        term = size;
        isSubmitEachWeeks = new boolean[size];
    }

    public static Progress create(long submitCount, int size) {
        return new Progress(submitCount, size);
    }

    public String getPercent() {
        return String.format("%.2f", ((double) submitCount / (double) term) * 100.0) + "%";
    }

    public String draw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < term; i++) {
            if (isSubmitEachWeeks[i]) {
                sb.append("■");
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public Progress submit(int week) {
        isSubmitEachWeeks[week] = true;
        ++submitCount;

        return this;
    }


}
