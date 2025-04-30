<template>
    
   <MyMainPage></MyMainPage>
</template>

<script>
import MyMainPage from './components/MyMainPage';

export default {
  name: 'App',
  components: {
     MyMainPage
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
  margin-top: 60px;
}
</style>
