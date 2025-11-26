package com.sec.chaton.forward;

import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.InterfaceC0302bn;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1739av;
import com.sec.chaton.util.C1786r;

/* loaded from: classes.dex */
public class ChatForwardFragment extends Fragment implements TabHost.OnTabChangeListener, InterfaceC0302bn {

    /* renamed from: b */
    private TabHost f2747b;

    /* renamed from: c */
    private TabWidget f2748c;

    /* renamed from: d */
    private BuddyFragment f2749d;

    /* renamed from: e */
    private MsgboxFragment f2750e;

    /* renamed from: f */
    private TextView f2751f;

    /* renamed from: g */
    private TextView f2752g;

    /* renamed from: i */
    private Bundle f2754i;

    /* renamed from: j */
    private int f2755j;

    /* renamed from: k */
    private String f2756k;

    /* renamed from: l */
    private String f2757l;

    /* renamed from: n */
    private String f2759n;

    /* renamed from: o */
    private C0666j f2760o;

    /* renamed from: h */
    private Bundle f2753h = new Bundle();

    /* renamed from: m */
    private String f2758m = "";

    /* renamed from: p */
    private Menu f2761p = null;

    /* renamed from: a */
    InterfaceC0667k f2746a = new C0748a(this);

    /* renamed from: q */
    private ContentObserver f2762q = new C0749b(this, new Handler());

