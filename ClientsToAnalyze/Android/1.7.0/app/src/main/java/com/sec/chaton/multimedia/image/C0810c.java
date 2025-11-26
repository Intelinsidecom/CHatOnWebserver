package com.sec.chaton.multimedia.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.p007b.p008a.p011c.AbstractRunnableC0120e;
import com.sec.widget.C1619g;
import java.io.File;

/* compiled from: ImageDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.c */
/* loaded from: classes.dex */
public class C0810c extends AbstractRunnableC0120e {

    /* renamed from: d */
    private static final String f2745d = C0810c.class.getSimpleName();

    /* renamed from: e */
    private String f2746e;

    /* renamed from: f */
    private boolean f2747f;

    /* renamed from: g */
    private boolean f2748g;

    /* renamed from: h */
    private BitmapDrawable f2749h;

    /* renamed from: i */
    private boolean f2750i;

    public C0810c(String str, String str2, boolean z) {
        super(str);
        this.f2746e = str2;
        this.f2747f = z;
        if (C1341p.f4578b) {
            C1341p.m4658b("key: + " + str + ", content: " + this.f2746e + ", isImage:" + z, f2745d);
        }
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: a */
    public void mo605a() {
        mo612e().setImageDrawable(null);
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: b */
    public Object mo610b() throws Throwable {
        Bitmap bitmapM4580a;
        Drawable drawable;
        if (C1341p.f4578b) {
            C1341p.m4658b("content : " + this.f2746e, f2745d);
        }
        if (this.f2746e != null) {
            if (C0684a.f2332c.equals(this.f2746e)) {
                this.f2748g = true;
                return null;
            }
            if (this.f2746e.contains("file://")) {
                this.f2746e = this.f2746e.substring(7);
            }
            if (this.f2747f && C1165c.m4207c(this.f2746e)) {
                this.f2750i = true;
            }
            if (C1341p.f4578b) {
                C1341p.m4658b("mIsAms : " + this.f2750i, f2745d);
            }
            File file = new File(this.f2746e);
            if (!this.f2746e.contains("thumbnail")) {
                String name = file.getName();
                String[] strArrSplit = this.f2746e.split(name);
                if (!this.f2747f) {
                    name = name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg");
                }
                file = new File(strArrSplit[0] + "thumbnail/" + name);
            }
            if (file.exists()) {
                if (C1341p.f4578b) {
                    C1341p.m4658b("thumbnail file exists.", f2745d);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inDither = true;
                options.inPurgeable = true;
                bitmapM4580a = BitmapFactory.decodeFile(file.getPath(), options);
                if (bitmapM4580a != null) {
                    if (this.f2747f && !this.f2750i) {
                        return C1348w.m4682a(bitmapM4580a);
                    }
                    this.f2749h = new BitmapDrawable(GlobalApplication.m3100a().getResources(), C1348w.m4682a(bitmapM4580a));
                    if (this.f2750i) {
                        drawable = GlobalApplication.m3100a().getResources().getDrawable(R.drawable.bubble_play_ams);
                    } else {
                        drawable = GlobalApplication.m3100a().getResources().getDrawable(R.drawable.chat_bubble_play);
                    }
                    return new LayerDrawable(new Drawable[]{this.f2749h, drawable});
                }
            } else {
                bitmapM4580a = null;
            }
            try {
                try {
                    if (this.f2747f) {
                        Bitmap bitmapM4580a2 = C1324bt.m4580a(GlobalApplication.m3100a(), new File(this.f2746e), true);
                        if (bitmapM4580a2 != null) {
                            if (!this.f2750i) {
                                return C1348w.m4682a(bitmapM4580a2);
                            }
                            this.f2749h = new BitmapDrawable(GlobalApplication.m3100a().getResources(), C1348w.m4682a(bitmapM4580a2));
                            return new LayerDrawable(new Drawable[]{this.f2749h, GlobalApplication.m3100a().getResources().getDrawable(R.drawable.bubble_play_ams)});
                        }
                    } else {
                        try {
                            bitmapM4580a = C1324bt.m4580a(GlobalApplication.m3100a(), new File(this.f2746e), false);
                        } catch (OutOfMemoryError e) {
                            C1619g.m5888a(GlobalApplication.m3100a(), R.string.chat_view_memory_error, 0).show();
                        }
                        if (bitmapM4580a != null) {
                            this.f2749h = new BitmapDrawable(GlobalApplication.m3100a().getResources(), C1348w.m4682a(bitmapM4580a));
                            return new LayerDrawable(new Drawable[]{this.f2749h, GlobalApplication.m3100a().getResources().getDrawable(R.drawable.chat_bubble_play)});
                        }
                    }
                } catch (OutOfMemoryError e2) {
                    C1619g.m5888a(GlobalApplication.m3100a(), R.string.chat_view_memory_error, 0).show();
                }
            } catch (Exception e3) {
                C1341p.m4653a(e3, f2745d);
            }
        }
        return null;
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: a */
    public void mo608a(Object obj, boolean z) {
        if (C1341p.f4578b) {
            C1341p.m4658b("key: " + ((String) this.f230b) + ", value:" + obj, f2745d);
        }
        if (obj != null) {
            if (obj instanceof Bitmap) {
                mo612e().setImageBitmap((Bitmap) obj);
                return;
            } else {
                if (obj instanceof Drawable) {
                    mo612e().setImageDrawable((Drawable) obj);
                    return;
                }
                return;
            }
        }
        if (this.f2747f) {
            if (this.f2748g) {
                mo612e().setImageResource(R.drawable.slideshow_error_top);
                return;
            } else {
                mo612e().setImageBitmap(null);
                return;
            }
        }
        mo612e().setImageResource(R.drawable.messenger_chat_video);
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: c */
    public void mo611c() {
        Bitmap bitmap;
        Object objG = m614g();
        if (objG != null) {
            if (objG instanceof Bitmap) {
                ((Bitmap) objG).recycle();
            } else if ((objG instanceof Drawable) && this.f2749h != null && (bitmap = this.f2749h.getBitmap()) != null) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public ImageView mo612e() {
        return (ImageView) super.mo612e();
    }
}
