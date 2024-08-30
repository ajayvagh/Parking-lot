package service.slotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategy(){
        return new NearestSlotAllocationStrategy();
    }

}
