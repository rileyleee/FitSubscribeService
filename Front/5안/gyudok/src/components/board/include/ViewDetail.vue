<template>

  <div>
    <h1>글 정보</h1>
    <div>
      <video :src="getFilePath(this.mymymy.fileName)"
        ref="videoPlayer"
        controls muted @click="playVideo"
      ></video>
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
            <div>{{ mymymy.category }}</div>
          </td>
          <td>
            <div>{{ mymymy.title }}</div>
          </td>
          <td>
            <div>{{ mymymy.content }}</div>
          </td>
          <td>
            <div>{{ mymymy.viewcnt }}</div>
          </td>
          <td>
            <div>{{ mymymy.regdate }}</div>
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
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "ViewDetail",
  data(){
    return{
      mymymy:{},
    }
  },
  created(){
    console.log(this.$route.query.id);
    const API_URL = `http://localhost:9999/gyudok-board/board/${this.$route.query.id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res.data);
          this.mymymy = res.data;
          console.log(this.mymymy.fileName);
        })
        .catch((err) => {
          console.log(err);
        });
  },
  methods: {
    getFilePath(fileName) {
      console.log("getfile")      
      const videoPath = `../assets/upload/${fileName}`; // 동영상 파일이 위치한 경로를 지정합니다.
      console.log(videoPath);
      return videoPath;
    },

   playVideo() {
      const videoPlayer = this.$refs.videoPlayer;
      if (videoPlayer.paused) {
        videoPlayer.play();
      }
    },
  },
};
</script>

<style></style>
