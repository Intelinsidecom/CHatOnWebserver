package com.vlingo.sdk.internal.lmtt;

import com.vlingo.sdk.internal.lmtt.LMTTItem;
import com.vlingo.sdk.internal.util.XmlUtils;

/* loaded from: classes.dex */
public class LMTTSongItem extends LMTTItem {
    public String album;
    public String artist;
    public String composer;
    public String folder;
    public String genre;
    public String title;
    public String year;

    public LMTTSongItem(String title, String artist, String composer, String album, String genre, int year, String folder, int uid, LMTTItem.ChangeType changeType) {
        super(LMTTItem.LmttItemType.TYPE_SONG, uid, changeType);
        this.title = title == null ? "" : title;
        this.artist = artist;
        this.composer = composer;
        this.album = album;
        this.genre = genre;
        if (year > 0) {
            this.year = String.valueOf(year);
        }
        this.folder = folder;
    }

    public LMTTSongItem(int uid, LMTTItem.ChangeType changeType) {
        this(null, null, null, null, null, -1, null, uid, changeType);
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getDelXML(StringBuilder sb) {
        sb.append("<SD");
        sb.append(" uid=\"");
        sb.append(this.uid);
        sb.append("\"/>");
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getUpXML(StringBuilder sb) {
        getInsXML(sb);
    }

    @Override // com.vlingo.sdk.internal.lmtt.LMTTItem
    public void getInsXML(StringBuilder sb) {
        sb.append("<SU");
        sb.append(" uid=\"");
        sb.append(this.uid);
        sb.append("\"");
        sb.append(" ttl=\"");
        XmlUtils.xmlEncode(this.title, sb);
        sb.append("\"");
        if (this.artist != null) {
            sb.append(" art=\"");
            XmlUtils.xmlEncode(this.artist, sb);
            sb.append("\"");
        }
        if (this.composer != null) {
            sb.append(" cmp=\"");
            XmlUtils.xmlEncode(this.composer, sb);
            sb.append('\"');
        }
        if (this.album != null) {
            sb.append(" alb=\"");
            XmlUtils.xmlEncode(this.album, sb);
            sb.append('\"');
        }
        if (this.genre != null) {
            sb.append(" gen=\"");
            XmlUtils.xmlEncode(this.genre, sb);
            sb.append('\"');
        }
        if (this.year != null) {
            sb.append(" yr=\"");
            XmlUtils.xmlEncode(this.year, sb);
            sb.append('\"');
        }
        if (this.folder != null) {
            sb.append(" fld=\"");
            XmlUtils.xmlEncode(this.folder, sb);
            sb.append('\"');
        }
        sb.append("/>");
    }

    public String toString() {
        return "LMTTSongItem | uid: " + this.uid + " | changeType: " + this.changeType + " | title: " + this.title;
    }
}
