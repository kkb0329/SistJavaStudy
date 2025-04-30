<template>
    <div>
        <h2>자식 컴포넌트</h2>

        <input type="text" :value="modelValue" @input="updateValue"/>

        <button @click="sendToParent">부모한테 이벤트 보내기</button>
    </div>
</template>

<script setup>
/* eslint-disable */

//props정의
    const props=defineProps({
        modelValue:String
    });
//emit 정의
const emit=defineEmits(['update:modelValue','send']);

const updateValue=(e)=>{
    emit('update:modelValue',e.target.value);
}

//버튼 클릭시 부모한테 이벤트 전송
const sendToParent=()=>{
    emit('send','자식에서 부모로 보내는 메세지');
}
</script>

<style lang="scss" scoped>

</style>