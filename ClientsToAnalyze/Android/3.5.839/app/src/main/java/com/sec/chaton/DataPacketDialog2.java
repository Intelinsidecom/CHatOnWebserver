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

    /* renamed from: j */
    public static final String f1922j = DataPacketDialog2.class.getSimpleName();

    /* renamed from: k */
    private Button f1923k;

    /* renamed from: l */
    private CheckBox f1924l;

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m35a(2, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m38b().setCanceledOnTouchOutside(false);
        View viewInflate = layoutInflater.inflate(R.layout.data_packet_dialog, viewGroup, false);
        this.f1923k = (Button) viewInflate.findViewById(R.id.data_packet_ok);
        this.f1924l = (CheckBox) viewInflate.findViewById(R.id.data_packet_chekcbox);
        this.f1923k.setOnClickListener(new ViewOnClickListenerC4928x(this));
        return viewInflate;
    }
}
