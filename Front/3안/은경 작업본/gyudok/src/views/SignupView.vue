<template>
  <v-app>
    <h2>회원가입껍데기</h2>
    <signup-form-vue></signup-form-vue>
  </v-app>
</template>

<script>
import SignupFormVue from "@/components/signup/SignupForm.vue";

export default {
  name: "App",
  components: {
    SignupFormVue,
  },
  data: () => ({}),
};
</script>
