package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface LazyStringList extends List {
    void add(ByteString byteString);

    ByteString getByteString(int i);
}
