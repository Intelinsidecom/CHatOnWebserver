package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyFilePlayerEntry;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/* loaded from: classes.dex */
public class RecordAudio extends Activity implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener {

    /* renamed from: C */
    private Timer f3224C;

    /* renamed from: D */
    private int f3225D;

    /* renamed from: E */
    private ImageView f3226E;

    /* renamed from: F */
    private TextView f3227F;

    /* renamed from: G */
    private RelativeLayout f3228G;

    /* renamed from: H */
    private BroadcastReceiver f3229H;

    /* renamed from: I */
    private BroadcastReceiver f3230I;

    /* renamed from: J */
    private AudioManager f3231J;

    /* renamed from: d */
    Timer f3234d;

    /* renamed from: f */
    private Context f3236f;

    /* renamed from: g */
    private ImageView f3237g;

    /* renamed from: h */
    private ImageView f3238h;

    /* renamed from: i */
    private ImageView f3239i;

    /* renamed from: j */
    private TextView f3240j;

    /* renamed from: k */
    private TextView f3241k;

    /* renamed from: l */
    private ImageView f3242l;

    /* renamed from: s */
    private SeekBar f3249s;

    /* renamed from: t */
    private MediaRecorder f3250t;

    /* renamed from: u */
    private MediaPlayer f3251u;

    /* renamed from: a */
    public static final String f3221a = RecordAudio.class.getSimpleName();

    /* renamed from: b */
    public static String f3222b = "extra fileuri";

    /* renamed from: B */
    private static String f3220B = null;

    /* renamed from: c */
    public int f3233c = 1;

    /* renamed from: m */
    private boolean f3243m = true;

    /* renamed from: n */
    private boolean f3244n = false;

    /* renamed from: o */
    private boolean f3245o = false;

    /* renamed from: p */
    private boolean f3246p = false;

    /* renamed from: q */
    private boolean f3247q = false;

    /* renamed from: r */
    private boolean f3248r = true;

    /* renamed from: v */
    private String f3252v = null;

    /* renamed from: w */
    private Message f3253w = new Message();

    /* renamed from: x */
    private int f3254x = 0;

    /* renamed from: y */
    private int f3255y = 120;

    /* renamed from: z */
    private int f3256z = 120;

    /* renamed from: A */
    private int f3223A = 0;

    /* renamed from: e */
    Handler f3235e = new HandlerC0890t(this);

    /* renamed from: K */
    private AudioManager.OnAudioFocusChangeListener f3232K = new C0888r(this);

