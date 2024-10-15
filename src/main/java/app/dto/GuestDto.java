
package app.dto;


public class GuestDto {
    
    private long Id;
    private boolean Status;
    private UserDto user;
    private PartnerDto Partner;

    public GuestDto(){
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PartnerDto getPartner() {
        return Partner;
    }

    public void setPartner(PartnerDto Partner) {
        this.Partner = Partner;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    
    
    
}
