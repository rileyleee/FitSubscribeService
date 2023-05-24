<template>
  <div>
    <ViewDetail></ViewDetail>
  </div>
</template>

<script>
import ViewDetail from "@/components/movie/include/ViewDetail.vue";

export default {
  name: "MovieDetail",
  components: {
    ViewDetail,
  },
  created() {
    this.$store.dispatch("getMovie", this.$route.query.id);
  },
};
</script>

<style></style>
