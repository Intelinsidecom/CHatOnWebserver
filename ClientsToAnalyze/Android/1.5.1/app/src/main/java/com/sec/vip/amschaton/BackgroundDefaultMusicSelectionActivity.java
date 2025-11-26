package com.sec.vip.amschaton;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public class BackgroundDefaultMusicSelectionActivity extends AMSActivity implements View.OnClickListener {

    /* renamed from: a */
    private int f4120a = -1;

    /* renamed from: b */
    private ListView f4121b = null;

    /* renamed from: c */
    private C0669bp f4122c = null;

    /* renamed from: d */
    private MediaPlayer f4123d = null;

    /* renamed from: m */
    private AMSBGMManager f4124m = AMSBGMManager.m3719a();

    /* renamed from: n */
    private int[] f4125n = {C0062R.drawable.music_play_grid_thumb_01, C0062R.drawable.music_play_grid_thumb_02, C0062R.drawable.music_play_grid_thumb_03, C0062R.drawable.music_play_grid_thumb_04, C0062R.drawable.music_play_grid_thumb_05, C0062R.drawable.music_play_grid_thumb_06, C0062R.drawable.music_play_grid_thumb_07, C0062R.drawable.music_play_grid_thumb_08};

    /* renamed from: o */
    private boolean f4126o = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4146a() throws IllegalStateException, IOException, IllegalArgumentException {
        if (this.f4120a >= this.f4124m.m3722b()) {
            return false;
        }
        if (this.f4123d == null) {
            this.f4123d = new MediaPlayer();
            try {
                String strM3720a = this.f4124m.m3720a(this.f4120a);
                if (strM3720a == null) {
                    return false;
                }
                ChatONLogWriter.m3506b("BGM Path : " + strM3720a, getClass().getSimpleName());
                AssetFileDescriptor assetFileDescriptorOpenFd = getAssets().openFd(strM3720a);
                this.f4123d.setDataSource(assetFileDescriptorOpenFd.getFileDescriptor(), assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getLength());
                assetFileDescriptorOpenFd.close();
                this.f4123d.prepare();
                this.f4123d.setLooping(false);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return false;
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        this.f4123d.start();
        return true;
    }

    /* renamed from: i */
    private boolean m4151i() throws IllegalStateException {
        if (this.f4123d == null) {
            return false;
        }
        this.f4123d.pause();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m4152j() throws IllegalStateException {
        if (this.f4123d == null) {
            return;
        }
        this.f4123d.stop();
        this.f4123d.release();
        this.f4123d = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_ok /* 2131427351 */:
                Intent intent = new Intent();
                intent.putExtra("BGM_INDEX", this.f4120a);
                setResult(-1, intent);
                finish();
                break;
            case C0062R.id.btn_cancel /* 2131427352 */:
                finish();
                break;
        }
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.ams_bg_default_music_layout);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4120a = extras.getInt("BGM_INDEX", -1);
        } else {
            ChatONLogWriter.m3506b("[onCreate] bundle is NULL!", getClass().getSimpleName());
        }
        this.f4122c = new C0669bp(this, this);
        this.f4121b = (ListView) findViewById(C0062R.id.soundList);
        this.f4121b.setAdapter((ListAdapter) this.f4122c);
        this.f4121b.setItemsCanFocus(false);
        this.f4121b.setTextFilterEnabled(true);
        this.f4121b.setOnItemClickListener(new C0651ay(this));
        findViewById(C0062R.id.btn_ok).setOnClickListener(this);
        findViewById(C0062R.id.btn_cancel).setOnClickListener(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalStateException {
        super.onDestroy();
        m4152j();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() throws IllegalStateException {
        super.onPause();
        m4151i();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() throws IllegalStateException, IOException, IllegalArgumentException {
        super.onResume();
        if (this.f4126o) {
            this.f4126o = false;
        } else {
            m4146a();
        }
    }
}
