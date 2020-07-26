package step_definitions.wiki_stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.smartbear_pages.SBLandingPage;
import pages.smartbear_pages.SBLoginPage;
import pages.smartbear_pages.SBOrderPage;
import pages.smartbear_pages.SBViewAllOrdersPage;
import utilities.Driver;

public class aaa {
    //new class under smartbear_stepdefs package
    SBLoginPage sbLoginPage = new SBLoginPage();
    SBLandingPage sbLandingPage = new SBLandingPage();
    SBOrderPage sbOrderPage = new SBOrderPage();
    SBViewAllOrdersPage sbViewAllOrdersPage = new SBViewAllOrdersPage();

// @Given("User is logged into SmartBear Tester account and on Order page")
//    public void user_is_logged_into_SmartBear_Tester_account_and_on_Order_page() {
//
//        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//
//        sbLoginPage.usernameInput.sendKeys("Tester");
//        sbLoginPage.passwordInput.sendKeys("test");
//        sbLoginPage.loginButton.click();
//
//        sbLandingPage.orderLink.click();
//    }


//    @Given("i am on the login page")
//    public void i_am_on_the_login_page() {
//       Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//
//    }
//
//    @When("user {string}with {string}")
//    public void user_with(String string, String string2) {
//        sbLoginPage.usernameInput.sendKeys(string2);
//
//    }
//
//    @When("user{string} with password{string}")
//    public void user_with_password(String string, String string2) {
//        sbLoginPage.passwordInput.sendKeys(string2);
//
//    }
//
//    @When("i click on {string}")
//    public void i_click_on(String string) {
//        sbLoginPage.loginButton.click();
//    }
//
//
//    @Then("I should see heading {string}")
//    public void i_should_see_heading(String expected) {
//        String sucess = Driver.getDriver().findElement(By.xpath("//h2")).getText();
//        String actual = Driver.getDriver().findElement(By.id("ctl00_MainContent_status")).getText();
//        Assert.assertTrue(actual.equals(expected));
//
//
//    }
//    @When("user {string}with {string} user{string} with password{string}")
//    public void user_with_user_with_password(String string, String string2, String string3, String string4) {
//
//    }
//    @When("user enter user name  {string}  and password{string}")
//    public void user_enter_user_name_and_password(String userName, String password) {
//
//
//    }

    @Given("home page")
    public void home_page() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
//
//        sbLoginPage.usernameInput.sendKeys("Tester");
//        sbLoginPage.passwordInput.sendKeys("test");
//        sbLoginPage.loginButton.click();
//
//        sbLandingPage.orderLink.click();

    }

    @When("user enter user name  {string}  and password{string}")
    public void user_enter_user_name_and_password(String userName, String password) {
        sbLoginPage.usernameInput.sendKeys(userName);
        sbLoginPage.passwordInput.sendKeys(password);


    }
    @When("i click on login button")
    public void i_click_on_login_button() {
        sbLoginPage.loginButton.click();
    }




//    @Then("use should see messege or heading{string}")
//    public void use_should_see_messege_or_heading(String string) {
//        String actualSuccess = Driver.getDriver().getCurrentUrl();
//
//        //String expectedSucess = "List of All Orders";
//        Assert.assertEquals("Web Orders",actualSuccess);
//
//        String actual = Driver.getDriver().findElement(By.id("ctl00_MainContent_status")).getText();
//        Assert.assertEquals(actual,"/Invalid Login or Password.\n" +
//                "\n");
//    }

    @Then("verify types of tests {string}")
    public void verify_types_of_tests(String test) {
       if (test.equals("positive")){
           Assert.assertEquals(Driver.getDriver().getTitle(),"Web Orders");
       }else if (test.equals("negative")){
           Assert.assertEquals(Driver.getDriver().getTitle(),"Web Orders Login");
       }

    }










}
