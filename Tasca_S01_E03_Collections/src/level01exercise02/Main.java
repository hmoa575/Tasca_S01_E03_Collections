package level01exercise02;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        List<Integer> hundreds = new ArrayList<>();

        hundreds.add(100);
        hundreds.add(200);
        hundreds.add(300);
        hundreds.add(400);
        hundreds.add(500);
        System.out.println("The list is: " + hundreds);

        List<Integer> hundredsReverse = ListReverser.iteratorAndReverse(hundreds);
        System.out.println("THe list reverse is: " + hundredsReverse);
    }

}
