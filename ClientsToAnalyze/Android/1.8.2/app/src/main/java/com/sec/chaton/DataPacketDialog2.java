package com.sec.chaton;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/* loaded from: classes.dex */
public class DataPacketDialog2 extends DialogFragment {

    /* renamed from: a */
    public static final String f208a = DataPacketDialog2.class.getSimpleName();

    /* renamed from: b */
    private Button f209b;

    /* renamed from: c */
    private CheckBox f210c;

    /* renamed from: d */
    private TextView f211d;

    /* renamed from: e */
    private Button f212e;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.data_packet_dialog, viewGroup, false);
        this.f209b = (Button) viewInflate.findViewById(R.id.data_packet_ok);
        this.f210c = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        this.f211d = (TextView) viewInflate.findViewById(R.id.data_packet_chekcbox_text);
        if (Build.VERSION.SDK_INT >= 11) {
            getDialog().setCanceledOnTouchOutside(false);
        }
        this.f211d.setOnClickListener(new ViewOnClickListenerC0712f(this));
        this.f210c.setOnKeyListener(new ViewOnKeyListenerC0751g(this));
        this.f210c.setOnClickListener(new ViewOnClickListenerC0763h(this));
        this.f212e = (Button) viewInflate.findViewById(R.id.data_packet_cancel);
        this.f209b.setOnClickListener(new ViewOnClickListenerC0817i(this));
        this.f212e.setOnClickListener(new ViewOnClickListenerC0833j(this));
        return viewInflate;
    }
}
