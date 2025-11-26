package android.support.v4.view;

import android.os.Build;
import android.support.v4.view.AccessibilityDelegateCompatIcs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    private static final Object DEFAULT_DELEGATE;
    private static final AccessibilityDelegateImpl IMPL;
    final Object mBridge = IMPL.newAccessiblityDelegateBridge(this);

    interface AccessibilityDelegateImpl {
        boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat);

        Object newAccessiblityDelegateDefaultImpl();

        void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(Object obj, View view, Object obj2);

        void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void sendAccessibilityEvent(Object obj, View view, int i);

        void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl {
        AccessibilityDelegateStubImpl() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateDefaultImpl() {
            return null;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return null;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityNodeInfo(Object obj, View view, Object obj2) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEvent(Object obj, View view, int i) {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    class AccessibilityDelegateIcsImpl extends AccessibilityDelegateStubImpl {
        AccessibilityDelegateIcsImpl() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateDefaultImpl() {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
            return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() { // from class: android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl.1
                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onInitializeAccessibilityNodeInfo(View view, Object obj) {
                    accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(obj));
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return accessibilityDelegateCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void sendAccessibilityEvent(View view, int i) {
                    accessibilityDelegateCompat.sendAccessibilityEvent(view, i);
                }

                @Override // android.support.v4.view.AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    accessibilityDelegateCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
                }
            });
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean dispatchPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(obj, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(obj, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onInitializeAccessibilityNodeInfo(Object obj, View view, Object obj2) {
            AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(obj, view, obj2);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void onPopulateAccessibilityEvent(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(obj, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public boolean onRequestSendAccessibilityEvent(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(obj, viewGroup, view, accessibilityEvent);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEvent(Object obj, View view, int i) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEvent(obj, view, i);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateStubImpl, android.support.v4.view.AccessibilityDelegateCompat.AccessibilityDelegateImpl
        public void sendAccessibilityEventUnchecked(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(obj, view, accessibilityEvent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityDelegateIcsImpl();
        } else {
            IMPL = new AccessibilityDelegateStubImpl();
        }
        DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
    }

    Object getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i) {
        IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, view, accessibilityNodeInfoCompat);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, viewGroup, view, accessibilityEvent);
    }
}
