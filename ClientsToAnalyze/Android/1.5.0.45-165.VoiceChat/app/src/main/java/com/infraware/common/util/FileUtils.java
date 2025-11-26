package com.infraware.common.util;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public abstract class FileUtils {
    public static String makeDirectory(String path, boolean isAbsolutePath, Context context) {
        File new_dir;
        File f = new File(path);
        String dirName = f.getName();
        if (!isAbsolutePath && context != null) {
            new_dir = context.getDir(dirName, 3);
        } else {
            new_dir = new File(path);
            if (!new_dir.exists()) {
                new_dir.mkdir();
            }
        }
        if (new_dir.exists()) {
            return new_dir.getPath();
        }
        return null;
    }
}
