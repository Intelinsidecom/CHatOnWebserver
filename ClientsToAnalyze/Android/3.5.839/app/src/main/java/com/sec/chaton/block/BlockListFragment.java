package com.sec.chaton.block;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockListFragment extends Fragment {

    /* renamed from: a */
    static boolean f3425a = false;

    /* renamed from: b */
    static ProgressDialog f3426b;

    /* renamed from: d */
    View f3428d;

    /* renamed from: f */
    private ListView f3430f;

    /* renamed from: g */
    private ArrayList<C1093u> f3431g;

    /* renamed from: h */
    private C2126g f3432h;

    /* renamed from: i */
    private C1083k f3433i;

    /* renamed from: j */
    private CheckedTextView f3434j;

    /* renamed from: k */
    private InterfaceC1085m f3435k;

    /* renamed from: l */
    private Activity f3436l;

    /* renamed from: m */
    private MenuItem f3437m;

    /* renamed from: c */
    Dialog f3427c = null;

    /* renamed from: n */
    private final String f3438n = "block_list";

    /* renamed from: o */
    private final String f3439o = "m_data";

    /* renamed from: p */
    private final String f3440p = "block_data";

    /* renamed from: q */
    private final String f3441q = "is_check";

    /* renamed from: e */
    public Handler f3429e = new HandlerC1092t(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3436l = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3436l = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.f3437m = menu.findItem(R.id.edit_profile_menu_done);
        this.f3437m.setEnabled(false);
        if (this.f3435k != null) {
            this.f3435k.onClick();
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            this.f3433i.m6227a();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            this.f3436l.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        View viewInflate = layoutInflater.inflate(R.layout.layout_blockedlist, viewGroup, false);
        BaseActivity.m6160a((Fragment) this, true);
        this.f3431g = new ArrayList<>();
        this.f3431g = (ArrayList) this.f3436l.getIntent().getExtras().getSerializable("block_buddy_list");
        f3426b = (ProgressDialog) new C4923p(this.f3436l).m18724a(R.string.dialog_connecting_server);
        this.f3435k = new C1087o(this);
        if (bundle != null && (bundle3 = bundle.getBundle("block_list")) != null) {
            this.f3431g.clear();
            this.f3431g.addAll((ArrayList) bundle3.getSerializable("m_data"));
        }
        this.f3433i = new C1083k(this.f3436l, R.layout.list_item_common_6, this.f3431g);
        this.f3433i.m6228a(this.f3435k);
        if (bundle != null && (bundle2 = bundle.getBundle("block_list")) != null) {
            this.f3433i.f3464b.clear();
            this.f3433i.f3463a.clear();
            this.f3433i.f3464b.addAll((ArrayList) bundle2.getSerializable("block_data"));
            this.f3433i.f3463a.addAll((ArrayList) bundle2.getSerializable("m_data"));
            this.f3433i.f3465c = bundle2.getBooleanArray("is_check");
        }
        this.f3432h = C2126g.m9476a(this.f3429e);
        this.f3430f = (ListView) viewInflate.findViewById(R.id.list);
        this.f3430f.setAdapter((ListAdapter) this.f3433i);
        this.f3430f.setChoiceMode(2);
        this.f3430f.setOnItemClickListener(new C1088p(this));
        this.f3430f.setOnItemSelectedListener(new C1089q(this));
        this.f3430f.setOnKeyListener(new ViewOnKeyListenerC1090r(this));
        this.f3434j = (CheckedTextView) viewInflate.findViewById(R.id.block_select_all);
        this.f3434j.setOnClickListener(new ViewOnClickListenerC1091s(this));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m6203b() {
        int i = 0;
        for (int i2 = 0; i2 < this.f3430f.getCount(); i2++) {
            if (this.f3430f.isItemChecked(i2)) {
                i++;
            }
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* renamed from: a */
    public void m6211a() {
        if (this.f3436l != null && this.f3431g != null) {
            this.f3436l.setTitle(getResources().getString(R.string.setting_block_unblock));
            if (this.f3433i.f3464b.size() == 0) {
                this.f3437m.setEnabled(false);
            } else {
                this.f3437m.setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("m_data", this.f3431g);
        bundle2.putSerializable("block_data", this.f3433i.f3464b);
        bundle2.putBooleanArray("is_check", this.f3433i.f3465c);
        bundle.putBundle("block_list", bundle2);
    }
}
