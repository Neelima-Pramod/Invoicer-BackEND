package LU.practice.InvoicerApp.model.Invoices;

import java.time.Instant;
import java.util.ArrayList;

public class InvoiceData {
    private int invoiceNo;
    private String payerName;
    private String payerEmail;
    private String freeTextOne;
    private String freeTextTwo;
    private int total;
    private String footer;
    private ArrayList<InvoiceProduct> products;
    private Instant dueDate;

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getFreeTextOne() {
        return freeTextOne;
    }

    public void setFreeTextOne(String freeTextOne) {
        this.freeTextOne = freeTextOne;
    }

    public String getFreeTextTwo() {
        return freeTextTwo;
    }

    public void setFreeTextTwo(String freeTextTwo) {
        this.freeTextTwo = freeTextTwo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public ArrayList<InvoiceProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<InvoiceProduct> products) {
        this.products = products;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }
}
