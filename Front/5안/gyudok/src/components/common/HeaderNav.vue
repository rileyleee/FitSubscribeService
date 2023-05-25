<template>
  <header class="shadow mb-5 bg-body-tertiary rounded">
    <nav class="header-nav">
      <div>
        <router-link :to="{ name: 'mainintro' }">
          <img class="home" src="@/assets/main.png" />
        </router-link>
      </div>
      <div>
        <router-link :to="{ name: 'fac-search' }"> 운동시설 구독 </router-link>
        <router-link :to="{ name: 'boardList' }">커뮤니티</router-link>
        <a href="#">이벤트</a>
      </div>
      <div>
        <a href="#" v-if="getUser" @click="logout">로그아웃 </a>
        <router-link :to="{ name: 'login' }" v-else>로그인 </router-link>
        <router-link :to="{ name: 'signup' }">회원가입 </router-link>
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

<style>
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
