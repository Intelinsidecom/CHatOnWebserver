package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import android.text.Layout;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
class Stage extends AbstractStage {
    public Lock historyLock;
    public OnSpriteChangeListener mOnSpriteChangeListener;

    /* renamed from: n */
    private LinkedList<C0989ab> f1308n;

    /* renamed from: o */
    private LinkedList<TextSprite> f1309o;

    public interface OnSpriteChangeListener {
        void onMultiClearAll(boolean z);

        void onObjectChanged(ObjectInfo objectInfo, boolean z, boolean z2);

        void onObjectDeleted(ObjectInfo objectInfo, boolean z, boolean z2, boolean z3);

        void onObjectInserted(ObjectInfo objectInfo, boolean z, boolean z2);

        void onSpriteChanged(boolean z, boolean z2);

        boolean onStrokeInserting(StrokeInfo strokeInfo);
    }

    public Stage(AbstractModeContext context) {
        super(context);
        this.historyLock = new ReentrantLock();
        initializeLayers(5, new int[]{context.setting.getScreenWidth(), context.setting.getScreenWidth(), context.setting.getScreenWidth(), context.setting.getCanvasWidth(), context.setting.getCanvasWidth()}, new int[]{context.setting.getScreenHeight(), context.setting.getScreenHeight(), context.setting.getScreenHeight(), context.setting.getCanvasHeight(), context.setting.getCanvasHeight()});
        this.f1308n = new LinkedList<>();
        this.f1309o = new LinkedList<>();
        if (this.f845i != null) {
            this.f845i.recycle();
        }
        this.f845i = Bitmap.createBitmap(context.setting.getCanvasWidth(), context.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
        if (this.fixedSprites2 != null) {
            this.fixedSprites2.recycle();
        }
        this.fixedSprites2 = Bitmap.createBitmap(context.setting.getCanvasWidth(), context.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void addSprite(AbstractSprite sprite, boolean isHistory) {
        addSprite(sprite, isHistory, this.context.setting.getUserID());
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void addSprite(AbstractSprite sprite, boolean isHistory, int userID) {
        int size;
        LinkedList linkedList = new LinkedList();
        if (this.context != null && this.context.setting != null && !this.context.setting.bHistoricalOperationSupport) {
            isHistory = false;
        }
        if (sprite.isPublicLayer()) {
            synchronized (sprites1) {
                if (checkHistoryContainKey(userID, true, true)) {
                    Iterator<SpriteCommand> it = this.f840d.get(Integer.valueOf(userID)).iterator();
                    while (it.hasNext()) {
                        SpriteCommand next = it.next();
                        if (next instanceof SpriteCreateCommand) {
                            linkedList.add(next);
                        }
                    }
                }
                for (int i = 0; i < linkedList.size() && (size = this.f837a.size()) != 0; i++) {
                    int i2 = size - 1;
                    while (true) {
                        if (i2 >= 0) {
                            if (this.f837a.get(i2).multiUserID != userID) {
                                i2--;
                            } else if (!(this.f837a.get(i2) instanceof C0989ab)) {
                                this.f837a.remove(i2);
                            }
                        }
                    }
                }
                this.f837a.add(sprite);
                if (isHistory) {
                    m829b(userID, true);
                    if (checkHistoryContainKey(userID, true, false)) {
                        this.f839c.get(Integer.valueOf(userID)).push(new SpriteCreateCommand(sprite, this));
                    } else {
                        m814a(userID);
                        this.f839c.get(Integer.valueOf(userID)).push(new SpriteCreateCommand(sprite, this));
                    }
                    if (userID == this.context.setting.getUserID()) {
                        callonObjectDeleted(sprite.getLayerID());
                    }
                    if (checkHistoryContainKey(userID, true, true)) {
                        this.f840d.get(Integer.valueOf(userID)).clear();
                    } else {
                        m814a(userID);
                        this.f840d.get(Integer.valueOf(userID)).clear();
                    }
                }
            }
        } else {
            synchronized (sprites2) {
                if (checkHistoryContainKey(userID, false, true)) {
                    Iterator<SpriteCommand> it2 = this.f842f.get(Integer.valueOf(userID)).iterator();
                    while (it2.hasNext()) {
                        SpriteCommand next2 = it2.next();
                        if (next2 instanceof SpriteCreateCommand) {
                            linkedList.add(next2);
                        }
                    }
                }
                for (int i3 = 0; i3 < linkedList.size() && this.f838b.size() != 0; i3++) {
                    if (!(this.f838b.getLast() instanceof C0989ab)) {
                        this.f838b.removeLast();
                    }
                }
                this.f838b.add(sprite);
                if (isHistory) {
                    m829b(userID, false);
                    if (checkHistoryContainKey(userID, false, false)) {
                        this.f841e.get(Integer.valueOf(userID)).push(new SpriteCreateCommand(sprite, this));
                    } else {
                        m814a(userID);
                        this.f841e.get(Integer.valueOf(userID)).push(new SpriteCreateCommand(sprite, this));
                    }
                    callonObjectDeleted(3);
                    if (checkHistoryContainKey(userID, false, true)) {
                        this.f842f.get(Integer.valueOf(userID)).clear();
                    } else {
                        m814a(userID);
                        this.f842f.get(Integer.valueOf(userID)).clear();
                    }
                }
            }
        }
        sprite.setVisible(true);
        if (isHistory) {
            if (userID == this.context.setting.getUserID()) {
                if (!(sprite instanceof StrokeSprite)) {
                    if (this.context != null && this.context.historyChangeListener != null) {
                        this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
                    }
                    if (this.mOnSpriteChangeListener != null) {
                        this.mOnSpriteChangeListener.onSpriteChanged(isUndoable(), isRedoable());
                    }
                }
                if (sprite instanceof C0989ab) {
                    this.f1308n.add((C0989ab) sprite);
                }
                if (sprite instanceof TextSprite) {
                    this.f1309o.add((TextSprite) sprite);
                }
            }
            synchronized (sprites1) {
                if (this.mOnSpriteChangeListener != null && isHistory) {
                    if (sprite instanceof C0989ab) {
                        ImageInfo imageInfoM1262c = ((C0989ab) sprite).m1262c();
                        this.mOnSpriteChangeListener.onObjectInserted(imageInfoM1262c, false, false);
                        ((C0989ab) sprite).objectID = imageInfoM1262c.getID();
                    } else if (sprite instanceof TextSprite) {
                        TextInfo textInfoM1203j = ((TextSprite) sprite).m1203j();
                        boolean z = textInfoM1203j.getID() == -1;
                        this.mOnSpriteChangeListener.onObjectInserted(textInfoM1203j, false, false);
                        if (z) {
                            ((TextSprite) sprite).objectID = textInfoM1203j.getID();
                        }
                    } else if (!(sprite instanceof StrokeSprite) && (sprite instanceof C1063s)) {
                        FillColorInfo fillColorInfoM1597d = ((C1063s) sprite).m1597d();
                        this.mOnSpriteChangeListener.onObjectInserted(fillColorInfoM1597d, false, false);
                        ((C1063s) sprite).objectID = fillColorInfoM1597d.getID();
                    }
                }
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void deleteSprite(AbstractSprite sprite, boolean isHistory) {
        deleteSprite(sprite, isHistory, sprite.multiUserID);
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void deleteSprite(AbstractSprite sprite, boolean isHistory, int userID) {
        if (this.context != null && this.context.setting != null && !this.context.setting.bHistoricalOperationSupport) {
            isHistory = false;
        }
        boolean zIsPublicLayer = sprite.isPublicLayer();
        if (isHistory) {
            m829b(userID, zIsPublicLayer);
            if (zIsPublicLayer) {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f839c.get(Integer.valueOf(userID)).push(new C1019be(sprite, this));
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted(0);
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f840d.get(Integer.valueOf(userID)).clear();
                }
            } else {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f841e.get(Integer.valueOf(userID)).push(new C1019be(sprite, this));
                }
                callonObjectDeleted(3);
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f842f.get(Integer.valueOf(userID)).clear();
                }
            }
        }
        if (userID == this.context.setting.getUserID() && this.context.historyChangeListener != null) {
            this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
        }
        synchronized (sprites1) {
            if (this.mOnSpriteChangeListener != null) {
                if (sprite instanceof C0989ab) {
                    this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) sprite).m1262c(), false, false, false);
                } else if (sprite instanceof TextSprite) {
                    this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) sprite).m1203j(), false, false, false);
                } else if (sprite instanceof StrokeSprite) {
                    this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) sprite).m1174s(), false, false, false);
                } else if (sprite instanceof C1063s) {
                    this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) sprite).m1597d(), false, false, false);
                }
            }
        }
        if (isHistory) {
            sprite.setVisible(false);
            return;
        }
        this.f1308n.remove(sprite);
        this.f1309o.remove(sprite);
        if (zIsPublicLayer) {
            synchronized (sprites1) {
                this.f837a.remove(sprite);
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    LinkedList<SpriteCommand> linkedList = this.f839c.get(Integer.valueOf(userID));
                    int size = linkedList.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            SpriteCommand spriteCommand = linkedList.get(i);
                            if (!(spriteCommand instanceof SpriteCreateCommand) || ((SpriteCreateCommand) spriteCommand).sprite != sprite) {
                                i++;
                            } else {
                                linkedList.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        } else {
            synchronized (sprites2) {
                this.f838b.remove(sprite);
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    LinkedList<SpriteCommand> linkedList2 = this.f841e.get(Integer.valueOf(userID));
                    int size2 = linkedList2.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 < size2) {
                            SpriteCommand spriteCommand2 = linkedList2.get(i2);
                            if (!(spriteCommand2 instanceof SpriteCreateCommand) || ((SpriteCreateCommand) spriteCommand2).sprite != sprite) {
                                i2++;
                            } else {
                                linkedList2.remove(i2);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        sprite.dispose();
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void moveSprite(AbstractSprite sprite, PointF point, PointF origin, boolean isHistory) {
        moveSprite(sprite, point, origin, isHistory, this.context.setting.getUserID());
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void moveSprite(AbstractSprite sprite, PointF point, PointF origin, boolean isHistory, int userID) {
        if (this.context != null && this.context.setting != null && !this.context.setting.bHistoricalOperationSupport) {
            isHistory = false;
        }
        if (isHistory) {
            C1021bg c1021bg = new C1021bg(sprite, this);
            c1021bg.m1406a(origin);
            c1021bg.m1407b(((C0989ab) sprite).m1263c(0));
            boolean zIsPublicLayer = sprite.isPublicLayer();
            m829b(userID, zIsPublicLayer);
            if (zIsPublicLayer) {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f839c.get(Integer.valueOf(userID)).push(c1021bg);
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted();
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f840d.get(Integer.valueOf(userID)).clear();
                }
            } else {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f841e.get(Integer.valueOf(userID)).push(c1021bg);
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted();
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f842f.get(Integer.valueOf(userID)).clear();
                }
            }
        }
        if (userID == this.context.setting.getUserID() && this.context.historyChangeListener != null) {
            this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
        }
        synchronized (sprites1) {
            if (this.mOnSpriteChangeListener != null && (sprite instanceof C0989ab)) {
                this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) sprite).m1262c(), false, false);
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void resizeSprite(AbstractSprite sprite, PointF[] resizeVertex, PointF[] mOriginVertex, boolean isHistory) {
        resizeSprite(sprite, resizeVertex, mOriginVertex, isHistory, this.context.setting.getUserID());
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void resizeSprite(AbstractSprite sprite, PointF[] resizeVertex, PointF[] mOriginVertex, boolean isHistory, int userID) {
        if (this.context != null && this.context.setting != null && !this.context.setting.bHistoricalOperationSupport) {
            isHistory = false;
        }
        if (isHistory) {
            C1022bh c1022bh = new C1022bh(sprite, this);
            c1022bh.m1408a(resizeVertex, mOriginVertex);
            boolean zIsPublicLayer = sprite.isPublicLayer();
            m829b(userID, zIsPublicLayer);
            if (zIsPublicLayer) {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f839c.get(Integer.valueOf(userID)).push(c1022bh);
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted();
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f840d.get(Integer.valueOf(userID)).clear();
                }
            } else {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f841e.get(Integer.valueOf(userID)).push(c1022bh);
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted();
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f841e.get(Integer.valueOf(userID)).clear();
                }
            }
        }
        if (userID == this.context.setting.getUserID() && this.context.historyChangeListener != null) {
            this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
        }
        synchronized (sprites1) {
            if (this.mOnSpriteChangeListener != null && (sprite instanceof C0989ab)) {
                this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) sprite).m1262c(), false, false);
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void rotateSprite(AbstractSprite sprite, float angle, float origin, boolean isHistory) {
        rotateSprite(sprite, angle, origin, isHistory, this.context.setting.getUserID());
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void rotateSprite(AbstractSprite sprite, float angle, float origin, boolean isHistory, int userID) {
        if (this.context != null && this.context.setting != null && !this.context.setting.bHistoricalOperationSupport) {
            isHistory = false;
        }
        if (isHistory) {
            C1023bi c1023bi = new C1023bi(sprite, this);
            c1023bi.m1409a(angle, origin);
            boolean zIsPublicLayer = sprite.isPublicLayer();
            m829b(userID, zIsPublicLayer);
            if (zIsPublicLayer) {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f839c.get(Integer.valueOf(userID)).push(c1023bi);
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted();
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f840d.get(Integer.valueOf(userID)).clear();
                }
            } else {
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    this.f841e.get(Integer.valueOf(userID)).push(c1023bi);
                }
                if (userID == this.context.setting.getUserID()) {
                    callonObjectDeleted();
                }
                if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                    this.f842f.get(Integer.valueOf(userID)).clear();
                }
            }
        }
        if (userID == this.context.setting.getUserID() && this.context.historyChangeListener != null) {
            this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
        }
        synchronized (sprites1) {
            if (this.mOnSpriteChangeListener != null && (sprite instanceof C0989ab)) {
                this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) sprite).m1262c(), false, false);
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void modifyTextSprite(TextSprite sprite, PointF position, int width, int height, Layout.Alignment layout, Editable modifiedText, boolean changeText) {
        modifyTextSprite(sprite, position, width, height, layout, modifiedText, changeText, this.context.setting.getUserID());
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void modifyTextSprite(TextSprite sprite, PointF position, int width, int height, Layout.Alignment layout, Editable modifiedText, boolean changeText, int userID) {
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable(sprite.m1201h());
        int iWidth = (int) sprite.getBounds().width();
        int iHeight = (int) sprite.getBounds().height();
        PointF pointF = sprite.f1359d;
        Layout.Alignment alignment = sprite.m1196c().getAlignment();
        sprite.m1194a(modifiedText, position, width, height, layout);
        if (position.x != pointF.x || position.y != pointF.y || iWidth != width || !editableNewEditable.toString().equals(modifiedText.toString()) || changeText) {
            boolean zIsPublicLayer = sprite.isPublicLayer();
            if (this.context != null && this.context.setting != null && this.context.setting.bHistoricalOperationSupport) {
                m829b(userID, zIsPublicLayer);
                if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                    if (zIsPublicLayer) {
                        this.f839c.get(Integer.valueOf(userID)).push(new C1039by(sprite, this, editableNewEditable, modifiedText, pointF, position, iWidth, width, iHeight, height, alignment, layout));
                    } else {
                        this.f841e.get(Integer.valueOf(userID)).push(new C1039by(sprite, this, editableNewEditable, modifiedText, pointF, position, iWidth, width, iHeight, height, alignment, layout));
                    }
                }
            }
            synchronized (sprites1) {
                if (this.mOnSpriteChangeListener != null && (sprite instanceof TextSprite)) {
                    this.mOnSpriteChangeListener.onObjectChanged(sprite.m1203j(), false, false);
                }
                callonObjectDeleted(sprite.getLayerID());
            }
            if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
                if (zIsPublicLayer) {
                    this.f840d.get(Integer.valueOf(userID)).clear();
                } else {
                    this.f842f.get(Integer.valueOf(userID)).clear();
                }
            }
            if (userID == this.context.setting.getUserID() && this.context.historyChangeListener != null) {
                this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void modifyImageSprite(C0989ab sprite, ImageInfo imageInfo, boolean updateBitmapResource) {
        modifyImageSprite(sprite, imageInfo, this.context.setting.getUserID(), updateBitmapResource);
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void modifyImageSprite(C0989ab sprite, ImageInfo imageInfo, int userID, boolean updateBitmapResource) {
        if (updateBitmapResource) {
            sprite.m1261b(imageInfo.getImg());
        }
        RectF rectFM1264d = sprite.m1264d();
        int i = sprite.f1423j;
        sprite.resizeTo(imageInfo.getRect());
        int angle = (int) imageInfo.getAngle();
        sprite.m1255a(0);
        sprite.m1260b(angle);
        C0990ac c0990ac = new C0990ac(sprite, this, rectFM1264d, imageInfo.getRect(), angle, i);
        boolean zIsPublicLayer = sprite.isPublicLayer();
        if (this.context != null && this.context.setting != null && this.context.setting.bHistoricalOperationSupport) {
            m829b(userID, zIsPublicLayer);
            if (checkHistoryContainKey(userID, zIsPublicLayer, false)) {
                if (zIsPublicLayer) {
                    this.f839c.get(Integer.valueOf(userID)).push(c0990ac);
                } else {
                    this.f841e.get(Integer.valueOf(userID)).push(c0990ac);
                }
            }
        }
        synchronized (sprites1) {
            if (this.mOnSpriteChangeListener != null && (sprite instanceof C0989ab)) {
                this.mOnSpriteChangeListener.onObjectChanged(sprite.m1262c(), false, false);
            }
            callonObjectDeleted();
        }
        if (checkHistoryContainKey(userID, zIsPublicLayer, true)) {
            if (zIsPublicLayer) {
                this.f840d.get(Integer.valueOf(userID)).clear();
            } else {
                this.f842f.get(Integer.valueOf(userID)).clear();
            }
        }
        if (userID == this.context.setting.getUserID() && this.context.historyChangeListener != null) {
            this.context.historyChangeListener.onHistoryChanged(this.context.stage.isUndoable(), this.context.stage.isRedoable());
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void initializeLayers(int numOfLayers, int[] widthOfLayers, int[] heightOfLayers) {
        mo836f();
        for (int i = 0; i < numOfLayers; i++) {
            this.listOfLayers.add(new Layer(widthOfLayers[i], heightOfLayers[i]));
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    /* renamed from: f */
    protected void mo836f() {
        if (this.listOfLayers != null) {
            m831c();
        }
        this.listOfLayers = new Vector<>();
    }

    public AbstractSprite selectHittedImageSprite(PointF point) {
        RectF rectFMapToScene = mapToScene(new RectF(point.x, point.y, point.x + 1.0f, point.y + 1.0f));
        if (getSelectedLayerID() == 0) {
            synchronized (sprites1) {
                for (int size = this.f837a.size() - 1; size >= 0; size--) {
                    AbstractSprite abstractSprite = this.f837a.get(size);
                    if ((abstractSprite instanceof C0989ab) && abstractSprite.isVisible() && abstractSprite.isHitted(rectFMapToScene)) {
                        abstractSprite.select();
                        if (abstractSprite.isSelected()) {
                            return abstractSprite;
                        }
                    }
                }
            }
        } else {
            synchronized (sprites2) {
                for (int size2 = this.f838b.size() - 1; size2 >= 0; size2--) {
                    AbstractSprite abstractSprite2 = this.f838b.get(size2);
                    if ((abstractSprite2 instanceof C0989ab) && abstractSprite2.isVisible() && abstractSprite2.isHitted(rectFMapToScene)) {
                        abstractSprite2.select();
                        if (abstractSprite2.isSelected()) {
                            return abstractSprite2;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private AbstractSprite m1132a(int i, PointF pointF, LinkedList<AbstractSprite> linkedList) {
        AbstractSprite abstractSprite;
        int size = linkedList.size() - 1;
        while (true) {
            if (size >= 0) {
                abstractSprite = linkedList.get(size);
                if ((abstractSprite instanceof StrokeSprite) && abstractSprite.isVisible() && abstractSprite.isHitted(pointF) && abstractSprite.multiUserID == i) {
                    break;
                }
                size--;
            } else {
                abstractSprite = null;
                break;
            }
        }
        if (abstractSprite != null) {
            return abstractSprite;
        }
        return null;
    }

    @Override // com.samsung.sdraw.AbstractStage
    public AbstractSprite selectHittedSprite(PointF point) {
        int i = 0;
        AbstractSprite abstractSpriteM1132a = m1132a(this.context.setting.getUserID(), point, this.f837a);
        if (abstractSpriteM1132a == null) {
            AbstractSprite abstractSpriteM1132a2 = m1132a(this.context.setting.getUserID(), point, this.f838b);
            if (abstractSpriteM1132a2 == null) {
                RectF rectFMapToScene = mapToScene(new RectF(point.x, point.y, point.x + 1.0f, point.y + 1.0f));
                Class<?>[] clsArr = {TextSprite.class, C0989ab.class};
                if (getSelectedLayerID() == 0) {
                    int length = clsArr.length;
                    while (i < length) {
                        LinkedList<AbstractSprite> linkedListA = m811a(clsArr[i]);
                        Collections.reverse(linkedListA);
                        Iterator<AbstractSprite> it = linkedListA.iterator();
                        while (it.hasNext()) {
                            AbstractSprite next = it.next();
                            if (next.isVisible() && next.isHitted(rectFMapToScene) && next.multiUserID == this.context.setting.getUserID()) {
                                if (!(next instanceof TextSprite) || this.context.setting.getTextLongClickSelectOption()) {
                                    next.select();
                                }
                                if (next.isSelected()) {
                                    return next;
                                }
                            }
                        }
                        i++;
                    }
                } else {
                    int length2 = clsArr.length;
                    while (i < length2) {
                        LinkedList<AbstractSprite> linkedListB = m826b(clsArr[i]);
                        Collections.reverse(linkedListB);
                        Iterator<AbstractSprite> it2 = linkedListB.iterator();
                        while (it2.hasNext()) {
                            AbstractSprite next2 = it2.next();
                            if (next2.isVisible() && next2.isHitted(rectFMapToScene) && next2.multiUserID == this.context.setting.getUserID()) {
                                if (!(next2 instanceof TextSprite) || this.context.setting.getTextLongClickSelectOption()) {
                                    next2.select();
                                }
                                if (next2.isSelected()) {
                                    return next2;
                                }
                            }
                        }
                        i++;
                    }
                }
                return null;
            }
            return abstractSpriteM1132a2;
        }
        return abstractSpriteM1132a;
    }

    public AbstractSprite selectedImageSprite() {
        if (getSelectedLayerID() == 0) {
            synchronized (sprites1) {
                int size = this.f837a.size();
                for (int i = 0; i < size; i++) {
                    AbstractSprite abstractSprite = this.f837a.get(i);
                    if ((abstractSprite instanceof C0989ab) && abstractSprite.isSelected()) {
                        return abstractSprite;
                    }
                }
            }
        } else {
            synchronized (sprites2) {
                int size2 = this.f838b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    AbstractSprite abstractSprite2 = this.f838b.get(i2);
                    if ((abstractSprite2 instanceof C0989ab) && abstractSprite2.isSelected()) {
                        return abstractSprite2;
                    }
                }
            }
        }
        return null;
    }

    public void renderSprites(int kindOfSprite, int layer) {
        synchronized (sprites1) {
            Iterator<AbstractSprite> it = this.f837a.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (!(next instanceof StrokeSprite) && (kindOfSprite & 2) != 0 && !next.isSelected()) {
                    renderSprite(layer, next);
                }
            }
            Iterator<AbstractSprite> it2 = this.f837a.iterator();
            while (it2.hasNext()) {
                AbstractSprite next2 = it2.next();
                if ((next2 instanceof StrokeSprite) && (kindOfSprite & 1) != 0) {
                    renderSprite(layer, next2);
                }
            }
        }
        synchronized (sprites2) {
            Iterator<AbstractSprite> it3 = this.f838b.iterator();
            while (it3.hasNext()) {
                AbstractSprite next3 = it3.next();
                if (!(next3 instanceof StrokeSprite) && (kindOfSprite & 2) != 0 && !next3.isSelected()) {
                    renderSprite(layer, next3);
                }
            }
            Iterator<AbstractSprite> it4 = this.f838b.iterator();
            while (it4.hasNext()) {
                AbstractSprite next4 = it4.next();
                if ((next4 instanceof StrokeSprite) && (kindOfSprite & 1) != 0) {
                    renderSprite(layer, next4);
                }
            }
        }
    }

    public static Rect getSpritesBounds(LinkedList<AbstractSprite> list) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).getBounds().round(rect);
            rect2.union(rect);
        }
        return rect2;
    }

    @Override // com.samsung.sdraw.AbstractStage
    public RectF redo(int userId) {
        LinkedList<SpriteCommand> linkedList;
        boolean zE = m835e(userId);
        if (checkHistoryContainKey(userId, zE, true)) {
            if (zE) {
                linkedList = this.f840d.get(Integer.valueOf(userId));
            } else {
                linkedList = this.f842f.get(Integer.valueOf(userId));
            }
            if (linkedList.size() == 0) {
                return super.redo(userId);
            }
            SpriteCommand first = linkedList.getFirst();
            RectF rectFRedo = super.redo(userId);
            if (first == null) {
                return rectFRedo;
            }
            if (first instanceof SpriteCreateCommand) {
                AbstractSprite abstractSprite = ((SpriteCreateCommand) first).sprite;
                if (this.mOnSpriteChangeListener != null) {
                    if (abstractSprite instanceof C0989ab) {
                        this.mOnSpriteChangeListener.onObjectInserted(((C0989ab) abstractSprite).m1262c(), false, true);
                    } else if (abstractSprite instanceof TextSprite) {
                        this.mOnSpriteChangeListener.onObjectInserted(((TextSprite) abstractSprite).m1203j(), false, true);
                    } else if (abstractSprite instanceof StrokeSprite) {
                        this.mOnSpriteChangeListener.onObjectInserted(((StrokeSprite) abstractSprite).m1174s(), false, true);
                    } else if (abstractSprite instanceof C1063s) {
                        this.mOnSpriteChangeListener.onObjectInserted(((C1063s) abstractSprite).m1597d(), false, true);
                    }
                }
            } else if (first instanceof C1019be) {
                AbstractSprite abstractSprite2 = ((C1019be) first).f1558a;
                if (this.mOnSpriteChangeListener != null) {
                    if (abstractSprite2 instanceof C0989ab) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) abstractSprite2).m1262c(), false, true, false);
                    } else if (abstractSprite2 instanceof TextSprite) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) abstractSprite2).m1203j(), false, true, false);
                    } else if (abstractSprite2 instanceof StrokeSprite) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) abstractSprite2).m1174s(), false, true, false);
                    } else if (abstractSprite2 instanceof C1063s) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) abstractSprite2).m1597d(), false, true, false);
                    }
                }
            } else if (first instanceof C1018bd) {
                this.mOnSpriteChangeListener.onMultiClearAll(false);
                if (zE) {
                    synchronized (sprites1) {
                        if (this.f837a != null) {
                            Iterator<AbstractSprite> it = this.f837a.iterator();
                            while (it.hasNext()) {
                                AbstractSprite next = it.next();
                                if (next instanceof C0989ab) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) next).m1262c(), false, true, false);
                                } else if (next instanceof TextSprite) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) next).m1203j(), false, true, false);
                                } else if (next instanceof StrokeSprite) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) next).m1174s(), false, true, false);
                                } else if (next instanceof C1063s) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) next).m1597d(), false, true, false);
                                }
                            }
                        }
                    }
                } else {
                    synchronized (sprites2) {
                        if (this.f838b != null) {
                            Iterator<AbstractSprite> it2 = this.f838b.iterator();
                            while (it2.hasNext()) {
                                AbstractSprite next2 = it2.next();
                                if (next2 instanceof C0989ab) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) next2).m1262c(), false, true, false);
                                } else if (next2 instanceof TextSprite) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) next2).m1203j(), false, true, false);
                                } else if (next2 instanceof StrokeSprite) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) next2).m1174s(), false, true, false);
                                } else if (next2 instanceof C1063s) {
                                    this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) next2).m1597d(), false, true, false);
                                }
                            }
                        }
                    }
                }
            } else if ((first instanceof C1021bg) || (first instanceof C1023bi) || (first instanceof C1022bh)) {
                if (first instanceof C1021bg) {
                    AbstractSprite abstractSprite3 = ((C1021bg) first).f1560a;
                    if (this.mOnSpriteChangeListener != null && (abstractSprite3 instanceof C0989ab)) {
                        this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) abstractSprite3).m1262c(), false, true);
                    }
                } else if (first instanceof C1023bi) {
                    AbstractSprite abstractSprite4 = ((C1023bi) first).f1570a;
                    if (this.mOnSpriteChangeListener != null && (abstractSprite4 instanceof C0989ab)) {
                        this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) abstractSprite4).m1262c(), false, true);
                    }
                } else if (first instanceof C1022bh) {
                    AbstractSprite abstractSprite5 = ((C1022bh) first).f1564a;
                    if (this.mOnSpriteChangeListener != null && (abstractSprite5 instanceof C0989ab)) {
                        this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) abstractSprite5).m1262c(), false, true);
                    }
                }
            } else if (first instanceof C1039by) {
                TextSprite textSprite = ((C1039by) first).f1669k;
                if (this.mOnSpriteChangeListener != null && (textSprite instanceof TextSprite)) {
                    this.mOnSpriteChangeListener.onObjectChanged(textSprite.m1203j(), false, true);
                }
            } else if (first instanceof C0990ac) {
                C0989ab c0989ab = ((C0990ac) first).f1432a;
                if (this.mOnSpriteChangeListener != null && (c0989ab instanceof C0989ab)) {
                    this.mOnSpriteChangeListener.onObjectChanged(c0989ab.m1262c(), false, true);
                }
            }
            return rectFRedo;
        }
        return super.redo(userId);
    }

    @Override // com.samsung.sdraw.AbstractStage
    public RectF undo(int userId) {
        LinkedList<SpriteCommand> linkedList;
        boolean zE = m835e(userId);
        if (checkHistoryContainKey(userId, zE, false)) {
            if (zE) {
                linkedList = this.f839c.get(Integer.valueOf(userId));
            } else {
                linkedList = this.f841e.get(Integer.valueOf(userId));
            }
            if (linkedList.size() == 0) {
                return super.undo(userId);
            }
            SpriteCommand first = linkedList.getFirst();
            RectF rectFUndo = super.undo(userId);
            if (first == null) {
                return rectFUndo;
            }
            if (first instanceof SpriteCreateCommand) {
                AbstractSprite abstractSprite = ((SpriteCreateCommand) first).sprite;
                if (this.mOnSpriteChangeListener != null) {
                    if (abstractSprite instanceof C0989ab) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) abstractSprite).m1262c(), true, false, false);
                    } else if (abstractSprite instanceof TextSprite) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) abstractSprite).m1203j(), true, false, false);
                    } else if (abstractSprite instanceof StrokeSprite) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) abstractSprite).m1174s(), true, false, false);
                    } else if (abstractSprite instanceof C1063s) {
                        this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) abstractSprite).m1597d(), true, false, false);
                    }
                }
            } else if (first instanceof C1019be) {
                AbstractSprite abstractSprite2 = ((C1019be) first).f1558a;
                if (this.mOnSpriteChangeListener != null) {
                    if (abstractSprite2 instanceof C0989ab) {
                        this.mOnSpriteChangeListener.onObjectInserted(((C0989ab) abstractSprite2).m1262c(), true, false);
                    } else if (abstractSprite2 instanceof TextSprite) {
                        this.mOnSpriteChangeListener.onObjectInserted(((TextSprite) abstractSprite2).m1203j(), true, false);
                    } else if (abstractSprite2 instanceof StrokeSprite) {
                        this.mOnSpriteChangeListener.onObjectInserted(((StrokeSprite) abstractSprite2).m1174s(), true, false);
                    } else if (abstractSprite2 instanceof C1063s) {
                        this.mOnSpriteChangeListener.onObjectInserted(((C1063s) abstractSprite2).m1597d(), true, false);
                    }
                }
            } else if (first instanceof C1018bd) {
                this.mOnSpriteChangeListener.onMultiClearAll(true);
                if (zE) {
                    synchronized (sprites1) {
                        if (this.f837a != null) {
                            Iterator<AbstractSprite> it = this.f837a.iterator();
                            while (it.hasNext()) {
                                AbstractSprite next = it.next();
                                if (next instanceof C0989ab) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((C0989ab) next).m1262c(), true, false);
                                } else if (next instanceof TextSprite) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((TextSprite) next).m1203j(), true, false);
                                } else if (next instanceof StrokeSprite) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((StrokeSprite) next).m1174s(), true, false);
                                } else if (next instanceof C1063s) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((C1063s) next).m1597d(), true, false);
                                }
                            }
                        }
                    }
                } else {
                    synchronized (sprites2) {
                        if (this.f838b != null) {
                            Iterator<AbstractSprite> it2 = this.f838b.iterator();
                            while (it2.hasNext()) {
                                AbstractSprite next2 = it2.next();
                                if (next2 instanceof C0989ab) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((C0989ab) next2).m1262c(), true, false);
                                } else if (next2 instanceof TextSprite) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((TextSprite) next2).m1203j(), true, false);
                                } else if (next2 instanceof StrokeSprite) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((StrokeSprite) next2).m1174s(), true, false);
                                } else if (next2 instanceof C1063s) {
                                    this.mOnSpriteChangeListener.onObjectInserted(((C1063s) next2).m1597d(), true, false);
                                }
                            }
                        }
                    }
                }
            } else if ((first instanceof C1021bg) || (first instanceof C1023bi) || (first instanceof C1022bh)) {
                if (first instanceof C1021bg) {
                    AbstractSprite abstractSprite3 = ((C1021bg) first).f1560a;
                    if (this.mOnSpriteChangeListener != null && (abstractSprite3 instanceof C0989ab)) {
                        this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) abstractSprite3).m1262c(), true, false);
                    }
                } else if (first instanceof C1023bi) {
                    AbstractSprite abstractSprite4 = ((C1023bi) first).f1570a;
                    if (this.mOnSpriteChangeListener != null && (abstractSprite4 instanceof C0989ab)) {
                        this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) abstractSprite4).m1262c(), true, false);
                    }
                } else if (first instanceof C1022bh) {
                    AbstractSprite abstractSprite5 = ((C1022bh) first).f1564a;
                    if (this.mOnSpriteChangeListener != null && (abstractSprite5 instanceof C0989ab)) {
                        this.mOnSpriteChangeListener.onObjectChanged(((C0989ab) abstractSprite5).m1262c(), true, false);
                    }
                }
            } else if (first instanceof C1039by) {
                TextSprite textSprite = ((C1039by) first).f1669k;
                if (this.mOnSpriteChangeListener != null) {
                    this.mOnSpriteChangeListener.onObjectChanged(textSprite.m1203j(), true, false);
                }
            } else if (first instanceof C0990ac) {
                C0989ab c0989ab = ((C0990ac) first).f1432a;
                if (this.mOnSpriteChangeListener != null) {
                    this.mOnSpriteChangeListener.onObjectChanged(c0989ab.m1262c(), false, true);
                }
            }
            return rectFUndo;
        }
        return super.undo(userId);
    }

    public void setSpriteChangeListener(OnSpriteChangeListener listener) {
        this.mOnSpriteChangeListener = listener;
    }

    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (sprites1) {
            zIsEmpty = this.f837a.isEmpty();
        }
        return zIsEmpty;
    }

    public boolean isEmpty(int layerID) {
        boolean zIsEmpty;
        if (layerID == 0) {
            synchronized (sprites1) {
                zIsEmpty = this.f837a.isEmpty();
            }
        } else {
            synchronized (sprites2) {
                zIsEmpty = this.f838b.isEmpty();
            }
        }
        return zIsEmpty;
    }

    public void callonObjectDeleted() {
        callonObjectDeleted(getSelectedLayerID());
    }

    public void callonObjectDeleted(int layerID) {
        if (layerID == 0) {
            if (checkHistoryContainKey(this.context.setting.getUserID(), true, true)) {
                Iterator<SpriteCommand> it = this.f840d.get(Integer.valueOf(this.context.setting.getUserID())).iterator();
                while (it.hasNext()) {
                    SpriteCommand next = it.next();
                    if (next instanceof SpriteCreateCommand) {
                        AbstractSprite abstractSprite = ((SpriteCreateCommand) next).sprite;
                        if (this.mOnSpriteChangeListener != null) {
                            if (abstractSprite instanceof C0989ab) {
                                this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) abstractSprite).m1262c(), false, false, true);
                            } else if (abstractSprite instanceof TextSprite) {
                                this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) abstractSprite).m1203j(), false, false, true);
                            } else if (abstractSprite instanceof StrokeSprite) {
                                this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) abstractSprite).m1174s(), false, false, true);
                            } else if (abstractSprite instanceof C1063s) {
                                this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) abstractSprite).m1597d(), false, false, true);
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        if (checkHistoryContainKey(this.context.setting.getUserID(), false, true)) {
            Iterator<SpriteCommand> it2 = this.f842f.get(Integer.valueOf(this.context.setting.getUserID())).iterator();
            while (it2.hasNext()) {
                SpriteCommand next2 = it2.next();
                if (next2 instanceof SpriteCreateCommand) {
                    AbstractSprite abstractSprite2 = ((SpriteCreateCommand) next2).sprite;
                    if (this.mOnSpriteChangeListener != null) {
                        if (abstractSprite2 instanceof C0989ab) {
                            this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) abstractSprite2).m1262c(), false, false, true);
                        } else if (abstractSprite2 instanceof TextSprite) {
                            this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) abstractSprite2).m1203j(), false, false, true);
                        } else if (abstractSprite2 instanceof StrokeSprite) {
                            this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) abstractSprite2).m1174s(), false, false, true);
                        }
                    }
                }
            }
        }
    }

    public void deleteSprite(AbstractSprite sprite) {
        if (this.mOnSpriteChangeListener != null) {
            if (sprite instanceof C0989ab) {
                this.mOnSpriteChangeListener.onObjectDeleted(((C0989ab) sprite).m1262c(), false, false, false);
            } else if (sprite instanceof TextSprite) {
                this.mOnSpriteChangeListener.onObjectDeleted(((TextSprite) sprite).m1203j(), false, false, false);
            } else if (sprite instanceof StrokeSprite) {
                this.mOnSpriteChangeListener.onObjectDeleted(((StrokeSprite) sprite).m1174s(), false, false, false);
            } else if (sprite instanceof C1063s) {
                this.mOnSpriteChangeListener.onObjectDeleted(((C1063s) sprite).m1597d(), false, false, false);
            }
        }
        this.f1308n.remove(sprite);
        this.f1309o.remove(sprite);
        if (sprite.isPublicLayer()) {
            this.f838b.remove(sprite);
        } else {
            this.f837a.remove(sprite);
        }
        sprite.dispose();
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void cleanUpObjectLayer() {
        if (this.listOfLayers != null) {
            this.listOfLayers.get(2).m1014b();
            this.listOfLayers.get(4).m1014b();
        }
        if (this.f837a != null) {
            for (int size = this.f837a.size() - 1; size >= 0; size--) {
                AbstractSprite abstractSprite = this.f837a.get(size);
                if ((abstractSprite instanceof TextSprite) || (abstractSprite instanceof C0989ab)) {
                    deleteSprite(abstractSprite);
                }
            }
        }
        if (this.f838b != null) {
            for (int size2 = this.f838b.size() - 1; size2 >= 0; size2--) {
                AbstractSprite abstractSprite2 = this.f838b.get(size2);
                if ((abstractSprite2 instanceof TextSprite) || (abstractSprite2 instanceof C0989ab)) {
                    deleteSprite(abstractSprite2);
                }
            }
        }
        int userID = this.context.setting.getUserID();
        if (checkHistoryContainKey(userID, true, false)) {
            LinkedList<SpriteCommand> linkedList = this.f839c.get(Integer.valueOf(userID));
            for (int size3 = linkedList.size() - 1; size3 >= 0; size3--) {
                SpriteCommand spriteCommand = linkedList.get(size3);
                if ((spriteCommand instanceof SpriteCreateCommand) || (spriteCommand instanceof C1019be)) {
                    if ((((SpriteCreateCommand) spriteCommand).sprite instanceof TextSprite) || (((SpriteCreateCommand) spriteCommand).sprite instanceof C0989ab)) {
                        linkedList.remove(spriteCommand);
                    }
                } else {
                    linkedList.remove(spriteCommand);
                }
            }
        }
        if (checkHistoryContainKey(userID, false, false)) {
            LinkedList<SpriteCommand> linkedList2 = this.f841e.get(Integer.valueOf(userID));
            for (int size4 = linkedList2.size() - 1; size4 >= 0; size4--) {
                SpriteCommand spriteCommand2 = linkedList2.get(size4);
                if ((spriteCommand2 instanceof SpriteCreateCommand) || (spriteCommand2 instanceof C1019be)) {
                    if ((((SpriteCreateCommand) spriteCommand2).sprite instanceof TextSprite) || (((SpriteCreateCommand) spriteCommand2).sprite instanceof C0989ab)) {
                        linkedList2.remove(spriteCommand2);
                    }
                } else {
                    linkedList2.remove(spriteCommand2);
                }
            }
        }
        if (checkHistoryContainKey(userID, true, true)) {
            LinkedList<SpriteCommand> linkedList3 = this.f840d.get(Integer.valueOf(userID));
            for (int size5 = linkedList3.size() - 1; size5 >= 0; size5--) {
                SpriteCommand spriteCommand3 = linkedList3.get(size5);
                if ((spriteCommand3 instanceof SpriteCreateCommand) || (spriteCommand3 instanceof C1019be)) {
                    if ((((SpriteCreateCommand) spriteCommand3).sprite instanceof TextSprite) || (((SpriteCreateCommand) spriteCommand3).sprite instanceof C0989ab)) {
                        linkedList3.remove(spriteCommand3);
                    }
                } else {
                    linkedList3.remove(spriteCommand3);
                }
            }
        }
        if (checkHistoryContainKey(userID, false, true)) {
            LinkedList<SpriteCommand> linkedList4 = this.f842f.get(Integer.valueOf(userID));
            for (int size6 = linkedList4.size() - 1; size6 >= 0; size6--) {
                SpriteCommand spriteCommand4 = linkedList4.get(size6);
                if ((spriteCommand4 instanceof SpriteCreateCommand) || (spriteCommand4 instanceof C1019be)) {
                    if ((((SpriteCreateCommand) spriteCommand4).sprite instanceof TextSprite) || (((SpriteCreateCommand) spriteCommand4).sprite instanceof C0989ab)) {
                        linkedList4.remove(spriteCommand4);
                    }
                } else {
                    linkedList4.remove(spriteCommand4);
                }
            }
        }
    }

    @Override // com.samsung.sdraw.AbstractStage
    public int selectFluidLayer(int widthOfLayers, int heightOfLayers) {
        int size = this.listOfLayers.size();
        for (int i = 5; i < size; i++) {
            Bitmap bitmap = this.listOfLayers.get(i).f1062b;
            if (bitmap.getWidth() == 1 && bitmap.getHeight() == 1) {
                m816a(i, widthOfLayers, heightOfLayers);
                return i;
            }
        }
        this.listOfLayers.add(new Layer(widthOfLayers, heightOfLayers));
        setPanning(size, getPanning(1));
        m815a(size, m832d(1));
        return size;
    }

    @Override // com.samsung.sdraw.AbstractStage
    public void renderAllSprites(boolean isAll, int fluidLayerId) {
        LinkedList<AbstractSprite> linkedListM812a = this.context.stage.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.context.stage.m827b(StrokeSprite.class, C1063s.class);
        if (this.context.setting != null && this.context.setting.m1121l()) {
            this.context.stage.clearLayers();
            if (((Stage) this.context.stage).f845i != null && this.context.stage.layerIsVisible(0)) {
                this.context.stage.m830c(0).drawBitmap(this.context.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
            if (linkedListM812a != null) {
                this.context.stage.m817a(0, linkedListM812a);
            }
            if (((Stage) this.context.stage).fixedSprites2 != null && this.context.stage.layerIsVisible(3)) {
                this.context.stage.m830c(3).drawBitmap(this.context.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
            if (linkedListM827b != null) {
                this.context.stage.m817a(3, linkedListM827b);
            }
        } else {
            LinkedList<AbstractSprite> linkedListM811a = this.context.stage.m811a(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM826b = this.context.stage.m826b(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.context.stage.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.context.stage.m826b(TextSprite.class);
            if (isAll) {
                this.context.stage.clearLayers();
                this.context.stage.renderFixedSprites(0);
            } else {
                this.context.stage.drawBackgroundTheme();
                this.context.stage.clearLayer(4);
            }
            if (linkedListM811a != null) {
                this.context.stage.m817a(2, linkedListM811a);
            }
            if (linkedListM811a2 != null) {
                this.context.stage.m817a(2, linkedListM811a2);
            }
            if (isAll && linkedListM812a != null) {
                this.context.stage.m817a(0, linkedListM812a);
            }
            if (isAll) {
                this.context.stage.renderFixedSprites(3);
            }
            if (linkedListM826b != null) {
                this.context.stage.m817a(4, linkedListM826b);
            }
            if (linkedListM826b2 != null) {
                this.context.stage.m817a(4, linkedListM826b2);
            }
            if (isAll && linkedListM827b != null) {
                this.context.stage.m817a(3, linkedListM827b);
            }
        }
        if (isAll) {
            this.context.stage.clearLayer(fluidLayerId);
        }
        this.context.invalidate();
    }
}
