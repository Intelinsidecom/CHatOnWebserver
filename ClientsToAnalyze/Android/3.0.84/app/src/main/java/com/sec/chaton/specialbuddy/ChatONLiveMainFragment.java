package com.sec.chaton.specialbuddy;

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.mobileweb.EnumC1689p;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;

/* loaded from: classes.dex */
public class ChatONLiveMainFragment extends AbstractChatONLiveFragment {

    /* renamed from: k */
    private static final String f10403k = ChatONLiveMainFragment.class.getSimpleName();

    /* renamed from: i */
    boolean f10404i;

    /* renamed from: j */
    String f10405j;

    /* renamed from: l */
    private ContentObserver f10406l;

    /* renamed from: m */
    private Handler f10407m;

    /* renamed from: n */
    private Handler f10408n;

    public ChatONLiveMainFragment() {
        super(f10403k, EnumC1689p.LIVE_MAIN);
        this.f10404i = false;
        this.f10406l = new C2931l(this, new Handler());
        this.f10407m = new HandlerC2932m(this);
        this.f10408n = new HandlerC2933n(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: b */
    protected Handler mo6954b() {
        return this.f10407m;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CommonApplication.m11493l().getContentResolver().registerContentObserver(C1390ah.f5188a, true, this.f10406l);
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
            C3250y.m11450b(String.format("onResume(), requestedLoadingWeb(%s), isActivityStarted(%s)", Boolean.valueOf(zI), Boolean.valueOf(this.f6165f)), f10403k);
        }
        if (zI) {
            if (this.f10404i) {
                mo6965j();
                return;
            }
            return;
        }
        m6958c(m10093n());
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        CommonApplication.m11493l().getContentResolver().unregisterContentObserver(this.f10406l);
        super.onDestroy();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.f10407m = null;
        super.onDestroyView();
        BaseActivity.m3081a(this, false);
    }

    @Override // com.sec.chaton.specialbuddy.AbstractChatONLiveFragment, com.sec.chaton.mobileweb.AbstractMobileWebFragment
    /* renamed from: j */
    protected void mo6965j() {
        this.f10404i = false;
        String strM10164a = "";
        if (!TextUtils.isEmpty(this.f10405j)) {
            strM10164a = new C2935p(this.f10405j, C1357af.m5997c(GlobalApplication.m11493l().getContentResolver(), this.f10405j)).m10164a();
        }
        super.mo6956b(strM10164a);
    }

    /* renamed from: n */
    protected String m10093n() {
        String str;
        EnumC1689p enumC1689pH = m6963h();
        String strM6982a = enumC1689pH.m6982a();
        String strM6983b = enumC1689pH.m6983b();
        if (TextUtils.isEmpty(strM6983b)) {
            return "";
        }
        long jM10976a = C3159aa.m10962a().m10976a("cleared_timestamp_livepartner_buddies", 0L);
        int iIntValue = C3159aa.m10962a().m10978a("new_livepartner_count", (Integer) 0).intValue();
        String str2 = ("myid=" + C3159aa.m10962a().m10979a("chaton_id", "")) + "&" + ("badgecount=" + iIntValue) + "&" + ("lastcleartime=" + jM10976a);
        if (strM6983b.contains("?")) {
            str = strM6982a + strM6983b + "&" + str2;
        } else {
            str = strM6982a + strM6983b + "?" + str2;
        }
        C3250y.m11450b(String.format("getRequestUrl(), requestUrl: %s", str), f10403k);
        return str;
    }
}
