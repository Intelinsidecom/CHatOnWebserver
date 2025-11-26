package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class List_TypeDetailGroupCallLog extends List_TypeDetailCommonCallLog {

    /* renamed from: g */
    private TextView f5400g;

    /* renamed from: h */
    private TextView f5401h;

    public List_TypeDetailGroupCallLog(Context context) {
        super(context);
        m7814a(context);
    }

    public List_TypeDetailGroupCallLog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7814a(context);
    }

    /* renamed from: a */
    private final void m7814a(Context context) {
        View.inflate(context, R.layout.list_detail_group_calllog, this);
        this.f5393a = (RelativeLayout) findViewById(R.id.calllog_list);
        this.f5394b = (ImageView) findViewById(R.id.call_type);
        this.f5395c = (ImageView) findViewById(R.id.call_method);
        this.f5396d = (ImageView) findViewById(R.id.image_calllog_reject_message);
        this.f5400g = (TextView) findViewById(R.id.call_time_at);
        this.f5401h = (TextView) findViewById(R.id.call_time);
        this.f5398e = (TextView) findViewById(R.id.call_duration);
        this.f5399f = (CheckBox) findViewById(R.id.delete);
        this.f5399f.setClickable(false);
        this.f5399f.setFocusable(false);
    }

    public final void setTime(String str) {
        if (this.f5400g != null) {
            if (this.f5399f.getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.alignWithParent = true;
                layoutParams.addRule(11, -1);
                layoutParams.rightMargin = 25;
                this.f5400g.setLayoutParams(layoutParams);
                this.f5400g.setText(str);
                return;
            }
            this.f5400g.setText(str);
        }
    }

    public final void setName(String str) {
        if (this.f5401h != null) {
            this.f5401h.setText(str);
        }
    }
}
