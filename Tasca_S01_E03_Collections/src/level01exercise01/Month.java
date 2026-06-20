package level01exercise01;

import java.util.Objects;

public class Month {

    String name;

    public Month(String name) {
        this.name = name;
    }
    //Getters and Setters
    public String getName(){return name;}

    @Override
    public boolean equals(Object object){
        if(this == object){return true;}
        if(object == null || getClass() != object.getClass()){return false;}
        Month month = (Month) object;
        return Objects.equals(name,month.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                '}';
    }
}
