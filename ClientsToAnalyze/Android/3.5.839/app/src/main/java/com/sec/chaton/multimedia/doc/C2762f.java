package com.sec.chaton.multimedia.doc;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.HashMap;

/* compiled from: FileIconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.doc.f */
/* loaded from: classes.dex */
public class C2762f extends C2844d {

    /* renamed from: a */
    private static final String f9963a = C2762f.class.getSimpleName();

    /* renamed from: c */
    private static HashMap<EnumC2758b, Integer> f9964c = new HashMap<>();

    /* renamed from: b */
    private C2763g f9965b;

    static {
        f9964c.put(EnumC2758b.DIRECTORY, Integer.valueOf(R.drawable.co_attach_file_folder));
        f9964c.put(EnumC2758b.DOC, Integer.valueOf(R.drawable.co_attach_file_word));
        f9964c.put(EnumC2758b.GUL, Integer.valueOf(R.drawable.co_attach_file_gul));
        f9964c.put(EnumC2758b.HWP, Integer.valueOf(R.drawable.co_attach_file_hwp));
        f9964c.put(EnumC2758b.PDF, Integer.valueOf(R.drawable.co_attach_file_pdf));
        f9964c.put(EnumC2758b.PPT, Integer.valueOf(R.drawable.co_attach_file_ppt));
        f9964c.put(EnumC2758b.XLS, Integer.valueOf(R.drawable.co_attach_file_excel));
        f9964c.put(EnumC2758b.TXT, Integer.valueOf(R.drawable.co_attach_file_text));
        f9964c.put(EnumC2758b.SNB, Integer.valueOf(R.drawable.co_attach_p_s_note_normal));
        f9964c.put(EnumC2758b.SPD, Integer.valueOf(R.drawable.co_attach_p_s_note_normal));
        f9964c.put(EnumC2758b.SCC, Integer.valueOf(R.drawable.co_attach_file_scc));
    }

    public C2762f(String str, C2763g c2763g) {
        super(str, c2763g.m11616e(), c2763g.m11606a() == EnumC2758b.IMAGE, false);
        this.f9965b = c2763g;
    }

    @Override // com.sec.chaton.multimedia.image.C2844d, com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        try {
            if (this.f9965b.m11606a() == EnumC2758b.IMAGE) {
                mo7449h().setImageResource(R.drawable.list_jpg_default);
            } else if (this.f9965b.m11606a() == EnumC2758b.VIDEO) {
                mo7449h().setImageResource(R.drawable.list_video_default);
            } else {
                mo7449h().setImageResource(m11605a(this.f9965b.m11606a()));
            }
        } catch (Exception e) {
            C4904y.m18635a(e, f9963a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, f9963a);
        }
    }

    @Override // com.sec.chaton.multimedia.image.C2844d, com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        Bitmap thumbnail;
        try {
            if (this.f9965b.m11617f() != null) {
                C2766j c2766jM11617f = this.f9965b.m11617f();
                if (this.f9965b.m11606a() == EnumC2758b.IMAGE) {
                    Bitmap thumbnail2 = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m18732r().getContentResolver(), c2766jM11617f.m11619a(), 3, null);
                    if (thumbnail2 != null) {
                        if (c2766jM11617f.m11620b() > 0) {
                            Bitmap bitmapM18147a = C4812ad.m18147a(thumbnail2, c2766jM11617f.m11620b());
                            if (bitmapM18147a != null) {
                                if (!thumbnail2.isRecycled()) {
                                    thumbnail2.recycle();
                                }
                                return bitmapM18147a;
                            }
                        } else {
                            return thumbnail2;
                        }
                    }
                } else if (this.f9965b.m11606a() == EnumC2758b.VIDEO && (thumbnail = MediaStore.Video.Thumbnails.getThumbnail(CommonApplication.m18732r().getContentResolver(), c2766jM11617f.m11619a(), 3, null)) != null) {
                    return new LayerDrawable(new Drawable[]{new BitmapDrawable(CommonApplication.m18732r().getResources(), thumbnail), CommonApplication.m18732r().getResources().getDrawable(R.drawable.chat_btn_play)});
                }
            } else if (this.f9965b.m11606a() == EnumC2758b.IMAGE || this.f9965b.m11606a() == EnumC2758b.VIDEO) {
                return super.mo7444c();
            }
        } catch (Exception e) {
            C4904y.m18635a(e, f9963a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, f9963a);
        }
        return null;
    }

    @Override // com.sec.chaton.multimedia.image.C2844d, com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        if (this.f9965b.m11606a() == EnumC2758b.IMAGE || this.f9965b.m11606a() == EnumC2758b.VIDEO) {
            super.mo7443a(obj, z);
        }
    }

    /* renamed from: a */
    public static int m11605a(EnumC2758b enumC2758b) {
        return f9964c.containsKey(enumC2758b) ? f9964c.get(enumC2758b).intValue() : f9964c.get(EnumC2758b.TXT).intValue();
    }
}
