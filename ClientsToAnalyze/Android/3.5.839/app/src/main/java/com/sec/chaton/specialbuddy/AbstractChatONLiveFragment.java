package com.sec.chaton.specialbuddy;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.sec.chaton.R;
import com.sec.chaton.base.InterfaceC1061c;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.mobileweb.AbstractMobileWebFragment;
import com.sec.chaton.mobileweb.C2602p;
import com.sec.chaton.mobileweb.EnumC2599m;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.qmlog.C3119a;
import com.sec.chaton.settings.p096a.C3469m;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4838bc;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4899t;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public abstract class AbstractChatONLiveFragment extends AbstractMobileWebFragment implements InterfaceC1061c {

    /* renamed from: a */
    private FrameLayout f16281a;

    /* renamed from: b */
    private FrameLayout f16282b;

    /* renamed from: c */
    InterfaceC4936e f16283c;

    /* renamed from: d */
    Handler f16284d;

    /* renamed from: e */
    DialogInterface.OnClickListener f16285e;

    /* renamed from: f */
    private ProgressDialog f16286f;

    /* renamed from: g */
    private ValueCallback<Uri> f16287g;

    /* renamed from: h */
    private Uri f16288h;

    public AbstractChatONLiveFragment(String str, EnumC2599m enumC2599m) {
        super(str, enumC2599m, R.layout.layout_special_buddy_chat_fragment);
        this.f16283c = null;
        this.f16284d = new HandlerC4539d(this);
        this.f16285e = new DialogInterfaceOnClickListenerC4541f(this);
    }

    public AbstractChatONLiveFragment(String str, EnumC2599m enumC2599m, int i, boolean z) {
        super(str, enumC2599m, i, z);
        this.f16283c = null;
        this.f16284d = new HandlerC4539d(this);
        this.f16285e = new DialogInterfaceOnClickListenerC4541f(this);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        C2602p.m11023d(this.mWebView);
        return viewOnCreateView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onShowProgress() {
        if (C2349a.m10301a("chaton_qmlog_sending")) {
            C3119a.m12716a().m12725c(System.currentTimeMillis());
        }
        m17114a();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onDismissProgress() {
        m17119e();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onProgressTimeOut() {
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onShowNetworkAlert() {
        m17124b();
    }

    /* renamed from: a */
    private void m17114a() {
        if (isValidActivity()) {
            if (this.f16286f == null) {
                this.f16286f = C3469m.m13794a(getAttachedActivity());
                this.f16286f.setOnCancelListener(new DialogInterfaceOnCancelListenerC4524a(this));
            }
            if (!this.f16286f.isShowing()) {
                this.f16286f.show();
            }
            this.f16286f.setCanceledOnTouchOutside(false);
        }
    }

    /* renamed from: e */
    private void m17119e() {
        if (isValidActivity() && this.f16286f != null && this.f16286f.isShowing()) {
            this.f16286f.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        setChromeHandler(this.f16284d);
        super.onCreate(bundle);
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        setChromeHandler(null);
        this.f16284d = null;
        super.onDestroy();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onReceiveErrorFromWebViewClient(int i) {
        m17125c();
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void onPageFinishedFromWebViewClient(int i) {
        if (C2349a.m10301a("chaton_qmlog_sending") && this.mWebView != null) {
            C3119a.m12716a().m12722a("live", this.mWebView.getUrl(), System.currentTimeMillis());
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected WebView onCreateWebView(View view) {
        this.f16281a = (FrameLayout) view.findViewById(R.id.mainLayout);
        this.f16282b = (FrameLayout) view.findViewById(R.id.networkErrorView);
        this.mWebView = (WebView) view.findViewById(R.id.spbd_webview);
        return this.mWebView;
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void setTitle(String str) {
        if (isValidActivity()) {
            getAttachedActivity().setTitle(str);
            super.setTitle(str);
        }
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void refreshWebContents() {
        C4904y.m18639b("refreshWebContents()", this.TAG);
        loadUrl("javascript:chaton.loadNewer()");
    }

    @Override // com.sec.chaton.mobileweb.AbstractMobileWebFragment
    protected void refreshWebContents(String str) {
        String str2 = String.format("javascript:chaton.loadNewer(%s)", str);
        C4904y.m18639b("refreshWebContents() : " + str2, this.TAG);
        loadUrl(str2);
    }

    /* renamed from: b */
    public void m17124b() {
        if (getActivity() != null) {
            InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.toast_network_unable)).mo18751b(false).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC4537b(this)).mo18745a();
            interfaceC4936eMo18745a.setCanceledOnTouchOutside(false);
            interfaceC4936eMo18745a.setOnKeyListener(new DialogInterfaceOnKeyListenerC4538c(this));
            interfaceC4936eMo18745a.show();
        }
    }

    /* renamed from: c */
    void m17125c() {
        if (this.f16282b != null && this.f16281a != null) {
            this.f16282b.setVisibility(0);
            this.f16281a.setVisibility(8);
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            int i = R.string.toast_network_unable;
            if (-3 == iM10677a || -2 == iM10677a) {
                i = R.string.popup_no_network_connection;
            }
            C5179v.m19810a(getActivity(), i, 1).show();
        }
    }

    /* renamed from: d */
    void m17126d() {
        Activity attachedActivity = getAttachedActivity();
        new Intent("android.intent.action.PICK").setType("image/*");
        int i = R.array.selphoto_first;
        if (!C4822an.m18251s()) {
            i = R.array.selphoto_first_nocamera_nodelete;
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(attachedActivity);
        abstractC4932aM18733a.mo18734a(R.string.mypage_profile_add_photo).mo18736a(i, this.f16285e);
        if (this.f16283c == null) {
            abstractC4932aM18733a.mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4540e(this));
            this.f16283c = abstractC4932aM18733a.mo18745a();
        }
        this.f16283c.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m17120f() {
        Activity attachedActivity = getAttachedActivity();
        if (attachedActivity != null) {
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(attachedActivity, R.string.sdcard_not_found, 0).show();
            } else {
                startActivityForResult(ChatFragment.m7882a(attachedActivity), 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m17121g() {
        Activity attachedActivity = getAttachedActivity();
        if (attachedActivity != null) {
            if (!C4822an.m18245m() || !C4822an.m18246n()) {
                C5179v.m19810a(attachedActivity, R.string.recordvideo_unable_to_record_during_call, 0).show();
                return;
            }
            if (!C4873ck.m18500a()) {
                C5179v.m19810a(attachedActivity, R.string.sdcard_not_found, 0).show();
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            String str = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) + ".jpg";
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//");
            if (!file.exists()) {
                file.mkdir();
            }
            this.f16288h = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//", str));
            intent.putExtra("output", this.f16288h);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra("return-data", true);
            if (BuddyProfileActivity.m6743a(attachedActivity, intent)) {
                startActivityForResult(intent, 0);
            } else if (C4904y.f17872b) {
                C4904y.m18639b("spbdweb, captureImage(), intent not available", this.TAG);
            }
        }
    }

    /* renamed from: a */
    Uri m17122a(Context context, Uri uri) {
        return m17123a(context, uri, true);
    }

    /* renamed from: a */
    Uri m17123a(Context context, Uri uri, boolean z) throws Throwable {
        File file;
        if (C4904y.f17872b) {
            C4904y.m18639b("getFileFromUri(), input is : " + uri, this.TAG);
        }
        if (uri == null) {
            return null;
        }
        if ("content".equals(uri.getScheme())) {
            C4899t c4899tM18600a = C4894o.m18600a(uri);
            if (c4899tM18600a == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("getFileFromUri(), FileInfo has not file path", this.TAG);
                }
                return null;
            }
            file = c4899tM18600a.f17859a;
        } else {
            file = new File(uri.getPath());
        }
        if (C4838bc.m18308a(file) && z) {
            if (C4904y.f17872b) {
                C4904y.m18639b("getFileFromUri(), to be resized", this.TAG);
            }
            try {
                file = C4838bc.m18310b(context, file, null, null, true);
            } catch (FileNotFoundException e) {
                C4904y.m18635a(e, this.TAG);
                file = null;
            } catch (IOException e2) {
                C4904y.m18635a(e2, this.TAG);
                file = null;
            } catch (Exception e3) {
                C4904y.m18635a(e3, this.TAG);
                file = null;
            } catch (OutOfMemoryError e4) {
                C4904y.m18635a(e4, this.TAG);
                file = null;
            }
            if (file == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("getFileFromUri(), failed to resize. (resizedFile is null)", this.TAG);
                }
                return null;
            }
        }
        Uri uriFromFile = Uri.fromFile(file);
        if (C4904y.f17872b) {
            C4904y.m18639b("getFileFromUri(), success. Uri is : " + uriFromFile, this.TAG);
            return uriFromFile;
        }
        return uriFromFile;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Activity attachedActivity;
        if (i2 == -1 && (attachedActivity = getAttachedActivity()) != null) {
            switch (i) {
                case 0:
                    if (C4904y.f17872b) {
                        C4904y.m18639b("REQ_CODE_SELECT_CAPTURE. start : " + this.f16288h, this.TAG);
                    }
                    if (this.f16288h != null) {
                        MediaScannerConnection.scanFile(attachedActivity, new String[]{this.f16288h.getPath()}, null, null);
                    }
                    Uri uriM17122a = m17122a(attachedActivity, this.f16288h);
                    if (uriM17122a != null) {
                        this.f16287g.onReceiveValue(uriM17122a);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("REQ_CODE_SELECT_CAPTURE. done : " + uriM17122a, this.TAG);
                        break;
                    }
                    break;
                case 1:
                    if (intent == null) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b("REQ_CODE_SELECT_GALLERY. intent is null", this.TAG);
                            break;
                        }
                    } else {
                        Uri data = intent.getData();
                        if (C4904y.f17872b) {
                            C4904y.m18639b("REQ_CODE_SELECT_GALLERY. start : " + data, this.TAG);
                        }
                        Uri uriM17122a2 = m17122a(attachedActivity, data);
                        if (uriM17122a2 != null) {
                            this.f16287g.onReceiveValue(uriM17122a2);
                        }
                        if (C4904y.f17872b) {
                            C4904y.m18639b("REQ_CODE_SELECT_GALLERY. done: " + uriM17122a2, this.TAG);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
