package pe.business.app.users.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRq {

 public int number;
 public int citycode;
 public int countrycode;

}
