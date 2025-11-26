package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public class LazyStringArrayList extends AbstractList implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
    private final List list;

    public LazyStringArrayList() {
        this.list = new ArrayList();
    }

    public LazyStringArrayList(List list) {
        this.list = new ArrayList(list);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        Object obj = this.list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.list.set(i, stringUtf8);
        }
        return stringUtf8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public String set(int i, String str) {
        return asString(this.list.set(i, str));
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, String str) {
        this.list.add(i, str);
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        boolean zAddAll = this.list.addAll(i, collection);
        this.modCount++;
        return zAddAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        Object objRemove = this.list.remove(i);
        this.modCount++;
        return asString(objRemove);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.list.clear();
        this.modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public void add(ByteString byteString) {
        this.list.add(byteString);
        this.modCount++;
    }

    @Override // com.google.protobuf.LazyStringList
    public ByteString getByteString(int i) {
        Object obj = this.list.get(i);
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.list.set(i, byteStringCopyFromUtf8);
        return byteStringCopyFromUtf8;
    }

    private String asString(Object obj) {
        return obj instanceof String ? (String) obj : ((ByteString) obj).toStringUtf8();
    }
}
