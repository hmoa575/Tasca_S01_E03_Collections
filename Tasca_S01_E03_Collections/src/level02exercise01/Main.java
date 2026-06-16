package level02exercise01;

import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        HashSet<Restaurant> sucursales = new HashSet<>();

        Restaurant sucursal1 = new Restaurant("Tequila y Tacos", 1);
        Restaurant sucursal2 = new Restaurant("Tequila y Tacos", 1);
        Restaurant sucursal3 = new Restaurant("Tequila y Tacos", 3);
        Restaurant sucursal4 = new Restaurant("Tequila y Tacos", 3);
        Restaurant sucursal5 = new Restaurant("Tequila y Tacos", 4);
        Restaurant sucursal6 = new Restaurant("Tequila y Tacos con Mariachi", 4);
        Restaurant sucursal7 = new Restaurant("Tequila y Tacos con Mariachi", 5);

        sucursales.add(sucursal1);
        sucursales.add(sucursal2);
        sucursales.add(sucursal3);
        sucursales.add(sucursal4);
        sucursales.add(sucursal5);
        sucursales.add(sucursal6);
        sucursales.add(sucursal7);

        System.out.println("\nRestaurant size: " + sucursales.size());
        System.out.println("Elements: ");
        for(Restaurant sucursal : sucursales){
            System.out.println(" > " + sucursal);
        }
    }
}
