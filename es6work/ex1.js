//함수 파라미터에 기본값 가능
function func1(x,y=100,z=200){
    console.log(x,y,z);
}

func1(3,5,6);
func1(100);
func1(2,5);
func1();

function func2(a,b){
    return a+b;
}

console.log(func2(5,6));

let r1=func2(5,4);
console.log(r1);

let arr=[2,5,9];
let r2=func2(arr[0],arr[1]);

console.log(r2);

//es6에서는 펼침연산자 추가
func1(...arr); //2,5,9
func1(arr[0],arr[1],arr[2]);

let r3=func2(...arr); //앞의 2개 넘어감
console.log(r3);