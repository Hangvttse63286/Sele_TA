package com.example.tadashboard.common.utilities.helpers;

import com.example.tadashboard.common.utilities.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties properties;
    static String propertyFilePath = "src//test//resources//config.properties";

    public static void setConfigFileReader() {
        BufferedReader reader;

        properties = new Properties();
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                Log.error("Error" + Arrays.toString(e.getStackTrace()));
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            Log.error("Error" + Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public static String getValue(String key) {
        String value = properties.getProperty(key);
        if (value != null) return value;
        else throw new RuntimeException(key + " not specified in the config.properties file.");
    }
}
