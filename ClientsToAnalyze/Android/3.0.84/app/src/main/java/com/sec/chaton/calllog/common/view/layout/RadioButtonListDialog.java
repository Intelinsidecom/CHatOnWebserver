package com.sec.chaton.calllog.common.view.layout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* loaded from: classes.dex */
public class RadioButtonListDialog extends DialogFragment {

    /* renamed from: a */
    private static int f3165a = 0;

    /* renamed from: a */
    public static RadioButtonListDialog m4384a(String str, int i) {
        RadioButtonListDialog radioButtonListDialog = new RadioButtonListDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        radioButtonListDialog.setArguments(bundle);
        f3165a = i;
        return radioButtonListDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) throws Resources.NotFoundException {
        return AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.calllog_view_by_title)).mo11502a(true).mo11496a(R.array.calllog_view_by, f3165a, new DialogInterfaceOnClickListenerC0831d(this)).mo11507b(R.string.cancel, new DialogInterfaceOnClickListenerC0830c(this)).mo11505a().mo11517a();
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
