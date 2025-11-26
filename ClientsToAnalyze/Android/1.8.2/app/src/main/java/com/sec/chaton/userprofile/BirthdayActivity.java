package com.sec.chaton.userprofile;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.p015d.C0647s;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class BirthdayActivity extends BaseActivity {

    /* renamed from: a */
    SimpleDateFormat f5773a;

    /* renamed from: b */
    SimpleDateFormat f5774b;

    /* renamed from: c */
    Context f5775c;

    /* renamed from: i */
    private String f5778i;

    /* renamed from: j */
    private String f5779j;

    /* renamed from: k */
    private LinearLayout f5780k;

    /* renamed from: l */
    private TextView f5781l;

    /* renamed from: m */
    private SimpleDateFormat f5782m;

    /* renamed from: o */
    private C0647s f5784o;

    /* renamed from: p */
    private ProgressDialog f5785p;

    /* renamed from: q */
    private boolean f5786q;

    /* renamed from: r */
    private String f5787r;

    /* renamed from: s */
    private CheckBox f5788s;

    /* renamed from: t */
    private AlertDialogC1696f f5789t;

    /* renamed from: n */
    private Calendar f5783n = Calendar.getInstance();

    /* renamed from: d */
    boolean f5776d = false;

    /* renamed from: u */
    private boolean f5790u = false;

    /* renamed from: v */
    private TextWatcher f5791v = new C1622a(this);

    /* renamed from: w */
    private Handler f5792w = new HandlerC1650b(this);

    /* renamed from: e */
    CompoundButton.OnCheckedChangeListener f5777e = new C1694d(this);

    /* renamed from: x */
    private InterfaceC1698h f5793x = new C1695e(this);

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_setting_birthday);
        this.f5775c = this;
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(798, 738);
        }
        this.f5780k = (LinearLayout) findViewById(R.id.llayoutBDay);
        this.f5781l = (TextView) findViewById(R.id.dateDisplay);
        this.f5773a = new SimpleDateFormat("yyyy-MM-dd");
        this.f5774b = new SimpleDateFormat("MM-dd");
        this.f5782m = new SimpleDateFormat("MM-dd");
        this.f5785p = (ProgressDialog) new C1805i(this.f5775c).m6139a(R.string.dialog_userprofile_updating);
        C1786r.m6066e("mOption : " + this.f5778i, getClass().getSimpleName());
        this.f5788s = (CheckBox) findViewById(R.id.birthday_check);
        this.f5788s.setChecked(C1789u.m6075a().getBoolean("birthday_show", false));
        C1786r.m6066e("setChecked : " + C1789u.m6075a().getBoolean("birthday_show", false), getClass().getSimpleName());
        this.f5788s.setOnCheckedChangeListener(this.f5777e);
        this.f5790u = C1789u.m6075a().getBoolean("birthday_year_show", false);
        m5552h();
        m5545e();
    }

    /* renamed from: d */
    private void m5544d() {
        new Date();
        if ("FULL".equals(this.f5778i)) {
            try {
                this.f5773a.parse(this.f5779j);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.f5781l.setText(MyPageFragment.m5579a(this.f5779j));
            return;
        }
        if ("SHORT".equals(this.f5778i)) {
            String[] strArrSplit = this.f5779j.split("-");
            String str = strArrSplit[1] + "-" + strArrSplit[2];
            try {
                this.f5782m.parse(str);
            } catch (ParseException e2) {
                C1786r.m6056a(e2, getClass().getSimpleName());
            }
            this.f5781l.setText(MyPageFragment.m5579a(str));
            return;
        }
        if ("DONT".equals(this.f5778i)) {
            if (this.f5779j != null && !"".equals(this.f5779j)) {
                if (!this.f5779j.startsWith("0000")) {
                    if (C1789u.m6075a().getBoolean("birthday_year_show", false)) {
                        this.f5781l.setText(MyPageFragment.m5579a(this.f5779j));
                        return;
                    }
                    String[] strArrSplit2 = this.f5779j.split("-");
                    this.f5781l.setText(MyPageFragment.m5579a(strArrSplit2[1] + "-" + strArrSplit2[2]));
                    return;
                }
                this.f5781l.setText(getResources().getString(R.string.add_your_birthday));
                return;
            }
            this.f5781l.setText(getResources().getString(R.string.add_your_birthday));
            return;
        }
        this.f5781l.setText(getResources().getString(R.string.add_your_birthday));
        C1789u.m6076a("birthday_show", (Boolean) false);
        this.f5788s.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m5545e() {
        C1786r.m6066e("init", getClass().getSimpleName());
        this.f5784o = new C0647s(this.f5792w);
        this.f5778i = C1789u.m6075a().getString("birthday_type", "");
        this.f5779j = C1789u.m6075a().getString("birthday", "");
        m5548f();
        m5544d();
    }

    /* renamed from: f */
    private void m5548f() {
        if ("FULL".equals(this.f5778i)) {
            this.f5781l.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
            return;
        }
        if ("SHORT".equals(this.f5778i)) {
            this.f5781l.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
        } else if ("DONT".equals(this.f5778i)) {
            this.f5781l.setTextColor(Color.parseColor("#9A9A9A"));
        } else {
            this.f5781l.setTextColor(Color.parseColor("#9A9A9A"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m5549g() throws NumberFormatException {
        int i = Calendar.getInstance().get(1);
        int i2 = Calendar.getInstance().get(2);
        int i3 = Calendar.getInstance().get(5);
        C1786r.m6061b("[editBirthDay] mBirthDay=" + this.f5779j, getClass().getSimpleName());
        if (this.f5779j != null && !"".equals(this.f5779j)) {
            String[] strArrSplit = this.f5779j.split("-");
            i = Integer.parseInt(strArrSplit[0]);
            i2 = Integer.parseInt(strArrSplit[1]) - 1;
            i3 = Integer.parseInt(strArrSplit[2]);
        }
        if ("FULL".equals(this.f5778i)) {
            this.f5786q = true;
            m5556a(i, i2, i3, 0);
        } else if ("SHORT".equals(this.f5778i)) {
            this.f5786q = true;
            m5556a(i, i2, i3, 1);
        } else {
            m5556a(i, i2, i3, 0);
        }
    }

    /* renamed from: h */
    private void m5552h() {
        this.f5780k.setOnClickListener(new ViewOnClickListenerC1677c(this));
    }

    /* renamed from: a */
    protected void m5556a(int i, int i2, int i3, int i4) {
        this.f5789t = null;
        boolean z = C1789u.m6075a().getBoolean("birthday_year_show", false);
        if (z && this.f5778i.equals("SHORT")) {
            C1789u.m6076a("birthday_year_show", (Boolean) false);
        } else if (!z && this.f5778i.equals("FULL")) {
            C1789u.m6076a("birthday_year_show", (Boolean) true);
        }
        switch (i4) {
            case 0:
                this.f5789t = new AlertDialogC1696f(this.f5775c, this.f5793x, i, i2, i3);
                break;
            case 1:
                this.f5789t = new AlertDialogC1696f(this.f5775c, this.f5793x, i, i2, i3);
                break;
        }
        if (this.f5789t != null) {
            this.f5789t.m5810a(i, i2, i3);
            this.f5789t.show();
        }
    }

    /* renamed from: a */
    public String m5555a() {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        C1786r.m6061b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    /* renamed from: b */
    public void m5558b() {
        this.f5778i = "FULL";
        if ("".equals(this.f5779j)) {
            this.f5779j = m5555a();
        }
        C1786r.m6061b("onClick::mBirthDay" + this.f5779j, getClass().getSimpleName());
        this.f5787r = MyPageFragment.m5579a(this.f5779j);
        this.f5781l.setText(this.f5787r);
        this.f5781l.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }

    /* renamed from: c */
    public void m5559c() {
        this.f5778i = "SHORT";
        if ("".equals(this.f5779j)) {
            this.f5779j = m5555a();
        }
        this.f5787r = MyPageFragment.m5579a(this.f5779j.substring(5, 10));
        this.f5781l.setText(this.f5787r);
        this.f5781l.setTextColor(getApplicationContext().getResources().getColor(R.color.blue_color_021));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1786r.m6061b("onResume", getClass().getSimpleName());
    }

    /* renamed from: a */
    protected void m5557a(String str) {
        C1786r.m6061b("[sendBirthday] mBirthDay=" + this.f5779j, getClass().getSimpleName());
        String string = C1789u.m6075a().getString("birthday_type", "");
        String string2 = C1789u.m6075a().getString("birthday", "");
        boolean z = C1789u.m6075a().getBoolean("birthday_year_show", false);
        if (string.equals(str) && string2.equals(this.f5779j) && z == this.f5790u) {
            finish();
            return;
        }
        if ("FULL".equals(str)) {
            this.f5786q = true;
            C0107h c0107h = new C0107h();
            c0107h.m687c(this.f5779j);
            this.f5784o.m2963a(c0107h, "FULL");
            this.f5785p.show();
            return;
        }
        if ("SHORT".equals(str)) {
            this.f5786q = true;
            C0107h c0107h2 = new C0107h();
            c0107h2.m687c(this.f5779j);
            this.f5784o.m2963a(c0107h2, "SHORT");
            this.f5785p.show();
            return;
        }
        this.f5786q = false;
        C0107h c0107h3 = new C0107h();
        c0107h3.m687c(this.f5779j);
        this.f5784o.m2963a(c0107h3, "DONT");
        this.f5785p.show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f5785p.isShowing()) {
            this.f5785p.dismiss();
        }
        if (this.f5789t != null) {
            this.f5789t.dismiss();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionbar_title_done_cancel_next, menu);
        menu.removeItem(R.id.actionbar_title_next);
        if (this.f5776d) {
            menu.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
            menu.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
        }
        return true;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_cancel /* 2131494128 */:
                finish();
                return true;
            case R.id.actionbar_title_change /* 2131494129 */:
            default:
                return super.onOptionsItemSelected(menuItem);
            case R.id.actionbar_title_done /* 2131494130 */:
                if (this.f5788s.isChecked()) {
                    m5557a(this.f5778i);
                } else {
                    m5557a("DONT");
                }
                setResult(-1);
                return true;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
