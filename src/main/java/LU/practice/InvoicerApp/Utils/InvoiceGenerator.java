package LU.practice.InvoicerApp.Utils;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import org.htmlcleaner.CleanerProperties;

import java.io.File;
import java.io.IOException;

public class InvoiceGenerator {

    public static CleanerProperties createHtmlCleaner() {

        CleanerProperties cleanerProperties = new CleanerProperties();
        cleanerProperties.setTranslateSpecialEntities(true);
        cleanerProperties.setTransResCharsToNCR(true);
        cleanerProperties.setOmitComments(true);

        return cleanerProperties;
    }

    public static Boolean createFolder(FilePath filePath){
        File file = new File(filePath.getFileUploadDir() + filePath.getSubFolderPath());

        Boolean folderExists=false;

        if(file.exists()){
            folderExists = true;
        }
        else{
            folderExists = file.mkdirs();
        }
        return folderExists;
    }

    public static void createPdf(FilePath filePath) throws IOException, InterruptedException {

        WrapperConfig wrapperConfig = new WrapperConfig(WrapperConfig.findExecutable());
        Pdf pdf = new Pdf(wrapperConfig);
        pdf.addPageFromFile(filePath.fullPath());
        pdf.saveAs(filePath.getFileUploadDir() + filePath.getSubFolderPath()+File.separator+"InvoicePdf.pdf");

    }

}
