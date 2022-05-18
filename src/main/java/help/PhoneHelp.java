package help;

import questionsAndAnswers.Question;

import java.util.ArrayList;
import java.util.List;

public class PhoneHelp extends HelpOption{

    public PhoneHelp() {
        super("P - Suna un prieten", P);
    }

    @Override
    public void showAnswers(List<HelpAnswer> helpAnswers) {
        helpAnswers.forEach(helpAnswer -> {
            System.out.println(" " + helpAnswer.getAnswer().getSequence() + ": " + helpAnswer.getAnswer().getAnswer());
        });
    }

    @Override
    public List<HelpAnswer> getHelpAnswers(Question question) {
        List<HelpAnswer> helpAnswers = new ArrayList<>();

        HelpAnswer correctAnswer = getCorrectAnswer(question);

        helpAnswers.add(correctAnswer);
        return helpAnswers;
    }
}
