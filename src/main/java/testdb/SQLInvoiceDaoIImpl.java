package testdb;

import java.sql.*;
import java.util.ArrayList;

import static testdb.App.con;

public class SQLInvoiceDaoIImpl implements InvoiceDao {

    @Override
    public ArrayList<Invoice> showAllInvoices() {
        return null;
    }

    @Override
    public void insertInvoice(Invoice i) {

    }

    @Override
    public void deleteInvoid(int i) {

    }

    @Override
    public void updateInvoice(int index, Invoice i){

    }

    @Override
    public void updateInvoiceSQL(int id, Date date, String description, int value, Byte paid) throws SQLException {
        Connection con = App.con;
        PreparedStatement update = con.prepareStatement
                ("UPDATE invoices SET date = ?, description = ?, value = ?, paid = ? WHERE id = ?");
        update.setDate(1, date);
        update.setString(2, description);
        update.setInt(3, value);
        update.setByte(4, paid);
        update.setInt(5, id);

        update.executeUpdate();
    }

    @Override
    public void insertInvoiceSQL(Date date, String description, int value, Byte paid) throws SQLException {
        PreparedStatement insert = con.prepareStatement
                ("insert into invoices  (date, description, value, paid) values(?,?,?,?)");
        insert.setDate(1, date);
        insert.setString(2, description);
        insert.setInt(3, value);
        insert.setByte(4, paid);

        insert.executeUpdate();
    }

    @Override
    public void deleteInvoiceSQL(int id) throws SQLException {
        PreparedStatement update = con.prepareStatement
                ("DELETE FROM invoices WHERE ID = ? ");
        update.setInt(1, id);
        update.executeUpdate();
    }

    @Override
    public void showInvoicesSQL() {
        try{
            Statement stmt=con.createStatement();
            ResultSet rs= ((Statement) stmt).executeQuery("select * from Invoices");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2) + " "+rs.getString(3)+ " "+rs.getInt(4));
        }catch(Exception e){ System.out.println(e);}
    }


}
