/**
 * Code Author: David G. Cooper, PhD
 * Purpose: Test the AlgebraicFraction class
 */

import java.util.ArrayList;

public class TestFraction {
    public static void main(String[] args) {
        String[] num1 = {"a"};
        String[] den1 = {"c"};
        AlgebraicFraction f1 = new AlgebraicFraction(num1, den1);
        String[] num2 = {"b","miles"};
        String[] den2 = {"hour"};
        AlgebraicFraction f2 = new AlgebraicFraction(num2, den2);
        String[] num3 = {"x","y","hour"};
        String[] den3 = {"b"};
        AlgebraicFraction f3 = new AlgebraicFraction(num3, den3);
        String[] num4 = {"x","y"};
        String[] den4 = {"x","y"};
        AlgebraicFraction f4 = new AlgebraicFraction(num4, den4);
        
        System.out.println("f1.numerator    = " + f1.numerator);
        System.out.println("f1.denominator  = " + f1.denominator);

        System.out.println("f1              = " + f1);
        System.out.println("f2              = " + f2);
        System.out.println("f3              = " + f3);
        System.out.println("f4              = " + f4);
        System.out.println("f1 * f2         = " + f1.multiply(f2));
        System.out.println("f3 * f2         = " + f3.multiply(f2));
        System.out.println("f1 * f4         = " + f1.multiply(f4));
    }
}
