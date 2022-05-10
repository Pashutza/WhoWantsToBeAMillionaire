package questionsAndAnswers;


import excetions.InvalidLevelException;
import excetions.InvalidScoreException;

import java.util.List;
import java.util.stream.Collectors;

public class Question {
    private String question;
    private int level;
    private int score;
    List<Answer> answers;

    public Question(String question, List<Answer> answers, int level, int score) {
        this.question = question;
        this.answers = answers;
        if (level < 0 || level > 15) {
            throw new InvalidLevelException("Level value must be greater than 0 and less than 15");
        }
        this.level = level;
        if (score < 0) {
            throw new InvalidScoreException("Score value must be greater than 0");
        }
        this.score = score;
    }

    public Answer getCorrectAnswer() {
        return this.answers.stream().filter(Answer::isTrue).findFirst().get();
    }

    public List<Answer> getWrongAnswers() {
        return this.answers.stream().filter(answer -> !answer.isTrue()).collect(Collectors.toList());
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }


}
