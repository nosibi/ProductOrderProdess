# 상품 주문 처리
## 1. 계층 설계
- Controller, Service, DAO, DB로 계층 구성
- Controller -> Service 에서는 DTO를 통해 데이터를 받아 Service 계층에서 DTO를 Entity로 변환하여 DAO에 넘김
- DAO에서 Entity를 통해 DB를 조작하고 DAO에게 Entity 데이터를 받은 Service 계층에서는 ResponseDTO로 변환하여 Controller에게 넘김
## 2. 데이터 테이블
- Product, Member, Order 엔티티를 정의하고 SpringData JPA를 사용하여 DB 테이블에 매칭
- 각각의 엔티티는 Primary Key로 Id값을 필드로 가짐
- Order 엔티티 클래스의 테이블명은 order_table임
## 3. 연관관계
- Order 엔티티는 Product, Member와 N:1 연관관계로 설정
- Order의 외래키로 Product, Member의 기본키를 설정
## 4. 명세
- Swagger를 사용하여 명세 작성
![Image](https://github.com/user-attachments/assets/ed45dc06-490c-447a-bb2f-c1c2d8fe3ef3)
## 5. 기능
- 회원, 상품에 대한 정보는 기본적으로 CRUD 가능
- 회원 정보는 이름과 등급을 수정하는 기능이 각각 있음
- 상품 정보는 재고, 가격을 각각 수정할 수 있게 기능 구현
- 주문을 신청할 경우 주문한 수량만큼 상품의 재고가 줄어들게 구현(DB에도 반영됨)
- 반대로 주문을 취소할 경우 그 수량만큼 상품의 재고가 늘어나게 구현(DB에도 반영됨)
- 주문 내역을 수정할 때 주문 상품만 수정 가능
- DB에는 주문자(회원), 주문한 상품(상품)의 id 값으로 표기되지만 주문 내역을 조회하면 이름으로 반환하도록 구현
![Image](https://github.com/user-attachments/assets/561eca7e-3061-4789-9a0c-415605808e12)
![Image](https://github.com/user-attachments/assets/720b0523-f673-402f-a40d-c72a22f966e9)
