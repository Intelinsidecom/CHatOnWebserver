package com.sec.amsoma;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OPTION;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.util.ChatONLogWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

    static {
        try {
            System.loadLibrary("AMSWiFiLibs");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static IntBuffer makeBuffer(int[] iArr, int i, int i2) {
        IntBuffer intBufferAllocate = IntBuffer.allocate(i * i2);
        intBufferAllocate.put(iArr);
        intBufferAllocate.rewind();
        return intBufferAllocate;
    }

    public int Convert565(int i, int i2, int i3) {
        return ((((i * 31) + 127) / 255) << 11) | ((((i2 * 63) + 127) / 255) << 5) | (((i3 * 31) + 127) / 255);
    }

    public void GetAnimationObjectInfo(int i, int i2) {
        g_nNumTotalPenPoint = i;
        g_nNumTotalObject = i2;
    }

    public int GetBValue(int i) {
        return (i >> 0) & 255;
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

    public int GetGValue(int i) {
        return (i >> 8) & 255;
    }

    public int GetRValue(int i) {
        return (i >> 16) & 255;
    }

    public boolean NewEncoding(int i, AMS_UI_DATA ams_ui_data) {
        this.UIData = ams_ui_data;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.UIData.m_cObjectSize);
        ams_object_data.setM_cStyle(this.UIData.m_cObjectStyle);
        ams_object_data.setM_nColorR(GetRValue(this.UIData.m_rgbPen));
        ams_object_data.setM_nColorG(GetGValue(this.UIData.m_rgbPen));
        ams_object_data.setM_nColorB(GetBValue(this.UIData.m_rgbPen));
        return VipAMS_TotalNewEncoding(i, this.UIData, this.UIData.m_rectRegion, ams_object_data);
    }

    public native boolean VipAMS_AddFrame(int i);

    public native boolean VipAMS_AnimationEnd(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_AnimationNext(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_AnimationStart(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_BlurUsingIntergralImg(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native boolean VipAMS_Bright(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native boolean VipAMS_ChangeSelectDiagram(int i, AMS_UI_DATA ams_ui_data, AMS_SELECT_OBJECT ams_select_object, AMS_RECT ams_rect, byte b, boolean z);

    public native boolean VipAMS_ChangeSelectStamp(int i, AMS_UI_DATA ams_ui_data, AMS_SELECT_OBJECT ams_select_object, AMS_RECT ams_rect, int i2, int i3, boolean z);

    public native boolean VipAMS_ChangeSelectText(int i, AMS_UI_DATA ams_ui_data, AMS_SELECT_OBJECT ams_select_object, AMS_RECT ams_rect, byte b, char[] cArr, int i2, char[] cArr2, int i3, boolean z);

    public native boolean VipAMS_ClearEncoding(int i, AMS_UI_DATA ams_ui_data);

    public native void VipAMS_Close(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_CloseStrokeEnd(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_Dark(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native boolean VipAMS_DecodingJPEGFile(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, AMS_RECT ams_rect);

    public native boolean VipAMS_DecodingJPEGMemory(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, byte[] bArr, int i2, AMS_RECT ams_rect);

    public native boolean VipAMS_DecodingRawImageData(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, byte[] bArr, int i2, int i3, int i4, AMS_RECT ams_rect);

    public native boolean VipAMS_DeleteSelectObject(int i, AMS_UI_DATA ams_ui_data, AMS_SELECT_OBJECT ams_select_object, boolean z);

    public native boolean VipAMS_EncodeNewDiagram(int i, AMS_UI_DATA ams_ui_data, AMS_RECT ams_rect, byte b, boolean z);

    public native boolean VipAMS_EncodeNewStamp(int i, AMS_UI_DATA ams_ui_data, AMS_RECT ams_rect, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7, boolean z);

    public native boolean VipAMS_EncodeNewText(int i, AMS_UI_DATA ams_ui_data, AMS_RECT ams_rect, byte b, char[] cArr, int i2, char[] cArr2, int i3, boolean z);

    public native boolean VipAMS_EncodePointData(int i, AMS_UI_DATA ams_ui_data, int i2, int i3);

    public native boolean VipAMS_EncodeStrokeEnd(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_EncodeStrokeStart(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_EndEncoding(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native boolean VipAMS_GetAnimationInfo(int i);

    public native char[] VipAMS_GetBGAudioFile(int i);

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

    public native int VipAMS_GetCurObjectType(int i);

    public native int[] VipAMS_GetCurrentBackgroundBuf(int i);

    public native int[] VipAMS_GetCurrentForegroundBuf(int i);

    public native int[] VipAMS_GetCurrentForegroundBufFile(AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, AMS_OPTION ams_option, int i, AMS_RECT ams_rect);

    public native int VipAMS_GetCurrentFrame(int i);

    public native void VipAMS_GetCurrentFrameBuf(int i, byte[] bArr);

    public native void VipAMS_GetDiagramImageBuffer(AMS_RECT ams_rect, byte b, int i, byte b2, int i2, int i3, int i4, byte b3, int i5, int[] iArr);

    public native int VipAMS_GetErrorCode(int i);

    public native void VipAMS_GetFileStreamInfo(byte[] bArr, int i);

    public native int VipAMS_GetFreeSpace(int i);

    public native boolean VipAMS_GetImageInfo(int[] iArr, int i, int i2, int i3);

    public native int VipAMS_GetLastFrame(int i);

    public native int VipAMS_GetNextDrawingData(int i, int i2, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_GetNextUpdateObject(int i, int i2, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_GetNextUpdateRegion(int i, int i2, AMS_RECT ams_rect);

    public native int[] VipAMS_GetObjectImageBuf(int i, AMS_OBJECT_DATA ams_object_data);

    public native void VipAMS_GetSelectObjectData(int i, AMS_OBJECT_DATA ams_object_data);

    public native byte VipAMS_GetTurnPageOption(int i);

    public native boolean VipAMS_GetUIImageBuffer(int[] iArr, int i, int i2);

    public native boolean VipAMS_Gray(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native void VipAMS_Init();

    public native int VipAMS_IsAMSJPEGFile(AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native boolean VipAMS_IsAnimationEnable(int i);

    public native boolean VipAMS_IsEditEnable(int i);

    public native boolean VipAMS_IsEnableRedo(int i);

    public native boolean VipAMS_IsEnableUndo(int i);

    public native boolean VipAMS_LoadEncoding(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, AMS_RECT ams_rect);

    public native boolean VipAMS_Negative(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native int VipAMS_Open(AMS_OPTION ams_option);

    public native boolean VipAMS_PencilSketch(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native int VipAMS_Redo(int i, AMS_UI_DATA ams_ui_data);

    public native boolean VipAMS_RemoveFrame(int i, byte b);

    public native boolean VipAMS_SaveEncoding(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native boolean VipAMS_SelectObject(int i, AMS_UI_DATA ams_ui_data, int i2, int i3, AMS_SELECT_OBJECT ams_select_object, int i4);

    public native boolean VipAMS_Sepia(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native int VipAMS_SetAMSImageBuf(int i, AMS_UI_DATA ams_ui_data, int[] iArr, int i2, int i3);

    public native boolean VipAMS_SetBGAudioFile(int i, AMS_UI_DATA ams_ui_data, char[] cArr);

    public native boolean VipAMS_SetBGAudioStyle(int i, int i2);

    public native boolean VipAMS_SetBGMIndex(int i, int i2);

    public native boolean VipAMS_SetBackgroundColor(int i, AMS_UI_DATA ams_ui_data, int i2, int i3, int i4);

    public native boolean VipAMS_SetBackgroundIndex(int i, byte b);

    public native boolean VipAMS_SetBackgroundRawImage(int i, int[] iArr, int i2, int i3, int i4);

    public native boolean VipAMS_SetCurObjectColor(int i, AMS_UI_DATA ams_ui_data, int i2, int i3, int i4);

    public native boolean VipAMS_SetCurObjectSize(int i, AMS_UI_DATA ams_ui_data, int i2);

    public native boolean VipAMS_SetCurObjectStyle(int i, AMS_UI_DATA ams_ui_data, byte b);

    public native boolean VipAMS_SetCurObjectType(int i, AMS_UI_DATA ams_ui_data, byte b);

    public native boolean VipAMS_SetCurrentFrame(int i, byte b);

    public native boolean VipAMS_SetEditEnable(int i, boolean z);

    public native boolean VipAMS_SetNextFrame(int i);

    public native boolean VipAMS_SetPrevFrame(int i);

    public native boolean VipAMS_SetStampTemplatePath(char[] cArr, int i);

    public native boolean VipAMS_SetTempFilePath(char[] cArr, int i);

    public native boolean VipAMS_SetTurnPageOption(int i, byte b);

    public native boolean VipAMS_StartEncoding(int i, AMS_RECT ams_rect, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_TotalEndEncoding(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native int VipAMS_TotalLoadEncodingFile(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr, AMS_RECT ams_rect);

    public native boolean VipAMS_TotalNewEncoding(int i, AMS_UI_DATA ams_ui_data, AMS_RECT ams_rect, AMS_OBJECT_DATA ams_object_data);

    public native int VipAMS_TotalSaveEncoding(int i, AMS_UI_DATA ams_ui_data, AMS_CODING_FILE_INFO[] ams_coding_file_infoArr);

    public native int VipAMS_Undo(int i, AMS_UI_DATA ams_ui_data);

    public void deleteTempFile(String str) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (file != null) {
        }
    }

    public AMS_UI_DATA getUIData() {
        return this.UIData;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int loadFileToBuffer(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            r4 = 0
            r6 = 0
            r5 = -1
            java.io.File r0 = new java.io.File     // Catch: java.io.IOException -> L3d
            r0.<init>(r9)     // Catch: java.io.IOException -> L3d
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L3d
            r1.<init>(r0)     // Catch: java.io.IOException -> L3d
            if (r1 != 0) goto L12
            r0 = 41
        L11:
            return r0
        L12:
            long r2 = r0.length()     // Catch: java.io.IOException -> L6f
            int r0 = (int) r2
            byte[] r2 = new byte[r0]     // Catch: java.io.IOException -> L74
            int r3 = r1.read(r2)     // Catch: java.io.IOException -> L7a
            r7 = r1
            r1 = r3
            r3 = r2
            r2 = r0
            r0 = r7
        L22:
            r0.close()     // Catch: java.io.IOException -> L6a
            r0 = r1
            r1 = r2
            r2 = r3
        L28:
            if (r0 != r5) goto L62
            java.lang.System.gc()
            java.lang.String r0 = "failed to read image"
            java.lang.Class r1 = r8.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3506b(r0, r1)
            r0 = 42
            goto L11
        L3d:
            r0 = move-exception
            r0 = r4
            r1 = r6
            r2 = r4
        L41:
            java.lang.String r3 = "IOException"
            java.lang.Class r4 = r8.getClass()     // Catch: java.io.IOException -> L52
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.io.IOException -> L52
            com.sec.chaton.util.ChatONLogWriter.m3499a(r3, r4)     // Catch: java.io.IOException -> L52
            r3 = r2
            r2 = r1
            r1 = r5
            goto L22
        L52:
            r0 = move-exception
            r0 = r5
        L54:
            java.lang.String r3 = "IOException"
            java.lang.Class r4 = r8.getClass()
            java.lang.String r4 = r4.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3506b(r3, r4)
            goto L28
        L62:
            r8.VipAMS_GetFileStreamInfo(r2, r1)
            java.lang.System.gc()
            r0 = r6
            goto L11
        L6a:
            r0 = move-exception
            r0 = r1
            r1 = r2
            r2 = r3
            goto L54
        L6f:
            r0 = move-exception
            r0 = r1
            r2 = r4
            r1 = r6
            goto L41
        L74:
            r2 = move-exception
            r2 = r4
            r7 = r0
            r0 = r1
            r1 = r7
            goto L41
        L7a:
            r3 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.amsoma.AMSLibs.loadFileToBuffer(java.lang.String):int");
    }

    public int loadImageFileToRawImage(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        int width = bitmapDecodeFile.getWidth();
        int height = bitmapDecodeFile.getHeight();
        int[] iArr = new int[width * height];
        bitmapDecodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
        bitmapDecodeFile.recycle();
        if (iArr == null) {
            return 41;
        }
        boolean zVipAMS_GetImageInfo = VipAMS_GetImageInfo(iArr, width, height, 32);
        System.gc();
        return !zVipAMS_GetImageInfo ? 41 : 0;
    }

    public int loadImageStreamToRawImage(String str, byte[] bArr, int i) throws IOException {
        FileOutputStream fileOutputStream;
        deleteTempFile(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
        } catch (IOException e) {
        }
        if (fileOutputStream == null) {
            return 43;
        }
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream2 = fileOutputStream;
        } catch (IOException e2) {
            fileOutputStream2 = fileOutputStream;
            try {
                ChatONLogWriter.m3499a("IOException", getClass().getSimpleName());
                fileOutputStream2.close();
            } catch (IOException e3) {
                ChatONLogWriter.m3499a("IOException", getClass().getSimpleName());
            }
            int iLoadImageFileToRawImage = loadImageFileToRawImage(str);
            deleteTempFile(str);
            return iLoadImageFileToRawImage;
        }
        fileOutputStream2.close();
        int iLoadImageFileToRawImage2 = loadImageFileToRawImage(str);
        deleteTempFile(str);
        return iLoadImageFileToRawImage2;
    }

    public int saveBufferToFile(String str, byte[] bArr, int i) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
        } catch (IOException e) {
        }
        if (fileOutputStream == null) {
            return 41;
        }
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream2 = fileOutputStream;
        } catch (IOException e2) {
            fileOutputStream2 = fileOutputStream;
            try {
                ChatONLogWriter.m3499a("IOException", getClass().getSimpleName());
                fileOutputStream2.close();
            } catch (IOException e3) {
                ChatONLogWriter.m3499a("IOException", getClass().getSimpleName());
            }
            return 0;
        }
        fileOutputStream2.close();
        return 0;
    }

    public int saveJPEGFileWithLimitSizeVoid(String str, int[] iArr, int i, int i2, int i3, int i4, int i5) throws Throwable {
        int iSaveRawImageToJPEGFile;
        int length;
        deleteTempFile(str);
        int i6 = i4;
        while (true) {
            iSaveRawImageToJPEGFile = saveRawImageToJPEGFile(str, iArr, i, i2, i3, i6);
            if (iSaveRawImageToJPEGFile != 0) {
                break;
            }
            try {
                File file = new File(str);
                FileInputStream fileInputStream = new FileInputStream(file);
                length = (int) file.length();
                fileInputStream.close();
                if (fileInputStream != null) {
                }
                if (file != null) {
                }
            } catch (IOException e) {
                ChatONLogWriter.m3499a("IOException", getClass().getSimpleName());
            }
            if (length < i5) {
                iSaveRawImageToJPEGFile = 0;
                break;
            }
            deleteTempFile(str);
            int i7 = i6 <= 30 ? i6 - 5 : i6 - 10;
            if (i7 < 5) {
                iSaveRawImageToJPEGFile = 43;
                break;
            }
            i6 = i7;
        }
        if (iSaveRawImageToJPEGFile == 43 || length == 0) {
        }
        return iSaveRawImageToJPEGFile;
    }

    public int saveRawImageToImageFile(String str, int[] iArr, int i, int i2, int i3, int i4, int i5) throws Throwable {
        FileOutputStream fileOutputStream;
        if (iArr == null) {
            return 41;
        }
        deleteTempFile(str);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
            if (fileOutputStream2 == null) {
                try {
                    fileOutputStream2.close();
                    if (fileOutputStream2 != null) {
                    }
                    return 41;
                } catch (Exception e) {
                    return 41;
                }
            }
            try {
                if (i5 != 0 && i5 == 1) {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, i4, fileOutputStream2);
                } else {
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, i4, fileOutputStream2);
                }
                System.gc();
                try {
                    fileOutputStream2.close();
                    if (fileOutputStream2 != null) {
                    }
                    return 0;
                } catch (Exception e2) {
                    return 41;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                        if (fileOutputStream != null) {
                        }
                        return 41;
                    } catch (Exception e4) {
                        return 41;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileOutputStream.close();
                        if (fileOutputStream == null) {
                        }
                        throw th;
                    } catch (Exception e5) {
                        return 41;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                fileOutputStream.close();
                if (fileOutputStream == null) {
                }
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public int saveRawImageToJPEGFile(String str, int[] iArr, int i, int i2, int i3, int i4) throws Throwable {
        if (iArr == null) {
            return 41;
        }
        deleteTempFile(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                if (fileOutputStream2 == null) {
                    try {
                        fileOutputStream2.close();
                        if (fileOutputStream2 != null) {
                        }
                        return 41;
                    } catch (Exception e) {
                        return 41;
                    }
                }
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    bitmapCreateBitmap.copyPixelsFromBuffer(makeBuffer(iArr, i, i2));
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, i4, fileOutputStream2);
                    System.gc();
                    try {
                        fileOutputStream2.close();
                        if (fileOutputStream2 != null) {
                        }
                        return 0;
                    } catch (Exception e2) {
                        return 41;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                        if (fileOutputStream != null) {
                        }
                        return 41;
                    } catch (Exception e4) {
                        return 41;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        fileOutputStream.close();
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    } catch (Exception e5) {
                        return 41;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
        }
    }

    public void setUIData(AMS_UI_DATA ams_ui_data) {
        this.UIData = ams_ui_data;
    }
}
