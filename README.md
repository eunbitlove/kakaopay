# kakaopay

## 1. 프로젝트 소개
  - URL을 입력받아 짧게 줄여주고, 줄여진 URL을 입력하면 원래 URL로 연결하는 웹화면 구현
  
## 2. 요구사항
  - webapp 으로 개발하고 URL 입력폼 제공 및 결과 출력
  - URL Shortening Key 는 8 Character 이내로 생성되어야 합니다.
  - 동일한 URL 에 대한 요청은 동일한 Shortening Key 로 응답해야 합니다.
  - Shortening 된 URL 을 요청받으면 원래 URL 로 리다이렉트 합니다.
  - Shortening Key 생성 알고리즘은 직접 구현해야 합니다. (라이브러리 사용 불가)
  - Unit Test 코드 작성
  - Database 사용은 필수 아님 (선택)
  
## 3. 개발환경
  - apache, tomcat, java 1.8, spring 4.3.x, mybatis, maven, Mysql 8.0, Eclipse
  
## 4. 개발방향
  - Java와 Spring framework를 사용한다.  
  - DB를 사용한다.   
  - Shortening URL은 Base62로 Encode 한다.  
  - 로직적인 분기문은 최대한 화면단에 구현한다.
  
## 5. 테이블 속성
  - u_no : int(20), 유니크한 값  
  - s_url : varchar(20), u_no의 값을 base62로 인코딩하고 http://localhost:8080/ 뒤에 붙여 저장  
  - f_url : varchar(2083), 원래 URL 저장 용
  
## 6. 문제해결
  - u_no, s_url, f_url을 한번에 모두 인서트 할 수 없다.<br>처리방법 : u_no, f_url을 먼저 인서트 후에 u_no값을 가져와서 치환 후 s_url에 업데이트
  - 인서트 된 u_no를 어떻게 가져올 것인가?    처리방법 : 별도의 select 로직을 구현하지 않고 mybatis의 keyProperty 옵션 사용