package com.sec.chaton.multimedia.vcalendar;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.h */
/* loaded from: classes.dex */
class C1923h implements LoaderManager.LoaderCallbacks<Cursor> {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f7346a;

    C1923h(VCalendarListFragment vCalendarListFragment) {
        this.f7346a = vCalendarListFragment;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        C3250y.m11458g("onCreateLoader()", VCalendarListFragment.f7311a);
        return new CursorLoader(this.f7346a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{"_id", "title", "eventLocation", "description", "dtstart", "dtend", "calendar_id", "rrule", "deleted"}, null, null, " dtstart asc ");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) throws NumberFormatException {
        C3250y.m11458g("*******************onLoadFinished()", VCalendarListFragment.f7311a);
        C3250y.m11458g("*******************Event count : " + cursor.getCount(), VCalendarListFragment.f7311a);
        this.f7346a.m7799a(cursor);
        if (this.f7346a.f7320j.size() > 0) {
            this.f7346a.f7317g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f7346a.f7318h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f7346a.m7804a((ArrayList<String>) this.f7346a.f7320j, (ArrayList<ArrayList<C1921f>>) this.f7346a.f7321k);
        } else {
            this.f7346a.f7317g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f7346a.f7318h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        if (this.f7346a.f7324n != null) {
            this.f7346a.f7324n.dismiss();
        }
        if (!TextUtils.isEmpty(this.f7346a.f7316f.m11463a().toString())) {
            this.f7346a.m7803a(this.f7346a.f7316f.m11463a().toString());
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }
}
