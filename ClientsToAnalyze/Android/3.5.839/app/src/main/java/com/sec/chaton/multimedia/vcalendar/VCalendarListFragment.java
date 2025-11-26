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
import android.support.v4.app.InterfaceC0028an;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.InterfaceC2318el;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.util.C4827as;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class VCalendarListFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, InterfaceC2318el {

    /* renamed from: a */
    public static final String f10631a = VCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f10633c;

    /* renamed from: d */
    private View f10634d;

    /* renamed from: e */
    private Context f10635e;

    /* renamed from: f */
    private ClearableEditText f10636f;

    /* renamed from: g */
    private ExpandableListView f10637g;

    /* renamed from: h */
    private ViewStub f10638h;

    /* renamed from: i */
    private View f10639i;

    /* renamed from: j */
    private C2889e f10640j;

    /* renamed from: k */
    private ArrayList<String> f10641k;

    /* renamed from: l */
    private ArrayList<ArrayList<C2890f>> f10642l;

    /* renamed from: m */
    private ArrayList<String> f10643m;

    /* renamed from: n */
    private ArrayList<ArrayList<C2890f>> f10644n;

    /* renamed from: o */
    private Dialog f10645o;

    /* renamed from: p */
    private ProgressDialog f10646p;

    /* renamed from: q */
    private BroadcastReceiver f10647q;

    /* renamed from: r */
    private TextWatcher f10648r = new C2891g(this);

    /* renamed from: b */
    InterfaceC0028an<Cursor> f10632b = new C2892h(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate()", f10631a);
        setHasOptionsMenu(true);
        BaseActivity.m6160a((Fragment) this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4904y.m18639b("onCreateView()", f10631a);
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcalendar_list, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.layout_search_calendar).findViewById(R.id.searchfieldLayout);
        linearLayout.setPadding((int) C5034k.m19088a(4.5f), 0, (int) C5034k.m19088a(4.5f), 0);
        linearLayout.setGravity(1);
        this.f10634d = viewInflate;
        this.f10635e = getActivity();
        this.f10633c = getArguments().getString("inbox_NO");
        this.f10641k = new ArrayList<>();
        this.f10642l = new ArrayList<>();
        this.f10643m = new ArrayList<>();
        this.f10644n = new ArrayList<>();
        this.f10646p = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_geo_loading);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4904y.m18639b("onStart()", f10631a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C4904y.m18639b("onResume()", f10631a);
        super.onResume();
        m12040e();
        m12036c();
        m12038d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        m12043g();
        try {
            if (this.f10636f != null) {
                this.f10636f.m18661b(this.f10648r);
                ((InputMethodManager) this.f10635e.getSystemService("input_method")).hideSoftInputFromWindow(this.f10636f.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
        if (this.f10646p != null && this.f10646p.isShowing()) {
            this.f10646p.dismiss();
        }
        super.onPause();
    }

    /* renamed from: c */
    private void m12036c() {
        View viewFindViewById = this.f10634d.findViewById(R.id.layout_search_calendar);
        this.f10636f = (ClearableEditText) viewFindViewById.findViewById(R.id.text1);
        this.f10636f.setHint(R.string.vcalendar_list_search_hint);
        this.f10636f.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
        ((ImageButton) viewFindViewById.findViewById(R.id.button1)).setVisibility(8);
        this.f10637g = (ExpandableListView) this.f10634d.findViewById(R.id.vcal_events_list);
        this.f10637g.setOnGroupClickListener(this);
        this.f10637g.setOnChildClickListener(this);
        this.f10638h = (ViewStub) this.f10634d.findViewById(R.id.vcal_events_noresult);
    }

    /* renamed from: d */
    private void m12038d() {
        this.f10636f.m18661b(this.f10648r);
        this.f10636f.m18659a(this.f10648r);
        if (this.f10640j == null) {
            this.f10640j = new C2889e(this.f10637g, getActivity(), this.f10643m, R.layout.vcalendar_eventlist_adapter_group, this.f10644n, R.layout.list_item_common_4);
        }
        if (this.f10637g.getAdapter() == null) {
            this.f10637g.setAdapter(this.f10640j);
        }
        this.f10645o = new C4923p(getActivity()).m18724a(R.string.dialog_geo_loading);
        this.f10645o.show();
        getLoaderManager().mo111b(0, null, this.f10632b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12026a(Cursor cursor) throws NumberFormatException {
        String string;
        C4904y.m18639b("createEventsDataSet()", f10631a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList arrayList = new ArrayList();
        this.f10641k.clear();
        this.f10642l.clear();
        C4904y.m18639b("CURSOR POSITION : " + cursor.getPosition(), f10631a);
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        int i = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(2, 1);
        int i2 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime()));
        C4904y.m18639b("*** 1 MONTH BEFORE : " + i, f10631a);
        C4904y.m18639b("*** 1 MONTH AFTER  : " + i2, f10631a);
        while (cursor.moveToNext()) {
            C4904y.m18639b("CURSOR POSITION : " + cursor.getPosition(), f10631a);
            if (cursor.getInt(8) == 1) {
                C4904y.m18639b("*** SKIP : DELETED ***", f10631a);
            } else {
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTimeZone(TimeZone.getTimeZone("GMT"));
                calendar3.setTimeInMillis(cursor.getLong(4));
                int i3 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar3.getTime()));
                C4904y.m18639b("*** EVENT DATE  : " + i3 + ", title :" + cursor.getString(1), f10631a);
                if (i3 < i || i3 > i2) {
                    C4904y.m18639b("*** SKIP ***", f10631a);
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
                    if (!this.f10641k.contains(str)) {
                        this.f10641k.add(str);
                    }
                    if (TextUtils.isEmpty(cursor.getString(1))) {
                        string = getString(R.string.insert_calendar_no_title);
                    } else {
                        string = cursor.getString(1);
                    }
                    arrayList.add(new C2890f(string, Long.valueOf(calendar3.getTimeInMillis()), Long.valueOf(calendar4.getTimeInMillis()), cursor.getString(2) == null ? "" : cursor.getString(2), cursor.getString(3) == null ? "" : cursor.getString(3)));
                }
            }
        }
        Collections.sort(this.f10641k);
        Iterator<String> it = this.f10641k.iterator();
        while (it.hasNext()) {
            String next = it.next();
            ArrayList<C2890f> arrayList2 = new ArrayList<>();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C2890f c2890f = (C2890f) it2.next();
                if (next.equals(simpleDateFormat.format(new Date(c2890f.m12055b().longValue())))) {
                    arrayList2.add(new C2890f(c2890f));
                }
            }
            this.f10642l.add(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12033a(boolean z) {
        if (z || this.f10639i != null) {
            if (this.f10639i == null) {
                this.f10639i = this.f10638h.inflate();
                ((ImageView) this.f10639i.findViewById(R.id.image1)).setVisibility(8);
                ((TextView) this.f10639i.findViewById(R.id.text1)).setText(R.string.calendar_no_schedule);
                ((TextView) this.f10639i.findViewById(R.id.text2)).setText(R.string.calendar_schedule_info_message);
            }
            if (z) {
                this.f10639i.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            } else {
                this.f10639i.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12031a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<C2890f>> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator<ArrayList<C2890f>> it = this.f10642l.iterator();
        while (it.hasNext()) {
            Iterator<C2890f> it2 = it.next().iterator();
            while (it2.hasNext()) {
                C2890f next = it2.next();
                if (C4827as.m18270b(next.m12054a().toUpperCase(), str.toUpperCase())) {
                    arrayList3.add(new C2890f(next));
                }
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            String str2 = new SimpleDateFormat("yyyy/MM/dd").format(new Date(((C2890f) it3.next()).m12055b().longValue()));
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        Iterator<String> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            String next2 = it4.next();
            ArrayList<C2890f> arrayList4 = new ArrayList<>();
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                C2890f c2890f = (C2890f) it5.next();
                if (next2.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date(c2890f.m12055b().longValue())))) {
                    arrayList4.add(new C2890f(c2890f));
                }
            }
            arrayList2.add(arrayList4);
        }
        if (arrayList.size() > 0) {
            this.f10637g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            m12033a(false);
            m12032a(arrayList, arrayList2);
        } else {
            this.f10637g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            m12033a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12032a(ArrayList<String> arrayList, ArrayList<ArrayList<C2890f>> arrayList2) {
        C4904y.m18639b("supplyDataToAdapter()", f10631a);
        this.f10643m.clear();
        this.f10644n.clear();
        Iterator<String> it = arrayList.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            String next = it.next();
            this.f10643m.add(next);
            if (next.equals(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))) {
                i2 = i;
            }
            i++;
        }
        Iterator<ArrayList<C2890f>> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ArrayList<C2890f> next2 = it2.next();
            ArrayList<C2890f> arrayList3 = new ArrayList<>();
            Iterator<C2890f> it3 = next2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(new C2890f(it3.next()));
            }
            this.f10644n.add(arrayList3);
        }
        C4904y.m18639b("mAdapter.getGroupCount() : " + this.f10640j.getGroupCount(), f10631a);
        this.f10640j.m12053a(this.f10636f.m18658a().toString());
        this.f10640j.notifyDataSetChanged();
        C4904y.m18639b("mGroupData.size() : " + this.f10641k.size(), f10631a);
        C4904y.m18639b("mAdapterGroupData.size() : " + this.f10643m.size(), f10631a);
        C4904y.m18639b("mAdapter.getGroupCount() : " + this.f10640j.getGroupCount(), f10631a);
        for (int i3 = 0; i3 < this.f10640j.getGroupCount(); i3++) {
            this.f10637g.expandGroup(i3);
        }
        if (i2 != -1) {
            C4904y.m18639b("todayPosition() : " + i2, f10631a);
            this.f10637g.setSelectedGroup(i2);
        } else {
            this.f10637g.setSelectedGroup(this.f10637g.getCount() - 1);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (!C4847bl.m18333a()) {
            C2890f c2890f = this.f10644n.get(i).get(i2);
            C4904y.m18639b("******** " + c2890f.m12054a(), f10631a);
            C4904y.m18639b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c2890f.m12055b().longValue())), f10631a);
            C4904y.m18639b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c2890f.m12056c().longValue())), f10631a);
            C4904y.m18639b("******** " + c2890f.m12057d(), f10631a);
            C4904y.m18639b("******** " + c2890f.m12058e(), f10631a);
            if (this.f10646p != null) {
                this.f10646p.show();
            }
            Intent intent = new Intent(this.f10635e, (Class<?>) VCalendarDetailActivity2.class);
            intent.putExtra("extra summary", c2890f.m12054a());
            intent.putExtra("extra dtstart", c2890f.m12055b());
            intent.putExtra("extra dtend", c2890f.m12056c());
            intent.putExtra("extra location", c2890f.m12057d());
            intent.putExtra("extra desc", c2890f.m12058e());
            intent.putExtra("ACTIVITY_PURPOSE", 1);
            intent.putExtra("inbox_NO", this.f10633c);
            startActivityForResult(intent, 5);
        }
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

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: j_ */
    public void mo2964j_() {
        BaseActivity.m6160a((Fragment) this, true);
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: k_ */
    public void mo2965k_() {
        BaseActivity.m6160a((Fragment) this, false);
    }

    /* renamed from: e */
    private void m12040e() {
        this.f10647q = new C2893i(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f10635e.registerReceiver(this.f10647q, intentFilter);
        m12041f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12041f() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f10635e, R.string.sdcard_not_found, 0).show();
            getActivity().finish();
        }
    }

    /* renamed from: g */
    private void m12043g() {
        this.f10635e.unregisterReceiver(this.f10647q);
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
