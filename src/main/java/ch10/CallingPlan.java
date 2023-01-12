package ch10;

public interface CallingPlan{

    boolean isSatisfy(Call call);

    double calculateFeeByCall(Call call);
}
