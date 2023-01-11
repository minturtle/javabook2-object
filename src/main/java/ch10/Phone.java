package ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private List<Call> callList = new ArrayList<>();

    private CallingPlan plan;

    public Phone(CallingPlan plan) {
        this.plan = plan;
    }

    public Double calculateFee(){
        double resultFee = 0.0;
        for(Call call : callList){
            resultFee += getFeeByCall(call, plan);
        }

        return resultFee;
    }

    public void call(Call call){
        callList.add(call);
    }

    //call당 요금 계산
    protected double getFeeByCall(Call call, CallingPlan plan){
        return (double)call.getSeconds() * plan.getAmount() / plan.getSeconds();
    }

    protected List<Call> getCallList(){
        return Collections.unmodifiableList(callList);
    }

    protected CallingPlan getPlan() {
        return plan;
    }


}


