package weibo4android;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Paging implements Serializable {
    private static final long serialVersionUID = -3285857427993796670L;
    private int count;
    private long maxId;
    private int page;
    private long sinceId;

    public Paging() {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1L;
        this.maxId = -1L;
    }

    public Paging(int i) {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1L;
        this.maxId = -1L;
        setPage(i);
    }

    public Paging(long j) {
        this.page = -1;
        this.count = -1;
        this.sinceId = -1L;
        this.maxId = -1L;
        setSinceId(j);
    }

    public Paging(int i, int i2) {
        this(i);
        setCount(i2);
    }

    public Paging(int i, long j) {
        this(i);
        setSinceId(j);
    }

    public Paging(int i, int i2, long j) {
        this(i, i2);
        setSinceId(j);
    }

    public Paging(int i, int i2, long j, long j2) {
        this(i, i2, j);
        setMaxId(j2);
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("page should be positive integer. passed:" + i);
        }
        this.page = i;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("count should be positive integer. passed:" + i);
        }
        this.count = i;
    }

    public Paging count(int i) {
        setCount(i);
        return this;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public void setSinceId(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("since_id should be positive integer. passed:" + i);
        }
        this.sinceId = i;
    }

    public Paging sinceId(int i) {
        setSinceId(i);
        return this;
    }

    public void setSinceId(long j) {
        if (j < 1) {
            throw new IllegalArgumentException("since_id should be positive integer. passed:" + j);
        }
        this.sinceId = j;
    }

    public Paging sinceId(long j) {
        setSinceId(j);
        return this;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public void setMaxId(long j) {
        if (j < 1) {
            throw new IllegalArgumentException("max_id should be positive integer. passed:" + j);
        }
        this.maxId = j;
    }

    public Paging maxId(long j) {
        setMaxId(j);
        return this;
    }
}
