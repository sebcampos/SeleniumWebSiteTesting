package UItestcases;

import base.BaseUITest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ReactPage;

public class FiltersButtonUITest extends BaseUITest
{

    private static WebElement minFreq;
    private static WebElement maxFreq;
    private static WebElement filterButton;

    private static WebElement ascendingButton;
    private static String newMinFreqValue = "20";
    private static String newMaxFreqValue = "25";


    public WebElement getFirstFrequencyInTable() {return waitForElementToExist(ReactPage.frequencyFirstRowValueXpath);}

    @Test
    public void ValidateFiltersButton()
    {
        minFreq = waitForElementVisibility(ReactPage.frequencyMinInputXpath);
        waitForTextToExistInInputElement(ReactPage.frequencyMinInputXpath);
        maxFreq = waitForElementToExist(ReactPage.frequencyMaxInputXpath);
        waitForTextToExistInInputElement(ReactPage.frequencyMaxInputXpath);
        //assert minFreq.getAttribute("value").equals(getFirstFrequencyInTable().getText());
        clearInputElement(minFreq);
        clearInputElement(maxFreq);
        minFreq.sendKeys(newMinFreqValue);
        maxFreq.sendKeys(newMaxFreqValue);
        filterButton = findByXPath(ReactPage.filterButtonXpath);
        scrollToElement(filterButton);
        filterButton.click();
        waitForTextToExistInInputElement(getFirstFrequencyInTable().getText());
        assert newMinFreqValue.equals(getFirstFrequencyInTable().getText());
        ascendingButton = findByXPath(ReactPage.frequencyTableFilterAscendingDescendingButton);
        ascendingButton.click();
        assert newMaxFreqValue.equals(getFirstFrequencyInTable().getText());
    }

}
