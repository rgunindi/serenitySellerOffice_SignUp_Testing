package starter.sellerOffice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Task.where;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;

public class sOfficeStepDefination {
    @Managed
    static
    WebDriver driver;
    @Given("{actor} open the login page")
    public void openTheLoginPage(Actor actor) {
        actor.can(BrowseTheWeb.with(driver));
        actor.wasAbleTo(navigateTo.theN11HomePage());
    }

    @And("{actor} Click The Signup Page")
    public void ClickTheSignupPage(Actor actor) {
        actor.attemptsTo(navigateTo.gotoSignupPage());
    }

    @When("{actor} user must signed in selleroffice with valid credentials")
    public void userMustSignedInSellerofficeWithValidCredentials(Actor actor) {
        actor.attemptsTo(registrationPage.registerNow());
    }

    @And("{actor} filled the extensions of the registration page")
    public void FilledTheExtensionsOfTheRegistrationPage(Actor actor) throws InterruptedException {
        actor.attemptsTo(registrationExPage.registerNow());
        actor.attemptsTo(
                //memberOfCeller.PerformScript(driver);
               registrationExPage.registerNowgoOn()
        );
    }

    @Then("{actor} user signed in selleroffice successfully")
    public void userSignedInSellerofficeSuccessfully(Actor actor) throws InterruptedException {
    actor.attemptsTo(navigateTo.gotoSignup());
    Thread.sleep(5000);
        actor.attemptsTo(
                Ensure.that(Locators.IBANMESSAGE).textContent().isEqualTo(("IBAN geçerli değil, lütfen kontrol edin."))
        );
    }

    public static class navigateTo{

        public static Performable theN11HomePage(){
            return where("Open The n11CellerOfice Home Page ",
            Open.browserOn().the(n11CellerOficeHomePage.class));
        }

        public static Performable gotoSignupPage() {
            return where("GoTo SignUp Page",
            Click.on("//*[@id=\"registerNow\"]"));
        }
        public static Performable gotoSignup()  {
            return where("Click SignUp ",
            Click.on(By.className("buttonLeft")));
        }
    }
    @DefaultUrl("https://so.n11.com/")
    public  class n11CellerOficeHomePage extends PageObject {}
    public static class registrationExPage {
        static String TcNo = memberOfCeller.randomTC();
        static String Iban="12312312312312312213";
        public static Performable registerNow() {
            return where("Register the n11CellerOficeExtensionPage",
                    new net.serenitybdd.screenplay.actions.EnterValue[]{
                            Enter.theValue("Battal Gazi")
                                    .into(Locators.INDIVIDUALNAME)
                                    .thenHit(Keys.TAB),
                            Enter.theValue("KÖROĞLU")
                                    .into(Locators.INDIVIDUALLASTNAME),
                            Enter.theValue(TcNo)
                                    .into(Locators.TC),
                            Enter.theValue("Alparslan")
                                    .into(Locators.signingAuthNameInputText),
                            Enter.theValue("MALAZGİRT")
                                    .into(Locators.signingAuthLastnameInputText),
                            Enter.theValue("SULTAN")
                                    .into(Locators.signingAuthTitleInputText).thenHit(Keys.TAB).thenHit(Keys.SPACE),
                            Enter.theValue("1453145314")
                                    .into(Locators.signingAuthPhoneNumberInputText),

                            Enter.theValue("Nizâmülmülk")
                                    .into(Locators.communicationsRepNameInputText),
                            Enter.theValue("Tâcülmülk")
                                    .into(Locators.communicationsRepLastnameInputText),
                            Enter.theValue("VEZİRİ AZAM")
                                    .into(Locators.communicationsRepTitleInputText),
                            Enter.theValue("1071107110")
                                    .into(Locators.communicationsRepPhoneNumberInputText)

                    });
        }

        public static Performable registerNowgoOn() throws InterruptedException {
            memberOfCeller.PerformScriptLater(driver);
            memberOfCeller.PerformScriptLater1(driver);
            memberOfCeller.PerformScriptLater2(driver);
            memberOfCeller.PerformScriptLater3(driver);
            memberOfCeller.PerformScriptLater4(driver);
            return where("Register the n11CellerOficeExtensionPageGgoOn",
                   Click.on(Locators.dropdownCategory));
        }
    }
    public static class registrationPage{
        static String member=memberOfCeller.randomIdentifier();
        static String email=(member+"@sharklasers.com").toLowerCase();
        static String password=memberOfCeller.randomIdentifier();

