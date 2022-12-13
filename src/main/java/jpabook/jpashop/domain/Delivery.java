package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // 0,1과 같이 숫자로 구분하기 시작하면 중간에 status가 늘어나서 사이에 들어가면 기존의 것이 XX로 처리됨. ->string
    private DeliveryStatus status;  //ready, comp
}
