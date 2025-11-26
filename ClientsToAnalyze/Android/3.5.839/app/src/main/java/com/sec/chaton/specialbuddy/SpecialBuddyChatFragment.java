package com.sec.chaton.specialbuddy;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.C0014a;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1071bk;
import com.sec.chaton.EnumC1094bm;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.InterfaceC1762hh;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.msgbox.C2608a;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p057e.p059b.C2244e;
import com.sec.chaton.p065io.entry.specialbuddy.SpecialBuddyFollowEntry;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import com.sec.common.util.log.collector.C5043h;
import com.sec.widget.C5179v;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyChatFragment extends AbstractChatONLiveFragment implements AdapterView.OnItemClickListener, InterfaceC1762hh {

    /* renamed from: A */
    private boolean f16300A;

    /* renamed from: B */
    private String f16301B;

    /* renamed from: C */
    private String f16302C;

    /* renamed from: D */
    private String f16303D;

    /* renamed from: E */
    private boolean f16304E;

    /* renamed from: F */
    private EnumC1109f f16305F;

    /* renamed from: G */
    private boolean f16306G;

    /* renamed from: H */
    private final int f16307H;

    /* renamed from: I */
    private final int f16308I;

    /* renamed from: J */
    private final int f16309J;

    /* renamed from: K */
    private final int f16310K;

    /* renamed from: L */
    private final int f16311L;

    /* renamed from: M */
    private final int f16312M;

    /* renamed from: N */
    private final String f16313N;

    /* renamed from: O */
    private final String f16314O;

    /* renamed from: P */
    private final String f16315P;

    /* renamed from: Q */
    private final String f16316Q;

    /* renamed from: R */
    private final String f16317R;

    /* renamed from: S */
    private final String f16318S;

    /* renamed from: T */
    private final String f16319T;

    /* renamed from: U */
    private final String f16320U;

    /* renamed from: V */
    private final int f16321V;

    /* renamed from: W */
    private final int f16322W;

    /* renamed from: X */
    private final int f16323X;

    /* renamed from: Y */
    private final int f16324Y;

    /* renamed from: Z */
    private ListView f16325Z;

    /* renamed from: a */
    String f16326a;

    /* renamed from: aA */
    private SpecialBuddyFollowEntry f16327aA;

    /* renamed from: aB */
    private boolean f16328aB;

    /* renamed from: aC */
    private boolean f16329aC;

    /* renamed from: aD */
    private boolean f16330aD;

    /* renamed from: aE */
    private Handler f16331aE;

    /* renamed from: aF */
    private Handler f16332aF;

    /* renamed from: aG */
    private Handler f16333aG;

    /* renamed from: aH */
    private Handler f16334aH;

    /* renamed from: aa */
    private boolean f16335aa;

    /* renamed from: ab */
    private boolean f16336ab;

    /* renamed from: ac */
    private boolean f16337ac;

    /* renamed from: ad */
    private int f16338ad;

    /* renamed from: ae */
    private DrawerLayout f16339ae;

    /* renamed from: af */
    private C0014a f16340af;

    /* renamed from: ag */
    private LinearLayout f16341ag;

    /* renamed from: ah */
    private LinearLayout f16342ah;

    /* renamed from: ai */
    private ImageView f16343ai;

    /* renamed from: aj */
    private TextView f16344aj;

    /* renamed from: ak */
    private TextView f16345ak;

    /* renamed from: al */
    private Activity f16346al;

    /* renamed from: am */
    private C5007c f16347am;

    /* renamed from: an */
    private int f16348an;

    /* renamed from: ao */
    private String f16349ao;

    /* renamed from: ap */
    private String f16350ap;

    /* renamed from: aq */
    private String f16351aq;

    /* renamed from: ar */
    private boolean f16352ar;

    /* renamed from: as */
    private boolean f16353as;

    /* renamed from: at */
    private EnumC1094bm f16354at;

    /* renamed from: au */
    private WindowManager f16355au;

    /* renamed from: av */
    private LinearLayout f16356av;

    /* renamed from: aw */
    private ImageView f16357aw;

    /* renamed from: ax */
    private C2128i f16358ax;

    /* renamed from: ay */
    private int f16359ay;

    /* renamed from: az */
    private C4536af f16360az;

    /* renamed from: b */
    String f16361b;

    /* renamed from: f */
    C2608a f16362f;

    /* renamed from: g */
    final Object f16363g;

    /* renamed from: h */
    Handler f16364h;

    /* renamed from: i */
    InterfaceC2211y f16365i;

    /* renamed from: j */
    ContentObserver f16366j;

    /* renamed from: k */
    ContentObserver f16367k;

    /* renamed from: m */
    private ViewGroup f16368m;

    /* renamed from: n */
    private ImageView f16369n;

    /* renamed from: o */
    private TextView f16370o;

    /* renamed from: p */
    private TextView f16371p;

    /* renamed from: q */
    private C2210x f16372q;

    /* renamed from: r */
    private C2142w f16373r;

    /* renamed from: s */
    private boolean f16374s;

    /* renamed from: t */
    private String f16375t;

    /* renamed from: u */
    private String f16376u;

    /* renamed from: v */
    private int f16377v;

    /* renamed from: w */
    private String f16378w;

    /* renamed from: x */
    private EnumC2300t f16379x;

    /* renamed from: y */
    private Long f16380y;

    /* renamed from: z */
    private long f16381z;

    /* renamed from: l */
    private static final String f16299l = SpecialBuddyChatFragment.class.getSimpleName();

    /* renamed from: aI */
    private static Handler f16298aI = new HandlerC4556u();

    /* renamed from: a */
    SpecialBuddyFollowEntry m17211a() {
        SpecialBuddyFollowEntry specialBuddyFollowEntryCopy;
        synchronized (this.f16363g) {
            specialBuddyFollowEntryCopy = SpecialBuddyFollowEntry.copy(this.f16327aA);
        }
        return specialBuddyFollowEntryCopy;
    }

    /* renamed from: a */
    void m17214a(SpecialBuddyFollowEntry specialBuddyFollowEntry) {
        synchronized (this.f16363g) {
            this.f16327aA = SpecialBuddyFollowEntry.copy(specialBuddyFollowEntry);
        }
    }

    public SpecialBuddyChatFragment() {
        super(f16299l, EnumC2599m.LIVE_CONTENTS);
        this.f16374s = false;
        this.f16375t = null;
        this.f16376u = null;
        this.f16377v = -1;
        this.f16378w = null;
        this.f16300A = true;
        this.f16304E = true;
        this.f16305F = EnumC1109f.NONE;
        this.f16306G = false;
        this.f16307H = 1;
        this.f16308I = 2;
        this.f16309J = 3;
        this.f16310K = 4;
        this.f16311L = 2;
        this.f16312M = 3;
        this.f16313N = "sessionid";
        this.f16314O = "buddyid";
        this.f16315P = "sid";
        this.f16316Q = "channelname";
        this.f16317R = "contenttitle";
        this.f16318S = "ctid";
        this.f16319T = "id";
        this.f16320U = "status";
        this.f16321V = 1;
        this.f16322W = 2;
        this.f16323X = 3;
        this.f16324Y = 4;
        this.f16335aa = false;
        this.f16336ab = false;
        this.f16337ac = false;
        this.f16338ad = 100;
        this.f16353as = false;
        this.f16354at = EnumC1094bm.INSIDE;
        this.f16363g = new Object();
        this.f16328aB = false;
        this.f16329aC = false;
        this.f16330aD = false;
        this.f16331aE = new HandlerC4550o(this);
        this.f16332aF = new HandlerC4558w(this);
        this.f16333aG = new HandlerC4559x(this);
        this.f16364h = new HandlerC4533ac(this);
        this.f16365i = new C4552q(this);
        this.f16334aH = new HandlerC4553r(this);
        this.f16366j = new C4554s(this, new Handler());
        this.f16367k = new C4555t(this, new Handler());
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected Handler getWebapiHandler() {
        return this.f16331aE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m17168b(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17161a(String str, int i) {
        if (i == 1) {
            C5179v.m19811a(getActivity(), str, 1).show();
        } else {
            C5179v.m19811a(getActivity(), str, 0).show();
        }
    }

    /* renamed from: a */
    void m17215a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", str2);
            String strM11011a = C2602p.m11011a(str.toString(), jSONObject.toString());
            if (this.f16332aF != null) {
                Message messageObtainMessage = this.f16332aF.obtainMessage();
                messageObtainMessage.obj = strM11011a;
                messageObtainMessage.what = 1;
                messageObtainMessage.sendToTarget();
            }
        } catch (JSONException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f16299l);
            }
        }
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Activity attachedActivity = getAttachedActivity();
        View viewInflate = LayoutInflater.from(attachedActivity).inflate(R.layout.actionbar_custom_layout_specialbuddychat, (ViewGroup) null, false);
        ((ActionBarFragmentActivity) attachedActivity).m18784t().mo18820a(viewInflate);
        this.f16371p = (TextView) viewInflate.findViewById(R.id.chatroom_custom_title);
        this.f16368m = (ViewGroup) viewInflate.findViewById(R.id.subtitle_group);
        this.f16370o = (TextView) viewInflate.findViewById(R.id.chatroom_custom_sub_title);
        this.f16369n = (ImageView) viewInflate.findViewById(R.id.title_alert_off_indicator);
        ((ActionBarFragmentActivity) attachedActivity).m18784t().mo18836e(23);
        this.f16326a = getString(R.string.chaton_live_buddy_alert_on);
        this.f16361b = getString(R.string.chaton_live_buddy_alert_off);
        this.f16303D = getArguments().getString("key_intent_ctid");
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f16347am = new C5007c();
            this.f16355au = (WindowManager) GlobalApplication.m18732r().getSystemService("window");
            this.f16339ae = (DrawerLayout) viewOnCreateView.findViewById(R.id.mDrawerLayout);
            this.f16341ag = (LinearLayout) viewOnCreateView.findViewById(R.id.listview_linearlayout);
            this.f16325Z = (ListView) this.f16339ae.findViewById(R.id.left_drawer);
            this.f16342ah = (LinearLayout) this.f16339ae.findViewById(R.id.empty_list_view);
            this.f16342ah.setBackgroundColor(getResources().getColor(R.color.white));
            this.f16343ai = (ImageView) this.f16342ah.findViewById(R.id.image1);
            this.f16343ai.setImageResource(R.drawable.no_contents_chat);
            this.f16344aj = (TextView) this.f16342ah.findViewById(R.id.text1);
            this.f16344aj.setText(getResources().getString(R.string.no_chats));
            this.f16345ak = (TextView) this.f16342ah.findViewById(R.id.text2);
            this.f16345ak.setText(getResources().getString(R.string.chatlist_no_chat_2));
            this.f16325Z.setEmptyView(this.f16342ah);
            m17155a(layoutInflater.inflate(R.layout.draw_menu_info_layout, (ViewGroup) null, false));
            this.f16325Z.setOnItemClickListener(this);
            this.f16340af = new C4560y(this, this.f16346al, this.f16339ae, R.drawable.actionbar_ic_send, R.string.draw_menu_msg, R.string.ams_never_show_again);
            this.f16339ae.setDrawerListener(this.f16340af);
        } else {
            this.f16339ae = (DrawerLayout) viewOnCreateView.findViewById(R.id.mDrawerLayout);
            this.f16339ae.setDrawerLockMode(1);
        }
        return viewOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17189k() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f16372q.startUpdate(4, null, C2299s.m10186a(this.f16376u, EnumC4549n.LIVECONTENTS), contentValues, null, null);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f16372q = new C2210x(CommonApplication.m18732r().getContentResolver(), this.f16365i);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("inboxNO")) {
                this.f16376u = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("receivers")) {
                String[] stringArray = arguments.getStringArray("receivers");
                if (stringArray.length >= 1) {
                    this.f16375t = stringArray[0];
                }
            } else if (C4904y.f17872b) {
                C4904y.m18639b("does not contain mBuddyNo.", f16299l);
            }
            if (arguments.containsKey("chatType")) {
                this.f16379x = EnumC2300t.m10207a(arguments.getInt("chatType"));
            }
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("onActivityCreated(), mInboxNo(%s), mChatType(%s), mBuddyNo(%s)", this.f16376u, this.f16379x, this.f16375t), f16299l);
            }
            if (TextUtils.isEmpty(this.f16378w) && arguments.containsKey("key_buddy_name")) {
                this.f16378w = arguments.getString("key_buddy_name");
                C4904y.m18639b("hslee_title, BuddyName intent : " + this.f16378w, f16299l);
            }
            if (TextUtils.isEmpty(this.f16378w)) {
                Context contextM18732r = CommonApplication.m18732r();
                if (!TextUtils.isEmpty(this.f16375t) && contextM18732r != null) {
                    this.f16378w = C2186al.m9762a(contextM18732r, this.f16375t);
                }
                C4904y.m18639b("hslee_title, BuddyName from following DB : " + this.f16378w, f16299l);
            }
            this.f16302C = this.f16378w;
            if (this.f16378w != null) {
                C4904y.m18639b("hslee_title, setTitle() #1 : " + this.f16302C, f16299l);
                setTitle(this.f16302C);
            }
            if (arguments.containsKey("content_type")) {
                this.f16348an = arguments.getInt("content_type");
                arguments.remove("content_type");
                this.f16353as = true;
            }
            if (arguments.containsKey("download_uri")) {
                this.f16349ao = arguments.getString("download_uri");
            }
            if (arguments.containsKey("sub_content")) {
                this.f16350ap = arguments.getString("sub_content");
            }
            if (arguments.containsKey("forward_sender_name")) {
                this.f16351aq = arguments.getString("forward_sender_name");
            }
            if (arguments.containsKey("is_forward_mode")) {
                this.f16352ar = arguments.getBoolean("is_forward_mode");
            }
            if (arguments.containsKey(C1071bk.f3371e)) {
                this.f16354at = (EnumC1094bm) arguments.get(C1071bk.f3371e);
            }
            if (arguments.containsKey("liveUserType")) {
                this.f16305F = EnumC1109f.m7094a(arguments.getString("liveUserType"));
            }
            if (arguments.containsKey("fromLiveMain")) {
                this.f16306G = true;
            }
            if (C2349a.m10301a("chatroom_draw_menu_feature")) {
                this.f16362f = new C2608a(getActivity(), this.f16325Z, R.layout.list_item_common_6, null, this.f16347am, null);
                getActivity().getContentResolver().registerContentObserver(C2299s.f8209a, true, this.f16366j);
                this.f16325Z.setAdapter((ListAdapter) this.f16362f);
                this.f16336ab = true;
                this.f16325Z.setItemsCanFocus(false);
                this.f16325Z.setChoiceMode(0);
                this.f16362f.m11156a(0);
            }
            this.f16358ax = new C2128i(this.f16333aG);
            if (arguments != null && arguments.containsKey("inbox_unread_count") && arguments.getInt("inbox_unread_count") > 0) {
                C5043h.m19179a().m19185a("2000", "2125", false);
            }
        }
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f16360az = new C4536af(this, null);
        C0991aa.m6037a().m18959a(this.f16360az);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16374s = false;
        if (!C5034k.m19106k()) {
            m17124b();
            return;
        }
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            if (!C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
                m17191l();
            }
            this.f16325Z.setChoiceMode(0);
            this.f16362f.m11156a(0);
            this.f16325Z.setItemsCanFocus(false);
            this.f16346al.getContentResolver().registerContentObserver(C2299s.f8209a, true, this.f16367k);
            this.f16374s = false;
            C4904y.m18646e("[MSGBOX] onResume()", getClass().getSimpleName());
            if (!TextUtils.isEmpty(GlobalApplication.f8359e)) {
                GlobalApplication.f8359e = null;
                this.f16347am.m19014a();
                this.f16347am = new C5007c();
                this.f16362f.m11157a(this.f16347am);
            }
            m17201r();
        }
        PushReceiver.m12761a(this);
        m17194n();
    }

    /* renamed from: l */
    private void m17191l() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2003, 262184, -3);
        layoutParams.gravity = 51;
        C4809aa.m18105a("show_draw_menu_info", (Boolean) true);
        this.f16355au.addView(this.f16356av, layoutParams);
    }

    /* renamed from: a */
    private void m17155a(View view) {
        if (!C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
            this.f16356av = (LinearLayout) view;
            this.f16357aw = (ImageView) this.f16356av.findViewById(R.id.closeinfo);
            this.f16357aw.setOnClickListener(new ViewOnClickListenerC4561z(this));
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f16374s = true;
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            if (C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue() && !C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
                this.f16355au.removeView(this.f16356av);
                C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
            }
            this.f16346al.getContentResolver().unregisterContentObserver(this.f16367k);
        }
        if (this.f16373r != null) {
            this.f16373r.mo9243a(SystemClock.elapsedRealtime() + 300000);
        }
        C1813b.m8906b().m8939d(this.f16376u);
        PushReceiver.m12761a((InterfaceC1762hh) null);
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C0991aa.m6037a().m18960b(this.f16360az);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView()", f16299l);
        }
        this.f16331aE = null;
        this.f16332aF = null;
        this.f16333aG = null;
        this.f16334aH = null;
        if (this.f16373r != null) {
            this.f16373r.m9267b(this.f16364h);
        }
        super.onDestroyView();
        BaseActivity.m6160a((Fragment) this, false);
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f16347am.m19014a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m17193m() {
        Activity attachedActivity = getAttachedActivity();
        if (attachedActivity != null && (attachedActivity instanceof ActionBarFragmentActivity)) {
            ((ActionBarFragmentActivity) attachedActivity).mo51u_();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem icon;
        boolean zM777j = C2349a.m10301a("chatroom_draw_menu_feature") ? this.f16339ae.m777j(this.f16341ag) : false;
        boolean z = this.f16305F != null && this.f16305F.m7097c();
        menu.removeItem(3);
        if (TextUtils.isEmpty(this.f16326a) || TextUtils.isEmpty(this.f16361b)) {
            this.f16326a = getString(R.string.chaton_live_buddy_alert_on);
            this.f16361b = getString(R.string.chaton_live_buddy_alert_off);
        }
        Boolean boolM17218g = m17218g();
        if (boolM17218g == null || boolM17218g.booleanValue()) {
            icon = menu.add(0, 3, 3, this.f16361b).setIcon(R.drawable.more_option_alert_off_white);
        } else {
            icon = menu.add(0, 3, 3, this.f16326a).setIcon(R.drawable.more_option_alert_white);
        }
        if (boolM17218g == null) {
            m17154a(icon, false);
        } else {
            m17154a(icon, this.f16329aC);
        }
        MenuItem menuItemFindItem = menu.findItem(1);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem2 = menu.findItem(2);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem3 = menu.findItem(3);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setVisible(!zM777j);
        }
        MenuItem menuItemFindItem4 = menu.findItem(4);
        if (menuItemFindItem4 != null) {
            menuItemFindItem4.setVisible(!zM777j);
        }
        if (this.f16306G) {
            menu.removeItem(3);
            menu.removeItem(4);
        }
        MenuItem menuItemFindItem5 = menu.findItem(R.id.contents_menu_livechat);
        if (menuItemFindItem5 != null) {
            if (z) {
                menuItemFindItem5.setVisible(!zM777j);
                if (this.f16359ay > 0) {
                    C4880cr.m18524a(menuItemFindItem5, true);
                } else {
                    C4880cr.m18524a(menuItemFindItem5, false);
                }
            } else {
                menuItemFindItem5.setVisible(false);
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    private void m17154a(MenuItem menuItem, boolean z) {
        menuItem.setEnabled(z);
        C4880cr.m18523a(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.add(0, 4, 4, getResources().getString(R.string.menu_chat_close)).setIcon(R.drawable.more_option_closechat_white);
        if (menu.findItem(R.id.contents_menu_livechat) != null) {
            C4880cr.m18526b(menu.findItem(R.id.contents_menu_livechat));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!isValidActivity()) {
            return true;
        }
        switch (menuItem.getItemId()) {
            case 3:
                if (TextUtils.isEmpty(this.f16326a) || TextUtils.isEmpty(this.f16361b)) {
                    return true;
                }
                String strValueOf = String.valueOf(menuItem.getTitle());
                if (this.f16326a.equals(strValueOf)) {
                    this.f16304E = true;
                } else if (this.f16361b.equals(strValueOf)) {
                    this.f16304E = false;
                }
                C2198l.m9913a(CommonApplication.m18732r().getContentResolver(), this.f16376u, this.f16304E);
                m17162a(this.f16304E);
                return true;
            case 4:
                m17197o();
                return true;
            case R.id.contents_menu_livechat /* 2131166642 */:
                ((InterfaceC4535ae) getActivity()).mo7823h();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* renamed from: n */
    private boolean m17194n() {
        C4904y.m18639b("spbd_refresh, askInboxNoAsync(), #1", f16299l);
        if (TextUtils.isEmpty(this.f16376u)) {
            if (TextUtils.isEmpty(this.f16375t)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("askInboxNoAsync(), mBuddyNo is empty !!", f16299l);
                }
                return false;
            }
            this.f16372q.startQuery(1, null, C2299s.m10201n(), null, "buddy_no=?", new String[]{this.f16375t, null, String.valueOf(EnumC2300t.ONETOONE.m10210a()), this.f16305F.m7095a()}, null);
            return true;
        }
        this.f16372q.startQuery(1, null, C2299s.m10184a(), null, "inbox_no=?", new String[]{this.f16376u}, null);
        return true;
    }

    /* renamed from: o */
    private boolean m17197o() {
        if (!isValidActivity()) {
            return true;
        }
        int iM10677a = C2471v.m10677a(getAttachedActivity());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(getAttachedActivity(), R.string.popup_no_network_connection, 0).show();
            return false;
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getAttachedActivity());
        abstractC4932aM18733a.mo18734a(R.string.menu_chat_close);
        abstractC4932aM18733a.mo18746b(R.string.close_chat_popup_all_data_deleted);
        abstractC4932aM18733a.mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4532ab(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4531aa(this));
        abstractC4932aM18733a.mo18752b();
        return true;
    }

    /* renamed from: e */
    public void m17216e() {
        if (isValidActivity()) {
            if (this.f16377v >= 0) {
            }
            if (!TextUtils.isEmpty(this.f16376u)) {
                this.f16372q.startDelete(2, null, C2299s.f8209a, "inbox_no IN ('" + this.f16376u + "')", null);
                this.f16372q.startDelete(3, null, C2306z.f8229a, "message_inbox_no='" + this.f16376u + "'", null);
            }
            this.f16373r.mo9274d();
            getAttachedActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public boolean m17200q() {
        if (this.f16374s) {
            return false;
        }
        this.f16373r = C2142w.m9593a(this.f16376u, this.f16379x);
        if (this.f16373r == null) {
            return false;
        }
        this.f16373r.m9246a(this.f16364h);
        this.f16373r.mo9244a(this.f16301B);
        if (this.f16373r.mo9272c()) {
        }
        return true;
    }

    /* renamed from: a */
    public AbstractC4932a m17212a(EnumC0789m enumC0789m) {
        if (!isValidActivity()) {
            return null;
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getAttachedActivity());
        if (enumC0789m == EnumC0789m.END_APP) {
            abstractC4932aM18733a.mo18746b(R.string.provision_error_end).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4534ad(this));
            return abstractC4932aM18733a;
        }
        if (enumC0789m != EnumC0789m.RESTART_APP) {
            return null;
        }
        abstractC4932aM18733a.mo18746b(R.string.auth_error_restart).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4551p(this));
        return abstractC4932aM18733a;
    }

    /* renamed from: f */
    void m17217f() {
    }

    /* renamed from: a */
    protected String m17213a(String str) {
        String str2;
        String strM11008b = getApiUsageType().m11008b();
        if (TextUtils.isEmpty(strM11008b)) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "specialuserid=" + str;
        String str4 = "myid=" + C4809aa.m18104a().m18121a("chaton_id", "");
        if (TextUtils.isEmpty(this.f16303D)) {
            str2 = str3 + "&" + str4;
        } else {
            str2 = str3 + "&" + str4 + "&" + this.f16303D;
        }
        if (strM11008b.contains("?")) {
            return strM11008b + "&" + str2;
        }
        return strM11008b + "?" + str2;
    }

    @Override // com.sec.chaton.chat.InterfaceC1762hh
    /* renamed from: a */
    public void mo8234a(String str, String str2, int i, String str3, String str4, EnumC2300t enumC2300t) {
        if (!str.equals(this.f16376u)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("inboxNo is not equal - arg inboxNo(" + str + "), SpecialBuddyChatFragment inboxNo(" + this.f16376u + ")", f16299l);
                return;
            }
            return;
        }
        if (this.f16373r != null) {
            if (EnumC2300t.m10209b(enumC2300t) || TextUtils.isEmpty(str4) || "null".equals(str4)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                C2142w c2142wM9593a = C2142w.m9593a(strValueOf, enumC2300t);
                if (c2142wM9593a != null) {
                    c2142wM9593a.m9246a(this.f16364h);
                    c2142wM9593a.mo9252a(strValueOf, str2, i);
                    c2142wM9593a.m9642a(true);
                    c2142wM9593a.m9648e(this.f16376u);
                    this.f16373r.mo9243a(Long.MAX_VALUE);
                    c2142wM9593a.mo9248a(EnumC2300t.BROADCAST, str3, this.f16380y, str4, this.f16376u, this.f16381z, true);
                    return;
                }
                return;
            }
            this.f16373r.mo9274d();
            this.f16373r.mo9252a(this.f16376u, str2, i);
            this.f16373r.mo9248a(enumC2300t, str3, this.f16380y, str4, this.f16376u, this.f16381z, true);
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1762hh
    /* renamed from: p */
    public boolean mo8271p() {
        return false;
    }

    @Override // com.sec.chaton.chat.InterfaceC1762hh
    /* renamed from: a */
    public void mo8219a(int i, String str, String str2, EnumC2214ab enumC2214ab) {
    }

    /* renamed from: g */
    protected Boolean m17218g() {
        Cursor cursorQuery;
        if (!isValidActivity() || TextUtils.isEmpty(this.f16376u) || (cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2299s.f8209a, new String[]{"inbox_enable_noti"}, "inbox_no=?", new String[]{this.f16376u}, null)) == null) {
            return null;
        }
        if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return null;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti"));
        cursorQuery.close();
        return Boolean.valueOf(!"N".equals(string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Intent m17149a(Context context, EnumC2214ab enumC2214ab, String str, String str2, int i) {
        Intent intent = new Intent(context, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC2214ab.m10076a());
        intent.putExtra("inboxNO", this.f16376u);
        if (i > 0) {
            intent.putExtra("ACTIVITY_PURPOSE_ARG2", i);
        }
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        if (this.f16379x != null) {
            intent.putExtra("chatType", this.f16379x.m10210a());
        }
        intent.putExtra("is_forward_mode", true);
        intent.setFlags(603979776);
        return intent;
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void setTitle(String str) {
        if (!getArguments().getBoolean("NO_TITLE_TO_ACTIONBAR") && this.f16371p != null) {
            this.f16371p.setText(str);
            super.setTitle(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17162a(boolean z) {
        if (this.f16370o != null && this.f16369n != null) {
            int visibility = this.f16370o.getVisibility();
            int i = z ? 8 : 0;
            this.f16369n.setVisibility(i);
            if (visibility == 8 && i == 8) {
                this.f16368m.setVisibility(8);
            } else {
                this.f16368m.setVisibility(0);
            }
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f16346al = activity;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f16346al = null;
    }

    /* renamed from: h */
    public void m17219h() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_is_new", "N");
        this.f16372q.startUpdate(1, null, C2299s.f8209a, contentValues, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0399  */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onItemClick(android.widget.AdapterView<?> r12, android.view.View r13, int r14, long r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 936
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.specialbuddy.SpecialBuddyChatFragment.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
    }

    /* renamed from: r */
    private void m17201r() {
        if (this.f16336ab) {
            this.f16336ab = false;
            C4904y.m18646e("[MSGBOX] updateMsgbox()", getClass().getSimpleName());
            this.f16372q.startQuery(99, null, C2299s.m10188b(), null, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17153a(Cursor cursor) {
        Message messageM10105c = C2244e.m10103a().m10105c();
        messageM10105c.obj = cursor;
        C2244e.m10103a().m10104b().sendMessage(messageM10105c);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() {
        if (this.f16328aB) {
            new C2128i(null).m9515c();
        }
        return super.onBackKeyPressed();
    }
}
