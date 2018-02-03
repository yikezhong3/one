package com.boreas.quarterhour.model;

import java.util.List;

/**
 * Created by dream on 2018/2/3.
 */

public class BendiBean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"德克萨斯州体验美国的枪支文化","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img4.cache.netease.com/travel/2016/1/10/2016011011515085b41_550.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/11/BCVF471L00063KE8.html"},{"ctime":"2016-03-06 14:11","title":"老外眼中的25大最中国特色 还真是这么回事!","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img5.cache.netease.com/travel/2016/1/10/201601101209010164a.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/12/BCVGCMVN00063KE8.html"},{"ctime":"2016-03-06 14:11","title":"游客光天化日在巴西里约街头被少年抢劫","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img5.cache.netease.com/travel/2016/1/8/2016010812321010498_550.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/12/BCVHQU9100063KE8.html"},{"ctime":"2016-03-06 14:11","title":"外国人没懂老炮儿翻译 这些影视译名戳你笑点","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img2.cache.netease.com/travel/2016/1/8/201601081300498c376_550.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/13/BCVJ6SHV00063KE8.html"},{"ctime":"2016-03-06 14:11","title":"伤性食物最全名单 为了\u201c性福\u201d要少吃","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img6.cache.netease.com/travel/2016/1/8/201601081321198ce82.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/13/BCVKIQQ700063KE8.html"},{"ctime":"2016-03-06 14:11","title":"人间伊甸园巴哈马 全球最性感的地方","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img1.cache.netease.com/travel/2016/1/8/201601081331427dc48.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/13/BCVL54UE00063KE8.html"},{"ctime":"2016-03-06 14:11","title":"布达佩斯 那些被惊扰的闲情","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img2.cache.netease.com/travel/2016/1/8/2016010814115679b34_550.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/14/BCVNECRQ00063KE8.html"},{"ctime":"2016-03-06 14:11","title":"去妖魔化 眼见一个真实的印度","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img4.cache.netease.com/travel/2016/1/8/20160108142728a8a8c.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/14/BCVOFB4C00063KE8.html"},{"ctime":"2016-03-06 14:11","title":"放生羊：最能代表西藏的一道独特风景","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img1.cache.netease.com/catchpic/0/0E/0EEA8F0C2596FBFBC642E0356C4C66DC.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/21/BD0FHVAB00063JSA.html"},{"ctime":"2016-03-06 14:11","title":"采蘑菇算什么 你敢去采水晶吗？","description":"网易旅游","picUrl":"http://imgsize.ph.126.net/?imgurl=http://img1.cache.netease.com/catchpic/D/D0/D072F1C37F12C211F352962DAB0D3156.jpg_180x130x1x85.jpg","url":"http://travel.163.com/16/0110/21/BD0G1H7800063KE8.html"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2016-03-06 14:11
         * title : 德克萨斯州体验美国的枪支文化
         * description : 网易旅游
         * picUrl : http://imgsize.ph.126.net/?imgurl=http://img4.cache.netease.com/travel/2016/1/10/2016011011515085b41_550.jpg_180x130x1x85.jpg
         * url : http://travel.163.com/16/0110/11/BCVF471L00063KE8.html
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
