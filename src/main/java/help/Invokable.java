package help;

import questionsAndAnswers.Question;

import java.util.List;

public interface Invokable {
    List<HelpAnswer> getHelpAnswers(Question question);
}
