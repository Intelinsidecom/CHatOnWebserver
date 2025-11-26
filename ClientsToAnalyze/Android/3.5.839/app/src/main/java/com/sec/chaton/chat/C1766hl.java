package com.sec.chaton.chat;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;

/* compiled from: MessageLoader.java */
/* renamed from: com.sec.chaton.chat.hl */
/* loaded from: classes.dex */
class C1766hl implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C1763hi f6640a;

    C1766hl(C1763hi c1763hi) {
        this.f6640a = c1763hi;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        this.f6640a.m8760b(EnumC1769ho.NONE);
        switch (i) {
            case 0:
                if (C4904y.f17872b) {
                    if (cursor == null || cursor.getCount() <= 0) {
                        C4904y.m18639b("onQueryCompleted - QUERY_MESSAGE, count: 0, mCurrentMessage:" + this.f6640a.f6626i, "MessageLoader");
                    } else {
                        C4904y.m18639b("onQueryCompleted - QUERY_MESSAGE, count:" + cursor.getCount() + ", mCurrentMessage:" + this.f6640a.f6626i, "MessageLoader");
                    }
                }
                Cursor cursorM8572d = this.f6640a.f6623f.m8572d(cursor);
                if (cursorM8572d != null) {
                    this.f6640a.m8748a(cursorM8572d);
                }
                if (cursor == null || cursor.getCount() <= 0) {
                    this.f6640a.f6626i = 0;
                    this.f6640a.f6627j.sendEmptyMessage(0);
                } else {
                    this.f6640a.f6626i = cursor.getCount();
                }
                ((ActionBarFragmentActivity) this.f6640a.f6621d).mo51u_();
                break;
            case 1:
                String str = (String) obj;
                if (C4904y.f17872b) {
                    if (cursor == null || cursor.getCount() <= 0) {
                        C4904y.m18639b("onQueryCompleted - QUERY_MESSAGE_SELECTION, count: 0, mCurrentMessage:" + this.f6640a.f6626i + ", positionFromBottom:" + str, "MessageLoader");
                    } else {
                        C4904y.m18639b("onQueryCompleted - QUERY_MESSAGE_SELECTION, count:" + cursor.getCount() + ", mCurrentMessage:" + this.f6640a.f6626i + ", positionFromBottom:" + str, "MessageLoader");
                    }
                }
                Cursor cursorM8572d2 = this.f6640a.f6623f.m8572d(cursor);
                if (cursorM8572d2 != null) {
                    this.f6640a.m8748a(cursorM8572d2);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    this.f6640a.f6626i = cursor.getCount();
                    this.f6640a.f6622e.setTranscriptMode(0);
                    this.f6640a.m8757b(Integer.parseInt(str), this.f6640a.f6622e.getHeight() / 2);
                    break;
                }
                break;
            case 2:
            case 3:
                if (C4904y.f17872b) {
                    String str2 = i == 2 ? "QUERY_MESSAGE_LOAD_MORE" : "QUERY_MESSAGE_LOAD_MORE_FROM_SERVER";
                    if (cursor == null || cursor.getCount() <= 0) {
                        C4904y.m18639b("onQueryCompleted - " + str2 + ", count: 0, mCurrentMessage:" + this.f6640a.f6626i, "MessageLoader");
                    } else {
                        C4904y.m18639b("onQueryCompleted - " + str2 + ", count:" + cursor.getCount() + ", mCurrentMessage:" + this.f6640a.f6626i, "MessageLoader");
                    }
                }
                if (cursor != null) {
                    int count = cursor.getCount() - this.f6640a.f6626i;
                    this.f6640a.f6626i = cursor.getCount();
                    if (count == 0) {
                        Cursor cursorM8572d3 = this.f6640a.f6623f.m8572d(cursor);
                        if (cursorM8572d3 != null) {
                            this.f6640a.m8748a(cursorM8572d3);
                        }
                        if (i == 2) {
                            this.f6640a.f6629l = false;
                            this.f6640a.f6627j.sendEmptyMessage(0);
                        }
                    } else {
                        int count2 = this.f6640a.f6623f.mo871a().getCount() - this.f6640a.f6623f.mo871a().getPosition();
                        Cursor cursorM8572d4 = this.f6640a.f6623f.m8572d(cursor);
                        if (cursorM8572d4 != null) {
                            this.f6640a.m8748a(cursorM8572d4);
                        }
                        this.f6640a.m8747a(count2);
                    }
                }
                if (i == 3) {
                    this.f6640a.f6627j.sendEmptyMessage(1);
                    break;
                }
                break;
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