    /* renamed from: r */
    private ContentObserver f2763r = new C0750c(this, new Handler());

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C1786r.m6066e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2760o = new C0666j(getActivity().getContentResolver(), this.f2746a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2754i = getArguments();
        if (this.f2754i != null && this.f2754i.size() > 0) {
            if (this.f2754i.containsKey("content_type")) {
                this.f2755j = this.f2754i.getInt("content_type");
                C1786r.m6064d("Forward content_type:" + this.f2755j);
            }
            if (this.f2754i.containsKey("download_uri")) {
                this.f2756k = this.f2754i.getString("download_uri");
                C1786r.m6064d("Forward download_uri:" + this.f2756k);
            }
            if (this.f2754i.containsKey("sub_content")) {
                this.f2757l = this.f2754i.getString("sub_content");
                C1786r.m6064d("Forward sub_content:" + this.f2757l);
            }
            if (this.f2754i.containsKey("inboxNO")) {
                this.f2759n = this.f2754i.getString("inboxNO");
                C1786r.m6064d("Forward mInboxNo:" + this.f2759n);
            }
            if (this.f2754i.containsKey("forward_sender_name")) {
                this.f2758m = this.f2754i.getString("forward_sender_name");
                C1786r.m6064d("Forward sender name:" + this.f2758m);
            }
        }
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_tab, viewGroup, false);
        this.f2747b = (TabHost) viewInflate.findViewById(android.R.id.tabhost);
        this.f2748c = (TabWidget) viewInflate.findViewById(android.R.id.tabs);
        this.f2747b.setup();
        this.f2747b.setOnTabChangedListener(this);
        m3245b(layoutInflater);
        m3242a(layoutInflater);
        BaseActivity.m1829b(this, true);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getFragmentManager();
        if (GlobalApplication.m3265f()) {
            this.f2748c.setStripEnabled(false);
        } else {
            this.f2748c.setStripEnabled(true);
        }
        this.f2748c.setRightStripDrawable(R.drawable.tab_bottom_right_xml);
        this.f2748c.setLeftStripDrawable(R.drawable.tab_bottom_left_xml);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().getContentResolver().registerContentObserver(C0694i.f2616a, true, this.f2763r);
        getActivity().getContentResolver().registerContentObserver(C0688c.f2606a, true, this.f2762q);
        this.f2760o.startQuery(1, null, C0688c.f2606a, null, "buddy_is_new='Y'", null, null);
        this.f2760o.startQuery(2, null, C0694i.f2616a, null, "inbox_unread_count > 0", null, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getContentResolver().unregisterContentObserver(this.f2763r);
        getActivity().getContentResolver().unregisterContentObserver(this.f2762q);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m3248c(TextView textView, Cursor cursor) {
        if (cursor != null) {
            int i = 0;
            while (cursor.moveToNext()) {
                i += cursor.getInt(cursor.getColumnIndex("inbox_unread_count"));
            }
            cursor.close();
            if (textView != null) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m3249d(TextView textView, Cursor cursor) {
        if (cursor != null) {
            int count = cursor.getCount();
            cursor.close();
            if (textView != null) {
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
    private void m3242a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(R.id.fragment_buddy);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f2747b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f2748c, false);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
        this.f2751f = (TextView) relativeLayout.findViewById(R.id.tab_badge);
        this.f2751f.setBackgroundResource(R.drawable.msg_icon_newmsg_num_bg);
        this.f2751f.setVisibility(8);
        if (!GlobalApplication.m3265f()) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_buddy_background));
        }
        textView.setText(getString(R.string.tab_buddies));
        textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_forward_font_color));
        FragmentManager fragmentManager = getFragmentManager();
        this.f2749d = (BuddyFragment) fragmentManager.findFragmentByTag("Buddy");
        if (this.f2749d == null) {
            this.f2749d = new BuddyFragment(this);
            this.f2753h.putInt("content_type", this.f2755j);
            this.f2753h.putString("download_uri", this.f2756k);
            this.f2753h.putString("inboxNO", this.f2759n);
            this.f2753h.putString("forward_sender_name", this.f2758m);
            this.f2753h.putString("sub_content", this.f2757l);
            this.f2753h.putInt("ACTIVITY_PURPOSE", 8);
            this.f2749d.setArguments(this.f2753h);
            fragmentManager.beginTransaction().add(R.id.fragment_buddy, this.f2749d, "Buddy").commit();
        }
        this.f2747b.addTab(this.f2747b.newTabSpec("Buddy").setIndicator(relativeLayout).setContent(R.id.fragment_buddy));
    }

    /* renamed from: b */
    private void m3245b(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(R.id.fragment_msg_box);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f2747b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tab_indicator_badge, (ViewGroup) this.f2748c, false);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tab_title);
        this.f2752g = (TextView) relativeLayout.findViewById(R.id.tab_badge);
        this.f2752g.setBackgroundResource(R.drawable.msg_icon_newmsg_num_bg);
        if (!GlobalApplication.m3265f()) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.tab_chat_background));
        }
        textView.setText(getString(R.string.tab_chat));
        textView.setTextColor(getResources().getColorStateList(R.drawable.tab_title_forward_font_color));
        this.f2752g.setVisibility(8);
        FragmentManager fragmentManager = getFragmentManager();
        this.f2750e = (MsgboxFragment) fragmentManager.findFragmentByTag("Chat");
        if (this.f2750e == null) {
            this.f2750e = new MsgboxFragment();
            this.f2753h.putInt("content_type", this.f2755j);
            this.f2753h.putString("download_uri", this.f2756k);
            this.f2753h.putString("inboxNO", this.f2759n);
            this.f2753h.putString("forward_sender_name", this.f2758m);
            this.f2753h.putString("sub_content", this.f2757l);
            this.f2750e.setArguments(this.f2753h);
            fragmentManager.beginTransaction().add(R.id.fragment_msg_box, this.f2750e, "Chat").commit();
        }
        this.f2747b.addTab(this.f2747b.newTabSpec("Chat").setIndicator(relativeLayout).setContent(R.id.fragment_msg_box));
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if (str.equals("Chat")) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f2747b.getApplicationWindowToken(), 0);
            if (this.f2761p != null) {
                this.f2761p.findItem(R.id.menu_start_chat).setEnabled(false);
                this.f2761p.findItem(R.id.menu_broadcast).setEnabled(false);
                return;
            }
            return;
        }
        this.f2749d.m2056m();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        menu.clear();
        menu.add(0, R.id.menu_start_chat, 1, R.string.menu_button_start_chat).setIcon(R.drawable.account_top_menu_addchat).setTitle(R.string.menu_button_start_chat).setShowAsAction(6);
        menu.add(0, R.id.menu_broadcast, 2, R.string.menu_inbox_broadcast).setIcon(R.drawable.account_top_menu_broadcast).setTitle(R.string.menu_inbox_broadcast).setShowAsAction(6);
        menu.findItem(R.id.menu_start_chat).setEnabled(false);
        menu.findItem(R.id.menu_broadcast).setEnabled(false);
        this.f2761p = menu;
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.chaton.buddy.InterfaceC0302bn
    /* renamed from: a */
    public void mo2228a() {
        if (this.f2761p != null) {
            this.f2761p.findItem(R.id.menu_start_chat).setEnabled(false);
            this.f2761p.findItem(R.id.menu_broadcast).setEnabled(false);
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0302bn
    /* renamed from: b */
    public void mo2229b() {
        if (this.f2761p != null) {
            this.f2761p.findItem(R.id.menu_start_chat).setEnabled(true);
            this.f2761p.findItem(R.id.menu_broadcast).setEnabled(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            getActivity().finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_start_chat) {
            if (C1739av.m5927a()) {
                return true;
            }
            this.f2749d.m2043c();
        } else if (menuItem.getItemId() == R.id.menu_broadcast) {
            if (C1739av.m5927a()) {
                return true;
            }
            this.f2749d.m2045d();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
