package weibo4android;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ListObjectWapper implements Serializable {
    private static final long serialVersionUID = -3119168701303920284L;
    private List<ListObject> listObjects;
    private long nextCursor;
    private long previousCursor;

    public ListObjectWapper(List<ListObject> list, long j, long j2) {
        this.listObjects = list;
        this.previousCursor = j;
        this.nextCursor = j2;
    }

    public List<ListObject> getListObjects() {
        return this.listObjects;
    }

    public void setListObjects(List<ListObject> list) {
        this.listObjects = list;
    }

    public long getPreviousCursor() {
        return this.previousCursor;
    }

    public void setPreviousCursor(long j) {
        this.previousCursor = j;
    }

    public long getNextCursor() {
        return this.nextCursor;
    }

    public void setNextCursor(long j) {
        this.nextCursor = j;
    }
}
