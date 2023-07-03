package Models;

import Constants.ParkingSpotType;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int id) {
        super(ParkingSpotType.BIKE, id);
    }
}
