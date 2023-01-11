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
        Double normalFee = super.calculateFee();

        for(Call call : getCallList()){
            if(call.getStartTime().getHour() > LATE_NIGHT_HOUR){
                normalFee -= (double)plan.getAmount() * call.getDuration().getSeconds() / plan.getSeconds();
                normalFee += (double)nightPlan.getAmount() * call.getDuration().getSeconds() / nightPlan.getSeconds();
            }
        }

        return normalFee;
    }


}
