package com.inditex.sales;

import com.inditex.sales.repository.entity.Price;
import com.inditex.sales.resource.PriceResponse;

/**
 * Transform Price from Entity to Model
 */
public final class PriceTransformer {

    private PriceTransformer() {
    }

    public static PriceResponse fromEntity(final Price price) {
        return PriceResponse.builder()
            .productId(price.getProductId())
            .brandId(price.getBrand().getId())
            .priceList(price.getPriceList())
            .startDate(price.getStartDate())
            .endDate(price.getEndDate())
            .price(price.getPrice())
            .build();
    }
}
