package com.sec.chaton.smsplugin.p112ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.sec.chaton.chat.MyEditText;

@TargetApi(14)
/* loaded from: classes.dex */
public class MmsMyEditText extends MyEditText {
    public MmsMyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MmsMyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MmsMyEditText(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a8  */
    @Override // com.sec.chaton.chat.MyEditText, android.widget.EditText, android.widget.TextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTextContextMenuItem(int r9) {
        /*
            r8 = this;
            r7 = 2131427568(0x7f0b00f0, float:1.8476756E38)
            r4 = 0
            r0 = 16908322(0x1020022, float:2.3877324E-38)
            if (r9 != r0) goto Lde
            java.lang.String r1 = ""
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r0 < r2) goto L73
            android.content.Context r0 = r8.getContext()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
            r0.getPrimaryClip()
            boolean r2 = r0.hasPrimaryClip()
            if (r2 == 0) goto La8
            android.content.ClipData r0 = r0.getPrimaryClip()
            android.content.ClipData$Item r0 = r0.getItemAt(r4)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
        L38:
            int r1 = r8.getSelectionStart()
            int r2 = r8.getSelectionEnd()
            android.content.Context r3 = r8.getContext()
            int r5 = r8.getLineHeight()
            float r5 = (float) r5
            r6 = 1067030938(0x3f99999a, float:1.2)
            float r5 = r5 * r6
            int r5 = (int) r5
            java.lang.CharSequence r3 = com.sec.chaton.multimedia.emoticon.C2799k.m11709a(r3, r0, r5)
            android.text.Editable r0 = r8.getText()
            int r0 = r0.length()
            int r5 = r3.length()
            int r0 = r0 + r5
            int r5 = r2 - r1
            int r0 = r0 - r5
            r5 = 10000(0x2710, float:1.4013E-41)
            if (r0 <= r5) goto Laa
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r7, r4)
            r0.show()
        L71:
            r0 = 1
        L72:
            return r0
        L73:
            android.content.Context r0 = r8.getContext()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.text.ClipboardManager r0 = (android.text.ClipboardManager) r0
            boolean r2 = r0.hasText()
            if (r2 == 0) goto La8
            java.lang.CharSequence r2 = r0.getText()
            if (r2 == 0) goto L96
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r1 = r0.toString()
            r0 = r1
            goto L38
        L96:
            boolean r0 = com.sec.chaton.util.C4904y.f17875e
            if (r0 == 0) goto La8
            java.lang.String r0 = "clipboard getText() is null"
            java.lang.Class r2 = r8.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C4904y.m18634a(r0, r2)
        La8:
            r0 = r1
            goto L38
        Laa:
            android.text.Editable r0 = r8.getEditableText()
            if (r0 == 0) goto Lbb
            android.text.Editable r0 = r8.getEditableText()
            int r5 = r3.length()
            r0.replace(r1, r2, r3, r4, r5)
        Lbb:
            int r0 = r3.length()
            int r0 = r0 + r1
            r2 = 2000(0x7d0, float:2.803E-42)
            if (r0 <= r2) goto Ld0
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r7, r4)
            r0.show()
            goto L71
        Ld0:
            int r0 = r3.length()
            int r0 = r0 + r1
            int r2 = r3.length()
            int r1 = r1 + r2
            r8.setSelection(r0, r1)
            goto L71
        Lde:
            boolean r0 = super.onTextContextMenuItem(r9)
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.widget.MmsMyEditText.onTextContextMenuItem(int):boolean");
    }
}
