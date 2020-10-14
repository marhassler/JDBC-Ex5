package testdb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDaoArrayListImpl implements  InvoiceDao{

    ArrayList<Invoice> invoices;

    public InvoiceDaoArrayListImpl()
    {
        this.invoices = new ArrayList<>();
        java.util.Date date2 = new  java.util.Date();
        this.invoices.add(new Invoice(1, new Date(date2.getTime()),"Beschreibung"));
        this.invoices.add(new Invoice(2, new Date(date2.getTime()),"Beschreibung"));
        this.invoices.add(new Invoice(3, new Date(date2.getTime()),"Beschreibung"));
    }

    @Override
    public ArrayList<Invoice> showAllInvoices() {
        return this.invoices;
    }

    @Override
    public void insertInvoice(Invoice i) {
        if(i!=null) {
            this.invoices.add(i);
        }
    }

    @Override
    public void deleteInvoid(int i) {
        for(Invoice i2 : this.invoices)
        {
            if(i2.getId()==i)
            {
                this.invoices.remove(i2);
                return;
            }
        }
    }

    @Override
    public void updateInvoice(int index,Invoice i)
    {
        this.invoices.set(index,i);
    }

    @Override
    public void updateInvoiceSQL(int id, Date date, String description, int value, Byte paid) throws SQLException {

    }

    @Override
    public void insertInvoiceSQL(Date date, String description, int value, Byte paid) throws SQLException {

    }

    @Override
    public void deleteInvoiceSQL(int id) throws SQLException {

    }

    @Override
    public void showInvoicesSQL() {

    }


}
