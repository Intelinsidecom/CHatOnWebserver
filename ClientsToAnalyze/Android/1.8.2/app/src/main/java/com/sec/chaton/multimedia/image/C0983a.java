package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;
import com.sec.widget.C2153y;
import java.io.File;

/* compiled from: ImageDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.a */
/* loaded from: classes.dex */
public class C0983a extends AbstractRunnableC1820a {

    /* renamed from: a */
    private static final String f3636a = C0983a.class.getSimpleName();

    /* renamed from: b */
    private String f3637b;

    /* renamed from: f */
    private boolean f3638f;

    /* renamed from: g */
    private boolean f3639g;

    /* renamed from: h */
    private BitmapDrawable f3640h;

    /* renamed from: i */
    private boolean f3641i;

    /* renamed from: j */
    private boolean f3642j;

    public C0983a(String str, String str2, boolean z, boolean z2) {
        super(str);
        this.f3637b = str2;
        this.f3638f = z;
        this.f3642j = z2;
        if (C1786r.f6452b) {
            C1786r.m6061b("key: + " + str + ", content: " + this.f3637b + ", isImage:" + z + ", saveFile: " + z2, f3636a);
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: b */
    public void mo3768b() {
        mo3775i().setImageDrawable(null);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() throws Throwable {
        Bitmap bitmapM6031a;
        Drawable drawable;
        if (C1786r.f6452b) {
            C1786r.m6061b("content : " + this.f3637b, f3636a);
        }
        if (this.f3637b != null) {
            if (C0452a.f1724c.equals(this.f3637b)) {
                this.f3639g = true;
                return null;
            }
            if (this.f3637b.contains("file://")) {
                this.f3637b = this.f3637b.substring(7);
            }
            if (this.f3638f && C1598g.m5509c(this.f3637b)) {
                this.f3641i = true;
            }
            if (C1786r.f6452b) {
                C1786r.m6061b("mIsAms : " + this.f3641i, f3636a);
            }
            File file = new File(this.f3637b);
            if (!this.f3637b.contains("thumbnail")) {
                String name = file.getName();
                String[] strArrSplit = this.f3637b.split(name);
                if (!this.f3638f) {
                    name = name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg");
                }
                file = new File(strArrSplit[0] + "thumbnail/" + name);
            }
            if (file.exists()) {
                if (C1786r.f6452b) {
                    C1786r.m6061b("thumbnail file exists.", f3636a);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inDither = true;
                options.inPurgeable = true;
                bitmapM6031a = BitmapFactory.decodeFile(file.getPath(), options);
                if (GlobalApplication.m3265f()) {
                    bitmapM6031a = Bitmap.createScaledBitmap(bitmapM6031a, 120, 120, true);
                }
                if (bitmapM6031a != null) {
                    if (this.f3638f && !this.f3641i) {
                        return C1746bb.m5942a(bitmapM6031a);
                    }
                    this.f3640h = new BitmapDrawable(GlobalApplication.m3260b().getResources(), C1746bb.m5942a(bitmapM6031a));
                    if (this.f3641i) {
                        drawable = GlobalApplication.m3260b().getResources().getDrawable(R.drawable.bubble_play_ams);
                    } else {
                        drawable = GlobalApplication.m3260b().getResources().getDrawable(R.drawable.chaton_icon_play);
                    }
                    return new LayerDrawable(new Drawable[]{this.f3640h, drawable});
                }
            } else {
                bitmapM6031a = null;
            }
            try {
                try {
                    if (this.f3638f) {
                        Bitmap bitmapM6031a2 = C1783o.m6031a(GlobalApplication.m3260b(), new File(this.f3637b), true, this.f3642j);
                        if (GlobalApplication.m3265f()) {
                            bitmapM6031a2 = Bitmap.createScaledBitmap(bitmapM6031a2, 120, 120, true);
                        }
                        if (bitmapM6031a2 != null) {
                            if (!this.f3641i) {
                                return C1746bb.m5942a(bitmapM6031a2);
                            }
                            this.f3640h = new BitmapDrawable(GlobalApplication.m3260b().getResources(), C1746bb.m5942a(bitmapM6031a2));
                            return new LayerDrawable(new Drawable[]{this.f3640h, GlobalApplication.m3260b().getResources().getDrawable(R.drawable.bubble_play_ams)});
                        }
                    } else {
                        try {
                            bitmapM6031a = C1783o.m6031a(GlobalApplication.m3260b(), new File(this.f3637b), false, this.f3642j);
                        } catch (OutOfMemoryError e) {
                            C2153y.m7535a(GlobalApplication.m3260b(), R.string.chat_view_memory_error, 0).show();
                        }
                        if (bitmapM6031a != null) {
                            this.f3640h = new BitmapDrawable(GlobalApplication.m3260b().getResources(), C1746bb.m5942a(bitmapM6031a));
                            return new LayerDrawable(new Drawable[]{this.f3640h, GlobalApplication.m3260b().getResources().getDrawable(R.drawable.chaton_icon_play)});
                        }
                    }
                } catch (OutOfMemoryError e2) {
                    C2153y.m7535a(GlobalApplication.m3260b(), R.string.chat_view_memory_error, 0).show();
                }
            } catch (Exception e3) {
                C1786r.m6056a(e3, f3636a);
            }
        }
        return null;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: a */
    public void mo3767a(Object obj, boolean z) {
        if (C1786r.f6452b) {
            C1786r.m6061b("key: " + ((String) this.f6523d) + ", value:" + obj, f3636a);
        }
        if (obj != null) {
            if (obj instanceof Bitmap) {
                mo3775i().setImageBitmap((Bitmap) obj);
                return;
            } else {
                if (obj instanceof Drawable) {
                    mo3775i().setImageDrawable((Drawable) obj);
                    return;
                }
                return;
            }
        }
        if (this.f3638f) {
            if (this.f3639g) {
                mo3775i().setImageResource(R.drawable.slideshow_error_top);
                return;
            } else {
                mo3775i().setImageBitmap(null);
                return;
            }
        }
        mo3775i().setImageResource(R.drawable.messenger_chat_video);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: d */
    public void mo3770d() {
        Bitmap bitmap;
        Object objH = mo3774h();
        if (objH != null) {
            if (objH instanceof Bitmap) {
                ((Bitmap) objH).recycle();
            } else if ((objH instanceof Drawable) && this.f3640h != null && (bitmap = this.f3640h.getBitmap()) != null) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo3775i() {
        return (ImageView) super.mo3775i();
    }
}
