package com.sec.amsoma;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.MotionEventCompat;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OPTION;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.IntBuffer;

/* loaded from: classes.dex */
public class AMSLibs {
    public static final byte DEF_VIP_AMSLIB_BK_COLOR = 0;
    public static final byte DEF_VIP_AMSLIB_BK_INDEX_IMAGE = 2;
    public static final byte DEF_VIP_AMSLIB_BK_PATTERN = 1;
    public static final byte DEF_VIP_AMSLIB_BK_RAW_IMAGE = 4;
    public static final byte DEF_VIP_AMSLIB_BK_SCREEN_BUF = 5;
    public static final int DEF_VIP_AMS_ANIMATION_TURN_PAGE_EFFECT_BRIGHT_VAR = 3;
    public static final int DEF_VIP_AMS_ANIMATION_TURN_PAGE_EFFECT_SIDE_CURL = 1;
    public static final int DEF_VIP_AMS_ANIMATION_TURN_PAGE_EFFECT_SLIDE_MOVE = 2;
    public static final int DEF_VIP_AMS_ANIMATION_TURN_PAGE_NONE = 0;
    public static final int ENUM_VIP_AMS_AUDIO_BG_INDEX = 1;
    public static final int ENUM_VIP_AMS_AUDIO_BG_MP3 = 2;
    public static final int ENUM_VIP_AMS_AUDIO_BG_VOICE = 3;
    public static final int ENUM_VIP_AMS_AUDIO_NONE = 0;
    public static final byte ENUM_VIP_AMS_CB_ERROR_DISK_FULL = 44;
    public static final byte ENUM_VIP_AMS_CB_ERROR_DRAW = 48;
    public static final byte ENUM_VIP_AMS_CB_ERROR_FILE_OPEN = 41;
    public static final byte ENUM_VIP_AMS_CB_ERROR_FILE_READ = 42;
    public static final byte ENUM_VIP_AMS_CB_ERROR_FILE_WRITE = 43;
    public static final byte ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION = 49;
    public static final byte ENUM_VIP_AMS_CB_ERROR_JPEG_DECODING = 47;
    public static final byte ENUM_VIP_AMS_CB_ERROR_JPEG_ENCODING = 46;
    public static final byte ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION = 50;
    public static final byte ENUM_VIP_AMS_CB_ERROR_MEMORY_ALLOC = 45;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_CIRCLE = 1;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_CIRCLE_FILL = 4;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_LINE = 6;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_RECT = 0;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_RECT_FILL = 3;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_TRI = 2;
    public static final byte ENUM_VIP_AMS_DIAGRAMSTYLE_TRI_FILL = 5;
    public static final byte ENUM_VIP_AMS_DIAGRAM_OBJECT_NUM_FULL = 13;
    public static final byte ENUM_VIP_AMS_ERROR_CONVERT_IMAGEBUFFER = 18;
    public static final byte ENUM_VIP_AMS_ERROR_DATA_FULL = 9;
    public static final byte ENUM_VIP_AMS_ERROR_DECODE_BUFFER = 19;
    public static final byte ENUM_VIP_AMS_ERROR_DECODE_DATA = 21;
    public static final byte ENUM_VIP_AMS_ERROR_DECODE_EXIF = 22;
    public static final byte ENUM_VIP_AMS_ERROR_DECODE_HEADER = 20;
    public static final byte ENUM_VIP_AMS_ERROR_DECODE_IMAGE = 23;
    public static final byte ENUM_VIP_AMS_ERROR_DRAW = 34;
    public static final byte ENUM_VIP_AMS_ERROR_ENCODE_DATA = 36;
    public static final byte ENUM_VIP_AMS_ERROR_ENCODE_IMAGE = 16;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_APP_VERSION = 2;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_CLIP = 38;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_DRAWING_DATA = 29;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_FILEFORMAT = 3;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_FILEINFO = 26;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_HEADER = 4;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_IMAGE_SIZE = 1;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_INSTANCE = 6;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_OBJECT_DATA = 31;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_OBJECT_STYLE = 32;
    public static final byte ENUM_VIP_AMS_ERROR_INVALID_PAGE = 7;
    public static final byte ENUM_VIP_AMS_ERROR_LOAD_JPEGTORAW = 17;
    public static final byte ENUM_VIP_AMS_ERROR_NO = 0;
    public static final byte ENUM_VIP_AMS_ERROR_NOMORE_PLAY_OBJECT = 39;
    public static final byte ENUM_VIP_AMS_ERROR_NOT_READY = 5;
    public static final byte ENUM_VIP_AMS_ERROR_OBJECT_ALLOC = 30;
    public static final byte ENUM_VIP_AMS_ERROR_OBJECT_IMAGE_NUM_FULL = 51;
    public static final byte ENUM_VIP_AMS_ERROR_OBJECT_PROPERTY_SETTING = 27;
    public static final byte ENUM_VIP_AMS_ERROR_OBJECT_START_SETTING = 28;
    public static final byte ENUM_VIP_AMS_ERROR_POINT_FULL = 8;
    public static final byte ENUM_VIP_AMS_ERROR_SAVE_FLASH = 24;
    public static final byte ENUM_VIP_AMS_ERROR_STRING_LENGTH = 33;
    public static final byte ENUM_VIP_AMS_ERROR_TURN_PAGE = 40;
    public static final byte ENUM_VIP_AMS_ERROR_UNDEFINED = 25;
    public static final byte ENUM_VIP_AMS_ERROR_UNDO_REDO = 35;
    public static final byte ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL = 15;
    public static final byte ENUM_VIP_AMS_ERROR_USERIMAGE_TRANSMIT_FULL = 14;
    public static final byte ENUM_VIP_AMS_ERROR_ZOOM_INVALID_NEXTREGION = 37;
    public static final byte ENUM_VIP_AMS_PENSTYLE_CRAYON = 1;
    public static final byte ENUM_VIP_AMS_PENSTYLE_DOTLINE = 3;
    public static final byte ENUM_VIP_AMS_PENSTYLE_PENCIL = 0;
    public static final byte ENUM_VIP_AMS_PENSTYLE_SHINY = 2;
    public static final byte ENUM_VIP_AMS_PENSTYLE_TRANSPARENT = 4;
    public static final byte ENUM_VIP_AMS_PEN_OBJECT_NUM_FULL = 10;
    public static final int ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE = 400;
    public static final byte ENUM_VIP_AMS_SAVE_USER_STAMPSIZE = 120;
    public static final byte ENUM_VIP_AMS_STAMPSIZE_NORMAL = 2;
    public static final byte ENUM_VIP_AMS_STAMPSIZE_SMALL = 1;
    public static final byte ENUM_VIP_AMS_STAMPSIZE_UNDEFINED = 0;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_ANIMATION = 1;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_BASIC = 0;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_USER = 2;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_USER_CIRCLE = 3;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_USER_HEART = 4;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_USER_RECT = 6;
    public static final byte ENUM_VIP_AMS_STAMPSTYLE_USER_STAR = 5;
    public static final byte ENUM_VIP_AMS_STAMP_OBJECT_NUM_FULL = 12;
    public static final byte ENUM_VIP_AMS_TEXTSIZE_LARGE = 2;
    public static final byte ENUM_VIP_AMS_TEXTSIZE_NORMAL = 1;
    public static final byte ENUM_VIP_AMS_TEXTSIZE_SMALL = 0;
    public static final byte ENUM_VIP_AMS_TEXT_OBJECT_NUM_FULL = 11;
    public static final byte ENUM_VIP_AMS_TYPE_DIAGRAM = 4;
    public static final byte ENUM_VIP_AMS_TYPE_PEN = 1;
    public static final byte ENUM_VIP_AMS_TYPE_STAMP = 3;
    public static final byte ENUM_VIP_AMS_TYPE_TEXT = 2;
    public static final byte ENUM_VIP_AMS_TYPE_UNDEFINED = 0;
    public static final int ENUM_VIP_AMS_UNDO_REDO_DRAW_ALL = 2;
    public static final int ENUM_VIP_AMS_UNDO_REDO_ERROR = 0;
    public static final int ENUM_VIP_AMS_UNDO_REDO_UPDATE = 1;
    public static final byte ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE = 55;
    public static final byte ENUM_VIP_AMS_WQVGA_DRAW_USER_STAMPSIZE_LARGE = 60;
    public static final byte ENUM_VIP_AMS_WQVGA_DRAW_USER_STAMPSIZE_SMALL = 30;
    public static final int ENUM_VIP_AMS_WQVGA_SAVE_USER_STAMPIMAGE_SIZE = 10240;
    public static final byte ENUM_VIP_AMS_WVGA_DRAW_BASIC_STAMPSIZE = 110;
    public static final byte ENUM_VIP_AMS_WVGA_DRAW_USER_STAMPSIZE_LARGE = 120;
    public static final byte ENUM_VIP_AMS_WVGA_DRAW_USER_STAMPSIZE_SMALL = 60;
    public static int g_nCurObjectImageBPP;
    public static int g_nCurObjectImageHeight;
    public static int g_nCurObjectImageWidth;
    public static int g_nCurrentBackgroundBPP;
    public static int g_nCurrentBackgroundHeight;
    public static int g_nCurrentBackgroundWidth;
    public static int g_nNumTotalObject;
    public static int g_nNumTotalPenPoint;
    public static int g_nTextHeight;
    public static int g_nTextWidth;
    public AMS_UI_DATA UIData = new AMS_UI_DATA();

