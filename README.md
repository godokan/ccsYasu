# 어바웃 송담

&nbsp;'어바웃 송담'은 2023년 용인예술과학대학교 융합캡스톤디자인 경진대회 '야수의 심장' 팀이 제작한 출품작 및 우승작으로, cafe24에서 제공하는 가상 서버 호스팅 서비스를 통해 우분투 리눅스 터미널 및 서버를 구축한 후, Spring-Boot(java)와 mysql을 바탕으로 동작하는 컴퓨터융합소프트웨어학과 프로젝트 개발용 커뮤니티 웹 서비스입니다.

&nbsp;학과 내 소통을 위한 커뮤니티 형성을 위해 토이 프로젝트로 시작하였던 어바웃 송담은, 그 시작이 에브리타임 카피 사이트 프로젝트 이었습니다. 그러나 캡스톤 디자인 경진대회를 위한 서버 개발 및 운영을 맡게 되며 학과생을 대상으로 API 서버, DB 서버, 리눅스 터미널 등을 제공하고 이를 관리해야 하는 문제가 생기게 되었습니다.

&nbsp;학과생 하나 하나를 모두 식별하며 서비스를 제공해야 했기 때문에 회원제로 운영을 해야 하며, 실제로 동작하며 외부에서 접근이 가능하면서도 직접 제어가 가능 한 서버가 필요해졌습니다.

&nbsp;이에 단순 커뮤니티 사이트 카피 프로젝트였던 어바웃송담이 가지고 있던 회원제 시스템과 게시판 기능을 이용하여 학과생을 식별하며, 개발 관련 공지사항을 전달하는 등 회원 관리 및 학과생과의 소통 창구로서 기능 하도록 만든것이 지금의 어바웃 송담입니다.

&nbsp;따라서 현재 어바웃 송담은 게시판 이용과 API 서버 사용 요청을 위한 회원제로 운영하는 교내 개발용 커뮤니티 웹 서비스입니다.

