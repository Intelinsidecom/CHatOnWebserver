package com.sec.chaton.trunk;

import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: TrunkCommentView.java */
/* renamed from: com.sec.chaton.trunk.ae */
/* loaded from: classes.dex */
class C4580ae implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ TrunkCommentView f16690a;

    C4580ae(TrunkCommentView trunkCommentView) {
        this.f16690a = trunkCommentView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f16690a.f16446f = (ImageButton) this.f16690a.f16442b.findViewById(R.id.button2);
        if (this.f16690a.f16446f.isEnabled()) {
            this.f16690a.f16446f.performClick();
        }
        return true;
    }
}
