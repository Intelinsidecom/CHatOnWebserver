package com.sec.chaton.userprofile;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
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
import com.sec.chaton.p016a.p017a.C0276m;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: BirthdayImpl.java */
/* renamed from: com.sec.chaton.userprofile.f */
/* loaded from: classes.dex */
public class C3137f {

    /* renamed from: a */
    SimpleDateFormat f11372a;

    /* renamed from: b */
    SimpleDateFormat f11373b;

    /* renamed from: d */
    private String f11375d;

    /* renamed from: e */
    private String f11376e;

    /* renamed from: f */
    private String f11377f;

    /* renamed from: g */
    private RelativeLayout f11378g;

    /* renamed from: h */
    private View f11379h;

    /* renamed from: i */
    private CheckBox f11380i;

    /* renamed from: j */
    private View f11381j;

    /* renamed from: k */
    private View f11382k;

    /* renamed from: l */
    private TextView f11383l;

    /* renamed from: m */
    private FrameLayout f11384m;

    /* renamed from: n */
    private LinearLayout f11385n;

    /* renamed from: p */
    private C1345w f11387p;

    /* renamed from: q */
    private ProgressDialog f11388q;

    /* renamed from: r */
    private AlertDialogC3152u f11389r;

    /* renamed from: s */
    private Activity f11390s;

    /* renamed from: o */
    private Calendar f11386o = Calendar.getInstance();

    /* renamed from: t */
    private View.OnClickListener f11391t = new ViewOnClickListenerC3139h(this);

    /* renamed from: u */
    private Handler f11392u = new HandlerC3140i(this);

    /* renamed from: c */
    CompoundButton.OnCheckedChangeListener f11374c = new C3142k(this);

    /* renamed from: v */
    private InterfaceC3155x f11393v = new C3143l(this);

    /* renamed from: a */
    public void m10921a(Bundle bundle) {
    }

    /* renamed from: a */
    public void m10920a(Activity activity) {
        this.f11390s = activity;
    }

    /* renamed from: a */
    public void m10918a() {
        this.f11390s = null;
    }

