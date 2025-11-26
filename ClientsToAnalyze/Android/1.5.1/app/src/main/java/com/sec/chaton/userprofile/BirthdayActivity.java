package com.sec.chaton.userprofile;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.common.entry.UserProfileEntry;
import com.sec.chaton.control.ProfileControl;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.widget.SMSProgressBar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class BirthdayActivity extends BaseActivity {

    /* renamed from: i */
    private static String f3314i;

    /* renamed from: a */
    SimpleDateFormat f3315a;

    /* renamed from: b */
    SimpleDateFormat f3316b;

    /* renamed from: c */
    Context f3317c;

    /* renamed from: e */
    private RadioButton f3319e;

    /* renamed from: f */
    private RadioButton f3320f;

    /* renamed from: g */
    private RadioButton f3321g;

    /* renamed from: h */
    private String f3322h;

    /* renamed from: j */
    private ImageButton f3323j;

    /* renamed from: k */
    private LinearLayout f3324k;

    /* renamed from: l */
    private TextView f3325l;

    /* renamed from: m */
    private SimpleDateFormat f3326m;

    /* renamed from: o */
    private ProfileControl f3328o;

    /* renamed from: p */
    private ProgressDialog f3329p;

    /* renamed from: q */
    private boolean f3330q;

    /* renamed from: r */
    private String f3331r;

    /* renamed from: s */
    private Button f3332s;

    /* renamed from: t */
    private Button f3333t;

    /* renamed from: n */
    private Calendar f3327n = Calendar.getInstance();

    /* renamed from: u */
    private Handler f3334u = new HandlerC0583g(this);

    /* renamed from: v */
    private DatePickerDialog.OnDateSetListener f3335v = new C0579c(this);

    /* renamed from: d */
    View.OnClickListener f3318d = new ViewOnClickListenerC0582f(this);

    /* renamed from: c */
    private void m3305c() {
        new Date();
        if (this.f3322h.equals("FULL")) {
            try {
                this.f3315a.parse(f3314i);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.f3325l.setText(UserProfileDetail.m3354a(f3314i));
            return;
        }
        if (this.f3322h.equals("SHORT")) {
            String[] strArrSplit = f3314i.split("-");
            String str = strArrSplit[1] + "-" + strArrSplit[2];
            try {
                this.f3326m.parse(str);
            } catch (ParseException e2) {
                ChatONLogWriter.m3501a(e2, getClass().getSimpleName());
            }
            this.f3325l.setText(UserProfileDetail.m3354a(str));
            return;
        }
        if (!this.f3322h.equals("DONT")) {
            this.f3325l.setText(getResources().getString(C0062R.string.add_your_birthday));
            return;
        }
        if (f3314i == null || f3314i.equals("")) {
            this.f3325l.setText(getResources().getString(C0062R.string.add_your_birthday));
        } else {
            if (f3314i.startsWith("0000")) {
                return;
            }
            this.f3325l.setText(UserProfileDetail.m3354a(f3314i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3307d() {
        this.f3328o = new ProfileControl(this.f3334u);
        this.f3322h = ChatONPref.m3519a().getString("birthday_type", "");
        f3314i = ChatONPref.m3519a().getString("birthday", "");
        m3309e();
        m3305c();
    }

    /* renamed from: e */
    private void m3309e() {
        if (this.f3322h.equals("FULL")) {
            this.f3319e.setChecked(true);
            this.f3320f.setChecked(false);
            this.f3321g.setChecked(false);
            this.f3323j.setClickable(true);
            this.f3325l.setTextColor(getApplicationContext().getResources().getColor(C0062R.color.blue_color_021));
            return;
        }
        if (this.f3322h.equals("SHORT")) {
            this.f3319e.setChecked(false);
            this.f3320f.setChecked(true);
            this.f3321g.setChecked(false);
            this.f3323j.setClickable(true);
            this.f3325l.setTextColor(getApplicationContext().getResources().getColor(C0062R.color.blue_color_021));
            return;
        }
        if (this.f3322h.equals("DONT")) {
            this.f3319e.setChecked(false);
            this.f3320f.setChecked(false);
            this.f3321g.setChecked(true);
            this.f3323j.setClickable(false);
            this.f3325l.setTextColor(Color.parseColor("#9A9A9A"));
            return;
        }
        this.f3319e.setChecked(false);
        this.f3320f.setChecked(false);
        this.f3321g.setChecked(true);
        this.f3323j.setClickable(false);
        this.f3325l.setTextColor(Color.parseColor("#9A9A9A"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3310f() throws NumberFormatException {
        int i;
        int i2;
        int i3 = Calendar.getInstance().get(1);
        int i4 = Calendar.getInstance().get(2);
        int i5 = Calendar.getInstance().get(5);
        if (f3314i == null || f3314i.equals("")) {
            i = i3;
            i2 = i5;
        } else {
            String[] strArrSplit = f3314i.split("-");
            int i6 = Integer.parseInt(strArrSplit[0]);
            int i7 = Integer.parseInt(strArrSplit[1]) - 1;
            i2 = Integer.parseInt(strArrSplit[2]);
            i = i6;
            i4 = i7;
        }
        if (this.f3322h.equals("FULL")) {
            this.f3330q = true;
            m3320a(i, i4, i2, 0);
        } else if (!this.f3322h.equals("SHORT")) {
            if (this.f3322h.equals("DONT")) {
            }
        } else {
            this.f3330q = true;
            m3320a(i, i4, i2, 1);
        }
    }

    /* renamed from: g */
    private void m3312g() {
        this.f3319e.setOnClickListener(this.f3318d);
        this.f3320f.setOnClickListener(this.f3318d);
        this.f3321g.setOnClickListener(this.f3318d);
        this.f3323j.setOnClickListener(new ViewOnClickListenerC0584h(this));
        this.f3324k.setOnClickListener(new ViewOnClickListenerC0580d(this));
        this.f3332s.setOnClickListener(new ViewOnClickListenerC0581e(this));
        this.f3333t.setOnClickListener(new ViewOnClickListenerC0573b(this));
    }

    /* renamed from: a */
    public String m3319a() {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        ChatONLogWriter.m3506b("toDay=" + str, getClass().getSimpleName());
        return str;
    }

    /* renamed from: a */
    protected void m3320a(int i, int i2, int i3, int i4) {
        android.app.DatePickerDialog datePickerDialog = null;
        switch (i4) {
            case 0:
                datePickerDialog = new android.app.DatePickerDialog(this.f3317c, this.f3335v, i, i2, i3);
                break;
            case 1:
                datePickerDialog = new android.app.DatePickerDialog(this.f3317c, this.f3335v, i, i2, i3);
                break;
        }
        if (datePickerDialog != null) {
            datePickerDialog.updateDate(i, i2, i3);
            datePickerDialog.show();
        }
    }

    /* renamed from: a */
    protected void m3321a(String str) {
        ChatONLogWriter.m3506b("mBirthDay=" + f3314i, getClass().getSimpleName());
        if (str.equals("FULL")) {
            this.f3330q = true;
            UserProfileEntry userProfileEntry = new UserProfileEntry();
            userProfileEntry.m1969c(f3314i);
            this.f3328o.m2065a(userProfileEntry, "FULL");
            this.f3329p.show();
            return;
        }
        if (str.equals("SHORT")) {
            this.f3330q = true;
            UserProfileEntry userProfileEntry2 = new UserProfileEntry();
            userProfileEntry2.m1969c(f3314i);
            this.f3328o.m2065a(userProfileEntry2, "SHORT");
            this.f3329p.show();
            return;
        }
        this.f3330q = false;
        UserProfileEntry userProfileEntry3 = new UserProfileEntry();
        userProfileEntry3.m1969c(f3314i);
        this.f3328o.m2065a(userProfileEntry3, "DONT");
        this.f3329p.show();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0062R.layout.layout_setting_birthday);
        this.f3317c = this;
        this.f3319e = (RadioButton) findViewById(C0062R.id.full_date_type);
        this.f3320f = (RadioButton) findViewById(C0062R.id.short_date_type);
        this.f3321g = (RadioButton) findViewById(C0062R.id.dont_show_type);
        this.f3323j = (ImageButton) findViewById(C0062R.id.birthday_more);
        this.f3324k = (LinearLayout) findViewById(C0062R.id.llayoutBDay);
        this.f3325l = (TextView) findViewById(C0062R.id.dateDisplay);
        this.f3315a = new SimpleDateFormat("yyyy-MM-dd");
        this.f3316b = new SimpleDateFormat("MM-dd");
        this.f3326m = new SimpleDateFormat("MM-dd");
        this.f3329p = (ProgressDialog) new SMSProgressBar(this.f3317c).onCreate(C0062R.string.dialog_userprofile_updating);
        this.f3332s = (Button) findViewById(C0062R.id.btnSave);
        this.f3333t = (Button) findViewById(C0062R.id.btnCancel);
        m3312g();
        m3307d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3506b("onResume", getClass().getSimpleName());
    }
}
