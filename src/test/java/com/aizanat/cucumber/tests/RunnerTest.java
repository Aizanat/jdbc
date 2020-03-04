package com.aizanat.cucumber.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.aizanat.cucumber.stepdefs",
        tags = "@All, @TestingOnePage",
        snippets = SnippetType.CAMELCASE
)

public class RunnerTest{
}
