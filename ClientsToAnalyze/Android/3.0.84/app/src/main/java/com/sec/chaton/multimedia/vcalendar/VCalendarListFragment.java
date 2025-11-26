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
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.InterfaceC0813bw;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3177as;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.widget.C3641ai;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class VCalendarListFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, InterfaceC0813bw {

    /* renamed from: a */
    public static final String f7311a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f7313c;

    /* renamed from: d */
    private View f7314d;

    /* renamed from: e */
    private Context f7315e;

    /* renamed from: f */
    private ClearableEditText f7316f;

    /* renamed from: g */
    private ExpandableListView f7317g;

    /* renamed from: h */
    private View f7318h;

    /* renamed from: i */
    private C1920e f7319i;

    /* renamed from: j */
    private ArrayList<String> f7320j;

    /* renamed from: k */
    private ArrayList<ArrayList<C1921f>> f7321k;

    /* renamed from: l */
    private ArrayList<String> f7322l;

    /* renamed from: m */
    private ArrayList<ArrayList<C1921f>> f7323m;

    /* renamed from: n */
    private Dialog f7324n;

    /* renamed from: o */
    private ProgressDialog f7325o;

    /* renamed from: p */
    private BroadcastReceiver f7326p;

    /* renamed from: q */
    private TextWatcher f7327q = new C1922g(this);

    /* renamed from: b */
    LoaderManager.LoaderCallbacks<Cursor> f7312b = new C1923h(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C3250y.m11458g("onCreate()", f7311a);
        setHasOptionsMenu(true);
        BaseActivity.m3081a(this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3250y.m11458g("onCreateView()", f7311a);
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcalendar_list, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.layout_search_calendar).findViewById(R.id.searchfieldLayout);
        linearLayout.setPadding((int) C3172an.m11085a(4.5f), 0, (int) C3172an.m11085a(4.5f), 0);
        linearLayout.setGravity(1);
        this.f7314d = viewInflate;
        this.f7315e = getActivity();
        this.f7313c = getArguments().getString("inbox_NO");
        this.f7320j = new ArrayList<>();
        this.f7321k = new ArrayList<>();
        this.f7322l = new ArrayList<>();
        this.f7323m = new ArrayList<>();
        this.f7325o = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_geo_loading);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C3250y.m11458g("onStart()", f7311a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C3250y.m11458g("onResume()", f7311a);
        super.onResume();
        m7810e();
        m7798a();
        m7808d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        m7813g();
        try {
            if (this.f7316f != null) {
                this.f7316f.m11467b(this.f7327q);
                ((InputMethodManager) this.f7315e.getSystemService("input_method")).hideSoftInputFromWindow(this.f7316f.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
        if (this.f7325o != null && this.f7325o.isShowing()) {
            this.f7325o.dismiss();
        }
        super.onPause();
    }

    /* renamed from: a */
    private void m7798a() {
        View viewFindViewById = this.f7314d.findViewById(R.id.layout_search_calendar);
        this.f7316f = (ClearableEditText) viewFindViewById.findViewById(R.id.text1);
        this.f7316f.setHint(R.string.vcalendar_list_search_hint);
        this.f7316f.setFilters(new InputFilter[]{new C3248w(getActivity(), 30)});
        ((ImageButton) viewFindViewById.findViewById(R.id.button1)).setVisibility(8);
        this.f7317g = (ExpandableListView) this.f7314d.findViewById(R.id.vcal_events_list);
        this.f7317g.setOnGroupClickListener(this);
        this.f7317g.setOnChildClickListener(this);
        this.f7318h = this.f7314d.findViewById(R.id.vcal_events_noresult);
        ((ImageView) this.f7318h.findViewById(R.id.image1)).setVisibility(8);
        ((TextView) this.f7318h.findViewById(R.id.text1)).setText(R.string.calendar_no_schedule);
        ((TextView) this.f7318h.findViewById(R.id.text2)).setText(R.string.calendar_schedule_info_message);
    }

    /* renamed from: d */
    private void m7808d() {
        this.f7316f.m11467b(this.f7327q);
        this.f7316f.m11464a(this.f7327q);
        if (this.f7319i == null) {
            this.f7319i = new C1920e(this.f7317g, getActivity(), this.f7322l, R.layout.vcalendar_eventlist_adapter_group, this.f7323m, R.layout.list_item_common_4);
        }
        if (this.f7317g.getAdapter() == null) {
            this.f7317g.setAdapter(this.f7319i);
        }
        this.f7324n = new C3263j(getActivity()).m11487a(R.string.dialog_geo_loading);
        this.f7324n.show();
        getLoaderManager().restartLoader(0, null, this.f7312b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7799a(Cursor cursor) throws NumberFormatException {
        String string;
        C3250y.m11458g("createEventsDataSet()", f7311a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList arrayList = new ArrayList();
        this.f7320j.clear();
        this.f7321k.clear();
        C3250y.m11458g("CURSOR POSITION : " + cursor.getPosition(), f7311a);
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        int i = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(2, 1);
        int i2 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime()));
        C3250y.m11458g("*** 1 MONTH BEFORE : " + i, f7311a);
        C3250y.m11458g("*** 1 MONTH AFTER  : " + i2, f7311a);
        while (cursor.moveToNext()) {
            C3250y.m11458g("CURSOR POSITION : " + cursor.getPosition(), f7311a);
            if (cursor.getInt(8) == 1) {
                C3250y.m11458g("*** SKIP : DELETED ***", f7311a);
            } else {
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTimeZone(TimeZone.getTimeZone("GMT"));
                calendar3.setTimeInMillis(cursor.getLong(4));
                int i3 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar3.getTime()));
                C3250y.m11458g("*** EVENT DATE  : " + i3 + ", title :" + cursor.getString(1), f7311a);
                if (i3 < i || i3 > i2) {
                    C3250y.m11458g("*** SKIP ***", f7311a);
                } else {
                    Calendar calendar4 = Calendar.getInstance();
                    calendar4.setTimeZone(TimeZone.getTimeZone("GMT"));
                    if (cursor.getLong(4) < 1) {
                        calendar3.set(1, Calendar.getInstance().get(1));
                    }
                    if (cursor.getLong(5) < 1) {
                        calendar4 = calendar3;
                    } else {
                        calendar4.setTimeInMillis(cursor.getLong(5));
                    }
                    String str = simpleDateFormat.format(calendar3.getTime());
                    if (!this.f7320j.contains(str)) {
                        this.f7320j.add(str);
                    }
                    if (TextUtils.isEmpty(cursor.getString(1))) {
                        string = getString(R.string.insert_calendar_no_title);
                    } else {
                        string = cursor.getString(1);
                    }
                    arrayList.add(new C1921f(string, Long.valueOf(calendar3.getTimeInMillis()), Long.valueOf(calendar4.getTimeInMillis()), cursor.getString(2) == null ? "" : cursor.getString(2), cursor.getString(3) == null ? "" : cursor.getString(3)));
                }
            }
        }
        Collections.sort(this.f7320j);
        Iterator<String> it = this.f7320j.iterator();
        while (it.hasNext()) {
            String next = it.next();
            ArrayList<C1921f> arrayList2 = new ArrayList<>();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1921f c1921f = (C1921f) it2.next();
                if (next.equals(simpleDateFormat.format(new Date(c1921f.m7825b().longValue())))) {
                    arrayList2.add(new C1921f(c1921f));
                }
            }
            this.f7321k.add(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7803a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<C1921f>> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator<ArrayList<C1921f>> it = this.f7321k.iterator();
        while (it.hasNext()) {
            Iterator<C1921f> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C1921f next = it2.next();
                if (C3177as.m11097b(next.m7824a().toUpperCase(), str.toUpperCase())) {
                    arrayList3.add(new C1921f(next));
                }
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            String str2 = new SimpleDateFormat("yyyy/MM/dd").format(new Date(((C1921f) it3.next()).m7825b().longValue()));
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        Iterator<String> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            String next2 = it4.next();
            ArrayList<C1921f> arrayList4 = new ArrayList<>();
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                C1921f c1921f = (C1921f) it5.next();
                if (next2.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date(c1921f.m7825b().longValue())))) {
                    arrayList4.add(new C1921f(c1921f));
                }
            }
            arrayList2.add(arrayList4);
        }
        if (arrayList.size() > 0) {
            this.f7317g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            this.f7318h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            m7804a(arrayList, arrayList2);
            return;
        }
        this.f7317g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
        this.f7318h.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7804a(ArrayList<String> arrayList, ArrayList<ArrayList<C1921f>> arrayList2) {
        C3250y.m11458g("supplyDataToAdapter()", f7311a);
        this.f7322l.clear();
        this.f7323m.clear();
        Iterator<String> it = arrayList.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            String next = it.next();
            this.f7322l.add(next);
            if (next.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))) {
                i2 = i;
            }
            i++;
        }
        Iterator<ArrayList<C1921f>> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList<C1921f> next2 = it2.next();
            ArrayList<C1921f> arrayList3 = new ArrayList<>();
            Iterator<C1921f> it3 = next2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(new C1921f(it3.next()));
            }
            this.f7323m.add(arrayList3);
        }
        C3250y.m11458g("mAdapter.getGroupCount() : " + this.f7319i.getGroupCount(), f7311a);
        this.f7319i.m7823a(this.f7316f.m11463a().toString());
        this.f7319i.notifyDataSetChanged();
        C3250y.m11458g("mGroupData.size() : " + this.f7320j.size(), f7311a);
        C3250y.m11458g("mAdapterGroupData.size() : " + this.f7322l.size(), f7311a);
        C3250y.m11458g("mAdapter.getGroupCount() : " + this.f7319i.getGroupCount(), f7311a);
        for (int i3 = 0; i3 < this.f7319i.getGroupCount(); i3++) {
            this.f7317g.expandGroup(i3);
        }
        if (i2 != -1) {
            C3250y.m11450b("todayPosition() : " + i2, f7311a);
            this.f7317g.setSelectedGroup(i2);
        } else {
            this.f7317g.setSelectedGroup(this.f7317g.getCount() - 1);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C1921f c1921f = this.f7323m.get(i).get(i2);
        C3250y.m11450b("******** " + c1921f.m7824a(), f7311a);
        C3250y.m11450b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c1921f.m7825b().longValue())), f7311a);
        C3250y.m11450b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c1921f.m7826c().longValue())), f7311a);
        C3250y.m11450b("******** " + c1921f.m7827d(), f7311a);
        C3250y.m11450b("******** " + c1921f.m7828e(), f7311a);
        if (this.f7325o != null) {
            this.f7325o.show();
        }
        Intent intent = new Intent(this.f7315e, (Class<?>) VCalendarDetailActivity2.class);
        intent.putExtra("extra summary", c1921f.m7824a());
        intent.putExtra("extra dtstart", c1921f.m7825b());
        intent.putExtra("extra dtend", c1921f.m7826c());
        intent.putExtra("extra location", c1921f.m7827d());
        intent.putExtra("extra desc", c1921f.m7828e());
        intent.putExtra("ACTIVITY_PURPOSE", 1);
        intent.putExtra("inbox_NO", this.f7313c);
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
                if (intent == null || !intent.getBooleanExtra("backKey", false)) {
                    getActivity().setResult(0, intent);
                    getActivity().finish();
                }
            }
        }
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        return true;
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: b */
    public void mo1189b() {
        BaseActivity.m3081a(this, true);
    }

    @Override // com.sec.chaton.InterfaceC0813bw
    /* renamed from: c */
    public void mo1190c() {
        BaseActivity.m3081a(this, false);
    }

    /* renamed from: e */
    private void m7810e() {
        this.f7326p = new C1924i(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f7315e.registerReceiver(this.f7326p, intentFilter);
        m7812f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7812f() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.f7315e, R.string.sdcard_not_found, 0).show();
            getActivity().finish();
        }
    }

    /* renamed from: g */
    private void m7813g() {
        this.f7315e.unregisterReceiver(this.f7326p);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }
}
