package com.sec.chaton.multimedia.image;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.InterfaceC0196cc;
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
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ImagePagerActivity extends BaseActivity {

    /* renamed from: o */
    private static final String f10196o = ImagePagerActivity.class.getSimpleName();

    /* renamed from: A */
    private View f10197A;

    /* renamed from: B */
    private BroadcastReceiver f10198B;

    /* renamed from: C */
    private boolean f10199C;

    /* renamed from: G */
    private EnumC2300t f10203G;

    /* renamed from: H */
    private MenuItem f10204H;

    /* renamed from: I */
    private MenuItem f10205I;

    /* renamed from: J */
    private InterfaceC4936e f10206J;

    /* renamed from: K */
    private ImageView f10207K;

    /* renamed from: L */
    private ImageView f10208L;

    /* renamed from: M */
    private TextView f10209M;

    /* renamed from: N */
    private LinearLayout f10210N;

    /* renamed from: O */
    private boolean f10211O;

    /* renamed from: P */
    private boolean f10212P;

    /* renamed from: Q */
    private boolean f10213Q;

    /* renamed from: R */
    private boolean f10214R;

    /* renamed from: S */
    private TextView f10215S;

    /* renamed from: p */
    private ViewPager f10221p;

    /* renamed from: q */
    private long f10222q;

    /* renamed from: r */
    private String f10223r;

    /* renamed from: s */
    private String f10224s;

    /* renamed from: t */
    private C2859s f10225t;

    /* renamed from: u */
    private C2210x f10226u;

    /* renamed from: v */
    private int f10227v;

    /* renamed from: w */
    private int f10228w;

    /* renamed from: x */
    private TextView f10229x;

    /* renamed from: y */
    private C5007c f10230y;

    /* renamed from: z */
    private Context f10231z;

    /* renamed from: D */
    private HashMap<Long, ImagePagerFragment> f10200D = new HashMap<>();

    /* renamed from: E */
    private HashMap<Long, C2860t> f10201E = new HashMap<>();

    /* renamed from: F */
    private HashMap<Integer, Long> f10202F = new HashMap<>();

    /* renamed from: T */
    private InterfaceC0196cc f10216T = new C2852l(this);

    /* renamed from: U */
    private View.OnClickListener f10217U = new ViewOnClickListenerC2853m(this);

    /* renamed from: n */
    InterfaceC2211y f10220n = new C2854n(this);

    /* renamed from: V */
    private Handler f10218V = new HandlerC2856p(this);

    /* renamed from: W */
    private Handler f10219W = new HandlerC2857q(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        Uri uri;
        super.onCreate(bundle);
        setContentView(R.layout.layout_image_pager);
        this.f10230y = new C5007c();
        this.f10231z = this;
        Bundle extras = getIntent().getExtras();
        this.f10229x = (TextView) findViewById(R.id.index);
        this.f10229x.bringToFront();
        this.f10197A = findViewById(R.id.detailVeiwLayout);
        this.f10197A.setOnClickListener(this.f10217U);
        this.f10215S = (TextView) this.f10197A.findViewById(R.id.text1);
        this.f10225t = new C2859s(this, m50e(), null);
        this.f10221p = (ViewPager) findViewById(R.id.filter_pager);
        this.f10221p.setAdapter(this.f10225t);
        this.f10221p.setOnPageChangeListener(this.f10216T);
        this.f10207K = (ImageView) findViewById(R.id.arrow_left);
        this.f10208L = (ImageView) findViewById(R.id.arrow_right);
        this.f10210N = (LinearLayout) findViewById(R.id.descriptionLayout);
        this.f10209M = (TextView) findViewById(R.id.description);
        if (bundle != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[restore from onSaveInstanceState]", f10196o);
            }
            this.f10222q = bundle.getLong("messageId");
            this.f10223r = bundle.getString("inboxNo");
            this.f10199C = bundle.getBoolean("isValid");
            this.f10203G = EnumC2300t.m10207a(bundle.getInt("chatType"));
            this.f10214R = bundle.getBoolean("backup");
            this.f10224s = bundle.getString("sessionID");
        } else if (extras != null) {
            this.f10222q = extras.getLong("messageId");
            this.f10223r = extras.getString("inboxNo");
            this.f10199C = extras.getBoolean("isValid");
            this.f10203G = EnumC2300t.m10207a(extras.getInt("chatType"));
            this.f10214R = extras.getBoolean("backup");
            this.f10224s = extras.getString("sessionID");
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("messageId: " + this.f10222q + ", mInboxNo: " + this.f10223r, f10196o);
        }
        if (this.f10203G == EnumC2300t.BROADCAST) {
            this.f10197A.setVisibility(8);
        }
        this.f10226u = new C2210x(getContentResolver(), this.f10220n);
        if (this.f10214R) {
            uri = C2543a.f9146a;
        } else {
            uri = C2306z.f8229a;
        }
        this.f10226u.startQuery(1, null, uri, null, "message_inbox_no=? AND ( message_content_type=? OR message_content_type=? OR message_content_type=? ) AND message_is_truncated = 'N'", new String[]{this.f10223r, String.valueOf(EnumC2214ab.AMS.m10076a()), String.valueOf(EnumC2214ab.VIDEO.m10076a()), String.valueOf(EnumC2214ab.IMAGE.m10076a())}, "message_is_failed , message_time , _id");
        m18784t().mo18828b(false);
        m18784t().mo18824a(false);
        m18784t().mo18831c(false);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        C2860t c2860t;
        if (this.f10202F.containsKey(Integer.valueOf(this.f10228w)) && (c2860t = this.f10201E.get(this.f10202F.get(Integer.valueOf(this.f10228w)))) != null && c2860t.f10495b > 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[onSaveInstanceState] messageId: " + c2860t.f10495b + ", inboxNo: " + this.f10223r, f10196o);
            }
            bundle.putLong("messageId", c2860t.f10495b);
            bundle.putString("inboxNo", this.f10223r);
            bundle.putBoolean("isValid", this.f10199C);
            bundle.putInt("chatType", this.f10203G.m10210a());
            bundle.putBoolean("backup", this.f10214R);
            bundle.putString("sessionID", this.f10224s);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m11806q();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m11783a(Cursor cursor) {
        int i = 0;
        int i2 = 0;
        while (cursor.moveToNext()) {
            String string = cursor.getString(cursor.getColumnIndex("message_sender"));
            long j = cursor.getLong(cursor.getColumnIndex("message_sever_id"));
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_content"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC2214ab enumC2214abM10070a = EnumC2214ab.m10070a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            int i3 = cursor.getInt(cursor.getColumnIndex("message_type"));
            int i4 = this.f10222q == j ? i2 : i;
            C2860t c2860t = new C2860t(this, string, j, j2, string2, string3, enumC2214abM10070a, i3);
            if (C4904y.f17872b) {
                C4904y.m18639b("add item : " + c2860t, f10196o);
            }
            this.f10202F.put(Integer.valueOf(i2), Long.valueOf(j));
            this.f10201E.put(Long.valueOf(j), c2860t);
            i2++;
            i = i4;
        }
        return i;
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m11808s();
        super.onPause();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f10230y.m19014a();
        if (this.f10206J != null) {
            this.f10206J.dismiss();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11786a(int i) {
        C2860t c2860t;
        this.f10228w = i;
        if (this.f10202F.containsKey(Integer.valueOf(i)) && (c2860t = this.f10201E.get(this.f10202F.get(Integer.valueOf(i)))) != null) {
            this.f10229x.setText("" + (i + 1) + "/" + this.f10227v);
            if (i == 0 || this.f10212P) {
                this.f10207K.setVisibility(8);
            } else {
                this.f10207K.setVisibility(0);
            }
            if (i >= this.f10227v - 1 || this.f10212P) {
                this.f10208L.setVisibility(8);
            } else {
                this.f10208L.setVisibility(0);
            }
            String str = c2860t.f10498e;
            boolean z = c2860t.f10499f == EnumC2214ab.AMS;
            if (TextUtils.isEmpty(str) || C1427a.f5066d.equals(str) || str.contains("thumbnail")) {
                m11812a(this.f10228w, false);
                m11817c(this.f10228w, false);
            } else {
                m11812a(this.f10228w, true);
                m11817c(this.f10228w, true);
            }
            if (z || this.f10212P) {
                m11815b(this.f10228w, false);
            } else {
                m11815b(this.f10228w, true);
            }
            C4880cr.m18523a(this.f10204H);
            C4880cr.m18523a(this.f10205I);
            if ((c2860t.f10499f == EnumC2214ab.IMAGE || c2860t.f10499f == EnumC2214ab.AMS) && ((TextUtils.isEmpty(c2860t.f10498e) || C1427a.f5066d.equals(c2860t.f10498e) || c2860t.f10498e.contains("thumbnail")) && this.f10200D.containsKey(Long.valueOf(c2860t.f10495b)))) {
                this.f10200D.get(Long.valueOf(c2860t.f10495b)).mo10895a();
            }
            if (this.f10214R) {
                this.f10197A.setVisibility(8);
            } else {
                this.f10213Q = false;
                if (this.f10203G != EnumC2300t.TOPIC && this.f10203G != EnumC2300t.BROADCAST && !TextUtils.isEmpty(c2860t.f10497d) && !TextUtils.isEmpty(this.f10224s) && c2860t.f10497d.split("\n").length > 4 && c2860t.f10500g != -1 && c2860t.f10500g != 0) {
                    this.f10213Q = true;
                }
                if (this.f10213Q) {
                    if (this.f10212P) {
                        this.f10197A.setVisibility(4);
                    } else {
                        this.f10197A.setVisibility(0);
                    }
                } else {
                    this.f10197A.setVisibility(8);
                }
            }
            if (TextUtils.isEmpty(c2860t.f10501h)) {
                this.f10211O = false;
            } else {
                this.f10211O = true;
                this.f10209M.setText(C2799k.m11709a(this.f10231z, c2860t.f10501h, (int) C5034k.m19088a(30.0f)));
                this.f10209M.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            }
            if (!this.f10211O || this.f10212P) {
                this.f10210N.setVisibility(4);
            } else {
                this.f10210N.setVisibility(0);
            }
            this.f10215S.setVisibility(4);
            if (!this.f10214R && this.f10197A.isShown() && this.f10200D.containsKey(Long.valueOf(c2860t.f10495b))) {
                ImagePagerFragment imagePagerFragment = this.f10200D.get(Long.valueOf(c2860t.f10495b));
                if (imagePagerFragment.m11846f() > -1) {
                    this.f10215S.setVisibility(0);
                    this.f10215S.setText(String.valueOf(imagePagerFragment.m11846f()));
                }
            }
        }
    }

    /* renamed from: a */
    protected void m11812a(int i, boolean z) {
        if (this.f10228w == i && this.f10204H != null) {
            this.f10204H.setEnabled(z);
            C4880cr.m18523a(this.f10204H);
        }
    }

    /* renamed from: b */
    protected void m11815b(int i, boolean z) {
        if (this.f10228w == i && this.f10204H != null) {
            this.f10204H.setVisible(z);
        }
    }

    /* renamed from: c */
    protected void m11817c(int i, boolean z) {
        if (this.f10228w == i && this.f10205I != null) {
            this.f10205I.setEnabled(z);
            C4880cr.m18523a(this.f10205I);
        }
    }

    /* renamed from: f */
    protected ViewPager m11818f() {
        return this.f10221p;
    }

    /* renamed from: g */
    protected HashMap<Long, C2860t> m11819g() {
        return this.f10201E;
    }

    /* renamed from: h */
    protected HashMap<Integer, Long> m11820h() {
        return this.f10202F;
    }

    /* renamed from: i */
    public String m11821i() {
        return this.f10223r;
    }

    /* renamed from: j */
    protected C5007c m11822j() {
        return this.f10230y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11787a(long j, String str) {
        C2860t c2860t;
        if (this.f10201E.containsKey(Long.valueOf(j)) && (c2860t = this.f10201E.get(Long.valueOf(j))) != null) {
            c2860t.f10498e = str;
        }
    }

    /* renamed from: p */
    private void m11805p() {
        C2860t c2860t;
        if (!C4847bl.m18333a()) {
            if (!C4873ck.m18504e()) {
                AbstractC4932a.m18733a(this).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
                return;
            }
            if (this.f10202F.containsKey(Integer.valueOf(this.f10228w)) && (c2860t = this.f10201E.get(this.f10202F.get(Integer.valueOf(this.f10228w)))) != null && !TextUtils.isEmpty(c2860t.f10498e)) {
                String str = c2860t.f10498e;
                if (!C4873ck.m18500a()) {
                    C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
                } else {
                    AsyncTaskC2751a.m11541a(str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", null, false).execute(new String[0]);
                }
            }
        }
    }

    /* renamed from: q */
    private void m11806q() {
        this.f10198B = new C2855o(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10198B, intentFilter);
        m11807r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m11807r() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: s */
    private void m11808s() {
        unregisterReceiver(this.f10198B);
    }

    /* renamed from: a */
    protected void m11814a(long j, ImagePagerFragment imagePagerFragment) {
        this.f10200D.put(Long.valueOf(j), imagePagerFragment);
    }

    /* renamed from: a */
    protected void m11813a(long j) {
        this.f10200D.remove(Long.valueOf(j));
    }

    /* renamed from: k */
    protected Handler m11823k() {
        return this.f10218V;
    }

    /* renamed from: l */
    public Handler m11824l() {
        return this.f10219W;
    }

    /* renamed from: m */
    public String m11825m() {
        return this.f10224s;
    }

    /* renamed from: n */
    public boolean m11826n() {
        return this.f10214R;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_pager_menu, menu);
        this.f10204H = menu.findItem(R.id.menu_save);
        this.f10205I = menu.findItem(R.id.menu_share);
        m11786a(this.f10228w);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        C2860t c2860t;
        if (menuItem.getItemId() == R.id.menu_save) {
            m11805p();
        } else if (menuItem.getItemId() == R.id.menu_share && this.f10202F.containsKey(Integer.valueOf(this.f10228w)) && (c2860t = this.f10201E.get(this.f10202F.get(Integer.valueOf(this.f10228w)))) != null) {
            if (!C4809aa.m18104a().m18119a("TrunkShareCheckPopup", (Boolean) false).booleanValue() && c2860t.f10499f == EnumC2214ab.AMS) {
                m11810v();
            } else {
                m11809u();
            }
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m11809u() {
        C2860t c2860t;
        Intent intentM18494a = null;
        if (!C4847bl.m18333a() && this.f10202F.containsKey(Integer.valueOf(this.f10228w)) && (c2860t = this.f10201E.get(this.f10202F.get(Integer.valueOf(this.f10228w)))) != null && !TextUtils.isEmpty(c2860t.f10498e)) {
            String path = c2860t.f10498e;
            if (c2860t.f10498e.startsWith("file")) {
                path = Uri.parse(c2860t.f10498e).getPath();
            }
            String strM8654f = C1736gi.m8654f(c2860t.f10497d);
            if (c2860t.f10499f == EnumC2214ab.IMAGE || c2860t.f10499f == EnumC2214ab.AMS) {
                intentM18494a = C4869cg.m18494a((Context) this, getString(R.string.trunk_opt_header_share), path, strM8654f, (String) null, false);
            } else if (c2860t.f10499f == EnumC2214ab.VIDEO) {
                intentM18494a = C4869cg.m18492a(this, getString(R.string.trunk_opt_header_share), path, strM8654f, (String) null);
            }
            if (intentM18494a != null) {
                startActivity(intentM18494a);
            }
        }
    }

    /* renamed from: v */
    private void m11810v() {
        if (this.f10206J == null) {
            this.f10206J = C4869cg.m18497a(this, new DialogInterfaceOnClickListenerC2858r(this)).mo18745a();
        }
        this.f10206J.show();
    }

    /* renamed from: b */
    protected void m11816b(boolean z) {
        if (!this.f10212P) {
            if (this.f10205I != null) {
                this.f10205I.setVisible(false);
            }
            if (this.f10204H != null) {
                this.f10204H.setVisible(false);
            }
            this.f10210N.setVisibility(4);
            if (this.f10213Q) {
                this.f10197A.setVisibility(4);
            }
            this.f10207K.setVisibility(4);
            this.f10208L.setVisibility(4);
            this.f10229x.setVisibility(4);
            this.f10212P = true;
            return;
        }
        if (this.f10205I != null) {
            this.f10205I.setVisible(true);
        }
        if (this.f10204H != null && !z) {
            this.f10204H.setVisible(true);
        }
        if (this.f10211O) {
            this.f10210N.setVisibility(0);
        }
        if (this.f10213Q) {
            this.f10197A.setVisibility(0);
        }
        if (this.f10228w > 0) {
            this.f10207K.setVisibility(0);
        }
        if (this.f10228w < this.f10227v - 1) {
            this.f10208L.setVisibility(0);
        }
        this.f10229x.setVisibility(0);
        this.f10212P = false;
    }

    /* renamed from: a */
    public void m11811a(int i, int i2) {
        if (this.f10228w == i) {
            this.f10215S.setVisibility(0);
            this.f10215S.setText(String.valueOf(i2));
        }
    }
}
