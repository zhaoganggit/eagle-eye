package org.zhaogang.eagleeye.model;

import org.springframework.beans.BeanUtils;
import java.io.Serializable;

/**
 * Created by Joy.wang on 16-5-24.
 */
public class DeviceParameterDynamic extends DeviceParameter  implements Serializable {

    private double          doubleValue;
    private int             enumValue;
    private MonitorStatus   status = MonitorStatus.NO_DATA;

    public static DeviceParameterDynamic fromDeviceParameter(DeviceParameter deviceParameter){
        DeviceParameterDynamic deviceParameterDynamic = new DeviceParameterDynamic();
        BeanUtils.copyProperties(deviceParameter, deviceParameterDynamic);
        return deviceParameterDynamic;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public int getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(int enumValue) {
        this.enumValue = enumValue;
    }

    public MonitorStatus getStatus() {
        return status;
    }

    public void setStatus(MonitorStatus status) {
        this.status = status;
    }
}
