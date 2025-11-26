package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.p019a.C0512b;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p029b.InterfaceC1413d;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3197bl;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class BuddyGroupMemberEditFragment extends Fragment {

    /* renamed from: a */
    public static final String f1896a = BuddyGroupMemberEditActivity.class.getSimpleName();

    /* renamed from: c */
    private C0512b f1898c;

    /* renamed from: d */
    private int f1899d;

    /* renamed from: e */
    private Context f1900e;

    /* renamed from: f */
    private HashSet<String> f1901f;

    /* renamed from: g */
    private String[] f1902g;

    /* renamed from: h */
    private String[] f1903h;

    /* renamed from: i */
    private Activity f1904i;

    /* renamed from: l */
    private ProgressDialog f1907l;

    /* renamed from: j */
    private View.OnClickListener f1905j = new ViewOnClickListenerC0647dl(this);

    /* renamed from: k */
    private Handler f1906k = new HandlerC0648dm(this);

    /* renamed from: b */
    InterfaceC1413d f1897b = new C0650do(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1900e = this.f1904i;
        this.f1899d = this.f1904i.getIntent().getIntExtra("ACTIVITY_PURPOSE", 1);
        C3250y.m11450b("onCreate() mPurpose=" + this.f1899d, f1896a);
        this.f1904i.setContentView(R.layout.buddy_list_layout);
        if (bundle == null) {
            BuddyFragment buddyFragment = new BuddyFragment();
            buddyFragment.setArguments(this.f1904i.getIntent().getExtras());
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").commit();
        }
        this.f1898c = (C0512b) this.f1904i.getIntent().getExtras().get("groupInfo");
        this.f1902g = this.f1904i.getIntent().getExtras().getStringArray("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST");
        m3457a(this.f1898c.m3963c());
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1904i = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1904i = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C3250y.m11450b("onDestroy()", f1896a);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_done) {
            if (!C3197bl.m11159a()) {
                switch (this.f1899d) {
                    case 19:
                        this.f1901f = m3455a().m3442g();
                        m3458a(this.f1901f);
                        break;
                }
            } else {
                return true;
            }
        } else if (menuItem.getItemId() == 16908332) {
            this.f1904i.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BuddyFragment m3455a() {
        return (BuddyFragment) getActivity().getSupportFragmentManager().findFragmentByTag("com.sec.chaton:single_pane_fragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3458a(HashSet<String> hashSet) {
        if (this.f1902g != null) {
            String[] strArrM3443h = m3455a().m3443h();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f1902g.length; i++) {
                int i2 = 0;
                while (true) {
                    if (i2 < strArrM3443h.length) {
                        if (this.f1902g[i].equals(strArrM3443h[i2])) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        arrayList.add(this.f1902g[i]);
                        break;
                    }
                }
            }
            this.f1903h = new String[arrayList.size()];
            this.f1903h = (String[]) arrayList.toArray(this.f1903h);
            for (int i3 = 0; i3 < this.f1902g.length; i3++) {
                C3250y.m11450b("before " + this.f1902g[i3], getClass().getSimpleName());
            }
            for (String str : strArrM3443h) {
                C3250y.m11450b("after " + str, getClass().getSimpleName());
            }
            for (int i4 = 0; i4 < m3455a().m3443h().length; i4++) {
                C3250y.m11450b("added " + m3455a().m3443h()[i4], getClass().getSimpleName());
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                C3250y.m11450b("deleted " + ((String) arrayList.get(i5)), getClass().getSimpleName());
            }
            new C1330h(this.f1906k).m5713a("group", false, 329, this.f1898c.m3962b(), m3455a().m3443h(), this.f1903h);
            m3460b();
        }
    }

    /* renamed from: a */
    private void m3457a(int i) {
        C3250y.m11450b("setTitleView() : " + i, f1896a);
        String strM3962b = null;
        if (this.f1899d == 19) {
            strM3962b = this.f1898c.m3962b();
        }
        if (strM3962b != null) {
            ((BaseSinglePaneActivity) this.f1904i).m11543k().mo11583a(i >= 0 ? strM3962b + " (" + i + ")" : strM3962b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m3460b() {
        if (this.f1907l == null) {
            this.f1907l = ProgressDialogC3265l.m11490a(this.f1904i, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f1907l.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3463c() {
        if (this.f1907l != null) {
            this.f1907l.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m3465d();
    }

    /* renamed from: d */
    private void m3465d() {
        C3250y.m11450b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = this.f1904i.getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
