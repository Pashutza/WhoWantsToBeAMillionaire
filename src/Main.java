import java.util.Scanner;

public class Main implements Sequence {

    public static void main(String[] args) {
        writeMessage("===== Cine vrea sa fie milinonar? ======");
        startGame();
    }

    public static void startGame() {
        int level = 1;
        int maxLevel = 5;
        boolean toNext = true;
        int score = 0;
        while (maxLevel >= level && toNext) {
            writeMessage("* Nivelul " + level);

            Question question = getQuestionByLevel(level);

            writeMessage(">> " + question.getQuestion() + ":");

            writeMessage(" " + question.getAnswer1().getSequence() + ": " + question.getAnswer1().getAnswer());
            writeMessage(" " + question.getAnswer2().getSequence() + ": " + question.getAnswer2().getAnswer());
            writeMessage(" " + question.getAnswer3().getSequence() + ": " + question.getAnswer3().getAnswer());
            writeMessage(" " + question.getAnswer4().getSequence() + ": " + question.getAnswer4().getAnswer());

            writeMessage("Raspunsul tau este: ");
            Scanner scanner = new Scanner(System.in);
            String answerSequence = scanner.nextLine();
            //TODO valideaza input-ul
            toNext = validateQuestion(question, answerSequence);
            if (toNext) {
                score += question.getScore();
                writeMessage("Raspuns corect! Scorul curent: " + score);
                level++;
            } else {
                writeMessage("Raspuns gresit! Scorul acumulat: " + score);
            }
        }
    }

    private static boolean validateQuestion(Question question, String answerSequence) {
        if (question.getAnswer1().getSequence().equals(answerSequence)) {
            if (question.getAnswer1().isTrue()) {
                return true;
            }
        }
        if (question.getAnswer2().getSequence().equals(answerSequence)) {
            if (question.getAnswer2().isTrue()) {
                return true;
            }
        }
        if (question.getAnswer3().getSequence().equals(answerSequence)) {
            if (question.getAnswer3().isTrue()) {
                return true;
            }
        }
        if (question.getAnswer4().getSequence().equals(answerSequence)) {
            if (question.getAnswer4().isTrue()) {
                return true;
            }
        }
        return false;
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static Question getQuestionByLevel(int level) {
        String question1 = "Câte strofe are poezia “Luceafărul” de Mihai Eminescu?";
        String question2 = "Cine a scris romanul 'Ion'?";
        String question3 = "Care este țara care are forma unei cizme?";
        String question4 = "Care este cea mai mică țară din lume?";
        String question5 = "Cîte elemente are tabelul periodic";

        Answer question1_answer1 = new Answer("10", false, A);
        Answer question1_answer2 = new Answer("15", false, B);
        Answer question1_answer3 = new Answer("2", false, C);
        Answer question1_answer4 = new Answer("98", true, D);

        Answer question2_answer1 = new Answer("Liviu Rebreanu", true, A);
        Answer question2_answer2 = new Answer("George Călinescu", false, B);
        Answer question2_answer3 = new Answer("Lucian Blaga", false, C);
        Answer question2_answer4 = new Answer("Mihail Sadoveanu", false, D);

        Answer question3_answer1 = new Answer("Franța", false, A);
        Answer question3_answer2 = new Answer("Italia", true, B);
        Answer question3_answer3 = new Answer("Spania", false, C);
        Answer question3_answer4 = new Answer("România", false, D);

        Answer question4_answer1 = new Answer("Moldova", false, A);
        Answer question4_answer2 = new Answer("India", false, B);
        Answer question4_answer3 = new Answer("Vatican", true, C);
        Answer question4_answer4 = new Answer("Ungaria", false, D);

        Answer question5_answer1 = new Answer("20", false, A);
        Answer question5_answer2 = new Answer("15", false, B);
        Answer question5_answer3 = new Answer("21", false, C);
        Answer question5_answer4 = new Answer("18", true, D);

        Question question1_level1 = new Question(question1, question1_answer1, question1_answer2, question1_answer3, question1_answer4, 1, 1000);
        Question question2_level2 = new Question(question2, question2_answer1, question2_answer2, question2_answer3, question2_answer4, 2, 2000);
        Question question3_level3 = new Question(question3, question3_answer1, question3_answer2, question3_answer3, question3_answer4, 3, 5000);
        Question question4_level4 = new Question(question4, question4_answer1, question4_answer2, question4_answer3, question4_answer4, 4, 7000);
        Question question5_level5 = new Question(question5, question5_answer1, question5_answer2, question5_answer3, question5_answer4, 5, 10000);

        switch (level) {
            case 1:
                return question1_level1;
            case 2:
                return question2_level2;
            case 3:
                return question3_level3;
            case 4:
                return question4_level4;
            default:
                return question5_level5;
        }
    }


}
