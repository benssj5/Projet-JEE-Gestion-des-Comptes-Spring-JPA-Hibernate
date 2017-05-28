package org.sid.dao;

import org.sid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long>{

	@Query("select o from Operation o where o.compte.codeCompte =:x order by o.dateOperation desc")
	public Page<Operation> listOperation(@Param("x")String codeCpte, Pageable pageable);
		
	
}
