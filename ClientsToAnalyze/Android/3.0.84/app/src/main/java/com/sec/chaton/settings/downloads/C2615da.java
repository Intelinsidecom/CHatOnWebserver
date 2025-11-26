package com.sec.chaton.settings.downloads;

import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.util.C3250y;

/* compiled from: SoundDownloads.java */
/* renamed from: com.sec.chaton.settings.downloads.da */
/* loaded from: classes.dex */
class C2615da implements AdapterView.OnItemLongClickListener {

    /* renamed from: a */
    final /* synthetic */ SoundDownloads f9839a;

    C2615da(SoundDownloads soundDownloads) {
        this.f9839a = soundDownloads;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
        if (cursor == null) {
            if (!C3250y.f11736d) {
                return false;
            }
            C3250y.m11455d("SoundDownloads.onItemLongClick cursor is null.", SoundDownloads.f9592a);
            return false;
        }
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        if (z) {
            this.f9839a.m9417b(string, string2);
        }
        return true;
    }
}
