package com.boreas.quarterhour.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boreas.quarterhour.R;
import com.boreas.quarterhour.base.BaseActivity;
import com.boreas.quarterhour.base.BasePresenter;
import com.boreas.quarterhour.model.VideoHotLike;
import com.boreas.quarterhour.model.glide.GlideCircleTransform;
import com.boreas.quarterhour.model.message.MessageEvent;
import com.boreas.quarterhour.presneter.VideoHotLikePresenter;
import com.boreas.quarterhour.presneter.VideoHotPresenter;
import com.boreas.quarterhour.utils.dagger.DaggerMyComponent;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotCollect;
import com.boreas.quarterhour.view.fragment.Video.view.VideoHotLikeView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

//<VideoHotLikeView,VideoHotLikePresenter> implements VideoHotLikeView

public class VideoHotDetailsActivity extends BaseActivity<VideoHotLikeView,VideoHotLikePresenter> implements VideoHotLikeView {
    /*@BindView(R.id.video_hot_details_iv_fanhui)
    ImageView videoHotDetailsIvFanhui;
    @BindView(R.id.video_hot_details_iv_like)
    ImageView videoHotDetailsIvLike;
    @BindView(R.id.video_hot_details_iv_nolike)
    ImageView videoHotDetailsIvNolike;
    @BindView(R.id.video_hot_details_iv_fenxiang)
    ImageView videoHotDetailsIvFenxiang;
    @BindView(R.id.video_hot_details_iv_touxiang)
    ImageView videoHotDetailsIvTouxiang;
    @BindView(R.id.video_hot_details_linearlayout)
    RelativeLayout videoHotDetailsLinearlayout;
    @BindView(R.id.video_hot_details_videoplayer)
    JCVideoPlayerStandard videoHotDetailsVideoplayer;
    @BindView(R.id.video_hot_details_title)
    TextView videoHotDetailsTitle;
    @BindView(R.id.video_hot_details_numandtime)
    TextView videoHotDetailsNumandtime;*/

    //"http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4"

    //点赞
    //https://www.zhaoapi.cn/quarter/praise?token=7D7681906D11EB7DA06B04362688EB74&source=android&appVersion=101&uid=983&wid=229
    //收藏
    //https://www.zhaoapi.cn/quarter/addFavorite?token=7D7681906D11EB7DA06B04362688EB74&source=android&appVersion=101&uid=983&wid=229
    //取消收藏
    //https://www.zhaoapi.cn/quarter/cancelFavorite?token=7D7681906D11EB7DA06B04362688EB74&source=android&appVersion=101&uid=983&wid=229

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    String url = "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";
    private ImageView fanhui;
    private ImageView like;
    private ImageView nolike;
    private ImageView fenxiang;
    private ImageView touxiang;
    private TextView title;
    private TextView numandtime;

    int likenum = 0;
    int nolikenum = 0;

    private RequestManager glideRequest;

    @Inject
    VideoHotLikePresenter videoHotLikePresenter;
    private int uid;
    private String token;
    private ArrayList<String> trings1;

    @Override
    protected void initDagger() {
        DaggerMyComponent.create().injectsp_video(this);
    }

    @Override
    protected void initView() {


        SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        uid = sp.getInt("uid", 0);
        token = sp.getString("token", "");

//        System.out.println("uid = " + uid);
        //圆形头像
        glideRequest = Glide.with(this);

        ArrayList<String> arrayList = new ArrayList<String>();

        trings1 = getIntent().getStringArrayListExtra("trings");
        //传来的ArrayList
//        System.out.println("trings = " + trings1.get(5));

        jcVideoPlayerStandard = findViewById(R.id.video_hot_details_videoplayer);
        fanhui = findViewById(R.id.video_hot_details_iv_fanhui);
        like = findViewById(R.id.video_hot_details_iv_like);
        nolike = findViewById(R.id.video_hot_details_iv_nolike);
        fenxiang = findViewById(R.id.video_hot_details_iv_fenxiang);
        touxiang = findViewById(R.id.video_hot_details_iv_touxiang);
        title = findViewById(R.id.video_hot_details_title);
        numandtime = findViewById(R.id.video_hot_details_numandtime);

        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

        //https://www.baidu.com/img/bdlogo.png
        glideRequest.load(trings1.get(3) + "").transform(new GlideCircleTransform(VideoHotDetailsActivity.this)).into(touxiang);
        title.setText(trings1.get(2));
        numandtime.setText(trings1.get(4));
        Toast.makeText(VideoHotDetailsActivity.this,"wid="+ trings1.get(5),Toast.LENGTH_LONG).show();

        jcVideoPlayerStandard.setUp(trings1.get(1) + "", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "这是视频呦");
        jcVideoPlayerStandard.thumbImageView.setImageURI(Uri.parse(trings1.get(0)));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_video_hot_details;
    }

