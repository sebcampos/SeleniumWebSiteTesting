package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile
{
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/test/configfiles/config.properties");
        Properties p = new Properties();
        p.load(fr);
    }
}
