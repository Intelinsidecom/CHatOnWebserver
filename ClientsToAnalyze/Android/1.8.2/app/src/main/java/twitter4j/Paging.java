package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

/* loaded from: classes.dex */
public final class Paging implements Serializable {
    static final String COUNT = "count";
    static final String PER_PAGE = "per_page";
    private static final long serialVersionUID = -3285857427993796670L;
    private int count;
    private long maxId;
    private int page;
    private long sinceId;

    /* renamed from: S */
    static char[] f7892S = {'s'};
    static char[] SMCP = {'s', 'm', 'c', 'p'};
    private static HttpParameter[] NULL_PARAMETER_ARRAY = new HttpParameter[0];
    private static List NULL_PARAMETER_LIST = new ArrayList(0);

    List asPostParameterList() {
        return asPostParameterList(SMCP, COUNT);
    }

    HttpParameter[] asPostParameterArray() {
        List listAsPostParameterList = asPostParameterList(SMCP, COUNT);
        return listAsPostParameterList.size() == 0 ? NULL_PARAMETER_ARRAY : (HttpParameter[]) listAsPostParameterList.toArray(new HttpParameter[listAsPostParameterList.size()]);
    }

    List asPostParameterList(char[] cArr) {
        return asPostParameterList(cArr, COUNT);
    }

    List asPostParameterList(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        addPostParameter(cArr, 's', arrayList, "since_id", getSinceId());
        addPostParameter(cArr, 'm', arrayList, "max_id", getMaxId());
        addPostParameter(cArr, 'c', arrayList, str, getCount());
        addPostParameter(cArr, 'p', arrayList, "page", getPage());
        if (arrayList.size() == 0) {
            return NULL_PARAMETER_LIST;
        }
        return arrayList;
    }

    HttpParameter[] asPostParameterArray(char[] cArr, String str) {
        ArrayList arrayList = new ArrayList(cArr.length);
        addPostParameter(cArr, 's', arrayList, "since_id", getSinceId());
        addPostParameter(cArr, 'm', arrayList, "max_id", getMaxId());
        addPostParameter(cArr, 'c', arrayList, str, getCount());
        addPostParameter(cArr, 'p', arrayList, "page", getPage());
        return arrayList.size() == 0 ? NULL_PARAMETER_ARRAY : (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void addPostParameter(char[] cArr, char c, List list, String str, long j) {
        boolean z = false;
        int length = cArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (cArr[i] != c) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (!z && -1 != j) {
            throw new IllegalStateException(new StringBuffer().append("Paging parameter [").append(str).append("] is not supported with this operation.").toString());
        }
        if (-1 != j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
        }
    }

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
            throw new IllegalArgumentException(new StringBuffer().append("page should be positive integer. passed:").append(i).toString());
        }
        this.page = i;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("count should be positive integer. passed:").append(i).toString());
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

    public void setSinceId(long j) {
        if (j < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("since_id should be positive integer. passed:").append(j).toString());
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
            throw new IllegalArgumentException(new StringBuffer().append("max_id should be positive integer. passed:").append(j).toString());
        }
        this.maxId = j;
    }

    public Paging maxId(long j) {
        setMaxId(j);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paging)) {
            return false;
        }
        Paging paging = (Paging) obj;
        return this.count == paging.count && this.maxId == paging.maxId && this.page == paging.page && this.sinceId == paging.sinceId;
    }

    public int hashCode() {
        return (((((this.page * 31) + this.count) * 31) + ((int) (this.sinceId ^ (this.sinceId >>> 32)))) * 31) + ((int) (this.maxId ^ (this.maxId >>> 32)));
    }

    public String toString() {
        return new StringBuffer().append("Paging{page=").append(this.page).append(", count=").append(this.count).append(", sinceId=").append(this.sinceId).append(", maxId=").append(this.maxId).append('}').toString();
    }
}
