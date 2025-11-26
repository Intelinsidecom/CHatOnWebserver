package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2130k;
import com.sec.chaton.p057e.C2291k;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.p065io.entry.inner.CoverStorySample;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.widget.C4923p;
import com.sec.common.p132g.C5007c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CoverstorySampleFragment extends Fragment implements InterfaceC4791j {

    /* renamed from: h */
    private static C4923p f17104h;

    /* renamed from: m */
    private static C2210x f17106m;

    /* renamed from: d */
    private View f17108d;

    /* renamed from: e */
    private GridView f17109e;

    /* renamed from: f */
    private C2130k f17110f;

    /* renamed from: g */
    private ProgressDialog f17111g;

    /* renamed from: i */
    private C4789h f17112i;

    /* renamed from: j */
    private C5007c f17113j;

    /* renamed from: l */
    private ArrayList<C4792k> f17114l;

    /* renamed from: n */
    private String f17115n;

    /* renamed from: c */
    private static String f17103c = CoverstorySampleFragment.class.getSimpleName();

    /* renamed from: k */
    private static Uri f17105k = C2291k.f8198a;

    /* renamed from: b */
    public static int f17102b = 1;

    /* renamed from: a */
    ArrayList<CoverStorySample> f17107a = new ArrayList<>();

    /* renamed from: o */
    private InterfaceC2211y f17116o = new C4794m(this);

    /* renamed from: p */
    private Handler f17117p = new HandlerC4795n(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17110f = new C2130k(this.f17117p);
        f17106m = new C2210x(getActivity().getContentResolver(), this.f17116o);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17108d = layoutInflater.inflate(R.layout.layout_mypage_cover_sample, (ViewGroup) null);
        this.f17109e = (GridView) this.f17108d.findViewById(R.id.cover_sample_gridview);
        f17104h = new C4923p(getActivity());
        this.f17111g = (ProgressDialog) f17104h.m18724a(R.string.dialog_provision_ing);
        this.f17113j = new C5007c();
        this.f17114l = new ArrayList<>();
        m17813c();
        return this.f17108d;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f17111g != null && this.f17111g.isShowing()) {
            this.f17111g.dismiss();
        }
        if (this.f17113j != null) {
            this.f17113j.m19014a();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f17110f != null) {
            this.f17110f.m9545d();
            this.f17110f.m9546e();
            this.f17110f = null;
        }
        super.onDestroy();
    }

    /* renamed from: c */
    private void m17813c() {
        if (this.f17111g != null) {
            this.f17111g.show();
        }
        this.f17110f.m9544c();
    }

    @Override // com.sec.chaton.userprofile.InterfaceC4791j
    /* renamed from: a */
    public void mo17817a(C4792k c4792k) {
        int iM10677a = C2471v.m10677a(getActivity().getApplicationContext());
        if (-3 == iM10677a || -2 == iM10677a) {
            Toast.makeText(getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        if (this.f17111g != null) {
            this.f17111g.show();
        }
        String string = Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_width));
        String string2 = Integer.toString(getResources().getDimensionPixelOffset(R.dimen.coverstory_sample_image_height));
        this.f17115n = c4792k.m18086a();
        this.f17110f.m9540a(c4792k.m18086a(), string, string2);
    }
}
