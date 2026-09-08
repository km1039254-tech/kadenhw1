import java.util.ArrayList;

public class AlgebraicFraction {

    protected ArrayList numerator;
    protected ArrayList denominator;

    public AlgebraicFraction(Object[] num, Object[] denom) {

        numerator = new ArrayList();
        denominator = new ArrayList();

        // Add numerator items
        for (Object n : num) {
            numerator.add(n);
        }

        // Add denominator items
        for (Object d : denom) {
            denominator.add(d);
        }

        // Reduce the fraction by removing matching factors
        ArrayList<Object> numeratorCopy = new ArrayList<Object>(numerator);

        for (Object n : numeratorCopy) {
            if (denominator.contains(n)) {
                numerator.remove(n);
                denominator.remove(n);
            }
        }
    }


    public AlgebraicFraction multiply(AlgebraicFraction other) {

        ArrayList newNumerator = new ArrayList();
        ArrayList newDenominator = new ArrayList();

        // Combine numerators
        newNumerator.addAll(numerator);
        newNumerator.addAll(other.numerator);

        // Combine denominators
        newDenominator.addAll(denominator);
        newDenominator.addAll(other.denominator);

        // Convert ArrayLists to Object arrays
        Object[] numArray = newNumerator.toArray();
        Object[] denomArray = newDenominator.toArray();

        // Create and return the new fraction
        return new AlgebraicFraction(numArray, denomArray);
    }


    public String toString() {

        // Empty fraction displays as 1
        if (numerator.size() == 0 && denominator.size() == 0) {
            return "1";
        }

        String result = "(";

        // Add numerator
        for (int i = 0; i < numerator.size(); i++) {
            result += numerator.get(i);

            if (i < numerator.size() - 1) {
                result += " ";
            }
        }

        result += ")/(";

        // Add denominator
        for (int i = 0; i < denominator.size(); i++) {
            result += denominator.get(i);

            if (i < denominator.size() - 1) {
                result += " ";
            }
        }

        result += ")";

        return result;
    }
}