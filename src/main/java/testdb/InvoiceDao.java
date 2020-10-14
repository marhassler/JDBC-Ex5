package testdb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public interface InvoiceDao {

    ArrayList<Invoice> showAllInvoices();
    void insertInvoice(Invoice i);
    void deleteInvoid(int i);
    void updateInvoice(int index, Invoice i);
    void updateInvoiceSQL(int id, Date date, String description, int value, Byte paid) throws SQLException;
    void insertInvoiceSQL(Date date, String description, int value, Byte paid) throws SQLException;
    void deleteInvoiceSQL(int id) throws SQLException;
    void showInvoicesSQL();

}
