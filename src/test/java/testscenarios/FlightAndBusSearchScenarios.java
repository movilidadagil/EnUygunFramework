package testscenarios;


import api.FlightTicketRequest;
import com.mashape.unirest.http.exceptions.UnirestException;
import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FlightAndBusSearchScenarios {

    static WebDriver driver;
    static Properties properties;
    HomePage homePage;
    FlightTicketRequest flightTicketRequest;

    @BeforeClass
    public void setup(){
          properties = ConfigReader.initialize_Properties();
          driver = DriverSetup.initialize_Driver("chrome");
          homePage = new HomePage(driver);
          flightTicketRequest = new FlightTicketRequest();
    }

    @Test(priority = 1)
    public void searchForKeyword(){
        String keyword = "ada";

        homePage.searchForFlightTicket(keyword);
        System.out.println("test success");

    }
    @Test(priority = 2)
    public void checkListForSearch() throws UnirestException, IOException {
        List<String > flightList = homePage.listForFlightTicketSearchByStream();
        flightTicketRequest.flightTicketFromList();
    }

}
