package level01exercise01;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Month> monthsList = new ArrayList<>();
        monthsList.add(new Month("January"));
        monthsList.add(new Month("February"));
        monthsList.add(new Month("March"));
        monthsList.add(new Month("April"));
        monthsList.add(new Month("May"));
        monthsList.add(new Month("June"));
        monthsList.add(new Month("July"));
        monthsList.add(new Month("September"));
        monthsList.add(new Month("October"));
        monthsList.add(new Month("November"));
        monthsList.add(new Month("December"));

        System.out.println("\n+++++ List without the August month.");
        for(Month o : monthsList){
            System.out.println(o.getName());
        }

        System.out.println("\n+++++ Adding August to the list.");
        monthsList.add(7,new Month("August"));

        System.out.println("\n+++++ List complete with August month.");
        for(Month o : monthsList){
            System.out.println(o.getName());
        }

        Set<Month> monthsSet = new HashSet<>(monthsList);
        System.out.println("\n+++++ HashSet, and verify duplicates are not allowed.");
        boolean isAdded = monthsSet.add(new Month("April"));
        System.out.println("is April added two times? " + isAdded);
        System.out.println("HashSet total size: " + monthsSet.size());
        System.out.println("The year has 12 months, so it's working!");


        System.out.println("\n+++++ Loop for-each");
        for(Month o : monthsSet){
            System.out.println(o.getName());
        }

        System.out.println("\n+++++ Iterator");
        Iterator<Month> iterator = monthsSet.iterator();
        while(iterator.hasNext())
        {
            Month month = iterator.next();
            System.out.println(month.getName());
        }
    }

}
