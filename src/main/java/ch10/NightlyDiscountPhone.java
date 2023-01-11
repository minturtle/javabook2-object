package ch10;

public class NightlyDiscountPhone extends Phone{

    private static final int LATE_NIGHT_HOUR = 22;

    private CallingPlan nightPlan;

    public NightlyDiscountPhone(CallingPlan plan, CallingPlan nightPlan) {
        super(plan);
        this.nightPlan = nightPlan;
    }


    @Override
    public Double calculateFee() {
        CallingPlan plan = getPlan();
        double normalFee = 0.0;

        for(Call call : getCallList()){
            normalFee += getFeeByCall(call, isLateTime(call) ? nightPlan : plan);
        }

        return normalFee;
    }

    private boolean isLateTime(Call call) {
        return call.getStartTime().getHour() > LATE_NIGHT_HOUR;
    }


}
