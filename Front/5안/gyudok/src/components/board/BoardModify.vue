<template>
  <div>
    <WriteForm type="modify"></WriteForm>
  </div>
</template>

<script>
import WriteForm from "../board/include/WriteForm.vue";

export default {
  name: "BoardModify",
  components: {
    WriteForm,
  },
  created() {
    this.$store.dispatch("getBoard", this.$route.query.id);
  },
};
</script>

<style></style>
