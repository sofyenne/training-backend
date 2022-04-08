<template>
  <exo-drawer
    id="activityKudosDrawer"
    ref="addDrawer"
    width="600px"
    hide-actions
    right
    disable-pull-to-refresh>
    <template slot="title">
      <span class="text-header-title">Add new user</span>
    </template>
    <template slot="content">
      <container>
        <v-form ref="form"
                v-model="valid"
                style="margin-left:20px;margin-right:20px;"
                lazy-validation
        > 
          <v-text-field
            v-model="user.firstname"
            :counter="10"
    
            label="first"
            required
          ></v-text-field>
          <v-text-field
            v-model="user.lastname"
            :counter="10"
      
            label="lastname"
            required
          ></v-text-field>
          <v-text-field
            v-model="user.email"
            :counter="10"
     
            label="email"
            required
          ></v-text-field>
          <v-text-field
            v-model="user.age"
            :counter="10"
     
            label="age"
            required
          ></v-text-field>
          <v-text-field
            v-model="user.password"
            :counter="10"
            mb-3
            label="password"
            required
          ></v-text-field>
          <v-btn clolor="blue" @click="saveuser()">save</v-btn>
        </v-form>
      </container>
    </template>
    <template slot="footer">
      <span>footer exo-drawer</span>
    </template>
  </exo-drawer>
</template>
<script>
import UserService from './service/userService';
export default {
  emit :['data'],
  name : 'Drawer',
  props:{
    user:{
      type:Object,
      default:function(){
        return {};
      }}
   
  },
  methods: {
    saveuser(){
      const restserv = new UserService();
      restserv.adduser(this.user)
        .then((res)=>{
          this.$refs.addDrawer.drawer=false;
          this.$emit('data',res.data);})
        .catch(e=>{throw new Error(e);});
    },
    open(){
      this.user = new Object();
      this.$refs.addDrawer.drawer=true;
    },
  },


};
</script>