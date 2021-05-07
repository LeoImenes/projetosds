package Leoimenes.Vendasds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Leoimenes.Vendasds.dto.SaleDTO;
import Leoimenes.Vendasds.dto.SaleSuccessDTO;
import Leoimenes.Vendasds.dto.SaleSumDTO;
import Leoimenes.Vendasds.entities.Sale;
import Leoimenes.Vendasds.repositories.SaleRepository;
import Leoimenes.Vendasds.repositories.SellerRepository;

@Service
public class SaleService {

		@Autowired
		private SaleRepository repository;
		
		@Autowired
		private SellerRepository sellerRepository;
		
		@Transactional(readOnly = true)
		public Page<SaleDTO> findAll(Pageable pageable){
			sellerRepository.findAll();
			Page<Sale>result=repository.findAll(pageable);
			return result.map(x -> new SaleDTO(x));
			
		}
		@Transactional(readOnly = true)
		public List<SaleSumDTO> amountGroupedBySeller(){
			return repository.amountGroupedBySeller();
		}
		@Transactional(readOnly = true)
		public List<SaleSuccessDTO> successGroupedBySeller(){
			return repository.successGroupedBySeller();
		}
}