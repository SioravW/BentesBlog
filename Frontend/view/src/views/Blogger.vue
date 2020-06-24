<template>
    <div>
        <h2 class="h2"> Journeys of {{ blogger.name }}</h2>
        <div v-for="journey in journeys" :key="journey.id">
            <h4><router-link :to="{ path: '/Journey/'+ journey.id}">{{ journey.title }}</router-link></h4>
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
            journeys: [],
            id: this.$route.params.id,
        }
    },
    created(){
        axios.get('localhost/blogger/' + this.id).then(res => this.blogger = res.data).catch(err => console.log(err));
        axios.get('/localhost/blogger/' + this.id + '/journeys/').then(res => this.journeys = res.data).catch(err => console.log(err));
    }
}
</script>