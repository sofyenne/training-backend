<template>
  <div class="d-inline-flex ms-lg-4">
    <!-- Added for mobile -->
     <v-btn class="mx-2" fab dark small color="pink">
       <v-icon class="ma-2">mdi-like</v-icon>
      </v-btn>
  </div>
</template>
<script>
export default {
  name: 'ActivityLikeAction',
  data() {
    return {
      like: 0,
    };
  },
};
</script>

<style scoped>
</style>