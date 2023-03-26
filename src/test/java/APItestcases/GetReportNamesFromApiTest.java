package APItestcases;
import base.BaseApiTest;
import org.testng.annotations.Test;
import utilities.JsonParser;
import utilities.ReportNameValues;

import java.io.IOException;



public class GetReportNamesFromApiTest extends BaseApiTest
{

    @Test
    public void getReportNamesInAscendingOrder() throws IOException, InterruptedException
    {
        ReportNameValues[] responseJson = JsonParser.parseReportNames(get(getReportNamesEndpoint("name", "asc")).body());
        for (int i = 0; i < responseJson.length-1; i++)
        {
            assert responseJson[i].getName().charAt(0) < responseJson[i+1].getName().charAt(0);
        }
    }

}
