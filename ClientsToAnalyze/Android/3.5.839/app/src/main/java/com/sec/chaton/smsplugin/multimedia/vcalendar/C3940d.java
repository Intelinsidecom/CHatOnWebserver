package com.sec.chaton.smsplugin.multimedia.vcalendar;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.InterfaceC0028an;
import android.support.v4.content.C0091c;
import android.support.v4.content.C0094f;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.sec.chaton.multimedia.vcalendar.C2890f;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: MmsVCalendarListFragment.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.vcalendar.d */
/* loaded from: classes.dex */
class C3940d implements InterfaceC0028an<Cursor> {

    /* renamed from: a */
    final /* synthetic */ MmsVCalendarListFragment f14201a;

    C3940d(MmsVCalendarListFragment mmsVCalendarListFragment) {
        this.f14201a = mmsVCalendarListFragment;
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public C0094f<Cursor> mo112a(int i, Bundle bundle) {
        C4904y.m18639b("onCreateLoader()", MmsVCalendarListFragment.f14180a);
        return new C0091c(this.f14201a.getActivity(), Uri.parse("content://com.android.calendar/events"), new String[]{"_id", "title", "eventLocation", "description", "dtstart", "dtend", "calendar_id", "rrule", "deleted"}, null, null, " dtstart asc ");
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo114a(C0094f<Cursor> c0094f, Cursor cursor) throws NumberFormatException {
        C4904y.m18639b("*******************onLoadFinished()", MmsVCalendarListFragment.f14180a);
        C4904y.m18639b("*******************Event count : " + cursor.getCount(), MmsVCalendarListFragment.f14180a);
        this.f14201a.m15199a(cursor);
        if (this.f14201a.f14190k.size() > 0) {
            this.f14201a.f14186g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f14201a.m15206a(false);
            this.f14201a.m15205a((ArrayList<String>) this.f14201a.f14190k, (ArrayList<ArrayList<C2890f>>) this.f14201a.f14191l);
        } else {
            this.f14201a.f14186g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f14201a.m15206a(true);
        }
        if (this.f14201a.f14194o != null) {
            this.f14201a.f14194o.dismiss();
        }
        if (!TextUtils.isEmpty(this.f14201a.f14185f.m18658a().toString())) {
            this.f14201a.m15204a(this.f14201a.f14185f.m18658a().toString());
        }
    }

    @Override // android.support.v4.app.InterfaceC0028an
    /* renamed from: a */
    public void mo113a(C0094f<Cursor> c0094f) {
    }
}
