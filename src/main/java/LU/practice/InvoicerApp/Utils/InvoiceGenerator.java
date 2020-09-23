package LU.practice.InvoicerApp.Utils;

import LU.practice.InvoicerApp.Utils.Enums.FileTypes;
import LU.practice.InvoicerApp.model.Invoices.InvoiceData;
import LU.practice.InvoicerApp.model.Invoices.Invoices;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

public class InvoiceGenerator {

    private  Invoices invoice;
    private InvoiceData invoiceData;
    private    FilePath tempHTMLFilePath;
    private FilePath invoiceFilePath;

    public InvoiceGenerator(Invoices invoice, InvoiceData invoiceData){
        this.invoice=invoice;
        this.invoiceData = invoiceData;
        this.tempHTMLFilePath = new FilePath(invoice.getCreatedBy(),FileTypes.HTML);
        this.invoiceFilePath = new FilePath(invoice.getCreatedBy(),FileTypes.PDF);
    }

    public FilePath getTempHTMLFilePath() {
        return tempHTMLFilePath;
    }

    public FilePath getInvoiceFilePath() {
        return invoiceFilePath;
    }

    public  void generatePdf() throws Exception {

        PdfStringReplace pdfStringReplace = new PdfStringReplace();
        String invoiceDetails= pdfStringReplace.replaceResourceString(invoiceData);

        TagNode tagNode = new HtmlCleaner(createHtmlCleaner()).clean(invoiceDetails);

        PrettyXmlSerializer xmlSerializer = new PrettyXmlSerializer(createHtmlCleaner());

        FilePath tempFilePath = new FilePath(invoice.getCreatedBy(), FileTypes.HTML);

        if(createFolder(tempFilePath)) {
            xmlSerializer.writeToFile(
                    tagNode, tempFilePath.fullPath(), StandardCharsets.UTF_8.name()
            );
        }

        createPdf(tempFilePath);
    }

    public  CleanerProperties createHtmlCleaner() {

        CleanerProperties cleanerProperties = new CleanerProperties();
        cleanerProperties.setTranslateSpecialEntities(true);
        cleanerProperties.setTransResCharsToNCR(true);
        cleanerProperties.setOmitComments(true);

        return cleanerProperties;
    }

    public  Boolean createFolder(FilePath tempFilePath){
        File file = new File(tempFilePath.getFileUploadDir() + tempFilePath.getSubFolderPath());

        Boolean folderExists=false;

        if(file.exists()){
            folderExists = true;
        }
        else{
            folderExists = file.mkdirs();
        }
        return folderExists;
    }

    public  void createPdf(FilePath tempFilePath) throws IOException, InterruptedException {

        WrapperConfig wrapperConfig = new WrapperConfig(WrapperConfig.findExecutable());
        Pdf pdf = new Pdf(wrapperConfig);
        pdf.addPageFromFile(tempFilePath.fullPath());
        FilePath invoiceFilePath = new FilePath(invoice.getCreatedBy(), FileTypes.PDF);

        pdf.saveAs(invoiceFilePath.fullPath());

//        if(createFolder(invoiceFilePath)){
//
//        }

    }

}
