package base;

import com.google.gson.JsonArray;
import credentials.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.JsonParser;


import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;

public class BaseApiTest
{
    private HttpClient client;

    final private static String apiEndPoint = "https://35.245.6.193/api";
    final private static String reportsEndpoint = apiEndPoint+"/reports/";
    final private static String reportNamesEndpoint = apiEndPoint+"/report_names/";
    final private static String tasksEndpoint = apiEndPoint+"/tasks";

    private HttpResponse<String> response;

    /**
     * This method taken from
     * `https://stackoverflow.com/questions/52988677/allow-insecure-https-connection-for-java-jdk-11-httpclient`
     * to allow insecure requests
     */
    private static final TrustManager[] trustAllCerts = new TrustManager[] {
        new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] certs, String authType) {
            }
        }
    };
    @BeforeMethod
    public void setUp() throws NoSuchAlgorithmException, KeyManagementException
    {
        // Creating a http client which ignores invalid certs
        final Properties props = System.getProperties();
        props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new SecureRandom());
        client = HttpClient.newBuilder()
                .sslContext(sslContext)
                .build();

    }


    public HttpResponse<String> get(String endpoint) throws IOException, InterruptedException
    {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .setHeader("Authorization", "Token " + User.getToken())
                .setHeader("Accept", "application/json")
                .GET()
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assert response.statusCode() == 200;
        return response;
    }

    public String getReportNamesEndpoint()
    {
        return reportNamesEndpoint;
    }

    public String getReportNamesEndpoint(String orderBy, String sort)
    {
        return reportNamesEndpoint+"?order_by="+orderBy+"&sort="+sort;
    }

    public String getReportsEndpoint()
    {
        return reportsEndpoint;
    }

    public String getReportsEndpoint(String name, String limit, String offset)
    {
        return reportsEndpoint+"?name="+name+"&limit="+limit+"&offset="+offset;
    }





//    private HttpResponse post(String endpoint) throws IOException, InterruptedException
//    {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(endpoint))
//                .POST()
//                .build();
//        return client.send(request, HttpResponse.BodyHandlers.discarding());
//    }

}
