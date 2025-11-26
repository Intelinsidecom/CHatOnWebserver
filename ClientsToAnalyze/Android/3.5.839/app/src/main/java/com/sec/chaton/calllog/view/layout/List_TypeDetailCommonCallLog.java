package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/* loaded from: classes.dex */
public class List_TypeDetailCommonCallLog extends List_TypeCommonCallLog {

    /* renamed from: e */
    protected TextView f5398e;

    /* renamed from: f */
    protected CheckBox f5399f;

    public List_TypeDetailCommonCallLog(Context context) {
        super(context);
    }

    public List_TypeDetailCommonCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void setDuration(String str) {
        if (this.f5398e != null) {
            this.f5398e.setText(str);
            this.f5398e.setSelected(true);
        }
    }

    public void setDeleteMode(boolean z) {
        if (z) {
            this.f5399f.setVisibility(0);
        } else {
            this.f5399f.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        this.f5399f.setChecked(z);
    }

    public void setCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f5399f.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
