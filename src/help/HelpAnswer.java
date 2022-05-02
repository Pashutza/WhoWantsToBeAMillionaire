package help;

import questionsAndAnswers.Answer;

public class HelpAnswer implements Comparable<HelpAnswer> {
    private Answer answer;
    private double probability;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    @Override
    public int compareTo(HelpAnswer helpAnswer) {
        return this.answer.getSequence().compareTo(helpAnswer.getAnswer().getSequence());
    }
}
