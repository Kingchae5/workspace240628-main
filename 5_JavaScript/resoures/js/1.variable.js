console.log("Hellow world");

/**
 * js의 변수 선언
 * 
 * 1)var - 사용하지 않음
 * 2)let
 * 3)const
 */



var name = "최지원";
var age = 55;
var height = 190.7;
var isTrue= true;

var name = "김수민";
console.log(name+" "+age+""+height+" "+isTrue)




/*
* let은 var에서 같은이름의 중복생성을 하지 못하게 만든 자료형이다.
*다만 let과 var는 모두 값을 변경하는 것은 가능하다.
*/

let name = "최지원";

let name = "김수민";

/***
 * const는 상수를 표현하기위한 자료형
 * 값을 변경할 수 없음
 */

const name2 = "최지원";

name2 = "김지원";

/***
 * js네이밍 규칙
 * 
 * 변수이름 지을때
 * 1) 일반적으로 영어를 사용하며문자와 숫자 모두 사용할 수 있음
 * 2) 특수문자는 언더스코어와 달러를 사용할 수 있음
 * 3) 숫자로 시작하면 안됨
 * 4) 키워드를 변수명으로 사용하면 안됨
 * 
 * 네이밍 타입
 * 1) camelCase -> 대부분의 언어에서 많이 사용하며 단어의 시작마다 대문자로 구분해준다.
 * 2) snake_case -> 파이썬에서 주로 사용하며 단어의 시작마다 _로 구분해준다.
 * 3) pascalCase -> c# 및 ms계열의 언어에서 많이 사용하며 매 단어 시작은 무조건 대문자로한다.
 */

let $name = "김민수"
let _name = "최민수"




/***
 * Data Types
 * 
 * 여섯개의 원시타입과 한개의 Object타입이 있다.
 * 
 * 1) Number
 * 2) String
 * 3) Boolean
 * 4) undefined <- 개발자가 정의하지 않는 비어있는 값.
 * 5) null <- 개발자가 null 이라고 (값이 비어있다고) 정의
 * 6) symbol
 *    - Function
 *    - Array
 *    - Object
 * ...
 * 
 */


//Number 타입
const age = 55;
const tampature = -10
const pi = 3.14

//console.log(age, tampature, pi)
console.log(typeof age2)
console.log(typeof tampature)
console.log(typeof pi)


// String타입
const name4 = "최지원 66살"
const num1 = 55
console.log(num1 == "55")
console.log(num1 === "55")

console.log("안녕하세요 저는 최지원입니다. \n \t 나이는 51살입니다.")

/***
 * undefined
 * 
 * 개발자가 직접 값을 초기화하지 않았을때
 * 지정되는 값이다.
 * 
 * 
 * undefined를 직접 넣어주는 것은 지양해야한다.
 */

let num2;
console.log(num2 === undefined);

/***
 * null 타입
 * undefined와 동일하게 값이 없음을 표시
 * 다만 js는 개발자가 직접 명시적으로 없는 값을 초기화할 때 사용
 */


let init = null;
console.log(nill);

if(!init){
    console.log("null이 아니다.")
}

/***
 * Symbol타입
 * 
 * 유일무이한 값을 생성할 때
 * 다른 원시값들과 다르게 Symbol함수를 호출해서 사용
 * 
 */

const tmp1 = '1';
const tmp2 = '1';
console.log(tmp1 === tmp2)

const symbol1 = Symbol('1');
const symbol2 = Symbol('1');
console.log(symbol1, symbol2)
console.log(symbol1 === symbol2)


/**
 * Object타입
 * 
 * 키 : 밸류 쌍으로 이루어져 있다.
 * Key : value
 */

const man = {
    name : "최지원",
    age : 47,
    address : "경기도"
}

console.log(typeof man);


/***
 * Array타입
 * 
 * 값을 리스트로 나열할 수 있는타입
 */

const arr = [];
arr.push("빨간색");
arr.push("주황색");
arr.push("파란색");
console.log(arr.pop());
console.log(arr[0].arr[1])





