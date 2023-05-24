<template>
  <div>
    <h2>등록폼작성하기</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
      /><br />
      <label for="username">이름</label>
      <input type="text" id="username" v-model="username" class="view" /><br />
      <label for="nickname">닉네임</label>
      <input type="text" id="nickname" v-model="nickname" class="view" /><br />
      <label for="email">이메일</label>
      <input type="email" id="email" v-model="email" class="view" /><br />
      <label for="phone">휴대폰번호</label>
      <input type="text" id="phone" v-model="phone" class="view" /><br />
      <label for="age">나이</label>
      <input type="number" id="age" v-model="age" class="view" /><br />
      <label for="address1">주소1</label>
      <input type="text" id="address1" v-model="address1" class="view" /><br />
      <label for="address2">주소2</label>
      <input type="text" id="address2" v-model="address2" class="view" /><br />
      <label for="gender">성별</label>
      <input type="text" id="gender" v-model="gender" class="view" /><br />
      <button class="btn" @click="regist">등록</button>
    </fieldset>
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
      }
    },
  },
  computed: {
    // ...mapState(["user"]),
  },
};
</script>
