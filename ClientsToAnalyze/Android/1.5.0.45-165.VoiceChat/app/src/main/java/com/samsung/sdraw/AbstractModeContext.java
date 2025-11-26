package com.samsung.sdraw;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AndroidRuntimeException;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.sdraw.CanvasView;
import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
abstract class AbstractModeContext {

    /* renamed from: e */
    static final Matrix f658e = new Matrix();

    /* renamed from: b */
    protected InterfaceC1035bu f660b;
    public InterfaceC1020bf factory;

    /* renamed from: j */
    private LinkedList<AbstractSprite> f667j;

    /* renamed from: k */
    private LinkedList<AbstractSprite> f668k;
    public Setting setting;
    public AbstractStage stage;
    public View view;
    public CanvasView.OnHistoryChangeListener historyChangeListener = null;

    /* renamed from: a */
    protected HashMap<Integer, ModeState> f659a = new HashMap<>();

    /* renamed from: g */
    private boolean f664g = true;

    /* renamed from: h */
    private MemoDataUtils f665h = null;

    /* renamed from: i */
    private MemoDataUtils f666i = null;
    public HashMap<Integer, ModeState> modes = new HashMap<>();

    /* renamed from: c */
    Matrix f661c = new Matrix();

    /* renamed from: d */
    Matrix f662d = new Matrix();
    public int currentHandle = 0;

    /* renamed from: f */
    Rect f663f = new Rect();

    /* renamed from: l */
    private boolean f669l = true;

    /* renamed from: a */
    protected abstract void mo672a(float f);

    /* renamed from: a */
    protected abstract void mo673a(float f, float f2);

    public abstract void changeCanvasSize(Rect rect);

    public abstract void changeScreenSize(Rect rect);

    public abstract PointF getPanning();

    public abstract float getZoom();

    AbstractModeContext() {
    }

    public void clearOffscreenBuffer() {
        int userID = this.setting.getUserID();
        if (this.f659a.containsKey(Integer.valueOf(userID)) && this.f659a.get(Integer.valueOf(userID)) != null) {
            this.f659a.get(Integer.valueOf(userID)).clearOffscreenBuffer(this);
        }
    }

