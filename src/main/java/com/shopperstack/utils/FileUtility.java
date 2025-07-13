package com.shopperstack.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
   private FileInputStream fis;
    public String getPropertyData(String key) throws IOException {

            fis=new FileInputStream("");

        Properties properties= new Properties();
        properties.load(fis);
       return properties.getProperty(key);
    }
}
