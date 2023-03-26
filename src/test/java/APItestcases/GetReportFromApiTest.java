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
    public void getReport() throws IOException, InterruptedException
    {
        ArrayList<ReportValues> report = new ArrayList<>();
        ReportValues[] responseJson;
        String name = "MES_3_17_23";
        int limit = 40000;
        int offset = 0;
        String response = get(getReportsEndpoint(name, String.valueOf(limit), String.valueOf(offset))).body();
        while (!response.equals("[]"))
        {
            responseJson = JsonParser.parseReport(response);
            report.addAll(Arrays.asList(responseJson));
            offset += limit;
            response = get(getReportsEndpoint(name, String.valueOf(limit), String.valueOf(offset))).body();
        }
        System.out.println("Report Size: "+report.size());
    }
}
