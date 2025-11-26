package com.sec.chaton;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ChatONVDialog extends Activity {

    /* renamed from: a */
    private Button f236a;

    /* renamed from: b */
    private Button f237b;

    /* renamed from: c */
    private CheckBox f238c;

    /* renamed from: d */
    private LinearLayout f239d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.chaton_coolots_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        getWindow().setLayout(-1, -2);
        this.f236a = (Button) findViewById(R.id.chaton_download_ok);
        this.f237b = (Button) findViewById(R.id.chaton_download_cancel);
        this.f238c = (CheckBox) findViewById(R.id.data_packet_chekcbox);
        this.f239d = (LinearLayout) findViewById(R.id.linear_packet_chekcbox);
        this.f239d.setOnClickListener(new ViewOnClickListenerC0230ac(this));
        this.f238c.setClickable(false);
        this.f236a.setOnClickListener(new ViewOnClickListenerC0229ab(this));
        this.f237b.setOnClickListener(new ViewOnClickListenerC0241ad(this));
    }
}
