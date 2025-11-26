package com.sec.chaton.settings.moreapps.p098a;

import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.settings.moreapps.entry.PlusListEntry;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GetPlusListTask.java */
/* renamed from: com.sec.chaton.settings.moreapps.a.c */
/* loaded from: classes.dex */
public class C3669c extends AbstractC4976a {
    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            C2477a c2477a = new C2477a();
            c2477a.m10711b(PlusListEntry.class);
            return c2477a.parse(inputStream);
        } catch (Exception e) {
            if (e != null) {
                throw new IOException(e.getMessage());
            }
            throw new IOException();
        }
    }
}
