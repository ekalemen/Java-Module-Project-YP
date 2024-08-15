import java.util.ArrayList;

public class Race {
    public ArrayList<Car> carsList;

    Race(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }

    Car getRaceWinner() {
        Car winner;

        if ((carsList != null) && !carsList.isEmpty()) {
            winner = carsList.get(0);
            for (Car car : carsList) {
                if (car.speed > winner.speed) {
                    winner = car;
                }
            }
        } else {
            return null;
        }

        return winner;
    }
}