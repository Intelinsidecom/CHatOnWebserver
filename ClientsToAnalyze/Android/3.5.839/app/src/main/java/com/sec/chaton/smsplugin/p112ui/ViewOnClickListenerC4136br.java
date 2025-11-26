package com.sec.chaton.smsplugin.p112ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.sec.chaton.R;
import java.io.File;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.br */
/* loaded from: classes.dex */
class ViewOnClickListenerC4136br implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f15408a;

    /* renamed from: b */
    final /* synthetic */ C4132bn f15409b;

    ViewOnClickListenerC4136br(C4132bn c4132bn, String str) {
        this.f15409b = c4132bn;
        this.f15408a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15409b.f15392l.size() > 0) {
            String strTrim = this.f15409b.f15399t.getText().toString().trim();
            if (strTrim.length() <= 0) {
                if (this.f15409b.f15401v == null || (this.f15409b.f15401v.getView() != null && !this.f15409b.f15401v.getView().isShown())) {
                    this.f15409b.f15401v = Toast.makeText(this.f15409b.f15387c, R.string.empty_name, 0);
                    this.f15409b.f15401v.show();
                    return;
                }
                return;
            }
            File file = new File(C4132bn.f15385w.concat(strTrim).concat(this.f15408a == null ? "" : ".".concat(this.f15408a)));
            if (!TextUtils.isEmpty(strTrim)) {
                if (file.exists()) {
                    if (!((String) this.f15409b.f15392l.get(0)).equalsIgnoreCase(strTrim.concat(this.f15408a == null ? "" : ".".concat(this.f15408a)))) {
                        this.f15409b.f15394n.put(this.f15409b.f15392l.get(0), new File(C4132bn.f15385w.concat(strTrim.concat(this.f15408a == null ? "" : ".".concat(this.f15408a)))));
                    }
                } else {
                    this.f15409b.f15394n.put(this.f15409b.f15392l.get(0), new File(C4132bn.f15385w.concat(strTrim.concat(this.f15408a == null ? "" : ".".concat(this.f15408a)))));
                }
                C4132bn.f15383i = true;
            }
            C4132bn.m16356a();
        }
    }
}
