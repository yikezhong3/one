package com.boreas.quarterhour.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Locale;

/**
 * Created by Dell on 2018/1/22.
 */

public class Splash {


    private static final String URL = "http://cn.bing.com%s_720x1280.jpg";

    @SerializedName("images")
    private List<ImagesBean> images;

    public String getUrl() {
        if (images != null && !images.isEmpty()) {
            String baseUrl = images.get(0).urlbase;
            if (!TextUtils.isEmpty(baseUrl)) {
                String format = String.format(Locale.getDefault(), URL, baseUrl);
                System.out.println("aaaaaaaaaaaa--------"+format);
                return format;
            }
        }
        return null;
    }

    private static class ImagesBean {

        @SerializedName("startdate")
        private String startdate;
        @SerializedName("fullstartdate")
        private String fullstartdate;
        @SerializedName("enddate")
        private String enddate;
        @SerializedName("url")
        private String url;
        @SerializedName("urlbase")
        private String urlbase;
        @SerializedName("copyright")
        private String copyright;
        @SerializedName("copyrightlink")
        private String copyrightlink;
        @SerializedName("quiz")
        private String quiz;
        @SerializedName("wp")
        private boolean wp;
        @SerializedName("hsh")
        private String hsh;
        @SerializedName("drk")
        private int drk;
        @SerializedName("top")
        private int top;
        @SerializedName("bot")
        private int bot;
        @SerializedName("hs")
        private List<?> hs;
    }
}
