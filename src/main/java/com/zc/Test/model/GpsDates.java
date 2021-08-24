package com.zc.Test.model;

import lombok.Data;

import java.util.List;

/**
 * @author CoreyChen Zhang
 * @date 2021/8/4 17:31
 * @modified
 */
@Data
public class GpsDates {
    private String type;
    private List<double[]> lnglats;
}
