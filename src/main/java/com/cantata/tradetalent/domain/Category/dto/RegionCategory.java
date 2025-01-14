package com.cantata.tradetalent.domain.Category.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegionCategory {

    private int id;
    private int regionGroup;
    private String regionGroupName;
    private int province;
    private String provinceName;
    private int district;
    private String districtName;

}
