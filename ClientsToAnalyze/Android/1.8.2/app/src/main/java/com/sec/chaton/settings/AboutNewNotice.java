package com.sec.chaton.settings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1722ae;

/* loaded from: classes.dex */
public class AboutNewNotice extends Preference {

    /* renamed from: a */
    private boolean f4454a;

    /* renamed from: b */
    private int f4455b;

    public AboutNewNotice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4454a = false;
        this.f4455b = 1;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        BitmapDrawable bitmapDrawableM4480a;
        super.onBindView(view);
        if (!this.f4454a) {
            bitmapDrawableM4480a = null;
        } else if (this.f4455b > 99) {
            bitmapDrawableM4480a = m4480a(R.drawable.tab_icon_notification, "+99");
        } else {
            bitmapDrawableM4480a = m4480a(R.drawable.tab_icon_notification, Integer.valueOf(this.f4455b).toString());
        }
        TextView textView = (TextView) view.findViewById(android.R.id.title);
        if (this.f4454a) {
            textView.setCompoundDrawablePadding(10);
            textView.setGravity(16);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, bitmapDrawableM4480a, (Drawable) null);
        } else {
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* renamed from: a */
    public void m4481a(boolean z) {
        this.f4454a = z;
        notifyChanged();
    }

    /* renamed from: a */
    public void m4482a(boolean z, int i) {
        this.f4454a = z;
        this.f4455b = i;
        notifyChanged();
    }

    /* renamed from: a */
    public BitmapDrawable m4480a(int i, String str) {
        Bitmap bitmapCopy = BitmapFactory.decodeResource(getContext().getResources(), i).copy(Bitmap.Config.ARGB_8888, true);
        float f = getContext().getResources().getDisplayMetrics().density;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(R.color.main_background_color);
        if (this.f4455b > 99) {
            paint.setTextSize(C1722ae.m5895b(11.0f) * f);
        } else {
            paint.setTextSize(C1722ae.m5895b(14.0f) * f);
        }
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        Canvas canvas = new Canvas(bitmapCopy);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, ((bitmapCopy.getWidth() - r4.width()) / 2) * f, f * ((r4.height() + bitmapCopy.getHeight()) / 2), paint);
        return new BitmapDrawable(bitmapCopy);
    }
}
