# java-lotto-kakao

## 기능 요구사항

### Input
[x] 구입금액 입력 <br>
[x] 지난주 당청 번호 입력 <br>
[x] 지난주 보너스 번호 입력 <br>

### Output
[x] 로또 리스트 출력
 - [x] 로또 출력 <br>

[x] 당첨 통계 출력 <br>
[x] 수익률 출력 


### Domain
[x] 구입가격으로 로또 몇개 살지 계산 <br>
[x] 구입 수 만큼 로또 리스트 생성 <br>
 - [x] 로또 번호 생성 <br>
   - [x] 1~45 6개 숫자 생성 <br>

[x] 당첨 계산 <br>
 - [x] 6개 일치
 - [x] 5개 일치, 보너스볼 일치
 - [x] 5개 일치
 - [x] 4개 일치
 - [x] 3개 일치

[x] 수익률 계산 <br>


lotto
 - list numbers; - 6개 1 ~ 45
 - 생성자 ()
   - radom()
 - 생성자 (list numbers)
   - list numbers () return
    - w1(당첨번호, 보너스볼) 교집합
      - 5개일 경우 보너스 체크
       return int 1,2,3
 - 
lottos
 - list lotto
 - w2(당첨번호, 보너스볼){
   - for each
   - w1(lotto)
   - return list

winner
 - ranking count(w2)
   - 
 - w3 수익률 계산(ranking count, 구입금액)
   - 수익률 계산 double return
