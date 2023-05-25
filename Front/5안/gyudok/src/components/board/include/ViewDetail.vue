<template>
  <div>
    <h2 class="align-center">글 정보</h2>
    <div>
      <!-- <video :src="getFilePath(board.fileName)" controls></video> -->
      <table>
        <tr>
          <td><label for="category"> 카테고리</label></td>
          <td><label for="title">제목</label></td>
          <td><label for="content">내용</label></td>
          <td><label for="viewcnt">조회수</label></td>
          <td><label for="regdate">작성날짜</label></td>
        </tr>

        <tr>
          <td>
            <div>{{ board.category }}</div>
          </td>
          <td>
            <div>{{ board.title }}</div>
          </td>
          <td>
            <div>{{ board.content }}</div>
          </td>
          <td>
            <div>{{ board.viewcnt }}</div>
          </td>
          <td>
            <div>{{ board.regdate }}</div>
          </td>
        </tr>
      </table>
      <div>
        <router-link :to="{ name: 'boardList' }"> 목록으로</router-link>
      </div>
      <router-link
        :to="{ name: 'boardModify', query: { id: this.$route.query.id } }"
        >글 수정</router-link
      >
      <!-- <button @click="likeUpdate">좋아요 버튼</button> -->
    </div>
  </div>
  <!-- 여기 밑부분 수정 -->
</template>

<script>
import { mapState } from "vuex";
// import { mapState } from "vuex";
export default {
  name: "ViewDetail",
  computed: {
    ...mapState(["board"]),
    // ...mapState(["board.likeCnt"]),
  },
  methods: {
    // getFilePath(file) {
    //   const videoPath = `asset/upload/${board.fileName}`; // 동영상 파일이 위치한 경로를 지정합니다.
    //   return videoPath;
    // },
    // async likeUpdate() {
    //   await this.$store.dispatch("updateLikeCnt", this.movie.id);
    //   this.$router.push({
    //     name: "movie-detail",
    //     query: { id: this.$route.query.id },
    //   });
    // },
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
  font-size: large;
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
.align-center {
  text-align: center;
}
</style>