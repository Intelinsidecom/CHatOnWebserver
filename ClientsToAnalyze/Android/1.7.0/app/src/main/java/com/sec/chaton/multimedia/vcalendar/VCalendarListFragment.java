package com.sec.chaton.multimedia.vcalendar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import com.sec.chaton.InterfaceC0726l;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C1303az;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.C1619g;
import com.sec.widget.EditTextWithClearButton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class VCalendarListFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, InterfaceC0726l {

    /* renamed from: a */
    public static final String f2770a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f2772c;

    /* renamed from: d */
    private View f2773d;

    /* renamed from: e */
    private Context f2774e;

    /* renamed from: f */
    private EditTextWithClearButton f2775f;

    /* renamed from: g */
    private ExpandableListView f2776g;

    /* renamed from: h */
    private LinearLayout f2777h;

    /* renamed from: i */
    private C0816f f2778i;

    /* renamed from: j */
    private ArrayList f2779j;

    /* renamed from: k */
    private ArrayList f2780k;

    /* renamed from: l */
    private ArrayList f2781l;

    /* renamed from: m */
    private ArrayList f2782m;

    /* renamed from: n */
    private Dialog f2783n;

    /* renamed from: o */
    private ProgressDialog f2784o;

    /* renamed from: p */
    private BroadcastReceiver f2785p;

    /* renamed from: q */
    private TextWatcher f2786q = new C0821k(this);

    /* renamed from: b */
    LoaderManager.LoaderCallbacks f2771b = new C0820j(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4663f("onCreate()", f2770a);
        if (bundle != null) {
            C1619g.m5888a(getActivity().getBaseContext(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
            getActivity().finish();
        } else {
            BaseActivity.m2041a(this, true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1341p.m4663f("onCreateView()", f2770a);
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcalendar_list, viewGroup, false);
        this.f2773d = viewInflate;
        this.f2774e = getActivity();
        this.f2772c = getArguments().getString("inbox_NO");
        this.f2779j = new ArrayList();
        this.f2780k = new ArrayList();
        this.f2781l = new ArrayList();
        this.f2782m = new ArrayList();
        this.f2784o = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_geo_loading);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1341p.m4663f("onStart()", f2770a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C1341p.m4663f("onResume()", f2770a);
        super.onResume();
        m3336e();
        m3332c();
        m3334d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        m3339g();
        try {
            this.f2775f.removeTextChangedListener(this.f2786q);
        } catch (Exception e) {
        }
        if (this.f2784o != null && this.f2784o.isShowing()) {
            this.f2784o.dismiss();
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        try {
            this.f2775f.removeTextChangedListener(this.f2786q);
        } catch (Exception e) {
        }
        super.onStop();
    }

    /* renamed from: c */
    private void m3332c() {
        this.f2775f = (EditTextWithClearButton) this.f2773d.findViewById(R.id.vcal_events_search);
        this.f2775f.setShowSearch(true);
        this.f2775f.setMaxLengthString(R.string.toast_text_max_Length);
        this.f2776g = (ExpandableListView) this.f2773d.findViewById(R.id.vcal_events_list);
        this.f2776g.setOnGroupClickListener(this);
        this.f2776g.setOnChildClickListener(this);
        this.f2777h = (LinearLayout) this.f2773d.findViewById(R.id.vcal_events_noresult);
    }

    /* renamed from: d */
    private void m3334d() {
        this.f2775f.removeTextChangedListener(this.f2786q);
        this.f2775f.addTextChangedListener(this.f2786q);
        if (this.f2778i == null) {
            this.f2778i = new C0816f(this.f2776g, getActivity(), this.f2781l, R.layout.vcalendar_eventlist_adapter_group, this.f2782m, R.layout.vcalendar_eventlist_adapter_child);
        }
        if (this.f2776g.getAdapter() == null) {
            this.f2776g.setAdapter(this.f2778i);
        }
        this.f2783n = new C1356c(getActivity()).m4728a(R.string.dialog_geo_loading);
        this.f2783n.show();
        getLoaderManager().restartLoader(0, null, this.f2771b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3324a(Cursor cursor) throws NumberFormatException {
        String string;
        Long lValueOf;
        Long lValueOf2;
        long j;
        C1341p.m4663f("createEventsDataSet()", f2770a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList arrayList = new ArrayList();
        this.f2779j.clear();
        this.f2780k.clear();
        C1341p.m4663f("CURSOR POSITION : " + cursor.getPosition(), f2770a);
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        int i = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(2, 1);
        int i2 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime()));
        C1341p.m4663f("*** 1 MONTH BEFORE : " + i, f2770a);
        C1341p.m4663f("*** 1 MONTH AFTER  : " + i2, f2770a);
        while (cursor.moveToNext()) {
            C1341p.m4663f("CURSOR POSITION : " + cursor.getPosition(), f2770a);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTimeInMillis(cursor.getLong(4));
            int i3 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar3.getTime()));
            C1341p.m4663f("*** EVENT DATE  : " + i3 + ", title :" + cursor.getString(1), f2770a);
            if (cursor.getInt(9) != 1) {
                if (i3 < i || i3 > i2) {
                    C1341p.m4663f("*** SKIP ***", f2770a);
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
                    if (!this.f2779j.contains(str)) {
                        this.f2779j.add(str);
                    }
                    if (TextUtils.isEmpty(cursor.getString(1))) {
                        string = getString(R.string.insert_calendar_no_title);
                    } else {
                        string = cursor.getString(1);
                    }
                    Long lValueOf3 = Long.valueOf(calendar3.getTimeInMillis());
                    Long lValueOf4 = Long.valueOf(calendar4.getTimeInMillis());
                    String string2 = cursor.getString(2) == null ? "" : cursor.getString(2);
                    String string3 = cursor.getString(3) == null ? "" : cursor.getString(3);
                    if (cursor.getInt(8) != 0) {
                        TimeZone timeZone = TimeZone.getDefault();
                        long rawOffset = timeZone.getRawOffset();
                        long dSTSavings = timeZone.getDSTSavings();
                        if (dSTSavings != 0) {
                            j = true == timeZone.inDaylightTime(new Date(lValueOf3.longValue())) ? rawOffset + dSTSavings : rawOffset;
                            if (true == timeZone.inDaylightTime(new Date(lValueOf4.longValue()))) {
                                rawOffset += dSTSavings;
                            }
                        } else {
                            j = rawOffset;
                        }
                        lValueOf2 = Long.valueOf(lValueOf3.longValue() - j);
                        lValueOf = Long.valueOf(lValueOf4.longValue() - rawOffset);
                    } else {
                        lValueOf = lValueOf4;
                        lValueOf2 = lValueOf3;
                    }
                    arrayList.add(new C0817g(string, lValueOf2, lValueOf, string2, string3));
                }
            }
        }
        Collections.sort(this.f2779j);
        Iterator it = this.f2779j.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C0817g c0817g = (C0817g) it2.next();
                if (str2.equals(simpleDateFormat.format(new Date(c0817g.m3344b().longValue())))) {
                    arrayList2.add(new C0817g(c0817g));
                }
            }
            this.f2780k.add(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3328a(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.f2780k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0817g c0817g = (C0817g) it2.next();
                if (C1303az.m4552a(c0817g.m3343a().toUpperCase(), str.toUpperCase())) {
                    arrayList3.add(new C0817g(c0817g));
                }
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            String str2 = new SimpleDateFormat("yyyy/MM/dd").format(new Date(((C0817g) it3.next()).m3344b().longValue()));
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
                C0817g c0817g2 = (C0817g) it5.next();
                if (str3.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date(c0817g2.m3344b().longValue())))) {
                    arrayList4.add(new C0817g(c0817g2));
                }
            }
            arrayList2.add(arrayList4);
        }
        if (arrayList.size() > 0) {
            this.f2776g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f2777h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            m3329a(arrayList, arrayList2);
            return;
        }
        this.f2776g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f2777h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3329a(ArrayList arrayList, ArrayList arrayList2) {
        C1341p.m4663f("supplyDataToAdapter()", f2770a);
        this.f2781l.clear();
        this.f2782m.clear();
        Iterator it = arrayList.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            String str = (String) it.next();
            this.f2781l.add(str);
            if (str.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))) {
                i2 = i;
            }
            i++;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList3 = (ArrayList) it2.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(new C0817g((C0817g) it3.next()));
            }
            this.f2782m.add(arrayList4);
        }
        C1341p.m4663f("mAdapter.getGroupCount() : " + this.f2778i.getGroupCount(), f2770a);
        this.f2778i.notifyDataSetChanged();
        C1341p.m4663f("mGroupData.size() : " + this.f2779j.size(), f2770a);
        C1341p.m4663f("mAdapterGroupData.size() : " + this.f2781l.size(), f2770a);
        C1341p.m4663f("mAdapter.getGroupCount() : " + this.f2778i.getGroupCount(), f2770a);
        for (int i3 = 0; i3 < this.f2778i.getGroupCount(); i3++) {
            this.f2776g.expandGroup(i3);
        }
        if (i2 != -1) {
            C1341p.m4658b("todayPosition() : " + i2, f2770a);
            this.f2776g.setSelectedGroup(i2);
        } else {
            this.f2776g.setSelectedGroup(this.f2776g.getCount() - 1);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C0817g c0817g = (C0817g) ((ArrayList) this.f2782m.get(i)).get(i2);
        C1341p.m4658b("******** " + c0817g.m3343a(), f2770a);
        C1341p.m4658b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c0817g.m3344b().longValue())), f2770a);
        C1341p.m4658b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c0817g.m3345c().longValue())), f2770a);
        C1341p.m4658b("******** " + c0817g.m3346d(), f2770a);
        C1341p.m4658b("******** " + c0817g.m3347e(), f2770a);
        if (this.f2784o != null) {
            this.f2784o.show();
        }
        Intent intent = new Intent(this.f2774e, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("extra summary", c0817g.m3343a());
        intent.putExtra("extra dtstart", c0817g.m3344b());
        intent.putExtra("extra dtend", c0817g.m3345c());
        intent.putExtra("extra location", c0817g.m3346d());
        intent.putExtra("extra desc", c0817g.m3347e());
        intent.putExtra("ACTIVITY_PURPOSE", 1);
        intent.putExtra("inbox_NO", this.f2772c);
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
            if (i2 == 0 && i == 5) {
                getActivity().setResult(0, intent);
                getActivity().finish();
            }
        }
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: a */
    public void mo2192a() {
        BaseActivity.m2041a(this, true);
    }

    @Override // com.sec.chaton.InterfaceC0726l
    /* renamed from: b */
    public void mo2200b() {
        BaseActivity.m2041a(this, false);
    }

    /* renamed from: e */
    private void m3336e() {
        this.f2785p = new C0822l(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f2774e.registerReceiver(this.f2785p, intentFilter);
        m3338f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3338f() {
        if (!C1327bw.m4595a()) {
            C1619g.m5888a(this.f2774e, R.string.sdcard_not_found, 0).show();
            getActivity().finish();
        }
    }

    /* renamed from: g */
    private void m3339g() {
        this.f2774e.unregisterReceiver(this.f2785p);
    }
}
