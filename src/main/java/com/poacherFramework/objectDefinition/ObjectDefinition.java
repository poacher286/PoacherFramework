package com.poacherFramework.objectDefinition;

import com.poacherFramework.constants.WhatType;
import org.openqa.selenium.By;

public class ObjectDefinition {
    private String name;
    private WhatType type;
    private By locator;

    public ObjectDefinition(String name, WhatType type, By locator) {
        this.name = name;
        this.type = type;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WhatType getType() {
        return type;
    }

    public void setType(WhatType type) {
        this.type = type;
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }
}
