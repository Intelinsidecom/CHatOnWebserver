package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BackStackRecord;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: android.support.v4.app.BackStackState.1
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final int mTransition;
    final int mTransitionStyle;

    public BackStackState(FragmentManagerImpl fragmentManagerImpl, BackStackRecord backStackRecord) {
        int size = 0;
        for (BackStackRecord.C0010Op c0010Op = backStackRecord.mHead; c0010Op != null; c0010Op = c0010Op.next) {
            if (c0010Op.removed != null) {
                size += c0010Op.removed.size();
            }
        }
        this.mOps = new int[size + (backStackRecord.mNumOp * 7)];
        if (!backStackRecord.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        for (BackStackRecord.C0010Op c0010Op2 = backStackRecord.mHead; c0010Op2 != null; c0010Op2 = c0010Op2.next) {
            int i2 = i + 1;
            this.mOps[i] = c0010Op2.cmd;
            int i3 = i2 + 1;
            this.mOps[i2] = c0010Op2.fragment.mIndex;
            int i4 = i3 + 1;
            this.mOps[i3] = c0010Op2.enterAnim;
            int i5 = i4 + 1;
            this.mOps[i4] = c0010Op2.exitAnim;
            int i6 = i5 + 1;
            this.mOps[i5] = c0010Op2.popEnterAnim;
            int i7 = i6 + 1;
            this.mOps[i6] = c0010Op2.popExitAnim;
            if (c0010Op2.removed != null) {
                int size2 = c0010Op2.removed.size();
                int i8 = i7 + 1;
                this.mOps[i7] = size2;
                int i9 = 0;
                while (i9 < size2) {
                    this.mOps[i8] = ((Fragment) c0010Op2.removed.get(i9)).mIndex;
                    i9++;
                    i8++;
                }
                i = i8;
            } else {
                i = i7 + 1;
                this.mOps[i7] = 0;
            }
        }
        this.mTransition = backStackRecord.mTransition;
        this.mTransitionStyle = backStackRecord.mTransitionStyle;
        this.mName = backStackRecord.mName;
        this.mIndex = backStackRecord.mIndex;
        this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
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

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        while (i < this.mOps.length) {
            BackStackRecord.C0010Op c0010Op = new BackStackRecord.C0010Op();
            int i2 = i + 1;
            c0010Op.cmd = this.mOps[i];
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "BSE " + backStackRecord + " set base fragment #" + this.mOps[i2]);
            }
            int i3 = i2 + 1;
            c0010Op.fragment = (Fragment) fragmentManagerImpl.mActive.get(this.mOps[i2]);
            int i4 = i3 + 1;
            c0010Op.enterAnim = this.mOps[i3];
            int i5 = i4 + 1;
            c0010Op.exitAnim = this.mOps[i4];
            int i6 = i5 + 1;
            c0010Op.popEnterAnim = this.mOps[i5];
            int i7 = i6 + 1;
            c0010Op.popExitAnim = this.mOps[i6];
            i = i7 + 1;
            int i8 = this.mOps[i7];
            if (i8 > 0) {
                c0010Op.removed = new ArrayList(i8);
                int i9 = 0;
                while (i9 < i8) {
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "BSE " + backStackRecord + " set remove fragment #" + this.mOps[i]);
                    }
                    c0010Op.removed.add((Fragment) fragmentManagerImpl.mActive.get(this.mOps[i]));
                    i9++;
                    i++;
                }
            }
            backStackRecord.addOp(c0010Op);
        }
        backStackRecord.mTransition = this.mTransition;
        backStackRecord.mTransitionStyle = this.mTransitionStyle;
        backStackRecord.mName = this.mName;
        backStackRecord.mIndex = this.mIndex;
        backStackRecord.mAddToBackStack = true;
        backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord.bumpBackStackNesting(1);
        return backStackRecord;
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
