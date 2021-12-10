package com.zhy.wisdom.demo;

import java.util.Objects;

public class StringDemo {

    private String str;

    private Long L;

    private long l;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringDemo that = (StringDemo) o;
        return l == that.l &&
                Objects.equals(str, that.str) &&
                Objects.equals(L, that.L);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, L, l);
    }
}
