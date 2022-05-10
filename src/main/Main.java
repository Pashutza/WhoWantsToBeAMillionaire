package main;

import help.*;
import questionsAndAnswers.Answer;
import questionsAndAnswers.Question;
import questionsAndAnswers.Sequence;
import repository.QuestionRepository;

import java.util.*;

public class Main implements Sequence {

    public static void main(String[] args) {
        writeMessage("===== Cine vrea sa fie milinonar? ======");
        startGame();
    }

    public static void startGame() {
        int level = 1;
        int maxLevel = 15;
        boolean toNext = true;
        int score = 0;

        HelpOption fiftyFifty = new FiftyFiftyHelp();
        HelpOption audience = new AudienceHelp();
        HelpOption phone = new PhoneHelp();
        List<HelpOption> helpOptions = Arrays.asList(fiftyFifty, audience, phone);


        while (maxLevel >= level && toNext) {
            writeMessage("* Nivelul " + level);

            Question question = getQuestionByLevel(level).get();

            writeMessage(">> " + question.getQuestion() + ":");

            for (Answer answer : question.getAnswers()) {
                writeMessage(" " + answer.getSequence() + ": " + answer.getAnswer());
            }

            writeMessage("= = = = Ajutor = = = =");
            helpOptions.stream().filter(helpOption -> !helpOption.isUsed()).forEach(helpOption -> {
                System.out.print(helpOption.getName() + "  |  ");
            });
            System.out.println();


            String answerSequence = getYourAnswerOption();
            //TODO valideaza input-ul

            if (isHelp(answerSequence, helpOptions)) {
                HelpOption helpOption = getHelpOption(answerSequence, helpOptions);
                helpOption.setUsed(true);
                List<HelpAnswer> helpAnswers = helpOption.getHelpAnswers(question);
                helpOption.showAnswers(helpAnswers);

                answerSequence = getYourAnswerOption();
            }

            toNext = validateQuestion(question, answerSequence);
            if (toNext) {
                score += question.getScore();
                writeMessage("Raspuns corect! Scorul curent: " + score);
                level++;
            } else {
                writeMessage("Raspuns gresit! Scorul acumulat: " + score);
            }
        }
        System.out.println("The game is over!");
    }

    private static String getYourAnswerOption() {
        writeMessage("Raspunsul tau este: ");
        Scanner scanner = new Scanner(System.in);
        String answerSequence = scanner.nextLine();
        return answerSequence;
    }

    private static boolean isHelp(String answerSequence, List<HelpOption> helpOptions) {
        return helpOptions.stream().anyMatch(helpOption -> helpOption.getSequence().equals(answerSequence));

    }

    private static boolean validateQuestion(Question question, String answerSequence) {
        return question.getAnswers().stream().anyMatch(answer -> answer.getSequence().equals(answerSequence) && answer.isTrue());
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static Optional<Question> getQuestionByLevel(int level) {
        List<Question> questions = QuestionRepository.getAllQuestion();
        return questions.stream().filter(question -> level == question.getLevel()).findFirst();
    }

    public static HelpOption getHelpOption(String sequence, List<HelpOption> helpOptions) {
        return helpOptions.stream().filter(helpOption -> helpOption.getSequence().equals(sequence)).findFirst().get();
    }
}
