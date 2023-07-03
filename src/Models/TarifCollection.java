package Models;

public interface TarifCollection {
    public boolean pay(int amount);

    public int tarifCalculator(int time, ParkingSpot parkingSpot);
}
