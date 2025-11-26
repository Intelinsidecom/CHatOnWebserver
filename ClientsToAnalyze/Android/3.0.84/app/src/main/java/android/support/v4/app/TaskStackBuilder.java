package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TaskStackBuilder implements Iterable<Intent> {
    private static final TaskStackBuilderImpl IMPL;
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents = new ArrayList<>();
    private final Context mSourceContext;

    interface TaskStackBuilderImpl {
        PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderImpl
        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent = intentArr[intentArr.length - 1];
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, i, intent, i2);
        }
    }

    class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderImpl
        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0].addFlags(268468224);
            return TaskStackBuilderHoneycomb.getActivitiesPendingIntent(context, i, intentArr, i2);
        }
    }

    class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        TaskStackBuilderImplJellybean() {
        }

        @Override // android.support.v4.app.TaskStackBuilder.TaskStackBuilderImpl
        public PendingIntent getPendingIntent(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0].addFlags(268468224);
            return TaskStackBuilderJellybean.getActivitiesPendingIntent(context, i, intentArr, i2, bundle);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilderImplHoneycomb();
        } else {
            IMPL = new TaskStackBuilderImplBase();
        }
    }

    private TaskStackBuilder(Context context) {
        this.mSourceContext = context;
    }

    public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    public static TaskStackBuilder from(Context context) {
        return create(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        this.mIntents.add(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        int size = this.mIntents.size();
        Intent parentActivityIntent = NavUtils.getParentActivityIntent(activity);
        while (parentActivityIntent != null) {
            this.mIntents.add(size, parentActivityIntent);
            try {
                parentActivityIntent = NavUtils.getParentActivityIntent(activity, parentActivityIntent.getComponent());
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e);
            }
        }
        return this;
    }

    public TaskStackBuilder addParentStack(Class<?> cls) {
        int size = this.mIntents.size();
        try {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.mSourceContext, cls);
            while (parentActivityIntent != null) {
                this.mIntents.add(size, parentActivityIntent);
                parentActivityIntent = NavUtils.getParentActivityIntent(this.mSourceContext, parentActivityIntent.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent getIntent(int i) {
        return editIntentAt(i);
    }

    public Intent editIntentAt(int i) {
        return this.mIntents.get(i);
    }

    @Override // java.lang.Iterable
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
        intentArr[0].addFlags(268484608);
        if (!ContextCompat.startActivities(this.mSourceContext, intentArr, bundle)) {
            Intent intent = intentArr[intentArr.length - 1];
            intent.addFlags(268435456);
            this.mSourceContext.startActivity(intent);
        }
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, null);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
        intentArr[0].addFlags(268484608);
        return IMPL.getPendingIntent(this.mSourceContext, intentArr, i, i2, bundle);
    }

    public Intent[] getIntents() {
        return (Intent[]) this.mIntents.toArray(new Intent[this.mIntents.size()]);
    }
}
