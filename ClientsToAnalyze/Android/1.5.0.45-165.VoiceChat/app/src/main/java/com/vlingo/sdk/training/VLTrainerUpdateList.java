package com.vlingo.sdk.training;

import com.vlingo.sdk.internal.VLTrainerUpdateListImpl;

/* loaded from: classes.dex */
public abstract class VLTrainerUpdateList {
    public abstract void addContact(int i, String str, String str2, String str3);

    public abstract void addPlaylist(int i, String str);

    public abstract void addSong(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6);

    public abstract void removeContact(int i);

    public abstract void removePlayList(int i);

    public abstract void removeSong(int i);

    public static VLTrainerUpdateList createList() {
        return new VLTrainerUpdateListImpl();
    }
}
