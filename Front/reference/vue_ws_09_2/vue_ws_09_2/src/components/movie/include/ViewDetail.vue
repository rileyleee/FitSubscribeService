<template>
  <div>
    <h1>영화 정보</h1>
    <div>
      <tr>
        <td><label for="title">영화 제목</label></td>
        <td><label for="director">감독</label></td>
        <td><label for="genre">장르</label></td>
        <td><label for="runningTime">상영 시간</label></td>
        <td><label for="likeCnt">좋아요 수</label></td>
      </tr>
      <tr>
        <td>
          <div>{{ movie.title }}</div>
        </td>
        <td>
          <div>{{ movie.director }}</div>
        </td>
        <td>
          <div>{{ movie.genre }}</div>
        </td>
        <td>
          <div>{{ movie.runningTime }}분</div>
        </td>
        <td>
          <div>{{ movie.likeCnt }}</div>
        </td>
      </tr>
      <div>
        <router-link :to="{ name: 'movie-list' }">영화 목록</router-link>
      </div>
      <router-link
        :to="{ name: 'movie-modify', query: { id: this.$route.query.id } }"
        >영화 수정</router-link
      >
      <button @click="likeUpdate">좋아요 버튼</button>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
export default {
  name: "ViewDetail",
  computed: {
    ...mapGetters(["movie"]),
    ...mapState(["movie.likeCnt"]),
  },
  methods: {
    async likeUpdate() {
      await this.$store.dispatch("updateLikeCnt", this.movie.id);
      this.$router.push({
        name: "movie-detail",
        query: { id: this.$route.query.id },
      });
    },
  },
};
</script>

<style></style>
