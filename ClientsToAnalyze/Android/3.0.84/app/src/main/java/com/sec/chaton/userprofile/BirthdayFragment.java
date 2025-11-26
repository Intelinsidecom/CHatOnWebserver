package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
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
import com.sec.chaton.p016a.p017a.C0276m;
import com.sec.chaton.p025d.C1345w;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class BirthdayFragment extends Fragment {

    /* renamed from: a */
    SimpleDateFormat f11025a;

    /* renamed from: b */
    SimpleDateFormat f11026b;

    /* renamed from: d */
    private String f11028d;

    /* renamed from: e */
    private String f11029e;

    /* renamed from: f */
    private String f11030f;

    /* renamed from: g */
    private RelativeLayout f11031g;

    /* renamed from: h */
    private View f11032h;

    /* renamed from: i */
    private CheckBox f11033i;

    /* renamed from: j */
    private View f11034j;

    /* renamed from: l */
    private C1345w f11036l;

    /* renamed from: m */
    private ProgressDialog f11037m;

    /* renamed from: n */
    private AlertDialogC3152u f11038n;

    /* renamed from: o */
    private View f11039o;

    /* renamed from: p */
    private TextView f11040p;

    /* renamed from: q */
    private FrameLayout f11041q;

    /* renamed from: r */
    private LinearLayout f11042r;

    /* renamed from: k */
    private Calendar f11035k = Calendar.getInstance();

    /* renamed from: s */
    private View.OnClickListener f11043s = new ViewOnClickListenerC3074a(this);

    /* renamed from: t */
    private Handler f11044t = new HandlerC3101b(this);

    /* renamed from: c */
    CompoundButton.OnCheckedChangeListener f11027c = new C3135d(this);

    /* renamed from: u */
    private InterfaceC3155x f11045u = new C3136e(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_birthday, viewGroup, false);
        this.f11031g = (RelativeLayout) viewInflate.findViewById(R.id.rlayout_setting_birthday_checkbox);
        this.f11032h = viewInflate.findViewById(R.id.setting_birthday_description);
        TextView textView = (TextView) this.f11032h.findViewById(R.id.text1);
        textView.setSingleLine(false);
        TextView textView2 = (TextView) this.f11032h.findViewById(R.id.text2);
        textView.setText(R.string.show_birthday);
        textView2.setText(R.string.birthday_open_birthday);
        textView2.setSingleLine(false);
        this.f11042r = (LinearLayout) viewInflate.findViewById(R.id.setting_birthday_text_layout);
        this.f11039o = viewInflate.findViewById(R.id.setting_birthday_text);
        this.f11040p = (TextView) this.f11039o.findViewById(R.id.text1);
        this.f11041q = (FrameLayout) this.f11039o.findViewById(R.id.space2);
        this.f11041q.setVisibility(0);
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.birthdaty_setting));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 5));
        this.f11041q.addView(imageView);
        this.f11033i = (CheckBox) viewInflate.findViewById(R.id.setting_birthday_checkbox);
        this.f11033i.setChecked(C3159aa.m10962a().m10977a("birthday_show", (Boolean) true).booleanValue());
        C3250y.m11456e("setChecked : " + C3159aa.m10962a().m10977a("birthday_show", (Boolean) true), getClass().getSimpleName());
        this.f11033i.setOnCheckedChangeListener(this.f11027c);
        this.f11033i.setClickable(false);
        this.f11031g.setOnClickListener(this.f11043s);
        this.f11034j = viewInflate.findViewById(R.id.setting_birthday_subtitle);
        ((TextView) this.f11034j.findViewById(R.id.text1)).setText(getString(R.string.birthday_settings));
        this.f11025a = new SimpleDateFormat("yyyy-MM-dd");
        this.f11026b = new SimpleDateFormat("MM-dd");
        this.f11036l = new C1345w(this.f11044t);
        this.f11037m = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_userprofile_updating);
        C3250y.m11456e("mOption : " + this.f11028d, getClass().getSimpleName());
        m10640g();
        m10636e();
        BaseActivity.m3081a(this, true);
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
    private void m10634d() {
        if (!"".equals(this.f11029e)) {
            if ("FULL".equals(this.f11028d) || "FULL_HIDE".equals(this.f11028d)) {
                this.f11040p.setText(MyInfoFragment.m10678b(this.f11029e));
                return;
            }
            if ("SHORT".equals(this.f11028d) || "SHORT_HIDE".equals(this.f11028d)) {
                String[] strArrSplit = this.f11029e.split("-");
                this.f11040p.setText(MyInfoFragment.m10678b(strArrSplit[1] + "-" + strArrSplit[2]));
                return;
            } else {
                this.f11040p.setText(getResources().getString(R.string.add_your_birthday));
                C3159aa.m10963a("birthday_show", (Boolean) true);
                this.f11033i.setChecked(true);
                return;
            }
        }
        this.f11040p.setText(getResources().getString(R.string.add_your_birthday));
        C3159aa.m10963a("birthday_show", (Boolean) true);
        this.f11033i.setChecked(true);
    }

    /* renamed from: e */
    private void m10636e() {
        C3250y.m11456e("init", getClass().getSimpleName());
        this.f11028d = C3159aa.m10962a().m10979a("birthday_type", "");
        if ("".equals(this.f11028d)) {
            this.f11028d = "SHORT";
        }
        this.f11029e = C3159aa.m10962a().m10979a("birthday", "");
        this.f11031g.setClickable(true);
        this.f11033i.setEnabled(true);
        if (this.f11029e.length() == 0) {
            this.f11031g.setClickable(false);
            this.f11033i.setEnabled(false);
        }
        if ("FULL".equals(this.f11028d) || "SHORT".equals(this.f11028d)) {
            C3159aa.m10963a("birthday_show", (Boolean) true);
            this.f11033i.setChecked(true);
        } else {
            C3159aa.m10963a("birthday_show", (Boolean) false);
            this.f11033i.setChecked(false);
        }
        if ("FULL".equals(this.f11028d) || "FULL_HIDE".equals(this.f11028d)) {
            C3159aa.m10963a("birthday_year_show", (Boolean) true);
        } else {
            C3159aa.m10963a("birthday_year_show", (Boolean) false);
        }
        m10634d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m10637f() throws NumberFormatException {
        int i = 1;
        int i2 = 0;
        int i3 = 2000;
        C3250y.m11450b("[editBirthDay] mBirthDay=" + this.f11029e, getClass().getSimpleName());
        if (this.f11029e != null && !"".equals(this.f11029e)) {
            String[] strArrSplit = this.f11029e.split("-");
            i3 = Integer.parseInt(strArrSplit[0]);
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i = Integer.parseInt(strArrSplit[2]);
        }
        m10646a(i3, i2, i);
    }

    /* renamed from: g */
    private void m10640g() {
        this.f11042r.setOnClickListener(new ViewOnClickListenerC3128c(this));
    }

    /* renamed from: a */
    protected void m10646a(int i, int i2, int i3) throws NumberFormatException {
        this.f11038n = new AlertDialogC3152u(getActivity(), this.f11045u, i, i2, i3, this.f11028d);
        this.f11038n.m10941a(i, i2, i3);
        this.f11038n.show();
    }

    /* renamed from: a */
    public String m10645a() {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        C3250y.m11450b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    /* renamed from: b */
    public void m10648b() {
        if ("".equals(this.f11029e)) {
            this.f11029e = m10645a();
        }
        C3250y.m11450b("onClick::mBirthDay" + this.f11029e, getClass().getSimpleName());
        this.f11030f = MyInfoFragment.m10678b(this.f11029e);
        this.f11040p.setText(this.f11030f);
    }

    /* renamed from: c */
    public void m10649c() {
        if ("".equals(this.f11029e)) {
            this.f11029e = m10645a();
        }
        this.f11030f = MyInfoFragment.m10678b(this.f11029e.substring(5, 10));
        this.f11040p.setText(this.f11030f);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C3250y.m11450b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    protected void m10647a(String str) {
        C3250y.m11450b("[sendBirthday] mBirthDay=" + this.f11029e, getClass().getSimpleName());
        if (this.f11029e != null && this.f11029e.length() > 0) {
            C0276m c0276m = new C0276m();
            c0276m.m1372c(this.f11029e);
            this.f11036l.m5928a(c0276m, str);
            this.f11037m.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f11037m.isShowing()) {
            this.f11037m.dismiss();
        }
        if (this.f11038n != null) {
            this.f11038n.dismiss();
        }
        super.onDestroy();
    }
}
