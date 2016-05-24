package org.zhaogang.eagleeye.model;

import org.springframework.beans.BeanUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joy.wang on 16-5-24.
 */
public class DeviceDynamic extends Device implements Serializable{

    private Map<Integer,DeviceParameterDynamic>   deviceParameterDynamics = new HashMap<Integer,DeviceParameterDynamic>();

    private DeviceStatus  deviceStatus = DeviceStatus.OFF;

    public static DeviceDynamic fromDevice(Device device){
        DeviceDynamic deviceDynamic = new DeviceDynamic();
        BeanUtils.copyProperties(device, deviceDynamic);

        DeviceType deviceType = deviceDynamic.getDeviceType();
        if(deviceType != null && !deviceType.getDeviceTypeParas().isEmpty()){
           for(DeviceParameter deviceParameter: deviceType.getDeviceTypeParas()){
               DeviceParameterDynamic deviceParameterDynamic = DeviceParameterDynamic.fromDeviceParameter(deviceParameter);
               deviceDynamic.getDeviceParameterDynamics().put(deviceParameterDynamic.getSeq(),deviceParameterDynamic);
           }
        }
        return deviceDynamic;
    }

    public Map<Integer, DeviceParameterDynamic> getDeviceParameterDynamics() {
        return deviceParameterDynamics;
    }

    public void setDeviceParameterDynamics(Map<Integer, DeviceParameterDynamic> deviceParameterDynamics) {
        this.deviceParameterDynamics = deviceParameterDynamics;
    }

    public DeviceStatus getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(DeviceStatus deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
}
