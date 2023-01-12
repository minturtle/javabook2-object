package ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {

    private List<Call> callList = new ArrayList<>();

    private List<CallingPlan> plans;
    private List<AdditionalCallingPlan> additionalPlans;


    // planList에 plan의 우선순위에 맞게 값을 넣어야 한다.
    public Phone(List<CallingPlan> planList , List<AdditionalCallingPlan> additionalPlanList) {
        plans = new ArrayList<>(planList);
        additionalPlans = new ArrayList<>(additionalPlanList);
    }

    public Phone(List<CallingPlan> plans) {
        this(plans, List.of());
    }

    public Double calculateFee(){
        double resultFee = 0.0;
        for(Call call : callList){

            //기본 정책은 하나의 plan만 적용해야 함.
            for(CallingPlan plan : plans){
                if(plan.isSatisfy(call)){
                    CallingPlan lastPlan = linkAdditionalPlans(plan);
                    resultFee += lastPlan.calculateFee(call);
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

    // AdditionalPlans가 있다면 연결해준다.
    private CallingPlan linkAdditionalPlans(CallingPlan plan){
        CallingPlan lastPlan = plan;
        for(AdditionalCallingPlan additionalPlan : additionalPlans) {
            additionalPlan.setNext(lastPlan);
            lastPlan = additionalPlan;
        }
        return lastPlan;
    }
}


