package com.sec.chaton.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import com.sec.common.C4996f;
import com.sec.common.util.C5035l;
import com.sec.common.util.C5052r;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: AnimationBuilder.java */
/* renamed from: com.sec.chaton.util.b */
/* loaded from: classes.dex */
public final class C4835b {

    /* renamed from: a */
    private static final String f17648a = C4835b.class.getSimpleName();

    /* renamed from: a */
    public static AnimationDrawable m18305a(Context context, File file, FilenameFilter filenameFilter, int i, int i2) {
        List<C4881d> listM18306b = m18306b(context, file, filenameFilter, i, i2);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (C4881d c4881d : listM18306b) {
            animationDrawable.addFrame(c4881d.m18530b(), c4881d.m18527a());
        }
        listM18306b.clear();
        animationDrawable.selectDrawable(0);
        animationDrawable.setOneShot(false);
        return animationDrawable;
    }

    /* renamed from: b */
    public static List<C4881d> m18306b(Context context, File file, FilenameFilter filenameFilter, int i, int i2) {
        File[] fileArrListFiles;
        if (file == null || !file.isDirectory()) {
            throw new IllegalArgumentException(C5052r.m19199a("Argument isn't directory. ", file));
        }
        if (filenameFilter == null) {
            fileArrListFiles = file.listFiles();
        } else {
            fileArrListFiles = file.listFiles(filenameFilter);
        }
        if (fileArrListFiles.length == 0) {
            throw new IllegalArgumentException(C5052r.m19199a("The directory is empty. ", file));
        }
        Arrays.sort(fileArrListFiles, new C4862c());
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (File file2 : fileArrListFiles) {
            C4881d c4881d = new C4881d();
            c4881d.m18528a(m18304a(file2.getName()));
            try {
                Bitmap bitmapM19109a = C5035l.m19109a(context, file2, i, i2);
                bitmapM19109a.setDensity(160);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapM19109a);
                bitmapDrawable.setAntiAlias(true);
                c4881d.m18529a(bitmapDrawable);
                arrayList.add(c4881d);
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f17648a, C5052r.m19199a(" Frame >> Path: ", file2.getAbsoluteFile(), ", Duration: " + c4881d.m18527a()));
                }
            } catch (IOException e) {
                if (C4996f.f18229a.f18174f) {
                    C4996f.f18229a.m18892f(f17648a, "Can't resize bimtap.");
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static int m18304a(String str) {
        try {
            return Integer.parseInt(str.substring(0, str.indexOf(".")).split("_")[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f17648a, e.getMessage(), e);
            }
            return 500;
        }
    }
}
