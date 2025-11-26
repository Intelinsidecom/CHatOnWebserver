package com.sec.chaton.userprofile;

import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.InterfaceC3204bs;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.aw */
/* loaded from: classes.dex */
class C3097aw implements InterfaceC3204bs {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f11310a;

    C3097aw(MyPageFragment myPageFragment) {
        this.f11310a = myPageFragment;
    }

    @Override // com.sec.chaton.util.InterfaceC3204bs
    /* renamed from: a */
    public boolean mo3063a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("mGetProfileImageList run", MyPageFragment.f11095a);
        }
        if ("updated".equals(C3159aa.m10962a().m10979a("mypage_coverstory_state", ""))) {
            if (C3250y.f11734b) {
                C3250y.m11450b(" Don't call getCoverStory(); ", MyPageFragment.f11095a);
            }
        } else {
            if (C3250y.f11734b) {
                C3250y.m11450b(" coverstory default image in PollingScheduler", MyPageFragment.f11095a);
            }
            this.f11310a.m10777d();
        }
        this.f11310a.m10748m();
        this.f11310a.m10744k();
        if (C3171am.m11080r()) {
            this.f11310a.m10746l();
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("mGetProfileImageList finish", MyPageFragment.f11095a);
            return true;
        }
        return true;
    }
}
