package com.igort.dsvendas.controllers;

import com.igort.dsvendas.dto.SaleDTO;
import com.igort.dsvendas.dto.SaleSuccessDTO;
import com.igort.dsvendas.dto.SaleSumDTO;
import com.igort.dsvendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = saleService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> list = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/sucess-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> sucessGroupedBySeller() {
        List<SaleSuccessDTO> list = saleService.sucessGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}
