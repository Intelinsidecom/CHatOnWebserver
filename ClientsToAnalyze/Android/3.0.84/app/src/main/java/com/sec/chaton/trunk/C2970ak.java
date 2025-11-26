package com.sec.chaton.trunk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.trunk.p061c.EnumC3026g;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3243r;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.widget.C3641ai;
import java.io.File;

/* compiled from: TrunkDispatcherTask.java */
/* renamed from: com.sec.chaton.trunk.ak */
/* loaded from: classes.dex */
public class C2970ak extends AbstractRunnableC3324a<Uri> {

    /* renamed from: a */
    private EnumC3026g f10748a;

    /* renamed from: b */
    private Context f10749b;

    /* renamed from: c */
    private String f10750c;

    /* renamed from: d */
    private BitmapDrawable f10751d;

    /* renamed from: e */
    private boolean f10752e;

    /* renamed from: i */
    private ImageView f10753i;

    public C2970ak(Uri uri, EnumC3026g enumC3026g, Boolean bool, ImageView imageView) {
        super(uri);
        this.f10748a = enumC3026g;
        this.f10749b = CommonApplication.m11493l();
        this.f10752e = bool.booleanValue();
        this.f10750c = mo7454i().toString();
        this.f10753i = imageView;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        if (C3250y.f11734b) {
            C3250y.m11450b("onPreDispatch()", C2970ak.class.getSimpleName());
        }
        if (!this.f10752e) {
            ((ImageView) mo4338h()).setImageBitmap(null);
        }
        if (this.f10753i != null) {
            this.f10753i.setVisibility(8);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c9 -> B:59:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f2 -> B:59:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0020 -> B:59:0x0020). Please report as a decompilation issue!!! */
    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        Bitmap bitmapM11003a;
        if (C3250y.f11734b) {
            C3250y.m11450b("onDispatch()", C2970ak.class.getSimpleName());
        }
        if (this.f10750c != null) {
            if (C0816a.f3113b.equals(this.f10750c)) {
                return null;
            }
            if (this.f10750c.contains("file://")) {
                this.f10750c = this.f10750c.substring(7);
            }
            File file = new File(this.f10750c);
            if (!this.f10750c.contains("thumbnail")) {
                String name = file.getName();
                String[] strArrSplit = this.f10750c.split(name);
                if (this.f10748a == EnumC3026g.VIDEO) {
                    name = name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg");
                }
                file = new File(strArrSplit[0] + "thumbnail/" + name);
            }
            try {
            } catch (Exception e) {
                C3250y.m11443a(e, getClass().getSimpleName());
                bitmapM11003a = null;
            } catch (OutOfMemoryError e2) {
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                C3250y.m11443a(e2, getClass().getSimpleName());
                bitmapM11003a = null;
            }
            if (file.exists()) {
                if (this.f10748a == EnumC3026g.IMAGE || this.f10748a == EnumC3026g.AMS) {
                    bitmapM11003a = C3162ad.m11003a(mo7454i());
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inDither = true;
                    options.inPurgeable = true;
                    BitmapFactory.decodeFile(file.getPath(), options);
                    bitmapM11003a = ThumbnailUtils.createVideoThumbnail(this.f10750c, 1);
                }
                return bitmapM11003a;
            }
            try {
                if (this.f10748a == EnumC3026g.IMAGE || this.f10748a == EnumC3026g.AMS) {
                    bitmapM11003a = C3162ad.m11003a(mo7454i());
                } else if (this.f10748a == EnumC3026g.VIDEO) {
                    if (!this.f10752e) {
                        bitmapM11003a = C3243r.m11414a(this.f10749b, new File(this.f10750c), false, true, false);
                    } else {
                        bitmapM11003a = ThumbnailUtils.createVideoThumbnail(this.f10750c, 1);
                    }
                }
            } catch (Exception e3) {
                C3250y.m11443a(e3, getClass().getSimpleName());
                bitmapM11003a = null;
            } catch (OutOfMemoryError e4) {
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
                C3250y.m11443a(e4, getClass().getSimpleName());
                bitmapM11003a = null;
            }
            return bitmapM11003a;
        }
        bitmapM11003a = null;
        return bitmapM11003a;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("Value: " + obj, C2970ak.class.getSimpleName());
        }
        if (this.f10753i != null) {
            this.f10753i.setVisibility(8);
        }
        try {
            if (obj != null) {
                if (obj instanceof Bitmap) {
                    if (((Bitmap) obj).isRecycled()) {
                        if (C3250y.f11734b) {
                            C3250y.m11450b(" This bitmap is already recycled. ", C2970ak.class.getSimpleName());
                            return;
                        }
                        return;
                    }
                    if (this.f10752e) {
                        m10436a((ImageView) mo4338h(), (Bitmap) obj);
                    } else {
                        ((ImageView) mo4338h()).setImageBitmap((Bitmap) obj);
                    }
                    if (this.f10748a == EnumC3026g.VIDEO) {
                        if (this.f10753i != null) {
                            this.f10753i.setImageResource(R.drawable.chat_btn_play);
                            this.f10753i.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    if (this.f10748a == EnumC3026g.AMS && this.f10753i != null) {
                        this.f10753i.setImageResource(R.drawable.chat_btn_ams_play);
                        this.f10753i.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f10752e) {
                if (this.f10748a == EnumC3026g.IMAGE || this.f10748a == EnumC3026g.AMS) {
                    ((ImageView) mo4338h()).setImageResource(R.drawable.turnk_no_image_default);
                } else if (this.f10748a == EnumC3026g.VIDEO) {
                    ((ImageView) mo4338h()).setImageResource(R.drawable.turnk_no_veido_default);
                }
            } else if (this.f10748a == EnumC3026g.IMAGE || this.f10748a == EnumC3026g.AMS) {
                ((ImageView) mo4338h()).setImageResource(R.drawable.trunk_image_default);
            } else if (this.f10748a == EnumC3026g.VIDEO) {
                ((ImageView) mo4338h()).setImageResource(R.drawable.trunk_video_default);
            }
            if (this.f10748a == EnumC3026g.AMS) {
                if (this.f10753i != null) {
                    this.f10753i.setImageResource(R.drawable.chat_btn_ams_play);
                    this.f10753i.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f10748a == EnumC3026g.VIDEO) {
                if (this.f10753i != null) {
                    this.f10753i.setImageResource(R.drawable.chat_btn_play);
                    this.f10753i.setVisibility(0);
                    return;
                }
                return;
            }
            this.f10753i.setVisibility(8);
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m10436a(ImageView imageView, Bitmap bitmap) {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m6447a().getSystemService("window")).getDefaultDisplay();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            layoutParams.width = (int) (defaultDisplay.getWidth() - C3172an.m11085a(20.0f));
            layoutParams.height = (int) C3172an.m11085a(220.0f);
            imageView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        Bitmap bitmap;
        Object objG = mo4337g();
        if (objG != null) {
            if (objG instanceof Bitmap) {
                if (!((Bitmap) objG).isRecycled()) {
                    ((Bitmap) objG).recycle();
                }
            } else if ((objG instanceof Drawable) && this.f10751d != null && (bitmap = this.f10751d.getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
