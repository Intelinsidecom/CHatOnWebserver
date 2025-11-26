package com.sec.chaton;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sec.chaton.HomeTabFragment;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.userprofile.UserProfileFragment;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HomeTabletFragment extends Fragment implements ActionBar.TabListener {

    /* renamed from: a */
    private HashMap f313a;

    /* renamed from: b */
    private BuddyFragment f314b;

    /* renamed from: c */
    private FrameLayout f315c;

    /* renamed from: d */
    private MsgboxFragment f316d;

    /* renamed from: e */
    private FrameLayout f317e;

    /* renamed from: f */
    private UserProfileFragment f318f;

    /* renamed from: g */
    private FrameLayout f319g;

    public class EmptyFragment extends Fragment {

        /* renamed from: a */
        public static final String f320a = EmptyFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(C0062R.layout.fragment_empty_chat, viewGroup, false);
        }
    }

    /* renamed from: a */
    private void m392a(ActionBar actionBar) {
        this.f314b = new BuddyFragment();
        this.f313a.put(0, this.f314b);
        this.f315c = new FrameLayout(getActivity());
        this.f315c.setId(C0062R.id.fragment_buddy);
        this.f315c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f315c.setVisibility(8);
        ((ViewGroup) getView().findViewById(C0062R.id.fragment_tab_content)).addView(this.f315c);
        getFragmentManager().mo6a().mo12a(C0062R.id.fragment_buddy, this.f314b, BuddyFragment.f409a).mo10a();
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(C0062R.string.tab_buddies)).setTabListener(this));
    }

    /* renamed from: a */
    private void m393a(Bundle bundle) {
        ActionBar actionBar = getActivity().getActionBar();
        this.f313a = new HashMap();
        m392a(actionBar);
        m394b(actionBar);
        m395c(actionBar);
        actionBar.setNavigationMode(2);
        if (bundle != null) {
        }
    }

    /* renamed from: b */
    private void m394b(ActionBar actionBar) {
        this.f316d = new MsgboxFragment();
        this.f313a.put(1, this.f316d);
        this.f317e = new FrameLayout(getActivity());
        this.f317e.setId(C0062R.id.fragment_msg_box);
        this.f317e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f317e.setVisibility(8);
        ((ViewGroup) getView().findViewById(C0062R.id.fragment_tab_content)).addView(this.f317e);
        getFragmentManager().mo6a().mo12a(C0062R.id.fragment_msg_box, this.f316d, MsgboxFragment.f1958a).mo10a();
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(C0062R.string.tab_chat)).setTabListener(this));
    }

    /* renamed from: c */
    private void m395c(ActionBar actionBar) {
        this.f318f = new UserProfileFragment();
        this.f313a.put(2, this.f318f);
        this.f319g = new FrameLayout(getActivity());
        this.f319g.setId(C0062R.id.fragment_user_profile);
        this.f319g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f319g.setVisibility(8);
        ((ViewGroup) getView().findViewById(C0062R.id.fragment_tab_content)).addView(this.f319g);
        getFragmentManager().mo6a().mo12a(C0062R.id.fragment_user_profile, this.f318f, UserProfileFragment.f3433a).mo10a();
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(C0062R.string.tab_mypage)).setTabListener(this));
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m393a(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        if (getView().findViewById(C0062R.id.fragment_container) == null || fragmentManager.mo5a("container") != null) {
            return;
        }
        fragmentManager.mo6a().mo16b(C0062R.id.fragment_container, new EmptyFragment(), "container").mo10a();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0062R.layout.fragment_home_tablet, viewGroup, false);
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                this.f315c.setVisibility(0);
                break;
            case 1:
                this.f317e.setVisibility(0);
                break;
            case 2:
                this.f319g.setVisibility(0);
                break;
        }
        ((HomeTabFragment.OnTabChangeListener) this.f313a.get(Integer.valueOf(position))).mo390a();
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                this.f315c.setVisibility(8);
                break;
            case 1:
                this.f317e.setVisibility(8);
                break;
            case 2:
                this.f319g.setVisibility(8);
                break;
        }
        ((HomeTabFragment.OnTabChangeListener) this.f313a.get(Integer.valueOf(position))).mo391b();
    }
}
