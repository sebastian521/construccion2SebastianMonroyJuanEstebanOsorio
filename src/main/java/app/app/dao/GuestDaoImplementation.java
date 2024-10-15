/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.app.dao;

import app.dao.Interfaces.GuestDao;
import app.dao.repositories.GuestRepository;
import app.dto.GuestDto;
import app.helpers.Helpers;
import app.model.Guest;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tsuna
 */
@Service
@Getter
@Setter
@NoArgsConstructor
public class GuestDaoImplementation implements GuestDao {
    @Autowired
    GuestRepository guestrepository;
    
    public boolean existsById(GuestDto GuestDto) throws Exception {
         return guestrepository.existsById(GuestDto.getId());
                
	}
     /*public GuestDto getGuestById(long guestId) throws Exception{
         Optional<Guest> optionalGuest = guestrepository.findById(guestId);
               return Helpers.parse(optionalGuest.get());*/

    @Override
    public GuestDto getGuestById(long guestId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}