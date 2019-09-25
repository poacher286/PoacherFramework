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

    public WhatType getType() {
        return type;
    }

    public By getLocator() {
        return locator;
    }
}
