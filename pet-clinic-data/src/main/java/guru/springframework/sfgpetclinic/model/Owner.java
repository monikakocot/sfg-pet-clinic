package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder // now with this constructor we can use in builder id,firstName and lastName for Owner
    public Owner(Long id, String firstName, String lastName,String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName,lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "adress")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    //GETTERS AND SETTERS

//    public Set<Pet> getPets() {
//        return pets;
//    }
//
//    public void setPets(Set<Pet> pets) {
//        this.pets = pets;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
}
