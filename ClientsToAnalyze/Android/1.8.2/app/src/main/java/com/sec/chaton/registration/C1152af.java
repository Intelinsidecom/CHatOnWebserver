package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.registration.ActivityRegist;

/* compiled from: ActivityRegist.java */
/* renamed from: com.sec.chaton.registration.af */
/* loaded from: classes.dex */
class C1152af implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityRegist.RegistFragment f4354a;

    C1152af(ActivityRegist.RegistFragment registFragment) {
        this.f4354a = registFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (GlobalApplication.m3265f()) {
            if (this.f4354a.f4217C == 0) {
                if (this.f4354a.f4245o.length() <= 0 || (this.f4354a.f4242l == null && this.f4354a.f4222H == null)) {
                    if (this.f4354a.f4216B != null) {
                        this.f4354a.f4216B.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(false);
                    }
                    if (this.f4354a.f4216B != null) {
                        this.f4354a.f4216B.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                    }
                    if (this.f4354a.f4253w != null) {
                        if (this.f4354a.f4253w.equals("US") || this.f4354a.f4253w.equals("JP")) {
                            if (this.f4354a.f4251u != null) {
                                this.f4354a.f4251u.setEnabled(false);
                            }
                            if (this.f4354a.f4250t != null) {
                                this.f4354a.f4250t.setEnabled(false);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f4354a.f4216B != null) {
                    this.f4354a.f4216B.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                }
                if (this.f4354a.f4216B != null) {
                    this.f4354a.f4216B.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(true);
                }
                if (this.f4354a.f4253w.equals("US") || this.f4354a.f4253w.equals("JP")) {
                    if (this.f4354a.f4251u != null) {
                        this.f4354a.f4251u.setEnabled(true);
                    }
                    if (this.f4354a.f4250t != null) {
                        this.f4354a.f4250t.setEnabled(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f4354a.f4217C == 1) {
                if (this.f4354a.f4245o == null || this.f4354a.f4245o.length() <= 0) {
                    if (this.f4354a.f4216B != null) {
                        this.f4354a.f4216B.findItem(R.id.actionbar_title_done).setVisible(false).setEnabled(true);
                    }
                    if (this.f4354a.f4216B != null) {
                        this.f4354a.f4216B.findItem(R.id.actionbar_title_done_dim).setVisible(true).setEnabled(false);
                        return;
                    }
                    return;
                }
                if (this.f4354a.f4216B != null) {
                    this.f4354a.f4216B.findItem(R.id.actionbar_title_done).setVisible(true).setEnabled(true);
                }
                if (this.f4354a.f4216B != null) {
                    this.f4354a.f4216B.findItem(R.id.actionbar_title_done_dim).setVisible(false).setEnabled(false);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f4354a.f4245o.length() <= 0 || (this.f4354a.f4217C != 1 && this.f4354a.f4242l == null)) {
            if (this.f4354a.f4249s != null) {
                this.f4354a.f4249s.setEnabled(false);
            }
            if (this.f4354a.f4253w.equals("US") || this.f4354a.f4253w.equals("JP")) {
                if (this.f4354a.f4251u != null) {
                    this.f4354a.f4251u.setEnabled(false);
                }
                if (this.f4354a.f4250t != null) {
                    this.f4354a.f4250t.setEnabled(false);
                    return;
                }
                return;
            }
            return;
        }
        if (this.f4354a.f4249s != null) {
            this.f4354a.f4249s.setEnabled(true);
        }
        if (this.f4354a.f4253w.equals("US") || this.f4354a.f4253w.equals("JP")) {
            if (this.f4354a.f4251u != null) {
                this.f4354a.f4251u.setEnabled(true);
            }
            if (this.f4354a.f4250t != null) {
                this.f4354a.f4250t.setEnabled(true);
            }
        }
    }
}
