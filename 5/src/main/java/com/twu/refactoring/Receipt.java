package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        totalCost += FIXED_CHARGE;

        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;
        double perRateDistance = Math.min(RATE_CHANGE_DISTANCE, totalKms) * peakTimeMultiple;
        double postRateDistance = Math.max(0, totalKms - RATE_CHANGE_DISTANCE) * peakTimeMultiple;
        totalCost = getTotalCost(totalCost, perRateDistance, postRateDistance);

        return totalCost * (1 + SALES_TAX_RATE);
    }

    private double getTotalCost(double totalCost, double perRateDistance, double postRateDistance) {
        if(taxi.isAirConditioned()) {
            totalCost += PRE_RATE_CHANGE_AC_RATE * perRateDistance;
            totalCost += POST_RATE_CHANGE_AC_RATE * postRateDistance;
        } else {
            totalCost += PRE_RATE_CHANGE_NON_AC_RATE * perRateDistance;
            totalCost += POST_RATE_CHANGE_NON_AC_RATE * postRateDistance;
        }
        return totalCost;
    }
}
