package com.poacherFramework.baseClass;


import com.poacherFramework.drivers.Drivers;

public class PageBase extends Drivers {
    protected TestBase testBase;
    protected Object driver;

    public PageBase(TestBase testBase, Object driver) {
        this.driver = driver;
        this.testBase = testBase;
        this.setDriver(driver);
    }

}
