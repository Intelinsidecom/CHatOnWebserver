package com.sec.chaton.multimedia.audio;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.util.C3250y;

/* compiled from: VoiceListFragment.java */
/* renamed from: com.sec.chaton.multimedia.audio.v */
/* loaded from: classes.dex */
class C1790v implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ VoiceListFragment f6629a;

    C1790v(VoiceListFragment voiceListFragment) {
        this.f6629a = voiceListFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (this.f6629a.f6525d == null) {
            return;
        }
        this.f6629a.m7281c();
        if (i == 1) {
            this.f6629a.f6528g = cursor;
            Cursor cursor2 = null;
            try {
                if (this.f6629a.f6528g == null || this.f6629a.f6528g.getCount() == 0) {
                    this.f6629a.f6530i.setVisibility(0);
                    if (cursor2 != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("count : " + this.f6629a.f6528g.getCount(), VoiceListFragment.f6522b);
                }
                Cursor cursorSwapCursor = this.f6629a.f6527f.swapCursor(this.f6629a.f6528g);
                if (cursorSwapCursor != null) {
                    cursorSwapCursor.close();
                }
            } finally {
                if (0 != 0) {
                    cursor2.close();
                }
            }
        }
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onInsertComplete(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onUpdateComplete(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onDeleteComplete(int i, Object obj, int i2) {
    }
}
