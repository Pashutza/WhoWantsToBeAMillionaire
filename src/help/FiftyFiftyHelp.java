package help;

import questionsAndAnswers.Question;

import java.util.ArrayList;
import java.util.List;

public class FiftyFiftyHelp extends HelpOption{
    public FiftyFiftyHelp() {
        super("F - 50/50", F);
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
        HelpAnswer wrongAnswer = getRandomWrongAnswer(question);

        helpAnswers.add(correctAnswer);
        helpAnswers.add(wrongAnswer);
        return helpAnswers;
    }




}
