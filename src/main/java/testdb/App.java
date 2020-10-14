package testdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Hello world!
 */
public class App {
    public static Connection con;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        verbindungAufbauen();
        InvoiceDao invoiceDaoSQL = new SQLInvoiceDaoIImpl();
        invoiceDaoSQL.showInvoicesSQL();
        invoiceDaoSQL.insertInvoiceSQL(date,"bestellung 24",424, (byte) 1);
        invoiceDaoSQL.updateInvoiceSQL(20,date,"bestellung 20 neu",122, (byte) 1);
        invoiceDaoSQL.deleteInvoiceSQL(11);
        System.out.println("\n");
        invoiceDaoSQL.showInvoicesSQL();
        System.out.println("\n");
        con.close();









        //ArrayList Implementation
        java.util.Date date2 = new  java.util.Date();
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
    public static void verbindungAufbauen() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbctest", "root", "");
    }

}