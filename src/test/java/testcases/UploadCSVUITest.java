package testcases;

import base.BaseUITest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ReactPage;

public class UploadCSVUITest extends BaseUITest
{
    @Test
    public void UploadCSVTestCase()
    {
        WebElement uploadCSVButton =  waitForElementToExist(ReactPage.uploadButtonXpath);
        uploadCSVButton.sendKeys(files[0]);
    }
}
