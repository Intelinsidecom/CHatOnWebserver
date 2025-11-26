package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.IOException;
import java.util.Timer;

/* loaded from: classes.dex */
public class PlayAudio extends Activity {

    /* renamed from: a */
    public static String f2036a = "extra division";

    /* renamed from: b */
    public static String f2037b = "record";

    /* renamed from: c */
    public static String f2038c = "bubble";

    /* renamed from: m */
    private static final String f2039m = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: d */
    TextView f2040d;

    /* renamed from: e */
    Timer f2041e;

    /* renamed from: f */
    private Context f2042f;

    /* renamed from: h */
    private String f2044h;

    /* renamed from: i */
    private String f2045i;

    /* renamed from: g */
    private MediaPlayer f2043g = new MediaPlayer();

    /* renamed from: j */
    private boolean f2046j = false;

    /* renamed from: k */
    private int f2047k = 0;

    /* renamed from: l */
    private int f2048l = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2455a() {
        int i = this.f2047k / 60;
        String string = Integer.toString(i);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(this.f2047k % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(i / 60);
        if (string3.length() == 1) {
            string3 = "0" + string3;
        }
        this.f2040d.setText(String.format("%s:%s:%s", string3, string, string2));
    }

    /* renamed from: b */
    private void m2458b() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Button button = (Button) findViewById(C0062R.id.btn_start_play_audio);
        Button button2 = (Button) findViewById(C0062R.id.btn_stop_play_audio);
        Button button3 = (Button) findViewById(C0062R.id.btn_send);
        Button button4 = (Button) findViewById(C0062R.id.btn_discard);
        this.f2040d = (TextView) findViewById(C0062R.id.Timechek);
        if (this.f2045i.equals(f2038c)) {
            button3.setVisibility(8);
            button4.setVisibility(8);
        }
        try {
            this.f2043g.setDataSource(this.f2044h);
            this.f2043g.prepare();
            this.f2047k = this.f2043g.getDuration();
            this.f2047k = Integer.parseInt(Integer.toString(this.f2047k).substring(0, Integer.toString(this.f2047k).length() - 3));
            this.f2043g.setOnCompletionListener(new C0288s(this, button));
            ChatONLogWriter.m3509d("mainTime:" + this.f2047k);
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, getClass().getName());
            Toast.makeText(this.f2042f, C0062R.string.toast_error, 1).show();
        }
        m2455a();
        button.setOnClickListener(new ViewOnClickListenerC0289t(this, button));
        button2.setOnClickListener(new ViewOnClickListenerC0284o(this, button));
        button3.setOnClickListener(new ViewOnClickListenerC0285p(this));
        button4.setOnClickListener(new ViewOnClickListenerC0286q(this));
    }

    /* renamed from: d */
    static /* synthetic */ int m2460d(PlayAudio playAudio) {
        int i = playAudio.f2048l;
        playAudio.f2048l = i - 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_multimedia_play_audio);
        this.f2042f = this;
        Intent intent = getIntent();
        this.f2044h = intent.getStringExtra(ChatFragment.f723b);
        this.f2047k = Integer.parseInt(intent.getStringExtra("recordtime"));
        this.f2045i = intent.getStringExtra(f2036a);
        ChatONLogWriter.m3509d("maintime:" + this.f2047k);
        m2458b();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f2043g != null) {
            this.f2043g.release();
            this.f2043g = null;
        }
    }
}
