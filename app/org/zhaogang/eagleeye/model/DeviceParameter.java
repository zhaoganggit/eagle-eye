package org.zhaogang.eagleeye.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class DeviceParameter  implements Serializable {

    protected int         seq;
    protected ParaType    type;
    protected String      name;
    protected boolean     monitor;
    protected boolean     control;

    //numerical value scope
    protected double      doubleValueMin;
    protected double      doubleValueMax;

    //enumeration value-test list
    protected List<EnumParaValue> enumParaValues;


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

    public boolean isMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public boolean isControl() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    public double getDoubleValueMin() {
        return doubleValueMin;
    }

    public void setDoubleValueMin(double doubleValueMin) {
        this.doubleValueMin = doubleValueMin;
    }

    public double getDoubleValueMax() {
        return doubleValueMax;
    }

    public void setDoubleValueMax(double doubleValueMax) {
        this.doubleValueMax = doubleValueMax;
    }

    public List<EnumParaValue> getEnumParaValues() {
        return enumParaValues;
    }

    public void setEnumParaValues(List<EnumParaValue> enumParaValues) {
        this.enumParaValues = enumParaValues;
    }
}
