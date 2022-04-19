<template>
  <v-container>
    <v-row>
      <v-col>
        <v-text-field v-model="search" label="Search by first name , lastname , email " style="text-align: center ;margin-right: 20%;width: 350px;" ></v-text-field>
      </v-col>
      <v-col>
        <v-btn color="green" style="margin-top: 20px; left: 87%" @click="opendrwer()">Add new</v-btn>
      </v-col>
    </v-row>
    <v-data-table
      :headers="headers"
      :items="items"
      :items-per-page="5"
      :search="search"
      class="elevation-1"
      hide:action
    >
      <template v-slot:item="row" v-slot:activator="{ on, attrs }">
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
            <v-btn v-bind="attrs" class="mx-2" fab dark small color="green"
                   v-on="on" @click="detail(row.item)">
              <v-icon dark>mdi-book</v-icon>
            </v-btn>
           
            
          </td>
        </tr>
    </template></v-data-table>
    <drawer ref="drow" :is-opened="isOpened" :user="user" @data="insertUser"></drawer>
    <userDetails ref="dialog" :userdetails="userdetails"></userDetails>
  </v-container>
</template>
<script>
import Userservice from './service/userService';
import drawer from './drawer.vue';
import userDetails from  './details.vue';
import ActivityActions from '../components/activity/ActivityActions.vue';
export default {
  name:'UserList',
  components:{
    ActivityActions,
    drawer,
    userDetails
  },
  data(){
    return {
      search :'',
      items :[],
      user : {},
      userdetails :{},
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
    detail(item){
      this.$refs.dialog.open();
      this.userdetails = Object.assign({},item);
    },
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