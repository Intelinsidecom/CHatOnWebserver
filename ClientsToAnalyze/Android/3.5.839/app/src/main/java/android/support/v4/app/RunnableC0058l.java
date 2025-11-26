package android.support.v4.app;

import android.support.v4.p008c.C0082e;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* renamed from: android.support.v4.app.l */
/* loaded from: classes.dex */
final class RunnableC0058l extends AbstractC0024aj implements Runnable {

    /* renamed from: a */
    final C0071y f170a;

    /* renamed from: b */
    C0059m f171b;

    /* renamed from: c */
    C0059m f172c;

    /* renamed from: d */
    int f173d;

    /* renamed from: e */
    int f174e;

    /* renamed from: f */
    int f175f;

    /* renamed from: g */
    int f176g;

    /* renamed from: h */
    int f177h;

    /* renamed from: i */
    int f178i;

    /* renamed from: j */
    int f179j;

    /* renamed from: k */
    boolean f180k;

    /* renamed from: m */
    String f182m;

    /* renamed from: n */
    boolean f183n;

    /* renamed from: p */
    int f185p;

    /* renamed from: q */
    CharSequence f186q;

    /* renamed from: r */
    int f187r;

    /* renamed from: s */
    CharSequence f188s;

    /* renamed from: l */
    boolean f181l = true;

