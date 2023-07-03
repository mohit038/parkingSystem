package Models;

import Constants.ParkingSpotType;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int id) {
        super(ParkingSpotType.CAR, id);
    }
}
