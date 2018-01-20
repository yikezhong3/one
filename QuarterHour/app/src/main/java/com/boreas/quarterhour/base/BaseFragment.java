package com.boreas.quarterhour.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Dell on 2018/1/19.
 */

public abstract class BaseFragment<V , P extends  BasePresenter> extends Fragment {
    public P presenter;
    private Unbinder bind;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initDagger();
        //沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getActivity().getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        //绑定ButterKnife
        bind = ButterKnife.bind(getActivity());
        presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
        view = inflater.inflate(getLayoutId(), container, false);
        initView(view);
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initDagger();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    protected abstract void init();

    protected abstract void initView(View view);

    protected abstract P getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.removeCompositeDisposable();
            presenter.detachView();
        }
        bind.unbind();
    }


}
