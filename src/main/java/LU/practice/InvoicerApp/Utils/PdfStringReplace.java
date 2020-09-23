package LU.practice.InvoicerApp.Utils;

import LU.practice.InvoicerApp.model.Invoices.InvoiceData;
import LU.practice.InvoicerApp.model.Invoices.Invoices;

public class PdfStringReplace {
    public  String replaceResourceString(InvoiceData invoiceData) throws Exception {
         String invoiceDetails= Utils.getResourceString("templates/Invoices/index.html")
                        .replace("$payerName$",invoiceData.getPayerName())
                        .replace("$payerEmail$",invoiceData.getPayerEmail())
//                        .replace("$invoiceNo$",invoiceData.getInvoiceNo().toString())
                        .replace("$freeTextOne$",invoiceData.getFreeTextOne())
                        .replace("$freeTextTwo$",invoiceData.getFreeTextTwo())
                        .replace("$productDetails$",getProductDetails(invoiceData))
                        .replace("$footer$",invoiceData.getFooter());
        return invoiceDetails;
    }

    public static String getProductDetails(InvoiceData invoiceData){

        invoiceData.getProducts().size();

        String tableRow = " <tr>\n" +
                "            <td>1</td>\n" +
                "            <td class=\"thead\">Nokia</td>\n" +
                "            <td class=\"thead\">Nishi </td>\n" +
                "            <td class=\"thead\">1</td>\n" +
                "            <td class=\"thead\">2000</td>\n" +
                "            <td class=\"thead\">2000</td>\n" +
                "        </tr>\n";

        return tableRow;
    }
}
