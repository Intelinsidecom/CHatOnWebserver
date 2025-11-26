package com.sec.chaton;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings2.PrefFragmentChats;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.aa */
/* loaded from: classes.dex */
class C0412aa implements InterfaceC1378v {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f1457a;

    C0412aa(PlusFragment plusFragment) {
        this.f1457a = plusFragment;
    }

    @Override // com.sec.chaton.p027e.p028a.InterfaceC1378v
    public void onQueryComplete(int i, Object obj, Cursor cursor) {
        if (i == 0) {
            this.f1457a.f715m.clear();
            if (cursor != null) {
                this.f1457a.f714l = cursor;
                this.f1457a.f717o = this.f1457a.f714l.getCount();
                while (this.f1457a.f714l.moveToNext()) {
                    this.f1457a.f715m.add(new C0429ag(this.f1457a.f714l.getInt(this.f1457a.f714l.getColumnIndex("id")), this.f1457a.f714l.getInt(this.f1457a.f714l.getColumnIndex(PrefFragmentChats.TYPE)), this.f1457a.f714l.getString(this.f1457a.f714l.getColumnIndex("title")), this.f1457a.f714l.getString(this.f1457a.f714l.getColumnIndex("contenturl")), this.f1457a.f714l.getString(this.f1457a.f714l.getColumnIndex("appid")), this.f1457a.f714l.getString(this.f1457a.f714l.getColumnIndex("linkurl")), this.f1457a.f714l.getString(this.f1457a.f714l.getColumnIndex("samsungappsurl"))));
                }
            }
            this.f1457a.f709g.notifyDataSetChanged();
            this.f1457a.f713k.setVisibility(8);
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
