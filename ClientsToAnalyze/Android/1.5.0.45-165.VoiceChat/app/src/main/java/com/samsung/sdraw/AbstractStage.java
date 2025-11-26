package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.Layout;
import com.sds.coolots.common.util.FileUtil;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
abstract class AbstractStage {
    public static final Object sprites1 = new Object();
    public static final Object sprites2 = new Object();

    /* renamed from: a */
    protected LinkedList<AbstractSprite> f837a;

    /* renamed from: b */
    protected LinkedList<AbstractSprite> f838b;
    public AbstractModeContext context;
    Bitmap fixedSprites2;

    /* renamed from: g */
    protected Bitmap f843g;

    /* renamed from: h */
    protected Bitmap f844h;

    /* renamed from: i */
    Bitmap f845i;

    /* renamed from: j */
    C1031bq f846j;
    protected Vector<Layer> listOfLayers;

    /* renamed from: o */
    private boolean f851o;
    public Canvas renderer;

    /* renamed from: c */
    protected ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> f839c = new ConcurrentHashMap<>();

    /* renamed from: d */
    protected ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> f840d = new ConcurrentHashMap<>();

    /* renamed from: e */
    protected ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> f841e = new ConcurrentHashMap<>();

    /* renamed from: f */
    protected ConcurrentHashMap<Integer, LinkedList<SpriteCommand>> f842f = new ConcurrentHashMap<>();

    /* renamed from: n */
    private int f850n = 3;

    /* renamed from: k */
    BitmapDrawable f847k = null;

    /* renamed from: l */
    BitmapDrawable f848l = null;

    /* renamed from: m */
    BitmapDrawable f849m = null;

    /* renamed from: p */
    private Lock f852p = new ReentrantLock();

    /* renamed from: q */
    private boolean f853q = false;

    public abstract void addSprite(AbstractSprite abstractSprite, boolean z);

    public abstract void addSprite(AbstractSprite abstractSprite, boolean z, int i);

    public abstract void cleanUpObjectLayer();

    public abstract void deleteSprite(AbstractSprite abstractSprite, boolean z);

    public abstract void deleteSprite(AbstractSprite abstractSprite, boolean z, int i);

    /* renamed from: f */
    protected abstract void mo836f();

    public abstract void initializeLayers(int i, int[] iArr, int[] iArr2);

    public abstract void modifyImageSprite(C0989ab c0989ab, ImageInfo imageInfo, int i, boolean z);

    public abstract void modifyImageSprite(C0989ab c0989ab, ImageInfo imageInfo, boolean z);

    public abstract void modifyTextSprite(TextSprite textSprite, PointF pointF, int i, int i2, Layout.Alignment alignment, Editable editable, boolean z);

    public abstract void modifyTextSprite(TextSprite textSprite, PointF pointF, int i, int i2, Layout.Alignment alignment, Editable editable, boolean z, int i3);

    public abstract void moveSprite(AbstractSprite abstractSprite, PointF pointF, PointF pointF2, boolean z);

    public abstract void moveSprite(AbstractSprite abstractSprite, PointF pointF, PointF pointF2, boolean z, int i);

    public abstract void renderAllSprites(boolean z, int i);

    public abstract void resizeSprite(AbstractSprite abstractSprite, PointF[] pointFArr, PointF[] pointFArr2, boolean z);

    public abstract void resizeSprite(AbstractSprite abstractSprite, PointF[] pointFArr, PointF[] pointFArr2, boolean z, int i);

    public abstract void rotateSprite(AbstractSprite abstractSprite, float f, float f2, boolean z);

    public abstract void rotateSprite(AbstractSprite abstractSprite, float f, float f2, boolean z, int i);

    public abstract int selectFluidLayer(int i, int i2);

    public AbstractStage(AbstractModeContext context) {
        if (SDrawLibrary.isSupportedModel()) {
            this.f851o = true;
        }
        this.context = context;
        initializeSprites();
        m834e();
        mo836f();
        m822a(context.setting);
    }

    /* renamed from: a */
    protected void m822a(Setting setting) {
        this.f846j = new C1031bq(setting);
        this.f846j.start();
    }

    /* renamed from: a */
    protected void m813a() {
        if (this.f846j != null) {
            this.f846j.m1423a();
            this.f846j.m1425b();
        }
    }

    public LinkedList<AbstractSprite> getSprites() {
        return getSprites(getSelectedLayerID());
    }

    public LinkedList<AbstractSprite> getSprites(int layerID) {
        return (layerID == 0 || layerID == 2) ? this.f837a : this.f838b;
    }

    public LinkedList<SpriteCommand> getUndoList() {
        return getUndoList(this.context.setting.getUserID());
    }

    public LinkedList<SpriteCommand> getUndoList(int userId) {
        boolean zM835e = m835e(userId);
        if (checkHistoryContainKey(userId, zM835e, false)) {
            if (zM835e) {
                return this.f839c.get(Integer.valueOf(userId));
            }
            return this.f841e.get(Integer.valueOf(userId));
        }
        return null;
    }

    public LinkedList<SpriteCommand> getRedoList() {
        return getRedoList(this.context.setting.getUserID());
    }

    public LinkedList<SpriteCommand> getRedoList(int userId) {
        boolean zM835e = m835e(userId);
        if (checkHistoryContainKey(userId, zM835e, true)) {
            if (zM835e) {
                return this.f840d.get(Integer.valueOf(userId));
            }
            return this.f842f.get(Integer.valueOf(userId));
        }
        return null;
    }

