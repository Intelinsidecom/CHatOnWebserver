package com.sec.chaton.trunk;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.ar */
/* loaded from: classes.dex */
class C1532ar implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f5582a;

    C1532ar(TrunkItemView trunkItemView) {
        this.f5582a = trunkItemView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
        if (cursor == null) {
            if (C1786r.f6454d) {
                C1786r.m6065d("ContentFragment.onItemLongClick cursor is null.", TrunkItemView.f5448e);
            }
            return false;
        }
        String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
        String string2 = cursor.getString(cursor.getColumnIndex("comment_id"));
        if ("ME".equals(string)) {
            this.f5582a.m5266c(string2);
            return true;
        }
        if (C1786r.f6452b) {
            C1786r.m6061b("[TRUNK] MyUid == Sender. Ignore it.", TrunkItemView.f5448e);
        }
        return false;
    }
}
