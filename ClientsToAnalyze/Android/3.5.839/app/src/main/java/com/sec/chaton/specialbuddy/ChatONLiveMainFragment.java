package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class ChatONLiveMainFragment extends AbstractChatONLiveFragment {

    /* renamed from: a */
    private static final String f16291a = ChatONLiveMainFragment.class.getSimpleName();

    /* renamed from: b */
    private boolean f16292b;

    /* renamed from: f */
    private String f16293f;

    /* renamed from: g */
    private boolean f16294g;

    /* renamed from: h */
    private ContentObserver f16295h;

    /* renamed from: i */
    private Handler f16296i;

    /* renamed from: j */
    private Handler f16297j;

    public ChatONLiveMainFragment() {
        super(f16291a, EnumC2599m.LIVE_MAIN);
        this.f16292b = false;
        this.f16294g = false;
        this.f16295h = new C4543h(this, new Handler());
        this.f16296i = new HandlerC4544i(this);
        this.f16297j = new HandlerC4545j(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected Handler getWebapiHandler() {
        return this.f16296i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17131a(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17130a(String str, int i) {
        if (i == 1) {
            C5179v.m19811a(getActivity(), str, 1).show();
        } else {
            C5179v.m19811a(getActivity(), str, 0).show();
        }
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("key_start_with_buddylist")) {
            this.f16294g = arguments.getBoolean("key_start_with_buddylist");
        }
        CommonApplication.m18732r().getContentResolver().registerContentObserver(C2230ar.f7958a, true, this.f16295h);
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        ((DrawerLayout) viewOnCreateView.findViewById(R.id.mDrawerLayout)).setDrawerLockMode(1);
        return viewOnCreateView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!C5034k.m19106k()) {
            m17124b();
            return;
        }
        boolean zIsRequestedLoadingWeb = isRequestedLoadingWeb();
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("onResume(), requestedLoadingWeb(%s), isActivityStarted(%s)", Boolean.valueOf(zIsRequestedLoadingWeb), Boolean.valueOf(this.mIsActivityStarted)), f16291a);
        }
        if (zIsRequestedLoadingWeb) {
            if (this.f16292b) {
                refreshWebContents();
                return;
            }
            return;
        }
        startWebContents(m17141a());
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        CommonApplication.m18732r().getContentResolver().unregisterContentObserver(this.f16295h);
        super.onDestroy();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f16296i = null;
        super.onDestroyView();
        BaseActivity.m6160a((Fragment) this, false);
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void refreshWebContents() {
        this.f16292b = false;
        String strM17244a = "";
        if (!TextUtils.isEmpty(this.f16293f)) {
            strM17244a = new C4547l(this.f16293f, C2186al.m9774c(GlobalApplication.m18732r().getContentResolver(), this.f16293f), null).m17244a();
        }
        super.refreshWebContents(strM17244a);
    }

    /* renamed from: a */
    protected String m17141a() {
        String str;
        String strM11008b = getApiUsageType().m11008b();
        if (TextUtils.isEmpty(strM11008b)) {
            return "";
        }
        long jM18118a = C4809aa.m18104a().m18118a("cleared_timestamp_livepartner_buddies", 0L);
        int iIntValue = C4809aa.m18104a().m18120a("new_livepartner_count", (Integer) 0).intValue();
        String str2 = ("myid=" + C4809aa.m18104a().m18121a("chaton_id", "")) + "&" + ("badgecount=" + iIntValue) + "&" + ("lastcleartime=" + jM18118a);
        if (this.f16294g) {
            str2 = "&view=buddy";
        }
        if (strM11008b.contains("?")) {
            str = strM11008b + "&" + str2;
        } else {
            str = strM11008b + "?" + str2;
        }
        C4904y.m18639b(String.format("getRequestUrl(), requestUrl: %s", str), f16291a);
        return str;
    }
}
