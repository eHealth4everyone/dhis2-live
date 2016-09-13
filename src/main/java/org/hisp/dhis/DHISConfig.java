package org.hisp.dhis;

import java.io.InputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Ime Asangansi on 9/13/2016.
 */
public class DHISConfig {

    private static final String CONFIG_DIR = "/conf";
    private static final String CONFIG = "/dhis.conf";

    protected Properties dhisProp;
    private String url;

    public DHISConfig() {

        System.getProperty("dhis2.home");
        dhisProp = getProperties(System.getProperty("dhis2.home") + CONFIG);
        url = dhisProp.getProperty("hibernate.connection.url");

    }


    public Properties getProperties(String conf_file){
        Properties properties = new Properties();

        InputStream input = null;

        try {

            input = new FileInputStream(conf_file);

            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return properties;

    }
}
