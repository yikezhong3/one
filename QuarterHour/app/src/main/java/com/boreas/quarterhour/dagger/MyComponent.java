package com.boreas.quarterhour.dagger;

import com.boreas.quarterhour.activity.LeadActivity;

import dagger.Component;

/**
 * Created by Dell on 2017/12/12.
 */
@Component(modules = MyMoudle.class)
public interface MyComponent {
    public void inject(LeadActivity lead);
}
