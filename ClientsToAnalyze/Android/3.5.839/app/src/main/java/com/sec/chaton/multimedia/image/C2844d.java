package com.sec.chaton.multimedia.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4838bc;
import com.sec.chaton.util.C4894o;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p131f.C5003g;
import com.sec.common.p132g.AbstractRunnableC5005a;
import com.sec.common.util.C5034k;
import java.io.File;
import java.io.IOException;

/* compiled from: ImageDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.image.d */
/* loaded from: classes.dex */
public class C2844d extends AbstractRunnableC5005a<String> {

    /* renamed from: a */
    private static final String f10444a = C2844d.class.getSimpleName();

    /* renamed from: b */
    private String f10445b;

    /* renamed from: c */
    private boolean f10446c;

    /* renamed from: d */
    private boolean f10447d;

    /* renamed from: e */
    private boolean f10448e;

    /* renamed from: i */
    private boolean f10449i;

    /* renamed from: j */
    private boolean f10450j;

    /* renamed from: k */
    private Handler f10451k;

    /* renamed from: l */
    private boolean f10452l;

    /* renamed from: m */
    private String f10453m;

    /* renamed from: n */
    private long f10454n;

    /* renamed from: o */
    private String f10455o;

    /* renamed from: p */
    private String f10456p;

    public C2844d(String str, String str2, boolean z, boolean z2) {
        super(str);
        this.f10445b = str2;
        this.f10446c = z;
        this.f10448e = z2;
        if (C4904y.f17872b) {
            C4904y.m18639b("[init] key: " + str + ", content: " + this.f10445b + ", isImage:" + z + ", saveFile: " + z2, f10444a);
        }
    }

    public C2844d(String str, String str2, boolean z, boolean z2, EnumC2214ab enumC2214ab) {
        super(str);
        this.f10445b = str2;
        this.f10446c = z;
        this.f10448e = z2;
        if (enumC2214ab == EnumC2214ab.AMS) {
            this.f10447d = true;
            this.f10449i = false;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("[init] key: " + str + ", content: " + this.f10445b + ", isImage:" + z + ", saveFile: " + z2 + ", mIsAms: " + this.f10447d, f10444a);
        }
    }

