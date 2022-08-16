package com.gearshop.ShoppingProject.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public abstract class AbstractDTO<T> {

    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private List<T> listResult = new ArrayList<>();
}
