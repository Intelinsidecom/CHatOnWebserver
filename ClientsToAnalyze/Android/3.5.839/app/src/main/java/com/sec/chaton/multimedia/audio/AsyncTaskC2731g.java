package com.sec.chaton.multimedia.audio;

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
import com.sec.chaton.R;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/* compiled from: RecordVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.g */
/* loaded from: classes.dex */
public class AsyncTaskC2731g extends AsyncTask<String, Integer, String> implements MediaRecorder.OnInfoListener {

    /* renamed from: a */
    private static final String f9794a = AsyncTaskC2731g.class.getSimpleName();

    /* renamed from: b */
    private MediaRecorder f9795b;

    /* renamed from: c */
    private AudioManager f9796c;

    /* renamed from: d */
    private String f9797d;

    /* renamed from: e */
    private boolean f9798e;

    /* renamed from: f */
    private String f9799f;

    /* renamed from: g */
    private Timer f9800g;

    /* renamed from: h */
    private int f9801h;

    /* renamed from: i */
    private LinearLayout f9802i;

    /* renamed from: j */
    private ImageView f9803j;

    /* renamed from: k */
    private TextView f9804k;

    /* renamed from: l */
    private ProgressBar f9805l;

    /* renamed from: m */
    private Handler f9806m;

    /* renamed from: n */
    private boolean f9807n;

    /* renamed from: o */
    private Context f9808o;

    /* renamed from: p */
    private BroadcastReceiver f9809p;

    /* renamed from: r */
    private View f9811r;

    /* renamed from: s */
    private boolean f9812s;

    /* renamed from: q */
    private boolean f9810q = true;

    /* renamed from: t */
    private AudioManager.OnAudioFocusChangeListener f9813t = new C2736l(this);

    /* renamed from: a */
    static /* synthetic */ int m11468a(AsyncTaskC2731g asyncTaskC2731g, int i) {
        int i2 = asyncTaskC2731g.f9801h + i;
        asyncTaskC2731g.f9801h = i2;
        return i2;
    }

