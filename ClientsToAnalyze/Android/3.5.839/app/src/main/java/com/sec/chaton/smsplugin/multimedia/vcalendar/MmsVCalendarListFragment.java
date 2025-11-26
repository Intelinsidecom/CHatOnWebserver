package com.sec.chaton.smsplugin.multimedia.vcalendar;

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
import com.sec.chaton.multimedia.vcalendar.C2889e;
import com.sec.chaton.multimedia.vcalendar.C2890f;
import com.sec.chaton.util.C4827as;
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
public class MmsVCalendarListFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, InterfaceC2318el {

    /* renamed from: a */
    public static final String f14180a = MmsVCalendarListFragment.class.getSimpleName();

    /* renamed from: c */
    private String f14182c;

    /* renamed from: d */
    private View f14183d;

    /* renamed from: e */
    private Context f14184e;

    /* renamed from: f */
    private ClearableEditText f14185f;

    /* renamed from: g */
    private ExpandableListView f14186g;

    /* renamed from: h */
    private ViewStub f14187h;

    /* renamed from: i */
    private View f14188i;

    /* renamed from: j */
    private C2889e f14189j;

    /* renamed from: k */
    private ArrayList<String> f14190k;

    /* renamed from: l */
    private ArrayList<ArrayList<C2890f>> f14191l;

    /* renamed from: m */
    private ArrayList<String> f14192m;

    /* renamed from: n */
    private ArrayList<ArrayList<C2890f>> f14193n;

    /* renamed from: o */
    private Dialog f14194o;

    /* renamed from: p */
    private ProgressDialog f14195p;

    /* renamed from: q */
    private BroadcastReceiver f14196q;

    /* renamed from: r */
    private TextWatcher f14197r = new C3939c(this);

