package app.Service;

import java.sql.SQLException;
import app.dao.Interfaces.UserDao;
import app.dao.Interfaces.GuestDao;
import app.dao.Interfaces.PartnerDao;
import app.dao.Interfaces.PersonDao;
import app.dao.Interfaces.InvoiceDao;
import app.dao.Interfaces.InvoiceDetailDao;
import app.dto.GuestDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.dto.PartnerDto;
import app.ServiceInterface.AdminService;
import app.ServiceInterface.LoginService;
import app.ServiceInterface.PartnerService;
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

public class ServiceClub implements LoginService, AdminService, PartnerService {
    @Autowired
        private PersonDao person;
    @Autowired
        private UserDao userdao;
    @Autowired
        private PartnerDao partner;
    @Autowired
    private GuestDao guest;
     @Autowired
    private InvoiceDao invoice;
      @Autowired
     private InvoiceDetailDao invoicedetail;   
     @Autowired 
        public static UserDto user;
    
    
    @Override
    public void Login(UserDto userDto) throws Exception {
        UserDto validateDto = userdao.findByID(userDto);
        if (validateDto == null) {
            throw new Exception("no existe ese usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            System.out.println(validateDto.getPassword());
            System.out.println(userDto.getPassword());
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRole(validateDto.getRole());
        user = validateDto;
    }

    @Override
    public void Logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    private void createPerson(PersonDto personDto) throws Exception {
        if (this.person.existsByDocument(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
        }
        this.person.createPerson(personDto);
    }

    private void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        if (this.userdao.existsByUserName(userDto)) {
            this.person.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try {
            this.userdao.createUser(userDto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.person.deletePerson(userDto.getPersonId());
        }
    }
    @Override
     public void CreatePartner(PartnerDto partnerDto) throws Exception{
        
        this.createUser(partnerDto.getUserId());
        UserDto userDto = userdao.findByID(partnerDto.getUserId());
        partnerDto.setUserId(userDto);
        this.partner.createPartner(partnerDto);
     }

    @Override
    public void createGuest(GuestDto GuestDto) throws Exception{
        this.createUser(GuestDto.getUser());
        PartnerDto partnerDto = partner.findByUserId(user);
        GuestDto.setPartner(partnerDto);
    }
    public GuestDto getGuestById(long guestId) throws Exception {
        return guest.getGuestById(guestId);
    }
}
