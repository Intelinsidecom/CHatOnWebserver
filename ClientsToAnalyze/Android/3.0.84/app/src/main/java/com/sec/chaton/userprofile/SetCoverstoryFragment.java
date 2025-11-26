package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.poston.C1960a;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.p069e.C3326c;
import com.sec.common.p069e.InterfaceC3329f;

/* loaded from: classes.dex */
public class SetCoverstoryFragment extends Fragment implements InterfaceC3329f {

    /* renamed from: b */
    private static String f11267b = SetCoverstoryFragment.class.getSimpleName();

    /* renamed from: n */
    private static C3263j f11268n;

    /* renamed from: c */
    private View f11270c;

    /* renamed from: d */
    private View f11271d;

    /* renamed from: e */
    private ImageView f11272e;

    /* renamed from: f */
    private Button f11273f;

    /* renamed from: g */
    private C3326c f11274g;

    /* renamed from: h */
    private String f11275h;

    /* renamed from: i */
    private String f11276i;

    /* renamed from: j */
    private String f11277j;

    /* renamed from: k */
    private String f11278k;

    /* renamed from: l */
    private boolean f11279l;

    /* renamed from: m */
    private ProgressDialog f11280m;

    /* renamed from: o */
    private C1331i f11281o;

    /* renamed from: p */
    private final String f11282p = "updated";

    /* renamed from: q */
    private final String f11283q = "coverstory_sample_changed";

    /* renamed from: r */
    private final String f11284r = "coverstory_not_changed";

    /* renamed from: a */
    View.OnClickListener f11269a = new ViewOnClickListenerC3131cc(this);

    /* renamed from: s */
    private Handler f11285s = new HandlerC3132cd(this);

    public SetCoverstoryFragment(String str, String str2, String str3, boolean z) {
        this.f11276i = str;
        this.f11277j = str3 + ".jpg";
        this.f11278k = str3;
        this.f11279l = z;
        if (C3250y.f11734b && str2 != null && str3 != null && str != null) {
            C3250y.m11450b("SetCoverstoryFragment url : " + str + ", filename : " + str2 + ", id : " + str3, getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        this.f11270c = layoutInflater.inflate(R.layout.layout_mypage_cover_imageview, (ViewGroup) null);
        this.f11272e = (ImageView) this.f11270c.findViewById(R.id.coverstory_image_view);
        String string = getResources().getString(R.string.mypage_set_as_coverstory);
        this.f11271d = this.f11270c.findViewById(R.id.coverstory_set_button);
        this.f11273f = (Button) this.f11271d.findViewById(R.id.button1);
        this.f11273f.setText(string);
        this.f11273f.setOnClickListener(this.f11269a);
        this.f11273f.setEnabled(false);
        f11268n = new C3263j(getActivity());
        this.f11280m = (ProgressDialog) f11268n.m11487a(R.string.mypage_wait_saving);
        this.f11274g = new C3326c();
        this.f11274g.m11735a(this);
        this.f11275h = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        C3250y.m11450b("SetCoverstoryFragment [dirInternalPath] : " + this.f11275h, getClass().getSimpleName());
        m10879b();
        return this.f11270c;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (f11268n == null) {
            f11268n = new C3263j(getActivity());
        }
        if (this.f11280m == null) {
            this.f11280m = (ProgressDialog) f11268n.m11487a(R.string.mypage_wait_saving);
        }
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(getActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f11280m != null && this.f11280m.isShowing()) {
            this.f11280m.dismiss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f11274g != null) {
            this.f11274g.m11731a();
        }
    }

    /* renamed from: b */
    private void m10879b() {
        if (C3250y.f11734b) {
            C3250y.m11450b("EXTRA_NAME_URL : " + this.f11276i + " / EXTRA_NAME_FILENAME : " + this.f11277j + " / SetCoverstoryActivity.EXTRA_NAME_ID : " + this.f11278k, f11267b);
        }
        this.f11274g.m11730a(this.f11272e, new C1960a(this.f11276i, null, C1960a.f7635a, getActivity(), this.f11275h, this.f11277j, this.f11278k));
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: b */
    public void mo3722b(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        if (!this.f11279l) {
            this.f11273f.setEnabled(true);
        } else {
            this.f11273f.setEnabled(false);
        }
        Log.d("CoverStoryDispatcherTask success", getClass().getSimpleName());
    }

    @Override // com.sec.common.p069e.InterfaceC3329f
    /* renamed from: a */
    public void mo3713a(View view, AbstractRunnableC3324a<?> abstractRunnableC3324a) {
        Log.d("CoverStoryDispatcherTask fail", getClass().getSimpleName());
    }
}
