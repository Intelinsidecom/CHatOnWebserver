package com.sec.chaton.multimedia.vcalendar;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.InterfaceC0028an;
import android.support.v4.content.C0091c;
import android.support.v4.content.C0094f;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: VCalendarListFragment.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.h */
/* loaded from: classes.dex */
class C2892h implements InterfaceC0028an<Cursor> {

    /* renamed from: a */
    final /* synthetic */ VCalendarListFragment f10667a;

    C2892h(VCalendarListFragment vCalendarListFragment) {
        this.f10667a = vCalendarListFragment;
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public C0094f<Cursor> mo112a(int i, Bundle bundle) {
        C4904y.m18639b("onCreateLoader()", VCalendarListFragment.f10631a);
        return new C0091c(this.f10667a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{"_id", "title", "eventLocation", "description", "dtstart", "dtend", "calendar_id", "rrule", "deleted"}, null, null, " dtstart asc ");
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo114a(C0094f<Cursor> c0094f, Cursor cursor) throws NumberFormatException {
        C4904y.m18639b("*******************onLoadFinished()", VCalendarListFragment.f10631a);
        C4904y.m18639b("*******************Event count : " + cursor.getCount(), VCalendarListFragment.f10631a);
        this.f10667a.m12026a(cursor);
        if (this.f10667a.f10641k.size() > 0) {
            this.f10667a.f10637g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f10667a.m12033a(false);
            this.f10667a.m12032a((ArrayList<String>) this.f10667a.f10641k, (ArrayList<ArrayList<C2890f>>) this.f10667a.f10642l);
        } else {
            this.f10667a.f10637g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f10667a.m12033a(true);
        }
        if (this.f10667a.f10645o != null) {
            this.f10667a.f10645o.dismiss();
        }
        if (!TextUtils.isEmpty(this.f10667a.f10636f.m18658a().toString())) {
            this.f10667a.m12031a(this.f10667a.f10636f.m18658a().toString());
        }
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public void mo113a(C0094f<Cursor> c0094f) {
    }
}
