package com.sec.chaton.hide;

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
import com.sec.chaton.block.C1093u;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HideListFragment extends Fragment {

    /* renamed from: a */
    static boolean f8415a = false;

    /* renamed from: b */
    static ProgressDialog f8416b;

    /* renamed from: d */
    View f8418d;

    /* renamed from: f */
    private ListView f8420f;

    /* renamed from: g */
    private ArrayList<C1093u> f8421g;

    /* renamed from: h */
    private C2377l f8422h;

    /* renamed from: i */
    private CheckedTextView f8423i;

    /* renamed from: j */
    private InterfaceC2379n f8424j;

    /* renamed from: k */
    private Activity f8425k;

    /* renamed from: l */
    private MenuItem f8426l;

    /* renamed from: c */
    Dialog f8417c = null;

    /* renamed from: m */
    private final String f8427m = "hide_list";

    /* renamed from: n */
    private final String f8428n = "m_data";

    /* renamed from: o */
    private final String f8429o = "hide_data";

    /* renamed from: p */
    private final String f8430p = "is_check";

    /* renamed from: q */
    private final String f8431q = "is_all_checked";

    /* renamed from: e */
    public Handler f8419e = new HandlerC2386u(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f8425k = activity;
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
        this.f8425k = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.f8426l = menu.findItem(R.id.edit_profile_menu_done);
        this.f8426l.setEnabled(false);
        if (this.f8424j != null) {
            this.f8424j.onClick();
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            this.f8422h.m10360a();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            this.f8425k.finish();
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
        View viewInflate = layoutInflater.inflate(R.layout.layout_hidedlist, viewGroup, false);
        BaseActivity.m6160a((Fragment) this, true);
        this.f8421g = new ArrayList<>();
        this.f8421g = (ArrayList) this.f8425k.getIntent().getExtras().getSerializable("hide_buddy_list");
        f8416b = (ProgressDialog) new C4923p(this.f8425k).m18724a(R.string.dialog_connecting_server);
        this.f8424j = new C2381p(this);
        this.f8423i = (CheckedTextView) viewInflate.findViewById(R.id.select_all);
        this.f8423i.setOnClickListener(new ViewOnClickListenerC2382q(this));
        if (bundle != null && (bundle3 = bundle.getBundle("hide_list")) != null) {
            this.f8421g.clear();
            this.f8421g.addAll((ArrayList) bundle3.getSerializable("m_data"));
        }
        this.f8422h = new C2377l(this.f8425k, R.layout.list_item_common_6, this.f8421g);
        this.f8422h.m10361a(this.f8424j);
        if (bundle != null && (bundle2 = bundle.getBundle("hide_list")) != null) {
            this.f8422h.f8454b.clear();
            this.f8422h.f8453a.clear();
            this.f8422h.f8454b.addAll((ArrayList) bundle2.getSerializable("hide_data"));
            this.f8422h.f8453a.addAll((ArrayList) bundle2.getSerializable("m_data"));
            this.f8422h.f8455c = bundle2.getBooleanArray("is_check");
            this.f8423i.setChecked(bundle2.getBoolean("is_all_checked"));
        }
        this.f8420f = (ListView) viewInflate.findViewById(R.id.list);
        this.f8420f.setAdapter((ListAdapter) this.f8422h);
        this.f8420f.setChoiceMode(2);
        this.f8420f.setOnItemClickListener(new C2383r(this));
        this.f8420f.setOnItemSelectedListener(new C2384s(this));
        this.f8420f.setOnKeyListener(new ViewOnKeyListenerC2385t(this));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m10336a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f8420f.getCount(); i2++) {
            if (this.f8420f.isItemChecked(i2)) {
                i++;
            }
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("m_data", this.f8421g);
        bundle2.putSerializable("hide_data", this.f8422h.f8454b);
        bundle2.putBooleanArray("is_check", this.f8422h.f8455c);
        bundle2.putBoolean("is_all_checked", this.f8423i.isChecked());
        bundle.putBundle("hide_list", bundle2);
    }
}
