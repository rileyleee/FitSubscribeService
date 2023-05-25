<template>
  <div class="container" style="padding-top: 20px">
    <h1 style="text-align: center">나의 구독 내역</h1>

    <div v-if="subscriptions.length">
      <b-table-simple hover>
        <b-thead class="text-center">
          <b-tr>
            <b-th>번호</b-th>
            <b-th>구독 신청일</b-th>
            <b-th>구독기간</b-th>
            <b-th>구독 시작일</b-th>
            <b-th>구독 종료일</b-th>
          </b-tr>
        </b-thead>
        <b-tbody class="text-center">
          <FacSubsListRow
            v-for="(subscription, index) in subscriptions"
            :key="index"
            :no="`${index + 1}`"
            :regdate="subscription.regdate.toString().split(' ')[0]"
            :months="subscription.months"
            :startdate="subscription.startdate.map(String).join('.')"
            :enddate="subscription.enddate.map(String).join('.')"
          >
          </FacSubsListRow>
        </b-tbody>
      </b-table-simple>
    </div>
  </div>
</template>

<script>
import FacSubsListRow from "./include/FacSubsListRow.vue";
import { mapGetters } from "vuex";

export default {
  name: "MyFacSubscribe",
  data() {
    return {
      user_id: this.$store.state.loginUser.id,
    };
  },

  components: {
    FacSubsListRow,
  },
  computed: {
    ...mapGetters(["subscriptions"]),
  },

  created() {
    this.$store.dispatch("getSubscriptions", this.user_id);
  },
};
</script>

<style scoped>
.container{
  height: 1200px;
}
th {
  font-size: 0.6em;
  vertical-align: middle;
}
</style>
