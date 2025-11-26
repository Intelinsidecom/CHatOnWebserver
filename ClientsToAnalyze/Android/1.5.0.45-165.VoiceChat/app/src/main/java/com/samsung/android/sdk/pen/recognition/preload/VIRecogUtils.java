package com.samsung.android.sdk.pen.recognition.preload;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import com.samsung.android.sdk.pen.Spen;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class VIRecogUtils {
    private static final boolean SUPPORT_DB = true;
    private static final String TAG = "VIRecogUtils";

    public static boolean copyDatabase(Context context) {
        return copyDatabase(context, false);
    }

    public static boolean copyDatabase(Context context, boolean bIgnoreExist) throws IOException {
        FileOutputStream fo;
        FileOutputStream fo2;
        Log.i(TAG, "Start copyDatabase()");
        String rootPath = context.getFilesDir().getAbsolutePath();
        try {
            AssetManager asset = context.getPackageManager().getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME).getAssets();
            try {
                String[] strDBname = asset.list("vidata");
                int nDataNum = strDBname.length;
                InputStream is = null;
                File fileDir = new File(String.valueOf(rootPath) + "/vidata");
                if (!fileDir.exists() && !fileDir.mkdirs()) {
                    Log.e(TAG, "Fail to make directory : " + fileDir.getAbsolutePath());
                    return false;
                }
                int ii = 0;
                FileOutputStream fileOutputStream = null;
                Object fileOut = null;
                while (ii < nDataNum) {
                    try {
                        File fileOut2 = new File(String.valueOf(rootPath) + "/vidata/" + strDBname[ii]);
                        try {
                            if (!fileOut2.exists() || bIgnoreExist) {
                                if (!bIgnoreExist) {
                                    Log.i(TAG, "[copyDatabase] There is no DB file : " + fileOut2.getAbsolutePath());
                                }
                                is = asset.open("vidata/" + strDBname[ii]);
                                long fileSize = is.available();
                                byte[] bufferData = new byte[(int) fileSize];
                                if (is.read(bufferData) < 0) {
                                    is.close();
                                    return false;
                                }
                                is.close();
                                is = null;
                                fo = new FileOutputStream(fileOut2);
                                try {
                                    fo.write(bufferData);
                                    fo.close();
                                    fo2 = null;
                                } catch (IOException e) {
                                    e = e;
                                    e.printStackTrace();
                                    if (is != null) {
                                        try {
                                            is.close();
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    if (fo != null) {
                                        try {
                                            fo.close();
                                        } catch (IOException e12) {
                                            e12.printStackTrace();
                                        }
                                    }
                                    return false;
                                }
                            } else {
                                Log.i(TAG, "[copyDatabase] DB file exist : " + fileOut2.getAbsolutePath());
                                fo2 = fileOutputStream;
                            }
                            ii++;
                            fileOutputStream = fo2;
                            fileOut = null;
                        } catch (IOException e2) {
                            e = e2;
                            fo = fileOutputStream;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fo = fileOutputStream;
                    }
                }
                return true;
            } catch (IOException e13) {
                e13.printStackTrace();
                return false;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
