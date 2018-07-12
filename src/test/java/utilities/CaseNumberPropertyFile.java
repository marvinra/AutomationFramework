package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CaseNumberPropertyFile  {

    Properties prop = new Properties();

    public CaseNumberPropertyFile() {
        InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("cases.properties");
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getBkCaseNumber() {return prop.getProperty("case_number");}


}
