package com.sec.chaton.settings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class FreeSmsInfoPreference extends Preference {

    /* renamed from: a */
    ProgressBar f12780a;

    /* renamed from: b */
    ProgressBar f12781b;

    /* renamed from: c */
    TextView f12782c;

    /* renamed from: d */
    TextView f12783d;

    /* renamed from: e */
    TextView f12784e;

    /* renamed from: f */
    TextView f12785f;

    /* renamed from: g */
    TextView f12786g;

    /* renamed from: h */
    Button f12787h;

    /* renamed from: i */
    private final Activity f12788i;

    /* renamed from: j */
    private int f12789j;

    /* renamed from: k */
    private int f12790k;

    /* renamed from: l */
    private int f12791l;

    /* renamed from: m */
    private final SharedPreferences f12792m;

    /* renamed from: n */
    private SharedPreferencesOnSharedPreferenceChangeListenerC3625fh f12793n;

    /* renamed from: o */
    private int f12794o;

    public FreeSmsInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12788i = (Activity) context;
        setLayoutResource(R.layout.layout_pref_freesms_info);
        this.f12792m = CommonApplication.m18732r().getSharedPreferences("ChatON", 0);
        this.f12793n = new SharedPreferencesOnSharedPreferenceChangeListenerC3625fh(this, null);
        this.f12792m.registerOnSharedPreferenceChangeListener(this.f12793n);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        this.f12780a = (ProgressBar) view.findViewById(R.id.remain_progress);
        this.f12781b = (ProgressBar) view.findViewById(R.id.invite_progress);
        this.f12786g = (TextView) view.findViewById(R.id.invite_description);
        int iIntValue = C4809aa.m18104a().m18120a("free_sms_reward_base", (Integer) 20).intValue();
        this.f12786g.setText(this.f12788i.getString(R.string.freesms_invite_description, new Object[]{Integer.valueOf(iIntValue - (C4809aa.m18104a().m18120a("free_sms_invitation_count", (Integer) 0).intValue() % iIntValue)), Integer.valueOf(C4809aa.m18104a().m18120a("free_sms_reward_per_base", (Integer) 50).intValue())}));
        this.f12782c = (TextView) view.findViewById(R.id.remain_count);
        this.f12783d = (TextView) view.findViewById(R.id.invite_count);
        this.f12784e = (TextView) view.findViewById(R.id.sending_international);
        String strM18243k = C4822an.m18243k();
        if (strM18243k != null && strM18243k.equals("404")) {
            this.f12785f = (TextView) view.findViewById(R.id.india_alert);
            this.f12785f.setText(GlobalApplication.m18732r().getResources().getString(R.string.freesms_dnd_alert, 9, 9));
            this.f12785f.setVisibility(0);
        }
        this.f12787h = (Button) view.findViewById(R.id.send_invitation);
        m13645b();
    }

    /* renamed from: b */
    private void m13645b() {
        this.f12789j = C4809aa.m18104a().m18120a("free_sms_remain_count", (Integer) 200).intValue();
        this.f12790k = C4809aa.m18104a().m18120a("free_sms_max_count", (Integer) 200).intValue();
        this.f12791l = C4809aa.m18104a().m18120a("free_sms_invitation_count", (Integer) 0).intValue();
        this.f12794o = C4809aa.m18104a().m18120a("free_sms_international_deduct_count", (Integer) 20).intValue();
        try {
            if (this.f12780a != null) {
                this.f12780a.setProgress(((int) ((this.f12789j / this.f12790k) * 100.0f)) % 101);
            }
            if (this.f12782c != null) {
                this.f12782c.setText("" + this.f12789j + "/" + this.f12790k);
            }
            if (this.f12791l > 0) {
                this.f12791l %= 20;
                if (this.f12791l == 0) {
                    this.f12791l = 20;
                }
            }
            if (this.f12781b != null) {
                this.f12781b.setMax(20);
                this.f12781b.setProgress(this.f12791l);
            }
            if (this.f12783d != null) {
                this.f12783d.setText("" + this.f12791l + "/20");
            }
            if (this.f12784e != null) {
                this.f12784e.setText(GlobalApplication.m18732r().getResources().getString(R.string.freesms_detail_description_sending_international, Integer.valueOf(this.f12794o)));
            }
            if (this.f12787h != null) {
                this.f12787h.setOnClickListener(new ViewOnClickListenerC3624fg(this));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m13647a() {
        try {
            if (this.f12792m != null && this.f12793n != null) {
                this.f12792m.unregisterOnSharedPreferenceChangeListener(this.f12793n);
                this.f12793n = null;
            }
        } catch (Exception e) {
            C3890m.m14996b("FreeSmsInfoPreference", "caught Exception:" + e);
            e.printStackTrace();
        }
    }
}
