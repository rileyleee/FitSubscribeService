<template>
  <div>
    <WriteForm type="create"></WriteForm>
  </div>
</template>

<script>
import WriteForm from "../board/include/WriteForm.vue";

export default {
  name: "BoardCreate",
  components: {
    WriteForm,
  },
};
</script>

<style scoped>
@font-face {
  font-family: "jua";
  src: url("@/assets/fonts/BMJUA_ttf.ttf");
}
div {
  font-family: "jua";
  font-size: larger;
}
header {
  height: 70px;
  background-color: white;
  line-height: 70px;
  padding: 0px 30px;
}
header a {
  margin: 10px;
  text-decoration: none;
  color: rgb(12, 12, 12);
}
</style>
