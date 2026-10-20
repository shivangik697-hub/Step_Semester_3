package PracticeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Examination Question Grader
 * Demonstrates OOP Polymorphism for evaluating different types of exam questions.
 */
abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getQuestionType();
    public abstract double calculateScore();

    public void displayResult() {
        System.out.printf("%s: %.2f%n", getQuestionType(), calculateScore());
    }
}

class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
}

class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }

    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }

    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudentAns.contains(trimmedKw)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class ExamQuestionGrader {
    public static void gradeQuestions(List<Question> questions) {
        double totalScore = 0;
        for (Question q : questions) {
            q.displayResult();
            totalScore += q.calculateScore();
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new MultipleChoiceQuestion("What is the capital of France?", "Paris", "Paris", 10));
        questions.add(new TrueFalseQuestion("The Earth is flat?", "False", "True", 5));
        questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
        questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));

        gradeQuestions(questions);
    }
}
