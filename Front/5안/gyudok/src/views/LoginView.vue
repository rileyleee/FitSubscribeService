<template>
  <div id="app">
    <h2>로그인껍데기</h2>
    <login-form-vue></login-form-vue>
  </div>
</template>

<script>
import LoginFormVue from "@/components/login/LoginForm.vue";

export default {
  name: "App",
  components: {
    LoginFormVue,
  },
  data: () => ({}),
};
</script>
