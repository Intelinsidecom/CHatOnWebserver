package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1070el;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.util.Timer;

/* compiled from: PlayVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.h */
/* loaded from: classes.dex */
public class AsyncTaskC1776h extends AsyncTask<String, Integer, String> implements MediaPlayer.OnCompletionListener {

    /* renamed from: j */
    private static final String f6568j = AsyncTaskC1776h.class.getSimpleName();

    /* renamed from: a */
    protected View f6569a;

    /* renamed from: b */
    protected long f6570b;

    /* renamed from: c */
    protected ImageView f6571c;

    /* renamed from: d */
    protected TextView f6572d;

    /* renamed from: e */
    protected boolean f6573e;

    /* renamed from: f */
    protected int f6574f;

    /* renamed from: g */
    protected int f6575g;

    /* renamed from: h */
    protected AnimationDrawable f6576h;

    /* renamed from: i */
    protected long f6577i;

    /* renamed from: k */
    private String f6578k;

    /* renamed from: l */
    private Timer f6579l;

    /* renamed from: m */
    private MediaPlayer f6580m;

    /* renamed from: n */
    private AudioManager f6581n;

    /* renamed from: o */
    private boolean f6582o;

    /* renamed from: p */
    private boolean f6583p;

    /* renamed from: q */
    private AudioManager.OnAudioFocusChangeListener f6584q = new C1778j(this);

    public AsyncTaskC1776h(View view, String str, long j, boolean z) {
        this.f6569a = view;
        this.f6578k = str;
        this.f6570b = j;
        this.f6573e = z;
        C3250y.m11450b("messageId: " + this.f6570b + ", mPath:" + this.f6578k, f6568j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        this.f6581n = (AudioManager) CommonApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.f6581n.requestAudioFocus(this.f6584q, 3, 1);
        m7335i();
        this.f6580m = new MediaPlayer();
        try {
            if (this.f6580m != null) {
                this.f6580m.reset();
                if (!TextUtils.isEmpty(this.f6578k) && this.f6578k.startsWith("file:")) {
                    this.f6578k = Uri.parse(this.f6578k).getPath();
                }
                this.f6580m.setDataSource(this.f6578k);
                this.f6580m.prepare();
                this.f6580m.start();
                this.f6582o = true;
                this.f6580m.setOnCompletionListener(this);
            }
            this.f6574f = this.f6580m.getDuration() / 60000;
            this.f6575g = (this.f6580m.getDuration() / 1000) % 60;
            this.f6579l = new Timer(true);
            this.f6579l.schedule(new C1777i(this), 0L, 300L);
            while (!isCancelled() && this.f6582o) {
            }
            if (!this.f6582o) {
                publishProgress(Integer.valueOf(this.f6580m.getDuration()));
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.f6578k;
        } catch (IOException e2) {
            C3250y.m11443a(e2, f6568j);
            return "null";
        } catch (IllegalArgumentException e3) {
            C3250y.m11443a(e3, f6568j);
            return "null";
        } catch (IllegalStateException e4) {
            C3250y.m11443a(e4, f6568j);
            return "null";
        } catch (SecurityException e5) {
            C3250y.m11443a(e5, f6568j);
            return "null";
        }
    }

    /* renamed from: g */
    private void m7333g() throws IllegalStateException {
        if (this.f6579l != null) {
            this.f6579l.cancel();
        }
        if (this.f6580m != null) {
            if (this.f6582o) {
                this.f6580m.stop();
            }
            this.f6580m.release();
        }
        mo6906b();
        if (this.f6581n != null) {
            this.f6581n.abandonAudioFocus(this.f6584q);
        }
    }

    /* renamed from: b */
    protected void mo6906b() {
        C1770b.m7289a().m7297a(this);
    }

    /* renamed from: h */
    private void m7334h() {
        if (this.f6571c != null) {
            this.f6571c.setImageResource(R.drawable.chat_attach_btn_icon_walkie_talkie);
            if (this.f6576h != null) {
                this.f6576h.stop();
            }
        }
        if (this.f6572d != null) {
            if (this.f6574f > 0 || this.f6575g > 0) {
                this.f6572d.setText(String.format("0:00/%d:%02d", Integer.valueOf(this.f6574f), Integer.valueOf(this.f6575g)));
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        mo6904a();
        super.onPreExecute();
    }

    /* renamed from: a */
    protected void mo6904a() {
        if (this.f6569a != null) {
            C1070el c1070el = (C1070el) this.f6569a.getTag();
            this.f6577i = c1070el.f4273c;
            if (this.f6577i == this.f6570b) {
                if (this.f6573e) {
                    this.f6571c = c1070el.f4229R;
                    this.f6572d = c1070el.f4230S;
                } else {
                    this.f6571c = c1070el.f4293w;
                    this.f6572d = c1070el.f4294x;
                }
                this.f6571c.setImageResource(R.drawable.chat_push_to_talk_play);
                this.f6576h = (AnimationDrawable) this.f6571c.getDrawable();
                if (this.f6576h != null && !this.f6576h.isRunning()) {
                    this.f6576h.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws IllegalStateException {
        m7333g();
        m7334h();
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f6569a != null) {
            this.f6577i = ((C1070el) this.f6569a.getTag()).f4273c;
            if (this.f6577i == this.f6570b) {
                String str = String.format("%d:%02d/%d:%02d", Integer.valueOf(numArr[0].intValue() / 60000), Integer.valueOf((numArr[0].intValue() / 1000) % 60), Integer.valueOf(this.f6574f), Integer.valueOf(this.f6575g));
                if (this.f6572d != null) {
                    this.f6572d.setText(str);
                }
            }
        }
        super.onProgressUpdate(numArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() throws IllegalStateException {
        m7333g();
        m7334h();
        super.onCancelled();
    }

    /* renamed from: i */
    private void m7335i() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        CommonApplication.m11493l().sendBroadcast(intent);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f6582o = false;
    }

    /* renamed from: c */
    public long m7340c() {
        return this.f6570b;
    }

    /* renamed from: a */
    public void m7337a(View view) {
        this.f6569a = view;
        mo6904a();
    }

    /* renamed from: b */
    public void m7339b(String str) {
        this.f6578k = str;
    }

    /* renamed from: d */
    public String m7341d() {
        return this.f6578k;
    }

    /* renamed from: e */
    public boolean m7342e() {
        return this.f6580m != null && this.f6580m.isPlaying() && this.f6580m.getCurrentPosition() > 500;
    }
}