    public native boolean VipAMS_AddFrame(int i);

    public native boolean VipAMS_AddObjectImage(int i, byte b, int[] iArr, int i2, int i3, int i4, short s);

    public native boolean VipAMS_AnimationEnd(int i);

    public native boolean VipAMS_AnimationNext(int i);

    public native boolean VipAMS_AnimationStart(int i);

    public native boolean VipAMS_Blur(int[] iArr, int i, int i2, int i3);

    public native boolean VipAMS_Bright(int[] iArr, int i, int i2);

    public native boolean VipAMS_CancelSelect(int i);

    public native boolean VipAMS_ChangeSelectDiagram(int i, AMS_SELECT_OBJECT ams_select_object, AMS_RECT ams_rect, byte b);

    public native boolean VipAMS_ChangeSelectStamp(int i, AMS_SELECT_OBJECT ams_select_object, AMS_RECT ams_rect, int i2, int i3, int i4);

    public native boolean VipAMS_ChangeSelectText(int i, AMS_SELECT_OBJECT ams_select_object, AMS_RECT ams_rect, byte b, char[] cArr, short s, char[] cArr2, short s2);

    public native boolean VipAMS_ClearEncoding(int i);

    public native void VipAMS_Close(int i);

    public native boolean VipAMS_Dark(int[] iArr, int i, int i2);

