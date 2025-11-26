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
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.settings2.PrefFragmentPostONHide;
import com.sec.chaton.widget.C3263j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockListFragment extends Fragment {

    /* renamed from: a */
    static boolean f1557a = false;

    /* renamed from: b */
    static ProgressDialog f1558b;

    /* renamed from: d */
    View f1560d;

    /* renamed from: f */
    private ListView f1562f;

    /* renamed from: g */
    private ArrayList<C0475ac> f1563g;

    /* renamed from: h */
    private C1328f f1564h;

    /* renamed from: i */
    private C0493s f1565i;

    /* renamed from: j */
    private CheckedTextView f1566j;

    /* renamed from: k */
    private InterfaceC0495u f1567k;

    /* renamed from: l */
    private Activity f1568l;

    /* renamed from: m */
    private MenuItem f1569m;

    /* renamed from: c */
    Dialog f1559c = null;

    /* renamed from: e */
    public Handler f1561e = new HandlerC0474ab(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f1568l = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f1568l = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.f1569m = menu.findItem(R.id.edit_profile_menu_done);
        this.f1569m.setEnabled(false);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            this.f1565i.m3156a();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            this.f1568l.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_blockedlist, viewGroup, false);
        BaseActivity.m3081a(this, true);
        this.f1563g = new ArrayList<>();
        this.f1563g = (ArrayList) this.f1568l.getIntent().getExtras().getSerializable(PrefFragmentPostONHide.BLOCK_BUDDY_LIST);
        f1558b = (ProgressDialog) new C3263j(this.f1568l).m11487a(R.string.dialog_connecting_server);
        this.f1567k = new C0497w(this);
        this.f1565i = new C0493s(this.f1568l, R.layout.list_item_common_6, this.f1563g);
        this.f1565i.m3157a(this.f1567k);
        this.f1564h = new C1328f(this.f1561e);
        this.f1562f = (ListView) viewInflate.findViewById(R.id.list);
        this.f1562f.setAdapter((ListAdapter) this.f1565i);
        this.f1562f.setOnItemClickListener(new C0498x(this));
        this.f1562f.setOnItemSelectedListener(new C0499y(this));
        this.f1562f.setOnKeyListener(new ViewOnKeyListenerC0500z(this));
        this.f1566j = (CheckedTextView) viewInflate.findViewById(R.id.block_select_all);
        this.f1566j.setOnClickListener(new ViewOnClickListenerC0473aa(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* renamed from: a */
    public void m3118a() {
        if (this.f1568l != null && this.f1563g != null) {
            this.f1568l.setTitle(getResources().getString(R.string.setting_block_unblock));
            if (this.f1565i.f1621b.size() == 0) {
                this.f1569m.setEnabled(false);
            } else {
                this.f1569m.setEnabled(true);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }
}
