package app.dao.Interfaces;

import app.dto.UserDto;
import java.sql.Date;
import java.util.List;
import app.dto.PartnerDto;

public interface PartnerDao {
    public void createPartner(PartnerDto partnerDto) throws Exception;
    
    public PartnerDto findByUserId(UserDto userDto) throws Exception;

    public PartnerDto findById(PartnerDto PartnerDto) throws Exception;

    public boolean existsById(UserDto UserDto) throws Exception;
}
