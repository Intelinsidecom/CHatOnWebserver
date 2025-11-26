package com.sec.chaton.buddy;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sec.chaton.buddy.m */
/* loaded from: classes.dex */
class C0120m implements LoaderManager.LoaderCallbacks {

    /* renamed from: a */
    CursorLoader f700a = null;

    /* renamed from: b */
    final /* synthetic */ BuddyGroupEditActivity f701b;

    C0120m(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f701b = buddyGroupEditActivity;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public Loader mo38a(int i, Bundle bundle) {
        if (i == 1 || i == 3) {
            this.f700a = new CursorLoader(this.f701b.getApplicationContext(), ChatONContract.GroupRelationTable.m2179a(), null, "group_relation_group = ? ", new String[]{String.valueOf(this.f701b.f509g.m663a())}, "buddy_name COLLATE LOCALIZED ASC ");
        } else {
            this.f700a = new CursorLoader(this.f701b.getApplicationContext(), ChatONContract.BuddyTable.m2171b(), null, "buddy_no NOT IN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = ? ) ", new String[]{String.valueOf(this.f701b.f509g.m663a())}, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
        }
        return this.f700a;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public void mo39a(Loader loader) {
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo40a(Loader loader, Cursor cursor) {
        if (loader.m152b() == 1) {
            this.f701b.m546a(cursor);
            this.f701b.m553a(this.f701b.f504b, this.f701b.f505c);
            this.f701b.f509g.m664a(cursor.getCount());
            this.f701b.f490C.setText(this.f701b.f509g.m666b());
            this.f701b.f488A.setText(this.f701b.getString(C0062R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f701b.f509g.m667c())}));
            this.f701b.f508f.m590a(this.f701b.f499L);
            this.f701b.f517o.removeTextChangedListener(this.f701b.f502O);
        } else if (loader.m152b() == 2) {
            this.f701b.m555b(cursor);
            this.f701b.m553a(this.f701b.f504b, this.f701b.f505c);
            this.f701b.f508f.m590a(this.f701b.f499L);
            this.f701b.f517o.setText("");
            this.f701b.f517o.addTextChangedListener(this.f701b.f502O);
        } else if (loader.m152b() == 3) {
            this.f701b.m546a(cursor);
            this.f701b.m553a(this.f701b.f504b, this.f701b.f505c);
            this.f701b.f490C.setText(this.f701b.f509g.m666b());
            Iterator it = this.f701b.f507e.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) it.next()).iterator();
                while (it2.hasNext()) {
                    BuddyItem buddyItem = (BuddyItem) it2.next();
                    if (buddyItem.m692q()) {
                        this.f701b.f508f.m594a(buddyItem.m668a(), true);
                    }
                }
            }
            this.f701b.f508f.m590a(this.f701b.f499L);
        }
        this.f701b.f524v.setFastScrollEnabled(false);
        this.f701b.f508f.m596b();
        this.f701b.f524v.setFastScrollEnabled(true);
    }
}
