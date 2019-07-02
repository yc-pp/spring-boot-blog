package com.blog.base.util;

import java.io.Serializable;
import java.util.List;

public class BootStrapTableList implements Serializable {
    private List<?> rows;
    private int  total;

    public BootStrapTableList(List<?> rows, int total) {
        this.rows = rows;
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
