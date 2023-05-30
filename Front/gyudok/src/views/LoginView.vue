<template>
  <div>
    <!-- <h2>로그인껍데기</h2> -->
    <login-form-vue></login-form-vue>
  </div>
</template>

<script>
import LoginFormVue from "@/components/login/LoginForm.vue";

export default {
  name: "Login-Form",
  components: {
    LoginFormVue,
  },
  data: () => ({}),
};
</script>

<style scoped>
.center-align {
  text-align: center;
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
