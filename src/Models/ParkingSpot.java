package Models;

import Constants.ParkingSpotType;

public class ParkingSpot {
    ParkingSpotType parkingSpotType;
    int parkingSpotId;

    public ParkingSpot(ParkingSpotType parkingSpotType, int parkingSpotId) {
        this.parkingSpotType = parkingSpotType;
        this.parkingSpotId = parkingSpotId;
    }
}
