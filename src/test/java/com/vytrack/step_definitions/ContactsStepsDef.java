package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
//I added this line from Github
//I added from IntelliJ
public class ContactsStepsDef {

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String usertype) {
        String username = "";
        String password = "";
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();


        if (usertype.equalsIgnoreCase("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");

        }else if(usertype.equalsIgnoreCase("sales manager")){
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");

        } else if (usertype.equalsIgnoreCase("store manager")){
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        loginPage.login(username,password);

    }

    @Then("the should see following options")
    public void the_should_see_following_options(List<String> menuOptions) {

        BrowserUtils.waitFor(2);
        //get the list of webelement and convert them to list of string with help of ready method
        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);
//        System.out.println(menuOptions.size());
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
        Assert.assertEquals(menuOptions,actualOptions);

    }
    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userInfo) {
        System.out.println("userInfo = " + userInfo);

        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
        DashboardPage dashboardPage = new DashboardPage();
        BrowserUtils.waitFor(2);
        String actualUserName = dashboardPage.getUserName();
        String expectedUserName = userInfo.get("firstname") + " " + userInfo.get("lastname");

        System.out.println("expectedUserName = " + expectedUserName);
        System.out.println("actualUserName = " + actualUserName);

        Assert.assertEquals(expectedUserName,actualUserName);

    }



}
