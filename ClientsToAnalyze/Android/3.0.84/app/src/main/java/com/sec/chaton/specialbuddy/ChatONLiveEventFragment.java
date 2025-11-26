package com.sec.chaton.specialbuddy;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.event.C1464f;
import com.sec.chaton.mobileweb.EnumC1689p;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;

/* loaded from: classes.dex */
public class ChatONLiveEventFragment extends AbstractChatONLiveFragment {

    /* renamed from: j */
    private static final String f10397j = ChatONLiveEventFragment.class.getSimpleName();

    /* renamed from: i */
    boolean f10398i;

    /* renamed from: k */
    private Handler f10399k;

    /* renamed from: l */
    private Handler f10400l;

    public ChatONLiveEventFragment() {
        super(f10397j, EnumC1689p.LIVE_EVENT);
        this.f10398i = false;
        this.f10399k = new HandlerC2927h(this);
        this.f10400l = new HandlerC2928i(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: b */
    protected Handler mo6954b() {
        return this.f10399k;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (!C3347i.m11788k()) {
            m10071l();
            return;
        }
        boolean zI = m6964i();
        if (C3250y.f11734b) {
            C3250y.m11450b(String.format("onResume(), requestedLoadingWeb(%s), isActivityStarted(%s)", Boolean.valueOf(zI), Boolean.valueOf(this.f6165f)), f10397j);
        }
        if (zI) {
            if (this.f10398i) {
                mo6965j();
            }
        } else {
            m6958c(m10085n());
            C1464f.m6394c(true);
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f10399k = null;
        super.onDestroyView();
        BaseActivity.m3081a(this, false);
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: j */
    protected void mo6965j() {
        this.f10398i = false;
        super.mo6965j();
    }

    /* renamed from: n */
    protected String m10085n() {
        String strReplace;
        String strM6982a = m6963h().m6982a();
        String strM10979a = C3159aa.m10962a().m10979a("event_web_url", "");
        int iIntValue = C3159aa.m10962a().m10978a("event_id", (Integer) 0).intValue();
        String strM11082t = C3171am.m11082t();
        if (TextUtils.isEmpty(strM10979a)) {
            return "";
        }
        String str = ("eventid=" + iIntValue) + "&" + ("iso2=" + strM11082t);
        if (strM10979a.contains("?")) {
            strReplace = strM10979a + "&" + str;
        } else {
            strReplace = strM10979a + "?" + str;
        }
        C3250y.m11450b("getRequestUrl() #1, tempUrl : " + strReplace, f10397j);
        if (strReplace.startsWith("{LIVE_MOBILEWEB}")) {
            strReplace = strReplace.replace("{LIVE_MOBILEWEB}", strM6982a);
        }
        C3250y.m11450b(String.format("getRequestUrl() #2, requestUrl: %s", strReplace), f10397j);
        return strReplace;
    }
}
