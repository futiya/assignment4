import model.InputModel;

import java.math.BigDecimal;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-08-13 13:56
 */
public class CalUtil {
    public static BigDecimal calcIncrementAmount(InputModel inputModel,BigDecimal startSalary){
        int increments = inputModel.getFrequentlyIncrement();
        BigDecimal salary=null;
        for(int i=0; i<increments;i++){
            salary = startSalary.multiply(BigDecimal.valueOf(1+inputModel.getIncrementPercent()/100));
        }
        return salary;
    }

    public static BigDecimal calcDeductionAmount(InputModel inputModel,BigDecimal startSalary){
        BigDecimal salary = inputModel.getSalary();
        int deduction = inputModel.getFrequentlyDeductions();
        for(int i=0; i<deduction;i++){
            salary=startSalary.multiply(BigDecimal.valueOf(1-inputModel.getDeductionOnIncome()/100));
        }
        return salary;
    }
}
