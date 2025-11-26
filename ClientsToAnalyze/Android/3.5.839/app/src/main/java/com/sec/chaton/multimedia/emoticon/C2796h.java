package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import com.sec.common.p132g.C5006b;
import java.util.LinkedList;

/* compiled from: EmoticonMruDataManager.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.h */
/* loaded from: classes.dex */
public class C2796h extends C5006b {
    public C2796h(Context context, String str, int i) {
        super(context, str, i);
    }

    @Override // com.sec.common.p132g.C5006b
    /* renamed from: a */
    public String[] mo11703a() throws NumberFormatException {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.f18265a.size(); i++) {
            try {
                Integer.parseInt(this.f18265a.get(i));
            } catch (Exception e) {
                linkedList.add(this.f18265a.get(i));
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }
}
