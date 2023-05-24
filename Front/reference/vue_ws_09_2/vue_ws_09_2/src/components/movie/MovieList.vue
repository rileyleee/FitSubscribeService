<template>
  <div>
    <h1>영화 목록</h1>
    <button @click="moveRegist">영화 등록</button>
    <div v-if="movies.length">
      <table>
        <colgroup>
          <col />
          <col />
          <col />
          <col />
          <col />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>영화제목</th>
            <th>감독</th>
            <th>장르</th>
            <th>상영시간</th>
            <th>좋아요</th>
          </tr>
        </thead>
        <tbody>
          <ListRow
            v-for="(movie, index) in movies"
            :key="index"
            :no="`${index + 1}`"
            :title="movie.title"
            :director="movie.director"
            :genre="movie.genre"
            :runningTime="movie.runningTime"
            :likeCnt="movie.likeCnt"
          >
          </ListRow>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import ListRow from "@/components/movie/include/ListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "movieList",
  methods: {
    moveRegist() {
      this.$router.push({ name: "movie-create" });
    },
  },
  components: {
    ListRow,
  },
  computed: {
    ...mapGetters(["movies"]),
  },
  created() {
    this.$store.dispatch("getMovies");
  },
};
</script>

<style></style>
