package service.billCalculationStrategy;

public class BillCalculationStrategyFactory {

    public static BillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategyType type) {
        switch (type) {
            case LOW:
                return new LowBillCalculationStrategy();
            // Add more cases here for different strategies

            default:
                throw new IllegalArgumentException("Unknown strategy type: " + type);
        }
    }

    public static BillCalculationStrategy getBillCalculationStrategy() {
        return null;
    }
}
