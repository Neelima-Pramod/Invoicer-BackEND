package LU.practice.InvoicerApp.Utils;

import LU.practice.InvoicerApp.InvoicerAppApplication;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static InputStream getResource(String fileName) throws Exception{
        try{
            return InvoicerAppApplication.class.getResourceAsStream(File.separator+fileName);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public static String getResourceString(String fileName) throws Exception{
        return IOUtils.toString(getResource(fileName), StandardCharsets.UTF_8.name());
    }
}
