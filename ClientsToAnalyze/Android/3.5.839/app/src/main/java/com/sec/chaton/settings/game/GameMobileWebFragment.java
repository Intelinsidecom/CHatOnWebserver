package com.sec.chaton.settings.game;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.sec.chaton.R;
import com.sec.chaton.mobileweb.AbstractMobileWebFragment;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;

/* loaded from: classes.dex */
public class GameMobileWebFragment extends AbstractMobileWebFragment {

    /* renamed from: a */
    private static final String f13214a = GameMobileWebFragment.class.getSimpleName();

    /* renamed from: b */
    private boolean f13215b;

    /* renamed from: c */
    private Handler f13216c;

    /* renamed from: d */
    private Handler f13217d;

    public GameMobileWebFragment() {
        super(f13214a, EnumC2599m.CHATON_GAME, R.layout.layout_game_main);
        this.f13216c = new HandlerC3646a(this);
        this.f13217d = new HandlerC3647b(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected Handler getWebapiHandler() {
        return this.f13216c;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onShowProgress() {
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onDismissProgress() {
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onProgressTimeOut() {
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onShowNetworkAlert() {
        getActivity().finish();
        C5179v.m19810a(getActivity(), R.string.toast_network_unable, 1).show();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected WebView onCreateWebView(View view) {
        return (WebView) view.findViewById(R.id.game_webview);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        startWebContents(m13932b());
        this.f13215b = true;
        return viewOnCreateView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f13215b) {
            this.f13215b = false;
        } else {
            loadUrl(C2602p.m11011a("chaton.loadNewer", ""));
        }
    }

    /* renamed from: b */
    private String m13932b() {
        String strM11008b = getApiUsageType().m11008b();
        if (!TextUtils.isEmpty(strM11008b)) {
            long jM18118a = C4809aa.m18104a().m18118a("cleared_timestamp_game", 0L);
            int iIntValue = C4809aa.m18104a().m18120a("new_game_count", (Integer) 0).intValue();
            String str = strM11008b + "?" + (("myid=" + C4809aa.m18104a().m18121a("chaton_id", "")) + "&" + ("badgecount=" + iIntValue) + "&" + ("lastcleartime=" + jM18118a));
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("getRequestUrl(), requestUrl: %s", str), f13214a);
                return str;
            }
            return str;
        }
        return "";
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onReceiveErrorFromWebViewClient(int i) {
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onPageFinishedFromWebViewClient(int i) {
    }
}
