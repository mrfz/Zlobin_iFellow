package ru.iFellow.tests;

import org.junit.platform.suite.api.*;


import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ru.iFellow/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ru.iFellow")
@SelectPackages("ru.iFellow.steps")

public class RunCucumberTest {
}
