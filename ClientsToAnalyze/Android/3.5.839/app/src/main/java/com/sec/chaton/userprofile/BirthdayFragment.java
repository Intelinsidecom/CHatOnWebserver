package com.sec.chaton.userprofile;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p046a.p047a.C0792p;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class BirthdayFragment extends Fragment {

    /* renamed from: d */
    private String f17079d;

    /* renamed from: e */
    private String f17080e;

    /* renamed from: f */
    private String f17081f;

    /* renamed from: g */
    private RelativeLayout f17082g;

    /* renamed from: h */
    private View f17083h;

    /* renamed from: i */
    private CheckBox f17084i;

    /* renamed from: j */
    private RelativeLayout f17085j;

    /* renamed from: k */
    private View f17086k;

    /* renamed from: l */
    private CheckBox f17087l;

    /* renamed from: m */
    private View f17088m;

    /* renamed from: n */
    private SimpleDateFormat f17089n;

    /* renamed from: o */
    private SimpleDateFormat f17090o;

    /* renamed from: q */
    private C2075ah f17092q;

    /* renamed from: r */
    private ProgressDialog f17093r;

    /* renamed from: s */
    private ProgressDialog f17094s;

    /* renamed from: t */
    private View f17095t;

    /* renamed from: u */
    private TextView f17096u;

    /* renamed from: v */
    private FrameLayout f17097v;

    /* renamed from: w */
    private LinearLayout f17098w;

    /* renamed from: x */
    private TextView f17099x;

    /* renamed from: y */
    private TextView f17100y;

    /* renamed from: p */
    private Calendar f17091p = Calendar.getInstance();

    /* renamed from: z */
    private View.OnClickListener f17101z = new ViewOnClickListenerC4714a(this);

    /* renamed from: A */
    private View.OnClickListener f17074A = new ViewOnClickListenerC4741b(this);

    /* renamed from: B */
    private Handler f17075B = new HandlerC4768c(this);

    /* renamed from: a */
    CompoundButton.OnCheckedChangeListener f17076a = new C4786e(this);

    /* renamed from: b */
    CompoundButton.OnCheckedChangeListener f17077b = new C4787f(this);

    /* renamed from: c */
    DatePickerDialog.OnDateSetListener f17078c = new C4788g(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Throwable {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_birthday, viewGroup, false);
        this.f17082g = (RelativeLayout) viewInflate.findViewById(R.id.rlayout_setting_birthday_checkbox);
        this.f17083h = viewInflate.findViewById(R.id.setting_birthday_description_of_contact);
        this.f17100y = (TextView) this.f17083h.findViewById(R.id.text1);
        this.f17100y.setSingleLine(false);
        TextView textView = (TextView) this.f17083h.findViewById(R.id.text2);
        this.f17100y.setText(R.string.show_birthday);
        textView.setText(R.string.birthday_open_birthday);
        textView.setSingleLine(false);
        this.f17098w = (LinearLayout) viewInflate.findViewById(R.id.setting_birthday_text_layout);
        this.f17095t = viewInflate.findViewById(R.id.setting_birthday_text);
        this.f17096u = (TextView) this.f17095t.findViewById(R.id.text1);
        this.f17097v = (FrameLayout) this.f17095t.findViewById(R.id.space2);
        this.f17097v.setVisibility(0);
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_arrow));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 5));
        this.f17097v.addView(imageView);
        this.f17084i = (CheckBox) viewInflate.findViewById(R.id.setting_birthday_checkbox);
        this.f17084i.setChecked(C4809aa.m18104a().m18119a("birthday_show", (Boolean) true).booleanValue());
        C4904y.m18646e("setChecked : " + C4809aa.m18104a().m18119a("birthday_show", (Boolean) true), getClass().getSimpleName());
        this.f17084i.setOnCheckedChangeListener(this.f17076a);
        this.f17084i.setClickable(false);
        this.f17082g.setOnClickListener(this.f17101z);
        this.f17085j = (RelativeLayout) viewInflate.findViewById(R.id.rlayout_setting_birthday_year_checkbox);
        this.f17086k = viewInflate.findViewById(R.id.setting_birthday_year_description);
        this.f17099x = (TextView) this.f17086k.findViewById(R.id.text1);
        this.f17099x.setGravity(16);
        this.f17099x.setSingleLine(false);
        this.f17099x.setText(R.string.birthday_show_year);
        ((TextView) this.f17086k.findViewById(R.id.text2)).setVisibility(8);
        this.f17087l = (CheckBox) viewInflate.findViewById(R.id.setting_birthday_year_checkbox);
        this.f17087l.setChecked(C4809aa.m18104a().m18119a("birthday_year_show", (Boolean) false).booleanValue());
        if (C4904y.f17871a) {
            C4904y.m18646e("setYearChecked : " + C4809aa.m18104a().m18119a("birthday_year_show", (Boolean) false), getClass().getSimpleName());
        }
        this.f17087l.setOnCheckedChangeListener(this.f17077b);
        this.f17087l.setClickable(false);
        this.f17085j.setOnClickListener(this.f17074A);
        this.f17088m = viewInflate.findViewById(R.id.setting_birthday_subtitle);
        ((TextView) this.f17088m.findViewById(R.id.text1)).setText(getString(R.string.birthday_settings));
        this.f17089n = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        this.f17090o = new SimpleDateFormat("MM-dd", Locale.US);
        this.f17092q = new C2075ah(this.f17075B);
        this.f17093r = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_userprofile_updating);
        this.f17094s = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_connecting_server);
        C4904y.m18646e("mOption : " + this.f17079d, getClass().getSimpleName());
        if (C4822an.m18255w()) {
            m17785e();
        }
        m17791h();
        m17787f();
        BaseActivity.m6160a((Fragment) this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    /* renamed from: d */
    private void m17783d() {
        if (!"".equals(this.f17080e)) {
            if ("FULL".equals(this.f17079d) || "FULL_HIDE".equals(this.f17079d)) {
                this.f17096u.setText(MyInfoFragment.m17841a(this.f17080e));
                return;
            }
            if ("SHORT".equals(this.f17079d) || "SHORT_HIDE".equals(this.f17079d)) {
                String[] strArrSplit = this.f17080e.split("-");
                this.f17096u.setText(MyInfoFragment.m17841a(strArrSplit[1] + "-" + strArrSplit[2]));
                return;
            } else {
                this.f17096u.setText(getResources().getString(R.string.add_your_birthday));
                C4809aa.m18105a("birthday_show", (Boolean) true);
                this.f17084i.setChecked(true);
                return;
            }
        }
        this.f17096u.setText(getResources().getString(R.string.add_your_birthday));
        C4809aa.m18105a("birthday_show", (Boolean) true);
        this.f17084i.setChecked(true);
    }

    /* renamed from: e */
    private void m17785e() throws Throwable {
        this.f17092q.m9312c(null);
        this.f17094s.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m17787f() {
        C4904y.m18646e("init", getClass().getSimpleName());
        this.f17079d = C4809aa.m18104a().m18121a("birthday_type", "");
        if ("".equals(this.f17079d)) {
            this.f17079d = "SHORT";
        }
        this.f17080e = C4809aa.m18104a().m18121a("birthday", "");
        this.f17082g.setClickable(true);
        this.f17084i.setEnabled(true);
        this.f17100y.setTextColor(getResources().getColor(R.color.color2));
        this.f17085j.setClickable(true);
        this.f17087l.setEnabled(true);
        if (this.f17080e.length() == 0) {
            this.f17082g.setClickable(false);
            this.f17084i.setEnabled(false);
            this.f17100y.setTextColor(getResources().getColor(R.color.setting_explain_text));
            this.f17085j.setClickable(false);
            this.f17087l.setEnabled(false);
        }
        if ("FULL".equals(this.f17079d)) {
            C4809aa.m18105a("birthday_show", (Boolean) true);
            C4809aa.m18105a("birthday_year_show", (Boolean) true);
            this.f17084i.setChecked(true);
            this.f17087l.setChecked(true);
        } else if ("SHORT".equals(this.f17079d)) {
            C4809aa.m18105a("birthday_show", (Boolean) true);
            C4809aa.m18105a("birthday_year_show", (Boolean) false);
            this.f17084i.setChecked(true);
            this.f17087l.setChecked(false);
        } else if ("FULL_HIDE".equals(this.f17079d)) {
            C4809aa.m18105a("birthday_show", (Boolean) false);
            C4809aa.m18105a("birthday_year_show", (Boolean) true);
            this.f17084i.setChecked(false);
            this.f17087l.setChecked(true);
        } else if ("SHORT_HIDE".equals(this.f17079d)) {
            C4809aa.m18105a("birthday_show", (Boolean) false);
            C4809aa.m18105a("birthday_year_show", (Boolean) false);
            this.f17084i.setChecked(false);
            this.f17087l.setChecked(false);
        }
        if (this.f17082g.isClickable()) {
            this.f17099x.setTextColor(getActivity().getResources().getColor(R.color.color2));
        } else {
            this.f17099x.setTextColor(getActivity().getResources().getColor(R.color.setting_explain_text));
        }
        m17783d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m17789g() throws NumberFormatException {
        int i = 1;
        int i2 = 0;
        int i3 = 2000;
        C4904y.m18639b("[editBirthDay] mBirthDay=" + this.f17080e, getClass().getSimpleName());
        if (this.f17080e != null && !"".equals(this.f17080e)) {
            String[] strArrSplit = this.f17080e.split("-");
            i3 = Integer.parseInt(strArrSplit[0]);
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i = Integer.parseInt(strArrSplit[2]);
        }
        m17800a(i3, i2, i);
    }

    /* renamed from: h */
    private void m17791h() {
        this.f17098w.setOnClickListener(new ViewOnClickListenerC4785d(this));
    }

    /* renamed from: a */
    protected void m17800a(int i, int i2, int i3) {
        new DatePickerDialog(new ContextThemeWrapper(getActivity(), android.R.style.Theme.Holo.Light.Dialog), this.f17078c, i, i2, i3).show();
    }

    /* renamed from: a */
    public String m17799a() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(Calendar.getInstance().getTimeInMillis()));
        C4904y.m18639b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    /* renamed from: b */
    public void m17802b() {
        if ("".equals(this.f17080e)) {
            this.f17080e = m17799a();
        }
        C4904y.m18639b("onClick::mBirthDay" + this.f17080e, getClass().getSimpleName());
        this.f17081f = MyInfoFragment.m17841a(this.f17080e);
        this.f17096u.setText(this.f17081f);
    }

    /* renamed from: c */
    public void m17803c() {
        if ("".equals(this.f17080e)) {
            this.f17080e = m17799a();
        }
        this.f17081f = MyInfoFragment.m17841a(this.f17080e.substring(5, 10));
        this.f17096u.setText(this.f17081f);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C4904y.m18639b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    protected void m17801a(String str) {
        C4904y.m18639b("[sendBirthday] mBirthDay=" + this.f17080e, getClass().getSimpleName());
        C4904y.m18639b("[sendBirthday] mBirthDay option=" + str, getClass().getSimpleName());
        if (this.f17080e != null && this.f17080e.length() > 0) {
            C0792p c0792p = new C0792p();
            c0792p.m3160c(this.f17080e);
            this.f17092q.m9304a(c0792p, str);
            this.f17093r.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f17092q != null) {
            this.f17092q.m9303a();
        }
        if (this.f17093r.isShowing()) {
            this.f17093r.dismiss();
        }
        super.onDestroy();
    }
}
