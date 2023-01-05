package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Repository repository = new Repository();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("||Invoice Management System||\nFollowing are the Evolution Queries\n\n[ 1 ] The number of outstanding invoices per customer\n[ 2 ] The number of repair orders processed and the respective average gross invoice amount (sales) per bicycle\n[ 3 ] Frequency and average net effort per activity\n[ 4 ] Net sales in spare parts sales\n[ 5 ] All items (material and AG) per invoice, sorted by invoice and item numbers\n[ 0 ] Exit");
            System.out.print("Enter your choice ==>  ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("=========================================================\n");
                    repository.theNumberOfOutstandingInvoicesPerCstomer();
                    System.out.println("\n=========================================================\n");
                    break;
                case 2:
                    System.out.println("=========================================================\n");
                    repository.theNumberOfRepairedOrderProcessedAndTheirAG();
                    System.out.println("\n=========================================================\n");
                    break;
                case 3:
                    System.out.println("=========================================================\n");
                    repository.frequencyAndAverageNetEffortPerActivity();
                    System.out.println("\n=========================================================\n");
                    break;
                case 4:
                    System.out.println("=========================================================\n");
                    repository.netSalesInSparePartsSales();
                    System.out.println("\n=========================================================\n");
                    break;
                case 5:
                    System.out.println("=========================================================\n");
                    repository.allItemsPerInvoice();
                    System.out.println("\n=========================================================\n");
                    break;
                case 0:
                    flag = false;
                    break;

            }
        }
    }
}