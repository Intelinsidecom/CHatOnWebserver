package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes.dex */
class ModeContext extends AbstractModeContext {
    public static final int MODE_ERASER = 2;
    public static final int MODE_FILLING = 5;
    public static final int MODE_PEN = 1;
    public static final int MODE_SELECT = 3;
    public static final int MODE_TEXT = 4;

    /* renamed from: g */
    private HashMap<Integer, ModeState> f1087g = new HashMap<>();

    /* renamed from: h */
    private HashMap<Integer, ModeState> f1088h = new HashMap<>();

    /* renamed from: i */
    private HashMap<Integer, ModeState> f1089i = new HashMap<>();

    /* renamed from: j */
    private HashMap<Integer, ModeState> f1090j = new HashMap<>();

    /* renamed from: k */
    private HashMap<Integer, ModeState> f1091k = new HashMap<>();

    public ModeContext() {
    }

    public ModeContext(View nview) {
        this.view = nview;
        this.factory = new C1054j(this.view.getContext());
        if (this.view.getContext() != null) {
            this.setting = new Setting(this.view.getContext());
        } else {
            this.setting = new Setting(null);
        }
        this.f660b = (InterfaceC1035bu) this.view;
        this.view = nview;
        createNewMode(this.setting.getUserID());
        this.stage = new Stage(this);
    }

