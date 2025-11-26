package com.sec.chaton.smsplugin.p112ui;

import android.content.res.Resources;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;

/* compiled from: PluginComposeMessageActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gl */
/* loaded from: classes.dex */
class RunnableC4265gl implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C4264gk f15635a;

    RunnableC4265gl(C4264gk c4264gk) {
        this.f15635a = c4264gk;
    }

    @Override // java.lang.Runnable
    public void run() throws Resources.NotFoundException {
        String number;
        String string;
        this.f15635a.f15631a.f15005ay = this.f15635a.f15634d.m14308a();
        switch (this.f15635a.f15634d.size()) {
            case 0:
                if (this.f15635a.f15631a.f14954Z != null) {
                    String string2 = this.f15635a.f15631a.f14954Z.getText().toString();
                    if (TextUtils.isEmpty(string2)) {
                        string2 = this.f15635a.f15631a.getString(R.string.new_message);
                    }
                    string = string2;
                    number = null;
                    break;
                } else {
                    string = this.f15635a.f15631a.getString(R.string.unknown_sender);
                    number = null;
                    break;
                }
            case 1:
                C3782a c3782a = this.f15635a.f15634d.get(0);
                String strM14264f = c3782a.m14264f();
                if (c3782a.m14265g()) {
                    number = null;
                    string = strM14264f;
                    break;
                } else {
                    String strM14262d = c3782a.m14262d();
                    number = PhoneNumberUtils.formatNumber(strM14262d, strM14262d, GlobalApplication.m10279a().m10297l());
                    string = strM14264f;
                    break;
                }
            default:
                string = this.f15635a.f15634d.m14310b(", ");
                number = this.f15635a.f15631a.getResources().getString(R.string.recipients_count, Integer.valueOf(this.f15635a.f15634d.size()));
                break;
        }
        if (C3847e.m14651aB()) {
            if (TextUtils.isEmpty(this.f15635a.f15631a.m16022ay()) || this.f15635a.f15631a.m15878E()) {
                this.f15635a.f15631a.m16016as();
                this.f15635a.f15631a.m16018au();
                this.f15635a.f15631a.m16021ax();
            } else {
                this.f15635a.f15631a.m16015ar();
            }
        }
        if (!TextUtils.isEmpty(number) || !this.f15635a.f15632b) {
            this.f15635a.f15631a.f15025bb.setVisibility(0);
            if (TextUtils.isEmpty(number)) {
                this.f15635a.f15631a.f15026bc.setVisibility(8);
            } else {
                this.f15635a.f15631a.f15026bc.setText(number);
                this.f15635a.f15631a.f15026bc.setVisibility(0);
            }
            if (this.f15635a.f15632b) {
                this.f15635a.f15631a.f15027bd.setVisibility(8);
            } else {
                this.f15635a.f15631a.f15027bd.setVisibility(0);
            }
        } else {
            this.f15635a.f15631a.f15025bb.setVisibility(8);
        }
        this.f15635a.f15631a.f15024ba.setText(string);
        this.f15635a.f15631a.f14980aZ.requestLayout();
    }
}
