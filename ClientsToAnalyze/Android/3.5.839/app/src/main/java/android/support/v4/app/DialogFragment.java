package android.support.v4.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a */
    int f35a = 0;

    /* renamed from: b */
    int f36b = 0;

    /* renamed from: c */
    boolean f37c = true;

    /* renamed from: d */
    boolean f38d = true;

    /* renamed from: e */
    int f39e = -1;

    /* renamed from: f */
    Dialog f40f;

    /* renamed from: g */
    boolean f41g;

    /* renamed from: h */
    boolean f42h;

    /* renamed from: i */
    boolean f43i;

    /* renamed from: a */
    public void m35a(int i, int i2) {
        this.f35a = i;
        if (this.f35a == 2 || this.f35a == 3) {
            this.f36b = R.style.Theme.Panel;
        }
        if (i2 != 0) {
            this.f36b = i2;
        }
    }

    /* renamed from: a */
    public void m36a(AbstractC0069w abstractC0069w, String str) {
        this.f42h = false;
        this.f43i = true;
        AbstractC0024aj abstractC0024ajMo183a = abstractC0069w.mo183a();
        abstractC0024ajMo183a.mo98a(this, str);
        abstractC0024ajMo183a.mo99b();
    }

    /* renamed from: a */
    public int m32a(AbstractC0024aj abstractC0024aj, String str) {
        this.f42h = false;
        this.f43i = true;
        abstractC0024aj.mo98a(this, str);
        this.f41g = false;
        this.f39e = abstractC0024aj.mo99b();
        return this.f39e;
    }

    /* renamed from: a */
    public void m34a() {
        m37a(false);
    }

    /* renamed from: a */
    void m37a(boolean z) {
        if (!this.f42h) {
            this.f42h = true;
            this.f43i = false;
            if (this.f40f != null) {
                this.f40f.dismiss();
                this.f40f = null;
            }
            this.f41g = true;
            if (this.f39e >= 0) {
                getFragmentManager().mo184a(this.f39e, 1);
                this.f39e = -1;
                return;
            }
            AbstractC0024aj abstractC0024ajMo183a = getFragmentManager().mo183a();
            abstractC0024ajMo183a.mo97a(this);
            if (z) {
                abstractC0024ajMo183a.mo103c();
            } else {
                abstractC0024ajMo183a.mo99b();
            }
        }
    }

    /* renamed from: b */
    public Dialog m38b() {
        return this.f40f;
    }

    /* renamed from: c */
    public int m39c() {
        return this.f36b;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.f43i) {
            this.f42h = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (!this.f43i && !this.f42h) {
            this.f42h = true;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f38d = this.mContainerId == 0;
        if (bundle != null) {
            this.f35a = bundle.getInt("android:style", 0);
            this.f36b = bundle.getInt("android:theme", 0);
            this.f37c = bundle.getBoolean("android:cancelable", true);
            this.f38d = bundle.getBoolean("android:showsDialog", this.f38d);
            this.f39e = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        if (!this.f38d) {
            return super.getLayoutInflater(bundle);
        }
        this.f40f = mo33a(bundle);
        switch (this.f35a) {
            case 3:
                this.f40f.getWindow().addFlags(24);
            case 1:
            case 2:
                this.f40f.requestWindowFeature(1);
                break;
        }
        if (this.f40f != null) {
            return (LayoutInflater) this.f40f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.mActivity.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public Dialog mo33a(Bundle bundle) {
        return new Dialog(getActivity(), m39c());
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f41g) {
            m37a(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (this.f38d) {
            View view = getView();
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f40f.setContentView(view);
            }
            this.f40f.setOwnerActivity(getActivity());
            this.f40f.setCancelable(this.f37c);
            this.f40f.setOnCancelListener(this);
            this.f40f.setOnDismissListener(this);
            if (bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
                this.f40f.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f40f != null) {
            this.f41g = false;
            this.f40f.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        super.onSaveInstanceState(bundle);
        if (this.f40f != null && (bundleOnSaveInstanceState = this.f40f.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        if (this.f35a != 0) {
            bundle.putInt("android:style", this.f35a);
        }
        if (this.f36b != 0) {
            bundle.putInt("android:theme", this.f36b);
        }
        if (!this.f37c) {
            bundle.putBoolean("android:cancelable", this.f37c);
        }
        if (!this.f38d) {
            bundle.putBoolean("android:showsDialog", this.f38d);
        }
        if (this.f39e != -1) {
            bundle.putInt("android:backStackId", this.f39e);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f40f != null) {
            this.f40f.hide();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f40f != null) {
            this.f41g = true;
            this.f40f.dismiss();
            this.f40f = null;
        }
    }
}
