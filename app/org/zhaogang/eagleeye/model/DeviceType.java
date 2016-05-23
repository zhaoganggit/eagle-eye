package org.zhaogang.eagleeye.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Joy.wang on 16-5-23.
 */
public class DeviceType  implements Serializable {

    private String id;
    private String name;
    private Protocol protocol;
    private List<DeviceParameter> deviceTypeParas;

    private Date createdDate;
    private Date lastModifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public List<DeviceParameter> getDeviceTypeParas() {
        return deviceTypeParas;
    }

    public void setDeviceTypeParas(List<DeviceParameter> deviceTypeParas) {
        this.deviceTypeParas = deviceTypeParas;
    }
}
