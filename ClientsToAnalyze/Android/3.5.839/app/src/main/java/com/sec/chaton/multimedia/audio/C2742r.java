package com.sec.chaton.multimedia.audio;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: VoiceListFragment.java */
/* renamed from: com.sec.chaton.multimedia.audio.r */
/* loaded from: classes.dex */
class C2742r implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ VoiceListFragment f9837a;

    C2742r(VoiceListFragment voiceListFragment) {
        this.f9837a = voiceListFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (this.f9837a.f9751d == null) {
            return;
        }
        this.f9837a.m11422d();
        if (i == 1) {
            this.f9837a.f9754g = cursor;
            Cursor cursor2 = null;
            try {
                if (this.f9837a.f9754g == null || this.f9837a.f9754g.getCount() == 0) {
                    this.f9837a.m11419b();
                    if (cursor2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("count : " + this.f9837a.f9754g.getCount(), VoiceListFragment.f9748b);
                }
                Cursor cursorB = this.f9837a.f9753f.mo877b(this.f9837a.f9754g);
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
