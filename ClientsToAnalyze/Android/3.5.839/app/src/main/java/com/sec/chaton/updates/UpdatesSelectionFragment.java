package com.sec.chaton.updates;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
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
import com.sec.chaton.p055d.C2120bz;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UpdatesSelectionFragment extends ListFragment {

    /* renamed from: i */
    public static final String f16988i = UpdatesSelectionFragment.class.getSimpleName();

    /* renamed from: j */
    private View f16989j;

    /* renamed from: k */
    private CheckedTextView f16990k;

    /* renamed from: l */
    private ListView f16991l;

    /* renamed from: m */
    private C4710q f16992m;

    /* renamed from: n */
    private ArrayList<C4709p> f16993n;

    /* renamed from: o */
    private int f16994o;

    /* renamed from: s */
    private C2120bz f16998s;

    /* renamed from: t */
    private ProgressDialog f16999t;

    /* renamed from: u */
    private MenuItem f17000u;

    /* renamed from: p */
    private final String f16995p = "delete_list";

    /* renamed from: q */
    private final String f16996q = "m_total_data";

    /* renamed from: r */
    private final String f16997r = "is_all_checked";

    /* renamed from: v */
    private Handler f17001v = new HandlerC4713t(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16998s = new C2120bz(this.f17001v);
        this.f16993n = new ArrayList<>();
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16989j = layoutInflater.inflate(R.layout.layout_updates_checkbox, viewGroup, false);
        this.f16999t = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_connecting_server);
        this.f16990k = (CheckedTextView) this.f16989j.findViewById(R.id.select_all);
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("delete_list");
            if (bundle2 != null) {
                this.f16993n.clear();
                this.f16993n.addAll((ArrayList) bundle2.getSerializable("m_total_data"));
                this.f16994o = this.f16993n.size();
                this.f16990k.setChecked(bundle2.getBoolean("is_all_checked"));
                m17743c();
            }
        } else {
            this.f16993n = (ArrayList) getActivity().getIntent().getExtras().getSerializable("DATA_LIST");
            this.f16994o = this.f16993n.size();
        }
        this.f16992m = new C4710q(getActivity(), this.f16993n, R.layout.list_item_updates_checkbox);
        this.f16991l = (ListView) this.f16989j.findViewById(android.R.id.list);
        this.f16991l.setChoiceMode(2);
        this.f16991l.setAdapter((ListAdapter) this.f16992m);
        this.f16990k.setOnClickListener(new ViewOnClickListenerC4712s(this));
        BaseActivity.m6160a((Fragment) this, true);
        return this.f16989j;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.cancel_done_menu, menu);
        this.f17000u = menu.findItem(R.id.menu_done);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.f17000u.setEnabled(false);
        C4880cr.m18523a(this.f17000u);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_cancel /* 2131166684 */:
                getActivity().finish();
                break;
            case R.id.menu_done /* 2131166685 */:
                ArrayList<String> arrayList = new ArrayList<>();
                m17747a(arrayList);
                this.f16998s.m9468a(arrayList);
                this.f16999t.show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    void m17747a(ArrayList<String> arrayList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16991l.getCount()) {
                if (this.f16991l.isItemChecked(i2)) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mDeleteItemList.get(i).createTime = " + this.f16993n.get(i2).m17766c(), getClass().getSimpleName());
                    }
                    arrayList.add(this.f16993n.get(i2).m17766c());
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        super.mo62a(listView, view, i, j);
        if (!listView.isItemChecked(i) && this.f16990k.isChecked()) {
            this.f16990k.setChecked(false);
        } else if (m17744d() == this.f16994o && !this.f16990k.isChecked()) {
            this.f16990k.setChecked(true);
        }
        m17743c();
        if (C4904y.f17872b) {
            C4904y.m18639b("list size = " + listView.getCount(), getClass().getSimpleName());
            C4904y.m18639b("list getCheckedItemCount() = " + m17744d(), getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    private void m17743c() {
        if (this.f17000u != null && this.f16993n != null) {
            if (m17744d() == 0) {
                this.f17000u.setEnabled(false);
            } else {
                this.f17000u.setEnabled(true);
            }
        }
    }

    /* renamed from: d */
    private int m17744d() {
        int i = 0;
        for (int i2 = 0; i2 < this.f16991l.getCount(); i2++) {
            if (this.f16991l.isItemChecked(i2)) {
                i++;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("getCheckedItemCount() Result : " + i, getClass().getSimpleName());
        }
        return i;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("m_total_data", this.f16993n);
        bundle2.putBoolean("is_all_checked", this.f16990k.isChecked());
        bundle.putBundle("delete_list", bundle2);
    }
}
