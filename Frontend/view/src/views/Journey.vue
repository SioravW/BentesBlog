<template>
    <div>
        <h2> Posts in journey: {{ journey.title }}</h2>
        <div v-for="post in posts" :key="post.id">
            <router-link :to="{ path: '/post/'+ post.id}">{{ post.title }}</router-link>
            <p> {{ post.text }} </p>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Journey',
    data() {
        return{
            journey: [],
            posts: [],
        }
    },
    created() {
        axios.get('localhost/journey/' + this.$route.params.id).then(res => this.journey = res.data).catch(err => console.log(err));
        axios.get('localhost/journey/' + this.$route.params.id + '/posts').then(res => this.posts = res.data).catch(err => console.log(err));
    }
}
</script>