package com.sec.chaton.multimedia.audio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.io.IOException;
import java.util.Timer;

/* loaded from: classes.dex */
public class PlayAudio extends Activity {

    /* renamed from: a */
    public static String f2604a = "extra division";

    /* renamed from: b */
    public static String f2605b = "record";

    /* renamed from: c */
    public static String f2606c = "bubble";

    /* renamed from: m */
    private static final String f2607m = Environment.getExternalStorageDirectory().getAbsolutePath() + new String("/ChatON/audio/");

    /* renamed from: d */
    TextView f2608d;

    /* renamed from: e */
    Timer f2609e;

    /* renamed from: f */
    private Context f2610f;

    /* renamed from: h */
    private String f2612h;

    /* renamed from: i */
    private String f2613i;

    /* renamed from: g */
    private MediaPlayer f2611g = new MediaPlayer();

    /* renamed from: j */
    private boolean f2614j = false;

    /* renamed from: k */
    private int f2615k = 0;

    /* renamed from: l */
    private int f2616l = 0;

    /* renamed from: d */
    static /* synthetic */ int m3215d(PlayAudio playAudio) {
        int i = playAudio.f2616l;
        playAudio.f2616l = i - 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        super.onCreate(bundle);
        setContentView(R.layout.layout_multimedia_play_audio);
        this.f2610f = this;
        Intent intent = getIntent();
        this.f2612h = intent.getStringExtra(ChatFragment.f1727b);
        this.f2615k = Integer.parseInt(intent.getStringExtra("recordtime"));
        this.f2613i = intent.getStringExtra(f2604a);
        C1341p.m4659c("maintime:" + this.f2615k);
        m3213b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3210a() {
        int i = this.f2615k / 60;
        String string = Integer.toString(i);
        if (string.length() == 1) {
            string = "0" + string;
        }
        String string2 = Integer.toString(this.f2615k % 60);
        if (string2.length() == 1) {
            string2 = "0" + string2;
        }
        String string3 = Integer.toString(i / 60);
        if (string3.length() == 1) {
            string3 = "0" + string3;
        }
        this.f2608d.setText(String.format("%s:%s:%s", string3, string, string2));
    }

    /* renamed from: b */
    private void m3213b() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Button button = (Button) findViewById(R.id.btn_start_play_audio);
        Button button2 = (Button) findViewById(R.id.btn_stop_play_audio);
        Button button3 = (Button) findViewById(R.id.btn_send);
        Button button4 = (Button) findViewById(R.id.btn_discard);
        this.f2608d = (TextView) findViewById(R.id.Timechek);
        if (this.f2613i.equals(f2606c)) {
            button3.setVisibility(8);
            button4.setVisibility(8);
        }
        try {
            this.f2611g.setDataSource(this.f2612h);
            this.f2611g.prepare();
            this.f2615k = this.f2611g.getDuration();
            this.f2615k = Integer.parseInt(Integer.toString(this.f2615k).substring(0, Integer.toString(this.f2615k).length() - 3));
            this.f2611g.setOnCompletionListener(new C0788y(this, button));
            C1341p.m4659c("mainTime:" + this.f2615k);
        } catch (IOException e) {
            C1341p.m4653a(e, getClass().getName());
            C1619g.m5888a(this.f2610f, R.string.toast_error, 1).show();
        }
        m3210a();
        button.setOnClickListener(new ViewOnClickListenerC0789z(this, button));
        button2.setOnClickListener(new ViewOnClickListenerC0784u(this, button));
        button3.setOnClickListener(new ViewOnClickListenerC0785v(this));
        button4.setOnClickListener(new ViewOnClickListenerC0786w(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f2611g != null) {
            this.f2611g.release();
            this.f2611g = null;
        }
    }
}
