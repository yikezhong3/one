package com.boreas.quarterhour.model;

import java.util.List;

/**
 * Created by dream on 2018/2/2.
 */

public class AttentionBean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":"ced8580c991e16fb","appsecret":"28CE201C9A394B630A629A9E5BAEA79E","createtime":"2018-02-02T16:49:20","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17316250426","money":null,"nickname":"","password":"7792A1F7048ECB10FE716CE6FD38E884","praiseNum":null,"token":"FE04C41704BE82CECA90454EA16CFBF1","uid":4305,"userId":null,"username":"17316250426"},{"age":null,"appkey":"ced8580c991e16fb","appsecret":"28CE201C9A394B630A629A9E5BAEA79E","createtime":"2018-02-02T16:49:20","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17316250426","money":null,"nickname":"","password":"7792A1F7048ECB10FE716CE6FD38E884","praiseNum":null,"token":"FE04C41704BE82CECA90454EA16CFBF1","uid":4305,"userId":null,"username":"17316250426"},{"age":null,"appkey":"d720415dada82e08","appsecret":"D06D8C948844FF8525D9BC9DA1D52B03","createtime":"2017-12-22T16:49:59","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1512108751006e.png","latitude":null,"longitude":null,"mobile":"18810431730","money":null,"nickname":"李薇","password":"30D0BA0744A36CFD7EFF8869E8B09A0E","praiseNum":null,"token":"4860E93D56838926DD61E21884D6939D","uid":2997,"userId":null,"username":"18810431730"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-01T10:39:53","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15144441889441500855344482.jpeg","latitude":null,"longitude":null,"mobile":"15201392236","money":0,"nickname":"李灿灿","password":"111111","praiseNum":null,"token":"3E030858FEEED1026B1A1FB5CD5EF9ED","uid":148,"userId":null,"username":"15201392236"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T09:06:15","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15518951212","money":0,"nickname":null,"password":"12345","praiseNum":null,"token":null,"uid":220,"userId":null,"username":"15518951212"},{"age":null,"appkey":"a28e5181cffca127","appsecret":"279205443175743B147519B6CF79F437","createtime":"2018-02-01T09:06:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18811152899","money":null,"nickname":null,"password":"96D4B05BC40E9CA4386CFE31668FB848","praiseNum":null,"token":"002CB4695F43BD12F30DEE34EE4AE8FB","uid":2924,"userId":null,"username":"18811152899"},{"age":null,"appkey":"a28e5181cffca127","appsecret":"279205443175743B147519B6CF79F437","createtime":"2018-02-01T09:06:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18811152899","money":null,"nickname":null,"password":"96D4B05BC40E9CA4386CFE31668FB848","praiseNum":null,"token":"002CB4695F43BD12F30DEE34EE4AE8FB","uid":2924,"userId":null,"username":"18811152899"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : ced8580c991e16fb
         * appsecret : 28CE201C9A394B630A629A9E5BAEA79E
         * createtime : 2018-02-02T16:49:20
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 17316250426
         * money : null
         * nickname :
         * password : 7792A1F7048ECB10FE716CE6FD38E884
         * praiseNum : null
         * token : FE04C41704BE82CECA90454EA16CFBF1
         * uid : 4305
         * userId : null
         * username : 17316250426
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
