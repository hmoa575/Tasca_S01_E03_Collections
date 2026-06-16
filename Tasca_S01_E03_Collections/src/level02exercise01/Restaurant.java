package level02exercise01;

import java.util.Objects;

public class Restaurant {
    //Attributes
    private String name;
    private int score;

    //Constructor
    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Restaurant restaurant = (Restaurant) object;
        return score == restaurant.score && Objects.equals(name, restaurant.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}



