package android.support.v4.app;

import android.os.Build;
import android.view.Menu;
import android.view.View;
import com.sec.common.actionbar.MenuC4965t;

/* loaded from: classes.dex */
public class ActionBarHookActivity extends FragmentActivity {

    /* renamed from: n */
    private MenuC4965t f34n;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (Build.VERSION.SDK_INT >= 11 || i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean zOnCreateOptionsMenu = onCreateOptionsMenu(menu);
        if (!(menu instanceof MenuC4965t)) {
            return zOnCreateOptionsMenu;
        }
        this.f34n = (MenuC4965t) menu;
        return this.f45b.m210a(menu, getMenuInflater()) | zOnCreateOptionsMenu;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (Build.VERSION.SDK_INT >= 11 || i != 0) {
            return super.onPreparePanel(i, view, menu);
        }
        return (onPrepareOptionsMenu(this.f34n) || this.f45b.m209a(this.f34n)) && menu.hasVisibleItems();
    }
}
