package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.base.BaseSinglePaneActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.provider.C3942a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4857bv;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
import java.util.ArrayList;
import java.util.Timer;

@TargetApi(14)
/* loaded from: classes.dex */
public class MessagingInfoActivity extends BaseSinglePaneActivity {

    /* renamed from: W */
    private Context f14885W;

    /* renamed from: X */
    private C2210x f14886X;

    /* renamed from: Y */
    private ListView f14887Y;

    /* renamed from: Z */
    private C4164cs f14888Z;

    /* renamed from: aa */
    private EnumC2300t f14889aa;

    /* renamed from: ab */
    private String f14890ab;

    /* renamed from: ac */
    private int f14891ac;

    /* renamed from: ad */
    private C3942a f14892ad;

    /* renamed from: n */
    public static String f14856n = "extra thread id";

    /* renamed from: o */
    public static String f14857o = "extra title";

    /* renamed from: p */
    public static String f14858p = "extra recipients";

    /* renamed from: q */
    public static String f14859q = "extra chattype";

    /* renamed from: r */
    public static String f14860r = "isClosing";

    /* renamed from: s */
    public static String f14861s = "isRemoveLockedSMS";

    /* renamed from: t */
    public static String f14862t = "roomType";

    /* renamed from: u */
    public static String f14863u = "onetoone";

    /* renamed from: v */
    public static String f14864v = "br2";

    /* renamed from: w */
    public static String f14865w = "extra fileuri";

    /* renamed from: x */
    public static String f14866x = "extra vcalendar";

    /* renamed from: y */
    public static String f14867y = "extra vard name";

    /* renamed from: z */
    public static String f14868z = "extra initchat";

    /* renamed from: A */
    public static String f14850A = "extra showinput";

    /* renamed from: B */
    public static String f14851B = "extra chagetitle";

    /* renamed from: C */
    public static String f14852C = "extra invite";

    /* renamed from: D */
    public static String f14853D = "extra inbox nobi";

    /* renamed from: H */
    private static int f14854H = 1;

    /* renamed from: I */
    private static int f14855I = 100;

    /* renamed from: G */
    private final String f14871G = "MessagingInfoActivity";

    /* renamed from: J */
    private View f14872J = null;

    /* renamed from: K */
    private ImageView f14873K = null;

    /* renamed from: L */
    private TextView f14874L = null;

    /* renamed from: M */
    private ImageButton f14875M = null;

    /* renamed from: N */
    private ViewGroup f14876N = null;

    /* renamed from: O */
    private ViewGroup f14877O = null;

    /* renamed from: P */
    private CheckBox f14878P = null;

    /* renamed from: Q */
    private TextView f14879Q = null;

    /* renamed from: R */
    private View f14880R = null;

    /* renamed from: S */
    private Button f14881S = null;

    /* renamed from: T */
    private Button f14882T = null;

    /* renamed from: U */
    private String f14883U = null;

    /* renamed from: V */
    private String[] f14884V = null;

    /* renamed from: E */
    final Handler f14869E = new HandlerC4159cn(this);

