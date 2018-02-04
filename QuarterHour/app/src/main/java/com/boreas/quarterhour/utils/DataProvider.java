package com.boreas.quarterhour.utils;

import com.boreas.quarterhour.model.PictureBean;

import java.util.ArrayList;

/**
 * Created by Dell on 2018/1/29.
 */

public class DataProvider {

    public static final PictureBean[] VIRTUAL_PICTURE = new PictureBean[]{new PictureBean("http://img.tupianzj.com/uploads/allimg/170125/9-1F125162054.jpg"),
            new PictureBean("http://i-7.vcimg.com/crop/5fed1e161b29372e8b63538d33f0be1158286(600x)/thumb.jpg"),
            new PictureBean("http://pic1.win4000.com/wallpaper/0/59cef2d1ebab3.jpg"),
            new PictureBean("http://www.taopic.com/uploads/allimg/110910/2518-11091022301758.jpg"),
            new PictureBean("http://img.tupianzj.com/uploads/allimg/170301/9-1F301131537.jpg"),
            new PictureBean("http://img.71lady.com/uploads/allimg/1708/2_170814105553_1.jpg"),
            new PictureBean("http://img5.duitang.com/uploads/item/201508/30/20150830140556_34KTY.thumb.700_0.jpeg"),
            new PictureBean("http://p1.so.qhimgs1.com/bdr/200_200_/t01ce6c8db3aba6ad0d.jpg"),
            new PictureBean("http://img4.duitang.com/uploads/item/201508/04/20150804070646_ehFwz.thumb.700_0.jpeg"),
            new PictureBean("http://p1.so.qhimgs1.com/bdr/200_200_/t010d34379ecd446711.gif"),
            new PictureBean("http://images.rednet.cn/ArticleImage/2017/01/05/20171356318267154.jpg"),
            new PictureBean("http://img.china-ef.com/news/201709/22/2017092205354380.jpg"),
    };

    public static ArrayList<PictureBean> getPictures() {
        ArrayList<PictureBean> arrayList = new ArrayList<>();
        for (int i = 0; i < VIRTUAL_PICTURE.length; i++) {
            arrayList.add(VIRTUAL_PICTURE[i]);
        }
        return arrayList;
    }
    public static  String[] STRING_PICTURE ={"http://img.tupianzj.com/uploads/allimg/170125/9-1F125162054.jpg",
            "http://g2.hexunimg.cn/2014-11-26/170804688.jpg",
            "http://pic1.win4000.com/wallpaper/0/59cef2d1ebab3.jpg",
            "http://ww1.sinaimg.cn/large/005JeY1Kgw1eqkokbohwbj30p00gotc5.jpg",
            "http://img.tupianzj.com/uploads/allimg/170301/9-1F301131537.jpg",
            "http://img.xgo-img.com.cn/pics/1643/1642420.jpg",
            "http://img5.duitang.com/uploads/item/201508/30/20150830140556_34KTY.thumb.700_0.jpeg",
            "http://p0.so.qhmsg.com/t011eb34023c3dd26c5.jpg",
            "http://img4.duitang.com/uploads/item/201508/04/20150804070646_ehFwz.thumb.700_0.jpeg",
            "http://p0.so.qhmsg.com/t01d5ca1e75e3720b2f.jpg",
            "http://images.rednet.cn/ArticleImage/2017/01/05/20171356318267154.jpg",
            "http://img.china-ef.com/news/201709/22/2017092205354380.jpg"
    };

    public static ArrayList<String> getPicStr() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < VIRTUAL_PICTURE.length; i++) {
            arrayList.add(STRING_PICTURE[i]);
        }
        return arrayList;
    }
}
