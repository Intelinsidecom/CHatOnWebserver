package com.sec.chaton.multimedia.vcalendar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import com.sec.chaton.C0062R;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.HangulJamoUtil;
import com.sec.chaton.widget.SMSProgressBar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VCalendarListFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, HomeTabFragment.OnTabChangeListener {

    /* renamed from: a */
    public static final String f2218a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f2220c;

    /* renamed from: d */
    private View f2221d;

    /* renamed from: e */
    private Context f2222e;

    /* renamed from: f */
    private EditText f2223f;

    /* renamed from: g */
    private ExpandableListView f2224g;

    /* renamed from: h */
    private LinearLayout f2225h;

    /* renamed from: i */
    private VCalendarListAdapter2 f2226i;

    /* renamed from: j */
    private ArrayList f2227j;

    /* renamed from: k */
    private ArrayList f2228k;

    /* renamed from: l */
    private ArrayList f2229l;

    /* renamed from: m */
    private ArrayList f2230m;

    /* renamed from: n */
    private Dialog f2231n;

    /* renamed from: o */
    private TextWatcher f2232o = new C0315g(this);

    /* renamed from: b */
    LoaderManager.LoaderCallbacks f2219b = new C0316h(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2587a(Cursor cursor) throws NumberFormatException {
        Calendar calendar;
        ChatONLogWriter.m3512f("createEventsDataSet()", f2218a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList arrayList = new ArrayList();
        this.f2227j.clear();
        this.f2228k.clear();
        ChatONLogWriter.m3512f("CURSOR POSITION : " + cursor.getPosition(), f2218a);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(2, -1);
        int i = Integer.parseInt(new SimpleDateFormat("MMdd").format(calendar2.getTime()));
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(2, 1);
        int i2 = Integer.parseInt(new SimpleDateFormat("MMdd").format(calendar3.getTime()));
        ChatONLogWriter.m3512f("*** 1 MONTH BEFORE : " + i, f2218a);
        ChatONLogWriter.m3512f("*** 1 MONTH AFTER  : " + i2, f2218a);
        while (cursor.moveToNext()) {
            ChatONLogWriter.m3512f("CURSOR POSITION : " + cursor.getPosition(), f2218a);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTimeInMillis(cursor.getLong(4));
            int i3 = Integer.parseInt(new SimpleDateFormat("MMdd").format(calendar4.getTime()));
            ChatONLogWriter.m3512f("*** EVENT DATE  : " + i3, f2218a);
            if (i3 < i || i3 > i2) {
                ChatONLogWriter.m3512f("*** SKIP ***", f2218a);
            } else {
                Calendar calendar5 = Calendar.getInstance();
                if (cursor.getLong(4) < 1) {
                    calendar4.set(1, Calendar.getInstance().get(1));
                }
                if (cursor.getLong(5) < 1) {
                    calendar = calendar4;
                } else {
                    calendar5.setTimeInMillis(cursor.getLong(5));
                    calendar = calendar5;
                }
                String str = simpleDateFormat.format(calendar4.getTime());
                if (!this.f2227j.contains(str)) {
                    this.f2227j.add(str);
                }
                arrayList.add(new VCalendarListChildItem((cursor.getString(1) == null || cursor.getString(1).equals("")) ? "No title" : cursor.getString(1), Long.valueOf(calendar4.getTimeInMillis()), Long.valueOf(calendar.getTimeInMillis()), cursor.getString(2) == null ? "" : cursor.getString(2), cursor.getString(3) == null ? "" : cursor.getString(3)));
            }
        }
        Collections.sort(this.f2227j);
        Iterator it = this.f2227j.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                VCalendarListChildItem vCalendarListChildItem = (VCalendarListChildItem) it2.next();
                if (str2.equals(simpleDateFormat.format(new Date(vCalendarListChildItem.m2583b().longValue())))) {
                    arrayList2.add(new VCalendarListChildItem(vCalendarListChildItem));
                }
            }
            this.f2228k.add(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2592a(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = this.f2228k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                VCalendarListChildItem vCalendarListChildItem = (VCalendarListChildItem) it2.next();
                if (HangulJamoUtil.m3582a(vCalendarListChildItem.m2582a().toUpperCase(), str.toUpperCase())) {
                    arrayList3.add(new VCalendarListChildItem(vCalendarListChildItem));
                }
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            String str2 = new SimpleDateFormat("yyyy/MM/dd").format(new Date(((VCalendarListChildItem) it3.next()).m2583b().longValue()));
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
                VCalendarListChildItem vCalendarListChildItem2 = (VCalendarListChildItem) it5.next();
                if (str3.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date(vCalendarListChildItem2.m2583b().longValue())))) {
                    arrayList4.add(new VCalendarListChildItem(vCalendarListChildItem2));
                }
            }
            arrayList2.add(arrayList4);
        }
        if (arrayList.size() <= 0) {
            this.f2224g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            this.f2225h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            return;
        }
        this.f2224g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f2225h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        m2593a(arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2593a(ArrayList arrayList, ArrayList arrayList2) {
        ChatONLogWriter.m3512f("supplyDataToAdapter()", f2218a);
        this.f2229l.clear();
        this.f2230m.clear();
        Iterator it = arrayList.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            String str = (String) it.next();
            this.f2229l.add(str);
            int i3 = str.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date())) ? i : i2;
            i++;
            i2 = i3;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList arrayList3 = (ArrayList) it2.next();
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(new VCalendarListChildItem((VCalendarListChildItem) it3.next()));
            }
            this.f2230m.add(arrayList4);
        }
        ChatONLogWriter.m3512f("mAdapter.getGroupCount() : " + this.f2226i.getGroupCount(), f2218a);
        this.f2226i.notifyDataSetChanged();
        ChatONLogWriter.m3512f("mGroupData.size() : " + this.f2227j.size(), f2218a);
        ChatONLogWriter.m3512f("mAdapterGroupData.size() : " + this.f2229l.size(), f2218a);
        ChatONLogWriter.m3512f("mAdapter.getGroupCount() : " + this.f2226i.getGroupCount(), f2218a);
        for (int i4 = 0; i4 < this.f2226i.getGroupCount(); i4++) {
            this.f2224g.expandGroup(i4);
        }
        if (i2 == -1) {
            this.f2224g.setSelectedGroup(0);
        } else {
            ChatONLogWriter.m3506b("todayPosition() : " + i2, f2218a);
            this.f2224g.setSelectedGroup(i2);
        }
    }

    /* renamed from: c */
    private void m2596c() {
        this.f2223f = (EditText) this.f2221d.findViewById(C0062R.id.vcal_events_search);
        this.f2224g = (ExpandableListView) this.f2221d.findViewById(C0062R.id.vcal_events_list);
        this.f2224g.setOnGroupClickListener(this);
        this.f2224g.setOnChildClickListener(this);
        this.f2225h = (LinearLayout) this.f2221d.findViewById(C0062R.id.vcal_events_noresult);
    }

    /* renamed from: d */
    private void m2598d() {
        this.f2223f.removeTextChangedListener(this.f2232o);
        this.f2223f.setText("");
        this.f2223f.addTextChangedListener(this.f2232o);
        if (this.f2226i == null) {
            this.f2226i = new VCalendarListAdapter2(this.f2224g, getActivity(), this.f2229l, C0062R.layout.vcalendar_eventlist_adapter_group, this.f2230m, C0062R.layout.vcalendar_eventlist_adapter_child);
        }
        if (this.f2224g.getAdapter() == null) {
            this.f2224g.setAdapter(this.f2226i);
        }
        this.f2231n = new SMSProgressBar(getActivity()).onCreate(C0062R.string.dialog_geo_loading);
        this.f2231n.show();
        getLoaderManager().mo37a(0, null, this.f2219b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2600e() throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(C0062R.drawable.btn_del);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.f2223f.getText().toString().length() > 0) {
            this.f2223f.setCompoundDrawables(null, null, drawable, null);
            this.f2223f.setOnTouchListener(new ViewOnTouchListenerC0314f(this, drawable));
        } else {
            Drawable drawable2 = getResources().getDrawable(C0062R.drawable.ic_btn_search);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.f2223f.setCompoundDrawables(null, null, drawable2, null);
            this.f2223f.setOnTouchListener(null);
        }
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: a */
    public void mo390a() {
        setHasOptionsMenu(true);
    }

    @Override // com.sec.chaton.HomeTabFragment.OnTabChangeListener
    /* renamed from: b */
    public void mo391b() {
        setHasOptionsMenu(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (getActivity() == null) {
            return;
        }
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

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        VCalendarListChildItem vCalendarListChildItem = (VCalendarListChildItem) ((ArrayList) this.f2230m.get(i)).get(i2);
        ChatONLogWriter.m3506b("******** " + vCalendarListChildItem.m2582a(), f2218a);
        ChatONLogWriter.m3506b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(vCalendarListChildItem.m2583b().longValue())), f2218a);
        ChatONLogWriter.m3506b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(vCalendarListChildItem.m2584c().longValue())), f2218a);
        ChatONLogWriter.m3506b("******** " + vCalendarListChildItem.m2585d(), f2218a);
        ChatONLogWriter.m3506b("******** " + vCalendarListChildItem.m2586e(), f2218a);
        Intent intent = new Intent(this.f2222e, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("extra summary", vCalendarListChildItem.m2582a());
        intent.putExtra("extra dtstart", vCalendarListChildItem.m2583b());
        intent.putExtra("extra dtend", vCalendarListChildItem.m2584c());
        intent.putExtra("extra location", vCalendarListChildItem.m2585d());
        intent.putExtra("extra desc", vCalendarListChildItem.m2586e());
        intent.putExtra("ACTIVITY_PURPOSE", 1);
        intent.putExtra("inbox_NO", this.f2220c);
        startActivityForResult(intent, 5);
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3512f("onCreate()", f2218a);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ChatONLogWriter.m3512f("onCreateView()", f2218a);
        View viewInflate = layoutInflater.inflate(C0062R.layout.layout_multimedia_vcalendar_list, viewGroup, false);
        this.f2221d = viewInflate;
        this.f2222e = getActivity();
        this.f2220c = getArguments().getString("inbox_NO");
        this.f2227j = new ArrayList();
        this.f2228k = new ArrayList();
        this.f2229l = new ArrayList();
        this.f2230m = new ArrayList();
        return viewInflate;
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        try {
            this.f2223f.removeTextChangedListener(this.f2232o);
        } catch (Exception e) {
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        ChatONLogWriter.m3512f("onResume()", f2218a);
        super.onResume();
        m2596c();
        m2598d();
        m2600e();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        ChatONLogWriter.m3512f("onStart()", f2218a);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        try {
            this.f2223f.removeTextChangedListener(this.f2232o);
        } catch (Exception e) {
        }
        super.onStop();
    }
}
