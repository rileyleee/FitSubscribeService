<template>
  <div class="center">
    <h1>규독페이지에 오신걸 환영합니다.</h1>
    <b-col class="mb-3">
      <b-icon icon="bell" animation="throb" font-scale="4"></b-icon>
    </b-col>
  </div>
</template>

<style scoped>
.center-align {
  text-align: center;
}

@font-face {
  font-family: "jua";
  src: url("@/assets/fonts/BMJUA_ttf.ttf");
}
.center {
  margin-top: 150px;
  text-align: center;
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