    public native boolean VipAMS_DeleteSelectObject(int i, AMS_SELECT_OBJECT ams_select_object);

    public native boolean VipAMS_EncodeNewDiagram(int i, AMS_RECT ams_rect, byte b);

    public native int VipAMS_EncodeNewMultiImage(int i, AMS_RECT ams_rect, byte b, byte b2);

    public native boolean VipAMS_EncodeNewStamp(int i, AMS_RECT ams_rect, byte b, byte b2, byte b3, int[] iArr, int i2, int i3, int i4);

    public native boolean VipAMS_EncodeNewText(int i, AMS_RECT ams_rect, byte b, char[] cArr, short s, char[] cArr2, short s2);

    public native boolean VipAMS_EncodePointData(int i, short s, short s2, short s3);

    public native boolean VipAMS_EncodeStrokeEnd(int i);

    public native boolean VipAMS_EncodeStrokeStart(int i);

    public native boolean VipAMS_GetAnimationInfo(int i);

    public native byte[] VipAMS_GetBGAudioFile(int i);

    public native int VipAMS_GetBGAudioStyle(int i);

    public native int VipAMS_GetBGMIndex(int i);

    public native int VipAMS_GetBackgroundColorA(int i);

    public native int VipAMS_GetBackgroundColorB(int i);

