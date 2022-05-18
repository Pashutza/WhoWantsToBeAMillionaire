package help;

import questionsAndAnswers.Question;

import java.util.Random;

public class RandomHelp {
    public static int getRandomIndex(Question question, Random random) {
        return random.nextInt(question.getWrongAnswers().size() - 1);
    }
}
