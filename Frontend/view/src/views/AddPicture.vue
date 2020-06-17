<template>
    <div>
        <input type="file" @change="onFileSelected" >
        <input type="button" v-on:click="uploadPicture">
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'AddPicture',
    data(){
        return{
            selected: null,
        }
    },
    methods: {
        onFileSelected(event){
            this.selected = event.target.files[0];
        },
        uploadPicture(){
            const data = new FormData();
            data.append('file', this.selected, this.selected.name);
            axios.post('localhost/post/' + this.$route.params.id + '/picture', data).then().catch(err => console.log(err));
        }
    }
}
</script>