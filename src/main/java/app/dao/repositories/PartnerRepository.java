/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repositories;

import app.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tsuna
 */
@Repository
public interface PartnerRepository extends JpaRepository < Partner, Long > {

    public boolean existsByID(long iD);
    public Partner findByid(Long iD);

    
}
