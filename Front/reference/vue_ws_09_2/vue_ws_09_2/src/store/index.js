import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    movie: {},
    movies: [],
    infoMessage: "영화 관리 사이트에 오신 걸 환영합니다.",
  },
  getters: {
    movies(state) {
      return state.movies;
    },
    movie(state) {
      return state.movie;
    },
  },
  mutations: {
    setMovies(state, payload) {
      state.movies = payload;
    },
    setMovie(state, payload) {
      state.movie = payload;
    },
    UPDATE_LIKE_CNT(state) {
      state.movie.likeCnt += 1;
    },
  },
  actions: {
    setMovie(context, payload) {
      http
        .post("", payload)
        .then(() => {
          alert("등록에 성공했습니다.");
        })
        .catch((err) => {
          alert("등록에 실패했습니다.");
          console.log(err);
        });
    },
    getMovies({ commit }) {
      http.get("").then(({ data }) => {
        commit("setMovies", data);
      });
    },
    getMovie({ commit }, payload) {
      http.get(payload).then(({ data }) => {
        commit("setMovie", data);
      });
    },
    async putMovie(context, payload) {
      await http
        .put(`${payload.id}`, payload)
        .then(() => {
          alert("수정 성공");
          // commit('setMovie')
        })
        .catch(() => {
          alert("수정 실패");
        });
    },
    updateLikeCnt({ commit }, payload) {
      http.put(`/like/${payload}`).then(() => {
        commit("UPDATE_LIKE_CNT");
      });
    },
  },
});
