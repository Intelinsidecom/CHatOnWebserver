package com.sec.chaton;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.settings.PhoneSettingFragment;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.util.C1341p;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HomeTabFragment extends Fragment implements TabHost.OnTabChangeListener {

    /* renamed from: b */
    private TabHost f269b;

    /* renamed from: c */
    private TabWidget f270c;

    /* renamed from: d */
    private HashMap f271d;

    /* renamed from: e */
    private String f272e;

    /* renamed from: f */
    private String f273f;

    /* renamed from: g */
    private C0630j f274g;

    /* renamed from: a */
    InterfaceC0626f f268a = new C0228aa(this);

    /* renamed from: h */
    private ContentObserver f275h = new C1361y(this, new Handler());

    /* renamed from: i */
    private ContentObserver f276i = new C1360x(this, new Handler());

    /* renamed from: j */
    private BroadcastReceiver f277j = new C1362z(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C1341p.m4662e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4662e("onCreate, MemoryAddress : " + this, getClass().getSimpleName());
        this.f274g = new C0630j(getActivity().getContentResolver(), this.f268a);
        this.f271d = new HashMap();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1341p.m4662e("onCreateView, MemoryAddress : " + this, getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_tab, viewGroup, false);
        this.f269b = (TabHost) viewInflate.findViewById(android.R.id.tabhost);
        this.f270c = (TabWidget) viewInflate.findViewById(android.R.id.tabs);
        this.f269b.setup();
        this.f269b.setOnTabChangedListener(this);
        m659a(this, this.f269b, this.f270c, this.f271d, R.id.fragment_buddy, R.layout.tab_indicator_badge_buddy, "Buddies", bundle == null ? new BuddyFragment() : null);
        m659a(this, this.f269b, this.f270c, this.f271d, R.id.fragment_msg_box, R.layout.tab_indicator_badge_chat, "Chat", bundle == null ? new MsgboxFragment() : null);
        m659a(this, this.f269b, this.f270c, this.f271d, R.id.fragment_user_profile, R.layout.tab_indicator_badge_mypage, "My page", bundle == null ? new MyPageFragment() : null);
        m659a(this, this.f269b, this.f270c, this.f271d, R.id.fragment_setting_tab, R.layout.tab_indicator_badge_setting, "Settings", bundle == null ? new PhoneSettingFragment() : null);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C1341p.m4662e("onActivityCrated, MemoryAddress : " + this, getClass().getSimpleName());
        if (bundle != null && bundle.containsKey("current_position")) {
            this.f273f = bundle.getString("current_position");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1341p.m4662e("onResume, MemoryAddress : " + this, getClass().getSimpleName());
        if (!TextUtils.isEmpty(this.f273f)) {
            this.f269b.setCurrentTabByTag(this.f273f);
            this.f273f = null;
        }
        getActivity().getContentResolver().registerContentObserver(C0671x.f2315a, true, this.f276i);
        getActivity().getContentResolver().registerContentObserver(C0667t.f2310a, true, this.f275h);
        this.f274g.startQuery(1, null, C0667t.f2310a, null, "buddy_is_new='Y'", null, null);
        this.f274g.startQuery(2, null, C0671x.f2315a, null, "inbox_unread_count > 0", null, null);
        m658a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f277j, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1341p.m4662e("onPause, MemoryAddress : " + this, getClass().getSimpleName());
        getActivity().getContentResolver().unregisterContentObserver(this.f276i);
        getActivity().getContentResolver().unregisterContentObserver(this.f275h);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f277j);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_position", this.f269b.getCurrentTabTag());
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if (this.f272e != null && this.f271d.containsKey(this.f272e)) {
            ((InterfaceC0726l) this.f271d.get(this.f272e)).mo2200b();
        }
        if (getActivity() != null) {
            getActivity().closeOptionsMenu();
        }
        if (this.f271d.containsKey(str)) {
            ((InterfaceC0726l) this.f271d.get(str)).mo2192a();
        }
        this.f272e = str;
    }

    /* renamed from: a */
    public static void m659a(Fragment fragment, TabHost tabHost, TabWidget tabWidget, HashMap map, int i, int i2, String str, Fragment fragment2) {
        ComponentCallbacks componentCallbacksFindFragmentByTag;
        FrameLayout frameLayout = new FrameLayout(fragment.getActivity());
        frameLayout.setId(i);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        tabHost.getTabContentView().addView(frameLayout);
        ViewGroup viewGroup = (ViewGroup) fragment.getActivity().getLayoutInflater().inflate(i2, (ViewGroup) tabWidget, false);
        viewGroup.setTag(str);
        if (fragment2 != null) {
            fragment.getFragmentManager().beginTransaction().add(i, fragment2, str).commit();
            componentCallbacksFindFragmentByTag = fragment2;
        } else {
            componentCallbacksFindFragmentByTag = fragment.getFragmentManager().findFragmentByTag(str);
        }
        if (componentCallbacksFindFragmentByTag instanceof InterfaceC0726l) {
            map.put(str, (InterfaceC0726l) componentCallbacksFindFragmentByTag);
        }
        tabHost.addTab(tabHost.newTabSpec(str).setIndicator(viewGroup).setContent(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m662b(TabWidget tabWidget, String str, int i) {
        TextView textView = (TextView) tabWidget.findViewWithTag(str).findViewById(R.id.tab_badge);
        if (i > 0) {
            textView.setVisibility(0);
            if (i >= 100) {
                textView.setText(R.string.chat_max_unread);
                textView.setTextSize(0, textView.getResources().getDimension(R.dimen.text_size_10));
                return;
            }
            textView.setText(String.valueOf(i));
            if (i >= 10) {
                textView.setTextSize(0, textView.getResources().getDimension(R.dimen.text_size_12));
                return;
            } else {
                textView.setTextSize(0, textView.getResources().getDimension(R.dimen.text_size_13));
                return;
            }
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m658a() {
        View viewFindViewWithTag = this.f270c.findViewWithTag("Settings");
        if (viewFindViewWithTag != null) {
            TextView textView = (TextView) viewFindViewWithTag.findViewById(R.id.tab_badge);
            if (PhoneSettingFragment.m3886c() || PhoneSettingFragment.m3887d()) {
                textView.setVisibility(0);
                textView.setText("N");
            } else {
                textView.setVisibility(8);
            }
        }
    }
}
