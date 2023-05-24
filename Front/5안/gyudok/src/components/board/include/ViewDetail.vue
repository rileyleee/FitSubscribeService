<template>
  <div>
    <h1>글 정보</h1>
    <div>
      <video width="640" height="360" controls>
        <source
          :src="/assets/upload/20230524/1684916101034_158349.mp4"
          type="video/mp4"
        />
      </video>
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
    getFilePath(filennnnn) {
      const videoPath = `../assets/upload/${filennnnn}`; // 동영상 파일이 위치한 경로를 지정합니다.
      return require(`${videoPath}`);
    },
    // getFilePath(board) {
    //   const videoPath = `@/assets/upload/${board.fileName}`; // 동영상 파일이 위치한 경로를 지정합니다.
    //   return videoPath;
    // },
    // getFilePath(board) {
    //   const videoPath = require(`@/assets/upload/${board.fileName}`);
    //   return videoPath;
    // },
    // getFilePath(fileName) {
    //   let temp = "assets/upload/";
    //   return require(temp + fileName);
    // },
    // getFilePath(board) {
    //   const videoPath = require("@/assets/upload/" + this.board.fileName);
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

<style></style>
