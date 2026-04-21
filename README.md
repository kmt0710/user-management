# \#User Management (Console)

콘솔 기반 회원 관리 프로그램입니다.

## \## 기능

* 회원 등록
* 전체 회원 조회
* 회원 조회
* 회원 수정
* 회원 삭제

## \## 구조

* domain
* repository
* service
* ui

## \## 설계 의도

* Repository는 데이터 접근만 담당하고, 비지니스 로직은 Service에서 처리하도록 분리
* 역활 분리를 통해 유지보수성과 확장성을 고려한 구조로 설계
* soft delete를 통해 데이터 보존 및 정책 확장 가능하도록 설계

## \## 학습 내용

* 객체 역할 분리
* Service / Repository 구조 이해
* 패키지 구조 분리

## \## 실행 방법

* Main.java 실행

## \## 1강 학습 내용

* 콘솔 기반 회원 관리 프로그램 기본 구조 구현
* User / UserRepository / UserService / Main 클래스 구성
* 회원 등록 / 조회 / 삭제 기능 구현

## \## 2강 학습 내용

* 패키지 구조 분리 (domain / repository / service / ui)
* 회원 수정 기능 추가
* soft delete 적용 (deleted 필드 사용)
* 삭제된 계정 재가입 정책 적용
* 조회 목적에 따라 Repository 메서드 분리

&#x20; - findByLoginId (활성 유저)

&#x20; - findByLoginIdIncludingDeleted (전체 유저)

## \## 3강 학습 내용

* User 엔티티를 내부에 그대로 노출하지 않도록 DTO 적용
* UserResponse DTO 추가
* 단건 조회 및 전체 조회를 DTO 반환 구조로 변경
* 민감정보와 내부 구조 노출을 줄이기 위한 데이터 전달 방습 학습

## \## 4강 학습 내용

* CreateUserRequest, UpdateUserRequest DTO 추가
* 회원 등록 및 수정 입력을 Request DTO 기반 구조로 변경
* 생성 요청과 수정 요청의 역활 분리 학습
* 입력값은 의미 있는 객체 단위로 전달하는 구조 적용



