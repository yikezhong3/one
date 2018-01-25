package com.boreas.quarterhour.utils;

/**
 * Created by dream on 2018/1/25.
 */

public class MessageEvent {
    private String icon;
    private String name;

    public MessageEvent(String icon, String name) {
        this.icon = icon;
        this.name = name;
    }



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