    public native int VipAMS_GetBackgroundColorG(int i);

    public native int VipAMS_GetBackgroundColorR(int i);

    public native byte VipAMS_GetBackgroundIndex(int i);

    public native int VipAMS_GetBackgroundStyle(int i);

    public native int VipAMS_GetCodingHeight(int i);

    public native int VipAMS_GetCodingWidth(int i);

    public native int VipAMS_GetCurObjectColorA(int i);

    public native int VipAMS_GetCurObjectColorB(int i);

    public native int VipAMS_GetCurObjectColorG(int i);

    public native int VipAMS_GetCurObjectColorR(int i);

    public native byte VipAMS_GetCurObjectSize(int i);

    public native byte VipAMS_GetCurObjectStyle(int i);

    public native byte VipAMS_GetCurObjectType(int i);

    public native int[] VipAMS_GetCurrentBackgroundBuf(int i);

    public native int VipAMS_GetCurrentFrame(int i);

    public native int VipAMS_GetErrorCode(int i);

    public native void VipAMS_GetFileStreamInfo(byte[] bArr, int i);

    public native int VipAMS_GetFreeSpace(int i);

    public native boolean VipAMS_GetImageInfo(int[] iArr, int i, int i2, int i3);

    public native int VipAMS_GetLastFrame(int i);

    public native String VipAMS_GetLibVersion(int i);

