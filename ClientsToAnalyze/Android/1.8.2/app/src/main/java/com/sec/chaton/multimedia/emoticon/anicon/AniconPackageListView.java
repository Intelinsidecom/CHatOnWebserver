package com.sec.chaton.multimedia.emoticon.anicon;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.p030a.C0910a;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0913c;
import com.sec.chaton.multimedia.emoticon.p030a.p031a.C0914d;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.chaton.p022h.C0809s;
import com.sec.chaton.settings.ActivitySettings;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.common.p056b.p061e.C1830a;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;

/* loaded from: classes.dex */
public class AniconPackageListView extends Fragment implements InterfaceC0938u {

    /* renamed from: a */
    private static final String f3435a = AniconPackageListView.class.getSimpleName();

    /* renamed from: b */
    private Activity f3436b;

    /* renamed from: c */
    private ListView f3437c;

    /* renamed from: d */
    private ProgressDialog f3438d;

    /* renamed from: e */
    private ProgressDialog f3439e;

    /* renamed from: f */
    private AlertDialog f3440f;

    /* renamed from: g */
    private C0910a f3441g;

    /* renamed from: h */
    private C0913c f3442h;

    /* renamed from: i */
    private C0914d f3443i;

    /* renamed from: j */
    private C0934q f3444j;

    /* renamed from: k */
    private Cursor f3445k;

    /* renamed from: l */
    private String f3446l;

    /* renamed from: m */
    private String f3447m;

    /* renamed from: n */
    private File f3448n;

    /* renamed from: o */
    private C1821b f3449o;

    /* renamed from: p */
    private Handler f3450p = new HandlerC0939v(this);

    /* renamed from: q */
    private boolean f3451q;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3441g = new C0910a(this.f3436b, this.f3450p);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_packagelist_view, viewGroup, false);
        this.f3437c = (ListView) viewInflate.findViewById(R.id.anicon_package_list);
        this.f3449o = new C1821b();
        m3739c();
        this.f3442h = this.f3441g.m3669a("0", "zip", 240);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f3445k != null) {
            this.f3445k.close();
        }
        if (this.f3442h != null) {
            this.f3442h.m2710c();
        }
        if (this.f3448n != null && this.f3448n.exists()) {
            this.f3448n.delete();
        }
        if (this.f3449o != null) {
            this.f3449o.m6191a();
        }
        if (this.f3444j != null) {
            this.f3444j.m3803a((InterfaceC0938u) null);
            this.f3444j.changeCursor(null);
        }
        if (this.f3438d != null && this.f3438d.isShowing()) {
            m3744d();
            m3754i();
        }
        try {
            m3748f();
        } catch (Exception e) {
            C1786r.m6054a("Caught Exception while dismissing dialog", getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3436b = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f3436b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Cursor m3736b() {
        return this.f3436b.getContentResolver().query(C0952g.f3515a, null, null, null, C1828c.m6207a("install", ",", "special", " DESC,", "_id", " DESC"));
    }

    /* renamed from: c */
    private void m3739c() {
        if (this.f3438d == null) {
            this.f3438d = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_geo_loading);
            this.f3438d.setProgressStyle(0);
            this.f3438d.setMessage(getResources().getString(R.string.dialog_connecting_server));
            this.f3438d.setCancelable(true);
            this.f3438d.setCanceledOnTouchOutside(false);
            this.f3438d.setOnCancelListener(new DialogInterfaceOnCancelListenerC0940w(this));
        }
        if (!this.f3438d.isShowing()) {
            this.f3438d.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m3744d() {
        if (this.f3438d != null && this.f3438d.isShowing()) {
            this.f3438d.dismiss();
        }
    }

    /* renamed from: e */
    private void m3746e() throws Resources.NotFoundException {
        if (this.f3439e == null) {
            this.f3439e = new ProgressDialog(new ContextThemeWrapper(this.f3436b, R.style.CustomProgressDialogtheme));
            this.f3439e.setProgressStyle(1);
            this.f3439e.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_custom));
            this.f3439e.setTitle(this.f3436b.getResources().getString(R.string.media_file_download));
            this.f3439e.setButton(this.f3436b.getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC0941x(this));
            this.f3439e.setOnCancelListener(new DialogInterfaceOnCancelListenerC0942y(this));
        }
        if (!this.f3439e.isShowing()) {
            this.f3439e.show();
            this.f3439e.setProgress(0);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3748f() {
        if (this.f3439e != null && this.f3439e.isShowing()) {
            this.f3439e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3750g() throws Resources.NotFoundException {
        m3752h();
        if (this.f3440f == null) {
            Resources resources = this.f3436b.getResources();
            String string = resources.getString(R.string.toast_error);
            String string2 = resources.getString(R.string.setting_selfsms_retry);
            String string3 = resources.getString(R.string.dialog_cancel);
            String string4 = resources.getString(R.string.anicon_file_download_fail);
            AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this.f3436b);
            alertDialogBuilderC2120a.setTitle(string);
            alertDialogBuilderC2120a.setMessage(string4);
            alertDialogBuilderC2120a.setPositiveButton(string3, (DialogInterface.OnClickListener) null);
            alertDialogBuilderC2120a.setNegativeButton(string2, new DialogInterfaceOnClickListenerC0943z(this));
            this.f3440f = alertDialogBuilderC2120a.create();
        }
        if (!this.f3440f.isShowing()) {
            this.f3440f.setMessage(this.f3436b.getString(m3725a(R.string.anicon_file_download_fail)));
            this.f3440f.show();
        }
    }

    /* renamed from: h */
    private void m3752h() {
        if (this.f3440f != null && this.f3440f.isShowing()) {
            this.f3440f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3742c(String str) throws Resources.NotFoundException {
        m3746e();
        this.f3443i = this.f3441g.m3670b(str, "png", 240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3754i() {
        if (this.f3443i == null || this.f3443i.m2711d()) {
            C1830a.m6211a().m6216a(this.f3450p, this.f3447m);
        } else {
            this.f3443i.m2710c();
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.InterfaceC0938u
    /* renamed from: a */
    public void mo3763a(String str) {
        AniconPackageDetailActivity aniconPackageDetailActivity = new AniconPackageDetailActivity();
        Bundle bundle = new Bundle();
        bundle.putString("ANICON_PACKAGE_ID", str);
        aniconPackageDetailActivity.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, aniconPackageDetailActivity, "container").addToBackStack(ActivitySettings.f4559g).commit();
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.InterfaceC0938u
    /* renamed from: b */
    public void mo3764b(String str) throws Resources.NotFoundException {
        m3742c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m3725a(int i) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 == iM3420a || -2 == iM3420a) {
            return R.string.popup_no_network_connection;
        }
        return i;
    }
}
