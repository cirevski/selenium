package step.definitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\search.feature",
glue={"step.definitions", "search_steps"},
plugin= {"pretty", "html:target/reports", "json:target/reports.json", "junit:target/reports.xml"},
tags= {"search"})





public class test_runner {
	
	

}
