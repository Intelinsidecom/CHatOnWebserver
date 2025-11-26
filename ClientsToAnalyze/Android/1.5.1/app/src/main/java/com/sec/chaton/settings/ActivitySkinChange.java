package com.sec.chaton.settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.userprofile.UserProfileFragment;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.StorageStateInfoUtil;
import com.sec.vip.cropimage.ImageModify;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ActivitySkinChange extends FragmentActivity {

    /* renamed from: A */
    private Button f3017A;

    /* renamed from: B */
    private File f3018B;

    /* renamed from: C */
    private File f3019C;

    /* renamed from: D */
    private final int f3020D;

    /* renamed from: E */
    private final int f3021E;

    /* renamed from: F */
    private final int f3022F;

    /* renamed from: G */
    private Uri f3023G;

    /* renamed from: H */
    private LinearLayout f3024H;

    /* renamed from: I */
    private HorizontalScrollView f3025I;

    /* renamed from: J */
    private boolean f3026J;

    /* renamed from: K */
    private Configuration f3027K;

    /* renamed from: L */
    private LinearLayout f3028L;

    /* renamed from: M */
    private int f3029M;

    /* renamed from: N */
    private int f3030N;

    /* renamed from: O */
    private Display f3031O;

    /* renamed from: P */
    private BitmapDrawable f3032P;

    /* renamed from: Q */
    private BitmapDrawable f3033Q;

    /* renamed from: R */
    private BitmapDrawable f3034R;

    /* renamed from: S */
    private BitmapDrawable f3035S;

    /* renamed from: T */
    private BitmapDrawable f3036T;

    /* renamed from: U */
    private BitmapDrawable f3037U;

    /* renamed from: V */
    private BitmapDrawable f3038V;

    /* renamed from: W */
    private BitmapDrawable f3039W;

    /* renamed from: X */
    private BitmapDrawable f3040X;

    /* renamed from: Y */
    private View.OnLongClickListener f3041Y;

    /* renamed from: Z */
    private View.OnClickListener f3042Z;

    /* renamed from: a */
    Context f3043a;

    /* renamed from: b */
    String f3044b;

    /* renamed from: c */
    WindowManager f3045c;

    /* renamed from: d */
    private ImageView f3046d;

    /* renamed from: e */
    private ImageView f3047e;

    /* renamed from: f */
    private ImageView f3048f;

    /* renamed from: g */
    private ImageView f3049g;

    /* renamed from: h */
    private ImageView f3050h;

    /* renamed from: i */
    private ImageView f3051i;

    /* renamed from: j */
    private ImageView f3052j;

    /* renamed from: k */
    private ImageView f3053k;

    /* renamed from: l */
    private ImageView f3054l;

    /* renamed from: m */
    private ImageView f3055m;

    /* renamed from: n */
    private ImageView f3056n;

    /* renamed from: o */
    private ImageView f3057o;

    /* renamed from: p */
    private ImageView f3058p;

    /* renamed from: q */
    private ImageView f3059q;

    /* renamed from: r */
    private ImageView f3060r;

    /* renamed from: s */
    private ImageView f3061s;

    /* renamed from: t */
    private ImageView f3062t;

    /* renamed from: u */
    private ImageView f3063u;

    /* renamed from: v */
    private RelativeLayout f3064v;

    /* renamed from: w */
    private LinearLayout f3065w;

    /* renamed from: x */
    private String f3066x;

    /* renamed from: y */
    private String f3067y;

    /* renamed from: z */
    private Button f3068z;

    public ActivitySkinChange() {
        this.f3044b = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        this.f3018B = new File(this.f3044b + "/skins/");
        this.f3020D = 0;
        this.f3021E = 1;
        this.f3022F = 6;
        this.f3026J = false;
        this.f3032P = null;
        this.f3033Q = null;
        this.f3034R = null;
        this.f3035S = null;
        this.f3036T = null;
        this.f3037U = null;
        this.f3038V = null;
        this.f3039W = null;
        this.f3040X = null;
        this.f3041Y = new ViewOnLongClickListenerC0494e(this);
        this.f3042Z = new ViewOnClickListenerC0492c(this);
    }

    /* renamed from: A */
    static /* synthetic */ ImageView m3150A(ActivitySkinChange activitySkinChange) {
        return activitySkinChange.f3058p;
    }

    /* renamed from: B */
    static /* synthetic */ ImageView m3151B(ActivitySkinChange activitySkinChange) {
        return activitySkinChange.f3059q;
    }

    /* JADX WARN: Failed to check method usage
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.MethodNode.getTopParentClass()" because "m" is null
    	at jadx.core.codegen.ClassGen.lambda$skipMethod$0(ClassGen.java:364)
    	at java.base/java.util.stream.ReferencePipeline$2$1.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.collect(Unknown Source)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:365)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:327)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
    	at jadx.core.ProcessClass.process(ProcessClass.java:79)
    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
     */
    /* renamed from: C */
    static /* synthetic */ ImageView m3152C(ActivitySkinChange activitySkinChange) {
        return activitySkinChange.f3060r;
    }

    /* renamed from: D */
    static /* synthetic */ ImageView m3153D(ActivitySkinChange activitySkinChange) {
        return activitySkinChange.f3061s;
    }

    /* renamed from: a */
    public static Bitmap m3157a(Context context, Uri uri, int i) throws IOException {
        Bitmap bitmapDecodeStream;
        File file = new File(uri.toString());
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = i;
        FileInputStream fileInputStream = null;
        Bitmap bitmap = null;
        int iLog = 8;
        while (true) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            int i3 = iLog == 0 ? 0 : i2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fileInputStream = new FileInputStream(file);
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
            if (bitmapDecodeStream != null) {
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i3 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                if (i3 <= 0 || bitmapDecodeStream.getWidth() >= i3 / 2 || bitmapDecodeStream.getHeight() >= i3 / 2) {
                    break;
                }
                i2 = i3;
                bitmap = bitmapDecodeStream;
            } else {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return bitmapDecodeStream;
    }

    /* renamed from: a */
    private void m3160a() {
        this.f3027K = getResources().getConfiguration();
        if (this.f3027K.orientation == 1) {
            setContentView(C0062R.layout.layout_change_skin);
        } else {
            setContentView(C0062R.layout.layout_change_skin_land);
        }
        this.f3043a = this;
        this.f3045c = (WindowManager) this.f3043a.getSystemService("window");
        if (!this.f3026J) {
            this.f3066x = ChatONPref.m3519a().getString("setting_change_skin", "");
            this.f3067y = ChatONPref.m3519a().getString("setting_change_bubble", "");
        }
        this.f3031O = this.f3045c.getDefaultDisplay();
        this.f3029M = this.f3031O.getWidth();
        this.f3030N = this.f3031O.getHeight();
        ChatONLogWriter.m3509d("w:" + this.f3029M);
        ChatONLogWriter.m3509d("h:" + this.f3030N);
        this.f3025I = (HorizontalScrollView) findViewById(C0062R.id.scroll);
        this.f3024H = (LinearLayout) findViewById(C0062R.id.layout_skins);
        this.f3046d = (ImageView) findViewById(C0062R.id.thumb_skin_bg_default);
        this.f3047e = (ImageView) findViewById(C0062R.id.thum_my_skin_bg);
        this.f3048f = (ImageView) findViewById(C0062R.id.imageView1);
        this.f3049g = (ImageView) findViewById(C0062R.id.imageView2);
        this.f3050h = (ImageView) findViewById(C0062R.id.imageView3);
        this.f3051i = (ImageView) findViewById(C0062R.id.imageView4);
        this.f3052j = (ImageView) findViewById(C0062R.id.imageView5);
        this.f3053k = (ImageView) findViewById(C0062R.id.imageView6);
        this.f3054l = (ImageView) findViewById(C0062R.id.imageView7);
        this.f3055m = (ImageView) findViewById(C0062R.id.imageView8);
        this.f3056n = (ImageView) findViewById(C0062R.id.imageView9);
        this.f3057o = (ImageView) findViewById(C0062R.id.bubble_imageView1);
        this.f3058p = (ImageView) findViewById(C0062R.id.bubble_imageView2);
        this.f3059q = (ImageView) findViewById(C0062R.id.bubble_imageView3);
        this.f3060r = (ImageView) findViewById(C0062R.id.bubble_imageView4);
        this.f3061s = (ImageView) findViewById(C0062R.id.bubble_imageView5);
        this.f3062t = (ImageView) findViewById(C0062R.id.bubble_imageView6);
        this.f3063u = (ImageView) findViewById(C0062R.id.photo_bg);
        this.f3064v = (RelativeLayout) findViewById(C0062R.id.skin_preview);
        this.f3065w = (LinearLayout) findViewById(C0062R.id.textRecvContent);
        this.f3028L = (LinearLayout) findViewById(C0062R.id.lLayoutSndContent);
        this.f3068z = (Button) findViewById(C0062R.id.setSkin);
        this.f3017A = (Button) findViewById(C0062R.id.btnCancel);
        m3167d();
        m3163b();
    }

    /* renamed from: b */
    static /* synthetic */ String m3162b(ActivitySkinChange activitySkinChange, String str) {
        activitySkinChange.f3067y = str;
        return str;
    }

    /* renamed from: b */
    private void m3163b() {
        if (this.f3066x.equals("pad_chat_bg_01")) {
            this.f3064v.setBackgroundResource(C0062R.drawable.skin_preview_bg);
            this.f3048f.setSelected(true);
        } else if (this.f3066x.equals("skin_bg_02")) {
            this.f3049g.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3033Q);
        } else if (this.f3066x.equals("skin_bg_03")) {
            this.f3050h.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3034R);
        } else if (this.f3066x.equals("skin_bg_04")) {
            this.f3051i.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3035S);
        } else if (this.f3066x.equals("skin_bg_05")) {
            this.f3052j.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3036T);
        } else if (this.f3066x.equals("skin_bg_06")) {
            this.f3053k.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3037U);
        } else if (this.f3066x.equals("skin_bg_07")) {
            this.f3054l.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3038V);
        } else if (this.f3066x.equals("skin_bg_08")) {
            this.f3055m.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3039W);
        } else if (this.f3066x.equals("skin_bg_09")) {
            this.f3056n.setSelected(true);
            this.f3064v.setBackgroundDrawable(this.f3040X);
        } else if (this.f3066x.equals("skin_myskin.png_")) {
            try {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(m3157a(this.f3043a, Uri.parse(this.f3018B + "/" + this.f3066x), 800), 800, 800, true);
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(m3157a(this.f3043a, Uri.parse(this.f3018B + "/" + this.f3066x), 114), 114, 114, true);
                this.f3063u.setImageBitmap(bitmapCreateScaledBitmap);
                this.f3063u.setVisibility(0);
                this.f3047e.setImageBitmap(bitmapCreateScaledBitmap2);
                this.f3047e.setSelected(true);
            } catch (IOException e) {
                this.f3064v.setBackgroundResource(C0062R.drawable.skin_preview_bg);
                this.f3047e.setVisibility(8);
                e.printStackTrace();
            }
        } else if (this.f3066x.equals("")) {
            this.f3064v.setBackgroundResource(C0062R.drawable.skin_preview_bg);
            this.f3048f.setSelected(true);
        }
        File file = new File(this.f3018B, "skin_myskin.png_");
        if (file.exists() && file.length() > 0) {
            try {
                this.f3047e.setImageBitmap(Bitmap.createScaledBitmap(m3157a(this.f3043a, Uri.parse(this.f3018B + "/skin_myskin.png_"), 114), 114, 114, true));
                this.f3047e.setVisibility(0);
            } catch (IOException e2) {
                this.f3047e.setVisibility(8);
                e2.printStackTrace();
            }
        }
        if (this.f3067y.equals("bubble_01")) {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_01);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_01);
            this.f3057o.setSelected(true);
            return;
        }
        if (this.f3067y.equals("bubble_02")) {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_02);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_02);
            this.f3058p.setSelected(true);
            return;
        }
        if (this.f3067y.equals("bubble_03")) {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_03);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_03);
            this.f3059q.setSelected(true);
            return;
        }
        if (this.f3067y.equals("bubble_04")) {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_04);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_04);
            this.f3060r.setSelected(true);
        } else if (this.f3067y.equals("bubble_05")) {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_05);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_05);
            this.f3061s.setSelected(true);
        } else if (this.f3067y.equals("bubble_06")) {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_06);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_06);
            this.f3062t.setSelected(true);
        } else {
            this.f3065w.setBackgroundResource(C0062R.drawable.bubble_receive_01);
            this.f3028L.setBackgroundResource(C0062R.drawable.bubble_send_01);
            this.f3057o.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m3164c() throws IOException {
        try {
            if (!this.f3018B.canRead()) {
                this.f3018B.mkdirs();
            }
            this.f3019C = new File(this.f3018B + "/", "skin_myskin.png_");
            this.f3019C.createNewFile();
            this.f3023G = Uri.fromFile(this.f3019C);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                Toast.makeText(this.f3043a, getString(C0062R.string.toast_sdcard_amount), 1).show();
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("image/*");
            intent.putExtra("outputX", this.f3031O.getWidth());
            intent.putExtra("outputY", this.f3031O.getHeight());
            intent.putExtra("aspectX", 2);
            intent.putExtra("aspectY", 3);
            intent.putExtra("scale", true);
            startActivityForResult(intent, 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m3167d() {
        this.f3046d.setOnClickListener(new ViewOnClickListenerC0493d(this));
        this.f3047e.setOnClickListener(new ViewOnClickListenerC0497h(this));
        this.f3048f.setOnClickListener(new ViewOnClickListenerC0498i(this));
        this.f3049g.setOnClickListener(new ViewOnClickListenerC0495f(this));
        this.f3050h.setOnClickListener(new ViewOnClickListenerC0496g(this));
        this.f3051i.setOnClickListener(new ViewOnClickListenerC0478b(this));
        this.f3052j.setOnClickListener(new ViewOnClickListenerC0451a(this));
        this.f3053k.setOnClickListener(new ViewOnClickListenerC0523x(this));
        this.f3054l.setOnClickListener(new ViewOnClickListenerC0452aa(this));
        this.f3055m.setOnClickListener(new ViewOnClickListenerC0453ab(this));
        this.f3056n.setOnClickListener(new ViewOnClickListenerC0524y(this));
        this.f3057o.setOnClickListener(new ViewOnClickListenerC0525z(this));
        this.f3058p.setOnClickListener(new ViewOnClickListenerC0456ae(this));
        this.f3059q.setOnClickListener(new ViewOnClickListenerC0457af(this));
        this.f3060r.setOnClickListener(new ViewOnClickListenerC0454ac(this));
        this.f3061s.setOnClickListener(new ViewOnClickListenerC0455ad(this));
        this.f3062t.setOnClickListener(new ViewOnClickListenerC0458ag(this));
        this.f3017A.setOnClickListener(new ViewOnClickListenerC0459ah(this));
        this.f3068z.setOnClickListener(new ViewOnClickListenerC0460ai(this));
    }

    /* renamed from: x */
    static /* synthetic */ LinearLayout m3187x(ActivitySkinChange activitySkinChange) {
        return activitySkinChange.f3065w;
    }

    /* renamed from: y */
    static /* synthetic */ LinearLayout m3188y(ActivitySkinChange activitySkinChange) {
        return activitySkinChange.f3028L;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        System.gc();
        switch (i) {
            case 1:
                if (intent == null) {
                    ChatONLogWriter.m3506b("Crop Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    try {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(UserProfileFragment.m3385a(this.f3043a, Uri.parse(intent.getExtras().getString("temp_file_path")), this.f3031O.getHeight()), this.f3031O.getWidth(), this.f3031O.getHeight(), true);
                        ChatOnGraphics.m3534a(ChatOnGraphics.m3535a(bitmapCreateScaledBitmap), "/skins/", this.f3019C.getName());
                        this.f3063u.setImageBitmap(bitmapCreateScaledBitmap);
                        this.f3063u.setScaleType(ImageView.ScaleType.FIT_XY);
                        this.f3066x = this.f3019C.getName();
                        break;
                    } catch (Exception e) {
                        ChatONLogWriter.m3501a(e, getClass().getSimpleName());
                        return;
                    }
                }
            case 6:
                if (intent != null) {
                    this.f3023G = intent.getData();
                    Intent intent2 = new Intent(this.f3043a, (Class<?>) ImageModify.class);
                    intent2.setDataAndType(this.f3023G, "image/*");
                    intent2.putExtra("outputX", this.f3031O.getWidth());
                    intent2.putExtra("outputY", this.f3031O.getHeight());
                    intent2.putExtra("aspectX", 2);
                    intent2.putExtra("aspectY", 3);
                    intent2.putExtra("return-data", true);
                    startActivityForResult(intent2, 1);
                    break;
                } else {
                    ChatONLogWriter.m3506b("Gallery Return is NULL", getClass().getSimpleName());
                    break;
                }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3026J = true;
        m3160a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m3160a();
        this.f3032P = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_01));
        this.f3032P.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3033Q = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_02));
        this.f3033Q.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3034R = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_03));
        this.f3034R.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3035S = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_04));
        this.f3035S.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3036T = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_05));
        this.f3036T.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3037U = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_06));
        this.f3037U.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3038V = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_07));
        this.f3038V.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3039W = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_08));
        this.f3039W.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.f3040X = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), C0062R.drawable.skin_09));
        this.f3040X.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        m3160a();
    }
}