    @Override
    public VideoHotLikePresenter getPresenter() {
        return videoHotLikePresenter;
    }

    @OnClick({R.id.video_hot_details_iv_fanhui, R.id.video_hot_details_iv_like, R.id.video_hot_details_iv_nolike, R.id.video_hot_details_iv_fenxiang, R.id.video_hot_details_iv_touxiang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.video_hot_details_iv_fanhui:
                Toast.makeText(VideoHotDetailsActivity.this, "返回", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.video_hot_details_iv_like:
                likenum++;
                if (likenum % 2 != 0) {
                    Toast.makeText(VideoHotDetailsActivity.this, "喜欢", Toast.LENGTH_LONG).show();
                    like.setImageResource(R.mipmap.video_like_yes);
                } else {
                    Toast.makeText(VideoHotDetailsActivity.this, "不喜欢", Toast.LENGTH_LONG).show();
                    like.setImageResource(R.mipmap.video_like);
                }
                videoHotLikePresenter.likelogin(uid+"",token,trings1.get(5));
                Log.d("uid,wid,token-like",uid+"-"+trings1.get(5)+"-"+token);
                break;
            case R.id.video_hot_details_iv_nolike:
                nolikenum++;
                if (nolikenum % 2 != 0) {
                    Toast.makeText(VideoHotDetailsActivity.this, "收藏", Toast.LENGTH_LONG).show();
                    nolike.setImageResource(R.mipmap.video_nolike_yes);
                    videoHotLikePresenter.collectlogin(uid+"",token,trings1.get(5));
                    Log.d("uid,wid,token-collect",uid+"-"+trings1.get(5)+"-"+token);
                } else {
                    Toast.makeText(VideoHotDetailsActivity.this, "不收藏", Toast.LENGTH_LONG).show();
                    nolike.setImageResource(R.mipmap.video_nolike);
                }
                break;
            case R.id.video_hot_details_iv_fenxiang:
                Toast.makeText(VideoHotDetailsActivity.this, "分享", Toast.LENGTH_LONG).show();
                UMImage image = new UMImage(VideoHotDetailsActivity.this, R.drawable.umeng_socialize_qq);//资源文件
                new ShareAction(VideoHotDetailsActivity.this)
                        .withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN,
                                SHARE_MEDIA.ALIPAY, SHARE_MEDIA.DINGTALK, SHARE_MEDIA.DOUBAN,
                                SHARE_MEDIA.DROPBOX, SHARE_MEDIA.EMAIL, SHARE_MEDIA.EVERNOTE,
                                SHARE_MEDIA.FACEBOOK)
                        .setCallback(shareListener)
                        .open();
                break;
            case R.id.video_hot_details_iv_touxiang:
                Toast.makeText(VideoHotDetailsActivity.this, "头像", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(VideoHotDetailsActivity.this , VideoHotTouxiangActivity.class);
                intent.putExtra("uid",uid+"");
                intent.putExtra("tx",trings1.get(3));
                intent.putExtra("title",trings1.get(2));
                Log.d("wid-----uid==",uid+"");
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();

        JCVideoPlayer.releaseAllVideos();
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(VideoHotDetailsActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(VideoHotDetailsActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(VideoHotDetailsActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

//        EventBus.getDefault().register(this);
    }

    /*public void onEventMainThread(MessageEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMessage();
        Log.d("harvic", msg);
//        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void likesuccess(VideoHotLike videoHotLike) {
        Log.d("喜欢的数据-wid==",videoHotLike.getMsg()+"-"+videoHotLike.getCode());
    }

    @Override
    public void collectsuccess(VideoHotCollect videoHotCollectView) {
        Log.d("收藏的数据-wid==",videoHotCollectView.getMsg()+"-"+videoHotCollectView.getCode());
    }
}
