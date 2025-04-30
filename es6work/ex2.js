let arr1=[2,4,5];
let arr2=[6,7];
let arr3=[11,12,...arr1,22,...arr2];

console.log(arr3.length);
console.dir(arr3);  //구조까지 확인

let arr4=[...[100,200],...arr2];
console.log(arr4);

function fsum(arr){

    let sum=0;

    // for(i=0;i<arr.length;i++){
    //     sum+=arr[i];
    // }

    for(let a in arr){ //a가 인덱스
        sum+=arr[a];
    }

    console.log("합계: "+sum);
}

fsum(arr3);

function func3(a,b,c,d,e){
    console.log(a,b,c,d,e);
}

//호출해보는데 인자를 arr3보내기
//11,12,2,4,5가 나오게...
func3(arr3);
func3(...arr3);