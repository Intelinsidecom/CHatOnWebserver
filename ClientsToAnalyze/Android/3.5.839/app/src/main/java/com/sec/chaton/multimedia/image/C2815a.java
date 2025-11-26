package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p131f.C5003g;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import java.io.File;
import java.io.IOException;

/* compiled from: AmsDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.a */
/* loaded from: classes.dex */
public class C2815a extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    private static final String f10377a = C2815a.class.getSimpleName();

    /* renamed from: b */
    private String f10378b;

    /* renamed from: c */
    private boolean f10379c;

    public C2815a(String str, String str2, boolean z) {
        super(str);
        this.f10378b = str2;
        this.f10379c = z;
        if (C4904y.f17872b) {
            C4904y.m18639b("[init] key: " + str + ", content: " + this.f10378b + ", saveFile: " + z, f10377a);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        mo7449h().setImageDrawable(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws Throwable {
        File file;
        File file2;
        Bitmap bitmapM18598a;
        LayerDrawable layerDrawableM11920a = null;
        if (this.f10378b == null || C1427a.f5066d.equals(this.f10378b)) {
            return null;
        }
        try {
            if (this.f10378b.startsWith("content")) {
                file = C4894o.m18610b(Uri.parse(this.f10378b));
                file2 = null;
            } else {
                this.f10378b = Uri.parse(this.f10378b).getPath();
                file = new File(this.f10378b);
                file2 = !this.f10378b.contains("thumbnail") ? new File(file.getParent() + "/thumbnail/" + file.getName()) : null;
            }
            if (file2 != null && file2.exists()) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("thumbnail file exists.", f10377a);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inDither = true;
                options.inPurgeable = true;
                bitmapM18598a = BitmapFactory.decodeFile(file2.getPath(), options);
            } else {
                bitmapM18598a = file != null ? C4894o.m18598a(CommonApplication.m18732r(), file, true, this.f10379c, false) : null;
            }
            if (bitmapM18598a == null) {
                return null;
            }
            layerDrawableM11920a = m11920a(bitmapM18598a);
            return layerDrawableM11920a;
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f10377a);
                return layerDrawableM11920a;
            }
            return layerDrawableM11920a;
        } catch (OutOfMemoryError e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f10377a);
                return layerDrawableM11920a;
            }
            return layerDrawableM11920a;
        }
    }

    /* renamed from: a */
    private LayerDrawable m11920a(Bitmap bitmap) {
        return new LayerDrawable(new Drawable[]{new BitmapDrawable(CommonApplication.m18732r().getResources(), m11921b(bitmap)), CommonApplication.m18732r().getResources().getDrawable(R.drawable.chat_btn_ams_play)});
    }

    /* renamed from: b */
    private Bitmap m11921b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                return C5003g.m18987a(C5034k.m19088a(3.0f), C5034k.m19088a(3.0f)).m18988a(bitmap);
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f10377a);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[Catch: OutOfMemoryError -> 0x0032, Exception -> 0x0039, TRY_LEAVE, TryCatch #2 {Exception -> 0x0039, OutOfMemoryError -> 0x0032, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0013, B:9:0x001d, B:11:0x0027), top: B:18:0x0002 }] */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7443a(java.lang.Object r4, boolean r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L27
            boolean r1 = r4 instanceof android.graphics.drawable.LayerDrawable     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            if (r1 == 0) goto L27
            r0 = r4
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            r1 = r0
            r2 = 0
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            if (r1 == 0) goto L27
            android.graphics.Bitmap r1 = r1.getBitmap()     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            boolean r1 = r1.isRecycled()     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            if (r1 != 0) goto L27
            android.widget.ImageView r1 = r3.mo7449h()     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            r1.setImageDrawable(r4)     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
        L26:
            return
        L27:
            android.widget.ImageView r1 = r3.mo7449h()     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            r2 = 2130837855(0x7f02015f, float:1.7280676E38)
            r1.setImageResource(r2)     // Catch: java.lang.OutOfMemoryError -> L32 java.lang.Exception -> L39
            goto L26
        L32:
            r1 = move-exception
            java.lang.String r2 = com.sec.chaton.multimedia.image.C2815a.f10377a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L26
        L39:
            r1 = move-exception
            java.lang.String r2 = com.sec.chaton.multimedia.image.C2815a.f10377a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.image.C2815a.mo7443a(java.lang.Object, boolean):void");
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Object objG = mo7448g();
        if (objG != null && (objG instanceof LayerDrawable) && (bitmapDrawable = (BitmapDrawable) ((LayerDrawable) objG).getDrawable(0)) != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }
}
