package android.sec.multiwindow;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;

/* loaded from: classes.dex */
public abstract class MWOnDragListener implements View.OnDragListener {
    public static final String TAG = "MWOnDragListener";

    public abstract void onDrop(DragEvent dragEvent);

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
            case 2:
            case 5:
            case 6:
                return true;
            case 3:
                onDrop(dragEvent);
                view.invalidate();
                return true;
            case 4:
                view.invalidate();
                return true;
            default:
                Log.w(TAG, "Unknown action type received by OnDragListener.");
                return false;
        }
    }
}
