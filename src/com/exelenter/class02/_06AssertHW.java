package com.exelenter.class02;
import org.testng.annotations.*;

import static utils.BaseClass.*;

public class _06AssertHW {

    @BeforeMethod
    void openBrowser(){
        setUp();
    }
    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

}
