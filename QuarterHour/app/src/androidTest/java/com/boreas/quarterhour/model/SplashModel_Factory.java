package com.boreas.quarterhour.model;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum SplashModel_Factory implements Factory<SplashModel> {
  INSTANCE;

  @Override
  public SplashModel get() {
    return new SplashModel();
  }

  public static Factory<SplashModel> create() {
    return INSTANCE;
  }
}
