package com.sec.chaton.multimedia.vcalendar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import com.sec.chaton.InterfaceC0221al;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1725ah;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.EditTextWithClearButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class VCalendarListFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, InterfaceC0221al {

    /* renamed from: a */
    public static final String f3736a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f3738c;

    /* renamed from: d */
    private View f3739d;

    /* renamed from: e */
    private Context f3740e;

    /* renamed from: f */
    private EditTextWithClearButton f3741f;

    /* renamed from: g */
    private ExpandableListView f3742g;

    /* renamed from: h */
    private LinearLayout f3743h;

    /* renamed from: i */
    private C1025e f3744i;

    /* renamed from: j */
    private ArrayList f3745j;

    /* renamed from: k */
    private ArrayList f3746k;

    /* renamed from: l */
    private ArrayList f3747l;

    /* renamed from: m */
    private ArrayList f3748m;

    /* renamed from: n */
    private Dialog f3749n;

    /* renamed from: o */
    private ProgressDialog f3750o;

    /* renamed from: p */
    private TextWatcher f3751p = new C1027g(this);

    /* renamed from: b */
    LoaderManager.LoaderCallbacks f3737b = new C1028h(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6067f("onCreate()", f3736a);
        BaseActivity.m1827a(this, true);
        getActivity().getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6067f("onCreateView()", f3736a);
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcalendar_list, viewGroup, false);
        this.f3739d = viewInflate;
        this.f3740e = getActivity();
        this.f3738c = getArguments().getString("inbox_NO");
        this.f3745j = new ArrayList();
        this.f3746k = new ArrayList();
        this.f3747l = new ArrayList();
        this.f3748m = new ArrayList();
        this.f3750o = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_geo_loading);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6067f("onStart()", f3736a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C1786r.m6067f("onResume()", f3736a);
        super.onResume();
        m3977c();
        m3978d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        try {
            this.f3741f.removeTextChangedListener(this.f3751p);
        } catch (Exception e) {
        }
        if (this.f3750o != null && this.f3750o.isShowing()) {
            this.f3750o.dismiss();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        try {
            this.f3741f.removeTextChangedListener(this.f3751p);
        } catch (Exception e) {
        }
        super.onStop();
    }

    /* renamed from: c */
    private void m3977c() {
        if (GlobalApplication.m3265f()) {
            this.f3741f = (EditTextWithClearButton) this.f3739d.findViewById(R.id.vcal_search_text);
            this.f3741f.setShowSearch(true);
        }
        this.f3742g = (ExpandableListView) this.f3739d.findViewById(R.id.vcal_events_list);
        this.f3742g.setOnGroupClickListener(this);
        this.f3742g.setOnChildClickListener(this);
        this.f3742g.setVerticalFadingEdgeEnabled(false);
        this.f3743h = (LinearLayout) this.f3739d.findViewById(R.id.vcal_events_noresult);
    }

    /* renamed from: d */
    private void m3978d() {
        if (GlobalApplication.m3265f()) {
            this.f3741f.removeTextChangedListener(this.f3751p);
            this.f3741f.setText("");
            this.f3741f.addTextChangedListener(this.f3751p);
        }
        if (this.f3744i == null) {
            this.f3744i = new C1025e(this.f3742g, getActivity(), this.f3747l, R.layout.vcalendar_eventlist_adapter_group, this.f3748m, R.layout.vcalendar_eventlist_adapter_child);
        }
        if (this.f3742g.getAdapter() == null) {
            this.f3742g.setAdapter(this.f3744i);
        }
        this.f3749n = new C1805i(getActivity()).m6139a(R.string.dialog_geo_loading);
        getLoaderManager().restartLoader(0, null, this.f3737b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3969a(Cursor cursor) throws NumberFormatException {
        String string;
        C1786r.m6067f("createEventsDataSet()", f3736a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList arrayList = new ArrayList();
        simpleDateFormat.format(new Date());
        this.f3745j.clear();
        this.f3746k.clear();
        C1786r.m6067f("CURSOR POSITION : " + cursor.getPosition(), f3736a);
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        int i = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(2, 1);
        int i2 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime()));
        C1786r.m6067f("*** 1 MONTH BEFORE : " + i, f3736a);
        C1786r.m6067f("*** 1 MONTH AFTER  : " + i2, f3736a);
        while (cursor.moveToNext()) {
            C1786r.m6067f("CURSOR POSITION : " + cursor.getPosition(), f3736a);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(cursor.getLong(4));
            int i3 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar3.getTime()));
            C1786r.m6067f("*** EVENT DATE  : " + i3, f3736a);
            if (cursor.getInt(9) != 1) {
                if (i3 < i || i3 > i2) {
                    C1786r.m6067f("*** SKIP ***", f3736a);
                } else {
                    Calendar calendar4 = Calendar.getInstance();
                    if (cursor.getLong(4) < 1) {
                        calendar3.set(1, Calendar.getInstance().get(1));
                    }
                    if (cursor.getLong(5) < 1) {
                        calendar4 = calendar3;
                    } else {
                        calendar4.setTimeInMillis(cursor.getLong(5));
                    }
                    String str = simpleDateFormat.format(calendar3.getTime());
                    if (!this.f3745j.contains(str)) {
                        this.f3745j.add(str);
                    }
                    if (cursor.getString(1) == null || cursor.getString(1).equals("")) {
                        string = "No title";
                    } else {
                        string = cursor.getString(1);
                    }
                    arrayList.add(new C1026f(string, Long.valueOf(calendar3.getTimeInMillis()), Long.valueOf(calendar4.getTimeInMillis()), cursor.getString(2) == null ? "" : cursor.getString(2), cursor.getString(3) == null ? "" : cursor.getString(3), cursor.getString(8) == null ? "" : cursor.getString(8)));
                }
            }
        }
        Collections.sort(this.f3745j);
        Iterator it = this.f3745j.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1026f c1026f = (C1026f) it2.next();
                if (str2.equals(simpleDateFormat.format(new Date(c1026f.m3988c().longValue())))) {
                    arrayList2.add(new C1026f(c1026f));
                }
            }
            this.f3746k.add(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3973a(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.f3746k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C1026f c1026f = (C1026f) it2.next();
                if (C1725ah.m5900a(c1026f.m3987b().toUpperCase(), str.toUpperCase())) {
                    arrayList3.add(new C1026f(c1026f));
                }
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            String str2 = new SimpleDateFormat("yyyy/MM/dd").format(new Date(((C1026f) it3.next()).m3988c().longValue()));
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            String str3 = (String) it4.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                C1026f c1026f2 = (C1026f) it5.next();
                if (str3.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date(c1026f2.m3988c().longValue())))) {
                    arrayList4.add(new C1026f(c1026f2));
                }
            }
            arrayList2.add(arrayList4);
        }
        if (arrayList.size() > 0) {
            this.f3742g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f3743h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            m3974a(arrayList, arrayList2);
            return;
        }
        this.f3742g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f3743h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0042 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3974a(java.util.ArrayList r14, java.util.ArrayList r15) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.vcalendar.VCalendarListFragment.m3974a(java.util.ArrayList, java.util.ArrayList):void");
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        long j2;
        C1026f c1026f = (C1026f) ((ArrayList) this.f3748m.get(i)).get(i2);
        C1786r.m6061b("******** " + c1026f.m3987b(), f3736a);
        C1786r.m6061b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c1026f.m3988c().longValue())), f3736a);
        C1786r.m6061b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c1026f.m3989d().longValue())), f3736a);
        C1786r.m6061b("******** " + c1026f.m3990e(), f3736a);
        C1786r.m6061b("******** " + c1026f.m3991f(), f3736a);
        C1786r.m6061b("******** " + c1026f.m3986a(), f3736a);
        if (this.f3750o != null) {
            this.f3750o.show();
        }
        TimeZone timeZone = TimeZone.getDefault();
        long rawOffset = timeZone.getRawOffset();
        long dSTSavings = timeZone.getDSTSavings();
        if (dSTSavings != 0) {
            j2 = true == timeZone.inDaylightTime(new Date(c1026f.m3988c().longValue())) ? rawOffset + dSTSavings : rawOffset;
            if (true == timeZone.inDaylightTime(new Date(c1026f.m3989d().longValue()))) {
                rawOffset += dSTSavings;
            }
        } else {
            j2 = rawOffset;
        }
        Intent intent = new Intent(this.f3740e, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("extra summary", c1026f.m3987b());
        intent.putExtra("extra dtstart", c1026f.m3988c().longValue() - j2);
        intent.putExtra("extra dtend", c1026f.m3989d().longValue() - rawOffset);
        intent.putExtra("extra location", c1026f.m3990e());
        intent.putExtra("extra desc", c1026f.m3991f());
        intent.putExtra("extra timezone", c1026f.m3986a());
        intent.putExtra("ACTIVITY_PURPOSE", 1);
        intent.putExtra("inbox_NO", this.f3738c);
        startActivityForResult(intent, 5);
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (getActivity() != null) {
            if (i2 == -1) {
                if (i == 5) {
                    getActivity().setResult(-1, intent);
                    getActivity().finish();
                    return;
                }
                return;
            }
            if (i2 != 0 || i != 5) {
            }
        }
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: a */
    public void mo1821a() {
        BaseActivity.m1827a(this, true);
    }

    @Override // com.sec.chaton.InterfaceC0221al
    /* renamed from: b */
    public void mo1822b() {
        BaseActivity.m1827a(this, false);
    }
}
