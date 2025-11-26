package com.sec.chaton.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.p076m.C2570b;
import com.sec.chaton.p076m.C2575g;

/* loaded from: classes.dex */
public class ImageTextViewGroup extends LinearLayout {

    /* renamed from: a */
    private ImageView f17918a;

    /* renamed from: b */
    private TextView f17919b;

    public ImageTextViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18700a(context, attributeSet);
    }

    /* renamed from: a */
    private void m18700a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2575g.ImageTextViewGroup, C2570b.imageTextViewGroupStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(0, R.attr.textAppearance);
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        this.f17918a = new ImageView(context, null);
        this.f17918a.setDuplicateParentStateEnabled(true);
        if (resourceId != 0) {
            this.f17918a.setImageResource(resourceId);
        }
        this.f17918a.setPadding(0, 0, dimensionPixelOffset, 0);
        addView(this.f17918a, new LinearLayout.LayoutParams(-2, -2));
        this.f17919b = new AdaptableTextView(context, null);
        this.f17919b.setDuplicateParentStateEnabled(true);
        this.f17919b.setTextAppearance(context, resourceId2);
        this.f17919b.setSingleLine();
        this.f17919b.setEllipsize(TextUtils.TruncateAt.END);
        this.f17919b.setText(string);
        addView(this.f17919b, new LinearLayout.LayoutParams(-2, -2));
    }

    public void setImageResource(int i) {
        this.f17918a.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f17918a.setImageDrawable(drawable);
    }

    public void setDrawablePadding(int i) {
        this.f17918a.setPadding(0, 0, i, 0);
    }

    public void setText(int i) {
        this.f17919b.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f17919b.setText(charSequence);
    }

    public void setTextAppearance(Context context, int i) {
        this.f17919b.setTextAppearance(context, i);
    }
}
