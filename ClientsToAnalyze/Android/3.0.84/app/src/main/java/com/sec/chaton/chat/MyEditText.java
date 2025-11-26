package com.sec.chaton.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.widget.InterfaceC3689w;

/* loaded from: classes.dex */
public class MyEditText extends AdaptableEditText {

    /* renamed from: a */
    int f3775a;

    /* renamed from: b */
    private InterfaceC3689w f3776b;

    public MyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3775a = 0;
    }

    public MyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3775a = 0;
    }

    public MyEditText(Context context) {
        super(context);
        this.f3775a = 0;
    }

    public void setOnEditTextImeBackListener(InterfaceC3689w interfaceC3689w) {
        this.f3776b = interfaceC3689w;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.f3776b != null) {
            this.f3776b.mo5127a(this, getText().toString());
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    @Override // android.widget.EditText, android.widget.TextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTextContextMenuItem(int r8) {
        /*
            r7 = this;
            r4 = 0
            r0 = 16908322(0x1020022, float:2.3877324E-38)
            if (r8 != r0) goto Lc5
            java.lang.String r1 = ""
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r0 < r2) goto L71
            android.content.Context r0 = r7.getContext()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
            r0.getPrimaryClip()
            boolean r2 = r0.hasPrimaryClip()
            if (r2 == 0) goto La4
            android.content.ClipData r0 = r0.getPrimaryClip()
            android.content.ClipData$Item r0 = r0.getItemAt(r4)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
        L33:
            int r1 = r7.getSelectionStart()
            int r2 = r7.getSelectionEnd()
            android.content.Context r3 = r7.getContext()
            int r5 = r7.getLineHeight()
            float r5 = (float) r5
            r6 = 1067030938(0x3f99999a, float:1.2)
            float r5 = r5 * r6
            int r5 = (int) r5
            java.lang.CharSequence r3 = com.sec.chaton.multimedia.emoticon.C1835j.m7508a(r3, r0, r5)
            android.text.Editable r0 = r7.getText()
            int r0 = r0.length()
            int r5 = r3.length()
            int r0 = r0 + r5
            int r5 = r2 - r1
            int r0 = r0 - r5
            r5 = 10000(0x2710, float:1.4013E-41)
            if (r0 <= r5) goto La6
            android.content.Context r0 = com.sec.common.CommonApplication.m11493l()
            r1 = 2131427377(0x7f0b0031, float:1.8476369E38)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r4)
            r0.show()
        L6f:
            r0 = 1
        L70:
            return r0
        L71:
            android.content.Context r0 = r7.getContext()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.text.ClipboardManager r0 = (android.text.ClipboardManager) r0
            boolean r2 = r0.hasText()
            if (r2 == 0) goto La4
            java.lang.CharSequence r2 = r0.getText()
            if (r2 == 0) goto L93
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r1 = r0.toString()
            r0 = r1
            goto L33
        L93:
            boolean r0 = com.sec.chaton.util.C3250y.f11737e
            if (r0 == 0) goto La4
            java.lang.String r0 = "clipboard getText() is null"
            java.lang.Class r2 = r7.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r0, r2)
        La4:
            r0 = r1
            goto L33
        La6:
            android.text.Editable r0 = r7.getEditableText()
            if (r0 == 0) goto Lb7
            android.text.Editable r0 = r7.getEditableText()
            int r5 = r3.length()
            r0.replace(r1, r2, r3, r4, r5)
        Lb7:
            int r0 = r3.length()
            int r0 = r0 + r1
            int r2 = r3.length()
            int r1 = r1 + r2
            r7.setSelection(r0, r1)
            goto L6f
        Lc5:
            boolean r0 = super.onTextContextMenuItem(r8)
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.MyEditText.onTextContextMenuItem(int):boolean");
    }
}
