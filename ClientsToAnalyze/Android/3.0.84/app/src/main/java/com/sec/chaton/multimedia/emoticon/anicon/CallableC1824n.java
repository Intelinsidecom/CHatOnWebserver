package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.database.Cursor;
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
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p025d.C1332j;
import com.sec.chaton.p025d.p026a.EnumC1172b;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p035io.entry.DownloadEmoticonEntry;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings.downloads.EnumC2651z;
import com.sec.chaton.util.C3229d;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3348j;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* compiled from: DynamicAniconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.n */
/* loaded from: classes.dex */
public class CallableC1824n extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    private static final String f6803a = CallableC1824n.class.getSimpleName();

    /* renamed from: b */
    private int f6804b;

    /* renamed from: c */
    private int f6805c;

    public CallableC1824n(String str, int i, int i2) {
        super(str);
        this.f6804b = i;
        this.f6805c = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo4338h = mo4338h();
        Drawable drawable = m11714k().getResources().getDrawable(R.drawable.rotate_emoticon_loading);
        imageViewMo4338h.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: b */
    public void mo4332b() {
        ImageView imageViewMo4338h = mo4338h();
        imageViewMo4338h.setImageBitmap(null);
        imageViewMo4338h.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo4338h.setBackgroundColor(0);
        m11711a(this, 500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws Throwable {
        Cursor cursorQuery;
        C0267d c0267dB;
        String string;
        Cursor cursor = null;
        List<C3229d> listM9656b = C2646u.m9656b(m11714k(), (String) this.f12013g, this.f6804b, this.f6805c);
        if (!listM9656b.isEmpty()) {
            return listM9656b;
        }
        try {
            cursorQuery = m11714k().getContentResolver().query(C1396an.f5203a.buildUpon().appendPath((String) this.f12013g).build(), null, null, null, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("zip_url"));
            } else {
                try {
                    c0267dB = new C1332j(m11714k(), null).m5771c(EnumC1172b.UI, (String) this.f12013g, "png", 240).m5491b();
                } catch (InterruptedException e) {
                    if (C3250y.f11734b) {
                        C3250y.m11443a(e, f6803a);
                    }
                    c0267dB = null;
                } catch (CancellationException e2) {
                    if (C3250y.f11734b) {
                        C3250y.m11443a(e2, f6803a);
                    }
                    c0267dB = null;
                }
                if (c0267dB == null || !c0267dB.m11704n() || c0267dB.m1351b() != EnumC1587o.SUCCESS) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                string = ((DownloadEmoticonEntry) c0267dB.m1354e()).anicon.aniconzipurl;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            File file = new File(C3332a.m11751a(m11714k()), String.valueOf(string.hashCode()));
            try {
                try {
                    C3332a.m11750a().m11753a(string, file);
                    C2646u.m9646a(m11714k(), (String) this.f12013g, file);
                    List<C3229d> listM9656b2 = C2646u.m9656b(m11714k(), (String) this.f12013g, this.f6804b, this.f6805c);
                    if (file == null || !file.exists()) {
                        return listM9656b2;
                    }
                    file.delete();
                    return listM9656b2;
                } catch (InterruptedException e3) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e3, f6803a);
                    }
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                if (file != null && file.exists()) {
                    file.delete();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws IllegalStateException, Resources.NotFoundException, IOException, SecurityException, IllegalArgumentException {
        Drawable drawable;
        ImageView imageViewMo4338h = mo4338h();
        imageViewMo4338h.setBackgroundColor(0);
        imageViewMo4338h.setScaleType(ImageView.ScaleType.FIT_XY);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (obj != null) {
            drawable = C2646u.m9644a(m11714k(), (List<C3229d>) obj);
        } else {
            drawable = m11714k().getResources().getDrawable(R.drawable.download_default);
        }
        if (z) {
            imageViewMo4338h.setImageDrawable(drawable);
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{colorDrawable, drawable});
            imageViewMo4338h.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(100);
        }
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
        if (C2646u.f9891a.containsKey(this.f12013g)) {
            if (C2646u.m9673i(GlobalApplication.m11493l(), (String) this.f12013g) != EnumC2651z.NORMAL) {
                C1821k.m7478a().m7482a((String) this.f12013g);
            }
            C2646u.f9891a.remove(this.f12013g);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        if (mo4338h() != null) {
            m11708a((View) null);
        }
        List<C3229d> listMo4337g = mo4337g();
        if (listMo4337g != null) {
            Iterator<C3229d> it = listMo4337g.iterator();
            while (it.hasNext()) {
                C3348j.m11795a(it.next().m11350b());
            }
            listMo4337g.clear();
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<C3229d> mo4337g() {
        return (List) super.mo4337g();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: j */
    public boolean mo7491j() {
        return true;
    }
}
