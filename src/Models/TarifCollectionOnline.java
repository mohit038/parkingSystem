package Models;

public class TarifCollectionOnline implements TarifCollection {
    int tarifForCar;
    int tarifForbike;
    int tarifForMinTruck;

    public TarifCollectionOnline(int tarifForCar, int tarifForBike, int tarifForMiniTruck) {
        this.tarifForCar = tarifForCar;
        this.tarifForbike = tarifForBike;
        this.tarifForMinTruck = tarifForMiniTruck;
    }

    @Override
    public boolean pay(int amount) {
        return false;
    }

    @Override
    public int tarifCalculator(int time, ParkingSpot parkingSpot) {
        if (parkingSpot instanceof CarParkingSpot) {
            return this.tarifForCar * time;
        } else if (parkingSpot instanceof BikeParkingSpot) {
            return this.tarifForbike * time;
        } else if (parkingSpot instanceof MiniTruckParkingSpot) {
            return this.tarifForMinTruck * time;
        } else {
            throw new IllegalArgumentException("Vehicle type not supported");
        }
    }

}
