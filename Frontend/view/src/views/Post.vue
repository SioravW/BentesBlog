<template>
    <div>
        <h2>{{ post.title }}</h2><br>
        <p>{{ post.text }}</p>
        <div class="row">
            <div v-for="picture in pictures" :key="picture.id" class="col-lg-4 col-md-12 mb-4">
                <img :src="picture" :alt="picture.fileName" class="img-fluid mb-4">
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Post',
    data() {
        return{
            post: [],
            pictures: [],
        }
    },
    created() {
        axios.get('localhost/post/' + this.$route.params.id).then(res => this.post = res.data).catch(err => console.log(err));
        axios.get('localhost/post/' + this.$route.params.id + '/pictures').then(res => this.pictures = res.data).catch(err => console.log(err));

    }
}
</script>