    /* renamed from: h */
    private void m810h() {
        if (getSelectedLayerID() == 0) {
            if (this.f845i != null && !this.f845i.isRecycled()) {
                this.f845i.eraseColor(0);
                return;
            }
            return;
        }
        if (this.fixedSprites2 != null && !this.fixedSprites2.isRecycled()) {
            this.fixedSprites2.eraseColor(0);
        }
    }

    public void clearAllStage() {
        int userID = this.context.setting.getUserID();
        if (getSelectedLayerID() == 0) {
            if (checkHistoryContainKey(userID, true, false)) {
                LinkedList<SpriteCommand> linkedList = this.f839c.get(Integer.valueOf(userID));
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    SpriteCommand spriteCommand = linkedList.get(size);
                    if (!(spriteCommand instanceof C1018bd)) {
                        linkedList.remove(spriteCommand);
                    }
                }
            }
            Iterator<Layer> it = this.listOfLayers.iterator();
            int i = 0;
            while (it.hasNext()) {
                Layer next = it.next();
                if (i != 3 && i != 4) {
                    next.m1014b();
                }
                i++;
            }
            if (this.f845i != null && !this.f845i.isRecycled()) {
                this.f845i.eraseColor(0);
            }
            drawBackgroundTheme();
        } else {
            if (checkHistoryContainKey(userID, false, false)) {
                LinkedList<SpriteCommand> linkedList2 = this.f841e.get(Integer.valueOf(userID));
                for (int size2 = linkedList2.size() - 1; size2 >= 0; size2--) {
                    SpriteCommand spriteCommand2 = linkedList2.get(size2);
                    if (!(spriteCommand2 instanceof C1018bd)) {
                        linkedList2.remove(spriteCommand2);
                    }
                }
            }
            Iterator<Layer> it2 = this.listOfLayers.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Layer next2 = it2.next();
                if (i2 != 0 && i2 != 2) {
                    next2.m1014b();
                }
                i2++;
            }
            if (this.fixedSprites2 != null && !this.fixedSprites2.isRecycled()) {
                this.fixedSprites2.eraseColor(0);
            }
        }
        m833d();
        m810h();
    }

    public void clearStage() {
        m819a(this.context.setting.getUserID(), true);
        m823a(false);
        this.context.setting.removeCacheFiles();
        int i = getSelectedLayerID() == 3 ? 1 : 0;
        clearLayers(i);
        if (i == 0) {
            if (this.f845i != null && !this.f845i.isRecycled()) {
                this.f845i.eraseColor(0);
                return;
            }
            return;
        }
        if (i == 1 && this.fixedSprites2 != null && !this.fixedSprites2.isRecycled()) {
            this.fixedSprites2.eraseColor(0);
        }
    }

    public void setBackgroundImages(Bitmap top, Bitmap mid, Bitmap btm) {
        if (this.f847k != null && !this.f847k.getBitmap().isRecycled() && !this.f847k.getBitmap().equals(top)) {
            this.f847k.getBitmap().recycle();
        }
        if (this.f848l != null && !this.f848l.getBitmap().isRecycled() && !this.f848l.getBitmap().equals(mid)) {
            this.f848l.getBitmap().recycle();
        }
        if (this.f849m != null && !this.f849m.getBitmap().isRecycled() && !this.f849m.getBitmap().equals(btm)) {
            this.f849m.getBitmap().recycle();
        }
        if (top != null) {
            this.f847k = new BitmapDrawable(top);
        } else {
            this.f847k = null;
        }
        if (mid != null) {
            this.f848l = new BitmapDrawable(mid);
        } else {
            this.f848l = null;
        }
        if (btm != null) {
            this.f849m = new BitmapDrawable(btm);
        } else {
            this.f849m = null;
        }
    }

    public void drawBackgroundTheme() {
        Canvas canvasM830c;
        int width;
        int height;
        if ((this.context == null || this.context.setting == null || !this.context.setting.m1121l()) && this.f845i != null && this.fixedSprites2 != null && (canvasM830c = m830c(2)) != null) {
            this.listOfLayers.get(2).m1014b();
            if (this.f845i != null) {
                width = this.f845i.getWidth();
                height = this.f845i.getHeight();
            } else {
                width = this.fixedSprites2.getWidth();
                height = this.fixedSprites2.getHeight();
            }
            float intrinsicWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            if (this.f847k != null) {
                intrinsicWidth = (width / this.f847k.getIntrinsicWidth()) * this.f847k.getIntrinsicHeight();
                this.f847k.setBounds(0, 0, width, (int) intrinsicWidth);
                this.f847k.draw(canvasM830c);
            }
            if (this.f848l != null) {
                float intrinsicWidth2 = (width / this.f848l.getIntrinsicWidth()) * this.f848l.getIntrinsicHeight();
                for (int i = (int) intrinsicWidth; i <= height && ((int) intrinsicWidth2) != 0; i = (int) (i + intrinsicWidth2)) {
                    this.f848l.setBounds(0, i, width, (int) (i + intrinsicWidth2));
                    this.f848l.draw(canvasM830c);
                }
            }
            if (this.f849m != null) {
                this.f849m.setBounds(0, (int) (height - ((width / this.f849m.getIntrinsicWidth()) * this.f849m.getIntrinsicHeight())), width, height);
                this.f849m.draw(canvasM830c);
            }
        }
    }

    /* renamed from: a */
    void m824a(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i = 0; i < iArr.length; i++) {
            m816a(iArr[i], iArr2[i], iArr3[i]);
        }
    }

    /* renamed from: a */
    void m816a(int i, int i2, int i3) {
        this.listOfLayers.get(i).m1009a(i2, i3);
    }

    /* renamed from: a */
    protected void m819a(int i, boolean z) {
        boolean zM835e = m835e(i);
        if (zM835e) {
            if (z) {
                Iterator<Integer> it = this.f839c.keySet().iterator();
                while (it.hasNext()) {
                    this.f839c.get(it.next()).clear();
                }
                Iterator<Integer> it2 = this.f840d.keySet().iterator();
                while (it2.hasNext()) {
                    this.f840d.get(it2.next()).clear();
                }
                return;
            }
            if (checkHistoryContainKey(i, zM835e, false)) {
                this.f839c.get(Integer.valueOf(i)).clear();
            }
            if (checkHistoryContainKey(i, zM835e, true)) {
                this.f840d.get(Integer.valueOf(i)).clear();
                return;
            }
            return;
        }
        if (z) {
            Iterator<Integer> it3 = this.f841e.keySet().iterator();
            while (it3.hasNext()) {
                this.f841e.get(it3.next()).clear();
            }
            Iterator<Integer> it4 = this.f842f.keySet().iterator();
            while (it4.hasNext()) {
                this.f842f.get(it4.next()).clear();
            }
            return;
        }
        if (checkHistoryContainKey(i, zM835e, false)) {
            this.f841e.get(Integer.valueOf(i)).clear();
        }
        if (checkHistoryContainKey(i, zM835e, true)) {
            this.f842f.get(Integer.valueOf(i)).clear();
        }
    }

    /* renamed from: b */
    protected void m828b() {
        if (this.f847k != null && !this.f847k.getBitmap().isRecycled()) {
            this.f847k.getBitmap().recycle();
        }
        if (this.f848l != null && !this.f848l.getBitmap().isRecycled()) {
            this.f848l.getBitmap().recycle();
        }
        if (this.f849m != null && !this.f849m.getBitmap().isRecycled()) {
            this.f849m.getBitmap().recycle();
        }
        this.f847k = null;
        this.f848l = null;
        this.f849m = null;
    }

    /* renamed from: c */
    protected void m831c() {
        Iterator<Layer> it = this.listOfLayers.iterator();
        while (it.hasNext()) {
            it.next().m1007a();
        }
        this.listOfLayers.clear();
    }

    /* renamed from: a */
    protected void m823a(boolean z) {
        if (getSelectedLayerID() == 0) {
            synchronized (sprites1) {
                if (this.f837a != null) {
                    Iterator<AbstractSprite> it = this.f837a.iterator();
                    while (it.hasNext()) {
                        it.next().dispose();
                    }
                    this.f837a.clear();
                }
            }
        } else {
            synchronized (sprites2) {
                if (this.f838b != null) {
                    Iterator<AbstractSprite> it2 = this.f838b.iterator();
                    while (it2.hasNext()) {
                        it2.next().dispose();
                    }
                    this.f838b.clear();
                }
            }
        }
        m833d();
        m810h();
    }

    /* renamed from: d */
    protected void m833d() {
        File[] fileArrListFiles;
        String strM1116g = this.context.setting.m1116g();
        if (strM1116g != null && (fileArrListFiles = new File(strM1116g).listFiles()) != null) {
            boolean zDelete = true;
            for (File file : fileArrListFiles) {
                if (!file.getName().equalsIgnoreCase(FileUtil.NOMEDIA_NAME)) {
                    zDelete = file.delete();
                }
                if (!zDelete) {
                    C0993af.m1275a("SPen", "cache file delete failed");
                }
            }
        }
    }

    public void clearLayer(int layer) {
        if (layer == 2) {
            drawBackgroundTheme();
        } else {
            this.listOfLayers.get(layer).m1014b();
        }
    }

    public void renderFixedSprites(int layer) {
        if (this.listOfLayers.get(layer).m1017d()) {
            if (layer == 0) {
                if (this.f845i != null) {
                    m830c(layer).drawBitmap(this.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
            } else if (this.fixedSprites2 != null) {
                m830c(layer).drawBitmap(this.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
        }
    }

    public void clearLayer(int layer, RectF rect) {
        this.listOfLayers.get(layer).m1011a(rect);
    }

    public void clearLayers() {
        Iterator<Layer> it = this.listOfLayers.iterator();
        while (it.hasNext()) {
            it.next().m1014b();
        }
        drawBackgroundTheme();
    }

    public void clearLayers(int layerID) {
        int i = 0;
        if (layerID == 0) {
            Iterator<Layer> it = this.listOfLayers.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    Layer next = it.next();
                    if (i2 == 0 && i2 == 2) {
                        next.m1014b();
                    }
                    i = i2 + 1;
                } else {
                    drawBackgroundTheme();
                    return;
                }
            }
        } else if (layerID == 1) {
            Iterator<Layer> it2 = this.listOfLayers.iterator();
            while (true) {
                int i3 = i;
                if (it2.hasNext()) {
                    Layer next2 = it2.next();
                    if (i3 == 3 && i3 == 4) {
                        next2.m1014b();
                    }
                    i = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dispose() {
        m831c();
        m823a(false);
        m813a();
        m828b();
        if (this.f845i != null) {
            this.f845i.recycle();
            this.f845i = null;
        }
        if (this.fixedSprites2 != null) {
            this.fixedSprites2.recycle();
            this.fixedSprites2 = null;
        }
        this.context = null;
    }

    /* renamed from: e */
    protected void m834e() {
        m814a(this.context.setting.getUserID());
    }

    /* renamed from: a */
    protected void m814a(int i) {
        m819a(i, false);
        boolean zM835e = m835e(i);
        if (i == this.context.setting.getUserID()) {
            if (!checkHistoryContainKey(i, zM835e, false)) {
                this.f839c.put(Integer.valueOf(i), new LinkedList<>());
            }
            if (!checkHistoryContainKey(i, zM835e, true)) {
                this.f840d.put(Integer.valueOf(i), new LinkedList<>());
            }
            if (!checkHistoryContainKey(i, zM835e, false)) {
                this.f841e.put(Integer.valueOf(i), new LinkedList<>());
            }
            if (!checkHistoryContainKey(i, zM835e, true)) {
                this.f842f.put(Integer.valueOf(i), new LinkedList<>());
                return;
            }
            return;
        }
        if (zM835e) {
            if (!checkHistoryContainKey(i, zM835e, false)) {
                this.f839c.put(Integer.valueOf(i), new LinkedList<>());
            }
            if (!checkHistoryContainKey(i, zM835e, true)) {
                this.f840d.put(Integer.valueOf(i), new LinkedList<>());
                return;
            }
            return;
        }
        if (!checkHistoryContainKey(i, zM835e, false)) {
            this.f841e.put(Integer.valueOf(i), new LinkedList<>());
        }
        if (!checkHistoryContainKey(i, zM835e, true)) {
            this.f842f.put(Integer.valueOf(i), new LinkedList<>());
        }
    }

    public void initializeSprites() {
        m823a(false);
        synchronized (sprites1) {
            this.f837a = new LinkedList<>();
        }
        synchronized (sprites2) {
            this.f838b = new LinkedList<>();
        }
        if (this.f845i != null && !this.f845i.isRecycled()) {
            this.f845i.eraseColor(0);
        }
        if (this.fixedSprites2 != null && !this.fixedSprites2.isRecycled()) {
            this.fixedSprites2.eraseColor(0);
        }
    }

    /* renamed from: a */
    void m820a(Bitmap bitmap) {
        m823a(false);
        drawBackgroundTheme();
        if (getSelectedLayerID() == 0) {
            synchronized (sprites1) {
                this.f837a = new LinkedList<>();
            }
            if (bitmap != null && this.f845i != null) {
                this.f845i.recycle();
            }
            if (bitmap != null) {
                try {
                    this.f845i = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    if (this.f845i != null) {
                        new Canvas(this.f845i).drawBitmap(bitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        synchronized (sprites2) {
            this.f838b = new LinkedList<>();
        }
        if (bitmap != null && this.fixedSprites2 != null) {
            this.fixedSprites2.recycle();
        }
        if (bitmap != null) {
            try {
                this.fixedSprites2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                if (this.fixedSprites2 != null) {
                    new Canvas(this.fixedSprites2).drawBitmap(bitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean isRedoable() {
        return isRedoable(this.context.setting.getUserID());
    }

    public boolean isRedoable(int userId) {
        boolean zM835e = m835e(userId);
        if (checkHistoryContainKey(userId, zM835e, true)) {
            if (zM835e) {
                return !this.f840d.get(Integer.valueOf(userId)).isEmpty();
            }
            return !this.f842f.get(Integer.valueOf(userId)).isEmpty();
        }
        m814a(userId);
        return false;
    }

    public boolean isUndoable() {
        return isUndoable(this.context.setting.getUserID());
    }

    public boolean isUndoable(int userId) {
        boolean zM835e = m835e(userId);
        if (checkHistoryContainKey(userId, zM835e, false)) {
            if (zM835e) {
                return !this.f839c.get(Integer.valueOf(userId)).isEmpty();
            }
            return !this.f841e.get(Integer.valueOf(userId)).isEmpty();
        }
        m814a(userId);
        return false;
    }

    public RectF redo(int userId) {
        LinkedList<SpriteCommand> linkedList;
        LinkedList<SpriteCommand> linkedList2;
        if (!isRedoable(userId)) {
            return new RectF();
        }
        boolean zM835e = m835e(userId);
        if (!checkHistoryContainKey(userId, zM835e, true) || !checkHistoryContainKey(userId, zM835e, false)) {
            return new RectF();
        }
        if (zM835e) {
            linkedList = this.f840d.get(Integer.valueOf(userId));
            linkedList2 = this.f839c.get(Integer.valueOf(userId));
        } else {
            linkedList = this.f842f.get(Integer.valueOf(userId));
            linkedList2 = this.f841e.get(Integer.valueOf(userId));
        }
        SpriteCommand spriteCommandPop = linkedList.pop();
        RectF rectFMo1129a = spriteCommandPop.mo1129a();
        if (rectFMo1129a == null) {
            linkedList2.push(spriteCommandPop);
            return new RectF(this.context.setting.getScreenRect());
        }
        RectF rectF = new RectF(rectFMo1129a);
        linkedList2.push(spriteCommandPop);
        return mapFromScene(rectF);
    }

    public RectF undo(int userId) {
        LinkedList<SpriteCommand> linkedList;
        LinkedList<SpriteCommand> linkedList2;
        if (!isUndoable(userId)) {
            return new RectF();
        }
        boolean zM835e = m835e(userId);
        if (!checkHistoryContainKey(userId, zM835e, true) || !checkHistoryContainKey(userId, zM835e, false)) {
            return new RectF();
        }
        if (zM835e) {
            LinkedList<SpriteCommand> linkedList3 = this.f840d.get(Integer.valueOf(userId));
            linkedList = this.f839c.get(Integer.valueOf(userId));
            linkedList2 = linkedList3;
        } else {
            LinkedList<SpriteCommand> linkedList4 = this.f842f.get(Integer.valueOf(userId));
            linkedList = this.f841e.get(Integer.valueOf(userId));
            linkedList2 = linkedList4;
        }
        SpriteCommand spriteCommandPop = linkedList.pop();
        RectF rectFMo1130b = spriteCommandPop.mo1130b();
        if (rectFMo1130b == null) {
            linkedList2.push(spriteCommandPop);
            return new RectF(this.context.setting.getScreenRect());
        }
        RectF rectF = new RectF(rectFMo1130b);
        linkedList2.push(spriteCommandPop);
        return mapFromScene(rectF);
    }

    public void renderSprite(int layer, AbstractSprite sprite) {
        if (sprite != null) {
            renderSprite(layer, sprite, sprite.getBounds());
        }
    }

    public void renderSprite(int layer, AbstractSprite sprite, RectF refreshRect) {
        this.f852p.lock();
        try {
            if (this.f851o) {
                this.listOfLayers.get(layer).renderSprite(sprite, refreshRect);
            }
        } finally {
            this.f852p.unlock();
        }
    }

    public void renderSprites(int layer) {
        if (layer == 0) {
            synchronized (sprites1) {
                Iterator<AbstractSprite> it = this.f837a.iterator();
                while (it.hasNext()) {
                    AbstractSprite next = it.next();
                    if (next.getLayerID() == 0) {
                        renderSprite(0, next);
                    }
                }
            }
            return;
        }
        if (layer == 3) {
            synchronized (sprites2) {
                Iterator<AbstractSprite> it2 = this.f838b.iterator();
                while (it2.hasNext()) {
                    AbstractSprite next2 = it2.next();
                    if (next2.getLayerID() == 3) {
                        renderSprite(3, next2);
                    }
                }
            }
            return;
        }
        if (layer == 2) {
            synchronized (sprites1) {
                Iterator<AbstractSprite> it3 = this.f837a.iterator();
                while (it3.hasNext()) {
                    AbstractSprite next3 = it3.next();
                    if (next3.getLayerID() == 2) {
                        renderSprite(2, next3);
                    }
                }
            }
            return;
        }
        if (layer == 4) {
            synchronized (sprites2) {
                Iterator<AbstractSprite> it4 = this.f838b.iterator();
                while (it4.hasNext()) {
                    AbstractSprite next4 = it4.next();
                    if (next4.getLayerID() == 4) {
                        renderSprite(4, next4);
                    }
                }
            }
            return;
        }
        synchronized (sprites1) {
            Iterator<AbstractSprite> it5 = this.f837a.iterator();
            while (it5.hasNext()) {
                renderSprite(layer, it5.next());
            }
        }
    }

    public void renderSprites(int layer, RectF refreshRect) {
        synchronized (sprites1) {
            Iterator<AbstractSprite> it = this.f837a.iterator();
            while (it.hasNext()) {
                renderSprite(layer, it.next(), refreshRect);
            }
        }
    }

    public void renderSprites(int layer, AbstractSprite hidingSprite) {
        synchronized (sprites1) {
            Iterator<AbstractSprite> it = this.f837a.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (!next.equals(hidingSprite)) {
                    renderSprite(layer, next);
                }
            }
        }
    }

    /* renamed from: b */
    Bitmap m825b(int i) {
        return this.listOfLayers.get(i).f1062b;
    }

    /* renamed from: c */
    Canvas m830c(int i) {
        return this.listOfLayers.get(i).f1061a;
    }

    public void setPanning(int layer, PointF panning) {
        this.listOfLayers.get(layer).m1012a(panning);
    }

    public PointF getPanning(int layer) {
        return new PointF(this.listOfLayers.get(layer).f1063c);
    }

    /* renamed from: a */
    void m815a(int i, float f) {
        this.listOfLayers.get(i).m1008a(f);
    }

    /* renamed from: d */
    float m832d(int i) {
        return this.listOfLayers.get(i).f1064d;
    }

    public RectF mapFromScene(RectF rect) {
        RectF rectF = new RectF();
        this.context.f661c.mapRect(rectF, rect);
        return rectF;
    }

    public Rect mapFromScene(Rect rect) {
        RectF rectFMapFromScene = mapFromScene(new RectF(rect));
        Rect rect2 = new Rect();
        rectFMapFromScene.roundOut(rect2);
        return rect2;
    }

    public PointF mapFromScene(PointF point) {
        float[] fArr = {point.x, point.y};
        this.context.f661c.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    public PointF mapToScene(PointF point) {
        float[] fArr = {point.x, point.y};
        this.context.f662d.mapPoints(fArr);
        return new PointF(fArr[0], fArr[1]);
    }

    public RectF mapToScene(RectF rect) {
        RectF rectF = new RectF();
        this.context.f662d.mapRect(rectF, rect);
        return rectF;
    }

    public AbstractSprite selectHittedSprite(PointF point) {
        RectF rectF = new RectF(point.x, point.y, point.x + 1.0f, point.y + 1.0f);
        int i = 0;
        LinkedList<AbstractSprite> linkedList = this.f837a;
        while (i < 2) {
            synchronized (sprites1) {
                for (int size = linkedList.size() - 1; size >= 0; size--) {
                    AbstractSprite abstractSprite = linkedList.get(size);
                    if (abstractSprite.isVisible() && abstractSprite.isHitted(rectF) && abstractSprite.multiUserID == this.context.setting.getUserID()) {
                        if (!(abstractSprite instanceof TextSprite) || this.context.setting.getTextLongClickSelectOption()) {
                            abstractSprite.select();
                        }
                        if (abstractSprite.isSelected()) {
                            return abstractSprite;
                        }
                    }
                }
            }
            i++;
            linkedList = this.f838b;
        }
        return null;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int userID = this.context.setting.getUserID();
        boolean zM835e = m835e(userID);
        if (zM835e) {
            StringBuilder sb4 = new StringBuilder("<ink>\n");
            synchronized (sprites1) {
                Iterator<AbstractSprite> it = this.f837a.iterator();
                while (it.hasNext()) {
                    sb4.append((CharSequence) it.next().toXML());
                }
            }
            sb4.append("</ink>\n");
            StringBuilder sb5 = new StringBuilder("<undo>\n");
            if (checkHistoryContainKey(userID, true, false)) {
                Iterator<SpriteCommand> it2 = this.f839c.get(Integer.valueOf(userID)).iterator();
                while (it2.hasNext()) {
                    sb5.append((CharSequence) it2.next().mo1131c());
                }
            }
            sb5.append("</undo>\n");
            StringBuilder sb6 = new StringBuilder("<redo>\n");
            if (checkHistoryContainKey(userID, zM835e, true)) {
                Iterator<SpriteCommand> it3 = this.f840d.get(Integer.valueOf(userID)).iterator();
                while (it3.hasNext()) {
                    sb6.append((CharSequence) it3.next().mo1131c());
                }
            }
            sb6.append("</redo>\n");
            sb = sb6;
            sb2 = sb5;
            sb3 = sb4;
        } else {
            StringBuilder sb7 = new StringBuilder("<ink>\n");
            synchronized (sprites2) {
                Iterator<AbstractSprite> it4 = this.f838b.iterator();
                while (it4.hasNext()) {
                    sb7.append((CharSequence) it4.next().toXML());
                }
            }
            sb7.append("</ink>\n");
            StringBuilder sb8 = new StringBuilder("<undo>\n");
            if (checkHistoryContainKey(userID, zM835e, false)) {
                Iterator<SpriteCommand> it5 = this.f841e.get(Integer.valueOf(userID)).iterator();
                while (it5.hasNext()) {
                    sb8.append((CharSequence) it5.next().mo1131c());
                }
            }
            sb8.append("</undo>\n");
            StringBuilder sb9 = new StringBuilder("<redo>\n");
            if (checkHistoryContainKey(userID, zM835e, true)) {
                Iterator<SpriteCommand> it6 = this.f842f.get(Integer.valueOf(userID)).iterator();
                while (it6.hasNext()) {
                    sb9.append((CharSequence) it6.next().mo1131c());
                }
            }
            sb9.append("</redo>\n");
            sb = sb9;
            sb2 = sb8;
            sb3 = sb7;
        }
        return String.format("<slide size=\"%d,%d\">\n", Integer.valueOf(this.context.setting.getCanvasWidth()), Integer.valueOf(this.context.setting.getCanvasHeight())) + ((CharSequence) sb3) + ((CharSequence) sb2) + ((CharSequence) sb) + "</slide>\n";
    }

    public Vector<C0989ab> toImageSpriteArray() {
        Vector<C0989ab> vector = new Vector<>();
        if (getSelectedLayerID() == 0) {
            synchronized (sprites1) {
                Iterator<AbstractSprite> it = this.f837a.iterator();
                while (it.hasNext()) {
                    AbstractSprite next = it.next();
                    if (next instanceof C0989ab) {
                        vector.add((C0989ab) next);
                    }
                }
            }
        } else {
            synchronized (sprites2) {
                Iterator<AbstractSprite> it2 = this.f838b.iterator();
                while (it2.hasNext()) {
                    AbstractSprite next2 = it2.next();
                    if (next2 instanceof C0989ab) {
                        vector.add((C0989ab) next2);
                    }
                }
            }
        }
        return vector;
    }

    /* renamed from: a */
    LinkedList<AbstractSprite> m811a(Class<?> cls) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        synchronized (sprites1) {
            Iterator<AbstractSprite> it = this.f837a.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (cls.isInstance(next)) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: b */
    LinkedList<AbstractSprite> m826b(Class<?> cls) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        synchronized (sprites2) {
            Iterator<AbstractSprite> it = this.f838b.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (cls.isInstance(next)) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    LinkedList<AbstractSprite> m812a(Class<?> cls, Class<?> cls2) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        synchronized (sprites1) {
            Iterator<AbstractSprite> it = this.f837a.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (cls.isInstance(next) || cls2.isInstance(next)) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: b */
    LinkedList<AbstractSprite> m827b(Class<?> cls, Class<?> cls2) {
        LinkedList<AbstractSprite> linkedList = new LinkedList<>();
        synchronized (sprites2) {
            Iterator<AbstractSprite> it = this.f838b.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (cls.isInstance(next) || cls2.isInstance(next)) {
                    linkedList.add(next);
                }
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    void m817a(int i, LinkedList<AbstractSprite> linkedList) {
        m818a(i, linkedList, (AbstractSprite) null);
    }

    /* renamed from: a */
    void m818a(int i, LinkedList<AbstractSprite> linkedList, AbstractSprite abstractSprite) {
        if (linkedList != null && !linkedList.isEmpty()) {
            if (abstractSprite == null) {
                Iterator<AbstractSprite> it = linkedList.iterator();
                while (it.hasNext()) {
                    renderSprite(i, it.next());
                }
            } else {
                Iterator<AbstractSprite> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    AbstractSprite next = it2.next();
                    if (!next.equals(abstractSprite)) {
                        renderSprite(i, next);
                    }
                }
            }
        }
    }

    public void strokeToFixedStroke(StrokeSprite stroke) throws Throwable {
        Bitmap bitmap;
        if (stroke.getLayerID() == 0) {
            bitmap = this.f845i;
        } else {
            bitmap = this.fixedSprites2;
        }
        if (bitmap != null && stroke.isVisible()) {
            stroke.mo1139a(new Canvas(bitmap), stroke.getBounds());
            stroke.m1143a(stroke.m1156d());
            stroke.m1159e(true);
        }
    }

    public void fillColorToFixedStroke(C1063s sprite) {
        Bitmap bitmap;
        if (sprite.getLayerID() == 0) {
            bitmap = this.f845i;
        } else {
            bitmap = this.fixedSprites2;
        }
        if (bitmap != null && sprite.isVisible()) {
            sprite.mo1139a(new Canvas(bitmap), sprite.getBounds());
            sprite.m1594a(true);
        }
    }

    public LinkedList<StrokeSprite> getHittedStrokeSprites(RectF hitRect) {
        LinkedList<StrokeSprite> linkedList = new LinkedList<>();
        RectF rectF = new RectF();
        synchronized (sprites2) {
            Iterator<AbstractSprite> it = this.f838b.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof StrokeSprite) && next.isHitted(hitRect)) {
                    linkedList.add((StrokeSprite) next);
                    rectF.union(next.getBounds());
                }
            }
        }
        synchronized (sprites1) {
            Iterator<AbstractSprite> it2 = this.f837a.iterator();
            while (it2.hasNext()) {
                AbstractSprite next2 = it2.next();
                if ((next2 instanceof StrokeSprite) && next2.isHitted(hitRect)) {
                    linkedList.add((StrokeSprite) next2);
                    rectF.union(next2.getBounds());
                }
            }
        }
        hitRect.set(rectF);
        return linkedList;
    }

    /* renamed from: a */
    void m821a(Matrix matrix) {
        Iterator<Layer> it = this.listOfLayers.iterator();
        while (it.hasNext()) {
            it.next().m1010a(matrix);
        }
    }

    public void deselectSprites() {
        synchronized (sprites2) {
            Iterator<AbstractSprite> it = this.f838b.iterator();
            while (it.hasNext()) {
                it.next().deselect();
            }
        }
        synchronized (sprites1) {
            Iterator<AbstractSprite> it2 = this.f837a.iterator();
            while (it2.hasNext()) {
                it2.next().deselect();
            }
        }
    }

    public int getCountOfSelectedSprites() {
        int i = 0;
        synchronized (sprites2) {
            Iterator<AbstractSprite> it = this.f838b.iterator();
            while (it.hasNext()) {
                if (it.next().isSelected()) {
                    i++;
                }
            }
        }
        synchronized (sprites1) {
            Iterator<AbstractSprite> it2 = this.f837a.iterator();
            while (it2.hasNext()) {
                if (it2.next().isSelected()) {
                    i++;
                }
            }
        }
        return i;
    }

    public ArrayList<AbstractSprite> getSelectedSprites() {
        ArrayList<AbstractSprite> arrayList = new ArrayList<>();
        synchronized (sprites2) {
            Iterator<AbstractSprite> it = this.f838b.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (next.isSelected()) {
                    arrayList.add(next);
                }
            }
        }
        synchronized (sprites1) {
            Iterator<AbstractSprite> it2 = this.f837a.iterator();
            while (it2.hasNext()) {
                AbstractSprite next2 = it2.next();
                if (next2.isSelected()) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<AbstractSprite> getHits(PointF point, boolean isExact) {
        ArrayList<AbstractSprite> arrayList = new ArrayList<>();
        if (isExact) {
            if (getSelectedLayerID() == 0) {
                synchronized (sprites1) {
                    Iterator<AbstractSprite> it = this.f837a.iterator();
                    while (it.hasNext()) {
                        AbstractSprite next = it.next();
                        if (next.isHitted(point) && next.multiUserID == this.context.setting.getUserID()) {
                            arrayList.add(next);
                        }
                    }
                }
            } else {
                synchronized (sprites2) {
                    Iterator<AbstractSprite> it2 = this.f838b.iterator();
                    while (it2.hasNext()) {
                        AbstractSprite next2 = it2.next();
                        if (next2.isHitted(point) && next2.multiUserID == this.context.setting.getUserID()) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        } else {
            RectF rectF = new RectF(point.x, point.y, point.x + 1.0f, point.y + 1.0f);
            if (getSelectedLayerID() == 0) {
                synchronized (sprites1) {
                    Iterator<AbstractSprite> it3 = this.f837a.iterator();
                    while (it3.hasNext()) {
                        AbstractSprite next3 = it3.next();
                        if (next3.isHitted(rectF) && next3.multiUserID == this.context.setting.getUserID()) {
                            arrayList.add(next3);
                        }
                    }
                }
            } else {
                synchronized (sprites2) {
                    Iterator<AbstractSprite> it4 = this.f838b.iterator();
                    while (it4.hasNext()) {
                        AbstractSprite next4 = it4.next();
                        if (next4.isHitted(rectF) && next4.multiUserID == this.context.setting.getUserID()) {
                            arrayList.add(next4);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public Bitmap getFixedStroke() {
        return this.f843g;
    }

    public Bitmap getFluidStroke() {
        return this.f844h;
    }

    /* renamed from: g */
    Vector<Layer> m837g() {
        return this.listOfLayers;
    }

    /* renamed from: b */
    protected void m829b(int i, boolean z) throws Throwable {
        if (this.context != null && this.context.setting != null) {
            int iM1117h = this.context.setting.m1117h();
            LinkedList<SpriteCommand> linkedList = null;
            if (checkHistoryContainKey(i, z, false)) {
                if (z) {
                    linkedList = this.f839c.get(Integer.valueOf(i));
                } else {
                    linkedList = this.f841e.get(Integer.valueOf(i));
                }
            }
            if (linkedList != null && linkedList.size() == iM1117h) {
                SpriteCommand spriteCommandPollLast = linkedList.pollLast();
                if (spriteCommandPollLast == null) {
                    throw new IllegalArgumentException(String.format("lastCommand is null", new Object[0]));
                }
                if ((spriteCommandPollLast instanceof SpriteCreateCommand) && (((SpriteCreateCommand) spriteCommandPollLast).sprite instanceof StrokeSprite)) {
                    strokeToFixedStroke((StrokeSprite) ((SpriteCreateCommand) spriteCommandPollLast).sprite);
                }
            }
        }
    }

    public void setSelectLayer(int layerID) {
        if (layerID == 1) {
            this.f850n = 3;
        } else {
            this.f850n = 0;
        }
    }

    public int getSelectedLayerID() {
        return this.f850n;
    }

    public void setLayerVisible(int layerID, boolean visible) {
        if (layerID == 0) {
            this.listOfLayers.get(0).m1013a(visible);
            this.listOfLayers.get(2).m1013a(visible);
        } else {
            this.listOfLayers.get(3).m1013a(visible);
            this.listOfLayers.get(4).m1013a(visible);
        }
        this.context.stage.clearLayers();
        LinkedList<AbstractSprite> linkedListM811a = this.context.stage.m811a(StrokeSprite.class);
        LinkedList<AbstractSprite> linkedListM826b = this.context.stage.m826b(StrokeSprite.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.context.stage.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.context.stage.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a3 = this.context.stage.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b3 = this.context.stage.m826b(TextSprite.class);
        this.context.stage.renderFixedSprites(0);
        this.context.stage.renderFixedSprites(3);
        if (linkedListM811a != null) {
            this.context.stage.m817a(0, linkedListM811a);
        }
        if (linkedListM826b != null) {
            this.context.stage.m817a(3, linkedListM826b);
        }
        if (linkedListM811a2 != null) {
            this.context.stage.m817a(2, linkedListM811a2);
        }
        if (linkedListM826b2 != null) {
            this.context.stage.m817a(4, linkedListM826b2);
        }
        if (linkedListM811a3 != null) {
            this.context.stage.m817a(2, linkedListM811a3);
        }
        if (linkedListM826b3 != null) {
            this.context.stage.m817a(4, linkedListM826b3);
        }
        this.context.invalidate();
    }

    public boolean layerIsVisible(int layerID) {
        return this.listOfLayers.get(layerID).m1017d();
    }

    public void setDrawingFront(boolean drawingFront) {
        this.f853q = drawingFront;
    }

    public boolean getDrawingFront() {
        return this.f853q;
    }

    public boolean checkHistoryContainKey(int userId, boolean isPublicLayer, boolean isListOfRedos) {
        if (isPublicLayer) {
            if (isListOfRedos) {
                if (this.f840d.containsKey(Integer.valueOf(userId)) && this.f840d.get(Integer.valueOf(userId)) != null) {
                    return true;
                }
            } else if (this.f839c.containsKey(Integer.valueOf(userId)) && this.f839c.get(Integer.valueOf(userId)) != null) {
                return true;
            }
        } else if (isListOfRedos) {
            if (this.f842f.containsKey(Integer.valueOf(userId)) && this.f842f.get(Integer.valueOf(userId)) != null) {
                return true;
            }
        } else if (this.f841e.containsKey(Integer.valueOf(userId)) && this.f841e.get(Integer.valueOf(userId)) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    protected boolean m835e(int i) {
        return (i == this.context.setting.getUserID() && getSelectedLayerID() == 3) ? false : true;
    }
}
