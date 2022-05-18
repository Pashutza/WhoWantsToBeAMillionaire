package help;

import questionsAndAnswers.Answer;
import questionsAndAnswers.Question;

import java.util.*;

public class AudienceHelp extends HelpOption {
    public AudienceHelp() {
        super("A - Intreaba publicul", A);
    }

    @Override
    public void showAnswers(List<HelpAnswer> helpAnswers) {
        helpAnswers.forEach(helpAnswer -> {
            System.out.println(" " + helpAnswer.getAnswer().getSequence() + ": " + helpAnswer.getAnswer().getAnswer() + "----> " + helpAnswer.getProbability() + " %");
        });
    }

    @Override
    public List<HelpAnswer> getHelpAnswers(Question question) {
        List<HelpAnswer> helpAnswers = new ArrayList<>();

        HelpAnswer correctAnswer = getCorrectAnswer(question);

        List<Integer> randomList = new ArrayList<>();
        int randomPercentages = 0;
        int randomBuffer = 100;
        int sum = 0;

        for (int i = 0; i < question.getWrongAnswers().size(); i++){
            randomBuffer = randomBuffer - randomPercentages;
            randomPercentages = getRandomPercentages(randomBuffer);
            sum += randomPercentages;

            randomList.add(randomPercentages);
            if(i == question.getWrongAnswers().size() -1){
                randomList.add(100 - sum);
            }
        }
        Collections.sort(randomList, Collections.reverseOrder());

        int randomItemIndex = 0;
        correctAnswer.setProbability(randomList.get(randomItemIndex));
        helpAnswers.add(correctAnswer);

        for (Answer answer : question.getWrongAnswers()) {
            HelpAnswer wrongAnswer = new HelpAnswer();
            wrongAnswer.setAnswer(answer);
            wrongAnswer.setProbability(randomList.get(++randomItemIndex));
            helpAnswers.add(wrongAnswer);
        }
        Collections.sort(helpAnswers);
        return helpAnswers;
    }

    private int getRandomPercentages(int max) {
        Random random = new Random();
        return random.nextInt(max + 1);
    }
}
