package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.widget.ProgressDialogC4926s;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.ei */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3248ei implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3244ee f12015a;

    DialogInterfaceOnClickListenerC3248ei(HandlerC3244ee handlerC3244ee) {
        this.f12015a = handlerC3244ee;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!C4822an.m18255w()) {
            this.f12015a.f12011a.m12929e();
        } else if (this.f12015a.f12011a.getActivity() != null) {
            this.f12015a.f12011a.f11729R = ProgressDialogC4926s.m18728a(this.f12015a.f12011a.f11731T, null, this.f12015a.f12011a.getResources().getString(R.string.buddy_list_progress_dialog_message), true);
            this.f12015a.f12011a.f11735X.m9355a(this.f12015a.f12011a.f11768h, true);
            this.f12015a.f12011a.f11754am = true;
        }
    }
}
