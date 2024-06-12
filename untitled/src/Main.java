import model.Car;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This application tries to read some data from a file name carData and does some actions
 * such as add a car, delete a car ....
 */
public class Main {
    static Scanner input =new Scanner(System.in);
    static ArrayList<Car> cars = new ArrayList<>();
    static final String DATA_FILE = "carData.txt";

    public static void main(String[] args) {
        while(true){
            System.out.println("\nEnter the options: \n0.Exit \n1.Add a car \n2.List all the cars");

            int userInput = input.nextInt();
            switch (userInput){
                case 0:
                    return;
                case 1:
                    addCar();
                    break;
                case 2:
                    listCars();
                    break;
            }
        }
    }

    private static void listCars() {
        for(int i=0; i< cars.size(); i++){
            System.out.printf("#%d %s %n", i+1, cars.get(i));
        }
    }

    private static void addCar() {
        //sout tab
        System.out.println("Enter the make");
        input.nextLine();
        String make = input.nextLine();
        System.out.println("Enter the production year");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Enter the engine size");
        double engineSize = input.nextDouble();
        input.nextLine();
        Car car = new Car(make, year, engineSize);
        cars.add(car);
    }
}