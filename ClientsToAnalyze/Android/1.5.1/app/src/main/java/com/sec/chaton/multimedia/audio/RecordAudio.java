package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/* loaded from: classes.dex */
public class RecordAudio extends Activity implements MediaRecorder.OnInfoListener {

    /* renamed from: c */
    Timer f2053c;

    /* renamed from: e */
    private Context f2055e;

    /* renamed from: f */
    private Button f2056f;

    /* renamed from: g */
    private ImageButton f2057g;

    /* renamed from: h */
    private ImageButton f2058h;

    /* renamed from: i */
    private TextView f2059i;

    /* renamed from: j */
    private TextView f2060j;

    /* renamed from: k */
    private ImageView f2061k;

    /* renamed from: l */
    private ImageView f2062l;

    /* renamed from: s */
    private SeekBar f2069s;

    /* renamed from: t */
    private MediaRecorder f2070t;

    /* renamed from: u */
    private MediaPlayer f2071u;

    /* renamed from: a */
    public static String f2050a = "extra fileuri";

    /* renamed from: B */
    private static String f2049B = null;

    /* renamed from: b */
    public int f2052b = 1;

    /* renamed from: m */
    private boolean f2063m = true;

    /* renamed from: n */
    private boolean f2064n = false;

    /* renamed from: o */
    private boolean f2065o = false;

    /* renamed from: p */
    private boolean f2066p = false;

    /* renamed from: q */
    private boolean f2067q = false;

    /* renamed from: r */
    private boolean f2068r = true;

    /* renamed from: v */
    private String f2072v = null;

    /* renamed from: w */
    private Message f2073w = new Message();

    /* renamed from: x */
    private int f2074x = 0;

    /* renamed from: y */
    private int f2075y = 120;

    /* renamed from: z */
    private int f2076z = 120;

    /* renamed from: A */
    private int f2051A = 0;

    /* renamed from: d */
    Handler f2054d = new HandlerC0275f(this);

