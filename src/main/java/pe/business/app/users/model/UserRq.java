package pe.business.app.users.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRq {

 public String name;


 public String email;

 public String password;

 public List<PhoneRq> phones;

}