        public static Performable registerNow(){
            memberOfCeller.PerformScript(driver);
            return where("Register the n11CellerOfice Member",

                    new net.serenitybdd.screenplay.actions.EnterValue[]{
                            Enter.theValue(member)
                            .into(Locators.USERNAME)
                            .thenHit(Keys.TAB),
                            Enter.theValue(password)
                            .into(Locators.PASSWORD)
                            .thenHit(Keys.TAB),
                            Enter.theValue(password)
                            .into(Locators.PASSWORD_RETYP)
                            .thenHit(Keys.TAB),
                             Enter.theValue(email)
                            .into(Locators.EMAIL)
                            .thenHit(Keys.TAB),
                            Enter.theValue(email)
                            .into(Locators.EMAIL_RETYP)
                            .thenHit(Keys.TAB),
                            Enter.theValue(member)
                            .into(Locators.NICKNAME)
                                    .thenHit(Keys.TAB).thenHit(Keys.SPACE)
                                    .thenHit(Keys.TAB).thenHit(Keys.SPACE)
            });
        }
    }
        public static class Locators{
        public static Target USERNAME = Target.the("UserName").locatedBy("//*[@id=\"usernameInputText\"]");
        public static Target PASSWORD = Target.the("Password").locatedBy("//*[@id=\"passwordInputText\"]");
        public static Target PASSWORD_RETYP = Target.the("PasswordReType").locatedBy("//*[@id=\"passwordRetypeInputText\"]");
        public static Target EMAIL = Target.the("email").locatedBy("//*[@id=\"emailInputText\"]");
        public static Target EMAIL_RETYP = Target.the("emailReType").locatedBy("//*[@id=\"emailRetypeInputText\"]");
        public static Target NICKNAME = Target.the("nickName").locatedBy("//*[@id=\"nicknameInputText\"]");
        public static Target MEMBERSHIP_rdnBtn=Target.the("nickName").locatedBy("//*[@id=\"membershipTypeRadio\"]/tbody/tr/td[1]/div/div[2]/span");

        //authored sign.
        public static Target INDIVIDUALNAME = Target.the("nickName").locatedBy("//*[@id=\"individualNameText\"]");
        public static Target INDIVIDUALLASTNAME = Target.the("nickName").locatedBy("//*[@id=\"individualLastNameText\"]");
        public static Target TC = Target.the("nickName").locatedBy("//*[@id=\"tcnoInputText\"]");
        public static Target signingAuthNameInputText = Target.the("nickName").locatedBy("//*[@id=\"signingAuthNameInputText\"]");
        public static Target signingAuthLastnameInputText = Target.the("nickName").locatedBy("//*[@id=\"signingAuthLastnameInputText\"]");
        public static Target signingAuthTitleInputText = Target.the("nickName").locatedBy("//*[@id=\"signingAuthTitleInputText\"]");
        public static Target signingAuthPhoneNumberInputText = Target.the("nickName").locatedBy("//*[@id=\"signingAuthPhoneNumberInputText\"]");

        //'communication officer'
        public static Target communicationsRepNameInputText = Target.the("nickName").locatedBy("//*[@id=\"communicationsRepNameInputText\"]");
        public static Target communicationsRepLastnameInputText = Target.the("nickName").locatedBy("//*[@id=\"communicationsRepLastnameInputText\"]");
        public static Target communicationsRepTitleInputText = Target.the("nickName").locatedBy("//*[@id=\"communicationsRepTitleInputText\"]");
        public static Target communicationsRepPhoneNumberInputText = Target.the("nickName").locatedBy("//*[@id=\"communicationsRepPhoneNumberInputText\"]");


        public static Target postalCodeNumber = Target.the("postalCodeNumber").locatedBy(("//*[@id=\"postalCodeNumber\"]"));
        public static Target addressInputText = Target.the("addressInputText").locatedBy(("//*[@id=\"addressInputText\"]"));
        public static Target ibanInputText = Target.the("addressInputText").locatedBy(("//*[@id=\"ibanInputText\"]"));

            //DropDownListSelected document.querySelector("#categoryGroupDropDown_panel > div > ul > li:nth-child(2)").click()
            public static Target dropdownCategory=
                Target.the("categoryDropdown").locatedBy("#businessCategoryDropDown_data > tr:nth-child(1) > td.ui-selection-column > div > div > div.ui-radiobutton-box.ui-widget.ui-corner-all.ui-radiobutton-relative.ui-state-default");
            public static Target dropdownCategory1 = Target.the("categoryDropdown").locatedBy("#categoryGroupDropDown_panel");
            public static Target businesCategoryDropdown = Target.the("BusinesCategory").locatedBy(("//*[@id=\"businessCategoryDropDown_data\"]"));
        //End
        public static final Target IBANMESSAGE =  Target.the("IBAN geçerli değil").locatedBy("#ibanMessage.children[1].innerText");
    }

}
