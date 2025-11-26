package com.sec.chaton.settings;

import android.content.DialogInterface;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.em */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3603em implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FragmentMultiDeviceView f13129a;

    DialogInterfaceOnCancelListenerC3603em(FragmentMultiDeviceView fragmentMultiDeviceView) {
        this.f13129a = fragmentMultiDeviceView;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.f13129a.getActivity() != null) {
            this.f13129a.getActivity().finish();
        }
    }
}
