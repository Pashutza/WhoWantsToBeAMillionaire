package help;

import questionsAndAnswers.Question;

import java.util.List;
import java.util.Random;

public abstract class HelpOption implements HelpSequence {
    boolean isUsed = false;
    public abstract List<HelpAnswer> getHelpAnswers(Question question);
    String name;
    String sequence;
    public abstract void showAnswers(List<HelpAnswer> helpAnswers);

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getSequence() {
        return sequence;
    }

    public HelpOption(String name, String sequence) {
        this.name = name;
        this.sequence = sequence;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public String getName() {
        return name;
    }

    protected HelpAnswer getCorrectAnswer(Question question) {
        HelpAnswer correctAnswer = new HelpAnswer();
        correctAnswer.setAnswer(question.getCorrectAnswer());
        return correctAnswer;
    }

    protected HelpAnswer getRandomWrongAnswer(Question question) {
        HelpAnswer wrongAnswer = new HelpAnswer();
        Random random = new Random();
        wrongAnswer.setAnswer(question.getWrongAnswers().get(RandomHelp.getRandomIndex(question, random)));
        return wrongAnswer;
    }
}
