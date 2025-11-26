package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.view.MotionEvent;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
class SelectMode implements ModeState {

    /* renamed from: aj */
    private static /* synthetic */ int[] f1170aj;

    /* renamed from: V */
    private Bitmap f1192V;

    /* renamed from: W */
    private Bitmap f1193W;

    /* renamed from: X */
    private Bitmap f1194X;

    /* renamed from: Y */
    private Bitmap f1195Y;

    /* renamed from: Z */
    private Bitmap f1196Z;

    /* renamed from: aa */
    private Bitmap f1198aa;

    /* renamed from: ab */
    private Bitmap f1199ab;

    /* renamed from: ac */
    private Bitmap f1200ac;

    /* renamed from: ad */
    private Bitmap f1201ad;

    /* renamed from: ae */
    private Bitmap f1202ae;

    /* renamed from: af */
    private Bitmap f1203af;

    /* renamed from: ag */
    private Bitmap f1204ag;

    /* renamed from: ah */
    private Bitmap f1205ah;

    /* renamed from: ai */
    private Bitmap f1206ai;

    /* renamed from: b */
    protected HitDirection f1207b;

    /* renamed from: g */
    private Bitmap f1212g;

    /* renamed from: h */
    private Bitmap f1213h;

    /* renamed from: i */
    private Bitmap f1214i;

    /* renamed from: j */
    private Bitmap f1215j;

    /* renamed from: k */
    private boolean f1216k;

    /* renamed from: x */
    private float f1229x;

    /* renamed from: y */
    private AudioManager f1230y;

    /* renamed from: a */
    public AbstractSprite f1197a = null;

    /* renamed from: d */
    private boolean f1209d = false;

