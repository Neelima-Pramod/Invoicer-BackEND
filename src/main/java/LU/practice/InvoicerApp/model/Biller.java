package LU.practice.InvoicerApp.model;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testing")
public class Biller {

    @Id
    private String id;
    private Unpackname name;
    private String email;
    private String phoneNumber;

    public UnpackAdress getAddress() {
        return address;
    }

    public void setAddress(UnpackAdress address) {
        this.address = address;
    }

    private UnpackAdress address;

    public Unpackname getName() {
        return name;
    }

    public void setName(Unpackname name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
