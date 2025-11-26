package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.QuickContactBadge;
import com.p137vk.sdk.api.VKApiConst;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class QuickContactDivot extends QuickContactBadge implements InterfaceC4356w {

    /* renamed from: b */
    private int f15073b;

    /* renamed from: c */
    private float f15074c;

    public QuickContactDivot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16155a(attributeSet);
    }

    public QuickContactDivot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16155a(attributeSet);
    }

    public QuickContactDivot(Context context) {
        super(context);
        m16155a(null);
    }

    /* renamed from: a */
    private void m16155a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.f15073b = attributeSet.getAttributeListValue(null, VKApiConst.POSITION, f15795a, -1);
        }
        this.f15074c = getContext().getResources().getDisplayMetrics().density;
    }

    @Override // android.widget.QuickContactBadge, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mOverlay");
            declaredField.setAccessible(true);
            try {
                declaredField.set(this, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        super.onDraw(canvas);
        canvas.save();
        canvas.restore();
    }

    public void setPosition(int i) {
        this.f15073b = i;
        invalidate();
    }

    @Override // android.widget.QuickContactBadge, android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
