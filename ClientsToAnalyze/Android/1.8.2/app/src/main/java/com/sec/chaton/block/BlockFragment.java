package com.sec.chaton.block;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p015d.C0632d;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockFragment extends Fragment {

    /* renamed from: a */
    static boolean f795a = false;

    /* renamed from: b */
    static ProgressDialog f796b;

    /* renamed from: e */
    private ListView f799e;

    /* renamed from: f */
    private ArrayList f800f;

    /* renamed from: g */
    private C0632d f801g;

    /* renamed from: h */
    private C0245e f802h;

    /* renamed from: i */
    private LinearLayout f803i;

    /* renamed from: k */
    private TextView f805k;

    /* renamed from: l */
    private boolean f806l;

    /* renamed from: m */
    private Button f807m;

    /* renamed from: c */
    Dialog f797c = null;

    /* renamed from: j */
    private boolean f804j = true;

    /* renamed from: n */
    private Menu f808n = null;

    /* renamed from: o */
    private DataSetObserver f809o = new C0251k(this);

    /* renamed from: d */
    public Handler f798d = new HandlerC0252l(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_blocked, viewGroup, false);
        this.f800f = new ArrayList();
        setHasOptionsMenu(true);
        f796b = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_connecting_server);
        f796b.setCancelable(true);
        f796b.setCanceledOnTouchOutside(false);
        this.f803i = (LinearLayout) viewInflate.findViewById(R.id.no_item_layout);
        this.f807m = (Button) viewInflate.findViewById(R.id.btn_add_buddies);
        this.f807m.setOnClickListener(new ViewOnClickListenerC0249i(this));
        this.f802h = new C0245e(getActivity(), R.layout.layout_blocked, this.f800f, this.f803i, false);
        this.f802h.registerDataSetObserver(this.f809o);
        this.f805k = (TextView) viewInflate.findViewById(R.id.title_settings_block_list);
        this.f805k.setVisibility(0);
        this.f801g = new C0632d(this.f798d);
        this.f801g.m2844a();
        f796b.show();
        f796b.setOnCancelListener(new DialogInterfaceOnCancelListenerC0250j(this));
        this.f799e = (ListView) viewInflate.findViewById(R.id.list);
        this.f799e.setAdapter((ListAdapter) this.f802h);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f801g.m2844a();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f808n = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.actionbar_title_remove, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.actionbar_title_remove).setVisible(true).setEnabled(true);
        this.f808n = menu;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.actionbar_title_remove /* 2131494135 */:
                startActivity(new Intent(getActivity(), (Class<?>) BlockActivity.class));
                break;
        }
        return false;
    }

    /* renamed from: a */
    public Menu m1854a() {
        return this.f808n;
    }
}