    /* renamed from: o */
    int f184o = -1;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f184o >= 0) {
            sb.append(" #");
            sb.append(this.f184o);
        }
        if (this.f182m != null) {
            sb.append(" ");
            sb.append(this.f182m);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public void m170a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m171a(str, printWriter, true);
    }

    /* renamed from: a */
    public void m171a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f182m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f184o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f183n);
            if (this.f178i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f178i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f179j));
            }
            if (this.f174e != 0 || this.f175f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f174e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f175f));
            }
            if (this.f176g != 0 || this.f177h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f176g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f177h));
            }
            if (this.f185p != 0 || this.f186q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f185p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f186q);
            }
            if (this.f187r != 0 || this.f188s != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f187r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f188s);
            }
        }
        if (this.f171b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            C0059m c0059m = this.f171b;
            while (c0059m != null) {
                switch (c0059m.f191c) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + c0059m.f191c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0059m.f192d);
                if (z) {
                    if (c0059m.f193e != 0 || c0059m.f194f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0059m.f193e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0059m.f194f));
                    }
                    if (c0059m.f195g != 0 || c0059m.f196h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0059m.f195g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0059m.f196h));
                    }
                }
                if (c0059m.f197i != null && c0059m.f197i.size() > 0) {
                    for (int i2 = 0; i2 < c0059m.f197i.size(); i2++) {
                        printWriter.print(str3);
                        if (c0059m.f197i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0059m.f197i.get(i2));
                    }
                }
                c0059m = c0059m.f189a;
                i++;
            }
        }
    }

    public RunnableC0058l(C0071y c0071y) {
        this.f170a = c0071y;
    }

    /* renamed from: a */
    void m169a(C0059m c0059m) {
        if (this.f171b == null) {
            this.f172c = c0059m;
            this.f171b = c0059m;
        } else {
            c0059m.f190b = this.f172c;
            this.f172c.f189a = c0059m;
            this.f172c = c0059m;
        }
        c0059m.f193e = this.f174e;
        c0059m.f194f = this.f175f;
        c0059m.f195g = this.f176g;
        c0059m.f196h = this.f177h;
        this.f173d++;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: a */
    public AbstractC0024aj mo98a(Fragment fragment, String str) {
        m166a(0, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: a */
    public AbstractC0024aj mo95a(int i, Fragment fragment) {
        m166a(i, fragment, (String) null, 1);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: a */
    public AbstractC0024aj mo96a(int i, Fragment fragment, String str) {
        m166a(i, fragment, str, 1);
        return this;
    }

    /* renamed from: a */
    private void m166a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.f170a;
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
        C0059m c0059m = new C0059m();
        c0059m.f191c = i2;
        c0059m.f192d = fragment;
        m169a(c0059m);
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: b */
    public AbstractC0024aj mo100b(int i, Fragment fragment) {
        return mo101b(i, fragment, null);
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: b */
    public AbstractC0024aj mo101b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m166a(i, fragment, str, 2);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: a */
    public AbstractC0024aj mo97a(Fragment fragment) {
        C0059m c0059m = new C0059m();
        c0059m.f191c = 3;
        c0059m.f192d = fragment;
        m169a(c0059m);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: b */
    public AbstractC0024aj mo102b(Fragment fragment) {
        C0059m c0059m = new C0059m();
        c0059m.f191c = 4;
        c0059m.f192d = fragment;
        m169a(c0059m);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: c */
    public AbstractC0024aj mo104c(Fragment fragment) {
        C0059m c0059m = new C0059m();
        c0059m.f191c = 5;
        c0059m.f192d = fragment;
        m169a(c0059m);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: d */
    public AbstractC0024aj mo105d(Fragment fragment) {
        C0059m c0059m = new C0059m();
        c0059m.f191c = 6;
        c0059m.f192d = fragment;
        m169a(c0059m);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: e */
    public AbstractC0024aj mo106e(Fragment fragment) {
        C0059m c0059m = new C0059m();
        c0059m.f191c = 7;
        c0059m.f192d = fragment;
        m169a(c0059m);
        return this;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: a */
    public AbstractC0024aj mo94a() {
        if (this.f180k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f181l = false;
        return this;
    }

    /* renamed from: a */
    void m168a(int i) {
        if (this.f180k) {
            if (C0071y.f210a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0059m c0059m = this.f171b; c0059m != null; c0059m = c0059m.f189a) {
                if (c0059m.f192d != null) {
                    c0059m.f192d.mBackStackNesting += i;
                    if (C0071y.f210a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0059m.f192d + " to " + c0059m.f192d.mBackStackNesting);
                    }
                }
                if (c0059m.f197i != null) {
                    for (int size = c0059m.f197i.size() - 1; size >= 0; size--) {
                        Fragment fragment = c0059m.f197i.get(size);
                        fragment.mBackStackNesting += i;
                        if (C0071y.f210a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: b */
    public int mo99b() {
        return m167a(false);
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: c */
    public int mo103c() {
        return m167a(true);
    }

    /* renamed from: a */
    int m167a(boolean z) {
        if (this.f183n) {
            throw new IllegalStateException("commit already called");
        }
        if (C0071y.f210a) {
            Log.v("FragmentManager", "Commit: " + this);
            m170a("  ", (FileDescriptor) null, new PrintWriter(new C0082e("FragmentManager")), (String[]) null);
        }
        this.f183n = true;
        if (this.f180k) {
            this.f184o = this.f170a.m195a(this);
        } else {
            this.f184o = -1;
        }
        this.f170a.m206a(this, z);
        return this.f184o;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment fragment;
        if (C0071y.f210a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.f180k && this.f184o < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        m168a(1);
        for (C0059m c0059m = this.f171b; c0059m != null; c0059m = c0059m.f189a) {
            switch (c0059m.f191c) {
                case 1:
                    Fragment fragment2 = c0059m.f192d;
                    fragment2.mNextAnim = c0059m.f193e;
                    this.f170a.m204a(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = c0059m.f192d;
                    if (this.f170a.f217g != null) {
                        fragment = fragment3;
                        for (int i = 0; i < this.f170a.f217g.size(); i++) {
                            Fragment fragment4 = this.f170a.f217g.get(i);
                            if (C0071y.f210a) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                            }
                            if (fragment == null || fragment4.mContainerId == fragment.mContainerId) {
                                if (fragment4 == fragment) {
                                    fragment = null;
                                    c0059m.f192d = null;
                                } else {
                                    if (c0059m.f197i == null) {
                                        c0059m.f197i = new ArrayList<>();
                                    }
                                    c0059m.f197i.add(fragment4);
                                    fragment4.mNextAnim = c0059m.f194f;
                                    if (this.f180k) {
                                        fragment4.mBackStackNesting++;
                                        if (C0071y.f210a) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                        }
                                    }
                                    this.f170a.m202a(fragment4, this.f178i, this.f179j);
                                }
                            }
                        }
                    } else {
                        fragment = fragment3;
                    }
                    if (fragment != null) {
                        fragment.mNextAnim = c0059m.f193e;
                        this.f170a.m204a(fragment, false);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 3:
                    Fragment fragment5 = c0059m.f192d;
                    fragment5.mNextAnim = c0059m.f194f;
                    this.f170a.m202a(fragment5, this.f178i, this.f179j);
                    break;
                case 4:
                    Fragment fragment6 = c0059m.f192d;
                    fragment6.mNextAnim = c0059m.f194f;
                    this.f170a.m215b(fragment6, this.f178i, this.f179j);
                    break;
                case 5:
                    Fragment fragment7 = c0059m.f192d;
                    fragment7.mNextAnim = c0059m.f193e;
                    this.f170a.m220c(fragment7, this.f178i, this.f179j);
                    break;
                case 6:
                    Fragment fragment8 = c0059m.f192d;
                    fragment8.mNextAnim = c0059m.f194f;
                    this.f170a.m222d(fragment8, this.f178i, this.f179j);
                    break;
                case 7:
                    Fragment fragment9 = c0059m.f192d;
                    fragment9.mNextAnim = c0059m.f193e;
                    this.f170a.m226e(fragment9, this.f178i, this.f179j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0059m.f191c);
            }
        }
        this.f170a.m197a(this.f170a.f224n, this.f178i, this.f179j, true);
        if (this.f180k) {
            this.f170a.m216b(this);
        }
    }

    /* renamed from: b */
    public void m172b(boolean z) {
        if (C0071y.f210a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m170a("  ", (FileDescriptor) null, new PrintWriter(new C0082e("FragmentManager")), (String[]) null);
        }
        m168a(-1);
        for (C0059m c0059m = this.f172c; c0059m != null; c0059m = c0059m.f190b) {
            switch (c0059m.f191c) {
                case 1:
                    Fragment fragment = c0059m.f192d;
                    fragment.mNextAnim = c0059m.f196h;
                    this.f170a.m202a(fragment, C0071y.m193c(this.f178i), this.f179j);
                    break;
                case 2:
                    Fragment fragment2 = c0059m.f192d;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = c0059m.f196h;
                        this.f170a.m202a(fragment2, C0071y.m193c(this.f178i), this.f179j);
                    }
                    if (c0059m.f197i != null) {
                        for (int i = 0; i < c0059m.f197i.size(); i++) {
                            Fragment fragment3 = c0059m.f197i.get(i);
                            fragment3.mNextAnim = c0059m.f195g;
                            this.f170a.m204a(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = c0059m.f192d;
                    fragment4.mNextAnim = c0059m.f195g;
                    this.f170a.m204a(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = c0059m.f192d;
                    fragment5.mNextAnim = c0059m.f195g;
                    this.f170a.m220c(fragment5, C0071y.m193c(this.f178i), this.f179j);
                    break;
                case 5:
                    Fragment fragment6 = c0059m.f192d;
                    fragment6.mNextAnim = c0059m.f196h;
                    this.f170a.m215b(fragment6, C0071y.m193c(this.f178i), this.f179j);
                    break;
                case 6:
                    Fragment fragment7 = c0059m.f192d;
                    fragment7.mNextAnim = c0059m.f195g;
                    this.f170a.m226e(fragment7, C0071y.m193c(this.f178i), this.f179j);
                    break;
                case 7:
                    Fragment fragment8 = c0059m.f192d;
                    fragment8.mNextAnim = c0059m.f195g;
                    this.f170a.m222d(fragment8, C0071y.m193c(this.f178i), this.f179j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0059m.f191c);
            }
        }
        if (z) {
            this.f170a.m197a(this.f170a.f224n, C0071y.m193c(this.f178i), this.f179j, true);
        }
        if (this.f184o >= 0) {
            this.f170a.m213b(this.f184o);
            this.f184o = -1;
        }
    }

    /* renamed from: d */
    public String m173d() {
        return this.f182m;
    }

    @Override // android.support.v4.app.AbstractC0024aj
    /* renamed from: e */
    public boolean mo107e() {
        return this.f173d == 0;
    }
}
