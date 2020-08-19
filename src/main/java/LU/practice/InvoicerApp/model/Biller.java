package LU.practice.InvoicerApp.model;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Biller")
public class Biller {

    @Id
    private String id;
    private Unpackname name;
    private String email;
    private String phoneNumber;
    private UnpackAdress address;
    private String password;

    public UnpackAdress getAddress() {
        return address;
    }

    public void setAddress(UnpackAdress address) {
        this.address = address;
    }


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
