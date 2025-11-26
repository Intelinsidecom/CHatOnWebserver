package com.sec.chaton.userprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;

/* loaded from: classes.dex */
public class CoverstoryUserGuideFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    private View f11062a;

    /* renamed from: b */
    private ImageView f11063b;

    /* renamed from: c */
    private LinearLayout f11064c;

    /* renamed from: d */
    private TextView f11065d;

    /* renamed from: e */
    private TextView f11066e;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11062a = layoutInflater.inflate(R.layout.layout_mypage_user_guide, viewGroup, false);
        m10664b();
        return this.f11062a;
    }

    /* renamed from: b */
    private void m10664b() {
        this.f11064c = (LinearLayout) this.f11062a.findViewById(R.id.layout_mypage_user_guide_page);
        this.f11063b = (ImageView) this.f11062a.findViewById(R.id.coverstory_user_guide_close);
        this.f11065d = (TextView) this.f11062a.findViewById(R.id.coverstory_user_guide_text);
        this.f11065d.setText(Html.fromHtml("<i>" + getResources().getString(R.string.mypage_coverstory_user_guide) + "</i>"));
        this.f11066e = (TextView) this.f11062a.findViewById(R.id.coverstory_poston_guide_text);
        this.f11066e.setText(Html.fromHtml("<i>" + getResources().getString(R.string.mypage_coverstory_poston_guide) + "</i>"));
        this.f11063b.setOnClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        m10664b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.coverstory_user_guide_close /* 2131166097 */:
                C3159aa.m10962a().m10983b("coverstory_user_guide_popup", (Boolean) false);
                getActivity().finish();
                break;
        }
    }

    /* renamed from: a */
    public void m10665a() {
        if (this.f11064c != null) {
            this.f11064c.setVisibility(8);
            this.f11064c = null;
        }
        if (this.f11063b != null) {
            this.f11063b.setImageBitmap(null);
            this.f11063b = null;
        }
        C3159aa.m10962a().m10983b("coverstory_user_guide_popup", (Boolean) false);
    }
}
