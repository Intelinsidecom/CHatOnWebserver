package com.sec.chaton.poston;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1352aa;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3348j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.d */
/* loaded from: classes.dex */
public class C2013d extends BaseAdapter {

    /* renamed from: a */
    InterfaceC2019j f7741a;

    /* renamed from: g */
    private Context f7742g;

    /* renamed from: i */
    private ArrayList<C2020k> f7744i;

    /* renamed from: j */
    private LayoutInflater f7745j;

    /* renamed from: k */
    private int f7746k;

    /* renamed from: l */
    private String f7747l;

    /* renamed from: b */
    public static String f7735b = "1";

    /* renamed from: c */
    public static String f7736c = "2";

    /* renamed from: d */
    public static String f7737d = "3";

    /* renamed from: m */
    private static String f7740m = C3223ck.m11329c() + "/poston/";

    /* renamed from: e */
    public static String f7738e = "mypage";

    /* renamed from: f */
    public static String f7739f = "buddy";

    /* renamed from: n */
    private View.OnClickListener f7748n = new ViewOnClickListenerC2018i(this);

    /* renamed from: h */
    private C3326c f7743h = new C3326c();

    /* renamed from: a */
    public void m8044a(InterfaceC2019j interfaceC2019j) {
        this.f7741a = interfaceC2019j;
    }

    public C2013d(ListView listView, Context context, ArrayList<C2020k> arrayList, int i) {
        this.f7747l = null;
        this.f7742g = context;
        this.f7744i = arrayList;
        this.f7746k = i;
        this.f7745j = (LayoutInflater) this.f7742g.getSystemService("layout_inflater");
        this.f7747l = null;
    }

