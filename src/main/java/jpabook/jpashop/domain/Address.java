package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address(){

    }//jpa spec상 만듦.

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }// 처음 등록할 때만 넣을 수 있도록 setter를 제거. 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스로 만들기
}
