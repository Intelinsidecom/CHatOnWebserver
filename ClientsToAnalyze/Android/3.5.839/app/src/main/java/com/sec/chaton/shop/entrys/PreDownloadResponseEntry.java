package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;

/* loaded from: classes.dex */
public class PreDownloadResponseEntry extends Entry {
    public Integer aniconType;
    public Integer bgtype;
    public Integer dvLandscape;
    public Integer dvPortrait;
    public String fileType;
    public Long itemType;
    public Integer pixelSize;
    public Integer stHeight;
    public Integer stWidth;

    public PreDownloadResponseEntry(long j, int i, int i2, int i3, int i4, int i5) {
        this.itemType = null;
        this.fileType = null;
        this.pixelSize = null;
        this.stWidth = null;
        this.stHeight = null;
        this.dvLandscape = null;
        this.dvPortrait = null;
        this.bgtype = null;
        this.aniconType = null;
        this.itemType = new Long(j);
        this.stWidth = new Integer(i);
        this.stHeight = new Integer(i2);
        this.dvLandscape = new Integer(i3);
        this.dvPortrait = new Integer(i4);
        this.bgtype = new Integer(i5);
    }

    public PreDownloadResponseEntry(long j, String str, int i) {
        this.itemType = null;
        this.fileType = null;
        this.pixelSize = null;
        this.stWidth = null;
        this.stHeight = null;
        this.dvLandscape = null;
        this.dvPortrait = null;
        this.bgtype = null;
        this.aniconType = null;
        this.itemType = new Long(j);
        this.fileType = new String(str);
        this.pixelSize = new Integer(i);
    }

    public PreDownloadResponseEntry(long j, String str, int i, int i2) {
        this.itemType = null;
        this.fileType = null;
        this.pixelSize = null;
        this.stWidth = null;
        this.stHeight = null;
        this.dvLandscape = null;
        this.dvPortrait = null;
        this.bgtype = null;
        this.aniconType = null;
        this.itemType = new Long(j);
        this.fileType = new String(str);
        this.pixelSize = new Integer(i);
        this.aniconType = new Integer(i2);
    }

    public PreDownloadResponseEntry(long j, String str) {
        this.itemType = null;
        this.fileType = null;
        this.pixelSize = null;
        this.stWidth = null;
        this.stHeight = null;
        this.dvLandscape = null;
        this.dvPortrait = null;
        this.bgtype = null;
        this.aniconType = null;
        this.itemType = new Long(j);
        this.fileType = new String(str);
    }

    public PreDownloadResponseEntry(long j) {
        this.itemType = null;
        this.fileType = null;
        this.pixelSize = null;
        this.stWidth = null;
        this.stHeight = null;
        this.dvLandscape = null;
        this.dvPortrait = null;
        this.bgtype = null;
        this.aniconType = null;
        this.itemType = new Long(j);
    }
}
