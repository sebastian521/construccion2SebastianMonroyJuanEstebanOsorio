
package app.helpers;

import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Person;
import app.model.User;
import app.model.Partner;
import app.dto.PartnerDto;

public abstract class Helpers {
    public static PersonDto parse(Person Person){
        PersonDto personDto = new PersonDto();
	personDto.setiD(Person.getID());
	personDto.setDocument(Person.getDocument());
	personDto.setName(Person.getName());
	personDto.setCellPhoneNumber(Person.getCellPhone());
	return personDto;     
        
    }
    public static Person parse(PersonDto personDto) {
		Person person = new Person();
		person.setID(personDto.getiD());
		person.setDocument(personDto.getDocument());
		person.setName(personDto.getName());
		person.setCellPhone(personDto.getCellPhoneNumber());
		return person;
	}
    public static UserDto parse(User user) {
                
		UserDto userDto = new UserDto();
                if (user.getPersonID()!=null){
                    userDto.setPersonId(parse(user.getPersonID()));
                }
		userDto.setID(user.getId());
		userDto.setPersonId(parse(user.getPersonID()));
		userDto.setRole(user.getRole());
		userDto.setUserName(user.getUsername());
                userDto.setPassword(user.getPassword());
		return userDto;
	}
    public static User parse(UserDto userDto) {
      
		User user = new User();
                 if (userDto.getPersonId()!=null){
                   user.setPersonID(parse(userDto.getPersonId()));
                }
		user.setId(userDto.getID());
		user.setPersonID(parse(userDto.getPersonId()));
		user.setRole(userDto.getRole());
		user.setUsername(userDto.getUserName());
                user.setPassword(userDto.getPassword());
		return user;
	}
    public static PartnerDto parse(Partner Partner){
                PartnerDto PartnerDto = new PartnerDto();
                PartnerDto.setID(Partner.getID());
                PartnerDto.setMoney(Partner.getMoney());
                Partner.setType(PartnerDto.getType());
                Partner.setDateCreated(Partner.getDateCreated());
                Partner.setUserID(parse(PartnerDto.getUserId()));
                return PartnerDto;
        
    }
    public static Partner parse(PartnerDto PartnerDto){
                Partner Partner = new Partner();
                Partner.setID(PartnerDto.getID());
                Partner.setMoney(PartnerDto.getMoney());
                Partner.setType(PartnerDto.getType());
                Partner.setDateCreated(PartnerDto.getDatecreated());
		Partner.setUserID(parse(PartnerDto.getUserId()));
                return Partner;
    }
    
}
