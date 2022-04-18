package com.sampleseleniumframework.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import com.sampleseleniumframework.pom.SamplePom;

/**
 * Unit test for simple App.
 */
public class SampleTest 
{
    static SamplePom samplePom;

    @BeforeClass
    public static void setUp() throws Exception
    {
        samplePom = new SamplePom();
        String pageTitle = samplePom.navigateToUrl("https://app.say.rocks/qa-code-challenge");
        assertEquals("Apple Q&A - QA Code Challenge", pageTitle);
    }

    @AfterClass
    public static void tearDown() throws Exception
    {
        samplePom.closeBrowser();
    }

    @Test
    public void validateEventTitle()
    {
        String eventTitle = samplePom.getEventTitle();
        System.out.println("Event title: " + eventTitle);
        assertEquals("Apple Q&A - QA Code Challenge", eventTitle);
    }

    @Test
    public void validateQuestionCount()
    {
        String totalQuestion = samplePom.getTotalQuestionCount();
        assertEquals("83 Questions", totalQuestion);
    }
}