    /* renamed from: e */
    private PointF[] f1210e = {new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET), new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET)};

    /* renamed from: f */
    private PointF f1211f = new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);

    /* renamed from: l */
    private int f1217l = 156;

    /* renamed from: m */
    private int f1218m = 156;

    /* renamed from: n */
    private boolean f1219n = false;

    /* renamed from: o */
    private boolean f1220o = false;

    /* renamed from: p */
    private ArrayList<PointF> f1221p = new ArrayList<>();

    /* renamed from: q */
    private ArrayList<PointF> f1222q = new ArrayList<>();

    /* renamed from: r */
    private int f1223r = 0;

    /* renamed from: s */
    private int f1224s = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SHEET_DELETE_CONTENT_EVENT;

    /* renamed from: t */
    private int f1225t = 0;

    /* renamed from: u */
    private int f1226u = 1128;

    /* renamed from: v */
    private PointF f1227v = new PointF();

    /* renamed from: w */
    private PointF[] f1228w = new PointF[4];

    /* renamed from: z */
    private String f1231z = "Delete";

    /* renamed from: A */
    private String f1171A = "Rotate Left";

    /* renamed from: B */
    private String f1172B = "Rotate Right";

    /* renamed from: C */
    private boolean f1173C = false;

    /* renamed from: D */
    private boolean f1174D = false;

    /* renamed from: E */
    private OnImageSelectedListener f1175E = null;

    /* renamed from: F */
    private int f1176F = 86;

    /* renamed from: G */
    private int f1177G = 125;

    /* renamed from: H */
    private int f1178H = 81;

    /* renamed from: I */
    private int f1179I = 92;

    /* renamed from: J */
    private int f1180J = 68;

    /* renamed from: K */
    private int f1181K = 35;

    /* renamed from: L */
    private int f1182L = 23;

    /* renamed from: M */
    private int f1183M = this.f1179I * 2;

    /* renamed from: N */
    private int f1184N = 42;

    /* renamed from: O */
    private Rect f1185O = new Rect();

    /* renamed from: P */
    private Rect f1186P = new Rect();

    /* renamed from: Q */
    private Rect f1187Q = new Rect();

    /* renamed from: R */
    private boolean f1188R = false;

    /* renamed from: S */
    private boolean f1189S = false;

    /* renamed from: T */
    private boolean f1190T = false;

    /* renamed from: U */
    private boolean f1191U = false;

    /* renamed from: c */
    private Paint f1208c = new Paint();

    public enum HitDirection {
        INNER,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        LEFT_TOP,
        RIGHT_TOP,
        LEFT_BOTTOM,
        RIGHT_BOTTOM,
        DELETE,
        ROTATE_LEFT,
        ROTATE_RIGHT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static HitDirection[] valuesCustom() {
            HitDirection[] hitDirectionArrValuesCustom = values();
            int length = hitDirectionArrValuesCustom.length;
            HitDirection[] hitDirectionArr = new HitDirection[length];
            System.arraycopy(hitDirectionArrValuesCustom, 0, hitDirectionArr, 0, length);
            return hitDirectionArr;
        }
    }

    public interface OnImageSelectedListener {
        void onImageSelected(ObjectInfo objectInfo, boolean z);
    }

    /* renamed from: b */
    static /* synthetic */ int[] m1082b() {
        int[] iArr = f1170aj;
        if (iArr == null) {
            iArr = new int[HitDirection.valuesCustom().length];
            try {
                iArr[HitDirection.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HitDirection.DELETE.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HitDirection.INNER.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[HitDirection.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[HitDirection.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[HitDirection.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[HitDirection.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[HitDirection.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[HitDirection.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[HitDirection.ROTATE_LEFT.ordinal()] = 11;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[HitDirection.ROTATE_RIGHT.ordinal()] = 12;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[HitDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            f1170aj = iArr;
        }
        return iArr;
    }

    public SelectMode() {
        this.f1208c.setAntiAlias(true);
        this.f1208c.setDither(true);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context) {
        if (this.f1197a != null) {
            if (this.f1175E != null && ((C0989ab) this.f1197a).m1259b() != null) {
                this.f1175E.onImageSelected(((C0989ab) this.f1197a).m1262c(), false);
            }
            this.f1197a.deselect();
        }
        this.f1197a = null;
    }

    /* renamed from: b */
    private void m1080b(AbstractModeContext abstractModeContext) {
        Iterator<AbstractSprite> it = abstractModeContext.stage.getSprites().iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next.isSelected() && (next instanceof C0989ab)) {
                this.f1197a = next;
                return;
            }
        }
        this.f1197a = null;
    }

    /* renamed from: a */
    private boolean m1076a(AbstractModeContext abstractModeContext, PointF pointF) {
        this.f1197a.deselect();
        if (this.f1175E != null) {
            this.f1175E.onImageSelected(((C0989ab) this.f1197a).m1262c(), false);
        }
        AbstractSprite abstractSpriteSelectHittedImageSprite = ((Stage) abstractModeContext.stage).selectHittedImageSprite(pointF);
        abstractModeContext.stage.clearLayer(2);
        abstractModeContext.stage.clearLayer(4);
        abstractModeContext.stage.drawBackgroundTheme();
        if (abstractSpriteSelectHittedImageSprite != null) {
            this.f1197a = abstractSpriteSelectHittedImageSprite;
            LinkedList<AbstractSprite> linkedListM812a = abstractModeContext.stage.m812a(StrokeSprite.class, C1063s.class);
            LinkedList<AbstractSprite> linkedListM827b = abstractModeContext.stage.m827b(StrokeSprite.class, C1063s.class);
            LinkedList<AbstractSprite> linkedListM811a = abstractModeContext.stage.m811a(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM826b = abstractModeContext.stage.m826b(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM811a2 = abstractModeContext.stage.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = abstractModeContext.stage.m826b(TextSprite.class);
            abstractModeContext.stage.clearLayer(1);
            if (linkedListM811a != null) {
                abstractModeContext.stage.m818a(2, linkedListM811a, this.f1197a);
            }
            if (linkedListM811a2 != null) {
                abstractModeContext.stage.m818a(2, linkedListM811a2, this.f1197a);
            }
            if (linkedListM812a != null) {
                abstractModeContext.stage.m817a(0, linkedListM812a);
            }
            if (abstractModeContext.stage.getSelectedLayerID() == 0 && !abstractModeContext.stage.getDrawingFront()) {
                abstractModeContext.stage.renderSprite(1, this.f1197a);
                if (linkedListM826b != null) {
                    abstractModeContext.stage.m818a(4, linkedListM826b, this.f1197a);
                }
                if (linkedListM826b2 != null) {
                    abstractModeContext.stage.m818a(4, linkedListM826b2, this.f1197a);
                }
                if (linkedListM827b != null) {
                    abstractModeContext.stage.m817a(3, linkedListM827b);
                }
            } else {
                if (linkedListM826b != null) {
                    abstractModeContext.stage.m818a(4, linkedListM826b, this.f1197a);
                }
                if (linkedListM826b2 != null) {
                    abstractModeContext.stage.m818a(4, linkedListM826b2, this.f1197a);
                }
                if (linkedListM827b != null) {
                    abstractModeContext.stage.m817a(3, linkedListM827b);
                }
                abstractModeContext.stage.renderSprite(1, this.f1197a);
            }
            abstractModeContext.invalidate();
            if (this.f1175E == null) {
                return true;
            }
            this.f1175E.onImageSelected(((C0989ab) this.f1197a).m1262c(), true);
            return true;
        }
        LinkedList<AbstractSprite> linkedListM812a2 = abstractModeContext.stage.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b2 = abstractModeContext.stage.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a3 = abstractModeContext.stage.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b3 = abstractModeContext.stage.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a4 = abstractModeContext.stage.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b4 = abstractModeContext.stage.m826b(TextSprite.class);
        if (linkedListM811a3 != null) {
            abstractModeContext.stage.m818a(2, linkedListM811a3, this.f1197a);
        }
        if (linkedListM811a4 != null) {
            abstractModeContext.stage.m818a(2, linkedListM811a4, this.f1197a);
        }
        if (linkedListM812a2 != null) {
            abstractModeContext.stage.m817a(0, linkedListM812a2);
        }
        if (abstractModeContext.stage.getSelectedLayerID() == 0 && !abstractModeContext.stage.getDrawingFront()) {
            abstractModeContext.stage.renderSprite(1, this.f1197a);
            if (linkedListM826b3 != null) {
                abstractModeContext.stage.m818a(4, linkedListM826b3, this.f1197a);
            }
            if (linkedListM826b4 != null) {
                abstractModeContext.stage.m818a(4, linkedListM826b4, this.f1197a);
            }
            if (linkedListM827b2 != null) {
                abstractModeContext.stage.m817a(3, linkedListM827b2);
            }
        } else {
            if (linkedListM826b3 != null) {
                abstractModeContext.stage.m818a(4, linkedListM826b3, this.f1197a);
            }
            if (linkedListM826b4 != null) {
                abstractModeContext.stage.m818a(4, linkedListM826b4, this.f1197a);
            }
            if (linkedListM827b2 != null) {
                abstractModeContext.stage.m817a(3, linkedListM827b2);
            }
            abstractModeContext.stage.renderSprite(1, this.f1197a);
        }
        this.f1197a = null;
        return false;
    }

    @Override // com.samsung.sdraw.ModeState
    public void onActivate(AbstractModeContext context, boolean isActive) {
        if (isActive) {
            context.stage.clearLayers();
            m1080b(context);
            LinkedList<AbstractSprite> linkedListM812a = context.stage.m812a(StrokeSprite.class, C1063s.class);
            LinkedList<AbstractSprite> linkedListM827b = context.stage.m827b(StrokeSprite.class, C1063s.class);
            LinkedList<AbstractSprite> linkedListM811a = context.stage.m811a(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM826b = context.stage.m826b(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM811a2 = context.stage.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = context.stage.m826b(TextSprite.class);
            Canvas canvasM830c = context.stage.m830c(0);
            if (context.stage.f845i != null && context.stage.layerIsVisible(0)) {
                canvasM830c.drawBitmap(context.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
            if (linkedListM811a != null) {
                context.stage.m818a(2, linkedListM811a, this.f1197a);
            }
            if (linkedListM811a2 != null) {
                context.stage.m818a(2, linkedListM811a2, this.f1197a);
            }
            if (linkedListM812a != null) {
                context.stage.m817a(0, linkedListM812a);
            }
            Canvas canvasM830c2 = context.stage.m830c(3);
            if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                context.stage.renderSprite(1, this.f1197a);
                if (context.stage.fixedSprites2 != null && context.stage.layerIsVisible(3)) {
                    canvasM830c2.drawBitmap(context.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM826b != null) {
                    context.stage.m818a(4, linkedListM826b, this.f1197a);
                }
                if (linkedListM826b2 != null) {
                    context.stage.m818a(4, linkedListM826b2, this.f1197a);
                }
                if (linkedListM827b != null) {
                    context.stage.m817a(3, linkedListM827b);
                }
            } else {
                if (context.stage.fixedSprites2 != null && context.stage.layerIsVisible(3)) {
                    canvasM830c2.drawBitmap(context.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM826b != null) {
                    context.stage.m818a(4, linkedListM826b, this.f1197a);
                }
                if (linkedListM826b2 != null) {
                    context.stage.m818a(4, linkedListM826b2, this.f1197a);
                }
                if (linkedListM827b != null) {
                    context.stage.m817a(3, linkedListM827b);
                }
                context.stage.renderSprite(1, this.f1197a);
            }
            context.invalidate();
            if (!this.f1173C && this.f1197a != null && this.f1175E != null) {
                this.f1175E.onImageSelected(((C0989ab) this.f1197a).m1262c(), true);
            }
            this.f1173C = false;
            return;
        }
        context.stage.clearLayer(1);
        onFinishJob(context);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onLayout(AbstractModeContext context, Rect rect) {
        this.f1173C = true;
        onActivate(context, true);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas) {
        if (context.stage != null) {
            Bitmap bitmapM825b = context.stage.m825b(2);
            Bitmap bitmapM825b2 = context.stage.m825b(4);
            Bitmap bitmapM825b3 = context.stage.m825b(0);
            Bitmap bitmapM825b4 = context.stage.m825b(3);
            Bitmap bitmapM825b5 = context.stage.m825b(1);
            PointF panning = context.getPanning();
            float zoom = context.getZoom();
            if (bitmapM825b != null && context.stage.layerIsVisible(2)) {
                canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
            }
            if (bitmapM825b3 != null && context.stage.layerIsVisible(0)) {
                canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
            }
            if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                if (bitmapM825b5 != null) {
                    canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                    m1080b(context);
                    if (this.f1197a != null) {
                        this.f1197a.mo1136a();
                        RectF bounds = this.f1197a.getBounds();
                        m1090a(context, canvas, bounds, panning, zoom);
                        if (this.f1197a instanceof C0989ab) {
                            m1089a(context, canvas, (Paint) null, bounds, panning);
                            m1068a(context, canvas, bounds.top, bounds.centerX(), bounds.bottom, panning);
                        }
                    }
                }
                if (bitmapM825b2 != null && context.stage.layerIsVisible(4)) {
                    canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                }
                if (bitmapM825b4 != null && context.stage.layerIsVisible(3)) {
                    canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                    return;
                }
                return;
            }
            if (bitmapM825b2 != null && context.stage.layerIsVisible(4)) {
                canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
            }
            if (bitmapM825b4 != null && context.stage.layerIsVisible(3)) {
                canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
            }
            if (bitmapM825b5 != null) {
                canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                m1080b(context);
                if (this.f1197a != null) {
                    this.f1197a.mo1136a();
                    RectF bounds2 = this.f1197a.getBounds();
                    m1090a(context, canvas, bounds2, panning, zoom);
                    if (this.f1197a instanceof C0989ab) {
                        m1089a(context, canvas, (Paint) null, bounds2, panning);
                        m1068a(context, canvas, bounds2.top, bounds2.centerX(), bounds2.bottom, panning);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected void m1089a(AbstractModeContext abstractModeContext, Canvas canvas, Paint paint, RectF rectF, PointF pointF) {
        float f;
        C0997aj c0997aj = new C0997aj(abstractModeContext.view.getContext(), ((CanvasView) abstractModeContext.view).f984e);
        if (this.f1214i == null) {
            this.f1214i = c0997aj.m1532d("/camera_crop_holo_hdpi.png");
        }
        if (this.f1215j == null) {
            this.f1215j = c0997aj.m1532d("/camera_crop_holo_hdpi.png");
        }
        if (this.f1212g == null) {
            this.f1212g = c0997aj.m1532d("/camera_crop_holo_hdpi.png");
        }
        if (this.f1213h == null) {
            this.f1213h = c0997aj.m1532d("/camera_crop_holo_hdpi.png");
        }
        if (this.f1214i != null && this.f1215j != null && this.f1212g != null && this.f1213h != null) {
            canvas.save();
            float[] fArr = new float[9];
            new Matrix(abstractModeContext.f661c).getValues(fArr);
            if (fArr[0] <= 1.0f) {
                f = 1.0f;
            } else {
                f = fArr[0];
            }
            HitDirection[] hitDirectionArrValuesCustom = HitDirection.valuesCustom();
            int width = this.f1212g.getWidth() / 2;
            Rect rect = new Rect((int) (rectF.left * f), (int) (rectF.top * f), (int) (rectF.right * f), (int) (rectF.bottom * f));
            if (this.f1197a instanceof C0989ab) {
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= 9) {
                        break;
                    }
                    Rect rectM1085a = m1085a(hitDirectionArrValuesCustom[i2], width, rect);
                    Matrix matrix = new Matrix();
                    if (fArr[0] > 1.0f) {
                        matrix.postScale(1.0f / f, 1.0f / f, rectM1085a.centerX(), rectM1085a.centerY());
                    }
                    matrix.preRotate(((C0989ab) this.f1197a).f1423j, rectM1085a.centerX(), rectM1085a.centerY());
                    canvas.save();
                    canvas.concat(matrix);
                    if (i2 == 1) {
                        canvas.drawBitmap(this.f1212g, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 2) {
                        canvas.drawBitmap(this.f1213h, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 3) {
                        canvas.drawBitmap(this.f1212g, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 4) {
                        canvas.drawBitmap(this.f1213h, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 5) {
                        canvas.drawBitmap(this.f1215j, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 6) {
                        canvas.drawBitmap(this.f1214i, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 7) {
                        canvas.drawBitmap(this.f1214i, rectM1085a.left, rectM1085a.top, paint);
                    } else if (i2 == 8) {
                        canvas.drawBitmap(this.f1215j, rectM1085a.left, rectM1085a.top, paint);
                    }
                    canvas.restore();
                    i = i2 + 1;
                }
            }
            canvas.restore();
        }
    }

    /* renamed from: a */
    protected Rect m1085a(HitDirection hitDirection, int i, Rect rect) {
        Rect rect2 = new Rect(rect);
        C0989ab c0989ab = (C0989ab) this.f1197a;
        new Matrix().preRotate(((C0989ab) this.f1197a).f1423j, this.f1197a.getBounds().centerX(), this.f1197a.getBounds().centerY());
        switch (m1082b()[hitDirection.ordinal()]) {
            case 2:
                PointF pointFM1067a = m1067a(c0989ab.m1263c(0), c0989ab.m1263c(2));
                return new Rect(((int) pointFM1067a.x) - i, ((int) pointFM1067a.y) - i, ((int) pointFM1067a.x) + i, ((int) pointFM1067a.y) + i);
            case 3:
                PointF pointFM1067a2 = m1067a(c0989ab.m1263c(0), c0989ab.m1263c(1));
                return new Rect(((int) pointFM1067a2.x) - i, ((int) pointFM1067a2.y) - i, ((int) pointFM1067a2.x) + i, ((int) pointFM1067a2.y) + i);
            case 4:
                PointF pointFM1067a3 = m1067a(c0989ab.m1263c(1), c0989ab.m1263c(3));
                return new Rect(((int) pointFM1067a3.x) - i, ((int) pointFM1067a3.y) - i, ((int) pointFM1067a3.x) + i, ((int) pointFM1067a3.y) + i);
            case 5:
                PointF pointFM1067a4 = m1067a(c0989ab.m1263c(2), c0989ab.m1263c(3));
                return new Rect(((int) pointFM1067a4.x) - i, ((int) pointFM1067a4.y) - i, ((int) pointFM1067a4.x) + i, ((int) pointFM1067a4.y) + i);
            case 6:
                return new Rect(((int) c0989ab.m1263c(0).x) - i, ((int) c0989ab.m1263c(0).y) - i, ((int) c0989ab.m1263c(0).x) + i, ((int) c0989ab.m1263c(0).y) + i);
            case 7:
                return new Rect(((int) c0989ab.m1263c(1).x) - i, ((int) c0989ab.m1263c(1).y) - i, ((int) c0989ab.m1263c(1).x) + i, ((int) c0989ab.m1263c(1).y) + i);
            case 8:
                return new Rect(((int) c0989ab.m1263c(2).x) - i, ((int) c0989ab.m1263c(2).y) - i, ((int) c0989ab.m1263c(2).x) + i, ((int) c0989ab.m1263c(2).y) + i);
            case 9:
                return new Rect(((int) c0989ab.m1263c(3).x) - i, ((int) c0989ab.m1263c(3).y) - i, ((int) c0989ab.m1263c(3).x) + i, ((int) c0989ab.m1263c(3).y) + i);
            case 10:
                return new Rect(this.f1185O);
            case 11:
                return new Rect(this.f1186P);
            case 12:
                return new Rect(this.f1187Q);
            default:
                return rect2;
        }
    }

    /* renamed from: a */
    private PointF m1067a(PointF pointF, PointF pointF2) {
        return new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
    }

    /* renamed from: a */
    protected void m1090a(AbstractModeContext abstractModeContext, Canvas canvas, RectF rectF, PointF pointF, float f) {
        RectF rectF2 = new RectF(((C0989ab) this.f1197a).m1264d());
        canvas.save();
        Matrix matrix = new Matrix();
        matrix.preRotate(((C0989ab) this.f1197a).f1423j, rectF2.centerX(), rectF2.centerY());
        canvas.concat(matrix);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16676356);
        paint.setStrokeWidth(2.0f);
        canvas.drawRect(rectF2, paint);
        canvas.restore();
    }

    /* renamed from: a */
    private void m1073a(HitDirection hitDirection) {
        this.f1216k = true;
        this.f1207b = hitDirection;
    }

    /* renamed from: a */
    private void m1071a(AbstractModeContext abstractModeContext, MotionEvent motionEvent, RectF rectF) {
        PointF pointFMapToScene = abstractModeContext.stage.mapToScene(new PointF((int) motionEvent.getX(0), (int) motionEvent.getY(0)));
        PointF pointFMapToScene2 = abstractModeContext.stage.mapToScene(new PointF((int) motionEvent.getX(1), (int) motionEvent.getY(1)));
        if (this.f1197a.isHitted(new RectF(pointFMapToScene2.x, pointFMapToScene2.y, pointFMapToScene2.x + 1.0f, pointFMapToScene2.y + 1.0f))) {
            this.f1220o = true;
            this.f1221p.add(pointFMapToScene);
            this.f1222q.add(pointFMapToScene2);
        }
    }

    /* renamed from: a */
    private void m1070a(AbstractModeContext abstractModeContext, MotionEvent motionEvent) {
        this.f1220o = true;
        PointF pointFMapToScene = abstractModeContext.stage.mapToScene(new PointF((int) motionEvent.getX(0), (int) motionEvent.getY(0)));
        PointF pointFMapToScene2 = abstractModeContext.stage.mapToScene(new PointF((int) motionEvent.getX(1), (int) motionEvent.getY(1)));
        this.f1221p.add(pointFMapToScene);
        this.f1222q.add(pointFMapToScene2);
        m1069a(abstractModeContext, this.f1197a.getBounds(), false);
    }

    /* renamed from: a */
    private boolean m1075a(AbstractModeContext abstractModeContext, int i, Rect rect, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        if (this.f1197a != null) {
            if (i == 0) {
                RectF bounds = this.f1197a.getBounds();
                bounds.offset(this.f1211f.x, this.f1211f.y);
                Rect canvasRect = abstractModeContext.setting.getCanvasRect();
                if (bounds.right < 100.0f) {
                    this.f1211f.offset(100.0f - bounds.right, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                } else if (bounds.left > abstractModeContext.setting.getCanvasRect().right - 100) {
                    this.f1211f.offset((abstractModeContext.setting.getCanvasRect().right - 100) - bounds.left, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                }
                if (bounds.bottom < 100.0f) {
                    this.f1211f.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 100.0f - bounds.bottom);
                    return false;
                }
                if (bounds.top > abstractModeContext.setting.getCanvasRect().bottom - 100) {
                    this.f1211f.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (abstractModeContext.setting.getCanvasRect().bottom - 100) - bounds.top);
                    return false;
                }
                PointF pointFM1263c = ((C0989ab) this.f1197a).m1263c(0);
                PointF pointFM1263c2 = ((C0989ab) this.f1197a).m1263c(1);
                PointF pointFM1263c3 = ((C0989ab) this.f1197a).m1263c(2);
                PointF pointFM1263c4 = ((C0989ab) this.f1197a).m1263c(3);
                pointFM1263c.offset(this.f1211f.x, this.f1211f.y);
                pointFM1263c2.offset(this.f1211f.x, this.f1211f.y);
                pointFM1263c3.offset(this.f1211f.x, this.f1211f.y);
                pointFM1263c4.offset(this.f1211f.x, this.f1211f.y);
                if (!canvasRect.contains((int) pointFM1263c.x, (int) pointFM1263c.y) && !canvasRect.contains((int) pointFM1263c2.x, (int) pointFM1263c2.y) && !canvasRect.contains((int) pointFM1263c3.x, (int) pointFM1263c3.y) && !canvasRect.contains((int) pointFM1263c4.x, (int) pointFM1263c4.y)) {
                    if ((bounds.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && bounds.right > canvasRect.right) || (bounds.top < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && bounds.bottom > canvasRect.bottom)) {
                        return true;
                    }
                    this.f1211f.offset(-this.f1211f.x, -this.f1211f.y);
                    return false;
                }
            } else if (i == 1) {
                PointF[] pointFArr = {((C0989ab) this.f1197a).m1263c(0), ((C0989ab) this.f1197a).m1263c(1), ((C0989ab) this.f1197a).m1263c(2), ((C0989ab) this.f1197a).m1263c(3)};
                if (pointF != null) {
                    pointFArr[0] = pointF;
                }
                if (pointF2 != null) {
                    pointFArr[1] = pointF2;
                }
                if (pointF3 != null) {
                    pointFArr[2] = pointF3;
                }
                if (pointF4 != null) {
                    pointFArr[3] = pointF4;
                }
                RectF rectF = new RectF();
                rectF.left = pointFArr[0].x;
                rectF.right = pointFArr[0].x;
                rectF.top = pointFArr[0].y;
                rectF.bottom = pointFArr[0].y;
                for (int i2 = 0; i2 < 4; i2++) {
                    if (pointFArr[i2].x < rectF.left) {
                        rectF.left = pointFArr[i2].x;
                    }
                    if (pointFArr[i2].x > rectF.right) {
                        rectF.right = pointFArr[i2].x;
                    }
                    if (pointFArr[i2].y > rectF.bottom) {
                        rectF.bottom = pointFArr[i2].y;
                    }
                    if (pointFArr[i2].y < rectF.top) {
                        rectF.top = pointFArr[i2].y;
                    }
                }
                if (rectF.right < 100.0f || rectF.left > rect.right - 100 || rectF.bottom < 100.0f || rectF.top > rect.bottom - 100) {
                    return false;
                }
                if (!rect.contains((int) pointFArr[0].x, (int) pointFArr[0].y) && !rect.contains((int) pointFArr[1].x, (int) pointFArr[1].y) && !rect.contains((int) pointFArr[2].x, (int) pointFArr[2].y) && !rect.contains((int) pointFArr[3].x, (int) pointFArr[3].y)) {
                    if ((rectF.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && rectF.right > rect.right) || (rectF.top < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && rectF.bottom > rect.bottom)) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event) {
        HitDirection hitDirectionM1086a;
        if (this.f1197a == null) {
            return false;
        }
        RectF bounds = this.f1197a.getBounds();
        PointF pointF = new PointF(event.getX(), event.getY());
        PointF pointFMapToScene = context.stage.mapToScene(pointF);
        int action = event.getAction();
        int pointerCount = event.getPointerCount();
        if (event.getActionMasked() == 5 && pointerCount > 1) {
            this.f1210e[1].x = event.getX();
            this.f1210e[1].y = event.getY();
        }
        switch (action) {
            case 0:
                this.f1210e[0].x = pointFMapToScene.x;
                this.f1210e[0].y = pointFMapToScene.y;
                if (event.getPointerCount() > 1) {
                    m1071a(context, event, bounds);
                } else {
                    if (context.setting.getStrokeInput() == StrokeSprite.InputMethod.Tablet) {
                        hitDirectionM1086a = m1086a(pointFMapToScene, 25);
                    } else {
                        hitDirectionM1086a = m1086a(pointFMapToScene, 30);
                    }
                    if (hitDirectionM1086a == HitDirection.DELETE || hitDirectionM1086a == HitDirection.ROTATE_RIGHT || hitDirectionM1086a == HitDirection.ROTATE_LEFT) {
                        this.f1188R = true;
                        if (hitDirectionM1086a == HitDirection.DELETE) {
                            this.f1189S = true;
                            m1088a(context);
                        } else if (hitDirectionM1086a == HitDirection.ROTATE_LEFT) {
                            this.f1190T = true;
                            m1088a(context);
                        } else {
                            this.f1191U = true;
                            m1088a(context);
                        }
                    } else if (hitDirectionM1086a != HitDirection.INNER) {
                        m1073a(hitDirectionM1086a);
                        this.f1209d = true;
                    } else if (this.f1197a.isHitted(new RectF(pointFMapToScene.x, pointFMapToScene.y, pointFMapToScene.x + 1.0f, pointFMapToScene.y + 1.0f))) {
                        this.f1209d = true;
                    } else {
                        this.f1209d = m1076a(context, pointF);
                    }
                }
                if (this.f1197a instanceof C0989ab) {
                    C0989ab c0989ab = (C0989ab) this.f1197a;
                    this.f1227v = new PointF(c0989ab.m1263c(0));
                    this.f1228w = c0989ab.m1268g();
                    this.f1229x = c0989ab.f1423j;
                    break;
                }
                break;
            case 1:
                if (this.f1220o) {
                    m1069a(context, bounds, true);
                    this.f1221p.clear();
                    this.f1222q.clear();
                    this.f1220o = false;
                    if (context.historyChangeListener != null) {
                        context.historyChangeListener.onHistoryChanged(context.stage.isUndoable(), context.stage.isRedoable());
                    }
                    return true;
                }
                if (this.f1216k) {
                    m1081b(context, pointFMapToScene);
                } else if (this.f1219n) {
                    context.stage.moveSprite(this.f1197a, this.f1211f, this.f1227v, true);
                    m1088a(context);
                    this.f1219n = false;
                }
                this.f1209d = false;
                this.f1216k = false;
                if (this.f1188R) {
                    if (this.f1230y == null) {
                        this.f1230y = (AudioManager) context.view.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    }
                    if (this.f1189S) {
                        m1072a(context, HitDirection.DELETE);
                        this.f1230y.playSoundEffect(0);
                    } else if (this.f1190T) {
                        m1072a(context, HitDirection.ROTATE_LEFT);
                        this.f1230y.playSoundEffect(0);
                    } else if (this.f1191U) {
                        m1072a(context, HitDirection.ROTATE_RIGHT);
                        this.f1230y.playSoundEffect(0);
                    }
                    this.f1188R = false;
                    this.f1189S = false;
                    this.f1190T = false;
                    this.f1191U = false;
                    m1088a(context);
                }
                if (context.historyChangeListener != null) {
                    context.historyChangeListener.onHistoryChanged(context.stage.isUndoable(), context.stage.isRedoable());
                    break;
                }
                break;
            case 2:
                if (this.f1188R) {
                    if (this.f1189S) {
                        this.f1207b = m1086a(pointFMapToScene, 25);
                        if (this.f1207b != HitDirection.DELETE) {
                            this.f1189S = false;
                            m1088a(context);
                        }
                    } else if (this.f1190T) {
                        this.f1207b = m1086a(pointFMapToScene, 25);
                        if (this.f1207b != HitDirection.ROTATE_LEFT) {
                            this.f1190T = false;
                            m1088a(context);
                        }
                    } else if (this.f1191U) {
                        this.f1207b = m1086a(pointFMapToScene, 25);
                        if (this.f1207b != HitDirection.ROTATE_RIGHT) {
                            m1088a(context);
                            this.f1191U = false;
                        }
                    }
                }
                if (this.f1209d) {
                    if (pointerCount > 1) {
                        m1070a(context, event);
                        break;
                    } else if (!this.f1220o) {
                        if (this.f1216k) {
                            PointF[] pointFArrM1268g = ((C0989ab) this.f1197a).m1268g();
                            this.f1217l = context.setting.getImageObjectMinimumEditableSize();
                            this.f1218m = context.setting.getImageObjectMinimumEditableSize();
                            m1074a(pointFArrM1268g, pointFMapToScene, context.setting.getCanvasRect());
                            m1088a(context);
                            break;
                        } else {
                            this.f1219n = true;
                            this.f1211f.x = pointFMapToScene.x - this.f1210e[0].x;
                            this.f1211f.y = pointFMapToScene.y - this.f1210e[0].y;
                            this.f1211f.x /= context.getZoom();
                            this.f1211f.y /= context.getZoom();
                            m1075a(context, 0, null, null, null, null, null);
                            ((C0989ab) this.f1197a).m1253a(this.f1211f.x, this.f1211f.y);
                            m1088a(context);
                            this.f1210e[0].x = pointFMapToScene.x;
                            this.f1210e[0].y = pointFMapToScene.y;
                            break;
                        }
                    } else {
                        return true;
                    }
                }
                break;
            case 3:
                this.f1221p.clear();
                this.f1222q.clear();
                if (context.setting.mOnDrawCancelListener != null) {
                    context.setting.mOnDrawCancelListener.onCancel(context.setting.getUserID());
                    break;
                }
                break;
            case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_NEW_EVENT /* 261 */:
                m1071a(context, event, bounds);
                break;
        }
        return true;
    }

    /* renamed from: a */
    private void m1069a(AbstractModeContext abstractModeContext, RectF rectF, boolean z) {
        int size = this.f1221p.size();
        int size2 = this.f1222q.size();
        if (size < 2 || size2 < 2) {
            this.f1221p.clear();
            this.f1222q.clear();
            return;
        }
        double dM1078b = m1078b(this.f1221p.get(this.f1221p.size() - 2), this.f1222q.get(this.f1221p.size() - 2));
        double dM1078b2 = m1078b(this.f1221p.get(this.f1221p.size() - 1), this.f1222q.get(this.f1222q.size() - 1));
        double dSqrt = Math.sqrt(m1083c(this.f1221p.get(this.f1221p.size() - 2), this.f1222q.get(this.f1221p.size() - 2)));
        double dSqrt2 = Math.sqrt(m1083c(this.f1221p.get(this.f1221p.size() - 1), this.f1222q.get(this.f1222q.size() - 1)));
        if (dM1078b < 0.0d) {
            dM1078b = 360.0d + dM1078b;
        }
        double d = dM1078b2 < 0.0d ? 360.0d + dM1078b2 : dM1078b2;
        if (dM1078b > 270.0d && d < 90.0d) {
            d += 360.0d;
        } else if (dM1078b < 90.0d && d > 270.0d) {
            d -= 360.0d;
        }
        double d2 = d - dM1078b;
        if (Math.abs(dSqrt - dSqrt2) <= 30.0d && Math.abs(d2) > 1.0d) {
            C0989ab c0989ab = (C0989ab) this.f1197a;
            if (c0989ab == null) {
                this.f1221p.clear();
                this.f1222q.clear();
                return;
            } else if (d2 > 0.0d) {
                c0989ab.m1260b(-3);
            } else {
                c0989ab.m1260b(3);
            }
        }
        if (z) {
            abstractModeContext.stage.rotateSprite(this.f1197a, ((C0989ab) this.f1197a).f1423j, this.f1229x, true);
        }
        m1088a(abstractModeContext);
    }

    /* renamed from: b */
    private double m1078b(PointF pointF, PointF pointF2) {
        return (180.0d * Math.atan2(pointF2.y - pointF.y, pointF.x - pointF2.x)) / 3.141592653589793d;
    }

    /* renamed from: c */
    private double m1083c(PointF pointF, PointF pointF2) {
        return ((pointF2.y - pointF.y) * (pointF2.y - pointF.y)) + ((pointF.x - pointF2.x) * (pointF.x - pointF2.x));
    }

    /* renamed from: b */
    private void m1081b(AbstractModeContext abstractModeContext, PointF pointF) {
        abstractModeContext.stage.resizeSprite(this.f1197a, ((C0989ab) this.f1197a).m1268g(), this.f1228w, true);
        m1088a(abstractModeContext);
    }

    /* renamed from: a */
    protected HitDirection m1086a(PointF pointF, int i) {
        HitDirection[] hitDirectionArrValuesCustom = HitDirection.valuesCustom();
        if (this.f1197a instanceof C0989ab) {
            for (int i2 = 1; i2 < hitDirectionArrValuesCustom.length; i2++) {
                if (m1085a(hitDirectionArrValuesCustom[i2], i, new Rect((int) this.f1197a.getBounds().left, (int) this.f1197a.getBounds().top, (int) this.f1197a.getBounds().right, (int) this.f1197a.getBounds().bottom)).contains((int) pointF.x, (int) pointF.y)) {
                    return hitDirectionArrValuesCustom[i2];
                }
            }
        }
        return hitDirectionArrValuesCustom[0];
    }

    /* renamed from: a */
    public void m1088a(AbstractModeContext abstractModeContext) {
        abstractModeContext.stage.clearLayer(1);
        abstractModeContext.stage.renderSprite(1, this.f1197a);
        abstractModeContext.invalidate();
    }

    /* renamed from: a */
    public void m1091a(AbstractModeContext abstractModeContext, AbstractSprite abstractSprite) {
        clearOffscreenBuffer(abstractModeContext);
        abstractModeContext.stage.clearLayers();
        LinkedList<AbstractSprite> linkedListM812a = abstractModeContext.stage.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = abstractModeContext.stage.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = abstractModeContext.stage.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b = abstractModeContext.stage.m826b(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM811a2 = abstractModeContext.stage.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b2 = abstractModeContext.stage.m826b(C0989ab.class);
        abstractModeContext.stage.renderFixedSprites(0);
        Iterator<AbstractSprite> it = linkedListM811a2.iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (!next.isSelected()) {
                abstractModeContext.stage.renderSprite(next.getLayerID(), next);
            }
        }
        if (linkedListM811a != null) {
            abstractModeContext.stage.m817a(2, linkedListM811a);
        }
        if (linkedListM812a != null) {
            abstractModeContext.stage.m817a(0, linkedListM812a);
        }
        if (abstractModeContext.stage.getSelectedLayerID() == 0 && !abstractModeContext.stage.getDrawingFront()) {
            Iterator<AbstractSprite> it2 = linkedListM811a2.iterator();
            while (it2.hasNext()) {
                AbstractSprite next2 = it2.next();
                if (next2.isSelected()) {
                    abstractModeContext.stage.renderSprite(1, next2);
                }
            }
            abstractModeContext.stage.renderFixedSprites(3);
            Iterator<AbstractSprite> it3 = linkedListM826b2.iterator();
            while (it3.hasNext()) {
                AbstractSprite next3 = it3.next();
                if (!next3.isSelected()) {
                    abstractModeContext.stage.renderSprite(next3.getLayerID(), next3);
                }
            }
            if (linkedListM826b != null) {
                abstractModeContext.stage.m817a(4, linkedListM826b);
            }
            if (linkedListM827b != null) {
                abstractModeContext.stage.m817a(3, linkedListM827b);
            }
            Iterator<AbstractSprite> it4 = linkedListM826b2.iterator();
            while (it4.hasNext()) {
                AbstractSprite next4 = it4.next();
                if (next4.isSelected()) {
                    abstractModeContext.stage.renderSprite(1, next4);
                }
            }
        } else {
            abstractModeContext.stage.renderFixedSprites(3);
            Iterator<AbstractSprite> it5 = linkedListM826b2.iterator();
            while (it5.hasNext()) {
                AbstractSprite next5 = it5.next();
                if (!next5.isSelected()) {
                    abstractModeContext.stage.renderSprite(next5.getLayerID(), next5);
                }
            }
            if (linkedListM826b != null) {
                abstractModeContext.stage.m817a(4, linkedListM826b);
            }
            if (linkedListM827b != null) {
                abstractModeContext.stage.m817a(3, linkedListM827b);
            }
            Iterator<AbstractSprite> it6 = linkedListM826b2.iterator();
            while (it6.hasNext()) {
                AbstractSprite next6 = it6.next();
                if (next6.isSelected()) {
                    abstractModeContext.stage.renderSprite(1, next6);
                }
            }
            Iterator<AbstractSprite> it7 = linkedListM811a2.iterator();
            while (it7.hasNext()) {
                AbstractSprite next7 = it7.next();
                if (next7.isSelected()) {
                    abstractModeContext.stage.renderSprite(1, next7);
                }
            }
        }
        abstractModeContext.invalidate();
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas, int layer) {
        if (context.stage.layerIsVisible(layer)) {
            PointF panning = context.getPanning();
            float zoom = context.getZoom();
            if (layer == 0) {
                canvas.drawBitmap(context.stage.m825b(0), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                return;
            }
            if (layer == 3) {
                canvas.drawBitmap(context.stage.m825b(3), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                return;
            }
            if (layer == 1) {
                canvas.drawBitmap(context.stage.m825b(1), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
                m1080b(context);
                if (this.f1197a != null) {
                    RectF bounds = this.f1197a.getBounds();
                    m1090a(context, canvas, bounds, panning, zoom);
                    if (this.f1197a instanceof C0989ab) {
                        m1089a(context, canvas, (Paint) null, bounds, panning);
                        m1068a(context, canvas, bounds.top, bounds.centerX(), bounds.bottom, panning);
                        return;
                    }
                    return;
                }
                return;
            }
            if (layer == 2) {
                canvas.drawBitmap(context.stage.m825b(2), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
            } else if (layer == 4) {
                canvas.drawBitmap(context.stage.m825b(4), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1208c);
            }
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public int getLayerID(AbstractModeContext context) {
        return 2;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isAnimating() {
        return this.f1174D;
    }

    @Override // com.samsung.sdraw.ModeState
    public void setAnimating(boolean animating) {
        this.f1174D = animating;
    }

    @Override // com.samsung.sdraw.ModeState
    public void clearOffscreenBuffer(AbstractModeContext context) {
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isFixedBuffer(AbstractModeContext context) {
        return false;
    }

    /* renamed from: a */
    public void m1092a(OnImageSelectedListener onImageSelectedListener) {
        this.f1175E = onImageSelectedListener;
    }

    /* renamed from: a */
    private void m1072a(AbstractModeContext abstractModeContext, HitDirection hitDirection) {
        C0989ab c0989ab = (C0989ab) this.f1197a;
        if (hitDirection == HitDirection.DELETE) {
            abstractModeContext.stage.deleteSprite(this.f1197a, true);
            onFinishJob(abstractModeContext);
            m1088a(abstractModeContext);
        } else {
            if (hitDirection == HitDirection.ROTATE_LEFT) {
                int i = c0989ab.f1423j;
                c0989ab.m1260b(-90);
                abstractModeContext.stage.rotateSprite(this.f1197a, c0989ab.f1423j, i, true);
                m1088a(abstractModeContext);
                return;
            }
            int i2 = c0989ab.f1423j;
            c0989ab.m1260b(90);
            abstractModeContext.stage.rotateSprite(this.f1197a, c0989ab.f1423j, i2, true);
            m1088a(abstractModeContext);
        }
    }

    /* renamed from: a */
    private void m1068a(AbstractModeContext abstractModeContext, Canvas canvas, float f, float f2, float f3, PointF pointF) {
        float f4;
        boolean z = true;
        canvas.save();
        float[] fArr = new float[9];
        canvas.getMatrix().getValues(fArr);
        float f5 = fArr[0];
        canvas.scale(1.0f / f5, 1.0f / f5);
        float f6 = f2 * f5;
        float f7 = f3 * f5;
        int height = abstractModeContext.view.getHeight();
        int width = abstractModeContext.view.getWidth();
        PointF pointFMapToScene = abstractModeContext.stage.mapToScene(new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1176F));
        PointF pointFMapToScene2 = abstractModeContext.stage.mapToScene(new PointF(width, height));
        float f8 = ((f * f5) - this.f1177G) + this.f1178H;
        if (f8 < pointFMapToScene.y * f5) {
            f8 = this.f1178H + (this.f1177G / 2.0f) + f7;
            z = false;
        }
        if (f8 > pointFMapToScene2.y * f5) {
            if (this.f1197a.getBounds().bottom > pointFMapToScene2.y) {
                f4 = ((pointFMapToScene2.y * f5) - this.f1177G) + this.f1178H;
            } else {
                f4 = ((this.f1197a.getBounds().bottom * f5) - this.f1177G) + this.f1178H;
            }
            f8 = f4;
            z = true;
        }
        int i = (((int) f6) - (this.f1183M / 2)) - (this.f1183M / 4);
        int i2 = this.f1183M + i + (this.f1183M / 2);
        if (i < pointFMapToScene.x * f5) {
            i = (int) (pointFMapToScene.x * f5);
        } else if (i2 > pointFMapToScene2.x * f5) {
            i = (((int) (pointFMapToScene2.x * f5)) - this.f1183M) - (this.f1183M / 2);
        }
        m1084c(abstractModeContext);
        int i3 = i + this.f1179I;
        int i4 = ((int) f8) - this.f1176F;
        int i5 = ((this.f1179I / 2) + i3) - (this.f1184N / 2);
        int i6 = ((this.f1180J / 2) + i4) - (this.f1184N / 2);
        int i7 = ((this.f1179I / 2) + i3) - (this.f1181K / 2);
        this.f1185O.set(i, i4, this.f1179I + i, this.f1180J + i4);
        this.f1186P.set(i3, i4, this.f1179I + i3, this.f1180J + i4);
        this.f1187Q.set(this.f1179I + i3, i4, (this.f1179I * 2) + i3, this.f1180J + i4);
        this.f1185O = m1065a(this.f1185O, f5);
        this.f1186P = m1065a(this.f1186P, f5);
        this.f1187Q = m1065a(this.f1187Q, f5);
        if (this.f1189S) {
            canvas.drawBitmap(this.f1202ae, i, i4, (Paint) null);
            canvas.drawBitmap(this.f1195Y, i5 - this.f1179I, i6, (Paint) null);
        } else {
            canvas.drawBitmap(this.f1199ab, i, i4, (Paint) null);
            canvas.drawBitmap(this.f1192V, i5 - this.f1179I, i6, (Paint) null);
        }
        if (this.f1190T) {
            canvas.drawBitmap(this.f1204ag, i3, i4, (Paint) null);
            canvas.drawBitmap(this.f1196Z, i5, i6, (Paint) null);
        } else {
            canvas.drawBitmap(this.f1201ad, i3, i4, (Paint) null);
            canvas.drawBitmap(this.f1193W, i5, i6, (Paint) null);
        }
        if (this.f1191U) {
            canvas.drawBitmap(this.f1203af, this.f1179I + i3, i4, (Paint) null);
            canvas.drawBitmap(this.f1198aa, i5 + this.f1179I, i6, (Paint) null);
        } else {
            canvas.drawBitmap(this.f1200ac, this.f1179I + i3, i4, (Paint) null);
            canvas.drawBitmap(this.f1194X, i5 + this.f1179I, i6, (Paint) null);
        }
        if (z) {
            canvas.drawBitmap(this.f1205ah, i7, this.f1180J + i4, (Paint) null);
        } else {
            canvas.drawBitmap(this.f1206ai, i7, i4 - this.f1182L, (Paint) null);
        }
        Paint paint = new Paint();
        paint.setColor(-16777216);
        canvas.drawLine(i3, i4, i3, this.f1180J + i4, paint);
        canvas.drawLine(this.f1179I + i3, i4, this.f1179I + i3, this.f1180J + i4, paint);
        canvas.restore();
    }

    /* renamed from: a */
    private Rect m1065a(Rect rect, float f) {
        return new Rect((int) (rect.left / f), (int) (rect.top / f), (int) (rect.right / f), (int) (rect.bottom / f));
    }

    /* renamed from: c */
    private void m1084c(AbstractModeContext abstractModeContext) {
        C0997aj c0997aj = new C0997aj(abstractModeContext.view.getContext(), ((CanvasView) abstractModeContext.view).f984e);
        if (this.f1192V == null) {
            this.f1192V = c0997aj.m1532d("/ploating_popup_icon_delete_n.png");
        }
        if (this.f1193W == null) {
            this.f1193W = c0997aj.m1532d("/ploating_popup_icon_r1_n.png");
        }
        if (this.f1194X == null) {
            this.f1194X = c0997aj.m1532d("/ploating_popup_icon_r2_n.png");
        }
        if (this.f1195Y == null) {
            this.f1195Y = c0997aj.m1532d("/ploating_popup_icon_delete_d.png");
        }
        if (this.f1196Z == null) {
            this.f1196Z = c0997aj.m1532d("/ploating_popup_icon_r1_d.png");
        }
        if (this.f1198aa == null) {
            this.f1198aa = c0997aj.m1532d("/ploating_popup_icon_r2_d.png");
        }
        if (this.f1201ad == null) {
            this.f1201ad = c0997aj.m1532d("/ploating_popup_center_n.png");
        }
        if (this.f1199ab == null) {
            this.f1199ab = c0997aj.m1532d("/ploating_popup_left_n.png");
        }
        if (this.f1200ac == null) {
            this.f1200ac = c0997aj.m1532d("/ploating_popup_right_n.png");
        }
        if (this.f1204ag == null) {
            this.f1204ag = c0997aj.m1532d("/ploating_popup_center_p.png");
        }
        if (this.f1202ae == null) {
            this.f1202ae = c0997aj.m1532d("/ploating_popup_left_p.png");
        }
        if (this.f1203af == null) {
            this.f1203af = c0997aj.m1532d("/ploating_popup_right_p.png");
        }
        if (this.f1205ah == null) {
            this.f1205ah = c0997aj.m1532d("/ploating_popup_picker_down.png");
        }
        if (this.f1206ai == null) {
            this.f1206ai = c0997aj.m1532d("/ploating_popup_picker_up.png");
        }
    }

    /* renamed from: a */
    private void m1074a(PointF[] pointFArr, PointF pointF, Rect rect) {
        C0989ab c0989ab = (C0989ab) this.f1197a;
        float fM1267f = c0989ab.m1267f() / c0989ab.m1266e();
        switch (m1082b()[this.f1207b.ordinal()]) {
            case 2:
                if (m1077a(pointF, c0989ab.m1263c(1), c0989ab.m1263c(3))) {
                    PointF pointFM1079b = m1079b(c0989ab.m1263c(0), c0989ab.m1263c(1), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(1), pointFM1079b) < this.f1217l) {
                        pointFM1079b.x = c0989ab.m1263c(1).x - ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b.y = c0989ab.m1263c(1).y - ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j))));
                    }
                    PointF pointFM1079b2 = m1079b(c0989ab.m1263c(2), c0989ab.m1263c(3), pointFM1079b);
                    if (m1075a(null, 1, rect, pointFM1079b, null, pointFM1079b2, null)) {
                        c0989ab.m1256a(0, pointFM1079b);
                        c0989ab.m1256a(2, pointFM1079b2);
                        break;
                    }
                }
                break;
            case 3:
                if (m1077a(pointF, c0989ab.m1263c(3), c0989ab.m1263c(2))) {
                    PointF pointFM1079b3 = m1079b(c0989ab.m1263c(0), c0989ab.m1263c(2), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(2), pointFM1079b3) < this.f1217l) {
                        pointFM1079b3.x = c0989ab.m1263c(2).x + ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b3.y = c0989ab.m1263c(2).y + ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                    }
                    PointF pointFM1079b4 = m1079b(c0989ab.m1263c(1), c0989ab.m1263c(3), pointFM1079b3);
                    if (m1075a(null, 1, rect, pointFM1079b3, pointFM1079b4, null, null)) {
                        c0989ab.m1256a(0, pointFM1079b3);
                        c0989ab.m1256a(1, pointFM1079b4);
                        break;
                    }
                }
                break;
            case 4:
                if (m1077a(pointF, c0989ab.m1263c(2), c0989ab.m1263c(0))) {
                    PointF pointFM1079b5 = m1079b(c0989ab.m1263c(0), c0989ab.m1263c(1), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(0), pointFM1079b5) < this.f1217l) {
                        pointFM1079b5.x = c0989ab.m1263c(0).x + ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b5.y = c0989ab.m1263c(0).y + ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j))));
                    }
                    PointF pointFM1079b6 = m1079b(c0989ab.m1263c(2), c0989ab.m1263c(3), pointFM1079b5);
                    if (m1075a(null, 1, rect, null, pointFM1079b5, null, pointFM1079b6)) {
                        c0989ab.m1256a(1, pointFM1079b5);
                        c0989ab.m1256a(3, pointFM1079b6);
                        break;
                    }
                }
                break;
            case 5:
                if (m1077a(pointF, c0989ab.m1263c(0), c0989ab.m1263c(1))) {
                    PointF pointFM1079b7 = m1079b(c0989ab.m1263c(0), c0989ab.m1263c(2), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(0), pointFM1079b7) < this.f1217l) {
                        pointFM1079b7.x = c0989ab.m1263c(0).x - ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b7.y = c0989ab.m1263c(0).y - ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                    }
                    PointF pointFM1079b8 = m1079b(c0989ab.m1263c(1), c0989ab.m1263c(3), pointFM1079b7);
                    if (m1075a(null, 1, rect, null, null, pointFM1079b7, pointFM1079b8)) {
                        c0989ab.m1256a(2, pointFM1079b7);
                        c0989ab.m1256a(3, pointFM1079b8);
                        break;
                    }
                }
                break;
            case 6:
                if (m1077a(pointF, c0989ab.m1263c(1), c0989ab.m1263c(3))) {
                    PointF pointFM1079b9 = m1079b(c0989ab.m1263c(2), c0989ab.m1263c(3), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(3), pointFM1079b9) < this.f1217l) {
                        pointFM1079b9.x = c0989ab.m1263c(3).x - ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b9.y = c0989ab.m1263c(3).y - ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j))));
                    }
                    float fCalculateDistance = PointF.calculateDistance(c0989ab.m1263c(3), c0989ab.m1263c(2));
                    float fCalculateDistance2 = PointF.calculateDistance(c0989ab.m1263c(3), pointFM1079b9);
                    PointF pointFM1066a = m1066a(fCalculateDistance, fCalculateDistance2, c0989ab.m1263c(3), c0989ab.m1263c(1));
                    PointF pointFM1079b10 = m1079b(pointFM1066a, m1066a(fCalculateDistance, fCalculateDistance2, c0989ab.m1263c(2), c0989ab.m1263c(0)), pointFM1079b9);
                    if (PointF.calculateDistance(c0989ab.m1263c(3), pointFM1066a) < this.f1218m) {
                        pointFM1066a.x = c0989ab.m1263c(3).x + ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1066a.y = c0989ab.m1263c(3).y + ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b9.x = c0989ab.m1263c(3).x - ((float) ((this.f1217l / fM1267f) * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b9.y = c0989ab.m1263c(3).y - ((float) ((this.f1217l / fM1267f) * Math.sin(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b10.x = pointFM1079b9.x + ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b10.y = pointFM1079b9.y + ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                    }
                    if (m1075a(null, 1, rect, pointFM1079b10, pointFM1066a, pointFM1079b9, null)) {
                        c0989ab.m1256a(0, pointFM1079b10);
                        c0989ab.m1256a(1, pointFM1066a);
                        c0989ab.m1256a(2, pointFM1079b9);
                        break;
                    }
                }
                break;
            case 7:
                if (m1077a(pointF, c0989ab.m1263c(2), c0989ab.m1263c(0)) && pointF.x > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && pointF.y > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    PointF pointFM1079b11 = m1079b(c0989ab.m1263c(2), c0989ab.m1263c(3), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(2), pointFM1079b11) < this.f1217l) {
                        pointFM1079b11.x = c0989ab.m1263c(2).x + ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b11.y = c0989ab.m1263c(2).y + ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j))));
                    }
                    float fCalculateDistance3 = PointF.calculateDistance(c0989ab.m1263c(2), c0989ab.m1263c(3));
                    float fCalculateDistance4 = PointF.calculateDistance(c0989ab.m1263c(2), pointFM1079b11);
                    PointF pointFM1066a2 = m1066a(fCalculateDistance3, fCalculateDistance4, c0989ab.m1263c(2), c0989ab.m1263c(0));
                    PointF pointFM1079b12 = m1079b(pointFM1066a2, m1066a(fCalculateDistance3, fCalculateDistance4, c0989ab.m1263c(3), c0989ab.m1263c(1)), pointFM1079b11);
                    if (PointF.calculateDistance(c0989ab.m1263c(2), pointFM1066a2) < this.f1218m) {
                        pointFM1066a2.x = c0989ab.m1263c(2).x + ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1066a2.y = c0989ab.m1263c(2).y + ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b11.x = c0989ab.m1263c(2).x + ((float) ((this.f1217l / fM1267f) * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b11.y = ((float) ((this.f1217l / fM1267f) * Math.sin(Math.toRadians(c0989ab.f1423j)))) + c0989ab.m1263c(2).y;
                        pointFM1079b12.x = pointFM1079b11.x + ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b12.y = pointFM1079b11.y + ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                    }
                    if (m1075a(null, 1, rect, pointFM1066a2, pointFM1079b12, null, pointFM1079b11)) {
                        c0989ab.m1256a(0, pointFM1066a2);
                        c0989ab.m1256a(1, pointFM1079b12);
                        c0989ab.m1256a(3, pointFM1079b11);
                        break;
                    }
                }
                break;
            case 8:
                if (m1077a(pointF, c0989ab.m1263c(1), c0989ab.m1263c(3))) {
                    PointF pointFM1079b13 = m1079b(c0989ab.m1263c(0), c0989ab.m1263c(1), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(1), pointFM1079b13) < this.f1217l) {
                        pointFM1079b13.x = c0989ab.m1263c(1).x - ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b13.y = c0989ab.m1263c(1).y - ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j))));
                    }
                    float fCalculateDistance5 = PointF.calculateDistance(c0989ab.m1263c(1), c0989ab.m1263c(0));
                    float fCalculateDistance6 = PointF.calculateDistance(c0989ab.m1263c(1), pointFM1079b13);
                    PointF pointFM1066a3 = m1066a(fCalculateDistance5, fCalculateDistance6, c0989ab.m1263c(1), c0989ab.m1263c(3));
                    PointF pointFM1079b14 = m1079b(pointFM1066a3, m1066a(fCalculateDistance5, fCalculateDistance6, c0989ab.m1263c(0), c0989ab.m1263c(2)), pointFM1079b13);
                    if (PointF.calculateDistance(c0989ab.m1263c(1), pointFM1066a3) < this.f1218m) {
                        pointFM1066a3.x = c0989ab.m1263c(1).x - ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1066a3.y = c0989ab.m1263c(1).y - ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b13.x = c0989ab.m1263c(1).x - ((float) ((this.f1217l / fM1267f) * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b13.y = c0989ab.m1263c(1).y - ((float) ((this.f1217l / fM1267f) * Math.sin(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b14.x = pointFM1079b13.x - ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b14.y = pointFM1079b13.y - ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                    }
                    if (m1075a(null, 1, rect, pointFM1079b13, null, pointFM1079b14, pointFM1066a3)) {
                        c0989ab.m1256a(0, pointFM1079b13);
                        c0989ab.m1256a(2, pointFM1079b14);
                        c0989ab.m1256a(3, pointFM1066a3);
                        break;
                    }
                }
                break;
            case 9:
                if (m1077a(pointF, c0989ab.m1263c(2), c0989ab.m1263c(0))) {
                    PointF pointFM1079b15 = m1079b(c0989ab.m1263c(0), c0989ab.m1263c(1), pointF);
                    if (PointF.calculateDistance(c0989ab.m1263c(0), pointFM1079b15) < this.f1217l) {
                        pointFM1079b15.x = c0989ab.m1263c(0).x + ((float) (this.f1217l * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b15.y = c0989ab.m1263c(0).y + ((float) (this.f1217l * Math.sin(Math.toRadians(c0989ab.f1423j))));
                    }
                    float fCalculateDistance7 = PointF.calculateDistance(c0989ab.m1263c(0), c0989ab.m1263c(1));
                    float fCalculateDistance8 = PointF.calculateDistance(c0989ab.m1263c(0), pointFM1079b15);
                    PointF pointFM1066a4 = m1066a(fCalculateDistance7, fCalculateDistance8, c0989ab.m1263c(0), c0989ab.m1263c(2));
                    PointF pointFM1079b16 = m1079b(pointFM1066a4, m1066a(fCalculateDistance7, fCalculateDistance8, c0989ab.m1263c(1), c0989ab.m1263c(3)), pointFM1079b15);
                    if (PointF.calculateDistance(c0989ab.m1263c(0), pointFM1066a4) < this.f1218m) {
                        pointFM1066a4.x = c0989ab.m1263c(0).x - ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1066a4.y = c0989ab.m1263c(0).y - ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b15.x = c0989ab.m1263c(0).x + ((float) ((this.f1217l / fM1267f) * Math.cos(Math.toRadians(c0989ab.f1423j))));
                        pointFM1079b15.y = ((float) ((this.f1217l / fM1267f) * Math.sin(Math.toRadians(c0989ab.f1423j)))) + c0989ab.m1263c(0).y;
                        pointFM1079b16.x = pointFM1079b15.x - ((float) (this.f1218m * Math.cos(Math.toRadians(c0989ab.f1423j - 90))));
                        pointFM1079b16.y = pointFM1079b15.y - ((float) (this.f1218m * Math.sin(Math.toRadians(c0989ab.f1423j - 90))));
                    }
                    if (m1075a(null, 1, rect, null, pointFM1079b15, pointFM1066a4, pointFM1079b16)) {
                        c0989ab.m1256a(1, pointFM1079b15);
                        c0989ab.m1256a(2, pointFM1066a4);
                        c0989ab.m1256a(3, pointFM1079b16);
                        break;
                    }
                }
                break;
        }
    }

    /* renamed from: a */
    private boolean m1077a(PointF pointF, PointF pointF2, PointF pointF3) {
        return ((pointF3.x - pointF2.x) * (pointF.y - pointF2.y)) - ((pointF3.y - pointF2.y) * (pointF.x - pointF2.x)) > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    /* renamed from: a */
    private PointF m1066a(float f, float f2, PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        float fAbs = Math.abs(f - f2);
        if (f2 > f) {
            pointF3.x = ((pointF2.x * f2) - (pointF.x * fAbs)) / (f2 - fAbs);
            pointF3.y = ((pointF2.y * f2) - (pointF.y * fAbs)) / (f2 - fAbs);
        } else {
            pointF3.x = ((pointF2.x * f2) + (pointF.x * fAbs)) / (f2 + fAbs);
            pointF3.y = ((pointF2.y * f2) + (pointF.y * fAbs)) / (fAbs + f2);
        }
        return pointF3;
    }

    /* renamed from: b */
    private PointF m1079b(PointF pointF, PointF pointF2, PointF pointF3) {
        PointF pointF4 = new PointF();
        if (Math.round(pointF.x) == Math.round(pointF2.x)) {
            pointF4.x = pointF.x;
            pointF4.y = pointF3.y;
        } else if (Math.round(pointF.y) == Math.round(pointF2.y)) {
            pointF4.x = pointF3.x;
            pointF4.y = pointF.y;
        } else {
            float f = (pointF2.y - pointF.y) / (pointF2.x - pointF.x);
            float f2 = ((pointF2.x * pointF.y) - (pointF.x * pointF2.y)) / (pointF2.x - pointF.x);
            float f3 = (-1.0f) / f;
            float f4 = ((((pointF2.x * f) - pointF2.y) - (pointF3.x * f3)) + pointF3.y) / (f - f3);
            pointF4.x = f4;
            pointF4.y = (f * f4) + f2;
        }
        return pointF4;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event, int userID, int stringID) {
        return onTouchEvent(context, event);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context, int userID) {
        onFinishJob(context);
    }

    /* renamed from: a */
    void m1093a(String str) {
        this.f1231z = str;
    }

    /* renamed from: b */
    void m1094b(String str) {
        this.f1171A = str;
    }

    /* renamed from: c */
    void m1095c(String str) {
        this.f1172B = str;
    }

    /* renamed from: a */
    void m1087a() {
        this.f1231z = "";
        this.f1171A = "";
        this.f1172B = "";
    }
}
