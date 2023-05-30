<template>
  <div>
    <h2 class="left-align">커뮤니티</h2>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>
<style scoped>
.left-align {
  margin-left: 40px;
}
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

.header-nav {
  display: flex;
  justify-content: space-between;
}

.button-container button {
  margin-right: 10px;
}

.header-mi .logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  margin: 0;
}
.home {
  width: 170px;
  height: 65px;
}
</style>
