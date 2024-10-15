/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.GuestDto;

/**
 *
 * @author tsuna
 */
public interface GuestDao {
   public GuestDto getGuestById(long guestId) throws Exception;
}
