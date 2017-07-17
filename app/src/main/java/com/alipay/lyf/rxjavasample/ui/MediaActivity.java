package com.alipay.lyf.rxjavasample.ui;

import android.os.Environment;

import com.alipay.lyf.rxjavasample.R;
import com.alipay.lyf.rxjavasample.base.MVPBaseActivity;
import com.alipay.lyf.rxjavasample.encrypt.MediaEncrypt;
import com.example.video.media.IjkPlayerView;

import butterknife.BindView;

public class MediaActivity extends MVPBaseActivity {

    private String filepath =
            Environment.getExternalStorageDirectory() + "/Download/" + "test0" + ".mp4";
    @BindView(R.id.ijkvideo)
    IjkPlayerView mIjkvideo;
    private String mFilepath;

    @Override
    public int getLayoutId() {
        return R.layout.activity_media;
    }

    @Override
    protected void init() {
        initVideo();
    }

    @Override
    protected void initInjector() {

    }
    private void initVideo() {
        mIjkvideo.init()
                .setIsLiving(false)
                .setSkipTip(1000 * 60 * 1)
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH);
        toPlay();
    }

    private void toPlay() {
        mFilepath = Environment.getExternalStorageDirectory() + "/Download/" + "test0" + ".mp4";
        mIjkvideo.switchVideoPath(mFilepath);
        MediaEncrypt.deEncrypt(mFilepath);
        mIjkvideo.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaEncrypt.deEncrypt(mFilepath);
    }

    @Override
    protected void onStop() {
        MediaEncrypt.encrypt(mFilepath);
        super.onStop();

    }
}
