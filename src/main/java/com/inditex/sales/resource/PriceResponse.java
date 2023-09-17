package com.inditex.sales.resource;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Represents a Price
 */
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceResponse {

    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
}
