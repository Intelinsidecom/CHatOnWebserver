package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/* loaded from: classes.dex */
public class RecordAudio extends Activity implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener {

    /* renamed from: C */
    private Timer f2621C;

    /* renamed from: D */
    private int f2622D;

    /* renamed from: E */
    private ImageView f2623E;

    /* renamed from: F */
    private TextView f2624F;

    /* renamed from: G */
    private RelativeLayout f2625G;

    /* renamed from: H */
    private BroadcastReceiver f2626H;

    /* renamed from: I */
    private BroadcastReceiver f2627I;

    /* renamed from: J */
    private AudioManager f2628J;

    /* renamed from: d */
    Timer f2631d;

    /* renamed from: f */
    private Context f2633f;

    /* renamed from: g */
    private ImageView f2634g;

    /* renamed from: h */
    private ImageView f2635h;

    /* renamed from: i */
    private ImageView f2636i;

    /* renamed from: j */
    private TextView f2637j;

    /* renamed from: k */
    private TextView f2638k;

    /* renamed from: l */
    private ImageView f2639l;

    /* renamed from: s */
    private SeekBar f2646s;

    /* renamed from: t */
    private MediaRecorder f2647t;

    /* renamed from: u */
    private MediaPlayer f2648u;

    /* renamed from: a */
    public static final String f2618a = RecordAudio.class.getSimpleName();

    /* renamed from: b */
    public static String f2619b = "extra fileuri";

    /* renamed from: B */
    private static String f2617B = null;

    /* renamed from: c */
    public int f2630c = 1;

    /* renamed from: m */
    private boolean f2640m = true;

    /* renamed from: n */
    private boolean f2641n = false;

    /* renamed from: o */
    private boolean f2642o = false;

    /* renamed from: p */
    private boolean f2643p = false;

    /* renamed from: q */
    private boolean f2644q = false;

    /* renamed from: r */
    private boolean f2645r = true;

    /* renamed from: v */
    private String f2649v = null;

    /* renamed from: w */
    private Message f2650w = new Message();

    /* renamed from: x */
    private int f2651x = 0;

    /* renamed from: y */
    private int f2652y = 120;

    /* renamed from: z */
    private int f2653z = 120;

    /* renamed from: A */
    private int f2620A = 0;

    /* renamed from: e */
    Handler f2632e = new HandlerC0776m(this);

    /* renamed from: K */
    private AudioManager.OnAudioFocusChangeListener f2629K = new C0770g(this);

