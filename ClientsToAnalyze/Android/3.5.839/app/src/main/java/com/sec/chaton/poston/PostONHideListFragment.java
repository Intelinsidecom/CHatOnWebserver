package com.sec.chaton.poston;

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
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.block.C1093u;
import com.sec.chaton.p055d.C2074ag;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PostONHideListFragment extends ListFragment {

    /* renamed from: i */
    static ProgressDialog f10952i;

    /* renamed from: k */
    private ListView f10954k;

    /* renamed from: l */
    private ArrayList<C1093u> f10955l;

    /* renamed from: m */
    private int f10956m;

    /* renamed from: n */
    private C2982b f10957n;

    /* renamed from: o */
    private View f10958o;

    /* renamed from: p */
    private ViewStub f10959p;

    /* renamed from: q */
    private CheckedTextView f10960q;

    /* renamed from: r */
    private String f10961r;

    /* renamed from: s */
    private MenuItem f10962s;

    /* renamed from: t */
    private C2074ag f10963t;

    /* renamed from: u */
    private final String f10964u = "block_list";

    /* renamed from: v */
    private final String f10965v = "m_total_data";

    /* renamed from: w */
    private final String f10966w = "is_all_checked";

    /* renamed from: j */
    public Handler f10953j = new HandlerC2981az(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseActivity.m6160a((Fragment) this, true);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_hide_list, viewGroup, false);
        f10952i = (ProgressDialog) new C4923p(getActivity()).m18724a(R.string.dialog_connecting_server);
        this.f10963t = new C2074ag(this.f10953j);
        this.f10960q = (CheckedTextView) viewInflate.findViewById(R.id.select_all);
        this.f10959p = (ViewStub) viewInflate.findViewById(R.id.llayout_no_item);
        this.f10955l = new ArrayList<>();
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("block_list");
            if (bundle2 != null) {
                this.f10955l.clear();
                this.f10955l.addAll((ArrayList) bundle2.getSerializable("m_total_data"));
                this.f10956m = this.f10955l.size();
                this.f10960q.setChecked(bundle2.getBoolean("is_all_checked"));
                m12286c();
            }
        } else {
            this.f10955l = (ArrayList) getActivity().getIntent().getExtras().getSerializable("block_buddy_list");
            this.f10956m = this.f10955l.size();
        }
        this.f10961r = getActivity().getIntent().getExtras().getString("block_buddy_type");
        this.f10957n = new C2982b(getActivity(), this.f10955l);
        this.f10954k = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f10954k.setChoiceMode(2);
        this.f10954k.setAdapter((ListAdapter) this.f10957n);
        this.f10960q.setOnClickListener(new ViewOnClickListenerC2980ay(this));
        if (this.f10955l != null && this.f10960q != null && this.f10956m == 0) {
            this.f10960q.setVisibility(8);
            m12284d();
            if (this.f10958o != null) {
                this.f10958o.setVisibility(0);
            }
        } else {
            this.f10960q.setVisibility(0);
            if (this.f10958o != null) {
                this.f10958o.setVisibility(8);
            }
        }
        return viewInflate;
    }

    /* renamed from: d */
    private void m12284d() {
        if (this.f10958o != null) {
            this.f10958o = this.f10959p.inflate();
            ImageView imageView = (ImageView) this.f10958o.findViewById(R.id.image1);
            TextView textView = (TextView) this.f10958o.findViewById(R.id.text1);
            TextView textView2 = (TextView) this.f10958o.findViewById(R.id.text2);
            imageView.setImageResource(R.drawable.no_contents_buddies);
            textView.setText(R.string.no_contacts);
            textView2.setText(R.string.poston_buddies_not_allowed);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f10962s = null;
        this.f10962s = menu.findItem(R.id.edit_profile_menu_done);
        m12286c();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            ArrayList<String> arrayList = new ArrayList<>();
            m12281a(arrayList);
            if (this.f10961r.equals("post_on")) {
                this.f10963t.m9293a(arrayList, new ArrayList<>());
                f10952i.show();
            }
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    /* renamed from: a */
    private void m12281a(ArrayList<String> arrayList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f10954k.getCount()) {
                if (this.f10954k.isItemChecked(i2)) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("mTotalData.get(i).buddyid = " + this.f10955l.get(i2).f3484a, getClass().getSimpleName());
                    }
                    arrayList.add(this.f10955l.get(i2).f3484a);
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
        if (!listView.isItemChecked(i) && this.f10960q.isChecked()) {
            this.f10960q.setChecked(false);
        } else if (m12285e() == this.f10956m && !this.f10960q.isChecked()) {
            this.f10960q.setChecked(true);
        }
        m12286c();
        if (C4904y.f17872b) {
            C4904y.m18639b("list size = " + listView.getCount(), getClass().getSimpleName());
            C4904y.m18639b("list getCheckedItemCount() = " + m12285e(), getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m12286c();
    }

    /* renamed from: c */
    public void m12286c() {
        if (this.f10962s != null && this.f10955l != null) {
            if (m12285e() == 0) {
                this.f10962s.setEnabled(false);
            } else {
                this.f10962s.setEnabled(true);
            }
        }
    }

    /* renamed from: e */
    private int m12285e() {
        int i = 0;
        for (int i2 = 0; i2 < this.f10954k.getCount(); i2++) {
            if (this.f10954k.isItemChecked(i2)) {
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
        bundle2.putSerializable("m_total_data", this.f10955l);
        bundle2.putBoolean("is_all_checked", this.f10960q.isChecked());
        bundle.putBundle("block_list", bundle2);
    }
}
