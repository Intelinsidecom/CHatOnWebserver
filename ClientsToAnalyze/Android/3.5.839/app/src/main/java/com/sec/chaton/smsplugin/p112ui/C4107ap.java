package com.sec.chaton.smsplugin.p112ui;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.ListAdapter;

/* compiled from: ManageSimMessages.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ap */
/* loaded from: classes.dex */
class C4107ap extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ ManageSimMessages f15239a;

    /* renamed from: b */
    private final ManageSimMessages f15240b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4107ap(ManageSimMessages manageSimMessages, ContentResolver contentResolver, ManageSimMessages manageSimMessages2) {
        super(contentResolver);
        this.f15239a = manageSimMessages;
        this.f15240b = manageSimMessages2;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        this.f15239a.f14788d = cursor;
        if (this.f15239a.f14788d != null) {
            if (!this.f15239a.f14788d.moveToFirst()) {
                this.f15239a.m15774a(1);
            } else if (this.f15239a.f14791g != null) {
                this.f15239a.f14791g.changeCursor(this.f15239a.f14788d);
                this.f15239a.m15774a(0);
            } else {
                this.f15239a.f14791g = new C4110as(this.f15240b, this.f15239a.f14788d, this.f15239a.f14789e, false, null);
                this.f15239a.f14789e.setAdapter((ListAdapter) this.f15239a.f14791g);
                this.f15239a.f14789e.setOnCreateContextMenuListener(this.f15240b);
                this.f15239a.m15774a(0);
            }
            this.f15239a.startManagingCursor(this.f15239a.f14788d);
            return;
        }
        this.f15239a.m15774a(1);
    }
}
