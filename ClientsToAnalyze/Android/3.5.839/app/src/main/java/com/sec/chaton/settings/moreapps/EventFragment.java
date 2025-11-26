package com.sec.chaton.settings.moreapps;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.specialbuddy.AbstractChatONLiveFragment;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;

/* loaded from: classes.dex */
public class EventFragment extends AbstractChatONLiveFragment {

    /* renamed from: f */
    private static final String f13244f = EventFragment.class.getSimpleName();

    /* renamed from: a */
    public String f13245a;

    /* renamed from: b */
    public String f13246b;

    /* renamed from: g */
    private boolean f13247g;

    /* renamed from: h */
    private Handler f13248h;

    /* renamed from: i */
    private Handler f13249i;

    public EventFragment() {
        super(f13244f, EnumC2599m.EVENT, R.layout.layout_shop_fragment, false);
        this.f13248h = new HandlerC3666a(this);
        this.f13249i = new HandlerC3670b(this);
        this.f13245a = null;
        this.f13246b = null;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected Handler getWebapiHandler() {
        return this.f13248h;
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("event_url")) {
                this.f13245a = arguments.getString("event_url");
            }
            if (arguments.containsKey("event_id")) {
                this.f13246b = arguments.getString("event_id");
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("mRequestUrl : " + this.f13245a + ", mEventId : " + this.f13246b, f13244f);
            }
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!C5034k.m19106k()) {
            m17124b();
            return;
        }
        if (!this.f13247g) {
            m13938e();
            this.f13247g = true;
        }
        boolean zIsRequestedLoadingWeb = isRequestedLoadingWeb();
        if (C4904y.f17872b) {
            C4904y.m18639b(String.format("onResume(), requestedLoadingWeb(%s), isActivityStarted(%s)", Boolean.valueOf(zIsRequestedLoadingWeb), Boolean.valueOf(this.mIsActivityStarted)), f13244f);
        }
        if (TextUtils.isEmpty(this.f13245a)) {
            if (C4904y.f17875e) {
                C4904y.m18634a("onResume() requestedUrl is empty.", f13244f);
            }
        } else if (!zIsRequestedLoadingWeb) {
            startWebContentsWithOriginalUrl(m13939f());
        }
    }

    /* renamed from: e */
    private void m13938e() {
        String[] strArrSplit;
        String strM18121a = C4809aa.m18104a().m18121a("new_promotion_ids", (String) null);
        int iIntValue = C4809aa.m18104a().m18120a("new_promotion_count", (Integer) 0).intValue();
        if (iIntValue > 0 && !TextUtils.isEmpty(strM18121a) && (strArrSplit = strM18121a.split(",")) != null) {
            StringBuilder sb = new StringBuilder();
            int i = iIntValue;
            for (String str : strArrSplit) {
                if (str.equals(this.f13246b)) {
                    if (i > 0) {
                        i--;
                        C4809aa.m18104a().m18126b("new_promotion_count", Integer.valueOf(i));
                    }
                } else {
                    sb.append(str).append(",");
                }
            }
            C4809aa.m18104a().m18128b("new_promotion_ids", sb.toString());
        }
    }

    /* renamed from: f */
    private String m13939f() {
        String str = this.f13245a;
        C4904y.m18639b(String.format("getRequestUrl(), requestUrl: %s", str), f13244f);
        return str;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f13248h = null;
        super.onDestroyView();
        BaseActivity.m6160a((Fragment) this, false);
    }
}
