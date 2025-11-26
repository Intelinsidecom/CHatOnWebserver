package com.samsung.android.sdk.pen.document;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import com.samsung.android.sdk.pen.util.SpenError;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenNoteDoc {
    public static final int MODE_READ_ONLY = 0;
    public static final int MODE_WRITABLE = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;
    private Context mContext;
    private int mHandle;

    public static class AuthorInfo {
        public String email;
        public String imageUri;
        public String name;
        public String phoneNumber;
    }

    private native ArrayList<Object> Native_command(int i, ArrayList<Object> arrayList);

    private native SpenPageDoc NoteDoc_appendPage(int i, int i2);

    private native SpenPageDoc NoteDoc_appendPage(int i, String str, int i2);

    private native SpenPageDoc NoteDoc_appendTemplatePage(String str);

    private native boolean NoteDoc_attachFile(String str, String str2);

    private native boolean NoteDoc_attachToFile(String str);

    private native boolean NoteDoc_backupObjectList(ArrayList<SpenObjectBase> arrayList, String str);

    private native boolean NoteDoc_close(boolean z);

    private native boolean NoteDoc_detachFile(String str);

    private native boolean NoteDoc_discard();

    private native void NoteDoc_finalize();

    private native int NoteDoc_getAppMajorVersion();

    private native int NoteDoc_getAppMinorVersion();

    private native String NoteDoc_getAppName();

    private native String NoteDoc_getAppPatchName();

    private native String NoteDoc_getAttachedFile(String str);

    private native int NoteDoc_getAttachedFileCount();

    private native AuthorInfo NoteDoc_getAuthorInfo();

    private native String NoteDoc_getCoverImagePath();

    private native byte[] NoteDoc_getExtraDataByteArray(String str);

    private native int NoteDoc_getExtraDataInt(String str);

    private native String NoteDoc_getExtraDataString(String str);

    private native String[] NoteDoc_getExtraDataStringArray(String str);

    private native double NoteDoc_getGeoTagLatitude();

    private native double NoteDoc_getGeoTagLongitude();

    private native int NoteDoc_getHeight();

    private native String NoteDoc_getId();

    private native String NoteDoc_getInternalDirectory();

    private native int NoteDoc_getLastEditedPageIndex();

    private native int NoteDoc_getOrientation();

    private native int NoteDoc_getOrientation2(ByteArrayInputStream byteArrayInputStream);

    private native int NoteDoc_getOrientation3(FileDescriptor fileDescriptor);

    private native SpenPageDoc NoteDoc_getPage(int i);

    private native int NoteDoc_getPageCount();

    private native String NoteDoc_getPageIdByIndex(int i);

    private native int NoteDoc_getPageIndexById(String str);

    private native int NoteDoc_getRotation();

    private native String NoteDoc_getTemplateUri();

    private native int NoteDoc_getWidth();

    private native boolean NoteDoc_hasAttachedFile(String str);

    private native boolean NoteDoc_hasExtraDataByteArray(String str);

    private native boolean NoteDoc_hasExtraDataInt(String str);

    private native boolean NoteDoc_hasExtraDataString(String str);

    private native boolean NoteDoc_hasExtraDataStringArray(String str);

    private native boolean NoteDoc_hasTaggedPage();

    private native int NoteDoc_init(String str, int i, int i2, int i3);

    private native int NoteDoc_init(String str, ByteArrayInputStream byteArrayInputStream, int i, int i2);

    private native int NoteDoc_init(String str, ByteArrayInputStream byteArrayInputStream, String str2, int i, int i2);

    private native int NoteDoc_init(String str, FileDescriptor fileDescriptor, int i, int i2);

    private native int NoteDoc_init(String str, FileDescriptor fileDescriptor, String str2, int i, int i2);

    private native int NoteDoc_init(String str, String str2, String str3, double d, int i);

    private native int NoteDoc_init(String str, String str2, String str3, int i, int i2, boolean z);

    private native SpenPageDoc NoteDoc_insertPage(int i, int i2, int i3);

    private native SpenPageDoc NoteDoc_insertPage(int i, int i2, String str, int i3);

    private native SpenPageDoc NoteDoc_insertTemplatePage(int i, String str);

    private native boolean NoteDoc_isAllPageTextOnly();

    private native boolean NoteDoc_isChanged();

    private native boolean NoteDoc_movePageIndex(SpenPageDoc spenPageDoc, int i);

    private native boolean NoteDoc_removeExtraDataByteArray(String str);

    private native boolean NoteDoc_removeExtraDataInt(String str);

    private native boolean NoteDoc_removeExtraDataString(String str);

    private native boolean NoteDoc_removeExtraDataStringArray(String str);

    private native boolean NoteDoc_removePage(int i);

    private native boolean NoteDoc_requestSave(String str);

    private native ArrayList<SpenObjectBase> NoteDoc_restoreObjectList(String str);

    private native boolean NoteDoc_revertToTemplatePage(int i);

    private native boolean NoteDoc_save(ByteArrayOutputStream byteArrayOutputStream);

    private native boolean NoteDoc_save(FileDescriptor fileDescriptor);

    private native boolean NoteDoc_save(String str);

    private native boolean NoteDoc_setAppName(String str);

    private native boolean NoteDoc_setAppVersion(int i, int i2, String str);

    private native boolean NoteDoc_setAuthorInfo(AuthorInfo authorInfo);

    private native boolean NoteDoc_setCoverImage(String str);

    private native boolean NoteDoc_setExtraDataByteArray(String str, byte[] bArr, int i);

    private native boolean NoteDoc_setExtraDataInt(String str, int i);

    private native boolean NoteDoc_setExtraDataString(String str, String str2);

    private native boolean NoteDoc_setExtraDataStringArray(String str, String[] strArr, int i);

    private native boolean NoteDoc_setGeoTag(double d, double d2);

    private native boolean NoteDoc_setTemplateUri(String str);

    private SpenNoteDoc() {
        this.mHandle = 0;
        this.mContext = null;
    }

    public SpenNoteDoc(Context context, int width, int height) throws IOException {
        int rnt;
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        if (width > height) {
            rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), 1, width, height);
        } else {
            rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), 0, width, height);
        }
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    public SpenNoteDoc(Context context, int orientation, int width, int height) throws IOException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), orientation, width, height);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    private SpenNoteDoc(Context context, InputStream stream, int width, int mode) throws SpenInvalidPasswordException, IOException, SpenUnsupportedTypeException {
        int rnt;
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        if (stream instanceof ByteArrayInputStream) {
            rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), (ByteArrayInputStream) stream, width, mode);
        } else if (stream instanceof FileInputStream) {
            rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), ((FileInputStream) stream).getFD(), width, mode);
        } else {
            SpenError.ThrowUncheckedException(7, "The parameter 'stream' is unsupported type. This method supports only ByteArrayInputStream and FileInputStream");
            return;
        }
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    public SpenNoteDoc(Context context, String filePath, int width, int mode) throws SpenInvalidPasswordException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), filePath, null, width, mode, false);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    public SpenNoteDoc(Context context, String filePath, double rotation, int mode) throws SpenInvalidPasswordException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), filePath, (String) null, rotation, mode);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    public SpenNoteDoc(Context context, String filePath, String password, int width, int mode) throws SpenInvalidPasswordException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), filePath, password, width, mode, false);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    public SpenNoteDoc(Context context, String filePath, String password, double rotation, int mode) throws SpenInvalidPasswordException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), filePath, password, rotation, mode);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    public SpenNoteDoc(Context context, String filePath, int width, int mode, boolean discardUnsavedData) throws SpenInvalidPasswordException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), filePath, null, width, mode, discardUnsavedData);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    public SpenNoteDoc(Context context, String filePath, String password, int width, int mode, boolean discardUnsavedData) throws SpenInvalidPasswordException, SpenUnsupportedVersionException, IOException, SpenUnsupportedTypeException {
        this.mHandle = 0;
        this.mContext = null;
        this.mContext = context;
        int rnt = NoteDoc_init(context.getFilesDir().getAbsolutePath(), filePath, password, width, mode, discardUnsavedData);
        if (rnt == 0) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : It does not correspond to the NoteDoc file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
            }
        }
    }

    protected void finalize() throws Throwable {
        Native_command(0, null);
        try {
            NoteDoc_finalize();
            super.finalize();
            this.mHandle = -1;
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    private static boolean isBuildTypeEngMode() {
        return "eng".equals(Build.TYPE);
    }

    public void discard() throws IOException {
        if (this.mHandle >= 0) {
            if (!NoteDoc_discard()) {
                switch (SpenError.getError()) {
                    case 11:
                        throw new IOException();
                    case 19:
                        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                    default:
                        SpenError.ThrowUncheckedException(SpenError.getError());
                        break;
                }
            }
            this.mHandle = -1;
            this.mContext = null;
        }
    }

    public void close() throws IOException {
        if (this.mHandle >= 0) {
            if (!NoteDoc_close(false)) {
                switch (SpenError.getError()) {
                    case 11:
                        throw new IOException();
                    case 19:
                        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                    default:
                        SpenError.ThrowUncheckedException(SpenError.getError());
                        break;
                }
            }
            this.mHandle = -1;
            this.mContext = null;
        }
    }

    public String getId() {
        return NoteDoc_getId();
    }

    public void setTemplateUri(String templateUri) {
        if (!NoteDoc_setTemplateUri(templateUri)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getTemplateUri() {
        return NoteDoc_getTemplateUri();
    }

    public int getWidth() {
        return NoteDoc_getWidth();
    }

    public int getHeight() {
        return NoteDoc_getHeight();
    }

    public int getRotation() {
        return NoteDoc_getRotation();
    }

    public int getOrientation() {
        int rnt = NoteDoc_getOrientation();
        if (rnt == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return rnt;
    }

    public void setCoverImage(String filePath) {
        if (!NoteDoc_setCoverImage(filePath)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getCoverImagePath() {
        return NoteDoc_getCoverImagePath();
    }

    public boolean hasTaggedPage() {
        return NoteDoc_hasTaggedPage();
    }

    public boolean isAllPageTextOnly() {
        return NoteDoc_isAllPageTextOnly();
    }

    public void setAuthorInfo(AuthorInfo info) {
        if (!NoteDoc_setAuthorInfo(info)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public AuthorInfo getAuthorInfo() {
        return NoteDoc_getAuthorInfo();
    }

    public void setGeoTag(double latitude, double longitude) {
        if (!NoteDoc_setGeoTag(latitude, longitude)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public double getGeoTagLatitude() {
        return NoteDoc_getGeoTagLatitude();
    }

    public double getGeoTagLongitude() {
        return NoteDoc_getGeoTagLongitude();
    }

    public void setAppName(String name) {
        if (!NoteDoc_setAppName(name)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getAppName() {
        return NoteDoc_getAppName();
    }

    public void setAppVersion(int majorVersion, int minorVersion, String patchName) {
        if (!NoteDoc_setAppVersion(majorVersion, minorVersion, patchName)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getAppMajorVersion() {
        return NoteDoc_getAppMajorVersion();
    }

    public int getAppMinorVersion() {
        return NoteDoc_getAppMinorVersion();
    }

    public String getAppPatchName() {
        return NoteDoc_getAppPatchName();
    }

    public void setExtraDataString(String key, String value) {
        if (!NoteDoc_setExtraDataString(key, value)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataInt(String key, int value) {
        if (!NoteDoc_setExtraDataInt(key, value)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataStringArray(String key, String[] value) {
        if (value != null) {
            if (!NoteDoc_setExtraDataStringArray(key, value, value.length)) {
                throwUncheckedException(SpenError.getError());
            }
        } else if (!NoteDoc_setExtraDataStringArray(key, value, 0)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void setExtraDataByteArray(String key, byte[] value) {
        if (value != null) {
            if (!NoteDoc_setExtraDataByteArray(key, value, value.length)) {
                throwUncheckedException(SpenError.getError());
            }
        } else if (!NoteDoc_setExtraDataByteArray(key, value, 0)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getExtraDataString(String key) {
        return NoteDoc_getExtraDataString(key);
    }

    public int getExtraDataInt(String key) {
        return NoteDoc_getExtraDataInt(key);
    }

    public String[] getExtraDataStringArray(String key) {
        return NoteDoc_getExtraDataStringArray(key);
    }

    public byte[] getExtraDataByteArray(String key) {
        return NoteDoc_getExtraDataByteArray(key);
    }

    public boolean hasExtraDataString(String key) {
        return NoteDoc_hasExtraDataString(key);
    }

    public boolean hasExtraDataInt(String key) {
        return NoteDoc_hasExtraDataInt(key);
    }

    public boolean hasExtraDataStringArray(String key) {
        return NoteDoc_hasExtraDataStringArray(key);
    }

    public boolean hasExtraDataByteArray(String key) {
        return NoteDoc_hasExtraDataByteArray(key);
    }

    public void removeExtraDataString(String key) {
        if (!NoteDoc_removeExtraDataString(key)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeExtraDataInt(String key) {
        if (!NoteDoc_removeExtraDataInt(key)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeExtraDataStringArray(String key) {
        if (!NoteDoc_removeExtraDataStringArray(key)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void removeExtraDataByteArray(String key) {
        if (!NoteDoc_removeExtraDataByteArray(key)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public SpenPageDoc appendPage() {
        SpenPageDoc page = NoteDoc_appendPage(-1, null, 0);
        if (page == null) {
            throwUncheckedException(SpenError.getError());
        }
        return page;
    }

    public SpenPageDoc appendPage(int backgroundColor, String backgroundImagePath, int backgourndImageMode) {
        SpenPageDoc page = NoteDoc_appendPage(backgroundColor, backgroundImagePath, backgourndImageMode);
        if (page == null) {
            throwUncheckedException(SpenError.getError());
        }
        return page;
    }

    public SpenPageDoc insertPage(int pageIndex) {
        SpenPageDoc page = NoteDoc_insertPage(pageIndex, -1, null, 0);
        if (page == null) {
            throwUncheckedException(SpenError.getError());
        }
        return page;
    }

    public SpenPageDoc insertPage(int pageIndex, int backgroundColor, String backgroundImagePath, int backgourndImageMode) {
        SpenPageDoc page = NoteDoc_insertPage(pageIndex, backgroundColor, backgroundImagePath, backgourndImageMode);
        if (page == null) {
            throwUncheckedException(SpenError.getError());
        }
        return page;
    }

    public SpenPageDoc appendTemplatePage(String templatePath) throws IOException, SpenUnsupportedTypeException {
        File file = new File(templatePath);
        if (file.exists()) {
            SpenPageDoc page = NoteDoc_appendTemplatePage(templatePath);
            if (page == null) {
                switch (SpenError.getError()) {
                    case 11:
                        throw new IOException();
                    case 12:
                    default:
                        SpenError.ThrowUncheckedException(SpenError.getError());
                        return page;
                    case 13:
                        throw new SpenUnsupportedTypeException("It does not correspond to the NoteDoc file format");
                }
            }
            return page;
        }
        AssetManager assetMgr = this.mContext.getAssets();
        InputStream is = assetMgr.open(templatePath);
        int fileSize = is.available();
        byte[] tempData = new byte[fileSize];
        try {
            if (is.read(tempData, 0, tempData.length) != tempData.length) {
                is.close();
                throw new IOException("Failed to is.read()");
            }
            is.close();
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(tempData);
            SpenNoteDoc templateNote = new SpenNoteDoc(this.mContext, byteArrayIS, getWidth(), 0);
            if (getOrientation() != templateNote.getOrientation()) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(7, "The orientation of the template is not matched with this NoteDoc.");
            }
            SpenPageDoc templatePage = templateNote.getPage(0);
            if (templatePage == null) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(SpenError.getError());
                return null;
            }
            SpenPageDoc page2 = NoteDoc_appendPage(templatePage.getWidth(), templatePage.getHeight());
            if (page2 == null) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(SpenError.getError());
                return null;
            }
            page2.copy(templatePage);
            page2.setTemplateUri(templatePath);
            page2.clearChangedFlagOfLayer();
            byteArrayIS.close();
            templateNote.close();
            return page2;
        } catch (IOException e) {
            is.close();
            throw e;
        }
    }

    public SpenPageDoc insertTemplatePage(int pageIndex, String templatePath) throws IOException, SpenUnsupportedTypeException {
        File file = new File(templatePath);
        if (file.exists()) {
            SpenPageDoc page = NoteDoc_insertTemplatePage(pageIndex, templatePath);
            if (page == null) {
                switch (SpenError.getError()) {
                    case 11:
                        throw new IOException();
                    case 13:
                        throw new SpenUnsupportedTypeException("It does not correspond to the NoteDoc file format");
                    case 19:
                        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                    default:
                        SpenError.ThrowUncheckedException(SpenError.getError());
                        return page;
                }
            }
            return page;
        }
        AssetManager assetMgr = this.mContext.getAssets();
        InputStream is = assetMgr.open(templatePath);
        int fileSize = is.available();
        byte[] tempData = new byte[fileSize];
        try {
            if (is.read(tempData, 0, tempData.length) != tempData.length) {
                throw new IOException("Failed to is.read()");
            }
            is.close();
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(tempData);
            SpenNoteDoc templateNote = new SpenNoteDoc(this.mContext, byteArrayIS, getWidth(), 0);
            if (getOrientation() != templateNote.getOrientation()) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(7, "The orientation of the template is not matched with this NoteDoc.");
            }
            SpenPageDoc templatePage = templateNote.getPage(0);
            if (templatePage == null) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(SpenError.getError());
                return null;
            }
            SpenPageDoc page2 = NoteDoc_insertPage(pageIndex, templatePage.getWidth(), templatePage.getHeight());
            if (page2 == null) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(SpenError.getError());
                return null;
            }
            page2.copy(templatePage);
            page2.setTemplateUri(templatePath);
            page2.clearChangedFlagOfLayer();
            byteArrayIS.close();
            templateNote.close();
            return page2;
        } catch (Exception e) {
            is.close();
            return null;
        }
    }

    public void revertToTemplatePage(int pageIndex) throws IOException, SpenUnsupportedTypeException {
        SpenPageDoc page = getPage(pageIndex);
        String templatePath = page.getTemplateUri();
        if (templatePath == null) {
            page.removeAllObject();
            return;
        }
        File file = new File(templatePath);
        if (file.exists()) {
            boolean rnt = NoteDoc_revertToTemplatePage(pageIndex);
            if (!rnt) {
                switch (SpenError.getError()) {
                    case 11:
                        throw new IOException();
                    case 13:
                        throw new SpenUnsupportedTypeException("It does not correspond to the NoteDoc file format");
                    case 19:
                        throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                    default:
                        SpenError.ThrowUncheckedException(SpenError.getError());
                        return;
                }
            }
            return;
        }
        InputStream is = null;
        AssetManager assetMgr = this.mContext.getAssets();
        try {
            InputStream is2 = assetMgr.open(templatePath);
            int fileSize = is2.available();
            if (fileSize == 0) {
                is2.close();
                page.removeAllObject();
                return;
            }
            byte[] tempData = new byte[fileSize];
            if (is2.read(tempData, 0, tempData.length) != tempData.length) {
                is2.close();
                throw new IOException("Failed to is.read()");
            }
            is2.close();
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(tempData);
            SpenNoteDoc templateNote = new SpenNoteDoc(this.mContext, byteArrayIS, getWidth(), 0);
            if (getOrientation() != templateNote.getOrientation()) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(7, "The orientation of the template is not matched with this NoteDoc.");
            }
            page.removeAllObject();
            SpenPageDoc templatePage = templateNote.getPage(0);
            if (templatePage == null) {
                byteArrayIS.close();
                templateNote.close();
                SpenError.ThrowUncheckedException(SpenError.getError());
                return;
            }
            ArrayList<SpenObjectBase> list = templatePage.getObjectList();
            int count = list.size();
            for (int i = 0; i < count; i++) {
                SpenObjectBase temp = templatePage.getObject(i);
                SpenObjectBase object = page.createObject(temp.getType());
                if (object != null) {
                    object.copy(temp);
                    page.appendObject(object);
                }
            }
            byteArrayIS.close();
            templateNote.close();
        } catch (IOException e) {
            if (0 != 0) {
                is.close();
            }
            page.removeAllObject();
        }
    }

    public void revertToTemplatePage(int pageIndex, String absolutePath) throws IOException, SpenUnsupportedTypeException {
        SpenPageDoc page = getPage(pageIndex);
        page.removeAllObject();
        if (absolutePath != null) {
            File file = new File(absolutePath);
            if (file.exists()) {
                SpenNoteDoc templateNote = null;
                try {
                    templateNote = new SpenNoteDoc(this.mContext, absolutePath, getWidth(), 0);
                } catch (SpenInvalidPasswordException e) {
                    e.printStackTrace();
                } catch (SpenUnsupportedVersionException e2) {
                    e2.printStackTrace();
                }
                if (templateNote == null) {
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                if (getOrientation() != templateNote.getOrientation()) {
                    templateNote.close();
                    SpenError.ThrowUncheckedException(7, "The orientation of the template is not matched with this NoteDoc.");
                }
                SpenPageDoc templatePage = templateNote.getPage(0);
                if (templatePage == null) {
                    templateNote.close();
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                }
                ArrayList<SpenObjectBase> list = templatePage.getObjectList();
                int count = list.size();
                for (int i = 0; i < count; i++) {
                    SpenObjectBase temp = templatePage.getObject(i);
                    SpenObjectBase object = page.createObject(temp.getType());
                    if (object != null) {
                        object.copy(temp);
                        page.appendObject(object);
                    }
                }
                templateNote.close();
                return;
            }
            throw new IOException("The file does not exist.");
        }
    }

    public void removePage(int pageIndex) {
        if (!NoteDoc_removePage(pageIndex)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void movePageIndex(SpenPageDoc page, int step) {
        if (!NoteDoc_movePageIndex(page, step)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public String getPageIdByIndex(int pageIndex) {
        String id = NoteDoc_getPageIdByIndex(pageIndex);
        if (id == null) {
            throwUncheckedException(SpenError.getError());
        }
        return id;
    }

    public int getPageIndexById(String pageId) {
        int index = NoteDoc_getPageIndexById(pageId);
        if (index == -1) {
            throwUncheckedException(SpenError.getError());
        }
        return index;
    }

    public SpenPageDoc getPage(int pageIndex) {
        SpenPageDoc page = NoteDoc_getPage(pageIndex);
        if (page == null) {
            throwUncheckedException(SpenError.getError());
        }
        return page;
    }

    public int getPageCount() {
        Log.i("Model_SpenNoteDoc", "mHandle = " + this.mHandle);
        return NoteDoc_getPageCount();
    }

    public boolean isChanged() {
        return NoteDoc_isChanged();
    }

    public void attachFile(String key, String filePath) {
        if (!NoteDoc_attachFile(key, filePath)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public void detachFile(String key) {
        if (!NoteDoc_detachFile(key)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public int getAttachedFileCount() {
        return NoteDoc_getAttachedFileCount();
    }

    public String getAttachedFile(String key) {
        String filepath = NoteDoc_getAttachedFile(key);
        if (filepath == null) {
            throwUncheckedException(SpenError.getError());
        }
        return filepath;
    }

    public boolean hasAttachedFile(String key) {
        return NoteDoc_hasAttachedFile(key);
    }

    public void save(OutputStream stream) throws IOException {
        boolean rnt;
        if (stream instanceof ByteArrayOutputStream) {
            rnt = NoteDoc_save((ByteArrayOutputStream) stream);
        } else if (stream instanceof FileOutputStream) {
            rnt = NoteDoc_save(((FileOutputStream) stream).getFD());
        } else {
            SpenError.ThrowUncheckedException(7, "The parameter 'stream' is unsupported type. This method supports only ByteArrayOutputStream and FileOutputStream");
            return;
        }
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    public void save(String filepath) throws IOException {
        boolean rnt = NoteDoc_save(filepath);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    public void attachToFile(String filePath) throws IOException {
        boolean rnt = NoteDoc_attachToFile(filePath);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 19:
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    public String getInternalDirectory() {
        return NoteDoc_getInternalDirectory();
    }

    public int getLastEditedPageIndex() {
        return NoteDoc_getLastEditedPageIndex();
    }

    public void backupObjectList(ArrayList<SpenObjectBase> objectList, String filePath) {
        if (!NoteDoc_backupObjectList(objectList, filePath)) {
            throwUncheckedException(SpenError.getError());
        }
    }

    public ArrayList<SpenObjectBase> restoreObjectList(String filePath) {
        return NoteDoc_restoreObjectList(filePath);
    }

    public boolean equals(Object o) {
        return (o instanceof SpenNoteDoc) && this.mHandle == ((SpenNoteDoc) o).mHandle;
    }

    public int hashCode() {
        return this.mHandle;
    }

    private void throwUncheckedException(int errno) {
        if (errno == 19) {
            throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed");
        }
        SpenError.ThrowUncheckedException(errno);
    }
}
