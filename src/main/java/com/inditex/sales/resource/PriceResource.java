package com.inditex.sales.resource;

import com.inditex.sales.error.ValidationException;
import com.inditex.sales.service.PriceService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Resource API for a Price
 */
@RestController
@RequestMapping("/api/v1/prices")
public class PriceResource {

    private final PriceService priceService;

    public PriceResource(final PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping(path = "/search")
    public PriceResponse getApplicablePrice(
        @RequestBody @Valid PriceFilterRequest filterRequest,
        final BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Validation error", bindingResult);
        }
        return priceService.findApplicablePrice(filterRequest.brandId(), filterRequest.productId(), filterRequest.applyDate());
    }
}
