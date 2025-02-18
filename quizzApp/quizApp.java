import java.util.ArrayList;
import java.util.Scanner;

public class quizApp {
    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("what is the capital of France?",
                new String[] { "Paris", "Berlin", "Madrid", "Rome" }, 1));
        questions.add(new Question("Which language is used for Android development?",
                new String[] { "Python", "Java", "C++", "Kotlin" }, 4));
        questions.add(new Question("What is 5 + 3?",
                new String[] { "6", "7", "8", "9" }, 3));

        int score = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("---Welcome to the Quiz---");
        for (Question question : questions) {
            question.displayQuesion();

            System.out.println("enter your answer (1-4)");
            int userAnswer = sc.nextInt();

            if (question.isCorrect(userAnswer)) {
                System.out.println("correct");
                score++;
            } else {
                System.out.println("wrong answer: ");
            }
            System.out.println();
        }
        System.out.println("---quizz over---");
        System.out.println("your score is :" + score + "/ " + questions.size());

        sc.close();
    }
}
