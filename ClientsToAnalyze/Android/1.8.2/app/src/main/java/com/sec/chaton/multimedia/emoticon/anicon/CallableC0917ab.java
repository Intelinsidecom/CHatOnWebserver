package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.common.p055a.C1811a;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;
import com.sec.common.p056b.p061e.C1830a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: RemoteImageResourceDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.ab */
/* loaded from: classes.dex */
public class CallableC0917ab extends AbstractRunnableC1820a implements Callable {

    /* renamed from: a */
    private int f3460a;

    /* renamed from: b */
    private int f3461b;

    /* renamed from: f */
    private int f3462f;

    /* renamed from: g */
    private int f3463g;

    public CallableC0917ab(String str) {
        this(str, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public CallableC0917ab(String str, int i, int i2) {
        super(str);
        this.f3462f = i;
        this.f3463g = i2;
        this.f3460a = R.drawable.rotate_emoticon_loading;
        this.f3461b = R.drawable.list_emoticon_error;
    }

    /* renamed from: a */
    public void m3777a(int i) {
        this.f3461b = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() throws Resources.NotFoundException {
        ImageView imageViewMo3775i = mo3775i();
        Drawable drawable = m6179k().getResources().getDrawable(this.f3460a);
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
        mo3775i().setImageBitmap(null);
        m6175a(this, 500L);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() throws IOException {
        File file = new File(C1830a.m6212a(m6179k()), String.valueOf(((String) m6178j()).hashCode()));
        try {
            C1830a.m6211a().m6213a((String) m6178j(), file);
            Bitmap bitmapM6144a = C1811a.m6144a(m6179k(), file, this.f3462f, this.f3463g);
            bitmapM6144a.setDensity(160);
            return bitmapM6144a;
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: a */
    public void mo3767a(Object obj, boolean z) throws Resources.NotFoundException {
        Drawable drawable;
        if (obj != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mo3774h());
            bitmapDrawable.setAntiAlias(true);
            drawable = bitmapDrawable;
        } else {
            drawable = m6179k().getResources().getDrawable(this.f3461b);
        }
        if (z) {
            mo3775i().setImageDrawable(drawable);
            return;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(0), drawable});
        mo3775i().setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(100);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: d */
    public void mo3770d() {
        Bitmap bitmapMo3774h = mo3774h();
        m6172a((View) null);
        if (bitmapMo3774h != null) {
            bitmapMo3774h.recycle();
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo3775i() {
        return (ImageView) super.mo3775i();
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Bitmap mo3774h() {
        return (Bitmap) super.mo3774h();
    }
}
