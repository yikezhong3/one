package com.boreas.quarterhour.view;

import com.boreas.quarterhour.model.CarouselModel;
import com.boreas.quarterhour.model.RMBean;

/**
 * Created by 123 on 2018/1/22.
 */

public interface HotView {
    public void onSuccess(CarouselModel model);
    public void onSuccessTn(RMBean bean);
}
