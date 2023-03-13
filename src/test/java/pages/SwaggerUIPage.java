package pages;

public class SwaggerUIPage
{
    public static String databaseEndPointListDropdownXpath = "//div[contains(@id, 'operations-database') and contains(@id, 'list')]";
    public static String tryItOutButtonXpath = "//button[contains(@class, 'try-out')]";
    public static String executeButtonXpath = "//button[text()='Execute']";
    public static String responseCodeStatus = "//tr[@class='response']//td[contains(@class, 'response') and contains(@class, 'status')]";
    public static String responseBody = "//tr[@class='response']//code";
}
