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
import com.sec.chaton.R;
import com.sec.chaton.chat.C1729gb;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.util.Timer;

/* compiled from: PlayVoiceTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.d */
/* loaded from: classes.dex */
public class AsyncTaskC2728d extends AsyncTask<String, Integer, String> implements MediaPlayer.OnCompletionListener {

    /* renamed from: j */
    private static final String f9774j = AsyncTaskC2728d.class.getSimpleName();

    /* renamed from: a */
    protected View f9775a;

    /* renamed from: b */
    protected long f9776b;

    /* renamed from: c */
    protected ImageView f9777c;

    /* renamed from: d */
    protected TextView f9778d;

    /* renamed from: e */
    protected boolean f9779e;

    /* renamed from: f */
    protected int f9780f;

    /* renamed from: g */
    protected int f9781g;

    /* renamed from: h */
    protected AnimationDrawable f9782h;

    /* renamed from: i */
    protected long f9783i;

    /* renamed from: k */
    private String f9784k;

    /* renamed from: l */
    private Timer f9785l;

    /* renamed from: m */
    private MediaPlayer f9786m;

    /* renamed from: n */
    private AudioManager f9787n;

    /* renamed from: o */
    private boolean f9788o;

    /* renamed from: p */
    private boolean f9789p;

    /* renamed from: q */
    private boolean f9790q;

    /* renamed from: r */
    private AudioManager.OnAudioFocusChangeListener f9791r = new C2730f(this);

    public AsyncTaskC2728d(View view, String str, long j, boolean z) {
        this.f9775a = view;
        this.f9784k = str;
        this.f9776b = j;
        this.f9779e = z;
        C4904y.m18639b("messageId: " + this.f9776b + ", mPath:" + this.f9784k, f9774j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        this.f9787n = (AudioManager) CommonApplication.m18732r().getSystemService("audio");
        this.f9787n.requestAudioFocus(this.f9791r, 3, 1);
        m11459i();
        this.f9786m = new MediaPlayer();
        try {
            this.f9786m.reset();
            if (!TextUtils.isEmpty(this.f9784k) && this.f9784k.startsWith("file:")) {
                this.f9784k = Uri.parse(this.f9784k).getPath();
            }
            this.f9786m.setDataSource(this.f9784k);
            this.f9786m.prepare();
            this.f9786m.start();
            this.f9788o = true;
            this.f9786m.setOnCompletionListener(this);
            this.f9780f = this.f9786m.getDuration() / 60000;
            this.f9781g = (this.f9786m.getDuration() / 1000) % 60;
            this.f9785l = new Timer(true);
            this.f9785l.schedule(new C2729e(this), 0L, 300L);
            while (!isCancelled() && this.f9788o) {
            }
            if (!this.f9788o) {
                publishProgress(Integer.valueOf(this.f9786m.getDuration()));
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.f9784k;
        } catch (IOException e2) {
            C4904y.m18635a(e2, f9774j);
            return "null";
        } catch (IllegalArgumentException e3) {
            C4904y.m18635a(e3, f9774j);
            return "null";
        } catch (IllegalStateException e4) {
            C4904y.m18635a(e4, f9774j);
            return "null";
        } catch (SecurityException e5) {
            C4904y.m18635a(e5, f9774j);
            return "null";
        }
    }

    /* renamed from: g */
    private void m11457g() throws IllegalStateException {
        if (this.f9785l != null) {
            this.f9785l.cancel();
        }
        if (this.f9786m != null) {
            if (this.f9788o) {
                this.f9786m.stop();
            }
            this.f9786m.release();
        }
        mo10936b();
        if (this.f9787n != null) {
            this.f9787n.abandonAudioFocus(this.f9791r);
        }
    }

    /* renamed from: b */
    protected void mo10936b() {
        C2726b.m11429a().m11437a(this);
    }

    /* renamed from: h */
    private void m11458h() {
        if (this.f9777c != null) {
            this.f9777c.setImageResource(R.drawable.chat_attach_btn_icon_walkie_talkie);
            if (this.f9782h != null) {
                this.f9782h.stop();
            }
        }
        if (this.f9778d != null) {
            if (this.f9780f > 0 || this.f9781g > 0) {
                this.f9778d.setText(String.format("%d:%02d/%d:%02d", 0, 0, Integer.valueOf(this.f9780f), Integer.valueOf(this.f9781g)));
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        mo10934a();
        super.onPreExecute();
    }

    /* renamed from: a */
    protected void mo10934a() {
        if (this.f9775a != null) {
            C1729gb c1729gb = (C1729gb) this.f9775a.getTag();
            this.f9783i = c1729gb.f6458c;
            if (this.f9783i == this.f9776b) {
                if (this.f9779e) {
                    this.f9777c = c1729gb.f6408Z;
                    this.f9778d = c1729gb.f6431aa;
                } else {
                    this.f9777c = c1729gb.f6481z;
                    this.f9778d = c1729gb.f6383A;
                }
                this.f9777c.setImageResource(R.drawable.chat_push_to_talk_play);
                this.f9782h = (AnimationDrawable) this.f9777c.getDrawable();
                if (this.f9782h != null && !this.f9782h.isRunning()) {
                    this.f9782h.start();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws IllegalStateException {
        m11457g();
        m11458h();
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        if (this.f9775a != null) {
            this.f9783i = ((C1729gb) this.f9775a.getTag()).f6458c;
            if (this.f9783i == this.f9776b) {
                String str = String.format("%d:%02d/%d:%02d", Integer.valueOf(numArr[0].intValue() / 60000), Integer.valueOf((numArr[0].intValue() / 1000) % 60), Integer.valueOf(this.f9780f), Integer.valueOf(this.f9781g));
                if (this.f9778d != null) {
                    this.f9778d.setText(str);
                }
                if (!this.f9790q && this.f9777c != null) {
                    this.f9777c.setImageResource(R.drawable.chat_push_to_talk_play);
                    this.f9782h = (AnimationDrawable) this.f9777c.getDrawable();
                    if (this.f9782h != null && !this.f9782h.isRunning()) {
                        this.f9782h.start();
                    }
                    this.f9790q = true;
                }
            }
        }
        super.onProgressUpdate(numArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() throws IllegalStateException {
        m11457g();
        m11458h();
        super.onCancelled();
    }

    /* renamed from: i */
    private void m11459i() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        CommonApplication.m18732r().sendBroadcast(intent);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f9788o = false;
    }

    /* renamed from: c */
    public long m11464c() {
        return this.f9776b;
    }

    /* renamed from: a */
    public void m11461a(View view) {
        this.f9775a = view;
        mo10934a();
    }

    /* renamed from: b */
    public void m11463b(String str) {
        this.f9784k = str;
    }

    /* renamed from: d */
    public String m11465d() {
        return this.f9784k;
    }

    /* renamed from: e */
    public boolean m11466e() {
        return this.f9786m != null && this.f9786m.isPlaying() && this.f9786m.getCurrentPosition() > 500;
    }
}
