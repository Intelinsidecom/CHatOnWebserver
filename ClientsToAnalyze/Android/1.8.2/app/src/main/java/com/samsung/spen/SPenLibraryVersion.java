package com.samsung.spen;

/* loaded from: classes.dex */
public class SPenLibraryVersion {
    public final int BUILD;
    public final int MAJOR;
    public final int MINOR;
    public final String RELEASE;

    SPenLibraryVersion(int i, int i2, int i3) {
        this.MAJOR = i;
        this.MINOR = i2;
        this.BUILD = i3;
        this.RELEASE = new StringBuilder().append(i).append('.').append(i2).append('.').append(i3).toString();
    }
}
