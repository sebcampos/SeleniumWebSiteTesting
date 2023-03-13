package testcases;

import base.BaseUITest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ReactPage;

public class FiltersButtonUITest extends BaseUITest
{

    public static WebElement minFreq;
    public static WebElement maxFreq;
    public static WebElement filterButton;

    public static WebElement ascendingButton;
    public static String newMinFreqValue = "20";
    public static String newMaxFreqValue = "25";


    public WebElement getFirstFrequencyInTable() {return findByXPath(ReactPage.frequencyFirstRowValueXpath);}

    @Test
    public void ValidateFiltersButton()
    {
        minFreq = waitForElementVisibility(ReactPage.frequencyMinInputXpath);
        waitForTextToExistInInputElement(ReactPage.frequencyMinInputXpath);
        maxFreq = findByXPath(ReactPage.frequencyMaxInputXpath);
        //assert minFreq.getAttribute("value").equals(getFirstFrequencyInTable().getText());
        clearInputElement(minFreq);
        clearInputElement(maxFreq);
        minFreq.sendKeys(newMinFreqValue);
        maxFreq.sendKeys(newMaxFreqValue);
        filterButton = findByXPath(ReactPage.filterButtonXpath);
        scrollToElement(filterButton);
        filterButton.click();
        assert newMinFreqValue.equals(getFirstFrequencyInTable().getText());
        ascendingButton = findByXPath(ReactPage.frequencyTableFilterAscendingDescendingButton);
        ascendingButton.click();
        assert newMaxFreqValue.equals(getFirstFrequencyInTable().getText());
    }

}
