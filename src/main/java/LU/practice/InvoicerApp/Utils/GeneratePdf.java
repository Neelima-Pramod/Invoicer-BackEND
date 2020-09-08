package LU.practice.InvoicerApp.Utils;

import LU.practice.InvoicerApp.Utils.Enums.FileTypes;
import LU.practice.InvoicerApp.model.Invoices.Invoices;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;

import java.nio.charset.StandardCharsets;

public class GeneratePdf {

    public static void generatePdf(Invoices invoice) throws Exception {
        String invoiceDetails= Utils.getResourceString("templates/Invoices/index.html");

        ReplaceResourceString.replaceResourceString(invoiceDetails,invoice);

        TagNode tagNode = new HtmlCleaner(InvoiceGenerator.createHtmlCleaner()).clean(invoiceDetails);

        PrettyXmlSerializer xmlSerializer = new PrettyXmlSerializer(InvoiceGenerator.createHtmlCleaner());

        FilePath filePath = new FilePath(invoice.getCreatedBy(), FileTypes.HTML);

        if(InvoiceGenerator.createFolder(filePath)) {
            xmlSerializer.writeToFile(
                    tagNode, filePath.fullPath(), StandardCharsets.UTF_8.name()
            );
        }
        InvoiceGenerator.createPdf(filePath);
    }

}
