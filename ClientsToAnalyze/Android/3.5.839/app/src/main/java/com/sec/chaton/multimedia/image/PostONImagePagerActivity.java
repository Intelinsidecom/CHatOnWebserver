package com.sec.chaton.multimedia.image;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
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
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;
import com.sec.chaton.p057e.C2221ai;
import com.sec.chaton.p057e.C2224al;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.poston.PostONDetailFragment;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4869cg;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.p132g.C5007c;
import com.sec.widget.C5179v;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PostONImagePagerActivity extends BaseActivity implements InterfaceC2835at {

    /* renamed from: o */
    private static final String f10266o = PostONImagePagerActivity.class.getSimpleName();

    /* renamed from: p */
    private static String f10267p = C4873ck.m18502c() + "/poston/";

    /* renamed from: A */
    private Context f10268A;

    /* renamed from: B */
    private View f10269B;

    /* renamed from: C */
    private BroadcastReceiver f10270C;

    /* renamed from: H */
    private MenuItem f10275H;

    /* renamed from: I */
    private MenuItem f10276I;

    /* renamed from: J */
    private TextView f10277J;

    /* renamed from: K */
    private InterfaceC4936e f10278K;

    /* renamed from: L */
    private ImageView f10279L;

    /* renamed from: M */
    private ImageView f10280M;

    /* renamed from: N */
    private TextView f10281N;

    /* renamed from: O */
    private boolean f10282O;

    /* renamed from: P */
    private C2210x f10283P;

    /* renamed from: Q */
    private LinearLayout f10284Q;

    /* renamed from: R */
    private boolean f10285R;

    /* renamed from: S */
    private String f10286S;

    /* renamed from: q */
    private ViewPager f10293q;

    /* renamed from: r */
    private C2827al f10294r;

    /* renamed from: s */
    private String f10295s;

    /* renamed from: t */
    private String f10296t;

    /* renamed from: u */
    private String f10297u;

    /* renamed from: v */
    private String f10298v;

    /* renamed from: w */
    private int f10299w;

    /* renamed from: x */
    private String f10300x;

    /* renamed from: y */
    private TextView f10301y;

    /* renamed from: z */
    private C5007c f10302z;

    /* renamed from: n */
    public int f10292n = 2;

    /* renamed from: D */
    private HashMap<String, PostONImagePagerFragment> f10271D = new HashMap<>();

    /* renamed from: E */
    private HashMap<String, C2828am> f10272E = new HashMap<>();

    /* renamed from: F */
    private HashMap<Integer, String> f10273F = new HashMap<>();

    /* renamed from: G */
    private HashMap<String, String> f10274G = new HashMap<>();

    /* renamed from: T */
    private InterfaceC0196cc f10287T = new C2821af(this);

    /* renamed from: U */
    private View.OnClickListener f10288U = new ViewOnClickListenerC2822ag(this);

    /* renamed from: V */
    private ContentObserver f10289V = new C2823ah(this, new Handler());

    /* renamed from: W */
    private InterfaceC2211y f10290W = new C2824ai(this);

    /* renamed from: X */
    private Handler f10291X = new HandlerC2826ak(this);

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_image_pager);
        this.f10302z = new C5007c();
        this.f10268A = this;
        this.f10296t = C4809aa.m18104a().m18121a("chaton_id", "");
        this.f10283P = new C2210x(getContentResolver(), this.f10290W);
        Bundle extras = getIntent().getExtras();
        this.f10301y = (TextView) findViewById(R.id.index);
        this.f10301y.bringToFront();
        this.f10269B = findViewById(R.id.detailVeiwLayout);
        this.f10269B.setOnClickListener(this.f10288U);
        this.f10284Q = (LinearLayout) findViewById(R.id.descriptionLayout);
        this.f10294r = new C2827al(this, m50e(), null);
        this.f10293q = (ViewPager) findViewById(R.id.filter_pager);
        this.f10293q.setAdapter(this.f10294r);
        this.f10293q.setOnPageChangeListener(this.f10287T);
        this.f10279L = (ImageView) findViewById(R.id.arrow_left);
        this.f10280M = (ImageView) findViewById(R.id.arrow_right);
        this.f10281N = (TextView) findViewById(R.id.description);
        this.f10277J = (TextView) this.f10269B.findViewById(R.id.text1);
        if (bundle != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[restore from onSaveInstanceState]", f10266o);
            }
            this.f10295s = bundle.getString("buddyId");
            this.f10297u = bundle.getString("url");
        } else if (extras != null) {
            this.f10295s = extras.getString("buddyId");
            this.f10297u = extras.getString("url");
        }
        if (this.f10295s == null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("mBuddyId is null. Finishing activity.", f10266o);
            }
            finish();
            return;
        }
        if (this.f10295s.equals(this.f10296t)) {
            this.f10283P.startQuery(this.f10292n, null, C2224al.f7950b, null, "poston_metatype=? OR poston_metatype=? OR poston_metatype=?", new String[]{Spam.ACTIVITY_REPORT, Spam.ACTIVITY_CHECK, "3"}, null);
        } else {
            this.f10283P.startQuery(this.f10292n, null, C2221ai.f7944b, null, "poston_metatype=? OR poston_metatype=? OR poston_metatype=?", new String[]{Spam.ACTIVITY_REPORT, Spam.ACTIVITY_CHECK, "3"}, null);
        }
        if (this.f10295s.equals(this.f10296t)) {
            getContentResolver().registerContentObserver(C2224al.f7949a, true, this.f10289V);
        } else {
            getContentResolver().registerContentObserver(C2221ai.f7943a, true, this.f10289V);
        }
        this.f10298v = f10267p + this.f10295s;
        m18784t().mo18828b(false);
        m18784t().mo18824a(false);
        m18784t().mo18831c(false);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f10273F.containsKey(Integer.valueOf(m11880j()))) {
            C2828am c2828am = this.f10272E.get(this.f10273F.get(Integer.valueOf(m11880j())));
            if (C4904y.f17872b) {
                C4904y.m18639b("[onSaveInstanceState] postonNo: " + c2828am.f10398a, f10266o);
            }
            bundle.putString("buddyId", this.f10295s);
            bundle.putString("url", this.f10297u);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(PostONDetailFragment.f10874g, this.f10286S);
        intent.putExtra(PostONDetailFragment.f10875h, this.f10285R);
        setResult(-1, intent);
        finish();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    if (intent.getExtras().getBoolean("IS_DELETED")) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("Inform the item is deleted", f10266o);
                        }
                        finish();
                        break;
                    } else {
                        if (intent.getExtras().getBoolean("POSTON_HAS_CHANGED")) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("POSTON_HAS_CHANGED", true);
                            setResult(-1, intent2);
                            finish();
                        }
                        if (intent.getExtras().getBoolean(PostONDetailFragment.f10875h)) {
                            Intent intent3 = new Intent();
                            intent3.putExtra(PostONDetailFragment.f10875h, true);
                            setResult(-1, intent3);
                            finish();
                            break;
                        } else {
                            this.f10286S = intent.getExtras().getString(PostONDetailFragment.f10874g);
                            this.f10285R = intent.getExtras().getBoolean(PostONDetailFragment.f10875h);
                            if (!TextUtils.isEmpty(this.f10286S)) {
                                this.f10277J.setText(this.f10286S);
                                if (this.f10273F.containsKey(Integer.valueOf(this.f10299w))) {
                                    String str = this.f10273F.get(Integer.valueOf(this.f10299w));
                                    if (this.f10272E.containsKey(str)) {
                                        C2828am c2828am = this.f10272E.get(str);
                                        c2828am.f10406i = this.f10286S;
                                        c2828am.f10407j = Spam.ACTIVITY_CANCEL;
                                        m11855d(c2828am.f10407j);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    /* renamed from: d */
    private void m11855d(String str) {
        if (!TextUtils.isEmpty(str) && Integer.parseInt(str) > 0) {
            this.f10277J.setCompoundDrawablesWithIntrinsicBounds(R.drawable.trunk_ic_comment_unread_chats, 0, 0, 0);
        } else {
            this.f10277J.setCompoundDrawablesWithIntrinsicBounds(R.drawable.trunk_ic_comment_read, 0, 0, 0);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        m11866n();
        if (this.f10295s.equals(this.f10296t)) {
            getContentResolver().registerContentObserver(C2224al.f7949a, true, this.f10289V);
        } else {
            getContentResolver().registerContentObserver(C2221ai.f7943a, true, this.f10289V);
        }
        super.onResume();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        m11868p();
        getContentResolver().unregisterContentObserver(this.f10289V);
        super.onPause();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.f10302z.m19014a();
        if (this.f10278K != null) {
            this.f10278K.dismiss();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11849a(int i) {
        C2828am c2828am;
        this.f10299w = i;
        if (this.f10273F.containsKey(Integer.valueOf(i)) && (c2828am = this.f10272E.get(this.f10273F.get(Integer.valueOf(i)))) != null) {
            this.f10300x = c2828am.f10398a;
            this.f10301y.setText("" + (i + 1) + "/" + this.f10273F.size());
            if (i == 0 || this.f10282O) {
                this.f10279L.setVisibility(8);
            } else {
                this.f10279L.setVisibility(0);
            }
            if (i >= this.f10273F.size() - 1 || this.f10282O) {
                this.f10280M.setVisibility(8);
            } else {
                this.f10280M.setVisibility(0);
            }
            String str = c2828am.f10401d;
            if (this.f10275H != null && this.f10276I != null) {
                File fileM11873b = m11873b(str);
                if (fileM11873b != null && fileM11873b.exists()) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("position updateCurrentPageInfo : " + this.f10299w, f10266o);
                    }
                    m11870a(this.f10299w, true);
                    m11874b(this.f10299w, true);
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("position updateCurrentPageInfo No file : " + this.f10299w, f10266o);
                    }
                    m11870a(this.f10299w, false);
                    m11874b(this.f10299w, false);
                }
            }
            this.f10281N.setText(c2828am.f10402e);
            if (this.f10282O) {
                this.f10269B.setVisibility(4);
                this.f10284Q.setVisibility(4);
            } else {
                this.f10269B.setVisibility(0);
                if (this.f10281N.getText().length() > 0) {
                    this.f10284Q.setVisibility(0);
                } else {
                    this.f10284Q.setVisibility(4);
                }
            }
            this.f10277J.setText(c2828am.m11925a());
            m11855d(c2828am.f10407j);
        }
    }

    /* renamed from: b */
    public File m11873b(String str) {
        int iLastIndexOf;
        if (str == null || (iLastIndexOf = str.lastIndexOf(47)) <= 0) {
            return null;
        }
        return new File(this.f10298v, str.substring(iLastIndexOf + 1));
    }

    /* renamed from: a */
    protected void m11870a(int i, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("PostON enable svve position : " + i + " // mCurrentIndex : " + this.f10299w, f10266o);
        }
        if (this.f10299w == i && this.f10275H != null) {
            this.f10275H.setEnabled(z);
            C4880cr.m18523a(this.f10275H);
        }
    }

    /* renamed from: b */
    protected void m11874b(int i, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("PostON enable share position : " + i + " // mCurrentIndex : " + this.f10299w, f10266o);
        }
        if (this.f10299w == i && this.f10276I != null) {
            this.f10276I.setEnabled(z);
            C4880cr.m18523a(this.f10276I);
        }
    }

    /* renamed from: f */
    protected ViewPager m11876f() {
        return this.f10293q;
    }

    /* renamed from: g */
    protected HashMap<String, C2828am> m11877g() {
        return this.f10272E;
    }

    /* renamed from: h */
    protected HashMap<Integer, String> m11878h() {
        return this.f10273F;
    }

    /* renamed from: i */
    protected C5007c m11879i() {
        return this.f10302z;
    }

    /* renamed from: j */
    protected int m11880j() {
        return this.f10299w;
    }

    /* renamed from: m */
    private void m11865m() {
        C2828am c2828am;
        if (!C4847bl.m18333a() && this.f10273F.containsKey(Integer.valueOf(m11880j())) && (c2828am = this.f10272E.get(this.f10273F.get(Integer.valueOf(m11880j())))) != null && !TextUtils.isEmpty(c2828am.f10401d)) {
            String str = c2828am.f10401d;
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            } else {
                AsyncTaskC2751a.m11541a(this.f10298v + "/" + str.split("/")[r0.length - 1], Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON", null, false).execute(new String[0]);
            }
        }
    }

    /* renamed from: n */
    private void m11866n() {
        this.f10270C = new C2825aj(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f10270C, intentFilter);
        m11867o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m11867o() {
        if (!C4873ck.m18500a()) {
            C5179v.m19810a(getBaseContext(), R.string.sdcard_not_found, 0).show();
            finish();
        }
    }

    /* renamed from: p */
    private void m11868p() {
        unregisterReceiver(this.f10270C);
    }

    /* renamed from: a */
    protected void m11872a(String str, PostONImagePagerFragment postONImagePagerFragment) {
        this.f10271D.put(str, postONImagePagerFragment);
    }

    /* renamed from: c */
    protected void m11875c(String str) {
        this.f10271D.remove(str);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_pager_menu, menu);
        this.f10275H = menu.findItem(R.id.menu_save);
        this.f10276I = menu.findItem(R.id.menu_share);
        m11849a(m11880j());
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_save) {
            m11865m();
        } else if (menuItem.getItemId() == R.id.menu_share && this.f10273F.containsKey(Integer.valueOf(this.f10299w)) && this.f10272E.get(this.f10273F.get(Integer.valueOf(this.f10299w))) != null) {
            m11869q();
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: q */
    private void m11869q() {
        C2828am c2828am;
        Intent intentM18492a = null;
        if (!C4847bl.m18333a() && this.f10273F.containsKey(Integer.valueOf(this.f10299w)) && (c2828am = this.f10272E.get(this.f10273F.get(Integer.valueOf(this.f10299w)))) != null && !TextUtils.isEmpty(c2828am.f10401d)) {
            String str = c2828am.f10401d.split("/")[r1.length - 1];
            if (c2828am.f10400c.equals(Spam.ACTIVITY_REPORT)) {
                intentM18492a = C4869cg.m18494a((Context) this, getString(R.string.trunk_opt_header_share), this.f10298v + "/" + str, (String) null, (String) null, false);
            } else if (c2828am.f10400c.equals(Spam.ACTIVITY_CHECK)) {
                intentM18492a = C4869cg.m18492a(this, getString(R.string.trunk_opt_header_share), this.f10298v + "/" + str, (String) null, (String) null);
            }
            if (intentM18492a != null) {
                startActivity(intentM18492a);
            }
        }
    }

    /* renamed from: k */
    protected void m11881k() {
        if (!this.f10282O) {
            if (this.f10276I != null) {
                this.f10276I.setVisible(false);
            }
            if (this.f10275H != null) {
                this.f10275H.setVisible(false);
            }
            this.f10281N.setVisibility(4);
            this.f10284Q.setVisibility(4);
            this.f10269B.setVisibility(4);
            this.f10279L.setVisibility(4);
            this.f10280M.setVisibility(4);
            this.f10301y.setVisibility(4);
            this.f10282O = true;
            return;
        }
        if (this.f10276I != null) {
            this.f10276I.setVisible(true);
        }
        if (this.f10275H != null) {
            this.f10275H.setVisible(true);
        }
        this.f10281N.setVisibility(0);
        if (this.f10281N.getText().length() > 0) {
            this.f10284Q.setVisibility(0);
        } else {
            this.f10284Q.setVisibility(4);
        }
        this.f10269B.setVisibility(0);
        if (this.f10299w > 0) {
            this.f10279L.setVisibility(0);
        }
        if (this.f10299w < this.f10273F.size() - 1) {
            this.f10280M.setVisibility(0);
        }
        this.f10301y.setVisibility(0);
        this.f10282O = false;
    }

    @Override // com.sec.chaton.multimedia.image.InterfaceC2835at
    /* renamed from: a */
    public void mo11871a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "video/*");
        intent.putExtra("android.intent.extra.finishOnCompletion", false);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f10266o);
            }
        }
    }
}
