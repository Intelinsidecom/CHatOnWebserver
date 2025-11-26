package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new C0011l();
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final int mTransition;
    final int mTransitionStyle;

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

    public BackStackState(C0015p c0015p, RunnableC0012m runnableC0012m) {
        int size = 0;
        for (C0018s c0018s = runnableC0012m.f50b; c0018s != null; c0018s = c0018s.f103a) {
            if (c0018s.f109g != null) {
                size += c0018s.f109g.size();
            }
        }
        this.mOps = new int[(runnableC0012m.f52d * 5) + size];
        if (!runnableC0012m.f57i) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        for (C0018s c0018s2 = runnableC0012m.f50b; c0018s2 != null; c0018s2 = c0018s2.f103a) {
            int i2 = i + 1;
            this.mOps[i] = c0018s2.f105c;
            int i3 = i2 + 1;
            this.mOps[i2] = c0018s2.f106d.mIndex;
            int i4 = i3 + 1;
            this.mOps[i3] = c0018s2.f107e;
            int i5 = i4 + 1;
            this.mOps[i4] = c0018s2.f108f;
            if (c0018s2.f109g != null) {
                int size2 = c0018s2.f109g.size();
                int i6 = i5 + 1;
                this.mOps[i5] = size2;
                int i7 = 0;
                while (i7 < size2) {
                    this.mOps[i6] = ((Fragment) c0018s2.f109g.get(i7)).mIndex;
                    i7++;
                    i6++;
                }
                i = i6;
            } else {
                this.mOps[i5] = 0;
                i = i5 + 1;
            }
        }
        this.mTransition = runnableC0012m.f55g;
        this.mTransitionStyle = runnableC0012m.f56h;
        this.mName = runnableC0012m.f59k;
        this.mIndex = runnableC0012m.f61m;
        this.mBreadCrumbTitleRes = runnableC0012m.f62n;
        this.mBreadCrumbTitleText = runnableC0012m.f63o;
        this.mBreadCrumbShortTitleRes = runnableC0012m.f64p;
        this.mBreadCrumbShortTitleText = runnableC0012m.f65q;
    }

    /* renamed from: a */
    public RunnableC0012m m0a(C0015p c0015p) {
        RunnableC0012m runnableC0012m = new RunnableC0012m(c0015p);
        int i = 0;
        while (i < this.mOps.length) {
            C0018s c0018s = new C0018s();
            int i2 = i + 1;
            c0018s.f105c = this.mOps[i];
            if (C0015p.f70a) {
                Log.v("FragmentManager", "BSE " + runnableC0012m + " set base fragment #" + this.mOps[i2]);
            }
            int i3 = i2 + 1;
            c0018s.f106d = (Fragment) c0015p.f79f.get(this.mOps[i2]);
            int i4 = i3 + 1;
            c0018s.f107e = this.mOps[i3];
            int i5 = i4 + 1;
            c0018s.f108f = this.mOps[i4];
            int i6 = i5 + 1;
            int i7 = this.mOps[i5];
            if (i7 > 0) {
                c0018s.f109g = new ArrayList(i7);
                i = i6;
                int i8 = 0;
                while (i8 < i7) {
                    if (C0015p.f70a) {
                        Log.v("FragmentManager", "BSE " + runnableC0012m + " set remove fragment #" + this.mOps[i]);
                    }
                    c0018s.f109g.add((Fragment) c0015p.f79f.get(this.mOps[i]));
                    i8++;
                    i++;
                }
            } else {
                i = i6;
            }
            runnableC0012m.m59a(c0018s);
        }
        runnableC0012m.f55g = this.mTransition;
        runnableC0012m.f56h = this.mTransitionStyle;
        runnableC0012m.f59k = this.mName;
        runnableC0012m.f61m = this.mIndex;
        runnableC0012m.f57i = true;
        runnableC0012m.f62n = this.mBreadCrumbTitleRes;
        runnableC0012m.f63o = this.mBreadCrumbTitleText;
        runnableC0012m.f64p = this.mBreadCrumbShortTitleRes;
        runnableC0012m.f65q = this.mBreadCrumbShortTitleText;
        runnableC0012m.m58a(1);
        return runnableC0012m;
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
