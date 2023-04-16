import java.util.HashMap;

public class ComparisonReports {

public static void compareSums(int monthsCount, YearlyReport YearlyReport, HashMap<Integer, MonthlyReport> monthData){
    for (int m=1; m<=monthsCount;m++){
        MonthlyReport monthlyReport=monthData.get(m);
        int expenseMonthReport=monthlyReport.findSumExpense();
        int incomeMonthReport=monthlyReport.findSumIncome();
        int expenseYearlyReport=YearlyReport.findSumExpense(m);
        int incomeYearlyReport=YearlyReport.findSumIncome(m);
        boolean isMistake=(expenseYearlyReport != expenseMonthReport) || (incomeMonthReport != incomeYearlyReport);//переименована переменная
        System.out.println("Месяц " + m + ".");
        System.out.println("Расходы по данным месячного отчета "+ expenseMonthReport+ " руб.");// вынесено за пределы if, дублирования теперь нет
        System.out.println("Расходы по данным годового отчета "+ expenseYearlyReport+ " руб.");
        System.out.println("Доходы по данным месячного отчета "+ incomeMonthReport+" руб.");
        System.out.println("Доходы по данным годового отчета " + incomeYearlyReport+" руб.");
        if (isMistake){
            System.out.println("Обратите внимание! Обнаружено несоответствие в отчетах по "+m+"-му месяцу.");
        }else {
            System.out.println("Данные месячного и годового отчетов по "+m+"-му месяцу соответствуют");
        }

    }
}
}
