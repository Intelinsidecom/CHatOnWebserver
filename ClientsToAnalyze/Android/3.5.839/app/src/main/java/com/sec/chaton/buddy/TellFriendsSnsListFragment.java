package com.sec.chaton.buddy;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TellFriendsSnsListFragment extends ListFragment {

    /* renamed from: i */
    public static final String f4190i = TellFriendsFragment.class.getSimpleName();

    /* renamed from: j */
    protected ViewGroup f4191j;

    /* renamed from: k */
    protected ListView f4192k;

    /* renamed from: l */
    protected C1400iz f4193l;

    /* renamed from: m */
    protected List<C1399iy> f4194m;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4194m = new ArrayList();
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tell_friends_share_via, viewGroup, false);
        this.f4192k = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f4191j = (ViewGroup) viewInflate.findViewById(R.id.progress);
        ArrayList arrayList = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.tell_friends)));
        C1427a.m7521d();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!C1427a.m7522e()) {
                if (!str.equals(getActivity().getString(R.string.tellfriends_via_facebook)) || !str.equals(getActivity().getString(R.string.tellfriends_via_twitter))) {
                    C1399iy c1399iy = new C1399iy(str);
                    c1399iy.m7515a(getActivity());
                    this.f4194m.add(c1399iy);
                }
            } else {
                C1399iy c1399iy2 = new C1399iy(str);
                c1399iy2.m7515a(getActivity());
                this.f4194m.add(c1399iy2);
            }
        }
        this.f4193l = new C1400iz(this, getActivity(), R.layout.list_item_common_1, this.f4194m);
        m7018c();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m61a(this.f4193l);
        ((C1400iz) m63b()).notifyDataSetInvalidated();
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        C1399iy c1399iy = (C1399iy) m63b().getItem(i);
        if (c1399iy != null) {
            startActivity(c1399iy.m7516b());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
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

    /* renamed from: c */
    public void m7018c() {
        this.f4191j.setVisibility(8);
    }
}
