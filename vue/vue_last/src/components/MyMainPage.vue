<template>
    <div>
       <label>
         <input type="radio" value="first" v-model="selected">first App&nbsp;&nbsp;
       </label>
       <label>
         <input type="radio" value="second" v-model="selected">second App&nbsp;&nbsp;
       </label>
       <label>
         <input type="radio" value="third" v-model="selected">third App&nbsp;&nbsp;
       </label>
       <label>
         <input type="radio" value="fourth" v-model="selected">fourth App&nbsp;&nbsp;
       </label>
       <label>
         <input type="radio" value="fifth" v-model="selected">fifth App&nbsp;&nbsp;
       </label>
       <label>
         <input type="radio" value="six" v-model="selected">six App&nbsp;&nbsp;
       </label>
       <label>
         <input type="radio" value="parent" v-model="selected">부모 &nbsp;&nbsp;
       </label>
    </div>

   <!-- 선택된 컴포넌트로 랜더링 -->
    <component :is="currentComponent"></component>

</template>

<script>

import {computed, ref} from 'vue';

import FirstAppPage from './FirstApp.vue';
import SecondAppPage from './SecondApp.vue';
import ThirdAppPage from './ThirdApp.vue';
import FourthAppPage from './FourApp.vue';
 import FifthAppPage from './FifthApp.vue';
 import SixAppPage from './SixApp.vue';
 import ParentApp from './ParentApp.vue';


export default {
    setup () {

        const selected=ref('first');
       
        const currentComponent=computed(()=>

            selected.value=='first'?FirstAppPage:
            selected.value=='second'?SecondAppPage:
            selected.value=='third'?ThirdAppPage:
            selected.value=='fourth'?FourthAppPage:
            selected.value=='fifth'?FifthAppPage:
            selected.value=='six'?SixAppPage:ParentApp
        )
        

        return {selected,currentComponent}
    }
}
</script>

<style>

</style>