package com.samsung.android.sdk.pen.document;

import android.content.Context;
import android.os.Build;
import com.samsung.android.sdk.pen.util.SpenError;
import java.io.IOException;

/* loaded from: classes.dex */
public class SpenNoteFile {
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 0;

    private static native boolean NoteFile_copy(String str, String str2);

    private static native String NoteFile_getAppName(String str);

    private static native boolean NoteFile_getAppVersion(String str, Integer num, Integer num2, StringBuffer stringBuffer);

    private static native String NoteFile_getCoverImage(String str, String str2);

    private static native int NoteFile_getFormatVersion(String str);

    private static native int NoteFile_getOrientation(String str);

    private static native boolean NoteFile_getSize(String str, Integer num, Integer num2);

    private static native boolean NoteFile_hasUnsavedData(String str, String str2, Long l);

    private static native boolean NoteFile_isFavorite(String str);

    private static native boolean NoteFile_isLocked(String str);

    private static native boolean NoteFile_isValid(String str);

    private static native boolean NoteFile_lock(String str, String str2, String str3);

    private static native boolean NoteFile_removeNote(String str);

    private static native boolean NoteFile_setCoverImage(String str, String str2, String str3, String str4);

    private static native boolean NoteFile_setFavorite(String str, boolean z);

    private static native boolean NoteFile_unlock(String str, String str2, String str3);

    private SpenNoteFile() {
    }

    public static void lock(Context context, String filePath, String password) throws IOException, SpenUnsupportedTypeException {
        boolean rnt = NoteFile_lock(context.getFilesDir().getAbsolutePath(), filePath, password);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : [" + filePath + "] does not correspond to the SPD file format");
            }
        }
    }

    public static void unlock(Context context, String filePath, String password) throws SpenInvalidPasswordException, IOException, SpenUnsupportedTypeException {
        boolean rnt = NoteFile_unlock(context.getFilesDir().getAbsolutePath(), filePath, password);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : [" + filePath + "] does not correspond to the SPD file format");
                case 17:
                    throw new SpenInvalidPasswordException("E_INVALID_PASSWORD : the password is wrong");
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
            }
        }
    }

    public static boolean isLocked(String filePath) {
        return NoteFile_isLocked(filePath);
    }

    public static void copy(String destFilePath, String srcFilePath) throws IOException, SpenUnsupportedTypeException {
        boolean rnt = NoteFile_copy(destFilePath, srcFilePath);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : [" + srcFilePath + "] does not correspond to the SPD file format");
            }
        }
    }

    public static void setFavorite(String filePath, boolean flag) throws IOException, SpenUnsupportedTypeException {
        boolean rnt = NoteFile_setFavorite(filePath, flag);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : [" + filePath + "] does not correspond to the SPD file format");
            }
        }
    }

    public static boolean isFavorite(String filePath) {
        return NoteFile_isFavorite(filePath);
    }

    public static boolean isValid(String filePath) {
        return NoteFile_isValid(filePath);
    }

    public static void setCoverImage(Context context, String filePath, String password, String imageFilePath) throws IOException, SpenUnsupportedTypeException {
        boolean rnt = NoteFile_setCoverImage(context.getFilesDir().getAbsolutePath(), filePath, password, imageFilePath);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : [" + filePath + "] does not correspond to the SPD file format");
            }
        }
    }

    public static String getCoverImagePath(Context context, String filePath) {
        return NoteFile_getCoverImage(context.getFilesDir().getAbsolutePath(), filePath);
    }

    public static int getOrientation(String filePath) {
        return NoteFile_getOrientation(filePath);
    }

    public static boolean hasUnsavedData(Context context, String filePath, Long lastEditedTime) {
        return NoteFile_hasUnsavedData(context.getFilesDir().getAbsolutePath(), filePath, lastEditedTime);
    }

    public static void removeNote(String filePath) throws IOException, SpenUnsupportedTypeException {
        boolean rnt = NoteFile_removeNote(filePath);
        if (!rnt) {
            switch (SpenError.getError()) {
                case 11:
                    throw new IOException();
                case 12:
                default:
                    SpenError.ThrowUncheckedException(SpenError.getError());
                    return;
                case 13:
                    throw new SpenUnsupportedTypeException("E_UNSUPPORTED_TYPE : [" + filePath + "] does not correspond to the SPD file format");
            }
        }
    }

    public static void getSize(String filePath, Integer width, Integer height) {
        boolean rnt = NoteFile_getSize(filePath, width, height);
        if (!rnt) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public static String getAppName(String filePath) {
        return NoteFile_getAppName(filePath);
    }

    public static void getAppVersion(String filePath, Integer major, Integer minor, StringBuffer patchName) {
        boolean rnt = NoteFile_getAppVersion(filePath, major, minor, patchName);
        if (!rnt) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public static int getFormatVersion(String filePath) {
        return NoteFile_getFormatVersion(filePath);
    }

    private static boolean isBuildTypeEngMode() {
        return "eng".equals(Build.TYPE);
    }
}
