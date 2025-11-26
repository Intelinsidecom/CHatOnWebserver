package com.sec.chaton;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.userprofile.UserProfileFragment;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.HashMap;

/* loaded from: classes.dex */
public class HomeTabFragment extends Fragment implements TabHost.OnTabChangeListener {

    /* renamed from: b */
    private TabHost f300b;

    /* renamed from: c */
    private TabWidget f301c;

    /* renamed from: d */
    private BuddyFragment f302d;

    /* renamed from: e */
    private MsgboxFragment f303e;

    /* renamed from: f */
    private UserProfileFragment f304f;

    /* renamed from: g */
    private TextView f305g;

    /* renamed from: h */
    private TextView f306h;

    /* renamed from: i */
    private HashMap f307i;

    /* renamed from: j */
    private String f308j;

    /* renamed from: k */
    private String f309k;

    /* renamed from: l */
    private NotifyingAsyncQueryHandler f310l;

    /* renamed from: a */
    NotifyingAsyncQueryHandler.AsyncQueryListener f299a = new C0244l(this);

    /* renamed from: m */
    private ContentObserver f311m = new C0243k(this, new Handler());

    /* renamed from: n */
    private ContentObserver f312n = new C0242j(this, new Handler());

    public interface OnTabChangeListener {
        /* renamed from: a */
        void mo390a();

        /* renamed from: b */
        void mo391b();
    }

