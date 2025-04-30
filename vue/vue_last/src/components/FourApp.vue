<template>
    <div style="margin-left: 100px;">
        <h2 class="alert alert-info">FourthApp입니다_배열로 테이블 객체출력</h2>
        <table class="table table-bordered" style="width: 800px;">
            <caption align="top"><b>배열객체출력</b></caption>
            <thead class="table-success">
                <tr >
                    <th width="100">번호</th>
                    <th width="150">사진</th>
                    <th width="400">제목</th>
                    <th width="150">작성자</th>

                </tr>
        </thead>

        <tbody>
            <tr v-for="(row,index) in boards" :key="'row'+index">
                <td>{{ row.no }}</td>
                <td><img :src="`/image/연예인사진/${row.photo}.jpg`" style="width: 40px; height: 50px;"></td>
                <td>{{ row.subject }}</td>
                <td>{{ row.writer }}</td>
            </tr>
        </tbody>
        </table>
    </div>
</template>

<script>
import { reactive } from 'vue';

export default {
    setup () {
        
        const boards=reactive(
            [{no:1,writer:'홍길동',subject:'오늘 여름날씨다',photo:'1'},
            {no:2,writer:'김길동',subject:'vue 2일차',photo:'3'},
            {no:3,writer:'이길동',subject:'vue 테이블',photo:'2'},
            {no:4,writer:'유민상',subject:'vue 이미지',photo:'4'},
            {no:5,writer:'김민상',subject:'내일은 jsp',photo:'5'},
            {no:6,writer:'홍민상',subject:'다시 이클립스에요',photo:'6'}
            ]
        );

        return {boards}
    }
}
</script>

<style>

</style>