&nbsp;어바웃 송담과 [어바웃 송담 API](https://github.com/godokan/ccsApi) 프로젝트 모두 private 상태로 소스를 공개하지 않았으나, 현재는 모든 개발 및 배포 작업이 완료되어 더 이상 버전관리의 필요성이 없다고 판단, public으로 전환하여 포트폴리오로서의 기능을 할 수 있도록 전환하였습니다.

## 개발 목표 및 필요성

* 서버가 필요한 학생들에게 다양한 형태의 서버 환경 제공

&nbsp;컴퓨터융합소프트웨어학과는 융합소프트웨어개발자, 정보보안전문가, 정보시스템운영자를 양성하는 과정이며 이 중 개발자를 지망하는 재학생이 많아 대부분은 웹 어플리케이션, 모바일 어플리케이션, 응용소프트웨어, 엔터테인먼트 소프트웨어 등과 관련한 프로젝트들이 주를 이루게 됩니다.
<br>&nbsp;이러한 프로젝트를 실제 사용 환경에서는 모두 서버에 배포하여 외부에서 안전하게 접근 할 수 있도록 합니다. 때문에 서버를 제공함으로서 각 프로젝트 팀에게 결과물을 외부에서 접근할 수 있는 형태로 공개할 수 있도록 할 수 있고, 데이터베이스 서버를 통해 대용량 데이터 처리 및 저장 환경을 제공할 수 있으며, 서버라는 매개체를 통해 프로젝트 관련 자료와 코드를 하나의 저장소에서 공유 해 쉽게 협업 할 수 있는 환경을 만들어 줄 수 있습니다.

* 데이터 작업이 필요한 학생들에게 API 서버를 맞춤 제작하여 작업 환경 제공

&nbsp;DB(데이터베이스) 서버를 기반으로 접근이 세밀하게 제어되는 REST API 서버를 통해 DB를 간접적으로 사용 할 수 있는 환경을 제공해 플랫폼에 구애받지 않는 확장성과 클라이언트와 서버 간의 독립성을 제공하는 데이터 관리 서비스를 제공하여 이를 제공받는 프로젝트 팀의 서비스는 플랫폼과 서비스에 제한되지 않고 프로젝트의 완성도에 집중하도록 만들 수 있습니다.

![어바웃 송담](https://github.com/godokan/ccsYasu/assets/117326245/0506898e-f99a-473f-bbfa-a03eb6bb05de)

## 개발내용

- 웹호스팅 서비스로부터 서버 임차 (우분투 리눅스)
- 리눅스 터미널을 통해 데이터베이스 서버 및 호스팅 환경 구축
- 리눅스 계정 생성 및 관리
- 타 프로젝트 팀을 대상으로 서버 제공을 위한 웹 서비스 구축
- 원활한 서버 제공을 위한 개인 계정 생성 및 관리 시스템 구축
- 문의 사항과 공지 사항 등 원활한 소통을 위한 커뮤니티 게시판 서비스 구축
- 구축한 서버 및 호스팅 환경을 통해 API 서버, DB 서버, 리눅스 터미널 등을 서버 공급이 필요한 타 프로젝트 팀에게 제공

## 개발결과물

* 비 로그인 시 메인화면
![ccsyasu cafe24 com_home](https://github.com/godokan/ccsYasu/assets/117326245/8b653bc6-b706-423c-a046-c4cbc388580d)

* 로그인 시 메인화면
![ccsyasu cafe24 com_home2](https://github.com/godokan/ccsYasu/assets/117326245/29d6e358-6ec7-4fcf-be7a-938d53d30066)

* 회원가입 페이지
![ccsyasu cafe24 com_signup](https://github.com/godokan/ccsYasu/assets/117326245/58ed6711-511d-4a05-86d8-dcccfc602a90)

* 로그인 페이지
![ccsyasu cafe24 com_login](https://github.com/godokan/ccsYasu/assets/117326245/a0f31b72-f43c-43ab-aa86-4dbf1cf79d40)

* 공지사항 페이지
![ccsyasu cafe24 com_notice](https://github.com/godokan/ccsYasu/assets/117326245/8c2381a8-0c6d-4399-9c5e-e216a1cceba7)

* 자유게시판 페이지
![ccsyasu cafe24 com_freeboard](https://github.com/godokan/ccsYasu/assets/117326245/d8843406-11a9-4199-9bf3-b09317fe4108)

* 게시글 조회 페이지
![ccsyasu cafe24 com_freeboard_2](https://github.com/godokan/ccsYasu/assets/117326245/227a15de-24c6-4240-8002-e055241818c9)

* 사용  가능한  API 목록 (API 게시판) 페이지
![ccsyasu cafe24 com_apiboard](https://github.com/godokan/ccsYasu/assets/117326245/332ef5c2-db30-40b1-9e22-29a51f4e24c1)

* API 상세 정보 페이지
![ccsyasu cafe24 com_apiboard_TOILET_MAP](https://github.com/godokan/ccsYasu/assets/117326245/bfac7ce4-92cc-4276-bb22-4c23e6c3f5a1)

* 서비스 목록 페이지
![ccsyasu cafe24 com_releases](https://github.com/godokan/ccsYasu/assets/117326245/f4967d6d-4b6a-4b52-acff-9bff262ec8d7)

* 내 정보 페이지
![ccsyasu cafe24 com_profile](https://github.com/godokan/ccsYasu/assets/117326245/3b76d5a8-e5f9-4a5d-abca-90bd825f6e37)

* API 계정 발급 페이지
![ccsyasu cafe24 com_api_user_create](https://github.com/godokan/ccsYasu/assets/117326245/76f9a5ba-b654-4722-87ed-3711f2612766)

* 내 API 목록 (발급 받은 API 목록)
![ccsyasu cafe24 com_my_apis](https://github.com/godokan/ccsYasu/assets/117326245/e6102c73-33ac-4f55-acf2-ba7f5b99daf8)

## 기술스택에 관하여
* IntelliJ IDEA에서 개발하였습니다.
* 프론트엔드에는 HTML5, CSS3, JavaScript, JQuery, Bootstrap을 사용하였습니다. (반응형)
* 백엔드에는 SpringBoot 3.2.0, JAVA 17, Mustache, JPA, Lombok, mySQL을 사용하였습니다.
* cafe24 가상 서버 호스팅을 통해 Ubuntu Linux 20.04.6 LTS 환경에서 배포되었습니다.
