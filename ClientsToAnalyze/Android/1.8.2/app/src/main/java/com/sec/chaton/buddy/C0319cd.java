package com.sec.chaton.buddy;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0691f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyGroupEditActivity.java */
/* renamed from: com.sec.chaton.buddy.cd */
/* loaded from: classes.dex */
class C0319cd implements LoaderManager.LoaderCallbacks {

    /* renamed from: a */
    CursorLoader f1438a = null;

    /* renamed from: b */
    final /* synthetic */ BuddyGroupEditActivity f1439b;

    C0319cd(BuddyGroupEditActivity buddyGroupEditActivity) {
        this.f1439b = buddyGroupEditActivity;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader onCreateLoader(int i, Bundle bundle) {
        if (i == 1 || i == 3) {
            this.f1438a = new CursorLoader(this.f1439b.getApplicationContext(), C0691f.m3133a(), null, "group_relation_group = ? ", new String[]{String.valueOf(this.f1439b.f1057j.m2313a())}, "buddy_name COLLATE LOCALIZED ASC ");
        } else {
            this.f1438a = new CursorLoader(this.f1439b.getApplicationContext(), C0688c.m3123b(), null, "buddy_no NOT IN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = ? ) ", new String[]{String.valueOf(this.f1439b.f1057j.m2313a())}, "group_type, CASE WHEN group_name IS NULL THEN 1 ELSE 0 END,group_name, buddy_name COLLATE LOCALIZED ASC");
        }
        return this.f1438a;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) {
        if (loader.getId() == 1) {
            this.f1439b.m2068a(cursor);
            this.f1439b.m2075a(this.f1439b.f1052b, this.f1439b.f1053c);
            this.f1439b.f1057j.m2314a(cursor.getCount());
            this.f1439b.f1038F.setText(this.f1439b.f1057j.m2316b());
            this.f1439b.f1036D.setText(this.f1439b.getString(R.string.buddy_group_profile_title, new Object[]{Integer.valueOf(this.f1439b.f1057j.m2317c())}));
            this.f1439b.f1056i.m2398a(this.f1439b.f1047O);
            this.f1439b.f1065r.removeTextChangedListener(this.f1439b.f1050R);
        } else if (loader.getId() == 2) {
            this.f1439b.m2077b(cursor);
            this.f1439b.m2075a(this.f1439b.f1052b, this.f1439b.f1053c);
            this.f1439b.f1056i.m2398a(this.f1439b.f1047O);
            this.f1439b.f1065r.setText("");
            this.f1439b.f1065r.addTextChangedListener(this.f1439b.f1050R);
        } else if (loader.getId() == 3) {
            this.f1439b.m2068a(cursor);
            this.f1439b.m2075a(this.f1439b.f1052b, this.f1439b.f1053c);
            this.f1439b.f1038F.setText(this.f1439b.f1057j.m2316b());
            Iterator it = this.f1439b.f1055e.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((ArrayList) it.next()).iterator();
                while (it2.hasNext()) {
                    C0257c c0257c = (C0257c) it2.next();
                    if (c0257c.m2345q()) {
                        this.f1439b.f1056i.m2402a(c0257c.m2318a(), true);
                    }
                }
            }
            this.f1439b.f1056i.m2398a(this.f1439b.f1047O);
        }
        this.f1439b.f1072y.setFastScrollEnabled(false);
        this.f1439b.f1056i.m2404b();
        this.f1439b.f1072y.setFastScrollEnabled(true);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader loader) {
    }
}
