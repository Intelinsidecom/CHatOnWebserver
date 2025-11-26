package com.sec.chaton.calllog.common.view.layout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ButtonTwoDialog extends DialogFragment {

    /* renamed from: a */
    private static int f3164a;

    /* renamed from: a */
    public static ButtonTwoDialog m4382a(int i, String str, String str2) {
        ButtonTwoDialog buttonTwoDialog = new ButtonTwoDialog();
        f3164a = i;
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString(Config.NOTIFICATION_INTENT_MSG, str2);
        buttonTwoDialog.setArguments(bundle);
        return buttonTwoDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("title");
        return AbstractC3271a.m11494a(getActivity()).mo11500a(string).mo11509b(getArguments().getString(Config.NOTIFICATION_INTENT_MSG)).mo11515d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC0829b(this)).mo11507b(R.string.cancel, new DialogInterfaceOnClickListenerC0828a(this)).mo11505a().mo11517a();
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