    /* renamed from: a */
    private void m381a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(C0062R.id.fragment_buddy);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f300b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C0062R.layout.tab_indicator_badge, (ViewGroup) this.f301c, false);
        relativeLayout.setBackgroundResource(C0062R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(C0062R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(C0062R.id.tab_title);
        this.f305g = (TextView) relativeLayout.findViewById(C0062R.id.tab_badge);
        this.f305g.setBackgroundResource(C0062R.drawable.msg_icon_newmsg_num_bg);
        this.f305g.setVisibility(8);
        imageView.setImageDrawable(getResources().getDrawable(C0062R.drawable.tab_buddy_background));
        textView.setText(getResources().getString(C0062R.string.tab_buddies));
        textView.setTextColor(getResources().getColorStateList(C0062R.color.tab_indicator_text));
        FragmentManager fragmentManager = getFragmentManager();
        this.f302d = (BuddyFragment) fragmentManager.mo5a("Buddies");
        if (this.f302d == null) {
            this.f302d = new BuddyFragment();
            fragmentManager.mo6a().mo12a(C0062R.id.fragment_buddy, this.f302d, "Buddies").mo10a();
        }
        if (this.f302d instanceof OnTabChangeListener) {
            this.f307i.put("Buddies", this.f302d);
        }
        this.f300b.addTab(this.f300b.newTabSpec("Buddies").setIndicator(relativeLayout).setContent(C0062R.id.fragment_buddy));
    }

    /* renamed from: b */
    private void m384b(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(C0062R.id.fragment_msg_box);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f300b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C0062R.layout.tab_indicator_badge, (ViewGroup) this.f301c, false);
        relativeLayout.setBackgroundResource(C0062R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(C0062R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(C0062R.id.tab_title);
        this.f306h = (TextView) relativeLayout.findViewById(C0062R.id.tab_badge);
        this.f306h.setBackgroundResource(C0062R.drawable.msg_icon_newmsg_num_bg);
        imageView.setImageDrawable(getResources().getDrawable(C0062R.drawable.tab_chat_background));
        textView.setText(getResources().getString(C0062R.string.tab_chat));
        textView.setTextColor(getResources().getColorStateList(C0062R.color.tab_indicator_text));
        this.f306h.setVisibility(8);
        FragmentManager fragmentManager = getFragmentManager();
        this.f303e = (MsgboxFragment) fragmentManager.mo5a("Chat");
        if (this.f303e == null) {
            this.f303e = new MsgboxFragment();
            fragmentManager.mo6a().mo12a(C0062R.id.fragment_msg_box, this.f303e, "Chat").mo10a();
        }
        if (this.f303e instanceof OnTabChangeListener) {
            this.f307i.put("Chat", this.f303e);
        }
        this.f300b.addTab(this.f300b.newTabSpec("Chat").setIndicator(relativeLayout).setContent(C0062R.id.fragment_msg_box));
    }

    /* renamed from: c */
    private void m387c(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(C0062R.id.fragment_user_profile);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f300b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C0062R.layout.tab_indicator_badge, (ViewGroup) this.f301c, false);
        relativeLayout.setBackgroundResource(C0062R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(C0062R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(C0062R.id.tab_title);
        imageView.setImageDrawable(getResources().getDrawable(C0062R.drawable.tab_mypage_background));
        textView.setText(getResources().getString(C0062R.string.tab_mypage));
        textView.setTextColor(getResources().getColorStateList(C0062R.color.tab_indicator_text));
        FragmentManager fragmentManager = getFragmentManager();
        this.f304f = (UserProfileFragment) fragmentManager.mo5a("My page");
        if (this.f304f == null) {
            this.f304f = new UserProfileFragment();
            fragmentManager.mo6a().mo12a(C0062R.id.fragment_user_profile, this.f304f, "My page").mo10a();
        }
        if (this.f304f instanceof OnTabChangeListener) {
            this.f307i.put("My page", this.f304f);
        }
        this.f300b.addTab(this.f300b.newTabSpec("My page").setIndicator(relativeLayout).setContent(C0062R.id.fragment_user_profile));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m388c(TextView textView, Cursor cursor) {
        if (cursor == null) {
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        int i = 0;
        while (cursor.moveToNext()) {
            i += cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
        }
        cursor.close();
        if (textView != null) {
            textView.setVisibility(0);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i >= 100) {
                textView.setText(C0062R.string.chat_max_unread);
                textView.setTextSize(10.0f);
            } else {
                textView.setText(i + "");
                textView.setTextSize(12.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m389d(TextView textView, Cursor cursor) {
        if (cursor == null) {
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        int count = cursor.getCount();
        cursor.close();
        if (textView != null) {
            textView.setVisibility(0);
            if (count <= 0) {
                textView.setVisibility(8);
            } else if (count >= 100) {
                textView.setText(C0062R.string.chat_max_unread);
            } else {
                textView.setText(count + "");
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ChatONLogWriter.m3511e("onActivityCrated, MemoryAddress : " + this, getClass().getSimpleName());
        this.f301c.setStripEnabled(true);
        this.f301c.setRightStripDrawable(C0062R.drawable.tab_bottom_right_xml);
        this.f301c.setLeftStripDrawable(C0062R.drawable.tab_bottom_left_xml);
        if (bundle == null || !bundle.containsKey("current_position")) {
            return;
        }
        this.f309k = bundle.getString("current_position");
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ChatONLogWriter.m3511e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3511e("onCreate, MemoryAddress : " + this, getClass().getSimpleName());
        this.f310l = new NotifyingAsyncQueryHandler(getActivity().getContentResolver(), this.f299a);
        this.f307i = new HashMap();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ChatONLogWriter.m3511e("onCreateView, MemoryAddress : " + this, getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(C0062R.layout.layout_fragment_tab, viewGroup, false);
        this.f300b = (TabHost) viewInflate.findViewById(android.R.id.tabhost);
        this.f301c = (TabWidget) viewInflate.findViewById(android.R.id.tabs);
        this.f300b.setup();
        this.f300b.setOnTabChangedListener(this);
        m381a(layoutInflater);
        m384b(layoutInflater);
        m387c(layoutInflater);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ChatONLogWriter.m3511e("onPause, MemoryAddress : " + this, getClass().getSimpleName());
        getActivity().getContentResolver().unregisterContentObserver(this.f312n);
        getActivity().getContentResolver().unregisterContentObserver(this.f311m);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        ChatONLogWriter.m3511e("onResume, MemoryAddress : " + this, getClass().getSimpleName());
        if (!TextUtils.isEmpty(this.f309k)) {
            this.f300b.setCurrentTabByTag(this.f309k);
            this.f309k = null;
        }
        getActivity().getContentResolver().registerContentObserver(ChatONContract.InBoxTable.f1717a, true, this.f312n);
        getActivity().getContentResolver().registerContentObserver(ChatONContract.BuddyTable.f1713a, true, this.f311m);
        this.f310l.startQuery(1, null, ChatONContract.BuddyTable.f1713a, null, "buddy_is_new='Y'", null, null);
        this.f310l.startQuery(2, null, ChatONContract.InBoxTable.f1717a, null, "inbox_unread_count > 0", null, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_position", this.f300b.getCurrentTabTag());
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if (this.f308j != null && this.f307i.containsKey(this.f308j)) {
            ((OnTabChangeListener) this.f307i.get(this.f308j)).mo391b();
        }
        if (this.f307i.containsKey(str)) {
            ((OnTabChangeListener) this.f307i.get(str)).mo390a();
        }
        this.f308j = str;
    }
}
