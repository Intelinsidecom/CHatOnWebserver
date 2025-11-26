package com.sec.chaton.multimedia.p078a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import com.sec.chaton.R;

/* compiled from: GlympseInstallDialog.java */
/* renamed from: com.sec.chaton.multimedia.a.a */
/* loaded from: classes.dex */
public class DialogC2719a extends Dialog {
    public DialogC2719a(Context context) {
        super(context, R.style.AppTheme_Dialog_Alert);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_glympse_install_dialog);
        ((Button) findViewById(R.id.google_play_button)).setOnClickListener(new ViewOnClickListenerC2720b(this));
        ((Button) findViewById(R.id.cancel_button)).setOnClickListener(new ViewOnClickListenerC2721c(this));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        dismiss();
    }
}
