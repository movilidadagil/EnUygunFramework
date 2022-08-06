package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    //WebDriver setups
    WebDriver driver;
    WebDriverWait wait;
    Helper elementHelper;
    By fromForFlightSearch= By.id("react-autowhatever-OriginInput");
    By fromListForFlightSearch=By.xpath("//*/ul[@role='listbox']/li");

    //login page constructor
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,10);
        this.elementHelper=new Helper(driver);
    }

    public void searchForFlightTicket(String kw){
        this.elementHelper
                .findElement(fromForFlightSearch).sendKeys(kw);
    }

    public List<String> listForFlightTicketSearchByStream(){
      return  this
                .elementHelper
                .findElements(fromListForFlightSearch)
                .stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public List<String> listForFlightTicketSearch(){

       List<String> webElementText = new ArrayList<>();
       List<WebElement> webElementList = this
               .elementHelper
               .findElements(fromListForFlightSearch);
       for(int i=0;i<webElementList.size();i++){
           webElementText.add(webElementList.get(i).getText());
       }
       return webElementText;

    }


}