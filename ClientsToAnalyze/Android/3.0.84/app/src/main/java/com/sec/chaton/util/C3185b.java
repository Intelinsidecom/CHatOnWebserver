package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.sec.common.C3330f;
import com.sec.common.util.C3348j;
import com.sec.common.util.C3364o;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: AnimationBuilder.java */
/* renamed from: com.sec.chaton.util.b */
/* loaded from: classes.dex */
public final class C3185b {

    /* renamed from: a */
    private static final String f11533a = C3185b.class.getSimpleName();

    /* renamed from: a */
    public static AnimationDrawable m11132a(Context context, File file, FilenameFilter filenameFilter, int i, int i2) throws IOException {
        List<C3229d> listM11133b = m11133b(context, file, filenameFilter, i, i2);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (C3229d c3229d : listM11133b) {
            animationDrawable.addFrame(c3229d.m11350b(), c3229d.m11347a());
        }
        listM11133b.clear();
        animationDrawable.selectDrawable(0);
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    /* renamed from: b */
    public static List<C3229d> m11133b(Context context, File file, FilenameFilter filenameFilter, int i, int i2) throws IOException {
        File[] fileArrListFiles;
        if (file == null || !file.isDirectory()) {
            throw new IllegalArgumentException(C3364o.m11849a("Argument isn't directory. ", file));
        }
        if (filenameFilter == null) {
            fileArrListFiles = file.listFiles();
        } else {
            fileArrListFiles = file.listFiles(filenameFilter);
        }
        if (fileArrListFiles.length == 0) {
            throw new IllegalArgumentException(C3364o.m11849a("The directory is empty. ", file));
        }
        Arrays.sort(fileArrListFiles, new C3212c());
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file2 : fileArrListFiles) {
            C3229d c3229d = new C3229d();
            c3229d.m11348a(m11131a(file2.getName()));
            Bitmap bitmapM11791a = C3348j.m11791a(context, file2, i, i2);
            if (bitmapM11791a == null) {
                if (C3330f.f12033a.f11975e) {
                    C3330f.f12033a.m11651a(f11533a, "Can't resize bimtap.");
                }
            } else {
                bitmapM11791a.setDensity(160);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM11791a);
                bitmapDrawable.setAntiAlias(true);
                c3229d.m11349a(bitmapDrawable);
                arrayList.add(c3229d);
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f11533a, C3364o.m11849a(" Frame >> Path: ", file2.getAbsoluteFile(), ", Duration: " + c3229d.m11347a()));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static int m11131a(String str) {
        try {
            return Integer.parseInt(str.substring(0, str.indexOf(".")).split("_")[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f11533a, e.getMessage(), e);
            }
            return HttpResponseCode.INTERNAL_SERVER_ERROR;
        }
    }
}
