package com.sec.chaton.poston;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.block.C0475ac;
import com.sec.chaton.p025d.C1344v;
import com.sec.chaton.settings2.PrefFragmentPostONHide;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PostONHideListFragment extends ListFragment {

    /* renamed from: a */
    static ProgressDialog f7561a;

    /* renamed from: b */
    public Handler f7562b = new HandlerC1985ay(this);

    /* renamed from: c */
    private ListView f7563c;

    /* renamed from: d */
    private ArrayList<C0475ac> f7564d;

    /* renamed from: e */
    private int f7565e;

    /* renamed from: f */
    private C1987b f7566f;

    /* renamed from: g */
    private View f7567g;

    /* renamed from: h */
    private View f7568h;

    /* renamed from: i */
    private CheckedTextView f7569i;

    /* renamed from: j */
    private String f7570j;

    /* renamed from: k */
    private MenuItem f7571k;

    /* renamed from: l */
    private C1344v f7572l;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseActivity.m3081a(this, true);
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_hide_list, viewGroup, false);
        f7561a = (ProgressDialog) new C3263j(getActivity()).m11487a(R.string.dialog_connecting_server);
        this.f7572l = new C1344v(this.f7562b);
        this.f7567g = viewInflate.findViewById(R.id.llayout_no_item);
        ImageView imageView = (ImageView) this.f7567g.findViewById(R.id.image1);
        TextView textView = (TextView) this.f7567g.findViewById(R.id.text1);
        TextView textView2 = (TextView) this.f7567g.findViewById(R.id.text2);
        imageView.setImageResource(R.drawable.no_contents_buddies);
        textView.setText(R.string.chat_title_no_buddies);
        textView2.setText(R.string.poston_buddies_not_allowed);
        this.f7564d = new ArrayList<>();
        this.f7564d = (ArrayList) getActivity().getIntent().getExtras().getSerializable(PrefFragmentPostONHide.BLOCK_BUDDY_LIST);
        this.f7565e = this.f7564d.size();
        this.f7570j = getActivity().getIntent().getExtras().getString(PrefFragmentPostONHide.BLOCK_BUDDY_TYPE);
        this.f7566f = new C1987b(getActivity(), this.f7564d);
        this.f7563c = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f7563c.setChoiceMode(2);
        this.f7563c.setAdapter((ListAdapter) this.f7566f);
        this.f7563c.setOnKeyListener(new ViewOnKeyListenerC1983aw(this));
        this.f7569i = (CheckedTextView) viewInflate.findViewById(R.id.select_all);
        this.f7569i.setOnClickListener(new ViewOnClickListenerC1984ax(this));
        if (this.f7564d != null && this.f7569i != null && this.f7565e == 0) {
            this.f7569i.setVisibility(8);
            this.f7567g.setVisibility(0);
        } else {
            this.f7569i.setVisibility(0);
            this.f7567g.setVisibility(8);
        }
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.activity_edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f7571k = null;
        this.f7571k = menu.findItem(R.id.edit_profile_menu_done);
        this.f7571k.setEnabled(false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            getActivity().finish();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            ArrayList<String> arrayList = new ArrayList<>();
            m7973a(arrayList);
            if (this.f7570j.equals("post_on")) {
                this.f7572l.m5919a(arrayList, new ArrayList<>());
                f7561a.show();
            }
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().finish();
        return true;
    }

    /* renamed from: a */
    private void m7973a(ArrayList<String> arrayList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f7563c.getCount()) {
                if (this.f7563c.isItemChecked(i2)) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("mTotalData.get(i).buddyid = " + this.f7564d.get(i2).f1584a, getClass().getSimpleName());
                    }
                    arrayList.add(this.f7564d.get(i2).f1584a);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.support.v4.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        if (!listView.isItemChecked(i) && this.f7569i.isChecked()) {
            this.f7569i.setChecked(false);
        } else if (m7971a() == this.f7565e && !this.f7569i.isChecked()) {
            this.f7569i.setChecked(true);
        }
        if (m7971a() > 0) {
            this.f7571k.setEnabled(true);
        } else {
            this.f7571k.setEnabled(false);
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("list size = " + listView.getCount(), getClass().getSimpleName());
            C3250y.m11450b("list getCheckedItemCount() = " + m7971a(), getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f7571k != null && this.f7564d != null) {
            if (this.f7563c.getCheckedItemCount() == 0) {
                this.f7571k.setEnabled(false);
            } else {
                this.f7571k.setEnabled(true);
            }
        }
    }

    /* renamed from: a */
    private int m7971a() {
        int i = 0;
        for (int i2 = 0; i2 < this.f7563c.getCount(); i2++) {
            if (this.f7563c.isItemChecked(i2)) {
                i++;
            }
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("getCheckedItemCount() Result : " + i, getClass().getSimpleName());
        }
        return i;
    }
}
