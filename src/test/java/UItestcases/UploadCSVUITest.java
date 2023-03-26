package UItestcases;

import base.BaseUITest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ReactPage;

public class UploadCSVUITest extends BaseUITest
{

    private void waitForUploadButton()
    {
        waitForElementToBeClickable(ReactPage.uploadButtonXpath);
    }

    private WebElement getUploadButtonInputBox()
    {
        return waitForElementToExist(ReactPage.uploadInputXpath);
    }

    @Test
    public void UploadCSVTestCase()
    {
        waitForUploadButton();
        getUploadButtonInputBox().sendKeys(files[0]);
        assert true;
    }
}
