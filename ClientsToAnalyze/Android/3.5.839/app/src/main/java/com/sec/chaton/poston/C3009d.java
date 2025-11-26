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
import com.sec.chaton.p057e.p058a.C2179ae;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5035l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.d */
/* loaded from: classes.dex */
public class C3009d extends BaseAdapter {

    /* renamed from: a */
    InterfaceC3015j f11137a;

    /* renamed from: g */
    private Context f11138g;

    /* renamed from: h */
    private C5007c f11139h;

    /* renamed from: i */
    private ArrayList<C3016k> f11140i;

    /* renamed from: j */
    private LayoutInflater f11141j;

    /* renamed from: k */
    private int f11142k;

    /* renamed from: l */
    private String f11143l;

    /* renamed from: n */
    private View.OnClickListener f11144n = new ViewOnClickListenerC3014i(this);

    /* renamed from: b */
    public static String f11131b = Spam.ACTIVITY_REPORT;

    /* renamed from: c */
    public static String f11132c = Spam.ACTIVITY_CHECK;

    /* renamed from: d */
    public static String f11133d = "3";

    /* renamed from: m */
    private static String f11136m = C4873ck.m18502c() + "/poston/";

    /* renamed from: e */
    public static String f11134e = "mypage";

    /* renamed from: f */
    public static String f11135f = "buddy";

    /* renamed from: a */
    public void m12364a(InterfaceC3015j interfaceC3015j) {
        this.f11137a = interfaceC3015j;
    }

    public C3009d(ListView listView, Context context, ArrayList<C3016k> arrayList, int i, C5007c c5007c) {
        this.f11143l = null;
        this.f11138g = context;
        this.f11140i = arrayList;
        this.f11142k = i;
        if (this.f11138g != null) {
            this.f11141j = (LayoutInflater) this.f11138g.getSystemService("layout_inflater");
        }
        this.f11143l = null;
        this.f11139h = c5007c;
    }

