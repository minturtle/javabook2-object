package ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private List<Call> callList = new ArrayList<>();

    private List<CallingPlan> plans;

    public Phone(CallingPlan plan, CallingPlan nightPlan) {
        plans = new ArrayList<>(List.of(nightPlan, plan));
    }

    // 심야 요금제 적용 아닌 휴대폰의 경우, 일반 요금제와 심야할인 요금제를 같은 객체로 사용
    public Phone(CallingPlan plan) {
        this(plan, plan);
    }

    public Double calculateFee(){
        double resultFee = 0.0;
        for(Call call : callList){
            for(CallingPlan plan : plans){
                if(plan.isSatisfy(call)){
                    resultFee += plan.calculateFeeByCall(call);
                    break;
                }
            }
        }

        return resultFee;
    }

    public void call(Call call){
        callList.add(call);
    }

    protected List<Call> getCallList(){
        return Collections.unmodifiableList(callList);
    }

}


