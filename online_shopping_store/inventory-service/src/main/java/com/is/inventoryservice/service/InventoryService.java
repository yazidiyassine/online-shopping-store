package com.is.inventoryservice.service;

import com.is.inventoryservice.dto.InventoryResponse;
import com.is.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String>  skuCode){
        log.info("Finding inventory for sku codes: {}", skuCode);
        Thread.sleep(1000);
        log.info("Inventory found for sku codes: {}", skuCode);
        return inventoryRepository.findBySkuCodeIn(skuCode).stream().
                map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}
