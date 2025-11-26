package com.sec.chaton.multimedia.vcalendar;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.sec.chaton.util.C1341p;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.j */
/* loaded from: classes.dex */
class C0820j implements LoaderManager.LoaderCallbacks {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f2819a;

    C0820j(VCalendarListFragment vCalendarListFragment) {
        this.f2819a = vCalendarListFragment;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader onCreateLoader(int i, Bundle bundle) {
        C1341p.m4663f("onCreateLoader()", VCalendarListFragment.f2770a);
        return new CursorLoader(this.f2819a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{"_id", "title", "eventLocation", "description", "dtstart", "dtend", "calendar_id", "rrule", "allDay", "deleted"}, null, null, " dtstart asc ");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) throws NumberFormatException {
        C1341p.m4663f("*******************onLoadFinished()", VCalendarListFragment.f2770a);
        C1341p.m4663f("*******************Event count : " + cursor.getCount(), VCalendarListFragment.f2770a);
        this.f2819a.m3324a(cursor);
        if (this.f2819a.f2779j.size() > 0) {
            this.f2819a.f2776g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f2819a.f2777h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f2819a.m3329a(this.f2819a.f2779j, this.f2819a.f2780k);
        } else {
            this.f2819a.f2776g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f2819a.f2777h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        if (this.f2819a.f2783n != null) {
            this.f2819a.f2783n.dismiss();
        } else {
            C1341p.m4663f("mDialog is NULL ==" + cursor.getCount(), VCalendarListFragment.f2770a);
        }
        if (!TextUtils.isEmpty(this.f2819a.f2775f.getText().toString())) {
            this.f2819a.m3328a(this.f2819a.f2775f.getText().toString());
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader loader) {
    }
}
