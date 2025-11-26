package com.sec.chaton.buddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2141v;
import com.sec.chaton.p065io.entry.inner.LiveGroupFollower;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BuddyLiveGroupFragment extends Fragment {

    /* renamed from: a */
    public static final String f3882a = BuddyGroupMemberEditActivity.class.getSimpleName();

    /* renamed from: b */
    public Handler f3883b = new HandlerC1304fk(this);

    /* renamed from: c */
    private int f3884c;

    /* renamed from: d */
    private C2141v f3885d;

    /* renamed from: e */
    private Activity f3886e;

    /* renamed from: f */
    private ArrayList<LiveGroupFollower> f3887f;

    /* renamed from: g */
    private ProgressDialog f3888g;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3884c = this.f3886e.getIntent().getIntExtra("ACTIVITY_PURPOSE", 23);
        C4904y.m18639b("onCreate() mPurpose=" + this.f3884c, f3882a);
        this.f3886e.setContentView(R.layout.buddy_list_layout);
        if (bundle == null) {
            String str = (String) this.f3886e.getIntent().getExtras().get("live_group_no");
            this.f3885d = C2141v.m9590a(this.f3883b);
            this.f3885d.m9591a(str);
            m6738a();
        }
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3886e = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3886e = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C4904y.m18639b("onDestroy()", f3882a);
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
            if (C4847bl.m18333a()) {
                return true;
            }
            int i = this.f3884c;
        } else if (menuItem.getItemId() == 16908332) {
            this.f3886e.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m6738a() {
        if (this.f3888g == null) {
            this.f3888g = ProgressDialogC4926s.m18728a(this.f3886e, null, getResources().getString(R.string.buddy_list_progress_dialog_message), true);
        } else {
            this.f3888g.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6740b() {
        if (this.f3888g != null) {
            this.f3888g.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
