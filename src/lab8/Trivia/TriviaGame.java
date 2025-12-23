package lab8.Trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


interface AnswerCheckingStrategy {
    boolean isCorrect(String correctAnswer, String userAnswer);
    String getPrompt();
}
class FreeFormStrategy implements AnswerCheckingStrategy {

    @Override
    public boolean isCorrect(String correctAnswer, String userAnswer) {
        if (userAnswer == null) return false;
        return userAnswer.trim().equalsIgnoreCase(correctAnswer);
    }

    @Override
    public String getPrompt() {
        return "";
    }
}

/** A concrete strategy for True/False answers. */
class TrueFalseStrategy implements AnswerCheckingStrategy {
    @Override
    public boolean isCorrect(String correctAnswer, String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }
        return userAnswer.trim().toUpperCase().charAt(0) == correctAnswer.toUpperCase().charAt(0);
    }

    @Override
    public String getPrompt() {
        return "Enter 'T' for true or 'F' for false.";
    }
}

class TriviaQuestion {

    private final String question;
    private final String answer;
    private final int value;
    private final AnswerCheckingStrategy checkingStrategy;

    public TriviaQuestion(String question, String answer, int value, AnswerCheckingStrategy strategy) {
        this.question = question;
        this.answer = answer;
        this.value = value;
        this.checkingStrategy = strategy;
    }

    public String getQuestion() {
        return question;
    }

    public int getValue() {
        return value;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect(String userAnswer) {
        return checkingStrategy.isCorrect(this.answer, userAnswer);
    }

    public String getPrompt() {
        return checkingStrategy.getPrompt();
    }
}


interface QuestionLoader {
    List<TriviaQuestion> load();
}

class HardcodedQuestionLoader implements QuestionLoader {
    @Override
    public List<TriviaQuestion> load() {
        List<TriviaQuestion> questions = new ArrayList<>();
        questions.add(new TriviaQuestion("The possession of more than two sets of chromosomes is termed?", "polyploidy", 3, new FreeFormStrategy()));
        questions.add(new TriviaQuestion("Erling Kagge skiied into the north pole alone on January 7, 1993.", "F", 1, new TrueFalseStrategy()));
        questions.add(new TriviaQuestion("1997 British band that produced 'Tub Thumper'", "Chumbawumba", 2, new FreeFormStrategy()));
        questions.add(new TriviaQuestion("I am the geometric figure most like a lost parrot", "polygon", 2, new FreeFormStrategy()));
        questions.add(new TriviaQuestion("Generics were introducted to Java starting at version 5.0.", "T", 1, new TrueFalseStrategy()));
        return questions;
    }
}

public class TriviaGame {

    private final List<TriviaQuestion> questions;
    private int score;

    public TriviaGame(QuestionLoader loader) {
        this.questions = loader.load();
        this.score = 0;
    }

    public void play() {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < questions.size(); i++) {
                askQuestion(i, sc);
            }
        }
        System.out.println("Game over!  Thanks for playing!");
    }

    private void askQuestion(int idx, Scanner sc) {
        TriviaQuestion q = questions.get(idx);

        System.out.printf("Question %d.  %d points.\n", idx + 1, q.getValue());
        System.out.println(q.getQuestion());

        String prompt = q.getPrompt();
        if (!prompt.isEmpty()) {
            System.out.println(prompt);
        }

        String userAnswer = sc.nextLine();
        if (q.isCorrect(userAnswer)) {
            System.out.printf("That is correct!  You get %d points.\n", q.getValue());
            score += q.getValue();
        } else {
            System.out.printf("Wrong, the correct answer is %s\n", q.getAnswer());
        }
        System.out.printf("Your score is %d\n", score);
    }

    public static void main(String[] args) {
        QuestionLoader loader = new HardcodedQuestionLoader();
        TriviaGame game = new TriviaGame(loader);
        game.play();
    }
}
