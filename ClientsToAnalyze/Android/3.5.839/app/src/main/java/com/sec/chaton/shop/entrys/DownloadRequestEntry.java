package com.sec.chaton.shop.entrys;

import com.sec.chaton.p065io.entry.Entry;
import com.sec.chaton.shop.items.AMSItem;
import com.sec.chaton.shop.items.AmsStampPackage;
import com.sec.chaton.shop.items.AniconPackage;
import com.sec.chaton.shop.items.AniconplusPackage;
import com.sec.chaton.shop.items.BgBubblePackage;
import com.sec.chaton.shop.items.FontItem;
import com.sec.chaton.shop.items.SoundItem;

/* loaded from: classes.dex */
public class DownloadRequestEntry extends Entry {
    public String cancel;
    public int downloadType;
    public long endValidPeriod;
    public String error;
    public long itemId;
    public long itemType;
    public int itemVersion;
    public long startValidPeriod;
    public String success;
    public int termOfUse;
    public AniconPackage aniconPackage = new AniconPackage();
    public AniconplusPackage aniconplusPackage = new AniconplusPackage();
    public AMSItem ams = new AMSItem();
    public AmsStampPackage amsStampPackage = new AmsStampPackage();
    public BgBubblePackage bgBubble = new BgBubblePackage();
    public FontItem font = new FontItem();
    public SoundItem sound = new SoundItem();
}
