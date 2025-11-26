package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p065io.entry.inner.MappingInfoEntry;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.ek */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3601ek implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3600ej f13127a;

    DialogInterfaceOnClickListenerC3601ek(ViewOnClickListenerC3600ej viewOnClickListenerC3600ej) {
        this.f13127a = viewOnClickListenerC3600ej;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f13127a.f13126a.f12714k = ProgressDialogC4926s.m18727a(this.f13127a.f13126a.f12707d, null, this.f13127a.f13126a.getResources().getString(R.string.deregister_device));
        String str = ((MappingInfoEntry) this.f13127a.f13126a.f12713j.get(this.f13127a.f13126a.f12717n.getCheckedItemPosition())).chatonid;
        if (C4904y.f17872b) {
            C4904y.m18639b("Remove buddyId would be : " + str, this.f13127a.f13126a.f12705b);
        }
        this.f13127a.f13126a.f12712i.m9393c(str);
    }
}
