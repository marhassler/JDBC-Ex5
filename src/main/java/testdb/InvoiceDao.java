package testdb;

import java.util.ArrayList;

public interface InvoiceDao {

    ArrayList<Invoice> showAllInvoices();
    void insertInvoice(Invoice i);
    void deleteInvoid(int i);
    void updateInvoice(int index, Invoice i);

}
