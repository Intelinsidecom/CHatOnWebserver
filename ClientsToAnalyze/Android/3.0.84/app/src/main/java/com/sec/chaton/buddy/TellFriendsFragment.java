package com.sec.chaton.buddy;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TellFriendsFragment extends ListFragment {

    /* renamed from: a */
    public static final String f2339a = TellFriendsFragment.class.getSimpleName();

    /* renamed from: b */
    protected ViewGroup f2340b;

    /* renamed from: c */
    protected ListView f2341c;

    /* renamed from: d */
    protected C0790it f2342d;

    /* renamed from: e */
    protected AsyncTaskC0791iu f2343e;

    /* renamed from: f */
    protected List<C0789is> f2344f;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2344f = new ArrayList();
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tell_friends_share_via, viewGroup, false);
        this.f2341c = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f2340b = (ViewGroup) viewInflate.findViewById(R.id.progress);
        this.f2342d = new C0790it(this, getActivity(), R.layout.list_item_common_5, this.f2344f);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setListAdapter(this.f2342d);
        ((C0790it) getListAdapter()).notifyDataSetInvalidated();
    }

    @Override // android.support.v4.app.ListFragment
    public void onListItemClick(ListView listView, View view, int i, long j) {
        C0789is c0789is = (C0789is) getListAdapter().getItem(i);
        if (c0789is != null) {
            startActivity(c0789is.m4356c());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f2343e != null && !this.f2343e.isCancelled()) {
            this.f2343e.cancel(true);
            this.f2343e = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    /* renamed from: a */
    public void m3942a() {
        this.f2340b.setVisibility(0);
    }

    /* renamed from: b */
    public void m3943b() {
        this.f2340b.setVisibility(8);
    }
}
