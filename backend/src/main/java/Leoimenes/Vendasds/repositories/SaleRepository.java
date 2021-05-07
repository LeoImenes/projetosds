package Leoimenes.Vendasds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Leoimenes.Vendasds.dto.SaleSuccessDTO;
import Leoimenes.Vendasds.dto.SaleSumDTO;
import Leoimenes.Vendasds.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new Leoimenes.Vendasds.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" + "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new Leoimenes.Vendasds.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals))" + "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSuccessDTO> successGroupedBySeller();
}
