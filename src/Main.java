
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        YearlyReport yearlyReport = null;

        HashMap<Integer, MonthlyReport> monthData = new HashMap<>();
        int monthsCount = 3;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                for (int m = 1; m <= monthsCount; m++) {
                    System.out.println(m+" -й месяц:");
                    String monthPath = "resources/m.20210" + m + ".csv";
                    MonthlyReport monthlyReport = new MonthlyReport(monthPath);
                    monthData.put(m, monthlyReport);
                }
            } else if (userInput == 2) {
                yearlyReport = new YearlyReport(2021, "resources/y.2021.csv");
            } else if (userInput == 3) {
                if (monthData.isEmpty() || yearlyReport == null){
                    System.out.println("Необходимо предварительно считать месячные и годовые отчеты");
                }else {
                    ComparisonReports.compareSums(monthsCount, yearlyReport, monthData);
                }
            } else if (userInput == 4) {
                if (monthData.isEmpty()){
                    System.out.println("Необходимо предварительно считать месячные отчеты");
                } else {
                    for (int m = 1; m <= monthsCount; m++) {
                        System.out.println("Отчет по "+m+" -му месяцу:");
                        MonthlyReport monthlyReport=monthData.get(m);
                        monthlyReport.findMaxExpenseAndIncome();
                    }
                }
            } else if (userInput == 5) {
                if (yearlyReport == null) {
                    System.out.println("Необходимо предварительно считать годовой отчет");
                } else {
                    System.out.println("Отчет за 2021 год:");
                    yearlyReport.getMonthProfit();
                    System.out.println("Средний расход за все месяцы в году: " + yearlyReport.getAverageExpenses());
                    System.out.println("Средний доход за все месяцы в году: " + yearlyReport.getAverageIncome());}
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            }
        }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчетах");
        System.out.println("5 - Вывести информацию о годовом отчете");
        System.out.println("0 - Завершить программу");
    }


}