    public native int VipAMS_GetNextDrawingData(int i, int i2, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_GetNextUpdateObject(int i, int i2, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_GetNextUpdateRegion(int i, int i2, AMS_RECT ams_rect);

    public native int[] VipAMS_GetObjectImageBuf(int i, AMS_OBJECT_DATA ams_object_data, byte b);

    public native int VipAMS_GetObjectImageDuration(int i, AMS_OBJECT_DATA ams_object_data, byte b);

    public native int VipAMS_GetObjectImageNum(int i, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_GetObjectIteration(int i, AMS_OBJECT_DATA ams_object_data);

    public native void VipAMS_GetSelectObjectData(int i, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_GetTotalObjectNum(int i);

    public native byte VipAMS_GetTurnPageOption(int i);

    public native boolean VipAMS_GetUIImageBuffer(int[] iArr, int i, int i2);

    public native boolean VipAMS_Gray(int[] iArr, int i, int i2);

    public native void VipAMS_Init();

    public native int VipAMS_IsAMSJPEGFile(AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native boolean VipAMS_IsAnimationEnable(int i);

    public native boolean VipAMS_IsEditEnable(int i);

    public native boolean VipAMS_IsEnableRedo(int i);

    public native boolean VipAMS_IsEnableUndo(int i);

    public native boolean VipAMS_Negative(int[] iArr, int i, int i2);

    public native int VipAMS_Open(AMS_OPTION ams_option);

    public native boolean VipAMS_PencilSketch(int[] iArr, int i, int i2);

    public native int VipAMS_Redo(int i);

    public native boolean VipAMS_RemoveFrame(int i, byte b);

    public native boolean VipAMS_SelectObject(int i, int i2, int i3, AMS_SELECT_OBJECT ams_select_object, int i4);

    public native boolean VipAMS_Sepia(int[] iArr, int i, int i2);

    public native int VipAMS_SetAMSImageBuf(int i, int[] iArr, int i2, int i3);

    public native boolean VipAMS_SetBGAudioFile(int i, byte[] bArr, int i2);

    public native boolean VipAMS_SetBGAudioStyle(int i, int i2);

    public native boolean VipAMS_SetBGMIndex(int i, int i2);

    public native boolean VipAMS_SetBackgroundColor(int i, int i2, int i3, int i4);

    public native boolean VipAMS_SetBackgroundIndex(int i, byte b);

    public native boolean VipAMS_SetBackgroundRawImage(int i, int[] iArr, int i2, int i3, int i4);

    public native boolean VipAMS_SetCurObjectColor(int i, int i2, int i3, int i4);

    public native boolean VipAMS_SetCurObjectSize(int i, byte b);

    public native boolean VipAMS_SetCurObjectStyle(int i, byte b);

    public native boolean VipAMS_SetCurObjectType(int i, byte b);

    public native boolean VipAMS_SetCurrentFrame(int i, byte b);

    public native boolean VipAMS_SetEditEnable(int i, boolean z);

    public native boolean VipAMS_SetNextFrame(int i);

    public native boolean VipAMS_SetPrevFrame(int i);

    public native boolean VipAMS_SetTempFilePath(byte[] bArr, int i);

    public native boolean VipAMS_SetTurnPageOption(int i, byte b);

    public native int VipAMS_TotalEndEncoding(int i, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native int VipAMS_TotalLoadEncodingFile(int i, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, AMS_RECT ams_rect);

    public native boolean VipAMS_TotalNewEncoding(int i, AMS_RECT ams_rect, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_TotalSaveEncoding(int i, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native int VipAMS_Undo(int i);

    static {
        try {
            System.loadLibrary("AMSWiFiLibs-1.0.6");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public AMS_UI_DATA getUIData() {
        return this.UIData;
    }

    public void setUIData(AMS_UI_DATA ams_ui_data) {
        this.UIData = ams_ui_data;
    }

    public int GetBValue(int i) {
        return (i >> 0) & MotionEventCompat.ACTION_MASK;
    }

    public int GetGValue(int i) {
        return (i >> 8) & MotionEventCompat.ACTION_MASK;
    }

    public int GetRValue(int i) {
        return (i >> 16) & MotionEventCompat.ACTION_MASK;
    }

    public int Convert565(int i, int i2, int i3) {
        return ((((i * 31) + 127) / MotionEventCompat.ACTION_MASK) << 11) | ((((i2 * 63) + 127) / MotionEventCompat.ACTION_MASK) << 5) | (((i3 * 31) + 127) / MotionEventCompat.ACTION_MASK);
    }

    public boolean NewEncoding(int i, AMS_UI_DATA ams_ui_data) {
        this.UIData = ams_ui_data;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.UIData.m_cObjectSize);
        ams_object_data.setM_cStyle(this.UIData.m_cObjectStyle);
        ams_object_data.setM_nColorR(GetRValue(this.UIData.m_rgbPen));
        ams_object_data.setM_nColorG(GetGValue(this.UIData.m_rgbPen));
        ams_object_data.setM_nColorB(GetBValue(this.UIData.m_rgbPen));
        return VipAMS_TotalNewEncoding(i, this.UIData.m_rectRegion, ams_object_data);
    }

    public int[] VipAMS_GetObjectImageBuf(int i, AMS_OBJECT_DATA ams_object_data) {
        return VipAMS_GetObjectImageBuf(i, ams_object_data, (byte) 0);
    }

    public static IntBuffer makeBuffer(int[] iArr, int i, int i2) {
        IntBuffer intBufferAllocate = IntBuffer.allocate(i * i2);
        intBufferAllocate.put(iArr);
        intBufferAllocate.rewind();
        return intBufferAllocate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int Callback_saveRawImageToImageFile(byte[] r9, int[] r10, int r11, int r12, int r13, int r14, int r15) throws java.lang.Throwable {
        /*
            r8 = this;
            if (r10 != 0) goto L5
            r0 = 41
        L4:
            return r0
        L5:
            r8.Callback_deleteTempFile(r9)
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r11, r12, r0)
            r2 = 0
            r4 = 0
            r5 = 0
            r1 = r10
            r3 = r11
            r6 = r11
            r7 = r12
            r0.setPixels(r1, r2, r3, r4, r5, r6, r7)
            java.io.File r3 = new java.io.File
            java.lang.String r1 = new java.lang.String
            r1.<init>(r9)
            r3.<init>(r1)
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L78 java.io.FileNotFoundException -> L7b
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L78 java.io.FileNotFoundException -> L7b
            if (r1 != 0) goto L36
            r0 = 41
            if (r1 == 0) goto L4
            r1.close()     // Catch: java.lang.Exception -> L32
            goto L4
        L32:
            r0 = move-exception
            r0 = 41
            goto L4
        L36:
            if (r15 != 0) goto L4a
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            r0.compress(r2, r14, r1)     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
        L3d:
            r0.recycle()     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            java.lang.System.gc()     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L70
        L48:
            r0 = 0
            goto L4
        L4a:
            r2 = 1
            if (r15 != r2) goto L63
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            r0.compress(r2, r14, r1)     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            goto L3d
        L53:
            r0 = move-exception
        L54:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L69
            r0 = 41
            if (r1 == 0) goto L4
            r1.close()     // Catch: java.lang.Exception -> L5f
            goto L4
        L5f:
            r0 = move-exception
            r0 = 41
            goto L4
        L63:
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            r0.compress(r2, r14, r1)     // Catch: java.io.FileNotFoundException -> L53 java.lang.Throwable -> L69
            goto L3d
        L69:
            r0 = move-exception
        L6a:
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.lang.Exception -> L74
        L6f:
            throw r0
        L70:
            r0 = move-exception
            r0 = 41
            goto L4
        L74:
            r0 = move-exception
            r0 = 41
            goto L4
        L78:
            r0 = move-exception
            r1 = r2
            goto L6a
        L7b:
            r0 = move-exception
            r1 = r2
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.amsoma.AMSLibs.Callback_saveRawImageToImageFile(byte[], int[], int, int, int, int, int):int");
    }

    public int Callback_saveRawImageToJPEGFileWithLimitSize(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5) throws Throwable {
        int length;
        int i6;
        Callback_deleteTempFile(bArr);
        int i7 = 0;
        int i8 = i4;
        while (true) {
            int iCallback_saveRawImageToImageFile = Callback_saveRawImageToImageFile(bArr, iArr, i, i2, i3, i8, 0);
            if (iCallback_saveRawImageToImageFile == 0) {
                try {
                    File file = new File(new String(bArr));
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    length = file != null ? (int) file.length() : i7;
                } catch (IOException e) {
                    length = i7;
                }
                if (length < i5) {
                    i6 = 0;
                    break;
                }
                try {
                    Callback_deleteTempFile(bArr);
                    if (i8 <= 30) {
                        i8 -= 5;
                    } else {
                        i8 -= 10;
                    }
                } catch (IOException e2) {
                    C3250y.m11442a("IOException", getClass().getSimpleName());
                    i7 = length;
                }
                if (i8 < 5) {
                    i6 = 43;
                    break;
                }
                i7 = length;
            } else {
                return iCallback_saveRawImageToImageFile;
            }
        }
        return (i6 == 43 || length == 0) ? i6 : i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[Catch: IOException -> 0x003b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x003b, blocks: (B:10:0x001e, B:14:0x002d), top: B:22:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int Callback_loadImageStreamToRawImage(byte[] r4, byte[] r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            r3.Callback_deleteTempFile(r4)
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L2b
            java.lang.String r0 = new java.lang.String     // Catch: java.io.IOException -> L2b
            r0.<init>(r4)     // Catch: java.io.IOException -> L2b
            r2.<init>(r0)     // Catch: java.io.IOException -> L2b
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L2b
            r0.<init>(r2)     // Catch: java.io.IOException -> L2b
            if (r0 != 0) goto L18
            r0 = 43
        L17:
            return r0
        L18:
            r1 = 0
            r0.write(r5, r1, r6)     // Catch: java.io.IOException -> L4a
        L1c:
            if (r0 == 0) goto L21
            r0.close()     // Catch: java.io.IOException -> L3b
        L21:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            int r0 = r3.loadImageFileToRawImage(r0)
            goto L17
        L2b:
            r0 = move-exception
            r0 = r1
        L2d:
            java.lang.String r1 = "IOException"
            java.lang.Class r2 = r3.getClass()     // Catch: java.io.IOException -> L3b
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.io.IOException -> L3b
            com.sec.chaton.util.C3250y.m11442a(r1, r2)     // Catch: java.io.IOException -> L3b
            goto L1c
        L3b:
            r0 = move-exception
            java.lang.String r0 = "IOException"
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.C3250y.m11442a(r0, r1)
            goto L21
        L4a:
            r1 = move-exception
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.amsoma.AMSLibs.Callback_loadImageStreamToRawImage(byte[], byte[], int):int");
    }

    public int Callback_loadImageFileToRawImage(byte[] bArr) {
        return loadImageFileToRawImage(new String(bArr));
    }

    public void Callback_deleteTempFile(byte[] bArr) {
        File file = new File(new String(bArr));
        if (file.isFile()) {
            file.delete();
        }
        if (file != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean Callback_writeData(byte[] r8, int r9, byte[] r10) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L5
            if (r10 != 0) goto L6
        L5:
            return r0
        L6:
            r3 = 0
            java.lang.String r1 = new java.lang.String     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L41
            r1.<init>(r8)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L41
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L41
            java.lang.String r4 = "rw"
            r2.<init>(r1, r4)     // Catch: java.io.IOException -> L31 java.lang.Throwable -> L41
            if (r9 < 0) goto L25
            long r3 = (long) r9
            long r5 = r2.length()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L25
            long r3 = (long) r9     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            r2.seek(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
            r2.write(r10)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50
        L25:
            if (r2 == 0) goto L2a
            r2.close()     // Catch: java.io.IOException -> L2c
        L2a:
            r0 = 1
            goto L5
        L2c:
            r0 = move-exception
            r0.printStackTrace()
            goto L2a
        L31:
            r1 = move-exception
            r2 = r3
        L33:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L5
            r2.close()     // Catch: java.io.IOException -> L3c
            goto L5
        L3c:
            r1 = move-exception
            r1.printStackTrace()
            goto L5
        L41:
            r0 = move-exception
        L42:
            if (r3 == 0) goto L47
            r3.close()     // Catch: java.io.IOException -> L48
        L47:
            throw r0
        L48:
            r1 = move-exception
            r1.printStackTrace()
            goto L47
        L4d:
            r0 = move-exception
            r3 = r2
            goto L42
        L50:
            r1 = move-exception
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.amsoma.AMSLibs.Callback_writeData(byte[], int, byte[]):boolean");
    }

    public int loadImageFileToRawImage(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        int width = bitmapDecodeFile.getWidth();
        int height = bitmapDecodeFile.getHeight();
        try {
            int[] iArr = new int[width * height];
            bitmapDecodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmapDecodeFile.recycle();
            if (iArr == null) {
                return 41;
            }
            boolean zVipAMS_GetImageInfo = VipAMS_GetImageInfo(iArr, width, height, 32);
            System.gc();
            return !zVipAMS_GetImageInfo ? 41 : 0;
        } catch (OutOfMemoryError e) {
            bitmapDecodeFile.recycle();
            return 45;
        }
    }

    public void GetCurObjectImageBufInfo(int i, int i2, int i3) {
        g_nCurObjectImageWidth = i;
        g_nCurObjectImageHeight = i2;
        g_nCurObjectImageBPP = i3;
    }

    public void GetCurrentBackgroundBufInfo(int i, int i2, int i3) {
        g_nCurrentBackgroundWidth = i;
        g_nCurrentBackgroundHeight = i2;
        g_nCurrentBackgroundBPP = i3;
    }

    public void GetAnimationObjectInfo(int i, int i2) {
        g_nNumTotalPenPoint = i;
        g_nNumTotalObject = i2;
    }
}
