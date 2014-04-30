package com.common.hardware;

public interface IHardwareInfoCollector {
    public abstract String getHardDriverID();

    public abstract String getCPUID();

    public abstract String getMACAddress();
}
