package UItestcases;

import base.BaseUITest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import credentials.User;
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
        tokenAuthenticate();
        waitForElementToExist(SwaggerUIPage.reportsEndPointListDropdownXpath).click();
        waitForElementToExist(SwaggerUIPage.tryItOutButtonXpath).click();
        executeGetRequestButton = findByXPath(SwaggerUIPage.executeButtonXpath);
        scrollToElement(executeGetRequestButton);
        executeGetRequestButton.click();
        responseCodeElement = waitForElementToExist(SwaggerUIPage.responseCodeStatusXpath);
        assert responseCodeElement.getText().contains("200");
    }

    private void tokenAuthenticate()
    {
        waitForElementToExist(SwaggerUIPage.authorizeButtonXpath).click();
        WebElement tokenAuthInput = waitForElementToExist(SwaggerUIPage.tokenInputBoxXpath);
        scrollToElement(tokenAuthInput);
        tokenAuthInput.sendKeys("Token "+ User.getToken());
        waitForElementToExist(SwaggerUIPage.tokenAuthorizeBtnXpath).click();
        waitForElementToExist(SwaggerUIPage.closeAuthorizationModalBtnXpath).click();
    }
}
