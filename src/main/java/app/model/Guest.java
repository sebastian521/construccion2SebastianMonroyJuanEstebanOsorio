package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 

 
@Getter
@Setter
@NoArgsConstructor
@Entity 
@Table(name="Guest")
public class Guest {
    
    @Id 
    @Column (name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name="USERID")
    @OneToOne
    private User user;
    @JoinColumn(name="PARTNERID")
    @OneToOne
    private Partner partner;
    @Column (name="STATUS")
    private String status;
    
    

    

    
    
      
    }

  
    


