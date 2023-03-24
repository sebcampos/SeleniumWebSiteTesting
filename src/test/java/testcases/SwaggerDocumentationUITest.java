package testcases;

import base.BaseUITest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.SwaggerUIPage;

public class SwaggerDocumentationUITest extends BaseUITest
{
    public static WebElement executeGetRequestButton;
    public static WebElement responseCodeElement;
    public static String expectedResponseMessage = "Authentication credentials were not provided";

    @Test
    public void getRequestWithoutAuthenticationTest()
    {
        navigateToSwaggerApiDocumentationPage();
        waitForElementToExist(SwaggerUIPage.reportsEndPointListDropdownXpath).click();
        waitForElementToExist(SwaggerUIPage.tryItOutButtonXpath).click();
        executeGetRequestButton = findByXPath(SwaggerUIPage.executeButtonXpath);
        scrollToElement(executeGetRequestButton);
        executeGetRequestButton.click();
        responseCodeElement = waitForElementToExist(SwaggerUIPage.responseCodeStatusXpath);
        assert responseCodeElement.getText().contains("403");
        assert findByXPath(SwaggerUIPage.responseBodyXpath).getText().contains(expectedResponseMessage);
    }


    @Test
    public void authenticatedGetRequestTest()
    {
        navigateToSwaggerApiDocumentationPage();
        waitForElementToExist(SwaggerUIPage.reportsEndPointListDropdownXpath).click();
        waitForElementToExist(SwaggerUIPage.authorizeButtonXpath).click();
        scrollToElement(waitForElementToExist(SwaggerUIPage.tokenInputBoxXpath));
        System.out.println("foo");
    }
}