    /* renamed from: a */
    static /* synthetic */ int m3226a(RecordAudio recordAudio) {
        int i = recordAudio.f2651x;
        recordAudio.f2651x = i + 1;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ int m3250i(RecordAudio recordAudio) {
        int i = recordAudio.f2622D;
        recordAudio.f2622D = i + 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            C1619g.m5888a(getBaseContext(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
            finish();
            return;
        }
        f2617B = getIntent().getStringExtra("inbox_NO");
        getWindow().addFlags(128);
        setContentView(R.layout.layout_multimedia_record_audio);
        this.f2633f = this;
        m3240d();
        m3257l();
        this.f2628J = (AudioManager) getSystemService("audio");
        this.f2628J.requestAudioFocus(this.f2629K, 3, 1);
    }

    @Override // android.app.Activity
    protected void onResume() {
        m3260n();
        m3251i();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3229a() throws IllegalStateException, IOException, IllegalArgumentException {
        this.f2647t = new MediaRecorder();
        this.f2647t.setOnInfoListener(this);
        try {
            this.f2647t.setAudioSource(1);
            this.f2647t.setOutputFormat(1);
            this.f2647t.setAudioEncoder(1);
            this.f2647t.setOutputFile(this.f2649v);
            this.f2647t.setMaxFileSize(1048576L);
            this.f2647t.setMaxDuration(120500);
        } catch (IllegalStateException e) {
            C1341p.m4653a(e, getClass().getName());
            C1619g.m5888a(this.f2633f, R.string.toast_error, 0).show();
        }
        try {
            this.f2647t.prepare();
        } catch (IOException e2) {
            C1341p.m4653a(e2, getClass().getName());
            C1619g.m5888a(this.f2633f, R.string.toast_error, 0).show();
        } catch (IllegalStateException e3) {
            C1341p.m4653a(e3, getClass().getName());
            C1619g.m5888a(this.f2633f, R.string.toast_error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3233b() {
        int i;
        int currentPosition;
        int i2;
        int i3;
        if (this.f2642o && this.f2648u != null) {
            if (this.f2648u.isPlaying()) {
                int currentPosition2 = this.f2648u.getCurrentPosition() / 60000;
                currentPosition = (this.f2648u.getCurrentPosition() / 1000) % 60;
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
            if (this.f2651x >= 1) {
                this.f2634g.setClickable(true);
            }
            i = this.f2651x / 60;
            currentPosition = this.f2651x % 60;
            i2 = this.f2652y / 60;
            i3 = this.f2652y % 60;
        }
        String str = String.format("%d:%02d", Integer.valueOf(i), Integer.valueOf(currentPosition));
        this.f2637j.setText(str);
        String str2 = String.format("%d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.f2641n || this.f2640m || !this.f2642o) {
            this.f2638k.setText(str2);
        }
        this.f2624F.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3237c() {
        this.f2651x = 0;
        this.f2631d = new Timer(true);
        this.f2631d.schedule(new C0777n(this, new Handler()), 1000L, 1000L);
        this.f2621C = new Timer(true);
        this.f2621C.schedule(new C0775l(this), 100L, 100L);
    }

    /* renamed from: d */
    private void m3240d() {
        File file;
        this.f2634g = (ImageView) findViewById(R.id.btn_start_record_audio);
        this.f2635h = (ImageView) findViewById(R.id.btn_cancel_record_audio);
        this.f2636i = (ImageView) findViewById(R.id.btn_send_record_audio);
        this.f2637j = (TextView) findViewById(R.id.Timechek);
        this.f2638k = (TextView) findViewById(R.id.Timechekdim);
        this.f2639l = (ImageView) findViewById(R.id.record_bg);
        ContentValues contentValues = new ContentValues();
        this.f2646s = (SeekBar) findViewById(R.id.progressbar);
        this.f2636i.setVisibility(4);
        this.f2623E = (ImageView) findViewById(R.id.record_voice_recording);
        this.f2624F = (TextView) findViewById(R.id.record_voice_elapsed_time);
        this.f2623E.setEnabled(false);
        this.f2625G = (RelativeLayout) findViewById(R.id.progressbarLayout);
        this.f2636i.setOnClickListener(new ViewOnClickListenerC0780q(this));
        this.f2646s.setOnTouchListener(new ViewOnTouchListenerC0781r(this));
        this.f2646s.setOnSeekBarChangeListener(new C0778o(this));
        contentValues.put("title", "title");
        contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
        new C0779p(this, this.f2633f);
        Uri uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
        if (C1327bw.m4595a()) {
            file = new File(GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() + "/" + f2617B);
        } else {
            file = new File(GlobalApplication.m3100a().getFilesDir().getAbsolutePath() + "/" + f2617B);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f2649v = file.getAbsolutePath() + "/" + String.valueOf(System.currentTimeMillis()) + "_" + this.f2651x + ".3gp";
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f2644q = true;
            this.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
            this.f2625G.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.record_voice_progressbar_height_h)));
        } else if (configuration.orientation == 1) {
            this.f2644q = false;
            this.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
            this.f2625G.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.record_voice_progressbar_height_v)));
        }
        this.f2634g.setOnClickListener(new ViewOnClickListenerC0773j(this));
        this.f2635h.setOnClickListener(new ViewOnClickListenerC0774k(this));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2 = new Intent();
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(f2619b);
            C1341p.m4659c("uri:" + stringExtra);
            C1341p.m4659c("dateString:" + stringExtra);
            intent2.putExtra(f2619b, stringExtra);
            setResult(-1, intent2);
        } else {
            setResult(0, intent2);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m3243e() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            if (this.f2648u == null) {
                this.f2648u = new MediaPlayer();
            }
            this.f2648u.setDataSource(this.f2649v);
            this.f2648u.setOnCompletionListener(new C0765b(this));
            this.f2648u.setOnPreparedListener(new C0769f(this));
            this.f2648u.prepare();
            try {
                this.f2652y = Integer.parseInt(Integer.toString(this.f2648u.getDuration()).substring(0, Integer.toString(this.f2648u.getDuration()).length() - 3));
                this.f2653z = this.f2652y;
                this.f2646s.setMax(this.f2648u.getDuration());
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getName());
                m3249h();
            }
        } catch (IOException e2) {
            C1341p.m4653a(e2, getClass().getName());
            C1619g.m5888a(this.f2633f, R.string.toast_error, 1).show();
        }
    }

