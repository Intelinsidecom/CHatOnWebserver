package com.sec.chaton.multimedia.doc;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.C1874c;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.util.HashMap;

/* compiled from: FileIconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.doc.e */
/* loaded from: classes.dex */
public class C1798e extends C1874c {

    /* renamed from: a */
    private static final String f6671a = C1798e.class.getSimpleName();

    /* renamed from: b */
    private C1799f f6672b;

    /* renamed from: c */
    private HashMap<EnumC1794a, Integer> f6673c;

    public C1798e(String str, C1799f c1799f) {
        super(str, c1799f.m7422e(), c1799f.m7412a() == EnumC1794a.IMAGE, false);
        this.f6673c = new HashMap<>();
        this.f6672b = c1799f;
        this.f6673c.put(EnumC1794a.DIRECTORY, Integer.valueOf(R.drawable.co_attach_file_folder));
        this.f6673c.put(EnumC1794a.PDF, Integer.valueOf(R.drawable.co_attach_file_pdf));
        this.f6673c.put(EnumC1794a.GUL, Integer.valueOf(R.drawable.co_attach_file_gul));
        this.f6673c.put(EnumC1794a.HWP, Integer.valueOf(R.drawable.co_attach_file_hwp));
        this.f6673c.put(EnumC1794a.PPT, Integer.valueOf(R.drawable.co_attach_file_ppt));
        this.f6673c.put(EnumC1794a.DOC, Integer.valueOf(R.drawable.co_attach_file_word));
        this.f6673c.put(EnumC1794a.XLS, Integer.valueOf(R.drawable.co_attach_file_excel));
        this.f6673c.put(EnumC1794a.TXT, Integer.valueOf(R.drawable.co_attach_file_text));
        this.f6673c.put(EnumC1794a.SNB, Integer.valueOf(R.drawable.co_attach_p_s_note_normal));
    }

    @Override // com.sec.chaton.multimedia.image.C1874c, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        try {
            if (this.f6672b.m7412a() == EnumC1794a.IMAGE) {
                mo4338h().setImageResource(R.drawable.list_jpg_default);
            } else if (this.f6672b.m7412a() == EnumC1794a.VIDEO) {
                mo4338h().setImageResource(R.drawable.list_video_default);
            } else {
                mo4338h().setImageResource(m7411a(this.f6672b.m7412a()));
            }
        } catch (Exception e) {
            C3250y.m11443a(e, f6671a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, f6671a);
        }
    }

    @Override // com.sec.chaton.multimedia.image.C1874c, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        Bitmap thumbnail;
        try {
            if (this.f6672b.m7423f() != null) {
                C1802i c1802iM7423f = this.f6672b.m7423f();
                if (this.f6672b.m7412a() == EnumC1794a.IMAGE) {
                    Bitmap thumbnail2 = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m11493l().getContentResolver(), c1802iM7423f.m7424a(), 3, null);
                    if (thumbnail2 != null) {
                        if (c1802iM7423f.m7425b() > 0) {
                            Bitmap bitmapM11002a = C3162ad.m11002a(thumbnail2, c1802iM7423f.m7425b());
                            if (bitmapM11002a != null) {
                                if (!thumbnail2.isRecycled()) {
                                    thumbnail2.recycle();
                                }
                                return bitmapM11002a;
                            }
                        } else {
                            return thumbnail2;
                        }
                    }
                } else if (this.f6672b.m7412a() == EnumC1794a.VIDEO && (thumbnail = MediaStore.Video.Thumbnails.getThumbnail(CommonApplication.m11493l().getContentResolver(), c1802iM7423f.m7424a(), 3, null)) != null) {
                    return new LayerDrawable(new Drawable[]{new BitmapDrawable(CommonApplication.m11493l().getResources(), thumbnail), CommonApplication.m11493l().getResources().getDrawable(R.drawable.chat_btn_play)});
                }
            } else if (this.f6672b.m7412a() == EnumC1794a.IMAGE || this.f6672b.m7412a() == EnumC1794a.VIDEO) {
                return super.mo4333c();
            }
        } catch (Exception e) {
            C3250y.m11443a(e, f6671a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, f6671a);
        }
        return null;
    }

    @Override // com.sec.chaton.multimedia.image.C1874c, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        if (this.f6672b.m7412a() == EnumC1794a.IMAGE || this.f6672b.m7412a() == EnumC1794a.VIDEO) {
            super.mo4331a(obj, z);
        }
    }

    /* renamed from: a */
    private int m7411a(EnumC1794a enumC1794a) {
        return this.f6673c.containsKey(enumC1794a) ? this.f6673c.get(enumC1794a).intValue() : this.f6673c.get(EnumC1794a.TXT).intValue();
    }
}
