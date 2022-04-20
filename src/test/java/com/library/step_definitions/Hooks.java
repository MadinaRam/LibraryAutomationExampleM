package com.library.step_definitions;

import com.library.utilities.ConfigurationReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.quitDriver();

    }

    @BeforeAll
    public void connectToDB(){

        DB_Util.createConnection(ConfigurationReader.getProperty("DB.URL"),
                ConfigurationReader.getProperty("DB.username"),ConfigurationReader.getProperty("DB.password"));
    }


    @AfterAll
    public void destroyDB(){
        DB_Util.destroy();
    }
}
