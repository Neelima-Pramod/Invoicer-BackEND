package LU.practice.InvoicerApp.model.Invoices;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Invoices")
public class Invoices {

    @Id
    private String id;
    private int invNo;
//    private UnpackInvoice invoice;
    private String createdBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public UnpackInvoice getInvoice() {
//        return invoice;
//    }
//
//    public void setInvoice(UnpackInvoice invoice) {
//        this.invoice = invoice;
//    }

    public int getInvNo() {
        return invNo;
    }

    public void setInvNo(int invNo) {
        this.invNo = invNo;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
