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
    board: {},
    boards: [],
    facility: {},
    facilities: [],
    fac_use: {},
    usefacilities: [],
    fit_sub: {},
    fit_subs: [],
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
    //이용한 운동시설 상세 조회 반환
    usefacilities(state) {
      return state.usefacilities;
    },
    // 운동시설 구독권 내역 반환
    subscriptions(state) {
      return state.fit_subs;
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
    GET_BOARD(state, board) {
      // console.log(board);
      state.board = board;
    },
    GET_BOARDS(state, board) {
      // console.log(board);
      state.boards = board;
    },
    CREATE_BOARD(state, board) {
      state.board = board;
    },
    PUT_BOARD(state, board) {
      // console.log(board);
      state.board = board;
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
    GET_USEFACILITIES(state, payload) {
      state.usefacilities = payload;
    },
    SET_SUBSCRIPTION(state, payload) {
      state.fit_sub = payload;
    },
    GET_FITSUBS(state, payload) {
      state.fit_subs = payload;
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
    getBoards({ commit }, board) {
      let params = null;
      if (board) params = board;
      // console.log(params);

      const API_URL = `${REST_API}/gyudok-board/boards`;
      axios({
        url: API_URL,
        method: "GET",
        params,
      })
        .then((res) => {
          // console.log(res);
          commit("GET_BOARDS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    async createBoard({ commit }, board) {
      const API_URL = `${REST_API}/gyudok-board/board`;
      const config = {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      };

      await axios
        .post(API_URL, board, config)
        .then(() => {
          commit("CREATE_BOARD", board);
          alert("게시글이 등록되었습니다.");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getBoard({ commit }, id) {
      const API_URL = `${REST_API}/gyudok-board/board/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          // console.log(res.data);
          commit("GET_BOARD", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    async putBoard({ commit }, board) {
      const API_URL = `${REST_API}/gyudok-board/board`;
      await axios({
        url: API_URL,
        method: "PATCH",
        params: board,
      })
        .then((res) => {
          console.log(res.data);
          commit("PUT_BOARD", board);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    async deleteBoard({ commit }, id) {
      const API_URL = `${REST_API}/gyudok-board/board/${id}`;
      console.log(id);
      await axios({
        url: API_URL,
        method: "DELETE",
      })
        .then(() => {
          commit;
          router.push({ name: "boardList" });
        })
        .catch((err) => {
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
    getUseFacilities({ commit }, user_id) {
      const API_URL = `${REST_API}/gyudok-subs/facility/history/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          //console.log(res.data);
          commit("GET_USEFACILITIES", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setSubscription({ commit }, fit_sub) {
      const API_URL = `${REST_API}/gyudok-subs/facsubs/${fit_sub.user_id}`;
      axios({
        url: API_URL,
        method: "POST",
        params: fit_sub,
      })
        .then(() => {
          commit("SET_SUBSCRIPTION", fit_sub);
          alert("구독신청되었습니다. 지금 바로 운동시설을 예약하세요");
          router.push("/facsubs/search");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getSubscriptions({ commit }, user_id) {
      const API_URL = `${REST_API}/gyudok-subs/facsubs/history/${user_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          //console.log(res.data);
          commit("GET_FITSUBS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
