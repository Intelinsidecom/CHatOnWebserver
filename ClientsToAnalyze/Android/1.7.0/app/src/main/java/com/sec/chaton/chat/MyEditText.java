package com.sec.chaton.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.sec.chaton.multimedia.p034a.C0760c;

/* loaded from: classes.dex */
public class MyEditText extends EditText {

    /* renamed from: a */
    int f1868a;

    public MyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1868a = 0;
    }

    public MyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1868a = 0;
    }

    public MyEditText(Context context) {
        super(context);
        this.f1868a = 0;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        int iM2708a = m2708a(i, getText().toString(), true);
        int iM2708a2 = m2708a(i2, getText().toString(), false);
        if (iM2708a != -1 || iM2708a2 != -1) {
            setSelection(iM2708a == -1 ? i : iM2708a, iM2708a2 == -1 ? i2 : iM2708a2);
            if (iM2708a != -1) {
                i = iM2708a;
            }
            if (iM2708a2 != -1) {
                i2 = iM2708a2;
            }
        }
        super.onSelectionChanged(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    @Override // android.widget.EditText, android.widget.TextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTextContextMenuItem(int r6) {
        /*
            r5 = this;
            r0 = 16908322(0x1020022, float:2.3877324E-38)
            if (r6 != r0) goto L6a
            java.lang.String r1 = ""
            int r0 = com.sec.chaton.p029f.C0684a.f2330a
            r2 = 11
            if (r0 < r2) goto L4f
            android.content.Context r0 = r5.getContext()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
            r0.getPrimaryClip()
            boolean r2 = r0.hasPrimaryClip()
            if (r2 == 0) goto L6f
            android.content.ClipData r0 = r0.getPrimaryClip()
            r1 = 0
            android.content.ClipData$Item r0 = r0.getItemAt(r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
        L33:
            com.sec.chaton.multimedia.a.c r1 = new com.sec.chaton.multimedia.a.c
            android.content.Context r2 = r5.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = r5.getLineHeight()
            float r3 = (float) r3
            r4 = 1067030938(0x3f99999a, float:1.2)
            float r3 = r3 * r4
            int r3 = (int) r3
            r1.<init>(r2, r0, r3)
            r1.m3202a(r5)
            r0 = 1
        L4e:
            return r0
        L4f:
            android.content.Context r0 = r5.getContext()
            java.lang.String r2 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.text.ClipboardManager r0 = (android.text.ClipboardManager) r0
            boolean r2 = r0.hasText()
            if (r2 == 0) goto L6f
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            goto L33
        L6a:
            boolean r0 = super.onTextContextMenuItem(r6)
            goto L4e
        L6f:
            r0 = r1
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.MyEditText.onTextContextMenuItem(int):boolean");
    }

    /* renamed from: a */
    private int m2708a(int i, String str, boolean z) {
        int iIndexOf;
        int iLastIndexOf = str.substring(0, i).lastIndexOf(91);
        if (iLastIndexOf == -1) {
            return -1;
        }
        for (String str2 : C0760c.f2589a) {
            try {
                iIndexOf = str.indexOf(str2, iLastIndexOf);
            } catch (Exception e) {
                e.printStackTrace();
                iIndexOf = -1;
            }
            if (iIndexOf != -1 && i > iIndexOf && i < str2.length() + iIndexOf) {
                return z ? iIndexOf : str2.length() + iIndexOf;
            }
        }
        return -1;
    }
}
