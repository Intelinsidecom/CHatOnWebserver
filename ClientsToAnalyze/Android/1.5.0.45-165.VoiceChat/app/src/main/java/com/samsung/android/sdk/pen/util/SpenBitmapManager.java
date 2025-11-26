package com.samsung.android.sdk.pen.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class SpenBitmapManager {
    private static LinkedList<Info> mList = new LinkedList<>();
    private static LinkedList<Info> mRemoveReservedList = new LinkedList<>();
    private static int mProtect = 0;

    private static native int _createNativeBitmap(Bitmap bitmap);

    private static native void _deleteNativeAncenstor(int i);

    private static native int _getNativeBitmapRef(int i);

    static class Info {
        Bitmap jbitmap = null;
        int handle = 0;

        Info() {
        }
    }

    private static void printLog() {
        Log.i("BitmapManager", "↓↓↓↓ Bitmap Manager (P" + mProtect + ") ↓↓↓↓");
        Log.i("BitmapManager", "Count = " + mList.size());
        Log.i("BitmapManager", "Reserved Count = " + mRemoveReservedList.size());
        Log.i("BitmapManager", "↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
    }

    private static int bitmapCount() {
        return mList.size();
    }

    private static int decodeBitmapFile(String uri) {
        Bitmap bitmap = BitmapFactory.decodeFile(uri);
        if (bitmap == null) {
            return 0;
        }
        return bindBitmap(bitmap);
    }

    private static int bindBitmap(Bitmap jbitmap) {
        Iterator<Info> iter = mList.iterator();
        while (iter.hasNext()) {
            Info info = iter.next();
            if (info.jbitmap.equals(jbitmap)) {
                return info.handle;
            }
        }
        if (mProtect > 0) {
            Iterator<Info> riter = mRemoveReservedList.iterator();
            while (riter.hasNext()) {
                Info info2 = riter.next();
                if (info2.jbitmap.equals(jbitmap)) {
                    mList.add(info2);
                    riter.remove();
                    return info2.handle;
                }
            }
        }
        Info info3 = new Info();
        info3.jbitmap = jbitmap;
        info3.handle = _createNativeBitmap(jbitmap);
        if (info3.handle == 0) {
            info3.jbitmap.recycle();
            info3.jbitmap = null;
            return 0;
        }
        mList.add(info3);
        printLog();
        return info3.handle;
    }

    private static int releaseBitmap(Bitmap jbitmap) {
        Iterator<Info> iter = mList.iterator();
        while (iter.hasNext()) {
            Info info = iter.next();
            if (info.jbitmap.equals(jbitmap)) {
                int ref = _getNativeBitmapRef(info.handle);
                if (ref != 1) {
                    return ref;
                }
                if (mProtect > 0) {
                    mRemoveReservedList.add(info);
                } else {
                    info.jbitmap.recycle();
                    _deleteNativeAncenstor(info.handle);
                }
                iter.remove();
                printLog();
                return 0;
            }
        }
        return -1;
    }

    private static int createBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            Log.e("BitmapManager", "createBitmap(bitmap==null) failed");
            return 0;
        }
        Info info = new Info();
        info.jbitmap = bitmap;
        info.handle = _createNativeBitmap(bitmap);
        if (info.handle == 0) {
            info.jbitmap.recycle();
            info.jbitmap = null;
            return 0;
        }
        mList.add(info);
        printLog();
        return info.handle;
    }

    private static int createBitmap(int[] buffer, int width, int height, int rowBytes, boolean isMutable) {
        Bitmap bitmap = Bitmap.createBitmap(buffer, width, height, Bitmap.Config.ARGB_8888);
        if (bitmap == null) {
            Log.e("BitmapManager", "createBitmap(width=" + width + ", height=" + height + ") failed");
            return 0;
        }
        Info info = new Info();
        info.jbitmap = bitmap;
        info.handle = _createNativeBitmap(bitmap);
        if (info.handle == 0) {
            info.jbitmap.recycle();
            info.jbitmap = null;
            return 0;
        }
        mList.add(info);
        printLog();
        return info.handle;
    }

    private static int createBitmap(String uri, int width, int height) {
        Bitmap bitmap;
        Uri parser = Uri.parse(uri);
        String scheme = parser.getScheme();
        if (scheme != null) {
            if (scheme.compareToIgnoreCase("file") == 0) {
                uri = "/" + parser.getAuthority() + parser.getPath();
            } else {
                scheme.compareToIgnoreCase("spd");
            }
        }
        if (width == 0 && height == 0) {
            bitmap = BitmapFactory.decodeFile(uri);
        } else {
            BitmapFactory.Options option = new BitmapFactory.Options();
            option.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri, option);
            option.inSampleSize = Math.min(option.outWidth / width, option.outHeight / height);
            option.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(uri, option);
        }
        if (bitmap == null) {
            Log.e("BitmapManager", "createBitmap(" + uri + ") failed");
            return 0;
        }
        Info info = new Info();
        info.jbitmap = bitmap;
        info.handle = _createNativeBitmap(bitmap);
        if (info.handle == 0) {
            info.jbitmap.recycle();
            info.jbitmap = null;
            return 0;
        }
        mList.add(info);
        printLog();
        return info.handle;
    }

    private static boolean saveBitmap(int handle, String uri) throws Throwable {
        Iterator<Info> iter = mList.iterator();
        while (iter.hasNext()) {
            Info info = iter.next();
            if (info.handle == handle) {
                boolean rnt = false;
                File file = new File(uri);
                OutputStream stream = null;
                try {
                    try {
                        if (file.createNewFile()) {
                            OutputStream stream2 = new FileOutputStream(file);
                            try {
                                rnt = info.jbitmap.compress(Bitmap.CompressFormat.PNG, 100, stream2);
                                stream = stream2;
                            } catch (Exception e) {
                                e = e;
                                stream = stream2;
                                e.printStackTrace();
                                Log.e("BitmapManager", "saveBitmap(" + uri + ") failed");
                                if (stream == null) {
                                    return false;
                                }
                                try {
                                    stream.close();
                                    return false;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    Log.e("BitmapManager", "saveBitmap(" + uri + ") failed");
                                    return false;
                                }
                            } catch (Throwable th) {
                                th = th;
                                stream = stream2;
                                if (stream != null) {
                                    try {
                                        stream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        Log.e("BitmapManager", "saveBitmap(" + uri + ") failed");
                                    }
                                }
                                throw th;
                            }
                        }
                        if (stream == null) {
                            return rnt;
                        }
                        try {
                            stream.close();
                            return rnt;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            Log.e("BitmapManager", "saveBitmap(" + uri + ") failed");
                            return rnt;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
        }
        return false;
    }

    private static int releaseBitmap(int handle) {
        Iterator<Info> iter = mList.iterator();
        while (iter.hasNext()) {
            Info info = iter.next();
            if (info.handle == handle) {
                int ref = _getNativeBitmapRef(info.handle);
                if (ref != 1) {
                    return ref;
                }
                if (mProtect > 0) {
                    mRemoveReservedList.add(info);
                } else {
                    info.jbitmap.recycle();
                    _deleteNativeAncenstor(info.handle);
                }
                iter.remove();
                printLog();
                return 0;
            }
        }
        return -1;
    }

    private static Bitmap findBitmap(int handle) {
        Iterator<Info> iter = mList.iterator();
        while (iter.hasNext()) {
            Info info = iter.next();
            if (info.handle == handle) {
                return info.jbitmap;
            }
        }
        return null;
    }

    private static int bindMutableClone(int handle) {
        Iterator<Info> iter = mList.iterator();
        while (iter.hasNext()) {
            Info info = iter.next();
            if (info.handle == handle) {
                Info newbie = new Info();
                newbie.jbitmap = info.jbitmap.copy(info.jbitmap.getConfig(), true);
                newbie.handle = _createNativeBitmap(newbie.jbitmap);
                if (newbie.handle == 0) {
                    newbie.jbitmap.recycle();
                    newbie.jbitmap = null;
                    return 0;
                }
                mList.add(newbie);
                printLog();
                return newbie.handle;
            }
        }
        return 0;
    }

    private static void protectRemoval() {
        mProtect++;
    }

    private static void unprotectRemoval() {
        mProtect--;
        if (mProtect == 0) {
            Iterator<Info> riter = mRemoveReservedList.iterator();
            while (riter.hasNext()) {
                Info info = riter.next();
                info.jbitmap.recycle();
                _deleteNativeAncenstor(info.handle);
            }
            mRemoveReservedList.clear();
        }
    }

    private static boolean isBuildTypeEngMode() {
        return "eng".equals(Build.TYPE);
    }
}
