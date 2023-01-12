package ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private List<Call> callList = new ArrayList<>();

    private CallingPlan plan;
    private CallingPlan nightPlan;

    public Phone(CallingPlan plan, CallingPlan nightPlan) {
        this.plan = plan;
        this.nightPlan = nightPlan;
    }

    // 심야 요금제 적용 아닌 휴대폰의 경우, 일반 요금제와 심야할인 요금제를 같은 객체로 사용
    public Phone(CallingPlan plan) {
        this(plan, plan);
    }

    public Double calculateFee(){
        double resultFee = 0.0;
        for(Call call : callList){
            resultFee += getFeeByCall(call, isLateNightCall(call) ? nightPlan : plan);
        }

        return resultFee;
    }

    public void call(Call call){
        callList.add(call);
    }

    protected List<Call> getCallList(){
        return Collections.unmodifiableList(callList);
    }

    protected CallingPlan getPlan() {
        return plan;
    }



    //call당 요금 계산
    private double getFeeByCall(Call call, CallingPlan plan){
        return (double)call.getSeconds() * plan.getAmount() / plan.getSeconds();
    }

    private boolean isLateNightCall(Call call){
        return call.getStartTime().getHour() > LATE_NIGHT_HOUR;
    }
}


