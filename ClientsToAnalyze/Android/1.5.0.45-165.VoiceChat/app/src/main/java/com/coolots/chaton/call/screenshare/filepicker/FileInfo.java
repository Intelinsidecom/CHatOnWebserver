package com.coolots.chaton.call.screenshare.filepicker;

/* loaded from: classes.dex */
public class FileInfo implements Comparable<FileInfo> {
    public static final int DIR = 1;
    public static final int DOC = 5;
    public static final int ETC = -1;
    public static final int EXCEL = 3;
    public static final int PARENT_DIR = 0;
    public static final int PDF = 6;
    public static final int POWERPOINT = 4;
    public static final int TEXT = 2;
    private int category;
    private int iconResId;
    private boolean isDisplayable;
    private String name;
    private String path;

    public FileInfo() {
        this.name = null;
        this.path = null;
        this.iconResId = 0;
        this.category = -1;
        this.isDisplayable = false;
    }

    public FileInfo(String name, String path, int iconResId, int category, boolean isDisplayable) {
        this.name = name;
        this.path = path;
        this.iconResId = iconResId;
        this.category = category;
        this.isDisplayable = isDisplayable;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isDisplayable() {
        return this.isDisplayable;
    }

    public void setDisplayable(boolean isDisplayable) {
        this.isDisplayable = isDisplayable;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    @Override // java.lang.Comparable
    public int compareTo(FileInfo another) {
        if (this.name != null) {
            return this.name.toLowerCase().compareTo(another.getName().toLowerCase());
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<CIH>");
        sb.append("name = " + this.name);
        sb.append(", ");
        sb.append("path = " + this.path);
        sb.append(", ");
        sb.append("category = " + this.category);
        sb.append(", ");
        sb.append("isDisplayable = " + this.isDisplayable);
        sb.append("\n");
        return sb.toString();
    }
}
