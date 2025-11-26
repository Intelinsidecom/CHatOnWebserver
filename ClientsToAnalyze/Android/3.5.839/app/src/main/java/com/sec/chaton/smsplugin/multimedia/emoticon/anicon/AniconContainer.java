package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
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
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.C2793e;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.multimedia.emoticon.C2800l;
import com.sec.chaton.multimedia.emoticon.C2801m;
import com.sec.chaton.multimedia.emoticon.anicon.AniconSortListActivity;
import com.sec.chaton.multimedia.emoticon.anicon.C2779k;
import com.sec.chaton.p055d.C2131l;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.registration.EnumC3297gd;
import com.sec.chaton.registration.RegisterSMSActivity;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.InterfaceC3467k;
import com.sec.chaton.settings.p096a.InterfaceC3468l;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
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
    private static final String f14070b = AniconContainer.class.getSimpleName();

    /* renamed from: c */
    private static boolean f14071c = false;

    /* renamed from: A */
    private ListAdapter f14072A;

    /* renamed from: B */
    private ListAdapter f14073B;

    /* renamed from: C */
    private String f14074C;

    /* renamed from: D */
    private LinearLayout f14075D;

    /* renamed from: a */
    Handler f14076a = new HandlerC3920h(this);

    /* renamed from: d */
    private C2131l f14077d;

    /* renamed from: e */
    private C5007c f14078e;

    /* renamed from: f */
    private C5007c f14079f;

    /* renamed from: g */
    private Activity f14080g;

    /* renamed from: h */
    private HorizontalScrollView f14081h;

    /* renamed from: i */
    private LinearLayout f14082i;

    /* renamed from: j */
    private GridView f14083j;

    /* renamed from: k */
    private View f14084k;

    /* renamed from: l */
    private View f14085l;

    /* renamed from: m */
    private C3913a f14086m;

    /* renamed from: n */
    private Map<String, View> f14087n;

    /* renamed from: o */
    private int f14088o;

    /* renamed from: p */
    private String f14089p;

    /* renamed from: q */
    private Cursor f14090q;

    /* renamed from: r */
    private InterfaceC3921i f14091r;

    /* renamed from: s */
    private int f14092s;

    /* renamed from: t */
    private C2210x f14093t;

    /* renamed from: u */
    private RelativeLayout f14094u;

    /* renamed from: v */
    private LinearLayout f14095v;

    /* renamed from: w */
    private LinearLayout f14096w;

    /* renamed from: x */
    private LinearLayout f14097x;

    /* renamed from: y */
    private LinearLayout f14098y;

    /* renamed from: z */
    private LinearLayout f14099z;

    /* renamed from: a */
    public static final AniconContainer m15110a(int i) {
        return m15111a(i, (String) null);
    }

    /* renamed from: a */
    public static final AniconContainer m15111a(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("layoutResId", i);
        AniconContainer aniconContainer = new AniconContainer();
        aniconContainer.setArguments(bundle);
        return aniconContainer;
    }

    /* renamed from: a */
    public void m15131a(InterfaceC3921i interfaceC3921i) {
        this.f14091r = interfaceC3921i;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14080g = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f14080g = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        this.f14088o = getArguments().getInt("layoutResId");
        this.f14089p = null;
        this.f14087n = new HashMap();
        this.f14078e = new C5007c(m15123f());
        this.f14079f = new C5007c(m15126g());
        this.f14077d = C2131l.m9549a(this.f14080g, null);
        this.f14093t = new C2210x(this.f14080g.getContentResolver(), null);
        m15129j();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        int i;
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f14074C = null;
        if (bundle != null) {
            this.f14074C = bundle.getString("currentTabId");
            i = bundle.getInt("currentIndicatorPosition");
        } else {
            i = 0;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("Restored. PackageId: ", this.f14074C, ", Tab Indicator Position: ", Integer.valueOf(i)), f14070b);
        }
        View viewInflate = layoutInflater.inflate(this.f14088o, viewGroup, false);
        this.f14081h = (HorizontalScrollView) viewInflate.findViewById(R.id.panelScrollView);
        this.f14082i = (LinearLayout) viewInflate.findViewById(R.id.panelContainer);
        this.f14075D = (LinearLayout) viewInflate.findViewById(R.id.shopPanelContainer);
        this.f14083j = (GridView) viewInflate.findViewById(R.id.emoticonGridView);
        this.f14084k = viewInflate.findViewById(R.id.emoticonEmptyView);
        this.f14085l = viewInflate.findViewById(R.id.emoticonDownloadView);
        this.f14096w = (LinearLayout) viewInflate.findViewById(R.id.downloadDownSlideLayout);
        this.f14097x = (LinearLayout) viewInflate.findViewById(R.id.downloadButtonLayout);
        this.f14097x.setOnClickListener(this);
        this.f14099z = (LinearLayout) viewInflate.findViewById(R.id.downloadRegisterSlideLayout);
        this.f14098y = (LinearLayout) viewInflate.findViewById(R.id.downloadRegisterLayout);
        this.f14098y.setOnClickListener(this);
        this.f14094u = (RelativeLayout) viewInflate.findViewById(R.id.characterDownloadView);
        if (!C4822an.m18218a()) {
            this.f14096w.setVisibility(8);
            this.f14099z.setVisibility(0);
            this.f14098y.setEnabled(true);
        } else {
            this.f14096w.setVisibility(0);
            this.f14099z.setVisibility(8);
            this.f14097x.setEnabled(true);
        }
        this.f14090q = m15119d();
        this.f14086m = new C3913a(this.f14080g, null, 1, this.f14079f);
        this.f14083j.setAdapter((ListAdapter) this.f14086m);
        this.f14083j.setOnItemClickListener(this);
        m15118c(this.f14074C);
        C3460d.m13767a((InterfaceC3467k) this);
        C3460d.m13768a((InterfaceC3468l) this);
        this.f14092s = i;
        this.f14081h.post(new RunnableC3915c(this, i));
        this.f14076a.sendEmptyMessageDelayed(0, 1000L);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        TextView textView = (TextView) this.f14087n.get("-1").findViewById(R.id.emoticon_tab_indicator_badge);
        int iM13760a = C3460d.m13760a();
        if (iM13760a == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            C4880cr.m18525a(textView, iM13760a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C3460d.m13775b((InterfaceC3467k) this);
        C3460d.m13776b((InterfaceC3468l) this);
        if (this.f14086m != null) {
            this.f14086m.mo875a((Cursor) null);
        }
        if (this.f14090q != null && !this.f14090q.isClosed()) {
            this.f14090q.close();
        }
        this.f14072A = null;
        this.f14073B = null;
        m15121e();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14078e.m19014a();
        this.f14079f.m19014a();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTabId", this.f14089p);
        if (this.f14092s == -1) {
            bundle.putInt("currentIndicatorPosition", this.f14081h.getScrollX());
        } else {
            bundle.putInt("currentIndicatorPosition", this.f14092s);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws Throwable {
        if (this.f14089p.equals("-3")) {
            String str = (String) view.getTag();
            if (!TextUtils.isEmpty(str) && this.f14091r != null) {
                this.f14091r.mo15105a(this, str, "emoticon");
                return;
            }
            return;
        }
        if (this.f14089p.equals("-2")) {
            C2801m c2801m = (C2801m) view.getTag();
            String strM11714a = c2801m.m11714a();
            String strM11715b = c2801m.m11715b();
            if (!TextUtils.isEmpty(strM11714a)) {
                if (strM11715b.equals("emoticon")) {
                    if (this.f14091r != null) {
                        this.f14091r.mo15105a(this, strM11714a, "emoticon");
                        return;
                    }
                    return;
                } else {
                    if (this.f14091r != null) {
                        this.f14091r.mo15106a(this, strM11714a, "anicon", m15125g(strM11714a));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        C3914b c3914b = (C3914b) view.getTag();
        String str2 = c3914b.f14105c;
        String str3 = c3914b.f14106d;
        if (!TextUtils.isEmpty(str2) && this.f14091r != null) {
            this.f14091r.mo15106a(this, str2, "anicon", str3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (!C4847bl.m18333a()) {
            if (view.equals(this.f14097x)) {
                m15115b();
                return;
            }
            if (view.equals(this.f14095v)) {
                Intent intent = new Intent(this.f14080g, (Class<?>) ChatONShopActivity.class);
                intent.putExtra("page_name", 1);
                intent.putExtra("category_id", 1L);
                this.f14080g.startActivity(intent);
                return;
            }
            if (view.equals(this.f14098y)) {
                Intent intent2 = new Intent(getActivity(), (Class<?>) RegisterSMSActivity.class);
                intent2.putExtra("request_register", EnumC3297gd.reigster);
                startActivity(intent2);
            } else {
                String str = (String) view.getTag();
                m15124f(str);
                m15122e(str);
            }
        }
    }

    @Override // com.sec.chaton.settings.p096a.InterfaceC3467k
    /* renamed from: a */
    public void mo11667a(String str) {
        this.f14083j.post(new RunnableC3916d(this));
    }

    @Override // com.sec.chaton.settings.p096a.InterfaceC3468l
    /* renamed from: b */
    public void mo11668b(String str) {
        this.f14083j.post(new RunnableC3917e(this));
    }

    /* renamed from: b */
    private void m15115b() {
        Intent intent = new Intent(this.f14080g, (Class<?>) ChatONShopActivity.class);
        intent.putExtra("page_name", 2);
        intent.putExtra("category_id", 1L);
        this.f14080g.startActivity(intent);
    }

    /* renamed from: c */
    private void m15117c() {
        Intent intent = new Intent();
        intent.setClass(this.f14080g, AniconSortListActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    C4904y.m18639b("Anicon panel list is changed or not.", getClass().getSimpleName());
                    this.f14090q = m15119d();
                    m15118c(this.f14074C);
                    break;
            }
        }
    }

    /* renamed from: d */
    private Cursor m15119d() {
        Uri uriBuild;
        if (C4809aa.m18104a().m18119a("pref_anicon_sort_set", (Boolean) false).booleanValue()) {
            uriBuild = C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath("anicon_group_sort").build();
        } else {
            uriBuild = C2257bc.m10121a(EnumC2258bd.Anicon).buildUpon().appendPath("anicon_group").build();
        }
        return this.f14080g.getContentResolver().query(uriBuild, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m15118c(String str) throws Throwable {
        int i;
        boolean z;
        m15121e();
        ((ImageView) m15120d("-1").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_shop);
        View viewM15120d = m15120d("-2");
        ImageView imageView = (ImageView) viewM15120d.findViewById(R.id.emoticon_tab_indicator_image);
        imageView.setImageResource(R.drawable.chat_anicon_btn_recent);
        ((ImageView) m15120d("-3").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_emoticon);
        if (!C4822an.m18218a()) {
            viewM15120d.setEnabled(false);
            viewM15120d.setBackgroundResource(R.drawable.chat_anicon_btn_disable);
            imageView.setImageResource(R.drawable.chat_anicon_btn_recent_disable);
            f14071c = true;
        } else if (f14071c) {
            viewM15120d.setEnabled(true);
            viewM15120d.setBackgroundResource(R.drawable.chat_anicon_btn);
            imageView.setImageResource(R.drawable.chat_anicon_btn_recent);
            f14071c = false;
        }
        this.f14090q.moveToPosition(-1);
        boolean z2 = false;
        while (this.f14090q.moveToNext()) {
            String string = this.f14090q.getString(this.f14090q.getColumnIndex("item_id"));
            boolean z3 = this.f14090q.getInt(this.f14090q.getColumnIndex("newly_installed")) != 0;
            String string2 = this.f14090q.getString(this.f14090q.getColumnIndex("data1"));
            String string3 = this.f14090q.getString(this.f14090q.getColumnIndex("data2"));
            if (this.f14090q.getPosition() == 0 && TextUtils.isEmpty(str)) {
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
                ImageView imageView2 = (ImageView) m15108a(string, z3, i).findViewById(R.id.emoticon_tab_indicator_image);
                if (i == -1) {
                    this.f14078e.m19023b(imageView2, new C2779k(string, C2188b.m9789a(this.f14090q.getString(this.f14090q.getColumnIndex("extras"))).m9795a(), this.f14077d));
                } else {
                    imageView2.setImageResource(R.drawable.chat_anicon_btn_anicon);
                }
                z2 = z;
            } catch (JSONException e2) {
                e = e2;
                z2 = z;
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f14070b);
                }
            }
        }
        if (!z2) {
            ((ImageView) m15108a("-4", false, 3).findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_anicon);
        }
        if (TextUtils.isEmpty(str)) {
            str = "-4";
        }
        ((ImageView) m15120d("-5").findViewById(R.id.emoticon_tab_indicator_image)).setImageResource(R.drawable.chat_anicon_btn_setting);
        m15122e(str);
    }

    /* renamed from: d */
    private View m15120d(String str) {
        return m15108a(str, false, -1);
    }

    /* renamed from: a */
    private View m15108a(String str, boolean z, int i) {
        View viewInflate = LayoutInflater.from(this.f14080g).inflate(R.layout.item_emoticon_tab_indicator, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(this.f14080g.getResources().getDimensionPixelOffset(R.dimen.anicon_tab_indicator_width), this.f14080g.getResources().getDimensionPixelOffset(R.dimen.anicon_tab_indicator_height)));
        viewInflate.setTag(str);
        viewInflate.setOnClickListener(this);
        if (TextUtils.equals(str, "-1")) {
            if (this.f14075D.getChildCount() == 0) {
                this.f14075D.addView(viewInflate);
            }
        } else if (this.f14082i.getChildCount() >= i) {
            this.f14082i.addView(viewInflate, i);
        } else {
            this.f14082i.addView(viewInflate);
        }
        this.f14087n.put(str, viewInflate);
        if (z) {
            viewInflate.setBackgroundResource(R.drawable.anicon_indicator_new_bg);
        } else {
            viewInflate.setBackgroundResource(R.drawable.tab_center_button_background);
        }
        return viewInflate;
    }

    /* renamed from: e */
    private void m15121e() {
        this.f14089p = null;
        for (String str : this.f14087n.keySet()) {
            if (!"-1".equals(str) && !"-2".equals(str) && !"-3".equals(str) && !"-5".equals(str)) {
                this.f14078e.m19015a(this.f14087n.get(str).findViewById(R.id.emoticon_tab_indicator_image));
            }
        }
        this.f14087n.clear();
        this.f14082i.removeAllViews();
    }

    /* renamed from: e */
    private void m15122e(String str) throws Throwable {
        View view;
        if (str != null) {
            if (str.equals("-1")) {
                if (C4822an.m18218a()) {
                    m15115b();
                    return;
                }
                Intent intent = new Intent(getActivity(), (Class<?>) RegisterSMSActivity.class);
                intent.putExtra("request_register", EnumC3297gd.reigster);
                startActivity(intent);
                return;
            }
            if (str.equals("-5")) {
                m15117c();
                return;
            }
            if (TextUtils.isEmpty(str) || !str.equals(this.f14089p)) {
                if (!TextUtils.isEmpty(this.f14089p) && (view = this.f14087n.get(this.f14089p)) != null) {
                    view.setSelected(false);
                }
                this.f14089p = str;
                View view2 = this.f14087n.get(str);
                if (view2 != null) {
                    view2.setSelected(true);
                }
                if (str.equals("-2")) {
                    this.f14083j.setVisibility(0);
                    this.f14084k.setVisibility(8);
                    this.f14085l.setVisibility(8);
                    this.f14094u.setVisibility(8);
                    m15130k();
                    if (this.f14072A == null) {
                        this.f14072A = m15128i();
                    }
                    if (this.f14072A.isEmpty()) {
                        this.f14083j.setVisibility(8);
                        this.f14084k.setVisibility(0);
                        this.f14094u.setVisibility(8);
                        return;
                    } else {
                        this.f14083j.setAdapter(this.f14072A);
                        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.recent_gridview_padding);
                        this.f14083j.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        this.f14083j.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.recent_gridview_item_width));
                        this.f14083j.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.recent_gridview_item_horizontal_spacing));
                        this.f14083j.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.recent_gridview_item_vertical_spacing));
                        return;
                    }
                }
                if (str.equals("-3")) {
                    this.f14083j.setVisibility(0);
                    this.f14084k.setVisibility(8);
                    this.f14094u.setVisibility(8);
                    this.f14085l.setVisibility(8);
                    if (this.f14073B == null) {
                        this.f14073B = m15127h();
                    }
                    this.f14083j.setAdapter(this.f14073B);
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_padding);
                    this.f14083j.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
                    this.f14083j.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_item_width));
                    this.f14083j.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_item_horizontal_spacing));
                    this.f14083j.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.emoticon_gridview_item_vertical_spacing));
                    return;
                }
                if (str.equals("-4")) {
                    this.f14083j.setVisibility(8);
                    this.f14084k.setVisibility(8);
                    this.f14085l.setVisibility(0);
                    if (!C4822an.m18218a()) {
                        this.f14096w.setVisibility(8);
                        this.f14099z.setVisibility(0);
                        this.f14098y.setEnabled(true);
                        return;
                    } else {
                        this.f14096w.setVisibility(0);
                        this.f14099z.setVisibility(8);
                        this.f14097x.setEnabled(true);
                        return;
                    }
                }
                this.f14083j.setVisibility(0);
                this.f14084k.setVisibility(8);
                this.f14085l.setVisibility(8);
                this.f14094u.setVisibility(8);
                this.f14086m.mo875a(this.f14080g.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath("group").appendPath(str).build(), null, null, null, null));
                this.f14086m.notifyDataSetInvalidated();
                this.f14083j.setAdapter((ListAdapter) this.f14086m);
                this.f14083j.setSelection(0);
                int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.anicon_gridview_padding);
                this.f14083j.setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
                this.f14083j.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.anicon_gridview_item_width));
                this.f14083j.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.anicon_gridview_item_horizontal_spacing));
                this.f14083j.setVerticalSpacing(getResources().getDimensionPixelSize(R.dimen.anicon_gridview_item_vertical_spacing));
            }
        }
    }

    /* renamed from: f */
    private void m15124f(String str) throws Throwable {
        View view = this.f14087n.get(str);
        if (!view.getBackground().equals(getResources().getDrawable(R.drawable.tab_center_button_background))) {
            view.setBackgroundResource(R.drawable.tab_center_button_background);
            String strM19199a = C5052r.m19199a("item_id", " IN ( SELECT ", "item_id", " FROM ( ", "\tSELECT ", "data1", ",", "data2", "\tFROM ", "download_item", "\tWHERE ", " ( ", "item_type", "='", EnumC2258bd.Anicon.m10123a(), "' )", " AND ", "install", " != 0 AND ", "item_id", "=?) D1", "\tINNER JOIN ", "download_item", " D2 ", "\tON D1.", "data1", " = D2.", "data1", " AND D1.", "data2", " = D2.", "data2", ")");
            ContentValues contentValues = new ContentValues();
            contentValues.put("newly_installed", (Integer) 0);
            this.f14093t.startUpdate(0, null, C2257bc.f8039a.buildUpon().appendPath("init_newly_installed").build(), contentValues, strM19199a, new String[]{str});
        }
    }

    /* renamed from: f */
    private ExecutorService m15123f() {
        return Executors.newCachedThreadPool(new ThreadFactoryC3918f(this));
    }

    /* renamed from: g */
    private ExecutorService m15126g() {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC3919g(this));
    }

    /* renamed from: h */
    private ListAdapter m15127h() {
        String[] strArr = new String[1];
        return new C2793e(this.f14080g, C2797i.m11707c());
    }

    /* renamed from: i */
    private ListAdapter m15128i() {
        return new C2800l(this.f14080g, C2797i.m11705a(), this.f14079f);
    }

    /* renamed from: j */
    private void m15129j() throws Throwable {
        Cursor cursorQuery;
        if (C4809aa.m18104a().m18119a("chat_is_recent_anicon_merged", (Boolean) false).booleanValue()) {
            return;
        }
        try {
            cursorQuery = this.f14080g.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath("recentused").build(), null, null, null, null);
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
    private String m15125g(String str) throws Throwable {
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("aniconId null from getPackageID()", f14070b);
            return null;
        }
        try {
            Cursor cursorQuery = this.f14080g.getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath(str).build(), null, null, null, null);
            try {
                if (cursorQuery == null) {
                    C4904y.m18639b("cursur null from getPackageID()", f14070b);
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

    /* renamed from: k */
    private void m15130k() throws Throwable {
        Cursor cursorQuery;
        Uri uriBuild = C2255ba.f8038a.buildUpon().appendPath("recentused").build();
        String[] strArrMo11703a = C2797i.m11705a().mo11703a();
        int length = strArrMo11703a.length;
        if (length <= 0) {
            return;
        }
        try {
            cursorQuery = this.f14080g.getContentResolver().query(uriBuild, null, null, null, null);
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
