package com.sec.chaton.trunk;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.aw */
/* loaded from: classes.dex */
class C1125aw implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f3936a;

    C1125aw(TrunkItemView trunkItemView) {
        this.f3936a = trunkItemView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
        if (cursor == null) {
            if (C1341p.f4580d) {
                C1341p.m4661d("ContentFragment.onItemLongClick cursor is null.", TrunkItemView.f3767a);
            }
            return false;
        }
        String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
        String string2 = cursor.getString(cursor.getColumnIndex("comment_id"));
        if ("ME".equals(string)) {
            this.f3936a.m4002c(string2);
            return true;
        }
        if (C1341p.f4578b) {
            C1341p.m4658b("[TRUNK] MyUid == Sender. Ignore it.", TrunkItemView.f3767a);
        }
        return false;
    }
}
