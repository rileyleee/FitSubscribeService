<template>
  <!-- 사실 카테고리는 id에 따라서 다르게 창 보이게 설정 -->
  <div>
    <h1>글쓰기</h1>
    <div>
      <label for="title"> 제목</label>
      <input type="text" id="title" name="title" v-model="title" />
      <label for="category"> 카테고리</label>
      <input type="text" id="category" name="category" v-model="category" />
      <label for="content">내용</label>
      <input type="text" id="content" name="content" v-model="content" />
      <input type="file" accept="video/*" @change="handleFileChange" />

      <button v-if="type === 'create'" @click="registBoard">등록</button>
      <button v-if="type === 'modify'" @click="modifyBoard">수정</button>
      <button @click="removeBoard">삭제</button>
      <button @click="moveCommunityList">목록</button>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "WriteForm",
  props: {
    type: String,
  },
  data() {
    return {
      title: "",
      category: "",
      content: "",
      file: null,
    };
  },
  created() {
    if (this.type == "modify") {
      this.title = this.board.title;
      this.content = this.board.content;
      this.category = this.board.category;
      this.file = this.board.file;
    }
  },
  methods: {
    handleFileChange(event) {
      this.file = event.target.files[0]; // 선택한 파일을 변수에 저장
      // this.video = this.file;
    },
    async registBoard() {
      const storedUser = localStorage.getItem("loginUser");
      const user = JSON.parse(storedUser);
      console.log(user);

      const formData = new FormData();
      formData.append("user_id", user.id);
      formData.append("category", this.category);
      formData.append("title", this.title);
      formData.append("content", this.content);
      formData.append("file", this.file);

      // let board = {
      //   user_id: user.id,
      //   title: this.title,
      //   content: this.content,
      //   category: this.category,
      //   video: this.video,
      // };

      if (this.title == "" || this.content == "" || this.category == "") {
        alert("내용을 전부 채워주세요");
      } else {
        await this.$store.dispatch("createBoard", formData);
        this.$router.push({ name: "boardList" });
      }
    },
    async modifyBoard() {
      const storedUser = localStorage.getItem("loginUser");
      const user = JSON.parse(storedUser);
      const board = {
        user_id: user.id,
        id: this.$route.query.id,
        content: this.content,
      };
      console.log(board);
      await this.$store.dispatch("putBoard", board);
      this.$router.push({ name: "boardList" });
    },
    moveCommunityList() {
      this.$router.push({ name: "boardList" });
    },
    async removeBoard() {
      let id = this.$route.query.id;
      //   console.log(id);
      await this.$store.dispatch("deleteBoard", id);
      this.$router.push({ name: "boardList" });
    },
  },
  computed: {
    ...mapState(["board"]),
  },
};
</script>

<style></style>
