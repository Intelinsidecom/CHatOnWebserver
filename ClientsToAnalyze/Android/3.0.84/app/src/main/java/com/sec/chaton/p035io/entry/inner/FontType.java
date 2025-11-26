package com.sec.chaton.p035io.entry.inner;

import android.graphics.Typeface;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.downloads.C2570bj;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class FontType {
    String category;
    String fileName;
    float fontFileSize;
    String fontTitle;

    /* renamed from: id */
    int f5646id;
    String thumbnailImagePath;

    public FontType() {
    }

    FontType(String str, String str2, String str3, int i, String str4, int i2) {
        this.thumbnailImagePath = str;
        this.fileName = str2;
        this.fontTitle = str3;
        this.fontFileSize = i;
        this.category = str;
        this.f5646id = i2;
    }

    public FontType(String str, String str2, int i) {
        this.fontTitle = str;
        this.fileName = str2;
        this.f5646id = i;
    }

    public String getThumbnailImagePath() {
        return this.thumbnailImagePath;
    }

    public void setThumbnailImagePath(String str) {
        this.thumbnailImagePath = str;
    }

    public String getFontTitle() {
        return this.fontTitle;
    }

    public void setFontTitle(String str) {
        this.fontTitle = str;
    }

    public float getFontFileSize() {
        return this.fontFileSize;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setId(int i) {
        this.f5646id = i;
    }

    public int getId() {
        return this.f5646id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFontFileSize(float f) {
        this.fontFileSize = f;
    }

    public boolean retrieveFromPrefereceValue(String str) {
        return this.fontTitle == str;
    }

    public Typeface getFontType() {
        if (!getFontTitle().equals(GlobalApplication.m6451b().getString(R.string.chaton_default))) {
            String path = C2570bj.m9521c(CommonApplication.m11493l(), Integer.toString(getId())).getPath();
            C3250y.m11450b("Font added from " + path, getClass().getSimpleName());
            try {
                return Typeface.createFromFile(path);
            } catch (Exception e) {
                C3250y.m11450b("Cannot make font from file", getClass().getSimpleName());
                return null;
            }
        }
        return Typeface.SANS_SERIF;
    }
}
