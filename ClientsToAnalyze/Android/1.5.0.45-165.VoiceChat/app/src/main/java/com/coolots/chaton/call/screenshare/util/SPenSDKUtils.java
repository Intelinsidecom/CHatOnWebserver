package com.coolots.chaton.call.screenshare.util;

import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import com.coolots.chaton.C0000R;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.spensdk.SCanvasConstants;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.EngineCallBackInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SPenSDKUtils {
    public static String getRealPathFromURI(Activity activity, Uri contentUri) throws IllegalArgumentException {
        if (MainApplication.mConfig.isScreenShare()) {
            String[] proj = {"_data"};
            String strFileName = "";
            CursorLoader cursorLoader = new CursorLoader(activity, contentUri, proj, null, null, null);
            Cursor cursor = cursorLoader.loadInBackground();
            if (cursor != null) {
                int column_index = cursor.getColumnIndexOrThrow("_data");
                cursor.moveToFirst();
                if (cursor.getCount() > 0) {
                    strFileName = cursor.getString(column_index);
                }
                cursor.close();
            }
            return strFileName;
        }
        String[] proj2 = {"_data"};
        String strFileName2 = "";
        Cursor cursor2 = activity.managedQuery(contentUri, proj2, null, null, null);
        if (cursor2 != null) {
            int column_index2 = cursor2.getColumnIndexOrThrow("_data");
            cursor2.moveToFirst();
            if (cursor2.getCount() > 0) {
                strFileName2 = cursor2.getString(column_index2);
            }
            cursor2.close();
        }
        return strFileName2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean saveBitmapJPEGWithBackgroundColor(java.lang.String r17, android.graphics.Bitmap r18, int r19, int r20) throws java.io.IOException {
        /*
            r1 = 0
            r2 = 0
            java.io.File r12 = new java.io.File
            r0 = r17
            r12.<init>(r0)
            boolean r13 = r12.exists()
            if (r13 == 0) goto L17
            boolean r13 = r12.delete()
            if (r13 != 0) goto L17
            r13 = 0
        L16:
            return r13
        L17:
            int r13 = r20 >> 24
            r7 = r13 & 255(0xff, float:3.57E-43)
            if (r7 != 0) goto L1f
            r20 = -1
        L1f:
            android.graphics.Rect r11 = new android.graphics.Rect
            r13 = 0
            r14 = 0
            int r15 = r18.getWidth()
            int r16 = r18.getHeight()
            r0 = r16
            r11.<init>(r13, r14, r15, r0)
            int r13 = r18.getWidth()
            int r14 = r18.getHeight()
            android.graphics.Bitmap$Config r15 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r13, r14, r15)
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r8)
            r0 = r20
            r4.drawColor(r0)
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>()
            r0 = r18
            r4.drawBitmap(r0, r11, r11, r13)
            r13 = 10
            r0 = r19
            if (r0 >= r13) goto L83
            r19 = 10
        L5a:
            r9 = 0
            boolean r1 = r12.createNewFile()     // Catch: java.io.IOException -> L8c
        L5f:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L91
            r10.<init>(r12)     // Catch: java.lang.Exception -> L91
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> Lbc
            r0 = r19
            boolean r2 = r8.compress(r13, r0, r10)     // Catch: java.lang.Exception -> Lbc
            r9 = r10
        L6d:
            if (r9 == 0) goto L96
            r9.flush()     // Catch: java.io.IOException -> L98 java.lang.Throwable -> La8
            r9.close()     // Catch: java.io.IOException -> L98 java.lang.Throwable -> La8
            r3 = 1
        L76:
            if (r9 == 0) goto L7b
            r9.close()     // Catch: java.io.IOException -> Lb4
        L7b:
            if (r1 == 0) goto Lb9
            if (r2 == 0) goto Lb9
            if (r3 == 0) goto Lb9
            r13 = 1
            goto L16
        L83:
            r13 = 100
            r0 = r19
            if (r0 <= r13) goto L5a
            r19 = 100
            goto L5a
        L8c:
            r6 = move-exception
            r6.printStackTrace()
            goto L5f
        L91:
            r5 = move-exception
        L92:
            r5.printStackTrace()
            goto L6d
        L96:
            r3 = 0
            goto L76
        L98:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> La8
            r3 = 0
            if (r9 == 0) goto L7b
            r9.close()     // Catch: java.io.IOException -> La3
            goto L7b
        La3:
            r5 = move-exception
            r5.printStackTrace()
            goto L7b
        La8:
            r13 = move-exception
            if (r9 == 0) goto Lae
            r9.close()     // Catch: java.io.IOException -> Laf
        Lae:
            throw r13
        Laf:
            r5 = move-exception
            r5.printStackTrace()
            goto Lae
        Lb4:
            r5 = move-exception
            r5.printStackTrace()
            goto L7b
        Lb9:
            r13 = 0
            goto L16
        Lbc:
            r5 = move-exception
            r9 = r10
            goto L92
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.call.screenshare.util.SPenSDKUtils.saveBitmapJPEGWithBackgroundColor(java.lang.String, android.graphics.Bitmap, int, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean saveBitmapPNGWithBackgroundColor(java.lang.String r17, android.graphics.Bitmap r18, int r19) throws java.io.IOException {
        /*
            r1 = 0
            r2 = 0
            java.io.File r12 = new java.io.File
            r0 = r17
            r12.<init>(r0)
            boolean r13 = r12.exists()
            if (r13 == 0) goto L17
            boolean r13 = r12.delete()
            if (r13 != 0) goto L17
            r13 = 0
        L16:
            return r13
        L17:
            int r13 = r19 >> 24
            r7 = r13 & 255(0xff, float:3.57E-43)
            if (r7 != 0) goto L1f
            r19 = -1
        L1f:
            android.graphics.Rect r11 = new android.graphics.Rect
            r13 = 0
            r14 = 0
            int r15 = r18.getWidth()
            int r16 = r18.getHeight()
            r0 = r16
            r11.<init>(r13, r14, r15, r0)
            int r13 = r18.getWidth()
            int r14 = r18.getHeight()
            android.graphics.Bitmap$Config r15 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r13, r14, r15)
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r8)
            r0 = r19
            r4.drawColor(r0)
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>()
            r0 = r18
            r4.drawBitmap(r0, r11, r11, r13)
            r9 = 0
            boolean r1 = r12.createNewFile()     // Catch: java.io.IOException -> L7b
        L57:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L80
            r10.<init>(r12)     // Catch: java.lang.Exception -> L80
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> Lab
            r14 = 100
            boolean r2 = r8.compress(r13, r14, r10)     // Catch: java.lang.Exception -> Lab
            r9 = r10
        L65:
            if (r9 == 0) goto L85
            r9.flush()     // Catch: java.io.IOException -> L87 java.lang.Throwable -> L97
            r9.close()     // Catch: java.io.IOException -> L87 java.lang.Throwable -> L97
            r3 = 1
        L6e:
            if (r9 == 0) goto L73
            r9.close()     // Catch: java.io.IOException -> La3
        L73:
            if (r1 == 0) goto La8
            if (r2 == 0) goto La8
            if (r3 == 0) goto La8
            r13 = 1
            goto L16
        L7b:
            r6 = move-exception
            r6.printStackTrace()
            goto L57
        L80:
            r5 = move-exception
        L81:
            r5.printStackTrace()
            goto L65
        L85:
            r3 = 0
            goto L6e
        L87:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L97
            r3 = 0
            if (r9 == 0) goto L73
            r9.close()     // Catch: java.io.IOException -> L92
            goto L73
        L92:
            r5 = move-exception
            r5.printStackTrace()
            goto L73
        L97:
            r13 = move-exception
            if (r9 == 0) goto L9d
            r9.close()     // Catch: java.io.IOException -> L9e
        L9d:
            throw r13
        L9e:
            r5 = move-exception
            r5.printStackTrace()
            goto L9d
        La3:
            r5 = move-exception
            r5.printStackTrace()
            goto L73
        La8:
            r13 = 0
            goto L16
        Lab:
            r5 = move-exception
            r9 = r10
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.call.screenshare.util.SPenSDKUtils.saveBitmapPNGWithBackgroundColor(java.lang.String, android.graphics.Bitmap, int):boolean");
    }

    public static boolean isValidImagePath(String strImagePath) {
        if (strImagePath == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(strImagePath, options);
        return options.outMimeType != null;
    }

    public static boolean isValidSaveName(String fileName) {
        int len = fileName.length();
        for (int i = 0; i < len; i++) {
            char c = fileName.charAt(i);
            if (c == '\\' || c == ':' || c == '/' || c == '*' || c == '?' || c == '\"' || c == '<' || c == '>' || c == '|' || c == '\t' || c == '\n') {
                return false;
            }
        }
        return true;
    }

    public static Bitmap getSafeResizingBitmap(String strImagePath, int nMaxResizedWidth, int nMaxResizedHeight, boolean checkOrientation) {
        int nSampleSize;
        BitmapFactory.Options options = getBitmapSize(strImagePath);
        if (options == null) {
            return null;
        }
        int degree = 0;
        if (checkOrientation) {
            degree = getExifDegree(strImagePath);
        }
        if (degree == 90 || degree == 270) {
            nSampleSize = getSafeResizingSampleSize(options.outHeight, options.outWidth, nMaxResizedWidth, nMaxResizedHeight);
        } else {
            nSampleSize = getSafeResizingSampleSize(options.outWidth, options.outHeight, nMaxResizedWidth, nMaxResizedHeight);
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = nSampleSize;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        Bitmap photo = BitmapFactory.decodeFile(strImagePath, options);
        if (checkOrientation) {
            if (degree == 90 || degree == 270) {
                return getRotatedBitmap(photo, degree);
            }
            return photo;
        }
        return photo;
    }

    public static Bitmap decodeImageFile(String strImagePath, BitmapFactory.Options options, boolean checkOrientation) {
        if (!checkOrientation) {
            return BitmapFactory.decodeFile(strImagePath, options);
        }
        Bitmap bm = BitmapFactory.decodeFile(strImagePath, options);
        int degree = getExifDegree(strImagePath);
        return getRotatedBitmap(bm, degree);
    }

    public static BitmapFactory.Options getBitmapSize(String strImagePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(strImagePath, options);
        return options;
    }

    public static BitmapFactory.Options getBitmapSize(String strImagePath, boolean checkOrientation) {
        int degree;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(strImagePath, options);
        if (checkOrientation && ((degree = getExifDegree(strImagePath)) == 90 || degree == 270)) {
            int temp = options.outWidth;
            options.outWidth = options.outHeight;
            options.outHeight = temp;
        }
        return options;
    }

    public static int getSafeResizingSampleSize(int nOrgWidth, int nOrgHeight, int nMaxWidth, int nMaxHeight) {
        float fWidthScale = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        float fHeightScale = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (nOrgWidth <= nMaxWidth && nOrgHeight <= nMaxHeight) {
            return 1;
        }
        if (nOrgWidth > nMaxWidth) {
            fWidthScale = nOrgWidth / nMaxWidth;
        }
        if (nOrgHeight > nMaxHeight) {
            fHeightScale = nOrgHeight / nMaxHeight;
        }
        float fsize = fWidthScale >= fHeightScale ? fWidthScale : fHeightScale;
        int size = (int) fsize;
        return size;
    }

    public static int getExifDegree(String filepath) {
        int orientation;
        int degree = 0;
        try {
            ExifInterface exif = new ExifInterface(filepath);
            if (exif != null && (orientation = exif.getAttributeInt("Orientation", -1)) != -1) {
                switch (orientation) {
                    case 3:
                        degree = EngineCallBackInterface.SIP_RINGTONE_NONE;
                        break;
                    case 6:
                        degree = 90;
                        break;
                    case 8:
                        degree = InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MIDDLE_ALIGN_EVENT;
                        break;
                }
            }
            return degree;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getRotatedBitmap(Bitmap bitmap, int degrees) {
        if (degrees != 0 && bitmap != null) {
            Matrix m = new Matrix();
            m.setRotate(degrees, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                Bitmap b2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
                if (bitmap.equals(b2)) {
                    bitmap.recycle();
                    return b2;
                }
                return bitmap;
            } catch (OutOfMemoryError ex) {
                ex.printStackTrace();
                return bitmap;
            }
        }
        return bitmap;
    }

    public static HashMap<String, Integer> getSettingLayoutLocaleResourceMap(boolean bUsePenSetting, boolean bUseEraserSetting, boolean bUseTextSetting, boolean bUseFillingSetting) {
        HashMap<String, Integer> settingResourceMapInt = new HashMap<>();
        if (bUsePenSetting) {
            settingResourceMapInt.put(SCanvasConstants.LAYOUT_PEN_SPINNER, Integer.valueOf(C0000R.layout.screenshare_mspinner));
            settingResourceMapInt.put(SCanvasConstants.LAYOUT_TEXT_SPINNER, Integer.valueOf(C0000R.layout.screenshare_mspinnertext));
        }
        if (bUsePenSetting) {
            settingResourceMapInt.put(SCanvasConstants.LOCALE_PEN_SETTING_TITLE, Integer.valueOf(C0000R.string.screenshare_pen_settings));
            settingResourceMapInt.put(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EMPTY_MESSAGE, Integer.valueOf(C0000R.string.screenshare_pen_settings_preset_empty));
            settingResourceMapInt.put(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_DELETE_TITLE, Integer.valueOf(C0000R.string.my_profile_question_delete));
            settingResourceMapInt.put(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_DELETE_MESSAGE, Integer.valueOf(C0000R.string.screenshare_pen_settings_preset_delete_msg));
            settingResourceMapInt.put(SCanvasConstants.LOCALE_TEXTBOX_HINT_SIZE, Integer.valueOf(C0000R.string.screenshare_textbox_hint_size));
        }
        if (bUseEraserSetting) {
            settingResourceMapInt.put(SCanvasConstants.LOCALE_ERASER_SETTING_TITLE, Integer.valueOf(C0000R.string.screenshare_eraser_settings));
            settingResourceMapInt.put(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL, Integer.valueOf(C0000R.string.screenshare_clear));
        }
        settingResourceMapInt.put(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION, Integer.valueOf(C0000R.string.close));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR, Integer.valueOf(C0000R.string.custom_color_desc));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR, Integer.valueOf(C0000R.string.defined_color_desc));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_PEN_PREVIEW, Integer.valueOf(C0000R.string.pen_preview_desc));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_PENTYPE_SOLID, Integer.valueOf(C0000R.string.pentype_desc_solid));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_PENTYPE_BRUSH, Integer.valueOf(C0000R.string.pentype_desc_brush));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_PENTYPE_CHINESE_BRUSH, Integer.valueOf(C0000R.string.pentype_desc_chinese_brush));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_PENTYPE_CRAYON, Integer.valueOf(C0000R.string.pentype_desc_crayon));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_PENTYPE_MARKER, Integer.valueOf(C0000R.string.pentype_desc_marker));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_SIZE, Integer.valueOf(C0000R.string.seekbar_size_desc));
        settingResourceMapInt.put(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_OPACITY, Integer.valueOf(C0000R.string.seekbar_opacity_desc));
        return settingResourceMapInt;
    }

    public static HashMap<String, String> getSettingLayoutStringResourceMap(boolean bUsePenSetting, boolean bUseEraserSetting, boolean bUseTextSetting, boolean bUseFillingSetting) {
        HashMap<String, String> settingResourceMapString = new HashMap<>();
        settingResourceMapString.put(SCanvasConstants.USER_FONT_PATH1, "fonts/chococooky.ttf");
        settingResourceMapString.put(SCanvasConstants.USER_FONT_PATH2, "fonts/rosemary.ttf");
        settingResourceMapString.put(SCanvasConstants.CUSTOM_RESOURCE_ASSETS_PATH, "spen_sdk_resource_default");
        return settingResourceMapString;
    }
}
