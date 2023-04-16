
import java.util.HashMap;

public class YearlyReport {
    public int year;
    public HashMap<Integer, YearlyReportMonth> monthsData = new HashMap<>();
    public YearlyReport(int year, String path) {
        this.year = year;
        String content = FileReader.readFileContentsOrNull(path);
        if (content==null) {
            return; //сделано по аналогии с месяцами
        }
        String[] lines = content.split("\r?\n");
        System.out.println("Годовой отчет успешно считан");
        for (int i = 1; i < lines.length; i++) {
                String line = lines[i];
                String[] parts = line.split(",");
                int month = Integer.parseInt(parts[0]);
                double sum = Double.parseDouble(parts[1]);
                boolean isExpense = Boolean.parseBoolean(parts[2]);

                if (!monthsData.containsKey(month)) {
                    monthsData.put(month, new YearlyReportMonth(month));
                }

                YearlyReportMonth oneMonthData = monthsData.get(month);
                if (isExpense) {
                    oneMonthData.expenses += sum;
                } else {
                    oneMonthData.income += sum;
                }
            }
    }
    int findSumExpense(int month) {
        return monthsData.get(month).expenses;
    }
    int findSumIncome(int month) {
        return monthsData.get(month).income;
    }

    void getMonthProfit() {
        for (Integer numberMonth: monthsData.keySet() ) {
            YearlyReportMonth oneMonthData= monthsData.get(numberMonth);
            double monthProfit = oneMonthData.income - oneMonthData.expenses; //исправлено
                System.out.println("Прибыль по месяцу " + numberMonth + " составила " + monthProfit);
             }
    }

    public double getAverageExpenses() {
        double sumExpenses = 0;
        for (YearlyReportMonth oneMonthData : monthsData.values()) {
            sumExpenses += oneMonthData.expenses;
        }
        return sumExpenses/monthsData.size();
    }
    public double getAverageIncome() {
        double sumIncome = 0;
        for (YearlyReportMonth oneMonthData : monthsData.values()) {
            sumIncome += oneMonthData.income;
        }
        return sumIncome/monthsData.size();
    }
}