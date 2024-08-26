package ProjectTwo;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class POPProjectTwo
{

    static final int MAX_TRANSACTIONS = 50;
    static String[] descriptions = new String[MAX_TRANSACTIONS];
    static double[] amounts = new double[MAX_TRANSACTIONS];
    static String[] categories = new String[MAX_TRANSACTIONS];
    static int transactionCount = 0;
    static Scanner scanner = new Scanner(System.in);

    //get data from user
    public static void inputTransaction()
    {
        //check there is data
        if (transactionCount < MAX_TRANSACTIONS)
        {
            System.out.print("Enter description: ");
            descriptions[transactionCount] = scanner.nextLine();
            System.out.print("Enter amount: ");
            amounts[transactionCount] = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Enter category: ");
            categories[transactionCount] = scanner.nextLine();
            transactionCount++;
        }
        else
        {
            System.out.println("Transaction limit reached!");
        }
    }

    //Showing the data with or without sorting
    public static void viewTransactions()
    {
        //check there is data
        if(transactionCount == 0)
        {
            System.out.println("\nThere is no data please enter data !!!!");
        }
        else
        {
            //print data without sorting
            System.out.printf("%-20s %-10s %-15s\n", "Description", "Amount", "Category");
            System.out.println("--------------------------------------------");
            for (int i = 0; i < transactionCount; i++)
            {
                System.out.printf("%-20s %-10.2f %-15s\n", descriptions[i], amounts[i], categories[i]);
            }

            //ask user if he wants data sorting
            System.out.print("do you want sort by amount? (yes/no): ");
            String sortByAmount = scanner.nextLine();
            if (Objects.equals(sortByAmount, "yes"))
            {
                sortTransactionsByAmount();
                //print data sorting
                System.out.printf("%-20s %-10s %-15s\n", "Description", "Amount", "Category");
                System.out.println("--------------------------------------------");
                for (int i = 0; i < transactionCount; i++)
                {
                    System.out.printf("%-20s %-10.2f %-15s\n", descriptions[i], amounts[i], categories[i]);
                }
            }
        }
    }

    //sorting method
    public static void sortTransactionsByAmount()
    {
        for (int i = 0; i < transactionCount - 1; i++)
        {
            for (int j = i + 1; j < transactionCount; j++)
            {
                if (amounts[i] > amounts[j]) {
                    swap(i, j);
                }
            }
        }
    }

    //swaping method
    public static void swap(int i, int j)
    {
        String tempDescription = descriptions[i];
        descriptions[i] = descriptions[j];
        descriptions[j] = tempDescription;

        double tempAmount = amounts[i];
        amounts[i] = amounts[j];
        amounts[j] = tempAmount;

        String tempCategory = categories[i];
        categories[i] = categories[j];
        categories[j] = tempCategory;
    }

    //summery of entery data
    public static void viewSummary()
    {
        //check there is data
        if(transactionCount == 0)
        {
            System.out.println("\nThere is no data please enter data !!!!");
        }
        else {
            //get sum of income and expense
            double totalIncome = 0, totalExpenses = 0;
            for (int i = 0; i < transactionCount; i++) {
                if (amounts[i] > 0) {
                    totalIncome += amounts[i];
                } else {
                    totalExpenses += amounts[i];
                }
            }
            double balance = totalIncome + totalExpenses;
            System.out.println("\nSummary:");
            System.out.println("Total Income: $" + totalIncome);
            System.out.println("Total Expenses: $" + totalExpenses);
            System.out.println("Balance: $" + balance);
        }
    }


    //get insight data
    public static void getInsights()
    {
        //check there is data
        if(transactionCount == 0)
        {
            System.out.println("\nThere is no data please enter data !!!!");
        }
        else
        {
            double totalExpenses = 0;
            System.out.println("\nSpending Insights by Category:");
            //get sum of expense
            for (int i = 0; i < transactionCount; i++)
            {
                if (amounts[i] < 0)
                {
                    totalExpenses += amounts[i];
                }
            }
            System.out.println("Total expenses : " + (totalExpenses*(-1)));

            //print expense data and there amount and rate
            DecimalFormat fm = new DecimalFormat("#.00");
            double num ;
            for (int i = 0; i < transactionCount; i++)
            {
                if (amounts[i] < 0)
                {
                    num = amounts[i]/totalExpenses*100;
                    System.out.println("Category: " + categories[i] + " - Spent : " + (amounts[i]*(-1)) + "( " + fm.format(num)+ "% of total )");
                }
            }
        }
    }


    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\nTransaction Management System");
            System.out.println("1. Input Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. View Summary");
            System.out.println("4. Get Insights");
            System.out.println("5. Exit");
            System.out.print("Choose an option : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    inputTransaction();
                    break;
                case 2:
                    viewTransactions();
                    break;
                case 3:
                    viewSummary();
                    break;
                case 4:
                    getInsights();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }
}
