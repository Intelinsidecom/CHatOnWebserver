package com.sec.chaton.trunk;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.InterfaceC0196cc;
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
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.plugin.C2921a;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.trunk.database.C4667c;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import com.sec.chaton.trunk.p121c.C4636a;
import com.sec.chaton.trunk.p121c.C4641f;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5052r;
import com.sec.widget.C5179v;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class TrunkPageActivity extends BaseActivity implements InterfaceC4609ba {

    /* renamed from: n */
    public static String f16575n;

    /* renamed from: o */
    public static String f16576o;

    /* renamed from: s */
    private static final String f16577s = TrunkPageActivity.class.getSimpleName();

    /* renamed from: A */
    private C2210x f16578A;

    /* renamed from: B */
    private int f16579B;

    /* renamed from: C */
    private Cursor f16580C;

    /* renamed from: D */
    private int f16581D;

    /* renamed from: E */
    private TextView f16582E;

    /* renamed from: F */
    private TextView f16583F;

    /* renamed from: G */
    private HashMap<Integer, TrunkFullView> f16584G;

    /* renamed from: H */
    private C5007c f16585H;

    /* renamed from: I */
    private Context f16586I;

    /* renamed from: J */
    private View f16587J;

    /* renamed from: K */
    private MenuItem f16588K;

    /* renamed from: L */
    private MenuItem f16589L;

    /* renamed from: M */
    private Menu f16590M;

    /* renamed from: N */
    private ImageView f16591N;

    /* renamed from: O */
    private ImageView f16592O;

    /* renamed from: P */
    private BroadcastReceiver f16593P;

    /* renamed from: Q */
    private LinearLayout f16594Q;

    /* renamed from: R */
    private TextView f16595R;

    /* renamed from: S */
    private boolean f16596S;

    /* renamed from: T */
    private String f16597T;

    /* renamed from: U */
    private Toast f16598U;

    /* renamed from: V */
    private boolean f16599V;

    /* renamed from: W */
    private boolean f16600W;

    /* renamed from: q */
    public boolean f16604q;

    /* renamed from: t */
    private ViewPager f16606t;

    /* renamed from: u */
    private String f16607u;

    /* renamed from: v */
    private String f16608v;

    /* renamed from: w */
    private String f16609w;

    /* renamed from: x */
    private C4644cb f16610x;

    /* renamed from: y */
    private EnumC4642g f16611y;

    /* renamed from: z */
    private EnumC4575b f16612z;

    /* renamed from: p */
    ArrayList<C4645cc> f16603p = new ArrayList<>();

    /* renamed from: X */
    private InterfaceC0196cc f16601X = new C4630bv(this);

    /* renamed from: Y */
    private View.OnClickListener f16602Y = new ViewOnClickListenerC4631bw(this);

    /* renamed from: r */
    InterfaceC2211y f16605r = new C4632bx(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        C4630bv c4630bv = null;
        super.onCreate(bundle);
        f16575n = (C4873ck.m18500a() ? CommonApplication.m18732r().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m18732r().getFilesDir().getAbsolutePath()) + "/AMS/";
        f16576o = f16575n + "amsuserfiles/";
        setContentView(R.layout.layout_image_pager);
        this.f16585H = new C5007c();
        this.f16586I = this;
        this.f16584G = new HashMap<>();
        Bundle extras = getIntent().getExtras();
        this.f16603p.clear();
        this.f16584G.clear();
        this.f16582E = (TextView) findViewById(R.id.index);
        this.f16582E.bringToFront();
        this.f16587J = findViewById(R.id.detailVeiwLayout);
        this.f16594Q = (LinearLayout) findViewById(R.id.descriptionLayout);
        this.f16595R = (TextView) findViewById(R.id.description);
        this.f16583F = (TextView) this.f16587J.findViewById(R.id.text1);
        this.f16587J.setOnClickListener(this.f16602Y);
        this.f16610x = new C4644cb(this, m50e(), c4630bv);
        this.f16606t = (ViewPager) findViewById(R.id.filter_pager);
        this.f16606t.setAdapter(this.f16610x);
        this.f16606t.setOnPageChangeListener(this.f16601X);
        this.f16591N = (ImageView) findViewById(R.id.arrow_left);
        this.f16592O = (ImageView) findViewById(R.id.arrow_right);
        if (bundle != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[restore from onSaveInstanceState]", f16577s);
            }
            this.f16607u = bundle.getString("itemId");
            this.f16608v = bundle.getString("inboxNo");
            this.f16609w = bundle.getString("sessionId");
            this.f16604q = bundle.getBoolean("isvalid");
        } else if (extras != null) {
            this.f16607u = extras.getString("itemId");
            this.f16608v = extras.getString("inboxNo");
            this.f16609w = extras.getString("sessionId");
            this.f16604q = extras.getBoolean("isvalid");
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("ItemId: " + this.f16607u + ", InboxNo: " + this.f16608v + "SessionId: " + this.f16609w + "isValid :" + this.f16604q, f16577s);
        }
        this.f16578A = new C2210x(getContentResolver(), this.f16605r);
        this.f16612z = EnumC4575b.m17529a(C4809aa.m18104a().m18121a("trunkOrderingType", EnumC4575b.UnreadComment.m17530a()));
        if (EnumC4575b.Recent.equals(this.f16612z)) {
            this.f16578A.startQuery(1, null, C4667c.f16901a, null, "session_id=?", new String[]{this.f16609w}, "registration_time DESC");
        } else {
            this.f16578A.startQuery(1, null, C4667c.f16901a, null, "session_id=?", new String[]{this.f16609w}, "last_comment_time DESC");
        }
        this.f16598U = C5179v.m19811a(CommonApplication.m18732r(), (CharSequence) null, 0);
        m18784t().mo18828b(false);
        m18784t().mo18824a(false);
        m18784t().mo18831c(false);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        BaseActivity.m6159a(this);
        this.f16595R.scrollTo(0, 0);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C4645cc c4645cc;
        if (this.f16581D < this.f16603p.size() && (c4645cc = this.f16603p.get(this.f16581D)) != null && c4645cc.f16833f != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[onSaveInstanceState] ItemId: " + c4645cc.f16833f + ", inboxNo: " + this.f16608v, f16577s);
            }
            bundle.putString("itemId", c4645cc.f16833f);
            bundle.putString("inboxNo", this.f16608v);
            bundle.putString("sessionId", this.f16609w);
            bundle.putBoolean("isvalid", this.f16604q);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        if (intent.getBooleanExtra("noUnread", false) && this.f16581D < this.f16603p.size()) {
                            if (!this.f16603p.isEmpty() && this.f16603p.get(this.f16581D) != null) {
                                this.f16603p.get(this.f16581D).f16840m = 0;
                            }
                            m17440b(false);
                            break;
                        }
                    } else {
                        C4904y.m18639b("Inform the item is deleted", f16577s);
                        finish();
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: d */
    private String m17444d(String str) {
        return C5052r.m19199a(C4636a.m17603a(), File.separator, str);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        m17452j();
        if (this.f16578A != null && this.f16584G != null && !this.f16584G.isEmpty() && this.f16584G.get(Integer.valueOf(this.f16581D)) != null) {
            this.f16578A.startQuery(2, null, C4667c.f16901a, null, "item_id=?", new String[]{this.f16584G.get(Integer.valueOf(this.f16581D)).m17348f()}, null);
        }
        super.onResume();
        BaseActivity.m6159a(this);
        m17456m();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m17455l();
        super.onPause();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f16585H.m19014a();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17434a(int i) throws Resources.NotFoundException {
        this.f16581D = i;
        if (i < this.f16603p.size()) {
            C4645cc c4645cc = this.f16603p.get(i);
            if (c4645cc != null) {
                this.f16582E.setText("" + (i + 1) + "/" + this.f16579B);
                if (i == 0 || this.f16599V) {
                    this.f16591N.setVisibility(8);
                } else {
                    this.f16591N.setVisibility(0);
                }
                if (i >= this.f16579B - 1 || this.f16599V) {
                    this.f16592O.setVisibility(8);
                } else {
                    this.f16592O.setVisibility(0);
                }
                m17438b(c4645cc.f16837j);
                if (c4645cc.f16840m > 0) {
                    m17440b(true);
                } else {
                    m17440b(false);
                }
                if (c4645cc.f16839l != null) {
                    this.f16594Q.setVisibility(0);
                    CharSequence charSequenceM11709a = C2799k.m11709a(getApplicationContext(), c4645cc.f16839l, (int) C5034k.m19088a(30.0f));
                    this.f16595R.setText(charSequenceM11709a);
                    this.f16597T = charSequenceM11709a.toString();
                    this.f16596S = true;
                } else {
                    this.f16596S = false;
                    this.f16594Q.setVisibility(8);
                }
                if ("true".equals(c4645cc.f16834g) || C4641f.m17617b(m17433a(c4645cc))) {
                    this.f16600W = true;
                } else {
                    this.f16600W = false;
                }
            }
            m17456m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17438b(int i) {
        this.f16583F.setText(String.valueOf(i));
    }

    /* renamed from: f */
    public ArrayList<C4645cc> m17462f() {
        return this.f16603p;
    }

    /* renamed from: g */
    public ViewPager m17463g() {
        return this.f16606t;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) throws Resources.NotFoundException {
        getMenuInflater().inflate(R.menu.image_pager_menu, menu);
        this.f16590M = menu;
        this.f16588K = menu.findItem(R.id.menu_save);
        this.f16589L = menu.findItem(R.id.menu_share);
        m17434a(this.f16581D);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (this.f16581D < this.f16603p.size()) {
            C4645cc c4645cc = this.f16603p.get(this.f16581D);
            String strM17433a = m17433a(c4645cc);
            this.f16611y = c4645cc.f16836i;
            switch (menuItem.getItemId()) {
                case R.id.menu_share /* 2131166708 */:
                    if (!C4847bl.m18334a(600L)) {
                        if (("true".equals(c4645cc.f16834g) || C4641f.m17617b(strM17433a)) && !C4809aa.m18104a().m18119a("TrunkShareCheckPopup", (Boolean) false).booleanValue()) {
                            m17460c(strM17433a);
                            break;
                        } else {
                            m17446e(strM17433a);
                            break;
                        }
                    }
                    break;
                case R.id.menu_save /* 2131166709 */:
                    if (strM17433a != null && !this.f16600W) {
                        m17459b(strM17433a);
                        break;
                    }
                    break;
            }
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: j */
    private void m17452j() {
        this.f16593P = new C4633by(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f16593P, intentFilter);
        m17454k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17454k() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: l */
    private void m17455l() {
        unregisterReceiver(this.f16593P);
    }

    @Override // com.sec.chaton.trunk.InterfaceC4609ba
    /* renamed from: a */
    public void mo17458a(EnumC4642g enumC4642g, String str) {
        Intent intent = new Intent();
        if (enumC4642g == EnumC4642g.IMAGE) {
            if (C4641f.m17617b(str)) {
                if (C4822an.m18206P() || C4822an.m18207Q()) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    return;
                } else {
                    if (C2948h.m12190a().m12192a(this, EnumC2949i.Animessage)) {
                        startActivityForResult(C2921a.m12139a(this, str), 1);
                        return;
                    }
                    AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(this);
                    abstractC4932aM18733a.mo18734a(R.string.media_animessage).mo18746b(R.string.ams_install_message).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4634bz(this)).mo18747b(R.string.dialog_cancel, (DialogInterface.OnClickListener) null);
                    abstractC4932aM18733a.mo18752b();
                    return;
                }
            }
            return;
        }
        if (enumC4642g == EnumC4642g.VIDEO && C4873ck.m18500a()) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(Uri.fromFile(new File(str)).toString()), "video/*");
            intent.putExtra("android.intent.extra.finishOnCompletion", false);
        }
        try {
            startActivityForResult(intent, 1);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f16577s);
            }
        }
    }

    /* renamed from: a */
    private String m17433a(C4645cc c4645cc) {
        try {
            return C5052r.m19199a(m17444d(this.f16608v), File.separator, C4641f.m17615a(c4645cc.f16835h));
        } catch (MalformedURLException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f16577s);
            }
            return "";
        }
    }

    /* renamed from: b */
    public void m17459b(String str) {
        if (!C4847bl.m18333a()) {
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(this, R.string.sdcard_not_found, 0).show();
            } else if (!C4873ck.m18504e()) {
                AbstractC4932a.m18733a(this).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
            } else {
                AsyncTaskC2751a.m11541a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", null, false).execute(new String[0]);
            }
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4609ba
    /* renamed from: a */
    public void mo17457a() {
        finish();
    }

    /* renamed from: c */
    public void m17460c(String str) {
        C4869cg.m18497a(this, new DialogInterfaceOnClickListenerC4643ca(this, str)).mo18752b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m17446e(String str) {
        Intent intentM18494a = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            C5179v.m19811a(this, getString(R.string.toast_sdcard_amount), 1).show();
            return;
        }
        if (this.f16611y == EnumC4642g.IMAGE || this.f16611y == EnumC4642g.AMS) {
            intentM18494a = C4869cg.m18494a((Context) this, getString(R.string.trunk_opt_header_share), str, this.f16597T, (String) null, false);
        } else if (this.f16611y == EnumC4642g.VIDEO) {
            intentM18494a = C4869cg.m18492a(this, getString(R.string.trunk_opt_header_share), str, this.f16597T, (String) null);
        }
        if (intentM18494a != null) {
            startActivityForResult(intentM18494a, 2);
        }
    }

    /* renamed from: h */
    protected void m17464h() {
        if (!this.f16599V) {
            if (this.f16589L != null && this.f16588K != null) {
                this.f16589L.setVisible(false);
                this.f16588K.setVisible(false);
            }
            this.f16587J.setVisibility(4);
            this.f16591N.setVisibility(4);
            this.f16592O.setVisibility(4);
            this.f16582E.setVisibility(4);
            if (this.f16596S) {
                this.f16594Q.setVisibility(8);
            }
            this.f16599V = true;
            return;
        }
        if (this.f16589L != null && this.f16588K != null) {
            this.f16589L.setVisible(true);
            this.f16588K.setVisible(true);
            m17456m();
        }
        this.f16587J.setVisibility(0);
        if (this.f16581D > 0) {
            this.f16591N.setVisibility(0);
        }
        if (this.f16581D < this.f16579B - 1) {
            this.f16592O.setVisibility(0);
        }
        this.f16582E.setVisibility(0);
        if (this.f16596S) {
            this.f16594Q.setVisibility(0);
        }
        this.f16599V = false;
    }

    /* renamed from: b */
    private void m17440b(boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (z) {
            drawable = this.f16586I.getResources().getDrawable(R.drawable.trunk_ic_comment_unread_chats);
        } else {
            drawable = this.f16586I.getResources().getDrawable(R.drawable.trunk_ic_comment_read);
        }
        if (this.f16583F != null) {
            this.f16583F.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.sec.chaton.trunk.InterfaceC4609ba
    /* renamed from: d_ */
    public void mo17461d_(boolean z) {
        this.f16600W = z;
        m17456m();
    }

    /* renamed from: m */
    private void m17456m() {
        if (this.f16588K != null) {
            if (this.f16600W) {
                this.f16588K.setVisible(false);
            } else {
                this.f16588K.setVisible(true);
            }
        }
        if (this.f16584G != null && !this.f16584G.isEmpty() && this.f16584G.get(Integer.valueOf(this.f16581D)) != null) {
            if (this.f16588K != null) {
                this.f16588K.setEnabled(this.f16584G.get(Integer.valueOf(this.f16581D)).m17346c());
                C4880cr.m18523a(this.f16588K);
            }
            if (this.f16589L != null) {
                this.f16589L.setEnabled(this.f16584G.get(Integer.valueOf(this.f16581D)).m17347d());
                C4880cr.m18523a(this.f16589L);
            }
        }
    }
}
