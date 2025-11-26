package com.google.p034a.p036b.p037a;

import com.google.p034a.AbstractC0562ae;
import com.google.p034a.p039d.C0666a;
import com.google.p034a.p039d.C0669d;
import com.google.p034a.p039d.EnumC0668c;
import java.io.IOException;
import java.util.UUID;

/* compiled from: TypeAdapters.java */
/* renamed from: com.google.a.b.a.am */
/* loaded from: classes.dex */
final class C0579am extends AbstractC0562ae<UUID> {
    C0579am() {
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public UUID mo1949b(C0666a c0666a) throws IOException {
        if (c0666a.mo1992f() != EnumC0668c.NULL) {
            return UUID.fromString(c0666a.mo1994h());
        }
        c0666a.mo1996j();
        return null;
    }

    @Override // com.google.p034a.AbstractC0562ae
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo1948a(C0669d c0669d, UUID uuid) throws IOException {
        c0669d.mo2010b(uuid == null ? null : uuid.toString());
    }
}
