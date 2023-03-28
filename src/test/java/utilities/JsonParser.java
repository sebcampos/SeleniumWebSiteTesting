package utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser
{

    public static ReportNameValues[] parseReportNames(String jsonString)
    {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        return gson.fromJson(jsonString, ReportNameValues[].class);
    }

    public static ReportValues[] parseReport(String jsonString)
    {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        return  gson.fromJson(jsonString, ReportValues[].class);
    }


}



