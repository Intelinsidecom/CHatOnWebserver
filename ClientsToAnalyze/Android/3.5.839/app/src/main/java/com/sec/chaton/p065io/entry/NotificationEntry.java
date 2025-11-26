package com.sec.chaton.p065io.entry;

import com.sec.chaton.p065io.entry.inner.Badge;
import com.sec.chaton.p065io.entry.inner.NewFeature;
import com.sec.chaton.p065io.entry.inner.PromotionList;
import com.sec.chaton.p065io.entry.inner.SeasonalTheme;
import com.sec.chaton.p065io.entry.inner.TrunkList;
import com.sec.chaton.p065io.entry.inner.WebLoginInfo;

/* loaded from: classes.dex */
public class NotificationEntry extends Entry {
    public String utctimestamp;
    public Badge badge = new Badge();
    public TrunkList trunklist = new TrunkList();
    public NewFeature newfeaturelist = new NewFeature();
    public SeasonalTheme themelist = new SeasonalTheme();
    public WebLoginInfo weblogininfo = new WebLoginInfo();
    public PromotionList promotionlist = new PromotionList();
}
