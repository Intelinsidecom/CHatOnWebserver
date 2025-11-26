package com.sec.chaton.buddy;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.buddy.p010a.C0258d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p015d.C0636h;
import com.sec.chaton.p017e.C0702q;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.p017e.p019b.InterfaceC0677d;
import com.sec.chaton.p028io.entry.inner.SpecialUser;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;

/* loaded from: classes.dex */
public class SpecialBuddyActivity extends BaseActivity {

    /* renamed from: A */
    private TextView f1235A;

    /* renamed from: B */
    private Button f1236B;

    /* renamed from: C */
    private Button f1237C;

    /* renamed from: D */
    private ImageView f1238D;

    /* renamed from: E */
    private TextView f1239E;

    /* renamed from: F */
    private Button f1240F;

    /* renamed from: G */
    private TextView f1241G;

    /* renamed from: H */
    private Button f1242H;

    /* renamed from: I */
    private Button f1243I;

    /* renamed from: J */
    private Button f1244J;

    /* renamed from: K */
    private Button f1245K;

    /* renamed from: e */
    private C0666j f1250e;

    /* renamed from: i */
    private C0258d f1251i;

    /* renamed from: j */
    private C0636h f1252j;

    /* renamed from: k */
    private ProgressDialogC1806j f1253k;

    /* renamed from: l */
    private Context f1254l;

    /* renamed from: m */
    private String f1255m;

    /* renamed from: n */
    private String f1256n;

    /* renamed from: r */
    private ImageView f1260r;

    /* renamed from: s */
    private TextView f1261s;

    /* renamed from: t */
    private TextView f1262t;

    /* renamed from: u */
    private CheckBox f1263u;

    /* renamed from: v */
    private ImageView f1264v;

    /* renamed from: w */
    private boolean f1265w;

    /* renamed from: x */
    private TextView f1266x;

    /* renamed from: y */
    private TextView f1267y;

    /* renamed from: z */
    private TextView f1268z;

    /* renamed from: o */
    private int f1257o = 0;

    /* renamed from: p */
    private long f1258p = 0;

    /* renamed from: q */
    private boolean f1259q = false;

    /* renamed from: a */
    View.OnClickListener f1246a = new ViewOnClickListenerC0403fg(this);

    /* renamed from: b */
    InterfaceC0667k f1247b = new C0390eu(this);

    /* renamed from: c */
    InterfaceC0677d f1248c = new C0391ev(this);

    /* renamed from: d */
    Handler f1249d = new HandlerC0392ew(this);

    /* renamed from: a */
    static /* synthetic */ int m2244a(SpecialBuddyActivity specialBuddyActivity, int i) {
        int i2 = specialBuddyActivity.f1257o + i;
        specialBuddyActivity.f1257o = i2;
        return i2;
    }

