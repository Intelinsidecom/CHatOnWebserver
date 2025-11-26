package com.sec.chaton.shop.p099a;

import com.sec.chaton.p072k.p073a.C2477a;
import com.sec.chaton.shop.entrys.ItemCharacterEntry;
import com.sec.common.p126d.p127a.AbstractC4976a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: GetCharacterTask.java */
/* renamed from: com.sec.chaton.shop.a.b */
/* loaded from: classes.dex */
public class C3704b extends AbstractC4976a {
    @Override // com.sec.common.p126d.p127a.AbstractC4976a
    public Object parse(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            C2477a c2477a = new C2477a();
            c2477a.m10711b(ItemCharacterEntry.class);
            return c2477a.parse(inputStream);
        } catch (Exception e) {
            if (e != null) {
                throw new IOException(e.getMessage());
            }
            throw new IOException();
        }
    }
}