    /* renamed from: a */
    static /* synthetic */ int m3568a(RecordAudio recordAudio) {
        int i = recordAudio.f3254x;
        recordAudio.f3254x = i + 1;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ int m3573b(RecordAudio recordAudio) {
        int i = recordAudio.f3255y;
        recordAudio.f3255y = i - 1;
        return i;
    }

    /* renamed from: l */
    static /* synthetic */ int m3598l(RecordAudio recordAudio) {
        int i = recordAudio.f3225D;
        recordAudio.f3225D = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (GlobalApplication.m3265f()) {
            try {
                getActionBar().setDisplayHomeAsUpEnabled(true);
            } catch (NullPointerException e) {
                if (C1786r.f6455e) {
                    C1786r.m6054a("recordaudio() returns null.", f3221a);
                }
            }
        }
        f3220B = getIntent().getStringExtra("inbox_NO");
        getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
        setContentView(R.layout.layout_multimedia_record_audio);
        this.f3236f = this;
        m3582d();
        m3599l();
        if (GlobalApplication.m3265f()) {
            getActionBar().setTitle(R.string.menu_multimedia_reocrd_audio);
        }
        this.f3231J = (AudioManager) getSystemService(SpecialBuddyFilePlayerEntry.FILEPLAYER_AUDIO);
        this.f3231J.requestAudioFocus(this.f3232K, 3, 1);
    }

    @Override // android.app.Activity
    protected void onResume() {
        m3602n();
        m3593i();
        super.onResume();
        m3605o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3571a() throws IllegalStateException, IOException, IllegalArgumentException {
        try {
            this.f3250t = new MediaRecorder();
            this.f3250t.setOnInfoListener(this);
            C1786r.m6060b("reset_here");
            this.f3250t.setAudioSource(1);
            this.f3250t.setOutputFormat(1);
            this.f3250t.setAudioEncoder(1);
            this.f3250t.setOutputFile(this.f3252v);
            this.f3250t.setMaxFileSize(1048576L);
            this.f3250t.setMaxDuration(120500);
        } catch (IllegalStateException e) {
            C1786r.m6056a(e, getClass().getName());
            Toast.makeText(this.f3236f, R.string.toast_error, 0).show();
        }
        try {
            this.f3250t.prepare();
        } catch (IOException e2) {
            C1786r.m6056a(e2, getClass().getName());
            Toast.makeText(this.f3236f, R.string.toast_error, 0).show();
        } catch (IllegalStateException e3) {
            C1786r.m6056a(e3, getClass().getName());
            Toast.makeText(this.f3236f, R.string.toast_error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3575b() {
        int i;
        int currentPosition;
        int i2;
        int i3;
        if (this.f3245o && this.f3251u != null) {
            if (this.f3251u.isPlaying()) {
                int currentPosition2 = this.f3251u.getCurrentPosition() / 60000;
                currentPosition = (this.f3251u.getCurrentPosition() / 1000) % 60;
                i = currentPosition2;
                i3 = 0;
                i2 = 0;
            } else {
                i3 = 0;
                i2 = 0;
                currentPosition = 0;
                i = 0;
            }
        } else {
            if (this.f3254x >= 1) {
                this.f3237g.setClickable(true);
            }
            i = this.f3254x / 60;
            currentPosition = this.f3254x % 60;
            i2 = this.f3255y / 60;
            i3 = this.f3255y % 60;
        }
        this.f3240j.setText(String.format("%d:%02d", Integer.valueOf(i), Integer.valueOf(currentPosition)));
        String str = String.format("%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f3244n || this.f3243m) {
            this.f3241k.setText("-" + str);
        } else if (!this.f3245o) {
            this.f3241k.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3579c() {
        this.f3254x = 0;
        this.f3234d = new Timer(true);
        this.f3234d.schedule(new C0881k(this, new Handler()), 1000L, 1000L);
        this.f3224C = new Timer(true);
        this.f3224C.schedule(new C0889s(this), 100L, 100L);
    }

    /* renamed from: d */
    private void m3582d() {
        File file;
        this.f3237g = (ImageView) findViewById(R.id.btn_start_record_audio);
        this.f3238h = (ImageView) findViewById(R.id.btn_cancel_record_audio);
        this.f3239i = (ImageView) findViewById(R.id.btn_send_record_audio);
        this.f3239i.setVisibility(4);
        this.f3240j = (TextView) findViewById(R.id.Timechek);
        this.f3241k = (TextView) findViewById(R.id.Timechekdim);
        this.f3242l = (ImageView) findViewById(R.id.record_bg);
        ContentValues contentValues = new ContentValues();
        this.f3249s = (SeekBar) findViewById(R.id.progressbar);
        this.f3249s.setEnabled(false);
        this.f3226E = (ImageView) findViewById(R.id.record_voice_recording);
        this.f3227F = (TextView) findViewById(R.id.record_voice_elapsed_time);
        this.f3226E.setEnabled(false);
        this.f3228G = (RelativeLayout) findViewById(R.id.progressbarLayout);
        this.f3239i.setOnClickListener(new ViewOnClickListenerC0891u(this));
        this.f3249s.setOnSeekBarChangeListener(new C0892v(this));
        contentValues.put("title", "title");
        contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
        new C0893w(this, this.f3236f);
        Uri uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
        if (C1767bw.m6002a()) {
            file = new File(GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() + "/" + f3220B);
            C1786r.m6060b("[path] storageAvailable" + file);
        } else {
            file = new File(GlobalApplication.m3260b().getFilesDir().getAbsolutePath() + "/" + f3220B);
            C1786r.m6060b("[path] storage is not Available" + file);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f3252v = file.getAbsolutePath() + "/" + String.valueOf(System.currentTimeMillis()) + "_" + this.f3254x + ".3gp";
        C1786r.m6060b("[path] finally path" + this.f3252v);
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f3247q = true;
        } else if (configuration.orientation == 1) {
            this.f3247q = false;
        }
        this.f3237g.setOnClickListener(new ViewOnClickListenerC0894x(this));
        this.f3238h.setOnClickListener(new ViewOnClickListenerC0895y(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2 = new Intent();
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(f3222b);
            C1786r.m6064d("uri:" + stringExtra);
            C1786r.m6064d("dateString:" + stringExtra);
            intent2.putExtra(f3222b, stringExtra);
            setResult(-1, intent2);
        } else {
            setResult(0, intent2);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3585e() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            if (this.f3251u == null) {
                this.f3251u = new MediaPlayer();
            }
            this.f3251u.setDataSource(this.f3252v);
            this.f3251u.setOnCompletionListener(new C0896z(this));
            this.f3251u.setOnPreparedListener(new C0883m(this));
            this.f3251u.prepare();
            try {
                this.f3255y = Integer.parseInt(Integer.toString(this.f3251u.getDuration()).substring(0, Integer.toString(this.f3251u.getDuration()).length() - 3));
                this.f3256z = this.f3255y;
                this.f3249s.setMax(this.f3251u.getDuration());
            } catch (Exception e) {
                C1786r.m6056a(e, getClass().getName());
                Toast.makeText(this.f3236f, R.string.toast_error, 0).show();
                m3590h();
            }
        } catch (IOException e2) {
            C1786r.m6056a(e2, getClass().getName());
            Toast.makeText(this.f3236f, R.string.toast_error, 1).show();
        }
    }

    /* renamed from: f */
    private void m3587f() {
        this.f3234d.cancel();
        this.f3224C.cancel();
        AlertDialog.Builder message = new AlertDialog.Builder(this).setTitle(R.string.media_file_size_1m).setMessage(R.string.ask_file_send);
        message.setNegativeButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0884n(this));
        message.setPositiveButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0885o(this));
        message.show();
        this.f3244n = false;
        this.f3245o = false;
        this.f3237g.setClickable(true);
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (i == 801) {
            m3587f();
            return;
        }
        if (i == 800) {
            if (GlobalApplication.m3265f()) {
            }
            Toast.makeText(this.f3236f, R.string.duration_2min_orver, 1).show();
            this.f3234d.cancel();
            this.f3224C.cancel();
            if (this.f3247q) {
                this.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
            } else {
                this.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
            }
            this.f3237g.setImageResource(R.drawable.recorder_player_play);
            this.f3248r = false;
            this.f3249s.setProgress(0);
            this.f3249s.setPressed(false);
            this.f3249s.setThumb(getResources().getDrawable(R.drawable.seek_thumb));
            this.f3244n = false;
            this.f3245o = false;
            this.f3250t.stop();
            this.f3250t.release();
            m3585e();
            this.f3254x = 0;
            this.f3225D = 0;
            this.f3255y = 120;
            this.f3256z = 120;
            m3575b();
            this.f3239i.setVisibility(0);
            this.f3226E.setEnabled(false);
            this.f3227F.setTextColor(this.f3236f.getResources().getColor(R.color.chat_rec_off));
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        boolean z = true;
        if (!C1721ad.m5887n() || !C1721ad.m5888o()) {
            z = false;
        }
        if (!z) {
            m3597k();
            if (this.f3245o || this.f3244n) {
                this.f3237g.performClick();
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalStateException, IOException {
        if (isFinishing()) {
            if (this.f3244n) {
                try {
                    this.f3250t.stop();
                    this.f3250t.release();
                } catch (Exception e) {
                    C1786r.m6056a(e, getClass().getName());
                    Toast.makeText(this.f3236f, R.string.toast_error, 1).show();
                }
            }
            if (this.f3251u != null) {
                try {
                    this.f3251u.stop();
                    this.f3251u.prepare();
                } catch (Exception e2) {
                    C1786r.m6056a(e2, getClass().getName());
                    Toast.makeText(this.f3236f, R.string.toast_error, 1).show();
                }
            }
        }
        if (this.f3230I != null) {
            unregisterReceiver(this.f3230I);
        }
        if (this.f3231J != null && this.f3232K != null) {
            this.f3231J.abandonAudioFocus(this.f3232K);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.f3247q = true;
            if (this.f3244n) {
                this.f3242l.setBackgroundResource(R.drawable.record_voice_bg_highlight);
                return;
            } else {
                this.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
                return;
            }
        }
        if (configuration.orientation == 1) {
            this.f3247q = false;
            if (this.f3244n) {
                this.f3242l.setBackgroundResource(R.drawable.record_voice_bg_highlight);
            } else {
                this.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3589g() throws IllegalStateException {
        this.f3244n = false;
        this.f3245o = false;
        this.f3237g.setClickable(true);
        this.f3234d.cancel();
        this.f3224C.cancel();
        this.f3226E.setEnabled(false);
        this.f3227F.setTextColor(this.f3236f.getResources().getColor(R.color.chat_rec_off));
        if (this.f3251u != null) {
            try {
                this.f3251u.stop();
                this.f3251u.release();
                this.f3251u = null;
            } catch (Exception e) {
                C1786r.m6056a(e, getClass().getName());
                Toast.makeText(this.f3236f, R.string.toast_error, 1).show();
            }
        }
        Intent intent = new Intent();
        intent.putExtra(f3222b, this.f3252v);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3590h() throws IllegalStateException {
        if (!this.f3243m) {
            this.f3234d.cancel();
            this.f3224C.cancel();
            this.f3239i.setVisibility(4);
            this.f3228G.setVisibility(4);
            if (GlobalApplication.m3265f()) {
            }
            if (this.f3247q) {
                this.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
            } else {
                this.f3242l.setBackgroundResource(R.drawable.chaton_chats_attach_record_mic);
            }
            if (this.f3251u != null) {
                try {
                    try {
                        this.f3251u.stop();
                        this.f3251u.release();
                    } catch (Exception e) {
                        C1786r.m6056a(e, getClass().getName());
                        Toast.makeText(this.f3236f, R.string.toast_error, 1).show();
                        this.f3251u.release();
                    }
                    this.f3251u = null;
                } catch (Throwable th) {
                    this.f3251u.release();
                    this.f3251u = null;
                    throw th;
                }
            }
            if (this.f3244n) {
                this.f3250t.stop();
                this.f3250t.release();
            }
            this.f3237g.setClickable(true);
            this.f3243m = true;
            this.f3244n = false;
            this.f3245o = false;
            this.f3248r = false;
            this.f3249s.setEnabled(false);
            this.f3249s.setProgress(0);
            this.f3249s.setPressed(false);
            this.f3249s.setThumb(new ColorDrawable(0));
            this.f3254x = 0;
            this.f3225D = 0;
            this.f3255y = 120;
            this.f3256z = 120;
            m3575b();
            this.f3249s.setMax(1200);
            this.f3237g.setImageResource(R.drawable.recorder_player_rec);
            this.f3226E.setEnabled(false);
            this.f3227F.setTextColor(this.f3236f.getResources().getColor(R.color.chat_rec_off));
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws IllegalStateException {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_cancel /* 2131494116 */:
                m3590h();
                break;
            case R.id.menu_send /* 2131494119 */:
                m3589g();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: i */
    private void m3593i() {
        this.f3229H = new C0886p(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f3229H, intentFilter);
        m3595j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3595j() {
        if (!C1767bw.m6002a()) {
            Toast.makeText(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: k */
    private void m3597k() {
        unregisterReceiver(this.f3229H);
    }

    /* renamed from: l */
    private void m3599l() {
        this.f3230I = new C0887q(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.music.musicservicecommand");
        intentFilter.addAction("com.android.music.musicservicecommand.pause");
        intentFilter.addAction("com.android.music.playstatechanged");
        registerReceiver(this.f3230I, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m3600m() {
        if (this.f3245o || this.f3244n) {
            this.f3237g.performClick();
        }
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        C1786r.m6064d("onError MediaRecorder:" + i + " , " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m3602n() {
        C1786r.m6060b("sendMusicServiceCommand_here");
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        this.f3236f.sendBroadcast(intent);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: o */
    private void m3605o() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
