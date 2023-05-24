import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
//import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/gyudok-subs`;

export default new Vuex.Store({
  state: {
    facility: {},
    facilities: [],
    infoMessage: "운동 규독 은넝해 사이트에 오신 것을 환영해요",
  },
  getters: {
    // 운동시설 검색해서 반환
    facilities(state) {
      return state.facilities;
    },
    //운동시설 상세 조회 반환
    facility(state) {
      return state.facility;
    },
    // 운동시설 이용내역 한 개 반환
    facVisit(state) {
      return state.facVisit;
    },
    // 운동시설 이용내역 여러 개 반환
    facVisits(state) {
      return state.facVisits;
    },
  },
  mutations: {
    GET_FACILITIES(state, payload) {
      state.facilities = payload;
    },
    GET_FACILITY(state, payload) {
      state.facility = payload;
    },
  },
  actions: {
    getFacilities({ commit }, keyword) {
      const API_URL = `${REST_API}/facsubs/${keyword}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          commit("GET_FACILITIES", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getFacility({ commit }, id) {
      const API_URL = `${REST_API}/facility/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(res);
          commit("GET_FACILITY", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
