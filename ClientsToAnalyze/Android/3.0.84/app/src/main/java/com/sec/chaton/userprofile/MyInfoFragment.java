package com.sec.chaton.userprofile;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.Date;

/* loaded from: classes.dex */
public class MyInfoFragment extends Fragment {

    /* renamed from: f */
    private static String f11077f = MyInfoFragment.class.getSimpleName();

    /* renamed from: h */
    private static View f11078h;

    /* renamed from: a */
    TextView f11079a;

    /* renamed from: b */
    TextView f11080b;

    /* renamed from: c */
    TextView f11081c;

    /* renamed from: d */
    ImageView f11082d;

    /* renamed from: e */
    ImageView f11083e;

    /* renamed from: g */
    private LinearLayout f11084g;

    /* renamed from: i */
    private String f11085i;

    /* renamed from: j */
    private String f11086j;

    /* renamed from: k */
    private String f11087k;

    /* renamed from: l */
    private View f11088l;

    /* renamed from: m */
    private LinearLayout f11089m;

    /* renamed from: n */
    private View f11090n;

    /* renamed from: o */
    private C1345w f11091o;

    /* renamed from: p */
    private View f11092p;

    /* renamed from: q */
    private Handler f11093q = new HandlerC3080af(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10674a();
        this.f11091o = new C1345w(this.f11093q);
        if (C3171am.m11080r()) {
            m10681c();
            m10684d();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        this.f11092p = layoutInflater.inflate(R.layout.layout_mypage_info, (ViewGroup) null);
        this.f11084g = (LinearLayout) this.f11092p.findViewById(R.id.llayout_info_background);
        if (GlobalApplication.m6456e()) {
            this.f11084g.setBackgroundColor(Color.parseColor("#F0EEEA"));
        }
        f11078h = this.f11092p.findViewById(R.id.llayout_info_birthday);
        this.f11081c = (TextView) this.f11092p.findViewById(R.id.info_birthday);
        this.f11088l = this.f11092p.findViewById(R.id.llayout_info_signin_account);
        this.f11080b = (TextView) this.f11092p.findViewById(R.id.info_signin_account);
        this.f11082d = (ImageView) this.f11092p.findViewById(R.id.info_signin_account_more);
        this.f11083e = (ImageView) this.f11092p.findViewById(R.id.samsungaccount_line);
        this.f11090n = this.f11092p.findViewById(R.id.llayout_info_register_phone_number);
        this.f11089m = (LinearLayout) this.f11092p.findViewById(R.id.llayout_info_phone_number);
        this.f11079a = (TextView) this.f11092p.findViewById(R.id.info_register_phone_number);
        m10686e();
        m10679b();
        setHasOptionsMenu(true);
        return this.f11092p;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m10674a();
        m10686e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10674a() {
        this.f11085i = C3159aa.m10962a().m10979a("msisdn", "");
        this.f11086j = C3159aa.m10962a().m10979a("chaton_id", "");
        if (C3171am.m11080r()) {
            this.f11087k = C3171am.m11079q();
        } else {
            this.f11087k = "";
        }
        if (this.f11081c != null) {
            if (C3159aa.m10962a().m10977a("birthday_show", (Boolean) true).booleanValue() || C3159aa.m10962a().m10979a("birthday", "").length() == 0) {
                this.f11081c.setTextAppearance(getActivity(), R.style.TextAppearance_List01);
            } else {
                this.f11081c.setTextAppearance(getActivity(), R.style.TextAppearance_List02);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        this.f11091o.m5927a();
        this.f11091o.m5943g();
        super.onDestroy();
    }

    /* renamed from: b */
    private void m10679b() {
        f11078h.setOnClickListener(new ViewOnClickListenerC3077ac(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10681c() {
        this.f11091o.m5936c(null);
    }

    /* renamed from: d */
    private void m10684d() {
        this.f11091o.m5942f(this.f11086j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10686e() throws Resources.NotFoundException {
        if (this.f11085i != null && this.f11085i.length() != 0) {
            this.f11079a.setText("+" + this.f11085i);
            this.f11079a.setTextColor(getActivity().getResources().getColor(R.color.buddy_list_item_name));
            this.f11090n.setOnClickListener(new ViewOnClickListenerC3078ad(this));
        } else {
            this.f11079a.setText(getString(R.string.mypage_register_phone_number));
            this.f11079a.setTextColor(getActivity().getResources().getColor(R.color.mypage_info_menu));
            this.f11090n.setOnClickListener(new ViewOnClickListenerC3079ae(this));
        }
        if (C3171am.m11080r() && this.f11087k.length() != 0) {
            this.f11088l.setVisibility(0);
            this.f11080b.setText(this.f11087k);
            this.f11080b.setSelected(true);
            this.f11082d.setVisibility(8);
            this.f11088l.setClickable(false);
            this.f11088l.setFocusable(false);
            this.f11088l.setOnClickListener(null);
            this.f11083e.setVisibility(0);
        } else {
            this.f11088l.setVisibility(8);
            this.f11083e.setVisibility(8);
        }
        m10675a(this.f11081c);
    }

    /* renamed from: a */
    public static void m10677a(String str) {
        String str2;
        String strM10979a = C3159aa.m10962a().m10979a("birthday", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("birthday_type", "");
        if ("0000-12-31".equals(str)) {
            C3159aa.m10963a("birthday_show", (Boolean) false);
            if ("FULL".equals(strM10979a2) || "FULL_HIDE".equals(strM10979a2)) {
                C3159aa.m10962a().m10986b("birthday_type", "FULL_HIDE");
                return;
            } else {
                C3159aa.m10962a().m10986b("birthday_type", "SHORT_HIDE");
                return;
            }
        }
        C3159aa.m10963a("birthday_show", (Boolean) true);
        if (str.length() == 10) {
            C3159aa.m10962a().m10986b("birthday", str);
            C3159aa.m10962a().m10986b("birthday_type", "FULL");
            return;
        }
        String[] strArrSplit = strM10979a.split("-");
        String[] strArrSplit2 = str.split("-");
        if (strArrSplit[0].equals("") || strArrSplit.length == 2) {
            str2 = "2000-" + strArrSplit2[0] + "-" + strArrSplit2[1];
        } else {
            str2 = strArrSplit[0] + "-" + strArrSplit2[0] + "-" + strArrSplit2[1];
        }
        C3159aa.m10962a().m10986b("birthday", str2);
        C3159aa.m10962a().m10986b("birthday_type", "SHORT");
    }

    /* renamed from: a */
    public static void m10675a(TextView textView) throws Resources.NotFoundException {
        String strM10979a = C3159aa.m10962a().m10979a("birthday_type", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("birthday", "");
        if (strM10979a2 == null || strM10979a2.length() == 0) {
            strM10979a2 = CommonApplication.m11493l().getResources().getString(R.string.add_your_birthday);
        }
        C3250y.m11456e("setBirthDay birthday : " + strM10979a2, f11077f);
        if (textView != null) {
            try {
                if (strM10979a.equals("FULL") || strM10979a.equals("FULL_HIDE")) {
                    textView.setText(m10678b(strM10979a2));
                } else if (strM10979a.equals("SHORT") || strM10979a.equals("SHORT_HIDE")) {
                    String[] strArrSplit = strM10979a2.split("-");
                    textView.setText(m10678b(strArrSplit[1] + "-" + strArrSplit[2]));
                } else if (strM10979a2.equals(CommonApplication.m11493l().getResources().getString(R.string.add_your_birthday))) {
                    textView.setText(CommonApplication.m11493l().getResources().getString(R.string.add_your_birthday));
                } else {
                    textView.setText(CommonApplication.m11493l().getResources().getString(R.string.add_your_birthday));
                }
            } catch (Exception e) {
                C3250y.m11450b("setBirthDay error", f11077f);
                return;
            }
        }
        f11078h.setVisibility(0);
    }

    /* renamed from: b */
    public static String m10678b(String str) throws NumberFormatException {
        String strReplaceAll;
        int i;
        int i2;
        int i3;
        C3250y.m11456e("original birthday str:" + str, f11077f);
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.contains(" ") && (str.contains("-") || str.contains("/") || str.contains(".") || str.contains(","))) {
            strReplaceAll = str.replaceAll("\\s", "");
            C3250y.m11456e("trimmed birthday str:" + strReplaceAll, f11077f);
        } else {
            strReplaceAll = str;
        }
        String[] strArrSplit = strReplaceAll.split("-|\\/|\\s|\\.|\\,");
        try {
            if (strReplaceAll.length() == 10) {
                i = Integer.parseInt(strArrSplit[0]) - 1900;
                i2 = Integer.parseInt(strArrSplit[1]) - 1;
                i3 = Integer.parseInt(strArrSplit[2]);
            } else {
                i = 100;
                i2 = Integer.parseInt(strArrSplit[0]) - 1;
                i3 = Integer.parseInt(strArrSplit[1]);
            }
            try {
                String string = DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(i, i2, i3)).toString();
                if (str.length() != 10) {
                    if (string.contains(" ") && (string.contains("-") || string.contains("/") || string.contains(".") || string.contains(","))) {
                        string = string.replaceAll("\\s", "");
                    }
                    String[] strArrSplit2 = string.split("-|\\/|\\s|\\.|\\,");
                    if (strArrSplit2[0].length() == 4) {
                        return string.substring(5);
                    }
                    if (strArrSplit2[2].length() == 4) {
                        return string.substring(0, strArrSplit2[1].length() + strArrSplit2[0].length() + 1);
                    }
                    return string;
                }
                return string;
            } catch (Exception e) {
                C3250y.m11450b("change date format error", f11077f);
                return str;
            }
        } catch (Exception e2) {
            C3250y.m11450b("change date format error", f11077f);
            return str;
        }
    }
}
