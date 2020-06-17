<template>
    <div>
        <h2> Journeys of {{ blogger.name }}</h2>
        <div v-for="journey in journeys" :key="journey.id">
            <router-link :to="{ path: '/Journey/'+ journey.id}">{{ journey.title }}</router-link>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Blogger',
    data(){
        return{
            blogger: [],
            journeys: []
        }
    },
    created(){
        axios.get('localhost/blogger/' + this.$route.params.id).then(res => this.blogger = res.data).catch(err => console.log(err));
        axios.get('/localhost/blogger/' + this.$route.params.id + '/journeys/').then(res => this.journeys = res.data).catch(err => console.log(err));
    }
}
</script>