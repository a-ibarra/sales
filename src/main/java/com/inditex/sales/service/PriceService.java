package com.inditex.sales.service;

import com.inditex.sales.PriceTransformer;
import com.inditex.sales.repository.PriceRepository;
import com.inditex.sales.repository.entity.Price;
import com.inditex.sales.resource.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public PriceResponse findApplicablePrice(final Long brandId, final Long productId, final LocalDateTime applyDate) {
        log.info("Attempting to query brandId={}, productId={} applyDate={}", brandId, productId, applyDate);
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            brandId, productId, applyDate, applyDate
        );
        log.info("Found [{}] matches", prices.size());
        return prices.stream()
            .findFirst()
            .map(PriceTransformer::fromEntity)
            .orElse(PriceResponse.builder().build());
    }
}