package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.C1385ac;
import com.sec.chaton.p027e.C1458z;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.widget.C3641ai;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PostONImagePagerActivity extends BaseActivity implements InterfaceC1866aq {

    /* renamed from: b */
    private static final String f6962b = PostONImagePagerActivity.class.getSimpleName();

    /* renamed from: c */
    private static String f6963c = C3223ck.m11329c() + "/poston/";

    /* renamed from: A */
    private boolean f6964A;

    /* renamed from: B */
    private C1377u f6965B;

    /* renamed from: C */
    private LinearLayout f6966C;

    /* renamed from: d */
    private ViewPager f6973d;

    /* renamed from: e */
    private C1858ai f6974e;

    /* renamed from: f */
    private String f6975f;

    /* renamed from: g */
    private String f6976g;

    /* renamed from: h */
    private String f6977h;

    /* renamed from: i */
    private String f6978i;

    /* renamed from: j */
    private int f6979j;

    /* renamed from: k */
    private String f6980k;

    /* renamed from: l */
    private C3326c f6981l;

    /* renamed from: m */
    private Context f6982m;

    /* renamed from: n */
    private View f6983n;

    /* renamed from: o */
    private BroadcastReceiver f6984o;

    /* renamed from: t */
    private MenuItem f6989t;

    /* renamed from: u */
    private MenuItem f6990u;

    /* renamed from: v */
    private TextView f6991v;

    /* renamed from: w */
    private InterfaceC3274d f6992w;

    /* renamed from: x */
    private ImageView f6993x;

    /* renamed from: y */
    private ImageView f6994y;

    /* renamed from: z */
    private TextView f6995z;

    /* renamed from: a */
    public int f6972a = 2;

    /* renamed from: p */
    private HashMap<String, PostONImagePagerFragment> f6985p = new HashMap<>();

    /* renamed from: q */
    private HashMap<String, C1859aj> f6986q = new HashMap<>();

    /* renamed from: r */
    private HashMap<Integer, String> f6987r = new HashMap<>();

    /* renamed from: s */
    private HashMap<String, String> f6988s = new HashMap<>();

    /* renamed from: D */
    private ViewPager.OnPageChangeListener f6967D = new C1852ac(this);

    /* renamed from: E */
    private View.OnClickListener f6968E = new ViewOnClickListenerC1853ad(this);

    /* renamed from: F */
    private ContentObserver f6969F = new C1854ae(this, new Handler());

    /* renamed from: G */
    private InterfaceC1378v f6970G = new C1855af(this);

    /* renamed from: H */
    private Handler f6971H = new HandlerC1857ah(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_image_pager);
        this.f6981l = new C3326c();
        this.f6982m = this;
        this.f6976g = C3159aa.m10962a().m10979a("chaton_id", "");
        this.f6965B = new C1377u(getContentResolver(), this.f6970G);
        Bundle extras = getIntent().getExtras();
        this.f6983n = findViewById(R.id.detailVeiwLayout);
        this.f6983n.setOnClickListener(this.f6968E);
        this.f6966C = (LinearLayout) findViewById(R.id.descriptionLayout);
        this.f6974e = new C1858ai(this, getSupportFragmentManager());
        this.f6973d = (ViewPager) findViewById(R.id.filter_pager);
        this.f6973d.setAdapter(this.f6974e);
        this.f6973d.setOnPageChangeListener(this.f6967D);
        this.f6993x = (ImageView) findViewById(R.id.arrow_left);
        this.f6994y = (ImageView) findViewById(R.id.arrow_right);
        this.f6995z = (TextView) findViewById(R.id.description);
        this.f6991v = (TextView) this.f6983n.findViewById(R.id.text1);
        if (bundle != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[restore from onSaveInstanceState]", f6962b);
            }
            this.f6975f = bundle.getString("buddyId");
            this.f6977h = bundle.getString("url");
        } else if (extras != null) {
            this.f6975f = extras.getString("buddyId");
            this.f6977h = extras.getString("url");
        }
        if (this.f6975f.equals(this.f6976g)) {
            this.f6965B.startQuery(this.f6972a, null, C1385ac.f5181b, null, "poston_metatype=? OR poston_metatype=? OR poston_metatype=?", new String[]{"1", "2", "3"}, null);
        } else {
            this.f6965B.startQuery(this.f6972a, null, C1458z.f5417b, null, "poston_metatype=? OR poston_metatype=? OR poston_metatype=?", new String[]{"1", "2", "3"}, null);
        }
        if (this.f6975f.equals(this.f6976g)) {
            getContentResolver().registerContentObserver(C1385ac.f5180a, true, this.f6969F);
        } else {
            getContentResolver().registerContentObserver(C1458z.f5416a, true, this.f6969F);
        }
        this.f6978i = f6963c + this.f6975f;
        m11543k().mo11588b(false);
        m11543k().mo11584a(false);
        m11543k().mo11591c(false);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f6987r.containsKey(Integer.valueOf(m7661e()))) {
            C1859aj c1859aj = this.f6986q.get(this.f6987r.get(Integer.valueOf(m7661e())));
            if (C3250y.f11734b) {
                C3250y.m11450b("[onSaveInstanceState] postonNo: " + c1859aj.f7087a, f6962b);
            }
            bundle.putString("buddyId", this.f6975f);
            bundle.putString("url", this.f6977h);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    C3250y.m11450b("Inform the item is deleted", getClass().getSimpleName());
                    finish();
                    break;
                }
                break;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m7649j();
        m7645h();
        if (this.f6975f.equals(this.f6976g)) {
            getContentResolver().registerContentObserver(C1385ac.f5180a, true, this.f6969F);
        } else {
            getContentResolver().registerContentObserver(C1458z.f5416a, true, this.f6969F);
        }
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m7652m();
        getContentResolver().unregisterContentObserver(this.f6969F);
        super.onPause();
    }

    /* renamed from: h */
    private void m7645h() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", f6962b);
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
        this.f6981l.m11731a();
        if (this.f6992w != null) {
            this.f6992w.dismiss();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7634a(int i) {
        C1859aj c1859aj;
        this.f6979j = i;
        if (this.f6987r.containsKey(Integer.valueOf(i)) && (c1859aj = this.f6986q.get(this.f6987r.get(Integer.valueOf(i)))) != null) {
            this.f6980k = c1859aj.f7087a;
            if (i == 0 || this.f6964A) {
                this.f6993x.setVisibility(8);
            } else {
                this.f6993x.setVisibility(0);
            }
            if (i >= this.f6987r.size() - 1 || this.f6964A) {
                this.f6994y.setVisibility(8);
            } else {
                this.f6994y.setVisibility(0);
            }
            String str = c1859aj.f7090d;
            if (this.f6989t != null && this.f6990u != null) {
                if (TextUtils.isEmpty(str) || C0816a.f3113b.equals(str) || str.contains("thumbnail")) {
                    this.f6989t.setEnabled(false);
                    this.f6990u.setEnabled(false);
                } else {
                    this.f6990u.setEnabled(true);
                }
            }
            this.f6995z.setText(c1859aj.f7091e);
            if (this.f6964A) {
                this.f6983n.setVisibility(4);
                this.f6966C.setVisibility(4);
            } else {
                this.f6983n.setVisibility(0);
                if (this.f6995z.getText().length() > 0) {
                    this.f6966C.setVisibility(0);
                } else {
                    this.f6966C.setVisibility(4);
                }
            }
            this.f6991v.setText(c1859aj.m7699a());
        }
    }

    /* renamed from: a */
    protected ViewPager m7654a() {
        return this.f6973d;
    }

    /* renamed from: b */
    protected HashMap<String, C1859aj> m7658b() {
        return this.f6986q;
    }

    /* renamed from: c */
    protected HashMap<Integer, String> m7659c() {
        return this.f6987r;
    }

    /* renamed from: d */
    protected C3326c m7660d() {
        return this.f6981l;
    }

    /* renamed from: e */
    protected int m7661e() {
        return this.f6979j;
    }

    /* renamed from: i */
    private void m7647i() {
        C1859aj c1859aj;
        if (!C3197bl.m11159a() && this.f6987r.containsKey(Integer.valueOf(m7661e())) && (c1859aj = this.f6986q.get(this.f6987r.get(Integer.valueOf(m7661e())))) != null && !TextUtils.isEmpty(c1859aj.f7090d)) {
            String str = c1859aj.f7090d;
            if (!C3223ck.m11327a()) {
                C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            } else {
                new AsyncTaskC1767a(this.f6978i + "/" + str.split("/")[r0.length - 1], Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", false).execute(new String[0]);
            }
        }
    }

    /* renamed from: j */
    private void m7649j() {
        this.f6984o = new C1856ag(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f6984o, intentFilter);
        m7651l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m7651l() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: m */
    private void m7652m() {
        unregisterReceiver(this.f6984o);
    }

    /* renamed from: a */
    protected void m7657a(String str, PostONImagePagerFragment postONImagePagerFragment) {
        this.f6985p.put(str, postONImagePagerFragment);
    }

    /* renamed from: a */
    protected void m7656a(String str) {
        this.f6985p.remove(str);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_pager_menu, menu);
        this.f6989t = menu.findItem(R.id.menu_save);
        this.f6990u = menu.findItem(R.id.menu_share);
        m7634a(m7661e());
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_save) {
            m7647i();
        } else if (menuItem.getItemId() == R.id.menu_share && this.f6987r.containsKey(Integer.valueOf(this.f6979j)) && this.f6986q.get(this.f6987r.get(Integer.valueOf(this.f6979j))) != null) {
            m7653n();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: n */
    private void m7653n() {
        C1859aj c1859aj;
        Intent intentM11326b;
        if (!C3197bl.m11159a() && this.f6987r.containsKey(Integer.valueOf(this.f6979j)) && (c1859aj = this.f6986q.get(this.f6987r.get(Integer.valueOf(this.f6979j)))) != null && !TextUtils.isEmpty(c1859aj.f7090d)) {
            String str = c1859aj.f7090d.split("/")[r2.length - 1];
            if (c1859aj.f7089c.equals("1")) {
                intentM11326b = C3220ch.m11320a(this, getString(R.string.trunk_opt_header_share), this.f6978i + "/" + str, (String) null, (String) null);
            } else {
                intentM11326b = c1859aj.f7089c.equals("2") ? C3220ch.m11326b(this, getString(R.string.trunk_opt_header_share), this.f6978i + "/" + str, null, null) : null;
            }
            if (intentM11326b != null) {
                startActivity(intentM11326b);
            }
        }
    }

    /* renamed from: f */
    protected void m7662f() {
        if (!this.f6964A) {
            this.f6990u.setVisible(false);
            this.f6989t.setVisible(false);
            this.f6995z.setVisibility(4);
            this.f6966C.setVisibility(4);
            this.f6983n.setVisibility(4);
            this.f6993x.setVisibility(4);
            this.f6994y.setVisibility(4);
            this.f6964A = true;
            return;
        }
        this.f6990u.setVisible(true);
        this.f6989t.setVisible(true);
        this.f6995z.setVisibility(0);
        if (this.f6995z.getText().length() > 0) {
            this.f6966C.setVisibility(0);
        } else {
            this.f6966C.setVisibility(4);
        }
        this.f6983n.setVisibility(0);
        if (this.f6979j > 0) {
            this.f6993x.setVisibility(0);
        }
        if (this.f6979j < this.f6987r.size() - 1) {
            this.f6994y.setVisibility(0);
        }
        this.f6964A = false;
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC1866aq
    /* renamed from: a */
    public void mo7655a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "video/*");
        intent.putExtra("android.intent.extra.finishOnCompletion", false);
        startActivity(intent);
    }
}
