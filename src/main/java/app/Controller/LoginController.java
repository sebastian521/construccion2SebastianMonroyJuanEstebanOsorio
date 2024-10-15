package app.Controller;


import java.util.HashMap;
import java.util.Map;
import app.controllervalidator.UserValidator;
import app.dto.UserDto;
import app.Service.ServiceClub;
import app.ServiceInterface.LoginService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@Controller
public class LoginController implements ControllerInterface{
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private LoginService service;
    private static final String MENU= "ingrese la opcion que desea: "
    + "\n 1. para iniciar sesion. \n 2. para detener la ejecucion.";
    private Map<String,ControllerInterface> roles;
	
        public LoginController(AdminController adminController,PartnerController partnerController,GuestController guestController) {
                this.roles= new HashMap<String,ControllerInterface>();
		roles.put("admin", adminController);
		roles.put("Partner",partnerController );
		roles.put("Guest",guestController);
                
	}
    @Override
public void session() throws Exception {
	boolean session = true;
		while (session) {
			session = menu();
		}		
	}
	
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
private boolean options(String option) throws Exception {
	switch (option) {
		case "1": {
			this.login();
			return true;
		}
	case "2": {
			System.out.println("el programa se detiene");
			return false;
		}
	default: {
			System.out.println("ingrese una opcion que sea valida");
			return true;
		}
		}
	}
	
	private void login()throws Exception {
		System.out.println("ingrese el usuario");
		String userName= Utils.getReader().nextLine();
		
                userValidator.validUsarName(userName);
		System.out.println("ingrese la contraseña");
		String password= Utils.getReader().nextLine();
                
		userValidator.validPassword(password);
		UserDto userDto = new UserDto();
		userDto.setPassword(password);
		userDto.setUserName(userName);
                
		this.service.Login(userDto);
		if(roles.get(userDto.getRole())==null) {
                throw new Exception ("Rol invalido");
		}
	roles.get(userDto.getRole()).session();
		
	}
	
	

    
}
