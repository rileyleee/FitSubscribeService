<template>
  <div>
    <WriteForm type="modify"></WriteForm>
  </div>
</template>

<script>
import WriteForm from "@/components/movie/include/WriteForm.vue";

export default {
  name: "MovieModify",
  components: {
    WriteForm,
  },
  created() {
    this.$store.dispatch("getMovie", this.$route.query.id);
  },
};
</script>

<style></style>
