package com.sec.chaton.forward;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.InterfaceC0726l;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.util.C1341p;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ChatForwardFragment extends Fragment implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    private TabHost f2393a;

    /* renamed from: b */
    private TabWidget f2394b;

    /* renamed from: c */
    private HashMap f2395c;

    /* renamed from: d */
    private String f2396d;

    /* renamed from: e */
    private int f2397e;

    /* renamed from: f */
    private String f2398f;

    /* renamed from: g */
    private String f2399g;

    /* renamed from: h */
    private String f2400h;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C1341p.m4662e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2395c = new HashMap();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BuddyFragment buddyFragment;
        MsgboxFragment msgboxFragment;
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("content_type")) {
                this.f2397e = arguments.getInt("content_type");
                C1341p.m4659c("Forward content_type:" + this.f2397e);
            }
            if (arguments.containsKey("download_uri")) {
                this.f2398f = arguments.getString("download_uri");
                C1341p.m4659c("Forward download_uri:" + this.f2398f);
            }
            if (arguments.containsKey("sub_content")) {
                this.f2399g = arguments.getString("sub_content");
                C1341p.m4659c("Forward sub_content:" + this.f2399g);
            }
            if (arguments.containsKey("inboxNO")) {
                this.f2400h = arguments.getString("inboxNO");
                C1341p.m4659c("Forward mInboxNo:" + this.f2400h);
            }
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_tab, viewGroup, false);
        this.f2393a = (TabHost) viewInflate.findViewById(android.R.id.tabhost);
        this.f2394b = (TabWidget) viewInflate.findViewById(android.R.id.tabs);
        this.f2393a.setup();
        this.f2393a.setOnTabChangedListener(this);
        if (bundle == null) {
            buddyFragment = new BuddyFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("content_type", this.f2397e);
            bundle2.putString("download_uri", this.f2398f);
            bundle2.putString("inboxNO", this.f2400h);
            bundle2.putString("sub_content", this.f2399g);
            bundle2.putInt("ACTIVITY_PURPOSE", 8);
            buddyFragment.setArguments(bundle2);
        } else {
            buddyFragment = null;
        }
        HomeTabFragment.m659a(this, this.f2393a, this.f2394b, this.f2395c, R.id.fragment_buddy, R.layout.tab_indicator_badge_buddy, "Buddy", buddyFragment);
        if (bundle == null) {
            msgboxFragment = new MsgboxFragment();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("content_type", this.f2397e);
            bundle3.putString("download_uri", this.f2398f);
            bundle3.putString("inboxNO", this.f2400h);
            bundle3.putString("sub_content", this.f2399g);
            msgboxFragment.setArguments(bundle3);
        } else {
            msgboxFragment = null;
        }
        HomeTabFragment.m659a(this, this.f2393a, this.f2394b, this.f2395c, R.id.fragment_msg_box, R.layout.tab_indicator_badge_chat, "Chat", msgboxFragment);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if (this.f2396d != null && this.f2395c.containsKey(this.f2396d)) {
            ((InterfaceC0726l) this.f2395c.get(this.f2396d)).mo2200b();
        }
        if (this.f2395c.containsKey(str)) {
            ((InterfaceC0726l) this.f2395c.get(str)).mo2192a();
        }
        this.f2396d = str;
    }
}
