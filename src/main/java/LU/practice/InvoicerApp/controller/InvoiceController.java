package LU.practice.InvoicerApp.controller;

import LU.practice.InvoicerApp.configuration.JwtTokenUtil;
import LU.practice.InvoicerApp.model.Biller.Biller;
import LU.practice.InvoicerApp.model.Invoices.Invoices;
import LU.practice.InvoicerApp.repos.BillerRepository;
import LU.practice.InvoicerApp.repos.InvoicesRepository;
import LU.practice.InvoicerApp.service.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                                @RequestHeader (name="Authorization") String token)

    {
        String Username = jwtTokenUtil.getUsernameFromToken(token);
        Biller biller =  billerRepository.findByEmail(Username);
        invoices.setCreatedBy(biller.getId());
        invoices.setCreatedOn(Instant.now());
        if(invoices.getDueDate()!=null)
        {
            invoices.setDueDate(Instant.parse(invoices.getDueDate().toString()));
        }

        return invoicesRepository.save(invoices);
    }



}
