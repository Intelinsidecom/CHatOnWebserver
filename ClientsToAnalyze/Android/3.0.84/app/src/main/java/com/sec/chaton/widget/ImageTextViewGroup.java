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
import com.sec.chaton.p044l.C1603b;
import com.sec.chaton.p044l.C1608g;

/* loaded from: classes.dex */
public class ImageTextViewGroup extends LinearLayout {

    /* renamed from: a */
    private ImageView f11755a;

    /* renamed from: b */
    private TextView f11756b;

    public ImageTextViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11469a(context, attributeSet);
    }

    /* renamed from: a */
    private void m11469a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1608g.ImageTextViewGroup, C1603b.imageTextViewGroupStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(0, R.attr.textAppearance);
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        this.f11755a = new ImageView(context, null);
        this.f11755a.setDuplicateParentStateEnabled(true);
        if (resourceId != 0) {
            this.f11755a.setImageResource(resourceId);
        }
        this.f11755a.setPadding(0, 0, dimensionPixelOffset, 0);
        addView(this.f11755a, new LinearLayout.LayoutParams(-2, -2));
        this.f11756b = new AdaptableTextView(context, null);
        this.f11756b.setDuplicateParentStateEnabled(true);
        this.f11756b.setTextAppearance(context, resourceId2);
        this.f11756b.setSingleLine();
        this.f11756b.setEllipsize(TextUtils.TruncateAt.END);
        this.f11756b.setText(string);
        addView(this.f11756b, new LinearLayout.LayoutParams(-2, -2));
    }

    public void setImageResource(int i) {
        this.f11755a.setImageResource(i);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f11755a.setImageDrawable(drawable);
    }

    public void setDrawablePadding(int i) {
        this.f11755a.setPadding(0, 0, i, 0);
    }

    public void setText(int i) {
        this.f11756b.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f11756b.setText(charSequence);
    }

    public void setTextAppearance(Context context, int i) {
        this.f11756b.setTextAppearance(context, i);
    }
}
