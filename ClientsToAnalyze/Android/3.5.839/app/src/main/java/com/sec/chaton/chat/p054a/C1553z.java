package com.sec.chaton.chat.p054a;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.p078a.C2722d;
import com.sec.chaton.multimedia.p078a.DialogC2719a;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5047m;
import com.sec.widget.C5179v;

/* compiled from: GlympseBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.z */
/* loaded from: classes.dex */
public class C1553z extends AbstractViewOnClickListenerC1514ah implements InterfaceC1544q {

    /* renamed from: L */
    private static final String f5953L = C1553z.class.getSimpleName();

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: a */
    public String mo8368a(Context context) {
        return context.getString(R.string.glympse);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: e */
    protected String mo8370e() {
        return "";
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    protected void mo8357a() throws Resources.NotFoundException {
        ImageView imageView;
        super.mo8357a();
        if (m8404s()) {
            this.f5861h.f6455ay.setText(m8434a(this.f5869p));
            this.f5861h.f6410aA.setText(m8435b(this.f5869p));
            imageView = this.f5861h.f6411aB;
            this.f5861h.f6454ax.setVisibility(0);
        } else {
            this.f5861h.f6415aF.setText(m8434a(this.f5869p));
            this.f5861h.f6417aH.setText(m8435b(this.f5869p));
            imageView = this.f5861h.f6418aI;
            this.f5861h.f6414aE.setVisibility(0);
        }
        imageView.setImageResource(R.drawable.co_attach_p_glympse_normal);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = (int) C5034k.m19088a(48.0f);
        layoutParams.height = (int) C5034k.m19088a(44.5f);
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(this);
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, com.sec.chaton.chat.p054a.AbstractC1506a
    /* renamed from: a */
    public void mo8361a(boolean z) {
        ImageView imageView;
        super.mo8361a(z);
        if (m8404s()) {
            this.f5861h.f6454ax.setVisibility(8);
            this.f5861h.f6456az.setVisibility(0);
            imageView = this.f5861h.f6411aB;
        } else {
            this.f5861h.f6414aE.setVisibility(8);
            this.f5861h.f6416aG.setVisibility(0);
            imageView = this.f5861h.f6418aI;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        imageView.setImageResource(R.drawable.chat_icon_link);
        imageView.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private String m8434a(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit.length > 3) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("getGlympseTitle: " + strArrSplit[3], f5953L);
                }
                if (!TextUtils.isEmpty(strArrSplit[3])) {
                    return strArrSplit[3];
                }
            }
        }
        return this.f5856c.getString(R.string.glympse);
    }

    /* renamed from: b */
    private String m8435b(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("\n");
            StringBuilder sb = new StringBuilder();
            if (strArrSplit.length > 5) {
                for (int i = 5; i < strArrSplit.length; i++) {
                    sb.append(strArrSplit[i] + "\n");
                    if (i == strArrSplit.length - 2 && C5047m.m19188a(this.f5856c, C2722d.m11408a(this.f5856c))) {
                        break;
                    }
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("getGlympseMessage: " + sb.toString().substring(0, sb.length() - 1), f5953L);
                }
                return sb.toString().substring(0, sb.length() - 1);
            }
        }
        return null;
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah
    /* renamed from: g */
    protected void mo8371g() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4 = null;
        float fM19096b = C5034k.m19096b() - this.f5856c.getResources().getDimensionPixelSize(R.dimen.bubble_largefile_width);
        if (m8404s()) {
            textView = this.f5861h.f6455ay;
            textView2 = this.f5861h.f6410aA;
            textView3 = this.f5861h.f6435ae;
            textView4 = this.f5861h.f6462g;
        } else {
            textView = this.f5861h.f6415aF;
            textView2 = this.f5861h.f6417aH;
            textView3 = this.f5861h.f6388F;
        }
        float fA = m8398a(fM19096b - m8399a(textView3, textView4));
        textView.setMaxWidth((int) fA);
        textView2.setMaxWidth((int) (fA - C5034k.m19088a(45.0f)));
    }

    @Override // com.sec.chaton.chat.p054a.AbstractViewOnClickListenerC1514ah, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.equals(this.f5861h.f6411aB) || view.equals(this.f5861h.f6418aI)) {
            if (C4822an.m18206P() || C4822an.m18207Q()) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                return;
            }
            Intent intentM11409a = C2722d.m11409a(this.f5856c, this.f5869p);
            if (C5047m.m19188a(this.f5856c, intentM11409a)) {
                try {
                    this.f5856c.startActivity(intentM11409a);
                    return;
                } catch (ActivityNotFoundException e) {
                    C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
                    if (C4904y.f17875e) {
                        C4904y.m18635a(e, f5953L);
                        return;
                    }
                    return;
                }
            }
            if (C4859bx.m18396c()) {
                new DialogC2719a(this.f5856c).show();
            } else {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.multiwindow_dragNdrop_not_supported, 0).show();
            }
        }
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: i */
    public boolean mo8373i() {
        return true;
    }

    @Override // com.sec.chaton.chat.p054a.InterfaceC1544q
    /* renamed from: j */
    public C1546s mo8374j() {
        return new C1546s(this.f5874u, this.f5869p, null);
    }
}
