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
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.AbstractRunnableC3324a;
import com.sec.common.util.C3348j;
import com.sec.common.util.C3364o;
import com.sec.common.util.p070a.C3332a;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: StaticAniconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.p */
/* loaded from: classes.dex */
public class CallableC1826p extends AbstractRunnableC3324a<String> implements Callable<Void> {

    /* renamed from: a */
    private static final String f6811a = CallableC1826p.class.getSimpleName();

    /* renamed from: b */
    private int f6812b;

    /* renamed from: c */
    private int f6813c;

    public CallableC1826p(String str, int i, int i2) {
        super(str);
        this.f6812b = i;
        this.f6813c = i2;
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
        imageViewMo4338h.setTag(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() throws Throwable {
        Cursor cursorQuery;
        String string;
        Cursor cursor = null;
        Drawable drawableM9662c = C2646u.m9662c(m11714k(), (String) this.f12013g, this.f6812b, this.f6813c);
        if (drawableM9662c != null) {
            return drawableM9662c;
        }
        m11711a(this, 500L);
        try {
            cursorQuery = m11714k().getContentResolver().query(C1396an.f5203a.buildUpon().appendPath((String) this.f12013g).build(), null, null, null, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("zip_url"));
            } else {
                if (C3250y.f11737e) {
                    C3250y.m11442a(C3364o.m11849a("Couldn't find anicon. ", this.f12013g), f6811a);
                }
                string = null;
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
                    Drawable drawableM9662c2 = C2646u.m9662c(m11714k(), (String) this.f12013g, this.f6812b, this.f6813c);
                    if (file == null || !file.exists()) {
                        return drawableM9662c2;
                    }
                    file.delete();
                    return drawableM9662c2;
                } catch (InterruptedException e) {
                    if (C3250y.f11737e) {
                        C3250y.m11443a(e, f6811a);
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

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: a */
    public void mo4331a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        ImageView imageViewMo4338h = mo4338h();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (obj != null) {
            drawable = (Drawable) obj;
            imageViewMo4338h.setTag(this.f12013g);
        } else {
            drawable = m11714k().getResources().getDrawable(R.drawable.chat_anicon_btn_failed);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{colorDrawable, drawable});
        imageViewMo4338h.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(100);
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: d */
    public void mo4334d() {
        if (mo4338h() != null) {
            m11708a((View) null);
        }
        BitmapDrawable bitmapDrawableMo4337g = mo4337g();
        if (bitmapDrawableMo4337g != null) {
            C3348j.m11795a(bitmapDrawableMo4337g);
        }
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo4338h() {
        return (ImageView) super.mo4338h();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable mo4337g() {
        return (BitmapDrawable) super.mo4337g();
    }

    @Override // com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: j */
    public boolean mo7491j() {
        return true;
    }
}
