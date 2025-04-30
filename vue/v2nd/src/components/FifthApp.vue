<template>
    <div style="margin-left: 100px;">
        <h2 class="alert alert-info">FifthApp입니다</h2>
        <table class="table table-bordered" style="width: 500px;">
  <tr>
    <th width="150">이름</th>
    <td width="350">
      <input type="text" v-model="name" class="form-control">
    </td>
  </tr>
  <tr>
    <th>자바점수</th>
    <td>
      <input type="text" v-model.number="java" class="form-control">
    </td>
  </tr>
  <tr>
    <th>Vue점수</th>
    <td>
      <input type="text" v-model.number="vue" class="form-control">
    </td>
  </tr>
  <tr>
    <th>Oracle점수</th>
    <td>
      <input type="text" v-model.number="oracle" class="form-control">
    </td>
  </tr>
  <!-- ✅ 수정된 부분 -->
  <tr>
    <td colspan="2" align="center">
      <button class="btn btn-success" style="width: 200px;" @click="btnResult">결과확인</button>
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
import { ref } from 'vue';

export default {
    setup () {
        
        const name=ref('');
        const java=ref(0);
        const vue=ref(0);
        const oracle=ref(0);
        const result=ref('');

        const btnResult=()=>{

            const tot=java.value+vue.value+oracle.value
            const avg=(tot/3).toFixed(2);

            result.value=`[결과확인]
            이름: ${name.value}
            자바점수: ${java.value}
            vue점수: ${vue.value}
            오라클점수: ${oracle.value}
            
            총점: ${tot}
            평균: ${avg}`
        }


        return {name,java,vue,oracle,result,btnResult}
    }
}
</script>

<style lang="scss" scoped>

</style>