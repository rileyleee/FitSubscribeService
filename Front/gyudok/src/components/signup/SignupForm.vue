<template>
  <div>
    <h2 class="welcome">규독은넝해에 오신것을 환영합니다.</h2>
    <div class="regist-box">
      <h2>회원가입</h2>
      <form>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="id"
            id="id"
            @keyup.enter="regist"
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
            @keyup.enter="regist"
          />
          <label for="password">비밀번호</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="username"
            id="username"
            @keyup.enter="regist"
          />
          <label for="username">이름</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="nickname"
            id="nickname"
            @keyup.enter="regist"
          />
          <label for="nickname">닉네임</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="email"
            id="email"
            @keyup.enter="regist"
          />
          <label for="email">이메일</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="phone"
            id="phone"
            @keyup.enter="regist"
          />
          <label for="phone">휴대폰번호</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="age"
            id="phone"
            @keyup.enter="regist"
          />
          <label for="age">나이</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="address1"
            id="address1"
            @keyup.enter="regist"
          />
          <label for="address1">주소1</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="address2"
            id="address2"
            @keyup.enter="regist"
          />
          <label for="address2">주소2</label>
        </div>
        <div class="user-box">
          <input
            type="text"
            name=""
            required=""
            v-model="gender"
            id="address2"
            @keyup.enter="regist"
          />
          <label for="gender">성별</label>
        </div>
        <a class="btn" @click="regist"
          >등록
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
  name: "UserList",
  data() {
    return {
      id: "",
      password: "",
      username: "",
      nickname: "",
      email: "",
      phone: "",
      age: 0,
      address1: "",
      address2: "",
      gender: "",
      img: "",
    };
  },
  methods: {
    async regist() {
      let user = {
        id: this.id,
        password: this.password,
        username: this.username,
        nickname: this.nickname,
        email: this.email,
        phone: this.phone,
        age: this.age,
        address1: this.address1,
        address2: this.address2,
        gender: this.gender,
        img: "#",
      };

      if (
        user.id === "" ||
        user.password === "" ||
        user.username === "" ||
        user.nickname === "" ||
        user.email === "" ||
        user.phone === "" ||
        user.age == 0 ||
        user.address1 === "" ||
        user.address2 === "" ||
        user.gender === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      } else {
        // console.log(user);
        await this.$store.dispatch("createRegist", user);
        // this.$router.push({ name: "boardList" });
      }
    },
  },
  computed: {
    // ...mapState(["user"]),
  },
};
</script>

<style>
.welcome {
  text-align: center;
}
html {
  height: 830px;
}
body {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  background: linear-gradient(white, white);
}

.regist-box {
  /* margin-top: 330px; */
  position: absolute;
  /* top: 60%; */
  /* bottom: 1%; */
  left: 50%;
  width: 80%;
  max-width: 350px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: white;
  /* box-sizing: 300px; */
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
  border-radius: 10px;
  overflow-y: auto;
  max-height: 80vh;
  margin-bottom: 100px;
  margin-top: 300px;
}

.regist-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: black;
  text-align: center;
}

.regist-box .user-box {
  position: relative;
}

.regist-box .user-box input {
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
.regist-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: black;
  pointer-events: none;
  transition: 0.5s;
}

.regist-box .user-box input:focus ~ label,
.regist-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #2b57a1;
  font-size: 12px;
}

.regist-box form a {
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

.regist-box a:hover {
  background: #2b57a1;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #2b57a1, 0 0 25px #2b57a1, 0 0 50px #2b57a1,
    0 0 100px #2b57a1;
}

.regist-box a span {
  position: absolute;
  display: block;
}

.regist-box a span:nth-child(1) {
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

.regist-box a span:nth-child(2) {
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

.regist-box a span:nth-child(3) {
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

.regist-box a span:nth-child(4) {
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
