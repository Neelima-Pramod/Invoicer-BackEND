package LU.practice.InvoicerApp.model.Biller;

import java.io.Serializable;

public class BillerJwtResponse implements Serializable{
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    public BillerJwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
    public String getToken() {
        return this.jwttoken;
    }
}
