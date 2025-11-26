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
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.entry.DownloadEmoticonEntry;
import com.sec.chaton.multimedia.emoticon.p030a.C0910a;
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;
import com.sec.common.p055a.C1811a;
import com.sec.common.p056b.p057a.C1815c;
import com.sec.common.p056b.p059c.AbstractRunnableC1820a;
import com.sec.common.p056b.p061e.C1830a;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: DynamicAniconDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.aa */
/* loaded from: classes.dex */
public class CallableC0916aa extends AbstractRunnableC1820a implements Callable {

    /* renamed from: a */
    private static final String f3457a = CallableC0916aa.class.getSimpleName();

    /* renamed from: b */
    private int f3458b;

    /* renamed from: f */
    private int f3459f;

    public CallableC0916aa(String str, int i, int i2) {
        super(str);
        this.f3458b = i;
        this.f3459f = i2;
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
        imageViewMo3775i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageViewMo3775i.setBackgroundColor(0);
        m6175a(this, 500L);
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() throws Throwable {
        Cursor cursorQuery;
        String string;
        Cursor cursor = null;
        List listM3793b = C0921d.m3793b(m6179k(), (String) this.f6523d, this.f3458b, this.f3459f);
        if (!listM3793b.isEmpty()) {
            return listM3793b;
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
                C0101b c0101bM3671c = new C0910a(m6179k(), null).m3671c((String) this.f6523d, "png", 240);
                if (!c0101bM3671c.m664a() || c0101bM3671c.m665b() != EnumC0803m.SUCCESS) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                string = ((DownloadEmoticonEntry) c0101bM3671c.m671d()).emoticon.aniconzipurl;
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
                    List listM3793b2 = C0921d.m3793b(m6179k(), (String) this.f6523d, this.f3458b, this.f3459f);
                    if (file == null || !file.exists()) {
                        return listM3793b2;
                    }
                    file.delete();
                    return listM3793b2;
                } catch (Throwable th2) {
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    throw th2;
                }
            } catch (InterruptedException e) {
                if (C1786r.f6455e) {
                    C1786r.m6056a(e, f3457a);
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
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageViewMo3775i.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        imageViewMo3775i.setLayoutParams(layoutParams);
        imageViewMo3775i.setBackgroundColor(0);
        imageViewMo3775i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (obj != null) {
            drawable = C0921d.m3785a(m6179k(), (List) obj);
        } else {
            drawable = m6179k().getResources().getDrawable(R.drawable.messenger_chat_error);
        }
        if (z) {
            imageViewMo3775i.setImageDrawable(drawable);
        } else {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{colorDrawable, drawable});
            imageViewMo3775i.setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(100);
        }
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: d */
    public void mo3770d() {
        if (mo3775i() != null) {
            m6172a((View) null);
        }
        List listMo3774h = mo3774h();
        if (listMo3774h != null) {
            Iterator it = listMo3774h.iterator();
            while (it.hasNext()) {
                C1811a.m6145a(((C1815c) it.next()).m6155b());
            }
            listMo3774h.clear();
        }
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public ImageView mo3775i() {
        return (ImageView) super.mo3775i();
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List mo3774h() {
        return (List) super.mo3774h();
    }

    @Override // com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: g */
    public boolean mo3773g() {
        return true;
    }
}
