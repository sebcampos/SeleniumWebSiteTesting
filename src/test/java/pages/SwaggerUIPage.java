package pages;

public class SwaggerUIPage
{
    public static String reportsEndPointListDropdownXpath = "//div[@id='operations-api-api_reports_list']";
    public static String tryItOutButtonXpath = "//button[contains(@class, 'try-out')]";
    public static String executeButtonXpath = "//button[text()='Execute']";
    public static String responseCodeStatusXpath = "//tr[@class='response']//td[contains(@class, 'response') and contains(@class, 'status')]";
    public static String responseBodyXpath = "//tr[@class='response']//code";

    public static String authorizeButtonXpath = "//button[@class='btn authorize unlocked']";

    public static String tokenInputBoxXpath = "//div[@class='auth-container']//h4//code[contains(text(), 'token')]/../..//input";
}
