import java.util.Scanner;

public class ExaminationQuestionGrader {
    static abstract class Question {
        String type;
        String questionText;
        String correctAnswer;
        String studentAnswer;
        int points;

        Question(String type, String questionText, String correctAnswer, String studentAnswer, int points) {
            this.type = type;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double getScore();
    }

    static class MCQQuestion extends Question {
        MCQQuestion(String q, String c, String s, int p) { super("MCQ", q, c, s, p); }
        double getScore() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class TFQuestion extends Question {
        TFQuestion(String q, String c, String s, int p) { super("TF", q, c, s, p); }
        double getScore() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String q, String c, String s, int p) { super("ESSAY", q, c, s, p); }

        double getScore() {
            String[] keywords = correctAnswer.split(",");
            int found = 0;
            String answer = studentAnswer.toLowerCase();

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) {
                    found++;
                }
            }

            if (found >= 2) {
                return points * 0.75;
            }
            if (found == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    static String[] parseLine(String line) {
        String[] values = new String[5];
        int index = 0;
        int position = 0;

        while (index < 4) {
            while (position < line.length() && line.charAt(position) == ' ') {
                position++;
            }
            if (position >= line.length()) {
                break;
            }
            if (line.charAt(position) == '"') {
                int end = line.indexOf('"', position + 1);
                values[index++] = line.substring(position + 1, end);
                position = end + 1;
            } else {
                int end = line.indexOf(' ', position);
                if (end == -1) {
                    values[index++] = line.substring(position);
                    position = line.length();
                } else {
                    values[index++] = line.substring(position, end);
                    position = end + 1;
                }
            }
        }

        while (position < line.length() && line.charAt(position) == ' ') {
            position++;
        }
        values[index] = line.substring(position);
        return values;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            while (line.isEmpty()) {
                line = sc.nextLine().trim();
            }

            String[] values = parseLine(line);
            String type = values[0];
            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion(values[1], values[2], values[3], Integer.parseInt(values[4]));
            } else if (type.equals("TF")) {
                question = new TFQuestion(values[1], values[2], values[3], Integer.parseInt(values[4]));
            } else {
                question = new EssayQuestion(values[1], values[2], values[3], Integer.parseInt(values[4]));
            }

            double score = question.getScore();
            total += score;
            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}
