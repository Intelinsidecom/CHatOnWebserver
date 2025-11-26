package com.sec.chaton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/* loaded from: classes.dex */
public class DataPacketDialog extends Activity {

    /* renamed from: a */
    private TextView f284a;

    /* renamed from: b */
    private Button f285b;

    /* renamed from: c */
    private CheckBox f286c;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0062R.layout.data_packet_dialog);
        getWindow().setLayout(-1, -2);
        this.f285b = (Button) findViewById(C0062R.id.data_packet_ok);
        this.f286c = (CheckBox) findViewById(C0062R.id.data_packet_chekcbox);
        this.f284a = (TextView) findViewById(C0062R.id.data_packet_textview);
        this.f286c.setText(C0062R.string.data_packet_checkbox);
        this.f284a.setText(C0062R.string.data_packet_text);
        this.f285b.setText(C0062R.string.dialog_ok);
        this.f285b.setOnClickListener(new ViewOnClickListenerC0352p(this));
    }
}
