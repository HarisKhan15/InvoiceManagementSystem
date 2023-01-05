package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Repository extends BaseConnection {
    public void theNumberOfOutstandingInvoicesPerCstomer(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT c.customerNo, c.firstName, c.lastName, COUNT(i.invoiceNo) AS number_of_invoices FROM customers as c INNER JOIN invoices as i ON c.customerNo = i.orderNo WHERE i.status = 'open' GROUP BY c.customerNo; ");
            ResultSet rs = stmt.executeQuery();
            System.out.println("CustomerNo   FirstName   LastName   NumberOfInvoices");
            while (rs.next()) {
                //Display values
                System.out.print(rs.getInt("customerNo") + "\t\t\t");
                System.out.print(rs.getString("firstName") + "\t\t\t");
                System.out.print(rs.getString("lastName") + "\t\t\t");
                System.out.println(rs.getInt("number_of_invoices"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void theNumberOfRepairedOrderProcessedAndTheirAG(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT b.bikeNo, b.description, COUNT(o.orderNo) AS number_of_orders, AVG(i.grossAmount) AS average_gross_invoice_amount FROM bicycles as b INNER JOIN orders as o ON b.bikeNo = o.bikeNo INNER JOIN invoices as i ON o.orderNo = i.orderNo GROUP BY b.bikeNo; ");
            ResultSet rs = stmt.executeQuery();
            System.out.println("bikeNo   description   number_of_orders   average_gross_invoice_amount");
            while (rs.next()) {
                //Display values
                System.out.print(rs.getInt("bikeNo") + "\t\t\t");
                System.out.print(rs.getString("description") + "\t\t\t");
                System.out.print(rs.getInt("number_of_orders") + "\t\t\t");
                System.out.println(rs.getDouble("average_gross_invoice_amount") );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void frequencyAndAverageNetEffortPerActivity(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT w.wuNo, w.description, COUNT(i.wuNo) AS frequency, SUM(i.quantity) AS net_effort FROM workUnits as w INNER JOIN items as i ON w.wuNo = i.wuNo GROUP BY w.wuNo;");
            ResultSet rs = stmt.executeQuery();
            System.out.println("WorkUnitNO   description          frequency   \tnet_effort");
            while (rs.next()) {
                //Display values
                System.out.print(rs.getInt("wuNo") + "\t\t\t");
                System.out.print(rs.getString("description") + "\t\t\t");
                System.out.print(rs.getInt("frequency") + "\t\t\t\t");
                System.out.println(rs.getInt("net_effort") + "\t\t\t");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void netSalesInSparePartsSales(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT m.materialNo, m.description, SUM(i.quantity) , m.customerPrice AS net_sales FROM materials as m INNER JOIN items as i ON m.materialNo = i.materialNo GROUP BY m.materialNo;");
            ResultSet rs = stmt.executeQuery();
            System.out.println("materialNo   description   SUM   net_sales");
            while (rs.next()) {
                //Display values
                System.out.print(rs.getInt("materialNo") + "\t\t\t");
                System.out.print(rs.getString("description") + "\t\t\t");
                System.out.print(rs.getInt("SUM") + "\t\t\t");
                System.out.println(rs.getDouble("net_sales") );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void allItemsPerInvoice(){
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("SELECT iv.invoiceNo, i.itemNo, m.description, i.quantity, m.customerPrice, i.quantity * m.customerPrice AS net_price FROM invoices as iv INNER JOIN items as i ON iv.orderNo = i.orderNo LEFT JOIN materials as m ON i.materialNo = m.materialNo ORDER BY iv.invoiceNo, i.itemNo;");
            ResultSet rs = stmt.executeQuery();
            System.out.println("invoiceNo   itemNo   description   quantity   customerPrice   net_price");
            while (rs.next()) {
                //Display values
                System.out.print(rs.getInt("invoiceNo") + "\t\t\t");
                System.out.print(rs.getInt("itemNo") + "\t\t\t");
                System.out.print(rs.getString("description") + "\t\t\t");
                System.out.print(rs.getInt("quantity") + "\t\t\t");
                System.out.print(rs.getDouble("customerPrice") +"\t\t\t");
                System.out.println(rs.getDouble("net_price") );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
