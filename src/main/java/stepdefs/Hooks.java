package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import steps.BaseSteps;

public class Hooks {
    @Before
    public void setUp(){
        BaseSteps.setUp();
    }

    @After
    public void tearDown(){
        BaseSteps.tearDown();
    }
}
