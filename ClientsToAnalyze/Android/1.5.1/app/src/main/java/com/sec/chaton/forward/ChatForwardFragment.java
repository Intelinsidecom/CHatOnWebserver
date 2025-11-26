package com.sec.chaton.forward;

import android.R;
import android.app.Activity;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.NotifyingAsyncQueryHandler;
import com.sec.chaton.msgbox.MsgboxFragment;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ChatForwardFragment extends Fragment implements TabHost.OnTabChangeListener {

    /* renamed from: b */
    private TabHost f1875b;

    /* renamed from: c */
    private TabWidget f1876c;

    /* renamed from: d */
    private BuddyFragment f1877d;

    /* renamed from: e */
    private MsgboxFragment f1878e;

    /* renamed from: f */
    private TextView f1879f;

    /* renamed from: g */
    private TextView f1880g;

    /* renamed from: i */
    private Bundle f1882i;

    /* renamed from: j */
    private int f1883j;

    /* renamed from: k */
    private String f1884k;

    /* renamed from: l */
    private String f1885l;

    /* renamed from: m */
    private String f1886m;

    /* renamed from: n */
    private NotifyingAsyncQueryHandler f1887n;

    /* renamed from: h */
    private Bundle f1881h = new Bundle();

    /* renamed from: a */
    NotifyingAsyncQueryHandler.AsyncQueryListener f1874a = new C0233a(this);

    /* renamed from: o */
    private ContentObserver f1888o = new C0234b(this, new Handler());

    /* renamed from: p */
    private ContentObserver f1889p = new C0235c(this, new Handler());

    public interface OnTabChangeListener {
    }

    /* renamed from: a */
    private void m2374a(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(C0062R.id.fragment_buddy);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1875b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C0062R.layout.tab_indicator_badge, (ViewGroup) this.f1876c, false);
        relativeLayout.setBackgroundResource(C0062R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(C0062R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(C0062R.id.tab_title);
        this.f1879f = (TextView) relativeLayout.findViewById(C0062R.id.tab_badge);
        this.f1879f.setBackgroundResource(C0062R.drawable.msg_icon_newmsg_num_bg);
        this.f1879f.setVisibility(8);
        imageView.setImageDrawable(getResources().getDrawable(C0062R.drawable.tab_buddy_background));
        textView.setText(getString(C0062R.string.tab_buddies));
        textView.setTextColor(getResources().getColorStateList(C0062R.color.tab_indicator_text));
        FragmentManager fragmentManager = getFragmentManager();
        this.f1877d = (BuddyFragment) fragmentManager.mo5a("Buddy");
        if (this.f1877d == null) {
            this.f1877d = new BuddyFragment();
            this.f1881h.putInt(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f1883j);
            this.f1881h.putString("download_uri", this.f1884k);
            this.f1881h.putString("inboxNO", this.f1886m);
            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f1883j) == ChatONContract.MessageTable.MsgContentType.CALENDAR || ChatONContract.MessageTable.MsgContentType.m2195a(this.f1883j) == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                this.f1881h.putString("sub_content", this.f1885l);
            }
            this.f1881h.putInt("ACTIVITY_PURPOSE", 8);
            this.f1877d.setArguments(this.f1881h);
            fragmentManager.mo6a().mo12a(C0062R.id.fragment_buddy, this.f1877d, "Buddy").mo10a();
        }
        this.f1875b.addTab(this.f1875b.newTabSpec("Buddy").setIndicator(relativeLayout).setContent(C0062R.id.fragment_buddy));
    }

    /* renamed from: b */
    private void m2377b(LayoutInflater layoutInflater) {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setId(C0062R.id.fragment_msg_box);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1875b.getTabContentView().addView(frameLayout);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(C0062R.layout.tab_indicator_badge, (ViewGroup) this.f1876c, false);
        relativeLayout.setBackgroundResource(C0062R.drawable.tab_indicator_xml);
        ImageView imageView = (ImageView) relativeLayout.findViewById(C0062R.id.tab_icon);
        TextView textView = (TextView) relativeLayout.findViewById(C0062R.id.tab_title);
        this.f1880g = (TextView) relativeLayout.findViewById(C0062R.id.tab_badge);
        this.f1880g.setBackgroundResource(C0062R.drawable.msg_icon_newmsg_num_bg);
        imageView.setImageDrawable(getResources().getDrawable(C0062R.drawable.tab_chat_background));
        textView.setText(getString(C0062R.string.tab_chat));
        textView.setTextColor(getResources().getColorStateList(C0062R.color.tab_indicator_text));
        this.f1880g.setVisibility(8);
        FragmentManager fragmentManager = getFragmentManager();
        this.f1878e = (MsgboxFragment) fragmentManager.mo5a("Chat");
        if (this.f1878e == null) {
            this.f1878e = new MsgboxFragment();
            this.f1881h.putInt(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE, this.f1883j);
            this.f1881h.putString("download_uri", this.f1884k);
            this.f1881h.putString("inboxNO", this.f1886m);
            if (ChatONContract.MessageTable.MsgContentType.m2195a(this.f1883j) == ChatONContract.MessageTable.MsgContentType.CALENDAR || ChatONContract.MessageTable.MsgContentType.m2195a(this.f1883j) == ChatONContract.MessageTable.MsgContentType.CONTACT) {
                this.f1881h.putString("sub_content", this.f1885l);
            }
            this.f1878e.setArguments(this.f1881h);
            fragmentManager.mo6a().mo12a(C0062R.id.fragment_msg_box, this.f1878e, "Chat").mo10a();
        }
        this.f1875b.addTab(this.f1875b.newTabSpec("Chat").setIndicator(relativeLayout).setContent(C0062R.id.fragment_msg_box));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m2380c(TextView textView, Cursor cursor) {
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
    public static void m2381d(TextView textView, Cursor cursor) {
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
        getFragmentManager();
        this.f1876c.setStripEnabled(true);
        this.f1876c.setRightStripDrawable(C0062R.drawable.tab_bottom_right_xml);
        this.f1876c.setLeftStripDrawable(C0062R.drawable.tab_bottom_left_xml);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ChatONLogWriter.m3511e("onAttach, MemoryAddress : " + this, getClass().getSimpleName());
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1887n = new NotifyingAsyncQueryHandler(getActivity().getContentResolver(), this.f1874a);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f1882i = getArguments();
        if (this.f1882i != null && this.f1882i.size() > 0) {
            if (this.f1882i.containsKey(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE)) {
                this.f1883j = this.f1882i.getInt(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE);
                ChatONLogWriter.m3509d("Forward content_type:" + this.f1883j);
            }
            if (this.f1882i.containsKey("download_uri")) {
                this.f1884k = this.f1882i.getString("download_uri");
                ChatONLogWriter.m3509d("Forward download_uri:" + this.f1884k);
            }
            if (this.f1882i.containsKey("sub_content")) {
                this.f1885l = this.f1882i.getString("sub_content");
                ChatONLogWriter.m3509d("Forward sub_content:" + this.f1885l);
            }
            if (this.f1882i.containsKey("inboxNO")) {
                this.f1886m = this.f1882i.getString("inboxNO");
                ChatONLogWriter.m3509d("Forward mInboxNo:" + this.f1886m);
            }
        }
        View viewInflate = layoutInflater.inflate(C0062R.layout.layout_fragment_tab, viewGroup, false);
        this.f1875b = (TabHost) viewInflate.findViewById(R.id.tabhost);
        this.f1876c = (TabWidget) viewInflate.findViewById(R.id.tabs);
        this.f1875b.setup();
        m2377b(layoutInflater);
        m2374a(layoutInflater);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getActivity().getContentResolver().unregisterContentObserver(this.f1889p);
        getActivity().getContentResolver().unregisterContentObserver(this.f1888o);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        getActivity().getContentResolver().registerContentObserver(ChatONContract.InBoxTable.f1717a, true, this.f1889p);
        getActivity().getContentResolver().registerContentObserver(ChatONContract.BuddyTable.f1713a, true, this.f1888o);
        this.f1887n.startQuery(1, null, ChatONContract.BuddyTable.f1713a, null, "buddy_is_new='Y'", null, null);
        this.f1887n.startQuery(2, null, ChatONContract.InBoxTable.f1717a, null, "inbox_unread_count > 0", null, null);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
    }
}
