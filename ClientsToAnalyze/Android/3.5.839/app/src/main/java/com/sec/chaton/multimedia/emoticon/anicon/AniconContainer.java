package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.C2793e;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.multimedia.emoticon.C2800l;
import com.sec.chaton.multimedia.emoticon.C2801m;
import com.sec.chaton.p055d.C2131l;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.InterfaceC3467k;
import com.sec.chaton.settings.p096a.InterfaceC3468l;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AniconContainer extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener, InterfaceC3467k, InterfaceC3468l {

    /* renamed from: b */
    private static final String f10019b = AniconContainer.class.getSimpleName();

    /* renamed from: a */
    Handler f10020a = new HandlerC2777i(this);

    /* renamed from: c */
    private C2131l f10021c;

    /* renamed from: d */
    private C5007c f10022d;

    /* renamed from: e */
    private C5007c f10023e;

    /* renamed from: f */
    private Activity f10024f;

    /* renamed from: g */
    private HorizontalScrollView f10025g;

    /* renamed from: h */
    private LinearLayout f10026h;

    /* renamed from: i */
    private RelativeLayout f10027i;

    /* renamed from: j */
    private GridView f10028j;

    /* renamed from: k */
    private View f10029k;

    /* renamed from: l */
    private C2769a f10030l;

    /* renamed from: m */
    private Map<String, View> f10031m;

    /* renamed from: n */
    private int f10032n;

    /* renamed from: o */
    private String f10033o;

    /* renamed from: p */
    private Cursor f10034p;

    /* renamed from: q */
    private InterfaceC2778j f10035q;

    /* renamed from: r */
    private ListAdapter f10036r;

    /* renamed from: s */
    private ListAdapter f10037s;

    /* renamed from: t */
    private int f10038t;

    /* renamed from: u */
    private C2210x f10039u;

    /* renamed from: v */
    private RelativeLayout f10040v;

    /* renamed from: w */
    private LinearLayout f10041w;

    /* renamed from: x */
    private String f10042x;

    /* renamed from: a */
    public static final AniconContainer m11640a(int i) {
        return m11641a(i, (String) null);
    }

    /* renamed from: a */
    public static final AniconContainer m11641a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        AniconContainer aniconContainer = new AniconContainer();
        aniconContainer.setArguments(bundle);
        return aniconContainer;
    }

    /* renamed from: a */
    public void m11666a(InterfaceC2778j interfaceC2778j) {
        this.f10035q = interfaceC2778j;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f10024f = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f10024f = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        m11663j();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        this.f10032n = getArguments().getInt("layoutResId");
        this.f10033o = null;
        this.f10031m = new HashMap();
        this.f10022d = new C5007c(m11657f());
        this.f10023e = new C5007c(m11660g());
        this.f10021c = new C2131l(this.f10024f, null);
        this.f10039u = new C2210x(this.f10024f.getContentResolver(), null);
        m11664k();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        int i;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f10042x = null;
        if (bundle != null) {
            this.f10042x = bundle.getString("currentTabId");
            i = bundle.getInt("currentIndicatorPosition");
        } else {
            i = 0;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("Restored. PackageId: ", this.f10042x, ", Tab Indicator Position: ", Integer.valueOf(i)), f10019b);
        }
        View viewInflate = layoutInflater.inflate(this.f10032n, viewGroup, false);
        this.f10025g = (HorizontalScrollView) viewInflate.findViewById(R.id.panelScrollView);
        this.f10026h = (LinearLayout) viewInflate.findViewById(R.id.panelContainer);
        this.f10028j = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f10029k = viewInflate.findViewById(R.id.emoticonEmptyView);
        this.f10027i = (RelativeLayout) viewInflate.findViewById(R.id.tab_shop_layout);
        this.f10027i.setOnClickListener(new ViewOnClickListenerC2771c(this));
        this.f10040v = (RelativeLayout) viewInflate.findViewById(R.id.characterDownloadView);
        this.f10041w = (LinearLayout) viewInflate.findViewById(R.id.characterButtonLayout);
        this.f10041w.setOnClickListener(this);
        this.f10034p = m11652d();
        this.f10030l = new C2769a(this.f10024f, null, 1, this.f10023e);
        this.f10028j.setAdapter((ListAdapter) this.f10030l);
        this.f10028j.setOnItemClickListener(this);
        m11651c(this.f10042x);
        C3460d.m13767a((InterfaceC3467k) this);
        C3460d.m13768a((InterfaceC3468l) this);
        this.f10038t = i;
        this.f10025g.post(new RunnableC2772d(this, i));
        this.f10020a.sendEmptyMessageDelayed(0, 1000L);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ImageView imageView = (ImageView) this.f10027i.findViewById(R.id.panel_shop_badge);
        if (C3460d.m13760a() == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        m11648b(this.f10040v.getVisibility());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C3460d.m13775b((InterfaceC3467k) this);
        C3460d.m13776b((InterfaceC3468l) this);
        if (this.f10030l != null) {
            this.f10030l.mo875a((Cursor) null);
        }
        if (this.f10034p != null && !this.f10034p.isClosed()) {
            this.f10034p.close();
        }
        this.f10037s = null;
        this.f10036r = null;
        m11655e();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f10022d.m19014a();
        this.f10023e.m19014a();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f10033o);
        if (this.f10038t == -1) {
            bundle.putInt("currentIndicatorPosition", this.f10025g.getScrollX());
        } else {
            bundle.putInt("currentIndicatorPosition", this.f10038t);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f10033o.equals("-3")) {
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str) && this.f10035q != null) {
                this.f10035q.mo11637a(this, str, "emoticon", null);
                return;
            }
            return;
        }
        if (this.f10033o.equals("-2")) {
            C2801m c2801m = (C2801m) view.getTag();
            String strM11714a = c2801m.m11714a();
            String strM11715b = c2801m.m11715b();
            if (!TextUtils.isEmpty(strM11714a)) {
                if (strM11715b.equals("emoticon")) {
                    if (this.f10035q != null) {
                        this.f10035q.mo11637a(this, strM11714a, "emoticon", null);
                        return;
                    }
                    return;
                } else {
                    if (this.f10035q != null) {
                        this.f10035q.mo11637a(this, strM11714a, "anicon", m11659g(strM11714a));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        C2770b c2770b = (C2770b) view.getTag();
        String str2 = c2770b.f10056c;
        String str3 = c2770b.f10057d;
        if (!TextUtils.isEmpty(str2) && this.f10035q != null) {
            this.f10035q.mo11637a(this, str2, "anicon", str3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!C4847bl.m18333a()) {
            if (view.equals(this.f10041w)) {
                Intent intent = new Intent(this.f10024f, (Class<?>) ChatONShopActivity.class);
                intent.putExtra("page_name", 1);
                intent.putExtra("category_id", 1L);
                this.f10024f.startActivity(intent);
                return;
            }
            String str = (String) view.getTag();
            m11658f(str);
            m11656e(str);
        }
    }

    @Override // com.sec.chaton.settings.p096a.InterfaceC3467k
    /* renamed from: a */
    public void mo11667a(String str) {
        this.f10028j.post(new RunnableC2773e(this));
    }

    @Override // com.sec.chaton.settings.p096a.InterfaceC3468l
    /* renamed from: b */
    public void mo11668b(String str) {
        this.f10028j.post(new RunnableC2774f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m11647b() {
        if ((!"mounted".equals(Environment.getExternalStorageState()) && !C4873ck.m18503d()) || !C4873ck.m18504e()) {
            AbstractC4932a.m18733a(this.f10024f).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
            return;
        }
        Intent intent = new Intent(this.f10024f, (Class<?>) ChatONShopActivity.class);
        intent.putExtra("page_name", 2);
        intent.putExtra("category_id", 1L);
        this.f10024f.startActivity(intent);
    }

    /* renamed from: c */
    private void m11650c() {
        Intent intent = new Intent();
        intent.setClass(this.f10024f, AniconSortListActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    C4904y.m18639b("Anicon panel list is changed or not.", getClass().getSimpleName());
                    this.f10034p = m11652d();
                    m11651c(this.f10042x);
                    break;
            }
        }
    }

    /* renamed from: d */
    private Cursor m11652d() {
        Uri uriBuild;
        if (C4809aa.m18104a().m18119a("pref_anicon_sort_set", (Boolean) false).booleanValue()) {
            uriBuild = C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath("anicon_group_sort").build();
        } else {
            uriBuild = C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath("anicon_group").build();
        }
        return this.f10024f.getContentResolver().query(uriBuild, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11651c(String str) throws Throwable {
        int i;
        boolean z;
        m11655e();
        ((ImageView) m11653d("-2").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_recent);
        ((ImageView) m11653d("-3").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_emoticon);
        this.f10034p.moveToPosition(-1);
        boolean z2 = false;
        while (this.f10034p.moveToNext()) {
            String string = this.f10034p.getString(this.f10034p.getColumnIndex("item_id"));
            boolean z3 = this.f10034p.getInt(this.f10034p.getColumnIndex("newly_installed")) != 0;
            String string2 = this.f10034p.getString(this.f10034p.getColumnIndex("data1"));
            String string3 = this.f10034p.getString(this.f10034p.getColumnIndex("data2"));
            if (this.f10034p.getPosition() == 0 && TextUtils.isEmpty(str)) {
                str = string;
            }
            try {
                if ("0036".equals(string2) && "001".equals(string3)) {
                    i = !C4809aa.m18104a().m18119a("pref_anicon_sort_set", (Boolean) false).booleanValue() ? 3 : -1;
                    z = true;
                } else {
                    i = -1;
                    z = z2;
                }
            } catch (JSONException e) {
                e = e;
            }
            try {
                ImageView imageView = (ImageView) m11639a(string, z3, i).findViewById(R.id.emoticon_tab_indicator_image);
                if (i == -1) {
                    this.f10022d.m19023b(imageView, new C2779k(string, C2188b.m9789a(this.f10034p.getString(this.f10034p.getColumnIndex("extras"))).m9795a(), this.f10021c));
                } else {
                    imageView.setImageResource(R.drawable.chat_anicon_btn_anicon);
                }
                z2 = z;
            } catch (JSONException e2) {
                e = e2;
                z2 = z;
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f10019b);
                }
            }
        }
        if (!z2) {
            ((ImageView) m11639a("-4", false, 3).findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_anicon);
        }
        if (TextUtils.isEmpty(str)) {
            str = "-4";
        }
        ((ImageView) m11653d("-5").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_setting);
        m11656e(str);
    }

    /* renamed from: d */
    private View m11653d(String str) {
        return m11639a(str, false, -1);
    }

    /* renamed from: a */
    private View m11639a(String str, boolean z, int i) {
        View viewInflate = LayoutInflater.from(this.f10024f).inflate(R.layout.item_emoticon_tab_indicator, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(this.f10024f.getResources().getDimensionPixelOffset(R.dimen.anicon_tab_indicator_width), this.f10024f.getResources().getDimensionPixelOffset(R.dimen.anicon_tab_indicator_height)));
        viewInflate.setTag(str);
        viewInflate.setOnClickListener(this);
        if (this.f10026h.getChildCount() >= i) {
            this.f10026h.addView(viewInflate, i);
        } else {
            this.f10026h.addView(viewInflate);
        }
        this.f10031m.put(str, viewInflate);
        if (z) {
            viewInflate.setBackgroundResource(R.drawable.anicon_indicator_new_bg);
        } else {
            viewInflate.setBackgroundResource(R.drawable.tab_center_button_background);
        }
        return viewInflate;
    }

    /* renamed from: e */
    private void m11655e() {
        this.f10033o = null;
        for (String str : this.f10031m.keySet()) {
            if (!"-1".equals(str) && !"-2".equals(str) && !"-3".equals(str) && !"-5".equals(str)) {
                this.f10022d.m19015a(this.f10031m.get(str).findViewById(R.id.emoticon_tab_indicator_image));
            }
        }
        this.f10031m.clear();
        this.f10026h.removeAllViews();
    }

    /* renamed from: e */
    private void m11656e(String str) throws Throwable {
        View view;
        if (str != null) {
            if (str.equals("-1")) {
                m11647b();
                return;
            }
            if (str.equals("-5")) {
                m11650c();
                return;
            }
            if (TextUtils.isEmpty(str) || !str.equals(this.f10033o)) {
                if (!TextUtils.isEmpty(this.f10033o) && (view = this.f10031m.get(this.f10033o)) != null) {
                    view.setSelected(false);
                }
                this.f10033o = str;
                View view2 = this.f10031m.get(str);
                if (view2 != null) {
                    view2.setSelected(true);
                }
                if (str.equals("-2")) {
                    this.f10028j.setVisibility(0);
                    this.f10029k.setVisibility(8);
                    m11648b(8);
                    m11665l();
                    if (this.f10037s == null) {
                        this.f10037s = m11662i();
                    }
                    if (this.f10037s.isEmpty()) {
                        this.f10028j.setVisibility(8);
                        this.f10029k.setVisibility(0);
                        m11648b(8);
                        return;
                    } else {
                        this.f10028j.setAdapter(this.f10037s);
                        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.recent_gridview_padding);
                        this.f10028j.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        this.f10028j.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.recent_gridview_item_width));
                        this.f10028j.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.recent_gridview_item_horizontal_spacing));
                        this.f10028j.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.recent_gridview_item_vertical_spacing));
                        return;
                    }
                }
                if (str.equals("-3")) {
                    this.f10028j.setVisibility(0);
                    this.f10029k.setVisibility(8);
                    m11648b(8);
                    if (this.f10036r == null) {
                        this.f10036r = m11661h();
                    }
                    this.f10028j.setAdapter(this.f10036r);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_padding);
                    this.f10028j.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                    this.f10028j.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_item_width));
                    this.f10028j.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_item_horizontal_spacing));
                    this.f10028j.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_item_vertical_spacing));
                    return;
                }
                if (str.equals("-4")) {
                    this.f10028j.setVisibility(8);
                    this.f10029k.setVisibility(8);
                    m11648b(0);
                    return;
                }
                this.f10028j.setVisibility(0);
                this.f10029k.setVisibility(8);
                m11648b(8);
                this.f10030l.mo875a(this.f10024f.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath("group").appendPath(str).build(), null, null, null, null));
                this.f10030l.notifyDataSetInvalidated();
                this.f10028j.setAdapter((ListAdapter) this.f10030l);
                this.f10028j.setSelection(0);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.anicon_gridview_padding);
                this.f10028j.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
                this.f10028j.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.anicon_gridview_item_width));
                this.f10028j.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.anicon_gridview_item_horizontal_spacing));
                this.f10028j.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.anicon_gridview_item_vertical_spacing));
            }
        }
    }

    /* renamed from: f */
    private void m11658f(String str) throws Throwable {
        View view = this.f10031m.get(str);
        if (!view.getBackground().equals(getResources().getDrawable(R.drawable.tab_center_button_background))) {
            view.setBackgroundResource(R.drawable.tab_center_button_background);
            String strM19199a = C5052r.m19199a("item_id", " IN ( SELECT ", "item_id", " FROM ( ", "\tSELECT ", "data1", ",", "data2", "\tFROM ", "download_item", "\tWHERE ", " ( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' )", " AND ", "install", " != 0 AND ", "item_id", "=?) D1", "\tINNER JOIN ", "download_item", " D2 ", "\tON D1.", "data1", " = D2.", "data1", " AND D1.", "data2", " = D2.", "data2", ")");
            ContentValues contentValues = new ContentValues();
            contentValues.put("newly_installed", (Integer) 0);
            this.f10039u.startUpdate(0, null, C2257bc.f8039a.buildUpon().appendPath("init_newly_installed").build(), contentValues, strM19199a, new String[]{str});
        }
    }

    /* renamed from: f */
    private ExecutorService m11657f() {
        return Executors.newCachedThreadPool(new ThreadFactoryC2775g(this));
    }

    /* renamed from: g */
    private ExecutorService m11660g() {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC2776h(this));
    }

    /* renamed from: h */
    private ListAdapter m11661h() {
        String[] strArr = new String[1];
        return new C2793e(this.f10024f, C2797i.m11707c());
    }

    /* renamed from: i */
    private ListAdapter m11662i() {
        return new C2800l(this.f10024f, C2797i.m11705a(), this.f10023e);
    }

    /* renamed from: a */
    private void m11643a(View view) {
        try {
            this.f10024f.findViewById(R.id.ticonButton).setNextFocusDownId(view.getId());
            this.f10024f.findViewById(R.id.amsButton).setNextFocusDownId(view.getId());
            this.f10024f.findViewById(R.id.emoticonButton).setNextFocusDownId(view.getId());
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: j */
    private void m11663j() {
        try {
            this.f10024f.findViewById(R.id.ticonButton).setNextFocusDownId(-1);
            this.f10024f.findViewById(R.id.amsButton).setNextFocusDownId(-1);
            this.f10024f.findViewById(R.id.emoticonButton).setNextFocusDownId(-1);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: b */
    private void m11648b(int i) {
        this.f10040v.setVisibility(i);
        if (i == 0) {
            m11643a(this.f10041w);
        } else {
            m11663j();
        }
    }

    /* renamed from: k */
    private void m11664k() throws Throwable {
        Cursor cursorQuery;
        if (C4809aa.m18104a().m18119a("chat_is_recent_anicon_merged", (Boolean) false).booleanValue()) {
            return;
        }
        try {
            cursorQuery = this.f10024f.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath("recentused").build(), null, null, null, null);
            try {
                ArrayList arrayList = new ArrayList();
                cursorQuery.moveToPosition(-1);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id")));
                }
                C2797i.m11705a().m19003a((List<String>) arrayList, true);
                C4809aa.m18104a().m18125b("chat_is_recent_anicon_merged", (Boolean) true);
                if (cursorQuery.isClosed()) {
                    return;
                }
                cursorQuery.close();
            } catch (Throwable th) {
                th = th;
                if (!cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: g */
    private String m11659g(String str) throws Throwable {
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("aniconId null from getPackageID()", f10019b);
            return null;
        }
        try {
            Cursor cursorQuery = this.f10024f.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath(str).build(), null, null, null, null);
            try {
                if (cursorQuery == null) {
                    C4904y.m18639b("cursur null from getPackageID()", f10019b);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("package_id")) : null;
                if (cursorQuery == null) {
                    return string;
                }
                cursorQuery.close();
                return string;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: l */
    private void m11665l() throws Throwable {
        Cursor cursorQuery;
        Uri uriBuild = C2255ba.f8038a.buildUpon().appendPath("recentused").build();
        String[] strArrMo11703a = C2797i.m11705a().mo11703a();
        int length = strArrMo11703a.length;
        if (length <= 0) {
            return;
        }
        try {
            cursorQuery = this.f10024f.getContentResolver().query(uriBuild, null, null, null, null);
            try {
                ArrayList arrayList = new ArrayList();
                cursorQuery.moveToPosition(-1);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id")));
                }
                for (int i = 0; i < length; i++) {
                    if (C2797i.m11704a(strArrMo11703a[i]) == -1 && !arrayList.contains(strArrMo11703a[i])) {
                        C2797i.m11705a().m19005b(strArrMo11703a[i], true);
                    }
                }
                if (cursorQuery.isClosed()) {
                    return;
                }
                cursorQuery.close();
            } catch (Throwable th) {
                th = th;
                if (!cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }
}
