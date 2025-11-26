package com.sec.chaton.localbackup.chatview;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4904y;

/* compiled from: ChatViewFragment.java */
/* renamed from: com.sec.chaton.localbackup.chatview.k */
/* loaded from: classes.dex */
class C2532k implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ChatViewFragment f9119a;

    C2532k(ChatViewFragment chatViewFragment) {
        this.f9119a = chatViewFragment;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        Cursor cursorB = null;
        if (this.f9119a.f9078f != null) {
            if (i == 1) {
                if (cursor != null) {
                    try {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("count : " + cursor.getCount(), ChatViewFragment.f9073c);
                        }
                        Cursor cursorB2 = this.f9119a.f9080h.mo877b(cursor);
                        if (cursor == null || cursor.getCount() <= 0) {
                            this.f9119a.f9082j.setSelection(0);
                            this.f9119a.f9090r = false;
                        } else {
                            this.f9119a.f9087o = cursor.getCount();
                            if (this.f9119a.f9088p) {
                                this.f9119a.f9082j.setSelection(cursor.getCount());
                            }
                            this.f9119a.f9090r = true;
                        }
                        if (cursorB2 != null) {
                            this.f9119a.m10901a(cursorB2);
                            return;
                        }
                        return;
                    } finally {
                    }
                }
                return;
            }
            if (i == 2) {
                try {
                    cursorB = this.f9119a.f9080h.mo877b(cursor);
                    if (cursorB != null) {
                        this.f9119a.m10901a(cursorB);
                    }
                    if (cursor == null || cursor.getCount() <= 0) {
                        this.f9119a.f9082j.setSelection(0);
                        this.f9119a.f9090r = false;
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("onQueryCompleted - QUERY_MESSAGE_LOAD_MORE, " + cursor.getCount(), ChatViewFragment.f9073c);
                        }
                        int count = cursor.getCount();
                        int i2 = count - this.f9119a.f9087o;
                        this.f9119a.f9087o = count;
                        if (this.f9119a.f9088p) {
                            this.f9119a.f9082j.setSelection(cursor.getCount());
                        } else if (i2 > 0) {
                            if (i2 < 30) {
                                this.f9119a.f9082j.setSelection(i2);
                            } else {
                                this.f9119a.f9082j.setSelection(30);
                            }
                        }
                        if (i2 > 0) {
                            this.f9119a.f9090r = true;
                        } else {
                            this.f9119a.f9090r = false;
                        }
                    }
                    this.f9119a.f9089q = false;
                    if (cursorB != null) {
                        this.f9119a.m10901a(cursorB);
                    }
                } finally {
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
