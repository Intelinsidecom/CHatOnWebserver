package android.support.v4.app;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final String TAG = "BackStackEntry";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    C0008Op mHead;
    int mIndex;
    final FragmentManagerImpl mManager;
    String mName;
    int mNumOp;
    int mPopEnterAnim;
    int mPopExitAnim;
    C0008Op mTail;
    int mTransition;
    int mTransitionStyle;

    /* renamed from: android.support.v4.app.BackStackRecord$Op */
    final class C0008Op {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        C0008Op next;
        int popEnterAnim;
        int popExitAnim;
        C0008Op prev;
        ArrayList<Fragment> removed;

        C0008Op() {
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mName=");
        printWriter.print(this.mName);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mCommitted=");
        printWriter.println(this.mCommitted);
        if (this.mTransition != 0) {
            printWriter.print(str);
            printWriter.print("mTransition=#");
            printWriter.print(Integer.toHexString(this.mTransition));
            printWriter.print(" mTransitionStyle=#");
            printWriter.println(Integer.toHexString(this.mTransitionStyle));
        }
        if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
            printWriter.print(str);
            printWriter.print("mEnterAnim=#");
            printWriter.print(Integer.toHexString(this.mEnterAnim));
            printWriter.print(" mExitAnim=#");
            printWriter.println(Integer.toHexString(this.mExitAnim));
        }
        if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
            printWriter.print(str);
            printWriter.print("mPopEnterAnim=#");
            printWriter.print(Integer.toHexString(this.mPopEnterAnim));
            printWriter.print(" mPopExitAnim=#");
            printWriter.println(Integer.toHexString(this.mPopExitAnim));
        }
        if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbTitleRes=#");
            printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
            printWriter.print(" mBreadCrumbTitleText=");
            printWriter.println(this.mBreadCrumbTitleText);
        }
        if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
            printWriter.print(str);
            printWriter.print("mBreadCrumbShortTitleRes=#");
            printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
            printWriter.print(" mBreadCrumbShortTitleText=");
            printWriter.println(this.mBreadCrumbShortTitleText);
        }
        if (this.mHead != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            for (C0008Op c0008Op = this.mHead; c0008Op != null; c0008Op = c0008Op.next) {
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(0);
                printWriter.println(":");
                printWriter.print(str2);
                printWriter.print("cmd=");
                printWriter.print(c0008Op.cmd);
                printWriter.print(" fragment=");
                printWriter.println(c0008Op.fragment);
                if (c0008Op.enterAnim != 0 || c0008Op.exitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0008Op.enterAnim));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0008Op.exitAnim));
                }
                if (c0008Op.popEnterAnim != 0 || c0008Op.popExitAnim != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0008Op.popEnterAnim));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0008Op.popExitAnim));
                }
                if (c0008Op.removed != null && c0008Op.removed.size() > 0) {
                    for (int i = 0; i < c0008Op.removed.size(); i++) {
                        printWriter.print(str2);
                        if (c0008Op.removed.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            printWriter.println("Removed:");
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(0);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0008Op.removed.get(i));
                    }
                }
            }
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.mManager = fragmentManagerImpl;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        return this.mBreadCrumbTitleRes != 0 ? this.mManager.mActivity.getText(this.mBreadCrumbTitleRes) : this.mBreadCrumbTitleText;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        return this.mBreadCrumbShortTitleRes != 0 ? this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes) : this.mBreadCrumbShortTitleText;
    }

    void addOp(C0008Op c0008Op) {
        if (this.mHead == null) {
            this.mTail = c0008Op;
            this.mHead = c0008Op;
        } else {
            c0008Op.prev = this.mTail;
            this.mTail.next = c0008Op;
            this.mTail = c0008Op;
        }
        c0008Op.enterAnim = this.mEnterAnim;
        c0008Op.exitAnim = this.mExitAnim;
        c0008Op.popEnterAnim = this.mPopEnterAnim;
        c0008Op.popExitAnim = this.mPopExitAnim;
        this.mNumOp++;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(Fragment fragment, String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(int i, Fragment fragment) {
        doAddOp(i, fragment, null, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(int i, Fragment fragment, String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    private void doAddOp(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.mManager;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        C0008Op c0008Op = new C0008Op();
        c0008Op.cmd = i2;
        c0008Op.fragment = fragment;
        addOp(c0008Op);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        doAddOp(i, fragment, str, 2);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        C0008Op c0008Op = new C0008Op();
        c0008Op.cmd = 3;
        c0008Op.fragment = fragment;
        addOp(c0008Op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        C0008Op c0008Op = new C0008Op();
        c0008Op.cmd = 4;
        c0008Op.fragment = fragment;
        addOp(c0008Op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        C0008Op c0008Op = new C0008Op();
        c0008Op.cmd = 5;
        c0008Op.fragment = fragment;
        addOp(c0008Op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        C0008Op c0008Op = new C0008Op();
        c0008Op.cmd = 6;
        c0008Op.fragment = fragment;
        addOp(c0008Op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction attach(Fragment fragment) {
        C0008Op c0008Op = new C0008Op();
        c0008Op.cmd = 7;
        c0008Op.fragment = fragment;
        addOp(c0008Op);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setTransitionStyle(int i) {
        this.mTransitionStyle = i;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction addToBackStack(String str) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = str;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v(TAG, "Bump nesting in " + this + " by " + i);
            }
            for (C0008Op c0008Op = this.mHead; c0008Op != null; c0008Op = c0008Op.next) {
                if (c0008Op.fragment != null) {
                    c0008Op.fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v(TAG, "Bump nesting of " + c0008Op.fragment + " to " + c0008Op.fragment.mBackStackNesting);
                    }
                }
                if (c0008Op.removed != null) {
                    for (int size = c0008Op.removed.size() - 1; size >= 0; size--) {
                        Fragment fragment = c0008Op.removed.get(size);
                        fragment.mBackStackNesting += i;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v(TAG, "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    int commitInternal(boolean z) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Commit: " + this);
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z);
        return this.mIndex;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment;
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "Run: " + this);
        }
        if (this.mAddToBackStack && this.mIndex < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        bumpBackStackNesting(1);
        for (C0008Op c0008Op = this.mHead; c0008Op != null; c0008Op = c0008Op.next) {
            switch (c0008Op.cmd) {
                case 1:
                    Fragment fragment2 = c0008Op.fragment;
                    fragment2.mNextAnim = c0008Op.enterAnim;
                    this.mManager.addFragment(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = c0008Op.fragment;
                    if (this.mManager.mAdded != null) {
                        fragment = fragment3;
                        for (int i = 0; i < this.mManager.mAdded.size(); i++) {
                            Fragment fragment4 = this.mManager.mAdded.get(i);
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v(TAG, "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                            }
                            if (fragment == null || fragment4.mContainerId == fragment.mContainerId) {
                                if (fragment4 == fragment) {
                                    fragment = null;
                                    c0008Op.fragment = null;
                                } else {
                                    if (c0008Op.removed == null) {
                                        c0008Op.removed = new ArrayList<>();
                                    }
                                    c0008Op.removed.add(fragment4);
                                    fragment4.mNextAnim = c0008Op.exitAnim;
                                    if (this.mAddToBackStack) {
                                        fragment4.mBackStackNesting++;
                                        if (FragmentManagerImpl.DEBUG) {
                                            Log.v(TAG, "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                        }
                                    }
                                    this.mManager.removeFragment(fragment4, this.mTransition, this.mTransitionStyle);
                                }
                            }
                        }
                    } else {
                        fragment = fragment3;
                    }
                    if (fragment != null) {
                        fragment.mNextAnim = c0008Op.enterAnim;
                        this.mManager.addFragment(fragment, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 3:
                    Fragment fragment5 = c0008Op.fragment;
                    fragment5.mNextAnim = c0008Op.exitAnim;
                    this.mManager.removeFragment(fragment5, this.mTransition, this.mTransitionStyle);
                    break;
                case 4:
                    Fragment fragment6 = c0008Op.fragment;
                    fragment6.mNextAnim = c0008Op.exitAnim;
                    this.mManager.hideFragment(fragment6, this.mTransition, this.mTransitionStyle);
                    break;
                case 5:
                    Fragment fragment7 = c0008Op.fragment;
                    fragment7.mNextAnim = c0008Op.enterAnim;
                    this.mManager.showFragment(fragment7, this.mTransition, this.mTransitionStyle);
                    break;
                case 6:
                    Fragment fragment8 = c0008Op.fragment;
                    fragment8.mNextAnim = c0008Op.exitAnim;
                    this.mManager.detachFragment(fragment8, this.mTransition, this.mTransitionStyle);
                    break;
                case 7:
                    Fragment fragment9 = c0008Op.fragment;
                    fragment9.mNextAnim = c0008Op.enterAnim;
                    this.mManager.attachFragment(fragment9, this.mTransition, this.mTransitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0008Op.cmd);
            }
        }
        this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, true);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }
    }

    public void popFromBackStack(boolean z) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v(TAG, "popFromBackStack: " + this);
        }
        bumpBackStackNesting(-1);
        for (C0008Op c0008Op = this.mTail; c0008Op != null; c0008Op = c0008Op.prev) {
            switch (c0008Op.cmd) {
                case 1:
                    Fragment fragment = c0008Op.fragment;
                    fragment.mNextAnim = c0008Op.popExitAnim;
                    this.mManager.removeFragment(fragment, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 2:
                    Fragment fragment2 = c0008Op.fragment;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = c0008Op.popExitAnim;
                        this.mManager.removeFragment(fragment2, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    }
                    if (c0008Op.removed != null) {
                        for (int i = 0; i < c0008Op.removed.size(); i++) {
                            Fragment fragment3 = c0008Op.removed.get(i);
                            fragment3.mNextAnim = c0008Op.popEnterAnim;
                            this.mManager.addFragment(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = c0008Op.fragment;
                    fragment4.mNextAnim = c0008Op.popEnterAnim;
                    this.mManager.addFragment(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = c0008Op.fragment;
                    fragment5.mNextAnim = c0008Op.popEnterAnim;
                    this.mManager.showFragment(fragment5, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 5:
                    Fragment fragment6 = c0008Op.fragment;
                    fragment6.mNextAnim = c0008Op.popExitAnim;
                    this.mManager.hideFragment(fragment6, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 6:
                    Fragment fragment7 = c0008Op.fragment;
                    fragment7.mNextAnim = c0008Op.popEnterAnim;
                    this.mManager.attachFragment(fragment7, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                case 7:
                    Fragment fragment8 = c0008Op.fragment;
                    fragment8.mNextAnim = c0008Op.popEnterAnim;
                    this.mManager.detachFragment(fragment8, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0008Op.cmd);
            }
        }
        if (z) {
            this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle, true);
        }
        if (this.mIndex >= 0) {
            this.mManager.freeBackStackIndex(this.mIndex);
            this.mIndex = -1;
        }
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.mName;
    }

    public int getTransition() {
        return this.mTransition;
    }

    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mNumOp == 0;
    }
}