    /* renamed from: b */
    static /* synthetic */ int m2249b(SpecialBuddyActivity specialBuddyActivity, int i) {
        int i2 = specialBuddyActivity.f1257o - i;
        specialBuddyActivity.f1257o = i2;
        return i2;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        this.f1254l = this;
        this.f1255m = getIntent().getExtras().getString("specialuserid");
        this.f1256n = getIntent().getExtras().getString("speicalusername");
        this.f1259q = getIntent().getExtras().getBoolean("specialBuddyAdded");
        if (this.f1255m == null) {
            finish();
        }
        this.f1253k = new ProgressDialogC1806j(this, false);
        this.f1253k.setMessage(getResources().getString(R.string.buddy_list_progress_dialog_message));
        this.f1250e = new C0666j(getContentResolver(), this.f1247b);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            if (Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);
            }
        }
        setTitle(R.string.buddy_suggestion_special_buddy);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f1259q) {
            new C0633e(this.f1249d).m2854a(-1, -1);
        }
        if (this.f1259q) {
            this.f1250e.startQuery(1, null, C0704s.f2647a, null, "buddy_no = ? ", new String[]{this.f1255m}, null);
        } else {
            this.f1250e.startQuery(4, null, C0702q.f2645a, null, "buddy_no = ? ", new String[]{this.f1255m}, null);
        }
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this, getClass().getSimpleName());
        m2258d();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f1259q) {
            new C0633e(this.f1249d).m2859a(this.f1255m, -1, -1);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2247a(boolean z) {
        if (this.f1251i != null) {
            setContentView(R.layout.special_buddy_profile_layout);
            this.f1260r = (ImageView) findViewById(R.id.profile_special_image);
            this.f1260r.setImageResource(R.drawable.contacts_default_special);
            if (getFilesDir().listFiles(new C0389et(this, this.f1251i.m2354a() + ".jpeg_")).length != 0) {
                this.f1260r.setOnClickListener(new ViewOnClickListenerC0395ez(this));
            }
            this.f1263u = (CheckBox) findViewById(R.id.profile_special_is_favorite);
            this.f1264v = (ImageView) findViewById(R.id.profile_specialButton);
            this.f1266x = (TextView) findViewById(R.id.profile_special_subcribed);
            if (this.f1251i.m2357d() != null && !this.f1251i.m2357d().equals("null")) {
                this.f1258p = Integer.parseInt(this.f1251i.m2357d());
            }
            this.f1266x.setText(getResources().getString(R.string.buddy_special_buddy_buddies_subscribed, Long.valueOf(this.f1258p)));
            this.f1235A = (TextView) findViewById(R.id.profile_special_like_count);
            if (this.f1251i.m2358e() != null && !this.f1251i.m2358e().equals("null")) {
                this.f1257o = Integer.parseInt(this.f1251i.m2358e());
            }
            TextView textView = this.f1235A;
            toString();
            textView.setText(String.valueOf(this.f1257o));
            if (z) {
                this.f1263u.setChecked(this.f1265w);
                this.f1263u.setOnClickListener(this.f1246a);
                this.f1263u.setVisibility(0);
                this.f1264v.setVisibility(8);
            } else {
                this.f1264v.setVisibility(0);
                this.f1263u.setVisibility(8);
                this.f1263u.setClickable(false);
            }
            C1746bb.m5945a(this.f1254l).m5960a(this.f1260r, this.f1251i.m2354a(), 3);
            this.f1261s = (TextView) findViewById(R.id.profile_special_name);
            this.f1261s.setText(this.f1251i.m2355b());
            this.f1261s.setContentDescription(this.f1251i.m2355b());
            this.f1261s.setOnTouchListener(new ViewOnTouchListenerC0397fa(this));
            this.f1238D = (ImageView) findViewById(R.id.profile_special_url_image);
            this.f1238D.setOnClickListener(this.f1246a);
            this.f1238D.setVisibility(0);
            this.f1239E = (TextView) findViewById(R.id.profile_special_url);
            if (this.f1251i != null && this.f1251i.m2362i() != null) {
                this.f1239E.setText(this.f1251i.m2362i().replace(" ", ""));
                this.f1239E.setContentDescription(this.f1251i.m2362i());
                this.f1239E.setOnTouchListener(new ViewOnTouchListenerC0398fb(this));
            }
            this.f1267y = (TextView) findViewById(R.id.special_selected_category);
            this.f1267y.setText(getString(R.string.calendar_description));
            this.f1268z = (TextView) findViewById(R.id.special_selected_description);
            this.f1268z.setText(this.f1251i.m2356c());
            this.f1268z.setContentDescription(this.f1251i.m2356c());
            this.f1262t = (TextView) findViewById(R.id.profile_special_status_message);
            this.f1262t.setContentDescription(this.f1251i.m2359f());
            if (TextUtils.isEmpty(this.f1251i.m2359f())) {
                this.f1262t.setVisibility(8);
            } else {
                this.f1262t.setText(this.f1251i.m2359f());
                this.f1262t.setOnTouchListener(new ViewOnTouchListenerC0399fc(this));
            }
            this.f1236B = (Button) findViewById(R.id.profile_add_special_buddy);
            this.f1236B.setOnTouchListener(new ViewOnTouchListenerC0400fd(this));
            this.f1236B.setOnClickListener(this.f1246a);
            this.f1237C = (Button) findViewById(R.id.profile_special_chat);
            this.f1237C.setOnTouchListener(new ViewOnTouchListenerC0401fe(this));
            this.f1237C.setOnClickListener(this.f1246a);
            if (z) {
                this.f1236B.setVisibility(8);
                this.f1237C.setVisibility(0);
            } else {
                this.f1236B.setVisibility(0);
                this.f1237C.setVisibility(8);
            }
            this.f1240F = (Button) findViewById(R.id.profile_spcial_buddy_see_more_btn);
            this.f1240F.setOnTouchListener(new ViewOnTouchListenerC0402ff(this));
            this.f1240F.setOnClickListener(this.f1246a);
            this.f1240F.setVisibility(8);
            return;
        }
        setContentView(R.layout.new_buddy_layout);
        this.f1261s = (TextView) findViewById(R.id.new_buddy_name);
        this.f1241G = (TextView) findViewById(R.id.new_buddy_information);
        if (this.f1256n == null) {
            this.f1261s.setText(getString(R.string.buddy_profile_no_name));
        } else {
            this.f1261s.setText(this.f1256n);
            this.f1261s.setContentDescription(this.f1256n);
        }
        this.f1242H = (Button) findViewById(R.id.new_buddy_add);
        this.f1243I = (Button) findViewById(R.id.new_buddy_block);
        this.f1244J = (Button) findViewById(R.id.new_buddy_unblock);
        this.f1245K = (Button) findViewById(R.id.new_buddy_cancel);
        this.f1242H.setOnClickListener(this.f1246a);
        this.f1243I.setOnClickListener(this.f1246a);
        this.f1244J.setOnClickListener(this.f1246a);
        this.f1245K.setOnClickListener(this.f1246a);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f1242H.setText(R.string.buddy_profile_button_block);
            this.f1243I.setText(R.string.buddy_profile_button_addbuddy);
            this.f1244J.setText(R.string.cancel);
            this.f1245K.setText(R.string.setting_block_unblock);
        }
    }

    /* renamed from: a */
    public void m2272a() {
        this.f1253k.show();
        new C0633e(this.f1249d).m2868b(this.f1255m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2251b() {
        this.f1253k.show();
        new C0632d(this.f1249d).m2847a(this.f1255m, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2255c() {
        this.f1253k.show();
        new C0632d(this.f1249d).m2846a(this.f1255m);
    }

    /* renamed from: a */
    C0258d m2271a(C0258d c0258d, SpecialUser specialUser) {
        return new C0258d(specialUser.specialuserid == null ? c0258d.m2354a() : specialUser.specialuserid, specialUser.name == null ? c0258d.m2355b() : specialUser.name, specialUser.description == null ? c0258d.m2356c() : specialUser.description, specialUser.followcount == null ? c0258d.m2357d() : specialUser.followcount, specialUser.likecount == null ? c0258d.m2358e() : specialUser.likecount, specialUser.msgstatus == null ? c0258d.m2359f() : specialUser.msgstatus, specialUser.photoloaded == null ? c0258d.m2360g() : specialUser.photoloaded, specialUser.status == null ? c0258d.m2361h() : specialUser.status, specialUser.url == null ? c0258d.m2362i() : specialUser.url, c0258d.m2364k());
    }

    /* renamed from: a */
    C0257c m2270a(C0258d c0258d) {
        return new C0257c(c0258d.m2354a(), c0258d.m2355b(), c0258d.m2359f(), null, c0258d.m2354a(), null, true, 0, c0258d.m2355b(), false, 0, 0, 0, 0, 0, 0, 1, false, false);
    }

    /* renamed from: d */
    private void m2258d() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
