package com.sec.chaton.chat.p054a;

import android.database.Cursor;
import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.sec.chaton.R;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;

/* compiled from: AniconBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.d */
/* loaded from: classes.dex */
class C1531d implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C1530c f5939a;

    C1531d(C1530c c1530c) {
        this.f5939a = c1530c;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (!this.f5939a.f5936ad) {
            this.f5939a.f5931Y = true;
            if (cursor != null) {
                try {
                    if (cursor.moveToNext() && cursor.getLong(cursor.getColumnIndex("install")) > 0) {
                        this.f5939a.f5931Y = false;
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (this.f5939a.f5931Y) {
                if (!this.f5939a.f5935ac) {
                    if (this.f5939a.f5933aa == null) {
                        this.f5939a.f5933aa = new ImageButton(this.f5939a.f5856c);
                        this.f5939a.f5933aa.setBackgroundResource(R.drawable.chat_btn_shop);
                        this.f5939a.f5933aa.setOnClickListener(this.f5939a.f5938af);
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 85;
                    this.f5939a.f5934ab.addView(this.f5939a.f5933aa, layoutParams);
                    this.f5939a.f5935ac = true;
                }
            } else if (this.f5939a.f5933aa != null) {
                this.f5939a.f5934ab.removeView(this.f5939a.f5933aa);
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
