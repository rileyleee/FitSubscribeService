<template>
  <div>
    <ViewDetail></ViewDetail>
  </div>
</template>

<script>
import ViewDetail from "../board/include/ViewDetail.vue";

export default {
  name: "BoardDetail",
  components: {
    ViewDetail,
  },
  created() {
    this.$store.dispatch("getBoard", this.$route.query.id);
  },
};
</script>

<style></style>
