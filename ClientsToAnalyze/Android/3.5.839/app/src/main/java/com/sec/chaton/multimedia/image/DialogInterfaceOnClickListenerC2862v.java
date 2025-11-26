package com.sec.chaton.multimedia.image;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2862v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC2861u f10504a;

    DialogInterfaceOnClickListenerC2862v(ViewOnClickListenerC2861u viewOnClickListenerC2861u) {
        this.f10504a = viewOnClickListenerC2861u;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f10504a.f10503a.getActivity() != null) {
            try {
                if (C4859bx.m18396c()) {
                    this.f10504a.f10503a.startActivity(C2921a.m12141i(this.f10504a.f10503a.getActivity()));
                } else {
                    this.f10504a.f10503a.startActivity(C2921a.m12142j(this.f10504a.f10503a.getActivity()));
                }
            } catch (ActivityNotFoundException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, ImagePagerFragment.f10232f);
                }
            }
        }
    }
}
