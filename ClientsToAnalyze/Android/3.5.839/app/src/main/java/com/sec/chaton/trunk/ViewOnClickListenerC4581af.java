package com.sec.chaton.trunk;

import android.text.TextUtils;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4847bl;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.af */
/* loaded from: classes.dex */
class ViewOnClickListenerC4581af implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16691a;

    ViewOnClickListenerC4581af(TrunkCommentView trunkCommentView) {
        this.f16691a = trunkCommentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!C4847bl.m18333a()) {
            int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
            if (-3 == iM10677a || -2 == iM10677a) {
                this.f16691a.f16452l.setText(R.string.popup_no_network_connection);
                this.f16691a.f16452l.setDuration(0);
                this.f16691a.f16452l.show();
                return;
            }
            if (TextUtils.isEmpty(this.f16691a.f16456p)) {
                TrunkDetailActivity trunkDetailActivity = (TrunkDetailActivity) this.f16691a.f16442b;
                if (trunkDetailActivity != null) {
                    this.f16691a.f16456p = trunkDetailActivity.f16459n;
                }
                if (this.f16691a.f16456p == null) {
                    C5179v.m19810a(this.f16691a.f16442b, R.string.download_progressing, 0).show();
                    return;
                }
            }
            this.f16691a.f16454n.mo17531a(this.f16691a.f16445e.getText().toString());
            this.f16691a.m17278b();
            this.f16691a.f16444d.hideSoftInputFromWindow(this.f16691a.f16445e.getWindowToken(), 0);
        }
    }
}
