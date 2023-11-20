package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(//features=".//Features/LoginPractice.feature",
			features=".//Features/LoginPracticeDDT.feature",
	glue={"stepDefinitions"},
	monochrome = true,
	dryRun = false,
	publish = true,
	plugin = {"pretty", 
			"html: reports/myreport.html",
			"json:reports/myreport.json",}
			//"rerun:target/rerun.txt",}
	//tags=("@sanity")
	)
	

public class TestRunner {

}
