package LU.practice.InvoicerApp.model.Invoices;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Invoices")
public class Invoices {

    @Id
    private String id;
//    private  InvoiceData invoiceData;
    private String createdBy;
    private Instant createdOn;
    private InvoiceStatus status;
    private Integer statusCode;
    private String invoiceNo;
    private String payerName;
    private String payerEmail;
    private String freeTextOne;
    private String freeTextTwo;
    private int total;
    private String footer;
    private List products;
    private Instant dueDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
        setStatusCode(status.getStatusCode());
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
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

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }
}
