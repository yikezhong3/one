package com.boreas.quarterhour.model;

import java.util.List;

/**
 * Created by 123 on 2018/1/29.
 */

public class UserDetailBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1517015733057bz.png","createTime":"2018-01-27T09:15:33","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":3,"praiseNum":null,"uid":2322,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517015733057xiaoniao.mp4","wid":261,"workDesc":"xiaoniao"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1517016314502bz.png","createTime":"2018-01-27T09:25:14","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":1,"praiseNum":null,"uid":2322,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016314502xiaohuang.mp4","wid":262,"workDesc":"xiaohuang"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1517016424550jqr.png","createTime":"2018-01-27T09:27:04","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":11,"praiseNum":null,"uid":2322,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016424550minion_09.mp4","wid":263,"workDesc":"minion_09"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1517016640785car.jpg","createTime":"2018-01-27T09:30:40","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":3,"praiseNum":null,"uid":2322,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016640785father.mp4","wid":264,"workDesc":"筷子兄弟\u2014父亲"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1517016896244jqr.png","createTime":"2018-01-27T09:34:56","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":2322,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016896244ymh.mp4","wid":266,"workDesc":"俞敏洪小视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1517025486173xniao.jpg","createTime":"2018-01-27T11:58:06","favoriteNum":null,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":0,"praiseNum":null,"uid":2322,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517025486173minion_09.mp4","wid":268,"workDesc":"俞敏洪小视频"}]
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
         * commentNum : null
         * cover : https://www.zhaoapi.cn/images/quarter/1517015733057bz.png
         * createTime : 2018-01-27T09:15:33
         * favoriteNum : null
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 3
         * praiseNum : null
         * uid : 2322
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1517015733057xiaoniao.mp4
         * wid : 261
         * workDesc : xiaoniao
         */

        private Object commentNum;
        private String cover;
        private String createTime;
        private Object favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private Object praiseNum;
        private int uid;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private boolean isCheck = true;

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(Object favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }
    }
}
