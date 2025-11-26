package com.sec.chaton.util.account;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class AccountData {

    /* renamed from: a */
    private String f3756a;

    /* renamed from: b */
    private String f3757b;

    /* renamed from: c */
    private CharSequence f3758c;

    /* renamed from: d */
    private Drawable f3759d;

    public AccountData(Context context, String str, String str2, String str3, int i, int i2) {
        this.f3756a = str;
        this.f3757b = str2;
        PackageManager packageManager = context.getPackageManager();
        if (i != 0) {
            this.f3758c = packageManager.getText(str3, i, null);
            if (this.f3758c == null) {
                throw new IllegalArgumentException("LabelID provided, but label not found");
            }
        } else {
            this.f3758c = "";
        }
        if (i2 == 0) {
            this.f3759d = context.getResources().getDrawable(R.drawable.sym_def_app_icon);
            return;
        }
        this.f3759d = packageManager.getDrawable(str3, i2, null);
        if (this.f3759d == null) {
            throw new IllegalArgumentException("IconID provided, but drawable not found");
        }
    }

    /* renamed from: a */
    public String m3684a() {
        return this.f3756a;
    }

    /* renamed from: b */
    public String m3685b() {
        return this.f3757b;
    }

    /* renamed from: c */
    public CharSequence m3686c() {
        return this.f3758c;
    }

    /* renamed from: d */
    public Drawable m3687d() {
        return this.f3759d;
    }

    public String toString() {
        return this.f3756a;
    }
}
