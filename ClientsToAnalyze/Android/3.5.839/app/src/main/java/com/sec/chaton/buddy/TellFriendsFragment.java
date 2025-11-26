package com.sec.chaton.buddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.p061g.C2346e;
import com.sec.chaton.util.C4822an;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TellFriendsFragment extends ListFragment {

    /* renamed from: i */
    public static final String f4184i = TellFriendsFragment.class.getSimpleName();

    /* renamed from: j */
    protected ViewGroup f4185j;

    /* renamed from: k */
    protected ListView f4186k;

    /* renamed from: l */
    protected C1397iw f4187l;

    /* renamed from: m */
    protected AsyncTaskC1398ix f4188m;

    /* renamed from: n */
    protected List<C1396iv> f4189n;

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 111:
                C2346e.m10272a(getActivity(), i2, intent, false, null);
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4189n = new ArrayList();
    }

    @Override // android.support.v4.app.ListFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tell_friends_share_via, viewGroup, false);
        this.f4186k = (ListView) viewInflate.findViewById(android.R.id.list);
        this.f4185j = (ViewGroup) viewInflate.findViewById(R.id.progress);
        this.f4187l = new C1397iw(this, getActivity(), R.layout.list_item_common_5, this.f4189n);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m61a(this.f4187l);
        ((C1397iw) m63b()).notifyDataSetInvalidated();
    }

    @Override // android.support.v4.app.ListFragment
    /* renamed from: a */
    public void mo62a(ListView listView, View view, int i, long j) {
        C1396iv c1396iv = (C1396iv) m63b().getItem(i);
        if (c1396iv != null) {
            if (c1396iv.m7506d() != 0) {
                startActivityForResult(c1396iv.m7505c(), c1396iv.m7506d());
            } else {
                startActivity(c1396iv.m7505c());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f4188m != null && !this.f4188m.isCancelled()) {
            this.f4188m.cancel(true);
            this.f4188m = null;
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

    /* renamed from: c */
    public void m7016c() {
        this.f4185j.setVisibility(0);
    }

    /* renamed from: d */
    public void m7017d() {
        this.f4185j.setVisibility(8);
    }

    /* renamed from: a */
    public static String m7015a(Context context) {
        return C4822an.m18218a() ? context.getString(R.string.sns_invite_message_full_feature, " www.chaton.com/invite.html ") : context.getString(R.string.sns_invite_message_lite_feature, " www.chaton.com/invite.html ");
    }
}
