package com.sec.chaton.ignore;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.p009b.ProgressDialogC0238b;
import com.sec.chaton.p015d.C0636h;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class IgnoreFragment extends Fragment {

    /* renamed from: a */
    static boolean f3014a = false;

    /* renamed from: b */
    static ProgressDialogC0238b f3015b;

    /* renamed from: d */
    View f3017d;

    /* renamed from: f */
    private ListView f3019f;

    /* renamed from: g */
    private ArrayList f3020g;

    /* renamed from: h */
    private C0636h f3021h;

    /* renamed from: i */
    private C0822a f3022i;

    /* renamed from: j */
    private View f3023j;

    /* renamed from: c */
    Dialog f3016c = null;

    /* renamed from: e */
    public Handler f3018e = new HandlerC0828g(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_ignored, viewGroup, false);
        this.f3020g = new ArrayList();
        f3015b = (ProgressDialogC0238b) new C1805i(getActivity()).m6139a(R.string.dialog_connecting_server);
        this.f3023j = viewInflate.findViewById(R.id.no_item_layout);
        this.f3022i = new C0822a(getActivity(), R.layout.item_mylist, this.f3020g);
        this.f3021h = new C0636h(this.f3018e);
        this.f3021h.m2889a();
        f3015b.show();
        this.f3019f = (ListView) viewInflate.findViewById(R.id.list);
        this.f3019f.setAdapter((ListAdapter) this.f3022i);
        this.f3019f.setOnItemSelectedListener(new C0826e(this));
        this.f3019f.setOnKeyListener(new ViewOnKeyListenerC0827f(this));
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