    public AsyncTaskC2731g(String str, LinearLayout linearLayout, Handler handler, Context context, View view, boolean z) {
        this.f9797d = str;
        this.f9802i = linearLayout;
        this.f9806m = handler;
        this.f9808o = context;
        this.f9811r = view;
        this.f9812s = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws InterruptedException {
        this.f9800g = new Timer(true);
        this.f9800g.scheduleAtFixedRate(new C2732h(this), 1000L, 1000L);
        while (!this.f9798e && !isCancelled()) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f9794a);
                }
            }
        }
        return this.f9799f;
    }

    /* renamed from: b */
    private void m11475b() throws IllegalStateException {
        try {
            if (this.f9795b != null) {
                this.f9795b.stop();
                this.f9795b.release();
            }
            this.f9795b = null;
            this.f9800g.cancel();
            if (this.f9796c != null) {
                this.f9796c.abandonAudioFocus(this.f9813t);
            }
            C2726b.m11429a().m11440a(false);
        } catch (IllegalStateException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f9794a);
            }
        }
        this.f9803j.setImageResource(R.drawable.chat_none_recoding);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() throws IllegalStateException, IOException, IllegalArgumentException {
        File file;
        super.onPreExecute();
        m11479c();
        this.f9803j = (ImageView) this.f9802i.findViewById(R.id.push_talk_recording);
        this.f9804k = (TextView) this.f9802i.findViewById(R.id.push_talk_time);
        this.f9805l = (ProgressBar) this.f9802i.findViewById(R.id.push_talk_progressbar);
        m11483f();
        if (C4873ck.m18500a() && CommonApplication.m18732r().getExternalFilesDir(null) != null) {
            file = new File(CommonApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() + "/" + this.f9797d);
        } else {
            file = new File(CommonApplication.m18732r().getFilesDir().getAbsolutePath() + "/" + this.f9797d);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f9799f = file.getAbsolutePath() + "/" + String.valueOf(System.currentTimeMillis()) + ".3gp";
        this.f9796c = (AudioManager) CommonApplication.m18732r().getSystemService("audio");
        this.f9796c.requestAudioFocus(this.f9813t, 3, 1);
        m11484g();
        this.f9795b = new MediaRecorder();
        this.f9795b.setOnInfoListener(this);
        this.f9795b.setAudioSource(1);
        this.f9795b.setOutputFormat(1);
        this.f9795b.setAudioEncoder(1);
        this.f9795b.setOutputFile(this.f9799f);
        this.f9795b.setMaxFileSize(1048576L);
        this.f9795b.setMaxDuration(120500);
        try {
            this.f9795b.prepare();
            this.f9795b.start();
            C2726b.m11429a().m11440a(true);
        } catch (IOException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f9794a);
            }
            this.f9798e = true;
        } catch (IllegalStateException e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f9794a);
            }
            this.f9798e = true;
        } catch (Exception e3) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e3, f9794a);
            }
            this.f9798e = true;
        }
    }

    /* renamed from: c */
    private void m11479c() {
        this.f9809p = new C2733i(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f9808o.registerReceiver(this.f9809p, intentFilter);
        m11481d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m11481d() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.sdcard_not_found, 0).show();
            this.f9798e = true;
            this.f9810q = false;
        }
    }

    /* renamed from: e */
    private void m11482e() {
        if (this.f9809p != null) {
            this.f9808o.unregisterReceiver(this.f9809p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws IllegalStateException {
        super.onPostExecute(str);
        m11475b();
        m11482e();
        Message messageObtainMessage = this.f9806m.obtainMessage();
        messageObtainMessage.obj = str;
        if (this.f9801h >= 13) {
            messageObtainMessage.arg1 = this.f9801h;
        } else {
            m11477b(this.f9799f);
        }
        if (!this.f9807n || this.f9812s) {
            if (this.f9810q) {
                m11470a(messageObtainMessage);
                return;
            }
            m11477b(this.f9799f);
            Message messageObtainMessage2 = this.f9806m.obtainMessage();
            messageObtainMessage2.obj = str;
            m11470a(messageObtainMessage2);
            return;
        }
        AbstractC4932a.m18733a(this.f9808o).mo18734a(R.string.setting_push_to_talk).mo18749b(CommonApplication.m18732r().getString(R.string.record_voice_alert_message, 2, 2)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2735k(this, messageObtainMessage)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2734j(this, str)).mo18751b(false).mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11477b(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteFile : " + str, f9794a);
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
    public void m11470a(Message message) {
        this.f9806m.sendMessage(message);
    }

    /* renamed from: f */
    private void m11483f() {
        this.f9805l.setProgress(0);
        this.f9803j.setImageResource(R.drawable.chat_none_recoding);
        this.f9804k.setText(String.format("%d:%02d/%d:%02d", 0, 0, 2, 0));
        this.f9801h = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.f9811r != null && !this.f9811r.isPressed()) {
            this.f9798e = true;
            return;
        }
        this.f9805l.setProgress(numArr[0].intValue());
        if (numArr[0].intValue() % 10 == 0) {
            int iIntValue = numArr[0].intValue() / 600;
            int iIntValue2 = (numArr[0].intValue() / 10) % 60;
            this.f9804k.setText(String.format("%d:%02d/%d:%02d", Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), 2, 0));
            if (!this.f9798e) {
                if (iIntValue2 % 2 == 0) {
                    this.f9803j.setImageResource(R.drawable.chat_recoding_2);
                    return;
                } else {
                    this.f9803j.setImageResource(R.drawable.chat_recoding);
                    return;
                }
            }
            this.f9803j.setImageResource(R.drawable.chat_none_recoding);
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() throws IllegalStateException {
        super.onCancelled();
        m11475b();
        m11482e();
        m11477b(this.f9799f);
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 800) {
            this.f9798e = true;
            this.f9807n = true;
        }
    }

    /* renamed from: a */
    public void m11487a(boolean z) {
        this.f9798e = z;
    }

    /* renamed from: g */
    private void m11484g() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        CommonApplication.m18732r().sendBroadcast(intent);
    }
}
