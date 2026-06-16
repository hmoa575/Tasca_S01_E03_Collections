package level02exercise02;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {
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

    // Ascending by name
    @Override
    public int compareTo(Restaurant other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        //Descending by score if the name is equal.
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}



