package com.sec.common.p056b.p057a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.sec.common.p055a.C1811a;
import com.sec.common.p056b.C1825d;
import com.sec.common.p056b.p060d.C1828c;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: AnimationBuilder.java */
/* renamed from: com.sec.common.b.a.a */
/* loaded from: classes.dex */
public final class C1813a {

    /* renamed from: a */
    private static final String f6507a = C1813a.class.getSimpleName();

    /* renamed from: a */
    public static AnimationDrawable m6149a(Context context, File file, FilenameFilter filenameFilter, int i, int i2) throws IOException {
        List<C1815c> listM6150b = m6150b(context, file, filenameFilter, i, i2);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (C1815c c1815c : listM6150b) {
            animationDrawable.addFrame(c1815c.m6155b(), c1815c.m6152a());
        }
        listM6150b.clear();
        animationDrawable.selectDrawable(0);
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    /* renamed from: b */
    public static List m6150b(Context context, File file, FilenameFilter filenameFilter, int i, int i2) throws IOException {
        File[] fileArrListFiles;
        if (file == null || !file.isDirectory()) {
            throw new IllegalArgumentException(C1828c.m6207a("Argument isn't directory. ", file));
        }
        if (filenameFilter == null) {
            fileArrListFiles = file.listFiles();
        } else {
            fileArrListFiles = file.listFiles(filenameFilter);
        }
        if (fileArrListFiles.length == 0) {
            throw new IllegalArgumentException(C1828c.m6207a("The directory is empty. ", file));
        }
        Arrays.sort(fileArrListFiles, new C1814b());
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file2 : fileArrListFiles) {
            C1815c c1815c = new C1815c();
            c1815c.m6153a(m6148a(file2.getName()));
            Bitmap bitmapM6144a = C1811a.m6144a(context, file2, i, i2);
            bitmapM6144a.setDensity(160);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM6144a);
            bitmapDrawable.setAntiAlias(true);
            c1815c.m6154a(bitmapDrawable);
            arrayList.add(c1815c);
            if (C1825d.f6539a.f6541b) {
                C1825d.f6539a.m6200a(f6507a, C1828c.m6207a(" Frame >> Path: ", file2.getAbsoluteFile(), ", Duration: " + c1815c.m6152a()));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static int m6148a(String str) {
        try {
            return Integer.parseInt(str.substring(0, str.indexOf(".")).split("_")[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (C1825d.f6539a.f6544e) {
                C1825d.f6539a.m6201a(f6507a, e.getMessage(), e);
            }
            return HttpResponseCode.INTERNAL_SERVER_ERROR;
        }
    }
}
