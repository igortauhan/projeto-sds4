package com.igort.dsvendas.service;

import com.igort.dsvendas.dto.SaleDTO;
import com.igort.dsvendas.dto.SaleSuccessDTO;
import com.igort.dsvendas.dto.SaleSumDTO;
import com.igort.dsvendas.entities.Sale;
import com.igort.dsvendas.repositories.SaleRepository;
import com.igort.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> list = saleRepository.findAll(pageable);
        return list.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> sucessGroupedBySeller() {
        return saleRepository.sucessGroupedBySeller();
    }
}
