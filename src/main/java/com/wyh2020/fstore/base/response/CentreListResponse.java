package com.wyh2020.fstore.base.response;

import com.wyh2020.fstore.base.BaseSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CentreListResponse<T> extends BaseSerializable {
    private static final long serialVersionUID = -7628952830016632166L;

    private List<T> dataList;

}
