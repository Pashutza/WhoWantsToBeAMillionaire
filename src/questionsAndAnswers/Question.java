package questionsAndAnswers;

import java.util.ArrayList;
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
        if(level < 0 ){
            throw new RuntimeException("fasdfas");
        }
        this.level = level;
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
