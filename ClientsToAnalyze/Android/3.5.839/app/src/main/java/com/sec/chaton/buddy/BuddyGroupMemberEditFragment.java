package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.buddy.p050a.C1105b;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.p059b.InterfaceC2243d;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class BuddyGroupMemberEditFragment extends Fragment {

    /* renamed from: a */
    public static final String f3774a = BuddyGroupMemberEditActivity.class.getSimpleName();

    /* renamed from: c */
    private C1105b f3776c;

    /* renamed from: d */
    private int f3777d;

    /* renamed from: e */
    private Context f3778e;

    /* renamed from: f */
    private HashSet<String> f3779f;

    /* renamed from: g */
    private String[] f3780g;

    /* renamed from: h */
    private String[] f3781h;

    /* renamed from: i */
    private Activity f3782i;

    /* renamed from: k */
    private ProgressDialog f3784k;

    /* renamed from: j */
    private Handler f3783j = new HandlerC1273eg(this);

    /* renamed from: b */
    InterfaceC2243d f3775b = new C1275ei(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3778e = this.f3782i;
        this.f3777d = this.f3782i.getIntent().getIntExtra("ACTIVITY_PURPOSE", 1);
        C4904y.m18639b("onCreate() mPurpose=" + this.f3777d, f3774a);
        this.f3782i.setContentView(R.layout.buddy_list_layout);
        if (bundle == null) {
            BuddyFragment buddyFragment = new BuddyFragment();
            buddyFragment.setArguments(this.f3782i.getIntent().getExtras());
            getActivity().m50e().mo183a().mo96a(R.id.fragment_controller, buddyFragment, "com.sec.chaton:single_pane_fragment").mo99b();
        }
        this.f3776c = (C1105b) this.f3782i.getIntent().getExtras().get("groupInfo");
        this.f3780g = this.f3782i.getIntent().getExtras().getStringArray("ACTIVITY_ARG_GROUP_MEMBER_NO_LIST");
        m6615a(this.f3776c.m7037c());
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3782i = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3782i = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18639b("onDestroy()", f3774a);
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
            if (!C4847bl.m18333a()) {
                switch (this.f3777d) {
                    case 19:
                        this.f3779f = m6614a().m6603f();
                        m6616a(this.f3779f);
                        break;
                }
            } else {
                return true;
            }
        } else if (menuItem.getItemId() == 16908332) {
            this.f3782i.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BuddyFragment m6614a() {
        return (BuddyFragment) getActivity().m50e().mo182a("com.sec.chaton:single_pane_fragment");
    }

    /* renamed from: a */
    private void m6616a(HashSet<String> hashSet) {
        if (this.f3780g != null) {
            String[] strArrM6604g = m6614a().m6604g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f3780g.length; i++) {
                int i2 = 0;
                while (true) {
                    if (i2 < strArrM6604g.length) {
                        if (this.f3780g[i].equals(strArrM6604g[i2])) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        arrayList.add(this.f3780g[i]);
                        break;
                    }
                }
            }
            this.f3781h = new String[arrayList.size()];
            this.f3781h = (String[]) arrayList.toArray(this.f3781h);
            for (int i3 = 0; i3 < this.f3780g.length; i3++) {
                C4904y.m18639b("before " + this.f3780g[i3], getClass().getSimpleName());
            }
            for (String str : strArrM6604g) {
                C4904y.m18639b("after " + str, getClass().getSimpleName());
            }
            for (int i4 = 0; i4 < m6614a().m6604g().length; i4++) {
                C4904y.m18639b("added " + m6614a().m6604g()[i4], getClass().getSimpleName());
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                C4904y.m18639b("deleted " + ((String) arrayList.get(i5)), getClass().getSimpleName());
            }
            new C2128i(this.f3783j).m9486a("group", false, 329, this.f3776c.m7036b(), m6614a().m6604g(), this.f3781h);
            m6618b();
        }
    }

    /* renamed from: a */
    private void m6615a(int i) {
        C4904y.m18639b("setTitleView() : " + i, f3774a);
        String strM7036b = null;
        if (this.f3777d == 19) {
            strM7036b = this.f3776c.m7036b();
        }
        if (strM7036b != null) {
            ((BaseSinglePaneActivity) this.f3782i).m18784t().mo18823a(i >= 0 ? strM7036b + " (" + i + ")" : strM7036b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6618b() {
        if (this.f3784k == null) {
            this.f3784k = ProgressDialogC4926s.m18728a(this.f3782i, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f3784k.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6620c() {
        if (this.f3784k != null) {
            this.f3784k.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
