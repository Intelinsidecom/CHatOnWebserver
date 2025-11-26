package com.sec.chaton.calllog.common.view.layout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class ButtonTwoDialog extends DialogFragment {

    /* renamed from: j */
    private static int f5132j;

    /* renamed from: a */
    public static ButtonTwoDialog m7534a(int i, String str, String str2) {
        ButtonTwoDialog buttonTwoDialog = new ButtonTwoDialog();
        f5132j = i;
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString(Config.NOTIFICATION_INTENT_MSG, str2);
        buttonTwoDialog.setArguments(bundle);
        return buttonTwoDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    /* renamed from: a */
    public Dialog mo33a(Bundle bundle) {
        String string = getArguments().getString("title");
        return AbstractC4932a.m18733a(getActivity()).mo18740a(string).mo18749b(getArguments().getString(Config.NOTIFICATION_INTENT_MSG)).mo18756d(R.string.alert_dialog_ok, new DialogInterfaceOnClickListenerC1440b(this)).mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC1439a(this)).mo18745a().mo18758a();
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
