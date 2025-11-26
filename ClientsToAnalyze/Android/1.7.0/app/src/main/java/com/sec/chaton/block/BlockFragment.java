package com.sec.chaton.block;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0217p;
import com.sec.chaton.widget.C1356c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BlockFragment extends Fragment {

    /* renamed from: a */
    static boolean f1025a = false;

    /* renamed from: b */
    static ProgressDialog f1026b;

    /* renamed from: d */
    View f1028d;

    /* renamed from: f */
    private ListView f1030f;

    /* renamed from: g */
    private ArrayList f1031g;

    /* renamed from: h */
    private C0217p f1032h;

    /* renamed from: i */
    private C0358e f1033i;

    /* renamed from: j */
    private View f1034j;

    /* renamed from: c */
    Dialog f1027c = null;

    /* renamed from: k */
    private boolean f1035k = true;

    /* renamed from: e */
    public Handler f1029e = new HandlerC0356c(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_blocked, viewGroup, false);
        this.f1031g = new ArrayList();
        f1026b = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_connecting_server);
        this.f1034j = viewInflate.findViewById(R.id.no_item_layout);
        this.f1033i = new C0358e(getActivity(), R.layout.item_mylist, this.f1031g);
        this.f1032h = new C0217p(this.f1029e);
        this.f1032h.m796a();
        f1026b.show();
        this.f1030f = (ListView) viewInflate.findViewById(R.id.list);
        this.f1030f.setAdapter((ListAdapter) this.f1033i);
        this.f1030f.setOnItemSelectedListener(new C0354a(this));
        this.f1030f.setOnKeyListener(new ViewOnKeyListenerC0355b(this));
        return viewInflate;
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
