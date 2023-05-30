<template>
  <div>
    <h2>운동구독</h2>
    <b-container fluid="xl">
      <br />
      <router-view />
    </b-container>
  </div>
</template>

<script>
export default {
  name: "FacSubView",
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

h2 {
  margin-left: 175px;
}
</style>
