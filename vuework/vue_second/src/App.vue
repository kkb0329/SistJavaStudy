<template>
<div>
  <img alt="Vue logo" src="./assets/logo.png">
  
  <div class="menu">
    <a  v-for="menu in menus" :key="menu">{{menu}}</a>
  </div>
  
  <div v-for="(product,key) in products" :key="key">
     <img class="celeb_img" :src="product.imgSrc" >
    <h6>{{product.name}}</h6>
    <h6>{{product.company}}</h6>
    <button type="button" class="btn btn-warning btn-sm"
    @click="onLikes(key)">좋아요</button><span>좋아요 수: {{product.likes}}</span>
   
  </div>
  

  
</div>
</template>

<script>


export default {
  name: 'App',
  data(){
      return{

        // couter:1,
        menus:['Home','Shop','Board','About'],
        products:[
          {name:'김태희',company:'하이브',
        likes:0,imgSrc:require('./assets/연예인사진/10.jpg')},
        {name:'유아인',company:'JYP',
        likes:0,imgSrc:require('./assets/연예인사진/20.jpg')},
        {name:'수지',company:'하이브',
        likes:0,imgSrc:require('./assets/연예인사진/19.jpg')},
        {name:'강동원',company:'SM',
        likes:0,imgSrc:require('./assets/연예인사진/9.jpg')}
        ]
       
      }
  },
  methods:{
      // numIncre(){
      //   this.couter++;
      // },
      // numDecre(){
      //   this.couter--;
      // }

      onLikes(num){
        this.products[num].likes=this.products[num].likes+1;
      }
  },
  components: {
    
  }
}
</script>

<style lang="css" scoped>

 .celeb_img{
    width: 200px;
    margin-top: 20px;
    border-radius: 20px;
} 

 #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
 
} 

.menu{
  background-color: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

 .menu a{
  color:white;
  padding: 10px;
}


</style>
