package com.sec.chaton.localbackup.chatview;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.sec.chaton.R;
import com.sec.chaton.chat.p023a.C0913q;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.image.C1874c;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3250y;
import java.util.HashMap;

/* compiled from: IconDispatcherTask.java */
/* renamed from: com.sec.chaton.localbackup.chatview.s */
/* loaded from: classes.dex */
public class C1638s extends C1874c {

    /* renamed from: a */
    private static final String f6092a = C1638s.class.getSimpleName();

    /* renamed from: b */
    private EnumC1455w f6093b;

    /* renamed from: c */
    private EnumC1794a f6094c;

    /* renamed from: d */
    private long f6095d;

    /* renamed from: e */
    private HashMap<EnumC1455w, Integer> f6096e;

    public C1638s(String str, String str2, boolean z, boolean z2, EnumC1455w enumC1455w, EnumC1794a enumC1794a, long j) {
        super(str, str2, z, z2, enumC1455w);
        this.f6096e = new HashMap<>();
        this.f6093b = enumC1455w;
        this.f6094c = enumC1794a;
        this.f6095d = j;
        this.f6096e.put(EnumC1455w.ANICON, Integer.valueOf(R.drawable.anicon_default));
        this.f6096e.put(EnumC1455w.CALENDAR, Integer.valueOf(R.drawable.co_attach_p_calendar_normal));
        this.f6096e.put(EnumC1455w.CONTACT, Integer.valueOf(R.drawable.co_attach_p_contact_normal));
        this.f6096e.put(EnumC1455w.GEO, Integer.valueOf(R.drawable.co_attach_p_location_normal));
        this.f6096e.put(EnumC1455w.APPLINK, Integer.valueOf(R.drawable.chat_lcon_link));
    }

    @Override // com.sec.chaton.multimedia.image.C1874c, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        AnimationDrawable animationDrawable;
        if (Build.VERSION.SDK_INT < 16) {
            mo4338h().setBackgroundDrawable(null);
        } else {
            mo4338h().setBackground(null);
        }
        switch (this.f6093b) {
            case AMS:
            case IMAGE:
            case VIDEO:
                super.mo4332b();
                break;
            case FILE:
            case DOCUMENT:
                mo4338h().setImageResource(m6913a(this.f6094c));
                break;
            case AUDIO:
                if (C1620a.m6897a().m6900a(this.f6095d)) {
                    mo4338h().setImageResource(R.drawable.chat_push_to_talk_play);
                } else {
                    mo4338h().setImageResource(R.drawable.chat_attach_btn_icon_walkie_talkie);
                }
                mo4338h().setBackgroundResource(R.drawable.chat_attach_btn_bg);
                if (C1620a.m6897a().m6901b(this.f6095d) != null && (animationDrawable = (AnimationDrawable) mo4338h().getDrawable()) != null && !animationDrawable.isRunning()) {
                    animationDrawable.start();
                    break;
                }
                break;
            case GEO:
                if (C0816a.m4365a()) {
                    mo4338h().setImageResource(m6912a(this.f6093b));
                    break;
                } else {
                    mo4338h().setImageResource(R.drawable.co_attach_p_alert_normal);
                    break;
                }
            default:
                mo4338h().setImageResource(m6912a(this.f6093b));
                if (Build.VERSION.SDK_INT < 16) {
                    mo4338h().setBackgroundDrawable(null);
                    break;
                } else {
                    mo4338h().setBackground(null);
                    break;
                }
        }
    }

    @Override // com.sec.chaton.multimedia.image.C1874c, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        if (this.f6093b == EnumC1455w.AMS || this.f6093b == EnumC1455w.IMAGE || this.f6093b == EnumC1455w.VIDEO) {
            return super.mo4333c();
        }
        return null;
    }

    @Override // com.sec.chaton.multimedia.image.C1874c, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) {
        switch (this.f6093b) {
            case AMS:
                if (obj == null) {
                    mo4338h().setImageResource(R.drawable.ams_default);
                    break;
                } else {
                    m6914b(obj);
                    break;
                }
            case IMAGE:
                if (obj == null) {
                    mo4338h().setImageResource(R.drawable.image_default);
                    break;
                } else {
                    m6914b(obj);
                    break;
                }
            case VIDEO:
                if (obj == null) {
                    mo4338h().setImageResource(R.drawable.co_attach_p_video_normal);
                    break;
                } else {
                    m6914b(obj);
                    break;
                }
        }
    }

    /* renamed from: b */
    private void m6914b(Object obj) {
        try {
            if ((obj instanceof Bitmap) && !((Bitmap) obj).isRecycled()) {
                mo4338h().setImageBitmap((Bitmap) obj);
            } else if (obj instanceof Drawable) {
                mo4338h().setImageDrawable((Drawable) obj);
            }
        } catch (Exception e) {
            C3250y.m11443a(e, f6092a);
        } catch (OutOfMemoryError e2) {
            C3250y.m11443a(e2, f6092a);
        }
    }

    /* renamed from: a */
    private int m6913a(EnumC1794a enumC1794a) {
        return C0913q.f3843F.containsKey(enumC1794a) ? C0913q.f3843F.get(enumC1794a).intValue() : C0913q.f3843F.get(EnumC1794a.TXT).intValue();
    }

    /* renamed from: a */
    private int m6912a(EnumC1455w enumC1455w) {
        return this.f6096e.containsKey(enumC1455w) ? this.f6096e.get(enumC1455w).intValue() : R.drawable.turnk_no_image_default;
    }
}
