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
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.util.C1786r;
import com.sec.common.p055a.C1811a;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;
import com.sec.common.p056b.p060d.C1828c;
import com.sec.common.p056b.p061e.C1830a;
import java.io.File;
import java.util.concurrent.Callable;

/* compiled from: StaticAniconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.ac */
/* loaded from: classes.dex */
public class CallableC0918ac extends AbstractRunnableC1820a implements Callable {

    /* renamed from: a */
    private static final String f3464a = CallableC0918ac.class.getSimpleName();

    /* renamed from: b */
    private int f3465b;

    /* renamed from: f */
    private int f3466f;

    public CallableC0918ac(String str, int i, int i2) {
        super(str);
        this.f3465b = i;
        this.f3466f = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo3775i = mo3775i();
        Drawable drawable = m6179k().getResources().getDrawable(R.drawable.rotate_emoticon_loading);
        imageViewMo3775i.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
            return null;
        }
        return null;
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: b */
    public void mo3768b() {
        ImageView imageViewMo3775i = mo3775i();
        imageViewMo3775i.setImageBitmap(null);
        imageViewMo3775i.setTag(null);
        m6175a(this, 500L);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() throws Throwable {
        Cursor cursorQuery;
        String string;
        Cursor cursor = null;
        Drawable drawableM3795c = C0921d.m3795c(m6179k(), (String) this.f6523d, this.f3465b, this.f3466f);
        if (drawableM3795c != null) {
            return drawableM3795c;
        }
        try {
            cursorQuery = m6179k().getContentResolver().query(C0950e.f3514a.buildUpon().appendPath((String) this.f6523d).build(), null, null, null, null);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("zip_url"));
            } else {
                if (C1786r.f6455e) {
                    C1786r.m6054a(C1828c.m6207a("Couldn't find anicon. ", this.f6523d), f3464a);
                }
                string = null;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            File file = new File(C1830a.m6212a(m6179k()), String.valueOf(System.currentTimeMillis()));
            try {
                try {
                    C1830a.m6211a().m6213a(string, file);
                    C0921d.m3792b(m6179k(), (String) this.f6523d, file);
                    Drawable drawableM3795c2 = C0921d.m3795c(m6179k(), (String) this.f6523d, this.f3465b, this.f3466f);
                    if (file == null || !file.exists()) {
                        return drawableM3795c2;
                    }
                    file.delete();
                    return drawableM3795c2;
                } catch (Throwable th2) {
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw th2;
                }
            } catch (InterruptedException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f3464a);
                }
                if (file != null && file.exists()) {
                    file.delete();
                }
                return null;
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

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: a */
    public void mo3767a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        ImageView imageViewMo3775i = mo3775i();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (obj != null) {
            drawable = (Drawable) obj;
            imageViewMo3775i.setTag(this.f6523d);
        } else {
            drawable = m6179k().getResources().getDrawable(R.drawable.chatting_no_emotion);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{colorDrawable, drawable});
        imageViewMo3775i.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(100);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: d */
    public void mo3770d() {
        if (mo3775i() != null) {
            m6172a((View) null);
        }
        BitmapDrawable bitmapDrawableMo3774h = mo3774h();
        if (bitmapDrawableMo3774h != null) {
            C1811a.m6145a(bitmapDrawableMo3774h);
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo3775i() {
        return (ImageView) super.mo3775i();
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable mo3774h() {
        return (BitmapDrawable) super.mo3774h();
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: g */
    public boolean mo3773g() {
        return true;
    }
}
