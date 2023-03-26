package pages;

public class ReactPage {

    public static String uploadButtonXpath = "//button//span[contains(text(), 'Upload CSV')]/..";

    public static String uploadInputXpath = "//input[@id='uploadFile']";
    public static String frequencyMinInputXpath = "//input[@id='minFrequency']";
    public static String frequencyMaxInputXpath = "//input[@id='maxFrequency']";
    public static String frequencyFirstRowValueXpath = "//tbody//tr[contains(@class, 'row-level-0')]//td[4]";
    public static String filterButtonXpath = "//button[@type='submit']//span[contains(text(), 'Filter')]";

    public static String frequencyTableFilterAscendingDescendingButton = "//span[contains(@class, 'column-title') and text()='Frequency']";

}
