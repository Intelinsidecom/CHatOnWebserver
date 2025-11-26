package com.sec.chaton.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.sec.chaton.widget.AdaptableEditText;
import com.sec.widget.InterfaceC5167j;

/* loaded from: classes.dex */
public class MyEditText extends AdaptableEditText {

    /* renamed from: a */
    int f5829a;

    /* renamed from: b */
    private InterfaceC5167j f5830b;

    public MyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5829a = 0;
    }

    public MyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5829a = 0;
    }

    public MyEditText(Context context) {
        super(context);
        this.f5829a = 0;
    }

    public void setOnEditTextImeBackListener(InterfaceC5167j interfaceC5167j) {
        this.f5830b = interfaceC5167j;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.f5830b != null) {
            this.f5830b.mo8496a(this, getText().toString());
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    @Override // android.widget.EditText, android.widget.TextView
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTextContextMenuItem(int r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.MyEditText.onTextContextMenuItem(int):boolean");
    }
}
