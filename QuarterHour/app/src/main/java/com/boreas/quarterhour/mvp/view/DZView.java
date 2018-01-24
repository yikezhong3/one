package com.boreas.quarterhour.mvp.view;

import com.boreas.quarterhour.model.DZBean;

/**
 * Created by Administrator on 2018/1/20.
 */

public interface DZView {
    void success(DZBean dzBean);
    void fail(Exception e);
}
