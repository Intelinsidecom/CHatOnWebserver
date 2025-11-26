package com.sec.chaton.multimedia.audio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;

/* compiled from: PlaySoundTask.java */
/* renamed from: com.sec.chaton.multimedia.audio.d */
/* loaded from: classes.dex */
public class AsyncTaskC1772d extends AsyncTask<String, Integer, String> implements MediaPlayer.OnCompletionListener {

    /* renamed from: d */
    private static final String f6545d = AsyncTaskC1772d.class.getSimpleName();

    /* renamed from: a */
    String f6546a;

    /* renamed from: b */
    Handler f6547b;

    /* renamed from: c */
    InterfaceC1775g f6548c;

    /* renamed from: e */
    private String f6549e;

    /* renamed from: f */
    private String f6550f;

    /* renamed from: h */
    private MediaPlayer f6552h;

    /* renamed from: i */
    private AudioManager f6553i;

    /* renamed from: j */
    private boolean f6554j;

    /* renamed from: g */
    private boolean f6551g = false;

    /* renamed from: k */
    private EnumC1774f f6555k = EnumC1774f.PLAY_STATUS_FINISHED;

    /* renamed from: l */
    private AudioManager.OnAudioFocusChangeListener f6556l = new C1773e(this);

    /* renamed from: a */
    public EnumC1774f m7314a() {
        return this.f6555k;
    }

    public AsyncTaskC1772d(String str, String str2, Handler handler) {
        m7319a(str, str2, handler, false);
    }

    public AsyncTaskC1772d(String str, String str2, Handler handler, boolean z) {
        m7319a(str, str2, handler, z);
    }

    /* renamed from: a */
    void m7319a(String str, String str2, Handler handler, boolean z) {
        this.f6546a = str;
        this.f6551g = z;
        this.f6550f = str2;
        this.f6549e = str2;
        this.f6547b = handler;
        if (z && str2 != null) {
            try {
                this.f6549e = new File(C3332a.m11751a(CommonApplication.m11493l()), String.valueOf(str2.hashCode())).getPath();
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f6545d);
                }
            }
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("constructor(), mFilePath (is_url/filepath) : " + z + "/" + str2, f6545d);
        }
    }

    /* renamed from: b */
    public String m7321b() {
        return this.f6546a;
    }

    /* renamed from: c */
    public void m7322c() {
        this.f6547b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!new File(this.f6549e).exists()) {
            m7316a(EnumC1774f.PLAY_STATUS_DOWNLOADING);
        }
        super.onPreExecute();
    }

    /* renamed from: a */
    void m7316a(EnumC1774f enumC1774f) {
        this.f6555k = enumC1774f;
        if (this.f6547b != null) {
            Message.obtain(this.f6547b, enumC1774f.m7324a(), this).sendToTarget();
        }
        if (this.f6548c != null) {
            this.f6548c.mo7325a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) throws IllegalStateException, InterruptedException, IOException, SecurityException, IllegalArgumentException {
        if (this.f6551g) {
            String str = this.f6550f;
            try {
                C3332a.m11750a().m11753a(str, new File(this.f6549e));
                m7316a(EnumC1774f.PLAY_STATUS_STARTED);
            } catch (IOException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f6545d);
                }
                m7316a(EnumC1774f.PLAY_STATUS_DOWNLOAD_FAILED);
                cancel(true);
            } catch (InterruptedException e2) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e2, f6545d);
                }
                cancel(true);
                m7316a(EnumC1774f.PLAY_STATUS_DOWNLOAD_INTERRUPTED);
            }
        } else {
            m7316a(EnumC1774f.PLAY_STATUS_STARTED);
        }
        this.f6553i = (AudioManager) CommonApplication.m11493l().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.f6553i.requestAudioFocus(this.f6556l, 3, 1);
        m7313e();
        this.f6552h = new MediaPlayer();
        try {
            if (this.f6552h != null) {
                this.f6552h.reset();
                if (!TextUtils.isEmpty(this.f6549e) && this.f6549e.startsWith("file:")) {
                    this.f6549e = Uri.parse(this.f6549e).getPath();
                }
                this.f6552h.setDataSource(this.f6549e);
                this.f6552h.prepare();
                this.f6552h.start();
                this.f6554j = true;
                this.f6552h.setOnCompletionListener(this);
            }
            while (!isCancelled() && this.f6554j) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
            }
            return this.f6549e;
        } catch (IOException e4) {
            C3250y.m11443a(e4, f6545d);
            return "null";
        } catch (IllegalArgumentException e5) {
            C3250y.m11443a(e5, f6545d);
            return "null";
        } catch (IllegalStateException e6) {
            C3250y.m11443a(e6, f6545d);
            return "null";
        } catch (SecurityException e7) {
            C3250y.m11443a(e7, f6545d);
            return "null";
        }
    }

    /* renamed from: d */
    private void m7312d() throws IllegalStateException {
        if (this.f6552h != null) {
            if (this.f6554j) {
                this.f6552h.stop();
            }
            this.f6552h.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) throws IllegalStateException {
        m7312d();
        m7316a(EnumC1774f.PLAY_STATUS_FINISHED);
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() throws IllegalStateException {
        m7312d();
        m7316a(EnumC1774f.PLAY_STATUS_CANCELED);
        super.onCancelled();
    }

    /* renamed from: e */
    private void m7313e() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        CommonApplication.m11493l().sendBroadcast(intent);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f6554j = false;
    }

    /* renamed from: a */
    public void m7317a(InterfaceC1775g interfaceC1775g) {
        this.f6548c = interfaceC1775g;
    }
}
