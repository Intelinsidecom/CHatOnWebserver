package com.sec.chaton.settings.tellfriends;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.p001a.p002a.C0036k;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import weibo4android.Weibo;
import weibo4android.WeiboException;

/* loaded from: classes.dex */
public class SnsFriendsUsingChatOnActivity extends ListActivity {

    /* renamed from: d */
    private static final String f4981d = SnsFriendsUsingChatOnActivity.class.getSimpleName();

    /* renamed from: m */
    private C0633e f4995m;

    /* renamed from: n */
    private ArrayList f4996n;

    /* renamed from: x */
    private C1374bb f5006x;

    /* renamed from: e */
    private ProgressDialog f4987e = null;

    /* renamed from: f */
    private C1358am f4988f = null;

    /* renamed from: g */
    private AsyncTaskC1360ao f4989g = null;

    /* renamed from: h */
    private ArrayList f4990h = new ArrayList();

    /* renamed from: i */
    private ArrayList f4991i = new ArrayList();

    /* renamed from: j */
    private C1392bt f4992j = new C1392bt();

    /* renamed from: k */
    private String f4993k = "";

    /* renamed from: l */
    private long[] f4994l = null;

    /* renamed from: o */
    private AsyncTaskC1366au f4997o = null;

    /* renamed from: p */
    private Weibo f4998p = null;

    /* renamed from: q */
    private int f4999q = 0;

    /* renamed from: r */
    private long[] f5000r = null;

    /* renamed from: s */
    private long[] f5001s = null;

    /* renamed from: t */
    private long f5002t = -1;

    /* renamed from: u */
    private long f5003u = -1;

    /* renamed from: v */
    private boolean f5004v = false;

    /* renamed from: w */
    private AsyncTaskC1365at f5005w = null;

    /* renamed from: a */
    View.OnClickListener f4984a = new ViewOnClickListenerC1352ag(this);

    /* renamed from: b */
    Handler f4985b = new HandlerC1353ah(this);

    /* renamed from: y */
    private AlertDialog f5007y = null;

    /* renamed from: z */
    private ArrayList f5008z = new ArrayList();

    /* renamed from: A */
    private InterfaceC1368aw f4982A = new C1354ai(this);

    /* renamed from: c */
    public Handler f4986c = new HandlerC1356ak(this);

