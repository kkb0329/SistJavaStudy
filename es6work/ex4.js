let a=6;
let b="6";

console.log(a==b);//true..값으로만 비교
console.log(a===b);//false ..타입까지 같아야 true
console.log(Object.is(a,b)); //===쓰는거랑 동일

console.log(`a의 타입은 ${typeof(a)}입니다`);
console.log(`a의 타입은 ${typeof(b)}입니다`);
