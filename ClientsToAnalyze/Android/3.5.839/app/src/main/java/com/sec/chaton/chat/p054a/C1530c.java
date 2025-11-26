package com.sec.chaton.chat.p054a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.C2780l;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC2788t;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.EnumC3465i;
import com.sec.chaton.shop.ChatONShopActivity;
import com.sec.chaton.util.C4847bl;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import java.io.IOException;

/* compiled from: AniconBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.c */
/* loaded from: classes.dex */
public class C1530c extends AbstractViewOnClickListenerC1514ah implements InterfaceC1541n, InterfaceC1543p, InterfaceC1544q, InterfaceC1548u {

    /* renamed from: M */
    private Drawable f5919M;

    /* renamed from: N */
    private boolean f5920N;

    /* renamed from: O */
    private RelativeLayout.LayoutParams f5921O;

    /* renamed from: P */
    private int f5922P;

    /* renamed from: Q */
    private int f5923Q;

    /* renamed from: R */
    private int f5924R;

    /* renamed from: S */
    private int f5925S;

    /* renamed from: T */
    private int f5926T;

    /* renamed from: U */
    private int f5927U;

    /* renamed from: V */
    private int f5928V;

    /* renamed from: W */
    private int f5929W;

    /* renamed from: X */
    private C2210x f5930X;

    /* renamed from: Y */
    private boolean f5931Y;

    /* renamed from: Z */
    private String f5932Z;

    /* renamed from: aa */
    private ImageButton f5933aa;

    /* renamed from: ab */
    private FrameLayout f5934ab;

    /* renamed from: ac */
    private boolean f5935ac;

    /* renamed from: ad */
    private boolean f5936ad;

    /* renamed from: ae */
    private ImageView f5937ae;

    /* renamed from: L */
    InterfaceC2211y f5918L = new C1531d(this);

