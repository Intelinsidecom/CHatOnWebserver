package android.support.v4.widget;

import android.content.Context;
import android.view.View;
import android.widget.SearchView;

/* loaded from: classes.dex */
class SearchViewCompatHoneycomb {

    interface OnQueryTextListenerCompatBridge {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    SearchViewCompatHoneycomb() {
    }

    public static View newSearchView(Context context) {
        return new SearchView(context);
    }

    public static Object newOnQueryTextListener(final OnQueryTextListenerCompatBridge onQueryTextListenerCompatBridge) {
        return new SearchView.OnQueryTextListener() { // from class: android.support.v4.widget.SearchViewCompatHoneycomb.1
            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                return onQueryTextListenerCompatBridge.onQueryTextSubmit(str);
            }

            @Override // android.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                return onQueryTextListenerCompatBridge.onQueryTextChange(str);
            }
        };
    }

    public static void setOnQueryTextListener(Object obj, Object obj2) {
        ((SearchView) obj).setOnQueryTextListener((SearchView.OnQueryTextListener) obj2);
    }
}
