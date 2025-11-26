package com.sec.chaton;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class DataPacketDialog extends Activity {

    /* renamed from: a */
    private Button f240a;

    /* renamed from: b */
    private CheckBox f241b;

    /* renamed from: c */
    private LinearLayout f242c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.data_packet_dialog);
        if (Build.VERSION.SDK_INT >= 11) {
            setFinishOnTouchOutside(false);
        }
        getWindow().setLayout(-1, -2);
        this.f240a = (Button) findViewById(R.id.data_packet_ok);
        this.f241b = (CheckBox) findViewById(R.id.data_packet_chekcbox);
        this.f242c = (LinearLayout) findViewById(R.id.linear_packet_chekcbox);
        this.f242c.setOnClickListener(new ViewOnClickListenerC0249al(this));
        this.f242c.setFocusable(true);
        this.f241b.setClickable(false);
        this.f240a.setOnClickListener(new ViewOnClickListenerC0248ak(this));
    }
}
