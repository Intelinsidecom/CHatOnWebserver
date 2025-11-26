package com.sec.chaton;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.InterfaceC0196cc;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2071ad;
import com.sec.chaton.p055d.C2073af;
import com.sec.chaton.p057e.C2262bh;
import com.sec.chaton.p057e.C2264bj;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.p057e.EnumC2265bk;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyTopicChatEntry;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.settings.moreapps.C3672d;
import com.sec.chaton.settings.moreapps.CallableC3675g;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.shop.C3733f;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.log.collector.C5043h;
import com.sec.widget.ExpandableHeightGridView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class PlusFragment extends Fragment implements InterfaceC2318el {

    /* renamed from: a */
    public static final String f1956a = PlusFragment.class.getSimpleName();

    /* renamed from: A */
    private LinearLayout f1957A;

    /* renamed from: B */
    private LinearLayout f1958B;

    /* renamed from: C */
    private RelativeLayout f1959C;

    /* renamed from: D */
    private RelativeLayout f1960D;

    /* renamed from: E */
    private LinearLayout f1961E;

    /* renamed from: F */
    private ViewPager f1962F;

    /* renamed from: G */
    private C1499cc f1963G;

    /* renamed from: H */
    private ArrayList<C1502cf> f1964H;

    /* renamed from: I */
    private ArrayList<View> f1965I;

    /* renamed from: J */
    private int f1966J;

    /* renamed from: b */
    public boolean f1975b;

    /* renamed from: f */
    private ExpandableHeightGridView f1979f;

    /* renamed from: g */
    private LinearLayout f1980g;

    /* renamed from: h */
    private LinearLayout f1981h;

    /* renamed from: i */
    private LinearLayout f1982i;

    /* renamed from: j */
    private RelativeLayout f1983j;

    /* renamed from: k */
    private C3672d f1984k;

    /* renamed from: l */
    private ArrayList<C1501ce> f1985l;

    /* renamed from: m */
    private int f1986m;

    /* renamed from: n */
    private C5007c f1987n;

    /* renamed from: o */
    private C5007c f1988o;

    /* renamed from: p */
    private C5007c f1989p;

    /* renamed from: q */
    private Activity f1990q;

    /* renamed from: r */
    private PlusFragment f1991r;

    /* renamed from: s */
    private boolean f1992s;

    /* renamed from: t */
    private boolean f1993t;

    /* renamed from: u */
    private Cursor f1994u;

    /* renamed from: v */
    private C2210x f1995v;

    /* renamed from: w */
    private LayoutInflater f1996w;

    /* renamed from: x */
    private ImageView f1997x;

    /* renamed from: y */
    private ImageView f1998y;

    /* renamed from: z */
    private ScrollView f1999z;

    /* renamed from: K */
    private SpecialBuddyTopicChatEntry f1967K = null;

    /* renamed from: c */
    ContentObserver f1976c = new C1095bn(this, new Handler());

    /* renamed from: d */
    ContentObserver f1977d = new C1101bt(this, new Handler());

    /* renamed from: L */
    private AdapterView.OnItemClickListener f1968L = new C1102bu(this);

    /* renamed from: e */
    InterfaceC2211y f1978e = new C1421bv(this);

    /* renamed from: M */
    private Handler f1969M = new HandlerC1424by(this);

    /* renamed from: N */
    private View.OnClickListener f1970N = new ViewOnClickListenerC1434ca(this);

    /* renamed from: O */
    private View.OnClickListener f1971O = new ViewOnClickListenerC1096bo(this);

    /* renamed from: P */
    private View.OnClickListener f1972P = new ViewOnClickListenerC1097bp(this);

    /* renamed from: Q */
    private View.OnClickListener f1973Q = new ViewOnClickListenerC1098bq(this);

    /* renamed from: R */
    private InterfaceC0196cc f1974R = new C1099br(this);

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        C5043h.m19179a().m19185a("4000", "2104", false);
        View viewInflate = layoutInflater.inflate(R.layout.layout_plus_horizontal, viewGroup, false);
        this.f1991r = this;
        this.f1980g = (LinearLayout) viewInflate.findViewById(R.id.plus_chatonlive);
        this.f1981h = (LinearLayout) viewInflate.findViewById(R.id.plus_shop);
        this.f1983j = (RelativeLayout) viewInflate.findViewById(R.id.plus_topic_layout);
        this.f1982i = (LinearLayout) viewInflate.findViewById(R.id.plus_topic);
        this.f1999z = (ScrollView) viewInflate.findViewById(R.id.scrollview);
        this.f1957A = (LinearLayout) viewInflate.findViewById(R.id.topic_bottom_line);
        this.f1961E = (LinearLayout) viewInflate.findViewById(R.id.other_services_header);
        this.f1959C = (RelativeLayout) viewInflate.findViewById(R.id.banner_layout);
        this.f1960D = (RelativeLayout) viewInflate.findViewById(R.id.banner_item_layout);
        this.f1958B = (LinearLayout) viewInflate.findViewById(R.id.indicator_layout);
        this.f1966J = 0;
        this.f1962F = (ViewPager) viewInflate.findViewById(R.id.filter_pager);
        this.f1963G = new C1499cc(this);
        this.f1962F.setAdapter(this.f1963G);
        this.f1962F.setOnPageChangeListener(this.f1974R);
        this.f1964H = new ArrayList<>();
        this.f1965I = new ArrayList<>();
        m2931a(viewInflate);
        this.f1979f = (ExpandableHeightGridView) viewInflate.findViewById(R.id.plus_moreapps);
        this.f1979f.setOnItemClickListener(this.f1968L);
        this.f1985l = new ArrayList<>();
        this.f1979f.setExpanded(true);
        this.f1995v = new C2210x(this.f1990q.getContentResolver(), this.f1978e);
        this.f1990q.getContentResolver().registerContentObserver(C2262bh.f8053a, true, this.f1976c);
        this.f1990q.getContentResolver().registerContentObserver(C2264bj.f8054a, true, this.f1977d);
        this.f1996w = (LayoutInflater) this.f1990q.getSystemService("layout_inflater");
        this.f1975b = false;
        this.f1992s = true;
        if (this.f1999z != null) {
            this.f1999z.smoothScrollTo(0, 0);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1990q = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1990q = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (C4904y.f17872b) {
            C4904y.m18639b("onStart - Redraw the list, ", f1956a);
        }
        if (this.f1995v != null) {
            this.f1995v.startQuery(102, null, C2262bh.f8053a, null, null, null, "priority");
            this.f1995v.startQuery(101, null, C2264bj.f8054a, null, null, null, null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f1975b = true;
        if (this.f1987n != null) {
            this.f1987n.m19014a();
        }
        if (this.f1988o != null) {
            this.f1988o.m19014a();
        }
        if (this.f1989p != null) {
            this.f1989p.m19014a();
        }
        this.f1990q.getContentResolver().unregisterContentObserver(this.f1976c);
        if (this.f1994u != null) {
            this.f1994u.close();
        }
        super.onDestroyView();
    }

    /* renamed from: a */
    private int m2925a(EnumC1500cd enumC1500cd) {
        switch (C1100bs.f3499a[enumC1500cd.ordinal()]) {
            case 1:
                return C3469m.m13793a();
            case 2:
                return C4809aa.m18104a().m18120a("new_livepartner_count", (Integer) 0).intValue();
            default:
                return 0;
        }
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: j_ */
    public void mo2964j_() {
        if (!this.f1992s && this.f1999z != null) {
            this.f1999z.smoothScrollTo(this.f1999z.getScrollX(), this.f1999z.getScrollY());
        }
        if (C4809aa.m18104a().m18119a("moreapps_polling_recieve", (Boolean) false).booleanValue() || this.f1992s) {
            C2071ad.m9281a(new Handler()).m9282a();
            C4904y.m18639b("Start mMoreAppTask", GlobalApplication.class.getSimpleName());
            C4809aa.m18105a("moreapps_polling_recieve", (Boolean) false);
        }
        if (C4809aa.m18104a().m18119a("pluslist_polling_recieve", (Boolean) false).booleanValue() || this.f1992s) {
            C2073af.m9284a(new Handler()).m9285a();
            C4904y.m18639b("Start mPlusListTask", GlobalApplication.class.getSimpleName());
            C4809aa.m18105a("pluslist_polling_recieve", (Boolean) false);
        }
        this.f1992s = false;
    }

    @Override // com.sec.chaton.InterfaceC2318el
    /* renamed from: k_ */
    public void mo2965k_() {
    }

    /* renamed from: a */
    private void m2931a(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.live_menu);
        if (Build.VERSION.SDK_INT > 8) {
            ((HorizontalScrollView) view.findViewById(R.id.live_menu_scroll)).setOverScrollMode(2);
            ((HorizontalScrollView) view.findViewById(R.id.shop_menu_scroll)).setOverScrollMode(2);
            ((HorizontalScrollView) view.findViewById(R.id.topic_menu_scroll)).setOverScrollMode(2);
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.shop_menu);
        this.f1997x = (ImageView) linearLayout.findViewById(R.id.badge);
        this.f1998y = (ImageView) linearLayout2.findViewById(R.id.badge);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.plus_first_item);
        TextView textView = (TextView) linearLayout.findViewById(R.id.plus_first_text);
        imageView.setImageResource(R.drawable.more_live_ic);
        textView.setText(R.string.goto_live);
        ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.plus_first_item);
        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.plus_first_text);
        imageView2.setImageResource(R.drawable.more_shop_ic);
        textView2.setText(R.string.goto_shop);
        linearLayout.setOnClickListener(new ViewOnClickListenerC1422bw(this));
        linearLayout2.setOnClickListener(new ViewOnClickListenerC1423bx(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2938c() {
        boolean z;
        boolean z2 = false;
        try {
            if (this.f1994u != null) {
                while (this.f1994u.moveToNext()) {
                    String string = this.f1994u.getString(this.f1994u.getColumnIndex("title"));
                    EnumC2265bk enumC2265bkM10124a = EnumC2265bk.m10124a(this.f1994u.getString(this.f1994u.getColumnIndex("menutype")));
                    switch (C1100bs.f3500b[enumC2265bkM10124a.ordinal()]) {
                        case 1:
                            m2932a(this.f1996w.inflate(R.layout.layout_plus_horizontal_live_item, (ViewGroup) this.f1980g, false), new C1503cg(null), string, this.f1994u.getString(this.f1994u.getColumnIndex("id")), this.f1994u.getPosition(), enumC2265bkM10124a);
                            z = z2;
                            continue;
                            z2 = z;
                        case 2:
                            m2933a(this.f1996w.inflate(R.layout.layout_plus_horizontal_shop_item, (ViewGroup) this.f1981h, false), new C1503cg(null), string, this.f1994u.getString(this.f1994u.getColumnIndex("thumbnailurl")), this.f1994u.getString(this.f1994u.getColumnIndex("itemtype")), this.f1994u.getPosition());
                            z = z2;
                            continue;
                            z2 = z;
                        case 3:
                            String string2 = this.f1994u.getString(this.f1994u.getColumnIndex("id"));
                            long j = this.f1994u.getLong(this.f1994u.getColumnIndex("start_time"));
                            long j2 = this.f1994u.getLong(this.f1994u.getColumnIndex("end_time"));
                            String string3 = this.f1994u.getString(this.f1994u.getColumnIndex("banner_h"));
                            String string4 = this.f1994u.getString(this.f1994u.getColumnIndex("banner_v"));
                            String string5 = this.f1994u.getString(this.f1994u.getColumnIndex("weburl"));
                            long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
                            if (C4904y.f17872b) {
                                C4904y.m18639b("start : " + j + ", current : " + timeInMillis + ", end : " + j2, f1956a);
                            }
                            if (timeInMillis > j && timeInMillis < j2) {
                                C1502cf c1502cf = new C1502cf(this, string2, j, j2, string3, string4, string5);
                                this.f1964H.add(c1502cf);
                                View viewInflate = this.f1996w.inflate(R.layout.layout_plus_banner_indicator, (ViewGroup) null);
                                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.banner_indcator);
                                int size = this.f1964H.size();
                                if (size == 1) {
                                    imageView.setSelected(true);
                                }
                                viewInflate.setTag(Integer.valueOf(size - 1));
                                this.f1965I.add(viewInflate);
                                this.f1958B.addView(viewInflate);
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("add item : " + c1502cf, f1956a);
                                }
                                z = z2;
                            }
                            z2 = z;
                            break;
                        case 4:
                            m2932a(this.f1996w.inflate(R.layout.layout_plus_horizontal_live_item, (ViewGroup) this.f1982i, false), new C1503cg(null), string, this.f1994u.getString(this.f1994u.getColumnIndex("id")), this.f1994u.getPosition(), enumC2265bkM10124a);
                            z = true;
                            continue;
                            z2 = z;
                    }
                    z = z2;
                    z2 = z;
                }
            }
            if (this.f1997x != null) {
                if (m2925a(EnumC1500cd.LIVEPartner) > 0) {
                    this.f1997x.setVisibility(0);
                } else {
                    this.f1997x.setVisibility(8);
                }
            }
            if (this.f1998y != null) {
                if (m2925a(EnumC1500cd.ChatONShop) > 0) {
                    this.f1998y.setVisibility(0);
                } else {
                    this.f1998y.setVisibility(8);
                }
            }
            if (this.f1964H != null && this.f1964H.size() > 0) {
                this.f1966J = this.f1964H.size();
                this.f1959C.setVisibility(0);
                this.f1960D.setVisibility(0);
                this.f1963G.m617c();
                if (this.f1962F != null) {
                    this.f1962F.setCurrentItem(0);
                }
            } else {
                this.f1959C.setVisibility(8);
                this.f1960D.setVisibility(8);
                C4809aa.m18104a().m18123a("new_promotion_ids");
                C4809aa.m18104a().m18126b("new_promotion_count", (Integer) 0);
            }
            if (z2) {
                this.f1983j.setVisibility(0);
                this.f1957A.setVisibility(0);
            } else {
                this.f1983j.setVisibility(8);
                this.f1957A.setVisibility(8);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m2932a(View view, C1503cg c1503cg, String str, String str2, int i, EnumC2265bk enumC2265bk) {
        c1503cg.f5447a = (ImageView) view.findViewById(R.id.plus_img);
        c1503cg.f5448b = (TextView) view.findViewById(R.id.plus_text);
        c1503cg.f5448b.setText(str);
        c1503cg.f5450d = i;
        C2496n.m10765a(c1503cg.f5447a, str2, EnumC2498p.ROUND);
        c1503cg.f5447a.setBackgroundResource(R.drawable.circle_background);
        switch (C1100bs.f3500b[enumC2265bk.ordinal()]) {
            case 1:
                this.f1980g.addView(view);
                view.setTag(c1503cg);
                view.setOnClickListener(this.f1970N);
                break;
            case 4:
                this.f1982i.addView(view);
                view.setTag(c1503cg);
                view.setOnClickListener(this.f1971O);
                break;
        }
    }

    /* renamed from: a */
    private void m2933a(View view, C1503cg c1503cg, String str, String str2, String str3, int i) {
        int i2;
        EnumC2258bd enumC2258bdM14069a = C3733f.m14069a(Long.parseLong(str3));
        c1503cg.f5447a = (ImageView) view.findViewById(R.id.plus_img);
        c1503cg.f5448b = (TextView) view.findViewById(R.id.plus_text);
        c1503cg.f5449c = (TextView) view.findViewById(R.id.plus_text2);
        c1503cg.f5448b.setText(str);
        switch (C1100bs.f3501c[enumC2258bdM14069a.ordinal()]) {
            case 1:
                i2 = R.string.chat_stickers;
                break;
            case 2:
                i2 = R.string.itemtype_styles;
                break;
            case 3:
                i2 = R.string.settings_alert_tone;
                break;
            default:
                i2 = R.string.unknown;
                break;
        }
        c1503cg.f5449c.setText(i2);
        c1503cg.f5450d = i;
        this.f1988o = new C5007c();
        this.f1988o.m19023b(c1503cg.f5447a, new CallableC3675g(str2));
        this.f1981h.addView(view);
        view.setTag(c1503cg);
        view.setOnClickListener(this.f1972P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m2940d() {
        if (getActivity() != null) {
            AbstractC4932a.m18733a(getActivity()).mo18734a(R.string.pop_up_attention).mo18749b(CommonApplication.m18732r().getString(R.string.maximum_number_participants_reached, 1000)).mo18756d(R.string.goto_live, new DialogInterfaceOnClickListenerC1425bz(this)).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null).mo18745a().show();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1963G != null) {
            this.f1963G.m617c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public int m2941e() {
        if (this.f1990q != null) {
            return this.f1990q.getResources().getConfiguration().orientation;
        }
        return -1;
    }
}
