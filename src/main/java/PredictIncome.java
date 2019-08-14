import de.vandermeer.asciitable.AsciiTable;
import model.Frequency;
import model.InputModel;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-08-12 16:36
 */
public class PredictIncome {
    public static void main(String[] args) {

        InputModel inputModel = new InputModel.Builder().salary().incrementPercent().frequentlyDeductions().deductionOnIncome().frequentlyIncrement().years().build();

        //Generate the increment report
        AsciiTable at1 = new AsciiTable();
        at1.addRule();
        at1.addRow("year", "Starting Salary", "Number of Increments", "Increment %", "Increment Amount");
        at1.addRule();


        AsciiTable at2 = new AsciiTable();
        at2.addRule();
        at2.addRow("year", "Starting Salary", "Number of deductions", "Deduction %", "Deduction Amount");
        at2.addRule();

        AsciiTable at3 = new AsciiTable();
        at3.addRule();
        at3.addRow("year", "Starting Salary", "Increment Amount", "Deduction Amount", "Salary Growth");
        at3.addRule();

        BigDecimal startSalary = inputModel.getSalary();
        BigDecimal incrementSalary = startSalary;
        BigDecimal deductionSalary = startSalary;
        for(int i=0; i<inputModel.getYears();i++){
            incrementSalary = CalUtil.calcIncrementAmount(inputModel,incrementSalary);
            at1.addRow(i+1,startSalary,inputModel.getFrequentlyIncrement(),inputModel.getIncrementPercent(),incrementSalary.setScale(2, BigDecimal.ROUND_HALF_UP));
            at1.addRule();

            deductionSalary = CalUtil.calcDeductionAmount(inputModel,deductionSalary);
            at2.addRow(i+1,startSalary,inputModel.getFrequentlyDeductions(),inputModel.getIncrementPercent(),deductionSalary.setScale(2, BigDecimal.ROUND_HALF_UP));
            at2.addRule();

            at3.addRow(i+1,startSalary,incrementSalary.setScale(2, BigDecimal.ROUND_HALF_UP),deductionSalary.setScale(2, BigDecimal.ROUND_HALF_UP),incrementSalary.subtract(deductionSalary).setScale(2, BigDecimal.ROUND_HALF_UP));
            at3.addRule();
        }


        //Generate the decrement report
        String rend1 = at1.render();
        System.out.println(rend1);

        String rend2 = at2.render();
        System.out.println(rend2);


        String rend3 = at3.render();
        System.out.println(rend3);
    }


}
