package com.sec.chaton.multimedia.vcalendar;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.h */
/* loaded from: classes.dex */
class C1028h implements LoaderManager.LoaderCallbacks {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f3771a;

    C1028h(VCalendarListFragment vCalendarListFragment) {
        this.f3771a = vCalendarListFragment;
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader onCreateLoader(int i, Bundle bundle) throws ClassNotFoundException {
        C1786r.m6067f("onCreateLoader()", VCalendarListFragment.f3736a);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.provider.CalendarContract$Events");
                return new CursorLoader(this.f3771a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{(String) cls.getField("_ID").get(new String()), (String) cls.getField("TITLE").get(new String()), (String) cls.getField("EVENT_LOCATION").get(new String()), (String) cls.getField("DESCRIPTION").get(new String()), (String) cls.getField("DTSTART").get(new String()), (String) cls.getField("DTEND").get(new String()), (String) cls.getField("CALENDAR_ID").get(new String()), (String) cls.getField("RRULE").get(new String()), (String) cls.getField("EVENT_TIMEZONE").get(new String()), (String) cls.getField("DELETED").get(new String())}, null, null, " dtstart asc ");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return new CursorLoader(this.f3771a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{"_id", "title", "eventLocation", "description", "dtstart", "dtend", "calendar_id", "rrule", "eventTimezone", "deleted"}, null, null, " dtstart asc ");
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) throws NumberFormatException {
        C1786r.m6067f("*******************onLoadFinished()", VCalendarListFragment.f3736a);
        C1786r.m6067f("*******************Event count : " + cursor.getCount(), VCalendarListFragment.f3736a);
        this.f3771a.m3969a(cursor);
        this.f3771a.m3974a(this.f3771a.f3745j, this.f3771a.f3746k);
        if (this.f3771a.f3749n != null) {
            this.f3771a.f3749n.dismiss();
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader loader) {
    }
}
