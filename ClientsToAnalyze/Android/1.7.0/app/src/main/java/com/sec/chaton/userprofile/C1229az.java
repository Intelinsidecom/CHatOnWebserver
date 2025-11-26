package com.sec.chaton.userprofile;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.az */
/* loaded from: classes.dex */
class C1229az implements InterfaceC0626f {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4309a;

    C1229az(MyPageFragment myPageFragment) {
        this.f4309a = myPageFragment;
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo879a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo880a(int i, Object obj, Cursor cursor) {
        this.f4309a.m4290a(cursor);
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: a */
    public void mo881a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p025d.p026a.InterfaceC0626f
    /* renamed from: b */
    public void mo882b(int i, Object obj, int i2) {
    }
}
