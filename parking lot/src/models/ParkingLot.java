package models;

import models.constants.ParkingLotStatus;
import models.constants.VehicleType;
import service.billCalculationStrategy.BillCalculationStrategy;
import service.slotAllocationStrategy.SlotAllocationStrategy;


import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private ParkingLotStatus parkingLotStatus;
    private List <VehicleType> supportedVehicleTypes;
    private SlotAllocationStrategy slotAllocationStrategy;
    private BillCalculationStrategy billCalculationStrategy;
}