    /* renamed from: b */
    InterfaceC0028an<Cursor> f14181b = new C3940d(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C4904y.m18639b("onCreate()", f14180a);
        setHasOptionsMenu(true);
        BaseActivity.m6160a((Fragment) this, true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C4904y.m18639b("onCreateView()", f14180a);
        View viewInflate = layoutInflater.inflate(R.layout.layout_multimedia_vcalendar_list, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.layout_search_calendar).findViewById(R.id.searchfieldLayout);
        linearLayout.setPadding((int) C5034k.m19088a(4.5f), 0, (int) C5034k.m19088a(4.5f), 0);
        linearLayout.setGravity(1);
        this.f14183d = viewInflate;
        this.f14184e = getActivity();
        this.f14182c = getArguments().getString("inbox_NO");
        this.f14190k = new ArrayList<>();
        this.f14191l = new ArrayList<>();
        this.f14192m = new ArrayList<>();
        this.f14193n = new ArrayList<>();
        this.f14195p = (ProgressDialog) C4923p.m18723a(getActivity()).m18724a(R.string.dialog_geo_loading);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C4904y.m18639b("onStart()", f14180a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        C4904y.m18639b("onResume()", f14180a);
        super.onResume();
        m15213e();
        m15209c();
        m15211d();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        m15216g();
        try {
            if (this.f14185f != null) {
                this.f14185f.m18661b(this.f14197r);
                ((InputMethodManager) this.f14184e.getSystemService("input_method")).hideSoftInputFromWindow(this.f14185f.getWindowToken(), 0);
            }
        } catch (Exception e) {
            C4904y.m18639b("onPause() event search exception", f14180a);
        }
        if (this.f14195p != null && this.f14195p.isShowing()) {
            this.f14195p.dismiss();
        }
        super.onPause();
    }

    /* renamed from: c */
    private void m15209c() {
        View viewFindViewById = this.f14183d.findViewById(R.id.layout_search_calendar);
        this.f14185f = (ClearableEditText) viewFindViewById.findViewById(R.id.text1);
        this.f14185f.setHint(R.string.vcalendar_list_search_hint);
        this.f14185f.setFilters(new InputFilter[]{new C4902w(getActivity(), 30)});
        ((ImageButton) viewFindViewById.findViewById(R.id.button1)).setVisibility(8);
        this.f14186g = (ExpandableListView) this.f14183d.findViewById(R.id.vcal_events_list);
        this.f14186g.setOnGroupClickListener(this);
        this.f14186g.setOnChildClickListener(this);
        this.f14187h = (ViewStub) this.f14183d.findViewById(R.id.vcal_events_noresult);
    }

    /* renamed from: d */
    private void m15211d() {
        this.f14185f.m18661b(this.f14197r);
        this.f14185f.m18659a(this.f14197r);
        if (this.f14189j == null) {
            this.f14189j = new C2889e(this.f14186g, getActivity(), this.f14192m, R.layout.vcalendar_eventlist_adapter_group, this.f14193n, R.layout.list_item_common_4);
        }
        if (this.f14186g.getAdapter() == null) {
            this.f14186g.setAdapter(this.f14189j);
        }
        this.f14194o = C4923p.m18723a(getActivity()).m18724a(R.string.dialog_geo_loading);
        this.f14194o.show();
        getLoaderManager().mo111b(0, null, this.f14181b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15199a(Cursor cursor) throws NumberFormatException {
        String string;
        C4904y.m18639b("createEventsDataSet()", f14180a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ArrayList arrayList = new ArrayList();
        this.f14190k.clear();
        this.f14191l.clear();
        C4904y.m18639b("CURSOR POSITION : " + cursor.getPosition(), f14180a);
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        int i = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar.getTime()));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(2, 1);
        int i2 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar2.getTime()));
        C4904y.m18639b("*** 1 MONTH BEFORE : " + i, f14180a);
        C4904y.m18639b("*** 1 MONTH AFTER  : " + i2, f14180a);
        while (cursor.moveToNext()) {
            C4904y.m18639b("CURSOR POSITION : " + cursor.getPosition(), f14180a);
            if (cursor.getInt(8) == 1) {
                C4904y.m18639b("*** SKIP : DELETED ***", f14180a);
            } else {
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTimeZone(TimeZone.getTimeZone("GMT"));
                calendar3.setTimeInMillis(cursor.getLong(4));
                int i3 = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(calendar3.getTime()));
                C4904y.m18639b("*** EVENT DATE  : " + i3 + ", title :" + cursor.getString(1), f14180a);
                if (i3 < i || i3 > i2) {
                    C4904y.m18639b("*** SKIP ***", f14180a);
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
                    if (!this.f14190k.contains(str)) {
                        this.f14190k.add(str);
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
        Collections.sort(this.f14190k);
        Iterator<String> it = this.f14190k.iterator();
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
            this.f14191l.add(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15206a(boolean z) {
        if (z || this.f14188i != null) {
            if (this.f14188i == null) {
                this.f14188i = this.f14187h.inflate();
                ((ImageView) this.f14188i.findViewById(R.id.image1)).setVisibility(8);
                ((TextView) this.f14188i.findViewById(R.id.text1)).setText(R.string.calendar_no_schedule);
                ((TextView) this.f14188i.findViewById(R.id.text2)).setText(R.string.calendar_schedule_info_message);
            }
            if (z) {
                this.f14188i.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            } else {
                this.f14188i.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15204a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<C2890f>> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator<ArrayList<C2890f>> it = this.f14191l.iterator();
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
            this.f14186g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            m15206a(false);
            m15205a(arrayList, arrayList2);
        } else {
            this.f14186g.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 0.0f));
            m15206a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15205a(ArrayList<String> arrayList, ArrayList<ArrayList<C2890f>> arrayList2) {
        C4904y.m18639b("supplyDataToAdapter()", f14180a);
        this.f14192m.clear();
        this.f14193n.clear();
        Iterator<String> it = arrayList.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            String next = it.next();
            this.f14192m.add(next);
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
            this.f14193n.add(arrayList3);
        }
        C4904y.m18639b("mAdapter.getGroupCount() : " + this.f14189j.getGroupCount(), f14180a);
        this.f14189j.m12053a(this.f14185f.m18658a().toString());
        this.f14189j.notifyDataSetChanged();
        C4904y.m18639b("mGroupData.size() : " + this.f14190k.size(), f14180a);
        C4904y.m18639b("mAdapterGroupData.size() : " + this.f14192m.size(), f14180a);
        C4904y.m18639b("mAdapter.getGroupCount() : " + this.f14189j.getGroupCount(), f14180a);
        for (int i3 = 0; i3 < this.f14189j.getGroupCount(); i3++) {
            this.f14186g.expandGroup(i3);
        }
        if (i2 != -1) {
            C4904y.m18639b("todayPosition() : " + i2, f14180a);
            this.f14186g.setSelectedGroup(i2);
        } else {
            this.f14186g.setSelectedGroup(this.f14186g.getCount() - 1);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C2890f c2890f = this.f14193n.get(i).get(i2);
        C4904y.m18639b("******** " + c2890f.m12054a(), f14180a);
        C4904y.m18639b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c2890f.m12055b().longValue())), f14180a);
        C4904y.m18639b("******** " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date(c2890f.m12056c().longValue())), f14180a);
        C4904y.m18639b("******** " + c2890f.m12057d(), f14180a);
        C4904y.m18639b("******** " + c2890f.m12058e(), f14180a);
        if (this.f14195p != null) {
            this.f14195p.show();
        }
        Intent intent = new Intent(this.f14184e, (Class<?>) MmsVCalendarDetailActivity2.class);
        intent.putExtra("extra summary", c2890f.m12054a());
        intent.putExtra("extra dtstart", c2890f.m12055b());
        intent.putExtra("extra dtend", c2890f.m12056c());
        intent.putExtra("extra location", c2890f.m12057d());
        intent.putExtra("extra desc", c2890f.m12058e());
        intent.putExtra("ACTIVITY_PURPOSE", 1);
        intent.putExtra("inbox_NO", this.f14182c);
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
    private void m15213e() {
        this.f14196q = new C3941e(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f14184e.registerReceiver(this.f14196q, intentFilter);
        m15214f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m15214f() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(this.f14184e, R.string.sdcard_not_found, 0).show();
            getActivity().finish();
        }
    }

    /* renamed from: g */
    private void m15216g() {
        this.f14184e.unregisterReceiver(this.f14196q);
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
