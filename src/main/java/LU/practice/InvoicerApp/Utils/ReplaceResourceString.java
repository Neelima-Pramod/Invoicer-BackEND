package LU.practice.InvoicerApp.Utils;

import LU.practice.InvoicerApp.model.Invoices.Invoices;

public class ReplaceResourceString {
    public static void replaceResourceString(String invoiceDetails,Invoices invoice){
        invoiceDetails.replace("$payerName$",invoice.getPayerName())
                        .replace("$payerEmail$",invoice.getPayerEmail())
                        .replace("$invoiceNo$",invoice.getInvoiceNo())
                        .replace("$freeTextOne$",invoice.getFreeTextOne())
                        .replace("$freeTextTwo$",invoice.getFreeTextTwo())
                        .replace("$footer$",invoice.getFooter());
    }
}
