package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.p008c.C0087m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FragmentActivity extends Activity {

    /* renamed from: a */
    final Handler f44a = new HandlerC0064r(this);

    /* renamed from: b */
    final C0071y f45b = new C0071y();

    /* renamed from: c */
    final InterfaceC0068v f46c = new C0065s(this);

    /* renamed from: d */
    boolean f47d;

    /* renamed from: e */
    boolean f48e;

    /* renamed from: f */
    boolean f49f;

    /* renamed from: g */
    boolean f50g;

    /* renamed from: h */
    boolean f51h;

    /* renamed from: i */
    boolean f52i;

    /* renamed from: j */
    boolean f53j;

    /* renamed from: k */
    boolean f54k;

    /* renamed from: l */
    C0087m<String, C0029ao> f55l;

    /* renamed from: m */
    C0029ao f56m;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f45b.m233j();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            if (this.f45b.f216f == null || i4 < 0 || i4 >= this.f45b.f216f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(i));
                return;
            }
            Fragment fragment = this.f45b.f216f.get(i4);
            if (fragment == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(i));
                return;
            } else {
                fragment.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.f45b.m223d()) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f45b.m200a(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f45b.m205a(this, this.f46c, (Fragment) null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        C0067u c0067u = (C0067u) getLastNonConfigurationInstance();
        if (c0067u != null) {
            this.f55l = c0067u.f206e;
        }
        if (bundle != null) {
            this.f45b.m201a(bundle.getParcelable("android:support:fragments"), c0067u != null ? c0067u.f205d : null);
        }
        this.f45b.m234k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean zOnCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.f45b.m210a(menu, getMenuInflater());
            if (Build.VERSION.SDK_INT < 11) {
                return true;
            }
            return zOnCreatePanelMenu;
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        byte b2 = 0;
        if (!"fragment".equals(str)) {
            return super.onCreateView(str, context, attributeSet);
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0066t.f201a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this, attributeValue)) {
            return super.onCreateView(str, context, attributeSet);
        }
        int id = 0 != 0 ? (b2 == true ? 1 : 0).getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentMo180a = resourceId != -1 ? this.f45b.mo180a(resourceId) : null;
        if (fragmentMo180a == null && string != null) {
            fragmentMo180a = this.f45b.mo182a(string);
        }
        if (fragmentMo180a == null && id != -1) {
            fragmentMo180a = this.f45b.mo180a(id);
        }
        if (C0071y.f210a) {
            Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + fragmentMo180a);
        }
        if (fragmentMo180a == null) {
            Fragment fragmentInstantiate = Fragment.instantiate(this, attributeValue);
            fragmentInstantiate.mFromLayout = true;
            fragmentInstantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentInstantiate.mContainerId = id;
            fragmentInstantiate.mTag = string;
            fragmentInstantiate.mInLayout = true;
            fragmentInstantiate.mFragmentManager = this.f45b;
            fragmentInstantiate.onInflate(this, attributeSet, fragmentInstantiate.mSavedFragmentState);
            this.f45b.m204a(fragmentInstantiate, true);
            fragmentMo180a = fragmentInstantiate;
        } else {
            if (fragmentMo180a.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentMo180a.mInLayout = true;
            if (!fragmentMo180a.mRetaining) {
                fragmentMo180a.onInflate(this, attributeSet, fragmentMo180a.mSavedFragmentState);
            }
            this.f45b.m219c(fragmentMo180a);
        }
        if (fragmentMo180a.mView == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            fragmentMo180a.mView.setId(resourceId);
        }
        if (fragmentMo180a.mView.getTag() == null) {
            fragmentMo180a.mView.setTag(string);
        }
        return fragmentMo180a.mView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m46a(false);
        this.f45b.m242s();
        if (this.f56m != null) {
            this.f56m.m126h();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f45b.m243t();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f45b.m211a(menuItem);
            case 6:
                return this.f45b.m218b(menuItem);
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f45b.m217b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f48e = false;
        if (this.f44a.hasMessages(2)) {
            this.f44a.removeMessages(2);
            m48a_();
        }
        this.f45b.m238o();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f45b.m233j();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f44a.sendEmptyMessage(2);
        this.f48e = true;
        this.f45b.m228f();
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.f44a.removeMessages(2);
        m48a_();
        this.f45b.m228f();
    }

    /* renamed from: a_ */
    protected void m48a_() {
        this.f45b.m237n();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f52i) {
            this.f52i = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m47a(view, menu) | this.f45b.m209a(menu);
    }

    /* renamed from: a */
    protected boolean m47a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        boolean z;
        if (this.f49f) {
            m46a(true);
        }
        Object objM52v_ = m52v_();
        ArrayList<Fragment> arrayListM231h = this.f45b.m231h();
        if (this.f55l != null) {
            int size = this.f55l.size();
            C0029ao[] c0029aoArr = new C0029ao[size];
            for (int i = size - 1; i >= 0; i--) {
                c0029aoArr[i] = this.f55l.m291c(i);
            }
            z = false;
            for (int i2 = 0; i2 < size; i2++) {
                C0029ao c0029ao = c0029aoArr[i2];
                if (c0029ao.f113g) {
                    z = true;
                } else {
                    c0029ao.m126h();
                    this.f55l.remove(c0029ao.f110d);
                }
            }
        } else {
            z = false;
        }
        if (arrayListM231h == null && !z && objM52v_ == null) {
            return null;
        }
        C0067u c0067u = new C0067u();
        c0067u.f202a = null;
        c0067u.f203b = objM52v_;
        c0067u.f204c = null;
        c0067u.f205d = arrayListM231h;
        c0067u.f206e = this.f55l;
        return c0067u;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable parcelableM232i = this.f45b.m232i();
        if (parcelableM232i != null) {
            bundle.putParcelable("android:support:fragments", parcelableM232i);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f49f = false;
        this.f50g = false;
        this.f44a.removeMessages(1);
        if (!this.f47d) {
            this.f47d = true;
            this.f45b.m235l();
        }
        this.f45b.m233j();
        this.f45b.m228f();
        if (!this.f54k) {
            this.f54k = true;
            if (this.f56m != null) {
                this.f56m.m120b();
            } else if (!this.f53j) {
                this.f56m = m42a("(root)", this.f54k, false);
                if (this.f56m != null && !this.f56m.f112f) {
                    this.f56m.m120b();
                }
            }
            this.f53j = true;
        }
        this.f45b.m236m();
        if (this.f55l != null) {
            int size = this.f55l.size();
            C0029ao[] c0029aoArr = new C0029ao[size];
            for (int i = size - 1; i >= 0; i--) {
                c0029aoArr[i] = this.f55l.m291c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0029ao c0029ao = c0029aoArr[i2];
                c0029ao.m123e();
                c0029ao.m125g();
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f49f = true;
        this.f44a.sendEmptyMessage(1);
        this.f45b.m239p();
    }

    /* renamed from: v_ */
    public Object m52v_() {
        return null;
    }

    /* renamed from: u_ */
    public void mo51u_() {
        if (Build.VERSION.SDK_INT >= 11) {
            C0057k.m165a(this);
        } else {
            this.f52i = true;
        }
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 11) {
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f47d);
        printWriter.print("mResumed=");
        printWriter.print(this.f48e);
        printWriter.print(" mStopped=");
        printWriter.print(this.f49f);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f50g);
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f54k);
        if (this.f56m != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f56m)));
            printWriter.println(":");
            this.f56m.m119a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        this.f45b.m207a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        m41a(str + "  ", printWriter, getWindow().getDecorView());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x00ee. Please report as an issue. */
    /* renamed from: a */
    private static String m40a(View view) throws Resources.NotFoundException {
        String resourcePackageName;
        StringBuilder sb = new StringBuilder(128);
        sb.append(view.getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(view)));
        sb.append(' ');
        switch (view.getVisibility()) {
            case 0:
                sb.append('V');
                break;
            case 4:
                sb.append('I');
                break;
            case 8:
                sb.append('G');
                break;
            default:
                sb.append('.');
                break;
        }
        sb.append(view.isFocusable() ? 'F' : '.');
        sb.append(view.isEnabled() ? 'E' : '.');
        sb.append(view.willNotDraw() ? '.' : 'D');
        sb.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        sb.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        sb.append(view.isClickable() ? 'C' : '.');
        sb.append(view.isLongClickable() ? 'L' : '.');
        sb.append(' ');
        sb.append(view.isFocused() ? 'F' : '.');
        sb.append(view.isSelected() ? 'S' : '.');
        sb.append(view.isPressed() ? 'P' : '.');
        sb.append(' ');
        sb.append(view.getLeft());
        sb.append(',');
        sb.append(view.getTop());
        sb.append('-');
        sb.append(view.getRight());
        sb.append(',');
        sb.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            sb.append(" #");
            sb.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id != 0 && resources != null) {
                switch ((-16777216) & id) {
                    case 16777216:
                        resourcePackageName = "android";
                        String resourceTypeName = resources.getResourceTypeName(id);
                        String resourceEntryName = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName);
                        sb.append("/");
                        sb.append(resourceEntryName);
                        break;
                    case 2130706432:
                        resourcePackageName = "app";
                        String resourceTypeName2 = resources.getResourceTypeName(id);
                        String resourceEntryName2 = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(resourcePackageName);
                        sb.append(":");
                        sb.append(resourceTypeName2);
                        sb.append("/");
                        sb.append(resourceEntryName2);
                        break;
                    default:
                        try {
                            resourcePackageName = resources.getResourcePackageName(id);
                            String resourceTypeName22 = resources.getResourceTypeName(id);
                            String resourceEntryName22 = resources.getResourceEntryName(id);
                            sb.append(" ");
                            sb.append(resourcePackageName);
                            sb.append(":");
                            sb.append(resourceTypeName22);
                            sb.append("/");
                            sb.append(resourceEntryName22);
                            break;
                        } catch (Resources.NotFoundException e) {
                            break;
                        }
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    private void m41a(String str, PrintWriter printWriter, View view) {
        ViewGroup viewGroup;
        int childCount;
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(m40a(view));
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            String str2 = str + "  ";
            for (int i = 0; i < childCount; i++) {
                m41a(str2, printWriter, viewGroup.getChildAt(i));
            }
        }
    }

    /* renamed from: a */
    void m46a(boolean z) {
        if (!this.f50g) {
            this.f50g = true;
            this.f51h = z;
            this.f44a.removeMessages(1);
            m49d();
        }
    }

    /* renamed from: d */
    void m49d() {
        if (this.f54k) {
            this.f54k = false;
            if (this.f56m != null) {
                if (!this.f51h) {
                    this.f56m.m121c();
                } else {
                    this.f56m.m122d();
                }
            }
        }
        this.f45b.m240q();
    }

    /* renamed from: a */
    public void m43a(Fragment fragment) {
    }

    /* renamed from: e */
    public AbstractC0069w m50e() {
        return this.f45b;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (i != -1 && ((-65536) & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
        super.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    public void m44a(Fragment fragment, Intent intent, int i) {
        if (i == -1) {
            super.startActivityForResult(intent, -1);
        } else {
            if (((-65536) & i) != 0) {
                throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            }
            super.startActivityForResult(intent, ((fragment.mIndex + 1) << 16) + (65535 & i));
        }
    }

    /* renamed from: a */
    void m45a(String str) {
        C0029ao c0029ao;
        if (this.f55l != null && (c0029ao = this.f55l.get(str)) != null && !c0029ao.f113g) {
            c0029ao.m126h();
            this.f55l.remove(str);
        }
    }

    /* renamed from: a */
    C0029ao m42a(String str, boolean z, boolean z2) {
        if (this.f55l == null) {
            this.f55l = new C0087m<>();
        }
        C0029ao c0029ao = this.f55l.get(str);
        if (c0029ao == null) {
            if (z2) {
                C0029ao c0029ao2 = new C0029ao(str, this, z);
                this.f55l.put(str, c0029ao2);
                return c0029ao2;
            }
            return c0029ao;
        }
        c0029ao.m117a(this);
        return c0029ao;
    }
}
