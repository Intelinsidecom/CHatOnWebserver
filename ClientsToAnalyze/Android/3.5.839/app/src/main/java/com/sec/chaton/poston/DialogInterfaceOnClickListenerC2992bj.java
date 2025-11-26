package com.sec.chaton.poston;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.sec.chaton.multimedia.multisend.PreviewData;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p067j.C2471v;

/* compiled from: PostONWriteFragment.java */
/* renamed from: com.sec.chaton.poston.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2992bj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PostONWriteFragment f11107a;

    DialogInterfaceOnClickListenerC2992bj(PostONWriteFragment postONWriteFragment) {
        this.f11107a = postONWriteFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        for (int i2 = 0; i2 < this.f11107a.f10987S.size(); i2++) {
            if (TextUtils.isEmpty(((PreviewData) this.f11107a.f10987S.get(i2)).m11984f())) {
                this.f11107a.f10988T.add(this.f11107a.f10987S.get(i2));
            }
        }
        this.f11107a.f11008c = 0;
        int iM10677a = C2471v.m10677a(this.f11107a.getActivity());
        if (-3 == iM10677a || -2 == iM10677a) {
            this.f11107a.f10977I.show();
        } else if (this.f11107a.f10999af) {
            new AsyncTaskC3006bx(this.f11107a, this.f11107a.f10988T, EnumC2214ab.VIDEO).execute(new Void[0]);
        } else {
            new AsyncTaskC3006bx(this.f11107a, this.f11107a.f10988T, EnumC2214ab.IMAGE).execute(new Void[0]);
        }
    }
}
