package com.sec.chaton;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyProfileFragment;
import com.sec.chaton.buddy.BuddySelectActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.chat.InterfaceC0495bi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.C0672p;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.settings.PhoneSettingFragment;
import com.sec.chaton.specialbuddy.SpecialBuddyChatFragment;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.userprofile.MyPageFragmentTablet;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HomeTabletFragment extends Fragment implements ActionBar.TabListener {

    /* renamed from: a */
    public ListView f253a;

    /* renamed from: d */
    private HashMap f256d;

    /* renamed from: e */
    private BuddyFragment f257e;

    /* renamed from: f */
    private FrameLayout f258f;

    /* renamed from: g */
    private MsgboxFragment f259g;

    /* renamed from: h */
    private FrameLayout f260h;

    /* renamed from: i */
    private MyPageFragmentTablet f261i;

    /* renamed from: j */
    private FrameLayout f262j;

    /* renamed from: k */
    private ActivitySettings f263k;

    /* renamed from: l */
    private FrameLayout f264l;

    /* renamed from: m */
    private C0666j f265m;

    /* renamed from: n */
    private boolean f266n;

    /* renamed from: q */
    private int f269q;

    /* renamed from: r */
    private int f270r;

    /* renamed from: o */
    private boolean f267o = false;

    /* renamed from: p */
    private boolean f268p = false;

    /* renamed from: s */
    private boolean f271s = false;

    /* renamed from: t */
    private boolean f272t = false;

    /* renamed from: u */
    private Bundle f273u = null;

    /* renamed from: v */
    private int f274v = 0;

    /* renamed from: b */
    public boolean f254b = false;

    /* renamed from: w */
    private ContentObserver f275w = new C0223an(this, new Handler());

    /* renamed from: x */
    private ContentObserver f276x = new C0224ao(this, new Handler());

    /* renamed from: y */
    private ContentObserver f277y = new C0225ap(this, new Handler());

    /* renamed from: c */
    InterfaceC0667k f255c = new C0226aq(this);

    /* renamed from: z */
    private final int f278z = 123;

    /* renamed from: A */
    private BroadcastReceiver f252A = new C0227ar(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f265m = new C0666j(GlobalApplication.m3260b().getContentResolver(), this.f255c);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        m627a(configuration);
    }

    /* renamed from: a */
    private void m627a(Configuration configuration) throws Resources.NotFoundException {
        if (configuration.orientation == 2) {
            m625a(R.dimen.land_Left_fragment_size, R.dimen.land_right_fragment_size);
        } else if (configuration.orientation == 1) {
            m625a(R.dimen.port_left_fragment_size, R.dimen.port_right_fragment_size);
        }
    }

    /* renamed from: a */
    private void m625a(int i, int i2) throws Resources.NotFoundException {
        int dimensionPixelOffset = getActivity().getResources().getDimensionPixelOffset(i);
        int dimensionPixelOffset2 = getActivity().getResources().getDimensionPixelOffset(i2);
        ((FrameLayout) getActivity().findViewById(R.id.fragment_controller)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset, -1));
        ((FrameLayout) getActivity().findViewById(R.id.fragment_container)).setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelOffset2, -1));
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.base_activity, viewGroup, false);
        this.f253a = (ListView) viewInflate.findViewById(R.id.more_option_list);
        this.f253a.setTag(true);
        this.f253a.setOnItemClickListener(new C0222am(this));
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C1786r.m6066e("onActivityCreated", getClass().getSimpleName());
        this.f256d = new HashMap();
        m637d();
        m640e();
        m641f();
        m642g();
        this.f254b = false;
    }

    /* renamed from: c */
    private void m635c() {
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.removeAllTabs();
        actionBar.setNavigationMode(2);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        if (Build.VERSION.SDK_INT > 13) {
            actionBar.setHomeButtonEnabled(false);
        }
        BaseActivity.m1829b(this, true);
        int i = C1789u.m6075a().getInt("selectedTab", 0);
        m624a(R.layout.hc_tab_indicator_badge_buddy);
        m624a(R.layout.hc_tab_indicator_badge_chat);
        m624a(R.layout.hc_tab_indicator_badge_mypage);
        m624a(R.layout.hc_tab_indicator_badge_settings);
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getAction() != null && ((getActivity().getIntent().getFlags() & 1048576) == 1048576 || getActivity().getIntent().getAction().equals("android.intent.action.MAIN"))) {
            m644a();
        }
        actionBar.setSelectedNavigationItem(i);
    }

    /* renamed from: a */
    public void m644a() {
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_msg_box);
        if (fragmentFindFragmentById != null && (fragmentFindFragmentById instanceof MsgboxFragment)) {
            ((MsgboxFragment) fragmentFindFragmentById).m3536b(C1789u.m6075a().getString("lastInbox", null));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null && extras.getBoolean("callChat", false)) {
            m645a(getActivity().getIntent().getExtras());
        }
    }

    /* renamed from: b */
    public void m647b() {
        if (this.f253a.getVisibility() == 0) {
            this.f253a.setVisibility(8);
            return;
        }
        ComponentCallbacks componentCallbacksFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_container);
        if (componentCallbacksFindFragmentById instanceof InterfaceC0495bi) {
            this.f253a.setVisibility(0);
            this.f253a.setAdapter((ListAdapter) ((InterfaceC0495bi) componentCallbacksFindFragmentById).getMenu());
            this.f253a.setOnItemSelectedListener(((InterfaceC0495bi) componentCallbacksFindFragmentById).getMenuListener());
        } else if (componentCallbacksFindFragmentById instanceof TrunkView) {
            this.f253a.setVisibility(0);
            this.f253a.setAdapter((ListAdapter) ((TrunkView) componentCallbacksFindFragmentById).m5349b());
            this.f253a.setOnItemSelectedListener(((TrunkView) componentCallbacksFindFragmentById).m5351c());
        } else if (this.f257e != null && this.f266n) {
            this.f253a.setVisibility(0);
            this.f253a.setAdapter((ListAdapter) this.f257e.m2052i());
            this.f253a.setOnItemSelectedListener(this.f257e.m2053j());
        }
    }

    /* renamed from: a */
    public void m645a(Bundle bundle) {
        this.f271s = true;
        this.f273u = bundle;
    }

    /* renamed from: b */
    public void m648b(Bundle bundle) {
        this.f272t = true;
        this.f273u = bundle;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f254b) {
            m635c();
            this.f254b = true;
        }
        C1786r.m6066e("onResume", getClass().getSimpleName());
        getActivity().getContentResolver().registerContentObserver(C0694i.f2616a, true, this.f277y);
        getActivity().getContentResolver().registerContentObserver(C0688c.f2606a, true, this.f275w);
        getActivity().getContentResolver().registerContentObserver(C0704s.f2647a, true, this.f276x);
        this.f265m.startQuery(1, null, C0688c.f2606a, null, "buddy_is_new='Y'", null, null);
        this.f265m.startQuery(2, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
        this.f265m.startQuery(3, null, C0704s.f2647a, null, "isNew='Y'", null, null);
        m643h();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f252A, intentFilter);
        if (this.f271s && this.f273u != null) {
            getActivity().getIntent().putExtra("callChat", false);
            m636c(this.f273u);
            this.f273u = null;
            this.f271s = false;
            return;
        }
        if (this.f272t && this.f273u != null) {
            getActivity().getIntent().putExtra("callChat", false);
            m638d(this.f273u);
            this.f273u = null;
            this.f272t = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6066e("onPause, MemoryAddress : " + this, getClass().getSimpleName());
        getActivity().getContentResolver().unregisterContentObserver(this.f277y);
        getActivity().getContentResolver().unregisterContentObserver(this.f275w);
        getActivity().getContentResolver().unregisterContentObserver(this.f276x);
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f252A);
    }

    /* renamed from: c */
    private void m636c(Bundle bundle) {
        Fragment chatFragment;
        Fragment fragmentFindFragmentById = getFragmentManager().findFragmentById(R.id.fragment_msg_box);
        if (fragmentFindFragmentById != null && (fragmentFindFragmentById instanceof MsgboxFragment)) {
            ((MsgboxFragment) fragmentFindFragmentById).m3536b((String) null);
        }
        getActivity().getActionBar().selectTab(getActivity().getActionBar().getTabAt(1));
        if (m630a(getActivity().getIntent())) {
            chatFragment = new SpecialBuddyChatFragment();
            chatFragment.setHasOptionsMenu(true);
            chatFragment.setArguments(bundle);
        } else {
            chatFragment = new ChatFragment();
            chatFragment.setHasOptionsMenu(true);
            chatFragment.setArguments(bundle);
        }
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, chatFragment, "container").commit();
    }

    /* renamed from: d */
    private void m638d(Bundle bundle) {
        getActivity().getActionBar().selectTab(getActivity().getActionBar().getTabAt(0));
        BuddyProfileFragment buddyProfileFragment = new BuddyProfileFragment();
        buddyProfileFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, buddyProfileFragment, "container").commit();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.actionbar_menu, menu);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.removeItem(123);
        menu.removeItem(R.id.menu_start_chat);
        menu.removeItem(R.id.menu_broadcast);
        if (this.f266n || this.f268p) {
            if (this.f257e.m2047e() > 0) {
                if (this.f266n || this.f268p) {
                    menu.add(0, R.id.menu_start_chat, 1, "").setIcon(R.drawable.account_top_menu_addchat).setTitle(R.string.menu_button_start_chat).setShowAsAction(2);
                    menu.add(0, R.id.menu_broadcast, 2, "").setIcon(R.drawable.account_top_menu_broadcast).setTitle(R.string.menu_inbox_broadcast).setShowAsAction(2);
                }
                if ((getFragmentManager().findFragmentById(R.id.fragment_container) instanceof InterfaceC0495bi) || this.f266n || (getFragmentManager().findFragmentById(R.id.fragment_container) instanceof TrunkView)) {
                    menu.add(0, 123, 3, "").setIcon(R.drawable.top_menu_optionmenu).setTitle(R.string.setting_birthday_option).setShowAsAction(2);
                    return;
                }
                return;
            }
            if ((getFragmentManager().findFragmentById(R.id.fragment_container) instanceof InterfaceC0495bi) || this.f266n || (getFragmentManager().findFragmentById(R.id.fragment_container) instanceof TrunkView)) {
                menu.add(0, 123, 1, "").setIcon(R.drawable.top_menu_optionmenu).setTitle(R.string.setting_birthday_option).setShowAsAction(2);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 123:
                m647b();
                break;
            case R.id.menu_start_chat /* 2131494111 */:
                Intent intent = new Intent(getActivity(), (Class<?>) BuddySelectActivity.class);
                intent.putExtra("BUDDY_SORT_STYLE", 11);
                intent.putExtra("ACTIVITY_PURPOSE", 2);
                if (GlobalApplication.m3265f()) {
                    intent.putExtra("ACTION_PURPOSE", 4);
                }
                startActivity(intent);
                break;
            case R.id.menu_broadcast /* 2131494112 */:
                Intent intent2 = new Intent(getActivity(), (Class<?>) BuddySelectActivity.class);
                intent2.putExtra("BUDDY_SORT_STYLE", 11);
                intent2.putExtra("ACTIVITY_PURPOSE", 3);
                if (GlobalApplication.m3265f()) {
                    intent2.putExtra("ACTION_PURPOSE", 5);
                }
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m626a(int i, Fragment fragment, FrameLayout frameLayout, int i2, String str, Fragment fragment2) {
        frameLayout.setId(i2);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setVisibility(8);
        ((ViewGroup) getView().findViewById(R.id.fragment_controller)).addView(frameLayout);
        try {
            fragment.getFragmentManager().beginTransaction().replace(i2, fragment2, str).commit();
        } catch (Exception e) {
            C1786r.m6054a("Error commiting Fragmnet in HomeTabletFragment", getClass().getSimpleName());
        }
        if (fragment2 instanceof InterfaceC0221al) {
            this.f256d.put(Integer.valueOf(i), (InterfaceC0221al) fragment2);
        }
    }

    /* renamed from: a */
    private void m624a(int i) {
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.addTab(actionBar.newTab().setCustomView(i).setTabListener(this), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m633b(int i, int i2) {
        ActionBar.Tab tabAt;
        TextView textView;
        if (getActivity() != null && (tabAt = getActivity().getActionBar().getTabAt(i)) != null && (textView = (TextView) tabAt.getCustomView().findViewById(R.id.tab_badge)) != null) {
            textView.setVisibility(0);
            switch (i) {
                case 0:
                case 1:
                    if (i2 > 0) {
                        textView.setVisibility(0);
                        if (i2 >= 100) {
                            textView.setText(R.string.chat_max_unread);
                            textView.setTextSize(11.0f);
                        } else if (i2 >= 10) {
                            textView.setText(String.valueOf(i2));
                            textView.setTextSize(12.0f);
                        } else {
                            textView.setText(String.valueOf(i2));
                            textView.setTextSize(14.0f);
                        }
                        if (i == 0 && this.f257e != null) {
                            this.f257e.m2055l();
                            break;
                        }
                    } else {
                        textView.setVisibility(8);
                        break;
                    }
                    break;
                case 3:
                    textView.setVisibility(0);
                    if (this.f274v > 99) {
                        textView.setText("+99");
                        textView.setTextSize(12.0f);
                        break;
                    } else {
                        textView.setText(Integer.valueOf(this.f274v).toString());
                        break;
                    }
            }
        }
    }

    /* renamed from: d */
    private void m637d() {
        this.f257e = new BuddyFragment();
        this.f258f = new FrameLayout(getActivity());
        m626a(0, this, this.f258f, R.id.fragment_buddy, getResources().getString(R.string.tab_buddies), this.f257e);
    }

    /* renamed from: e */
    private void m640e() {
        this.f259g = new MsgboxFragment();
        this.f260h = new FrameLayout(getActivity());
        m626a(1, this, this.f260h, R.id.fragment_msg_box, getResources().getString(R.string.tab_chat), this.f259g);
    }

    /* renamed from: f */
    private void m641f() {
        this.f261i = new MyPageFragmentTablet();
        this.f262j = new FrameLayout(getActivity());
        m626a(2, this, this.f262j, R.id.fragment_user_profile, getResources().getString(R.string.tablet_tab_mypage), this.f261i);
    }

    /* renamed from: g */
    private void m642g() {
        this.f263k = new ActivitySettings();
        this.f264l = new FrameLayout(getActivity());
        this.f264l.setBackgroundResource(R.drawable.list_bg);
        m626a(3, this, this.f264l, R.id.fragment_settings, getResources().getString(R.string.menu_inbox_setting), this.f263k);
    }

    public class EmptySettingsFragment extends Fragment {

        /* renamed from: a */
        public static final String f281a = EmptySettingsFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(R.layout.layout_settings_about, viewGroup, false);
        }
    }

    public class EmptyFragment extends Fragment {

        /* renamed from: a */
        public static final String f280a = EmptyFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.fragment_empty, viewGroup, false);
            TextView textView = (TextView) viewInflate.findViewById(R.id.emptyTextView);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(R.drawable.no_chat), (Drawable) null, (Drawable) null);
            textView.setText(R.string.container_empty);
            return viewInflate;
        }
    }

    public class EmptyBuddyFragment extends Fragment {

        /* renamed from: a */
        public static final String f279a = EmptyBuddyFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return layoutInflater.inflate(R.layout.buddy_fragment_empty, viewGroup, false);
        }
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        tab.getCustomView().findViewById(R.id.tab_title_bottom).setVisibility(0);
        switch (position) {
            case 0:
                this.f258f.setVisibility(0);
                this.f266n = true;
                break;
            case 1:
                this.f260h.setVisibility(0);
                FragmentManager fragmentManager = getFragmentManager();
                if (getView().findViewById(R.id.fragment_container) != null && fragmentManager.findFragmentByTag("container") == null) {
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, new EmptyFragment(), "container").commit();
                }
                this.f268p = true;
                break;
            case 2:
                this.f262j.setVisibility(0);
                this.f267o = true;
                break;
            case 3:
                this.f264l.setVisibility(0);
                break;
        }
        C1789u.m6077a("selectedTab", Integer.valueOf(position));
        ((InterfaceC0221al) this.f256d.get(Integer.valueOf(position))).mo1821a();
        this.f253a.setVisibility(8);
        getActivity().invalidateOptionsMenu();
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        int position = tab.getPosition();
        tab.getCustomView().findViewById(R.id.tab_title_bottom).setVisibility(8);
        switch (position) {
            case 0:
                this.f258f.setVisibility(8);
                this.f266n = false;
                break;
            case 1:
                this.f260h.setVisibility(8);
                this.f268p = false;
                break;
            case 2:
                this.f262j.setVisibility(8);
                this.f267o = false;
                break;
            case 3:
                this.f264l.setVisibility(8);
                break;
        }
        ((InterfaceC0221al) this.f256d.get(Integer.valueOf(position))).mo1822b();
        this.f253a.setVisibility(8);
        getActivity().invalidateOptionsMenu();
    }

    /* renamed from: a */
    public static void m628a(FragmentManager fragmentManager, Fragment fragment) {
        if (fragmentManager.findFragmentById(R.id.fragment_container) != null) {
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, "container").commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m643h() {
        this.f274v = PhoneSettingFragment.m4680c();
        this.f274v += PhoneSettingFragment.m4681d();
        this.f274v += C1003c.m3945c();
        if (this.f274v > 0) {
            m633b(3, 0);
        }
    }

    /* renamed from: a */
    public boolean m646a(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.f253a.getGlobalVisibleRect(rect);
        if (this.f253a.getVisibility() != 0 || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        this.f253a.setVisibility(8);
        return true;
    }

    /* renamed from: a */
    private boolean m630a(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent.getBooleanExtra("specialbuddy", false)) {
            C1786r.m6061b("checkSpecialBuddy(), spbd_intent, specialbuddy flag : true", HomeTabletFragment.class.getSimpleName());
            return true;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("receivers");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            return false;
        }
        String str = stringArrayExtra[0];
        if (!C0672p.m3096c(getActivity(), str)) {
            return str.startsWith("0999");
        }
        C1786r.m6061b("checkSpecialBuddy(), spbd_intent, specialbuddy table exist : " + str.toString(), HomeTabletFragment.class.getSimpleName());
        return true;
    }
}
