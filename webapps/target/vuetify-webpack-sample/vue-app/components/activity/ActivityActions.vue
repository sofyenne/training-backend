<template>
  <extension-registry-components
      :params="params"
      :class="actionclass"
      class="d-flex flex-no-wrap ms-lg-auto py-2 activity-footer-actions"
      name="Activitytable"
      type="activity-table-action"
      parent-element="div"
      element="div"
      element-class="mx-auto ma-lg-0 activity-footer-action" />
</template>

<script>
export default {
  name: 'ActivityActions',
  props: {
    activity: {
      type: Object,
      default: null,
    },
    activityTypeExtension: {
      type: Object,
      default: null,
    },
  },
  computed: {
    params() {
      return {
        activity: this.activity,
        activityTypeExtension: this.activityTypeExtension,
      };
    },
  }
};
</script>

<style scoped>

</style>