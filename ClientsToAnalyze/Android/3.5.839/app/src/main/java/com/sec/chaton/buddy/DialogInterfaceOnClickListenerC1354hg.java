package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.io.UnsupportedEncodingException;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1354hg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1353hf f4933a;

    DialogInterfaceOnClickListenerC1354hg(HandlerC1353hf handlerC1353hf) {
        this.f4933a = handlerC1353hf;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws UnsupportedEncodingException {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4933a.f4932a.f4066A, R.string.popup_no_network_connection, 0).show();
        } else {
            this.f4933a.f4932a.m6909a(this.f4933a.f4932a.f4083k, this.f4933a.f4932a.f4084l);
        }
    }
}
