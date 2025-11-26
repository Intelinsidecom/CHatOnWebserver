package com.sec.chaton.hide;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.RemoteException;
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
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HideListFragment extends Fragment {

    /* renamed from: a */
    static boolean f5546a = false;

    /* renamed from: b */
    ProgressDialog f5547b;

    /* renamed from: c */
    Dialog f5548c = null;

    /* renamed from: d */
    View f5549d;

    /* renamed from: e */
    private ListView f5550e;

    /* renamed from: f */
    private ArrayList<C1515f> f5551f;

    /* renamed from: g */
    private C1523n f5552g;

    /* renamed from: h */
    private CheckedTextView f5553h;

    /* renamed from: i */
    private InterfaceC1524o f5554i;

    /* renamed from: j */
    private Activity f5555j;

    /* renamed from: k */
    private MenuItem f5556k;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5555j = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5555j = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_profile_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        this.f5556k = menu.findItem(R.id.edit_profile_menu_done);
        this.f5556k.setEnabled(false);
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws RemoteException, OperationApplicationException {
        if (menuItem.getItemId() == R.id.edit_profile_menu_done) {
            this.f5552g.m6515a();
        }
        if (menuItem.getItemId() == R.id.edit_profile_menu_cancel) {
            this.f5555j.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_hidedlist, viewGroup, false);
        BaseActivity.m3081a(this, true);
        this.f5551f = new ArrayList<>();
        this.f5551f = (ArrayList) this.f5555j.getIntent().getExtras().getSerializable("hide_buddy_list");
        this.f5547b = (ProgressDialog) new C3263j(this.f5555j).m11487a(R.string.dialog_connecting_server);
        this.f5554i = new C1526q(this);
        this.f5552g = new C1523n(this.f5555j, R.layout.list_item_common_6, this.f5551f);
        this.f5552g.m6516a(this.f5554i);
        this.f5550e = (ListView) viewInflate.findViewById(R.id.list);
        this.f5550e.setAdapter((ListAdapter) this.f5552g);
        this.f5550e.setOnItemClickListener(new C1527r(this));
        this.f5550e.setOnItemSelectedListener(new C1528s(this));
        this.f5550e.setOnKeyListener(new ViewOnKeyListenerC1529t(this));
        this.f5553h = (CheckedTextView) viewInflate.findViewById(R.id.select_all);
        this.f5553h.setOnClickListener(new ViewOnClickListenerC1530u(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m6474a();
    }

    /* renamed from: a */
    private void m6474a() {
        if (this.f5547b != null && this.f5547b.isShowing()) {
            try {
                this.f5547b.dismiss();
            } catch (IllegalArgumentException e) {
                C3250y.m11443a(e, getClass().getSimpleName());
            }
        }
    }
}
