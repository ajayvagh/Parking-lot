package service.slotAllocationStrategy;

import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.constants.ParkingSlotStatus;
import models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy {

    @Override
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate) {
        int floorNumber = entryGate.getFloorNumber();

        // Check the current floor
        for (ParkingSlot slot : parkingLot.getParkingFloors().get(floorNumber).getParkingSlots()) {
            if (slot.getSupportedVehicleType().equals(vehicleType) &&
                    slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
                return slot;
            }
        }

        // Check adjacent floors
        int i = floorNumber - 1;
        int j = floorNumber + 1;
        while (i >= 0 || j < parkingLot.getParkingFloors().size()) {
            if (i >= 0) {
                for (ParkingSlot slot : parkingLot.getParkingFloors().get(i).getParkingSlots()) {
                    if (slot.getSupportedVehicleType().equals(vehicleType) &&
                            slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
                        return slot;
                    }
                }
            }
            if (j < parkingLot.getParkingFloors().size()) {
                for (ParkingSlot slot : parkingLot.getParkingFloors().get(j).getParkingSlots()) {
                    if (slot.getSupportedVehicleType().equals(vehicleType) &&
                            slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
                        return slot;
                    }
                }
            }
            i--;
            j++;
        }

        // Handle the case where no available slot is found
        return null; // Or handle it in a way appropriate for your application
    }
}
