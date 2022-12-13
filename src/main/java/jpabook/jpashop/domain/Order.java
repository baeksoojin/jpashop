package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Orders")
@Getter
@Setter
public class Order {
    @Id @GeneratedValue
    @Column(name ="order_id")
    private Long id;

    @ManyToOne //FK
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy ="order") //orderItems의 order column으로 mapping한다는 의미 -> 읽기전용
    private List<OderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
    private LocalDateTime orderDate; //DateTime과 달리 annotation이 필요없음

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태로 [order, cancel]로 생성



}
