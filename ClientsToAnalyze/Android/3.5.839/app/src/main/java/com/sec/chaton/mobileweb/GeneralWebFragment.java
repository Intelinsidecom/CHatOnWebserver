package com.sec.chaton.mobileweb;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0014a;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.C2608a;
import com.sec.chaton.specialbuddy.AbstractChatONLiveFragment;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;

/* loaded from: classes.dex */
public class GeneralWebFragment extends AbstractChatONLiveFragment {

    /* renamed from: b */
    private static final String f9200b = GeneralWebFragment.class.getSimpleName();

    /* renamed from: a */
    C2608a f9201a;

    /* renamed from: f */
    private ViewGroup f9202f;

    /* renamed from: g */
    private ImageView f9203g;

    /* renamed from: h */
    private TextView f9204h;

    /* renamed from: i */
    private TextView f9205i;

    /* renamed from: j */
    private boolean f9206j;

    /* renamed from: k */
    private EnumC1109f f9207k;

    /* renamed from: l */
    private ListView f9208l;

    /* renamed from: m */
    private DrawerLayout f9209m;

    /* renamed from: n */
    private C0014a f9210n;

    /* renamed from: o */
    private LinearLayout f9211o;

    /* renamed from: p */
    private LinearLayout f9212p;

    /* renamed from: q */
    private ImageView f9213q;

    /* renamed from: r */
    private TextView f9214r;

    /* renamed from: s */
    private TextView f9215s;

    /* renamed from: t */
    private Activity f9216t;

    /* renamed from: u */
    private C5007c f9217u;

    /* renamed from: v */
    private WindowManager f9218v;

    /* renamed from: w */
    private LinearLayout f9219w;

    /* renamed from: x */
    private ImageView f9220x;

    /* renamed from: y */
    private Handler f9221y;

    /* renamed from: z */
    private Handler f9222z;

    public GeneralWebFragment() {
        super(f9200b, EnumC2599m.LIVE_GENERAL);
        this.f9206j = false;
        this.f9207k = EnumC1109f.NONE;
        this.f9221y = new HandlerC2591e(this);
        this.f9222z = new HandlerC2592f(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected Handler getWebapiHandler() {
        return this.f9222z;
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Activity attachedActivity = getAttachedActivity();
        View viewInflate = LayoutInflater.from(attachedActivity).inflate(R.layout.actionbar_custom_layout_specialbuddychat, (ViewGroup) null, false);
        ((ActionBarFragmentActivity) attachedActivity).m18784t().mo18820a(viewInflate);
        this.f9205i = (TextView) viewInflate.findViewById(R.id.chatroom_custom_title);
        this.f9202f = (ViewGroup) viewInflate.findViewById(R.id.subtitle_group);
        this.f9204h = (TextView) viewInflate.findViewById(R.id.chatroom_custom_sub_title);
        this.f9203g = (ImageView) viewInflate.findViewById(R.id.title_alert_off_indicator);
        ((ActionBarFragmentActivity) attachedActivity).m18784t().mo18836e(23);
        Bundle arguments = getArguments();
        String string = arguments.getString("key_intent_title");
        String string2 = arguments.getString("key_intent_url");
        if (!TextUtils.isEmpty(string)) {
            this.f9205i.setText(string);
        }
        loadUrl(string2);
        if (this.mWebView != null) {
            C2602p.m11021c(this.mWebView);
            setProgressTimer(90);
        }
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f9217u = new C5007c();
            this.f9218v = (WindowManager) GlobalApplication.m18732r().getSystemService("window");
            this.f9209m = (DrawerLayout) viewOnCreateView.findViewById(R.id.mDrawerLayout);
            this.f9211o = (LinearLayout) viewOnCreateView.findViewById(R.id.listview_linearlayout);
            this.f9208l = (ListView) this.f9209m.findViewById(R.id.left_drawer);
            this.f9212p = (LinearLayout) this.f9209m.findViewById(R.id.empty_list_view);
            this.f9212p.setBackgroundColor(getResources().getColor(R.color.white));
            this.f9213q = (ImageView) this.f9212p.findViewById(R.id.image1);
            this.f9213q.setImageResource(R.drawable.no_contents_chat);
            this.f9214r = (TextView) this.f9212p.findViewById(R.id.text1);
            this.f9214r.setText(getResources().getString(R.string.no_chats));
            this.f9215s = (TextView) this.f9212p.findViewById(R.id.text2);
            this.f9215s.setText(getResources().getString(R.string.chatlist_no_chat_2));
            this.f9208l.setEmptyView(this.f9212p);
            m10976a(layoutInflater.inflate(R.layout.draw_menu_info_layout, (ViewGroup) null, false));
            this.f9210n = new C2593g(this, this.f9216t, this.f9209m, R.drawable.actionbar_ic_send, R.string.draw_menu_msg, R.string.ams_never_show_again);
            this.f9209m.setDrawerListener(this.f9210n);
        } else {
            this.f9209m = (DrawerLayout) viewOnCreateView.findViewById(R.id.mDrawerLayout);
            this.f9209m.setDrawerLockMode(1);
        }
        return viewOnCreateView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || arguments.size() <= 0) {
        }
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9206j = false;
        if (!C5034k.m19106k()) {
            m17124b();
            return;
        }
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            if (!C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
                m10980e();
            }
            this.f9208l.setChoiceMode(0);
            this.f9201a.m11156a(0);
            this.f9208l.setItemsCanFocus(false);
            this.f9206j = false;
            C4904y.m18646e("[MSGBOX] onResume()", getClass().getSimpleName());
            if (!TextUtils.isEmpty(GlobalApplication.f8359e)) {
                GlobalApplication.f8359e = null;
                this.f9217u.m19014a();
                this.f9217u = new C5007c();
                this.f9201a.m11157a(this.f9217u);
            }
        }
    }

    /* renamed from: e */
    private void m10980e() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2003, 262184, -3);
        layoutParams.gravity = 51;
        C4809aa.m18105a("show_draw_menu_info", (Boolean) true);
        this.f9218v.addView(this.f9219w, layoutParams);
    }

    /* renamed from: a */
    private void m10976a(View view) {
        if (!C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
            this.f9219w = (LinearLayout) view;
            this.f9220x = (ImageView) this.f9219w.findViewById(R.id.closeinfo);
            this.f9220x.setOnClickListener(new ViewOnClickListenerC2594h(this));
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f9206j = true;
        if (C2349a.m10301a("chatroom_draw_menu_feature") && C4809aa.m18104a().m18119a("show_draw_menu_info", (Boolean) false).booleanValue() && !C4809aa.m18104a().m18119a("draw_menu_info", (Boolean) false).booleanValue()) {
            this.f9218v.removeView(this.f9219w);
            C4809aa.m18105a("show_draw_menu_info", (Boolean) false);
        }
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f9222z = null;
        this.f9221y = null;
        super.onDestroy();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView()", f9200b);
        }
        super.onDestroyView();
        BaseActivity.m6160a((Fragment) this, false);
        if (C2349a.m10301a("chatroom_draw_menu_feature")) {
            this.f9217u.m19014a();
        }
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void setTitle(String str) {
        if (!getArguments().getBoolean("NO_TITLE_TO_ACTIONBAR") && this.f9205i != null) {
            this.f9205i.setText(str);
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9216t = activity;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9216t = null;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() {
        return super.onBackKeyPressed();
    }
}
