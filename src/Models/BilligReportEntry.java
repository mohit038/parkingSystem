package Models;

public class BilligReportEntry {
    int amount;
    int inTime;
    int exitTime;
    String VehicleNumber;

    public BilligReportEntry(int amount, int inTime, int exitTime, String VehicleNumber) {
        this.amount = amount;
        this.inTime = inTime;
        this.exitTime = exitTime;
        this.VehicleNumber = VehicleNumber;
    }
}
