package jpabook.jpashop.domain;

import jpabook.jpashop.domain.Item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany //실무에서는 사용하지 않음
    @JoinTable(name="category_item",
                joinColumns = @JoinColumn(name="category_id"),
                inverseJoinColumns = @JoinColumn(name="item_id"))
    //객체에서는 컬렉션으로 다대다가 가능하지만 관계형 디비는 양쪽에 컬렉션 관계를 가질 수 없어서 매핑 테이블을 만들어줘야함
    private List<Item> items = new ArrayList<>();

    @ManyToOne //category가 부모 카테고리는 하나만 가질 수 있어서 다대일
    @JoinColumn(name="parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

}
