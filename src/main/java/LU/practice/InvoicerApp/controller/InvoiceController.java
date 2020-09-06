package LU.practice.InvoicerApp.controller;

import LU.practice.InvoicerApp.Utils.CreateHtmlCleaner;
import LU.practice.InvoicerApp.Utils.Enums.FileTypes;
import LU.practice.InvoicerApp.Utils.FilePath;
import LU.practice.InvoicerApp.Utils.Utils;
import LU.practice.InvoicerApp.configuration.JwtTokenUtil;
import LU.practice.InvoicerApp.model.Biller.Biller;
import LU.practice.InvoicerApp.model.Invoices.InvoiceStatus;
import LU.practice.InvoicerApp.model.Invoices.Invoices;
import LU.practice.InvoicerApp.repos.BillerRepository;
import LU.practice.InvoicerApp.repos.InvoicesRepository;
import LU.practice.InvoicerApp.service.NextSequenceService;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.PrettyXmlSerializer;
import org.htmlcleaner.TagNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

@CrossOrigin
@RestController
public class InvoiceController {

    @Autowired
    private InvoicesRepository invoicesRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private BillerRepository billerRepository;
    @Autowired
    private NextSequenceService nextSequenceService;
//    @Autowired
//    private CreateHtmlCleaner htmlCleaner;

    @GetMapping(value ="api/test")
    public void testGeneratePDF(Invoices invoice) throws Exception {
        String invoiceDetails= Utils.getResourceString("templates/Invoices/index.html")
                .replace("$payerName$",invoice.getPayerName())
                .replace("$payerEmail$",invoice.getPayerEmail())
                .replace("$invoiceNo$",invoice.getInvoiceNo())
                .replace("$freeTextOne$",invoice.getFreeTextOne())
                .replace("$freeTextTwo$",invoice.getFreeTextTwo())
                .replace("$footer$",invoice.getFooter());

        TagNode tagNode = new HtmlCleaner(CreateHtmlCleaner.createHtmlCleaner()).clean(invoiceDetails);
        PrettyXmlSerializer xmlSerializer = new PrettyXmlSerializer(CreateHtmlCleaner.createHtmlCleaner());

        FilePath filePath = new FilePath("temp", FileTypes.HTML);

        File file = new File(filePath.getFileUploadDir() + filePath.getSubFolderPath());

        Boolean folderExists=false;

        if(file.exists()){
            folderExists = true;
        }
        else{
            folderExists = file.mkdirs();
        }
        if(folderExists) {
            xmlSerializer.writeToFile(
                    tagNode, filePath.fullPath(), StandardCharsets.UTF_8.name()
            );
        }
        WrapperConfig wrapperConfig = new WrapperConfig(WrapperConfig.findExecutable());
        Pdf pdf = new Pdf(wrapperConfig);
        pdf.addPageFromFile(filePath.fullPath());
        pdf.saveAs("/home/neelima/FileUploads/InvoicePdf.pdf");
    }

    @GetMapping(value = "/api/getInvoiceNo")
    public long getInvoiceNumber(@RequestHeader (name="Authorization") String token)
    {
        String Username = jwtTokenUtil.getUsernameFromToken(token);
        Biller biller =  billerRepository.findByEmail(Username);
        String billerId= biller.getId();
        long billerCount=invoicesRepository.countByCreatedBy(billerId);
        return billerCount+1;
    }

    @GetMapping(value = "/api/invoice/{id}")
    public Invoices getOne(@PathVariable String id)
    {
        return invoicesRepository.findById(id).get();
    }

    @PostMapping(value = "/api/invoices")
    public Invoices saveInvoice(@RequestBody Invoices invoices,
                                @RequestHeader (name="Authorization") String token) throws Exception {
        String Username = jwtTokenUtil.getUsernameFromToken(token);
        Biller biller =  billerRepository.findByEmail(Username);
        invoices.setCreatedBy(biller.getId());
        invoices.setCreatedOn(Instant.now());
        invoices.setStatus(InvoiceStatus.DATA_SAVED);
        if(invoices.getDueDate()!=null)
        {
            invoices.setDueDate(Instant.parse(invoices.getDueDate().toString()));
        }
        testGeneratePDF(invoices);
        return invoicesRepository.save(invoices);
    }



}
