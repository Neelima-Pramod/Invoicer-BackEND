package LU.practice.InvoicerApp.model.Invoices;

import LU.practice.InvoicerApp.Utils.FilePath;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "Invoices")
public class Invoices {

    @Id
    private String id;
    private  InvoiceData invoiceData;
    private String createdBy;
    private FilePath invoiceFilePath;
    private Instant createdOn;
    private InvoiceStatus status;
    private Integer statusCode;

    public Invoices(InvoiceData invoiceData,String createdBy){
        this.invoiceData = invoiceData;
        this.createdBy=createdBy;
        this.createdOn=Instant.now();
    }

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

    public FilePath getInvoiceFilePath() {
        return invoiceFilePath;
    }

    public void setInvoiceFilePath(FilePath invoiceFilePath) {
        this.invoiceFilePath = invoiceFilePath;
    }

    public InvoiceData getInvoiceData() {
        return invoiceData;
    }

    public void setInvoiceData(InvoiceData invoiceData) {
        this.invoiceData = invoiceData;
    }
}
