package com.boreas.quarterhour.model;

import java.util.List;

/**
 * Created by dream on 2018/2/3.
 */

public class SelectBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-29T13:40:59","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18803007655","money":null,"nickname":null,"password":"666666","praiseNum":null,"token":"544EE1642BA42F4887F31827B60E13F5","uid":5058,"userId":null,"username":"18803007655"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T10:40:26","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18803001234","money":null,"nickname":null,"password":"666666","praiseNum":null,"token":null,"uid":5059,"userId":null,"username":"18803001234"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T10:40:46","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18803001233","money":null,"nickname":null,"password":"666666","praiseNum":null,"token":null,"uid":5060,"userId":null,"username":"18803001233"},{"age":null,"appkey":"4d899dda09be2bf2","appsecret":"4E6309EF7E7651DFAA5F34C867C9D6BA","createtime":"2017-12-20T10:50:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15726649023","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":5061,"userId":null,"username":"15726649023"},{"age":null,"appkey":"6880ad7eed28166b","appsecret":"1ADE34B3784DD8CA4A964CD9D53896FF","createtime":"2017-12-20T10:52:19","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15726649090","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":5062,"userId":null,"username":"15726649090"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T11:24:07","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13516516516","money":null,"nickname":null,"password":"164115","praiseNum":null,"token":null,"uid":5063,"userId":null,"username":"13516516516"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T11:31:16","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13161092407","money":null,"nickname":null,"password":"123456789012","praiseNum":null,"token":null,"uid":5064,"userId":null,"username":"13161092407"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T14:23:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18644773484","money":null,"nickname":null,"password":"741852963","praiseNum":null,"token":null,"uid":5065,"userId":null,"username":"18644773484"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T14:24:21","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18634478383","money":null,"nickname":null,"password":"741852963","praiseNum":null,"token":"3E519E774E40AEB1FD6CA0153267156E","uid":5066,"userId":null,"username":"18634478383"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-20T14:40:33","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15144987412","money":null,"nickname":null,"password":"sunyu1025","praiseNum":null,"token":null,"uid":5067,"userId":null,"username":"15144987412"}]
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
         * appkey : null
         * appsecret : null
         * createtime : 2018-01-29T13:40:59
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 18803007655
         * money : null
         * nickname : null
         * password : 666666
         * praiseNum : null
         * token : 544EE1642BA42F4887F31827B60E13F5
         * uid : 5058
         * userId : null
         * username : 18803007655
         */

        private Object age;
        private Object appkey;
        private Object appsecret;
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
        private Object nickname;
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

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
            this.appkey = appkey;
        }

        public Object getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(Object appsecret) {
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

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
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
