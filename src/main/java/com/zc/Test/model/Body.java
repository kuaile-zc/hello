package com.zc.Test.model;

import lombok.Data;

import java.util.List;

/**
 * @author CoreyChen Zhang
 * @date 2021/8/4 17:28
 * @modified
 */
@Data
public class Body {
    private String shop_id;
    private String fence_id;
    private String fence_name;
    private String fence_type;
    private List<GpsDates> gps;
    private String area;
    private String time;
    private String price;
    private Object fee;
}
