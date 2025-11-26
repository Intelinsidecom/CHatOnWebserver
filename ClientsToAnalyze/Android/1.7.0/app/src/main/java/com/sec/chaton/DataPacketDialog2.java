package com.sec.chaton;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

/* loaded from: classes.dex */
public class DataPacketDialog2 extends DialogFragment {

    /* renamed from: a */
    public static final String f243a = DataPacketDialog2.class.getSimpleName();

    /* renamed from: b */
    private Button f244b;

    /* renamed from: c */
    private CheckBox f245c;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().setCanceledOnTouchOutside(false);
        View viewInflate = layoutInflater.inflate(R.layout.data_packet_dialog, viewGroup, false);
        this.f244b = (Button) viewInflate.findViewById(R.id.data_packet_ok);
        this.f245c = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        this.f244b.setOnClickListener(new ViewOnClickListenerC0251b(this));
        return viewInflate;
    }
}
