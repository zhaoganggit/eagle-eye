package org.zhaogang.eagleeye.model;

import java.io.Serializable;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class EnumParaValue implements Serializable {
    private int     value;
    private String  displayName;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
