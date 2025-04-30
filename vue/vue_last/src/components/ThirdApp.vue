<template>
    <div >
        <h2 class="alert alert-info">ThirdApp입니다</h2>
        <h2>Nav데이터</h2><br>
        <!-- <div v-for="(item,idx) in todayHomeData.navData" 
        :key="'nav'+idx">
           {{ item.title }}
        </div>-->

        <div v-for="(item,idx) in todayHomeData.navData" 
        :key="'nav'+idx" class="home">
            <img :src="item.img">
            <p>{{ item.title }}</p>
        </div>

        <h2>카테고리 데이터</h2><br>
        <!-- <div v-for="(item,idx) in todayHomeData.categoryData" 
        :key="'cate'+idx">
           {{ item.title }}
        </div> -->
        <div v-for="(item,idx) in todayHomeData.navData" 
        :key="'nav'+idx" class="home">
            <img :src="item.img" >
            <p>{{ item.title }}</p>
        </div>



    </div>
</template>

<script>
import todayHomeData from '@/assets/todayHome.js';

export default {
    setup () {
        
        console.log(todayHomeData)

        return {todayHomeData}
    }
}
</script>

<style>
 .home{
    float: left;
   
 }

 img{
    width: 80px;
    height: 80px;
 }
 h2{clear: both;}
 
</style>