    public C2013d(ListView listView, Context context, ArrayList<C2020k> arrayList, int i, String str) {
        this.f7747l = null;
        this.f7742g = context;
        this.f7744i = arrayList;
        this.f7746k = i;
        this.f7745j = (LayoutInflater) this.f7742g.getSystemService("layout_inflater");
        this.f7747l = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7744i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7744i.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2021l c2021l;
        CallableC1986az callableC1986az;
        C1352aa c1352aa;
        boolean z;
        C1352aa c1352aa2;
        if (view == null) {
            View viewInflate = this.f7745j.inflate(this.f7746k, viewGroup, false);
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space1);
            frameLayout.addView(this.f7745j.inflate(R.layout.mypage_poston_list_location, (ViewGroup) frameLayout, false));
            FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(R.id.space2);
            ImageView imageView = new ImageView(this.f7742g);
            imageView.setImageDrawable(this.f7742g.getResources().getDrawable(R.drawable.chat_btn_play));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            frameLayout2.addView(imageView);
            if (GlobalApplication.m6456e()) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
                layoutParams.gravity = 17;
                frameLayout2.setLayoutParams(layoutParams);
            }
            C2021l c2021l2 = new C2021l((ViewGroup) viewInflate);
            c2021l2.f7780k.setOnClickListener(this.f7748n);
            c2021l = c2021l2;
            view = viewInflate;
        } else {
            c2021l = (C2021l) view.getTag();
        }
        if (Integer.parseInt(this.f7744i.get(i).m8052g()) > 0) {
            c2021l.f7782m.setImageResource(R.drawable.trunk_ic_comment_unread_chats);
        } else {
            c2021l.f7782m.setImageResource(R.drawable.trunk_ic_comment_read);
        }
        c2021l.f7772c.setText(this.f7744i.get(i).m8050e());
        c2021l.f7777h.setOnClickListener(new ViewOnClickListenerC2014e(this, i));
        c2021l.f7776g.setOnLongClickListener(null);
        c2021l.f7778i.setOnClickListener(new ViewOnClickListenerC2015f(this, i));
        c2021l.f7778i.setOnLongClickListener(new ViewOnLongClickListenerC2016g(this));
        c2021l.f7773d.setText(m8038a(Long.parseLong(this.f7744i.get(i).m8051f())));
        C3205bt.m11182a(this.f7742g).m11210a(c2021l.f7770a, this.f7744i.get(i).m8048c());
        if (this.f7744i.get(i).m8048c().equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            c2021l.f7770a.setClickable(false);
        } else if (this.f7747l != null && this.f7744i.get(i).m8048c().equals(this.f7747l)) {
            c2021l.f7770a.setClickable(false);
        } else {
            c2021l.f7770a.setOnClickListener(new ViewOnClickListenerC2017h(this, i));
        }
        if (this.f7744i.get(i).m8048c().equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            c2021l.f7771b.setText(GlobalApplication.m6451b().getString(R.string.setting_interaction_me));
        } else {
            c2021l.f7771b.setText(this.f7744i.get(i).m8049d());
        }
        c2021l.f7775f.setText(this.f7744i.get(i).m8056k());
        ArrayList<C1352aa> arrayListM8055j = this.f7744i.get(i).m8055j();
        c2021l.f7781l.setVisibility(8);
        if (arrayListM8055j.size() > 0) {
            if (C3250y.f11734b) {
                C3250y.m11450b("for bGeo Position = " + i, getClass().getSimpleName());
            }
            c2021l.f7778i.setVisibility(0);
            C1352aa c1352aa3 = null;
            boolean z2 = false;
            Iterator<C1352aa> it = arrayListM8055j.iterator();
            C1352aa c1352aa4 = null;
            boolean z3 = false;
            while (it.hasNext()) {
                C1352aa next = it.next();
                if (z3 || !(next.m5957a().equals("1") || next.m5957a().equals("2"))) {
                    c1352aa = c1352aa4;
                } else {
                    z3 = true;
                    c1352aa = next;
                }
                if (next.m5957a().equals("3")) {
                    c1352aa2 = next;
                    z = true;
                } else {
                    z = z2;
                    c1352aa2 = c1352aa3;
                }
                c1352aa3 = c1352aa2;
                c1352aa4 = c1352aa;
                z2 = z;
            }
            if (z2) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("bGeo = true / Position = " + i, getClass().getSimpleName());
                }
                c2021l.f7779j.setVisibility(0);
                String strM8039a = m8039a(c1352aa3);
                if (strM8039a != null) {
                    c2021l.f7780k.setText(strM8039a);
                    C3348j.m11796a(c2021l.f7780k);
                    c2021l.f7780k.setTag(c1352aa3);
                }
            } else {
                if (C3250y.f11734b) {
                    C3250y.m11450b("bGeo = false / Position = " + i, getClass().getSimpleName());
                }
                c2021l.f7779j.setVisibility(8);
            }
            if (z3) {
                c2021l.f7778i.setVisibility(0);
            } else {
                c2021l.f7778i.setImageDrawable(null);
                this.f7743h.m11732a(c2021l.f7778i);
                c2021l.f7778i.setVisibility(8);
            }
            if (c1352aa4 != null) {
                C3250y.m11456e("content.getMetaType(): " + c1352aa4.m5957a(), getClass().getSimpleName());
                if (c1352aa4.m5957a().equals(f7735b) || c1352aa4.m5957a().equals(f7736c)) {
                    String str = c1352aa4.m5959b().split("/")[r0.length - 1];
                    if (this.f7747l == null) {
                        if (new File(f7740m + C3159aa.m10962a().m10979a("chaton_id", ""), str).exists()) {
                            callableC1986az = new CallableC1986az(c1352aa4.m5959b(), C3159aa.m10962a().m10979a("chaton_id", ""), c1352aa4.m5957a().equals(f7735b), f7738e, CallableC1986az.f7686e);
                        } else {
                            callableC1986az = new CallableC1986az(c1352aa4.m5959b(), C3159aa.m10962a().m10979a("chaton_id", ""), c1352aa4.m5957a().equals(f7735b), f7738e, CallableC1986az.f7685d);
                        }
                    } else if (new File(f7740m + this.f7747l, str).exists()) {
                        callableC1986az = new CallableC1986az(c1352aa4.m5959b(), this.f7747l, c1352aa4.m5957a().equals(f7735b), f7738e, CallableC1986az.f7686e);
                    } else {
                        callableC1986az = new CallableC1986az(c1352aa4.m5959b(), this.f7747l, c1352aa4.m5957a().equals(f7735b), f7738e, CallableC1986az.f7685d);
                    }
                    if (callableC1986az != null) {
                        this.f7743h.m11730a(c2021l.f7778i, callableC1986az);
                    }
                    if (c1352aa4.m5957a().equals(f7736c)) {
                        c2021l.f7781l.setVisibility(0);
                    } else {
                        c2021l.f7781l.setVisibility(8);
                    }
                } else {
                    c2021l.f7778i.setImageDrawable(null);
                    this.f7743h.m11732a(c2021l.f7778i);
                    c2021l.f7778i.setVisibility(8);
                }
            }
        } else {
            if (C3250y.f11734b) {
                C3250y.m11450b("for bGeo Position multimediaArray not exist = " + i, getClass().getSimpleName());
            }
            c2021l.f7778i.setVisibility(8);
            c2021l.f7779j.setVisibility(8);
        }
        view.setTag(c2021l);
        return view;
    }

    /* renamed from: a */
    private String m8039a(C1352aa c1352aa) {
        if (c1352aa.m5959b().length() > 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(c1352aa.m5959b().substring(1, c1352aa.m5959b().length() - 1), ",");
            String str = "";
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                int i2 = i + 1;
                String strNextToken = stringTokenizer.nextToken();
                if (i2 < 3 || TextUtils.isEmpty(strNextToken)) {
                    strNextToken = str;
                } else if (str.length() != 0) {
                    strNextToken = str + "," + strNextToken;
                }
                str = strNextToken;
                i = i2;
            }
            return str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m8043b(C1352aa c1352aa) {
        if (c1352aa.m5959b().length() > 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(c1352aa.m5959b().substring(1, c1352aa.m5959b().length() - 1), ",");
            if (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreTokens()) {
                    return strNextToken + "," + stringTokenizer.nextToken();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m8038a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            return DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        if (str2.equals(str4)) {
            return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
    }
}
