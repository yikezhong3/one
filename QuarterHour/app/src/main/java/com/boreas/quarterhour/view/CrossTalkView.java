package com.boreas.quarterhour.view;

import com.boreas.quarterhour.model.CrossTalkBean;

/**
 * Created by Administrator on 2018/1/20.
 */

public interface CrossTalkView {
    void success(CrossTalkBean crossTalkBean);
    void fail(Exception e);
}
