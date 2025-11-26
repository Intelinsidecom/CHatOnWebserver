package com.sec.chaton.specialbuddy;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.SpecialBuddyActivity;
import com.sec.chaton.chat.InterfaceC1091ff;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.EnumC1689p;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.receiver.PushReceiver;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.C3347i;
import com.sec.widget.C3641ai;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SpecialBuddyChatFragment extends AbstractChatONLiveFragment implements InterfaceC1091ff {

    /* renamed from: m */
    private static final String f10409m = SpecialBuddyChatFragment.class.getSimpleName();

    /* renamed from: A */
    private long f10410A;

    /* renamed from: B */
    private boolean f10411B;

    /* renamed from: C */
    private String f10412C;

    /* renamed from: D */
    private String f10413D;

    /* renamed from: E */
    private String f10414E;

    /* renamed from: F */
    private String f10415F;

    /* renamed from: G */
    private boolean f10416G;

    /* renamed from: H */
    private final int f10417H;

    /* renamed from: I */
    private final int f10418I;

    /* renamed from: J */
    private final int f10419J;

    /* renamed from: K */
    private final int f10420K;

    /* renamed from: L */
    private final int f10421L;

    /* renamed from: M */
    private final int f10422M;

    /* renamed from: N */
    private final int f10423N;

    /* renamed from: O */
    private final int f10424O;

    /* renamed from: P */
    private final int f10425P;

    /* renamed from: Q */
    private final int f10426Q;

    /* renamed from: R */
    private final int f10427R;

    /* renamed from: S */
    private boolean f10428S;

    /* renamed from: T */
    private boolean f10429T;

    /* renamed from: U */
    private Handler f10430U;

    /* renamed from: V */
    private Handler f10431V;

    /* renamed from: W */
    private Handler f10432W;

    /* renamed from: i */
    String f10433i;

    /* renamed from: j */
    String f10434j;

    /* renamed from: k */
    Handler f10435k;

    /* renamed from: l */
    InterfaceC1378v f10436l;

    /* renamed from: n */
    private ViewGroup f10437n;

    /* renamed from: o */
    private ImageView f10438o;

    /* renamed from: p */
    private TextView f10439p;

    /* renamed from: q */
    private TextView f10440q;

    /* renamed from: r */
    private C1377u f10441r;

    /* renamed from: s */
    private C1337o f10442s;

    /* renamed from: t */
    private boolean f10443t;

    /* renamed from: u */
    private String f10444u;

    /* renamed from: v */
    private String f10445v;

    /* renamed from: w */
    private int f10446w;

    /* renamed from: x */
    private String f10447x;

    /* renamed from: y */
    private EnumC1450r f10448y;

    /* renamed from: z */
    private Long f10449z;

    public SpecialBuddyChatFragment() {
        super(f10409m, EnumC1689p.LIVE_CONTENTS);
        this.f10443t = false;
        this.f10444u = null;
        this.f10445v = null;
        this.f10446w = -1;
        this.f10447x = null;
        this.f10411B = true;
        this.f10416G = true;
        this.f10417H = 1;
        this.f10418I = 2;
        this.f10419J = 3;
        this.f10420K = 4;
        this.f10421L = 5;
        this.f10422M = 2;
        this.f10423N = 3;
        this.f10424O = 1;
        this.f10425P = 2;
        this.f10426Q = 3;
        this.f10427R = 4;
        this.f10428S = false;
        this.f10429T = false;
        this.f10430U = new HandlerC2936q(this);
        this.f10431V = new HandlerC2938s(this);
        this.f10435k = new HandlerC2941v(this);
        this.f10436l = new C2944y(this);
        this.f10432W = new HandlerC2945z(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: b */
    protected Handler mo6954b() {
        return this.f10430U;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Activity activityF = m6961f();
        View viewInflate = LayoutInflater.from(activityF).inflate(R.layout.actionbar_custom_layout_specialbuddychat, (ViewGroup) null, false);
        ((ActionBarFragmentActivity) activityF).m11543k().mo11580a(viewInflate);
        this.f10440q = (TextView) viewInflate.findViewById(R.id.chatroom_custom_title);
        this.f10437n = (ViewGroup) viewInflate.findViewById(R.id.subtitle_group);
        this.f10439p = (TextView) viewInflate.findViewById(R.id.chatroom_custom_sub_title);
        this.f10438o = (ImageView) viewInflate.findViewById(R.id.title_alert_off_indicator);
        ((ActionBarFragmentActivity) activityF).m11543k().mo11596e(23);
        this.f10433i = getString(R.string.chaton_live_buddy_alert_on);
        this.f10434j = getString(R.string.chaton_live_buddy_alert_off);
        Bundle arguments = getArguments();
        this.f10415F = arguments.getString("key_intent_ctid");
        this.f10414E = arguments.getString("key_web_url");
        C3250y.m11450b("onCreateView(), mCtid: " + this.f10415F + " / mForwardedWebURL: " + this.f10414E, f10409m);
        return viewOnCreateView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m10133q() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        this.f10441r.startUpdate(4, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f10445v + "'", null);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        this.f10441r = new C1377u(contentResolver, this.f10436l);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.size() > 0) {
            if (arguments.containsKey("inboxNO")) {
                this.f10445v = arguments.getString("inboxNO");
            }
            if (arguments.containsKey("receivers")) {
                String[] stringArray = arguments.getStringArray("receivers");
                if (stringArray.length >= 1) {
                    this.f10444u = stringArray[0];
                }
            }
            if (arguments.containsKey("chatType")) {
                this.f10448y = EnumC1450r.m6339a(arguments.getInt("chatType"));
            }
            if (C3250y.f11734b) {
                C3250y.m11450b(String.format("onActivityCreated(), mInboxNo(%s), mChatType(%s), mBuddyNo(%s)", this.f10445v, this.f10448y, this.f10444u), f10409m);
            }
            if (TextUtils.isEmpty(this.f10447x) && arguments.containsKey("key_buddy_name")) {
                this.f10447x = arguments.getString("key_buddy_name");
                C3250y.m11450b("hslee_title, BuddyName intent : " + this.f10447x, f10409m);
            }
            if (TextUtils.isEmpty(this.f10447x)) {
                this.f10447x = C1357af.m5987a(CommonApplication.m11493l(), this.f10444u);
                C3250y.m11450b("hslee_title, BuddyName from following DB : " + this.f10447x, f10409m);
            }
            if (TextUtils.isEmpty(this.f10447x)) {
                this.f10447x = C1357af.m5986a(contentResolver, this.f10444u);
                C3250y.m11450b("hslee_title, BuddyName from recommendee DB : " + this.f10447x, f10409m);
            }
            this.f10413D = this.f10447x;
            if (this.f10447x != null) {
                C3250y.m11450b("hslee_title, setTitle() #1 : " + this.f10413D, f10409m);
                mo10070d(this.f10413D);
            }
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10443t = false;
        if (!C3347i.m11788k()) {
            m10071l();
        } else {
            PushReceiver.m8377a(this);
            m10139t();
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f10443t = true;
        if (this.f10442s != null) {
            this.f10442s.m5893c(SystemClock.elapsedRealtime() + 480000);
        }
        C1103a.m5432a(GlobalApplication.m11493l()).m5464c(this.f10445v);
        PushReceiver.m8377a((InterfaceC1091ff) null);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onDestroyView()", f10409m);
        }
        this.f10430U = null;
        if (this.f10442s != null) {
            this.f10442s.m5888b(this.f10435k);
        }
        super.onDestroyView();
        BaseActivity.m3081a(this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m10136r() {
        Activity activityF = m6961f();
        if (activityF != null && (activityF instanceof ActionBarFragmentActivity)) {
            ((ActionBarFragmentActivity) activityF).supportInvalidateOptionsMenu();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem icon;
        menu.removeItem(3);
        if (TextUtils.isEmpty(this.f10433i) || TextUtils.isEmpty(this.f10434j)) {
            this.f10433i = getString(R.string.chaton_live_buddy_alert_on);
            this.f10434j = getString(R.string.chaton_live_buddy_alert_off);
        }
        Boolean boolM10150o = m10150o();
        if (boolM10150o == null || boolM10150o.booleanValue()) {
            icon = menu.add(0, 3, 3, this.f10434j).setIcon(R.drawable.more_option_alert_off_white);
        } else {
            icon = menu.add(0, 3, 3, this.f10433i).setIcon(R.drawable.more_option_alert_white);
        }
        if (boolM10150o == null) {
            m10099a(icon, false);
        } else {
            m10099a(icon, this.f10428S);
        }
        super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    private void m10099a(MenuItem menuItem, boolean z) {
        menuItem.setEnabled(z);
        C3228cp.m11343a(menuItem);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.add(0, 1, 1, getResources().getString(R.string.buddy_list_contextual_menu_viewprofile)).setIcon(R.drawable.more_option_profile_white);
        MenuItem icon = menu.add(0, 2, 2, getResources().getString(R.string.live_partner_option_recommend)).setIcon(R.drawable.more_option_suggestion_white);
        menu.add(0, 4, 4, getResources().getString(R.string.menu_chat_close)).setIcon(R.drawable.more_option_closechat_white);
        if (this.f10428S && this.f10429T) {
            m10099a(icon, true);
        } else {
            m10099a(icon, false);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) throws JSONException {
        if (!m6966k()) {
            return true;
        }
        switch (menuItem.getItemId()) {
            case 1:
                Intent intent = new Intent(m6961f(), (Class<?>) SpecialBuddyActivity.class);
                intent.putExtra("specialuserid", this.f10444u);
                intent.putExtra("speicalusername", this.f10447x);
                try {
                    m6961f().startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    return true;
                }
            case 2:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f10444u);
                    jSONObject.put("name", this.f10447x);
                    startActivity(m10096a(m6961f(), EnumC1455w.LIVERECOMMEND, jSONObject.toString(), (String) null));
                    return true;
                } catch (JSONException e2) {
                    C3250y.m11443a(e2, f10409m);
                    return true;
                }
            case 3:
                if (TextUtils.isEmpty(this.f10433i) || TextUtils.isEmpty(this.f10434j)) {
                    return true;
                }
                String strValueOf = String.valueOf(menuItem.getTitle());
                if (this.f10433i.equals(strValueOf)) {
                    this.f10416G = true;
                } else if (this.f10434j.equals(strValueOf)) {
                    this.f10416G = false;
                }
                C1370n.m6109a(CommonApplication.m11493l().getContentResolver(), this.f10445v, this.f10416G);
                m10102a(this.f10416G);
                return true;
            case 4:
                m10140u();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    /* renamed from: t */
    private void m10139t() {
        C3250y.m11450b("spbd_refresh, askInboxNoAsync(), #1", f10409m);
        if (TextUtils.isEmpty(this.f10445v)) {
            this.f10441r.startQuery(1, null, C1449q.m6337g(), null, "buddy_no=?", new String[]{this.f10444u, null, String.valueOf(EnumC1450r.ONETOONE.m6342a())}, null);
        } else {
            this.f10441r.startQuery(1, null, C1449q.m6328a(), null, "inbox_no=?", new String[]{this.f10445v}, null);
        }
    }

    /* renamed from: u */
    private boolean m10140u() {
        if (!m6966k()) {
            return true;
        }
        int iM6733a = C1594v.m6733a(m6961f());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(m6961f(), R.string.popup_no_network_connection, 0).show();
            return false;
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(m6961f());
        abstractC3271aM11494a.mo11495a(R.string.menu_chat_close);
        abstractC3271aM11494a.mo11506b(R.string.close_chat_popup_all_data_deleted);
        abstractC3271aM11494a.mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2940u(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2939t(this));
        abstractC3271aM11494a.mo11512b();
        return true;
    }

    /* renamed from: n */
    public void m10149n() {
        if (m6966k()) {
            if (this.f10446w >= 0) {
            }
            if (!TextUtils.isEmpty(this.f10445v)) {
                this.f10441r.startDelete(2, null, C1449q.f5381a, "inbox_no IN ('" + this.f10445v + "')", null);
                this.f10441r.startDelete(3, null, C1454v.f5393a, "message_inbox_no='" + this.f10445v + "'", null);
            }
            this.f10442s.m5901j();
            m6961f().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public boolean m10142v() {
        if (this.f10443t) {
            return false;
        }
        C1103a.m5432a(GlobalApplication.m11493l()).m5462b(this.f10445v);
        this.f10442s = C1337o.m5795a(this.f10445v, this.f10448y);
        if (this.f10442s == null) {
            return false;
        }
        this.f10442s.m5874a(this.f10435k);
        this.f10442s.m5894c(this.f10412C);
        if (this.f10442s.m5907p()) {
        }
        return true;
    }

    /* renamed from: a */
    public AbstractC3271a m10147a(EnumC0273j enumC0273j) {
        if (!m6966k()) {
            return null;
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(m6961f());
        if (enumC0273j == EnumC0273j.END_APP) {
            abstractC3271aM11494a.mo11506b(R.string.provision_error_end).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2942w(this));
            return abstractC3271aM11494a;
        }
        if (enumC0273j != EnumC0273j.RESTART_APP) {
            return null;
        }
        abstractC3271aM11494a.mo11506b(R.string.auth_error_restart).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2943x(this));
        return abstractC3271aM11494a;
    }

    /* renamed from: a */
    protected String m10148a(String str, String str2) {
        String str3;
        String str4;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.startsWith("{LIVE_MOBILEWEB}")) {
            str = str.replace("{LIVE_MOBILEWEB}", m6963h().m6982a());
        }
        String str5 = "specialuserid=" + str2;
        String str6 = "myid=" + C3159aa.m10962a().m10979a("chaton_id", "");
        if (TextUtils.isEmpty(this.f10415F)) {
            str3 = str5 + "&" + str6;
        } else {
            str3 = str5 + "&" + str6 + "&" + this.f10415F;
        }
        if (str.contains("?")) {
            str4 = str + "&" + str3;
        } else {
            str4 = str + "?" + str3;
        }
        C3250y.m11450b(String.format("startWebContents(), requestUrl: %s", str4), f10409m);
        return str4;
    }

    @Override // com.sec.chaton.chat.InterfaceC1091ff
    /* renamed from: a */
    public void mo4978a(String str, int i, String str2, String str3, EnumC1450r enumC1450r) {
        if (this.f10442s != null) {
            if (EnumC1450r.m6341b(enumC1450r) || TextUtils.isEmpty(str3) || "null".equals(str3)) {
                String strValueOf = String.valueOf(System.currentTimeMillis());
                C1337o c1337oM5795a = C1337o.m5795a(strValueOf, enumC1450r);
                if (c1337oM5795a != null) {
                    c1337oM5795a.m5874a(this.f10435k);
                    c1337oM5795a.m5880a(strValueOf, str, i);
                    c1337oM5795a.m5873a(true);
                    c1337oM5795a.m5897e(this.f10445v);
                    this.f10442s.m5893c(Long.MAX_VALUE);
                    c1337oM5795a.m5876a(EnumC1450r.BROADCAST, str2, this.f10449z, str3, this.f10445v, this.f10410A, true);
                }
            } else {
                this.f10442s.m5901j();
                this.f10442s.m5880a(this.f10445v, str, i);
                this.f10442s.m5876a(enumC1450r, str2, this.f10449z, str3, this.f10445v, this.f10410A, true);
            }
            mo6965j();
        }
    }

    @Override // com.sec.chaton.chat.InterfaceC1091ff
    /* renamed from: s */
    public boolean mo5018s() {
        return false;
    }

    @Override // com.sec.chaton.chat.InterfaceC1091ff
    /* renamed from: a */
    public void mo4963a(int i, String str, String str2, EnumC1455w enumC1455w) {
    }

    /* renamed from: o */
    protected Boolean m10150o() {
        Cursor cursorQuery;
        if (!m6966k() || TextUtils.isEmpty(this.f10445v) || (cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1449q.f5381a, new String[]{"inbox_enable_noti"}, "inbox_no=?", new String[]{this.f10445v}, null)) == null) {
            return null;
        }
        if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return null;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti"));
        cursorQuery.close();
        if ("N".equals(string)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Intent m10096a(Context context, EnumC1455w enumC1455w, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ChatForwardActivity.class);
        intent.putExtra("content_type", enumC1455w.m6364a());
        intent.putExtra("inboxNO", "");
        if (TextUtils.isEmpty(str2)) {
            intent.putExtra("download_uri", str);
        } else {
            intent.putExtra("download_uri", str2);
            intent.putExtra("sub_content", str);
        }
        intent.putExtra("is_forward_mode", true);
        intent.setFlags(536870912);
        return intent;
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment
    /* renamed from: d */
    protected void mo10070d(String str) {
        if (this.f10440q != null) {
            this.f10440q.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10102a(boolean z) {
        if (this.f10439p != null && this.f10438o != null) {
            int visibility = this.f10439p.getVisibility();
            int i = z ? 8 : 0;
            this.f10438o.setVisibility(i);
            if (visibility == 8 && i == 8) {
                this.f10437n.setVisibility(8);
            } else {
                this.f10437n.setVisibility(0);
            }
        }
    }
}
