package com.samsung.android.sdk.pen.document;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import com.samsung.android.sdk.pen.util.SpenError;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class SpenPageDoc {
    public static final int BACKGROUND_IMAGE_MODE_CENTER = 0;
    public static final int BACKGROUND_IMAGE_MODE_FIT = 2;
    public static final int BACKGROUND_IMAGE_MODE_STRETCH = 1;
    public static final int BACKGROUND_IMAGE_MODE_TILE = 3;
    public static final int FIND_TYPE_ALL = 31;
    public static final int FIND_TYPE_CONTAINER = 8;
    public static final int FIND_TYPE_IMAGE = 4;
    public static final int FIND_TYPE_STROKE = 1;
    public static final int FIND_TYPE_TEXT_BOX = 2;
    public static final int HISTORY_MANAGER_MODE_MULTIPLE_VIEW = 1;
    public static final int HISTORY_MANAGER_MODE_SINGLE_VIEW = 0;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    private int mHandle = 0;

    public interface HistoryListener {
        void onCommit(SpenPageDoc spenPageDoc);

        void onRedoable(SpenPageDoc spenPageDoc, boolean z);

        void onUndoable(SpenPageDoc spenPageDoc, boolean z);
    }

    public static class HistoryUpdateInfo {
        public int layerId;
        public String redoFile;
        public String undoFile;
        public RectF updateRect;
    }

    public interface ObjectIndexMovedListener {
        void onObjectIndexMoved(SpenPageDoc spenPageDoc, SpenObjectBase spenObjectBase, int i);
    }

    public interface ObjectListener {
        public static final int TYPE_REDO = 2;
        public static final int TYPE_SET = 0;
        public static final int TYPE_UNDO = 1;

        void onObjectAdded(SpenPageDoc spenPageDoc, ArrayList<SpenObjectBase> arrayList, int i);

        void onObjectChanged(SpenPageDoc spenPageDoc, SpenObjectBase spenObjectBase, int i);

        void onObjectRemoved(SpenPageDoc spenPageDoc, ArrayList<SpenObjectBase> arrayList, int i);
    }

    public interface ObjectSelectedListener {
        void onObjectSelected(SpenPageDoc spenPageDoc, ArrayList<SpenObjectBase> arrayList, boolean z);
    }

    private native ArrayList<Object> Native_command(int i, ArrayList<Object> arrayList);

    private native boolean PageDoc_AddTag(String str);

    private native boolean PageDoc_AppendLayer(int i);

    private native boolean PageDoc_AppendObject(SpenObjectBase spenObjectBase);

    private native void PageDoc_ClearChangedFlagOfLayer();

    private native boolean PageDoc_ClearRecordedObject();

    private native boolean PageDoc_Construct2(String str, SpenPageDoc spenPageDoc);

    private native boolean PageDoc_Copy(SpenPageDoc spenPageDoc);

    private native boolean PageDoc_EnableLayerEventForward(int i, boolean z);

    private native ArrayList<SpenObjectBase> PageDoc_FindObjectAtPosition(int i, float f, float f2);

    private native ArrayList<SpenObjectBase> PageDoc_FindObjectInClosedCurve(int i, PointF[] pointFArr, int i2);

    private native ArrayList<SpenObjectBase> PageDoc_FindObjectInRect(int i, RectF rectF, boolean z);

    private native SpenObjectBase PageDoc_FindTopObjectAtPosition(int i, float f, float f2);

    private native int PageDoc_GetBackgroundColor();

    private native Bitmap PageDoc_GetBackgroundImage();

    private native int PageDoc_GetBackgroundImageMode();

    private native String PageDoc_GetBackgroundImagePath();

    private native int PageDoc_GetCurrentLayerId();

    private native byte[] PageDoc_GetExtraDataByteArray(String str);

    private native int PageDoc_GetExtraDataInt(String str);

    private native String PageDoc_GetExtraDataString(String str);

    private native String[] PageDoc_GetExtraDataStringArray(String str);

    private native double PageDoc_GetGeoTagLatitude();

    private native double PageDoc_GetGeoTagLongitude();

    private native int PageDoc_GetHeight();

    private native ArrayList<RectF> PageDoc_GetHistoryUpdateRect();

    private native String PageDoc_GetId();

    private native long PageDoc_GetLastEditedTime();

    private native int PageDoc_GetLayerCount();

    private native int PageDoc_GetLayerHistoryId(int i);

    private native int PageDoc_GetLayerIdByIndex(int i);

    private native int PageDoc_GetLayerIndex(int i);

    private native String PageDoc_GetLayerName(int i);

    private native SpenObjectBase PageDoc_GetObject(int i);

    private native SpenObjectBase PageDoc_GetObjectByRuntimeHandle(int i);

    private native int PageDoc_GetObjectCount(boolean z);

    private native int PageDoc_GetObjectIndex(SpenObjectBase spenObjectBase);

    private native ArrayList<SpenObjectBase> PageDoc_GetObjectList();

    private native ArrayList<SpenObjectBase> PageDoc_GetObjectList2(int i);

    private native ArrayList<SpenObjectBase> PageDoc_GetObjectList3(int i, String str, int i2);

    private native ArrayList<SpenObjectBase> PageDoc_GetObjectList4(int i, String str, String str2);

    private native int PageDoc_GetOrientation();

    private native RectF PageDoc_GetRectOfAllObject();

    private native ArrayList<SpenObjectBase> PageDoc_GetSelectedObject();

    private native int PageDoc_GetSelectedObjectCount();

    private native ArrayList<String> PageDoc_GetTag();

    private native ArrayList<SpenObjectBase> PageDoc_GetTemplateObjectList();

    private native String PageDoc_GetTemplateUri();

    private native Bitmap PageDoc_GetThumbnail();

    private native String PageDoc_GetVoiceData();

    private native int PageDoc_GetWidth();

    private native SpenObjectContainer PageDoc_GroupObject(ArrayList<SpenObjectBase> arrayList, boolean z);

    private native SpenObjectContainer PageDoc_GroupSelectedObject(boolean z);

    private native boolean PageDoc_HasExtraDataByteArray(String str);

    private native boolean PageDoc_HasExtraDataInt(String str);

    private native boolean PageDoc_HasExtraDataString(String str);

    private native boolean PageDoc_HasExtraDataStringArray(String str);

    private native boolean PageDoc_HasRecordedObject();

    private native boolean PageDoc_InsertLayer(int i, int i2);

    private native boolean PageDoc_InsertObject(SpenObjectBase spenObjectBase, int i);

    private native boolean PageDoc_IsChanged();

    private native boolean PageDoc_IsHistoryManagerUsed();

    private native boolean PageDoc_IsLayerChanged();

    private native boolean PageDoc_IsLayerEventForwardable(int i);

    private native boolean PageDoc_IsObjectLoaded();

    private native boolean PageDoc_IsRecording();

    private native boolean PageDoc_IsTextOnly();

    private native boolean PageDoc_IsValid();

    private native boolean PageDoc_LoadHeader(String str);

    private native boolean PageDoc_LoadObject();

    private native boolean PageDoc_MoveLayerIndex(int i, int i2);

    private native boolean PageDoc_MoveObjectIndex(SpenObjectBase spenObjectBase, int i, boolean z);

    private native boolean PageDoc_RemoveAllObject();

    private native boolean PageDoc_RemoveExtraDataByteArray(String str);

    private native boolean PageDoc_RemoveExtraDataInt(String str);

    private native boolean PageDoc_RemoveExtraDataString(String str);

    private native boolean PageDoc_RemoveExtraDataStringArray(String str);

    private native boolean PageDoc_RemoveLayer(int i);

    private native boolean PageDoc_RemoveObject(SpenObjectBase spenObjectBase);

    private native boolean PageDoc_RemoveSelectedObject();

    private native boolean PageDoc_RemoveTag(String str);

    private native boolean PageDoc_Save();

    private native boolean PageDoc_SelectObject(SpenObjectBase spenObjectBase);

    private native boolean PageDoc_SelectObject(ArrayList<SpenObjectBase> arrayList);

    private native boolean PageDoc_SetBackgroundColor(int i);

    private native boolean PageDoc_SetBackgroundImage(String str);

    private native boolean PageDoc_SetBackgroundImageMode(int i);

    private native boolean PageDoc_SetCurrentLayer(int i);

    private native boolean PageDoc_SetExtraDataByteArray(String str, byte[] bArr, int i);

    private native boolean PageDoc_SetExtraDataInt(String str, int i);

    private native boolean PageDoc_SetExtraDataString(String str, String str2);

    private native boolean PageDoc_SetExtraDataStringArray(String str, String[] strArr, int i);

    private native boolean PageDoc_SetGeoTag(double d, double d2);

    private native boolean PageDoc_SetLayerName(int i, String str);

    private native boolean PageDoc_SetObjectIndexMovedListener(ObjectIndexMovedListener objectIndexMovedListener);

    private native boolean PageDoc_SetObjectListener(ObjectListener objectListener);

    private native boolean PageDoc_SetObjectSelectedListener(ObjectSelectedListener objectSelectedListener);

    private native boolean PageDoc_SetTemplateUri(String str);

    private native boolean PageDoc_SetThumbnail(Bitmap bitmap);

    private native void PageDoc_SetVoiceData(String str);

    private native boolean PageDoc_SetVolatileBackgroundImage(Bitmap bitmap);

    private native boolean PageDoc_StartRecord();

    private native boolean PageDoc_StopRecord();

    private native boolean PageDoc_UngroupObject(SpenObjectContainer spenObjectContainer, boolean z);

    private native boolean PageDoc_UngroupSelectedObject(boolean z);

    private native boolean PageDoc_UnloadObject();

    private native void PageDoc_UseHistoryManager(boolean z);

    private native void PageDoc_clearHistory();

    private native void PageDoc_clearHistory2(int i);

    private native boolean PageDoc_clearHistoryTag();

    private native void PageDoc_clearRedoHistory();

    private native boolean PageDoc_commitHistory(HistoryUpdateInfo historyUpdateInfo);

    private native void PageDoc_finalize();

    private native int PageDoc_getHistoryManagerMode();

    private native int PageDoc_getLastHistoryId();

    private native int PageDoc_getUndoLimit();

    private native boolean PageDoc_isRedoable();

    private native boolean PageDoc_isRedoable2(int i);

    private native boolean PageDoc_isUndoable();

    private native boolean PageDoc_isUndoable2(int i);

    private native HistoryUpdateInfo[] PageDoc_redo();

    private native HistoryUpdateInfo[] PageDoc_redo2(int i);

    private native HistoryUpdateInfo[] PageDoc_redoAll();

    private native HistoryUpdateInfo[] PageDoc_redoAll2(int i);

    private native boolean PageDoc_setHistoryId(int i);

    private native boolean PageDoc_setHistoryListener(HistoryListener historyListener);

    private native boolean PageDoc_setHistoryManagerMode(int i);

    private native boolean PageDoc_setHistoryTag();

    private native void PageDoc_setUndoLimit(int i);

    private native boolean PageDoc_startHistoryGroup();

    private native boolean PageDoc_stopHistoryGroup();

    private native HistoryUpdateInfo[] PageDoc_undo();

    private native HistoryUpdateInfo[] PageDoc_undo2(int i);

    private native HistoryUpdateInfo[] PageDoc_undoAll();

    private native HistoryUpdateInfo[] PageDoc_undoAll2(int i);

    private native HistoryUpdateInfo[] PageDoc_undoToTag();

    private SpenPageDoc() {
    }

    private SpenPageDoc(String templateUri, SpenPageDoc templatePage) {
        if (!PageDoc_Construct2(templateUri, templatePage)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenPageDoc(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }

    protected void finalize() {
        Native_command(0, null);
        PageDoc_finalize();
        this.mHandle = -1;
    }

    private static boolean isBuildTypeEngMode() {
        return "eng".equals(Build.TYPE);
    }

    public int getWidth() {
        return PageDoc_GetWidth();
    }

    public int getHeight() {
        return PageDoc_GetHeight();
    }

    public long getLastEditedTime() {
        return PageDoc_GetLastEditedTime();
    }

    public void appendObject(SpenObjectBase object) {
        if (!PageDoc_AppendObject(object)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void insertObject(SpenObjectBase object, int index) {
        if (!PageDoc_InsertObject(object, index)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeObject(SpenObjectBase object) {
        if (!PageDoc_RemoveObject(object)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeAllObject() {
        if (!PageDoc_RemoveAllObject()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeSelectedObject() {
        if (!PageDoc_RemoveSelectedObject()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenObjectBase getObject(int index) {
        SpenObjectBase object = PageDoc_GetObject(index);
        if (object == null) {
            throwUncheckedException(SpenError.getError());
        }
        return object;
    }

    public ArrayList<SpenObjectBase> getObjectList() {
        ArrayList<SpenObjectBase> list = PageDoc_GetObjectList();
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public ArrayList<SpenObjectBase> getObjectList(int typeFilter) {
        ArrayList<SpenObjectBase> list = PageDoc_GetObjectList2(typeFilter);
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public ArrayList<SpenObjectBase> getObjectList(int typeFilter, String extraKey, int extraValue) {
        ArrayList<SpenObjectBase> list = PageDoc_GetObjectList3(typeFilter, extraKey, extraValue);
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public ArrayList<SpenObjectBase> getObjectList(int typeFilter, String extraKey, String extraValue) {
        ArrayList<SpenObjectBase> list = PageDoc_GetObjectList4(typeFilter, extraKey, extraValue);
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public ArrayList<SpenObjectBase> getTemplateObjectList() {
        ArrayList<SpenObjectBase> list = PageDoc_GetTemplateObjectList();
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public int getObjectCount(boolean includeInvisible) {
        return PageDoc_GetObjectCount(includeInvisible);
    }

    public SpenObjectBase getObjectByRuntimeHandle(int runtimeHandle) {
        SpenObjectBase object = PageDoc_GetObjectByRuntimeHandle(runtimeHandle);
        if (object == null) {
            throwUncheckedException(SpenError.getError());
        }
        return object;
    }

    public int getObjectIndex(SpenObjectBase object) {
        int rnt = PageDoc_GetObjectIndex(object);
        if (rnt == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public boolean isObjectContained(SpenObjectBase object) {
        int rnt = PageDoc_GetObjectIndex(object);
        return rnt != -1;
    }

    public SpenObjectBase findTopObjectAtPosition(int typeFilter, float x, float y) {
        return PageDoc_FindTopObjectAtPosition(typeFilter, x, y);
    }

    public ArrayList<SpenObjectBase> findObjectAtPosition(int typeFilter, float x, float y) {
        ArrayList<SpenObjectBase> rnt = PageDoc_FindObjectAtPosition(typeFilter, x, y);
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public ArrayList<SpenObjectBase> findObjectInClosedCurve(int typeFilter, PointF[] points) {
        ArrayList<SpenObjectBase> rnt = PageDoc_FindObjectInClosedCurve(typeFilter, points, points.length);
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public ArrayList<SpenObjectBase> findObjectInRect(int typeFilter, RectF rectf, boolean allAreas) {
        ArrayList<SpenObjectBase> rnt = PageDoc_FindObjectInRect(typeFilter, rectf, allAreas);
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public void moveObjectIndex(SpenObjectBase object, int step, boolean ignoreInvisible) {
        boolean rnt = PageDoc_MoveObjectIndex(object, step, ignoreInvisible);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void selectObject(SpenObjectBase object) {
        boolean rnt = PageDoc_SelectObject(object);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void selectObject(ArrayList<SpenObjectBase> objectList) {
        boolean rnt = PageDoc_SelectObject(objectList);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public ArrayList<SpenObjectBase> getSelectedObject() {
        ArrayList<SpenObjectBase> list = PageDoc_GetSelectedObject();
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public int getSelectedObjectCount() {
        return PageDoc_GetSelectedObjectCount();
    }

    public SpenObjectContainer groupObject(ArrayList<SpenObjectBase> groupList, boolean selectAfterGroup) {
        SpenObjectContainer conatiner = PageDoc_GroupObject(groupList, selectAfterGroup);
        if (conatiner == null) {
            throwUncheckedException(SpenError.getError());
        }
        return conatiner;
    }

    public SpenObjectContainer groupSelectedObject(boolean selectAfterGroup) {
        SpenObjectContainer conatiner = PageDoc_GroupSelectedObject(selectAfterGroup);
        if (conatiner == null) {
            throwUncheckedException(SpenError.getError());
        }
        return conatiner;
    }

    public void ungroupObject(SpenObjectContainer group, boolean selectAfterUngroup) {
        boolean rnt = PageDoc_UngroupObject(group, selectAfterUngroup);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void ungroupSelectedObject(boolean selectAfterUngroup) {
        boolean rnt = PageDoc_UngroupSelectedObject(selectAfterUngroup);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void addTag(String tag) {
        boolean rnt = PageDoc_AddTag(tag);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeTag(String tag) {
        boolean rnt = PageDoc_RemoveTag(tag);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public ArrayList<String> getTag() {
        ArrayList<String> list = PageDoc_GetTag();
        if (list == null) {
            throwUncheckedException(SpenError.getError());
        }
        return list;
    }

    public boolean isTextOnly() {
        return PageDoc_IsTextOnly();
    }

    public boolean hasRecordedObject() {
        return PageDoc_HasRecordedObject();
    }

    public void clearRecordedObject() {
        boolean rnt = PageDoc_ClearRecordedObject();
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getOrientation() {
        int rnt = PageDoc_GetOrientation();
        if (rnt == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public void setVolatileBackgroundImage(Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("bitmap is recyled.");
        }
        boolean rnt = PageDoc_SetVolatileBackgroundImage(bitmap);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setBackgroundImage(String filePath) {
        boolean rnt = PageDoc_SetBackgroundImage(filePath);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public Bitmap getBackgroundImage() {
        return PageDoc_GetBackgroundImage();
    }

    public String getBackgroundImagePath() {
        return PageDoc_GetBackgroundImagePath();
    }

    public void setBackgroundImageMode(int mode) {
        boolean rnt = PageDoc_SetBackgroundImageMode(mode);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getBackgroundImageMode() {
        return PageDoc_GetBackgroundImageMode();
    }

    public void setBackgroundColor(int color) {
        boolean rnt = PageDoc_SetBackgroundColor(color);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getBackgroundColor() {
        return PageDoc_GetBackgroundColor();
    }

    public void setTemplateUri(String uri) {
        boolean rnt = PageDoc_SetTemplateUri(uri);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getTemplateUri() {
        return PageDoc_GetTemplateUri();
    }

    public String getId() {
        return PageDoc_GetId();
    }

    public RectF getDrawnRectOfAllObject() {
        return PageDoc_GetRectOfAllObject();
    }

    public boolean isChanged() {
        return PageDoc_IsChanged();
    }

    public void startRecord() {
        boolean rnt = PageDoc_StartRecord();
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void stopRecord() {
        boolean rnt = PageDoc_StopRecord();
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isRecording() {
        return PageDoc_IsRecording();
    }

    public void setGeoTag(double latitude, double longitude) {
        boolean rnt = PageDoc_SetGeoTag(latitude, longitude);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public double getGeoTagLatitude() {
        return PageDoc_GetGeoTagLatitude();
    }

    public double getGeoTagLongitude() {
        return PageDoc_GetGeoTagLongitude();
    }

    public void setExtraDataString(String key, String value) {
        boolean rnt = PageDoc_SetExtraDataString(key, value);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataStringArray(String key, String[] value) {
        boolean rnt;
        if (value == null) {
            rnt = PageDoc_SetExtraDataStringArray(key, value, 0);
        } else {
            rnt = PageDoc_SetExtraDataStringArray(key, value, value.length);
        }
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataByteArray(String key, byte[] value) {
        boolean rnt;
        if (value == null) {
            rnt = PageDoc_SetExtraDataByteArray(key, value, 0);
        } else {
            rnt = PageDoc_SetExtraDataByteArray(key, value, value.length);
        }
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataInt(String key, int value) {
        boolean rnt = PageDoc_SetExtraDataInt(key, value);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getExtraDataString(String key) {
        return PageDoc_GetExtraDataString(key);
    }

    public int getExtraDataInt(String key) {
        return PageDoc_GetExtraDataInt(key);
    }

    public String[] getExtraDataStringArray(String key) {
        return PageDoc_GetExtraDataStringArray(key);
    }

    public byte[] getExtraDataByteArray(String key) {
        return PageDoc_GetExtraDataByteArray(key);
    }

    public boolean hasExtraDataString(String key) {
        return PageDoc_HasExtraDataString(key);
    }

    public boolean hasExtraDataInt(String key) {
        return PageDoc_HasExtraDataInt(key);
    }

    public boolean hasExtraDataStringArray(String key) {
        return PageDoc_HasExtraDataStringArray(key);
    }

    public boolean hasExtraDataByteArray(String key) {
        return PageDoc_HasExtraDataByteArray(key);
    }

    public void removeExtraDataString(String key) {
        boolean rnt = PageDoc_RemoveExtraDataString(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeExtraDataInt(String key) {
        boolean rnt = PageDoc_RemoveExtraDataInt(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeExtraDataStringArray(String key) {
        boolean rnt = PageDoc_RemoveExtraDataStringArray(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeExtraDataByteArray(String key) {
        boolean rnt = PageDoc_RemoveExtraDataByteArray(key);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void save() throws IOException {
        boolean rnt = PageDoc_Save();
        if (!rnt) {
            SpenError.getError();
            throwUncheckedException(SpenError.getError());
        }
    }

    public void loadObject() throws IOException {
        boolean rnt = PageDoc_LoadObject();
        if (!rnt) {
            SpenError.getError();
            throwUncheckedException(SpenError.getError());
        }
    }

    public void unloadObject() throws IOException {
        boolean rnt = PageDoc_UnloadObject();
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isObjectLoaded() {
        return PageDoc_IsObjectLoaded();
    }

    public void appendLayer(int id) throws OutOfMemoryError {
        boolean rnt = PageDoc_AppendLayer(id);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void insertLayer(int id, int index) {
        boolean rnt = PageDoc_InsertLayer(id, index);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeLayer(int id) {
        boolean rnt = PageDoc_RemoveLayer(id);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setCurrentLayer(int id) {
        boolean rnt = PageDoc_SetCurrentLayer(id);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getCurrentLayerId() {
        return PageDoc_GetCurrentLayerId();
    }

    public int getLayerIndex(int id) {
        int rnt = PageDoc_GetLayerIndex(id);
        if (rnt == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public int getLayerIdByIndex(int index) {
        int rnt = PageDoc_GetLayerIdByIndex(index);
        if (rnt == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public int getLayerCount() {
        return PageDoc_GetLayerCount();
    }

    public void setLayerName(int id, String name) {
        boolean rnt = PageDoc_SetLayerName(id, name);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getLayerName(int id) {
        int index = PageDoc_GetLayerIndex(id);
        if (index == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return PageDoc_GetLayerName(id);
    }

    public void setLayerEventForwardEnabled(int id, boolean enable) {
        boolean rnt = PageDoc_EnableLayerEventForward(id, enable);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isLayerEventForwardEnabled(int id) {
        int index = PageDoc_GetLayerIndex(id);
        if (index == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return PageDoc_IsLayerEventForwardable(id);
    }

    public boolean isLayerChanged() {
        return PageDoc_IsLayerChanged();
    }

    public void clearChangedFlagOfLayer() {
        PageDoc_ClearChangedFlagOfLayer();
    }

    public void setObjectListener(ObjectListener listener) {
        boolean rnt = PageDoc_SetObjectListener(listener);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setObjectSelectedListener(ObjectSelectedListener listener) {
        boolean rnt = PageDoc_SetObjectSelectedListener(listener);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setObjectIndexMovedListener(ObjectIndexMovedListener listener) {
        boolean rnt = PageDoc_SetObjectIndexMovedListener(listener);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void copy(SpenPageDoc sourcePage) {
        boolean rnt = PageDoc_Copy(sourcePage);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public boolean isUndoable() {
        return PageDoc_isUndoable();
    }

    public boolean isRedoable() {
        return PageDoc_isRedoable();
    }

    public boolean isUndoable(int userId) {
        return PageDoc_isUndoable2(userId);
    }

    public boolean isRedoable(int userId) {
        return PageDoc_isRedoable2(userId);
    }

    public HistoryUpdateInfo[] undo() {
        HistoryUpdateInfo[] rnt = PageDoc_undo();
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] redo() {
        HistoryUpdateInfo[] rnt = PageDoc_redo();
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] undo(int userId) {
        HistoryUpdateInfo[] rnt = PageDoc_undo2(userId);
        if (rnt == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] redo(int userId) {
        HistoryUpdateInfo[] rnt = PageDoc_redo2(userId);
        if (rnt == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] undoAll() {
        HistoryUpdateInfo[] rnt = PageDoc_undoAll();
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] redoAll() {
        HistoryUpdateInfo[] rnt = PageDoc_redoAll();
        if (rnt == null) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] undoAll(int userId) {
        HistoryUpdateInfo[] rnt = PageDoc_undoAll2(userId);
        if (rnt == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public HistoryUpdateInfo[] redoAll(int userId) {
        HistoryUpdateInfo[] rnt = PageDoc_redoAll2(userId);
        if (rnt == null) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public void setUndoLimit(int undoLimit) {
        PageDoc_setUndoLimit(undoLimit);
    }

    public int getUndoLimit() {
        return PageDoc_getUndoLimit();
    }

    public void clearHistory() {
        PageDoc_clearHistory();
    }

    public void clearRedoHistory() {
        PageDoc_clearRedoHistory();
    }

    public void commitHistory(HistoryUpdateInfo userData) {
        boolean rnt = PageDoc_commitHistory(userData);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setHistoryListener(HistoryListener listener) {
        boolean rnt = PageDoc_setHistoryListener(listener);
        if (!rnt) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public ArrayList<RectF> getHistoryUpdateRect() {
        return PageDoc_GetHistoryUpdateRect();
    }

    public void setHistoryTag() {
        if (!PageDoc_setHistoryTag()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void clearHistoryTag() {
        if (!PageDoc_clearHistoryTag()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public HistoryUpdateInfo[] undoToTag() {
        HistoryUpdateInfo[] ret = PageDoc_undoToTag();
        if (ret == null) {
            throwUncheckedException(SpenError.getError());
        }
        return ret;
    }

    public void startHistoryGroup() {
        if (!PageDoc_startHistoryGroup()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void stopHistoryGroup() {
        if (!PageDoc_stopHistoryGroup()) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setHistoryManagerMode(int mode) {
        if (!PageDoc_setHistoryManagerMode(mode)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public int getHistoryManagerMode() {
        return PageDoc_getHistoryManagerMode();
    }

    public void setUserIdForHistoryListener(int userId) {
        Integer tempInteger = Integer.valueOf(userId);
        ArrayList<Object> tempArray = new ArrayList<>();
        tempArray.add(tempInteger);
        Native_command(1, tempArray);
    }

    public SpenObjectBase createObject(int type) {
        switch (type) {
            case 1:
                return new SpenObjectStroke("");
            case 2:
                return new SpenObjectTextBox("");
            case 3:
                SpenObjectImage i = new SpenObjectImage();
                i.setImage((String) null);
                return i;
            case 4:
                return new SpenObjectContainer((ArrayList<SpenObjectBase>) null);
            default:
                return null;
        }
    }

    public SpenObjectBase createObject(int type, boolean isTemplateObject) {
        switch (type) {
            case 1:
                return new SpenObjectStroke(isTemplateObject);
            case 2:
                return new SpenObjectTextBox(isTemplateObject);
            case 3:
                return new SpenObjectImage(isTemplateObject);
            case 4:
                return new SpenObjectContainer(isTemplateObject);
            default:
                return null;
        }
    }

    public boolean isValid() {
        return PageDoc_IsValid();
    }

    public boolean equals(Object o) {
        return (o instanceof SpenPageDoc) && this.mHandle == ((SpenPageDoc) o).mHandle;
    }

    public int hashCode() {
        return this.mHandle;
    }
}
