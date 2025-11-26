package com.sec.vip.amschaton;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.Time;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class BackgroundAudioRecordActivity extends AMSViewerActivity implements View.OnClickListener {

    /* renamed from: A */
    private Time f4090A;

    /* renamed from: B */
    private Time f4091B;

    /* renamed from: u */
    private ImageView f4101u;

    /* renamed from: v */
    private ImageView f4102v;

    /* renamed from: w */
    private ImageView f4103w;

    /* renamed from: x */
    private ImageView f4104x;

    /* renamed from: y */
    private SeekBar f4105y;

    /* renamed from: z */
    private TextView f4106z;

    /* renamed from: m */
    private final int f4093m = 120000;

    /* renamed from: n */
    private final long f4094n = 500;

    /* renamed from: o */
    private CountDownTimer f4095o = null;

    /* renamed from: p */
    private boolean f4096p = false;

    /* renamed from: q */
    private boolean f4097q = false;

    /* renamed from: r */
    private MediaRecorder f4098r = null;

    /* renamed from: s */
    private String f4099s = null;

    /* renamed from: t */
    private String f4100t = null;

    /* renamed from: C */
    private int f4092C = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4112a(boolean z) {
        if (z) {
            this.f4102v.setVisibility(8);
            this.f4103w.setVisibility(0);
            this.f4104x.setEnabled(this.f4097q);
        } else {
            this.f4102v.setVisibility(0);
            this.f4103w.setVisibility(8);
            this.f4104x.setEnabled(this.f4097q);
        }
    }

    /* renamed from: i */
    private void m4123i() throws IllegalStateException, IOException {
        this.f4086a.m4194a(this.f4100t);
        this.f4086a.m4193a(true);
        ((LinearLayout) findViewById(C0062R.id.layout_ams)).addView(this.f4087b);
        m4112a(false);
    }

    /* renamed from: j */
    private void m4124j() throws IllegalStateException, IOException, IllegalArgumentException {
        this.f4099s = String.format(f3812i + "%08d.3gp", Integer.valueOf((int) (Math.random() * 1.0E8d)));
        this.f4098r = new MediaRecorder();
        this.f4098r.setAudioSource(1);
        this.f4098r.setOutputFormat(1);
        this.f4098r.setAudioEncoder(1);
        this.f4098r.setOutputFile(this.f4099s);
        this.f4098r.setMaxDuration(120000);
        this.f4098r.setOnInfoListener(new C0668bo(this));
        try {
            this.f4098r.prepare();
            this.f4098r.start();
        } catch (IOException e) {
            this.f4098r = null;
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            this.f4098r = null;
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m4125k() throws IllegalStateException {
        if (this.f4098r == null) {
            return;
        }
        this.f4098r.stop();
        this.f4098r.release();
        this.f4098r = null;
    }

    /* renamed from: l */
    private void m4126l() throws IllegalStateException {
        m4125k();
        if (this.f4099s == null) {
            return;
        }
        new File(this.f4099s).delete();
        this.f4099s = null;
    }

    /* renamed from: m */
    private void m4127m() {
        m4128n();
        this.f4095o = new CountDownTimerC0667bn(this, 120000L, 500L).start();
    }

    /* renamed from: n */
    private void m4128n() {
        m4129o();
        this.f4092C = 0;
        this.f4106z.setText(String.format("%d:%02d", Integer.valueOf(this.f4092C / 60), Integer.valueOf(this.f4092C % 60)));
        this.f4105y.setProgress(this.f4092C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m4129o() {
        if (this.f4095o == null) {
            return;
        }
        this.f4095o.cancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, IllegalArgumentException {
        switch (view.getId()) {
            case C0062R.id.btn_record_cancel /* 2131427373 */:
                if (!this.f4096p && !this.f4097q) {
                    finish();
                    break;
                } else {
                    this.f4096p = false;
                    this.f4097q = false;
                    m4128n();
                    m4126l();
                    this.f4086a.m4193a(true);
                    break;
                }
                break;
            case C0062R.id.btn_record_start /* 2131427374 */:
                this.f4097q = false;
                this.f4096p = true;
                this.f4090A.setToNow();
                this.f4090A.normalize(true);
                m4127m();
                m4124j();
                this.f4086a.m4189a();
                break;
            case C0062R.id.btn_record_add /* 2131427375 */:
                if (this.f4099s != null) {
                    Intent intent = new Intent();
                    intent.putExtra("REC_AUDIO_PATH", this.f4099s);
                    setResult(-1, intent);
                    finish();
                    break;
                }
                break;
            case C0062R.id.btn_record_stop /* 2131427376 */:
                this.f4097q = true;
                this.f4096p = false;
                m4129o();
                m4125k();
                this.f4086a.m4193a(true);
                break;
        }
        m4112a(this.f4096p);
    }

    @Override // com.sec.vip.amschaton.AMSViewerActivity, com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, IOException {
        super.onCreate(bundle);
        setContentView(C0062R.layout.ams_bg_record_layout);
        m4109a();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f4100t = extras.getString("AMS_FILE_PATH");
        } else {
            ChatONLogWriter.m3506b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            this.f4100t = "";
        }
        this.f4101u = (ImageView) findViewById(C0062R.id.btn_record_cancel);
        this.f4101u.setOnClickListener(this);
        this.f4102v = (ImageView) findViewById(C0062R.id.btn_record_start);
        this.f4102v.setOnClickListener(this);
        this.f4103w = (ImageView) findViewById(C0062R.id.btn_record_stop);
        this.f4103w.setOnClickListener(this);
        this.f4104x = (ImageView) findViewById(C0062R.id.btn_record_add);
        this.f4104x.setOnClickListener(this);
        this.f4104x.setEnabled(this.f4097q);
        this.f4105y = (SeekBar) findViewById(C0062R.id.progressbar);
        this.f4105y.setMax(120);
        this.f4105y.setOnTouchListener(new ViewOnTouchListenerC0670bq(this));
        this.f4106z = (TextView) findViewById(C0062R.id.tv_record_current);
        this.f4090A = new Time();
        this.f4091B = new Time();
        m4123i();
    }
}
