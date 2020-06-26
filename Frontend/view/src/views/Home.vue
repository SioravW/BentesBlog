<template>
  <div id="bloggerslist">
    <h2>Bloggers:</h2>
    <div v-for="blogger in bloggers" :key="blogger.id">
      <h4><router-link :to="{ path: '/Blogger/'+ blogger.id}" class="bloggerName">{{ blogger.name }}</router-link></h4>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Home',
  data() {
    return {
      bloggers: [],
    }
  },
  created(){
    axios.get('/localhost/blogger').then(res => this.bloggers = res.data).catch(err => console.log(err));
  },
  methods:{
    setBloggerId(blogger){
      this.bloggerId = blogger.id;
    }
  }
}
</script>

<style scoped>

</style>