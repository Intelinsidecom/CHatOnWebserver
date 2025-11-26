package com.sec.chaton.multimedia.audio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.util.C5034k;
import java.io.File;

/* compiled from: VoiceRecordDialog.java */
/* renamed from: com.sec.chaton.multimedia.audio.w */
/* loaded from: classes.dex */
public class DialogC2747w extends Dialog {

    /* renamed from: a */
    private Button f9852a;

    /* renamed from: b */
    private Button f9853b;

    /* renamed from: c */
    private ImageButton f9854c;

    /* renamed from: d */
    private TextView f9855d;

    /* renamed from: e */
    private C2743s f9856e;

    /* renamed from: f */
    private LinearLayout f9857f;

    /* renamed from: g */
    private ImageView f9858g;

    /* renamed from: h */
    private ImageView f9859h;

    /* renamed from: i */
    private ImageView f9860i;

    /* renamed from: j */
    private AsyncTaskC2731g f9861j;

    /* renamed from: k */
    private String f9862k;

    /* renamed from: l */
    private LinearLayout f9863l;

    /* renamed from: m */
    private boolean f9864m;

    /* renamed from: n */
    private Handler f9865n;

    /* renamed from: o */
    private View f9866o;

    /* renamed from: p */
    private ProgressBar f9867p;

    /* renamed from: q */
    private int f9868q;

    /* renamed from: r */
    private int f9869r;

    /* renamed from: s */
    private TextView f9870s;

    /* renamed from: t */
    private String f9871t;

    /* renamed from: u */
    private int f9872u;

    /* renamed from: v */
    private boolean f9873v;

    /* renamed from: w */
    private Activity f9874w;

    /* renamed from: x */
    private Handler f9875x;

    /* renamed from: y */
    private Handler f9876y;

    public DialogC2747w(Activity activity, Handler handler, View view, String str, boolean z) {
        super(activity, R.style.AppTheme_Dialog);
        this.f9875x = new HandlerC2724aa(this);
        this.f9876y = new HandlerC2725ab(this);
        this.f9874w = activity;
        this.f9865n = handler;
        this.f9866o = view;
        this.f9864m = z;
        this.f9862k = str;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m11523c();
    }

    /* renamed from: c */
    private void m11523c() {
        setContentView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.voice_record, (ViewGroup) null));
        this.f9863l = (LinearLayout) findViewById(R.id.inputTalkLayout);
        this.f9852a = (Button) findViewById(R.id.startRecord);
        this.f9853b = (Button) findViewById(R.id.sendRecord);
        this.f9854c = (ImageButton) findViewById(R.id.playRecord);
        this.f9859h = (ImageView) findViewById(R.id.walkie_talkie_image);
        this.f9858g = (ImageView) findViewById(R.id.line);
        this.f9860i = (ImageView) findViewById(R.id.push_talk_recording);
        this.f9857f = (LinearLayout) findViewById(R.id.inputButtonLayout);
        this.f9855d = (TextView) findViewById(R.id.recordComplete);
        this.f9867p = (ProgressBar) findViewById(R.id.push_talk_progressbar);
        this.f9870s = (TextView) findViewById(R.id.push_talk_time);
        this.f9859h.setBackgroundResource(R.drawable.chat_attach_btn_icon_voice);
        this.f9855d.setVisibility(8);
        this.f9852a.setOnClickListener(new ViewOnClickListenerC2748x(this));
        this.f9853b.setOnClickListener(new ViewOnClickListenerC2749y(this));
        this.f9854c.setOnClickListener(new ViewOnClickListenerC2750z(this));
        m11515a(2, 0, 0, 0);
        if (!this.f9864m) {
            this.f9857f.setVisibility(8);
            this.f9858g.setVisibility(8);
            this.f9859h.setBackgroundResource(R.drawable.chat_attach_btn_icon_walkie_talkie_2);
            m11525d();
        }
    }

    /* renamed from: a */
    public void m11538a() throws IllegalStateException {
        if (this.f9861j != null) {
            this.f9861j.m11487a(true);
        }
        if (this.f9856e != null) {
            this.f9856e.m11507a();
        }
        if (this.f9874w != null) {
            this.f9874w.setRequestedOrientation(-1);
            this.f9874w.getWindow().clearFlags(128);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11515a(int i, int i2, int i3, int i4) {
        String str = String.format("%d:%02d/%d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.f9870s != null) {
            this.f9870s.setText(str);
        }
    }

    /* renamed from: b */
    public void m11539b() {
        this.f9852a.setVisibility(8);
        this.f9857f.setVisibility(0);
        this.f9858g.setVisibility(0);
        this.f9854c.setVisibility(0);
        this.f9853b.setVisibility(0);
        this.f9855d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public void m11525d() {
        C2726b.m11429a().m11442b();
        if (this.f9864m) {
            this.f9861j = new AsyncTaskC2731g(this.f9862k, this.f9863l, this.f9876y, this.f9874w, this.f9866o, this.f9864m);
        } else {
            this.f9861j = new AsyncTaskC2731g(this.f9862k, this.f9863l, this.f9865n, this.f9874w, this.f9866o, this.f9864m);
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.f9861j.execute(new String[0]);
        } else {
            this.f9861j.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
        if (getContext() != null) {
            if (!this.f9864m && Settings.System.getInt(getContext().getContentResolver(), "accelerometer_rotation", 0) == 1) {
                this.f9874w.setRequestedOrientation(C5034k.m19089a(this.f9874w));
            }
            getWindow().addFlags(128);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (this.f9861j != null) {
            this.f9861j.cancel(true);
        }
        m11527e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m11527e() {
        if (this.f9871t != null) {
            File file = new File(this.f9871t);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() throws IllegalStateException {
        super.dismiss();
        if (this.f9856e != null) {
            this.f9856e.m11507a();
            this.f9856e.m11509b();
        }
        if (this.f9874w != null) {
            this.f9874w.setRequestedOrientation(-1);
            this.f9874w.getWindow().clearFlags(128);
        }
    }
}