    public boolean initializeContext(Activity activity) {
        if (this.currentHandle == activity.hashCode() || this.currentHandle == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0243  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void serializeContext(boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 841
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.AbstractModeContext.serializeContext(boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0385 A[PHI: r0 r3
  0x0385: PHI (r0v5 byte[]) = (r0v4 byte[]), (r0v75 byte[]), (r0v76 byte[]), (r0v79 byte[]), (r0v79 byte[]) binds: [B:194:0x030e, B:218:0x0368, B:211:0x0357, B:198:0x0326, B:230:0x0382] A[DONT_GENERATE, DONT_INLINE]
  0x0385: PHI (r3v0 java.io.FileInputStream) = 
  (r3v155 java.io.FileInputStream)
  (r3v91 java.io.FileInputStream)
  (r3v94 java.io.FileInputStream)
  (r3v95 java.io.FileInputStream)
 binds: [B:218:0x0368, B:211:0x0357, B:198:0x0326, B:230:0x0382] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03fd A[PHI: r0 r3
  0x03fd: PHI (r0v69 byte[]) = (r0v10 byte[]), (r0v11 byte[]), (r0v72 byte[]), (r0v72 byte[]) binds: [B:256:0x03d8, B:237:0x0391, B:268:0x03f2, B:272:0x03fa] A[DONT_GENERATE, DONT_INLINE]
  0x03fd: PHI (r3v33 java.io.FileInputStream) = 
  (r3v137 java.io.FileInputStream)
  (r3v138 java.io.FileInputStream)
  (r3v139 java.io.FileInputStream)
  (r3v140 java.io.FileInputStream)
 binds: [B:256:0x03d8, B:237:0x0391, B:268:0x03f2, B:272:0x03fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x03e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0378 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:457:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b4 A[PHI: r0 r3
  0x00b4: PHI (r0v98 byte[]) = (r0v97 byte[]), (r0v168 byte[]), (r0v169 byte[]), (r0v172 byte[]), (r0v172 byte[]) binds: [B:16:0x003e, B:40:0x0097, B:33:0x0086, B:20:0x0056, B:52:0x00b1] A[DONT_GENERATE, DONT_INLINE]
  0x00b4: PHI (r3v51 java.io.FileInputStream) = 
  (r3v133 java.io.FileInputStream)
  (r3v100 java.io.FileInputStream)
  (r3v103 java.io.FileInputStream)
  (r3v104 java.io.FileInputStream)
 binds: [B:40:0x0097, B:33:0x0086, B:20:0x0056, B:52:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012d A[PHI: r0 r3
  0x012d: PHI (r0v162 byte[]) = (r0v103 byte[]), (r0v104 byte[]), (r0v165 byte[]), (r0v165 byte[]) binds: [B:79:0x0108, B:59:0x00c0, B:91:0x0122, B:95:0x012a] A[DONT_GENERATE, DONT_INLINE]
  0x012d: PHI (r3v83 java.io.FileInputStream) = 
  (r3v112 java.io.FileInputStream)
  (r3v113 java.io.FileInputStream)
  (r3v114 java.io.FileInputStream)
  (r3v115 java.io.FileInputStream)
 binds: [B:79:0x0108, B:59:0x00c0, B:91:0x0122, B:95:0x012a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v108, types: [com.samsung.sdraw.MemoDataUtils] */
    /* JADX WARN: Type inference failed for: r0v142, types: [com.samsung.sdraw.MemoDataUtils] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.samsung.sdraw.MemoDataUtils] */
    /* JADX WARN: Type inference failed for: r0v49, types: [com.samsung.sdraw.MemoDataUtils] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.io.File[]] */
    /* JADX WARN: Type inference failed for: r1v77, types: [java.io.File[]] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v11, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.util.LinkedList<com.samsung.sdraw.AbstractSprite>] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v66 */
    /* JADX WARN: Type inference failed for: r2v67 */
    /* JADX WARN: Type inference failed for: r2v70, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v72, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v74, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v76, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v78, types: [java.util.LinkedList<com.samsung.sdraw.AbstractSprite>] */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82, types: [int] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v130 */
    /* JADX WARN: Type inference failed for: r3v131 */
    /* JADX WARN: Type inference failed for: r3v132 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v141 */
    /* JADX WARN: Type inference failed for: r3v142 */
    /* JADX WARN: Type inference failed for: r3v143 */
    /* JADX WARN: Type inference failed for: r3v144 */
    /* JADX WARN: Type inference failed for: r3v145 */
    /* JADX WARN: Type inference failed for: r3v146 */
    /* JADX WARN: Type inference failed for: r3v147 */
    /* JADX WARN: Type inference failed for: r3v148 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r3v153 */
    /* JADX WARN: Type inference failed for: r3v154 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v62 */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r3v73 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v88 */
    /* JADX WARN: Type inference failed for: r3v89 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r3v97 */
    /* JADX WARN: Type inference failed for: r3v98 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.Vector] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.Vector] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean deserializeContext(boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.AbstractModeContext.deserializeContext(boolean):boolean");
    }

    public void changeModeTo(ModeState changingMode) {
        changeModeTo(this.setting.getUserID(), changingMode);
    }

    public void changeModeTo(int userID, ModeState changingMode) {
        if (this.modes.containsKey(Integer.valueOf(userID)) && !this.modes.get(Integer.valueOf(userID)).equals(changingMode)) {
            this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
            onActivate(false, userID);
            this.modes.put(Integer.valueOf(userID), changingMode);
            onActivate(true, userID);
        }
    }

    /* renamed from: a */
    void m674a(Matrix matrix) {
        if (this.stage != null && matrix != null) {
            float[] fArr = new float[10];
            matrix.getValues(fArr);
            C0993af.m1274a("Before Scale : " + fArr[0]);
            this.stage.m821a(matrix);
            this.f661c.set(matrix);
            this.f661c.invert(this.f662d);
            this.f661c.getValues(fArr);
            C0993af.m1274a("After Scale : " + fArr[0]);
        }
    }

    /* renamed from: a */
    protected void m671a() {
        float zoom = getZoom();
        PointF panning = getPanning();
        this.f661c = new Matrix();
        this.f661c.setScale(zoom, zoom);
        this.f661c.postTranslate(-panning.x, -panning.y);
        this.f661c.invert(this.f662d);
    }

    public void invalidate() {
        if (this.view != null) {
            try {
                if (this.f664g) {
                    this.view.invalidate();
                }
            } catch (AndroidRuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    public void invalidate(RectF refreshRect) {
        if (this.view != null) {
            synchronized (this.f663f) {
                try {
                } catch (AndroidRuntimeException e) {
                    e.printStackTrace();
                }
                if (this.f664g) {
                    refreshRect.roundOut(this.f663f);
                    Rect rect = this.f663f;
                    rect.left--;
                    this.f663f.right++;
                    Rect rect2 = this.f663f;
                    rect2.top--;
                    this.f663f.bottom++;
                    Rect canvasRect = this.setting.getCanvasRect();
                    this.f663f.offset(canvasRect.left, canvasRect.top);
                    this.view.invalidate(this.f663f);
                }
            }
        }
    }

    public boolean isRedoable() {
        if (this.stage == null) {
            return false;
        }
        return this.stage.isRedoable();
    }

    public boolean isUndoable() {
        if (this.stage == null) {
            return false;
        }
        return this.stage.isUndoable();
    }

    public boolean isRedoable(int userId) {
        if (this.stage == null) {
            return false;
        }
        return this.stage.isRedoable(userId);
    }

    public boolean isUndoable(int userId) {
        if (this.stage == null) {
            return false;
        }
        return this.stage.isUndoable(userId);
    }

    public void setView(View view) {
        this.view = view;
    }

    public void onActivate(boolean isActive) {
        if (this.modes.containsKey(Integer.valueOf(this.setting.getUserID())) && this.modes.get(Integer.valueOf(this.setting.getUserID())) != null) {
            this.modes.get(Integer.valueOf(this.setting.getUserID())).onActivate(this, isActive);
        }
    }

    public void onActivate(boolean isActive, int uID) {
        if (this.modes.containsKey(Integer.valueOf(uID)) && this.modes.get(Integer.valueOf(uID)) != null) {
            this.modes.get(Integer.valueOf(uID)).onActivate(this, isActive);
        }
    }

    public void onLayout(Rect rect) {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            Rect rect2 = new Rect(rect);
            rect2.offset(-rect2.left, -rect2.top);
            this.setting.setScreenRect(rect);
            this.setting.setCanvasRect(rect);
            this.modes.get(Integer.valueOf(userID)).onLayout(this, rect);
        }
    }

    public void onDraw(Canvas canvas) {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            if (!this.f661c.equals(f658e)) {
                canvas.save();
                canvas.concat(this.f661c);
                this.modes.get(Integer.valueOf(userID)).onDraw(this, canvas);
                canvas.restore();
                return;
            }
            this.modes.get(Integer.valueOf(userID)).onDraw(this, canvas);
        }
    }

    public void onDraw(Canvas canvas, int layer) {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            if (!this.f661c.equals(f658e)) {
                canvas.save();
                canvas.concat(this.f661c);
                this.modes.get(Integer.valueOf(userID)).onDraw(this, canvas, layer);
                canvas.restore();
                return;
            }
            this.modes.get(Integer.valueOf(userID)).onDraw(this, canvas, layer);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int userID = this.setting.getUserID();
        if (!this.modes.containsKey(Integer.valueOf(userID)) || this.modes.get(Integer.valueOf(userID)) == null) {
            return true;
        }
        return this.modes.get(Integer.valueOf(userID)).onTouchEvent(this, event);
    }

    public boolean onTouchEvent(MotionEvent event, int userID, int multiObjectID) {
        if (!this.modes.containsKey(Integer.valueOf(userID)) || this.modes.get(Integer.valueOf(userID)) == null) {
            return true;
        }
        return this.modes.get(Integer.valueOf(userID)).onTouchEvent(this, event, userID, multiObjectID);
    }

    public void onFinishJob() {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            this.modes.get(Integer.valueOf(userID)).onFinishJob(this);
        }
    }

    public void redo() {
        redo(this.setting.getUserID());
    }

    public void redo(int userID) {
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
            this.modes.get(Integer.valueOf(userID)).onFinishJob(this);
            this.stage.redo(userID);
            changeModeTo(userID, this.f659a.get(Integer.valueOf(userID)));
            invalidate();
            if (userID == this.setting.getUserID() && this.historyChangeListener != null) {
                this.historyChangeListener.onHistoryChanged(isUndoable(), isRedoable());
            }
        }
    }

    public void undo() {
        undo(this.setting.getUserID());
    }

    public void undo(int userID) {
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            this.f659a.put(Integer.valueOf(userID), this.modes.get(Integer.valueOf(userID)));
            this.modes.get(Integer.valueOf(userID)).onFinishJob(this);
            this.stage.undo(userID);
            changeModeTo(userID, this.f659a.get(Integer.valueOf(userID)));
            invalidate();
            if (userID == this.setting.getUserID() && this.historyChangeListener != null) {
                this.historyChangeListener.onHistoryChanged(isUndoable(), isRedoable());
            }
        }
    }

    public void dispose() {
        if (this.stage != null) {
            this.stage.dispose();
        }
        this.stage = null;
        this.modes.clear();
        this.factory = null;
        this.f660b = null;
    }

    public void drawBackgroundTheme() {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null && this.stage != null) {
            this.stage.drawBackgroundTheme();
            this.modes.get(Integer.valueOf(userID)).onActivate(this, false);
            this.modes.get(Integer.valueOf(userID)).onActivate(this, true);
            invalidate();
        }
    }

    public void clear() {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            this.stage.clearStage();
            this.modes.get(Integer.valueOf(userID)).onActivate(this, true);
            invalidate();
            if (this.historyChangeListener != null) {
                this.historyChangeListener.onHistoryChanged(false, false);
            }
        }
    }

    public void clearAll() {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            this.stage.clearAllStage();
            this.modes.get(Integer.valueOf(userID)).onActivate(this, true);
            invalidate();
            if (this.historyChangeListener != null) {
                this.historyChangeListener.onHistoryChanged(isUndoable(), isRedoable());
            }
        }
    }

    public void setPanning(float x, float y) {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            mo673a(x, y);
            m671a();
            this.modes.get(Integer.valueOf(userID)).onLayout(this, new Rect());
        }
    }

    public void setZoom(float zoom) {
        int userID = this.setting.getUserID();
        if (this.modes.containsKey(Integer.valueOf(userID)) && this.modes.get(Integer.valueOf(userID)) != null) {
            mo672a(zoom);
            m671a();
            this.modes.get(Integer.valueOf(userID)).onLayout(this, new Rect());
        }
    }

    public void setInputMethod(StrokeSprite.InputMethod inputMethod) {
        if (this.setting != null) {
            setInputMethod(inputMethod, this.setting.getUserID());
        }
    }

    public void setInputMethod(StrokeSprite.InputMethod inputMethod, int userID) {
        if (this.setting != null) {
            this.setting.m1099a(inputMethod, userID);
        }
    }

    public void setSpeedParameter(float[] handSpeed, float[] tabletSpeed) {
        if (this.setting != null) {
            this.setting.m1102a(handSpeed, tabletSpeed);
        }
    }

    public float[] getHandSpeedParameter() {
        return this.setting == null ? new float[]{VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET} : this.setting.m1108b();
    }

    public float[] getTabletSpeedParameter() {
        return this.setting == null ? new float[]{VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET} : this.setting.m1111c();
    }

    public void setPressureParameter(float[] handPressure, float[] tabletPressure) {
        if (this.setting != null) {
            this.setting.m1107b(handPressure, tabletPressure);
        }
    }

    public float[] getHandPressureParameter() {
        return this.setting == null ? new float[]{VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET} : this.setting.m1113d();
    }

    public float[] getTabletPressureParameter() {
        return this.setting == null ? new float[]{VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET} : this.setting.m1114e();
    }

    public int getLayerID() {
        return getLayerID(this.setting.getUserID());
    }

    public int getLayerID(int userID) {
        if (!this.modes.containsKey(Integer.valueOf(userID)) || this.modes.get(Integer.valueOf(userID)) == null) {
            return 0;
        }
        return this.modes.get(Integer.valueOf(userID)).getLayerID(this);
    }

    public ModeState getPreviousMode() {
        return getPreviousMode(this.setting.getUserID());
    }

    public ModeState getPreviousMode(int userID) {
        return this.f659a.get(Integer.valueOf(userID));
    }

    public void setCursorVisible(boolean visible) {
        this.f669l = visible;
    }

    public boolean getCursorVisible() {
        return this.f669l;
    }

    public InterfaceC1035bu getEdit() {
        return this.f660b;
    }

    public View getParent() {
        return this.view;
    }

    public void setBUpdateScreen(boolean bUpdateScreen) {
        this.f664g = bUpdateScreen;
    }

    public boolean isBUpdateScreen() {
        return this.f664g;
    }

    public void initializeSerializeData() {
        if (this.stage.getSelectedLayerID() == 0) {
            if (this.f667j != null) {
                Iterator<AbstractSprite> it = this.f667j.iterator();
                while (it.hasNext()) {
                    it.next().dispose();
                }
                this.f667j.clear();
                this.f667j = null;
            }
            if (this.f665h != null) {
                this.f665h.dispose();
                return;
            }
            return;
        }
        if (this.f668k != null) {
            Iterator<AbstractSprite> it2 = this.f668k.iterator();
            while (it2.hasNext()) {
                it2.next().dispose();
            }
            this.f668k.clear();
            this.f668k = null;
        }
        if (this.f666i != null) {
            this.f666i.dispose();
        }
    }
}
