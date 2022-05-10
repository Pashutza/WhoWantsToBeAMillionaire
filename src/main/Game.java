package main;

import excetions.InvalidSequenceException;
import help.*;
import questionsAndAnswers.Answer;
import questionsAndAnswers.Question;
import repository.QuestionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    public static void start() {
        int level = 1;
        int maxLevel = 15;
        boolean toNext = true;
        int score = 0;

        HelpOption fiftyFifty = new FiftyFiftyHelp();
        HelpOption audience = new AudienceHelp();
        HelpOption phone = new PhoneHelp();
        List<HelpOption> helpOptions = Arrays.asList(fiftyFifty, audience, phone);


        while (maxLevel >= level && toNext) {
            System.out.println();
            writeMessage("* Nivelul " + level);

            Question question = getQuestionByLevel(level).get();

            writeMessage(">> " + question.getQuestion() + ":");

            for (Answer answer : question.getAnswers()) {
                writeMessage(" " + answer.getSequence() + ": " + answer.getAnswer());
            }
            boolean isInvalidSequence;
            do{
                writeMessage("= = = = Ajutor = = = =");
                helpOptions.stream().filter(helpOption -> !helpOption.isUsed()).forEach(helpOption -> System.out.print(helpOption.getName() + "  |  "));
                if(! helpOptions.stream().anyMatch(helpOption -> !helpOption.isUsed())){
                    System.out.print("Nu mai aveti obtiuni pentru ajutor");
                }
                System.out.println();

                isInvalidSequence = false;
                String answerSequence = getYourAnswerOption();

                if (isHelp(answerSequence, helpOptions)) {
                    HelpOption helpOption = getHelpOption(answerSequence, helpOptions);
                    helpOption.setUsed(true);
                    List<HelpAnswer> helpAnswers = helpOption.getHelpAnswers(question);
                    helpOption.showAnswers(helpAnswers);
                    question.setAnswers(helpAnswers.stream().map(HelpAnswer::getAnswer).collect(Collectors.toList()));
                    isInvalidSequence = true;
                    continue;
                }

                try {
                    toNext = validateAnswers(question.getAnswers(), answerSequence);
                } catch (InvalidSequenceException e) {
                    isInvalidSequence = true;
                    writeMessage(e.getMessage() + ", Mai incercati o data!");
                }

            }while(isInvalidSequence);

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
        return helpOptions.stream().filter(helpOption -> !helpOption.isUsed()).anyMatch(helpOption -> helpOption.getSequence().equals(answerSequence));

    }

    private static boolean validateAnswers(List<Answer> answers, String answerSequence) throws InvalidSequenceException {
        Answer foundAnswer = answers.stream().filter(answer -> answer.getSequence().equals(answerSequence)).findFirst().orElseThrow(InvalidSequenceException::new);
        return foundAnswer.isTrue();
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
