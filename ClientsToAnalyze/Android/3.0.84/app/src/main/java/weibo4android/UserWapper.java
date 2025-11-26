package weibo4android;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class UserWapper implements Serializable {
    private static final long serialVersionUID = -3119107701303920284L;
    private long nextCursor;
    private long previousCursor;
    private List<User> users;

    public UserWapper(List<User> list, long j, long j2) {
        this.users = list;
        this.previousCursor = j;
        this.nextCursor = j2;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> list) {
        this.users = list;
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
