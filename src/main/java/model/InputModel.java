package model;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-08-13 10:48
 */
public class InputModel {
    BigDecimal salary;
    float incrementPercent;
    int frequentlyIncrement;
    float deductionOnIncome;
    int frequentlyDeductions;
    int years;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public float getIncrementPercent() {
        return incrementPercent;
    }

    public void setIncrementPercent(float incrementPercent) {
        this.incrementPercent = incrementPercent;
    }

    public int getFrequentlyIncrement() {
        return frequentlyIncrement;
    }

    public void setFrequentlyIncrement(int frequentlyIncrement) {
        this.frequentlyIncrement = frequentlyIncrement;
    }

    public float getDeductionOnIncome() {
        return deductionOnIncome;
    }

    public void setDeductionOnIncome(float deductionOnIncome) {
        this.deductionOnIncome = deductionOnIncome;
    }

    public int getFrequentlyDeductions() {
        return frequentlyDeductions;
    }

    public void setFrequentlyDeductions(int frequentlyDeductions) {
        this.frequentlyDeductions = frequentlyDeductions;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }


    public static class Builder {
        BigDecimal salary;
        float incrementPercent;
        int frequentlyIncrement;
        float deductionOnIncome;
        int frequentlyDeductions;
        int years;

        private Scanner scanner;

        public Builder() {
            scanner = new Scanner(System.in);
        }


        public Builder salary() {

            System.out.println("Enter The starting salary: ");
            BigDecimal salary = scanner.nextBigDecimal();
            if (salary.compareTo(BigDecimal.ONE) == -1) {
                System.err.println("Starting Salary less then 1");
                salary();
            }
            this.salary = salary;
            return this;
        }

        public Builder incrementPercent() {
            System.out.println("Enter The  Increment Percent: ");
            float incrementPercent = scanner.nextFloat();
            if (incrementPercent < 0) {
                System.err.println("Do not accept a negative number for increment");
                incrementPercent();
            }
            this.incrementPercent = incrementPercent;
            return this;
        }

        public Builder frequentlyIncrement() {
            System.out.println("Enter How frequently is increment received: ");
            int frequentlyIncrement = scanner.nextInt();
            if(frequentlyIncrement<1){
                System.err.println("Do not accept a number less than 1 for frequency of increment");
                frequentlyIncrement();
            }
            this.frequentlyIncrement = frequentlyIncrement;
            return this;
        }

        public Builder deductionOnIncome() {
            System.out.println("Enter Deductions on income: ");
            float deductionOnIncome = scanner.nextFloat();
            if (deductionOnIncome < 0) {
                System.err.println("Do not accept a negative number for increment");
                incrementPercent();
            }
            this.deductionOnIncome = deductionOnIncome;
            return this;
        }

        public Builder frequentlyDeductions() {
            System.out.println("Enter How frequently are deductions done: ");
            int frequentlyDeductions = scanner.nextInt();
            if(frequentlyDeductions<1){
                System.err.println("Do not accept a number less than 1 for frequency of deductions");
                frequentlyDeductions();
            }
            this.frequentlyDeductions = frequentlyDeductions;
            return this;
        }

        public Builder years() {
            System.out.println("Enter Prediction for (years): ");
            int years = scanner.nextInt();
            this.years = years;
            return this;
        }

        public InputModel build() {
            return new InputModel(this);
        }

    }

    private InputModel(Builder b) {
        this.salary = b.salary;
        this.incrementPercent = b.incrementPercent;
        this.frequentlyIncrement = b.frequentlyIncrement;
        this.frequentlyDeductions = b.frequentlyDeductions;
        this.deductionOnIncome = b.deductionOnIncome;
        this.years = b.years;
    }
}
