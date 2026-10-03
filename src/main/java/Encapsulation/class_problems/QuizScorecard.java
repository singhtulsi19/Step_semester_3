public class QuizScorecard {
    private final boolean[] results;
    private int recordedAnswers;

    public QuizScorecard(int questionCount) {
        results = new boolean[questionCount];
        recordedAnswers = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedAnswers < results.length) {
            results[recordedAnswers] = correct;
            recordedAnswers++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedAnswers; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        QuizScorecard sc = new QuizScorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
