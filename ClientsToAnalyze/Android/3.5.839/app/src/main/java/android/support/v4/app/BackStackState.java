package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new C0060n();
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final int mTransition;
    final int mTransitionStyle;

    public BackStackState(C0071y c0071y, RunnableC0058l runnableC0058l) {
        int size = 0;
        for (C0059m c0059m = runnableC0058l.f171b; c0059m != null; c0059m = c0059m.f189a) {
            if (c0059m.f197i != null) {
                size += c0059m.f197i.size();
            }
        }
        this.mOps = new int[size + (runnableC0058l.f173d * 7)];
        if (!runnableC0058l.f180k) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        for (C0059m c0059m2 = runnableC0058l.f171b; c0059m2 != null; c0059m2 = c0059m2.f189a) {
            int i2 = i + 1;
            this.mOps[i] = c0059m2.f191c;
            int i3 = i2 + 1;
            this.mOps[i2] = c0059m2.f192d != null ? c0059m2.f192d.mIndex : -1;
            int i4 = i3 + 1;
            this.mOps[i3] = c0059m2.f193e;
            int i5 = i4 + 1;
            this.mOps[i4] = c0059m2.f194f;
            int i6 = i5 + 1;
            this.mOps[i5] = c0059m2.f195g;
            int i7 = i6 + 1;
            this.mOps[i6] = c0059m2.f196h;
            if (c0059m2.f197i != null) {
                int size2 = c0059m2.f197i.size();
                int i8 = i7 + 1;
                this.mOps[i7] = size2;
                int i9 = 0;
                while (i9 < size2) {
                    this.mOps[i8] = c0059m2.f197i.get(i9).mIndex;
                    i9++;
                    i8++;
                }
                i = i8;
            } else {
                i = i7 + 1;
                this.mOps[i7] = 0;
            }
        }
        this.mTransition = runnableC0058l.f178i;
        this.mTransitionStyle = runnableC0058l.f179j;
        this.mName = runnableC0058l.f182m;
        this.mIndex = runnableC0058l.f184o;
        this.mBreadCrumbTitleRes = runnableC0058l.f185p;
        this.mBreadCrumbTitleText = runnableC0058l.f186q;
        this.mBreadCrumbShortTitleRes = runnableC0058l.f187r;
        this.mBreadCrumbShortTitleText = runnableC0058l.f188s;
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    /* renamed from: a */
    public RunnableC0058l m31a(C0071y c0071y) {
        RunnableC0058l runnableC0058l = new RunnableC0058l(c0071y);
        int i = 0;
        int i2 = 0;
        while (i2 < this.mOps.length) {
            C0059m c0059m = new C0059m();
            int i3 = i2 + 1;
            c0059m.f191c = this.mOps[i2];
            if (C0071y.f210a) {
                Log.v("FragmentManager", "Instantiate " + runnableC0058l + " op #" + i + " base fragment #" + this.mOps[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.mOps[i3];
            if (i5 >= 0) {
                c0059m.f192d = c0071y.f216f.get(i5);
            } else {
                c0059m.f192d = null;
            }
            int i6 = i4 + 1;
            c0059m.f193e = this.mOps[i4];
            int i7 = i6 + 1;
            c0059m.f194f = this.mOps[i6];
            int i8 = i7 + 1;
            c0059m.f195g = this.mOps[i7];
            int i9 = i8 + 1;
            c0059m.f196h = this.mOps[i8];
            int i10 = i9 + 1;
            int i11 = this.mOps[i9];
            if (i11 > 0) {
                c0059m.f197i = new ArrayList<>(i11);
                int i12 = 0;
                while (i12 < i11) {
                    if (C0071y.f210a) {
                        Log.v("FragmentManager", "Instantiate " + runnableC0058l + " set remove fragment #" + this.mOps[i10]);
                    }
                    c0059m.f197i.add(c0071y.f216f.get(this.mOps[i10]));
                    i12++;
                    i10++;
                }
            }
            runnableC0058l.m169a(c0059m);
            i++;
            i2 = i10;
        }
        runnableC0058l.f178i = this.mTransition;
        runnableC0058l.f179j = this.mTransitionStyle;
        runnableC0058l.f182m = this.mName;
        runnableC0058l.f184o = this.mIndex;
        runnableC0058l.f180k = true;
        runnableC0058l.f185p = this.mBreadCrumbTitleRes;
        runnableC0058l.f186q = this.mBreadCrumbTitleText;
        runnableC0058l.f187r = this.mBreadCrumbShortTitleRes;
        runnableC0058l.f188s = this.mBreadCrumbShortTitleText;
        runnableC0058l.m168a(1);
        return runnableC0058l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
    }
}
