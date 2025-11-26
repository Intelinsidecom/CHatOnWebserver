package com.sec.chaton.calllog.common.view.layout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.p123a.AbstractC4932a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RadioButtonListDialog extends DialogFragment {

    /* renamed from: j */
    private static int f5133j = 0;

    /* renamed from: k */
    private static boolean f5134k = true;

    /* renamed from: a */
    public static RadioButtonListDialog m7537a(String str, int i, boolean z) {
        RadioButtonListDialog radioButtonListDialog = new RadioButtonListDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        radioButtonListDialog.setArguments(bundle);
        f5133j = i;
        f5134k = z;
        return radioButtonListDialog;
    }

    @Override // android.support.v4.app.DialogFragment
    /* renamed from: a */
    public Dialog mo33a(Bundle bundle) throws Resources.NotFoundException {
        String string = getResources().getString(R.string.calllog_view_by_title);
        ArrayList arrayList = new ArrayList();
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_all_logs));
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_all_voice_calls));
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_all_video_calls));
        if (f5134k) {
            arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_all_single_calls));
            arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_all_group_calls));
        }
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_missed_calls));
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_dialed_calls));
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_received_calls));
        arrayList.add(GlobalApplication.m10283b().getString(R.string.calllog_rejected_calls));
        if (!f5134k && f5133j > 4) {
            f5133j -= 2;
        }
        return AbstractC4932a.m18733a(getActivity()).mo18740a(string).mo18742a(true).mo18743a((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]), f5133j, new DialogInterfaceOnClickListenerC1442d(this, arrayList)).mo18747b(R.string.cancel, new DialogInterfaceOnClickListenerC1441c(this)).mo18745a().mo18758a();
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }
}
