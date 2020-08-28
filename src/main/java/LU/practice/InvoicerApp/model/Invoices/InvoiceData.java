package LU.practice.InvoicerApp.model.Invoices;

import java.util.List;

public class InvoiceData {
    private int invNo;
    private String payerName;
    private String payerEmail;
    private String freeTextOne;
    private String freeTextTwo;
    private int total;
    private String invoiceFooter;
    private List  products;
    private String dueDate;

    public int getInvNo() {
        return invNo;
    }

    public void setInvNo(int invNo) {
        this.invNo = invNo;
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

    public String getInvoiceFooter() {
        return invoiceFooter;
    }

    public void setInvoiceFooter(String invoiceFooter) {
        this.invoiceFooter = invoiceFooter;
    }

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
