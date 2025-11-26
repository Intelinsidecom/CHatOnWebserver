package com.sec.chaton.smsplugin.spam;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.ListAdapter;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.m */
/* loaded from: classes.dex */
class C4035m extends AsyncQueryHandler {

    /* renamed from: a */
    final /* synthetic */ ManageSpamMessages f14548a;

    /* renamed from: b */
    private final ManageSpamMessages f14549b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4035m(ManageSpamMessages manageSpamMessages, ContentResolver contentResolver, ManageSpamMessages manageSpamMessages2) {
        super(contentResolver);
        this.f14548a = manageSpamMessages;
        this.f14549b = manageSpamMessages2;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int i, Object obj, Cursor cursor) {
        C3890m.m14996b("Mms/ManageSpamMessages", "onQueryComplete()");
        if (cursor == null) {
            C3890m.m14999e("Mms/ManageSpamMessages", "cursor is null");
        }
        if (cursor == null) {
            this.f14548a.m15297b(1);
        } else {
            C3890m.m14996b("Mms/ManageSpamMessages", "cursor count=" + cursor.getCount());
            if (!cursor.moveToFirst() || cursor.getCount() == 0) {
                this.f14548a.m15297b(1);
                if (this.f14548a.f14291i != null) {
                    this.f14548a.f14291i.setVisibility(8);
                }
            } else if (this.f14548a.f14288f != null) {
                this.f14548a.f14288f.m15468a(this.f14548a.f14290h);
                this.f14548a.f14288f.changeCursor(cursor);
                this.f14548a.m15297b(0);
            } else {
                this.f14548a.f14288f = new C4018bv(this.f14549b, cursor, this.f14548a.f14286d, false, null, true, this.f14548a.f14290h);
                this.f14548a.f14286d.setAdapter((ListAdapter) this.f14548a.f14288f);
                this.f14548a.f14286d.setOnCreateContextMenuListener(this.f14548a.f14296n);
                this.f14548a.m15297b(0);
            }
        }
        switch (this.f14548a.f14290h) {
            case 1:
            case 2:
                if (this.f14548a.f14291i != null && cursor != null && cursor.getCount() != 0) {
                    this.f14548a.f14291i.setVisibility(0);
                    break;
                }
                break;
        }
    }
}
