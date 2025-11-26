package com.sec.chaton.chat;

import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.trunk.InterfaceC1150bn;
import com.sec.chaton.trunk.TrunkDetailActivity;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.trunk.database.C1178f;
import com.sec.chaton.trunk.p043c.C1161b;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1632t;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatActivity extends FragmentActivity implements InterfaceC0604u, InterfaceC1150bn {

    /* renamed from: t */
    private static boolean f1699t = false;

    /* renamed from: x */
    private static InterfaceC0531ag f1700x = null;

    /* renamed from: a */
    TabHost f1701a;

    /* renamed from: b */
    C0591h f1702b;

    /* renamed from: c */
    Button f1703c;

    /* renamed from: d */
    Button f1704d;

    /* renamed from: e */
    ImageButton f1705e;

    /* renamed from: f */
    TextView f1706f;

    /* renamed from: g */
    TextView f1707g;

    /* renamed from: h */
    TextView f1708h;

    /* renamed from: i */
    EditText f1709i;

    /* renamed from: j */
    public ImageButton f1710j;

    /* renamed from: k */
    RelativeLayout f1711k;

    /* renamed from: l */
    RelativeLayout f1712l;

    /* renamed from: m */
    Bundle f1713m;

    /* renamed from: n */
    Bundle f1714n;

    /* renamed from: s */
    private C1632t f1719s;

    /* renamed from: u */
    private ChatActivity f1720u;

    /* renamed from: w */
    private C0630j f1722w;

    /* renamed from: z */
    private C1161b f1724z;

    /* renamed from: o */
    public String f1715o = null;

    /* renamed from: p */
    public String f1716p = null;

    /* renamed from: v */
    private boolean f1721v = false;

    /* renamed from: q */
    InterfaceC0626f f1717q = new C0593j(this);

    /* renamed from: y */
    private Handler f1723y = new HandlerC0595l(this);

    /* renamed from: r */
    ContentObserver f1718r = new C0596m(this, new Handler());

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1720u = this;
        setContentView(R.layout.chat_fragment_tabs);
        this.f1701a = (TabHost) findViewById(android.R.id.tabhost);
        this.f1701a.setup();
        this.f1719s = new C1632t(this);
        this.f1702b = new C0591h(this, this.f1701a, R.id.realtabcontent);
        this.f1722w = new C0630j(this.f1720u.getContentResolver(), this.f1717q);
        Intent intent = getIntent();
        this.f1703c = (Button) findViewById(R.id.btnForChat);
        this.f1704d = (Button) findViewById(R.id.btnForTrunk);
        this.f1705e = (ImageButton) findViewById(R.id.btnForChatlist);
        this.f1706f = (TextView) findViewById(R.id.textNames);
        this.f1711k = (RelativeLayout) findViewById(R.id.LayoutChatBtn);
        this.f1712l = (RelativeLayout) findViewById(R.id.LayoutTrunkBtn);
        this.f1707g = (TextView) findViewById(R.id.imgTrunkNew);
        this.f1708h = (TextView) findViewById(R.id.chat_type_icon);
        this.f1713m = intent.getExtras();
        if (EnumC0665r.m3011a(this.f1713m.getInt("chatType")) == EnumC0665r.BROADCAST) {
            this.f1711k.setVisibility(8);
            this.f1712l.setVisibility(8);
            this.f1706f.setVisibility(0);
        } else {
            this.f1711k.setVisibility(0);
            this.f1712l.setVisibility(0);
            this.f1706f.setVisibility(8);
            if (EnumC0665r.m3011a(this.f1713m.getInt("chatType")) == EnumC0665r.ONETOONE) {
                this.f1708h.setBackgroundResource(R.drawable.chatting_btn_icon_chat);
            } else {
                this.f1708h.setBackgroundResource(R.drawable.chatting_btn_lcon_groupchat);
            }
        }
        this.f1703c.setOnTouchListener(new ViewOnTouchListenerC0601r(this));
        this.f1704d.setOnTouchListener(new ViewOnTouchListenerC0602s(this));
        this.f1714n = intent.getExtras();
        this.f1702b.m2776a(this.f1701a.newTabSpec("chatroom").setIndicator("Chat"), ChatFragment.class, this.f1713m);
        this.f1702b.m2776a(this.f1701a.newTabSpec("trunk").setIndicator("Trunk"), TrunkView.class, this.f1714n);
        if (bundle != null) {
            this.f1701a.setCurrentTabByTag(bundle.getString("tab"));
        }
        this.f1703c.setSelected(true);
        this.f1721v = true;
        this.f1724z = new C1161b(GlobalApplication.m3100a(), this.f1723y);
        this.f1703c.setOnClickListener(new ViewOnClickListenerC0599p(this));
        this.f1704d.setOnClickListener(new ViewOnClickListenerC0600q(this));
        this.f1705e.setOnClickListener(new ViewOnClickListenerC0597n(this));
        this.f1710j = (ImageButton) findViewById(R.id.btnChatOption);
        this.f1710j.setOnClickListener(new ViewOnClickListenerC0598o(this));
    }

    /* renamed from: c */
    public void m2598c(String str) {
        this.f1706f.setText(str);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("tab", this.f1701a.getCurrentTabTag());
    }

    /* renamed from: a */
    public void m2593a(int i) {
        if (i > 0 && i < 100) {
            this.f1707g.setSelected(true);
            this.f1707g.setText(String.valueOf(i));
        } else if (i >= 100) {
            this.f1707g.setText(R.string.chat_max_unread);
            this.f1707g.setSelected(true);
        } else {
            this.f1707g.setText(" ");
            this.f1707g.setSelected(false);
        }
    }

    /* renamed from: a */
    public void m2592a() {
        this.f1704d.setSelected(true);
        this.f1703c.setSelected(false);
    }

    /* renamed from: c */
    public void m2597c() {
        this.f1704d.setSelected(false);
        this.f1703c.setSelected(true);
    }

    /* renamed from: d */
    public void m2600d(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f1724z.m4198a(arrayList);
    }

    @Override // com.sec.chaton.chat.InterfaceC0604u
    /* renamed from: a */
    public void mo2594a(String str) {
        C0594k c0594k = (C0594k) this.f1702b.f2029e.get("trunk");
        if (this.f1716p == null) {
            this.f1716p = str;
            c0594k.f2035c.putString("sessionId", str);
        } else if (!this.f1716p.equals("newSessionId")) {
            this.f1716p = str;
            c0594k.f2035c.putString("sessionId", str);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC0604u
    /* renamed from: b */
    public void mo2596b(String str) {
        this.f1715o = str;
        ((C0594k) this.f1702b.f2029e.get("trunk")).f2035c.putString("inboxNO", str);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (f1700x == null || f1700x.mo2202d()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1341p.m4660c("[LIFE] onNewIntent, Task ID: " + getTaskId(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        C1341p.m4660c("[LIFE] onStart, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStart();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        C1341p.m4660c("[LIFE] onStop, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onStop();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        C1341p.m4660c("[LIFE] onResume, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onResume();
        if (!TextUtils.isEmpty(this.f1716p)) {
            this.f1722w.startQuery(9, null, C1178f.f4044a, null, "session_id=?", new String[]{this.f1716p}, null);
        }
        getContentResolver().registerContentObserver(C1178f.f4044a, true, this.f1718r);
        if (!this.f1721v) {
            m2600d(this.f1716p);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        C1341p.m4660c("[LIFE] onPause, Task ID: " + getTaskId(), getClass().getSimpleName());
        super.onPause();
        getContentResolver().unregisterContentObserver(this.f1718r);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1150bn
    /* renamed from: a */
    public void mo2595a(String str, String str2, String str3, String str4, EnumC1168f enumC1168f) {
        TrunkDetailActivity.m3985a(this, str, str2, str3, str4, enumC1168f);
    }

    @Override // com.sec.chaton.trunk.InterfaceC1150bn
    /* renamed from: c_ */
    public void mo2599c_() {
        this.f1701a.setCurrentTabByTag("chatroom");
        this.f1703c.setSelected(true);
        this.f1704d.setSelected(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (C1632t.m5917c() && this.f1719s != null) {
            if (this.f1701a.getCurrentTabTag().equals("chatroom")) {
                ChatFragment chatFragment = (ChatFragment) ((C0594k) this.f1702b.f2029e.get("chatroom")).f2036d;
                if (chatFragment != null) {
                    if (!chatFragment.m2699a(findViewById(R.id.btnChatOption))) {
                        C1341p.m4660c("ChatFragment.showDroupMenu failed", getClass().getSimpleName());
                    }
                } else {
                    C1341p.m4660c("ChatFragment is null", getClass().getSimpleName());
                }
                C1341p.m4660c("chat compatpopup menu", getClass().getSimpleName());
            } else {
                TrunkView trunkView = (TrunkView) ((C0594k) this.f1702b.f2029e.get("trunk")).f2036d;
                if (trunkView != null) {
                    if (!trunkView.m4086a(findViewById(R.id.btnChatOption))) {
                        C1341p.m4660c("TrunkView.showDroupMenu failed", getClass().getSimpleName());
                    }
                } else {
                    C1341p.m4660c("TrunkView is null", getClass().getSimpleName());
                }
                C1341p.m4660c("trunk compatpopup menu", getClass().getSimpleName());
            }
            return false;
        }
        return super.onMenuOpened(i, menu);
    }

    /* renamed from: a */
    public static void m2590a(boolean z) {
        f1699t = z;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.f1709i = ChatFragment.m2651h();
        if (this.f1709i != null && !this.f1709i.hasFocus() && !f1699t) {
            f1699t = true;
            this.f1709i.requestFocus();
            this.f1709i.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
