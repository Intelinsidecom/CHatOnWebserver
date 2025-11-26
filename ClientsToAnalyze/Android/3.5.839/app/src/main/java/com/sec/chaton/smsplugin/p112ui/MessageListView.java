package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ListView;

/* loaded from: classes.dex */
public final class MessageListView extends ListView {

    /* renamed from: a */
    private InterfaceC4131bm f14849a;

    public MessageListView(Context context) {
        super(context);
    }

    public MessageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        C4108aq c4108aqM15834i;
        switch (i) {
            case 31:
                MessageListItem messageListItem = (MessageListItem) getSelectedView();
                if (messageListItem != null && (c4108aqM15834i = messageListItem.m15834i()) != null && c4108aqM15834i.m16312o()) {
                    ((ClipboardManager) getContext().getSystemService("clipboard")).setText(c4108aqM15834i.f15277l);
                    return true;
                }
                break;
        }
        return super.onKeyShortcut(i, keyEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f14849a != null) {
            this.f14849a.m16350a(i, i2, i3, i4);
        }
    }
}
