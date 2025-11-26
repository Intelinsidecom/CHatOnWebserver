package com.sec.chaton.trunk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.database.C3047c;
import com.sec.chaton.trunk.p058a.EnumC2959b;
import com.sec.chaton.trunk.p061c.C3020a;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3364o;
import com.sec.vip.amschaton.AMSPlayerActivity;
import com.sec.widget.C3641ai;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TrunkPageActivity extends BaseActivity implements InterfaceC2983ax {

    /* renamed from: a */
    public static String f10630a;

    /* renamed from: b */
    public static String f10631b;

    /* renamed from: f */
    private static final String f10632f = TrunkPageActivity.class.getSimpleName();

    /* renamed from: A */
    private ImageView f10633A;

    /* renamed from: B */
    private BroadcastReceiver f10634B;

    /* renamed from: C */
    private LinearLayout f10635C;

    /* renamed from: D */
    private TextView f10636D;

    /* renamed from: E */
    private boolean f10637E;

    /* renamed from: F */
    private Toast f10638F;

    /* renamed from: G */
    private boolean f10639G;

    /* renamed from: d */
    public boolean f10643d;

    /* renamed from: g */
    private ViewPager f10645g;

    /* renamed from: h */
    private String f10646h;

    /* renamed from: i */
    private String f10647i;

    /* renamed from: j */
    private String f10648j;

    /* renamed from: k */
    private C3016bx f10649k;

    /* renamed from: l */
    private String f10650l;

    /* renamed from: m */
    private EnumC3026g f10651m;

    /* renamed from: n */
    private EnumC2959b f10652n;

    /* renamed from: o */
    private C1377u f10653o;

    /* renamed from: p */
    private int f10654p;

    /* renamed from: q */
    private Cursor f10655q;

    /* renamed from: r */
    private int f10656r;

    /* renamed from: s */
    private TextView f10657s;

    /* renamed from: t */
    private HashMap<Integer, TrunkFullView> f10658t;

    /* renamed from: u */
    private C3326c f10659u;

    /* renamed from: v */
    private Context f10660v;

    /* renamed from: w */
    private View f10661w;

    /* renamed from: x */
    private MenuItem f10662x;

    /* renamed from: y */
    private MenuItem f10663y;

    /* renamed from: z */
    private ImageView f10664z;

    /* renamed from: c */
    ArrayList<C3017by> f10642c = new ArrayList<>();

    /* renamed from: H */
    private ViewPager.OnPageChangeListener f10640H = new C3011bs(this);

    /* renamed from: I */
    private View.OnClickListener f10641I = new ViewOnClickListenerC3012bt(this);

    /* renamed from: e */
    InterfaceC1378v f10644e = new C3013bu(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f10630a = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
        f10631b = f10630a + "amsuserfiles/";
        setContentView(R.layout.layout_image_pager);
        this.f10659u = new C3326c();
        this.f10660v = this;
        this.f10658t = new HashMap<>();
        Bundle extras = getIntent().getExtras();
        this.f10642c.clear();
        this.f10658t.clear();
        this.f10661w = findViewById(R.id.detailVeiwLayout);
        this.f10635C = (LinearLayout) findViewById(R.id.descriptionLayout);
        this.f10636D = (TextView) findViewById(R.id.description);
        this.f10657s = (TextView) this.f10661w.findViewById(R.id.text1);
        this.f10661w.setOnClickListener(this.f10641I);
        this.f10649k = new C3016bx(this, getSupportFragmentManager());
        this.f10645g = (ViewPager) findViewById(R.id.filter_pager);
        this.f10645g.setAdapter(this.f10649k);
        this.f10645g.setOnPageChangeListener(this.f10640H);
        this.f10664z = (ImageView) findViewById(R.id.arrow_left);
        this.f10633A = (ImageView) findViewById(R.id.arrow_right);
        if (bundle != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[restore from onSaveInstanceState]", f10632f);
            }
            this.f10646h = bundle.getString("itemId");
            this.f10647i = bundle.getString("inboxNo");
            this.f10648j = bundle.getString("sessionId");
            this.f10643d = bundle.getBoolean("isvalid");
        } else if (extras != null) {
            this.f10646h = extras.getString("itemId");
            this.f10647i = extras.getString("inboxNo");
            this.f10648j = extras.getString("sessionId");
            this.f10643d = extras.getBoolean("isvalid");
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("ItemId: " + this.f10646h + ", InboxNo: " + this.f10647i + "SessionId: " + this.f10648j + "isValid :" + this.f10643d, f10632f);
        }
        this.f10653o = new C1377u(getContentResolver(), this.f10644e);
        this.f10652n = EnumC2959b.m10433a(C3159aa.m10962a().m10979a("trunkOrderingType", EnumC2959b.UnreadComment.m10434a()));
        if (EnumC2959b.Recent.equals(this.f10652n)) {
            this.f10653o.startQuery(1, null, C3047c.f10952a, null, "session_id=?", new String[]{this.f10648j}, "registration_time DESC");
        } else {
            this.f10653o.startQuery(1, null, C3047c.f10952a, null, "session_id=?", new String[]{this.f10648j}, "last_comment_time DESC");
        }
        this.f10638F = C3641ai.m13211a(CommonApplication.m11493l(), (CharSequence) null, 0);
        m11543k().mo11588b(false);
        m11543k().mo11584a(false);
        m11543k().mo11591c(false);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m3080a(this);
        this.f10636D.scrollTo(0, 0);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C3017by c3017by;
        if (this.f10656r < this.f10642c.size() && (c3017by = this.f10642c.get(this.f10656r)) != null && c3017by.f10870f != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[onSaveInstanceState] ItemId: " + c3017by.f10870f + ", inboxNo: " + this.f10647i, f10632f);
            }
            bundle.putString("itemId", c3017by.f10870f);
            bundle.putString("inboxNo", this.f10647i);
            bundle.putString("sessionId", this.f10648j);
            bundle.putBoolean("isvalid", this.f10643d);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        if (intent.getBooleanExtra("noUnread", false)) {
                            if (!this.f10642c.isEmpty() && this.f10642c.get(this.f10656r) != null) {
                                this.f10642c.get(this.f10656r).f10877m = 0;
                            }
                            m10339a(false);
                            break;
                        }
                    } else {
                        C3250y.m11450b("Inform the item is deleted", f10632f);
                        finish();
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: b */
    private String m10342b(String str) {
        return C3364o.m11849a(C3020a.m10526a(), File.separator, str);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        m10353i();
        m10352h();
        if (this.f10653o != null && this.f10658t != null && !this.f10658t.isEmpty()) {
            this.f10653o.startQuery(2, null, C3047c.f10952a, null, "item_id=?", new String[]{this.f10658t.get(Integer.valueOf(this.f10656r)).m10250e()}, null);
        }
        super.onResume();
        BaseActivity.m3080a(this);
        if (this.f10658t != null && !this.f10658t.isEmpty() && this.f10658t.get(Integer.valueOf(this.f10656r)) != null) {
            if (this.f10662x != null) {
                this.f10662x.setEnabled(this.f10658t.get(Integer.valueOf(this.f10656r)).m10248c());
                C3228cp.m11343a(this.f10662x);
            }
            if (this.f10663y != null) {
                this.f10663y.setEnabled(this.f10658t.get(Integer.valueOf(this.f10656r)).m10249d());
                C3228cp.m11343a(this.f10663y);
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m10357l();
        super.onPause();
    }

    /* renamed from: h */
    private void m10352h() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", f10632f);
        }
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f10659u.m11731a();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10337a(int i) throws Resources.NotFoundException {
        this.f10656r = i;
        if (i < this.f10642c.size()) {
            C3017by c3017by = this.f10642c.get(i);
            if (c3017by != null) {
                if (i == 0 || this.f10639G) {
                    this.f10664z.setVisibility(8);
                } else {
                    this.f10664z.setVisibility(0);
                }
                if (i >= this.f10654p - 1 || this.f10639G) {
                    this.f10633A.setVisibility(8);
                } else {
                    this.f10633A.setVisibility(0);
                }
                m10343b(c3017by.f10874j);
                if (c3017by.f10877m > 0) {
                    m10339a(true);
                } else {
                    m10339a(false);
                }
                if (c3017by.f10876l != null) {
                    this.f10635C.setVisibility(0);
                    this.f10636D.setText(C1835j.m7508a(getApplicationContext(), c3017by.f10876l, (int) C3172an.m11085a(30.0f)));
                    this.f10637E = true;
                } else {
                    this.f10637E = false;
                    this.f10635C.setVisibility(8);
                }
            }
            if (!this.f10658t.isEmpty()) {
                if (this.f10662x != null) {
                    this.f10662x.setEnabled(this.f10658t.get(Integer.valueOf(this.f10656r)).m10248c());
                    C3228cp.m11343a(this.f10662x);
                }
                if (this.f10663y != null) {
                    this.f10663y.setEnabled(this.f10658t.get(Integer.valueOf(this.f10656r)).m10249d());
                    C3228cp.m11343a(this.f10663y);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10343b(int i) {
        this.f10657s.setText(String.valueOf(i));
    }

    /* renamed from: c */
    public ArrayList<C3017by> m10363c() {
        return this.f10642c;
    }

    /* renamed from: d */
    public ViewPager m10364d() {
        return this.f10645g;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) throws Resources.NotFoundException {
        getMenuInflater().inflate(R.menu.image_pager_menu, menu);
        this.f10662x = menu.findItem(R.id.menu_save);
        this.f10663y = menu.findItem(R.id.menu_share);
        m10337a(this.f10656r);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (this.f10656r < this.f10642c.size()) {
            C3017by c3017by = this.f10642c.get(this.f10656r);
            this.f10650l = m10336a(c3017by);
            this.f10651m = c3017by.f10873i;
            switch (menuItem.getItemId()) {
                case R.id.menu_save /* 2131166578 */:
                    boolean zM10540b = C3025f.m10540b(this.f10650l);
                    if (this.f10650l != null && !zM10540b) {
                        m10361a(this.f10650l);
                        break;
                    }
                    break;
                case R.id.menu_share /* 2131166616 */:
                    if (("true".equals(c3017by.f10871g) || C3025f.m10540b(this.f10650l)) && !C3159aa.m10962a().m10977a("TrunkShareCheckPopup", (Boolean) false).booleanValue()) {
                        m10365e();
                        break;
                    } else {
                        m10358m();
                        break;
                    }
            }
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: i */
    private void m10353i() {
        this.f10634B = new C3014bv(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10634B, intentFilter);
        m10355j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m10355j() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: l */
    private void m10357l() {
        unregisterReceiver(this.f10634B);
    }

    @Override // com.sec.chaton.trunk.InterfaceC2983ax
    /* renamed from: a */
    public void mo10360a(EnumC3026g enumC3026g, String str) {
        Intent intent = new Intent();
        if (enumC3026g == EnumC3026g.IMAGE) {
            if (C3025f.m10540b(str)) {
                intent.setClass(this, AMSPlayerActivity.class);
                intent.putExtra("AMS_FILE_PATH", str);
                intent.putExtra("VIEWER_MODE", 1002);
            } else {
                return;
            }
        } else if (enumC3026g == EnumC3026g.VIDEO && C3223ck.m11327a()) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(Uri.fromFile(new File(str)).toString()), "video/*");
            intent.putExtra("android.intent.extra.finishOnCompletion", false);
        }
        startActivityForResult(intent, 1);
    }

    /* renamed from: a */
    private String m10336a(C3017by c3017by) {
        try {
            return C3364o.m11849a(m10342b(this.f10647i), File.separator, C3025f.m10538a(c3017by.f10872h));
        } catch (MalformedURLException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, f10632f);
            }
            return null;
        }
    }

    /* renamed from: a */
    public void m10361a(String str) {
        if (!C3197bl.m11159a()) {
            if (!C3223ck.m11327a()) {
                C3641ai.m13210a(this, R.string.sdcard_not_found, 0).show();
            } else if (!C3223ck.m11331e()) {
                AbstractC3271a.m11494a(this).mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null).mo11512b();
            } else {
                new AsyncTaskC1767a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", false).execute(new String[0]);
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC2983ax
    /* renamed from: a */
    public void mo10359a() {
        finish();
    }

    /* renamed from: e */
    public void m10365e() {
        C3220ch.m11325a(this, new DialogInterfaceOnClickListenerC3015bw(this)).mo11512b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m10358m() {
        Intent intentM11322a = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            C3641ai.m13211a(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (this.f10651m == EnumC3026g.IMAGE || this.f10651m == EnumC3026g.AMS) {
            intentM11322a = C3220ch.m11322a((Context) this, getString(R.string.trunk_opt_header_share), this.f10650l, this.f10658t.get(Integer.valueOf(this.f10656r)).f10541b, (String) null, false);
        } else if (this.f10651m == EnumC3026g.VIDEO) {
            intentM11322a = C3220ch.m11326b(this, getString(R.string.trunk_opt_header_share), this.f10650l, this.f10658t.get(Integer.valueOf(this.f10656r)).f10541b, null);
        }
        if (intentM11322a != null) {
            startActivityForResult(intentM11322a, 2);
        }
    }

    /* renamed from: f */
    protected void m10366f() {
        if (!this.f10639G) {
            if (this.f10663y != null && this.f10662x != null) {
                this.f10663y.setVisible(false);
                this.f10662x.setVisible(false);
            }
            this.f10661w.setVisibility(4);
            this.f10664z.setVisibility(4);
            this.f10633A.setVisibility(4);
            if (this.f10637E) {
                this.f10635C.setVisibility(8);
            }
            this.f10639G = true;
            return;
        }
        if (this.f10663y != null && this.f10662x != null) {
            this.f10663y.setVisible(true);
            this.f10662x.setVisible(true);
        }
        this.f10661w.setVisibility(0);
        if (this.f10656r > 0) {
            this.f10664z.setVisibility(0);
        }
        if (this.f10656r < this.f10654p - 1) {
            this.f10633A.setVisibility(0);
        }
        if (this.f10637E) {
            this.f10635C.setVisibility(0);
        }
        this.f10639G = false;
    }

    /* renamed from: a */
    private void m10339a(boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (z) {
            drawable = this.f10660v.getResources().getDrawable(R.drawable.trunk_ic_comment_unread_chats);
        } else {
            drawable = this.f10660v.getResources().getDrawable(R.drawable.trunk_ic_comment_read);
        }
        if (this.f10657s != null) {
            this.f10657s.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC2983ax
    /* renamed from: b */
    public void mo10362b() {
        if (!this.f10658t.isEmpty() && this.f10658t.get(Integer.valueOf(this.f10656r)) != null) {
            if (this.f10662x != null) {
                this.f10662x.setEnabled(this.f10658t.get(Integer.valueOf(this.f10656r)).m10248c());
                C3228cp.m11343a(this.f10662x);
            }
            if (this.f10663y != null) {
                this.f10663y.setEnabled(this.f10658t.get(Integer.valueOf(this.f10656r)).m10249d());
                C3228cp.m11343a(this.f10663y);
            }
        }
    }
}