    /* renamed from: f */
    private void m3245f() {
        this.f2631d.cancel();
        this.f2621C.cancel();
        AlertDialog.Builder message = new AlertDialogBuilderC1625m(this).setTitle(R.string.media_file_size_1m).setMessage(R.string.ask_file_send);
        message.setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0768e(this));
        message.setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0767d(this));
        message.show();
        this.f2641n = false;
        this.f2642o = false;
        this.f2634g.setClickable(true);
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (i == 801) {
            m3245f();
            return;
        }
        if (i == 800) {
            C1619g.m5888a(this.f2633f, R.string.duration_2min_orver, 1).show();
            this.f2631d.cancel();
            this.f2621C.cancel();
            if (this.f2644q) {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
            } else {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
            }
            this.f2634g.setImageResource(R.drawable.recorder_player_play);
            this.f2645r = false;
            this.f2646s.setProgress(0);
            this.f2646s.setPressed(false);
            this.f2641n = false;
            this.f2642o = false;
            this.f2647t.stop();
            this.f2647t.release();
            m3243e();
            this.f2651x = 0;
            this.f2622D = 0;
            this.f2652y = 120;
            this.f2653z = 120;
            m3233b();
            this.f2636i.setVisibility(0);
            this.f2623E.setEnabled(false);
            this.f2625G.setVisibility(4);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        m3254k();
        if (this.f2642o || this.f2641n) {
            this.f2634g.performClick();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalStateException, IOException {
        if (isFinishing()) {
            if (this.f2641n) {
                try {
                    this.f2647t.stop();
                    this.f2647t.release();
                } catch (Exception e) {
                    C1341p.m4653a(e, getClass().getName());
                    C1619g.m5888a(this.f2633f, R.string.toast_error, 1).show();
                }
            }
            if (this.f2648u != null) {
                try {
                    this.f2648u.stop();
                    this.f2648u.prepare();
                } catch (Exception e2) {
                    C1341p.m4653a(e2, getClass().getName());
                    C1619g.m5888a(this.f2633f, R.string.toast_error, 1).show();
                }
            }
        }
        if (this.f2627I != null) {
            unregisterReceiver(this.f2627I);
        }
        if (this.f2628J != null && this.f2629K != null) {
            this.f2628J.abandonAudioFocus(this.f2629K);
        }
        AudioManager audioManager = this.f2628J;
        AudioManager audioManager2 = this.f2628J;
        audioManager.setStreamMute(5, false);
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.f2644q = true;
            if (this.f2641n) {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg_highlight_h);
            } else {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
            }
            this.f2625G.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.record_voice_progressbar_height_h)));
            return;
        }
        if (configuration.orientation == 1) {
            this.f2644q = false;
            if (this.f2641n) {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg_highlight);
            } else {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
            }
            this.f2625G.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.record_voice_progressbar_height_v)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3246g() throws IllegalStateException {
        this.f2641n = false;
        this.f2642o = false;
        this.f2634g.setClickable(true);
        this.f2631d.cancel();
        this.f2621C.cancel();
        this.f2623E.setEnabled(false);
        if (this.f2648u != null) {
            try {
                this.f2648u.stop();
                this.f2648u.release();
                this.f2648u = null;
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getName());
                C1619g.m5888a(this.f2633f, R.string.toast_error, 1).show();
            }
        }
        Intent intent = new Intent();
        intent.putExtra(f2619b, this.f2649v);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m3249h() throws IllegalStateException {
        if (!this.f2640m) {
            this.f2631d.cancel();
            this.f2621C.cancel();
            this.f2636i.setVisibility(4);
            if (this.f2644q) {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg_h);
            } else {
                this.f2639l.setBackgroundResource(R.drawable.record_voice_bg);
            }
            try {
                if (this.f2648u != null) {
                    try {
                        this.f2648u.stop();
                        this.f2648u.release();
                    } catch (Exception e) {
                        C1341p.m4653a(e, getClass().getName());
                        C1619g.m5888a(this.f2633f, R.string.toast_error, 1).show();
                        this.f2648u.release();
                    }
                    this.f2648u = null;
                }
                if (this.f2641n) {
                    this.f2647t.stop();
                    this.f2647t.release();
                }
                this.f2634g.setClickable(true);
                this.f2640m = true;
                this.f2641n = false;
                this.f2642o = false;
                this.f2645r = false;
                this.f2646s.setProgress(0);
                this.f2646s.setPressed(false);
                this.f2651x = 0;
                this.f2622D = 0;
                this.f2652y = 120;
                this.f2653z = 120;
                m3233b();
                this.f2646s.setMax(1200);
                this.f2634g.setImageResource(R.drawable.recorder_player_rec);
                this.f2623E.setEnabled(false);
                this.f2625G.setVisibility(4);
                return;
            } catch (Throwable th) {
                this.f2648u.release();
                this.f2648u = null;
                throw th;
            }
        }
        finish();
    }

    /* renamed from: i */
    private void m3251i() {
        this.f2626H = new C0766c(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f2626H, intentFilter);
        m3252j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m3252j() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: k */
    private void m3254k() {
        unregisterReceiver(this.f2626H);
    }

    /* renamed from: l */
    private void m3257l() {
        this.f2627I = new C0771h(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.music.musicservicecommand");
        intentFilter.addAction("com.android.music.musicservicecommand.pause");
        intentFilter.addAction("com.android.music.playstatechanged");
        registerReceiver(this.f2627I, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m3258m() {
        if (this.f2642o || this.f2641n) {
            this.f2634g.performClick();
        }
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        C1341p.m4659c("onError MediaRecorder:" + i + " , " + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m3260n() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        intent.putExtra("ChatON", true);
        this.f2633f.sendBroadcast(intent);
    }
}
