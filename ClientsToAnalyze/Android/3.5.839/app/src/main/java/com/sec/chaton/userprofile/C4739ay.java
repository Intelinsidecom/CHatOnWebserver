package com.sec.chaton.userprofile;

import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.InterfaceC4854bs;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.ay */
/* loaded from: classes.dex */
class C4739ay implements InterfaceC4854bs {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f17403a;

    C4739ay(MyPageFragment myPageFragment) {
        this.f17403a = myPageFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC4854bs
    /* renamed from: a */
    public boolean mo7135a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("mGetProfileImageList run", MyPageFragment.f17192a);
        }
        this.f17403a.m17908h();
        this.f17403a.m17905g();
        if (C4904y.f17872b) {
            C4904y.m18639b("mGetProfileImageList finish", MyPageFragment.f17192a);
            return true;
        }
        return true;
    }
}
