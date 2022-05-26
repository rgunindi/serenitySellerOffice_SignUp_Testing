package starter.sellerOffice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class memberOfCeller {
    static final String lexicon = "ABCDEFGHJKLMNOPQRSTUVWXYZ";

    static final java.util.Random rand = new java.util.Random();

    static final Set<String> identifiers = new HashSet<String>();

    public static String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(6)+6;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
}
    static JavascriptExecutor js ;
    public static void PerformScript(WebDriver driver){
        String script="document.getElementById('dialogLoading').remove();";
        js= (JavascriptExecutor) driver;
        js.executeScript(script);
    }
    public static void PerformScriptLater(WebDriver driver) throws InterruptedException {
        String script=   "document.querySelector(\"#categoryGroupDropDown_panel > div > ul > li:nth-child(2)\").click();"+
                         "document.getElementById(\"signingAuthPhoneNumberInputText\").value=\"1453145314\";"+
                         //"document.getElementById(\"communicationsRepPhoneNumberInputText\").click();"+
                         "document.getElementById(\"communicationsRepPhoneNumberInputText\").value=\"1453145314\";";

        js= (JavascriptExecutor) driver;
        js.executeScript(script);
    }
    public static void PerformScriptLater1(WebDriver driver) throws InterruptedException {
        String script=   "document.getElementById(\"officeNumberInputText\").value=\"5559999999\";"+
                         "document.getElementById(\"comMobileNumberInputText\").value=\"5559999999\";"+
                         "document.querySelector(\"#cityDropDown_panel\").click();"+
                         "document.querySelector(\"#cityDropDown_panel > div > ul > li:nth-child(8)\").click();"+
                         "document.querySelector(\"#cityTaxOfficeDropDown_label\").click();";

        js= (JavascriptExecutor) driver;
        js.executeScript(script);
        Thread.sleep(2000);
    }
    public static void PerformScriptLater2(WebDriver driver) throws InterruptedException {

        String script=   "document.querySelector(\"#cityTaxOfficeDropDown_panel > div > ul > li:nth-child(8)\").click();"+
                         "setTimeout(() => {  console.log(\"waitEl!\"); }, 2000);"+
                        "document.querySelector(\"#taxOfficeDropDown_label\").click();"+
                    "document.getElementById(\"communicationsRepPhoneNumberInputText\").value=\"1453145314\";"+
                         "document.querySelector(\"#districtDropDown_panel > div > ul > li:nth-child(3)\").click();";

                 js= (JavascriptExecutor) driver;
                 js.executeScript(script);
                 Thread.sleep(2000);
    }
    public static void PerformScriptLater3(WebDriver driver) throws InterruptedException {

        String script=     "document.querySelector(\"#taxOfficeDropDown_panel > div > ul > li:nth-child(3)\").click();"+
                "setTimeout(() => {  console.log(\"waitEl!\"); }, 2000);"+
                "document.querySelector(\"#bankSelect_label\").click();"+
                "setTimeout(() => {  console.log(\"waitEl!\"); }, 2000);"+
                "document.querySelector(\"#bankSelect_panel > div > ul > li:nth-child(4)\").click();";
                js= (JavascriptExecutor) driver;
                js.executeScript(script);

                Thread.sleep(2000);
    }
    public static void PerformScriptLater4(WebDriver driver) throws InterruptedException {

        String script=    "document.getElementById(\"postalCodeInputText\").value=\"06130\";"+
                         "document.getElementById(\"ibanInputText\").value=\"1168181685864618\";"+
                         "document.getElementById(\"addressInputText\").value=\"Ostim Ankara Aşti\";";
        js= (JavascriptExecutor) driver;
        js.executeScript(script);


    }

    public static String randomTC() {
        String[] TC={
        "65172360000" //1.TRUE
       ,"91549798800" //2.TRUE
       ,"98312006100" //3.TRUE
        };
        int length = rand.nextInt(2);
        return TC[length];
    }
}

