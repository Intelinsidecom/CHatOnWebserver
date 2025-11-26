package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2131l;
import com.sec.chaton.p065io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.EnumC3465i;
import com.sec.chaton.util.C4881d;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5035l;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: DynamicAniconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.t */
/* loaded from: classes.dex */
public class CallableC2788t extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: a */
    private static final String f10092a = CallableC2788t.class.getSimpleName();

    /* renamed from: b */
    private int f10093b;

    /* renamed from: c */
    private int f10094c;

    /* renamed from: d */
    private ImageView f10095d;

    public CallableC2788t(String str, int i, int i2, ImageView imageView) {
        super(str);
        this.f10093b = i;
        this.f10094c = i2;
        this.f10095d = imageView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo7449h = mo7449h();
        Drawable drawable = m18997k().getResources().getDrawable(R.drawable.rotate_emoticon_loading);
        imageViewMo7449h.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        ImageView imageViewMo7449h = mo7449h();
        imageViewMo7449h.setImageBitmap(null);
        imageViewMo7449h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo7449h.setBackgroundColor(0);
        m18993a(this, 500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws ExecutionException, InterruptedException {
        C0778b c0778b;
        List<C4881d> listM13774b = C3460d.m13774b(m18997k(), (String) this.f18262g, this.f10093b, this.f10094c);
        if (!listM13774b.isEmpty()) {
            return listM13774b;
        }
        try {
            c0778b = new C2131l(m18997k(), null).m9551a(EnumC2463n.UI, (String) this.f18262g, "png", 240).get();
        } catch (InterruptedException e) {
            if (C4904y.f17872b) {
                C4904y.m18635a(e, f10092a);
            }
            c0778b = null;
        } catch (CancellationException e2) {
            if (C4904y.f17872b) {
                C4904y.m18635a(e2, f10092a);
            }
            c0778b = null;
        } catch (ExecutionException e3) {
            if (C4904y.f17872b) {
                C4904y.m18635a(e3, f10092a);
            }
            c0778b = null;
        }
        if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
            return null;
        }
        String str = ((DownloadEmoticonEntry) c0778b.m3110e()).anicon.aniconzipurl;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(C5017a.m19065a(m18997k()), String.valueOf(str.hashCode()));
        try {
            try {
                C5017a.m19064a().m19067a(str, file);
                C3460d.m13764a(m18997k(), (String) this.f18262g, file);
                List<C4881d> listM13774b2 = C3460d.m13774b(m18997k(), (String) this.f18262g, this.f10093b, this.f10094c);
                if (!file.exists()) {
                    return listM13774b2;
                }
                file.delete();
                return listM13774b2;
            } catch (InterruptedException e4) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e4, f10092a);
                }
                if (file.exists()) {
                    file.delete();
                }
                return null;
            }
        } catch (Throwable th) {
            if (file.exists()) {
                file.delete();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws IllegalStateException, Resources.NotFoundException, IOException, SecurityException, IllegalArgumentException {
        Drawable drawable;
        ImageView imageViewMo7449h = mo7449h();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (obj != null) {
            imageViewMo7449h.setBackgroundColor(0);
            imageViewMo7449h.setScaleType(ImageView.ScaleType.FIT_XY);
            drawable = C3460d.m13762a(m18997k(), (List<C4881d>) obj);
        } else {
            drawable = m18997k().getResources().getDrawable(R.drawable.anicon_broken);
        }
        if (z) {
            imageViewMo7449h.setImageDrawable(drawable);
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{colorDrawable, drawable});
            imageViewMo7449h.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(100);
        }
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
        EnumC3465i enumC3465iM13788h = C3460d.m13788h(GlobalApplication.m18732r(), (String) this.f18262g);
        if (this.f10095d != null) {
            if (enumC3465iM13788h == EnumC3465i.NORMAL) {
                this.f10095d.setVisibility(8);
            } else {
                this.f10095d.setVisibility(0);
                this.f10095d.bringToFront();
                if (enumC3465iM13788h == EnumC3465i.SOUND) {
                    this.f10095d.setImageResource(R.drawable.chat_haptic_sound_nor);
                } else if (enumC3465iM13788h == EnumC3465i.HAPTIC_SOUND) {
                    this.f10095d.setImageResource(R.drawable.chat_haptic_sound_vi2_nor);
                } else {
                    this.f10095d.setImageResource(R.drawable.chat_haptic_vibration_nor);
                }
            }
        }
        if (C3460d.f12913a.containsKey(this.f18262g)) {
            if (enumC3465iM13788h != EnumC3465i.NORMAL) {
                C2780l.m11679a().m11683a((String) this.f18262g);
            }
            C3460d.f12913a.remove(this.f18262g);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        if (mo7449h() != null) {
            m18990a((View) null);
        }
        List<C4881d> listMo7448g = mo7448g();
        if (listMo7448g != null) {
            Iterator<C4881d> it = listMo7448g.iterator();
            while (it.hasNext()) {
                C5035l.m19113a(it.next().m18530b());
            }
            listMo7448g.clear();
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<C4881d> mo7448g() {
        return (List) super.mo7448g();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: i */
    public boolean mo11696i() {
        return true;
    }
}
