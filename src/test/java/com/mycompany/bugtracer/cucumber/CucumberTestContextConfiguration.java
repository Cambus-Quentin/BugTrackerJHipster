package com.mycompany.bugtracer.cucumber;

import com.mycompany.bugtracer.BugTrackerJHipsterApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = BugTrackerJHipsterApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
