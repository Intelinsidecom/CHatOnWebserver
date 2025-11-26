package twitter4j.internal.async;

/* loaded from: classes.dex */
public interface Dispatcher {
    void invokeLater(Runnable runnable);

    void shutdown();
}
