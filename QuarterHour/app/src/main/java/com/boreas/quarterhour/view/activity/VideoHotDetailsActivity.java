package com.boreas.quarterhour.view.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.boreas.quarterhour.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoHotDetailsActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    String url = "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_hot_details);

        jcVideoPlayerStandard = findViewById(R.id.video_hot_details_videoplayer);

        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "嫂子闭眼睛");
        jcVideoPlayerStandard.thumbImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"));
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
}
