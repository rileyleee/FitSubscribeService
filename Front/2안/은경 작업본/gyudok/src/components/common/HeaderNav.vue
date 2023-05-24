<template>
  <header>
    <nav>
      <div>
        헤더입니다.
        <router-link :to="{ name: 'mainintro' }"> 구독 홈 </router-link>
      </div>
      <div>
        <!--부모 이름은 쓸 필요 없고 자식 이름으로 들어가기-->
        <router-link :to="{ name: 'fac-search' }"> 운동시설 구독 </router-link>
      </div>
      <div>
        <a href="#" v-if="getUser" @click="logout"> 로그아웃 </a>
        <router-link :to="{ name: 'login' }" v-else> 로그인 </router-link>
        <router-link :to="{ name: 'signup' }"> 회원가입 </router-link>
      </div>
    </nav>
  </header>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "HeaderNav",
  methods: {
    logout() {
      this.$store.commit("LOGOUT");
    },
  },
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
      if (this.loginUser) {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>

<style></style>
