import model.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
    static final String NO_CAR_EXIST = "There is no car !";


    public static void main(String[] args) {

        try {
            readDataFromTheFile();

            while (true) {
                System.out.println("\nEnter the options: \n0.Exit \n1.Add a car \n2.List all the cars \n3.Modify the car");

                int userInput = input.nextInt();
                switch (userInput) {
                    case 0:
                        saveToFile();
                        return;
                    case 1:
                        addCar();
                        break;
                    case 2:
                        listCars();
                        break;
                    case 3:
                        modifyCars();
                        break;
                }

//            switch (userInput) {
//                case 0 -> {
//                    saveToFile();
//                    return;
//                }
//                case 1 -> addCar();
//                case 2 -> listCars();
//                case 3 -> modifyCars();
//            }
            }
        }catch (Exception exc){
            System.out.println("An exception happened " + exc.getMessage());
        }
    }

    private static void readDataFromTheFile() {
        //try-with-resource
        try(Scanner reader = new Scanner(new File(DATA_FILE))) {
            while (reader.hasNextLine()){
                String[] dataLine = reader.nextLine().split(";");

                String make = dataLine[0];
                int productionYear = Integer.parseInt(dataLine[1]);
                double engineSize = Double.parseDouble(dataLine[2]);

                cars.add(new Car(make, productionYear, engineSize));

            }
        }
        catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

    private static void saveToFile() {
        if(!cars.isEmpty()){
            try(PrintWriter writer = new PrintWriter(DATA_FILE)){
                for(Car car: cars){
                    writer.println(car.toDataString());
                }
            }
            catch (Exception exc){

            }
        }
    }

    private static void modifyCars() {
        if(cars.isEmpty()){
            System.out.println(NO_CAR_EXIST);
            return;
        }
        System.out.println("Enter the car # to modify");
        int carNum = input.nextInt();
        input.nextLine();

        Car carTobeModified = cars.get(carNum - 1);

        if(!cars.contains(carTobeModified)){ // index starts from 0
            System.out.println("The car does not exist");
        }
        else{
            System.out.println("Enter the make");
            input.nextLine();
            String make = input.nextLine();
            System.out.println("Enter the production year");
            int year = input.nextInt();
            input.nextLine();
            System.out.println("Enter the engine size");
            double engineSize = input.nextDouble();
            input.nextLine();

            carTobeModified.setYear(year);
            carTobeModified.setMake(make);
            carTobeModified.setEngineSize(engineSize);

        }
    }

    private static void listCars() {
        if(cars.isEmpty()){
            System.out.println(NO_CAR_EXIST);
            return;
        }
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