    /* renamed from: B */
    private Handler f4983B = new HandlerC1357al(this);

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_tell_friends_chaton_list);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        if (Build.VERSION.SDK_INT < 11) {
            this.f5004v = true;
        } else {
            this.f5004v = false;
        }
        m4840b();
    }

    /* renamed from: b */
    private void m4840b() {
        this.f4996n = new ArrayList();
        this.f4993k = getIntent().getStringExtra("snsType");
        ((TextView) findViewById(R.id.tv_title)).setText(getString(R.string.chaton_user_txt));
        TextView textView = (TextView) findViewById(R.id.tv_description);
        if (this.f4993k.equals(C1350ae.f5157a)) {
            this.f5006x = new C1374bb(this);
            textView.setText(getString(R.string.friends_using_chaton_facebook_header_txt));
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
                getActionBar().setTitle(R.string.tellfriends_via_facebook);
            }
        } else if (this.f4993k.equals(C1350ae.f5158b)) {
            textView.setText(getString(R.string.friends_using_chaton_twitter_header_txt));
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
                getActionBar().setTitle(R.string.tellfriends_via_twitter);
            }
        } else if (this.f4993k.equals(C1350ae.f5159c)) {
            textView.setText(getString(R.string.friends_using_chaton_weibo_header_txt));
            if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
                getActionBar().setTitle(R.string.tellfriends_via_weibo);
            }
        }
        ((Button) findViewById(R.id.btn_add_all)).setOnClickListener(this.f4984a);
        m4844c();
        this.f4988f = new C1358am(this, getApplicationContext(), R.layout.list_item_add_buddy, this.f4991i);
        setListAdapter(this.f4988f);
        getListView().setEmptyView(findViewById(R.id.no_recommendations_layout));
    }

    /* renamed from: c */
    private void m4844c() {
        this.f4989g = (AsyncTaskC1360ao) new AsyncTaskC1360ao(this, this).execute(new long[0][]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4846d() {
        if (C1350ae.m5081a(getApplicationContext()).m5085a(this.f4993k)) {
            this.f4995m = new C0633e(this.f4986c);
            this.f4995m.m2863a(this.f4993k, this.f4994l);
            return;
        }
        String strValueOf = "";
        if (this.f4993k.equals(C1350ae.f5157a)) {
            strValueOf = C0036k.m32b(getApplicationContext());
        } else if (this.f4993k.equals(C1350ae.f5158b)) {
            strValueOf = C1437dk.m5166a().m5169c();
        } else if (this.f4993k.equals(C1350ae.f5159c)) {
            strValueOf = String.valueOf(getSharedPreferences("WeiboLogin", 0).getLong("weibo_userID", 0L));
        }
        new C0633e(this.f4985b).m2862a(this.f4993k, strValueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public long[] m4848e() {
        long[] jArr = new long[this.f4990h.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f4990h.size()) {
                jArr[i2] = Long.parseLong(((C1342a) this.f4990h.get(i2)).m5066a());
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public long[] m4849f() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        try {
            Twitter twitterM5170d = C1437dk.m5166a().m5170d();
            long nextCursor = -1;
            do {
                IDs friendsIDs = twitterM5170d.getFriendsIDs(nextCursor);
                for (long j : friendsIDs.getIDs()) {
                    arrayList.add(Long.valueOf(j));
                }
                nextCursor = friendsIDs.getNextCursor();
            } while (nextCursor == -1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (TwitterException e2) {
            e2.printStackTrace();
        }
        long[] jArr = new long[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                jArr[i2] = ((Long) arrayList.get(i2)).longValue();
                i = i2 + 1;
            } else {
                return jArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public long[] m4852g() {
        String strValueOf = String.valueOf(getSharedPreferences("WeiboLogin", 0).getLong("weibo_userID", 0L));
        try {
            if (this.f4998p == null) {
                this.f4998p = C1472u.m5199a().m5203b();
                this.f4999q = this.f4998p.showUser(strValueOf).getFriendsCount();
            }
            weibo4android.IDs friendsListIDS_test2 = this.f4998p.getFriendsListIDS_test2(strValueOf, (int) this.f5002t, 5000);
            this.f5003u = friendsListIDS_test2.getNextCursor();
            int i = (int) this.f5003u;
            this.f5000r = friendsListIDS_test2.getIDs();
            if (i != 0) {
                int i2 = i;
                while (i2 == 0) {
                    Log.d(f4981d, "nextCursor not 0, Thus request additional friend lists.");
                    weibo4android.IDs friendsListIDS_test22 = this.f4998p.getFriendsListIDS_test2(strValueOf, i2, 5000);
                    this.f5001s = friendsListIDS_test22.getIDs();
                    int i3 = 0;
                    for (int i4 = i2; i4 < this.f5001s.length + i2; i4++) {
                        if (i3 != this.f5001s.length) {
                            this.f5000r[i4] = this.f5001s[i3];
                            i3++;
                        }
                    }
                    this.f5003u = friendsListIDS_test22.getNextCursor();
                    int i5 = (int) this.f5003u;
                    Log.d(f4981d, "5000 over... nextCursor2 = " + i5);
                    i2 = i5;
                }
            }
        } catch (WeiboException e) {
            e.printStackTrace();
        }
        return this.f5000r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4853h() {
        this.f5006x.m5120a(this.f4982A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4855i() {
        m4838a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m4857j() {
        if (this.f4987e != null) {
            this.f4987e.dismiss();
            this.f4987e = null;
        }
    }

    /* renamed from: a */
    private void m4838a(boolean z) {
        if (this.f4987e == null) {
            this.f4987e = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_connecting_server);
            this.f4987e.setCancelable(false);
            this.f4987e.setOnKeyListener(new DialogInterfaceOnKeyListenerC1355aj(this, z));
        }
        this.f4987e.show();
    }

    /* renamed from: k */
    private void m4859k() {
        if (this.f5007y != null && this.f5007y.isShowing()) {
            this.f5007y.dismiss();
            this.f5007y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m4861l() {
        m4857j();
        m4859k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m4863m() {
        m4861l();
        int iM3420a = C0809s.m3420a(this);
        if (-3 == iM3420a) {
            m4837a(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM3420a) {
            m4837a(getResources().getString(R.string.toast_network_unable));
        }
    }

    /* renamed from: b */
    private void m4842b(boolean z) {
        int iM3420a = C0809s.m3420a(this);
        if (-3 == iM3420a) {
            m4837a(getResources().getString(R.string.popup_no_network_connection));
        } else if (-2 == iM3420a) {
            m4837a(getResources().getString(R.string.toast_network_unable));
        } else {
            m4837a(getResources().getString(R.string.facebook_post_failed));
        }
    }

    /* renamed from: a */
    private void m4837a(String str) {
        Toast.makeText(this, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4866n() {
        m4842b(true);
    }

    @Override // android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        if (this.f4997o != null) {
            this.f4997o.cancel(true);
            this.f4997o = null;
        }
        m4861l();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        m4868o();
    }

    /* renamed from: o */
    private void m4868o() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
