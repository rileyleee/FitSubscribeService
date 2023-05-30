<template>
  <div>
    <!-- <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원가입폼</h2> -->
    <signup-form-vue></signup-form-vue>
  </div>
</template>

<script>
import SignupFormVue from "@/components/signup/SignupForm.vue";

export default {
  name: "SignUp",
  components: {
    SignupFormVue,
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