    public C2844d(String str, String str2, boolean z, boolean z2, EnumC2214ab enumC2214ab, boolean z3, boolean z4, Handler handler, boolean z5, String str3, long j, String str4, String str5) {
        super(str);
        this.f10445b = str2;
        this.f10446c = z;
        this.f10449i = z3;
        this.f10450j = z4;
        this.f10451k = handler;
        this.f10452l = z5;
        this.f10453m = str3;
        this.f10454n = j;
        this.f10455o = str4;
        this.f10456p = str5;
        if (enumC2214ab == EnumC2214ab.AMS) {
            this.f10447d = true;
            this.f10449i = false;
        }
        this.f10448e = z2;
        if (C4904y.f17872b) {
            C4904y.m18639b("[init] key: " + str + ", content: " + this.f10445b + ", msgType:" + enumC2214ab + ", saveFile: " + z2 + " mAdjustViewBounds : " + this.f10449i + ", mFullImageThumbnail : " + this.f10450j, f10444a);
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: m_ */
    public void mo7450m_() {
        mo7449h().setImageDrawable(null);
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: c */
    public Object mo7444c() throws Throwable {
        File file;
        File file2;
        boolean z;
        boolean z2;
        Bitmap bitmapDecodeFile;
        Movie movieM11757a;
        if (this.f10445b != null) {
            try {
                if (C1427a.f5066d.equals(this.f10445b)) {
                    return null;
                }
                if (this.f10445b.startsWith("content")) {
                    file = C4894o.m18610b(Uri.parse(this.f10445b));
                    file2 = null;
                } else {
                    this.f10445b = Uri.parse(this.f10445b).getPath();
                    file = new File(this.f10445b);
                    if (this.f10445b.contains("thumbnail")) {
                        file2 = null;
                    } else {
                        String name = file.getName();
                        file2 = new File(file.getParent() + "/thumbnail/" + (!this.f10446c ? name.replace(name.substring(name.lastIndexOf(".") + 1), "jpg") : name));
                    }
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("mIsAms : " + this.f10447d, f10444a);
                }
                if (C4838bc.m18309a(this.f10445b)) {
                    boolean z3 = TextUtils.isEmpty(this.f10456p) || this.f10456p.split(",").length < 3;
                    if (!z3 || (movieM11757a = GifView.m11757a(this.f10445b)) == null || movieM11757a.duration() <= 0) {
                        z = z3;
                        z2 = false;
                    } else {
                        z = z3;
                        z2 = true;
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                if (this.f10449i && !this.f10450j && file2 != null && file2.exists()) {
                    file2.delete();
                }
                if (file2 == null || !file2.exists()) {
                    bitmapDecodeFile = null;
                } else {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("thumbnail file exists.", f10444a);
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = false;
                    options.inDither = true;
                    options.inPurgeable = true;
                    bitmapDecodeFile = BitmapFactory.decodeFile(file2.getPath(), options);
                    if (bitmapDecodeFile != null) {
                        if (this.f10446c && !this.f10447d) {
                            if ((this.f10449i && !this.f10450j) || z) {
                                m11940a(bitmapDecodeFile, z2);
                                if (this.f10451k != null) {
                                    this.f10451k.sendMessage(Message.obtain(this.f10451k, 0, bitmapDecodeFile.getWidth() + "," + bitmapDecodeFile.getHeight() + "," + (z2 ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL)));
                                }
                            }
                            return m11941b(bitmapDecodeFile);
                        }
                        return m11939a(bitmapDecodeFile);
                    }
                }
                if (this.f10446c) {
                    Bitmap bitmapM18599a = file != null ? C4894o.m18599a(CommonApplication.m18732r(), file, true, this.f10448e, false, this.f10449i) : bitmapDecodeFile;
                    if (bitmapM18599a != null) {
                        if (!this.f10447d) {
                            if ((this.f10449i && !this.f10450j) || z) {
                                m11940a(bitmapM18599a, z2);
                                if (this.f10451k != null) {
                                    this.f10451k.sendMessage(Message.obtain(this.f10451k, 0, bitmapM18599a.getWidth() + "," + bitmapM18599a.getHeight() + "," + (z2 ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL)));
                                }
                            }
                            return m11941b(bitmapM18599a);
                        }
                        return m11939a(bitmapM18599a);
                    }
                } else {
                    Bitmap bitmapM18598a = C4894o.m18598a(CommonApplication.m18732r(), new File(this.f10445b), false, this.f10448e, false);
                    if (bitmapM18598a != null) {
                        return m11939a(bitmapM18598a);
                    }
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f10444a);
                }
            } catch (OutOfMemoryError e2) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, f10444a);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private LayerDrawable m11939a(Bitmap bitmap) throws Resources.NotFoundException {
        Drawable drawable;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(CommonApplication.m18732r().getResources(), m11941b(bitmap));
        if (this.f10447d) {
            drawable = CommonApplication.m18732r().getResources().getDrawable(R.drawable.chat_btn_ams_play);
        } else {
            drawable = CommonApplication.m18732r().getResources().getDrawable(R.drawable.chat_btn_play);
        }
        return new LayerDrawable(new Drawable[]{bitmapDrawable, drawable});
    }

    /* renamed from: b */
    private Bitmap m11941b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                return C5003g.m18987a(C5034k.m19088a(3.0f), C5034k.m19088a(3.0f)).m18988a(bitmap);
            } catch (IOException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f10444a);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m11940a(Bitmap bitmap, boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("updateImageSize : " + ((String) this.f18262g) + ", isGifImage : " + z, f10444a);
        }
        if (bitmap != null) {
            int i = z ? 1 : 0;
            if (this.f10452l) {
                C2204r.m10030a(GlobalApplication.m18732r().getContentResolver(), this.f10453m, Long.valueOf(this.f10454n), bitmap.getWidth() + "," + bitmap.getHeight() + "," + i);
            } else {
                C2204r.m10031a(CommonApplication.m18732r().getContentResolver(), this.f10453m, Long.valueOf(this.f10454n), bitmap.getWidth() + "," + bitmap.getHeight() + "," + i, this.f10455o);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[Catch: OutOfMemoryError -> 0x003f, Exception -> 0x0055, TRY_ENTER, TryCatch #2 {Exception -> 0x0055, OutOfMemoryError -> 0x003f, blocks: (B:3:0x0002, B:5:0x0006, B:7:0x0010, B:9:0x001a, B:11:0x001e, B:13:0x002b, B:15:0x0035, B:19:0x0046, B:21:0x004a, B:25:0x005c), top: B:28:0x0002 }] */
    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7443a(java.lang.Object r4, boolean r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L46
            boolean r1 = r4 instanceof android.graphics.Bitmap     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            if (r1 == 0) goto L1a
            r0 = r4
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            r1 = r0
            boolean r1 = r1.isRecycled()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            if (r1 != 0) goto L1a
            android.widget.ImageView r1 = r3.mo7449h()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            r1.setImageBitmap(r4)     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
        L19:
            return
        L1a:
            boolean r1 = r4 instanceof android.graphics.drawable.LayerDrawable     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            if (r1 == 0) goto L46
            r0 = r4
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            r1 = r0
            r2 = 0
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r2)     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            if (r1 == 0) goto L46
            android.graphics.Bitmap r1 = r1.getBitmap()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            boolean r1 = r1.isRecycled()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            if (r1 != 0) goto L46
            android.widget.ImageView r1 = r3.mo7449h()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            r1.setImageDrawable(r4)     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            goto L19
        L3f:
            r1 = move-exception
            java.lang.String r2 = com.sec.chaton.multimedia.image.C2844d.f10444a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L19
        L46:
            boolean r1 = r3.f10446c     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            if (r1 == 0) goto L5c
            android.widget.ImageView r1 = r3.mo7449h()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            r2 = 2130838211(0x7f0202c3, float:1.7281398E38)
            r1.setImageResource(r2)     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            goto L19
        L55:
            r1 = move-exception
            java.lang.String r2 = com.sec.chaton.multimedia.image.C2844d.f10444a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L19
        L5c:
            android.widget.ImageView r1 = r3.mo7449h()     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            r2 = 2130837870(0x7f02016e, float:1.7280706E38)
            r1.setImageResource(r2)     // Catch: java.lang.OutOfMemoryError -> L3f java.lang.Exception -> L55
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.multimedia.image.C2844d.mo7443a(java.lang.Object, boolean):void");
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: d */
    public void mo7445d() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Object objG = mo7448g();
        if (objG != null) {
            if (objG instanceof Bitmap) {
                Bitmap bitmap2 = (Bitmap) objG;
                if (!bitmap2.isRecycled()) {
                    bitmap2.recycle();
                    return;
                }
                return;
            }
            if ((objG instanceof LayerDrawable) && (bitmapDrawable = (BitmapDrawable) ((LayerDrawable) objG).getDrawable(0)) != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override // com.sec.common.p132g.AbstractRunnableC5005a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageView mo7449h() {
        return (ImageView) super.mo7449h();
    }
}
