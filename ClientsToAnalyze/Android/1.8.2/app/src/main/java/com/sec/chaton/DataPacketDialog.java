package com.sec.chaton;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class DataPacketDialog extends Activity {

    /* renamed from: a */
    private Button f204a;

    /* renamed from: b */
    private CheckBox f205b;

    /* renamed from: c */
    private TextView f206c;

    /* renamed from: d */
    private Button f207d;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.data_packet_dialog);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(-2, -2);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            getWindow().setLayout(-1, -2);
        }
        this.f204a = (Button) findViewById(R.id.data_packet_ok);
        this.f205b = (CheckBox) findViewById(R.id.data_packet_chekcbox);
        this.f207d = (Button) findViewById(R.id.data_packet_cancel);
        this.f207d.setOnClickListener(new ViewOnClickListenerC0098a(this));
        this.f206c = (TextView) findViewById(R.id.data_packet_chekcbox_text);
        this.f205b.setOnClickListener(new ViewOnClickListenerC0236b(this));
        this.f206c.setOnClickListener(new ViewOnClickListenerC0451c(this));
        this.f205b.setOnClickListener(new ViewOnClickListenerC0530d(this));
        this.f204a.setOnClickListener(new ViewOnClickListenerC0655e(this));
    }
}
