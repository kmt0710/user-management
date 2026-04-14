# User Management (Console)

콘솔 기반 회원 관리 프로그램입니다.

## 기능

* 회원 등록
* 전체 회원 조회
* 회원 조회
* 회원 삭제

## 구조

* domain
* repository
* service
* ui

## 학습 내용

* 객체 역할 분리
* Service / Repository 구조 이해
* 패키지 구조 분리

## 실행 방법

* Main.java 실행



\##  1강 학습 내용

* 콘솔 기반 회원 관리 프로그램 기본 구조 구현
* User / UserRepository / UserService / Main 클래스 구성
* 회원 등록 / 조회 /  삭제 기능 구현



\##  2강 학습 내용

* 패키지 구조 분리 (domain / repository / service / ui)
* 회원 수정 기능 추가
* soft delete 적용 (deleted 필드 사용)
* 삭제된 계정 재가입 정책 적용
* 조회 목적에 따라 Repository 메서드 분리

\- findByLoginId (활성 유저) 

\- findByLoginIdIncloudingDeleted (전체 유저)

