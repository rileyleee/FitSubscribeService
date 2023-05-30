<template>
  <!-- 사실 카테고리는 id에 따라서 다르게 창 보이게 설정 -->
  <div>
    <h3 class="center-align" v-if="type == 'create'">글을 작성해 주세요</h3>
    <h3 class="center-align" v-if="type == 'modify'">글을 수정해 주세요</h3>
    <div class="container">
      <div>
        <div class="content">
          <label for="title"> 제목</label>
          <input
            type="text"
            id="title"
            name="title"
            v-model="title"
            class="form-control"
            :readonly="type == 'modify'"
          />

          <!-- <label for="category"> 카테고리</label>
          <input
            type="text"
            id="category"
            name="category"
            v-model="category"
            class="form-control"
            :readonly="type == 'modify'"
          /> -->
          <label for="category"> 카테고리</label>
          <b-form-select
            v-model="category"
            id="category"
            name="category"
            :disabled ="type == 'modify'"
          >
            <option
              v-for="category in categoryList"
              :key="category.id"
              :value="category.value"
            >
              {{ category.value }}
            </option>
          </b-form-select>

          <label for="content" form-label>내용</label>
          <textarea
            type="text"
            id="content"
            name="content"
            v-model="content"
            class="form-control"
            rows="3"
          />

          <input
            type="file"
            accept="video/*"
            @change="handleFileChange"
            class="file"
          />
        </div>

        <div class="button">
          <b-button
            class="buttonson"
            variant="outline-primary"
            style="background-color = white"
            v-if="type === 'create'"
            @click="registBoard"
            >등록</b-button
          >
          <b-button
            class="buttonson"
            variant="outline-warning"
            v-if="type === 'modify'"
            @click="modifyBoard"
            >수정</b-button
          >
          <b-button
            class="buttonson"
            variant="outline-danger"
            @click="removeBoard"
            >삭제</b-button
          >

          <b-button
            class="buttonson"
            variant="outline-secondary"
            @click="moveCommunityList"
            >목록</b-button
          >
        </div>
      </div>
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

      categoryList: [
        {
          id: 1,
          value: "운동",
        },
        {
          id: 2,
          value: "식단",
        },
        {
          id: 3,
          value: "시설",
        },
        {
          id: 4,
          value: "강의",
        },
        {
          id: 5,
          value: "기타",
        },
      ],
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
      // const storedUser = localStorage.getItem("loginUser");
      const storeUser = localStorage.getItem("loginUser");
      // console.log(storeUser);

      const user = JSON.parse(storeUser);
      console.log(user.id);
      if (user.id !== this.board.user_id) {
        alert("수정할수 없습니다.");
        this.$router.push({ name: "boardList" });
      } else {
        const board = {
          user_id: user.id,
          id: this.$route.query.id,
          content: this.content,
        };
        console.log(board);
        await this.$store.dispatch("putBoard", board);
        alert("수정이 정상적으로 완료되었습니다.");
        this.$router.push({ name: "boardList" });
      }
    },
    moveCommunityList() {
      this.$router.push({ name: "boardList" });
    },
    async removeBoard() {
      const storedUser = localStorage.getItem("loginUser");
      const user = JSON.parse(storedUser);
      if (user.id !== this.board.user_id) {
        alert("삭제할수 없습니다.");
        this.$router.push({ name: "boardList" });
      } else {
        let id = this.$route.query.id;
        await this.$store.dispatch("deleteBoard", id);
        alert("삭제가 완료되었습니다.");
      }

      //   this.$router.push({ name: "boardList" });
    },
  },
  computed: {
    ...mapState(["board"]),
  },
};
</script>

<style scoped>
.center-align {
  text-align: center;
}
.container {
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
  /* transform: translate(-50%, -50%); */
  background: white;
  border-radius: 10px;
  overflow-y: auto;
  margin-top: 20px;
  
}
.write {
  margin-top: 30px;
}
/* .container h3 {
  margin: 0 0 30px;
  padding: 0;
} */
.btn-secondary {
  background-color: white;
}
.form-control {
  margin-bottom: 30px;
}
.content {
  display: flex;
  flex-direction: column;
  margin-top: 30px;
  margin-bottom: 30px;
}
.button {
  display: flex;
  /* justify-content: end; */
  margin-bottom: 30px;
  /* margin-right: 10px; */
  justify-content: flex-end;
  margin-right: 10px;
}
.buttonson {
  margin-right: 10px;
}

.input {
  margin-bottom: 10px;
}

@font-face {
  font-family: "jua";
  src: url("@/assets/fonts/BMJUA_ttf.ttf");
}
div {
  font-family: "jua";
  font-size: medium;
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
</style>
