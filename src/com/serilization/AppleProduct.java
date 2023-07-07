package com.serilization;

import java.io.Serializable;

public class AppleProduct implements Serializable {


    public static void main(String[] args) {
        new AppleProduct() {

            public String getHeaderPort() {
                return null;
            }
        };
    }

    private static final long serialVersionUID = 1234567L;

    public String headphonePort;
    public String thunderboltPort;

    public String getHeadphonePort() {
        return headphonePort;
    }

    public void setHeadphonePort(String headphonePort) {
        this.headphonePort = headphonePort;
    }

    public String getThunderboltPort() {
        return thunderboltPort;
    }

    public void setThunderboltPort(String thunderboltPort) {
        this.thunderboltPort = thunderboltPort;
    }
}
