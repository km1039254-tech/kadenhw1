/*
 * Code Author: Kaden Maier
 */

import java.util.ArrayList;

public class AlgebraicFraction {

    protected ArrayList numerator;
    protected ArrayList denominator;

    public AlgebraicFraction(Object[] num, Object[] denom) {
        numerator = new ArrayList();
        denominator = new ArrayList();

        for (Object n : num) {
            numerator.add(n);
        }

        for (Object d : denom) {
            denominator.add(d);
        }

        // Reduce the fraction
        for (Object n : num) {
            if (numerator.contains(n) && denominator.contains(n)) {
                numerator.remove(n);
                denominator.remove(n);
            }
        }
    }

    public AlgebraicFraction multiply(AlgebraicFraction other) {

        ArrayList newNumerator = new ArrayList();
        ArrayList newDenominator = new ArrayList();

        newNumerator.addAll(numerator);
        newNumerator.addAll(other.numerator);

        newDenominator.addAll(denominator);
        newDenominator.addAll(other.denominator);

        Object[] numArray = newNumerator.toArray();
        Object[] denomArray = newDenominator.toArray();

        return new AlgebraicFraction(numArray, denomArray);
    }

    public String toString() {

        String result = "( ";

        for (Object item : numerator) {
            result += item + " ";
        }

        result += ") / ( ";

        for (Object item : denominator) {
            result += item + " ";
        }

        result += ")";

        return result;
    }
}