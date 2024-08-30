package service.billCalculationStrategy;

import models.Ticket;
import models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy {
    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;

    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {
        LocalDateTime entryTime = ticket.getEntryTime();
        long totalHours = ChronoUnit.HOURS.between(entryTime, exitTime); // Calculate total hours between entry and exit times
        int costPerHour = getCostPerHour(ticket.getVehicle().getVehicleType());

        double baseCost = costPerHour * totalHours;
        return baseCost + (baseCost * (INCREMENT_FACTOR * (totalHours - 1)));
    }

    // Method to calculate per hour cost based on vehicle type
    private int getCostPerHour(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.CAR)) {
            return PER_HOUR_CHARGE_4_WHEELER;
        } else {
            return PER_HOUR_CHARGE_2_WHEELER;
        }
    }
}


/*
   1st hour -> 50
   2nd hour -> 50 * 2 =>100 +  100 * ( 0.1 * 2-1) => 10 => 110
   3rd hour -> 50 * 3 => 150 | 150 * ( 0.1 * 3-1) => 150 * 0.2 => 30 -> 180

   formula = base cost => fixedCost * N
             totalCost => baseCost + baseCost * [ incrementFactor * [N-1]]
*/

