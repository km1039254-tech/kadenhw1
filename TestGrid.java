/**
 * Code Author: David G. Cooper, PhD
 * Purpose: Test the GridText class
 */

import java.util.Scanner;
import java.util.ArrayList;

public class TestGrid {
    public static void main(String[] args) {
        String test1 = "cat,axe,tea";
        String test2 = "A variable can be any type,\n" +
                       "or a method can return no type.\n" +
                       "But a constructor is the class's type\n";
        // source: https://www.ronslate.com/on-the-hurting-kind-poems-by-ada-limon/
        // part of a poem by Ada Limon
        String test3 = "            You can't sum it up, my mother says as we are driving,\n\n" +
                       "and the electronic voice says, Turn left onto Wildwood Canyon Road,\n\n" +
                       "so I turn left, happy for the instructions.\n";
        GridText one = new GridText(test1,",");
        Scanner s2a = new Scanner(test2);
        Scanner s2b = new Scanner(test2);
        Scanner s3 = new Scanner(test3);
        GridText twoA = new GridText(s2a, 2);
        GridText twoB = new GridText(s2b, 3);
        GridText three = new GridText(s3,50);
        System.out.println("==================================");
        
        System.out.println("Testing first constructor");
        ArrayList<String> first = one.gridText;
        boolean correct = true;
        if(first.size() > 0) {
            System.out.print(first.get(0) + " should be cat");
            if(!first.get(0).equals("cat")) {
                correct = false; 
                System.out.println(", but it's not. ERROR.");
            } else {
                System.out.println(", and it is!");
            }
        }
        if(first.size() > 1) {
            System.out.print(first.get(1) + " should be axe");
            if(!first.get(1).equals("axe")) {
                correct = false; 
                System.out.println(",but it's not. ERROR.");
            } else {
                System.out.println(", and it is!");
            }
        }
        if(first.size() > 2) {
            System.out.print(first.get(2) + " should be tea");
            if(!first.get(2).equals("tea")) {
                correct = false; 
                System.out.println(",but it's not. ERROR.");
            } else {
                System.out.println(", and it is!");
            }
        }
        if(first.size() != 3) {
            correct = false;
            System.out.println("ERROR: first gridText should have 3 elements instead of" + first.size());
        }
        if(correct) {
            System.out.println("Test 1: First constructor passes!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        
        // for test 2
        correct = true;
        System.out.println("Test 2, testing at on first GridText");
        System.out.print(one.at(0,0) + " at(0,0) should be c");
        if(one.at(0,0) != 'c') {
            correct = false; 
            System.out.println(",but it's not. ERROR.");
        } else {
                System.out.println(", and it is!");
        } 
        System.out.print(one.at(1,1) + " at(1,1) should be x");
        if(one.at(1,1) != 'x') {
            correct = false; 
            System.out.println(",but it's not. ERROR.");
        } else {
                System.out.println(", and it is!");
        }
        System.out.print(one.at(2,2) + " at(2,2) should be a");
        if(one.at(2,2) != 'a') {
            correct = false; 
            System.out.println(",but it's not. ERROR.");
        } else {
                System.out.println(", and it is!");
        }
        try{
          if(one.at(-1,0) != null) {
            correct = false; 
            System.out.println(one.at(-1,0) + " at(-1,0) should be null,but it's not. ERROR.");
          }
          else if(one.at(0,3) != null) {
            correct = false; 
            System.out.println(one.at(0,3) + " at(0,3) should be null,but it's not. ERROR.");
          }
          else if(one.at(0,-1) != null) {
            correct = false; 
            System.out.println(one.at(0,-1) + " at(0,-1) should be null,but it's not. ERROR.");
          }
          else if(one.at(3,0) != null) {
            correct = false; 
            System.out.println(one.at(3,0) + " at(3,0) should be null,but it's not. ERROR.");
          }
          else {
            System.out.println("tested that an index out of bounds returns null, and it does!");
          }
        } catch (Exception e) {
          correct = false;
          System.out.println("ERROR: index out of bounds causes an exception instead of returning null");
        }
        if(correct) {
            System.out.println("Test 2: First .at() tests pass!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        // for test 3
        correct = true;
        GridText testGrid = twoA;
        StringBuilder word1 = new StringBuilder();
        StringBuilder word2 = new StringBuilder();
        StringBuilder word3 = new StringBuilder();
        for(int col = 2; col < 10; ++col) {
            word1.append(testGrid.at(0,col));
        }
        for(int col = 5; col < 11; ++col) {
            word2.append(testGrid.at(1,col));
        }
        for(int col = 6; col < 17; ++col) {
            if(testGrid.length(2) > col) {
               word3.append(testGrid.at(2,col));
            }
        }
        System.out.print(word1 + " should be variable");
        if(word1.toString().equals("variable")) {
            System.out.println(", and it is!");
        } else {
            correct = false;
            System.out.println(",but it's not. ERROR.");
        }
        System.out.print(word2 + " should be method");
        if(word2.toString().equals("method")) {
            System.out.println(", and it is!");
        } else {
            correct = false;
            System.out.println(",but it's not. ERROR.");
        }
        System.out.print(word3.length() + " should be 0");
        if(word3.length() == 0) {
            System.out.println(", and it is!");
        } else {
            correct = false;
            System.out.println(",but it's not. ERROR.");
        }
        if(correct) {
            System.out.println("Test 3: Second constructor tests pass!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        // for test 4
        correct = true;
        testGrid = twoB;
        word1.delete(0,20);
        word2.delete(0,20);
        word3.delete(0,20);
        for(int col = 2; col < 10; ++col) {
            word1.append(testGrid.at(0,col));
        }
        for(int col = 5; col < 11; ++col) {
            word2.append(testGrid.at(1,col));
        }
        for(int col = 6; col < 17; ++col) {
            if(testGrid.length(2) > col) {
               word3.append(testGrid.at(2,col));
            }
        }
        System.out.print(word1 + " should be variable");
        if(word1.toString().equals("variable")) {
            System.out.println(", and it is!");
        } else {
            correct = false;
            System.out.println(",but it's not. ERROR.");
        }
        System.out.print(word2 + " should be method");
        if(word2.toString().equals("method")) {
            System.out.println(", and it is!");
        } else {
            correct = false;
            System.out.println(",but it's not. ERROR.");
        }
        System.out.print(word3 + " should be constructor");
        if(word3.toString().equals("constructor")) {
            System.out.println(", and it is!");
        } else {
            correct = false;
            System.out.println(",but it's not. ERROR.");
        }
        if(correct) {
            System.out.println("Test 4: Third constructor tests pass!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        // for test 5
        correct = true;
        System.out.println("Test 5, testing spacing");
        String spaces = "            ";
        // need to finish test 5
        for(int i = 0 ; i < spaces.length(); ++i) {
            Character t = three.at(0,i);
            System.out.print("Character at (0," + i + ") should be a space");
            if(t == spaces.charAt(i)) {
               System.out.println(", and it is!");
            } else {
               correct = false;
               System.out.println(",but it's not. ERROR.");
            }
        }
        for(int i = 1 ; i < 6; i += 2) {
            int length = three.length(i);
            System.out.print("length of row " + i + " should be 0");
            if(length == 0) {
               System.out.println(", and it is!");
            } else {
               correct = false;
               System.out.println(",but it's " + length + ". ERROR.");
            }
        }
        if(correct) {
            System.out.println("Test 5: Fourth grid spaces test pass!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Num rows of one should be 3 and is " +
                           one.numRows());
        if(one.numRows() == 3) {
             System.out.println("Test 6 passes!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Num rows of twoA should be 2 and is " +
                           twoA.numRows());
        if(twoA.numRows() == 2) {
             System.out.println("Test 7 passes!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Num rows of twoA should be 3 and is " +
                           twoB.numRows());
        if(twoB.numRows() == 3) {
             System.out.println("Test 8 passes!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Num rows of three should be 5 and is " +
                           three.numRows());
        if(three.numRows() == 5) {
             System.out.println("Test 9 passes!");
        }
        System.out.println("==================================");
        System.out.println("==================================");
        
        
    }

    
}
