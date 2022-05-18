package repository;

import questionsAndAnswers.Answer;
import questionsAndAnswers.Question;
import questionsAndAnswers.Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionRepository implements Sequence {
    public static List<Question> getAllQuestion() {
        String question1 = "Câte strofe are poezia “Luceafărul” de Mihai Eminescu?";
        Answer question1_answer1 = new Answer("10", false, A);
        Answer question1_answer2 = new Answer("15", false, B);
        Answer question1_answer3 = new Answer("2", false, C);
        Answer question1_answer4 = new Answer("98", true, D);

        String question2 = "Cine a scris romanul 'Ion'?";
        Answer question2_answer1 = new Answer("Liviu Rebreanu", true, A);
        Answer question2_answer2 = new Answer("George Călinescu", false, B);
        Answer question2_answer3 = new Answer("Lucian Blaga", false, C);
        Answer question2_answer4 = new Answer("Mihail Sadoveanu", false, D);

        String question3 = "Care este țara care are forma unei cizme?";
        Answer question3_answer1 = new Answer("Franța", false, A);
        Answer question3_answer2 = new Answer("Italia", true, B);
        Answer question3_answer3 = new Answer("Spania", false, C);
        Answer question3_answer4 = new Answer("România", false, D);

        String question4 = "Care este cea mai mică țară din lume?";
        Answer question4_answer1 = new Answer("Moldova", false, A);
        Answer question4_answer2 = new Answer("India", false, B);
        Answer question4_answer3 = new Answer("Vatican", true, C);
        Answer question4_answer4 = new Answer("Ungaria", false, D);

        String question5 = "Cîte elemente are tabelul periodic?";
        Answer question5_answer1 = new Answer("20", false, A);
        Answer question5_answer2 = new Answer("15", false, B);
        Answer question5_answer3 = new Answer("21", false, C);
        Answer question5_answer4 = new Answer("18", true, D);

        String question6 = "Câte zile are un an bisect?";
        Answer question6_answer1 = new Answer("365", false, A);
        Answer question6_answer2 = new Answer("366", true, B);
        Answer question6_answer3 = new Answer("360", false, C);
        Answer question6_answer4 = new Answer("350", false, D);

        String question7 = "Câte laturi are un hexagon?";
        Answer question7_answer1 = new Answer("6", true, A);
        Answer question7_answer2 = new Answer("7", false, B);
        Answer question7_answer3 = new Answer("8", false, C);
        Answer question7_answer4 = new Answer("9", false, D);

        String question8 = "Ce culoare are cutia neagra a unui avion?";
        Answer question8_answer1 = new Answer("neagra", false, A);
        Answer question8_answer2 = new Answer("alba", false, B);
        Answer question8_answer3 = new Answer("portocalie", true, C);
        Answer question8_answer4 = new Answer("gri", false, D);

        String question9 = "Care este cel mai rapid animal din lume??";
        Answer question9_answer1 = new Answer("antilopa", false, A);
        Answer question9_answer2 = new Answer("iepurele", false, B);
        Answer question9_answer3 = new Answer("leul", false, C);
        Answer question9_answer4 = new Answer("ghepardul", true, D);

        String question10 = "In ce oras au fost executati sotii Ceausescu??";
        Answer question10_answer1 = new Answer("Bucuresti", false, A);
        Answer question10_answer2 = new Answer("Tirgoviste", true, B);
        Answer question10_answer3 = new Answer("Iasi", false, C);
        Answer question10_answer4 = new Answer("Timisoara", false, D);

        String question11 = "În ce an s-a scufundat Titanicul?";
        Answer question11_answer1 = new Answer("1912", true, A);
        Answer question11_answer2 = new Answer("1900", false, B);
        Answer question11_answer3 = new Answer("1930", false, C);
        Answer question11_answer4 = new Answer("1920", false, D);

        String question12 = "Cite laturi egale are un triunghi isoscel?";
        Answer question12_answer1 = new Answer("3", false, A);
        Answer question12_answer2 = new Answer("2", true, B);
        Answer question12_answer3 = new Answer("1", false, C);
        Answer question12_answer4 = new Answer("nici una", false, D);

        String question13 = "Care este mincarea preferata a ursului Panda?";
        Answer question13_answer1 = new Answer("mierea", false, A);
        Answer question13_answer2 = new Answer("bambusul", true, B);
        Answer question13_answer3 = new Answer("carnea", false, C);
        Answer question13_answer4 = new Answer("ciocolata", false, D);

        String question14 = "Citi ani a durat razboiul de 100 de ani?";
        Answer question14_answer1 = new Answer("101", false, A);
        Answer question14_answer2 = new Answer("100", false, B);
        Answer question14_answer3 = new Answer("110", false, C);
        Answer question14_answer4 = new Answer("116", true, D);

        String question15 = "Ce poet a scris poezia 'Plumb'?";
        Answer question15_answer1 = new Answer("George Bacovia", true, A);
        Answer question15_answer2 = new Answer("Tudor Arghezi", false, B);
        Answer question15_answer3 = new Answer("Nichita Stanescu", false, C);
        Answer question15_answer4 = new Answer("Nicolae Labis", false, D);

        List<Answer> question1_answers = Arrays.asList(question1_answer1, question1_answer2, question1_answer3, question1_answer4);
        List<Answer> question2_answers = Arrays.asList(question2_answer1, question2_answer2, question2_answer3, question2_answer4);
        List<Answer> question3_answers = Arrays.asList(question3_answer1, question3_answer2, question3_answer3, question3_answer4);
        List<Answer> question4_answers = Arrays.asList(question4_answer1, question4_answer2, question4_answer3, question4_answer4);
        List<Answer> question5_answers = Arrays.asList(question5_answer1, question5_answer2, question5_answer3, question5_answer4);
        List<Answer> question6_answers = Arrays.asList(question6_answer1, question6_answer2, question6_answer3, question6_answer4);
        List<Answer> question7_answers = Arrays.asList(question7_answer1, question7_answer2, question7_answer3, question7_answer4);
        List<Answer> question8_answers = Arrays.asList(question8_answer1, question8_answer2, question8_answer3, question8_answer4);
        List<Answer> question9_answers = Arrays.asList(question9_answer1, question9_answer2, question9_answer3, question9_answer4);
        List<Answer> question10_answers = Arrays.asList(question10_answer1, question10_answer2, question10_answer3, question10_answer4);
        List<Answer> question11_answers = Arrays.asList(question11_answer1, question11_answer2, question11_answer3, question11_answer4);
        List<Answer> question12_answers = Arrays.asList(question12_answer1, question12_answer2, question12_answer3, question12_answer4);
        List<Answer> question13_answers = Arrays.asList(question13_answer1, question13_answer2, question13_answer3, question13_answer4);
        List<Answer> question14_answers = Arrays.asList(question14_answer1, question14_answer2, question14_answer3, question14_answer4);
        List<Answer> question15_answers = Arrays.asList(question15_answer1, question15_answer2, question15_answer3, question15_answer4);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(question1, question1_answers, 1, 100));
        questions.add(new Question(question2, question2_answers, 2, 200));
        questions.add(new Question(question3, question3_answers, 3, 300));
        questions.add(new Question(question4, question4_answers, 4, 500));
        questions.add(new Question(question5, question5_answers, 5, 1000));
        questions.add(new Question(question6, question6_answers, 6, 2000));
        questions.add(new Question(question7, question7_answers, 7, 4000));
        questions.add(new Question(question8, question8_answers, 8, 8000));
        questions.add(new Question(question9, question9_answers, 9, 16000));
        questions.add(new Question(question10, question10_answers, 10, 32000));
        questions.add(new Question(question11, question11_answers, 11, 64000));
        questions.add(new Question(question12, question12_answers, 12, 125000));
        questions.add(new Question(question13, question13_answers, 13, 250000));
        questions.add(new Question(question14, question14_answers, 14, 500000));
        questions.add(new Question(question15, question15_answers, 15, 100000000));
        return questions;
    }
}
