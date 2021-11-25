# 협업관리 프로그램 Haru
### 팀명 : 하루코딩
### 프로젝트 명 : HARU
### 조원 : 이종윤(팀장), 이승현, 조진석, 김행운
### 오늘할 코딩을 내일로 미루지 말라
### 그라운드 룰 : 1. 성실
###            2. slack에 오늘 한 일, 다음 할 일 공유
###            3. 하루 한 번 Branch생성 and Merge
###            4. 주석 습관화

***

- Commit Rules
  - 형식

      ```
      #name [commit-type]: (scope) message
      ```
  - commit type
      - FEAT : 새로운 기능의 추가
      - FIX: 버그 수정
      - DOCS: 문서 수정
      - STYLE: 스타일 관련 기능(코드 포맷팅, 세미콜론 누락, 코드 자체의 변경이 없는 경우)
      - REFACTOR: 코드 리펙토링
      - TEST: 테스트 코트, 리펙토링 테스트 코드 추가
      - CHORE: 빌드 업무 수정, 패키지 매니저 수정(ex .gitignore 수정 같은 경우)
      - ADD: 추가이긴 한데 새로운 기능 추가가 아닌 경우(애매한 추가인경우)
      - DELETE: 없앤 경우
      - MODIFY : 수정했을때
      - SET: config 수정등
  - scope
      - 기능 중심
  - message (본문)
      - 변경내용 요약
      - 최대한 자세히
  - 예시

      ```
      feat(board): search api 추가
      add(board): search api 예외사항 코드 작성
      chore: server IP 변경
      style(main): 코드 포맷R팅
      docs: server readme 수정 

      #Dr.[FEAT]: (chat)first commit 
      #Cap.[FIX]: (chat)스크롤 기능 수정
      #Hul. [DOCS] : README.md
      #Tho. [STYLE] : thunder!
      ```

