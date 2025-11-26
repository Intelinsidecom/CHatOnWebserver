package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;

/* compiled from: FragmentMultiDeviceView.java */
/* renamed from: com.sec.chaton.settings.ej */
/* loaded from: classes.dex */
class ViewOnClickListenerC3600ej implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentMultiDeviceView f13126a;

    ViewOnClickListenerC3600ej(FragmentMultiDeviceView fragmentMultiDeviceView) {
        this.f13126a = fragmentMultiDeviceView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(this.f13126a.f12707d).mo18734a(R.string.header_notification).mo18746b(R.string.multideivce_delete_account_pop_up).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3602el(this)).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3601ek(this)).mo18745a();
        if (this.f13126a.f12717n.getCheckedItemPosition() != -1) {
            interfaceC4936eMo18745a.show();
        }
    }
}
