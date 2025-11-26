package com.samsung.android.sdk.pen.util;

import android.content.Context;
import android.graphics.Typeface;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class SpenFont {
    private static boolean isInit = false;
    private static LinkedHashMap<String, Typeface> mTypeFaceMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, String> mFontNameMap = new LinkedHashMap<>();
    private static ArrayList<String> mFontTypeList = new ArrayList<>();
    private static HashMap<String, String> mFontNames = new HashMap<>();

    private static native boolean native_appendFontPath(String str);

    private SpenFont() {
    }

    public SpenFont(Context context, HashMap<String, String> fontNames) {
        if (!isInit) {
            mFontNames.clear();
            mTypeFaceMap.clear();
            mFontTypeList.clear();
            mFontNames.clear();
            mFontNames = fontNames;
            getFontTypeList(context);
            isInit = true;
        }
    }

    public static Typeface getTypeFace(String fontName) {
        return mTypeFaceMap.get(fontName);
    }

    public static Typeface getTypeFace(int index) {
        List<Map.Entry<String, Typeface>> mTypeFaceMapAccess = new ArrayList<>(mTypeFaceMap.entrySet());
        return mTypeFaceMapAccess.get(index).getValue();
    }

    public static String getFontName(String fontName) {
        return mFontNameMap.get(fontName);
    }

    public static String getFontName(int index) {
        List<Map.Entry<String, Typeface>> mTypeFaceMapAccess = new ArrayList<>(mTypeFaceMap.entrySet());
        return mTypeFaceMapAccess.get(index).getKey();
    }

    public static List<String> getFontList() {
        return mFontTypeList;
    }

    private void getFontTypeList(Context context) {
        File[] fontFile;
        File[] fontFile2;
        File systemFontFile = new File("/system/fonts/");
        if (systemFontFile.listFiles() != null && (fontFile2 = systemFontFile.listFiles()) != null) {
            for (File file1 : fontFile2) {
                if (file1.getName().endsWith("Roboto-Regular.ttf")) {
                    mFontTypeList.add("Roboto");
                    mTypeFaceMap.put("Roboto-Regular", Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf"));
                    mFontNameMap.put("Roboto-Regular", "Roboto");
                } else if (file1.getName().endsWith("Roboto-Light.ttf")) {
                    mFontTypeList.add("Roboto Light");
                    mTypeFaceMap.put("Roboto-Light", Typeface.createFromFile("/system/fonts/Roboto-Light.ttf"));
                    mFontNameMap.put("Roboto-Light", "Roboto Light");
                } else if (file1.getName().endsWith("RobotoCondensed-Regular.ttf")) {
                    mFontTypeList.add("Roboto Condensed");
                    mTypeFaceMap.put("RobotoCondensed-Regular", Typeface.createFromFile("/system/fonts/RobotoCondensed-Regular.ttf"));
                    mFontNameMap.put("RobotoCondensed-Regular", "Roboto Condensed");
                } else if (file1.getName().endsWith("DroidSerif-Regular.ttf")) {
                    mFontTypeList.add("Droid Serif");
                    mTypeFaceMap.put("DroidSerif-Regular", Typeface.createFromFile("/system/fonts/DroidSerif-Regular.ttf"));
                    mFontNameMap.put("DroidSerif-Regular", "Droid Serif");
                } else if (file1.getName().endsWith("SamsungSans_Regular.ttf")) {
                    mFontTypeList.add("Samsung Sans");
                    mTypeFaceMap.put("SamsungSans_Regular", Typeface.createFromFile("/system/fonts/SamsungSans_Regular.ttf"));
                    mFontNameMap.put("SamsungSans_Regular", "Samsung Sans");
                } else if (file1.getName().endsWith("Arial.ttf")) {
                    mFontTypeList.add("Arial");
                    mTypeFaceMap.put("Arial", Typeface.createFromFile("/system/fonts/Arial.ttf"));
                    mFontNameMap.put("Arial", "Arial");
                } else if (file1.getName().endsWith("Ttahoma.ttf")) {
                    mFontTypeList.add("Tahoma");
                    mTypeFaceMap.put("Ttahoma", Typeface.createFromFile("/system/fonts/Ttahoma.ttf"));
                    mFontNameMap.put("Ttahoma", "Tahoma");
                } else if (file1.getName().endsWith("Verdana.ttf")) {
                    mFontTypeList.add("Verdana");
                    mTypeFaceMap.put("Verdana", Typeface.createFromFile("/system/fonts/Verdana.ttf"));
                    mFontNameMap.put("Verdana", "Verdana");
                } else if (file1.getName().endsWith("Times.ttf")) {
                    mFontTypeList.add("Times New Roman");
                    mTypeFaceMap.put("Times", Typeface.createFromFile("/system/fonts/Times.ttf"));
                    mFontNameMap.put("Times", "Times New Roman");
                } else if (file1.getName().endsWith("DroidSansGeorgian.ttf")) {
                    mFontTypeList.add("Droid Sans Georgian");
                    mTypeFaceMap.put("DroidSansGeorgian", Typeface.createFromFile("/system/fonts/DroidSansGeorgian.ttf"));
                    mFontNameMap.put("DroidSansGeorgian", "Droid Sans Georgian");
                } else if (file1.getName().endsWith("Cour.ttf")) {
                    mFontTypeList.add("Courier New");
                    mTypeFaceMap.put("Cour", Typeface.createFromFile("/system/fonts/Cour.ttf"));
                    mFontNameMap.put("Cour", "Courier New");
                }
                List<Map.Entry<String, String>> fontNameAccess = new ArrayList<>(mFontNames.entrySet());
                int j = 0;
                while (true) {
                    if (j < mFontNames.size()) {
                        if (!file1.getAbsolutePath().endsWith(fontNameAccess.get(j).getValue())) {
                            j++;
                        } else {
                            if (!mFontTypeList.contains(fontNameAccess.get(j).getKey())) {
                                mFontTypeList.add(fontNameAccess.get(j).getKey());
                            }
                            String fontName = file1.getName().substring(0, file1.getName().length() - 4).replace("-Bold", "").replace("-BoldItalic", "").replace("-Italic", "").replace(" ", "");
                            mTypeFaceMap.put(fontName, Typeface.createFromFile(file1.getAbsolutePath()));
                            mFontNameMap.put(fontName, fontNameAccess.get(j).getKey());
                        }
                    }
                }
            }
        }
        String localFontPath = String.valueOf(context.getFilesDir().getPath().substring(0, context.getFilesDir().getPath().lastIndexOf("/"))) + "/fonts/";
        File localFontFile = new File(localFontPath);
        if (localFontFile.listFiles() != null && (fontFile = localFontFile.listFiles()) != null) {
            for (File file12 : fontFile) {
                List<Map.Entry<String, String>> fontNameAccess2 = new ArrayList<>(mFontNames.entrySet());
                int j2 = 0;
                while (true) {
                    if (j2 < mFontNames.size()) {
                        if (!file12.getAbsolutePath().endsWith(fontNameAccess2.get(j2).getValue())) {
                            j2++;
                        } else {
                            if (!mFontTypeList.contains(fontNameAccess2.get(j2).getKey())) {
                                mFontTypeList.add(fontNameAccess2.get(j2).getKey());
                            }
                            String fontName2 = file12.getName().substring(0, file12.getName().length() - 4).replace("-Bold", "").replace("-BoldItalic", "").replace("-Italic", "").replace(" ", "");
                            mTypeFaceMap.put(fontName2, Typeface.createFromFile(file12.getAbsolutePath()));
                            mFontNameMap.put(fontName2, fontNameAccess2.get(j2).getKey());
                        }
                    }
                }
            }
        }
        native_appendFontPath("/system/csc/common/system/fonts/");
        native_appendFontPath("/system/fonts/");
        native_appendFontPath(localFontPath);
    }
}
