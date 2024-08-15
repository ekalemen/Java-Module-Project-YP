import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int CAR_MIN_SPEED_KMH = 0;
    public static final int CAR_MAX_SPEED_KMH = 250;
    public static final int MAX_CARS_IN_RACE = 3;
    public static String resultMessageTemplate = "Самая быстрая машина: %s.";
    public static String addNewCarMessageTemplate = "Введите данные автомобиля N%d";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> carsInRace = new ArrayList<>();

        System.out.println("Введите данные автомобилей учавствующих в гонке.");
        for(int i = 0; i < MAX_CARS_IN_RACE; i++) {
            System.out.println(String.format(addNewCarMessageTemplate, i + 1));
            System.out.print("Имя: ");
            String carName = scanner.next();
            int carSpeed;
            while (true) {
                System.out.print("Скорость (км/ч): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Скорость - целочисленная величина!");
                    scanner.next(); //Dummy read to clear input
                } else {
                    carSpeed = scanner.nextInt();
                    if (carSpeed <= CAR_MIN_SPEED_KMH) {
                        System.out.println("Скорость должна быть больше " + CAR_MIN_SPEED_KMH);
                    } else if (carSpeed > CAR_MAX_SPEED_KMH) {
                        System.out.println("Скорость должна быть меньше или равна " + CAR_MAX_SPEED_KMH);
                    } else {
                        break;
                    }
                }
            }
            carsInRace.add(new Car(carName,carSpeed));
        }
        Race race = new Race(carsInRace);
        Car carWinner = race.getRaceWinner();
        if (carWinner != null) {
            System.out.println(String.format(resultMessageTemplate, carWinner.name));
        } else {
            System.out.println("Fail. Something is going wrong.");
        }
    }
}