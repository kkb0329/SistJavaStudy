<template>
    <div>
     <h2 class="alert alert-info">FirstApp입니다</h2>
     <h3>버튼으로 숫자 증감하기</h3>
     <h3>{{ counter }}</h3>
     <h4>{{ message }}</h4>

     <button class="btn btn-success" @click="counterIncre">증가</button>
     <button class="btn btn-danger" @click="counterDecre">감소</button>
    </div>
</template>

<script>
import { ref } from 'vue';

export default {
    setup () {

        const counter=ref(0);
        const message=ref('Composition Api 구조 공부중입니다');

        const counterIncre=()=>{
            counter.value++;
        }

        const counterDecre=()=>{
            counter.value--;
        }
        

        return {counter,message,counterIncre,counterDecre}
    }
}
</script>

<style lang="scss" scoped>

</style>