package com.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "junit:target/junit/junit-report.xml",
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/library/step_definitions",
        dryRun = false,
        tags = ""
)

public class CukesRunner {
}
