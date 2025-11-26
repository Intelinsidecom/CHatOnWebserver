package com.sec.chaton.multimedia.vcalendar;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.util.ChatONLogWriter;

/* renamed from: com.sec.chaton.multimedia.vcalendar.h */
/* loaded from: classes.dex */
class C0316h implements LoaderManager.LoaderCallbacks {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f2273a;

    C0316h(VCalendarListFragment vCalendarListFragment) {
        this.f2273a = vCalendarListFragment;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public Loader mo38a(int i, Bundle bundle) {
        ChatONLogWriter.m3512f("onCreateLoader()", VCalendarListFragment.f2218a);
        return new CursorLoader(this.f2273a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{"_id", "title", "eventLocation", "description", "dtstart", "dtend", "calendar_id", "rrule"}, null, null, " dtstart asc ");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a */
    public void mo39a(Loader loader) {
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo40a(Loader loader, Cursor cursor) throws NumberFormatException {
        ChatONLogWriter.m3512f("*******************onLoadFinished()", VCalendarListFragment.f2218a);
        ChatONLogWriter.m3512f("*******************Event count : " + cursor.getCount(), VCalendarListFragment.f2218a);
        this.f2273a.m2587a(cursor);
        this.f2273a.m2593a(this.f2273a.f2227j, this.f2273a.f2228k);
        if (this.f2273a.f2231n != null) {
            this.f2273a.f2231n.dismiss();
        }
    }
}
