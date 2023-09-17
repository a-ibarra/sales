package com.inditex.sales.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * Class for Price filter options
 *
 * @param brandId   the ID of the brand for the given product
 * @param productId the ID of the given product
 * @param applyDate the time that is applied the price
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PriceFilterRequest(
    @NotNull Long brandId,
    @NotNull Long productId,
    @NotNull LocalDateTime applyDate
) {
}
