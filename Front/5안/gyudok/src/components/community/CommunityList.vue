<template>
  <div>
    <h1>커뮤니티 목록</h1>
    <button @click="boardCreate">글쓰기</button>
    <div v-if="boards.length">
      <table>
        <colgroup>
          <col />
          <col />
          <col />
          <col />
          <col />
          <col />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>카테고리</th>
            <th>타이틀</th>
            <th>내용</th>
            <th>조회수</th>
            <th>작성날짜</th>
          </tr>
        </thead>
        <!-- :no="`${index + 1}`" -->
        <tbody>
          <ListRow
            v-for="(board, index) in boards"
            :key="index"
            :no="board.id"
            :category="board.category"
            :title="board.title"
            :content="board.content"
            :viewcnt="board.viewcnt"
            :regdate="board.regdate"
          >
          </ListRow>
        </tbody>
      </table>
    </div>
    <!-- <div v-for="board in pageBoardList" :key = "board.id"> -->
  </div>
</template>

<script>
import ListRow from "../board/include/BoardListRow.vue";
import { mapState } from "vuex";

export default {
  name: "Community-List",
  methods: {
    boardCreate() {
      this.$router.push({ name: "boardCreate" });
    },
  },
  components: {
    ListRow,
  },
  computed: {
    ...mapState(["boards"]),
  },
  created() {
    this.$store.dispatch("getBoards");
  },
};
</script>

<style></style>
