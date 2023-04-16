
import java.util.ArrayList;


public class MonthlyReport {
    public ArrayList<OneMonthlyReport> oneMonthData = new ArrayList<>();
    public MonthlyReport(String path) {

        String content = FileReader.readFileContentsOrNull(path);
        if (content==null) {
            return;
        }//Спасибо большое! Интересная функция
        String[] lines = content.split("\r?\n");
        System.out.println("Месячный отчет успешно считан");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            String item = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);
            int amount = sumOfOne * quantity;
            oneMonthData.add(new OneMonthlyReport(item, isExpense, amount));
            }
        }




     public void findMaxExpenseAndIncome(){
         int maxExpense=0;
         String maxExItem=null;
         int maxIncome=0;
         String maxInItem=null;
         for (OneMonthlyReport line : oneMonthData) { //исправлено на краткую форму, также исправила по аналогии ниже
             if (line.isExpense) {
                 if (line.amount > maxExpense) {
                     maxExpense = line.amount;
                     maxExItem = line.item;
                 }
             } else {
                 if (line.amount > maxIncome) {
                     maxIncome = line.amount;
                     maxInItem = line.item;
                 }
             }
         }
System.out.println("Самым прибыльным товаром является: " + maxInItem+ ". Прибыль составила: "+ maxIncome+ " руб." );
System.out.println("Самой большой тратой является: " + maxExItem+ ". Расходы составили: "+ maxExpense+ " руб." );
    }

    public int findSumExpense() {
        int sumExpense = 0;
        for (OneMonthlyReport line : oneMonthData) {
            if (line.isExpense) {
                sumExpense += line.amount;
            }
        }
        return sumExpense;
    }

    public int findSumIncome(){
        int sumIncome=0;
        for (OneMonthlyReport line : oneMonthData) {
            if (!line.isExpense) {
                sumIncome += line.amount;
            }
        }
       return sumIncome;
    }
}