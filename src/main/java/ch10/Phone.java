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
        Long resultSecond = getTotalCallSecond();

        return (double)resultSecond * plan.getAmount() / plan.getSeconds();
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

    private Long getTotalCallSecond() {
        Long resultSecond = 0L;

        for(Call call : callList){
            resultSecond += call.getDuration().getSeconds();
        }
        return resultSecond;
    }
}


