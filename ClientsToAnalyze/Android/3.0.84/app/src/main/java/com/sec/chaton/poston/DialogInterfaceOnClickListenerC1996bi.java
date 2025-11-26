package com.sec.chaton.poston;

import android.content.DialogInterface;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p037j.C1594v;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1996bi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f7711a;

    DialogInterfaceOnClickListenerC1996bi(PostONWriteFragment postONWriteFragment) {
        this.f7711a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        for (int i2 = 0; i2 < this.f7711a.f7591Q.size(); i2++) {
            if (((PreviewData) this.f7711a.f7591Q.get(i2)).m7754f() == null || ((PreviewData) this.f7711a.f7591Q.get(i2)).m7754f().isEmpty()) {
                this.f7711a.f7592R.add(this.f7711a.f7591Q.get(i2));
            }
        }
        this.f7711a.f7611c = 0;
        int iM6733a = C1594v.m6733a(this.f7711a.getActivity());
        if (-3 == iM6733a || -2 == iM6733a) {
            this.f7711a.f7581G.show();
        } else if (this.f7711a.f7602ac) {
            new AsyncTaskC2010bw(this.f7711a, this.f7711a.f7592R, EnumC1455w.VIDEO).execute(new Void[0]);
        } else {
            new AsyncTaskC2010bw(this.f7711a, this.f7711a.f7592R, EnumC1455w.IMAGE).execute(new Void[0]);
        }
    }
}
