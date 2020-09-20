package edu.noe.pruebatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.noe.pruebatecnica.entity.Fiscalia;

@Repository
public interface FiscaliaRepository extends JpaRepository<Fiscalia, Long> {

}
