package com.sec.chaton.mobileweb;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public abstract class AbstractMobileWebFragment extends Fragment implements InterfaceC1061c {
    static final String JS_INTERFACE_NAME = "ChatONBridge";
    private static final int PROGRESS_MAX = 100;
    public static final int UI_REQUEST_PICK_OR_CAPTURE_IMAGE = 0;
    protected final String TAG;
    private Handler handler;
    private String loadedUrl;
    protected final EnumC2599m mApiUsageType;
    private Activity mAttachedActivity;
    protected C2601o mBridgeObject;
    protected final boolean mCheckInternalUrl;
    private Handler mChromeEventHandler;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private LinearLayout mFullView;
    private boolean mInLoad;
    protected boolean mIsActivityStarted;
    protected boolean mIsRedirected;
    private boolean mIsRequestedLoadingWeb;
    private int mLayoutId;
    private boolean mLoadDone;
    private PageProgressView mProgressWebLoading;
    protected final List<EnumC2598l> mRequestApiList;
    private Timer mTimer;
    private String mTitle;
    private InternalWebChromeClient mWebChromeClient;
    protected WebView mWebView;
    Set<ProgressShowReason> progressBarReason;
    Set<ProgressShowReason> progressDialogReason;
    private int runningTime;
    private int timeOut;

    public enum ProgressShowReason {
        REQ_STARTING_MOBILE_WEB_CONTENTS
    }

    protected abstract Handler getWebapiHandler();

    protected abstract WebView onCreateWebView(View view);

    protected abstract void onDismissProgress();

    protected abstract void onPageFinishedFromWebViewClient(int i);

    protected abstract void onProgressTimeOut();

    protected abstract void onReceiveErrorFromWebViewClient(int i);

    protected abstract void onShowNetworkAlert();

    protected abstract void onShowProgress();

    static /* synthetic */ int access$008(AbstractMobileWebFragment abstractMobileWebFragment) {
        int i = abstractMobileWebFragment.runningTime;
        abstractMobileWebFragment.runningTime = i + 1;
        return i;
    }

    public void setChromeHandler(Handler handler) {
        this.mChromeEventHandler = handler;
    }

    public AbstractMobileWebFragment(String str, EnumC2599m enumC2599m, int i, boolean z) {
        this.mIsRequestedLoadingWeb = false;
        this.loadedUrl = null;
        this.mIsRedirected = false;
        this.mWebChromeClient = null;
        this.mTitle = null;
        this.mIsActivityStarted = false;
        this.progressDialogReason = new HashSet();
        this.progressBarReason = new HashSet();
        this.mInLoad = false;
        this.mLoadDone = false;
        this.timeOut = -1;
        this.runningTime = -1;
        this.handler = new Handler() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("the progress timer is expired.", AbstractMobileWebFragment.this.TAG);
                }
                AbstractMobileWebFragment.this.runningTime = -1;
                AbstractMobileWebFragment.this.stopProgressTimer();
                AbstractMobileWebFragment.this.progressTimeOut();
                super.handleMessage(message);
            }
        };
        this.TAG = str;
        this.mApiUsageType = enumC2599m;
        this.mRequestApiList = this.mApiUsageType.m11009c();
        this.mLayoutId = i;
        this.mIsRequestedLoadingWeb = false;
        this.loadedUrl = null;
        this.mInLoad = false;
        this.mLoadDone = false;
        this.mCheckInternalUrl = z;
    }

    public AbstractMobileWebFragment(String str, EnumC2599m enumC2599m, int i) {
        this(str, enumC2599m, i, true);
    }

    public Activity getAttachedActivity() {
        return this.mAttachedActivity;
    }

    public List<EnumC2598l> getRequestApiList() {
        return this.mRequestApiList;
    }

    public EnumC2599m getApiUsageType() {
        return this.mApiUsageType;
    }

    public boolean isRequestedLoadingWeb() {
        return this.mIsRequestedLoadingWeb;
    }

    protected void setIsRedirected(boolean z) {
        this.mIsRedirected = z;
    }

    protected boolean getIsRedirected() {
        return this.mIsRedirected;
    }

    protected void setTitle(String str) {
        this.mTitle = str;
    }

    protected String getTitle() {
        return this.mTitle;
    }

    protected boolean isRedirected(String str) {
        boolean z;
        if (C4904y.f17872b) {
            C4904y.m18639b("IsRedirected() previous URL : " + this.mWebView.getUrl() + ", current URL : " + str, this.TAG);
        }
        if (this.mWebView.getUrl().equals(str)) {
            z = false;
        } else {
            z = true;
        }
        if (C4904y.f17872b) {
            setIsRedirected(z);
            C4904y.m18639b("IsRedirected() : " + z, this.TAG);
        }
        return z;
    }

    protected boolean isNeededToLoadedInternalWebView(String str) {
        if (C2602p.m11019b(this.mWebView.getUrl()) && !C2602p.m11019b(str)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("IsNeededToLoadedInternalWebView() : true", this.TAG);
            }
            return true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("IsNeededToLoadedInternalWebView() : false", this.TAG);
        }
        return false;
    }

    @Override // com.sec.chaton.base.InterfaceC1061c
    public boolean onBackKeyPressed() {
        if (!isValidActivity()) {
            return false;
        }
        if (this.mCustomView != null) {
            this.mWebChromeClient.onHideCustomView();
            return true;
        }
        if (this.mWebView == null || !this.mWebView.canGoBack()) {
            return false;
        }
        this.mWebView.goBack();
        return true;
    }

    protected void showOpenProgress(ProgressShowReason progressShowReason) {
        if (isValidActivity()) {
            this.progressBarReason.add(progressShowReason);
            onShowProgress();
            if (C4904y.f17872b) {
                C4904y.m18639b(String.format("spbd_progress, showOpenProgress(), add (%s), become (%s)  ", progressShowReason, this.progressBarReason.toString()), this.TAG);
            }
        }
    }

    protected void dismissOpenProgress() {
        dismissOpenProgress(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dismissOpenProgress(ProgressShowReason progressShowReason) {
        if (isValidActivity()) {
            if (progressShowReason == null) {
                this.progressBarReason.clear();
            } else {
                this.progressBarReason.remove(progressShowReason);
            }
            if (this.progressBarReason.isEmpty()) {
                onDismissProgress();
            }
        }
    }

    protected void setProgressTimer(int i) {
        this.timeOut = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void progressTimeOut() {
        if (isValidActivity()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("progressTimeOut()", this.TAG);
            }
            onProgressTimeOut();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startProgressTimer() {
        if (this.timeOut < 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("the timeOut value is not set.", this.TAG);
                return;
            }
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("startProgressTimer()", this.TAG);
        }
        if (this.mTimer == null) {
            this.runningTime = 0;
            this.mTimer = new Timer(true);
            this.mTimer.schedule(new TimerTask() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        if (AbstractMobileWebFragment.this.runningTime >= 0) {
                            AbstractMobileWebFragment.access$008(AbstractMobileWebFragment.this);
                            if (AbstractMobileWebFragment.this.runningTime > 0 && C4904y.f17872b) {
                                C4904y.m18639b("thread runningTime" + AbstractMobileWebFragment.this.runningTime, AbstractMobileWebFragment.this.TAG);
                            }
                            if (AbstractMobileWebFragment.this.runningTime > AbstractMobileWebFragment.this.timeOut) {
                                AbstractMobileWebFragment.this.handler.sendEmptyMessage(0);
                            }
                        }
                    } catch (Exception e) {
                        if (C4904y.f17875e) {
                            C4904y.m18635a(e, AbstractMobileWebFragment.this.TAG);
                        }
                    }
                }
            }, 0L, 1000L);
        } else if (this.runningTime > 0) {
            this.runningTime = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopProgressTimer() {
        if (this.timeOut >= 0) {
            this.runningTime = -1;
            if (this.mTimer != null) {
                this.mTimer.cancel();
                this.mTimer = null;
            }
            if (this.mApiUsageType == EnumC2599m.LIVE_GENERAL && !this.mLoadDone) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Time out but Web page loading is not completed", this.TAG);
                }
                setProgress(100);
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("stopProgressTimer()", this.TAG);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.mAttachedActivity = activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreateView()", this.TAG);
        }
        View viewInflate = layoutInflater.inflate(this.mLayoutId, viewGroup, false);
        this.mWebView = onCreateWebView(viewInflate);
        this.mFullView = (LinearLayout) viewInflate.findViewById(R.id.spbd_full_screen);
        this.mProgressWebLoading = (PageProgressView) viewInflate.findViewById(R.id.progress_web_loading);
        C2602p.m11014a(this.mWebView);
        this.mBridgeObject = C2601o.buildMobileWebBridgeClass(getWebapiHandler(), this.mRequestApiList);
        this.mWebView.addJavascriptInterface(this.mBridgeObject, JS_INTERFACE_NAME);
        this.mWebView.setWebViewClient(new SpbdWebViewClient(this.TAG));
        this.mWebChromeClient = new InternalWebChromeClient(this.TAG);
        this.mWebView.setWebChromeClient(this.mWebChromeClient);
        this.mIsRequestedLoadingWeb = false;
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("onActivityCreated()", this.TAG);
        }
        BaseActivity.m6160a((Fragment) this, true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (C4904y.f17872b) {
            C4904y.m18639b("onStart()", this.TAG);
        }
        this.mIsActivityStarted = true;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume()", this.TAG);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (C4904y.f17872b) {
            C4904y.m18639b("onPause()", this.TAG);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onStop() mIsRequestedLoadingWeb = " + this.mIsRequestedLoadingWeb, this.TAG);
        }
        dismissOpenProgress();
        this.mIsActivityStarted = false;
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy()", this.TAG);
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyView()", this.TAG);
        }
        super.onDestroyView();
        BaseActivity.m6160a((Fragment) this, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onDetach()", this.TAG);
        }
        if (this.mWebView != null) {
            try {
                this.mWebView.stopLoading();
                this.mWebView.removeAllViews();
                this.mWebView.destroy();
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, this.TAG);
                }
            }
            this.mWebView = null;
        }
        if (this.mBridgeObject != null) {
            this.mBridgeObject.release();
        }
        this.mAttachedActivity = null;
        super.onDetach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadUrl(String str) {
        if (isValidActivity() && !TextUtils.isEmpty(str)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("loadUrl(), request url : " + str, this.TAG);
            }
            if (this.mWebView == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("loadUrl(), BUT CURRENT WEBVIEW IS NULL. ", this.TAG);
                }
            } else {
                try {
                    this.mWebView.loadUrl(str);
                } catch (RuntimeException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, this.TAG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopLoading() {
        if (isValidActivity()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("stopLoading() : is null webview - " + (this.mWebView == null), this.TAG);
            }
            if (this.mWebView != null) {
                try {
                    if (TextUtils.isEmpty(this.loadedUrl)) {
                        this.mWebView.stopLoading();
                        this.mAttachedActivity.finish();
                    } else if (this.loadedUrl.equals(this.mWebView.getUrl())) {
                        this.mWebView.stopLoading();
                    } else {
                        this.mAttachedActivity.onBackPressed();
                        if (C4904y.f17872b) {
                            C4904y.m18639b("stopLoading() : back to previous page.", this.TAG);
                        }
                    }
                } catch (RuntimeException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, this.TAG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearHistory() {
        if (isValidActivity()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("clearHistory() : is null webview - " + (this.mWebView == null), this.TAG);
            }
            if (this.mWebView != null) {
                try {
                    this.mWebView.clearHistory();
                } catch (RuntimeException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, this.TAG);
                    }
                }
            }
        }
    }

    protected void refreshWebContents() {
    }

    protected void refreshWebContents(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.sec.chaton.mobileweb.AbstractMobileWebFragment$3] */
    public void startWebContents(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "langcd=" + C4822an.m18248p();
            if (str.contains("?")) {
                str = str + "&" + str2;
            } else {
                str = str + "?" + str2;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("startWebContents(), requestUrl with out server is : " + str, this.TAG);
        }
        showOpenProgress(ProgressShowReason.REQ_STARTING_MOBILE_WEB_CONTENTS);
        startProgressTimer();
        String strM11007a = getApiUsageType().m11007a();
        if (TextUtils.isEmpty(strM11007a)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("startWebContents(), serverUrl is empty. waiting for GLD.", this.TAG);
            }
            new AsyncTask<String, Void, String>() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public String doInBackground(String... strArr) {
                    new C2132m(null).m9555b().m9082a();
                    return strArr[0];
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(String str3) {
                    String strM11007a2 = AbstractMobileWebFragment.this.getApiUsageType().m11007a();
                    if (TextUtils.isEmpty(strM11007a2)) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("startWebContents(), GLD work has been failed", AbstractMobileWebFragment.this.TAG);
                        }
                        AbstractMobileWebFragment.this.dismissOpenProgress(ProgressShowReason.REQ_STARTING_MOBILE_WEB_CONTENTS);
                        AbstractMobileWebFragment.this.stopProgressTimer();
                        AbstractMobileWebFragment.this.onShowNetworkAlert();
                    } else {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("startWebContents(), GLD work has been successed", AbstractMobileWebFragment.this.TAG);
                        }
                        AbstractMobileWebFragment.this.loadUrl(strM11007a2 + str3);
                        AbstractMobileWebFragment.this.mIsRequestedLoadingWeb = true;
                    }
                    super.onPostExecute((AsyncTaskC25783) str3);
                }
            }.execute(str);
        } else {
            loadUrl(strM11007a + str);
            this.mIsRequestedLoadingWeb = true;
        }
    }

    protected void startWebContentsWithOriginalUrl(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("startWebContentsWithOriginalUrl(), requestUrl with out server is : " + str, this.TAG);
        }
        showOpenProgress(ProgressShowReason.REQ_STARTING_MOBILE_WEB_CONTENTS);
        startProgressTimer();
        loadUrl(str);
        this.mIsRequestedLoadingWeb = true;
    }

    class SpbdWebViewClient extends C2597k {
        SpbdWebViewClient(String str) {
            super(str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (AbstractMobileWebFragment.this.isValidActivity()) {
                C4904y.m18639b(String.format("hslee_web, view, onPageStarted(), url(%s)", str), this.TAG);
                if (AbstractMobileWebFragment.this.mApiUsageType != EnumC2599m.LIVE_GENERAL) {
                    AbstractMobileWebFragment.this.showOpenProgress(ProgressShowReason.REQ_STARTING_MOBILE_WEB_CONTENTS);
                }
                AbstractMobileWebFragment.this.mLoadDone = false;
                AbstractMobileWebFragment.this.startProgressTimer();
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (AbstractMobileWebFragment.this.isValidActivity()) {
                C4904y.m18639b(String.format("hslee_web, view, onPageFinished(), url(%s)", str), this.TAG);
                if (AbstractMobileWebFragment.this.mApiUsageType != EnumC2599m.LIVE_GENERAL) {
                    AbstractMobileWebFragment.this.dismissOpenProgress(ProgressShowReason.REQ_STARTING_MOBILE_WEB_CONTENTS);
                }
                AbstractMobileWebFragment.this.mLoadDone = true;
                AbstractMobileWebFragment.this.stopProgressTimer();
                if (AbstractMobileWebFragment.this.mWebView != null) {
                    AbstractMobileWebFragment.this.onPageFinishedFromWebViewClient(AbstractMobileWebFragment.this.mWebView.copyBackForwardList().getCurrentIndex());
                    AbstractMobileWebFragment.this.loadedUrl = AbstractMobileWebFragment.this.mWebView.getUrl();
                } else if (C4904y.f17875e) {
                    C4904y.m18634a("onPageFinished(), mWebView is null !!", this.TAG);
                }
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (AbstractMobileWebFragment.this.isValidActivity()) {
                C4904y.m18639b(String.format("hslee_web, view, onReceivedError(), errorCode(%d), description(%s), failingUrl(%s)", Integer.valueOf(i), str, str2), this.TAG);
                AbstractMobileWebFragment.this.dismissOpenProgress(ProgressShowReason.REQ_STARTING_MOBILE_WEB_CONTENTS);
                AbstractMobileWebFragment.this.stopProgressTimer();
                if (AbstractMobileWebFragment.this.mWebView != null) {
                    AbstractMobileWebFragment.this.onReceiveErrorFromWebViewClient(AbstractMobileWebFragment.this.mWebView.copyBackForwardList().getCurrentIndex());
                } else if (C4904y.f17875e) {
                    C4904y.m18634a("onReceivedError(), mWebView is null !!", this.TAG);
                }
                super.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!AbstractMobileWebFragment.this.isValidActivity() || TextUtils.isEmpty(str)) {
                return true;
            }
            EnumC2607u enumC2607uM11025a = EnumC2607u.m11025a(str);
            C4904y.m18639b(String.format("hslee_web, view, shouldOverrideUrlLoading(), url(%s), scheme(%s)", str, enumC2607uM11025a), this.TAG);
            switch (enumC2607uM11025a) {
                case HTTP:
                case HTTPS:
                    if (str.endsWith("[_blank]")) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("[_blank]", "")));
                        if (BuddyProfileActivity.m6743a(GlobalApplication.m18732r(), intent)) {
                            AbstractMobileWebFragment.this.startActivity(intent);
                            break;
                        }
                    } else if ((!C2602p.m11019b(str) || !AbstractMobileWebFragment.this.mCheckInternalUrl) && AbstractMobileWebFragment.this.mApiUsageType != EnumC2599m.SHOP_MAIN) {
                        if (AbstractMobileWebFragment.this.isNeededToLoadedInternalWebView(str)) {
                            Intent intent2 = new Intent(AbstractMobileWebFragment.this.mAttachedActivity, (Class<?>) GeneralWebActivity.class);
                            intent2.putExtra("key_intent_title", AbstractMobileWebFragment.this.getTitle());
                            intent2.putExtra("key_intent_url", str);
                            AbstractMobileWebFragment.this.startActivity(intent2);
                            break;
                        } else if (AbstractMobileWebFragment.this.mApiUsageType == EnumC2599m.LIVE_GENERAL) {
                            if (!TextUtils.isEmpty(AbstractMobileWebFragment.this.loadedUrl)) {
                                Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                                if (BuddyProfileActivity.m6743a(GlobalApplication.m18732r(), intent3)) {
                                    AbstractMobileWebFragment.this.startActivity(intent3);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            if (BuddyProfileActivity.m6743a(GlobalApplication.m18732r(), intent4)) {
                                AbstractMobileWebFragment.this.startActivity(intent4);
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                    break;
                case INTENT:
                    try {
                        AbstractMobileWebFragment.this.startActivity(Intent.parseUri(str, 1));
                        break;
                    } catch (ActivityNotFoundException e) {
                        if (!C4904y.f17875e) {
                            return true;
                        }
                        C4904y.m18635a(e, this.TAG);
                        return true;
                    } catch (URISyntaxException e2) {
                        if (!C4904y.f17875e) {
                            return true;
                        }
                        C4904y.m18635a(e2, this.TAG);
                        return true;
                    }
                default:
                    Intent intent5 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    if (BuddyProfileActivity.m6743a(GlobalApplication.m18732r(), intent5)) {
                        AbstractMobileWebFragment.this.startActivity(intent5);
                        break;
                    }
                    break;
            }
            return true;
        }
    }

    class InternalWebChromeClient extends C2596j {
        InternalWebChromeClient(String str) {
            super(str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (C4904y.f17872b) {
                C4904y.m18639b("errorCode=" + i + "failingUrl = " + str2 + "desctiption = " + str, getClass().getSimpleName());
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            if (C4904y.f17872b) {
                C4904y.m18639b("openFileChooser under SDK 10", getClass().getSimpleName());
            }
            if (AbstractMobileWebFragment.this.mChromeEventHandler != null) {
                AbstractMobileWebFragment.this.mChromeEventHandler.obtainMessage(0, valueCallback).sendToTarget();
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            if (C4904y.f17872b) {
                C4904y.m18639b("openFileChooser over SDK 11 and under SDK 15", getClass().getSimpleName());
            }
            if (AbstractMobileWebFragment.this.mChromeEventHandler != null) {
                AbstractMobileWebFragment.this.mChromeEventHandler.obtainMessage(0, valueCallback).sendToTarget();
            }
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (C4904y.f17872b) {
                C4904y.m18639b("openFileChooser over SDK 16", getClass().getSimpleName());
            }
            if (AbstractMobileWebFragment.this.mChromeEventHandler != null) {
                AbstractMobileWebFragment.this.mChromeEventHandler.obtainMessage(0, valueCallback).sendToTarget();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            if (AbstractMobileWebFragment.this.isValidActivity()) {
                C4904y.m18639b(String.format("hslee_web, chrome, onJsConfirm(), url(%s) / message(%s) / result(%s)", str, str2, jsResult), this.TAG);
                InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(AbstractMobileWebFragment.this.getActivity()).mo18734a(R.string.app_name).mo18749b(str2).mo18756d(R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.InternalWebChromeClient.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                }).mo18747b(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.InternalWebChromeClient.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                }).mo18745a();
                interfaceC4936eMo18745a.show();
                interfaceC4936eMo18745a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.InternalWebChromeClient.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        jsResult.cancel();
                    }
                });
                interfaceC4936eMo18745a.setCanceledOnTouchOutside(false);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            if (!AbstractMobileWebFragment.this.isValidActivity()) {
                return true;
            }
            C4904y.m18639b(String.format("hslee_web, chrome, onJsAlert(), url(%s), message(%s), result(%s)", str, str2, jsResult), this.TAG);
            if (AbstractMobileWebFragment.this.getActivity() == null) {
                return false;
            }
            AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(AbstractMobileWebFragment.this.mAttachedActivity);
            abstractC4932aM18733a.mo18734a(R.string.app_name);
            abstractC4932aM18733a.mo18749b(str2);
            abstractC4932aM18733a.mo18756d(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.InternalWebChromeClient.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            InterfaceC4936e interfaceC4936eMo18745a = abstractC4932aM18733a.mo18745a();
            interfaceC4936eMo18745a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.InternalWebChromeClient.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            interfaceC4936eMo18745a.show();
            interfaceC4936eMo18745a.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.sec.chaton.mobileweb.AbstractMobileWebFragment.InternalWebChromeClient.6
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            interfaceC4936eMo18745a.setCanceledOnTouchOutside(false);
            return true;
        }

        @Override // com.sec.chaton.mobileweb.C2596j, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i < 100) {
                AbstractMobileWebFragment.this.startProgressTimer();
            } else {
                AbstractMobileWebFragment.this.stopProgressTimer();
            }
            if (AbstractMobileWebFragment.this.mApiUsageType == EnumC2599m.LIVE_GENERAL) {
                AbstractMobileWebFragment.this.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            try {
                if (AbstractMobileWebFragment.this.mCustomView != null) {
                    customViewCallback.onCustomViewHidden();
                } else {
                    AbstractMobileWebFragment.this.mWebView.setVisibility(8);
                    AbstractMobileWebFragment.this.mFullView.setBackgroundResource(android.R.color.black);
                    view.setLayoutParams(layoutParams);
                    AbstractMobileWebFragment.this.mFullView.addView(view);
                    AbstractMobileWebFragment.this.mCustomView = view;
                    AbstractMobileWebFragment.this.mCustomViewCallback = customViewCallback;
                    AbstractMobileWebFragment.this.mFullView.setVisibility(0);
                    AbstractMobileWebFragment.this.hideActionBar();
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, this.TAG);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (AbstractMobileWebFragment.this.mCustomView != null) {
                try {
                    AbstractMobileWebFragment.this.mCustomView.setVisibility(8);
                    AbstractMobileWebFragment.this.mFullView.removeView(AbstractMobileWebFragment.this.mCustomView);
                    AbstractMobileWebFragment.this.mCustomView = null;
                    AbstractMobileWebFragment.this.mFullView.setVisibility(8);
                    AbstractMobileWebFragment.this.mCustomViewCallback.onCustomViewHidden();
                    AbstractMobileWebFragment.this.mWebView.setVisibility(0);
                    AbstractMobileWebFragment.this.showActionBar();
                } catch (Exception e) {
                    AbstractMobileWebFragment.this.showActionBar();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, this.TAG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActionBar() {
        if (this.mAttachedActivity != null) {
            ((ActionBarFragmentActivity) this.mAttachedActivity).m18784t().mo18835e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideActionBar() {
        if (this.mAttachedActivity != null) {
            ((ActionBarFragmentActivity) this.mAttachedActivity).m18784t().mo18837f();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValidActivity() {
        return (this.mAttachedActivity == null || this.mAttachedActivity.isFinishing()) ? false : true;
    }

    public void setProgress(int i) {
        if (i >= 100) {
            this.mProgressWebLoading.m10988a(10000);
            this.mProgressWebLoading.setVisibility(8);
            this.mInLoad = false;
        } else {
            if (!this.mInLoad) {
                this.mProgressWebLoading.setVisibility(0);
                this.mInLoad = true;
            }
            this.mProgressWebLoading.m10988a((i * 10000) / 100);
        }
    }
}
