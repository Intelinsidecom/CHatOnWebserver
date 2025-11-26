package com.android.p029ex.editstyledtext;

import android.content.DialogInterface;
import android.text.Layout;
import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0378ar implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0376ap f935a;

    DialogInterfaceOnClickListenerC0378ar(C0376ap c0376ap) {
        this.f935a = c0376ap;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        switch (i) {
            case 0:
                alignment = Layout.Alignment.ALIGN_NORMAL;
                break;
            case 1:
                alignment = Layout.Alignment.ALIGN_CENTER;
                break;
            case 2:
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
                break;
            default:
                Log.e("EditStyledText", "--- onShowAlignAlertDialog: got illigal align.");
                break;
        }
        this.f935a.f933o.setAlignment(alignment);
    }
}
