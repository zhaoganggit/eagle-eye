package org.zhaogang.eagleeye.model;

import java.io.Serializable;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class DeviceParameter  implements Serializable {

    private int         seq;
    private ParaType    type;
    private String      name;
    private boolean     enableMonitor;
    private boolean     enableControl;

    public ParaType getType() {
        return type;
    }

    public void setType(ParaType type) {
        this.type = type;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnableMonitor() {
        return enableMonitor;
    }

    public void setEnableMonitor(boolean enableMonitor) {
        this.enableMonitor = enableMonitor;
    }

    public boolean isEnableControl() {
        return enableControl;
    }

    public void setEnableControl(boolean enableControl) {
        this.enableControl = enableControl;
    }
}
