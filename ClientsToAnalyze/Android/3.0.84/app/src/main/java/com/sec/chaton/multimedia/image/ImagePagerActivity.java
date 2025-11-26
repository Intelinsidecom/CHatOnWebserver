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
import com.sec.chaton.localbackup.chatview.BackupImagePagerFragment;
import com.sec.chaton.localbackup.database.C1641a;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3220ch;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.p069e.C3326c;
import com.sec.widget.C3641ai;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ImagePagerActivity extends BaseActivity {

    /* renamed from: b */
    private static final String f6898b = ImagePagerActivity.class.getSimpleName();

    /* renamed from: A */
    private boolean f6899A;

    /* renamed from: B */
    private boolean f6900B;

    /* renamed from: C */
    private boolean f6901C;

    /* renamed from: D */
    private boolean f6902D;

    /* renamed from: c */
    private ViewPager f6909c;

    /* renamed from: d */
    private long f6910d;

    /* renamed from: e */
    private String f6911e;

    /* renamed from: f */
    private String f6912f;

    /* renamed from: g */
    private C1890s f6913g;

    /* renamed from: h */
    private C1377u f6914h;

    /* renamed from: i */
    private int f6915i;

    /* renamed from: j */
    private int f6916j;

    /* renamed from: k */
    private C3326c f6917k;

    /* renamed from: l */
    private Context f6918l;

    /* renamed from: m */
    private View f6919m;

    /* renamed from: n */
    private BroadcastReceiver f6920n;

    /* renamed from: o */
    private boolean f6921o;

    /* renamed from: s */
    private EnumC1450r f6925s;

    /* renamed from: t */
    private MenuItem f6926t;

    /* renamed from: u */
    private MenuItem f6927u;

    /* renamed from: v */
    private InterfaceC3274d f6928v;

    /* renamed from: w */
    private ImageView f6929w;

    /* renamed from: x */
    private ImageView f6930x;

    /* renamed from: y */
    private TextView f6931y;

    /* renamed from: z */
    private LinearLayout f6932z;

    /* renamed from: p */
    private HashMap<Long, ImagePagerFragment> f6922p = new HashMap<>();

    /* renamed from: q */
    private HashMap<Long, C1891t> f6923q = new HashMap<>();

    /* renamed from: r */
    private HashMap<Integer, Long> f6924r = new HashMap<>();

    /* renamed from: E */
    private ViewPager.OnPageChangeListener f6903E = new C1882k(this);

    /* renamed from: F */
    private View.OnClickListener f6904F = new ViewOnClickListenerC1883l(this);

    /* renamed from: a */
    InterfaceC1378v f6908a = new C1884m(this);

    /* renamed from: G */
    private ContentObserver f6905G = new C1885n(this, new Handler());

    /* renamed from: H */
    private Handler f6906H = new HandlerC1887p(this);

    /* renamed from: I */
    private Handler f6907I = new HandlerC1888q(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Uri uri;
        super.onCreate(bundle);
        setContentView(R.layout.layout_image_pager);
        this.f6917k = new C3326c();
        this.f6918l = this;
        Bundle extras = getIntent().getExtras();
        this.f6919m = findViewById(R.id.chatDetailVeiwLayout);
        this.f6919m.setOnClickListener(this.f6904F);
        ((TextView) this.f6919m.findViewById(R.id.text1)).setText(R.string.attach_image_comments);
        findViewById(R.id.detailVeiwLayout).setVisibility(8);
        this.f6913g = new C1890s(this, getSupportFragmentManager());
        this.f6909c = (ViewPager) findViewById(R.id.filter_pager);
        this.f6909c.setAdapter(this.f6913g);
        this.f6909c.setOnPageChangeListener(this.f6903E);
        this.f6929w = (ImageView) findViewById(R.id.arrow_left);
        this.f6930x = (ImageView) findViewById(R.id.arrow_right);
        this.f6932z = (LinearLayout) findViewById(R.id.descriptionLayout);
        this.f6931y = (TextView) findViewById(R.id.description);
        if (bundle != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[restore from onSaveInstanceState]", f6898b);
            }
            this.f6910d = bundle.getLong("messageId");
            this.f6911e = bundle.getString("inboxNo");
            this.f6921o = bundle.getBoolean("isValid");
            this.f6925s = EnumC1450r.m6339a(bundle.getInt("chatType"));
            this.f6902D = bundle.getBoolean("backup");
            this.f6912f = bundle.getString("sessionID");
        } else if (extras != null) {
            this.f6910d = extras.getLong("messageId");
            this.f6911e = extras.getString("inboxNo");
            this.f6921o = extras.getBoolean("isValid");
            this.f6925s = EnumC1450r.m6339a(extras.getInt("chatType"));
            this.f6902D = extras.getBoolean("backup");
            this.f6912f = extras.getString("sessionID");
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("messageId: " + this.f6910d + ", mInboxNo: " + this.f6911e, f6898b);
        }
        if (this.f6925s == EnumC1450r.BROADCAST || this.f6925s == EnumC1450r.BROADCAST2) {
            this.f6919m.setVisibility(8);
        }
        this.f6914h = new C1377u(getContentResolver(), this.f6908a);
        if (this.f6902D) {
            uri = C1641a.f6102a;
        } else {
            uri = C1454v.f5393a;
        }
        this.f6914h.startQuery(1, null, uri, null, "message_inbox_no=? AND ( message_content_type=? OR message_content_type=? OR message_content_type=? ) AND message_is_truncated = 'N'", new String[]{this.f6911e, String.valueOf(EnumC1455w.AMS.m6364a()), String.valueOf(EnumC1455w.VIDEO.m6364a()), String.valueOf(EnumC1455w.IMAGE.m6364a())}, "message_is_failed , message_time , _id");
        m11543k().mo11588b(false);
        m11543k().mo11584a(false);
        m11543k().mo11591c(false);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C1891t c1891t;
        if (this.f6924r.containsKey(Integer.valueOf(this.f6916j)) && (c1891t = this.f6923q.get(this.f6924r.get(Integer.valueOf(this.f6916j)))) != null && c1891t.f7175b > 0) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[onSaveInstanceState] messageId: " + c1891t.f7175b + ", inboxNo: " + this.f6911e, f6898b);
            }
            bundle.putLong("messageId", c1891t.f7175b);
            bundle.putString("inboxNo", this.f6911e);
            bundle.putBoolean("isValid", this.f6921o);
            bundle.putInt("chatType", this.f6925s.m6342a());
            bundle.putBoolean("backup", this.f6902D);
            bundle.putString("sessionID", this.f6912f);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m7599m();
        m7595j();
        getContentResolver().registerContentObserver(C1454v.f5393a, true, this.f6905G);
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m7603o();
        getContentResolver().unregisterContentObserver(this.f6905G);
        super.onPause();
    }

    /* renamed from: j */
    private void m7595j() {
        if (C3250y.f11734b) {
            C3250y.m11450b("showPasswordLockActivity", f6898b);
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
        this.f6917k.m11731a();
        if (this.f6928v != null) {
            this.f6928v.dismiss();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7579a(int i) {
        C1891t c1891t;
        boolean zM10540b;
        this.f6916j = i;
        if (this.f6924r.containsKey(Integer.valueOf(i)) && (c1891t = this.f6923q.get(this.f6924r.get(Integer.valueOf(i)))) != null) {
            if (i == 0 || this.f6900B) {
                this.f6929w.setVisibility(8);
            } else {
                this.f6929w.setVisibility(0);
            }
            if (i >= this.f6915i - 1 || this.f6900B) {
                this.f6930x.setVisibility(8);
            } else {
                this.f6930x.setVisibility(0);
            }
            String str = c1891t.f7178e;
            if (c1891t.f7179f == EnumC1455w.IMAGE) {
                zM10540b = C3025f.m10540b(str);
            } else {
                zM10540b = c1891t.f7179f == EnumC1455w.AMS;
            }
            if (this.f6926t != null && this.f6927u != null) {
                if (TextUtils.isEmpty(str) || C0816a.f3113b.equals(str) || str.contains("thumbnail")) {
                    this.f6926t.setEnabled(false);
                    this.f6927u.setEnabled(false);
                } else {
                    if (zM10540b) {
                        this.f6926t.setEnabled(false);
                    } else {
                        this.f6926t.setEnabled(true);
                    }
                    this.f6927u.setEnabled(true);
                }
                C3228cp.m11343a(this.f6926t);
                C3228cp.m11343a(this.f6927u);
            }
            if (this.f6902D) {
                this.f6919m.setVisibility(8);
                if ((c1891t.f7179f == EnumC1455w.IMAGE || c1891t.f7179f == EnumC1455w.AMS) && ((TextUtils.isEmpty(c1891t.f7178e) || C0816a.f3113b.equals(c1891t.f7178e) || c1891t.f7178e.contains("thumbnail")) && this.f6922p.containsKey(Long.valueOf(c1891t.f7175b)))) {
                    ((BackupImagePagerFragment) this.f6922p.get(Long.valueOf(c1891t.f7175b))).m6865b();
                }
            } else {
                this.f6901C = false;
                if (this.f6925s != EnumC1450r.BROADCAST && this.f6925s != EnumC1450r.BROADCAST2 && !TextUtils.isEmpty(c1891t.f7177d) && !TextUtils.isEmpty(this.f6912f) && c1891t.f7177d.split("\n").length > 4 && c1891t.f7180g != -1 && c1891t.f7180g != 0) {
                    this.f6901C = true;
                }
                if (this.f6901C) {
                    if (this.f6900B) {
                        this.f6919m.setVisibility(4);
                    } else {
                        this.f6919m.setVisibility(0);
                    }
                } else {
                    this.f6919m.setVisibility(8);
                }
            }
            if (TextUtils.isEmpty(c1891t.f7181h) || this.f6900B) {
                this.f6932z.setVisibility(4);
                this.f6899A = false;
            } else {
                this.f6932z.setVisibility(0);
                this.f6931y.setText(C1835j.m7508a(this.f6918l, c1891t.f7181h, (int) C3172an.m11085a(30.0f)));
                this.f6931y.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                this.f6899A = true;
            }
        }
    }

    /* renamed from: a */
    protected void m7608a(int i, boolean z) {
        if (this.f6916j == i && this.f6926t != null) {
            this.f6926t.setEnabled(z);
            C3228cp.m11343a(this.f6926t);
        }
    }

    /* renamed from: b */
    protected void m7612b(int i, boolean z) {
        if (this.f6916j == i && this.f6927u != null) {
            this.f6927u.setEnabled(z);
            C3228cp.m11343a(this.f6927u);
        }
    }

    /* renamed from: a */
    protected ViewPager m7607a() {
        return this.f6909c;
    }

    /* renamed from: b */
    protected HashMap<Long, C1891t> m7611b() {
        return this.f6923q;
    }

    /* renamed from: c */
    protected HashMap<Integer, Long> m7613c() {
        return this.f6924r;
    }

    /* renamed from: d */
    public String m7614d() {
        return this.f6911e;
    }

    /* renamed from: e */
    protected C3326c m7615e() {
        return this.f6917k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7580a(long j, String str) {
        C1891t c1891t;
        if (this.f6923q.containsKey(Long.valueOf(j)) && (c1891t = this.f6923q.get(Long.valueOf(j))) != null) {
            c1891t.f7178e = str;
        }
    }

    /* renamed from: l */
    private void m7597l() {
        C1891t c1891t;
        if (!C3197bl.m11159a()) {
            if (!C3223ck.m11331e()) {
                AbstractC3271a.m11494a(this).mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null).mo11512b();
                return;
            }
            if (this.f6924r.containsKey(Integer.valueOf(this.f6916j)) && (c1891t = this.f6923q.get(this.f6924r.get(Integer.valueOf(this.f6916j)))) != null && !TextUtils.isEmpty(c1891t.f7178e)) {
                String str = c1891t.f7178e;
                if (!C3223ck.m11327a()) {
                    C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
                } else {
                    new AsyncTaskC1767a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", false).execute(new String[0]);
                }
            }
        }
    }

    /* renamed from: m */
    private void m7599m() {
        this.f6920n = new C1886o(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f6920n, intentFilter);
        m7602n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7602n() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: o */
    private void m7603o() {
        unregisterReceiver(this.f6920n);
    }

    /* renamed from: a */
    protected void m7610a(long j, ImagePagerFragment imagePagerFragment) {
        this.f6922p.put(Long.valueOf(j), imagePagerFragment);
    }

    /* renamed from: a */
    protected void m7609a(long j) {
        this.f6922p.remove(Long.valueOf(j));
    }

    /* renamed from: f */
    protected Handler m7616f() {
        return this.f6906H;
    }

    /* renamed from: g */
    public Handler m7617g() {
        return this.f6907I;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_pager_menu, menu);
        this.f6926t = menu.findItem(R.id.menu_save);
        this.f6927u = menu.findItem(R.id.menu_share);
        m7579a(this.f6916j);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        C1891t c1891t;
        if (menuItem.getItemId() == R.id.menu_save) {
            m7597l();
        } else if (menuItem.getItemId() == R.id.menu_share && this.f6924r.containsKey(Integer.valueOf(this.f6916j)) && (c1891t = this.f6923q.get(this.f6924r.get(Integer.valueOf(this.f6916j)))) != null) {
            if ((C3159aa.m10962a().m10977a("TrunkShareCheckPopup", (Boolean) false).booleanValue() || !(c1891t.f7179f == EnumC1455w.IMAGE || c1891t.f7179f == EnumC1455w.AMS)) ? false : C3025f.m10540b(c1891t.f7178e)) {
                m7606q();
            } else {
                m7605p();
            }
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m7605p() {
        C1891t c1891t;
        Intent intentM11320a;
        if (!C3197bl.m11159a() && this.f6924r.containsKey(Integer.valueOf(this.f6916j)) && (c1891t = this.f6923q.get(this.f6924r.get(Integer.valueOf(this.f6916j)))) != null && !TextUtils.isEmpty(c1891t.f7178e)) {
            String path = c1891t.f7178e;
            if (c1891t.f7178e.startsWith("file:")) {
                path = Uri.parse(c1891t.f7178e).getPath();
            }
            if (c1891t.f7179f == EnumC1455w.IMAGE || c1891t.f7179f == EnumC1455w.AMS) {
                intentM11320a = C3220ch.m11320a(this, getString(R.string.trunk_opt_header_share), path, (String) null, (String) null);
            } else {
                intentM11320a = c1891t.f7179f == EnumC1455w.VIDEO ? C3220ch.m11326b(this, getString(R.string.trunk_opt_header_share), path, null, null) : null;
            }
            if (intentM11320a != null) {
                startActivity(intentM11320a);
            }
        }
    }

    /* renamed from: q */
    private void m7606q() {
        if (this.f6928v == null) {
            this.f6928v = C3220ch.m11325a(this, new DialogInterfaceOnClickListenerC1889r(this)).mo11505a();
        }
        this.f6928v.show();
    }

    /* renamed from: h */
    protected void m7618h() {
        if (!this.f6900B) {
            if (this.f6927u != null) {
                this.f6927u.setVisible(false);
            }
            if (this.f6926t != null) {
                this.f6926t.setVisible(false);
            }
            this.f6932z.setVisibility(4);
            if (this.f6901C) {
                this.f6919m.setVisibility(4);
            }
            this.f6929w.setVisibility(4);
            this.f6930x.setVisibility(4);
            this.f6900B = true;
            return;
        }
        if (this.f6927u != null) {
            this.f6927u.setVisible(true);
        }
        if (this.f6926t != null) {
            this.f6926t.setVisible(true);
        }
        if (this.f6899A) {
            this.f6932z.setVisibility(0);
        }
        if (this.f6901C) {
            this.f6919m.setVisibility(0);
        }
        if (this.f6916j > 0) {
            this.f6929w.setVisibility(0);
        }
        if (this.f6916j < this.f6915i - 1) {
            this.f6930x.setVisibility(0);
        }
        this.f6900B = false;
    }
}
