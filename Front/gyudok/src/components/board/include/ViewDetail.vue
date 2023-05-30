<template>
  <div>
    <div class="cont1">
      <h2 class="align-center">글 정보</h2>
    </div>
    <div>
      <!-- <video :src="getFilePath(board.fileName)" controls></video> -->
      <div class="container">
        <div class="category">카테고리 : {{ board.category }}</div>
        <div class="board-contents">
          <div class="between">
            <span class="title">제목 : {{ board.title }}</span>
            <div class="between">
              <div class="bottonson">
                <b-button
                  class="bot"
                  variant="outline-warning"
                  size="sm"
                  @click="goModify"
                  >글수정</b-button
                >
                <!-- <router-link :to="{ name: 'boardList' }"> 목록으로</router-link> -->

                <b-button
                  class="bot"
                  variant="outline-secondary"
                  size="sm"
                  @click="goList"
                  >목록</b-button
                >
                <!-- <router-link
                  :to="{
                    name: 'boardModify',
                    query: { id: this.$route.query.id },
                  }"
                  >글 수정</router-link
                > -->
              </div>
            </div>
          </div>
          <hr />
          <hr />
          <div>
            <div class="end">
              <span>작성자 : {{ board.user_id }}</span>
              <div class="end">
                <div class="little">
                  <span>작성날짜 : {{ formatDate(board.regdate) }}</span>
                </div>
                <div class="little">
                  <span>조회수 : {{ board.viewcnt }}</span>
                </div>
              </div>
            </div>
            <hr />
          </div>
        </div>
        <div class="content">
          <span>내용 : {{ board.content }}</span>
        </div>
      </div>
      <!-- <button @click="likeUpdate">좋아요 버튼</button> -->
    </div>
  </div>
  <!-- 여기 밑부분 수정 -->
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ViewDetail",
  computed: {
    ...mapState(["board"]),
    // ...mapState(["board.likeCnt"]),
  },
  methods: {
    formatDate(dateString) {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      return `${year}년 ${month}월 ${day}일`;
    },
    goList() {
      this.$router.push({ name: "boardList" });
    },
    goModify() {
      this.$router.push({
        name: "boardModify",
        query: { id: this.$route.query.id },
      });
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
  font-size: large;
}
.bottonson {
  margin-right: 10px;
}
.title {
  font-size: x-large;
}
.bot {
  margin-right: 10px;
}
.container {
  margin-top: 30px;
}
.between {
  display: flex;
  justify-content: space-between;
}
.category {
  font-size: small;
  display: flex;
}
header {
  height: 70px;
  background-color: white;
  line-height: 70px;
  padding: 0px 30px;
}
.end {
  display: flex;
  justify-content: space-between;
}
.little {
  margin-right: 10px;
}
header a {
  margin: 10px;
  text-decoration: none;
  color: rgb(12, 12, 12);
}
.content {
  font-size: x-large;
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
.align-center {
  text-align: center;
}
</style>
