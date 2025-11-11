package kol1.Evaluator11;

@SuppressWarnings("unchecked")
public class EvaluatorBuilder{
    public static IEvaluator build (String operator){
        return switch (operator) {
            case ">" -> (a, b) -> ((Comparable) a).compareTo(b) > 0;
            case "<" -> (a, b) -> ((Comparable) a).compareTo(b) < 0;
            case "==" -> Object::equals;
            case "!=" -> (a, b) -> !a.equals(b);
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

}
