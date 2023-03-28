package APItestcases;

import base.BaseApiTest;
import org.testng.annotations.Test;
import utilities.JsonParser;
import utilities.ReportValues;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GetReportFromApiTest extends BaseApiTest
{
    @Test
    public void getFullReportInAscendingOrder() throws IOException, InterruptedException
    {
        ArrayList<ReportValues> report = new ArrayList<>();
        ReportValues[] responseJson;
        String name = "MES_3_17_23";
        int limit = 3000;
        int offset = 0;
        String response = get(getReportsEndpoint(name, String.valueOf(limit), String.valueOf(offset), "r_squared", "asc")).body();
        while (!response.equals("[]"))
        {
            responseJson = JsonParser.parseReport(response);
            report.addAll(Arrays.asList(responseJson));
            offset += limit;
            response = get(getReportsEndpoint(name, String.valueOf(limit), String.valueOf(offset), "r_squared", "asc")).body();
        }
        System.out.println("Report Size: "+report.size());
        for (int i = 0; i < report.size()-1; i++)
        {
            System.out.println(report.get(i).getRSquared()+" "+report.get(i+1).getRSquared());
            assert report.get(i).getRSquared().compareTo(report.get(i+1).getRSquared()) <= 0;
        }
    }
}
