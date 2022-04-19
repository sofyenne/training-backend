<template>
  <div class="d-inline-flex ms-lg-4">
    <!-- Added for mobile -->
    <v-tooltip bottom>
      <template>
        <v-btn
          class="pa-0 mt-0"
        >
          <div class="d-flex flex-lg-row flex-column">
            <v-icon class="baseline-vertical-align" size="14">
              fa-thumbs-up
            </v-icon>
            <span class="mx-auto mt-1 mt-lg-0 ms-lg-2"> </span>
          </div>
        </v-btn>
      </template>
      <span> Like </span>
    </v-tooltip>
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