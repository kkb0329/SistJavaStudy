<template>
  
  <div>
    <img alt="Vue logo" src="./assets/logo.png">

    <h2>{{message}}</h2>
    <h2 v-html="message2"></h2><!--선언적랜더링으로는 스타일변경못함-->

     <h2 v-bind:class="{active:isActive}">클래스 바인딩테스트</h2>
     <h2 :class="{active:isActive}">클래스 바인딩테스트</h2>

     <!-- style binding -->
     <h3 :style="{color:fontColor,fontSize:fontSize+'px'}">스타일바인딩테스트</h3>
    <button type="button" @click="change">버튼</button>

  </div>
</template>

<script>



export default {
  name: 'App',
  data(){
      return{

        message:"Hello Vue.js!!",
        message2:'<span style="color:red">메세지</span>',
        isActive:false,
        fontColor:'#ff00ff',
        fontSize:40,
      }
  },
  methods:{
      
      change(){
        this.isActive=!this.isActive
      }
  },
  components: {
    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  
}

h2.active{
  color: blue;
}
</style>
