package LU.practice.InvoicerApp.controller;

import LU.practice.InvoicerApp.configuration.JwtTokenUtil;
import LU.practice.InvoicerApp.model.Biller.Biller;
import LU.practice.InvoicerApp.model.Invoices.Invoices;
import LU.practice.InvoicerApp.repos.BillerRepository;
import LU.practice.InvoicerApp.repos.InvoicesRepository;
import LU.practice.InvoicerApp.service.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/api/getInvoiceNo")
    public long getInvoiceNumber(@RequestHeader (name="Authorization") String token)
    {
        String Username = jwtTokenUtil.getUsernameFromToken(token);
        Biller biller =  billerRepository.findByEmail(Username);
        String billerId= biller.getId();
        long billerCount=invoicesRepository.countByCreatedBy(billerId);
        return billerCount+1;
    }

    @PostMapping(value = "/api/invoices")
    public Invoices saveInvoice(@RequestHeader (name="Authorization") String token,
                                @RequestBody Invoices invoices)
    {
        String Username = jwtTokenUtil.getUsernameFromToken(token);
        Biller biller =  billerRepository.findByEmail(Username);
        invoices.setCreatedBy(biller.getId());
        return invoicesRepository.save(invoices);
    }

//    @GetMapping(value = "api/getInvoiceNoo")
//    public int getInvoiceNumber1()
//    {
//        int i=nextSequenceService.getNextSequence("customSequences");
//        System.out.println(i);
//        invoices.setInvNo(nextSequenceService.getNextSequence("customSequences"));
//        return invoicesRepository.save(invoices);

//        int i=nextSequenceService.getNextSequence("customSequences");
//        return i;
//
//
//    }


}
