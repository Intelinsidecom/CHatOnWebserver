package com.sec.chaton.trunk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1294aq;
import com.sec.chaton.util.C1324bt;
import com.sec.chaton.util.C1341p;
import com.sec.p007b.p008a.p011c.AbstractRunnableC0120e;
import com.sec.p007b.p012b.C0121a;
import com.sec.widget.C1619g;
import java.io.File;

/* compiled from: TrunkDispatcherTask.java */
/* renamed from: com.sec.chaton.trunk.bk */
/* loaded from: classes.dex */
public class C1147bk extends AbstractRunnableC0120e {

    /* renamed from: d */
    private EnumC1168f f3977d;

    /* renamed from: e */
    private Context f3978e;

    /* renamed from: f */
    private String f3979f;

    /* renamed from: g */
    private BitmapDrawable f3980g;

    /* renamed from: h */
    private boolean f3981h;

    public C1147bk(Uri uri, EnumC1168f enumC1168f, Boolean bool) {
        super(uri);
        this.f3977d = enumC1168f;
        this.f3978e = GlobalApplication.m3100a();
        this.f3981h = bool.booleanValue();
        this.f3979f = ((Uri) m613f()).toString();
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: a */
    public void mo605a() {
        if (C1341p.f4578b) {
            C1341p.m4658b("onPreDispatch()", C1147bk.class.getSimpleName());
        }
        ((ImageView) mo612e()).setImageBitmap(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v39, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v42, types: [android.graphics.drawable.LayerDrawable] */
    /* JADX WARN: Type inference failed for: r0v45, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ed -> B:59:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x010b -> B:59:0x0020). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0020 -> B:59:0x0020). Please report as a decompilation issue!!! */
    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: b */
    public Object mo610b() {
        ?? DecodeFile;
        if (C1341p.f4578b) {
            C1341p.m4658b("onDispatch()", C1147bk.class.getSimpleName());
        }
        if (this.f3979f != null) {
            if (C0684a.f2332c.equals(this.f3979f)) {
                return null;
            }
            if (this.f3979f.contains("file://")) {
                this.f3979f = this.f3979f.substring(7);
            }
            File file = new File(this.f3979f);
            if (!this.f3979f.contains("thumbnail")) {
                String name = file.getName();
                String[] strArrSplit = this.f3979f.split(name);
                if (this.f3977d != EnumC1168f.IMAGE) {
                    name = name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg");
                }
                file = new File(strArrSplit[0] + "thumbnail/" + name);
            }
            try {
            } catch (Exception e) {
                C1341p.m4653a(e, getClass().getSimpleName());
                DecodeFile = 0;
            } catch (OutOfMemoryError e2) {
                C1619g.m5888a(GlobalApplication.m3100a(), R.string.chat_view_memory_error, 0).show();
                DecodeFile = 0;
            }
            if (file.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inDither = true;
                options.inPurgeable = true;
                DecodeFile = BitmapFactory.decodeFile(file.getPath(), options);
                if (this.f3977d == EnumC1168f.IMAGE) {
                    DecodeFile = C1294aq.m4499a(this.f3978e, (Uri) m613f());
                } else if (!this.f3981h) {
                    this.f3980g = new BitmapDrawable(this.f3978e.getResources(), (Bitmap) DecodeFile);
                    DecodeFile = new LayerDrawable(new Drawable[]{this.f3980g, this.f3978e.getResources().getDrawable(R.drawable.msg_play_button)});
                }
                return DecodeFile;
            }
            try {
                if (this.f3977d == EnumC1168f.IMAGE) {
                    DecodeFile = C1294aq.m4499a(this.f3978e, (Uri) m613f());
                } else if (this.f3977d == EnumC1168f.VIDEO) {
                    if (!this.f3981h) {
                        this.f3980g = new BitmapDrawable(this.f3978e.getResources(), C1324bt.m4580a(this.f3978e, new File(this.f3979f), false));
                        DecodeFile = new LayerDrawable(new Drawable[]{this.f3980g, this.f3978e.getResources().getDrawable(R.drawable.msg_play_button)});
                    } else {
                        DecodeFile = C1324bt.m4580a(this.f3978e, new File(this.f3979f), false);
                    }
                }
            } catch (Exception e3) {
                C1341p.m4653a(e3, getClass().getSimpleName());
                DecodeFile = 0;
            } catch (OutOfMemoryError e4) {
                C1619g.m5888a(GlobalApplication.m3100a(), R.string.chat_view_memory_error, 0).show();
                DecodeFile = 0;
            }
            return DecodeFile;
        }
        DecodeFile = 0;
        return DecodeFile;
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: a */
    public void mo608a(Object obj, boolean z) {
        if (C1341p.f4578b) {
            C1341p.m4658b("Value: " + obj, C1147bk.class.getSimpleName());
        }
        if (obj != null) {
            if (obj instanceof Bitmap) {
                ((ImageView) mo612e()).setImageBitmap((Bitmap) obj);
            } else if (obj instanceof Drawable) {
                ((ImageView) mo612e()).setImageDrawable((Drawable) obj);
            }
        }
    }

    @Override // com.sec.p007b.p008a.p011c.AbstractRunnableC0120e
    /* renamed from: c */
    public void mo611c() {
        Object objG = m614g();
        if (objG != null) {
            if (objG instanceof Bitmap) {
                ((Bitmap) objG).recycle();
            } else if (objG instanceof Drawable) {
                C0121a.m618a(this.f3980g);
            }
        }
    }
}
