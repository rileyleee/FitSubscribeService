<template>
  <div>
    <h1>영화 등록</h1>
    <div>
      <label for="title">영화 제목</label>
      <input type="text" id="title" name="title" v-model="title" />
      <label for="director">감독</label>
      <input type="text" id="director" name="director" v-model="director" />
      <label for="genre">장르</label>
      <input type="text" id="genre" name="genre" v-model="genre" />
      <label for="runningTime">상영 시간</label>
      <input
        type="text"
        id="runningTime"
        name="runningTime"
        v-model="runningTime"
      />
      <button v-if="type == 'create'" @click="registMovie">등록</button>
      <button v-if="type == 'modify'" @click="modifyMovie">수정</button>
      <button @click="moveList">목록</button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "WriteForm",
  props: {
    type: String,
  },
  data() {
    return {
      title: "",
      director: "",
      genre: "",
      runningTime: "",
    };
  },
  created() {
    if (this.type == "modify") {
      this.title = this.movie.title;
      this.director = this.movie.director;
      this.genre = this.movie.genre;
      this.runningTime = this.movie.runningTime;
    }
  },
  methods: {
    async registMovie() {
      const movie = {
        title: this.title,
        director: this.director,
        genre: this.genre,
        runningTime: this.runningTime,
      };

      if (movie.title == "" || movie.director == "" || movie.genre == "") {
        alert("내용을 전부 채워주세요");
      } else {
        await this.$store.dispatch("setMovie", movie);
        this.$router.push({ name: "movie-list" });
      }
    },
    async modifyMovie() {
      const movie = {
        id: this.$route.query.id,
        title: this.title,
        director: this.director,
        genre: this.genre,
        runningTime: this.runningTime,
      };
      await this.$store.dispatch("putMovie", movie);
      this.$router.push({ name: "movie-detail", query: { id: movie.id } });
    },
    moveList() {
      this.$router.push({ name: "movie-list" });
    },
  },
  computed: {
    ...mapGetters(["movie"]),
  },
};
</script>

<style></style>
