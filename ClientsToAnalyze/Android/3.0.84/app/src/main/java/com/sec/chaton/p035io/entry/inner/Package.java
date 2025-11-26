package com.sec.chaton.p035io.entry.inner;

import com.sec.chaton.p035io.entry.Entry;
import com.sec.chaton.p035io.entry.EntryParserInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Package extends Entry {

    @EntryParserInfo(name = "newitem")
    public Integer _new;

    @EntryParserInfo(name = "anicon")
    public List<Anicon> aniconList = new ArrayList();
    public Integer aniconcount;
    public String categoryid;
    public String cdproxyurl;

    @EntryParserInfo(name = "author")
    public String data1;

    @EntryParserInfo(name = "character")
    public String data2;

    @EntryParserInfo(name = "serialnumber")
    public String data3;

    @EntryParserInfo(name = "downloadrank")
    public Integer down_rank;
    public Long expirationdate;

    /* renamed from: id */
    public String f5653id;
    public String name;
    public String packagezipurl;
    public String panelurl;
    public String previewurl;
    public Integer special;
    public String thumbnailurl;
    public Long volume;
}
