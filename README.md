# 프로젝트 소개
안녕하세요 위매치 백엔드 포지션 지원자 배진섭입니다. 해당 프로젝트에 대해 간단하게 소개를 드리면
  * 스프링부트 2.4 (spring)
  * 자바 버전 11 [8이상 무관]
  * lombok (코드 자동완성)
  * mysql 8 version (db)
  * mapstruct (entity -> dto)
  * junit5 (test)
  * spring data jpa (orm)
  * gradle (build tool)
  
등을 사용하여 개발을 진행하였습니다. 부족하지만 잘 부탁드립니다.
  
# 사무실에 몇명이나 있을까
두 과제를 한 프로젝트에서 진행하였으며, 사무실과제와 관련된 소스는 dto - Commute / service - OfficePersonnelCheck / test - OfficePersonnelCheckTest 파일로 구성되어 있습니다.

# 데이터 모델링 퀴즈

## 셋팅 및 테스트 And Run 방법
기본적으로 자바8 버전이상 gradle, mysql이 설치 되어 있어야 build가 가능합니다.
springboot는 기본적으로 h2 임베드 디비를 사용하지만 mysql 또는 postgresql사용 제약사항이 있어 run 및 test 시 모두 mysql 서버를 바라보고 있습니다.
mysql 접속설정은 resources 디렉토리 밑에 application.properties 파일에 정의 되어 있습니다.
springboot는 디폴트 설정으로 tomcat 임베드를 내장하고 있어 웹서버 설정 따로없이 실행을 해볼 수 있습니다.
gradle를 통해 해당 프로젝트 root 디렉토리에서 gradle build를 실행하게 되면 test 및 complie를 하며 build 디렉토리가 생성이 되고 /build/libs 경로에 해당 프로젝트 jar 파일이
생성이 됩니다. 이제 java를 통해 java -jar [jar파일명.jar] 명령어를 실행하게 되면 서버가 정상적으로 동작하게 됩니다.

## 패키지 구조
패키지 구조는 계층형으로 이루어져 있으며 해당 패키지들 역할은 이렇습니다.
  * controller - client 요청 매핑
  * dto - 데이터 전송
  * entity - orm 관련 도메인
  * enums - enum
  * mapper - mapstruct를 사용한 entity -> dto 데이터 전송
  * repositories - spring data jpa를 사용한 orm 기반 영속성 데이터 접근
  * runner - run 시 실행되는 code
  * service - 비즈니스 로직
  * util - 공통
    
## test code
  * 고객정보 / 이사 신청 / 이사 업체 관련 테스트는 통합테스트로 진행하였습니다.
  * 고객 피드백 이력은 JpaDataTest를 통해 create update 데이터를 test 하였습니다.

간단하게 프로젝트 구조 및 빌드에 대해 설명 드렸는데 혹시 설명이 부족했던 부분이나 잘못 된 부분이 있으면 회신 주시면 빠르게 피드백 드리도록 하겠습니다 감사합니다.
  
