package com.sec.chaton.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: MultideviceSyncProgressDialog.java */
/* renamed from: com.sec.chaton.widget.l */
/* loaded from: classes.dex */
public class AlertDialogC4919l extends AlertDialog implements DialogInterface.OnShowListener {

    /* renamed from: a */
    private TextView f17976a;

    /* renamed from: b */
    private TextView f17977b;

    public AlertDialogC4919l(Context context) {
        super(context);
        m18720a();
    }

    /* renamed from: a */
    private void m18720a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
        this.f17977b = (TextView) viewInflate.findViewById(R.id.messageText);
        this.f17976a = (TextView) viewInflate.findViewById(R.id.subTitleText);
        m18721a(viewInflate);
        setOnShowListener(this);
    }

    /* renamed from: a */
    private void m18721a(View view) {
        setView(view);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
