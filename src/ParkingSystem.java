import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Constants.ParkingSpotType;
import Models.BikeParkingSpot;
import Models.CarParkingSpot;
import Models.MiniTruckParkingSpot;
import Models.ParkingSpot;
import Models.TarifCollectionCash;
import Models.TarifCollectionOnline;

public class ParkingSystem {

    int numberOfCarParkingSpots;
    int numberOfBikeParkingSpots;
    int numberOfMiniTruckParkingSpots;
    int tarifForCar;
    int tarifForBike;
    int tarifForMiniTruck;

    int numberOfEntrances;

    List<CarParkingSpot> carParkingSpots;
    List<BikeParkingSpot> bikeParkingSpots;
    List<MiniTruckParkingSpot> miniTruckParkingSpots;
    TarifCollectionCash tarifCollectionCash;
    TarifCollectionOnline tarifCollectionOnline;
    int[][] distance;

    Set<ParkingSpot> occupied;
    Set<ParkingSpot> empty;

    public ParkingSystem(int numberOfCarParkingSpots, int numberOfBikeParkingSpots, int numberOfMiniTruckParkingSpots,
            int tarifForCar, int tarifForBike, int tarifForMiniTruck, int numberOfEntrances) {
        this.numberOfBikeParkingSpots = numberOfBikeParkingSpots;
        this.numberOfCarParkingSpots = numberOfCarParkingSpots;
        this.numberOfMiniTruckParkingSpots = numberOfMiniTruckParkingSpots;
        this.tarifForCar = tarifForCar;
        this.tarifForBike = tarifForBike;
        this.tarifForMiniTruck = tarifForMiniTruck;
        this.numberOfEntrances = numberOfEntrances;
        this.distance = new int[numberOfBikeParkingSpots + numberOfBikeParkingSpots
                + numberOfMiniTruckParkingSpots][numberOfEntrances];
        int index = 0;

        initDistance(this.distance);
        tarifCollectionCash = new TarifCollectionCash(tarifForCar, tarifForBike, tarifForMiniTruck);
        tarifCollectionOnline = new TarifCollectionOnline(tarifForCar, tarifForBike, tarifForMiniTruck);

        for (int i = 0; i < numberOfCarParkingSpots; i++) {
            carParkingSpots.add(new CarParkingSpot(index++));
        }
        for (int i = 0; i < numberOfBikeParkingSpots; i++) {
            bikeParkingSpots.add(new BikeParkingSpot(index++));
        }
        for (int i = 0; i < numberOfMiniTruckParkingSpots; i++) {
            miniTruckParkingSpots.add(new MiniTruckParkingSpot(index++));
        }

        occupied = new HashSet<>();
        empty = new HashSet<>();

    }

    private void initDistance(int[][] distance2) {
    }

    synchronized public void entry(String vehicleNumber, ParkingSpotType parkingSpotType) {
        ParkingSpot parkingSpot = getParkingSpot(parkingSpotType);
        occupied.add(parkingSpot);
    }

    public ParkingSpot getParkingSpot(ParkingSpotType parkingSpotType) {
        if (parkingSpotType == ParkingSpotType.CAR) {
            for (CarParkingSpot carParkingSpot : carParkingSpots) {
                if (occupied.contains(carParkingSpot))
                    continue;
                return carParkingSpot;
            }
        } else if (parkingSpotType == ParkingSpotType.BIKE) {
            for (BikeParkingSpot bilBikeParkingSpot : bikeParkingSpots) {
                if (occupied.contains(bilBikeParkingSpot))
                    continue;
                return bilBikeParkingSpot;
            }
        } else if (parkingSpotType == ParkingSpotType.MINITRUCK) {
            for (MiniTruckParkingSpot miniTruckParkingSpot : miniTruckParkingSpots) {
                if (occupied.contains(miniTruckParkingSpot))
                    continue;
                return miniTruckParkingSpot;
            }
        }
        return null;
    }

    public boolean exit(int parkingSpotId) {

    }

}
