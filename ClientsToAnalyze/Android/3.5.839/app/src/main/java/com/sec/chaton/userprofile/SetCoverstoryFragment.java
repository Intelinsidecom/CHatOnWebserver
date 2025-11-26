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
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.poston.C2955a;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.p132g.C5007c;
import com.sec.common.p132g.InterfaceC5010f;

/* loaded from: classes.dex */
public class SetCoverstoryFragment extends Fragment implements InterfaceC5010f {

    /* renamed from: b */
    private static String f17359b = SetCoverstoryFragment.class.getSimpleName();

    /* renamed from: n */
    private static C4923p f17360n;

    /* renamed from: c */
    private View f17362c;

    /* renamed from: d */
    private View f17363d;

    /* renamed from: e */
    private ImageView f17364e;

    /* renamed from: f */
    private Button f17365f;

    /* renamed from: g */
    private C5007c f17366g;

    /* renamed from: h */
    private String f17367h;

    /* renamed from: i */
    private String f17368i;

    /* renamed from: j */
    private String f17369j;

    /* renamed from: k */
    private String f17370k;

    /* renamed from: l */
    private boolean f17371l;

    /* renamed from: m */
    private ProgressDialog f17372m;

    /* renamed from: o */
    private C2130k f17373o;

    /* renamed from: p */
    private final String f17374p = "updated";

    /* renamed from: q */
    private final String f17375q = "coverstory_sample_changed";

    /* renamed from: r */
    private final String f17376r = "coverstory_not_changed";

    /* renamed from: a */
    View.OnClickListener f17361a = new ViewOnClickListenerC4781cm(this);

    /* renamed from: s */
    private Handler f17377s = new HandlerC4782cn(this);

    public SetCoverstoryFragment(String str, String str2, String str3, boolean z) {
        this.f17368i = str;
        this.f17369j = str3 + ".jpg";
        this.f17370k = str3;
        this.f17371l = z;
        if (C4904y.f17872b && str2 != null && str3 != null && str != null) {
            C4904y.m18639b("SetCoverstoryFragment url : " + str + ", filename : " + str2 + ", id : " + str3, getClass().getSimpleName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public SetCoverstoryFragment() {
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mUrl", this.f17368i);
        bundle.putString("mFileName", this.f17369j);
        bundle.putString("mId", this.f17370k);
        bundle.putBoolean("mIsCurrentCoverstory", this.f17371l);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        if (bundle != null) {
            this.f17368i = bundle.getString("mUrl");
            this.f17369j = bundle.getString("mFileName");
            this.f17370k = bundle.getString("mId");
            this.f17371l = bundle.getBoolean("mIsCurrentCoverstory");
        }
        this.f17362c = layoutInflater.inflate(R.layout.layout_mypage_cover_imageview, (ViewGroup) null);
        this.f17364e = (ImageView) this.f17362c.findViewById(R.id.coverstory_image_view);
        String string = getResources().getString(R.string.mypage_set_as_coverstory);
        this.f17363d = this.f17362c.findViewById(R.id.coverstory_set_button);
        this.f17365f = (Button) this.f17363d.findViewById(R.id.button1);
        this.f17365f.setText(string);
        this.f17365f.setOnClickListener(this.f17361a);
        this.f17365f.setEnabled(false);
        f17360n = new C4923p(getActivity());
        this.f17372m = (ProgressDialog) f17360n.m18724a(R.string.mypage_wait_saving);
        this.f17366g = new C5007c();
        this.f17366g.m19019a((InterfaceC5010f) this);
        this.f17367h = getActivity().getApplicationContext().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/coverstory/random/";
        C4904y.m18639b("SetCoverstoryFragment [dirInternalPath] : " + this.f17367h, getClass().getSimpleName());
        m18035b();
        return this.f17362c;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (f17360n == null) {
            f17360n = new C4923p(getActivity());
        }
        if (this.f17372m == null) {
            this.f17372m = (ProgressDialog) f17360n.m18724a(R.string.mypage_wait_saving);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f17372m != null && this.f17372m.isShowing()) {
            this.f17372m.dismiss();
        }
        if (this.f17373o != null) {
            this.f17373o.m9547f();
            this.f17373o = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f17366g != null) {
            this.f17366g.m19014a();
        }
    }

    /* renamed from: b */
    private void m18035b() {
        if (C4904y.f17872b) {
            C4904y.m18639b("EXTRA_NAME_URL : " + this.f17368i + " / EXTRA_NAME_FILENAME : " + this.f17369j + " / SetCoverstoryActivity.EXTRA_NAME_ID : " + this.f17370k, f17359b);
        }
        this.f17366g.m19023b(this.f17364e, new C2955a(this.f17368i, null, C2955a.f11032a, getActivity(), this.f17367h, this.f17369j, this.f17370k));
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: b */
    public void mo6860b(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        if (!this.f17371l) {
            this.f17365f.setEnabled(true);
        } else {
            this.f17365f.setEnabled(false);
        }
        Log.d("CoverStoryDispatcherTask success", getClass().getSimpleName());
    }

    @Override // com.sec.common.p132g.InterfaceC5010f
    /* renamed from: a */
    public void mo6852a(View view, AbstractRunnableC5005a<?> abstractRunnableC5005a) {
        Log.d("CoverStoryDispatcherTask fail", getClass().getSimpleName());
    }
}
