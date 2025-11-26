package com.sec.chaton.multimedia.multisend;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class PreviewData implements Parcelable {
    public static final Parcelable.Creator<PreviewData> CREATOR = new C2878l();
    private String mCategoryId;
    private String mCropFilePath;
    private String mFileName;
    private String mImageData;
    private String mImageId;
    private String mOriInfo;
    private String mUploadSuccessUrl;

    public PreviewData(String str, String str2, String str3, String str4, String str5) {
        this.mImageData = str;
        this.mImageId = str2;
        this.mCategoryId = str3;
        this.mCropFilePath = str4;
        this.mOriInfo = str5;
    }

    public PreviewData(Parcel parcel) {
        this.mImageData = parcel.readString();
        this.mImageId = parcel.readString();
        this.mCategoryId = parcel.readString();
        this.mCropFilePath = parcel.readString();
        this.mOriInfo = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mImageData);
        parcel.writeString(this.mImageId);
        parcel.writeString(this.mCategoryId);
        parcel.writeString(this.mCropFilePath);
        parcel.writeString(this.mOriInfo);
    }

    /* renamed from: a */
    public String m11976a() {
        return this.mImageData;
    }

    /* renamed from: b */
    public String m11978b() {
        return this.mImageId;
    }

    /* renamed from: c */
    public String m11980c() {
        return this.mCategoryId;
    }

    /* renamed from: d */
    public String m11982d() {
        return this.mCropFilePath;
    }

    /* renamed from: e */
    public String m11983e() {
        return this.mOriInfo;
    }

    /* renamed from: a */
    public void m11977a(String str) {
        this.mCropFilePath = str;
    }

    /* renamed from: b */
    public void m11979b(String str) {
        this.mUploadSuccessUrl = str;
    }

    /* renamed from: f */
    public String m11984f() {
        return this.mUploadSuccessUrl;
    }

    /* renamed from: c */
    public void m11981c(String str) {
        this.mFileName = str;
    }

    /* renamed from: g */
    public String m11985g() {
        return this.mFileName;
    }
}
