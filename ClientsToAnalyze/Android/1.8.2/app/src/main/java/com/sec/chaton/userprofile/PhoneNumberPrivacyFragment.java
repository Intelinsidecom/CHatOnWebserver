package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0633e;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.C1805i;

/* loaded from: classes.dex */
public class PhoneNumberPrivacyFragment extends Fragment {

    /* renamed from: a */
    private TextView f5947a;

    /* renamed from: b */
    private CheckBox f5948b;

    /* renamed from: c */
    private ProgressDialog f5949c;

    /* renamed from: d */
    private C0633e f5950d;

    /* renamed from: e */
    private TextView f5951e;

    /* renamed from: f */
    private View.OnClickListener f5952f = new ViewOnClickListenerC1647ax(this);

    /* renamed from: g */
    private Handler f5953g = new HandlerC1648ay(this);

    /* renamed from: h */
    private View.OnClickListener f5954h = new ViewOnClickListenerC1649az(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_phone_number_privacy, viewGroup, false);
        String stringExtra = getActivity().getIntent().getStringExtra("extra_phone_number");
        this.f5947a = (TextView) viewInflate.findViewById(R.id.phone_number_text);
        this.f5947a.setText(stringExtra);
        this.f5948b = (CheckBox) viewInflate.findViewById(R.id.phone_number_checkbox);
        this.f5948b.setChecked(C1789u.m6075a().getBoolean("show_phone_number_to_all", false));
        this.f5948b.setOnClickListener(this.f5952f);
        this.f5951e = (TextView) viewInflate.findViewById(R.id.phone_number_privacy_message);
        if (C1789u.m6075a().getBoolean("show_phone_number_to_all", false)) {
            this.f5951e.setText(getResources().getString(R.string.phone_number_privacy_guide));
        } else {
            this.f5951e.setText(getResources().getString(R.string.phone_number_privacy_guide_off));
        }
        this.f5948b.setOnCheckedChangeListener(new C1646aw(this));
        ((Button) viewInflate.findViewById(R.id.btnSave)).setOnClickListener(this.f5954h);
        ((Button) viewInflate.findViewById(R.id.btnCancel)).setOnClickListener(this.f5954h);
        if (GlobalApplication.m3265f()) {
            getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getActivity().getWindow().setLayout(549, 306);
        }
        this.f5949c = (ProgressDialog) new C1805i(getActivity()).m6139a(R.string.dialog_userprofile_updating);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1786r.m6066e("onDestroy", getClass().getSimpleName());
        if (this.f5950d != null) {
            this.f5950d.m2879e();
        }
    }
}
