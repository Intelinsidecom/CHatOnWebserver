package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.k */
/* loaded from: classes.dex */
public class AsyncTaskC1779k extends AsyncTask<String, Integer, String> implements MediaRecorder.OnInfoListener {

    /* renamed from: a */
    private static final String f6587a = AsyncTaskC1779k.class.getSimpleName();

    /* renamed from: b */
    private MediaRecorder f6588b;

    /* renamed from: c */
    private AudioManager f6589c;

    /* renamed from: d */
    private String f6590d;

    /* renamed from: e */
    private boolean f6591e;

    /* renamed from: f */
    private String f6592f;

    /* renamed from: g */
    private Timer f6593g;

    /* renamed from: h */
    private int f6594h;

    /* renamed from: i */
    private LinearLayout f6595i;

    /* renamed from: j */
    private ImageView f6596j;

    /* renamed from: k */
    private TextView f6597k;

    /* renamed from: l */
    private ProgressBar f6598l;

    /* renamed from: m */
    private Handler f6599m;

    /* renamed from: n */
    private boolean f6600n;

    /* renamed from: o */
    private Context f6601o;

    /* renamed from: p */
    private BroadcastReceiver f6602p;

    /* renamed from: r */
    private View f6604r;

    /* renamed from: q */
    private boolean f6603q = true;

    /* renamed from: s */
    private AudioManager.OnAudioFocusChangeListener f6605s = new C1784p(this);

    /* renamed from: a */
    static /* synthetic */ int m7344a(AsyncTaskC1779k asyncTaskC1779k, int i) {
        int i2 = asyncTaskC1779k.f6594h + i;
        asyncTaskC1779k.f6594h = i2;
        return i2;
    }

    public AsyncTaskC1779k(String str, LinearLayout linearLayout, Handler handler, Activity activity, View view) {
        this.f6590d = str;
        this.f6595i = linearLayout;
        this.f6599m = handler;
        this.f6601o = activity;
        this.f6604r = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws InterruptedException {
        this.f6593g = new Timer(true);
        this.f6593g.scheduleAtFixedRate(new C1780l(this), 1000L, 1000L);
        while (!this.f6591e) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f6587a);
                }
            }
        }
        return this.f6592f;
    }

    /* renamed from: b */
    private void m7351b() throws IllegalStateException {
        try {
            if (this.f6588b != null) {
                try {
                    this.f6588b.stop();
                    this.f6588b.release();
                } catch (Exception e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f6587a);
                    }
                }
            }
            this.f6588b = null;
            this.f6593g.cancel();
            if (this.f6589c != null) {
                this.f6589c.abandonAudioFocus(this.f6605s);
            }
            C1770b.m7289a().m7300a(false);
        } catch (Exception e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f6587a);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() throws IllegalStateException, IOException, IllegalArgumentException {
        File file;
        super.onPreExecute();
        m7355c();
        this.f6596j = (ImageView) this.f6595i.findViewById(R.id.push_talk_recording);
        this.f6597k = (TextView) this.f6595i.findViewById(R.id.push_talk_time);
        this.f6598l = (ProgressBar) this.f6595i.findViewById(R.id.push_talk_progressbar);
        m7359f();
        if (C3223ck.m11327a()) {
            file = new File(CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f6590d);
        } else {
            file = new File(CommonApplication.m11493l().getFilesDir().getAbsolutePath() + "/" + this.f6590d);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f6592f = file.getAbsolutePath() + "/" + String.valueOf(System.currentTimeMillis()) + ".3gp";
        this.f6589c = (AudioManager) CommonApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.f6589c.requestAudioFocus(this.f6605s, 3, 1);
        m7360g();
        this.f6588b = new MediaRecorder();
        this.f6588b.setOnInfoListener(this);
        this.f6588b.setAudioSource(1);
        this.f6588b.setOutputFormat(1);
        this.f6588b.setAudioEncoder(1);
        this.f6588b.setOutputFile(this.f6592f);
        this.f6588b.setMaxFileSize(1048576L);
        this.f6588b.setMaxDuration(120500);
        try {
            this.f6588b.prepare();
            this.f6588b.start();
            C1770b.m7289a().m7300a(true);
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f6587a);
            }
            this.f6591e = true;
        } catch (IllegalStateException e2) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e2, f6587a);
            }
            this.f6591e = true;
        } catch (Exception e3) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e3, f6587a);
            }
            this.f6591e = true;
        }
    }

    /* renamed from: c */
    private void m7355c() {
        this.f6602p = new C1781m(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f6601o.registerReceiver(this.f6602p, intentFilter);
        m7357d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7357d() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.sdcard_not_found, 0).show();
            this.f6591e = true;
            this.f6603q = false;
        }
    }

    /* renamed from: e */
    private void m7358e() {
        if (this.f6602p != null) {
            this.f6601o.unregisterReceiver(this.f6602p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws IllegalStateException {
        super.onPostExecute(str);
        m7351b();
        m7358e();
        Message messageObtainMessage = this.f6599m.obtainMessage();
        messageObtainMessage.obj = str;
        if (this.f6594h >= 13) {
            messageObtainMessage.arg1 = this.f6594h;
        } else {
            m7353b(this.f6592f);
        }
        if (!this.f6600n) {
            if (this.f6603q) {
                m7346a(messageObtainMessage);
                return;
            }
            m7353b(this.f6592f);
            Message messageObtainMessage2 = this.f6599m.obtainMessage();
            messageObtainMessage2.obj = str;
            m7346a(messageObtainMessage2);
            return;
        }
        AbstractC3271a.m11494a(this.f6601o).mo11495a(R.string.setting_push_to_talk).mo11509b(CommonApplication.m11493l().getString(R.string.record_voice_alert_message, 2, 2)).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1783o(this, messageObtainMessage)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1782n(this, str)).mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7353b(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("deleteFile : " + str, f6587a);
        }
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7346a(Message message) {
        m7359f();
        this.f6599m.sendMessage(message);
    }

    /* renamed from: f */
    private void m7359f() {
        this.f6598l.setProgress(0);
        this.f6596j.setEnabled(true);
        this.f6597k.setText("0:00");
        this.f6594h = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f6604r != null && !this.f6604r.isPressed()) {
            this.f6591e = true;
            return;
        }
        this.f6598l.setProgress(numArr[0].intValue());
        if (numArr[0].intValue() % 10 == 0) {
            this.f6597k.setText(String.format("%d:%02d", Integer.valueOf(numArr[0].intValue() / 600), Integer.valueOf((numArr[0].intValue() / 10) % 60)));
            if (this.f6596j.isEnabled()) {
                this.f6596j.setEnabled(false);
            } else {
                this.f6596j.setEnabled(true);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() throws IllegalStateException {
        super.onCancelled();
        m7351b();
        m7358e();
        m7353b(this.f6592f);
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 800) {
            this.f6591e = true;
            this.f6600n = true;
        }
    }

    /* renamed from: a */
    public void m7363a(boolean z) {
        this.f6591e = z;
    }

    /* renamed from: g */
    private void m7360g() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        CommonApplication.m11493l().sendBroadcast(intent);
    }
}
