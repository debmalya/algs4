package java8.examPreparation;

import java.time.LocalDate;
import java.time.Period;

public class Dating {
    public static void main(String[] args){
        LocalDate joiningDate = LocalDate.of(1996,02,19);
        LocalDate now = LocalDate.now();
        Period period = Period.between(joiningDate, now);
        System.out.println(String.format("Years : %d month : %d",period.getYears(),period.getMonths()));
    }
}
