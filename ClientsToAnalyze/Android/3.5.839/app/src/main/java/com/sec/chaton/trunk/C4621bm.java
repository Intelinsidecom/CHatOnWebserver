package com.sec.chaton.trunk;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C4904y;

/* compiled from: TrunkItemView.java */
/* renamed from: com.sec.chaton.trunk.bm */
/* loaded from: classes.dex */
class C4621bm implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkItemView f16796a;

    C4621bm(TrunkItemView trunkItemView) {
        this.f16796a = trunkItemView;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
        if (cursor != null) {
            if (!this.f16796a.f16543ae) {
                return false;
            }
            String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
            String string2 = cursor.getString(cursor.getColumnIndex("comment_id"));
            if ("ME".equals(string)) {
                this.f16796a.m17374e(string2);
                return true;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("[TRUNK] MyUid == Sender. Ignore it.", TrunkItemView.f16512a);
            }
            return false;
        }
        if (C4904y.f17874d) {
            C4904y.m18645d("ContentFragment.onItemLongClick cursor is null.", TrunkItemView.f16512a);
        }
        return false;
    }
}
