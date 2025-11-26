package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenControlBase;
import com.samsung.android.sdk.pen.engine.SpenTextBox;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SpenControlList extends SpenControlBase {
    private static final boolean CONFIG_LIST_GROUP = true;
    int mFlipDirection;
    private Group mGroup;
    ArrayList<SpenObjectBase> mObjectList;
    private SpenControlBase.CoordinateInfo mTempCoordinateInfo;
    private final SpenTextBox.TextBoxActionListener mTextBoxActionListener;
    private ArrayList<SpenTextBox> mTextBoxList;

    private class ObjectGroup extends SpenObjectBase {
        private ArrayList<SpenObjectBase> mObjectList;
        private float mRotation;
        private final RectF mUnionRect;

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public int getType() {
            return 4;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setRecorded(boolean record) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isRecorded() {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setVisibility(boolean visible) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isVisible() {
            return true;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setOutOfViewEnabled(boolean enable) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isOutOfViewEnabled() {
            return true;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setSelectable(boolean enable) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isSelectable() {
            return true;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setMovable(boolean enable) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isMovable() {
            Iterator<SpenObjectBase> it = this.mObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectBase objectBase = it.next();
                if (!objectBase.isMovable()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setSorInfo(String info) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public String getSorInfo() {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setSorPackageLink(String link) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public String getSorPackageLink() {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setExtraDataString(String key, String value) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public String getExtraDataString(String key) {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setExtraDataInt(String key, int value) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public int getExtraDataInt(String key) {
            return -1;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setExtraDataStringArray(String key, String[] value) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public String[] getExtraDataStringArray(String key) {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setExtraDataByteArray(String key, byte[] value) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public byte[] getExtraDataByteArray(String key) {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean hasExtraDataString(String key) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean hasExtraDataInt(String key) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean hasExtraDataStringArray(String key) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean hasExtraDataByteArray(String key) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void removeExtraDataString(String key) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void removeExtraDataInt(String key) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void removeExtraDataStringArray(String key) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void removeExtraDataByteArray(String key) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setSorDataString(String key, String value) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public String getSorDataString(String key) {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setSorDataInt(String key, int value) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public int getSorDataInt(String key) {
            return -1;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean hasSorDataString(String key) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean hasSorDataInt(String key) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void removeSorDataString(String key) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void removeSorDataInt(String key) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void clearChangedFlag() {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isChanged() {
            return true;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public int getRuntimeHandle() {
            return -1;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public RectF getDrawnRect() {
            return null;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void copy(SpenObjectBase base) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean equals(Object o) {
            return false;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public int hashCode() {
            return -1;
        }

        public ObjectGroup() {
            super(4);
            this.mRotation = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            this.mObjectList = null;
            this.mUnionRect = new RectF();
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public float getRotation() {
            return this.mRotation;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setRotatable(boolean enable) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public boolean isRotatable() {
            for (int i = 0; i < this.mObjectList.size(); i++) {
                if (!this.mObjectList.get(i).isRotatable()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setResizeOption(int option) {
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public int getResizeOption() {
            boolean ratioResizeFlag = false;
            for (int i = 0; i < this.mObjectList.size(); i++) {
                int resizeOption = this.mObjectList.get(i).getResizeOption();
                if (resizeOption == 2) {
                    return 2;
                }
                if (resizeOption == 1) {
                    ratioResizeFlag = true;
                }
            }
            return ratioResizeFlag ? 1 : 0;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public RectF getRect() {
            this.mUnionRect.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            for (int i = 0; i < this.mObjectList.size(); i++) {
                RectF rec = this.mObjectList.get(i).getRect();
                if (rec != null) {
                    this.mUnionRect.union(rec);
                }
            }
            return this.mUnionRect;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setRect(RectF rect, boolean regionOnly) {
            if (rect.right != rect.left && rect.bottom != rect.top) {
                boolean flipHorizon = false;
                boolean flipVertical = false;
                RectF prevRect = getRect();
                prevRect.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                for (int i = 0; i < this.mObjectList.size(); i++) {
                    RectF rec = this.mObjectList.get(i).getRect();
                    if (rec != null) {
                        prevRect.union(rec);
                    }
                }
                if (rect.left > rect.right) {
                    float temp = rect.left;
                    rect.left = rect.right;
                    rect.right = temp;
                    flipHorizon = true;
                }
                if (rect.top > rect.bottom) {
                    float temp2 = rect.top;
                    rect.top = rect.bottom;
                    rect.bottom = temp2;
                    flipVertical = true;
                }
                if (prevRect.left != rect.left || prevRect.top != rect.top || prevRect.right != rect.right || prevRect.bottom != rect.bottom || flipHorizon || flipVertical) {
                    float rw = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    float rh = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    if (prevRect.right != prevRect.left) {
                        rw = (rect.right - rect.left) / (prevRect.right - prevRect.left);
                    }
                    if (prevRect.bottom != prevRect.top) {
                        rh = (rect.bottom - rect.top) / (prevRect.bottom - prevRect.top);
                    }
                    for (int i2 = 0; i2 < this.mObjectList.size(); i2++) {
                        SpenObjectBase object = this.mObjectList.get(i2);
                        RectF objectRect = object.getRect();
                        float x = objectRect.left - prevRect.left;
                        float y = objectRect.top - prevRect.top;
                        float w = objectRect.right - objectRect.left;
                        float h = objectRect.bottom - objectRect.top;
                        float x2 = x * rw;
                        float y2 = y * rh;
                        if (object.getResizeOption() != 2) {
                            w *= rw;
                            h *= rh;
                        }
                        if (flipHorizon) {
                            x2 = ((rect.right - rect.left) - x2) - w;
                        }
                        if (flipVertical) {
                            y2 = ((rect.bottom - rect.top) - y2) - h;
                        }
                        objectRect.left = rect.left + x2;
                        objectRect.top = rect.top + y2;
                        objectRect.right = objectRect.left + w;
                        objectRect.bottom = objectRect.top + h;
                        if (flipVertical) {
                            float temp3 = objectRect.bottom;
                            objectRect.bottom = objectRect.top;
                            objectRect.top = temp3;
                        }
                        if (flipHorizon) {
                            float temp4 = objectRect.right;
                            objectRect.right = objectRect.left;
                            objectRect.left = temp4;
                        }
                        object.setRect(objectRect, false);
                    }
                    this.mUnionRect.set(rect);
                }
            }
        }

        public void appendObject(ArrayList<SpenObjectBase> objectList) {
            this.mObjectList = objectList;
        }

        public ArrayList<SpenObjectBase> getObjectList() {
            return this.mObjectList;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public void setRotation(float degree) {
            if (this.mObjectList.size() > 0) {
                float curDegree = this.mRotation;
                float moveDegree = degree - curDegree;
                RectF containerRect = getRect();
                Iterator<SpenObjectBase> it = this.mObjectList.iterator();
                while (it.hasNext()) {
                    SpenObjectBase object = it.next();
                    RectF objectRect = object.getRect();
                    if (objectRect.left != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || objectRect.right != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || objectRect.top != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || objectRect.bottom != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        PointF rotPoint = SpenControlList.this.getRotatePoint((int) objectRect.centerX(), (int) objectRect.centerY(), (int) containerRect.centerX(), (int) containerRect.centerY(), moveDegree);
                        objectRect.offset(rotPoint.x - objectRect.centerX(), rotPoint.y - objectRect.centerY());
                        object.setRect(objectRect, false);
                    }
                    object.setRotation(object.getRotation() + moveDegree);
                }
                this.mRotation = degree;
            }
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public float getMinWidth() {
            float min = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            Iterator<SpenObjectBase> it = this.mObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectBase object = it.next();
                if (object.isVisible()) {
                    float curMin = object.getMinWidth();
                    if (min == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || min < curMin) {
                        min = curMin;
                    }
                }
            }
            return min;
        }

        @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
        public float getMinHeight() {
            float min = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            Iterator<SpenObjectBase> it = this.mObjectList.iterator();
            while (it.hasNext()) {
                SpenObjectBase object = it.next();
                if (object.isVisible()) {
                    float curMin = object.getMinHeight();
                    if (min == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || min < curMin) {
                        min = curMin;
                    }
                }
            }
            return min;
        }
    }

    private class Group {
        protected boolean mDirtyFlag;
        protected boolean mFlag = false;
        private final ObjectGroup mObject;

        Group() {
            this.mObject = SpenControlList.this.new ObjectGroup();
            reset();
        }

        void set(boolean groupFlag) {
            if (groupFlag != this.mFlag) {
                this.mFlag = groupFlag;
                this.mDirtyFlag = true;
            }
        }

        void reset() {
            this.mDirtyFlag = false;
        }
    }

    public SpenControlList(Context context, SpenPageDoc pageDoc) {
        super(context, pageDoc);
        this.mTextBoxActionListener = new SpenTextBox.TextBoxActionListener() { // from class: com.samsung.android.sdk.pen.engine.SpenControlList.1
            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onRequestScroll(float x, float y) {
                SpenControlList.this.onRequestScroll(x, y);
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onSettingTextInfoChanged(SpenSettingTextInfo info) {
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onObjectChanged(SpenObjectTextBox object) {
                if (SpenControlList.this.mListener != null) {
                    ArrayList<SpenObjectBase> objectList = new ArrayList<>();
                    objectList.add(object);
                    SpenControlList.this.mListener.onObjectChanged(objectList);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onExceedLimit() {
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public boolean onSelectionChanged(int selStart, int selEnd) {
                return true;
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onMoreButtonDown(SpenObjectTextBox object) {
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onRequestCoordinateInfo(SpenControlBase.CoordinateInfo coordinateInfo) {
                if (SpenControlList.this.mListener != null) {
                    SpenControlList.this.mListener.onRequestCoordinateInfo(coordinateInfo);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onUndo() {
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onVisibleUpdated(SpenObjectTextBox objectTextBox, boolean visible) {
                SpenControlList.this.onVisibleUpdated(objectTextBox, visible);
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenTextBox.TextBoxActionListener
            public void onFocusChanged(boolean gainFocus) {
            }
        };
        this.mTextBoxList = null;
        initialize();
    }

    private void initialize() {
        this.mFlipDirection = 0;
        this.mGroup = new Group();
        this.mGroup.set(true);
        this.mTextBoxList = new ArrayList<>();
        this.mTempCoordinateInfo = new SpenControlBase.CoordinateInfo();
    }

    public void setObject(ArrayList<SpenObjectBase> objectBaseList) {
        setObjectList(objectBaseList);
        this.mGroup.mObject.appendObject(objectBaseList);
    }

    public ArrayList<SpenObjectBase> getObject() {
        return super.getObjectList();
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public RectF getRect() {
        if (this.mGroup == null || !this.mGroup.mFlag || this.mGroup.mObject == null) {
            return super.getRect();
        }
        RectF rect = this.mGroup.mObject.getRect();
        RectF relativeRect = new RectF();
        this.mTempCoordinateInfo.reset();
        if (this.mListener != null) {
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
        }
        relativeCoordinate(relativeRect, rect, this.mTempCoordinateInfo);
        return relativeRect;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected void onFlip(int flipDirection, SpenObjectBase objectBase) {
        SpenSLog.m142w("");
        this.mFlipDirection ^= flipDirection;
        super.onFlip(flipDirection, objectBase);
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    protected void onObjectChanged() {
        this.mObjectList = getObject();
        super.onObjectChanged();
    }

    private void updateGroup() {
        if (this.mGroup.mDirtyFlag) {
            this.mGroup.reset();
            if (!this.mGroup.mFlag) {
                setObjectList(this.mGroup.mObject.getObjectList());
            } else {
                ArrayList<SpenObjectBase> objectList = new ArrayList<>();
                objectList.add(this.mGroup.mObject);
                this.mGroup.mObject.appendObject(super.getObjectList());
                setObjectList(objectList);
            }
            fit();
        }
    }

    private void drawListHighlight(Canvas canvas) {
        ArrayList<SpenObjectBase> objectList = this.mGroup.mObject.getObjectList();
        Iterator<SpenObjectBase> it = objectList.iterator();
        while (it.hasNext()) {
            SpenObjectBase objectBase = it.next();
            drawHighlightObject(canvas, objectBase);
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase, android.view.View
    public void onDraw(Canvas canvas) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        updateGroup();
        if (getStyle() != 3) {
            if (this.mGroup.mFlag) {
                drawListHighlight(canvas);
            }
            super.onDraw(canvas);
        }
    }

    public void setGroup(boolean groupFlag) {
        this.mGroup.set(groupFlag);
        this.mTouchState.reset();
    }

    public boolean isGroup() {
        return this.mGroup.mFlag;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public ArrayList<SpenObjectBase> getObjectList() {
        return this.mGroup.mFlag ? this.mGroup.mObject.getObjectList() : super.getObjectList();
    }

    protected void onVisibleUpdated(SpenObjectTextBox objectTextBox, boolean visible) {
        if (this.mListener != null) {
            ArrayList<SpenObjectBase> objectList = new ArrayList<>();
            objectList.add(objectTextBox);
            this.mListener.onVisibleUpdated(objectList, visible);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        if (getStyle() == 3) {
            setVisibility(4);
            Iterator<SpenObjectBase> it = getObjectList().iterator();
            while (it.hasNext()) {
                SpenObjectBase objectBase = it.next();
                if (objectBase.getType() == 2) {
                    SpenTextBox textBox = new SpenTextBox(getContext(), (ViewGroup) getParent(), this.mPageDoc.getWidth(), this.mPageDoc.getHeight());
                    textBox.setObjectText((SpenObjectTextBox) objectBase);
                    textBox.setTextBoxListener(this.mTextBoxActionListener);
                    textBox.setViewModeEnabled(true);
                    textBox.fit(true);
                    this.mTextBoxList.add(textBox);
                    textBox.invalidate();
                }
            }
        }
        super.onAttachedToWindow();
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public void close() {
        if (this.mTextBoxList != null) {
            Iterator<SpenTextBox> it = this.mTextBoxList.iterator();
            while (it.hasNext()) {
                SpenTextBox textBox = it.next();
                onVisibleUpdated(textBox.getObjectText(), true);
                textBox.close();
            }
            this.mTextBoxList.clear();
        }
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenControlBase
    public void fit() {
        super.fit();
        if (this.mTextBoxList != null) {
            Iterator<SpenTextBox> it = this.mTextBoxList.iterator();
            while (it.hasNext()) {
                SpenTextBox textBox = it.next();
                textBox.fit(true);
            }
        }
    }
}
