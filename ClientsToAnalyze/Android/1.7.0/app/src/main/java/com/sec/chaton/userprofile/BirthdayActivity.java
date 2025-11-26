package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p013a.C0226y;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.GeneralHeaderView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class BirthdayActivity extends BaseActivity {

    /* renamed from: a */
    SimpleDateFormat f4081a;

    /* renamed from: b */
    SimpleDateFormat f4082b;

    /* renamed from: c */
    Context f4083c;

    /* renamed from: e */
    private String f4085e;

    /* renamed from: f */
    private String f4086f;

    /* renamed from: g */
    private LinearLayout f4087g;

    /* renamed from: i */
    private TextView f4088i;

    /* renamed from: j */
    private SimpleDateFormat f4089j;

    /* renamed from: l */
    private C0226y f4091l;

    /* renamed from: m */
    private ProgressDialog f4092m;

    /* renamed from: n */
    private boolean f4093n;

    /* renamed from: o */
    private String f4094o;

    /* renamed from: p */
    private CheckBox f4095p;

    /* renamed from: q */
    private AlertDialogC1249bs f4096q;

    /* renamed from: r */
    private RelativeLayout f4097r;

    /* renamed from: s */
    private GeneralHeaderView f4098s;

    /* renamed from: k */
    private Calendar f4090k = Calendar.getInstance();

    /* renamed from: t */
    private View.OnClickListener f4099t = new ViewOnClickListenerC1265o(this);

    /* renamed from: u */
    private Handler f4100u = new HandlerC1262l(this);

    /* renamed from: d */
    CompoundButton.OnCheckedChangeListener f4084d = new C1260j(this);

    /* renamed from: v */
    private InterfaceC1250bt f4101v = new C1261k(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_setting_birthday);
        this.f4083c = this;
        this.f4087g = (LinearLayout) findViewById(R.id.llayoutBDay);
        this.f4088i = (TextView) findViewById(R.id.dateDisplay);
        this.f4081a = new SimpleDateFormat("yyyy-MM-dd");
        this.f4082b = new SimpleDateFormat("MM-dd");
        this.f4089j = new SimpleDateFormat("MM-dd");
        this.f4092m = (ProgressDialog) new C1356c(this.f4083c).m4728a(R.string.dialog_userprofile_updating);
        this.f4098s = (GeneralHeaderView) findViewById(R.id.birthday_headerView);
        this.f4098s.setButtonClickListener(new ViewOnClickListenerC1264n(this));
        C1341p.m4662e("mOption : " + this.f4085e, getClass().getSimpleName());
        this.f4095p = (CheckBox) findViewById(R.id.birthday_check);
        this.f4095p.setChecked(C1323bs.m4575a().getBoolean("birthday_show", false));
        C1341p.m4662e("setChecked : " + C1323bs.m4575a().getBoolean("birthday_show", false), getClass().getSimpleName());
        this.f4095p.setOnCheckedChangeListener(this.f4084d);
        this.f4095p.setClickable(false);
        this.f4097r = (RelativeLayout) findViewById(R.id.birthday_check_layout);
        this.f4097r.setOnClickListener(this.f4099t);
        m4278h();
        m4272e();
    }

    /* renamed from: d */
    private void m4269d() {
        new Date();
        if ("FULL".equals(this.f4085e)) {
            try {
                this.f4081a.parse(this.f4086f);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.f4088i.setText(MyPageFragment.m4289a(this.f4086f));
            return;
        }
        if ("SHORT".equals(this.f4085e)) {
            String[] strArrSplit = this.f4086f.split("-");
            String str = strArrSplit[1] + "-" + strArrSplit[2];
            try {
                this.f4089j.parse(str);
            } catch (ParseException e2) {
                C1341p.m4653a(e2, getClass().getSimpleName());
            }
            this.f4088i.setText(MyPageFragment.m4289a(str));
            return;
        }
        if ("DONT".equals(this.f4085e)) {
            if (this.f4086f != null && !"".equals(this.f4086f)) {
                if (C1323bs.m4575a().getBoolean("birthday_year_show", false)) {
                    this.f4088i.setText(MyPageFragment.m4289a(this.f4086f));
                    return;
                }
                String[] strArrSplit2 = this.f4086f.split("-");
                String str2 = strArrSplit2[1] + "-" + strArrSplit2[2];
                try {
                    this.f4089j.parse(str2);
                } catch (ParseException e3) {
                    C1341p.m4653a(e3, getClass().getSimpleName());
                }
                this.f4088i.setText(MyPageFragment.m4289a(str2));
                return;
            }
            this.f4088i.setText(getResources().getString(R.string.add_your_birthday));
            return;
        }
        this.f4088i.setText(getResources().getString(R.string.add_your_birthday));
        C1323bs.m4576a("birthday_show", (Boolean) false);
        this.f4095p.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4272e() {
        C1341p.m4662e("init", getClass().getSimpleName());
        this.f4091l = new C0226y(this.f4100u);
        this.f4085e = C1323bs.m4575a().getString("birthday_type", "");
        this.f4086f = C1323bs.m4575a().getString("birthday", "");
        m4274f();
        m4269d();
    }

    /* renamed from: f */
    private void m4274f() {
        if ("FULL".equals(this.f4085e)) {
            this.f4088i.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
            return;
        }
        if ("SHORT".equals(this.f4085e)) {
            this.f4088i.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
        } else if ("DONT".equals(this.f4085e)) {
            this.f4088i.setTextColor(Color.parseColor("#9A9A9A"));
        } else {
            this.f4088i.setTextColor(Color.parseColor("#9A9A9A"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4275g() throws NumberFormatException {
        int i;
        int i2;
        int i3;
        C1341p.m4658b("[editBirthDay] mBirthDay=" + this.f4086f, getClass().getSimpleName());
        if (this.f4086f == null || "".equals(this.f4086f)) {
            i = 0;
            i2 = 2000;
            i3 = 1;
        } else {
            String[] strArrSplit = this.f4086f.split("-");
            i2 = Integer.parseInt(strArrSplit[0]);
            i = Integer.parseInt(strArrSplit[1]) - 1;
            i3 = Integer.parseInt(strArrSplit[2]);
        }
        if ("FULL".equals(this.f4085e)) {
            this.f4093n = true;
            m4283a(i2, i, i3, 0);
        } else if ("SHORT".equals(this.f4085e)) {
            this.f4093n = true;
            m4283a(i2, i, i3, 1);
        }
    }

    /* renamed from: h */
    private void m4278h() {
        this.f4087g.setOnClickListener(new ViewOnClickListenerC1263m(this));
    }

    /* renamed from: a */
    protected void m4283a(int i, int i2, int i3, int i4) {
        this.f4096q = null;
        switch (i4) {
            case 0:
                this.f4096q = new AlertDialogC1249bs(this.f4083c, this.f4101v, i, i2, i3);
                break;
            case 1:
                this.f4096q = new AlertDialogC1249bs(this.f4083c, this.f4101v, i, i2, i3);
                break;
        }
        if (this.f4096q != null) {
            this.f4096q.m4425a(i, i2, i3);
            this.f4096q.show();
        }
    }

    /* renamed from: a */
    public String m4282a() {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        C1341p.m4658b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    /* renamed from: b */
    public void m4285b() {
        this.f4085e = "FULL";
        if ("".equals(this.f4086f)) {
            this.f4086f = m4282a();
        }
        C1341p.m4658b("onClick::mBirthDay" + this.f4086f, getClass().getSimpleName());
        this.f4094o = MyPageFragment.m4289a(this.f4086f);
        this.f4088i.setText(this.f4094o);
        this.f4088i.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }

    /* renamed from: c */
    public void m4286c() {
        this.f4085e = "SHORT";
        if ("".equals(this.f4086f)) {
            this.f4086f = m4282a();
        }
        this.f4094o = MyPageFragment.m4289a(this.f4086f.substring(5, 10));
        this.f4088i.setText(this.f4094o);
        this.f4088i.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4658b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    protected void m4284a(String str) {
        C1341p.m4658b("[sendBirthday] mBirthDay=" + this.f4086f, getClass().getSimpleName());
        String string = C1323bs.m4575a().getString("birthday_type", "");
        String string2 = C1323bs.m4575a().getString("birthday", "");
        if (string.equals(str) && string2.equals(this.f4086f)) {
            finish();
            return;
        }
        if ("FULL".equals(str)) {
            this.f4093n = true;
            C0260h c0260h = new C0260h();
            c0260h.m943c(this.f4086f);
            this.f4091l.m873a(c0260h, "FULL");
            this.f4092m.show();
            return;
        }
        if ("SHORT".equals(str)) {
            this.f4093n = true;
            C0260h c0260h2 = new C0260h();
            c0260h2.m943c(this.f4086f);
            this.f4091l.m873a(c0260h2, "SHORT");
            this.f4092m.show();
            return;
        }
        this.f4093n = false;
        C0260h c0260h3 = new C0260h();
        c0260h3.m943c(this.f4086f);
        this.f4091l.m873a(c0260h3, "DONT");
        this.f4092m.show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f4092m.isShowing()) {
            this.f4092m.dismiss();
        }
        if (this.f4096q != null) {
            this.f4096q.dismiss();
        }
        super.onDestroy();
    }
}
