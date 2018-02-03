package com.boreas.quarterhour.model;

import java.util.List;

/**
 * Created by dream on 2018/2/2.
 */

public class CollectBean {

    /**
     * msg : 获取收藏列表成功
     * code : 0
     * data : [{"commentNum":14,"comments":[{"cid":108,"content":"888888","createTime":"2017-12-18T16:11:50","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":225},{"cid":110,"content":"你好啊","createTime":"2017-12-18T16:14:05","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":225},{"cid":114,"content":"Mo","createTime":"2017-12-18T16:29:34","jid":null,"mvp":null,"nickname":"Mo","praiseNum":0,"uid":98,"wid":225},{"cid":117,"content":"%E4%B8%89%E6%A5%BC%E5%A4%A7%E4%BD%AC","createTime":"2017-12-18T16:47:46","jid":null,"mvp":null,"nickname":"笑出腹肌的男人","praiseNum":0,"uid":154,"wid":225},{"cid":118,"content":"123","createTime":"2017-12-18T16:50:25","jid":null,"mvp":null,"nickname":"笑出腹肌的男人","praiseNum":0,"uid":154,"wid":225},{"cid":121,"content":"Mo","createTime":"2017-12-18T19:34:32","jid":null,"mvp":null,"nickname":"Mo","praiseNum":0,"uid":98,"wid":225},{"cid":145,"content":"666","createTime":"2017-12-19T11:04:25","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":225},{"cid":146,"content":"666","createTime":"2017-12-19T11:13:01","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":225},{"cid":187,"content":"vvvvvv","createTime":"2017-12-19T14:51:40","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":225},{"cid":244,"content":"1212","createTime":"2018-01-27T11:40:13","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":245,"content":"1231231","createTime":"2018-01-27T11:40:32","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":257,"content":"123","createTime":"2018-01-28T15:09:48","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":258,"content":"1234","createTime":"2018-01-28T15:09:55","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":260,"content":"哈哈哈","createTime":"2018-01-28T15:53:59","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225}],"cover":"https://www.zhaoapi.cn/images/quarter/151358372249720170919_202309_1506213685322.jpg","createTime":"2017-12-18T15:55:22","favoriteNum":8,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":118,"praiseNum":5,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/151358372249720170919_194626.mp4","wid":225,"workDesc":"瞎搞"}]
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
         * commentNum : 14
         * comments : [{"cid":108,"content":"888888","createTime":"2017-12-18T16:11:50","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":225},{"cid":110,"content":"你好啊","createTime":"2017-12-18T16:14:05","jid":null,"mvp":null,"nickname":"linnnn","praiseNum":0,"uid":114,"wid":225},{"cid":114,"content":"Mo","createTime":"2017-12-18T16:29:34","jid":null,"mvp":null,"nickname":"Mo","praiseNum":0,"uid":98,"wid":225},{"cid":117,"content":"%E4%B8%89%E6%A5%BC%E5%A4%A7%E4%BD%AC","createTime":"2017-12-18T16:47:46","jid":null,"mvp":null,"nickname":"笑出腹肌的男人","praiseNum":0,"uid":154,"wid":225},{"cid":118,"content":"123","createTime":"2017-12-18T16:50:25","jid":null,"mvp":null,"nickname":"笑出腹肌的男人","praiseNum":0,"uid":154,"wid":225},{"cid":121,"content":"Mo","createTime":"2017-12-18T19:34:32","jid":null,"mvp":null,"nickname":"Mo","praiseNum":0,"uid":98,"wid":225},{"cid":145,"content":"666","createTime":"2017-12-19T11:04:25","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":225},{"cid":146,"content":"666","createTime":"2017-12-19T11:13:01","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":225},{"cid":187,"content":"vvvvvv","createTime":"2017-12-19T14:51:40","jid":null,"mvp":null,"nickname":"祝又忠","praiseNum":0,"uid":99,"wid":225},{"cid":244,"content":"1212","createTime":"2018-01-27T11:40:13","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":245,"content":"1231231","createTime":"2018-01-27T11:40:32","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":257,"content":"123","createTime":"2018-01-28T15:09:48","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":258,"content":"1234","createTime":"2018-01-28T15:09:55","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225},{"cid":260,"content":"哈哈哈","createTime":"2018-01-28T15:53:59","jid":null,"mvp":null,"nickname":"淘宝","praiseNum":0,"uid":2825,"wid":225}]
         * cover : https://www.zhaoapi.cn/images/quarter/151358372249720170919_202309_1506213685322.jpg
         * createTime : 2017-12-18T15:55:22
         * favoriteNum : 8
         * latitude : 0.0
         * localUri : null
         * longitude : 0.0
         * playNum : 118
         * praiseNum : 5
         * uid : 150
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/151358372249720170919_194626.mp4
         * wid : 225
         * workDesc : 瞎搞
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
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

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
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

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
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

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg
             * nickname : 小狼
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class CommentsBean {
            /**
             * cid : 108
             * content : 888888
             * createTime : 2017-12-18T16:11:50
             * jid : null
             * mvp : null
             * nickname : linnnn
             * praiseNum : 0
             * uid : 114
             * wid : 225
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }
        }
    }
}
