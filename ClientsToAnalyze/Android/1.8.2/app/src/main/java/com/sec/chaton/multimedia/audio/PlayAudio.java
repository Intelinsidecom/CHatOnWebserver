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
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.util.C1786r;
import java.io.IOException;
import java.util.Timer;

/* loaded from: classes.dex */
public class PlayAudio extends Activity {

    /* renamed from: a */
    public static String f3207a = "extra division";

    /* renamed from: b */
    public static String f3208b = "record";

    /* renamed from: c */
    public static String f3209c = "bubble";

    /* renamed from: m */
    private static final String f3210m = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: d */
    TextView f3211d;

    /* renamed from: e */
    Timer f3212e;

    /* renamed from: f */
    private Context f3213f;

    /* renamed from: h */
    private String f3215h;

    /* renamed from: i */
    private String f3216i;

    /* renamed from: g */
    private MediaPlayer f3214g = new MediaPlayer();

    /* renamed from: j */
    private boolean f3217j = false;

    /* renamed from: k */
    private int f3218k = 0;

    /* renamed from: l */
    private int f3219l = 0;

    /* renamed from: d */
    static /* synthetic */ int m3555d(PlayAudio playAudio) {
        int i = playAudio.f3219l;
        playAudio.f3219l = i - 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_multimedia_play_audio);
        this.f3213f = this;
        Intent intent = getIntent();
        this.f3215h = intent.getStringExtra(ChatFragment.f1748d);
        this.f3218k = Integer.parseInt(intent.getStringExtra("recordtime"));
        this.f3216i = intent.getStringExtra(f3207a);
        C1786r.m6064d("maintime:" + this.f3218k);
        m3553b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3550a() {
        int i = this.f3218k / 60;
        String string = Integer.toString(i);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(this.f3218k % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(i / 60);
        if (string3.length() == 1) {
            string3 = "0" + string3;
        }
        this.f3211d.setText(String.format("%s:%s:%s", string3, string, string2));
    }

    /* renamed from: b */
    private void m3553b() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Button button = (Button) findViewById(R.id.btn_start_play_audio);
        Button button2 = (Button) findViewById(R.id.btn_stop_play_audio);
        Button button3 = (Button) findViewById(R.id.btn_send);
        Button button4 = (Button) findViewById(R.id.btn_discard);
        this.f3211d = (TextView) findViewById(R.id.Timechek);
        if (this.f3216i.equals(f3209c)) {
            button3.setVisibility(8);
            button4.setVisibility(8);
        }
        try {
            this.f3214g.setDataSource(this.f3215h);
            this.f3214g.prepare();
            this.f3218k = this.f3214g.getDuration();
            this.f3218k = Integer.parseInt(Integer.toString(this.f3218k).substring(0, Integer.toString(this.f3218k).length() - 3));
            this.f3214g.setOnCompletionListener(new C0874d(this, button));
            C1786r.m6064d("mainTime:" + this.f3218k);
        } catch (IOException e) {
            C1786r.m6056a(e, getClass().getName());
            Toast.makeText(this.f3213f, R.string.toast_error, 1).show();
        }
        m3550a();
        button.setOnClickListener(new ViewOnClickListenerC0875e(this, button));
        button2.setOnClickListener(new ViewOnClickListenerC0878h(this, button));
        button3.setOnClickListener(new ViewOnClickListenerC0879i(this));
        button4.setOnClickListener(new ViewOnClickListenerC0880j(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f3214g != null) {
            this.f3214g.release();
            this.f3214g = null;
        }
    }
}
