package fds.runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/fds/resources/features/CreateNewDossier.feature",
        glue = {"test.java.fds.stepsdefinition"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
        	},
        monochrome = true
        )
public class CreateNewDossierRunner extends BaseRunner {
	
}