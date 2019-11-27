package com.poacherFramework.drivers;

public class Drivers {
    private static final String RESTAPIDRIVER ="RESTAPIDRIVER";
    private static final String BROWSERDRIVER ="BROWSERDRIVER";

    public void setDriver(Object driver){
        switch (driver.getClass().getSimpleName().toUpperCase().trim()){
            case RESTAPIDRIVER:


            case BROWSERDRIVER:

        }
    }
}
