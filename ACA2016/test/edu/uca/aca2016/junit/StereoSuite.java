package edu.uca.aca2016.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author cfiles
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    edu.uca.aca2016.junit.MyStereoTest.class
})

public class StereoSuite{

    @BeforeClass
    public static void setUpClass() throws Exception{
    }

    @AfterClass
    public static void tearDownClass() throws Exception{
    }

    @Before
    public void setUp() throws Exception{
    }

    @After
    public void tearDown() throws Exception{
    }
}
