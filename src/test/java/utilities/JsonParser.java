package utilities;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser
{
    private static String regexRemoveSpecialCharacters = "[{\"\\[}\\]]";

    public static ReportNameValues[] parseReportNames(String jsonString)
    {
//        String id = null;
//        String name = null;
//        String modelId = null;
//        String[] jsonArray = jsonString.split(",");
//        ReportNameVal[] jsonReturn = new ReportNameVal[(jsonArray.length+1)/3];
//        String[] currentPair;
//        int counter = 0;
//
//        for (String s : jsonArray) {
//            currentPair = s.replaceAll(regexRemoveSpecialCharacters, "").split(":");
//            switch (currentPair[0]) {
//                case "id" -> id = currentPair[1];
//                case "name" -> name = currentPair[1];
//                case "model_uuid" -> modelId = currentPair[1];
//            }
//
//            if ((id != null) && (name != null) && (modelId != null)) {
//                jsonReturn[counter] = new ReportNameVal(id, name, modelId);
//                modelId = null;
//                name = null;
//                id = null;
//                counter += 1;
//            }
//        }
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



