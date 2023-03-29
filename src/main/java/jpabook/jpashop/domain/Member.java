package jpabook.jpashop.domain;

import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "number_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy ="member")
    private List<Order> orders = new ArrayList<>();


}
