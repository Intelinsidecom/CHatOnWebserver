package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.p053b.C1452a;

/* loaded from: classes.dex */
public class List_TypeCommonCallLog extends RelativeLayout {

    /* renamed from: a */
    protected RelativeLayout f5393a;

    /* renamed from: b */
    protected ImageView f5394b;

    /* renamed from: c */
    protected ImageView f5395c;

    /* renamed from: d */
    protected ImageView f5396d;

    public List_TypeCommonCallLog(Context context) {
        super(context);
    }

    public List_TypeCommonCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void setCallType(CallLogData callLogData) {
        this.f5394b.setBackgroundResource(C1452a.m7610c(callLogData));
    }

    public final void setCallMethod(int i) {
        int i2 = R.drawable.buddies_voicecall;
        switch (i) {
            case 6:
            case 10:
                this.f5396d.setVisibility(8);
                break;
            case 7:
            case 11:
                i2 = R.drawable.buddies_videocall;
                this.f5396d.setVisibility(8);
                break;
            case 12:
                i2 = R.drawable.buddies_reject_message;
                this.f5396d.setVisibility(0);
                break;
        }
        this.f5395c.setBackgroundResource(i2);
    }
}
