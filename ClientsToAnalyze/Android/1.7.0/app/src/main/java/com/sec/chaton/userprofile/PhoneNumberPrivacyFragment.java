package com.sec.chaton.userprofile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.GeneralHeaderView;

/* loaded from: classes.dex */
public class PhoneNumberPrivacyFragment extends Fragment {

    /* renamed from: a */
    private View f4165a;

    /* renamed from: b */
    private TextView f4166b;

    /* renamed from: c */
    private CheckBox f4167c;

    /* renamed from: d */
    private ProgressDialog f4168d;

    /* renamed from: e */
    private TextView f4169e;

    /* renamed from: f */
    private GeneralHeaderView f4170f;

    /* renamed from: g */
    private View.OnClickListener f4171g = new ViewOnClickListenerC1213aj(this);

    /* renamed from: h */
    private Handler f4172h = new HandlerC1212ai(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_setting_phone_number_privacy, viewGroup, false);
        String stringExtra = getActivity().getIntent().getStringExtra("extra_phone_number");
        this.f4165a = viewInflate.findViewById(R.id.phone_number_layout);
        this.f4165a.setOnClickListener(this.f4171g);
        this.f4166b = (TextView) viewInflate.findViewById(R.id.phone_number_text);
        this.f4166b.setText(stringExtra);
        this.f4167c = (CheckBox) viewInflate.findViewById(R.id.phone_number_checkbox);
        this.f4167c.setChecked(C1323bs.m4575a().getBoolean("show_phone_number_to_all", false));
        this.f4169e = (TextView) viewInflate.findViewById(R.id.phone_number_privacy_string);
        if (this.f4167c.isChecked()) {
            this.f4169e.setText(R.string.phone_number_privacy_guide);
        } else {
            this.f4169e.setText(R.string.phone_number_privacy_guide_off);
        }
        this.f4170f = (GeneralHeaderView) viewInflate.findViewById(R.id.phone_headerView);
        this.f4170f.setButtonClickListener(new ViewOnClickListenerC1215al(this));
        this.f4170f.setButtonEnabled(false);
        this.f4167c.setOnCheckedChangeListener(new C1214ak(this));
        this.f4168d = (ProgressDialog) new C1356c(getActivity()).m4728a(R.string.dialog_userprofile_updating);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f4168d.dismiss();
    }
}
