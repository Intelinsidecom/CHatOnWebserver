package com.samsung.samm.common;

/* loaded from: classes.dex */
public class SOptionSAMM {
    public static final int SAMM_CONTETNS_QUALITY_MAX = 0;
    public static final int SAMM_CONTETNS_QUALITY_MEDIUM = 1;
    public static final int SAMM_CONTETNS_QUALITY_MINIMUM = 2;
    public static final int SAMM_CONTETNS_QUALITY_ORIGINAL = 3;
    public static final int SAMM_LOAD_OPTION_CONVERT_SIZE_FITINSIDE = 1;
    public static final int SAMM_LOAD_OPTION_CONVERT_SIZE_FITTOSIZE = 0;
    public static final int SAMM_LOAD_OPTION_CONVERT_SIZE_ORIGINAL = 2;
    public static final int SAMM_SAVE_OPTION_COMPACT_SIZE = 2;
    public static final int SAMM_SAVE_OPTION_MEDIUM_SIZE = 1;
    public static final int SAMM_SAVE_OPTION_ORIGINAL_SIZE = 0;
    public static final int SAMM_SAVE_OPTION_THUMBNAIL_SIZE = 3;

    @Deprecated
    public static final int SAMM_SAVE_OPTION_THUMNAIL_SIZE = 3;

    /* renamed from: a */
    private int f430a = 0;

    /* renamed from: b */
    private int f431b = 1;

    /* renamed from: c */
    private int f432c = 0;

    /* renamed from: d */
    private boolean f433d = false;

    /* renamed from: e */
    private boolean f434e = false;

    /* renamed from: f */
    private boolean f435f = false;

    /* renamed from: g */
    private boolean f436g = false;

    /* renamed from: h */
    private boolean f437h = false;

    /* renamed from: i */
    private int f438i = 1;

    /* renamed from: j */
    private int f439j = 100;

    /* renamed from: k */
    private boolean f440k = false;

    /* renamed from: l */
    private boolean f441l = true;

    /* renamed from: m */
    private int f442m = 1;

    public boolean setConvertCanvasSizeOption(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return false;
        }
        this.f430a = i;
        return true;
    }

    public int getConvertCanvasSizeOption() {
        return this.f430a;
    }

    public boolean setConvertCanvasHorizontalAlignOption(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return false;
        }
        this.f431b = i;
        return true;
    }

    public int getConvertCanvasHorizontalAlignOption() {
        return this.f431b;
    }

    public boolean setConvertCanvasVerticalAlignOption(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return false;
        }
        this.f432c = i;
        return true;
    }

    public int getConvertCanvasVerticalAlignOption() {
        return this.f432c;
    }

    public boolean setSaveImageSize(int i) {
        if (i < 0 || i > 3) {
            return false;
        }
        this.f438i = i;
        return true;
    }

    public int getSaveImageSize() {
        return this.f438i;
    }

    public boolean setJPGImageQuality(int i) {
        if (i < 1 || i > 100) {
            return false;
        }
        this.f439j = i;
        return true;
    }

    public int getJPGImageQuality() {
        return this.f439j;
    }

    public void setSaveOnlyForegroundImage(boolean z) {
        this.f440k = z;
    }

    public boolean isSaveOnlyForegroundImage() {
        return this.f440k;
    }

    public void setCreateNewImageFile(boolean z) {
        this.f441l = z;
    }

    public boolean isCreateNewImageFile() {
        return this.f441l;
    }

    public boolean setContentsQuality(int i) {
        if (i < 0 || i > 3) {
            return false;
        }
        this.f442m = i;
        return true;
    }

    public int getContentsQuality() {
        return this.f442m;
    }

    public void setSaveImageLeftCroppingOption(boolean z) {
        this.f433d = z;
    }

    public boolean getSaveImageLeftCroppingOption() {
        return this.f433d;
    }

    public void setSaveImageRightCroppingOption(boolean z) {
        this.f434e = z;
    }

    public boolean getSaveImageRightCroppingOption() {
        return this.f434e;
    }

    public void setSaveImageTopCroppingOption(boolean z) {
        this.f435f = z;
    }

    public boolean getSaveImageTopCroppingOption() {
        return this.f435f;
    }

    public void setSaveImageBottomCroppingOption(boolean z) {
        this.f436g = z;
    }

    public boolean getSaveImageBottomCroppingOption() {
        return this.f436g;
    }

    public void setSaveContentsCroppingOption(boolean z) {
        this.f437h = z;
    }

    public boolean getSaveContentsCroppingOption() {
        return this.f437h;
    }
}
