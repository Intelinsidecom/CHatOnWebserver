package com.sec.chaton;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.settings.EnumC1296cu;
import com.sec.chaton.settings.PhoneSettingFragment;
import com.sec.chaton.userprofile.MyPageFragment;
import com.sec.chaton.util.C1786r;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HomeTabFragment extends Fragment implements TabHost.OnTabChangeListener {

    /* renamed from: b */
    private TabHost f238b;

    /* renamed from: c */
    private TabWidget f239c;

    /* renamed from: d */
    private BuddyFragment f240d;

    /* renamed from: e */
    private MsgboxFragment f241e;

    /* renamed from: f */
    private MyPageFragment f242f;

    /* renamed from: g */
    private TextView f243g;

    /* renamed from: h */
    private TextView f244h;

    /* renamed from: i */
    private HashMap f245i;

    /* renamed from: j */
    private String f246j;

    /* renamed from: k */
    private String f247k;

    /* renamed from: l */
    private C0666j f248l;

    /* renamed from: a */
    InterfaceC0667k f237a = new C0217ah(this);

    /* renamed from: m */
    private ContentObserver f249m = new C0218ai(this, new Handler());

    /* renamed from: n */
    private ContentObserver f250n = new C0219aj(this, new Handler());

    /* renamed from: o */
    private BroadcastReceiver f251o = new C0220ak(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C1786r.m6066e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6066e("onCreate, MemoryAddress : " + this, getClass().getSimpleName());
        this.f248l = new C0666j(getActivity().getContentResolver(), this.f237a);
        this.f245i = new HashMap();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6066e("onCreateView, MemoryAddress : " + this, getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_tab, viewGroup, false);
        this.f238b = (TabHost) viewInflate.findViewById(android.R.id.tabhost);
        this.f239c = (TabWidget) viewInflate.findViewById(android.R.id.tabs);
        this.f238b.setup();
        this.f238b.setOnTabChangedListener(this);
        m614a(layoutInflater);
        m617b(layoutInflater);
        m620c(layoutInflater);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C1786r.m6066e("onActivityCrated, MemoryAddress : " + this, getClass().getSimpleName());
        this.f239c.setStripEnabled(true);
        this.f239c.setRightStripDrawable(R.drawable.tab_bottom_right_xml);
        this.f239c.setLeftStripDrawable(R.drawable.tab_bottom_left_xml);
        if (bundle != null && bundle.containsKey("current_position")) {
            this.f247k = bundle.getString("current_position");
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6066e("onResume, MemoryAddress : " + this, getClass().getSimpleName());
        if (!TextUtils.isEmpty(this.f247k)) {
            this.f238b.setCurrentTabByTag(this.f247k);
            this.f247k = null;
        }
        getActivity().getContentResolver().registerContentObserver(C0694i.f2616a, true, this.f250n);
        getActivity().getContentResolver().registerContentObserver(C0688c.f2606a, true, this.f249m);
        this.f248l.startQuery(1, null, C0688c.f2606a, null, "buddy_is_new='Y'", null, null);
        this.f248l.startQuery(2, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
        m613a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("setting_tab_badge_update");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f251o, intentFilter);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        C1786r.m6066e("onPause, MemoryAddress : " + this, getClass().getSimpleName());
        getActivity().getContentResolver().unregisterContentObserver(this.f250n);
        getActivity().getContentResolver().unregisterContentObserver(this.f249m);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_position", this.f238b.getCurrentTabTag());
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if (this.f246j != null && this.f245i.containsKey(this.f246j)) {
            ((InterfaceC0221al) this.f245i.get(this.f246j)).mo1822b();
        }
        if (this.f245i.containsKey(str)) {
            ((InterfaceC0221al) this.f245i.get(str)).mo1821a();
        }
        this.f246j = str;
    }

    /* renamed from: a */
    public static void m615a(TextView textView, Cursor cursor) {
        if (cursor != null) {
            int i = 0;
            while (cursor.moveToNext()) {
                i += cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
            }
            cursor.close();
            if (textView != null) {
                textView.setVisibility(0);
                if (i > 0) {
                    if (i >= 100) {
                        textView.setText(R.string.chat_max_unread);
                        textView.setTextSize(10.0f);
                        return;
                    } else {
                        textView.setText(i + "");
                        textView.setTextSize(12.0f);
                        return;
                    }
                }
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: b */
    public static void m618b(TextView textView, Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            cursor.close();
            if (textView != null) {
                textView.setVisibility(0);
                if (count > 0) {
                    if (count < 100) {
                        textView.setText(count + "");
                        return;
                    } else {
                        textView.setText(R.string.chat_max_unread);
                        return;
                    }
                }
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m614a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(R.id.fragment_buddy);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f238b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f239c, false);
        relativeLayout.setBackgroundResource(R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
        this.f243g = (TextView) relativeLayout.findViewById(R.id.tab_badge);
        this.f243g.setBackgroundResource(R.drawable.msg_icon_newmsg_num_bg);
        this.f243g.setVisibility(8);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_buddy_background));
        textView.setText(getResources().getString(R.string.tab_buddies));
        textView.setTextColor(getResources().getColorStateList(R.color.tab_indicator_text));
        FragmentManager fragmentManager = getFragmentManager();
        this.f240d = (BuddyFragment) fragmentManager.findFragmentByTag("Buddies");
        if (this.f240d == null) {
            this.f240d = new BuddyFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_buddy, this.f240d, "Buddies").commit();
        }
        if (this.f240d instanceof InterfaceC0221al) {
            this.f245i.put("Buddies", this.f240d);
        }
        this.f238b.addTab(this.f238b.newTabSpec("Buddies").setIndicator(relativeLayout).setContent(R.id.fragment_buddy));
    }

    /* renamed from: b */
    private void m617b(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(R.id.fragment_msg_box);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f238b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f239c, false);
        relativeLayout.setBackgroundResource(R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
        this.f244h = (TextView) relativeLayout.findViewById(R.id.tab_badge);
        this.f244h.setBackgroundResource(R.drawable.msg_icon_newmsg_num_bg);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_chat_background));
        textView.setText(getResources().getString(R.string.tab_chat));
        textView.setTextColor(getResources().getColorStateList(R.color.tab_indicator_text));
        this.f244h.setVisibility(8);
        FragmentManager fragmentManager = getFragmentManager();
        this.f241e = (MsgboxFragment) fragmentManager.findFragmentByTag("Chat");
        if (this.f241e == null) {
            this.f241e = new MsgboxFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_msg_box, this.f241e, "Chat").commit();
        }
        if (this.f241e instanceof InterfaceC0221al) {
            this.f245i.put("Chat", this.f241e);
        }
        this.f238b.addTab(this.f238b.newTabSpec("Chat").setIndicator(relativeLayout).setContent(R.id.fragment_msg_box));
    }

    /* renamed from: c */
    private void m620c(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(R.id.fragment_user_profile);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f238b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f239c, false);
        relativeLayout.setBackgroundResource(R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_mypage_background));
        textView.setText(getResources().getString(R.string.tab_mypage));
        textView.setTextColor(getResources().getColorStateList(R.color.tab_indicator_text));
        FragmentManager fragmentManager = getFragmentManager();
        this.f242f = (MyPageFragment) fragmentManager.findFragmentByTag("My page");
        if (this.f242f == null) {
            this.f242f = new MyPageFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_user_profile, this.f242f, "My page").commit();
        }
        if (this.f242f instanceof InterfaceC0221al) {
            this.f245i.put("My page", this.f242f);
        }
        this.f238b.addTab(this.f238b.newTabSpec("My page").setIndicator(relativeLayout).setContent(R.id.fragment_user_profile));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m613a() {
        int iM4677a = PhoneSettingFragment.m4677a(EnumC1296cu.ABOUT_CHATON);
        int iM4677a2 = PhoneSettingFragment.m4677a(EnumC1296cu.GENERAL);
        int iM4677a3 = iM4677a + iM4677a2 + PhoneSettingFragment.m4677a(EnumC1296cu.ANICON) + PhoneSettingFragment.m4677a(EnumC1296cu.SKIN);
        View viewFindViewWithTag = this.f239c.findViewWithTag("Settings");
        if (viewFindViewWithTag != null) {
            TextView textView = (TextView) viewFindViewWithTag.findViewById(R.id.tab_badge);
            if (iM4677a3 > 0) {
                textView.setVisibility(0);
                if (iM4677a3 > 99) {
                    textView.setText("+99");
                    textView.setTextSize(12.0f);
                    return;
                } else {
                    textView.setText(Integer.valueOf(iM4677a3).toString());
                    return;
                }
            }
            textView.setVisibility(8);
        }
    }
}
