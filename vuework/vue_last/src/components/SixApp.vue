<template>
    <div style="margin-left: 50px;">
        <h2 class="alert alert-info">SixApp입니다_버튼없이 바로 결과반영</h2>
        <table class="table table-bordered" style="width: 500px;">
            <tr>
                <th width="150">이름</th>
                <td width="350">
                    <input type="text" v-model="name" class="form-control" >
                </td>
            </tr>
            <tr>
                <th width="150">자바점수</th>
                <td width="350">
                    <input type="text" v-model.number="java" class="form-control" >
                </td>
            </tr>
            <tr>
                <th width="150">Vue점수</th>
                <td width="350">
                    <input type="text" v-model.number="vue" class="form-control" >
                </td>
            </tr>
            <tr>
                <th width="150">Oracle점수</th>
                <td width="350">
                    <input type="text" v-model.number="oracle" class="form-control" >
                </td>
            </tr>
            
        </table>

        <div style="width: 500px;">
            <h4 class="alert alert-success"
            style="white-space: pre-wrap;">{{ result }}</h4>
        </div>
    </div>
</template>

<script>
import { computed, ref } from 'vue';

export default {
    setup () {
        
        const name=ref('');
        const java=ref(0);
        const vue=ref(0);
        const oracle=ref(0);

        const result=computed(()=>{

            const tot=java.value+vue.value+oracle.value
            const avg=(tot/3).toFixed(2)

            return `[결과확인]
            이름: ${name.value}
            자바: ${java.value}
            vue: ${vue.value}
            oracle:${oracle.value}
            
            총점: ${tot}
            평균: ${avg}`
        });


        return {name,java,vue,oracle,result}
    }
}
</script>

<style lang="scss" scoped>

</style>