    public C3009d(ListView listView, Context context, ArrayList<C3016k> arrayList, int i, String str, C5007c c5007c) {
        this.f11143l = null;
        this.f11138g = context;
        this.f11140i = arrayList;
        this.f11142k = i;
        if (this.f11138g != null) {
            this.f11141j = (LayoutInflater) this.f11138g.getSystemService("layout_inflater");
        }
        this.f11143l = str;
        this.f11139h = c5007c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11140i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11140i.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3017l c3017l;
        CallableC2983ba callableC2983ba;
        C2179ae c2179ae;
        boolean z;
        C2179ae c2179ae2;
        if (view == null) {
            View viewInflate = this.f11141j.inflate(this.f11142k, viewGroup, false);
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space1);
            frameLayout.addView(this.f11141j.inflate(R.layout.mypage_poston_list_location, (ViewGroup) frameLayout, false));
            FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(R.id.space2);
            ((FrameLayout.LayoutParams) frameLayout2.getLayoutParams()).gravity = 16;
            ImageView imageView = new ImageView(this.f11138g);
            imageView.setImageDrawable(this.f11138g.getResources().getDrawable(R.drawable.chat_btn_play));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            frameLayout2.addView(imageView);
            C3017l c3017l2 = new C3017l((ViewGroup) viewInflate);
            c3017l2.f11176k.setOnClickListener(this.f11144n);
            c3017l = c3017l2;
            view = viewInflate;
        } else {
            c3017l = (C3017l) view.getTag();
        }
        if (this.f11143l == null && Integer.parseInt(this.f11140i.get(i).m12372g()) > 0) {
            c3017l.f11179n.setImageResource(R.drawable.trunk_ic_comment_unread_chats);
        } else {
            c3017l.f11179n.setImageResource(R.drawable.trunk_ic_comment_read);
        }
        if (!TextUtils.isEmpty(this.f11140i.get(i).m12370e())) {
            c3017l.f11168c.setVisibility(0);
            c3017l.f11168c.setText(this.f11140i.get(i).m12370e());
        } else {
            c3017l.f11168c.setVisibility(8);
        }
        c3017l.f11173h.setOnClickListener(new ViewOnClickListenerC3010e(this, i));
        c3017l.f11172g.setOnLongClickListener(null);
        c3017l.f11174i.setOnClickListener(new ViewOnClickListenerC3011f(this, i));
        c3017l.f11174i.setOnLongClickListener(new ViewOnLongClickListenerC3012g(this));
        c3017l.f11169d.setText(m12358a(Long.parseLong(this.f11140i.get(i).m12371f())));
        if (this.f11140i.get(i).m12368c().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            C2496n.m10763a(c3017l.f11166a, EnumC2498p.ROUND);
            c3017l.f11166a.setClickable(false);
        } else {
            C2496n.m10765a(c3017l.f11166a, this.f11140i.get(i).m12368c(), EnumC2498p.ROUND);
            if (this.f11143l != null && this.f11140i.get(i).m12368c().equals(this.f11143l)) {
                c3017l.f11166a.setClickable(false);
            } else {
                c3017l.f11166a.setOnClickListener(new ViewOnClickListenerC3013h(this, i));
            }
        }
        if (this.f11140i.get(i).m12368c().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            c3017l.f11167b.setText(GlobalApplication.m10283b().getString(R.string.setting_interaction_me));
        } else {
            c3017l.f11167b.setText(this.f11140i.get(i).m12369d());
        }
        c3017l.f11166a.setContentDescription(c3017l.f11167b.getText());
        c3017l.f11171f.setText(this.f11140i.get(i).m12376k());
        ArrayList<C2179ae> arrayListM12375j = this.f11140i.get(i).m12375j();
        c3017l.f11177l.setVisibility(8);
        if (arrayListM12375j.size() > 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("for bGeo Position = " + i, getClass().getSimpleName());
            }
            c3017l.f11174i.setVisibility(0);
            C2179ae c2179ae3 = null;
            boolean z2 = false;
            Iterator<C2179ae> it = arrayListM12375j.iterator();
            C2179ae c2179ae4 = null;
            boolean z3 = false;
            while (it.hasNext()) {
                C2179ae next = it.next();
                if (z3 || !(next.m9726a().equals(Spam.ACTIVITY_REPORT) || next.m9726a().equals(Spam.ACTIVITY_CHECK))) {
                    c2179ae = c2179ae4;
                } else {
                    z3 = true;
                    c2179ae = next;
                }
                if (next.m9726a().equals("3")) {
                    c2179ae2 = next;
                    z = true;
                } else {
                    z = z2;
                    c2179ae2 = c2179ae3;
                }
                c2179ae3 = c2179ae2;
                c2179ae4 = c2179ae;
                z2 = z;
            }
            if (z2) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("bGeo = true / Position = " + i, getClass().getSimpleName());
                }
                c3017l.f11175j.setVisibility(0);
                String strM12359a = m12359a(c2179ae3);
                if (strM12359a != null) {
                    c3017l.f11176k.setText(strM12359a);
                    C5035l.m19114a(c3017l.f11176k);
                    c3017l.f11176k.setTag(c2179ae3);
                }
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("bGeo = false / Position = " + i, getClass().getSimpleName());
                }
                c3017l.f11175j.setVisibility(8);
            }
            if (z3 && c2179ae4 != null) {
                c3017l.f11174i.setVisibility(0);
                String str = c2179ae4.m9728b().split("/")[r0.length - 1];
                if (this.f11143l == null) {
                    File file = new File(f11136m + C4809aa.m18104a().m18121a("chaton_id", ""));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (new File(file, str).exists()) {
                        callableC2983ba = new CallableC2983ba(c2179ae4.m9728b(), C4809aa.m18104a().m18121a("chaton_id", ""), c2179ae4.m9726a().equals(f11131b), f11134e, CallableC2983ba.f11085e);
                    } else {
                        callableC2983ba = new CallableC2983ba(c2179ae4.m9728b(), C4809aa.m18104a().m18121a("chaton_id", ""), c2179ae4.m9726a().equals(f11131b), f11134e, CallableC2983ba.f11084d);
                    }
                } else {
                    File file2 = new File(f11136m + this.f11143l);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (new File(file2, str).exists()) {
                        callableC2983ba = new CallableC2983ba(c2179ae4.m9728b(), this.f11143l, c2179ae4.m9726a().equals(f11131b), f11134e, CallableC2983ba.f11085e);
                    } else {
                        callableC2983ba = new CallableC2983ba(c2179ae4.m9728b(), this.f11143l, c2179ae4.m9726a().equals(f11131b), f11134e, CallableC2983ba.f11084d);
                    }
                }
                if (callableC2983ba != null) {
                    this.f11139h.m19023b(c3017l.f11174i, callableC2983ba);
                }
                if (c2179ae4.m9726a().equals(f11132c)) {
                    c3017l.f11177l.setVisibility(0);
                } else {
                    c3017l.f11177l.setVisibility(8);
                }
            } else {
                c3017l.f11174i.setImageDrawable(null);
                this.f11139h.m19015a((View) c3017l.f11174i);
                c3017l.f11174i.setVisibility(8);
            }
        } else {
            if (C4904y.f17872b) {
                C4904y.m18639b("for bGeo Position multimediaArray not exist = " + i, getClass().getSimpleName());
            }
            c3017l.f11174i.setImageDrawable(null);
            this.f11139h.m19015a((View) c3017l.f11174i);
            c3017l.f11174i.setVisibility(8);
            c3017l.f11175j.setVisibility(8);
        }
        view.setTag(c3017l);
        return view;
    }

    /* renamed from: a */
    private String m12359a(C2179ae c2179ae) {
        if (c2179ae.m9728b().length() > 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(c2179ae.m9728b().substring(1, c2179ae.m9728b().length() - 1), ",");
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
    public String m12363b(C2179ae c2179ae) {
        if (c2179ae.m9728b().length() > 1) {
            StringTokenizer stringTokenizer = new StringTokenizer(c2179ae.m9728b().substring(1, c2179ae.m9728b().length() - 1), ",");
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
    public static String m12358a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            return DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        if (str2.equals(str4)) {
            return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
    }
}