    /* renamed from: a */
    public View m10917a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_birthday, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
        textView.setText(R.string.setting_category_privacy);
        textView.setClickable(true);
        textView.setOnClickListener(new ViewOnClickListenerC3138g(this));
        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.breadcrumb2);
        textView2.setText(R.string.setting_birthday);
        textView2.setTextColor(this.f11390s.getResources().getColor(R.color.buddy_list_item_status_changed));
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        this.f11378g = (RelativeLayout) viewInflate.findViewById(R.id.rlayout_setting_birthday_checkbox);
        this.f11379h = viewInflate.findViewById(R.id.setting_birthday_description);
        TextView textView3 = (TextView) this.f11379h.findViewById(R.id.text1);
        textView3.setSingleLine(false);
        TextView textView4 = (TextView) this.f11379h.findViewById(R.id.text2);
        textView3.setText(R.string.show_birthday);
        textView4.setText(R.string.birthday_open_birthday);
        textView4.setSingleLine(false);
        this.f11380i = (CheckBox) viewInflate.findViewById(R.id.setting_birthday_checkbox);
        this.f11380i.setChecked(C3159aa.m10962a().m10977a("birthday_show", (Boolean) false).booleanValue());
        C3250y.m11456e("setChecked : " + C3159aa.m10962a().m10977a("birthday_show", (Boolean) false), getClass().getSimpleName());
        this.f11380i.setOnCheckedChangeListener(this.f11374c);
        this.f11380i.setClickable(false);
        this.f11378g.setOnClickListener(this.f11391t);
        this.f11381j = viewInflate.findViewById(R.id.setting_birthday_subtitle);
        ((TextView) this.f11381j.findViewById(R.id.text1)).setText(this.f11390s.getString(R.string.birthday_settings));
        this.f11372a = new SimpleDateFormat("yyyy-MM-dd");
        this.f11373b = new SimpleDateFormat("MM-dd");
        this.f11387p = new C1345w(this.f11392u);
        this.f11388q = (ProgressDialog) new C3263j(this.f11390s).m11487a(R.string.dialog_userprofile_updating);
        C3250y.m11456e("mOption : " + this.f11375d, getClass().getSimpleName());
        this.f11385n = (LinearLayout) viewInflate.findViewById(R.id.setting_birthday_text_layout);
        this.f11382k = viewInflate.findViewById(R.id.setting_birthday_text);
        this.f11383l = (TextView) this.f11382k.findViewById(R.id.text1);
        this.f11384m = (FrameLayout) this.f11382k.findViewById(R.id.space2);
        this.f11384m.setVisibility(0);
        ImageView imageView = new ImageView(this.f11390s);
        imageView.setImageDrawable(this.f11390s.getResources().getDrawable(R.drawable.birthdaty_setting));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 5));
        this.f11384m.addView(imageView);
        m10914j();
        m10910h();
        return viewInflate;
    }

    /* renamed from: a */
    public void m10922a(Menu menu, MenuInflater menuInflater) {
    }

    /* renamed from: a */
    public boolean m10924a(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.f11390s.finish();
        }
        return true;
    }

    /* renamed from: g */
    private void m10907g() {
        if (!"".equals(this.f11376e)) {
            if ("FULL".equals(this.f11375d) || "FULL_HIDE".equals(this.f11375d)) {
                this.f11383l.setText(MyInfoFragment.m10678b(this.f11376e));
                return;
            }
            if ("SHORT".equals(this.f11375d) || "SHORT_HIDE".equals(this.f11375d)) {
                String[] strArrSplit = this.f11376e.split("-");
                this.f11383l.setText(MyInfoFragment.m10678b(strArrSplit[1] + "-" + strArrSplit[2]));
                return;
            } else {
                this.f11383l.setText(this.f11390s.getResources().getString(R.string.add_your_birthday));
                C3159aa.m10963a("birthday_show", (Boolean) false);
                this.f11380i.setChecked(false);
                return;
            }
        }
        this.f11383l.setText(this.f11390s.getResources().getString(R.string.add_your_birthday));
        C3159aa.m10963a("birthday_show", (Boolean) false);
        this.f11380i.setChecked(false);
    }

    /* renamed from: h */
    private void m10910h() {
        C3250y.m11456e("init", getClass().getSimpleName());
        this.f11375d = C3159aa.m10962a().m10979a("birthday_type", "");
        if ("".equals(this.f11375d)) {
            this.f11375d = "SHORT_HIDE";
        }
        this.f11376e = C3159aa.m10962a().m10979a("birthday", "");
        this.f11378g.setClickable(true);
        this.f11380i.setEnabled(true);
        if (this.f11376e.length() == 0) {
            this.f11378g.setClickable(false);
            this.f11380i.setEnabled(false);
        }
        if ("FULL".equals(this.f11375d) || "SHORT".equals(this.f11375d)) {
            C3159aa.m10963a("birthday_show", (Boolean) true);
            this.f11380i.setChecked(true);
        } else {
            C3159aa.m10963a("birthday_show", (Boolean) false);
            this.f11380i.setChecked(false);
        }
        if ("FULL".equals(this.f11375d) || "FULL_HIDE".equals(this.f11375d)) {
            C3159aa.m10963a("birthday_year_show", (Boolean) true);
        } else {
            C3159aa.m10963a("birthday_year_show", (Boolean) false);
        }
        m10907g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m10912i() throws NumberFormatException {
        int i = 1;
        int i2 = 0;
        int i3 = 2000;
        C3250y.m11450b("[editBirthDay] mBirthDay=" + this.f11376e, getClass().getSimpleName());
        if (this.f11376e != null && !"".equals(this.f11376e)) {
            String[] strArrSplit = this.f11376e.split("-");
            i3 = Integer.parseInt(strArrSplit[0]);
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i = Integer.parseInt(strArrSplit[2]);
        }
        m10919a(i3, i2, i);
    }

    /* renamed from: j */
    private void m10914j() {
        this.f11385n.setOnClickListener(new ViewOnClickListenerC3141j(this));
    }

    /* renamed from: a */
    protected void m10919a(int i, int i2, int i3) throws NumberFormatException {
        this.f11389r = new AlertDialogC3152u(this.f11390s, this.f11393v, i, i2, i3, this.f11375d);
        this.f11389r.m10941a(i, i2, i3);
        this.f11389r.show();
    }

    /* renamed from: b */
    public String m10925b() {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        C3250y.m11450b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    /* renamed from: c */
    public void m10926c() {
        if ("".equals(this.f11376e)) {
            this.f11376e = m10925b();
        }
        C3250y.m11450b("onClick::mBirthDay" + this.f11376e, getClass().getSimpleName());
        this.f11377f = MyInfoFragment.m10678b(this.f11376e);
        this.f11383l.setText(this.f11377f);
    }

    /* renamed from: d */
    public void m10927d() {
        if ("".equals(this.f11376e)) {
            this.f11376e = m10925b();
        }
        this.f11377f = MyInfoFragment.m10678b(this.f11376e.substring(5, 10));
        this.f11383l.setText(this.f11377f);
    }

    /* renamed from: e */
    public void m10928e() {
        C3250y.m11450b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    protected void m10923a(String str) {
        C3250y.m11450b("[sendBirthday] mBirthDay=" + this.f11376e, getClass().getSimpleName());
        C0276m c0276m = new C0276m();
        c0276m.m1372c(this.f11376e);
        this.f11387p.m5928a(c0276m, str);
        this.f11388q.show();
    }

    /* renamed from: f */
    public void m10929f() {
        if (this.f11388q.isShowing()) {
            this.f11388q.dismiss();
        }
        if (this.f11389r != null) {
            this.f11389r.dismiss();
        }
    }
}
