package com.sec.chaton.multimedia.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class VideoRecordActivity extends Activity implements MediaRecorder.OnInfoListener, SurfaceHolder.Callback {

    /* renamed from: a */
    public static final String f3920a = VideoRecordActivity.class.getSimpleName();

    /* renamed from: c */
    private C1064k f3922c;

    /* renamed from: d */
    private SurfaceView f3923d;

    /* renamed from: e */
    private SurfaceHolder f3924e;

    /* renamed from: g */
    private ImageView f3926g;

    /* renamed from: h */
    private ImageView f3927h;

    /* renamed from: i */
    private ImageView f3928i;

    /* renamed from: j */
    private Chronometer f3929j;

    /* renamed from: k */
    private ImageView f3930k;

    /* renamed from: l */
    private LinearLayout f3931l;

    /* renamed from: m */
    private ImageView f3932m;

    /* renamed from: n */
    private Context f3933n;

    /* renamed from: o */
    private String f3934o;

    /* renamed from: p */
    private File f3935p;

    /* renamed from: q */
    private C1063j f3936q;

    /* renamed from: r */
    private TextView f3937r;

    /* renamed from: s */
    private ImageView f3938s;

    /* renamed from: t */
    private MenuItem f3939t;

    /* renamed from: f */
    private Camera f3925f = null;

    /* renamed from: u */
    private boolean f3940u = false;

    /* renamed from: b */
    Handler f3921b = new HandlerC1061h(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6067f("onCreate() : ", f3920a);
        this.f3933n = this;
        m4061a();
        CamcorderProfile camcorderProfile = CamcorderProfile.get(0);
        C1786r.m6067f("onCreate() : " + camcorderProfile.videoFrameWidth + ":" + camcorderProfile.videoFrameHeight, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile.videoCodec, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile.audioCodec, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile.fileFormat, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile.videoFrameRate, f3920a);
        CamcorderProfile camcorderProfile2 = CamcorderProfile.get(1);
        C1786r.m6067f("onCreate() : " + camcorderProfile2.videoFrameWidth + ":" + camcorderProfile2.videoFrameHeight, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile2.videoCodec, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile2.audioCodec, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile2.fileFormat, f3920a);
        C1786r.m6067f("onCreate() : " + camcorderProfile2.videoFrameRate, f3920a);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        C1786r.m6067f("onResume() : ", f3920a);
        C1786r.m6067f("MSISDN : " + C1789u.m6075a().getString("msisdn", ""), f3920a);
        C1786r.m6067f("Version : " + C0452a.f1723b, f3920a);
        C1786r.m6067f("Manufacturer : " + Build.MANUFACTURER, f3920a);
        C1786r.m6067f("MODEL : " + Build.MODEL, f3920a);
        C1786r.m6067f("Device : " + Build.DEVICE, f3920a);
        C1786r.m6067f("SDK : " + Build.VERSION.SDK_INT, f3920a);
        C1786r.m6067f("BUILD_IDENTIFIER : " + Build.FINGERPRINT, f3920a);
        C1786r.m6067f("BRAND : " + Build.BRAND, f3920a);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        C1786r.m6067f("onStart() : ", f3920a);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        C1786r.m6067f("onPause() : ", f3920a);
        if (this.f3922c != null && this.f3922c.m4087a() == EnumC1065l.RECORDING) {
            m4072d();
            m4075f();
        } else {
            m4073e();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        C1786r.m6067f("onStop() : ", f3920a);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1786r.m6067f("onPause() : ", f3920a);
        m4073e();
    }

    /* renamed from: a */
    private void m4061a() {
        setContentView(R.layout.layout_attachment_record_video);
        this.f3923d = (SurfaceView) findViewById(R.id.viewer_record_video);
        this.f3924e = this.f3923d.getHolder();
        this.f3924e.addCallback(this);
        this.f3924e.setType(3);
        this.f3930k = (ImageView) findViewById(R.id.record_video_preview);
        this.f3931l = (LinearLayout) findViewById(R.id.record_video_preview_playbutton_layout);
        this.f3932m = (ImageView) findViewById(R.id.record_video_preview_playbutton);
        this.f3929j = (Chronometer) findViewById(R.id.record_video_elapsed_time);
        this.f3937r = (TextView) findViewById(R.id.record_video_file_size);
        this.f3937r.setText("  0K  /  10240K  ");
        this.f3938s = (ImageView) findViewById(R.id.record_video_recording);
        this.f3926g = (ImageView) findViewById(R.id.btn_reset_start_record_video);
        this.f3927h = (ImageView) findViewById(R.id.btn_cancel_stop_record_video);
        this.f3928i = (ImageView) findViewById(R.id.btn_send_record_video);
        this.f3926g.setOnClickListener(new ViewOnClickListenerC1057d(this));
        this.f3927h.setOnClickListener(new ViewOnClickListenerC1058e(this));
        this.f3928i.setOnClickListener(new ViewOnClickListenerC1059f(this));
        this.f3932m.setOnClickListener(new ViewOnClickListenerC1060g(this));
    }

    /* renamed from: b */
    private String m4068b() throws IOException {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                throw new IOException();
            }
            String str = GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() + "/recVideo";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file.exists() && !file.mkdirs()) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    C1786r.m6061b(e.toString(), null);
                }
            }
            return str + "/chaton_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".mp4";
        } catch (IOException e2) {
            C1786r.m6061b(e2.toString(), null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4065a(String str) {
        C1786r.m6067f("RECORD VIDEO FILE URL : " + str, f3920a);
        this.f3935p = null;
        Intent intent = new Intent();
        if (str == null) {
            setResult(0, intent);
        } else {
            intent.setData(Uri.parse(str));
            setResult(-1, intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4062a(SurfaceHolder surfaceHolder) {
        try {
            if (this.f3922c == null) {
                this.f3922c = new C1064k();
                this.f3922c.m4088a(this.f3925f);
            }
            this.f3922c.m4089a(m4068b(), surfaceHolder, this);
        } catch (Exception e) {
            C1786r.m6061b(e.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4070c() {
        try {
            this.f3926g.setImageResource(R.drawable.recorder_player_stop);
            this.f3928i.setVisibility(4);
            this.f3922c.m4090b();
            this.f3929j.setBase(SystemClock.elapsedRealtime());
            this.f3929j.start();
            this.f3938s.setVisibility(0);
            this.f3935p = new File(this.f3922c.m4093e());
            this.f3936q = new C1063j(this);
            this.f3936q.start();
            if (GlobalApplication.m3265f()) {
                this.f3939t.setEnabled(false);
            }
            getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
        } catch (Exception e) {
            C1786r.m6061b(e.toString(), null);
            Toast.makeText(this, getResources().getString(R.string.chat_send_recordvodeo_toast_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4072d() {
        try {
            this.f3926g.setEnabled(false);
            this.f3922c.m4091c();
            this.f3929j.stop();
            this.f3938s.setVisibility(4);
            this.f3926g.setImageResource(R.drawable.recorder_player_recoding);
            this.f3926g.setEnabled(true);
            this.f3928i.setVisibility(0);
            this.f3934o = this.f3922c.m4093e();
            this.f3940u = false;
            if (GlobalApplication.m3265f()) {
                this.f3939t.setEnabled(true);
            }
            getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
        } catch (Exception e) {
            C1786r.m6061b(e.toString(), null);
            Toast.makeText(this, getResources().getString(R.string.chat_send_recordvodeo_toast_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4073e() {
        try {
            if (this.f3922c != null) {
                this.f3922c.m4092d();
                this.f3922c = null;
            }
        } catch (Exception e) {
            C1786r.m6061b(e.toString(), null);
            Toast.makeText(this, getResources().getString(R.string.chat_send_recordvodeo_toast_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m4075f() {
        String strM4093e = this.f3922c.m4093e();
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(strM4093e, 2);
        if (bitmapCreateVideoThumbnail != null) {
            this.f3930k.setImageBitmap(bitmapCreateVideoThumbnail);
            this.f3930k.setVisibility(0);
            this.f3930k.setTag(strM4093e);
            this.f3931l.setVisibility(0);
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 801) {
            Toast.makeText(this.f3933n, R.string.duration_2min_orver, 1).show();
            m4072d();
            m4075f();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        C1786r.m6067f("surfaceCreated() : ", f3920a);
        synchronized (VideoRecordActivity.class) {
            if (this.f3925f == null) {
                this.f3925f = m4077g();
                if (this.f3925f == null) {
                    return;
                }
            }
            try {
                this.f3925f.setPreviewDisplay(surfaceHolder);
                this.f3925f.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
                if (this.f3925f != null) {
                    this.f3925f.release();
                    this.f3925f = null;
                }
            }
            m4062a(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) throws IOException {
        C1786r.m6067f("surfaceChanged() : ", f3920a);
        if (surfaceHolder.getSurface() != null) {
            try {
                this.f3925f.stopPreview();
            } catch (Exception e) {
            }
            try {
                this.f3925f.setPreviewDisplay(surfaceHolder);
                this.f3925f.startPreview();
            } catch (Exception e2) {
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C1786r.m6061b("surfaceDestroyed : ", f3920a);
        if (this.f3925f != null) {
            this.f3925f.stopPreview();
            this.f3925f.release();
            this.f3925f = null;
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (GlobalApplication.m3265f()) {
            getMenuInflater().inflate(R.menu.actionbar_menu_send_cancel, menu);
            this.f3939t = menu.findItem(R.id.menu_send);
            this.f3939t.setEnabled(false);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_cancel /* 2131494116 */:
                m4073e();
                m4065a((String) null);
                finish();
                break;
            case R.id.menu_send /* 2131494119 */:
                m4065a(this.f3934o);
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: g */
    private Camera m4077g() {
        try {
            return Camera.open();
        } catch (Exception e) {
            C1786r.m6056a(e, getClass().getName());
            return null;
        }
    }
}