    public void initialize() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCurrentView(View view) {
        this.view = view;
        this.f660b = (InterfaceC1035bu) view;
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    public View getParent() {
        return this.view;
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    public void changeCanvasSize(Rect rect) {
        if (this.stage != null) {
            this.setting.setCanvasRect(rect);
            if (this.setting.m1121l()) {
                this.stage.m824a(new int[]{0, 2, 3, 4}, new int[]{this.setting.getCanvasWidth(), 1, this.setting.getCanvasWidth(), 1}, new int[]{this.setting.getCanvasHeight(), 1, this.setting.getCanvasHeight(), 1});
            } else {
                this.stage.m824a(new int[]{0, 3, 2, 4}, new int[]{this.setting.getCanvasWidth(), this.setting.getCanvasWidth(), this.setting.getCanvasWidth(), this.setting.getCanvasWidth()}, new int[]{this.setting.getCanvasHeight(), this.setting.getCanvasHeight(), this.setting.getCanvasHeight(), this.setting.getCanvasHeight()});
            }
            if (this.stage.f845i != null && (this.stage.f845i.getWidth() != this.setting.getCanvasWidth() || this.stage.f845i.getHeight() != this.setting.getCanvasHeight())) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.setting.getCanvasWidth(), this.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(bitmapCreateBitmap).drawBitmap(this.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                this.stage.f845i.recycle();
                this.stage.f845i = bitmapCreateBitmap;
            } else if (this.stage.f845i == null) {
                this.stage.f845i = Bitmap.createBitmap(this.setting.getCanvasWidth(), this.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
            }
            if (this.stage.fixedSprites2 != null && (this.stage.fixedSprites2.getWidth() != this.setting.getCanvasWidth() || this.stage.fixedSprites2.getHeight() != this.setting.getCanvasHeight())) {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.setting.getCanvasWidth(), this.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
                new Canvas(bitmapCreateBitmap2).drawBitmap(this.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                this.stage.fixedSprites2.recycle();
                this.stage.fixedSprites2 = bitmapCreateBitmap2;
            } else if (this.stage.fixedSprites2 == null) {
                this.stage.fixedSprites2 = Bitmap.createBitmap(this.setting.getCanvasWidth(), this.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
            }
            LinkedList<AbstractSprite> linkedListM812a = this.stage.m812a(StrokeSprite.class, C1063s.class);
            LinkedList<AbstractSprite> linkedListM827b = this.stage.m827b(StrokeSprite.class, C1063s.class);
            if (this.setting.m1121l()) {
                Canvas canvasM830c = this.stage.m830c(0);
                if (this.stage.f845i != null && this.stage.layerIsVisible(0)) {
                    canvasM830c.drawBitmap(this.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM812a != null) {
                    this.stage.m817a(0, linkedListM812a);
                }
                Canvas canvasM830c2 = this.stage.m830c(3);
                if (this.stage.fixedSprites2 != null && this.stage.layerIsVisible(3)) {
                    canvasM830c2.drawBitmap(this.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM827b != null) {
                    this.stage.m817a(3, linkedListM827b);
                    return;
                }
                return;
            }
            LinkedList<AbstractSprite> linkedListM811a = this.stage.m811a(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM826b = this.stage.m826b(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.stage.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.stage.m826b(TextSprite.class);
            Canvas canvasM830c3 = this.stage.m830c(0);
            if (this.stage.f845i != null && this.stage.layerIsVisible(0)) {
                canvasM830c3.drawBitmap(this.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
            if (linkedListM811a != null) {
                this.stage.m817a(2, linkedListM811a);
            }
            if (linkedListM811a2 != null) {
                this.stage.m817a(2, linkedListM811a2);
            }
            if (linkedListM812a != null) {
                this.stage.m817a(0, linkedListM812a);
            }
            Canvas canvasM830c4 = this.stage.m830c(3);
            if (this.stage.fixedSprites2 != null && this.stage.layerIsVisible(3)) {
                canvasM830c4.drawBitmap(this.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
            if (linkedListM826b != null) {
                this.stage.m817a(4, linkedListM826b);
            }
            if (linkedListM826b2 != null) {
                this.stage.m817a(4, linkedListM826b2);
            }
            if (linkedListM827b != null) {
                this.stage.m817a(3, linkedListM827b);
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    public void changeScreenSize(Rect rect) {
        if (this.stage != null) {
            this.setting.setScreenRect(rect);
            this.stage.m824a(new int[]{1}, new int[]{this.setting.getScreenWidth()}, new int[]{this.setting.getScreenHeight()});
        }
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    /* renamed from: a */
    protected void mo673a(float f, float f2) {
        if (this.stage != null) {
            PointF pointF = new PointF(f, f2);
            int size = this.stage.m837g().size();
            for (int i = 0; i < size; i++) {
                this.stage.setPanning(i, pointF);
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    /* renamed from: a */
    protected void mo672a(float f) {
        if (this.stage != null) {
            int size = this.stage.m837g().size();
            for (int i = 0; i < size; i++) {
                this.stage.m815a(i, f);
            }
        }
    }

    public void changeModeTo(int changingMode) {
        changeModeTo(this.setting.getUserID(), changingMode);
    }

    public void changeModeTo(int userID, int changingMode) {
        if (!this.modes.containsKey(Integer.valueOf(userID)) || this.modes.get(Integer.valueOf(userID)) == null) {
            this.modes.put(Integer.valueOf(userID), this.f1087g.get(Integer.valueOf(userID)));
        }
        if (userID != this.setting.getUserID()) {
            changeModeToSimple(userID, changingMode);
        }
        switch (changingMode) {
            case 1:
                this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
                onActivate(false, userID);
                this.modes.put(Integer.valueOf(userID), this.f1087g.get(Integer.valueOf(userID)));
                if (this.f659a.get(Integer.valueOf(userID)) == this.f1089i.get(Integer.valueOf(userID))) {
                    onActivate(true, userID);
                    break;
                }
                break;
            case 2:
                this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
                onActivate(false, userID);
                this.modes.put(Integer.valueOf(userID), this.f1088h.get(Integer.valueOf(userID)));
                if (this.f659a.get(Integer.valueOf(userID)) == this.f1089i.get(Integer.valueOf(userID))) {
                    onActivate(true, userID);
                    break;
                }
                break;
            case 3:
                this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
                onActivate(false, userID);
                this.modes.put(Integer.valueOf(userID), this.f1089i.get(Integer.valueOf(userID)));
                onActivate(true, userID);
                break;
            case 4:
                this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
                onActivate(false, userID);
                this.modes.put(Integer.valueOf(userID), this.f1090j.get(Integer.valueOf(userID)));
                if (this.f659a.get(Integer.valueOf(userID)) == this.f1089i.get(Integer.valueOf(userID))) {
                    onActivate(true, userID);
                    break;
                }
                break;
            case 5:
                this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
                onActivate(false, userID);
                this.modes.put(Integer.valueOf(userID), this.f1091k.get(Integer.valueOf(userID)));
                if (this.f659a.get(Integer.valueOf(userID)) == this.f1089i.get(Integer.valueOf(userID))) {
                    onActivate(true, userID);
                    break;
                }
                break;
        }
    }

    public void changeModeToSimple(int userID, int changingMode) {
        if (!this.modes.containsKey(Integer.valueOf(userID)) || this.modes.get(Integer.valueOf(userID)) == null) {
            this.modes.put(Integer.valueOf(userID), this.f1087g.get(Integer.valueOf(userID)));
        }
        switch (changingMode) {
            case 1:
                this.modes.put(Integer.valueOf(userID), this.f1087g.get(Integer.valueOf(userID)));
                break;
            case 2:
                this.modes.put(Integer.valueOf(userID), this.f1088h.get(Integer.valueOf(userID)));
                break;
            case 3:
                this.modes.put(Integer.valueOf(userID), this.f1089i.get(Integer.valueOf(userID)));
                break;
            case 4:
                this.modes.put(Integer.valueOf(userID), this.f1090j.get(Integer.valueOf(userID)));
                break;
            case 5:
                this.modes.put(Integer.valueOf(userID), this.f1091k.get(Integer.valueOf(userID)));
                break;
        }
    }

    public int getMode() {
        return getMode(this.setting.getUserID());
    }

    public int getMode(int userID) {
        if (!this.modes.containsKey(Integer.valueOf(userID)) || this.modes.get(Integer.valueOf(userID)) == null) {
            return -1;
        }
        if (this.modes.get(Integer.valueOf(userID)).equals(this.f1087g.get(Integer.valueOf(userID)))) {
            return 1;
        }
        if (this.modes.get(Integer.valueOf(userID)).equals(this.f1088h.get(Integer.valueOf(userID)))) {
            return 2;
        }
        if (this.modes.get(Integer.valueOf(userID)).equals(this.f1089i.get(Integer.valueOf(userID)))) {
            return 3;
        }
        if (this.modes.get(Integer.valueOf(userID)).equals(this.f1090j.get(Integer.valueOf(userID)))) {
            return 4;
        }
        return this.modes.get(Integer.valueOf(userID)).equals(this.f1091k.get(Integer.valueOf(userID))) ? 5 : -1;
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    public PointF getPanning() {
        return this.stage == null ? new PointF() : this.stage.getPanning(0);
    }

    @Override // com.samsung.sdraw.AbstractModeContext
    public float getZoom() {
        if (this.stage == null) {
            return 1.0f;
        }
        return this.stage.m832d(0);
    }

    public void removeCurrentStrokeSpriteForce() {
        removeCurrentStrokeSpriteForce(this.setting.getUserID());
    }

    public void removeCurrentStrokeSpriteForce(int userID) {
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            if (this.modes.get(Integer.valueOf(userID)).equals(this.f1087g.get(Integer.valueOf(userID))) || this.modes.get(Integer.valueOf(userID)).equals(this.f1088h.get(Integer.valueOf(userID)))) {
                ((PenMode) this.modes.get(Integer.valueOf(userID))).removeStrokeSprite(this);
            }
            if (this.setting != null && this.setting.mOnDrawCancelListener != null) {
                this.setting.mOnDrawCancelListener.onCancel(userID);
            }
        }
    }

    public boolean isFixedBuffer() {
        return false;
    }

    public TextMode getTextMode(int uID) {
        if (!this.f1090j.containsKey(Integer.valueOf(uID))) {
            createNewMode(uID);
        }
        return (TextMode) this.f1090j.get(Integer.valueOf(uID));
    }

    public SelectMode getSelectMode(int uID) {
        if (!this.f1089i.containsKey(Integer.valueOf(uID))) {
            createNewMode(uID);
        }
        return (SelectMode) this.f1089i.get(Integer.valueOf(uID));
    }

    public C1064t getFillingMode(int uID) {
        if (!this.f1089i.containsKey(Integer.valueOf(uID))) {
            createNewMode(uID);
        }
        return (C1064t) this.f1091k.get(Integer.valueOf(uID));
    }

    public void createNewMode(int uID) {
        if (!this.f1087g.containsKey(Integer.valueOf(uID))) {
            this.f1087g.put(Integer.valueOf(uID), new PenMode());
            this.f1088h.put(Integer.valueOf(uID), new C1059o());
            this.f1089i.put(Integer.valueOf(uID), new SelectMode());
            this.f1090j.put(Integer.valueOf(uID), new TextMode());
            this.f1091k.put(Integer.valueOf(uID), new C1064t());
            this.modes.put(Integer.valueOf(uID), this.f1087g.get(Integer.valueOf(uID)));
        }
    }
}
