package com.sec.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;

/* loaded from: classes.dex */
public class SkinSettingPanel extends HorizontalScrollView {

    /* renamed from: a */
    private View.OnClickListener f7760a;

    public SkinSettingPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        this.f7760a = onClickListener;
    }

    /* renamed from: a */
    public void m7477a(String str, View view) {
        if (str != null) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            if (linearLayout.findViewWithTag(str) == null) {
                view.setTag(str);
                view.setOnClickListener(this.f7760a);
                linearLayout.addView(view);
            }
        }
    }

    /* renamed from: a */
    public void m7476a(String str, Drawable drawable) {
        if (str != null) {
            View viewFindViewWithTag = ((LinearLayout) getChildAt(0)).findViewWithTag(str);
            if (viewFindViewWithTag != null) {
                ((ImageView) viewFindViewWithTag.findViewById(R.id.skin_bg)).setImageDrawable(drawable);
            }
            viewFindViewWithTag.setVisibility(0);
        }
    }

    public void setSelection(String str) {
        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt.getTag().toString().equals(str)) {
                childAt.setSelected(true);
            } else {
                childAt.setSelected(false);
            }
        }
    }
}
