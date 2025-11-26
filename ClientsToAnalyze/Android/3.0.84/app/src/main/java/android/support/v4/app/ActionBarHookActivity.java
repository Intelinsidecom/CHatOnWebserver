package android.support.v4.app;

import android.os.Build;
import android.view.Menu;
import android.view.View;
import com.sec.common.actionbar.MenuC3303t;

/* loaded from: classes.dex */
public class ActionBarHookActivity extends FragmentActivity {
    private MenuC3303t mMenuImpl;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (Build.VERSION.SDK_INT >= 11 || i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean zOnCreateOptionsMenu = onCreateOptionsMenu(menu);
        if (!(menu instanceof MenuC3303t)) {
            return zOnCreateOptionsMenu;
        }
        this.mMenuImpl = (MenuC3303t) menu;
        return this.mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater()) | zOnCreateOptionsMenu;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (Build.VERSION.SDK_INT >= 11 || i != 0) {
            return super.onPreparePanel(i, view, menu);
        }
        return (onPrepareOptionsMenu(this.mMenuImpl) || this.mFragments.dispatchPrepareOptionsMenu(this.mMenuImpl)) && menu.hasVisibleItems();
    }
}
