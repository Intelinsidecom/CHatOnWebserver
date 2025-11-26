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
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.trunk.p121c.EnumC4642g;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.io.File;

/* compiled from: TrunkDispatcherTask.java */
/* renamed from: com.sec.chaton.trunk.an */
/* loaded from: classes.dex */
public class C4589an extends AbstractRunnableC5005a<Uri> {

    /* renamed from: a */
    private EnumC4642g f16697a;

    /* renamed from: b */
    private Context f16698b;

    /* renamed from: c */
    private String f16699c;

    /* renamed from: d */
    private BitmapDrawable f16700d;

    /* renamed from: e */
    private boolean f16701e;

    /* renamed from: i */
    private ImageView f16702i;

    public C4589an(Uri uri, EnumC4642g enumC4642g, Boolean bool, ImageView imageView) {
        super(uri);
        this.f16697a = enumC4642g;
        this.f16698b = CommonApplication.m18732r();
        this.f16701e = bool.booleanValue();
        this.f16699c = m18996j().toString();
        this.f16702i = imageView;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        if (C4904y.f17872b) {
            C4904y.m18639b("onPreDispatch()", C4589an.class.getSimpleName());
        }
        if (!this.f16701e) {
            ((ImageView) mo7449h()).setImageBitmap(null);
        }
        if (this.f16702i != null) {
            this.f16702i.setVisibility(8);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d0 -> B:61:0x0021). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00f9 -> B:61:0x0021). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0021 -> B:61:0x0021). Please report as a decompilation issue!!! */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        Bitmap bitmapM18148a;
        if (C4904y.f17872b) {
            C4904y.m18639b("onDispatch()", C4589an.class.getSimpleName());
        }
        if (this.f16699c != null) {
            if (C1427a.f5066d.equals(this.f16699c)) {
                return null;
            }
            if (this.f16699c.contains("file://")) {
                this.f16699c = this.f16699c.substring(7);
            }
            File file = new File(this.f16699c);
            if (!this.f16699c.contains("thumbnail")) {
                String name = file.getName();
                String[] strArrSplit = this.f16699c.split(name);
                if (this.f16697a == EnumC4642g.VIDEO) {
                    name = name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg");
                }
                file = new File(strArrSplit[0] + "thumbnail/" + name);
            }
            try {
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
                bitmapM18148a = null;
            } catch (OutOfMemoryError e2) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                C4904y.m18635a(e2, getClass().getSimpleName());
                bitmapM18148a = null;
            }
            if (file.exists()) {
                if (this.f16697a == EnumC4642g.IMAGE || this.f16697a == EnumC4642g.AMS) {
                    bitmapM18148a = C4812ad.m18148a(m18996j());
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inDither = true;
                    options.inPurgeable = true;
                    BitmapFactory.decodeFile(file.getPath(), options);
                    bitmapM18148a = ThumbnailUtils.createVideoThumbnail(this.f16699c, 1);
                }
                return bitmapM18148a;
            }
            try {
                if (this.f16697a == EnumC4642g.IMAGE || this.f16697a == EnumC4642g.AMS) {
                    bitmapM18148a = C4812ad.m18148a(m18996j());
                } else if (this.f16697a == EnumC4642g.VIDEO) {
                    if (!this.f16701e && mo7449h().getId() != R.id.trunkContentMainImage_f) {
                        bitmapM18148a = C4894o.m18598a(this.f16698b, new File(this.f16699c), false, true, false);
                    } else {
                        bitmapM18148a = ThumbnailUtils.createVideoThumbnail(this.f16699c, 1);
                    }
                }
            } catch (Exception e3) {
                C4904y.m18635a(e3, getClass().getSimpleName());
                bitmapM18148a = null;
            } catch (OutOfMemoryError e4) {
                C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                C4904y.m18635a(e4, getClass().getSimpleName());
                bitmapM18148a = null;
            }
            return bitmapM18148a;
        }
        bitmapM18148a = null;
        return bitmapM18148a;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Value: " + obj, C4589an.class.getSimpleName());
        }
        if (this.f16702i != null) {
            this.f16702i.setVisibility(8);
        }
        try {
            if (obj != null) {
                if (obj instanceof Bitmap) {
                    if (((Bitmap) obj).isRecycled()) {
                        if (C4904y.f17872b) {
                            C4904y.m18639b(" This bitmap is already recycled. ", C4589an.class.getSimpleName());
                            return;
                        }
                        return;
                    }
                    if (this.f16701e && mo7449h().getId() == R.id.image2) {
                        m17532a((ImageView) mo7449h(), (Bitmap) obj);
                    } else {
                        ((ImageView) mo7449h()).setImageBitmap((Bitmap) obj);
                    }
                    if (this.f16697a == EnumC4642g.VIDEO) {
                        if (this.f16702i != null) {
                            this.f16702i.setImageResource(R.drawable.chat_btn_play);
                            this.f16702i.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    if (this.f16697a == EnumC4642g.AMS && this.f16702i != null) {
                        this.f16702i.setImageResource(R.drawable.chat_btn_ams_play);
                        this.f16702i.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f16701e) {
                if (this.f16697a == EnumC4642g.IMAGE || this.f16697a == EnumC4642g.AMS) {
                    ((ImageView) mo7449h()).setImageResource(R.drawable.turnk_no_image_default);
                } else if (this.f16697a == EnumC4642g.VIDEO) {
                    ((ImageView) mo7449h()).setImageResource(R.drawable.turnk_no_veido_default);
                }
            } else if (this.f16697a == EnumC4642g.IMAGE || this.f16697a == EnumC4642g.AMS) {
                ((ImageView) mo7449h()).setImageResource(R.drawable.trunk_image_default);
            } else if (this.f16697a == EnumC4642g.VIDEO) {
                ((ImageView) mo7449h()).setImageResource(R.drawable.trunk_video_default);
            }
            if (this.f16697a == EnumC4642g.AMS) {
                if (this.f16702i != null) {
                    this.f16702i.setImageResource(R.drawable.chat_btn_ams_play);
                    this.f16702i.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f16697a == EnumC4642g.VIDEO) {
                if (this.f16702i != null) {
                    this.f16702i.setImageResource(R.drawable.chat_btn_play);
                    this.f16702i.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.f16702i != null) {
                this.f16702i.setVisibility(8);
            }
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
        } catch (OutOfMemoryError e2) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e2, getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m17532a(ImageView imageView, Bitmap bitmap) {
        Display defaultDisplay = ((WindowManager) GlobalApplication.m10279a().getSystemService("window")).getDefaultDisplay();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layoutParams.height = (int) ((((defaultDisplay.getWidth() - C5034k.m19088a(10.0f)) - C5034k.m19097b(10.0f)) * height) / width);
            imageView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        Bitmap bitmap;
        Object objG = mo7448g();
        if (objG != null) {
            if (objG instanceof Bitmap) {
                if (!((Bitmap) objG).isRecycled()) {
                    ((Bitmap) objG).recycle();
                }
            } else if ((objG instanceof Drawable) && this.f16700d != null && (bitmap = this.f16700d.getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }
}
