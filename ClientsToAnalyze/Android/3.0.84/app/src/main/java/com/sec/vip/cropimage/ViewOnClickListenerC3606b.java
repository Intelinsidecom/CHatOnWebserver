package com.sec.vip.cropimage;

import android.content.res.Resources;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;

/* compiled from: CropImage.java */
/* renamed from: com.sec.vip.cropimage.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC3606b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CropImage f13274a;

    ViewOnClickListenerC3606b(CropImage cropImage) {
        this.f13274a = cropImage;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int i;
        if (this.f13274a.f13152G) {
            this.f13274a.m12903h();
            this.f13274a.f13150E = true;
            this.f13274a.f13153H = this.f13274a.f13183v;
            this.f13274a.setTitle(R.string.image_select_effect);
            this.f13274a.m12874a(true);
            if (this.f13274a.f13179r != null) {
                int childCount = this.f13274a.f13179r.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        i = 0;
                        break;
                    }
                    View childAt = this.f13274a.f13179r.getChildAt(i2);
                    if (childAt.getId() != this.f13274a.f13183v) {
                        i2++;
                    } else {
                        ((TextView) childAt.findViewById(R.id.text_filter_name)).setSelected(true);
                        ((ImageView) childAt.findViewById(R.id.image_filter_effect)).setSelected(true);
                        i = i2;
                        break;
                    }
                }
                int width = this.f13274a.getWindowManager().getDefaultDisplay().getWidth();
                ((HorizontalScrollView) this.f13274a.findViewById(R.id.hscroll_effect_filter)).scrollTo((i * this.f13274a.getResources().getDimensionPixelSize(R.dimen.ams_ics_effect_filter_layout_width)) - ((int) (((width - r3) * 0.5f) + 0.5f)), 0);
            }
        }
    }
}
