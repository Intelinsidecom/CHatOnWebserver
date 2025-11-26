package com.sec.chaton.smsplugin.multimedia.audio;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: MmsVoiceListFragment.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.audio.f */
/* loaded from: classes.dex */
class C3911f implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ MmsVoiceListFragment f14051a;

    C3911f(MmsVoiceListFragment mmsVoiceListFragment) {
        this.f14051a = mmsVoiceListFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (this.f14051a.f14028d == null) {
            return;
        }
        this.f14051a.m15085d();
        if (i == 1) {
            this.f14051a.f14031g = cursor;
            Cursor cursor2 = null;
            try {
                if (this.f14051a.f14031g == null || this.f14051a.f14031g.getCount() == 0) {
                    this.f14051a.m15082b();
                    if (cursor2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("count : " + this.f14051a.f14031g.getCount(), MmsVoiceListFragment.f14025b);
                }
                Cursor cursorB = this.f14051a.f14030f.mo877b(this.f14051a.f14031g);
                if (cursorB != null) {
                    cursorB.close();
                }
            } finally {
                if (0 != 0) {
                    cursor2.close();
                }
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
