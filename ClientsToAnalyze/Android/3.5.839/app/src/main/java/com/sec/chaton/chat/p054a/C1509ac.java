package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.multimedia.image.AsyncTaskC2843c;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p067j.p070c.C2434a;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;

/* compiled from: ImageBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ac */
/* loaded from: classes.dex */
public class C1509ac extends AbstractC1525as {

    /* renamed from: L */
    private static final String f5882L = C1509ac.class.getSimpleName();

    /* renamed from: M */
    private static final float f5883M = C5034k.m19088a(60.0f);

    /* renamed from: N */
    private boolean f5884N;

    /* renamed from: O */
    private ImageView f5885O;

    /* renamed from: P */
    private boolean f5886P;

    /* renamed from: Q */
    private String f5887Q;

    /* renamed from: R */
    private FrameLayout f5888R;

    /* renamed from: S */
    private ImageButton f5889S;

    /* renamed from: T */
    private AsyncTaskC2843c f5890T;

    /* renamed from: U */
    private Handler f5891U = new HandlerC1510ad(this);

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.media_photo);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return C1736gi.m8654f(super.mo8370e());
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: b_ */
    public C1546s mo8387b_() {
        if (TextUtils.isEmpty(m8407v())) {
            return new C1546s(this.f5874u, this.f5876w, mo8370e());
        }
        if (!TextUtils.isEmpty(mo8370e())) {
            return new C1546s(this.f5874u, this.f5876w, mo8370e() + m8407v());
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("onShare() - getTextContent() is null", f5882L);
        }
        return new C1546s(this.f5874u, this.f5876w, "" + m8407v());
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws NumberFormatException {
        super.mo8357a();
        this.f5884N = false;
        if (TextUtils.isEmpty(this.f5876w) && !C2434a.m10540a().m10542a(this.f5866m)) {
            C2434a.m10540a().m10541a(this.f5857d, null, new Handler(), 0, super.mo8370e(), true, this.f5867n, this.f5866m, this.f5874u, this.f5865l, this.f5875v);
        }
        if (m8404s()) {
            this.f5887Q = this.f5868o + this.f5876w;
            this.f5885O = this.f5861h.f6401S;
            this.f5889S = this.f5861h.f6403U;
            this.f5888R = this.f5861h.f6402T;
            if (this.f5876w == null) {
                this.f5861h.f6401S.setVisibility(8);
                this.f5861h.f6437ag.setVisibility(0);
            } else {
                this.f5861h.f6401S.setVisibility(0);
                this.f5861h.f6437ag.setVisibility(8);
            }
        } else {
            this.f5887Q = this.f5866m + this.f5876w;
            this.f5885O = this.f5861h.f6476u;
            this.f5889S = this.f5861h.f6479x;
            this.f5888R = this.f5861h.f6478w;
            if (this.f5876w == null) {
                this.f5861h.f6476u.setVisibility(8);
                this.f5861h.f6442al.setVisibility(0);
            } else {
                this.f5861h.f6476u.setVisibility(0);
                this.f5861h.f6442al.setVisibility(8);
            }
        }
        boolean z = false;
        if (C2349a.m10301a("full_image_feature") && this.f5876w != null && !this.f5876w.contains("thumbnail") && !C1427a.f5066d.equals(this.f5869p)) {
            z = true;
            m8376a(this.f5877x);
            m8379b(this.f5877x);
        }
        this.f5885O.setOnClickListener(this);
        this.f5885O.setContentDescription(this.f5856c.getString(R.string.media_photo));
        this.f5863j.m19023b(this.f5885O, new C2844d(this.f5887Q + this.f5886P, this.f5876w, true, true, this.f5874u, z, this.f5886P, this.f5891U, m8404s(), this.f5867n, m8404s() ? this.f5868o : this.f5866m, this.f5875v, this.f5877x));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8376a(java.lang.String r8) throws java.lang.NumberFormatException {
        /*
            r7 = this;
            r5 = 1
            r4 = 0
            boolean r0 = com.sec.chaton.util.C4904y.f17872b
            if (r0 == 0) goto L21
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mFormattedMessage : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = r7.f5877x
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = com.sec.chaton.chat.p054a.C1509ac.f5882L
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
        L21:
            java.lang.String r0 = r7.f5877x
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L9e
            java.lang.String r0 = r7.f5877x
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            if (r1 <= r5) goto L9e
            r1 = 0
            r1 = r0[r1]     // Catch: java.lang.NumberFormatException -> L85
            int r3 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L85
            r1 = 1
            r0 = r0[r1]     // Catch: java.lang.NumberFormatException -> L85
            int r1 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L85
            float r0 = (float) r3     // Catch: java.lang.NumberFormatException -> L85
            float r2 = com.sec.chaton.chat.p054a.C1509ac.f5883M     // Catch: java.lang.NumberFormatException -> L85
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L51
            float r0 = (float) r1     // Catch: java.lang.NumberFormatException -> L85
            float r2 = com.sec.chaton.chat.p054a.C1509ac.f5883M     // Catch: java.lang.NumberFormatException -> L85
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L6b
        L51:
            r0 = r1
            r1 = r3
        L53:
            r2 = r1
            r1 = r0
        L55:
            if (r2 <= 0) goto L92
            if (r1 <= 0) goto L92
            android.widget.ImageView r0 = r7.f5885O
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r7.f5886P = r5
            r0.width = r2
            r0.height = r1
            android.widget.ImageView r1 = r7.f5885O
            r1.setLayoutParams(r0)
        L6a:
            return
        L6b:
            if (r3 <= r1) goto L79
            float r0 = com.sec.chaton.chat.p054a.C1509ac.f5883M     // Catch: java.lang.NumberFormatException -> L85
            int r2 = (int) r0
            float r0 = com.sec.chaton.chat.p054a.C1509ac.f5883M     // Catch: java.lang.NumberFormatException -> L95
            float r3 = (float) r3
            float r0 = r0 / r3
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            r1 = r2
            goto L53
        L79:
            float r0 = com.sec.chaton.chat.p054a.C1509ac.f5883M     // Catch: java.lang.NumberFormatException -> L85
            int r0 = (int) r0
            float r2 = com.sec.chaton.chat.p054a.C1509ac.f5883M     // Catch: java.lang.NumberFormatException -> L98
            float r1 = (float) r1
            float r1 = r2 / r1
            float r2 = (float) r3
            float r1 = r1 * r2
            int r1 = (int) r1
            goto L53
        L85:
            r0 = move-exception
            r1 = r4
            r2 = r4
        L88:
            boolean r3 = com.sec.chaton.util.C4904y.f17875e
            if (r3 == 0) goto L55
            java.lang.String r3 = com.sec.chaton.chat.p054a.C1509ac.f5882L
            com.sec.chaton.util.C4904y.m18635a(r0, r3)
            goto L55
        L92:
            r7.f5886P = r4
            goto L6a
        L95:
            r0 = move-exception
            r1 = r4
            goto L88
        L98:
            r1 = move-exception
            r2 = r4
            r6 = r0
            r0 = r1
            r1 = r6
            goto L88
        L9e:
            r1 = r4
            r2 = r4
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p054a.C1509ac.m8376a(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8379b(String str) {
        if (!TextUtils.isEmpty(this.f5877x)) {
            String[] strArrSplit = this.f5877x.split(",");
            if (strArrSplit.length > 2 && Spam.ACTIVITY_REPORT.equals(strArrSplit[2])) {
                this.f5889S.setVisibility(0);
                this.f5889S.bringToFront();
                this.f5889S.setOnClickListener(this);
            } else {
                this.f5889S.setVisibility(8);
                this.f5889S.setOnClickListener(null);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) throws Resources.NotFoundException {
        ImageView imageView;
        super.mo8361a(z);
        this.f5884N = true;
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroyBubble", f5882L);
        }
        if (m8404s()) {
            this.f5861h.f6401S.setVisibility(8);
            this.f5861h.f6437ag.setVisibility(8);
            imageView = this.f5861h.f6401S;
        } else {
            this.f5861h.f6476u.setVisibility(8);
            this.f5861h.f6442al.setVisibility(8);
            imageView = this.f5861h.f6476u;
        }
        if (!z) {
            imageView.setImageBitmap(null);
            this.f5863j.m19015a((View) imageView);
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int dimensionPixelSize = this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_img_size);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        imageView.setLayoutParams(layoutParams);
        int dimensionPixelSize2 = this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_anicon_size);
        imageView.setMaxWidth(dimensionPixelSize2);
        imageView.setMaxHeight(dimensionPixelSize2);
        imageView.setOnClickListener(null);
        this.f5889S.setVisibility(8);
        this.f5889S.setOnClickListener(null);
        if (this.f5890T != null) {
            this.f5890T.cancel(true);
            this.f5890T.m11937a();
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractC1525as, com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (!this.f5858e.isClosed()) {
            if (view.equals(this.f5861h.f6476u) || view.equals(this.f5861h.f6401S)) {
                if (this.f5858e.moveToPosition(this.f5859f)) {
                    this.f5864k.mo8237a(m8404s(), this.f5858e);
                }
            } else if (view.equals(this.f5861h.f6403U) || view.equals(this.f5861h.f6479x)) {
                if (this.f5889S != null) {
                    this.f5889S.setVisibility(4);
                }
                this.f5890T = AsyncTaskC2843c.m11935a(this.f5876w, this.f5888R, this.f5885O, this.f5891U, false);
                this.f5890T.execute(new String[0]);
            }
        }
    }
}