    /* renamed from: af */
    private View.OnClickListener f5938af = new ViewOnClickListenerC1532e(this);

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return this.f5920N ? context.getString(R.string.dialog_header_text) : context.getString(R.string.chat_stickers);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String mo8370e() {
        /*
            r6 = this;
            r0 = 6
            r5 = 0
            java.lang.String r2 = super.mo8370e()
            java.lang.String r1 = ""
            java.lang.String[] r3 = new java.lang.String[r5]
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L65
            java.lang.String r3 = "\n"
            java.lang.String[] r2 = r2.split(r3)
            int r3 = r2.length
            if (r3 <= r0) goto L65
            java.lang.String r3 = "mixed"
            r4 = r2[r5]
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L65
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
        L2b:
            int r3 = r2.length
            if (r0 >= r3) goto L4a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r2[r0]
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "\n"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.append(r3)
            int r0 = r0 + 1
            goto L2b
        L4a:
            java.lang.String r0 = r1.toString()
            int r1 = r1.length()
            int r1 = r1 + (-1)
            java.lang.String r0 = r0.substring(r5, r1)
        L58:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L61
            r6.f5920N = r5
        L60:
            return r0
        L61:
            r1 = 1
            r6.f5920N = r1
            goto L60
        L65:
            r0 = r1
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p054a.C1530c.mo8370e():java.lang.String");
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws Resources.NotFoundException {
        ImageView imageView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        super.mo8357a();
        this.f5936ad = false;
        if (!TextUtils.isEmpty(this.f5869p)) {
            int dimensionPixelSize = this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_anicon_size);
            if (m8404s()) {
                LinearLayout linearLayout3 = this.f5861h.f6395M;
                ImageView imageView2 = this.f5861h.f6404V;
                this.f5934ab = this.f5861h.f6405W;
                this.f5937ae = this.f5861h.f6406X;
                if (this.f5920N) {
                    LinearLayout linearLayout4 = this.f5861h.f6396N;
                    LinearLayout linearLayout5 = this.f5861h.f6434ad;
                    this.f5921O = (RelativeLayout.LayoutParams) linearLayout5.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams) this.f5921O);
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.addRule(3, linearLayout3.getId());
                    layoutParams.addRule(7, linearLayout3.getId());
                    linearLayout5.setLayoutParams(layoutParams);
                    linearLayout5.setOrientation(0);
                    linearLayout = linearLayout4;
                    linearLayout2 = linearLayout3;
                    imageView = imageView2;
                } else {
                    linearLayout = null;
                    imageView = imageView2;
                    linearLayout2 = linearLayout3;
                }
            } else {
                LinearLayout linearLayout6 = this.f5861h.f6470o;
                imageView = this.f5861h.f6476u;
                this.f5934ab = this.f5861h.f6478w;
                this.f5937ae = this.f5861h.f6477v;
                if (this.f5920N) {
                    LinearLayout linearLayout7 = this.f5861h.f6471p;
                    RelativeLayout relativeLayout = this.f5861h.f6387E;
                    this.f5921O = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams) this.f5921O);
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    layoutParams2.addRule(3, linearLayout6.getId());
                    layoutParams2.addRule(5, linearLayout6.getId());
                    relativeLayout.setLayoutParams(layoutParams2);
                    linearLayout = linearLayout7;
                    linearLayout2 = linearLayout6;
                } else {
                    linearLayout = null;
                    linearLayout2 = linearLayout6;
                }
            }
            imageView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            layoutParams3.width = dimensionPixelSize;
            layoutParams3.height = dimensionPixelSize;
            imageView.setLayoutParams(layoutParams3);
            imageView.setOnClickListener(this);
            imageView.setContentDescription(this.f5856c.getString(R.string.chat_stickers));
            this.f5919M = linearLayout2.getBackground();
            linearLayout2.setBackgroundColor(0);
            if (this.f5920N) {
                this.f5924R = linearLayout.getPaddingTop();
                this.f5925S = linearLayout.getPaddingBottom();
                this.f5922P = linearLayout.getPaddingLeft();
                this.f5923Q = linearLayout.getPaddingRight();
                linearLayout.setBackgroundDrawable(this.f5919M.getConstantState().newDrawable());
                linearLayout2.setOrientation(0);
                this.f5926T = linearLayout2.getPaddingLeft();
                this.f5927U = linearLayout2.getPaddingTop();
                this.f5928V = linearLayout2.getPaddingRight();
                this.f5929W = linearLayout2.getPaddingBottom();
                linearLayout2.setPadding(this.f5922P, this.f5924R, this.f5923Q, this.f5925S);
            }
            String[] strArrSplit = this.f5869p.split("\n");
            if (strArrSplit != null && strArrSplit.length >= 3) {
                this.f5932Z = C3460d.m13781c(strArrSplit[2]);
                if (!TextUtils.isEmpty(this.f5932Z)) {
                    this.f5863j.m19023b(imageView, new CallableC2788t(this.f5932Z, dimensionPixelSize, C5034k.m19098c(), this.f5937ae));
                    this.f5930X = new C2210x(this.f5856c.getContentResolver(), this.f5918L);
                    this.f5930X.startQuery(Integer.parseInt(this.f5932Z), null, C2257bc.f8039a.buildUpon().appendPath("anicon_install").appendPath(this.f5932Z).build(), null, null, null, null);
                    return;
                }
                imageView.setImageResource(R.drawable.anicon_broken);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) throws Resources.NotFoundException {
        View view;
        LinearLayout linearLayout;
        ImageView imageView;
        LinearLayout linearLayout2;
        super.mo8361a(z);
        this.f5936ad = true;
        if (this.f5930X != null) {
            this.f5930X.cancelOperation(Integer.parseInt(this.f5932Z));
        }
        int dimensionPixelSize = this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_img_size);
        if (m8404s()) {
            LinearLayout linearLayout3 = this.f5861h.f6395M;
            ImageView imageView2 = this.f5861h.f6404V;
            LinearLayout linearLayout4 = this.f5861h.f6396N;
            view = this.f5861h.f6434ad;
            linearLayout = linearLayout3;
            imageView = imageView2;
            linearLayout2 = linearLayout4;
        } else {
            LinearLayout linearLayout5 = this.f5861h.f6470o;
            ImageView imageView3 = this.f5861h.f6476u;
            LinearLayout linearLayout6 = this.f5861h.f6471p;
            view = this.f5861h.f6387E;
            linearLayout = linearLayout5;
            imageView = imageView3;
            linearLayout2 = linearLayout6;
        }
        imageView.setVisibility(8);
        if (!z) {
            imageView.setImageBitmap(null);
            this.f5863j.m19015a((View) imageView);
            this.f5937ae.setVisibility(8);
        }
        imageView.setOnClickListener(null);
        this.f5861h.f6443am.setOnClickListener(null);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        imageView.setLayoutParams(layoutParams);
        if (this.f5919M != null) {
            linearLayout.setBackgroundDrawable(this.f5919M);
        }
        if (this.f5921O != null) {
            view.setLayoutParams(this.f5921O);
        }
        if (m8404s()) {
            ((LinearLayout) view).setOrientation(1);
        }
        if (this.f5920N) {
            linearLayout2.setBackgroundDrawable(null);
            linearLayout2.setPadding(this.f5922P, this.f5924R, this.f5923Q, this.f5925S);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(this.f5926T, this.f5927U, this.f5928V, this.f5929W);
        }
        this.f5919M = null;
        this.f5920N = false;
        this.f5921O = null;
        this.f5922P = 0;
        this.f5923Q = 0;
        this.f5924R = 0;
        this.f5925S = 0;
        this.f5926T = 0;
        this.f5927U = 0;
        this.f5928V = 0;
        this.f5929W = 0;
        if (!z && this.f5933aa != null) {
            this.f5934ab.removeView(this.f5933aa);
            this.f5935ac = false;
            this.f5933aa = null;
        }
        this.f5931Y = false;
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        float fA;
        TextView textView4 = null;
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_default_subtraction_width);
        if (m8404s()) {
            textView = this.f5861h.f6397O;
            textView2 = this.f5861h.f6399Q;
            textView3 = this.f5861h.f6435ae;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6472q;
            textView2 = this.f5861h.f6474s;
            textView3 = this.f5861h.f6388F;
        }
        if (!this.f5920N) {
            fA = m8399a(textView3, textView4) + 0.0f;
        } else {
            fA = this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_img_size) + 0.0f + C5034k.m19088a(60.0f);
        }
        if (m8404s()) {
            float dimensionPixelSize = this.f5856c.getResources().getDimensionPixelSize(R.dimen.upload_progressbar_width) + this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fA <= dimensionPixelSize) {
                fA = dimensionPixelSize;
            }
            fA += C5034k.m19088a(5.0f);
        } else {
            float dimensionPixelSize2 = this.f5856c.getResources().getDimensionPixelSize(R.dimen.download_progressbar_width) + this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_icon_width);
            if (fA <= dimensionPixelSize2) {
                fA = dimensionPixelSize2;
            }
        }
        if (this.f5879z == 2) {
            fA += C5034k.m19088a(40.0f);
        }
        float fA2 = m8398a(fM19096b - fA);
        textView.setMaxWidth((int) fA2);
        if (this.f5861h.f6475t != null && this.f5861h.f6475t.getVisibility() == 0) {
            textView2.setMaxWidth((int) (fA2 - C5034k.m19088a(41.0f)));
        } else {
            textView2.setMaxWidth((int) fA2);
        }
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        AnimationDrawable animationDrawable;
        String strM13781c;
        super.onClick(view);
        if ((view.equals(this.f5861h.f6476u) || view.equals(this.f5861h.f6404V)) && !C4847bl.m18333a()) {
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
            String[] strArrSplit = this.f5869p.split("\n");
            if (strArrSplit != null && strArrSplit.length >= 3 && (strM13781c = C3460d.m13781c(strArrSplit[2])) != null && C3460d.m13788h(this.f5856c, strM13781c) != EnumC3465i.NORMAL) {
                C2780l.m11679a().m11683a(strM13781c);
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: h */
    public boolean mo8412h() {
        return this.f5920N;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1548u
    /* renamed from: b_ */
    public C1546s mo8387b_() {
        if (TextUtils.isEmpty(m8407v())) {
            return new C1546s(EnumC2214ab.TEXT, mo8370e(), null);
        }
        if (!TextUtils.isEmpty(mo8370e())) {
            return new C1546s(EnumC2214ab.TEXT, mo8370e() + m8407v(), null);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("onShare() - getTextContent() is null", "AniconBubbleDrawer");
        }
        return new C1546s(EnumC2214ab.TEXT, "" + m8407v(), null);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return this.f5920N;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        if (TextUtils.isEmpty(m8407v())) {
            return new C1546s(EnumC2214ab.TEXT, mo8370e(), null);
        }
        if (!TextUtils.isEmpty(mo8370e())) {
            return new C1546s(EnumC2214ab.TEXT, mo8370e() + m8407v(), null);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("onForward() - getTextContent() is null", "AniconBubbleDrawer");
        }
        return new C1546s(EnumC2214ab.TEXT, "" + m8407v(), null);
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1541n
    /* renamed from: k */
    public boolean mo8390k() {
        return this.f5920N;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1541n
    /* renamed from: l */
    public String mo8391l() {
        if (TextUtils.isEmpty(m8407v())) {
            return mo8370e();
        }
        if (!TextUtils.isEmpty(mo8370e())) {
            return mo8370e() + m8407v();
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("onCopy() - getTextContent() is null", "AniconBubbleDrawer");
        }
        return "" + m8407v();
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1543p
    /* renamed from: m */
    public boolean mo8427m() {
        return this.f5931Y;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1543p
    /* renamed from: f_ */
    public Intent mo8426f_() {
        Intent intent = new Intent(this.f5856c, (Class<?>) ChatONShopActivity.class);
        intent.putExtra("page_name", 1);
        intent.putExtra("category_id", 1L);
        intent.putExtra("anicon_id", this.f5932Z);
        return intent;
    }
}
