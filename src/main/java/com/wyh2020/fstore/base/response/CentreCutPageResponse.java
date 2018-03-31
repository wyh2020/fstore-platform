//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wyh2020.fstore.base.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class CentreCutPageResponse<T> extends CentreListResponse<T> {
    private static final long serialVersionUID = 5888709607809204814L;


    private int pageNum;

    private int pageSize;

    private long totalCount;

    public CentreCutPageResponse(int pageNum, int pageSize, long totalCount, List<T> dataList) {
        super(dataList);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }
}
