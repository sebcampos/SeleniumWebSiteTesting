package APItestcases;

import base.BaseApiTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class InvalidCredentialsTest extends BaseApiTest
{

    @Test
    public void invalidCredentialsGet() throws IOException, InterruptedException
    {
        getWithoutToken(getReportNamesEndpoint());
    }

}
