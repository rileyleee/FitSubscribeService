<template>
  <div>
    <!-- <h2 class="welcome">로그인을 해주세요</h2> -->
    <div class="login-box">
      <h2>로그인폼</h2>
      <form>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="id"
            id="id"
            @keyup.enter="login"
          />
          <label for="id">아이디</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="password"
            id="password"
            @keyup.enter="login"
          />
          <label for="password">비밀번호</label>
        </div>
        <a class="btn" @click="login"
          >로그인
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <!-- <button class="btn" @click="regist">등록</button> -->
        </a>
      </form>
    </div>
  </div>
</template>

<script>
// import { mapGetters, mapState } from "vuex";

export default {
  name: "LoginForm",
  data() {
    return {
      id: "",
      password: "",
    };
  },
  methods: {
    login() {
      let user = {
        id: this.id,
        password: this.password,
      };

      if (user.id === "") {
        alert("아이디를 입력해주세요");
        return;
      }
      if (user.password === "") {
        alert("비밀번호를 입력해주세요");
        return;
      } else {
        this.$store.dispatch("setLoginUser", user);
      }
    },
  },
};
</script>

<style props>
/* .welcome {
  text-align: left;
} */
html {
  height: 830px;
}
body {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: linear-gradient(white, white);
}

.login-box {
  margin-top: 40px;
  position: absolute;
  top: 60%;
  /* bottom: 1%; */
  left: 50%;
  width: 80%;
  max-width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: white;
  /* box-sizing: 300px; */
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
  border-radius: 10px;
  overflow-y: auto;
  max-height: 80vh;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: black;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: black;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid black;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: black;
  pointer-events: none;
  transition: 0.5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #2b57a1;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: black;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: 0.5s;
  margin-top: 40px;
  letter-spacing: 4px;
}

.login-box a:hover {
  background: #2b57a1;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #2b57a1, 0 0 25px #2b57a1, 0 0 50px #2b57a1,
    0 0 100px #2b57a1;
}

.login-box a span {
  position: absolute;
  display: block;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #2b57a1);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,
  100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #2b57a1);
  animation: btn-anim2 1s linear infinite;
  animation-delay: 0.25s;
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,
  100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #2b57a1);
  animation: btn-anim3 1s linear infinite;
  animation-delay: 0.5s;
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,
  100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #2b57a1);
  animation: btn-anim4 1s linear infinite;
  animation-delay: 0.75s;
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,
  100% {
    bottom: 100%;
  }
}
</style>
