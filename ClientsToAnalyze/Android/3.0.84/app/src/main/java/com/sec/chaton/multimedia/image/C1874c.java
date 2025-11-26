package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.trunk.p061c.C3025f;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import java.io.File;

/* compiled from: ImageDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.c */
/* loaded from: classes.dex */
public class C1874c extends AbstractRunnableC3324a<String> {

    /* renamed from: a */
    private static final String f7131a = C1874c.class.getSimpleName();

    /* renamed from: b */
    private String f7132b;

    /* renamed from: c */
    private boolean f7133c;

    /* renamed from: d */
    private boolean f7134d;

    /* renamed from: e */
    private boolean f7135e;

    public C1874c(String str, String str2, boolean z, boolean z2) {
        super(str);
        this.f7132b = str2;
        this.f7133c = z;
        this.f7135e = z2;
        if (C3250y.f11734b) {
            C3250y.m11450b("[init] key: " + str + ", content: " + this.f7132b + ", isImage:" + z + ", saveFile: " + z2, f7131a);
        }
    }

    public C1874c(String str, String str2, boolean z, boolean z2, EnumC1455w enumC1455w) {
        super(str);
        this.f7132b = str2;
        this.f7133c = z;
        if (enumC1455w == EnumC1455w.AMS) {
            this.f7134d = true;
        }
        this.f7135e = z2;
        if (C3250y.f11734b) {
            C3250y.m11450b("[init] key: " + str + ", content: " + this.f7132b + ", msgType:" + enumC1455w + ", saveFile: " + z2, f7131a);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        mo4338h().setImageDrawable(null);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws Throwable {
        Drawable drawable;
        if (C3250y.f11734b) {
            C3250y.m11450b("[onDispatch] content : " + this.f7132b, f7131a);
        }
        if (this.f7132b != null) {
            try {
                if (C0816a.f3113b.equals(this.f7132b)) {
                    return null;
                }
                if (this.f7132b.contains("file://")) {
                    this.f7132b = Uri.parse(this.f7132b).getPath();
                }
                if (this.f7133c && C3025f.m10540b(this.f7132b)) {
                    this.f7134d = true;
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("mIsAms : " + this.f7134d, f7131a);
                }
                File file = new File(this.f7132b);
                if (!this.f7132b.contains("thumbnail")) {
                    String name = file.getName();
                    file = new File(this.f7132b.split(name)[0] + "thumbnail/" + (!this.f7133c ? name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg") : name));
                }
                if (file.exists()) {
                    if (C3250y.f11734b) {
                        C3250y.m11450b("thumbnail file exists.", f7131a);
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inDither = true;
                    options.inPurgeable = true;
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getPath(), options);
                    if (bitmapDecodeFile != null) {
                        if (this.f7133c && !this.f7134d) {
                            return C3205bt.m11191b(bitmapDecodeFile);
                        }
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(CommonApplication.m11493l().getResources(), C3205bt.m11191b(bitmapDecodeFile));
                        if (this.f7134d) {
                            drawable = CommonApplication.m11493l().getResources().getDrawable(R.drawable.chat_btn_ams_play);
                        } else {
                            drawable = CommonApplication.m11493l().getResources().getDrawable(R.drawable.chat_btn_play);
                        }
                        return new LayerDrawable(new Drawable[]{bitmapDrawable, drawable});
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("thumbBitmap1 is null", f7131a);
                    }
                }
                if (this.f7133c) {
                    Bitmap bitmapM11414a = C3243r.m11414a(CommonApplication.m11493l(), new File(this.f7132b), true, this.f7135e, false);
                    if (bitmapM11414a != null) {
                        if (!this.f7134d) {
                            return C3205bt.m11191b(bitmapM11414a);
                        }
                        return new LayerDrawable(new Drawable[]{new BitmapDrawable(CommonApplication.m11493l().getResources(), C3205bt.m11191b(bitmapM11414a)), CommonApplication.m11493l().getResources().getDrawable(R.drawable.chat_btn_ams_play)});
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("thumbBitmap2 is null", f7131a);
                    }
                } else {
                    Bitmap bitmapM11414a2 = C3243r.m11414a(CommonApplication.m11493l(), new File(this.f7132b), false, this.f7135e, false);
                    if (bitmapM11414a2 != null) {
                        return new LayerDrawable(new Drawable[]{new BitmapDrawable(CommonApplication.m11493l().getResources(), C3205bt.m11191b(bitmapM11414a2)), CommonApplication.m11493l().getResources().getDrawable(R.drawable.chat_btn_play)});
                    }
                    if (C3250y.f11734b) {
                        C3250y.m11450b("thumbBitmap3 is null", f7131a);
                    }
                }
            } catch (Exception e) {
                C3250y.m11443a(e, f7131a);
            } catch (OutOfMemoryError e2) {
                C3250y.m11443a(e2, f7131a);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[Catch: OutOfMemoryError -> 0x0069, Exception -> 0x007f, TRY_ENTER, TryCatch #2 {Exception -> 0x007f, OutOfMemoryError -> 0x0069, blocks: (B:6:0x002c, B:8:0x0030, B:10:0x003a, B:12:0x0044, B:14:0x0048, B:16:0x0055, B:18:0x005f, B:22:0x0070, B:24:0x0074, B:28:0x0086), top: B:31:0x002c }] */
    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4331a(java.lang.Object r4, boolean r5) {
        /*
            r3 = this;
            boolean r1 = com.sec.chaton.util.C3250y.f11734b
            if (r1 == 0) goto L2a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[onPostDispatch] key: "
            java.lang.StringBuilder r2 = r1.append(r2)
            TK r1 = r3.f12013g
            java.lang.String r1 = (java.lang.String) r1
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r2 = ", value:"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = com.sec.chaton.multimedia.image.C1874c.f7131a
            com.sec.chaton.util.C3250y.m11450b(r1, r2)
        L2a:
            if (r4 == 0) goto L70
            boolean r1 = r4 instanceof android.graphics.Bitmap     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            if (r1 == 0) goto L44
            r0 = r4
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            r1 = r0
            boolean r1 = r1.isRecycled()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            if (r1 != 0) goto L44
            android.widget.ImageView r1 = r3.mo4338h()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            r1.setImageBitmap(r4)     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
        L43:
            return
        L44:
            boolean r1 = r4 instanceof android.graphics.drawable.LayerDrawable     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            if (r1 == 0) goto L70
            r0 = r4
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            r1 = r0
            r2 = 0
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            if (r1 == 0) goto L70
            android.graphics.Bitmap r1 = r1.getBitmap()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            boolean r1 = r1.isRecycled()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            if (r1 != 0) goto L70
            android.widget.ImageView r1 = r3.mo4338h()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            r1.setImageDrawable(r4)     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            goto L43
        L69:
            r1 = move-exception
            java.lang.String r2 = com.sec.chaton.multimedia.image.C1874c.f7131a
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto L43
        L70:
            boolean r1 = r3.f7133c     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            if (r1 == 0) goto L86
            android.widget.ImageView r1 = r3.mo4338h()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            r2 = 2130837955(0x7f0201c3, float:1.7280879E38)
            r1.setImageResource(r2)     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            goto L43
        L7f:
            r1 = move-exception
            java.lang.String r2 = com.sec.chaton.multimedia.image.C1874c.f7131a
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto L43
        L86:
            android.widget.ImageView r1 = r3.mo4338h()     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            r2 = 2130837906(0x7f020192, float:1.728078E38)
            r1.setImageResource(r2)     // Catch: java.lang.OutOfMemoryError -> L69 java.lang.Exception -> L7f
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.image.C1874c.mo4331a(java.lang.Object, boolean):void");
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Object objG = mo4337g();
        if (objG != null) {
            if (objG instanceof Bitmap) {
                Bitmap bitmap2 = (Bitmap) objG;
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                    return;
                }
                return;
            }
            if ((objG instanceof LayerDrawable) && (bitmapDrawable = (BitmapDrawable) ((LayerDrawable) objG).getDrawable(0)) != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }
}
