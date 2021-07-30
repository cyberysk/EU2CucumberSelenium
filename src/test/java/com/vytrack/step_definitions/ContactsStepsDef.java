package com.vytrack.step_definitions;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Statement;
import java.util.List;
import java.util.Map;

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

    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {

        BrowserUtils.waitFor(2);
        new ContactsPage().getContactEmail(email).click();

    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
        //get actual data from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.contactFullName();
        String actualPhone = contactInfoPage.phone();
        String actualEmail = contactInfoPage.email();

        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);
        System.out.println("actualFullname = " + actualFullname);

        //get expected data from database

/* This is my solution
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap("select first_name,last_name, e.email, phone\n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id = e.owner_id join orocrm_contact_phone p\n" +
                "on c.id = p.owner_id");

        String expectedFullname = "";
        String expectedPhone = "";
        String expectedEmail= "";
        for (Map<String, Object> row: queryResultMap) {
            if (row.get("first_name").equals("Mariam")){
                expectedFullname = (String) row.get("first_name") + " " + (String) row.get("last_name");
                expectedEmail = (String) row.get("email");
                expectedPhone = (String) row.get("phone");
                break;
            }
        }
        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);
        System.out.println("expectedFullname = " + expectedFullname);

        Assert.assertEquals(expectedFullname,actualFullname);
        Assert.assertEquals(expectedPhone,actualPhone);
        Assert.assertEquals(expectedEmail,actualEmail);

 */
   // This is Jamal's solution
        String myQuery = "select concat (first_name, ' ' ,last_name) as fullname, e.email, phone\n" +
                    "from orocrm_contact c JOIN orocrm_contact_email e\n" +
                    "ON c.id = e.owner_id JOIN orocrm_contact_phone p\n" +
                    "on e.owner_id = p.owner_id\n" +
                    "WHERE e.email='mbrackstone9@example.com'";

        Map<String, Object> rowMap = DBUtils.getRowMap(myQuery);

        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);
        System.out.println("expectedFullname = " + expectedFullname);


        //Compare UI to Database

        Assert.assertEquals(expectedFullname,actualFullname);
        Assert.assertEquals(expectedPhone,actualPhone);
        Assert.assertEquals(expectedEmail,actualEmail);

    }


    @Then("the information {string} should be same with database")
    public void the_information_should_be_same_with_database(String email) {
        //get information from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullname = contactInfoPage.contactFullName();
        String actualPhone = contactInfoPage.phone();
        String actualEmail = contactInfoPage.email();

        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);
        System.out.println("actualFullname = " + actualFullname);

        //get expected data from database

        String myQuery = "select concat (first_name, ' ' ,last_name) as fullname, e.email, phone\n" +
                "from orocrm_contact c JOIN orocrm_contact_email e\n" +
                "ON c.id = e.owner_id JOIN orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "WHERE e.email='"+ email + "'";

        Map<String, Object> rowMap = DBUtils.getRowMap(myQuery);

        String expectedFullname = (String) rowMap.get("fullname");
        String expectedEmail = (String) rowMap.get("email");
        String expectedPhone = (String) rowMap.get("phone");

        System.out.println("expectedEmail = " + expectedEmail);
        System.out.println("expectedPhone = " + expectedPhone);
        System.out.println("expectedFullname = " + expectedFullname);


        //Compare UI to Database

        Assert.assertEquals(expectedFullname,actualFullname);
        Assert.assertEquals(expectedPhone,actualPhone);
        Assert.assertEquals(expectedEmail,actualEmail);

    }

}
