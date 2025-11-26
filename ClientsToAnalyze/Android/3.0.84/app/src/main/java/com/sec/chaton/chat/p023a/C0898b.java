package com.sec.chaton.chat.p023a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.C1821k;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings.downloads.EnumC2651z;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3197bl;
import com.sec.common.util.C3347i;
import java.io.IOException;

/* compiled from: AniconBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.b */
/* loaded from: classes.dex */
public class C0898b extends AbstractViewOnClickListenerC0920x implements InterfaceC0907k, InterfaceC0909m, InterfaceC0912p {

    /* renamed from: F */
    private Drawable f3821F;

    /* renamed from: G */
    private boolean f3822G;

    /* renamed from: H */
    private RelativeLayout.LayoutParams f3823H;

    /* renamed from: I */
    private int f3824I;

    /* renamed from: J */
    private int f3825J;

    /* renamed from: K */
    private int f3826K;

    /* renamed from: L */
    private int f3827L;

    /* renamed from: M */
    private int f3828M;

    /* renamed from: N */
    private int f3829N;

    /* renamed from: O */
    private int f3830O;

    /* renamed from: P */
    private int f3831P;

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: a */
    public String mo5092a(Context context) {
        return this.f3822G ? context.getString(R.string.dialog_header_text) : context.getString(R.string.anicon_download_list_title);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String mo5103c() {
        /*
            r6 = this;
            r0 = 6
            r5 = 0
            java.lang.String r2 = super.mo5103c()
            r1 = 0
            java.lang.String[] r3 = new java.lang.String[r5]
            if (r2 == 0) goto L5c
            java.lang.String r3 = "\n"
            java.lang.String[] r2 = r2.split(r3)
            int r3 = r2.length
            if (r3 <= r0) goto L5c
            java.lang.String r3 = "mixed"
            r4 = r2[r5]
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5c
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
        L23:
            int r3 = r2.length
            if (r0 >= r3) goto L41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r2[r0]
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "\n"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.append(r3)
            int r0 = r0 + 1
            goto L23
        L41:
            java.lang.String r0 = r1.toString()
            int r1 = r1.length()
            int r1 = r1 + (-1)
            java.lang.String r0 = r0.substring(r5, r1)
        L4f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L58
            r6.f3822G = r5
        L57:
            return r0
        L58:
            r1 = 1
            r6.f3822G = r1
            goto L57
        L5c:
            r0 = r1
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p023a.C0898b.mo5103c():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0131 A[PHI: r2 r3
  0x0131: PHI (r2v3 android.widget.ImageView) = (r2v1 android.widget.ImageView), (r2v8 android.widget.ImageView) binds: [B:19:0x00fc, B:8:0x002d] A[DONT_GENERATE, DONT_INLINE]
  0x0131: PHI (r3v2 android.widget.LinearLayout) = (r3v0 android.widget.LinearLayout), (r3v5 android.widget.LinearLayout) binds: [B:19:0x00fc, B:8:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void mo5087a() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p023a.C0898b.mo5087a():void");
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, com.sec.chaton.chat.p023a.AbstractC0888a
    /* renamed from: a */
    public void mo5090a(boolean z) throws Resources.NotFoundException {
        ImageView imageView;
        View view;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        super.mo5090a(z);
        int dimensionPixelSize = this.f3789c.getResources().getDimensionPixelSize(R.dimen.bubble_img_size);
        if (m5123n()) {
            LinearLayout linearLayout3 = this.f3794h.f4221J;
            ImageView imageView2 = this.f3794h.f4227P;
            LinearLayout linearLayout4 = this.f3794h.f4222K;
            imageView = imageView2;
            view = this.f3794h.f4232U;
            linearLayout = linearLayout3;
            linearLayout2 = linearLayout4;
        } else {
            LinearLayout linearLayout5 = this.f3794h.f4285o;
            ImageView imageView3 = this.f3794h.f4291u;
            LinearLayout linearLayout6 = this.f3794h.f4286p;
            imageView = imageView3;
            view = this.f3794h.f4213B;
            linearLayout = linearLayout5;
            linearLayout2 = linearLayout6;
        }
        imageView.setVisibility(8);
        if (!z) {
            imageView.setImageBitmap(null);
            this.f3796j.m11732a(imageView);
        }
        imageView.setOnClickListener(null);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        imageView.setLayoutParams(layoutParams);
        if (this.f3821F != null) {
            linearLayout.setBackgroundDrawable(this.f3821F);
        }
        if (this.f3823H != null) {
            view.setLayoutParams(this.f3823H);
        }
        if (this.f3822G) {
            linearLayout2.setBackgroundDrawable(null);
            linearLayout2.setPadding(this.f3824I, this.f3826K, this.f3825J, this.f3827L);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(this.f3828M, this.f3829N, this.f3830O, this.f3831P);
        }
        this.f3821F = null;
        this.f3822G = false;
        this.f3823H = null;
        this.f3824I = 0;
        this.f3825J = 0;
        this.f3826K = 0;
        this.f3827L = 0;
        this.f3828M = 0;
        this.f3829N = 0;
        this.f3830O = 0;
        this.f3831P = 0;
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x
    /* renamed from: d */
    protected void mo5100d() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        float fMeasureText;
        TextView textView4 = null;
        float fM11779b = C3347i.m11779b() - C3172an.m11085a(105.0f);
        if (m5123n()) {
            textView = this.f3794h.f4223L;
            textView2 = this.f3794h.f4225N;
            textView3 = this.f3794h.f4233V;
            textView4 = this.f3794h.f4277g;
        } else {
            textView = this.f3794h.f4287q;
            textView2 = this.f3794h.f4289s;
            textView3 = this.f3794h.f4214C;
        }
        if (this.f3822G) {
            fMeasureText = this.f3789c.getResources().getDimensionPixelSize(R.dimen.bubble_img_size) + 0.0f + C3172an.m11085a(60.0f);
        } else {
            float fMeasureText2 = textView3.getPaint().measureText(textView3.getText().toString());
            fMeasureText = textView4 != null ? textView4.getPaint().measureText(textView4.getText().toString()) + fMeasureText2 : fMeasureText2;
        }
        if (m5123n()) {
            float dimensionPixelSize = this.f3789c.getResources().getDimensionPixelSize(R.dimen.upload_progressbar_width) + this.f3789c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fMeasureText <= dimensionPixelSize) {
                fMeasureText = dimensionPixelSize;
            }
            fMeasureText += C3172an.m11085a(5.0f);
        } else {
            float dimensionPixelSize2 = this.f3789c.getResources().getDimensionPixelSize(R.dimen.download_progressbar_width) + this.f3789c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fMeasureText <= dimensionPixelSize2) {
                fMeasureText = dimensionPixelSize2;
            }
        }
        if (this.f3812z == 2) {
            fMeasureText += C3172an.m11085a(40.0f);
        }
        float fA = m5122a(fM11779b - fMeasureText);
        textView.setMaxWidth((int) fA);
        if (this.f3794h.f4290t != null && this.f3794h.f4290t.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fA - C3172an.m11085a(41.0f)));
        } else {
            textView2.setMaxWidth((int) fA);
        }
    }

    @Override // com.sec.chaton.chat.p023a.AbstractViewOnClickListenerC0920x, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        AnimationDrawable animationDrawable;
        if (!C3197bl.m11159a()) {
            super.onClick(view);
            if (view == this.f3794h.f4291u || view == this.f3794h.f4227P) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof TransitionDrawable) {
                    try {
                        animationDrawable = (AnimationDrawable) ((TransitionDrawable) drawable).getDrawable(1);
                    } catch (ClassCastException e) {
                        animationDrawable = null;
                    }
                } else {
                    animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
                }
                if (animationDrawable != null) {
                    animationDrawable.stop();
                    animationDrawable.start();
                }
                String[] strArrSplit = this.f3802p.split("\n");
                if (strArrSplit != null && strArrSplit.length >= 3) {
                    String strM9664c = C2646u.m9664c(strArrSplit[2]);
                    if (C2646u.m9673i(this.f3789c, strM9664c) != EnumC2651z.NORMAL) {
                        C1821k.m7478a().m7482a(strM9664c);
                    }
                }
            }
        }
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: e */
    public boolean mo5094e() {
        return this.f3822G;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0912p
    /* renamed from: f */
    public C0910n mo5095f() {
        return TextUtils.isEmpty(m5126q()) ? new C0910n(EnumC1455w.TEXT, mo5103c(), null) : new C0910n(EnumC1455w.TEXT, mo5103c() + m5126q(), null);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: g */
    public boolean mo5096g() {
        return this.f3822G;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0909m
    /* renamed from: h */
    public C0910n mo5097h() {
        return TextUtils.isEmpty(m5126q()) ? new C0910n(EnumC1455w.TEXT, mo5103c(), null) : new C0910n(EnumC1455w.TEXT, mo5103c() + m5126q(), null);
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: i */
    public boolean mo5098i() {
        return this.f3822G;
    }

    @Override // com.sec.chaton.chat.p023a.InterfaceC0907k
    /* renamed from: j */
    public String mo5099j() {
        return TextUtils.isEmpty(m5126q()) ? mo5103c() : mo5103c() + m5126q();
    }
}
