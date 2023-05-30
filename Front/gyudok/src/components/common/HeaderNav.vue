<template>
  <header class="shadow mb-5 bg-body-tertiary rounded">
    <nav class="header-nav">
      <div>
        <router-link :to="{ name: 'mainintro' }">
          <img class="home" src="@/assets/main.png" />
        </router-link>
      </div>
      <div class="button-container">
        <button
          type="button"
          variant="outline-primary"
          class="btn"
          style="background-color: white"
          @click="goToBoardList"
        >
          커뮤니티
        </button>
        <button
          type="button"
          variant="outline-primary"
          class="btn"
          style="background-color: white"
          @click="goToFacSearch"
        >
          운동시설 구독
        </button>
      </div>
      <div class="button-container">
        <button
          type="button"
          variant="outline-primary"
          class="btn"
          style="background-color: white"
          @click="logout"
          v-if="getUser"
          href="#"
        >
          로그아웃
        </button>
        <!-- <a href="#" v-if="getUser" @click="logout">로그아웃 </a> -->
        <button
          type="button"
          variant="outline-primary"
          class="btn"
          style="background-color: white"
          @click="goToLogin"
          v-else
        >
          로그인
        </button>
        <button
          type="button"
          variant="outline-primary"
          class="btn"
          style="background-color: white"
          @click="goToSignup"
        >
          회원 가입
        </button>
        <!-- <router-link :to="{ name: 'signup' }">회원 가입 </router-link> -->
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
    goToSignup() {
      if (this.$route.path !== "/signup") {
        this.$router.push({ name: "signup" });
      }
    },
    goToLogin() {
      if (this.$route.path !== "/login") {
        this.$router.push({ name: "login" });
      }
    },
    goToBoardList() {
      if (this.$route.path !== "/community/") {
        this.$router.push({ name: "boardList" });
      }
    },
    goToFacSearch() {
      if (this.$route.path !== "/facsubs/search") {
        this.$router.push({ name: "fac-search" });
      }
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
