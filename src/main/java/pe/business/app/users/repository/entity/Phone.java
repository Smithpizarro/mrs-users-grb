package pe.business.app.users.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "tbl_phones")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull(message = "number must not be null")
    @Positive(message = "number must be mayor than zero")
    private  int number;

    @NotNull(message = "citycode not be null")
    @Column(name = "citycode", nullable=false)
    @Positive(message = "citycode must be mayor than zero")
    private int citycode;

    @NotNull(message = "countrycode not be null")
    @Column(name = "countrycode", nullable=false)
    @Positive(message = "countrycode must be mayor than zero")
    private int countrycode;

    @NotNull(message = "La categoria no puede ser vacia")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private User user;

}
