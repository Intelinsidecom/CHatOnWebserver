package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p055d.C2131l;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p065io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.chaton.settings.p096a.EnumC3465i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import com.sec.common.util.C5035l;
import com.sec.common.util.C5052r;
import com.sec.common.util.p133a.C5017a;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: StaticAniconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.u */
/* loaded from: classes.dex */
public class CallableC2789u extends AbstractRunnableC5005a<String> implements Callable<Void> {

    /* renamed from: a */
    private static final String f10096a = CallableC2789u.class.getSimpleName();

    /* renamed from: b */
    private int f10097b;

    /* renamed from: c */
    private int f10098c;

    /* renamed from: d */
    private ImageView f10099d;

    public CallableC2789u(String str, int i, int i2, ImageView imageView) {
        super(str);
        this.f10097b = i;
        this.f10098c = i2;
        this.f10099d = imageView;
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
        imageViewMo7449h.setTag(null);
        imageViewMo7449h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (this.f10099d != null) {
            this.f10099d.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws Throwable {
        C0778b c0778b;
        String string;
        Cursor cursorQuery;
        Cursor cursor = null;
        Drawable drawableM13779c = C3460d.m13779c(m18997k(), (String) this.f18262g, this.f10097b, this.f10098c);
        if (drawableM13779c != null) {
            return drawableM13779c;
        }
        m18993a(this, 500L);
        if (TextUtils.isEmpty(C4809aa.m18104a().m18121a("uid", ""))) {
            try {
                cursorQuery = m18997k().getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath((String) this.f18262g).build(), null, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("zip_url"));
                } else {
                    if (C4904y.f17875e) {
                        C4904y.m18634a(C5052r.m19199a("Couldn't find anicon. ", this.f18262g), f10096a);
                    }
                    string = null;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            try {
                c0778b = new C2131l(m18997k(), null).m9551a(EnumC2463n.UI, (String) this.f18262g, "png", 240).get();
            } catch (InterruptedException e) {
                if (C4904y.f17872b) {
                    C4904y.m18635a(e, f10096a);
                }
                c0778b = null;
            } catch (CancellationException e2) {
                if (C4904y.f17872b) {
                    C4904y.m18635a(e2, f10096a);
                }
                c0778b = null;
            } catch (ExecutionException e3) {
                if (C4904y.f17872b) {
                    C4904y.m18635a(e3, f10096a);
                }
                c0778b = null;
            }
            if (c0778b == null || !c0778b.m18954n() || c0778b.m3107b() != EnumC2464o.SUCCESS) {
                return null;
            }
            string = ((DownloadEmoticonEntry) c0778b.m3110e()).anicon.aniconzipurl;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        File file = new File(C5017a.m19065a(m18997k()), String.valueOf(string.hashCode()));
        try {
            try {
                C5017a.m19064a().m19067a(string, file);
                C3460d.m13764a(m18997k(), (String) this.f18262g, file);
                Drawable drawableM13779c2 = C3460d.m13779c(m18997k(), (String) this.f18262g, this.f10097b, this.f10098c);
                if (!file.exists()) {
                    return drawableM13779c2;
                }
                file.delete();
                return drawableM13779c2;
            } catch (InterruptedException e4) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e4, f10096a);
                }
                if (file.exists()) {
                    file.delete();
                }
                return null;
            }
        } catch (Throwable th3) {
            if (file.exists()) {
                file.delete();
            }
            throw th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    public void mo7443a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        ImageView imageViewMo7449h = mo7449h();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ViewGroup.LayoutParams layoutParams = imageViewMo7449h.getLayoutParams();
        if (obj != null) {
            drawable = (Drawable) obj;
            imageViewMo7449h.setTag(this.f18262g);
            layoutParams.width = -1;
            layoutParams.height = -1;
            if (this.f10099d != null) {
                EnumC3465i enumC3465iM13788h = C3460d.m13788h(m18997k(), (String) this.f18262g);
                if (enumC3465iM13788h == EnumC3465i.NORMAL) {
                    this.f10099d.setVisibility(8);
                } else {
                    if (enumC3465iM13788h == EnumC3465i.SOUND) {
                        this.f10099d.setImageResource(R.drawable.chat_haptic_sound_nor);
                    } else if (enumC3465iM13788h == EnumC3465i.HAPTIC_SOUND) {
                        this.f10099d.setImageResource(R.drawable.chat_haptic_sound_vi2_nor);
                    } else {
                        this.f10099d.setImageResource(R.drawable.chat_haptic_vibration_nor);
                    }
                    this.f10099d.setVisibility(0);
                    this.f10099d.bringToFront();
                }
            }
        } else {
            this.f10099d.setVisibility(8);
            drawable = m18997k().getResources().getDrawable(R.drawable.anicon_broken);
            layoutParams.width = (int) C5034k.m19088a(42.0f);
            layoutParams.height = (int) C5034k.m19088a(42.0f);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{colorDrawable, drawable});
        imageViewMo7449h.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(100);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        if (mo7449h() != null) {
            m18990a((View) null);
        }
        BitmapDrawable bitmapDrawableMo7448g = mo7448g();
        if (bitmapDrawableMo7448g != null) {
            C5035l.m19113a(bitmapDrawableMo7448g);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable mo7448g() {
        return (BitmapDrawable) super.mo7448g();
    }
}
