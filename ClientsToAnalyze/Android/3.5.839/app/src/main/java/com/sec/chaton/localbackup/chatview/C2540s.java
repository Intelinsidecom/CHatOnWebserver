package com.sec.chaton.localbackup.chatview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.doc.C2762f;
import com.sec.chaton.multimedia.doc.EnumC2758b;
import com.sec.chaton.multimedia.image.C2844d;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4904y;
import java.util.HashMap;

/* compiled from: IconDispatcherTask.java */
/* renamed from: com.sec.chaton.localbackup.chatview.s */
/* loaded from: classes.dex */
public class C2540s extends C2844d {

    /* renamed from: a */
    private static final String f9135a = C2540s.class.getSimpleName();

    /* renamed from: b */
    private EnumC2214ab f9136b;

    /* renamed from: c */
    private EnumC2758b f9137c;

    /* renamed from: d */
    private long f9138d;

    /* renamed from: e */
    private HashMap<EnumC2214ab, Integer> f9139e;

    public C2540s(String str, String str2, boolean z, boolean z2, EnumC2214ab enumC2214ab, EnumC2758b enumC2758b, long j) {
        super(str, str2, z, z2, enumC2214ab);
        this.f9139e = new HashMap<>();
        this.f9136b = enumC2214ab;
        this.f9137c = enumC2758b;
        this.f9138d = j;
        this.f9139e.put(EnumC2214ab.ANICON, Integer.valueOf(R.drawable.anicon_default));
        this.f9139e.put(EnumC2214ab.CALENDAR, Integer.valueOf(R.drawable.co_attach_p_calendar_normal));
        this.f9139e.put(EnumC2214ab.CONTACT, Integer.valueOf(R.drawable.co_attach_p_contact_normal));
        this.f9139e.put(EnumC2214ab.GEO, Integer.valueOf(R.drawable.co_attach_p_location_normal));
        this.f9139e.put(EnumC2214ab.APPLINK, Integer.valueOf(R.drawable.chat_lcon_link));
    }

    @Override // com.sec.chaton.multimedia.image.C2844d, com.sec.common.p132g.AbstractRunnableC5005a
    @SuppressLint({"NewApi"})
    /* renamed from: m_ */
    public void mo7450m_() {
        AnimationDrawable animationDrawable;
        if (Build.VERSION.SDK_INT < 16) {
            mo7449h().setBackgroundDrawable(null);
        } else {
            mo7449h().setBackground(null);
        }
        switch (this.f9136b) {
            case AMS:
            case IMAGE:
            case VIDEO:
                super.mo7450m_();
                break;
            case FILE:
            case DOCUMENT:
                mo7449h().setImageResource(C2762f.m11605a(this.f9137c));
                break;
            case AUDIO:
                if (C2522a.m10927a().m10930a(this.f9138d)) {
                    mo7449h().setImageResource(R.drawable.chat_push_to_talk_play);
                } else {
                    mo7449h().setImageResource(R.drawable.chat_attach_btn_icon_walkie_talkie);
                }
                mo7449h().setBackgroundResource(R.drawable.chat_attach_btn_bg);
                if (C2522a.m10927a().m10931b(this.f9138d) != null && (animationDrawable = (AnimationDrawable) mo7449h().getDrawable()) != null && !animationDrawable.isRunning()) {
                    animationDrawable.start();
                    break;
                }
                break;
            case GEO:
                if (C1427a.m7518a()) {
                    mo7449h().setImageResource(m10944a(this.f9136b));
                    break;
                } else {
                    mo7449h().setImageResource(R.drawable.co_attach_p_alert_normal);
                    break;
                }
            default:
                mo7449h().setImageResource(m10944a(this.f9136b));
                if (Build.VERSION.SDK_INT < 16) {
                    mo7449h().setBackgroundDrawable(null);
                    break;
                } else {
                    mo7449h().setBackground(null);
                    break;
                }
        }
    }

    @Override // com.sec.chaton.multimedia.image.C2844d, com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() {
        if (this.f9136b == EnumC2214ab.AMS || this.f9136b == EnumC2214ab.IMAGE || this.f9136b == EnumC2214ab.VIDEO) {
            return super.mo7444c();
        }
        return null;
    }

    @Override // com.sec.chaton.multimedia.image.C2844d, com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) {
        switch (this.f9136b) {
            case AMS:
                if (obj == null) {
                    mo7449h().setImageResource(R.drawable.ams_default);
                    break;
                } else {
                    m10945b(obj);
                    break;
                }
            case IMAGE:
                if (obj == null) {
                    mo7449h().setImageResource(R.drawable.image_default);
                    break;
                } else {
                    m10945b(obj);
                    break;
                }
            case VIDEO:
                if (obj == null) {
                    mo7449h().setImageResource(R.drawable.co_attach_p_video_normal);
                    break;
                } else {
                    m10945b(obj);
                    break;
                }
        }
    }

    /* renamed from: b */
    private void m10945b(Object obj) {
        try {
            if ((obj instanceof Bitmap) && !((Bitmap) obj).isRecycled()) {
                mo7449h().setImageBitmap((Bitmap) obj);
            } else if (obj instanceof Drawable) {
                mo7449h().setImageDrawable((Drawable) obj);
            }
        } catch (Exception e) {
            C4904y.m18635a(e, f9135a);
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, f9135a);
        }
    }

    /* renamed from: a */
    private int m10944a(EnumC2214ab enumC2214ab) {
        return this.f9139e.containsKey(enumC2214ab) ? this.f9139e.get(enumC2214ab).intValue() : R.drawable.trunk_no_image_default;
    }
}
