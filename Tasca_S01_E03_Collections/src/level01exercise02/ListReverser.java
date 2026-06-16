package level01exercise02;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListReverser {
    //Methods
    public static <TypeElement> List<TypeElement> iteratorAndReverse(List<TypeElement> list){
        List<TypeElement> reversed = new ArrayList<>();
        ListIterator<TypeElement> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()){
            reversed.add(iterator.previous());
        }
        return reversed;
    }
}