    /* renamed from: F */
    InterfaceC2211y f14870F = new C4162cq(this);

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.messaging_info);
        this.f14885W = this;
        this.f14886X = new C2210x(getContentResolver(), this.f14870F);
        this.f14892ad = new C3942a(getContentResolver());
        Intent intent = getIntent();
        if (intent.hasExtra(f14856n)) {
            this.f14883U = intent.getStringExtra(f14856n);
        }
        if (TextUtils.isEmpty(this.f14883U)) {
            finish();
            return;
        }
        if (intent.hasExtra(f14859q)) {
            if (intent.getStringExtra(f14859q).equals(f14863u)) {
                this.f14889aa = EnumC2300t.ONETOONE;
            } else {
                this.f14889aa = EnumC2300t.BROADCAST2;
            }
        }
        if (intent.hasExtra(f14858p)) {
            this.f14884V = intent.getStringArrayExtra(f14858p);
        }
        m15850j();
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        super.onSupportCreateOptionsMenu(menu);
        if (C4822an.m18218a()) {
            menu.add(0, 1, 1, getResources().getString(R.string.menu_chat_close)).setIcon(R.drawable.more_option_closechat_white);
        } else {
            menu.add(0, 1, 1, getResources().getString(R.string.menu_close_message_room)).setIcon(R.drawable.more_option_closechat_white);
        }
        return true;
    }

    @Override // com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportPrepareOptionsMenu(Menu menu) {
        return super.onSupportPrepareOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Long.valueOf(this.f14883U));
                this.f14892ad.m15245c(this.f14869E, 1805, arrayList, Long.valueOf(this.f14883U).longValue());
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    /* renamed from: j */
    private void m15850j() {
        this.f14887Y = (ListView) findViewById(R.id.listview);
        this.f14872J = LayoutInflater.from(this.f14885W).inflate(R.layout.chat_info_header, (ViewGroup) this.f14887Y, false);
        this.f14873K = (ImageView) this.f14872J.findViewById(R.id.profile_image);
        this.f14874L = (TextView) this.f14872J.findViewById(R.id.title_name);
        this.f14875M = (ImageButton) this.f14872J.findViewById(R.id.btn_edit);
        this.f14876N = (ViewGroup) this.f14872J.findViewById(R.id.alert_space);
        this.f14877O = (ViewGroup) this.f14872J.findViewById(R.id.alert_layout);
        this.f14878P = (CheckBox) this.f14877O.findViewById(R.id.checkbox);
        this.f14878P.setChecked(C2198l.m9956i(getContentResolver(), this.f14883U));
        this.f14878P.setOnCheckedChangeListener(new C4160co(this));
        this.f14879Q = (TextView) this.f14872J.findViewById(R.id.ChatInfoBuddyTitle);
        this.f14880R = this.f14872J.findViewById(R.id.layoutCenterButton);
        this.f14881S = (Button) this.f14872J.findViewById(R.id.invite_button);
        this.f14882T = (Button) this.f14872J.findViewById(R.id.create_group_button);
        this.f14887Y.addHeaderView(this.f14872J, null, false);
        this.f14888Z = new C4164cs(this.f14885W, null);
        this.f14887Y.setAdapter((ListAdapter) this.f14888Z);
        this.f14887Y.setOnItemClickListener(new C4161cp(this));
        m15851k();
        m15852l();
    }

    /* renamed from: k */
    private void m15851k() {
        if (C4822an.m18218a()) {
            setTitle(R.string.chat_view_menu_info2);
        } else {
            setTitle(R.string.menu_message_room_info);
        }
        if (getIntent().hasExtra(f14857o)) {
            this.f14874L.setText(getIntent().getStringExtra(ChatFragment.f5469e));
        }
        this.f14875M.setVisibility(8);
        if (this.f14889aa == EnumC2300t.BROADCAST2) {
            this.f14876N.setVisibility(8);
        } else {
            this.f14876N.setVisibility(0);
        }
        if (this.f14884V != null) {
            this.f14879Q.setText(getString(R.string.chat_info_buddy_title, new Object[]{Integer.valueOf(this.f14884V.length)}));
        } else {
            this.f14879Q.setText(getString(R.string.chat_info_buddy_title, new Object[]{0}));
        }
        this.f14879Q.setVisibility(0);
        this.f14880R.setVisibility(8);
        this.f14881S.setVisibility(8);
        this.f14882T.setVisibility(8);
    }

    /* renamed from: h */
    public void m15854h() {
        this.f14873K.setClickable(false);
        if (this.f14889aa == EnumC2300t.ONETOONE) {
            if (TextUtils.isEmpty(this.f14890ab)) {
                this.f14873K.setBackgroundResource(R.drawable.frame_background);
                C4855bt.m18351a(this.f14885W).m18366b(this.f14873K, EnumC4857bv.BUDDY);
                return;
            }
            if (this.f14891ac == 0) {
                this.f14873K.setBackgroundResource(R.drawable.circle_background);
                C2496n.m10765a(this.f14873K, this.f14890ab, EnumC2498p.ROUND);
                return;
            } else if (this.f14891ac == 1) {
                this.f14873K.setBackgroundResource(R.drawable.frame_background);
                C2496n.m10784c(this.f14873K, this.f14890ab, EnumC2498p.SQUARE);
                return;
            } else {
                C2496n.m10762a(this.f14873K);
                this.f14873K.setBackgroundResource(R.drawable.frame_background);
                this.f14873K.setImageDrawable(C2496n.m10754a(EnumC2498p.SQUARE));
                return;
            }
        }
        C2496n.m10762a(this.f14873K);
        this.f14873K.setImageDrawable(C2496n.m10753a(EnumC2300t.BROADCAST2, EnumC2498p.SQUARE));
        this.f14873K.setBackgroundResource(R.drawable.frame_background);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m15852l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m15852l() {
        C4904y.m18639b("initListView()", "MessagingInfoActivity");
        this.f14886X.startQuery(f14854H, null, C2220ah.m10089b(), null, "participants_inbox_no=?", new String[]{this.f14883U}, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15842a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity
    /* renamed from: f */
    protected Fragment mo2967f() {
        return null;
    }

    /* renamed from: b */
    public void m15853b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("phone", str);
        bundle.putString("name", null);
        C3890m.m14996b("MessagingInfoActivity", "phoneNum: " + str);
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtras(bundle);
        intent.putExtra("return-data", true);
        try {
            startActivityForResult(intent, f14855I);
        } catch (ActivityNotFoundException e) {
            C4904y.m18635a(e, "MessagingInfoActivity");
            C5179v.m19810a(GlobalApplication.m18732r(), R.string.toast_contact_not_found, 0).show();
        }
    }

    @Override // com.sec.chaton.base.BaseSinglePaneActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == f14855I) {
            if (!TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
                if (-3 == iM10677a || -2 == iM10677a) {
                    C5179v.m19810a(this, R.string.trunk_network_not_available, 0).show();
                    return;
                } else {
                    C4809aa.m18104a().m18125b("buddy_request_sync_in_chaton", (Boolean) true);
                    C1002i.m6059a(true);
                }
            } else {
                if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
                    C4809aa.m18104a().m18128b("Setting Sync TimeInMillis", String.valueOf(System.currentTimeMillis()));
                }
                new C2128i(null).m9497a("localsms");
            }
            new Timer().schedule(new C4163cr(this), 2000L);
        }
    }
}
