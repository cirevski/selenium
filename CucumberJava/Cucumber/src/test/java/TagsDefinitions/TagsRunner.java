package TagsDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Tags", glue={"TagsDefinitions"},
plugin = { "pretty", "html:target\\HtmlReports1" },
tags =  {"@login or @smoke"}

		)


public class TagsRunner {

}
