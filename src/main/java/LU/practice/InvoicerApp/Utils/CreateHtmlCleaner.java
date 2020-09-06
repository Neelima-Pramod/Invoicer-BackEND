package LU.practice.InvoicerApp.Utils;

import org.htmlcleaner.CleanerProperties;

public class CreateHtmlCleaner {

    public static CleanerProperties createHtmlCleaner() {

        CleanerProperties cleanerProperties = new CleanerProperties();
        cleanerProperties.setTranslateSpecialEntities(true);
        cleanerProperties.setTransResCharsToNCR(true);
        cleanerProperties.setOmitComments(true);

        return cleanerProperties;
    }

}
