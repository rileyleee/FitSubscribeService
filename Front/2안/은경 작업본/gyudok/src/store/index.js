import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999`;

export default new Vuex.Store({
  state: {
    user: {},
    users: [],
    loginUser: null,
    facility: {},
    facilities: [],
    fac_use:{},
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
  },
  mutations: {
    DO_REGIST(state, user) {
      state.user = user;
    },
    DO_LOGIN(state, user) {
      state.loginUser = user;
      localStorage.setItem("loginUser", JSON.stringify(user));
    },
    LOGOUT: function (state) {
      state.loginUser = null;
      localStorage.removeItem("loginUser");
    },
    GET_FACILITIES(state, payload) {
      state.facilities = payload;
    },
    GET_FACILITY(state, payload) {
      state.facility = payload;
    },
    USE_THISFAC(state, payload) {
      state.fac_use = payload;
    },
  },
  actions: {
    createRegist({ commit }, user) {
      const API_URL = `${REST_API}/gyudok-user/regist`;
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then(() => {
          commit("DO_REGIST", user);
          alert("등록되었습니다.");
          router.push("/");
        })
        .catch((err) => {
          alert("다시 작성해주세요.");
          console.log(err);
        });
    },
    setLoginUser({ commit }, user) {
      const API_URL = `${REST_API}/gyudok-user/login`;
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          commit("DO_LOGIN", res.data);
          alert("로그인하였습니다.");
          router.push("/");
        })
        .catch((err) => {
          alert("비밀번호를 다시 입력해주세요.");
          console.log(err);
        });
    },
    getFacilities({ commit }, keyword) {
      const API_URL = `${REST_API}/gyudok-subs/facsubs/search/${keyword}`;
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
      const API_URL = `${REST_API}/gyudok-subs/facility/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("GET_FACILITY", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    useThisFac({ commit }, fac_use) {
      console.log(fac_use);
      const API_URL = `${REST_API}/gyudok-subs/facility/use`;
      axios({
        url: API_URL,
        method: "POST",
        params: fac_use,
      })
        .then(() => {
          commit("USE_THISFAC", fac_use);
          alert("예약되었습니다 (전.이용하기)");
          router.push("/facsubs/result"); //시설 이용내역으로 가면 좋겠다.
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});

// alert("등록되었습니다.");
// router.push("/");
// })
// .catch((err) => {
// alert("다시 작성해주세요.");
// console.log(err);
// });
