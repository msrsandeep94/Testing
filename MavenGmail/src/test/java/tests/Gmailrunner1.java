package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"G:\\batch228\\MavenGmail\\src\\test\\resources\\features\\feature1.feature","G:\\batch228\\MavenGmail\\src\\test\\resources\\features\\feature2.feature"},
                 monochrome=true,
                 glue= {"classpath:glue"},
                 plugin= {"pretty","html:target\\sandeep"})
public class Gmailrunner1 
{
  
}
