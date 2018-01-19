package com.boreas.quarterhour.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Dell on 2018/1/19.
 */

public class BasePresenter<V> {

    //弱引用管理view
    private WeakReference<V> weakReference;
    //订阅者管理器
    private CompositeDisposable compositeDisposable;

    //关联view
    public void attachView(V view) {
        weakReference = new WeakReference(view);
    }

    //解除view
    public void detachView(){
        if (isattach()){
            weakReference.clear();
            weakReference = null;
        }
    }

    //判断是否关联
    public boolean isattach(){
        return weakReference != null && weakReference.get() != null;
    }

    //得到view对象
    public V getView(){
        return isattach() ? weakReference.get() : null;
    }

    //添加订阅者管理器
    public void addCompositeDisposable(Disposable disposable){
        if (compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    //清空订阅者管理器
    public void removeCompositeDisposable(){
        if (compositeDisposable != null){
            compositeDisposable.clear();
            compositeDisposable = null;
        }
    }
}
