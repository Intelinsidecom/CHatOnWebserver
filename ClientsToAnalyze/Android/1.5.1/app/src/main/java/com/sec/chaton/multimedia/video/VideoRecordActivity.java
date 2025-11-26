package com.sec.chaton.multimedia.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class VideoRecordActivity extends Activity implements MediaRecorder.OnInfoListener, SurfaceHolder.Callback {

    /* renamed from: a */
    public static final String f2389a = VideoRecordActivity.class.getSimpleName();

    /* renamed from: c */
    private VideoRecordManager f2391c;

    /* renamed from: d */
    private SurfaceView f2392d;

    /* renamed from: e */
    private SurfaceHolder f2393e;

    /* renamed from: g */
    private ImageButton f2395g;

    /* renamed from: h */
    private ImageView f2396h;

    /* renamed from: i */
    private ImageView f2397i;

    /* renamed from: j */
    private Chronometer f2398j;

    /* renamed from: k */
    private ImageView f2399k;

    /* renamed from: l */
    private LinearLayout f2400l;

    /* renamed from: m */
    private ImageView f2401m;

    /* renamed from: n */
    private Context f2402n;

    /* renamed from: o */
    private String f2403o;

    /* renamed from: p */
    private File f2404p;

    /* renamed from: q */
    private C0333g f2405q;

    /* renamed from: r */
    private TextView f2406r;

    /* renamed from: s */
    private ImageView f2407s;

    /* renamed from: f */
    private boolean f2394f = false;

    /* renamed from: b */
    Handler f2390b = new HandlerC0332f(this);

    /* renamed from: a */
    private void m2668a() {
        setContentView(C0062R.layout.layout_attachment_record_video);
        this.f2392d = (SurfaceView) findViewById(C0062R.id.viewer_record_video);
        this.f2393e = this.f2392d.getHolder();
        this.f2393e.addCallback(this);
        this.f2393e.setType(3);
        this.f2399k = (ImageView) findViewById(C0062R.id.record_video_preview);
        this.f2400l = (LinearLayout) findViewById(C0062R.id.record_video_preview_playbutton_layout);
        this.f2401m = (ImageView) findViewById(C0062R.id.record_video_preview_playbutton);
        this.f2398j = (Chronometer) findViewById(C0062R.id.record_video_elapsed_time);
        this.f2406r = (TextView) findViewById(C0062R.id.record_video_file_size);
        this.f2406r.setText("  0K  /  10240K  ");
        this.f2407s = (ImageView) findViewById(C0062R.id.record_video_recording);
        this.f2395g = (ImageButton) findViewById(C0062R.id.btn_reset_start_record_video);
        this.f2396h = (ImageView) findViewById(C0062R.id.btn_cancel_stop_record_video);
        this.f2397i = (ImageView) findViewById(C0062R.id.btn_send_record_video);
        this.f2395g.setOnClickListener(new ViewOnClickListenerC0329c(this));
        this.f2396h.setOnClickListener(new ViewOnClickListenerC0330d(this));
        this.f2397i.setOnClickListener(new ViewOnClickListenerC0327a(this));
        this.f2401m.setOnClickListener(new ViewOnClickListenerC0328b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2670a(String str) {
        ChatONLogWriter.m3512f("RECORD VIDEO FILE URL : " + str, f2389a);
        this.f2404p = null;
        Intent intent = new Intent();
        if (str == null) {
            setResult(0, intent);
        } else {
            intent.setData(Uri.parse(str));
            setResult(-1, intent);
        }
        finish();
    }

    /* renamed from: b */
    private String m2672b() throws IOException {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                throw new IOException();
            }
            String str = GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() + "/recVideo";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file.exists() && !file.mkdirs()) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    ChatONLogWriter.m3506b(e.toString(), null);
                }
            }
            return str + "/chaton_" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".mp4";
        } catch (IOException e2) {
            ChatONLogWriter.m3506b(e2.toString(), null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2674c() {
        try {
            if (this.f2391c == null) {
                this.f2391c = new VideoRecordManager();
            }
            this.f2391c.m2693a(m2672b(), this.f2393e, this);
        } catch (Exception e) {
            ChatONLogWriter.m3506b(e.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2675d() {
        try {
            this.f2395g.setImageResource(C0062R.drawable.recorder_player_stop);
            this.f2397i.setVisibility(4);
            this.f2391c.m2694b();
            this.f2398j.setBase(SystemClock.elapsedRealtime());
            this.f2398j.start();
            this.f2407s.setVisibility(0);
            this.f2404p = new File(this.f2391c.m2697e());
            this.f2405q = new C0333g(this);
            this.f2405q.start();
            getWindow().addFlags(128);
        } catch (Exception e) {
            ChatONLogWriter.m3506b(e.toString(), null);
            Toast.makeText(this, getResources().getString(C0062R.string.chat_send_recordvodeo_toast_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2677e() {
        try {
            this.f2395g.setEnabled(false);
            this.f2391c.m2695c();
            this.f2398j.stop();
            this.f2407s.setVisibility(4);
            this.f2395g.setImageResource(C0062R.drawable.recorder_player_recoding);
            this.f2395g.setEnabled(true);
            this.f2397i.setVisibility(0);
            this.f2403o = this.f2391c.m2697e();
            getWindow().clearFlags(128);
        } catch (Exception e) {
            ChatONLogWriter.m3506b(e.toString(), null);
            Toast.makeText(this, getResources().getString(C0062R.string.chat_send_recordvodeo_toast_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2679f() {
        try {
            if (this.f2391c == null) {
                return;
            }
            this.f2391c.m2696d();
            this.f2391c = null;
        } catch (Exception e) {
            ChatONLogWriter.m3506b(e.toString(), null);
            Toast.makeText(this, getResources().getString(C0062R.string.chat_send_recordvodeo_toast_failed), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2681g() {
        String strM2697e = this.f2391c.m2697e();
        Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(strM2697e, 2);
        if (bitmapCreateVideoThumbnail != null) {
            this.f2399k.setImageBitmap(bitmapCreateVideoThumbnail);
            this.f2399k.setVisibility(0);
            this.f2399k.setTag(strM2697e);
            this.f2400l.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2402n = this;
        m2668a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        m2679f();
        super.onDestroy();
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 801) {
            Toast.makeText(this.f2402n, C0062R.string.duration_2min_orver, 1).show();
            m2677e();
            m2681g();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        m2679f();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ChatONLogWriter.m3512f("onResume() : " + this.f2394f, f2389a);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ChatONLogWriter.m3512f("surfaceChanged() : " + this.f2394f, f2389a);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f2394f) {
            return;
        }
        this.f2394f = true;
        m2674c();
        ChatONLogWriter.m3512f("surfaceCreated() : " + this.f2394f, f2389a);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f2394f = false;
        ChatONLogWriter.m3506b("surfaceDestroyed : " + this.f2394f, f2389a);
    }
}
