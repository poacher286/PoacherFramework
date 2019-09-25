package com.poacherFramework.base;

public class PageBase {
    public TestBase testBase;
    public Object driver;

    public PageBase(TestBase testBase, Object whichDriver) {
        this.testBase = testBase;
        this.driver = whichDriver;
    }
}