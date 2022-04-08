<template>
  <v-container>
    <v-btn color="green" style="margin-bottom:20px;margin-left:94%;" @click="opendrwer()" >Add new</v-btn>
    <v-data-table
      :headers="headers"
      :items="items"
      :items-per-page="5"
      class="elevation-1"
      hide:action
    >
      <template v-slot:item="row">
        <tr>
          <td>{{ row.item.id }}</td>
          <td>{{ row.item.firstname }}</td>
          <td>{{ row.item.lastname }}</td>
          <td>{{ row.item.email }}</td>          
          <td>
            <v-btn class="mx-2" fab dark small color="blue" @click="onButtonClick(row.item)">
              <v-icon dark>mdi-update</v-icon>
            </v-btn>
            <v-btn class="mx-2" fab dark small color="pink" @click="delet(row.item)">
              <v-icon dark>mdi-delete</v-icon>
            </v-btn>
          </td>
        </tr>
    </template></v-data-table> 
    <drawer ref="drow" :is-opened="isOpened" :user="user" @data="insertUser"></drawer>
  </v-container>
</template>
<script>
import Userservice from './service/userService';
import drawer from './drawer.vue';
export default {
  name:'UserList',
  components:{
    drawer   
  },
  data(){
    return {
      items :[],
      user : {},
      headers :[
        {text :'id' ,value :'id'},
        {text :'first' ,value :'firstname'},
        {text :'last' ,value :'lastname'},
        {text :'email' ,value :'email'},
        {text :'action'},
      ],
      isOpened:false
    };
  },
  
  mounted(){
    this.getalluser();
  },
  methods :{
    insertUser(user){
      this.items = this.items.filter(e=>e.id !== user.id);
      this.items.push(user);
    },
    delet(item){
      const restService = new Userservice();
      restService.delete(item)
        .then(()=>{
          const index = this.items.indexOf(item);
          this.items.splice(index,1);})
        .catch(e => {throw new Error(e);});
    },
    onButtonClick(item) {
      this.user = new Object();
      this.user=Object.assign({},item);
      this.$refs.drow.open();
    },
    opendrwer(){
      this.$refs.drow.open();
    },
    getalluser(){
      const restService = new Userservice();
      restService.getallusers()
        .then(res => {this.items = res.data;})
        .catch(e => {throw new Error(e);});
    }
  },
};
</script>