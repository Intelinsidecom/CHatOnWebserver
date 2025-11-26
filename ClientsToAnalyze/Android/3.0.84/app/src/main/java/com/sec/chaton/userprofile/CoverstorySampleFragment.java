package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1331i;
import com.sec.chaton.p027e.C1443k;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.p035io.entry.inner.CoverStorySample;
import com.sec.chaton.widget.C3263j;
import com.sec.common.p069e.C3326c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CoverstorySampleFragment extends Fragment implements InterfaceC3146o {

    /* renamed from: h */
    private static C3263j f11048h;

    /* renamed from: m */
    private static C1377u f11050m;

    /* renamed from: d */
    private View f11052d;

    /* renamed from: e */
    private GridView f11053e;

    /* renamed from: f */
    private C1331i f11054f;

    /* renamed from: g */
    private ProgressDialog f11055g;

    /* renamed from: i */
    private C3144m f11056i;

    /* renamed from: j */
    private C3326c f11057j;

    /* renamed from: l */
    private ArrayList<C3147p> f11058l;

    /* renamed from: n */
    private String f11059n;

    /* renamed from: c */
    private static String f11047c = CoverstorySampleFragment.class.getSimpleName();

    /* renamed from: k */
    private static Uri f11049k = C1443k.f5371a;

    /* renamed from: b */
    public static int f11046b = 1;

    /* renamed from: a */
    ArrayList<CoverStorySample> f11051a = new ArrayList<>();

    /* renamed from: o */
    private InterfaceC1378v f11060o = new C3149r(this);

    /* renamed from: p */
    private Handler f11061p = new HandlerC3150s(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11054f = new C1331i(this.f11061p);
        f11050m = new C1377u(getActivity().getContentResolver(), this.f11060o);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11052d = layoutInflater.inflate(R.layout.layout_mypage_cover_sample, (ViewGroup) null);
        this.f11053e = (GridView) this.f11052d.findViewById(R.id.cover_sample_gridview);
        f11048h = new C3263j(getActivity());
        this.f11055g = (ProgressDialog) f11048h.m11487a(R.string.dialog_provision_ing);
        this.f11057j = new C3326c();
        this.f11058l = new ArrayList<>();
        m10659c();
        return this.f11052d;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f11055g != null && this.f11055g.isShowing()) {
            this.f11055g.dismiss();
        }
        if (this.f11057j != null) {
            this.f11057j.m11731a();
        }
    }

    /* renamed from: c */
    private void m10659c() {
        if (this.f11055g != null) {
            this.f11055g.show();
        }
        this.f11054f.m5765d();
    }

    @Override // com.sec.chaton.userprofile.InterfaceC3146o
    /* renamed from: a */
    public void mo10663a(C3147p c3147p) {
        if (this.f11055g != null) {
            this.f11055g.show();
        }
        String string = Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width));
        String string2 = Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height));
        this.f11059n = c3147p.m10938a();
        this.f11054f.m5760a(c3147p.m10938a(), string, string2);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(getActivity());
        }
    }
}
