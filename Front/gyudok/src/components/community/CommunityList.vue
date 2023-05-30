<template>
  <div>
    <div class="container">
      <h3 class="center-align">커뮤니티 목록</h3>
      <div class="writebutton">
        <b-button
          variant="outline-primary"
          style="border-color: #2b57a1"
          size="sm"
          @click="boardCreate"
          >글쓰기</b-button
        >
      </div>

      <hr />
      <div>
        <div>
          <b-table-simple hover :items="boards">
            <b-thead class="text-center">
              <b-tr>
                <b-th>번호</b-th>
                <b-th>제목</b-th>
                <b-th>카테고리</b-th>
                <b-th>타이틀</b-th>
                <b-th>작성자</b-th>
                <b-th>조회수</b-th>
                <b-th>작성날짜</b-th>
              </b-tr>
            </b-thead>
            <b-tbody class="text-center">
              <b-tr v-for="(board, index) in pageBoardList" :key="board.id">
                <b-td>{{ index + 1 }}</b-td>
                <b-td>
                  <b-link
                    style="color: #2b57a1"
                    :to="{ name: 'boardDetail', query: { id: board.id } }"
                    >{{ board.title }}</b-link
                  >
                </b-td>
                <b-td>{{ board.category }}</b-td>
                <b-td>{{ board.title }}</b-td>
                <b-td>{{ board.user_id }}</b-td>
                <b-td>{{ board.viewcnt }}</b-td>
                <b-td>{{ board.regdate }}</b-td>
              </b-tr>
            </b-tbody>
          </b-table-simple>
        </div>
      </div>
      <b-pagination
        v-model="currentPage"
        :total-rows="boardCount"
        :per-page="perPage"
        align="center"
      >
        <template #first-text
          ><span style="color: #2b57a1">First</span></template
        >
        <template #last-text><span style="color: #2b57a1">Last</span></template>
      </b-pagination>
    </div>
  </div>
</template>

<script>
// import ListRow from "../board/include/BoardListRow.vue";
import { mapState } from "vuex";

export default {
  name: "Community-List",
  data() {
    return {
      currentPage: 1,
      perPage: 10,
      mode: 1,
      //   boardCount: 1,
    };
  },
  methods: {
    boardCreate() {
      this.$router.push({ name: "boardCreate" });
    },
    goToboardDetail() {
      //   if (this.$route.path !== "`/board/${board.id}`") {
      this.$router.push({ name: "boardDetail" });
      //   },
    },
  },
  //   components: {
  //     ListRow,
  //   },
  computed: {
    ...mapState(["boards"]),

    pageBoardList() {
      return this.boards.slice(
        (this.currentPage - 1) * this.perPage,
        this.currentPage * this.perPage
      );
    },
    boardCount() {
      return this.boards.length;
    },
  },
  created() {
    this.$store.dispatch("getBoards");
  },
};
</script>

<style scoped>
.center-align {
  text-align: center;
}
.container{
  height: 1200px;
}

@font-face {
  font-family: "jua";
  src: url("@/assets/fonts/BMJUA_ttf.ttf");
}
div {
  font-family: "jua";
  font-size: medium;
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
.writebutton {
  /* margin-left: auto; */
  display: flex;
  justify-content: end;
}
.page-item.active .page-link {
  background-color: rgb(86, 32, 100);
}
/* .page-link {
  color: #000;
  background-color: #fff;
  border: 1px solid #ccc;
}

.page-item.active .page-link {
  z-index: 1;
  color: #555;
  font-weight: bold;
  background-color: #f1f1f1;
  border-color: #ccc;
}

.page-link:focus,
.page-link:hover {
  color: #000;
  background-color: #fafafa;
  border-color: #ccc;
} */

/* display: flex; */
/* justify-content: space-between; */

/*
.button-container {
  margin-left: auto;
} */
</style>
