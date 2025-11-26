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
/* renamed from: com.sec.chaton.widget.f */
/* loaded from: classes.dex */
public class AlertDialogC3259f extends AlertDialog implements DialogInterface.OnShowListener {

    /* renamed from: a */
    private TextView f11779a;

    /* renamed from: b */
    private TextView f11780b;

    public AlertDialogC3259f(Context context) {
        super(context);
        m11484a();
    }

    /* renamed from: a */
    private void m11484a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
        this.f11780b = (TextView) viewInflate.findViewById(R.id.messageText);
        this.f11779a = (TextView) viewInflate.findViewById(R.id.subTitleText);
        m11485a(viewInflate);
        setOnShowListener(this);
    }

    /* renamed from: a */
    private void m11485a(View view) {
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
