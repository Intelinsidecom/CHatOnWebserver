package com.sec.chaton.trunk;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C3250y;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bj */
/* loaded from: classes.dex */
class C3002bj implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f10848a;

    C3002bj(TrunkItemView trunkItemView) {
        this.f10848a = trunkItemView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
        if (cursor != null) {
            if (!this.f10848a.f10598ag) {
                return false;
            }
            String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
            String string2 = cursor.getString(cursor.getColumnIndex("comment_id"));
            if ("ME".equals(string)) {
                this.f10848a.m10275d(string2);
                return true;
            }
            if (C3250y.f11734b) {
                C3250y.m11450b("[TRUNK] MyUid == Sender. Ignore it.", TrunkItemView.f10565a);
            }
            return false;
        }
        if (C3250y.f11736d) {
            C3250y.m11455d("ContentFragment.onItemLongClick cursor is null.", TrunkItemView.f10565a);
        }
        return false;
    }
}
