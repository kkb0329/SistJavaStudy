<template>
    <div>
        <h2>부모컴포넌트</h2>
        <p>자식이 입력한 메세지: {{ message }}</p>

   <!-- v-model과 @send 이벤트 연동 -->
        <ChildApp v-model="message" @send="sendHandle"/>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import ChildApp from './ChildApp.vue';

    const message=ref('안녕 ~~~');

    const sendHandle=(msg)=>{
        alert(`자식이 보낸메시지: ${msg}`);
    }
</script>

<style lang="scss" scoped>

</style>