    /* renamed from: a */
    static /* synthetic */ int m2464a(RecordAudio recordAudio) {
        int i = recordAudio.f2074x;
        recordAudio.f2074x = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2468a() throws IllegalStateException, IOException, IllegalArgumentException {
        this.f2070t = new MediaRecorder();
        this.f2070t.setOnInfoListener(this);
        try {
            this.f2070t.setAudioSource(1);
            this.f2070t.setOutputFormat(1);
            this.f2070t.setAudioEncoder(1);
            this.f2070t.setOutputFile(this.f2072v);
            this.f2070t.setMaxFileSize(1048576L);
            this.f2070t.setMaxDuration(121000);
        } catch (IllegalStateException e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
            Toast.makeText(this.f2055e, C0062R.string.toast_error, 0).show();
        }
        try {
            this.f2070t.prepare();
        } catch (IOException e2) {
            ChatONLogWriter.m3501a(e2, getClass().getName());
            Toast.makeText(this.f2055e, C0062R.string.toast_error, 0).show();
        } catch (IllegalStateException e3) {
            ChatONLogWriter.m3501a(e3, getClass().getName());
            Toast.makeText(this.f2055e, C0062R.string.toast_error, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2472b() {
        if (this.f2074x >= 1) {
            this.f2056f.setClickable(true);
        }
        String string = Integer.toString(this.f2074x / 60);
        String string2 = Integer.toString(this.f2074x % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(this.f2075y / 60);
        String string4 = Integer.toString(this.f2075y % 60);
        if (string4.length() == 1) {
            string4 = "0" + string4;
        }
        this.f2059i.setText(String.format("%s:%s", string, string2));
        this.f2060j.setText(String.format("-%s:%s", string3, string4));
    }

    /* renamed from: c */
    static /* synthetic */ int m2474c(RecordAudio recordAudio) {
        int i = recordAudio.f2075y;
        recordAudio.f2075y = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2476c() {
        this.f2074x = 0;
        this.f2053c = new Timer(true);
        this.f2053c.schedule(new C0277h(this, new Handler()), 1000L, 1000L);
    }

    /* renamed from: d */
    private void m2479d() {
        this.f2056f = (Button) findViewById(C0062R.id.btn_start_record_audio);
        this.f2057g = (ImageButton) findViewById(C0062R.id.btn_cancel_record_audio);
        this.f2058h = (ImageButton) findViewById(C0062R.id.btn_send_record_audio);
        this.f2059i = (TextView) findViewById(C0062R.id.Timechek);
        this.f2060j = (TextView) findViewById(C0062R.id.Timechekdim);
        this.f2061k = (ImageView) findViewById(C0062R.id.record_bg);
        this.f2062l = (ImageView) findViewById(C0062R.id.record_status);
        ContentValues contentValues = new ContentValues();
        this.f2069s = (SeekBar) findViewById(C0062R.id.progressbar);
        this.f2069s.setEnabled(false);
        this.f2058h.setVisibility(4);
        this.f2058h.setOnClickListener(new ViewOnClickListenerC0276g(this));
        this.f2069s.setOnSeekBarChangeListener(new C0280k(this));
        contentValues.put("title", "title");
        contentValues.put("date_added", Long.valueOf(System.currentTimeMillis()));
        new C0281l(this, this.f2055e);
        Uri uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
        File file = StorageStateInfoUtil.m3677a() ? new File(GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() + "/" + f2049B) : new File(GlobalApplication.m2387e().getFilesDir().getAbsolutePath() + "/" + f2049B);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f2072v = file.getAbsolutePath() + "/" + String.valueOf(System.currentTimeMillis()) + "_" + this.f2074x + ".3gp";
        Configuration configuration = getResources().getConfiguration();
        if (configuration.orientation == 2) {
            this.f2067q = true;
            if (this.f2064n) {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_recoding_h);
            } else {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
            }
        } else if (configuration.orientation == 1) {
            this.f2067q = false;
            if (this.f2064n) {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_recoding);
            } else {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
        }
        this.f2056f.setOnClickListener(new ViewOnClickListenerC0278i(this));
        this.f2057g.setOnClickListener(new ViewOnClickListenerC0279j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2482e() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            if (this.f2071u == null) {
                this.f2071u = new MediaPlayer();
            }
            this.f2071u.setDataSource(this.f2072v);
            this.f2071u.setOnCompletionListener(new C0273d(this));
            this.f2071u.setOnPreparedListener(new C0274e(this));
            this.f2071u.prepare();
            this.f2075y = Integer.parseInt(Integer.toString(this.f2071u.getDuration()).substring(0, Integer.toString(this.f2071u.getDuration()).length() - 3));
            this.f2076z = this.f2075y;
            this.f2069s.setMax(this.f2071u.getDuration() / 100);
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
            Toast.makeText(this.f2055e, C0062R.string.toast_error, 1).show();
        }
    }

    /* renamed from: f */
    private void m2484f() {
        this.f2053c.cancel();
        AlertDialog.Builder message = new AlertDialog.Builder(this).setTitle(C0062R.string.media_file_size_1m).setMessage(C0062R.string.ask_file_send);
        message.setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0270a(this));
        message.setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0271b(this));
        message.show();
        this.f2064n = false;
        this.f2065o = false;
        this.f2056f.setClickable(true);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2 = new Intent();
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(f2050a);
            ChatONLogWriter.m3509d("uri:" + stringExtra);
            ChatONLogWriter.m3509d("dateString:" + stringExtra);
            intent2.putExtra(f2050a, stringExtra);
            setResult(-1, intent2);
        } else {
            setResult(0, intent2);
        }
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.f2067q = true;
            if (this.f2064n) {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_recoding_h);
                return;
            } else {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
                return;
            }
        }
        if (configuration.orientation == 1) {
            this.f2067q = false;
            if (this.f2064n) {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_recoding);
            } else {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = 0.75f;
        getWindow().setAttributes(layoutParams);
        f2049B = intent.getStringExtra("inbox_NO");
        getWindow().addFlags(128);
        setContentView(C0062R.layout.layout_multimedia_record_audio);
        this.f2055e = this;
        m2479d();
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalStateException, IOException {
        if (isFinishing()) {
            if (this.f2064n) {
                try {
                    this.f2070t.stop();
                    this.f2070t.release();
                } catch (Exception e) {
                    ChatONLogWriter.m3501a(e, getClass().getName());
                    Toast.makeText(this.f2055e, C0062R.string.toast_error, 1).show();
                }
            }
            if (this.f2071u != null) {
                try {
                    this.f2071u.stop();
                    this.f2071u.prepare();
                } catch (Exception e2) {
                    ChatONLogWriter.m3501a(e2, getClass().getName());
                    Toast.makeText(this.f2055e, C0062R.string.toast_error, 1).show();
                }
            }
        }
        super.onDestroy();
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (i == 801) {
            m2484f();
            return;
        }
        if (i == 800) {
            Toast.makeText(this.f2055e, C0062R.string.duration_2min_orver, 1).show();
            this.f2053c.cancel();
            if (this.f2067q) {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
            } else {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
            this.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_play);
            this.f2062l.setVisibility(8);
            this.f2068r = false;
            this.f2069s.setProgress(0);
            this.f2064n = false;
            this.f2065o = false;
            this.f2070t.stop();
            this.f2070t.release();
            m2482e();
            this.f2074x = 0;
            m2472b();
            this.f2058h.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    protected void onPause() throws IllegalStateException, IOException {
        super.onPause();
        if (this.f2065o) {
            this.f2053c.cancel();
            if (this.f2067q) {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg_h);
            } else {
                this.f2061k.setBackgroundResource(C0062R.drawable.record_voice_bg);
            }
            this.f2056f.setBackgroundResource(C0062R.drawable.recorder_player_play);
            this.f2062l.setVisibility(8);
            this.f2074x = 0;
            this.f2075y = this.f2076z;
            m2472b();
            this.f2065o = false;
            this.f2068r = false;
            this.f2069s.setEnabled(false);
            this.f2069s.setProgress(0);
            try {
                this.f2071u.stop();
                this.f2071u.prepare();
            } catch (Exception e) {
                ChatONLogWriter.m3501a(e, getClass().getName());
                Toast.makeText(this.f2055e, C0062R.string.toast_error, 1).show();
            }
        }
        this.f2066p = true;
        if (this.f2063m) {
        }
    }
}
