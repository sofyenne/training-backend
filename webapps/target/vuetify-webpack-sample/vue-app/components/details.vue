<template>
  <v-row justify="space-around" >
    <v-col cols="auto" >
      <v-dialog
        v-model="dialog"
        transition="dialog-top-transition"
        width="600">
        <template v-slot:default="dialog" >
          <v-card >
            <v-toolbar
              color="primary"
              dark
            >User Details</v-toolbar>
            <v-card-text>
              <ul>
                <li>first name {{ userdetails.firstname }}</li>
                <li>last name:{{ userdetails.lastname }}</li>
                <li>email:{{ userdetails.email }}</li>
              </ul>
            </v-card-text>
            <v-card-actions class="justify-end"
            >
              <v-btn
                text
                @click="dialog.value = false"
              >Close</v-btn>
            </v-card-actions>
          </v-card>
        </template>
      </v-dialog>
    </v-col>
  </v-row>
</template>
<script>
export default {
  name:'UserDetail',
  props:{
    userdetails:{
      type:Object,
      default:function(){
        return {};
      }}

  },
  data(){
    return {
      dialog:false
    };
  },
  methods :{
    open(){
      this.dialog = true;
    }
  },
};
</script>