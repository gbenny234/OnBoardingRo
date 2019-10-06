package com.Onboarding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;

public class SignUpPatientCommonFunctions {
	
    private static final String DATA_FOR_RANDOM_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static SecureRandom random = new SecureRandom();
    static Properties prop = new Properties();
    public static final String Path_Properties = "OnboardingData.properties";
    
    
    /*
     * This function generates random string. 
     */

    public static String generateEmail(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

			// 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);

        }

        return sb.toString();

    }
    
    //load data from properties file
    public static void dataLoad() throws FileNotFoundException, IOException
    {
    	prop.load(new FileInputStream(Path_Properties));
    }
    
    //get url from properties file
    public static String urL()
    {
    	String baseUrl = prop.getProperty("roUrl");
		return baseUrl;
    	
    }
    
    //gets firstName from properties file.
    public static String profileFirstName()
    {
    	String firstName = prop.getProperty("firstname");
		return firstName;
    	
    }
    
    //get lastname from properties file.
    public static String profileLastName()
    {
    	String lastName = prop.getProperty("lastName");
		return lastName;
    	
    }

}
