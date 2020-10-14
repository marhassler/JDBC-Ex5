package testdb;

import java.sql.*;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static Connection con;
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Test", "root", "1234");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Invoices");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        java.util.Date date2 = new java.util.Date();
        InvoiceDao invoiceDaoSQL = new SQLInvoiceDaoIImpl();
        insertInvoice(date,"bestellung 231",324, (byte) 1);
        invoiceDaoSQL.updateInvoiceSQL(1,date,"bestellung 1 neu",192, (byte) 1);
        deleteInvoice(9,connectDatabase());








        //ArrayList Implementation

        InvoiceDao invoiceDao = new InvoiceDaoArrayListImpl();
        ArrayList<Invoice> liste = invoiceDao.showAllInvoices();
        for (Invoice i : liste) {
            System.out.println(i);
        }
        System.out.println("\n");
        invoiceDao.deleteInvoid(3);
        for (Invoice i : liste) {
            System.out.println(i);
        }
        System.out.println("\n");
        invoiceDao.updateInvoice(1, new Invoice(2, new Date(date2.getTime()), "Beschreibung aktualisiert"));
        for (Invoice i : liste) {
            System.out.println(i);
        }
        System.out.println("\n");
        invoiceDao.insertInvoice(new Invoice(3, new Date(date2.getTime()), "Beschreibung inserted ,mit der id 3"));
        for (Invoice i : liste) {
            System.out.println(i);
        }


    }

}