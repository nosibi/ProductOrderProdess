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
## 6. 보완할 점
- 상품명으로 분류하기보다 카테고리로 분류하고 세부 상품명으로 테이블을 구성하는 것이 더 현실적임
- 회원 등급에 따른 가격 할인을 적용하는 기능을 추가 구현 :white_check_mark:
- 회원의 이름으로 주문 내역 리스트를 조회하거나 동명이인 회원 리스트를 조회하는 기능 구현 ----> QueryDSL을 사용하여 CustomRepository 구성 필요
- 테스트 코드를 별도로 작성하지 않고 Talend API Tester로 테스트를 했는데 TDD 개발을 위해서는 테스트 코드를 별도로 작성할 필요가 있음
- 계층별로 각각 도메인을 만들었는데 도메인별로 계층을 만들어보는 방법도 좋을 것 같다고 생각함
- 클라이언트로부터 받는 데이터에 대한 유효성 검사 추가해서 데이터 무결성 확보 :white_check_mark:
- DAO에서 예외처리를 구체화하고 상황별로 상태 코드를 다르게 반환하도록 수정 필요함
